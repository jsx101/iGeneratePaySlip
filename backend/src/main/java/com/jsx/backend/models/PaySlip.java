package com.jsx.backend.models;

import com.jsx.backend.BackendApplication;
import com.jsx.backend.models.payslip.*;
import com.jsx.backend.models.payslip.incometaxbracket.IncomeTaxBracket;
import com.jsx.backend.models.payslip.incometaxbracket.IncomeTaxBracketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.stream.Stream;

@ComponentScan
public class PaySlip {
    // Employee and pay slip data
    private EmployeeDetail employee;
    private Integer grossIncome;
    private Integer incomeTax;
    private Integer netIncome;
    private Integer superannuation;
    private String paymentStartDate;
    private String paymentEndDate;

    // Calculator objects
    @Autowired
    private GrossIncomeCalculator grossIncomeCalculator;
    @Autowired
    private IncomeTaxCalculator incomeTaxCalculator;
    @Autowired
    private NetIncomeCalculator netIncomeCalculator;
    @Autowired
    private SuperannuationCalculator superannuationCalculator;
    @Autowired
    private PaymentPeriodIdentifier paymentPeriodIdentifier;
    /*@Autowired
    private IncomeTaxBracketRepository incomeTaxBracketRepository;*/


    public PaySlip(EmployeeDetail employee) {
        this.employee = employee;

        //System.out.println("In PaySlip");
        ApplicationContext appCon = new AnnotationConfigApplicationContext(BackendApplication.class);
        /*for(String beanName : appCon.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }*/

        this.grossIncomeCalculator = appCon.getBean(GrossIncomeCalculator.class);
        this.incomeTaxCalculator = appCon.getBean(IncomeTaxCalculator.class);
        this.netIncomeCalculator = appCon.getBean(NetIncomeCalculator.class);
        this.superannuationCalculator = appCon.getBean(SuperannuationCalculator.class);
        this.paymentPeriodIdentifier = appCon.getBean(PaymentPeriodIdentifier.class);

        /*System.out.println("Creating PaySlip and testing IncomeTaxBracketRepo");
        this.incomeTaxBracketRepository = appCon.getBean(IncomeTaxBracketRepository.class);
        Stream<IncomeTaxBracket> brackets = incomeTaxBracketRepository
                .findIncomeTaxBracketByIncomeLowerLimitLessThanEqual(50060);
         System.out.println(brackets.reduce((first, second) -> second).orElse(null));*/
    }

    public Integer returnGrossIncomeAmount() {
        this.grossIncome = grossIncomeCalculator.calculate(employee.getAnnualSalary());
        return this.grossIncome;
    }

    public Integer returnGrossIncomeAmount(Integer annualSalary) {
        this.grossIncome = grossIncomeCalculator.calculate(annualSalary);
        return this.grossIncome;
    }

    public Integer returnIncomeTaxAmount() {
        this.incomeTax = incomeTaxCalculator.calculate(employee.getAnnualSalary());
        return incomeTax;
    }

    public Integer returnIncomeTaxAmount(Integer annualSalary) {
        this.incomeTax = incomeTaxCalculator.calculate(annualSalary);
        return incomeTax;
    }

    public Integer returnNetIncome() {
        this.netIncome = netIncomeCalculator.calculate(employee.getAnnualSalary());
        return this.netIncome;
    }

    public Integer returnNetIncome(Integer annualSalary) {
        this.netIncome = netIncomeCalculator.calculate(annualSalary);
        return this.netIncome;
    }

    public Integer returnSuperannuation() {
        this.superannuation = superannuationCalculator.calculate(employee.getAnnualSalary(), employee.getSuperRate());
        return this.superannuation;
    }

    public Integer returnSuperannuation(Integer annualSalary, Double superRate) {
        this.superannuation = superannuationCalculator.calculate(annualSalary, superRate);
        return this.superannuation;
    }

    public String returnPaymentStartDate() {
        this.paymentStartDate = paymentPeriodIdentifier.getPaymentStartDate(employee.getPaymentMonth());
        return this.paymentStartDate;
    }

    public String returnPaymentStartDate(Integer paymentMonth) {
        this.paymentStartDate = paymentPeriodIdentifier.getPaymentStartDate(paymentMonth);
        return this.paymentStartDate;
    }

    public String returnPaymentEndDate() {
        this.paymentEndDate = paymentPeriodIdentifier.getPaymentEndDate(employee.getPaymentMonth());
        return this.paymentEndDate;
    }

    public String returnPaymentEndDate(Integer paymentMonth) {
        this.paymentEndDate = paymentPeriodIdentifier.getPaymentEndDate(paymentMonth);
        return this.paymentEndDate;
    }

    @Override
    public String toString() {
        return "{" +
                "\"employee\":" + employee +
                ", \"grossIncome\":" + grossIncome +
                ", \"incomeTax\":" + incomeTax +
                ", \"netIncome\":" + netIncome +
                ", \"superannuation\":" + superannuation +
                ", \"paymentStartDate\":\"" + paymentStartDate + '"' +
                ", \"paymentEndDate\":\"" + paymentEndDate + '"' +
                '}';
    }

    // Getters and setters

    public EmployeeDetail getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDetail employee) {
        this.employee = employee;
        this.returnGrossIncomeAmount();
        this.returnIncomeTaxAmount();
        this.returnNetIncome();
        this.returnSuperannuation();
        this.returnPaymentStartDate();
        this.returnPaymentEndDate();
    }

    public Integer getIncomeTax() {
        return incomeTax;
    }

    public Integer getNetIncome() {
        return netIncome;
    }

    public Integer getSuperannuation() {
        return superannuation;
    }

    public String getPaymentStartDate() {
        return paymentStartDate;
    }

    public String getPaymentEndDate() {
        return paymentEndDate;
    }
}


