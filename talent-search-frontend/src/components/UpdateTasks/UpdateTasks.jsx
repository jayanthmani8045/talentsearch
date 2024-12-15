import React, { useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import { Button, TextareaAutosize } from '@mui/material';
import UpdateTasksHeader from './UpdateTasksHeader';
import axios from 'axios';
import './UpdateTasks.css';

export default function UpdateTasks() {
  const location = useLocation();
  const navigate = useNavigate();
  const data = location.state || {};
  const [jobDescription, setJobDescription] = useState(data.manager.jobDescription);

  console.log(data.manager._id);

  const handleSubmit = async () => {
    alert(jobDescription);
    const response = await axios.put(
      'http://localhost:8080/updateJobDescription/'+data.manager.referenceId,
      data.manager,
      {
        params: { jobDescription: jobDescription },
      }
    );
    if (response.data !== '') {
      navigate('/home', { state: { hiringManager: response.data } });
    }
  };

  return (
    <>
      <UpdateTasksHeader />
      <div className="form">
        <TextareaAutosize
          className='TextArea'
          placeholder="Job Description"
          value={jobDescription}
          onChange={(e) => setJobDescription(e.target.value)}
          style={{
            width: '480px',
            height: '150px',
            padding: '10px',
            fontSize: '16px',
            marginBottom: '20px',
            border: '1px solid #ccc',
            borderRadius: '4px',
            resize: 'none',
          }}
        />
        <Button variant="contained" onClick={handleSubmit}>
          Submit
        </Button>
      </div>
    </>
  );
}
