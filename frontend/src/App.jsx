import React from 'react'
import { BrowserRouter,Routes,Route} from 'react-router-dom'
import Homepage from './Pages/Homepage'
import Pagenotfound from './Pages/Pagenotfound'
import Doctorslogin from './Pages/Doctorslogin'
import Userslogin from './Pages/Userslogin'
import Createaccount from './Pages/Createaccount'
import Userpage from './Pages/Userpage'
import Doctorpage from './Pages/Doctorpage'

export default function App() {
  return (
    <>
    
        <BrowserRouter>
        
            <Routes>

                <Route path="/" element={<Homepage/>} />
                <Route path="*" element={<Pagenotfound/>} />

                <Route path="/Userslogin" element={<Userslogin/>} />
                <Route path="/Doctorslogin" element={<Doctorslogin/>} />
                <Route path="/Createaccount" element={<Createaccount/>} />

                <Route path="/Userpage" element={<Userpage/>} />
                <Route path="/Doctorpage" element={<Doctorpage/>} />

            </Routes>

        </BrowserRouter>
    
    </>
  )
}
