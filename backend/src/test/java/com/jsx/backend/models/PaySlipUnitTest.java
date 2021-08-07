package com.jsx.backend.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaySlipUnitTest {

    private final PaySlip paySlip = new PaySlip(new EmployeeDetail(
            "Imposter",
            "Employee",
            0,
            0.0,
            "0"
    ));

    @Test
    void returnGrossIncomeAmount() {
        // $0 - $18200
        // This is to test if it rounds up when the decimal value is .5
        Integer grossIncome0 = paySlip.returnGrossIncomeAmount(12006);
        assertEquals(1001, grossIncome0);

        // $18201 - $37000
        Integer grossIncome1 = paySlip.returnGrossIncomeAmount(22100);
        assertEquals(1842, grossIncome1);

        // $37001 - $87000
        Integer grossIncome2 = paySlip.returnGrossIncomeAmount(37001);
        assertEquals(3083, grossIncome2);

        // $87001 - 180000
        Integer grossIncome3 = paySlip.returnGrossIncomeAmount(87001);
        assertEquals(7250, grossIncome3);

        // >=$180001
        Integer grossIncome4 = paySlip.returnGrossIncomeAmount(399999);
        assertEquals(33333, grossIncome4);
    }

    @Test
    void returnIncomeTaxAmount() {
        // $0 - $18200
        Integer grossIncome0 = paySlip.returnIncomeTaxAmount(12006);
        assertEquals(0, grossIncome0);

        // $18201 - $37000
        Integer grossIncome2 = paySlip.returnIncomeTaxAmount(22100);
        Integer grossIncome3 = paySlip.returnIncomeTaxAmount(37000);
        assertEquals(62, grossIncome2);
        assertEquals(298, grossIncome3);

        // $37001 - $87000
        Integer grossIncome4 = paySlip.returnIncomeTaxAmount(37001);
        Integer grossIncome5 = paySlip.returnIncomeTaxAmount(60000);
        Integer grossIncome6 = paySlip.returnIncomeTaxAmount(87000);
        assertEquals(298, grossIncome4);
        assertEquals(921, grossIncome5);
        assertEquals(1652, grossIncome6);

        // $87001 - 180000
        Integer grossIncome7 = paySlip.returnIncomeTaxAmount(87001);
        Integer grossIncome8 = paySlip.returnIncomeTaxAmount(180000);
        assertEquals(1652, grossIncome7);
        assertEquals(4519, grossIncome8);

        // >=$180001
        Integer grossIncome9 = paySlip.returnIncomeTaxAmount(399999);
        assertEquals(12769, grossIncome9);
    }

    @Test
    void returnNetIncome() {
        // $0 - $18200
        Integer grossIncome0 = paySlip.returnNetIncome(12006);
        assertEquals(1001, grossIncome0);

        // $18201 - $37000
        Integer grossIncome2 = paySlip.returnNetIncome(22100);
        Integer grossIncome3 = paySlip.returnNetIncome(37000);
        assertEquals(1780, grossIncome2);
        assertEquals(2785, grossIncome3);

        // $37001 - $87000
        Integer grossIncome4 = paySlip.returnNetIncome(37001);
        Integer grossIncome5 = paySlip.returnNetIncome(60000);
        Integer grossIncome6 = paySlip.returnNetIncome(87000);
        assertEquals(2785, grossIncome4);
        assertEquals(4079, grossIncome5);
        assertEquals(5598, grossIncome6);

        // $87001 - 180000
        Integer grossIncome7 = paySlip.returnNetIncome(87001);
        Integer grossIncome8 = paySlip.returnNetIncome(180000);
        assertEquals(5598, grossIncome7);
        assertEquals(10481, grossIncome8);

        // >=$180001
        Integer grossIncome9 = paySlip.returnNetIncome(399999);
        assertEquals(20564, grossIncome9);
    }

    @Test
    void returnSuperannuation() {
        Integer superannuation0 = paySlip.returnSuperannuation(12006,0.1);
        assertEquals(100,superannuation0);

        Integer superannuation1 = paySlip.returnSuperannuation(22100,0.5);
        assertEquals(921,superannuation1);

        Integer superannuation2 = paySlip.returnSuperannuation(37001,0.19);
        assertEquals(586,superannuation2);

        Integer superannuation3 = paySlip.returnSuperannuation(60005,0.25);
        assertEquals(1250,superannuation3);

        Integer superannuation4 = paySlip.returnSuperannuation(87002,0.005);
        assertEquals(36,superannuation4);

        Integer superannuation5 = paySlip.returnSuperannuation(99998,0.03);
        assertEquals(250,superannuation5);

        Integer superannuation6 = paySlip.returnSuperannuation(399999,0.43);
        assertEquals(14333,superannuation6);
    }

    @Test
    void returnPaymentStartDate() {
        String startDate0 = paySlip.returnPaymentStartDate(0);
        assertEquals("01 January", startDate0);

        String startDate1 = paySlip.returnPaymentStartDate(1);
        assertEquals("01 February", startDate1);

        String startDate2 = paySlip.returnPaymentStartDate(2);
        assertEquals("01 March", startDate2);

        String startDate3 = paySlip.returnPaymentStartDate(3);
        assertEquals("01 April", startDate3);

        String startDate4 = paySlip.returnPaymentStartDate(4);
        assertEquals("01 May", startDate4);

        String startDate5 = paySlip.returnPaymentStartDate(5);
        assertEquals("01 June", startDate5);

        String startDate6 = paySlip.returnPaymentStartDate(6);
        assertEquals("01 July", startDate6);

        String startDate7 = paySlip.returnPaymentStartDate(7);
        assertEquals("01 August", startDate7);

        String startDate8 = paySlip.returnPaymentStartDate(8);
        assertEquals("01 September", startDate8);

        String startDate9 = paySlip.returnPaymentStartDate(9);
        assertEquals("01 October", startDate9);

        String startDate10 = paySlip.returnPaymentStartDate(10);
        assertEquals("01 November", startDate10);

        String startDate11 = paySlip.returnPaymentStartDate(11);
        assertEquals("01 December", startDate11);
    }

    @Test
    void returnPaymentEndDate() {
        String startDate0 = paySlip.returnPaymentEndDate(0);
        assertEquals("31 January", startDate0);

        String startDate1 = paySlip.returnPaymentEndDate(1);
        assertEquals("28 February", startDate1);

        String startDate2 = paySlip.returnPaymentEndDate(2);
        assertEquals("31 March", startDate2);

        String startDate3 = paySlip.returnPaymentEndDate(3);
        assertEquals("30 April", startDate3);

        String startDate4 = paySlip.returnPaymentEndDate(4);
        assertEquals("31 May", startDate4);

        String startDate5 = paySlip.returnPaymentEndDate(5);
        assertEquals("30 June", startDate5);

        String startDate6 = paySlip.returnPaymentEndDate(6);
        assertEquals("31 July", startDate6);

        String startDate7 = paySlip.returnPaymentEndDate(7);
        assertEquals("31 August", startDate7);

        String startDate8 = paySlip.returnPaymentEndDate(8);
        assertEquals("30 September", startDate8);

        String startDate9 = paySlip.returnPaymentEndDate(9);
        assertEquals("31 October", startDate9);

        String startDate10 = paySlip.returnPaymentEndDate(10);
        assertEquals("30 November", startDate10);

        String startDate11 = paySlip.returnPaymentEndDate(11);
        assertEquals("31 December", startDate11);
    }
}