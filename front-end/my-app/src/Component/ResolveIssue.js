import React, { useState } from 'react';
import Cookies from 'js-cookie';
import {useNavigate} from 'react-router-dom'
import {useLocation} from 'react-router-dom'
import ReportDetails from './ReportDetails';

function pad(number, length) {
  var str = '' + number;
  while (str.length < length) {
      str = '0' + str;
  }
  return str;
}

Date.prototype.formattedTimestamp = function () {
  var yyyy = this.getFullYear().toString();
  var MM = pad(this.getMonth() + 1,2);
  var dd = pad(this.getDate(), 2);
  var hh = pad(this.getHours(), 2);
  var mm = pad(this.getMinutes(), 2)
  var ss = pad(this.getSeconds(), 2)

  return dd + "-" + MM + '-' + yyyy + 'T' + hh + ':' + mm + ":" + ss;
};

function ResolveIssue() {
  const [responseData, setResponseData] = useState(null);
  const [dataInput, setDataInput] = useState("");

  let Navigates = useNavigate()
  let location = useLocation();

  console.log(location.state)

  const createRequestObject = () => {
    var id_operator = Cookies.get('loginResult')
    var req_obj = {
      "reportId": location.state._id,
      "operatorId": id_operator,
      "timestamp": (new Date).formattedTimestamp(),
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
    Navigates('/home')

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
        <input className = "corner2" type="submit" value="Submit" /></p>
        </form>
        
      </div>
      <div className='right_panel'>
        <h3 className='raport'>
        <div className='final'>
            <ReportDetails  report={location.state} />
        </div>
        </h3>
      </div >
      <div className='pad'>
      <button  className='corner'  onClick={handleLogout}>Logout</button>
      </div>
      
    </div>
    
  );
}

export default ResolveIssue;