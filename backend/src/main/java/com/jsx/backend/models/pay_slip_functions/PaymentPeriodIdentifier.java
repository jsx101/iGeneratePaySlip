package com.jsx.backend.models.pay_slip_functions;

import org.springframework.stereotype.Component;

@Component
public class PaymentPeriodIdentifier {
    public String getPaymentStartDate() {
        return "01 ";
    }

    public String getPaymentEndDate() {
        return "31 ";
    }
}

