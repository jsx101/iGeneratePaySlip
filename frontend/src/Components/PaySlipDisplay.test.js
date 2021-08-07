import { fireEvent, render } from '@testing-library/react';
import PaySlipDisplay from './PaySlipDisplay';

describe("PaySlipData", () => {
    it("should return a JSX object that displays the data given to it as expected", () => {
        let mockData = { 
            employee: { 
                firstname: 'David', 
                lastname: 'Rudd', 
                superRate: 0.09 
            }, 
            grossIncome: 1001, 
            incomeTax: 0, 
            netIncome: 1001, 
            superannuation: 90, 
            paymentStartDate: '01 April', 
            paymentEndDate: '30 April' 
        };

        let dummyFunction = ()=>{};

        const { getByTestId } = render(<PaySlipDisplay data={mockData} backToFormFunction={dummyFunction} />);
        const paySlipDisplayElement = getByTestId('pay-slip-data');

        expect(paySlipDisplayElement).toHaveTextContent('Employee\'s name: David Rudd');
        expect(paySlipDisplayElement).toHaveTextContent('Pay period: 01 April — 30 April');
        expect(paySlipDisplayElement).toHaveTextContent('Net income: $1001');
        expect(paySlipDisplayElement).toHaveTextContent('Gross income: $1001');
        expect(paySlipDisplayElement).toHaveTextContent('Income tax: $0');
        expect(paySlipDisplayElement).toHaveTextContent('Superannuation: $90 (9%)');
    });


    it('should activate the back function when the Back button is clicked', ()=>{
        let mockBackButton = jest.fn();
        let dummyData = { 
            employee: { 
                firstname: 'Dummy', 
                lastname: 'Test', 
                superRate: 0.09 
            }, 
            grossIncome: 1001, 
            incomeTax: 0, 
            netIncome: 1001, 
            superannuation: 90, 
            paymentStartDate: '01 April', 
            paymentEndDate: '30 April' 
        };

        const { getByTestId } = render(<PaySlipDisplay data={dummyData} backToFormFunction={mockBackButton} />);
        fireEvent.click(getByTestId('paySlipDisplay-back-button'));
        expect(mockBackButton.mock.calls.length).toBe(1);
    })

});