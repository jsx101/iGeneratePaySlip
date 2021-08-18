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
@DisplayName("Net income calculator")
class NetIncomeCalculatorTest {

    @Autowired
    NetIncomeCalculatorService netIncomeCalculator;

    @Test
    @DisplayName("Tests at least one annual salary value for each income tax bracket")
    void returnNetIncome() {
        // $0 - $18200
        Integer netIncome0 = netIncomeCalculator.calculate(12006);
        assertEquals(1001, netIncome0);

        // $18201 - $37000
        Integer netIncome1 = netIncomeCalculator.calculate(22100);
        Integer netIncome2 = netIncomeCalculator.calculate(37000);
        assertEquals(1780, netIncome1);
        assertEquals(2785, netIncome2);

        // $37001 - $87000
        Integer netIncome3 = netIncomeCalculator.calculate(37001);
        Integer netIncome4 = netIncomeCalculator.calculate(60000);
        Integer netIncome5 = netIncomeCalculator.calculate(87000);
        assertEquals(2785, netIncome3);
        assertEquals(4079, netIncome4);
        assertEquals(5598, netIncome5);

        // $87001 - 180000
        Integer netIncome6 = netIncomeCalculator.calculate(87001);
        Integer netIncome7 = netIncomeCalculator.calculate(180000);
        assertEquals(5598, netIncome6);
        assertEquals(10481, netIncome7);

        // >=$180001
        Integer netIncome8 = netIncomeCalculator.calculate(399999);
        assertEquals(20564, netIncome8);
    }
}