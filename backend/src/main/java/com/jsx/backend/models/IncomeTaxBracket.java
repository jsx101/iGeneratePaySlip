package com.jsx.backend.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class IncomeTaxBracket {
    @Id
    private String id;
    private Double incomeLowerLimit;
    private Double incomeUpperLimit;
    private Double baseTax;
    private Double taxPerDollar;
    private Double whenOverThisMuch;

    public IncomeTaxBracket(Double incomeLowerLimit,
                            Double incomeUpperLimit,
                            Double baseTax,
                            Double taxPerDollar,
                            Double whenOverThisMuch) {
        this.incomeLowerLimit = incomeLowerLimit;
        this.incomeUpperLimit = incomeUpperLimit;
        this.baseTax = baseTax;
        this.taxPerDollar = taxPerDollar;
        this.whenOverThisMuch = whenOverThisMuch;
    }

    public Boolean isSimilarTo(IncomeTaxBracket bracketWithoutId) {
        boolean lowerLimitEquals = this.incomeLowerLimit.equals(bracketWithoutId.getIncomeLowerLimit());
        boolean upperLimitEquals = this.incomeUpperLimit.equals(bracketWithoutId.getIncomeUpperLimit());
        boolean baseTaxEquals = this.baseTax.equals(bracketWithoutId.getBaseTax());
        boolean taxPerDollarEquals = this.taxPerDollar.equals(bracketWithoutId.getTaxPerDollar());
        boolean whenOverThisMuchEquals = this.whenOverThisMuch.equals(bracketWithoutId.getWhenOverThisMuch());

        return lowerLimitEquals && upperLimitEquals && baseTaxEquals && taxPerDollarEquals && whenOverThisMuchEquals;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getIncomeLowerLimit() {
        return incomeLowerLimit;
    }

    public void setIncomeLowerLimit(Double incomeLowerLimit) {
        this.incomeLowerLimit = incomeLowerLimit;
    }

    public Double getIncomeUpperLimit() {
        return incomeUpperLimit;
    }

    public void setIncomeUpperLimit(Double incomeUpperLimit) {
        this.incomeUpperLimit = incomeUpperLimit;
    }

    public Double getBaseTax() {
        return baseTax;
    }

    public void setBaseTax(Double baseTax) {
        this.baseTax = baseTax;
    }

    public Double getTaxPerDollar() {
        return taxPerDollar;
    }

    public void setTaxPerDollar(Double taxPerDollar) {
        this.taxPerDollar = taxPerDollar;
    }

    public Double getWhenOverThisMuch() {
        return whenOverThisMuch;
    }

    public void setWhenOverThisMuch(Double whenOverThisMuch) {
        this.whenOverThisMuch = whenOverThisMuch;
    }
}
