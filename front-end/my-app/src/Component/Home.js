import React, { useEffect, useState } from 'react';
import Cookies from 'js-cookie';
import {useNavigate} from 'react-router-dom'



function Home() {

  var [data_json, setDate] = useState({
    "reportId" : "",
    "imageBase64": "",
    "category": "",
    "comments": ".",
    "contacts": {
        "email": "",
        "tel": "",
        "firstName": "",
        "lastName": ""
    },
    "geoTagging": "",
    "timestamp": ""
});

//datele de la server
    const new_jsonData = [
    {
        "reportId" : "id_string",
        "imageBase64": "Base64String==",
        "category": "lost",
        "comments": "None.",
        "contacts": {
            "email": "ion@mail.com",
            "tel": "07",
            "firstName": "Ion",
            "lastName": "Ionescu"
        },
        "geoTagging": "lat,long",
        "timestamp": "01-04-2023T00:00:00.000"
    },
    {
        "reportId" : "id",
        "imageBase64": "Base64String==",
        "category": "lost",
        "comments": "None.",
        "contacts": {
            "email": "ion@mail.com",
            "tel": "07",
            "firstName": "Ion",
            "lastName": "Ionescu"
        },
        "geoTagging": "lat,long",
        "timestamp": "01-04-2023T00:00:00.000"
    }
]

  let Navigates = useNavigate()

  useEffect(() => {
    console.log('useEff')
    console.log(data_json)
    
}, [data_json]);

  const handleSubmit = (event) =>{
    event.preventDefault();
  }
//   const handleSubmit = (event) => {
//     event.preventDefault();
//     var id_operator = Cookies.get('loginResult')

//     fetch("http://localhost:8080/",{
//         method: "GET",
//         headers: {
//         "Content-Type": "application/json", 
//         },
//         params:{
//             id_operator
//         }    
//     })
    
//     .then(response => response.text())
//     .then(data => {
//       setResponseData(data);
//       console.log(data)
//     })
//     .catch(error => {
//       console.log(error);
//     });
   

//   }
  const handleLogout = () => {
    console.log(Cookies.remove('loginResult'));
    Cookies.remove('loginResult');
    Navigates('/')
  }

  const handleData = () => {
    console.log("callUpdate")
    setDate(new_jsonData[0])//iarasi de i prin lista de date

    
  }
  return (
    <div>
        {new_jsonData.map((
            json
        ) => {
          return (
            <pre>{JSON.stringify(json, null, 2)}</pre>
          );
        })}
      
    <form onSubmit={handleSubmit}>

    <p><button onClick={handleData}>Send Req</button></p>

    </form>
    
    <p><button onClick={handleLogout}>Logout</button></p>
    
    </div>
  );
}

export default Home;