package edu.neu.csye6200.repositories;
import java.util.List;
import org.springframework.data.mongodb.repository.*;
import org.springframework.stereotype.Repository;

import edu.neu.csye6200.models.HiringManager;
import edu.neu.csye6200.models.Person;

@Repository
public interface HiringManagerRepository extends MongoRepository<HiringManager,String>{
	HiringManager findByManagerId(String id);
}
