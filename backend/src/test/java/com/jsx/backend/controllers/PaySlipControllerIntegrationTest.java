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

import java.io.FilenameFilter;

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

        MvcResult result = mvc.perform(request).andReturn();
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