package com.jsx.backend.controllers;

import com.jsx.backend.models.payslip.incometaxbracket.IncomeTaxBracket;
import com.jsx.backend.models.payslip.incometaxbracket.IncomeTaxBracketService;
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
        // Returns full list of tax brackets
        return incomeTaxBracketService.getAllBrackets();
    }

    @PostMapping(path="insert")
    public String insertIncomeTaxBracket(@RequestBody IncomeTaxBracket bracket) {
        // Inserts a new tax bracket
        // If no id string is provided, one will be generated for it
        return incomeTaxBracketService.insertBracket(bracket);
    }

    @PostMapping(path="save")
    public String saveIncomeTaxBracket(@RequestBody IncomeTaxBracket bracketWithId) {
        // Searches for document with the same id string
        // If no id string is provided, the tax bracket is inserted as a new document
        return incomeTaxBracketService.saveBracket(bracketWithId);
    }

    @PostMapping(path="delete")
    public String deleteIncomeTaxBracket(@RequestBody IncomeTaxBracket bracketWithId) {
        // Searches for document with exactly the same id and tax bracket data
        // If no id is provided, or if one data does not match, the document is not deleted
        return incomeTaxBracketService.deleteBracket(bracketWithId);
    }


    // To test if the IncomeTaxBracketService and Repository works when called in the Controllers package
    // It works
    @GetMapping("get-one/{annualSalary}")
    @ResponseBody
    public IncomeTaxBracket fetchOne(@PathVariable Integer annualSalary) {

        return incomeTaxBracketService.getTaxBracketForSalary(annualSalary);
    }
}
