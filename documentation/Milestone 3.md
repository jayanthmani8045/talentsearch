# Problem Statement: of group 1 - TalentSearch

Traditional recruitment methods often fall short in identifying the most suitable candidates for job openings. Manual processes for screening and matching candidates are time-consuming, inefficient, and prone to errors. Furthermore, traditional systems that rely on keyword matching fail to understand the nuances of job descriptions and candidate qualifications, leading to suboptimal hiring decisions.

This inefficiency poses a significant challenge for hiring managers, especially in high-volume or specialized recruitment scenarios, as they struggle to balance time constraints with the need for quality hires. There is a need for a solution that streamlines the recruitment process, enhances accuracy, and saves time and resources while ensuring better hiring outcomes.

**TalentSearch** addresses this problem by utilizing OpenAI's natural language processing capabilities to provide an AI-driven, scalable approach to talent acquisition.

## Table of Content

- [Problem Statement](#problem-statement-of-group-1---talentsearch)
- [Final Tech Stack](#final-tech-stack)
- [Functionalities Implemented](#functionalities-implemented)
- [OOPs Concepts](#oops-concepts)
- [Contributions](#contributions)
- [Project Group Number/Name](#authors-of-group-1)

## Final Tech Stack

### Front-End
- **React.js**

### Back-End
- **Java**: Core language for implementing business logic, encapsulation, and database interaction.
- **Spring Boot**: To create and manage backend APIs for a scalable, REST-based architecture.
- **OpenAI API Integration**: Used for natural language processing to analyze resumes and generate scores/feedback.

### Database
- **MongoDB**: If there’s a need to store unstructured or semi-structured data (e.g., scanned resume content).

### IDE/Tools
- IntelliJ IDEA/Eclipse/VS Code - For Java development.

## Functionalities Implemented

### Authentication
- Login functionality for hiring managers
- Secure access control to protect sensitive recruitment data

### Job Description Management
- Update existing job descriptions
- Modify job requirements and specifications dynamically

### Candidate Management
- View complete list of all candidates
- Access candidate profiles and application details
- Screen candidates using OpenAI integration
- Rank candidates based on job requirement matching
- Generate shortlist of top candidates automatically

### Document Processing
- PDF file parsing and data extraction
- DOCX file parsing and data extraction
- Factory pattern implementation for scalable file handling

### Database Operations
- MongoDB integration for data persistence
- CRUD operations for candidate profiles
- Update operation for job descriptions
- Document storage for resumes and applications

### Technology Integration
- SpringBoot REST API endpoints
- ReactJS frontend implementation
- OpenAI API integration for candidate screening
- Cross-origin resource sharing setup

## OOPs Concepts

The TalentSearch application implements several core **Object-Oriented Programming (OOP)** concepts, which include:

### 1. Encapsulation
- **Definition**: Encapsulation binds data and methods that manipulate the data into a single unit (class) and restricts direct access to some of the object's components.
- **Implementation**:
  	- `@Autowired MenuOperations menuOperations;`
	- `@Autowired Login login;`

### 2. Inheritance
- **Definition**: Inheritance allows a class to acquire the properties and behaviors of another class.
- **Implementation**:
  - `public class Candidate extends Person`
  - `public class PdfReader implements ScanResume`

### 3. Polymorphism
- **Definition**: Polymorphism allows methods to perform different tasks based on the object calling them.
- **Implementation**:
  - `ScanResume reader = new WordReader();`
  - ```@Override public void run(String... args) throws Exception```

### 4. Abstraction
- **Definition**: Abstraction focuses on exposing essential features while hiding implementation details.
- **Implementation**:
  - `private MongoTemplate mongoTemplate;`
  - `protected String id`

### 5. Composition
- **Definition**: Composition involves using objects of one class within another class to achieve functionality.
- **Implementation**:
  - `@Autowired CandidateRepository candidateRepository;`
  - `@Autowired OpenAIService openAI`

### 6. Classes and Objects
- **Definition**: Classes act as blueprints for creating objects, which are instances of the class.
- **Implementation**:
  - ```public  class Database {
        @Autowired HiringManagerRepository hiringManagerRepository;
        public boolean verify(String username)
        {
            Optional<HiringManager> manager=hiringManagerRepository.findById(username);
            System.out.println(manager.isPresent()+" "+manager);
            return manager.isPresent();
        }
    }```

### 7. Association
- **Definition**: Association establishes a relationship between classes.
- **Implementation**:
  - `updatedList.add(openAI.getScoreAndFeedback(candidate,hiringManager));`

## Contributions

Although everyone contributed collaboratively throughout the project, the following highlights some of the key roles and individual contributions:

- The **Code Snippets** are attached with group members name on the file.

## Milestone 3: Team Member Contributions

### 1. Jayanth Mani
#### Frontend-Backend Integration Specialist
- Led the frontend-backend integration for real-time interactions
- Implemented robust input validation across frontend forms
- Conducted integration testing for frontend-backend interactions
- Extended from previous work on candidate functions display

### 2. Adharsh Rengarajan and Xindo Fan
#### AI Integration & Testing Team
- Enhanced OpenAI API integration to handle edge cases
- Improved resume analysis algorithms
- Conducted testing for feedback generation systems
- Built upon our previous work with Resume Scanning and OpenAI integration

### 3. Zuoyu Wang and Sai Kalyan
#### Database & Security Team
- Established secure database-backend API connections
- Implemented login credential validation
- Added runtime checks for API responses
- Performed testing for login and authentication
- Continued our work on database integration and core framework

### Shared Responsibilities
- All team members participated in system testing
- Collaborative code review and documentation
- Cross-functional support during integration phases
- Rest API implementation

## Authors of Group 1

- [Jayanth Mani](mani.j@northeastern.edu)
- [Sai Kalyan Burra](burra.sa@northeastern.edu)
- [Xinduo Fan](fan.xind@northeastern.edu)
- [Zuoyu Wang](wang.zuoy@northeastern.edu)
- [Adharsh Rengarajan](rengarajan.ad@northeastern.edu)
