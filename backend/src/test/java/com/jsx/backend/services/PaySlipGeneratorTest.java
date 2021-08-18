package com.jsx.backend.services;

import com.jsx.backend.models.EmployeeDetail;
import com.jsx.backend.models.PaySlip;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@DisplayName("Pay slip generator test")
class PaySlipGeneratorTest {
    @Autowired
    PaySlipGeneratorService paySlipGenerator;

    @Test
    @DisplayName("Testing integration of units from the 'calculators' package to produce a pay slip")
    void returnPaySlip() {

        EmployeeDetail employee = new EmployeeDetail(
                "David",
                "Rudd",
                60000,
                0.09,
                1
        );

        PaySlip actualPaySlip = paySlipGenerator.returnPaySlip(employee);
        PaySlip expectedPaySlip = new PaySlip(
            new EmployeeDetail(
                    "David",
                    "Rudd",
                    60000,
                    0.09,
                    1
                ),
                5000,
                921,
                4079,
                450,
                "01 February",
                "28 February"
        );
        assertEquals(actualPaySlip, expectedPaySlip);
    }
}