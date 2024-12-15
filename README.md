
# TalentSearch

**TalentSearch** is a Java-based application powered by OpenAI, designed to assist hiring managers in identifying the most suitable candidates for job openings. The application allows hiring managers to log in, update job descriptions, and search for candidates based on specific skills and experience. By leveraging OpenAI's capabilities, **TalentSearch** analyzes job descriptions and matches them with the most qualified candidates, streamlining the recruitment process and ensuring better hiring decisions.

Instead of relying on manual searches and interviews, **TalentSearch** provides an AI-driven approach to talent acquisition, saving time and resources while improving the overall quality of hires. Unlike traditional systems that map keywords to skills, **TalentSearch** uses OpenAI's natural language processing capabilities to understand the nuances of job descriptions and identify the right candidates. This advanced approach enables hiring managers to focus on what matters most which is finding the best talent for their organization.

## Table of Content

- [Brief Intro](#talentsearch)

- [UML Diagram/Class Diagram](#system-design-for-talentSearch)

- [Getting Started](#getting-started)

- [Authors](#authors)

## System Design for TalentSearch

```mermaid
---
title: Talent Search
---

classDiagram
    class SpringApplication{
        +static run()
    }

    class MongoTemplate{
        +MongoDatabase getDb()
        +String getName()
    }

    class TalentSearchApplication{
        +MongoTemplate mongoTemplate
        +public void run()
        +String dbName
    }

    MongoTemplate <|-- TalentSearchApplication
    SpringApplication <|-- TalentSearchApplication

    class Comparator
    <<interface>> Comparator
    Comparator: int compare()

    class HRController{
        -String BASEURL
        MenuOperations menuOperations
        Login login
        HiringManagerRepository hiringManagerRepository

        +HiringManager getHiringManager(HiringManager manager)
        +List<Candidate> getAllCandidates()
        +List<Candidate> getTopCandidates(HiringManager manager)
        +ResponseEntity<Resource> downloadResume(String fileName)
    }

    TalentSearchApplication *-- HRController


    class MenuOperations {
        +CandidateRepository candidateRepository
        +OpenAIService openAI

        +List<Candidate> showAllCandidates()
        +List<Candidate> showTopCandidates(HiringManager manager)
    }

    HRController *-- MenuOperations
    MenuOperations *-- CandidateRepository
    MenuOperations *-- OpenAIService
    MenuOperations *-- Comparator

    class OpenAIService{
        -ScanResumeFactory resumeFactory

        -static final BASE_URL
        -final String apiKey
        -final HttpClient client

        +Candidate getScoreAndFeedBack(Candidate candidate, HiringManager manager)
    }

        class ScanResume
    <<interface>> ScanResume
    ScanResume: +String getResumeContent(String fileLocation)

    class PdfReader{
        +String getResumeContent(String fileLocation)
    }

    class WordReader{
      +String getResumeContent(String fileLocation)
    }
    ScanResume <|-- PdfReader
    ScanResume <|-- WordReader

    class ScanResumeFactory {
        -ScanResume reader_Word;
	    -ScanResume reader_PDF;
        +ScanResume getResumeContent(String file)
    }
    ScanResumeFactory *-- PdfReader
    ScanResumeFactory *-- WordReader

    OpenAIService *--ScanResumeFactory

    class Login {
        +HiringManagerRepository hiringManagerRepository
        +HiringManager login(String username, String password)
    }

    HRController *-- Login

    class Person {
            - ObjectId _id
            +String username
            +String password
            +String type
            +long number
            +String emailId
            +String referenceId
            + ObjectId getId()
            + void setId(ObjectId _id)

            + String getReferenceId()
            + void setReferenceId(String referenceId)

            + String getUsername()
            + void setUsername(String username)

            + String getPassword()
            + void setPassword(String password)

            + String getType()
            + void setType(String type)

            + long getNumber()
            + void setNumber(long number)

            + String getEmailId()
            + void setEmailId(String emailId)

    }

    class HiringManager {
            private String managerId
            private String jobDescription
            private String jobTitle
            private String jobLocation
            - String managerId
            - String jobDescription
            - String jobTitle
            - String jobLocation

            + String getManagerId()
            + void setManagerId(String managerId)

            + String getJobDescription()
            + void setJobDescription(String jobDescription)

            + String getJobTitle()
            + void setJobTitle(String jobTitle)

            + String getJobLocation()
            + void setJobLocation(String jobLocation)
    }

    class Candidate{
        - String candidateFirstName
        - String candidateLastName
        - String candidateLocation
        - int candidateAge
        - int candidateId
        - double candidateScore
        - String candidateFeedback
        - int getCandidateId
        - String resumeLocation

        + String getCandidateFirstName()
        + void setCandidateFirstName(String candidateFirstName)

        + String getCandidateLastName()
        + void setCandidateLastName(String candidateLastName)

        + String getCandidateLocation()
        + void setCandidateLocation(String candidateLocation)

        + int getCandidateAge()
        + void setCandidateAge(int candidateAge)

        + int getCandidateId()
        + void setCandidateId(int candidateId)

        + double getCandidateScore()
        + void setCandidateScore(double candidateScore)

        + String getCandidateFeedback()
        + void setCandidateFeedback(String candidateFeedback)

        + int getGetCandidateId()
        + void setGetCandidateId(int getCandidateId)

        + String getResumeLocation()
        + void setResumeLocation(String resumeLocation)

    }

    class HiringManagerRepository
    <<interface>> HiringManagerRepository
    HiringManagerRepository *-- HiringManager

    class CandidateRepository
    <<interface>> CandidateRepository
    CandidateRepository *-- Candidate

    HRController *-- CandidateRepository

    class MongoRepository
    <<interface>> MongoRepository

    MongoRepository <|-- HiringManagerRepository
    MongoRepository <|-- CandidateRepository

    Person <|-- Candidate
    Person <|-- HiringManager

```

## Getting Started

### Backend Setup

1. Open Eclipse IDE
2. Navigate to `talent-search-backend` project
3. Locate `src/main/java/edu/neu/csye6200/application/TalentSearchApplication.java`
4. Right-click on `TalentSearchApplication.java` and select "Run as Java Application"

### Frontend Setup

Prerequisites:

- Node.js (Latest LTS version)

Steps:

1. Open Visual Studio Code
2. Navigate to `talent-search-frontend` directory
3. Open terminal and run:

```bash
npm install
npm run dev
```

The frontend server will start automatically and display the local development URL.

If the OpenAI key is not working, please generate a new from https://openrouter.ai/settings/keys and update it in the application.properties file. This may occur when the key has reached it's limit.

## Author

- [Jayanth Mani](mani.j@northeastern.edu)


