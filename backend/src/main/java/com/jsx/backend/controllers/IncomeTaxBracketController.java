package com.jsx.backend.controllers;

import com.jsx.backend.models.payslip.incometaxbracket.IncomeTaxBracket;
import com.jsx.backend.models.payslip.incometaxbracket.IncomeTaxBracketService;
import com.jsx.backend.models.payslip.incometaxbracket.IncomeTaxBracketWithId;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping(path="insert")
    public String insertIncomeTaxBracket(@RequestBody IncomeTaxBracket bracket) {
        return incomeTaxBracketService.insertBracket(bracket);
    }

    @PostMapping(path="save")
    public String insertIncomeTaxBracket(@RequestBody IncomeTaxBracketWithId bracketWithId) {
        return incomeTaxBracketService.saveBracket(bracketWithId);
    }

    @PostMapping(path="delete")
    public String deleteIncomeTaxBracket(@RequestBody IncomeTaxBracketWithId bracketWithId) {
        return incomeTaxBracketService.deleteBracket(bracketWithId);
    }



    @GetMapping("get-one/{annualSalary}")
    @ResponseBody
    public IncomeTaxBracket fetchOne(@PathVariable Integer annualSalary) {

        return incomeTaxBracketService.getTaxBracketForSalary(annualSalary);
    }
}
