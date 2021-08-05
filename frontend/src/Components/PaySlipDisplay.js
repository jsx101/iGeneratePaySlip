function PaySlipData({ data, backToFormFunction }) {
    const { employee, grossIncome, incomeTax, netIncome, superannuation, paymentStartDate, paymentEndDate } = data;
    const { firstname, lastname, superRate } = employee;
    return <div>
        <div>
            Employee's name: {firstname + ' ' + lastname}
        </div>
        <div>
            Pay period: {paymentStartDate + ' — ' + paymentEndDate}
        </div>
        <div>
            Net income: ${netIncome}
        </div>
        <div>
            Gross income: ${grossIncome}
        </div>
        <div>
            Income tax: ${incomeTax}
        </div>
        <div>
            Superannuation: ${superannuation + `(${superRate*100}%)`}
        </div>

        <button onClick={()=>{backToFormFunction()}}>Back</button>
    </div>
}

export default PaySlipData;