package edu.neu.csye6200.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.neu.csye6200.models.Candidate;
import edu.neu.csye6200.models.HiringManager;
import edu.neu.csye6200.repositories.CandidateRepository;
import edu.neu.csye6200.repositories.HiringManagerRepository;

class SortByScore implements Comparator<Candidate>{

	@Override
	public int compare(Candidate c1, Candidate c2) {
		return Double.compare(c2.getCandidateScore(), c1.getCandidateScore());
	}
	
}

@Service
public class MenuOperations {
	@Autowired CandidateRepository candidateRepository;
	@Autowired OpenAIService openAI;
	
	public List<Candidate> showAllCandidates()
	{
		return candidateRepository.findAll();
	}
	
	public List<Candidate> showTopCandidates(HiringManager hiringManager) throws Exception
	{
		List<Candidate> candidates=candidateRepository.findAll();
    	List<Candidate> updatedList=new ArrayList<Candidate>();
    	for(Candidate candidate:candidates)
    	{
    		updatedList.add(openAI.getScoreAndFeedback(candidate,hiringManager));
    		
    	}
    	Collections.sort(updatedList,new SortByScore());
    	
    	return updatedList;
	}
}

