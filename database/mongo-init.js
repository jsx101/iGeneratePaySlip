db = db.getSiblingDB('incometaxbrackets');

db.createCollection('incomeTaxBracket');

db.incomeTaxBracket.insertMany([
    {
        "incomeLowerLimit": 0.0,
        "incomeUpperLimit": 18200.0,
        "baseTax": 0.0,
        "taxPerDollar": 0.0,
        "whenOverThisMuch": 0.0
    },
    {
        "incomeLowerLimit": 18201.0,
        "incomeUpperLimit": 37000.0,
        "baseTax": 0.0,
        "taxPerDollar": 0.19,
        "whenOverThisMuch": 18200.0
    },
    {
        "incomeLowerLimit": 37001.0,
        "incomeUpperLimit": 87000.0,
        "baseTax": 3572.0,
        "taxPerDollar": 0.325,
        "whenOverThisMuch": 37000.0
    },
    {
        "incomeLowerLimit": 87001.0,
        "incomeUpperLimit": 180000.0,
        "baseTax": 19822.0,
        "taxPerDollar": 0.37,
        "whenOverThisMuch": 87000.0
    },
    {
        "incomeLowerLimit": 180000.0,
        "incomeUpperLimit": "Infinity",
        "baseTax": 54232.0,
        "taxPerDollar": 0.45,
        "whenOverThisMuch": 180000.0
    } 
]);