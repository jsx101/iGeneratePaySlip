import { Container, Form, FormGroup, Input, Label } from 'reactstrap';
import { useState } from 'react';

const axios = require('axios');

function EmployeeDetailForm({sendDataToParent}) {
    const [ formData, setFormData ] = useState({
        firstname: '',
        lastname: '',
        annualSalary: '',
        paymentMonth: '',
        superRate: ''
    })
    var handleChange = (e) => {
        const newData = {...formData};
        newData[e.target.id] = e.target.value;
        setFormData(newData);
        console.log(newData);
    
    }

    var handleSubmit = (e) => {
        e.preventDefault();
        formData.superRate = formData.superRate/100;
        axios.post('/api/generate/pay-slip', formData)
            .then(res => {
                setFormData({
                    firstname: '',
                    lastname: '',
                    annualSalary: '',
                    paymentMonth: '',
                    superRate: ''
                })
                sendDataToParent(res.data);
            });
    }

    return <Container>
        <h2>Fill in employee details</h2>
        <Form onSubmit={(e) => handleSubmit(e)}>
            <FormGroup>
                <Label for='firstname'>First name</Label>
                <Input type='text' name='firstname' id='firstname' onChange={(e) => handleChange(e)} value={formData.firstname} required='required' />
            </FormGroup>
            <FormGroup>
                <Label for='lastname'>Last name</Label>
                <Input type='text' name='lastname' id='lastname' onChange={(e) => handleChange(e)} value={formData.lastname} required='required' />
            </FormGroup>
            <FormGroup>
                <Label for='annualSalary' min='0'>Annual Salary ($)</Label>
                <Input type='number' name='annualSalary' id='annualSalary' onChange={(e) => handleChange(e)} value={formData.annualSalary} required='required' />
            </FormGroup>
            <FormGroup>
                <Label for='paymentMonth'>Payment month</Label>
                <select name='paymentMonth' id='paymentMonth' onChange={(e) => handleChange(e)} value={formData.paymentMonth} required='required'>
                    <option value=''>SELECT</option>
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
                <Input type='' name='superRate' id='superRate' min='0' step='0.1' onChange={(e) => handleChange(e)} value={formData.superRate} required='required' />
            </FormGroup>
            <Input type='submit' value='Generate' />
            <Input type='reset' value='Clear' />
        </Form>
    </Container>
}

export default EmployeeDetailForm;