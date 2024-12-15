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

const CandidateCard = ({ candidate }) => {
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



export default CandidateCard;