package com.jsx.backend.services.calculators;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@DisplayName("Superannuation calculator test")
class SuperannuationCalculatorTest {

    @Autowired
    SuperannuationCalculatorService superannuationCalculator;

    @Test
    @DisplayName("Testing a range of annual salaries and superannuation rates combinations")
    void returnSuperannuation() {
        Integer superannuation0 = superannuationCalculator.calculate(12006,0.1);
        assertEquals(100,superannuation0);

        Integer superannuation1 = superannuationCalculator.calculate(22100,0.5);
        assertEquals(921,superannuation1);

        Integer superannuation2 = superannuationCalculator.calculate(37001,0.19);
        assertEquals(586,superannuation2);

        Integer superannuation3 = superannuationCalculator.calculate(60005,0.25);
        assertEquals(1250,superannuation3);

        Integer superannuation4 = superannuationCalculator.calculate(87002,0.005);
        assertEquals(36,superannuation4);

        Integer superannuation5 = superannuationCalculator.calculate(99998,0.03);
        assertEquals(250,superannuation5);

        Integer superannuation6 = superannuationCalculator.calculate(399999,0.43);
        assertEquals(14333,superannuation6);
    }
}