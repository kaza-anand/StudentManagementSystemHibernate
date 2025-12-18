# StudentManagementSystemHibernate

Below is a **professional, detailed, interview-ready README.md** for your project.
You can **copy–paste this directly** into your GitHub repository.

---

# 🎓 Student Management System using Hibernate

## 📌 Project Overview

The **Student Management System** is a **menu-driven Java application** developed using **Hibernate ORM** and **MySQL**.
It allows managing student records along with their subject marks using **One-to-One mapping**, **Hibernate annotations**, and **HQL queries**.

This project demonstrates **real-world Hibernate concepts**, proper project structure, and clean separation of concerns using **Service and Utility classes**.

---

## 🚀 Features

* ➕ Insert student details with marks
* ❌ Delete student by ID (marks deleted automatically using cascade)
* 📄 Retrieve all students
* 🏆 Retrieve **Top N students** based on total marks
* 🔠 Sort students by name
* 📊 Sort students by total marks
* 🏫 Retrieve students by branch (case-insensitive)
* 📋 Menu-driven console application

---

## 🛠 Technologies Used

* **Java** (Core Java)
* **Hibernate ORM (5.x)**
* **MySQL**
* **HQL (Hibernate Query Language)**
* **Maven**
* **Git & GitHub**

---

## 🧱 Project Architecture

```
Student-Management-System-Hibernate
│
├── src/main/java
│   └── com/student/StudentManagementSystemHibernate
│       ├── App.java                # Main menu-driven application
│       ├── Student.java            # Student entity
│       ├── Marks.java              # Marks entity
│       ├── StudentService.java     # Business logic & DB operations
│       └── HibernateUtil.java      # SessionFactory utility
│
├── hibernate.cfg.xml               # Hibernate configuration
├── pom.xml                         # Maven dependencies
└── README.md                       # Project documentation
```

---

## 🗃 Database Design

### Student Table

| Column Name | Description                |
| ----------- | -------------------------- |
| id          | Primary Key                |
| stu_name    | Student Name               |
| stu_branch  | Student Branch             |
| marks_id    | Foreign Key (studentMarks) |

### studentMarks Table

| Column Name | Description      |
| ----------- | ---------------- |
| marks_id    | Primary Key      |
| java        | Java Marks       |
| python      | Python Marks     |
| mysql       | MySQL Marks      |
| js          | JavaScript Marks |

### Relationship

* **One-to-One**
* `Student` → owning side
* Cascade enabled (`CascadeType.ALL`)

---

## ⚙ Hibernate Mapping

```java
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "marks_id")
private Marks marks;
```

---

## 🧠 Important Hibernate Concepts Used

* `@Entity`, `@Table`, `@Id`
* `@OneToOne`, `@JoinColumn`
* `CascadeType.ALL`
* `Session`, `SessionFactory`
* `HibernateUtil` (Singleton SessionFactory)
* HQL Queries
* Transactions

---

## 🧾 Menu Options

```
1. Insert Student
2. Delete Student
3. Get All Students
4. Get Top N Students
5. Sort Students by Name
6. Sort Students by Marks
7. Get Students by Branch
Any other number → Exit
```

---

## 🧪 Sample Output

```
ID: 1
Name: Anand
Branch: CSE
Java: 100
Python: 100
MySQL: 100
JS: 100
-------------------
```

---

## ▶ How to Run the Project

1. Clone the repository

   ```bash
   git clone https://github.com/your-username/Student-Management-System-Hibernate.git
   ```
2. Import into **Eclipse / IntelliJ** as a **Maven Project**
3. Configure **MySQL DB credentials** in `hibernate.cfg.xml`
4. Create required tables in MySQL
5. Run `App.java`

---

## 🧑‍💻 Author

**Jaya Sri Anand**
B.Tech CSE Graduate
Skills: Java, Hibernate, MySQL, Python, HTML, CSS
GitHub: [https://github.com/your-username](https://github.com/your-username)

---

## 🎯 Why This Project is Important

* Demonstrates **real Hibernate usage**
* Shows **clean architecture**
* Useful for **college projects**
* Strong for **interview & resume**
* Covers CRUD + advanced queries

---

## 📌 Future Enhancements

* Update student details
* Pagination
* Branch-wise ranking
* Convert to Spring Boot
* REST API version

---

✅ **This README is recruiter-friendly and professional**
If you want, I can also:

* Customize it for your **resume**
* Improve wording for **interview explanation**
* Create a **project description paragraph** for LinkedIn
