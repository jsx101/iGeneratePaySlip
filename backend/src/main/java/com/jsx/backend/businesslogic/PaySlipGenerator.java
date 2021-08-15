package com.jsx.backend.businesslogic;

import com.jsx.backend.models.EmployeeDetail;
import com.jsx.backend.models.PaySlip;
import com.jsx.backend.businesslogic.payslip.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaySlipGenerator {
    @Autowired
    private GrossIncomeCalculator grossIncomeCalculator;
    @Autowired
    private IncomeTaxCalculator incomeTaxCalculator;
    @Autowired
    private NetIncomeCalculator netIncomeCalculator;
    @Autowired
    private PaymentPeriodIdentifier paymentPeriodIdentifier;
    @Autowired
    private SuperannuationCalculator superannuationCalculator;

    public PaySlip returnPaySlip(EmployeeDetail employee) {
        Integer grossIncome = grossIncomeCalculator.calculate(employee.getAnnualSalary());
        Integer incomeTax = incomeTaxCalculator.calculate(employee.getAnnualSalary());
        Integer netIncome = netIncomeCalculator.calculate(employee.getAnnualSalary());
        Integer superannuation = superannuationCalculator.calculate(employee.getAnnualSalary(),employee.getSuperRate());
        String startDate = paymentPeriodIdentifier.getPaymentStartDate(employee.getPaymentMonth());
        String endDate = paymentPeriodIdentifier.getPaymentEndDate(employee.getPaymentMonth());

        return new PaySlip(
            employee,
            grossIncome,
            incomeTax,
            netIncome,
            superannuation,
            startDate,
            endDate
        );
    }
}
