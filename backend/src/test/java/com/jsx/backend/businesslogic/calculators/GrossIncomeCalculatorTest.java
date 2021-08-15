package com.jsx.backend.businesslogic.calculators;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.*;


class GrossIncomeCalculatorTest {
    @Autowired
    private GrossIncomeCalculator grossIncomeCalculator;

    @Test
    void returnGrossIncomeAmount() {

        GrossIncomeCalculator grossIncomeCalculator = new GrossIncomeCalculator();

        // $0 - $18200
        // This is to test if it rounds up when the decimal value is .5
        Integer grossIncome0 = grossIncomeCalculator.calculate(12006);
        assertEquals(1001, grossIncome0);

        // $18201 - $37000
        Integer grossIncome1 = grossIncomeCalculator.calculate(22100);
        assertEquals(1842, grossIncome1);

        // $37001 - $87000
        Integer grossIncome2 = grossIncomeCalculator.calculate(37001);
        assertEquals(3083, grossIncome2);

        // $87001 - 180000
        Integer grossIncome3 = grossIncomeCalculator.calculate(87001);
        assertEquals(7250, grossIncome3);

        // >=$180001
        Integer grossIncome4 = grossIncomeCalculator.calculate(399999);
        assertEquals(33333, grossIncome4);
    }
}