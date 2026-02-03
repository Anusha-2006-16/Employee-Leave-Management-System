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



<img width="959" height="500" alt="image" src="https://github.com/user-attachments/assets/26bbaf25-a4f7-47e7-9847-02f7c51fcd09" />


<img width="1914" height="871" alt="Screenshot 2026-01-17 141311" src="https://github.com/user-attachments/assets/7b6744b0-9519-4192-9031-27de11435964" />


<img width="1319" height="835" alt="Screenshot 2026-01-17 141322" src="https://github.com/user-attachments/assets/ec6176ba-9b75-4108-a3ca-1e04e082516d" />

<img width="1015" height="797" alt="Screenshot 2026-01-17 141335" src="https://github.com/user-attachments/assets/231f3eb3-c39e-4cac-93b5-fc50dcf1d8cb" />

<img width="1919" height="1085" alt="Screenshot 2026-02-03 150424" src="https://github.com/user-attachments/assets/74c4855f-ac00-49f7-a394-0f98ad716708" />

<img width="1919" height="1058" alt="Screenshot 2026-02-03 150434" src="https://github.com/user-attachments/assets/fb5f5d5e-26df-4a3b-b138-e63f00fba9cc" />

<img width="1919" height="1061" alt="Screenshot 2026-02-03 150444" src="https://github.com/user-attachments/assets/e31b4cea-686c-4837-86da-13654444e61f" />

<img width="1919" height="1068" alt="Screenshot 2026-02-03 150500" src="https://github.com/user-attachments/assets/8e58712c-2c61-402f-bc8d-b861622a9386" />

<img width="1915" height="1074" alt="Screenshot 2026-02-03 150508" src="https://github.com/user-attachments/assets/23f8f51d-e6be-490c-bc88-5361e6000a80" />

<img width="1919" height="1059" alt="Screenshot 2026-02-03 150517" src="https://github.com/user-attachments/assets/4b1c7ab1-e75b-4685-b4ae-ddcc54ea4645" />

<img width="1919" height="1058" alt="Screenshot 2026-02-03 150526" src="https://github.com/user-attachments/assets/6f01afb6-8c12-43ae-95ad-fab6fd206983" />

<img width="1914" height="1071" alt="Screenshot 2026-02-03 150544" src="https://github.com/user-attachments/assets/cc4db5e7-30bd-46cf-9cd1-312ef18218e1" />

<img width="1919" height="1084" alt="Screenshot 2026-02-03 150552" src="https://github.com/user-attachments/assets/32b79c2a-a871-4c94-b94e-1a4678a4ac33" />

<img width="1919" height="1065" alt="Screenshot 2026-02-03 150743" src="https://github.com/user-attachments/assets/15640b37-2939-4070-908f-6182aa6df108" />

<img width="1919" height="988" alt="Screenshot 2026-02-03 150755" src="https://github.com/user-attachments/assets/83debd85-4012-44eb-aaea-7e30dd23eaf4" />
