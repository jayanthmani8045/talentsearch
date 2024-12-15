import React from 'react';
import {
  Card,
  CardHeader,
  CardContent,
  Typography,
  Avatar,
  Grid,
  Chip,
  Box,
  IconButton,
  Divider
} from '@mui/material';
import {
  Email,
  Phone,
  LocationOn,
  Description,
  Star,
  Person,
  Work
} from '@mui/icons-material';

const TopCandidateCard = ({ candidate }) => {
  return (
    <Card sx={{ maxWidth: "100%", m: 2 }}>
      <CardHeader
        avatar={
          <Avatar sx={{ bgcolor: 'primary.main' }}>
            {candidate.candidateFirstName[0]}
          </Avatar>
        }
        action={
          <Chip
            icon={<Star />}
            label={`Score: ${candidate.candidateScore.toFixed(1)}`}
            color="primary"
          />
        }
        title={
          <Typography variant="h6">
            {candidate.candidateFirstName} {candidate.candidateLastName}
          </Typography>
        }
        subheader={`ID: ${candidate.candidateId}`}
      />
      <Divider />
      <CardContent>
        <Grid container spacing={2}>
          <Grid item xs={12}>
            <Box display="flex" alignItems="center" gap={1}>
              <Work color="action" />
              <Typography variant="body1">
                Type: {candidate.type}
              </Typography>
            </Box>
          </Grid>

          <Grid item xs={12} sm={6}>
            <Box display="flex" alignItems="center" gap={1}>
              <Email color="action" />
              <Typography variant="body1">
                {candidate.emailId}
              </Typography>
            </Box>
          </Grid>

          <Grid item xs={12} sm={6}>
            <Box display="flex" alignItems="center" gap={1}>
              <Phone color="action" />
              <Typography variant="body1">
                {candidate.number}
              </Typography>
            </Box>
          </Grid>

          <Grid item xs={12} sm={6}>
            <Box display="flex" alignItems="center" gap={1}>
              <LocationOn color="action" />
              <Typography variant="body1">
                {candidate.candidateLocation}
              </Typography>
            </Box>
          </Grid>

          <Grid item xs={12} sm={6}>
            <Box display="flex" alignItems="center" gap={1}>
              <Person color="action" />
              <Typography variant="body1">
                Age: {candidate.candidateAge}
              </Typography>
            </Box>
          </Grid>

          <Grid item xs={12}>
            <Box display="flex" alignItems="center" gap={1}>
              <Description color="action" />
              <Typography variant="body2" color="text.secondary">
                Resume: {candidate.resumeLocation}
              </Typography>
            </Box>
          </Grid>

          <Grid item xs={12}>
            <Typography variant="subtitle1" color="primary" sx={{ mt: 2, fontWeight: 'bold' }}>
              Feedback
            </Typography>
            <Typography variant="body2" color="text.secondary">
              {candidate.candidateFeedBack}
            </Typography>
          </Grid>
        </Grid>
      </CardContent>
    </Card>
  );
};

// Example usage:
const App = () => {
  const sampleCandidate = {
    username: "jsmith2024",
    password: "Secure@Pass123",
    type: "fulltime",
    number: "6175551234",
    emailId: "john.smith@gmail.com",
    candidateFirstName: "John",
    candidateLastName: "Smith",
    candidateLocation: "Boston, MA",
    candidateAge: 28,
    candidateId: 1001,
    candidateScore: 85.5,
    candidateFeedBack: "Strong technical skills, excellent communication",
    getCandidateId: 1001,
    resumeLocation: "src/main/java/com/edu/neu/csye6200/resume/example_resume1.pdf"
  };

  return (
    <Box sx={{ p: 3, bgcolor: '#f5f5f5', minHeight: '100vh' }}>
      <CandidateCard candidate={sampleCandidate} />
    </Box>
  );
};

export default TopCandidateCard;