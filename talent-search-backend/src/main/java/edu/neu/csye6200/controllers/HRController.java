package edu.neu.csye6200.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import edu.neu.csye6200.models.Candidate;
import edu.neu.csye6200.models.HiringManager;
import edu.neu.csye6200.repositories.CandidateRepository;
import edu.neu.csye6200.repositories.HiringManagerRepository;
import edu.neu.csye6200.services.Login;
import edu.neu.csye6200.services.MenuOperations;
import edu.neu.csye6200.services.OpenAIService;

class SortByScore implements Comparator<Candidate>
{

	@Override
	public int compare(Candidate o1, Candidate o2) {
		return Double.compare(o2.getCandidateScore(), o1.getCandidateScore());
	}
	
}

@CrossOrigin(
	    origins = "http://localhost:5173", 
	    allowedHeaders = "*", 
	    allowCredentials = "true")
@RestController
@RequestMapping("/")

public class HRController {
	
    private final String RESUME_DIRECTORY = "src/main/java/edu/neu/csye6200/resume/";


	@Autowired MenuOperations menuOperations;
	@Autowired Login login;
	@Autowired HiringManagerRepository hiringManagerRepository;

	
    @GetMapping("")
    public String home() {
        return "Working";
    }
    
    @PostMapping({"/login","/login/"})
    public HiringManager getHiringManager(@RequestBody HiringManager manager)
    {
    	System.out.println("Username: "+manager.getUsername() + " Password: "+manager.getPassword());
		return login.login(manager.getUsername(),manager.getPassword());
    	
    }
    
    @GetMapping("/allCandidates")
    public List<Candidate> getAllCandidates() throws Exception
    {	
    	return menuOperations.showAllCandidates();
    }

    @PostMapping("/topCandidates")
    public List<Candidate> getTopCandidates(@RequestBody HiringManager manager) throws Exception {
    	return menuOperations.showTopCandidates(manager);
    }
    
    @PutMapping("/updateJobDescription/{id}")
    public HiringManager updateDescription(@PathVariable String id, @RequestParam String jobDescription) {
        try {
            ObjectId objectId = new ObjectId(id);
            Optional<HiringManager> existingManager = hiringManagerRepository.findById(objectId);
            
            if (existingManager.isPresent()) {
                HiringManager manager = existingManager.get();
                manager.setJobDescription(jobDescription);
                return hiringManagerRepository.save(manager);
            }
            
            throw new RuntimeException("Manager not found");
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid ID format", e);
        }
    }

    
    @GetMapping("/download/{filename}")
    public ResponseEntity<Resource> downloadResume(@PathVariable String filename) {
        try {

        	Path filePath = Paths.get(RESUME_DIRECTORY).resolve(filename).normalize();
            Resource resource = new UrlResource(filePath.toUri());

            if (!resource.exists() || !resource.isReadable()) {
                return ResponseEntity.notFound().build();
            }

            String contentType = "application/pdf";
            if (filename.toLowerCase().endsWith(".doc")) {
                contentType = "application/msword";
            } else if (filename.toLowerCase().endsWith(".docx")) {
                contentType = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
            }

            return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);

        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}



