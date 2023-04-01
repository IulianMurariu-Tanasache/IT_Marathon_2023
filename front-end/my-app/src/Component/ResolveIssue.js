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
        method: "GET",
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
    <form onSubmit={handleSubmit}>

      <p><input type="text" name="data" id="data" onChange={event => setDataInput(event.target.value)} />
      <input type="submit" value="Trimite" /></p>
      
    </form>
    
    <p><button onClick={handleLogout}>Logout</button></p>
    
    </div>
  );
}

export default ResolveIssue;