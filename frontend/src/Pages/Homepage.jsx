import React from 'react'
import Header from '../Components/Header'
import Footer from '../Components/Footer'
import { NavLink } from 'react-router-dom'
import '../App.css'
import '../Appqueries.css'

export default function Homepage() {
  return (
    <>
        <Header/>
        <section className='container Home-container' >
        <h2>Welcome to BookmyDoctor, A Quick and easy way to book Appointment</h2>
        <h2>Login Links:</h2>
        <div>
            <ul>
                <li><NavLink className="nav-link" to="Userslogin" > 
                  <p className='login-icon' >👨‍👩‍👧‍👦</p>
                  <p className='login-icon-desc' >Users login</p>
                </NavLink></li>
                <li><NavLink className="nav-link"  to="Doctorslogin" >
                  <p className='login-icon' >👩‍⚕️</p>
                  <p className='login-icon-desc' >Doctors login</p>
                </NavLink></li>
            </ul>
        </div>
        </section>
        <Footer/>
    </>
  )
}
