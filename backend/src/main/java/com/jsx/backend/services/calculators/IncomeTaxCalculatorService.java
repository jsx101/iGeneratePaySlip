package com.jsx.backend.services.calculators;

import com.jsx.backend.models.IncomeTaxBracket;
import com.jsx.backend.services.calculators.incometaxbracket.IncomeTaxBracketService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
//@ComponentScan
public class IncomeTaxCalculatorService {
    @Autowired
    private IncomeTaxBracketService incomeTaxBracketService;

    public Integer calculate(Integer annualSalary) {
        return calculateGivenTheIncomeTaxBracket(annualSalary, salaryBelongsInThisTaxBracket(annualSalary));
    }

    private Integer calculateGivenTheIncomeTaxBracket(Integer annualSalary, IncomeTaxBracket taxBracket) {

        // A function to calculate the income tax amount based on the annual salary and which tax bracket it belongs in
        Double amountOver = annualSalary - taxBracket.getWhenOverThisMuch();
        return (int) Math.round((taxBracket.getBaseTax() + amountOver*taxBracket.getTaxPerDollar())/12);
    }

    private IncomeTaxBracket salaryBelongsInThisTaxBracket(Integer annualSalary) {
        // Determines which tax bracket a given salary belongs in

        // Temporary solution by having the app make an API call to itself
        // It works, but will only pass unit testing when the app is running in the background
        // Does not pass when I run "mvn clean install" on the command line
        /*final String uri = "http://localhost:8080/api/income-tax-bracket/get-one/" + annualSalary.toString();

        RestTemplate restTemplate = new RestTemplate();
        String bracket = restTemplate.getForObject(uri, String.class);
        return JsonStringToIncomeTaxBracket(bracket);*/


        // Preferred implementation by calling IncomeTaxBracketService instance
        return incomeTaxBracketService.getTaxBracketForSalary(annualSalary);


        // Tried using IncomeTaxBracketController instance since it works in the Controllers package
        // Doesn't work
        //return this.incomeTaxBracketController.fetchOne(annualSalary);


        // Tried calling IncomeTaxBracketRepository itself
        // Doesn't work
        /*Stream<IncomeTaxBracket> brackets = incomeTaxBracketRepository
                .findIncomeTaxBracketByIncomeLowerLimitLessThanEqual(annualSalary);
        return brackets.reduce((first, second) -> second).orElse(null);*/
    }

    private IncomeTaxBracket JsonStringToIncomeTaxBracket(String json) {
        // Converts JSON string to IncomeTaxBracket object

        //String id = extractValueFromJsonString(json, "\"id\":");
        Double incomeLowerLimit = Double.parseDouble(extractValueFromJsonString(json, "\"incomeLowerLimit\":"));

        String incomeUpperLimitStr = extractValueFromJsonString(json, "\"incomeUpperLimit\":");
        Double incomeUpperLimit;
        if(incomeUpperLimitStr.equals("\"Infinity\"")) {
            incomeUpperLimit = Double.POSITIVE_INFINITY;
        } else {
            incomeUpperLimit = Double.parseDouble(incomeUpperLimitStr);
        }

        Double baseTax = Double.parseDouble(extractValueFromJsonString(json, "\"baseTax\":"));
        Double taxPerDollar = Double.parseDouble(extractValueFromJsonString(json, "\"taxPerDollar\":"));
        Double whenOverThisMuch = Double.parseDouble(extractValueFromJsonString(json, "\"whenOverThisMuch\":"));

        return new IncomeTaxBracket(
                incomeLowerLimit,
                incomeUpperLimit,
                baseTax,
                taxPerDollar,
                whenOverThisMuch
        );

    }

    private String extractValueFromJsonString(String json, String key) {
        // Gets the key string (with double-quotes and colon) and returns its corresponding value in the JSON string
        int keyStart = json.indexOf(key);
        int keyLength = key.length();

        int valStart=keyStart+keyLength;
        int valEnd = json.indexOf(',', valStart);
        if(valEnd==-1) {
            valEnd=json.length()-2;
        }

        return json.substring(valStart, valEnd);
    }
}
