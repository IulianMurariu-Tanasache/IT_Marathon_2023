import React, { useState } from 'react';
import Cookies from 'js-cookie';
import {useNavigate} from 'react-router-dom'
import {useLocation} from 'react-router-dom'

function ResolveIssue() {
  const [responseData, setResponseData] = useState(null);
  const [dataInput, setDataInput] = useState("");

  let Navigates = useNavigate()
  let location = useLocation();

  console.log(location.state)

  const createRequestObject = () => {
    var id_operator = Cookies.get('loginResult')
    var req_obj = {
      "reportId": location.state.reportId,
      "operatorId": id_operator,
      "timestamp": "",
      "actions": dataInput
    }
    console.log(req_obj)
    //redirect
    return req_obj
  }
 
  const handleSubmit = (event) => {
    event.preventDefault();
    var token = Cookies.get('loginResult')

    fetch("http://localhost:8003/api/operators/reports/submit",{
        method: "POST",
        headers: {
        "Content-Type": "application/json", 
        "Authorization" : token ,
        },
        body: JSON.stringify(createRequestObject())
    })
    .then()
    .catch(error => {
        console.log(error);
    });

  }
  const handleLogout = () => {
    console.log(Cookies.remove('loginResult'));
    Cookies.remove('loginResult');
    Navigates('/')
  }
   
  return (
    <div>
      <div className='left_panel'>
        <h3 className='acti'>
           Actions insert by operator:
        </h3>
        <form onSubmit={handleSubmit}>
        <p><textarea className='actions' onChange={event => setDataInput(event.target.value)} />
        <input className = "corner2"type="submit" value="Trimite" /></p>
        </form>
        
      </div>
      <div className='right_panel'>
        <h3 className='raport'>
          Report
        </h3>
      </div >
      <div className='pad'>
      <button className='corner'  onClick={handleLogout}>Logout</button>
      </div>
      
    </div>
    
  );
}

export default ResolveIssue;