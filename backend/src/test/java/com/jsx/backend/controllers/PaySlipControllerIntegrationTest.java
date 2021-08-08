package com.jsx.backend.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsx.backend.models.EmployeeDetail;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest
class PaySlipControllerIntegrationTest {
    @Autowired
    private MockMvc mvc;

    // Tests if PaySlipController will take a valid request and return payslip data in the correct form
    @Test
    void generatePaySlip() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .post("/api/generate/pay-slip")
                .content(asJsonString(new EmployeeDetail(
                        "David",
                        "Rudd",
                        12006,
                        0.09,
                        3
                )))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("{" +
                    "\"employee\":{" +
                        "\"firstname\":\"David\", " +
                        "\"lastname\":\"Rudd\", " +
                        "\"annualSalary\":12006, " +
                        "\"superRate\":0.09, " +
                        "\"paymentMonth\":3" +
                    "}, " +
                    "\"grossIncome\":1001, " +
                    "\"incomeTax\":0, " +
                    "\"netIncome\":1001, " +
                    "\"superannuation\":90, " +
                    "\"paymentStartDate\":\"01 April\", " +
                    "\"paymentEndDate\":\"30 April\"" +
                "}",
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