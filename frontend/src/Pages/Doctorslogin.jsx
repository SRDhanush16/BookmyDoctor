import React from 'react'
import Header from '../Components/Header'
import Footer from '../Components/Footer'
import axios from 'axios'
import { useState } from 'react';
import {  useNavigate  } from 'react-router-dom'

import '../App.css'
import '../Appqueries.css'

export default function Doctorslogin() {

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

  let dname = '';
  let demail = '';
  let dflag = false;
  let did = 0;

  const handleSubmit = async (e) => {
    e.preventDefault();
    console.log('email:', email);
    console.log('Password:', password);

    try {
      const response = await axios.post('http://localhost:8080/Doctorslogin', {
        email: email,
        password: password,
      });

      if(response.data){
        dname = response.data.username;
        demail= email;
        dflag = response.data.flag;
        did = response.data.id;
        if(dflag){
          navigate(`/Doctorpage?dname=${dname}&did=${did}&demail=${demail}`);
        }else{
          setMsg('Wrong password');
        }
    }

    }catch (error) {
      console.log('Error logging in', error);
      setMsg('Wrong email or password');
    }
  }

  return (
    <>
       
      <Header/>
      
      <section className='container usrlg-container'  >
        <div className='usrlg-card' >
          <h2>Doctors Login</h2>
          <form onSubmit={handleSubmit} >

            <label>
              <span>Email:</span>
              <input type="text"  value={email} onChange={handleEmailChange}/>
            </label>
            

            <label>
              <span>Password:</span>
              <input type="password" value={password} onChange={handlePasswordChange} />
            </label>
            

            <button type="submit">Login</button>

            {msg && <p>{msg}</p>}

          </form>
        </div>
      </section>
      <Footer/>
    </>
  )
}
