import { Container, Form, FormGroup, Input, Label } from 'reactstrap';

function EmployeeDetailForm() {
    return <Container>
        <h2>Employee Details</h2>
        <Form onSubmit='/api/generate/pay-slip'>
            <FormGroup>
                <Label for='firstname'>First name</Label>
                <Input type='text' name='firstname' id='firstname' required='required' />
            </FormGroup>
            <FormGroup>
                <Label for='lastname'>Last name</Label>
                <Input type='text' name='lastname' id='lastname' required='required' />
            </FormGroup>
            <FormGroup>
                <Label for='annualSalary' min='0'>Annual Salary ($)</Label>
                <Input type='number' name='annualSalary' id='annualSalary' required='required' />
            </FormGroup>
            <FormGroup>
                <Label for='paymentMonth'>Payment month</Label>
                <select name='paymentMonth' id='paymentMonth' required='required'>
                    <option value='0'>January</option>
                    <option value='1'>February</option>
                    <option value='2'>March</option>
                    <option value='3'>April</option>
                    <option value='4'>May</option>
                    <option value='5'>June</option>
                    <option value='6'>July</option>
                    <option value='7'>August</option>
                    <option value='8'>September</option>
                    <option value='9'>October</option>
                    <option value='10'>November</option>
                    <option value='11'>December</option>
                </select>
            </FormGroup>
            <FormGroup>
                <Label for='superRate'>Superannuation rate (%)</Label>
                <Input type='' name='superRate' id='superRate' min='0' step='0.1' required='required' />
            </FormGroup>
            <FormGroup>
                <Input type='submit' value='Generate' />
                <Input type='reset' value='Clear' />
            </FormGroup>
        </Form>
    </Container>
}

export default EmployeeDetailForm;