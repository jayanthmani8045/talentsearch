package edu.neu.csye6200.services;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import edu.neu.csye6200.models.Candidate;
import edu.neu.csye6200.models.HiringManager;
import edu.neu.csye6200.models.interfaces.ScanResume;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.json.JSONObject;

@Service
public class OpenAIService {
	@Autowired 
	private ScanResumeFactory resumeFactory; 
	
    private static final String BASE_URL = "https://openrouter.ai/api/v1";
    @Value("${api.key}")
    private final String apiKey;
    private final HttpClient client;
   
    public OpenAIService(@Value("${api.key}") String apiKey) {
		this.apiKey = apiKey;
		this.client = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(30))
            .build();
    }
    
    public Candidate getScoreAndFeedback(Candidate candidate, HiringManager manager) throws Exception {
    	String fileLocation = candidate.getResumeLocation();
    	ScanResume reader=resumeFactory.getResumeContent(fileLocation);
    	String resumeContent=reader.getResumeContent(candidate.getResumeLocation());
    	
    	System.out.println(candidate.getCandidateFirstName() + "\n" + resumeContent.substring(0,100));
    	
        String finalPrompt = String.format("""
                    Your task is to provide a resume score and feedback in this exact format: score#feedback
        Rules:
        1. Score must be between 0-100 with up to 2 decimal places
        2. Feedback must be exactly 20 words
        3. Use only a single # to separate score and feedback
        4. No additional text or sections allowed
        5. Focus on technical abilities and job suitability
        
        Example response:
        90.25#The candidate's profile is specialised in Java Springboot. His internship in full-stack development could be a major factor to consider
        
        Resume to analyze:
        %s
        
        Job Description:
        %s
        
        Provide your score#feedback response:""", resumeContent, manager.getJobDescription());

        String jsonBody = String.format("""
            {
                "model": "meta-llama/llama-3.1-70b-instruct:free",
                "messages": [
                    {
                        "role": "user",
                        "content": "%s"
                    }
                ],
                "temperature":0.56
            }""", finalPrompt.replace("\"", "\\\"").replace("\n", "\\n").replace("\r", "\\r"));

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(BASE_URL + "/chat/completions"))
            .header("Content-Type", "application/json")
            .header("Authorization", "Bearer " + this.apiKey)
            .header("HTTP-Referer", "https://openrouter.ai/docs")
            .header("X-Title", "Java API Integration")
            .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
            .build();
        HttpResponse<String> response1 = this.client.send(request,
                HttpResponse.BodyHandlers.ofString());
            
            JSONObject jsonResponse = new JSONObject(response1.body());
            
            String content = jsonResponse
                .getJSONArray("choices")
                .getJSONObject(0)
                .getJSONObject("message")
                .getString("content");
            String[] scoreAndFeedback=content.split("#");
            candidate.setCandidateScore(Double.parseDouble(scoreAndFeedback[0]));
            candidate.setCandidateFeedBack(scoreAndFeedback[1]);
            
            return candidate;
    }
}