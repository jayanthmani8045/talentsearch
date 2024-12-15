import * as React from 'react';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import './HomeScreen.css';
import axios from "axios";
import { useNavigate } from 'react-router';

export default function HomeMenu(props) {

  const navigate = useNavigate();

  const getAllCandidates = () => {
    axios.get("http://localhost:8080/allCandidates").then(
      response => {
          let data= response.data
          navigate('/allCandidates', {state: {data}})
      }
    )
    }

     const getTopCandidates = async () => {
      let manager=props.hiringManager;
      console.log(manager);
      let data = axios.post("http://localhost:8080/topCandidates", manager);
      if((await data).data !== "")
      {
          let hiringManager = (await data).data
          console.log(hiringManager,data);
          navigate("/topCandidates", {state: {hiringManager}});
      } 
    }

    const updateTasks = async () => {
      let manager = props.hiringManager;
      navigate("/updateTasks", { state: { manager } });
      
  };
  

  return (
    <div className="card-container">
      <Card className="card">
        <CardMedia
          component="img"
          alt="refresh icon"
          image="./refresh.png"
          className="card-image"
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="div">
            Update Job Description
          </Typography>
          <Typography variant="body2" sx={{ color: 'text.secondary' }}>
            In this segment you will be able to update the existing job description for your recruitment.
          </Typography>
        </CardContent>
        <CardActions>
          <Button size="small" onClick={updateTasks}>ENTER</Button>
        </CardActions>
      </Card>

      <Card className="card">
        <CardMedia
          component="img"
          alt="candidate icon"
          image="./candidate.png"
          className="card-image"
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="div">
            All Candidates
          </Typography>
          <Typography variant="body2" sx={{ color: 'text.secondary' }}>
            In this segment you will be able to see all the candidates who have applied to our job posting.
          </Typography>
        </CardContent>
        <CardActions>
          <Button size="small" onClick={getAllCandidates}>ENTER</Button>
        </CardActions>
      </Card>

      <Card className="card">
        <CardMedia
          component="img"
          alt="candidate icon alternate"
          image="./candidate (1).png"
          className="card-image"
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="div">
            Top Candidates
          </Typography>
          <Typography variant="body2" sx={{ color: 'text.secondary' }}>
            In this segment you will be able to see the top most candidates who are suitable for this job
          </Typography>
        </CardContent>
        <CardActions>
          <Button size="small" onClick={getTopCandidates}>ENTER</Button>
        </CardActions>
      </Card>
    </div>
  );
}
