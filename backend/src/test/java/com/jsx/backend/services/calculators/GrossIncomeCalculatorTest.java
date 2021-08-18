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
@DisplayName("Gross income calculator")
class GrossIncomeCalculatorTest {
    @Autowired
    private GrossIncomeCalculatorService grossIncomeCalculator;

    @Test
    @DisplayName("Tests a range of annual salary values")
    void returnGrossIncomeAmount() {

        GrossIncomeCalculatorService grossIncomeCalculator = new GrossIncomeCalculatorService();

        // This is to test if it rounds up when the decimal value is .5
        Integer grossIncome0 = grossIncomeCalculator.calculate(12006);
        assertEquals(1001, grossIncome0);

        Integer grossIncome1 = grossIncomeCalculator.calculate(22100);
        assertEquals(1842, grossIncome1);

        Integer grossIncome2 = grossIncomeCalculator.calculate(37001);
        assertEquals(3083, grossIncome2);

        Integer grossIncome3 = grossIncomeCalculator.calculate(87001);
        assertEquals(7250, grossIncome3);

        Integer grossIncome4 = grossIncomeCalculator.calculate(399999);
        assertEquals(33333, grossIncome4);
    }
}