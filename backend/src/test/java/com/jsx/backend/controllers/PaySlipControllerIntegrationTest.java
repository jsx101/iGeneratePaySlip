package com.jsx.backend.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsx.backend.businesslogic.PaySlipGenerator;
import com.jsx.backend.models.EmployeeDetail;
import com.jsx.backend.models.PaySlip;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.FilenameFilter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = PaySlipController.class)
/*@RunWith(SpringRunner.class)
@SpringBootTest*/
class PaySlipControllerIntegrationTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private PaySlipGenerator paySlipGenerator;

    // Tests if PaySlipController will take a valid request and return payslip data in the correct form
    @Test
    void generatePaySlip() throws Exception {
        List<EmployeeDetail> employees = List.of(
                new EmployeeDetail(
                        "David",
                        "Rudd",
                        90500,
                        0.09,
                        1
                ),
                new EmployeeDetail(
                        "Ryan",
                        "Chen",
                        120000,
                        0.1,
                        5
                )
        );

        List<PaySlip> expectedOutput = List.of(
                new PaySlip(
                        employees.get(0),
                        7542,
                        1760,
                        5782,
                        679,
                        "01 February",
                        "28 February"
                ),
                new PaySlip(
                        employees.get(1),
                        10000,
                        2669,
                        7331,
                        1000,
                        "01 June",
                        "30 June"
                )
        );

        when(this.paySlipGenerator.returnPaySlips(employees)).thenReturn(expectedOutput);

        RequestBuilder request = MockMvcRequestBuilders
            .post("/api/pay-slip/generate")
            .content("[" +
                "{" +
                    "\"firstname\": \"David\"," +
                    "\"lastname\": \"Rudd\"," +
                    "\"annualSalary\": 90500," +
                    "\"superRate\": 0.09," +
                    "\"paymentMonth\": \"1\"" +
                "}," +
                "{" +
                    "\"firstname\": \"Ryan\"," +
                    "\"lastname\": \"Chen\"," +
                    "\"annualSalary\": 120000," +
                    "\"superRate\": 0.1," +
                    "\"paymentMonth\": \"5\"" +
                "}" +
            "]")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON);

        MvcResult result = this.mvc.perform(request).andReturn();
        assertEquals("[" +
            "{" +
                "\"employee\":{" +
                    "\"firstname\":\"David\", " +
                    "\"lastname\":\"Rudd\", " +
                    "\"annualSalary\":90500, " +
                    "\"superRate\":0.09, " +
                    "\"paymentMonth\":1" +
                "}, " +
                "\"grossIncome\":7542, " +
                "\"incomeTax\":1760, " +
                "\"netIncome\":5782, " +
                "\"superannuation\":679, " +
                "\"paymentStartDate\":\"01 February\", " +
                "\"paymentEndDate\":\"28 February\"" +
            "}, " +
            "{" +
                "\"employee\":{" +
                    "\"firstname\":\"Ryan\", " +
                    "\"lastname\":\"Chen\", " +
                    "\"annualSalary\":120000, " +
                    "\"superRate\":0.1, " +
                    "\"paymentMonth\":5" +
                "}, " +
                "\"grossIncome\":10000, " +
                "\"incomeTax\":2669, " +
                "\"netIncome\":7331, " +
                "\"superannuation\":1000, " +
                "\"paymentStartDate\":\"01 June\", " +
                "\"paymentEndDate\":\"30 June\"" +
            "}" +
        "]",
        result.getResponse().getContentAsString());
    }

    // Function to convert Object into JSON string
    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}