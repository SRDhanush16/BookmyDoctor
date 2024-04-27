import React from 'react'
import Header from '../Components/Header'
import Footer from '../Components/Footer'
import { NavLink, useNavigate  } from 'react-router-dom'
import axios from 'axios'
import { useState } from 'react';

import '../App.css'
import '../Appqueries.css'

export default function Userslogin() {

  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [msg, setMsg] = useState('');
  const navigate = useNavigate();

  const handleEmailChange = (e) => {
    setEmail(e.target.value);
  };

  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  let uname = '';
  let uemail = '';
  let uflag = false;
  let uid = 0;

  const handleSubmit = async (e) => {
    e.preventDefault();
    console.log('email:', email);
    console.log('Password:', password);

    try {
      const response = await axios.post('http://localhost:8080/Userslogin', {
        email: email,
        password: password,
      });

      if(response.data){
          uname = response.data.username;
          uemail= email;
          uflag = response.data.flag;
          uid = response.data.id;
          if(uflag){
            navigate(`/Userpage?uname=${uname}&uid=${uid}&uemail=${uemail}`);
          }else{
            setMsg('Wrong email or password');
          }
      }

    } catch (error) {
      console.log('Error logging in', error);
      setMsg('Maybe Server is Down');
    }

  }

  return (
    <>
      <Header/>
      
      <section className='container usrlg-container'  >
        <div className='usrlg-card' >
          <h2>Users Login</h2>
          {msg && <p>{msg}</p>}
          <form onSubmit={handleSubmit} >

            <label>
            <span>Email:</span>
              <input type="text" value={email} onChange={handleEmailChange} />
            </label>
            

            <label>
            <span>Password:</span>
              <input type="password" value={password} onChange={handlePasswordChange} />
            </label>
            

            <button type="submit">Login</button>

          </form>

          <NavLink to="/Createaccount" ><p>Don't have an account, Create One</p></NavLink>

        </div>
      </section>

      <Footer/>
    </>
  )
}
