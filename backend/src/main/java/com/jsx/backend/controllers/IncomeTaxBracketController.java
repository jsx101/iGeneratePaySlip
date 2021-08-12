package com.jsx.backend.controllers;

import com.jsx.backend.models.EmployeeDetail;
import com.jsx.backend.models.PaySlip;
import com.jsx.backend.models.payslip.incometaxbracket.IncomeTaxBracket;
import com.jsx.backend.models.payslip.incometaxbracket.IncomeTaxBracketService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@RequestMapping("api/income-tax-bracket")
@AllArgsConstructor
public class IncomeTaxBracketController {
    @Autowired
    private final IncomeTaxBracketService incomeTaxBracketService;

    @GetMapping("get-all")
    public List<IncomeTaxBracket> fetchAllIncomeTaxBrackets() {
        return incomeTaxBracketService.getAllBrackets();
    }

    @GetMapping("get-one/{annualSalary}")
    @ResponseBody
    public IncomeTaxBracket fetchOne(@PathVariable Integer annualSalary) {
        /*PaySlip paySlip = new PaySlip(new EmployeeDetail("david", "rudd", 60050, 0.09, 1));
        return paySlip.returnIncomeTaxAmount();*/

        return incomeTaxBracketService.getTaxBracketForSalary(annualSalary);
    }
}
