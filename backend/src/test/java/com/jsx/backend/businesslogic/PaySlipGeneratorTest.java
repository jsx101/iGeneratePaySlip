package com.jsx.backend.businesslogic;

import com.jsx.backend.models.EmployeeDetail;
import com.jsx.backend.models.PaySlip;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest
class PaySlipGeneratorTest {
    @Autowired
    PaySlipGenerator paySlipGenerator;

    @Test
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