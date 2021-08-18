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
@DisplayName("Payment period identifier")
class PaymentPeriodIdentifierTest {

    @Autowired
    PaymentPeriodIdentifierService paymentPeriodIdentifier;

    @Test
    @DisplayName("Test all 12 months. Expected outputs are the first date of every month")
    void returnPaymentStartDate() {
        String startDate0 = paymentPeriodIdentifier.getPaymentStartDate(0);
        assertEquals("01 January", startDate0);

        String startDate1 = paymentPeriodIdentifier.getPaymentStartDate(1);
        assertEquals("01 February", startDate1);

        String startDate2 = paymentPeriodIdentifier.getPaymentStartDate(2);
        assertEquals("01 March", startDate2);

        String startDate3 = paymentPeriodIdentifier.getPaymentStartDate(3);
        assertEquals("01 April", startDate3);

        String startDate4 = paymentPeriodIdentifier.getPaymentStartDate(4);
        assertEquals("01 May", startDate4);

        String startDate5 = paymentPeriodIdentifier.getPaymentStartDate(5);
        assertEquals("01 June", startDate5);

        String startDate6 = paymentPeriodIdentifier.getPaymentStartDate(6);
        assertEquals("01 July", startDate6);

        String startDate7 = paymentPeriodIdentifier.getPaymentStartDate(7);
        assertEquals("01 August", startDate7);

        String startDate8 = paymentPeriodIdentifier.getPaymentStartDate(8);
        assertEquals("01 September", startDate8);

        String startDate9 = paymentPeriodIdentifier.getPaymentStartDate(9);
        assertEquals("01 October", startDate9);

        String startDate10 = paymentPeriodIdentifier.getPaymentStartDate(10);
        assertEquals("01 November", startDate10);

        String startDate11 = paymentPeriodIdentifier.getPaymentStartDate(11);
        assertEquals("01 December", startDate11);
    }

    @Test
    @DisplayName("Test all 12 months. Expected outputs are the last date of every month")
    void returnPaymentEndDate() {
        String startDate0 = paymentPeriodIdentifier.getPaymentEndDate(0);
        assertEquals("31 January", startDate0);

        String startDate1 = paymentPeriodIdentifier.getPaymentEndDate(1);
        assertEquals("28 February", startDate1);

        String startDate2 = paymentPeriodIdentifier.getPaymentEndDate(2);
        assertEquals("31 March", startDate2);

        String startDate3 = paymentPeriodIdentifier.getPaymentEndDate(3);
        assertEquals("30 April", startDate3);

        String startDate4 = paymentPeriodIdentifier.getPaymentEndDate(4);
        assertEquals("31 May", startDate4);

        String startDate5 = paymentPeriodIdentifier.getPaymentEndDate(5);
        assertEquals("30 June", startDate5);

        String startDate6 = paymentPeriodIdentifier.getPaymentEndDate(6);
        assertEquals("31 July", startDate6);

        String startDate7 = paymentPeriodIdentifier.getPaymentEndDate(7);
        assertEquals("31 August", startDate7);

        String startDate8 = paymentPeriodIdentifier.getPaymentEndDate(8);
        assertEquals("30 September", startDate8);

        String startDate9 = paymentPeriodIdentifier.getPaymentEndDate(9);
        assertEquals("31 October", startDate9);

        String startDate10 = paymentPeriodIdentifier.getPaymentEndDate(10);
        assertEquals("30 November", startDate10);

        String startDate11 = paymentPeriodIdentifier.getPaymentEndDate(11);
        assertEquals("31 December", startDate11);
    }
}