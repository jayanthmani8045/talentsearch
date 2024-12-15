## Problem-Statement: of group 1 - TalentSearch

Traditional recruitment methods often fall short in identifying the most suitable candidates for job openings. Manual processes for screening and matching candidates are time-consuming, inefficient, and prone to errors. Furthermore, traditional systems that rely on keyword matching fail to understand the nuances of job descriptions and candidate qualifications, leading to suboptimal hiring decisions.

This inefficiency poses a significant challenge for hiring managers, especially in high-volume or specialized recruitment scenarios, as they struggle to balance time constraints with the need for quality hires. There is a need for a solution that streamlines the recruitment process, enhances accuracy, and saves time and resources while ensuring better hiring outcomes.

TalentSearch addresses this problem by utilizing OpenAI's natural language processing capabilities to provide an AI-driven, scalable approach to talent acquisition.

## Table of Content

- [Problem Statement](#problem-statement-of-group-1---talentsearch)

- [Tech Stack](#tech-stack)

- [OOPs Concepts](#oops-concepts)

- [Class and Function Descriptions](#class-and-function-descriptions)

- [Milestone 2: Functionalities Implemented](#milestone-2-functionalities-implemented)

- [Contributions](#contributions)

- [Milestone 3: Functionalities to be Implemented](#milestone-3-functionalities-to-be-implemented)

- [Project Group Number/Name](#authors-of-group-1)

## Tech Stack

- **Front-End**:

  - **React.js**

- **Back-End**:

  - **Java**: Core language for implementing business logic, encapsulation, and database interaction.

  - **Spring Boot**: To create and manage backend APIs for a scalable, REST-based architecture.
  - **OpenAI API Integration**: Used for natural language processing to analyze resumes and generate scores/feedback.

- **Database**:

  - **MongoDB**: If there’s a need to store unstructured or semi-structured data (e.g., scanned resume content).

- **IDE/Tools**:
  - IntelliJ IDEA/Eclipse/VS Code - For Java development.

## OOPs Concepts

The TalentSearch application implements several core **Object-Oriented Programming (OOP)** concepts, which include:

### 1. Encapsulation

- **Definition**: Encapsulation binds data and methods that manipulate the data into a single unit (class) and restricts direct access to some of the object's components.
- **Implementation**:
  - Classes like `Person`, `HiringManager`, and `Candidate` encapsulate attributes such as `username`, `password`, `jobTitle`, etc., along with getter and setter methods to control access to these properties.
  - Sensitive data like passwords are managed through encapsulation to ensure secure access.

### 2. Inheritance

- **Definition**: Inheritance allows a class to acquire the properties and behaviors of another class.
- **Implementation**:
  - The `HiringManager` and `Candidate` classes inherit from the `Person` class, reusing common attributes like `username` and `emailId`.
  - The `Login` and `Home` classes inherit functionality from the `Database` abstract class, ensuring consistent implementation across database operations.

### 3. Polymorphism

- **Definition**: Polymorphism allows methods to perform different tasks based on the object calling them.
- **Implementation**:
  - **Method Overriding**: Classes like `Login` and `Home` override methods from the abstract `Database` class, providing their specific implementations for database operations such as `connectToDatabase()` or `selectTopCandidates()`.
  - Interfaces like `Validation` allow multiple implementations of methods like `login()`.

### 4. Abstraction

- **Definition**: Abstraction focuses on exposing essential features while hiding implementation details.
- **Implementation**:
  - The `Database` class is abstract and provides a template for methods such as `selectAllCandidates()` and `updateJobDescription()` that must be implemented by derived classes.
  - The interface `Validation` abstracts the concept of user authentication, leaving the implementation to the `Login` class.

### 5. Composition

- **Definition**: Composition involves using objects of one class within another class to achieve functionality.
- **Implementation**:
  - The `Home` class uses objects of `HiringManager`, `Candidate`, and `OpenAI` to perform specific tasks like scanning resumes, fetching top candidates, or updating job descriptions.

### 6. Classes and Objects

- **Definition**: Classes act as blueprints for creating objects, which are instances of the class.
- **Implementation**:
  - Classes such as `HiringManager`, `Candidate`, `OpenAI`, and `ScanResume` represent distinct real-world entities, with their objects being used to interact dynamically within the application.

### 7. Association

- **Definition**: Association establishes a relationship between classes.
- **Implementation**:
  - The `HiringManager` class is associated with the `Home` class to facilitate job description updates.
  - The `Candidate` class interacts with the `OpenAI` class to score and rank resumes.

Some of the other concepts include Lamada Fn, Anonymous Inner Class, Static Method, Stream API, etc

---

These concepts collectively enable the modular, reusable, and maintainable design of the **TalentSearch** application, ensuring robust and scalable functionality.

---

## Class and Function Descriptions

### **Person.java**

The `Person.java` is the baseclass that will be extended by the `HiringManager.java` and the `Candidate.java` class.

### **HiringManager.java**

The `HiringManager.java` class will be used to create the object for the Hiring Manager. It extends the `Person.java` class.

### **Candidate.java**

The `Candidate.java` class will be used to create the object for the Candidate. It extends the `Person.java` class.

### **Driver.java**

This is the starting point of the application which will call the static `start()` from the **Application.java** class.

### **Application.java**

The Hiring Manager's credential will be accquired. The `getUserName` and `getPassword` varaiables are used to get username and password from the user.

#### **public void start()** method from Application.java

The `start()` method will call the **Login.java**'s static static `login()` method by passing `getUserName` and `getPassword`.

### **Validation.java**

The `Validation.java` interface will have `username` and `password` String variables and a static `login()` which has to be implemented by the `Login.java` class implementing this interface.

### **Database.java**

This abstract class is used to contain the methods that are used to perform operations in the database. This abstract class implements the **Validation.java** interface.

#### **public boolean connectToDatabase()** method from Database.java

The `connecToDatabase()` will be used to connect from the **Login.java** class as well as from the **Home.java** class to the database.

### **Login.java**

The `Login.java` has been inherited from the abstract class **Database.java** which further implements the **Validation.java** interface. The `Login.java` implements the `login()` from the **Validation.java** interface and the `connectToDatabase()` from the **Database.java** abstract class.

#### **public static void login(username,password)** method from Login.java

The `public static void login(username,password)` method will use the `connectToDataBase()` from the **Database.java** abstract class to connect to the database. If the connection is successfull, it will authenticate the user with the given username and password. If the authentication is successfull, it will call the **Home.java**'s `displayMenu()` method. If the authentication fails, it will print the error message and get back to `Application.java`'s `start()` to ask for the username and password again.

#### **Display.java**

The `Display.java` method will display the menu to the user. Based on the choice entered by the user, the corresponding method will be called. The Hiring Manager object accquired as to update the job description for the relevant hiringManager. If the user chooses update job description, the user will be asked to enter the new job description. The new job description will be updated in the database.

#### **public List<Candidate> selectAllCandidates(HiringManager manager)**

The `selectAllCandidates()` extended from the abstract `Database.java` class will be used to select all the candidates for the relevant job. The candidates will be selected from the database by mapping the candidate's applied job description with the hiring manager's job description.

#### **public List<Candidate> selectTopCandidates(HiringManager manager)**

The `selectTopCandidates()` extended from the abstract `Database.java` class will be used to select the top candidates for the relevant job. The candidates will be selected from the database by mapping the candidate's applied job description with the hiring manager's job description. All the candidate's resume will be scanned using the `ScanResume`'s `scanResume()` which will return the content of the resume in a String format which will be sent to the `OpenAI.java` class to get the candidate's score. The candidate's score and feedback will be sent as a String back which be will be saved along with the candidate's object in the database. Candidates who are having a score will not be sent to OpenAI so that we can save the time for calling OpenAI API. Finally, The candidates will be sorted based on their score in descending order.

#### **public void updateJobDescription(HiringManager manager, String jobDescription)**

The `updateJobDescription()` will accquire the manager object as well as jobDescription and will update the job description in the database. This method has been extended from the abstract `Database.java` class.

### **OpenAI.java**

The `OpenAI.java` class will have the function to calculate the candidate's score and feedback. The candidate's resume content will be sent to the OpenAI API to get the candidate's score and feedback.

#### **public String getScoreAndFeedback(String resume, HiringManager manager)** method from OpenAI.java

The string resume along with the job description and customised prompt will be sent to the OpenAI API to get the candidate's score and feedback. The score and will be returned as a string which will be saved along with the candidate's object in the database.

### **ScanResume.java**

The `ScanResume.java` is used read and process of candidate's resume.

#### **public String scanResume(String resume)** method from ScanResume.java

The candidate's resume will be scanned and the content will be returned as a string.

## Milestone 2: Functionalities Implemented

By the end of Milestone 2, the following goals were achieved:

1. **Login and Authentication**:

   - The `Validation` interface and `Login` class were implemented to authenticate hiring managers using their username and password.

2. **Database Integration**:

   - Database connectivity was established via the `Database` abstract class.
   - Methods were implemented to fetch all candidates, fetch top candidates, and update job descriptions.

3. **Candidate Management**:

   - The `Candidate` class was developed to manage candidate profiles, including attributes like score, feedback, and job description.

4. **Job Description Management**:

   - The `Display` class was enabled to update and retrieve job descriptions.

5. **Resume Scanning and Scoring**:

   - The `ScanResume` class was integrated to process resumes.
   - The `OpenAI` API was utilized for candidate scoring and feedback generation.

6. **Driver Program**:

   - The `Driver` class was developed to serve as the entry point for initializing and running the application.

7. **Display**:

   - Display functionalities were developed to enhance the user interface and present candidate-related information clearly.

## Contributions

Although everyone contributed collaboratively throughout the project, the following highlights some of the key roles and individual contributions:

- The **Code Snippets** are attached with group members name on the file.

### Team Members and Their Contributions

1. **Jayanth Mani**

   - Worked on displaying the candidate functions based on the program-specific output.
   - Contributed to implementing functionalities that provide clear and interactive output to hiring managers.

2. **Adharsh Rengarajan and Xindo Fan**

   - Collaboratively worked on the `Resume Scanning` functionality.
   - Integrated the `OpenAI` API to enhance candidate scoring and feedback generation.

3. **Zuoyu Wang and Sai Kalyan**
   - Handled the `Database Integration` to establish connectivity and operations.
   - Initialized fundamental classes like `Person`, `Login`, and `Validation` to build the application's core framework.

## Milestone 3: Functionalities to be Implemented

### **Integration**

- Seamlessly integrate the frontend and backend components for real-time interaction.
- Establish a secure connection between the database and backend APIs.
- Enhance the OpenAI API integration to handle edge cases and improve resume analysis.

### **Validation**

- Implement robust input validation across all forms, ensuring data consistency.
- Validate login credentials with stricter security measures.
- Add runtime checks for API responses to prevent errors during operations.

### **Testing**

- Perform unit testing for all major classes and methods, including:
  - Candidate scoring and feedback generation.
  - Login and authentication processes.
- Conduct integration testing for frontend-backend interactions.
- Carry out system testing to ensure the complete application works as expected under different scenarios.

### **Deployment**

- Set up an automated testing and deployment.
- Ensure the application is accessible with proper configuration for scaling and security.

## Authors of Group 1

- [Jayanth Mani](mani.j@northeastern.edu)
- [Sai Kalyan Burra](burra.sa@northeastern.edu)
- [Xinduo Fan](fan.xind@northeastern.edu)
- [Zuoyu Wang](wang.zuoy@northeastern.edu)
- [Adharsh Rengarajan](rengarajan.ad@northeastern.edu)
