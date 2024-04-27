import React from 'react'
import Header from '../Components/Header'
import Footer from '../Components/Footer'
import { NavLink,useLocation  } from 'react-router-dom'
import { useState,useEffect } from 'react';
import axios from 'axios';

import '../App.css'
import '../Appqueries.css'

export default function Doctorpage() {

  const location = useLocation();
  const searchParams = new URLSearchParams(location.search);
  const docname = searchParams.get('dname');
  const docid = searchParams.get('did');
  const docemail = searchParams.get('demail');
  const [appointments, setAppointments] = useState([]);

  const fetchAppointments = async () => {
    try {
      const response = await axios.post('http://localhost:8080/Doctorpage/ShowDoctorappointments', { 
        username : docname,
        id: docid,
        email: '',
        flag: true 
      });
      setAppointments(response.data);
    } catch (error) {
      console.error('Error fetching appointments', error);
    }
  };

  // refetch the appointments of the user once there is a change in DB
  let flag = 'true';
  useEffect(() => {
      fetchAppointments();
  }, [docid, docname, docemail, flag]);


  const handleOverClick = async (apno) => {
    try {
        await axios.post('http://localhost:8080/Doctorpage/Finishappointment', { Aid: apno });
        // Refresh the appointments list after marking an appointment as over
        fetchAppointments();
    } catch (error) {
        console.error('Error marking appointment as over', error);
    }
  };

  return (
    <>
        <Header/>
        <div className='logout-bar'>
            <NavLink className='nav-link'  to="/" ><p>Logout</p></NavLink>
        </div>

        <section className='container doc-container' >
            <h2>Welcome Dr.{docname}</h2>
            <h2>Your Patients</h2>
            <div className='doc-patients' >

              <div className='doc-appointments' >
                  {appointments.map((appointment, index) => (
                      <div key={index} className="appointmentcard">
                          <p>Appointment No : <b>{appointment.aid}</b></p>
                          <p>Patient Name: <b>{appointment.pname}</b></p>
                          <p>Age: <b>{appointment.patage}</b></p>
                          <p>Phone No: <b>{appointment.pphone}</b> </p>
                          <p>Date: <b>{appointment.adate}</b> & Time: <b>{appointment.atime}</b></p>
                          <button type="submit" onClick={() => handleOverClick(appointment.aid)}  >OVER</button>
                      </div>
                  ))} 
              </div>

            </div>
        </section>

        <Footer/>

    </>
  )
}
