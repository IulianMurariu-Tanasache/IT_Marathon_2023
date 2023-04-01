import React, { useState } from 'react';
import Cookies from 'js-cookie';
import {useNavigate} from 'react-router-dom'



function Login() {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    var [id_operator,] = useState('');


    let Navigates = useNavigate()


    const handleSubmit = (e) => {
      e.preventDefault();
      fetch('http://localhost:8080/login', {///modificat link
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
          username: username,
          password: password
        })
      })
      
      .then(response => response.text())
    .then(responseText => {
    
      var responseLogin = JSON.parse(responseText)
      //de vazut cum primesc raspunsul
      //console.log(token["soap11env:Envelope"]["soap11env:Body"]["tns:loginResponse"]["tns:loginResult"])
    //   var loginResult = token["soap11env:Envelope"]["soap11env:Body"]["tns:loginResponse"]["tns:loginResult"]
    id_operator = responseLogin['id']
     console.log(responseLogin)
     console.log(id_operator)
      if (id_operator !== null) {
        Cookies.set('loginResult', id_operator);
        Navigates("/home")
      }
    })
    .catch(error => console.error(error));
  }
  
    return (
    <form onSubmit={handleSubmit}>
        <label>
        <div >Username:</div>
        <input  className='corner' type="text" value={username} onChange={e => setUsername(e.target.value)} />
        </label>
        <br/>
        <label>
        <div >Password:</div>
        <input className='corner' type="password" value={password} onChange={e => setPassword(e.target.value)} />
        </label>
        <br />
        <div className="form-wrapper2">
            <button className='corner' type="submit" disabled={!username || !password}>Log in</button>
        </div>
        
    </form>
      
    );
}
  
  export default Login;//este