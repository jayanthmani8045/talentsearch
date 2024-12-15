import * as React from 'react';
import { useState } from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import "./LoginScreen.css"
import axios from 'axios';
import { useNavigate } from 'react-router';

export default function LoginForm() {

  const [userName, setUserName] = useState("");
  const [password, setPassword] = useState("");
  const navigate=useNavigate();

  async function handleSubmit(){
    console.log(userName,password);
    let data = axios.post("http://localhost:8080/login",{"username":userName,"password":password});
    if((await data).data !== "")
    {
        let hiringManager = (await data).data
        navigate("/home", {state: {hiringManager}});
    }   
    else
            alert("Invalid Username or Password")

    }

  return (
    <div className='form'>
        <Box
        component="form"
        noValidate
        autoComplete="off"
        >
        <TextField id="outlined-basic" label="Username" variant="outlined"
                value={userName}
                onChange={(e) => setUserName(e.target.value)} />
        <br /><br />
        <TextField id="outlined-basic" label="Password" variant="outlined"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
        type='password'/>
        <br /><br />
        <Button variant="contained" onClick={handleSubmit}> Submit</Button>

        </Box>
    </div>
  );
}
