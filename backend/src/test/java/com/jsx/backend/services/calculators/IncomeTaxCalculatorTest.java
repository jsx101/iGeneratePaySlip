package com.jsx.backend.services.calculators;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest
@DisplayName("Income tax calculator")
class IncomeTaxCalculatorTest {
    @Autowired
    IncomeTaxCalculatorService incomeTaxCalculator;

    @Test
    @DisplayName("Tests at least one annual salary value for each income tax bracket")
    void returnIncomeTaxAmount() {

        // $0 - $18200
        Integer incomeTax0 = incomeTaxCalculator.calculate(12006);
        assertEquals(0, incomeTax0);

        // $18201 - $37000
        Integer incomeTax1 = incomeTaxCalculator.calculate(22100);
        Integer incomeTax2 = incomeTaxCalculator.calculate(37000);
        assertEquals(62, incomeTax1);
        assertEquals(298, incomeTax2);

        // $37001 - $87000
        Integer incomeTax3 = incomeTaxCalculator.calculate(37001);
        Integer incomeTax4 = incomeTaxCalculator.calculate(60000);
        Integer incomeTax5 = incomeTaxCalculator.calculate(87000);
        assertEquals(298, incomeTax3);
        assertEquals(921, incomeTax4);
        assertEquals(1652, incomeTax5);

        // $87001 - 180000
        Integer incomeTax6 = incomeTaxCalculator.calculate(87001);
        Integer incomeTax7 = incomeTaxCalculator.calculate(180000);
        assertEquals(1652, incomeTax6);
        assertEquals(4519, incomeTax7);

        // >=$180001
        Integer incomeTax8 = incomeTaxCalculator.calculate(399999);
        assertEquals(12769, incomeTax8);
    }
}