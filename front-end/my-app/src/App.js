import logo from './logo.svg';
import './App.css';
// import SongList from './component/SongList';
// import UserList from './component/UserList';
import LoginForm from './Component/Login';
import Home from './Component/Home';
import { BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import ResolveIssue from './Component/ResolveIssue';

function App() {
  
  return (

    <div className="form-wrapper">
      <h1 className='Comm' >Community</h1>
      <h2 className='Clean'> Clean</h2>
      <Router>
      <Routes>
        <Route path='/' element={<LoginForm/>} />
        <Route path='/home' element={<Home/>} /> 
        <Route path='/issue' element={<ResolveIssue/>} /> 
      </Routes>
    </Router>
    </div>
    
  );
}

export default App;