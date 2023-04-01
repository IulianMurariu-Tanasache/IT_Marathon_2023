import logo from './logo.svg';
import './App.css';
// import SongList from './component/SongList';
// import UserList from './component/UserList';
import LoginForm from './Component/Login';
import Home from './Component/Home';
import { BrowserRouter as Router, Routes, Route} from 'react-router-dom';

function App() {
  
  return (

    <div className="form-wrapper">
      <p><img src={logo} className="App-logo" alt="logo" /></p>
      <Router>
      <Routes>
        <Route path='/' element={<LoginForm/>} />
        <Route path='/home' element={<Home/>} /> 
      </Routes>
    </Router>
    </div>
    
  );
}

export default App;