import React, { useEffect, useState } from 'react';
import Cookies from 'js-cookie';
import {useNavigate} from 'react-router-dom'
import ReportsList from './ReportsList';


function Home() {

  var [data_json, setResponseData] = useState([]);

  let Navigates = useNavigate()

  useEffect(() => {
    console.log('useEff')
    console.log(data_json)
    
}, [data_json]);


  const handleSubmit = () => {
    var id_operator = Cookies.get('loginResult')

    fetch("http://localhost:8003/api/operators/reports/" + id_operator,{
        method: "GET",
        headers: {
        "Content-Type": "application/json", 
        }  
    })
    .then(response => response.text())
    .then(data => {
      setResponseData(JSON.parse(data));
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
      <ReportsList reports={data_json} />
      

      <button onClick={handleSubmit}>Send Req</button>

      
      <p><button onClick={handleLogout}>Logout</button></p>
      
    </div>
  );
}

export default Home;