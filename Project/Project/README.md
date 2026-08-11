# Finance School Course Management System

A Spring Boot-based REST API for managing finance courses, instructors, students, modules, and enrollments. The application follows a layered architecture and provides CRUD operations, pagination, filtering, relationship management, exception handling, and AOP-based logging.

---

## Overview

The **Finance School Course Management System** is designed for institutions that provide finance-related education.

The system enables:

- Instructors to create and manage courses
- Students to manage their profiles and enroll in courses
- Courses to be associated with instructors
- Modules and enrollments to be managed efficiently
- Courses and instructors to be searched and filtered
- Large datasets to be retrieved using pagination and sorting
- Application errors to be handled centrally
- Application activities to be monitored through AOP logging

---

## Features

### Instructor Management
- Create instructor
- View all instructors
- View instructor by ID
- Update instructor details
- Delete instructor
- Find instructors by specialization

### Course Management
- Create course
- View all courses
- View course by ID
- Update course details
- Find courses by instructor
- Filter courses by level

### Student Management
- Create student
- View all students
- View student by ID
- Update student details
- Find student by email

### Module & Enrollment Management
- Manage course modules
- Manage student enrollments
- Maintain relationships between students, courses, and instructors

### Pagination & Sorting
- Page number
- Page size
- Sorting
- Total elements
- Total pages
- Paginated content

### Exception Handling
Centralized exception handling using a global exception handler with appropriate HTTP responses such as:

- `200 OK`
- `201 Created`
- `204 No Content`
- `400 Bad Request`
- `404 Not Found`

### AOP Logging
Aspect-Oriented Programming is used to provide application-level logging without mixing logging logic with business logic.

---

## Technology Stack

| Technology | Purpose |
|------------|---------|
| Java | Programming Language |
| Spring Boot | Backend Framework |
| Spring MVC | REST API Development |
| Spring Data JPA | Data Access |
| Hibernate | ORM |
| MySQL | Database |
| Maven | Build & Dependency Management |
| AOP | Logging & Cross-Cutting Concerns |
| Git & GitHub | Version Control |

---

## Architecture

The application follows a layered architecture:

```text
                    Client
                      |
                      v
              +---------------+
              |   Controller  |
              +---------------+
                      |
                      v
              +---------------+
              |    Service    |
              +---------------+
                      |
                      v
              +---------------+
              |  Repository   |
              +---------------+
                      |
                      v
              +---------------+
              |    MySQL      |
              +---------------+
