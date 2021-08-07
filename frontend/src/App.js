import { useState, useEffect } from 'react';

import './App.css';
import EmployeeDetailForm from './Components/EmployeeDetailForm';
import PaySlipDisplay from './Components/PaySlipDisplay';

function App() {

  const [ paySlipData, setPaySlipData ] = useState(null);
  const sendDataToParent = (data) => {
    setPaySlipData(data);
    console.log("Pay slip generated");
  }

  const resetPaySlipDataToNull = () => {
    setPaySlipData(null);
    console.log("Back to the form")
  }

  const [ display, setDisplay ] = useState(<EmployeeDetailForm sendDataToParent={sendDataToParent} />);
  useEffect(() => {
    setDisplay(paySlipData ? 
      <PaySlipDisplay data={paySlipData} backToFormFunction={resetPaySlipDataToNull} /> : 
      <EmployeeDetailForm sendDataToParent={sendDataToParent} />)
  }, [paySlipData]);

  return (
    <div data-testid='app' className="App">
      {display}
    </div>
  );
}

export default App;
