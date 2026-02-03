# Employee-Leave-Management-System
Built a role-based Employee Leave Management System using Spring Boot and Spring Security, enabling secure authentication, leave workflows, and admin oversight.

# Project Name: Employee Leave Management System
Technologies: Java, Spring Boot, Spring Security, Thymeleaf, MySQL
Description:

Developed a full-stack leave management system with role-based access control (Employee, Manager, Admin).

Employees can apply and track their leave requests.

Admins can manage users, assign roles, and view all leave requests.

Implemented secure login with password encryption using BCrypt.

Designed database with JPA/Hibernate for efficient data management.

# Full-stack Implementation

You’re using Spring Boot (backend) + Thymeleaf (frontend) + MySQL (database).

You’ve integrated Spring Security for authentication and role-based authorization.

Core Features

Role-based access control (Admin, Manager, Employee).

Employees can apply for leaves and view past leaves.

Admin can register users and manage roles.

Optional: Manager can approve/reject leaves.

Real-world Relevance

This mimics a common enterprise HR system.

Shows your ability to implement business logic with multiple user roles.

Tech Skills Highlighted

Spring Boot, Spring Security, JPA/Hibernate, Thymeleaf, MySQL.

Authentication & authorization handling.

Employee Leave Management System – Project Flow
1. User Registration

Admin registers users or users self-register.

Role is assigned (EMPLOYEE / MANAGER / ADMIN).

Password is encrypted using BCrypt.

User data is stored in the database.

2. Login & Authentication

User logs in using email and password.

Spring Security authenticates the user.

Based on role, the user is redirected to the correct dashboard:

Employee → /employee/dashboard

Manager → /manager/dashboard

Admin → /admin/dashboard

3. Employee Flow

Employee logs in.

Can:

Apply for leave (start date, end date, reason).

View previously applied leaves with status:

PENDING

APPROVED

REJECTED

4. Manager Flow

Manager logs in.

Can:

View all employee leave requests.

Approve or reject leave requests.

Add comments while taking action.

5. Admin / HR Flow

Admin logs in.

Can:

View all employees and leave requests.

Access leave statistics and reports.

Manage users and roles (optional extension).

6. Security & Access Control

Role-based authorization using Spring Security.

Each role can access only its allowed endpoints.

Unauthorized access is restricted.

7. Data Management

Entities managed using JPA/Hibernate.

Relationships:

One Employee → Many Leave Requests.

Leave status and timestamps are tracked.

Final Touch (What you’re doing now)

Add UI styling (CSS / Bootstrap).

Push code to GitHub with:

Proper README

Screenshots

Clear commit history


RESTful controller design and service layer logic.
