package edu.neu.csye6200.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "edu.neu.csye6200")
@EnableMongoRepositories(basePackages = "edu.neu.csye6200.repositories")
public class TalentSearchApplication implements CommandLineRunner {
    
    @Autowired
    private MongoTemplate mongoTemplate;

    public static void main(String[] args) {
        SpringApplication.run(TalentSearchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            String dbName = mongoTemplate.getDb().getName();
            System.out.println("Successfully connected to MongoDB Atlas database: " + dbName);
        } catch (Exception e) {
            System.err.println("Failed to connect to MongoDB Atlas: " + e.getMessage());
            e.printStackTrace();
        }
    }
}