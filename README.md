# 🐾 Veterinary Management System (Java Project)
Grade:1.0(Excellent)
## 📌 Overview
This is a Java-based academic project was developed as part of the course **Software Engineering and Programming Basic** at TU Chemnitz. It simulates a basic veterinary management system where patients (animals) are registered, queued, and treated based on urgency and resource availability. The project is fully object-oriented and includes automated unit test written with JUnit5.


### 💬 User Stories

- When a new patient arrives, they are **registered and placed into the anteroom queue**.
- Patients are treated by a **doctor autherized** for their specific animal kind (dog, cat, bird, reptile, rodent).
- Doctors are assisted by **assistants** during treatment. If there are not enough assistants **(at least one assistant more than the number of doctors)** treatment times are **doubled**.
- **Emergency cases** receive priority over regular cases.
- Once a case is completed, it is removed from the waiting list.
- The simulation records **treatment start and end times**, and returns a **log of executed cases** as formatted strings.  
Format:  
”$ownerName with $animalName was treated by $doctorName, $treatment, started at: $startingTime ended
at: $finishingTime”  
Example:  
Owner2 with animal2 was treated by Doctor1, emergency, started at: 0 ended at: 60  
Owner5 with animal5 was treated by Doctor2, emergency, started at: 0 ended at: 60  
Owner3 with animal3 was treated by Doctor2, vaccination, started at: 61 ended at: 76  
Owner1 with animal1 was treated by Doctor1, diagnostics, started at: 61 ended at: 106  

---


## 🗂️ Project Structure 
The project contains 3 Packages:
interface : Provided interfaces
classes : Animal, AnimalKind, Person, Doctor, Assitant, Node, Case, list, Veterinary, Treatment
tests : Unit tests using JUnit5


## 📝 Documentation
A short documentation PDF is included alongside the `.java` files in the submission, explaining:
- Class responsibilities
- Inheritance and composition usage
- Design decisions
- Edge cases handled

## 🎓 Academic Information
- **Course:** Software Engineering and Programming Basic  
- **University:** Technische Universität Chemnitz  
- **Semester:** Winter Semester 2023/2024  

## 👤 Author
- Student at TU Chemnitz
