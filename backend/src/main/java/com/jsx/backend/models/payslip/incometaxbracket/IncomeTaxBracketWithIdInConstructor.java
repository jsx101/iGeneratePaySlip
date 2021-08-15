package com.jsx.backend.models.payslip.incometaxbracket;

public class IncomeTaxBracketWithIdInConstructor {
    private String id;
    private Double incomeLowerLimit;
    private Double incomeUpperLimit;
    private Double baseTax;
    private Double taxPerDollar;
    private Double whenOverThisMuch;

    public IncomeTaxBracketWithIdInConstructor(String id,
                                               Double incomeLowerLimit,
                                               Double incomeUpperLimit,
                                               Double baseTax,
                                               Double taxPerDollar,
                                               Double whenOverThisMuch) {
        this.id = id;
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

    public IncomeTaxBracket convertToIncomeTaxBracket() {

        return new IncomeTaxBracket(
                this.incomeLowerLimit,
                this.incomeUpperLimit,
                this.baseTax,
                this.taxPerDollar,
                this.whenOverThisMuch
        );
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "IncomeTaxBracketWithId{" +
                "id='" + id + '\'' +
                ", incomeLowerLimit=" + incomeLowerLimit +
                ", incomeUpperLimit=" + incomeUpperLimit +
                ", baseTax=" + baseTax +
                ", taxPerDollar=" + taxPerDollar +
                ", whenOverThisMuch=" + whenOverThisMuch +
                '}';
    }
}
