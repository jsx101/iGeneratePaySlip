package com.jsx.backend.models;

import com.jsx.backend.models.pay_slip_functions.GrossIncomeCalculator;
import com.jsx.backend.models.pay_slip_functions.IncomeTaxCalculator;
import com.jsx.backend.models.pay_slip_functions.NetIncomeCalculator;
import com.jsx.backend.models.pay_slip_functions.SuperannuationCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api")
public class PaySlip {
    private EmployeeDetail employee;
    private Integer grossIncome;
    private Integer incomeTax;
    private Integer netIncome;
    private Integer superannuation;
    private String fromDate;
    private String toDate;

    @Autowired
    private GrossIncomeCalculator grossIncomeCalculator;
    @Autowired
    private IncomeTaxCalculator incomeTaxCalculator;
    @Autowired
    private NetIncomeCalculator netIncomeCalculator;
    @Autowired
    private SuperannuationCalculator superannuationCalculator;

//    public PaySlip(EmployeeDetail employee) {
//        this.employee = employee;
//    }

    @GetMapping(path="gross-income")
    public Integer returnGrossIncomeAmount() {
        this.grossIncome = grossIncomeCalculator.calculate(60050);
        return this.grossIncome;
    }

    @GetMapping(path="income-tax")
    public Integer returnIncomeTaxAmount() {
        this.incomeTax = incomeTaxCalculator.calculate(120000);
        return incomeTax;
    }

    @GetMapping(path="net-income")
    public Integer returnNetIncome() {
        this.netIncome = netIncomeCalculator.calculate(60050);
        return this.netIncome;
    }

    @GetMapping(path="superannuation")
    public Integer returnSuperannuation() {
        this.superannuation = superannuationCalculator.calculate(60050, 0.09);
        return this.superannuation;
    }


}


