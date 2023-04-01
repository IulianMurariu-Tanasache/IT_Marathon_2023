import React, { useState } from 'react';
import Cookies from 'js-cookie';
import {useNavigate} from 'react-router-dom'

function ResolveIssue() {
  const [responseData, setResponseData] = useState(null);
  const [dataInput, setDataInput] = useState("");
  let Navigates = useNavigate()

 
  const handleSubmit = (event) => {
    event.preventDefault();
    var token = Cookies.get('loginResult')

    fetch("http://localhost:8002/artists",{
        method: "POST",
        headers: {
        "Content-Type": "application/json", 
        "Authorization" : token ,
        },
        
    })
    
    .then(response => response.text())
    .then(data => {
        setResponseData(data);
        console.log(data)
    })
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
        <form onSubmit={handleSubmit}>
        <p><textarea className='actions' onChange={event => setDataInput(event.target.value)} />
        <input type="submit" value="Trimite" /></p>
        </form>
        
      </div>
      <div className='right_panel'>
      <h3>
        Report
      </h3>
      </div >
      <p className='form-wrapper3'><button  onClick={handleLogout}>Logout</button></p>
    </div>
    
  );
}

export default ResolveIssue;