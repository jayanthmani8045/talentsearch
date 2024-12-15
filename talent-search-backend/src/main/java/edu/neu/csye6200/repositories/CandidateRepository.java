package edu.neu.csye6200.repositories;
import java.util.List;
import org.springframework.data.mongodb.repository.*;
import org.springframework.stereotype.Repository;

import edu.neu.csye6200.models.Candidate;
import edu.neu.csye6200.models.Person;

@Repository
public interface CandidateRepository extends MongoRepository<Candidate,String>{
}
