import React,{ useState }  from 'react'
import Header from '../Components/Header'
import Footer from '../Components/Footer'
import axios from 'axios';

import '../App.css'
import '../Appqueries.css'

export default function Createaccount() {

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [email, setEmail] = useState('');
    const [phoneno, setPhoneNo] = useState('');
    const [showSuccessMessage, setShowSuccessMessage] = useState(false);
    const handleUsernameChange = (e) => {
        setUsername(e.target.value);
      };
    
      const handlePasswordChange = (e) => {
        setPassword(e.target.value);
      };
    
      const handleEmailChange = (e) => {
        setEmail(e.target.value);
      };
    
      const handlePhoneNoChange = (e) => {
        setPhoneNo(e.target.value);
      };

      const handleSubmit =  async (e) => {
        e.preventDefault();
        console.log('Username:', username);
        console.log('Password:', password);
        console.log('Email:', email);
        console.log('PhoneNo:', phoneno);
    
        try{
          const response = await axios.post('http://localhost:8080/Createaccount', {
            uemail: email,
            upassword: password,
            uname: username,
            uphone: phoneno,
          });
    
          if(response.data){
            setShowSuccessMessage(true);
          }else{
            setShowSuccessMessage(false);
          }
          
        }catch(error){
          console.log('Error creating account', error);
          setShowSuccessMessage(false);
        }
    
        // Simulate a successful account creation
        
    
        // Reset form fields
        setUsername('');
        setPassword('');
        setEmail('');
        setPhoneNo('');
      };

  return (
    <>
    
        <Header/>

        <section className='container crtAcc-container' >
            <div className='crtAcc-card'>
              <h2>Create Account</h2>
                <form onSubmit={handleSubmit} >
                    <label>
                        Username:
                        <input type="text" value={username} onChange={handleUsernameChange} />
                    </label>
                    <br />

                    <label>
                        Password:
                        <input type="password" value={password} onChange={handlePasswordChange} />
                    </label>
                    <br />

                    <label>
                        Email:
                        <input type="text" value={email} onChange={handleEmailChange} />
                    </label>
                    <br />

                    <label>
                        PhoneNo:
                        <input type="text" value={phoneno} onChange={handlePhoneNoChange} />
                    </label>
                    <br />

                    <button type="submit">Create Account</button>
                    {showSuccessMessage && <p>Account created successfully!</p>}
                </form>
            </div>
        </section>

        <Footer/>
    
    </>
  )
}
