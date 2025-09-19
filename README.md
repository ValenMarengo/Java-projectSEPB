# 🐾 Veterinary Management System (Java Project)
One of project in my class, got 1.0 grade
## 📌 Overview
This is a Java-based academic project developed as part of the course **Software Engineering and Programming Basic** at TU Chemnitz. The project simulates a basic veterinary management system where patients (animals) are registered, queued, and treated based on urgency and resource availability. The code is implemented using object-oriented programming concept and using unit test from by JUnit5.


### 💬 User Stories

- When a new patient arrives, they are **registered and placed into the anteroom queue**.
- Patients are treated by a **doctor qualified** to handle their specific animal kind (dog, cat, bird, reptile, rodent).
- Doctors are assisted by **assistants** during treatment. For efficient operations, there must be **at least one assistant more than the number of doctors**. If not, treatment times will **double**.
- The clinic handles **emergency cases** with priority over regular ones.
- Once a case is completed, it is removed from the waiting list.
- The simulation tracks **treatment start and end times**, and returns a **log of executed cases** as formatted strings.

---


## 🗂️ Project Structure contain 3 Packages
interface : Provided interfaces
classes : Animal, AnimalKind, Person, Doctor, Assitant, Node, Case, list, Veterinary, Treatment
tests : Unit tests using JUnit5 


## 📝 Documentation
A short documentation PDF is included alongside the `.java` files in the submission, explaining:
- Class responsibilities
- Inheritance and composition usage
- Design decisions
- Edge cases handled during development

## 🎓 Academic Information
- **Course:** Software Engineering and Programming Basic  
- **University:** Technische Universität Chemnitz  
- **Semester:** Winter Semester 2023/2024  

## 👤 Author
- Panatda Pongkasemwiwat
- Student at TU Chemnitz

> ⚠️ This project was completed as part of an academic assignment. All source code was written independently following the examination regulations. Any code generated with AI or online sources is clearly marked with comments.
