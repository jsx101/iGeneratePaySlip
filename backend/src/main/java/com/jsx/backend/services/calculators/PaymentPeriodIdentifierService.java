package com.jsx.backend.services.calculators;

import org.springframework.stereotype.Service;

@Service
public class PaymentPeriodIdentifierService {

    public PaymentPeriodIdentifierService() {
    }

    public String getPaymentStartDate(Integer paymentMonth) {
        String month;
        switch(paymentMonth) {
            case 0:
                month = "January";
                break;
            case 1:
                month = "February";
                break;
            case 2:
                month = "March";
                break;
            case 3:
                month = "April";
                break;
            case 4:
                month = "May";
                break;
            case 5:
                month = "June";
                break;
            case 6:
                month = "July";
                break;
            case 7:
                month = "August";
                break;
            case 8:
                month = "September";
                break;
            case 9:
                month = "October";
                break;
            case 10:
                month = "November";
                break;
            default:
                month = "December";
                break;
        }
        return String.format("01 %s", month);
    }

    public String getPaymentEndDate(Integer paymentMonth) {
        String month;
        String endDate;
        switch(paymentMonth) {
            case 0:
                month = "January";
                endDate="31";
                break;
            case 1:
                month = "February";
                endDate="28";
                break;
            case 2:
                month = "March";
                endDate="31";
                break;
            case 3:
                month = "April";
                endDate="30";
                break;
            case 4:
                month = "May";
                endDate="31";
                break;
            case 5:
                month = "June";
                endDate="30";
                break;
            case 6:
                month = "July";
                endDate="31";
                break;
            case 7:
                month = "August";
                endDate="31";
                break;
            case 8:
                month = "September";
                endDate="30";
                break;
            case 9:
                month = "October";
                endDate="31";
                break;
            case 10:
                month = "November";
                endDate="30";
                break;
            default:
                month = "December";
                endDate="31";
                break;
        }
        return String.format("%s %s", endDate, month);
    }
}

