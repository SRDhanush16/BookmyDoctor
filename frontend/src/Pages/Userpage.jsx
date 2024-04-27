import React from 'react'
import Header from '../Components/Header'
import Footer from '../Components/Footer'
import { NavLink } from 'react-router-dom'
import axios from 'axios'
import { useLocation } from 'react-router-dom'
import { useState ,useEffect} from 'react';

import '../App.css'
import '../Appqueries.css'


export default function Userpage() {

    const [uid,setUid] = useState(); // get form url
    const [uemail, setUemail] = useState(''); //
    const [pname,setPname] =  useState('');
    const [patage, setPatAge] = useState();
    const [pphone, setPphone] = useState('');
    const [dname, setDname] = useState('');
    const [adate, setAdate] = useState('');
    const [atime, setAtime] = useState('');
    const [appointments, setAppointments] = useState([]);
    const [showSuccessMessage, setShowSuccessMessage] = useState(false);


    const location = useLocation();
    const searchParams = new URLSearchParams(location.search);
    const usrname = searchParams.get('uname');
    const usrid = searchParams.get('uid');
    const usremail = searchParams.get('uemail');
    
    useEffect(() => {
        setUemail(usremail);
        setUid(usrid);
    }, []);
    
    
    // get all the appointments of the user
    const fetchAppointments = async () => {
        try {
          console.log("USERNAME : ", usrname);
          console.log("USER-ID : ", usrid);
            const response = await axios.post('http://localhost:8080/Userpage/ShowUserappointments', { 
                username : usrname,
                id: usrid,
                email: '',
                flag: true
            });
            
            setAppointments(response.data);
        } catch (error) {
            console.error('Error fetching appointments', error);
        }
    };

    
    //refetch the appointments of the user once there is a change in DB
    let flag = 'true';
    useEffect(() => {
        fetchAppointments();
    }, [usrid, usrname, usremail, flag]);

    // used to cancel the appointment
    const handleCancelClick = async (apno) => {
        try {
            await axios.post('http://localhost:8080/Userpage/Cancelappointment', { Aid: apno });
            // Refresh the appointments list after marking an appointment as over
           fetchAppointments();
        } catch (error) {
            console.error('Error in Canceling Appointment : ', error);
        }
    };

    const handlePatientNameChange = (e)=>{
        setPname(e.target.value);
    }
    const handlePatientAgeChange = (e) => {
        setPatAge(e.target.value);
    }
    const handlePatientPhoneChange = (e) => {
        setPphone(e.target.value);
    }
    const handleDoctorNameChange = (e) => {
        setDname(e.target.value);
    }
    ;
    const handleAppointmentDateChange = (e) => {
        setAdate(e.target.value);
    }
    const handleAppointmentTimeChange = (e) => {
        setAtime(e.target.value);
    }

    const handleSubmit = async(e) => {
        e.preventDefault();

        try{
            const response = await axios.post('http://localhost:8080/Userpage/Bookappointment',{
                uid: uid ,
                pname: pname ,
                patage: patage ,
                pphone: pphone ,
                dname: dname ,
                adate: adate ,
                atime: atime ,
                uemail: uemail
            });
            if(response.data){
                setShowSuccessMessage(true);
            }else{
                setShowSuccessMessage(false);
            }
        }catch(error){
            console.log('Error booking appointment', error);
          setShowSuccessMessage(false);
        }
        setPname('');
        setPatAge('');
        setPphone('');
        setDname('');
        setAdate('');
        setAtime('');
    };

    const [doctors, setDoctors] = useState([]);
    useEffect(() => {
        const fetchDoctors = async () => {
            try {
                const response = await axios.get('http://localhost:8080/Userpage/getDoctors');
                setDoctors(response.data);
            } catch (error) {
                console.error('Error fetching doctors:', error);
            }
        };

        fetchDoctors();
    }, []); // Empty dependency array to run only once when component mounts

    

  return (
    <>
    
        <Header/>
        <div className='logout-bar' >
            <NavLink className='nav-link'  to="/" ><p>Logout</p></NavLink>
        </div>
        
        <section className='container usrpg-container' >
            <h2>Welcome {usrname}</h2>

            <div className='usr-appointments' >
                {appointments.map((appointment, index) => (
                    <div key={index} className="appointmentcard">
                        <p>Appointment No :<b>{appointment.aid}</b> </p>
                        <p>Patient Name: <b>{appointment.pname}</b></p>
                        <p>Age: <b>{appointment.patage}</b> </p>
                        <p>Doctor Name : <b>{appointment.dname}</b></p>
                        <p>Date: <b>{appointment.adate}</b>& Time: <b>{appointment.atime}</b> </p>
                        <button type="submit" onClick={() => handleCancelClick(appointment.aid)}  >CANCEL</button>
                    </div>
                ))} 
            </div>

            

            <h2>Book Appointment</h2>

            <div className='book-appointments' >
                
                <form onSubmit={handleSubmit} >
                    <label>
                        Patient Name:
                        <input type="text" value={pname} onChange={handlePatientNameChange} />
                    </label>
                    <br />

                    <label>
                        Patient Age:
                        <input type="number" value={patage} onChange={handlePatientAgeChange} />
                    </label>
                    <br />

                    <label>
                        Phone No:
                        <input type="text" value={pphone} onChange={handlePatientPhoneChange} />
                    </label>
                    <br />

                    <label>
                        Doctor Name:
                        <select onChange={handleDoctorNameChange} value={dname} >
                            <option value="" >Select Doc</option>
                            {doctors.map((doctor, index) => (
                                <option key={index} value={doctor.dname}>{doctor.dname},{doctor.specialzation}</option>
                            ))}
                        </select>
                    </label>
                    <br />

                    <label>
                        Date:
                        <input type="date" value={adate} onChange={handleAppointmentDateChange} />
                    </label>
                    <br />

                    <label>
                        Time:
                        <select value={atime} onChange={handleAppointmentTimeChange} >
                            <option value="" >Select Time</option>
                            <option value={doctors.find((doctor) => doctor.dname === dname)?.slot1}>{doctors.find((doctor) => doctor.dname === dname)?.slot1}</option>
                            <option value={doctors.find((doctor) => doctor.dname === dname)?.slot2}>{doctors.find((doctor) => doctor.dname === dname)?.slot2}</option>
                        </select>
                    </label>
                    <br />
                    <button type="submit">Book Appointment</button>

                </form>
                {showSuccessMessage && <p>Appointment booked successfully!</p>}
            </div>

        </section>

        <Footer/>
    
    </>
  )
}
