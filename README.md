# AuthSystem

## 📌 Project Overview
AuthSystem is a **User Authentication System** built with **Spring Boot (Backend)**, **MySQL (Database)**, and **HTML, CSS, JavaScript (Frontend)**. This system allows users to **sign up, log in, and receive email confirmation** upon successful registration.

## 🚀 Features
- **User Registration (Sign Up)** with validation using **DTO and Validator**.
- **Login System** with validation.
- **Password Validation**
- **Email Verification** on sign-up.
- **Frontend with HTML, CSS, JavaScript**.
- **Backend with Spring Boot** (Spring Jpa, DTO, and Validator).
- **MySQL Database** for storing user credentials securely.

## 🏗️ Tech Stack
### 🔹 Backend (Spring Boot)
- **Spring Boot** (REST API)
- **Spring Data JPA** (Database Handling)
- **DTO & Validator** (Data Validation)
- **JavaMailSender** (Email Service)
- **Lombok** (Simplify Java Code)

### 🔹 Frontend
- **HTML, CSS, JavaScript** (User Interface & Validation)

### 🔹 Database
- **MySQL** (User Data Storage)

## 🛠️ Setup & Installation
### 🔹 Prerequisites
- **Java 17+** installed
- **Spring Boot & Maven** installed
- **MySQL Server** running

### 🔹 Clone the Repository
```sh
https://github.com/GARALAJEET/authSystem.git
```

### 🔹 Configure MySQL Database
Update `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/authsystem
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your-email@gmail.com
spring.mail.password=your-email-password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

### 🔹 Run the Backend
```sh
mvn spring-boot:run
```

### 🔹 Open Frontend
1. Navigate to `frontend/` directory.
2. Open `index.html` in a browser.

## 📜 API Endpoints
### 🔹 User Registration (Sign Up)
**POST** `/api/Home/signup`
```json
{
  "name": "John Doe",
  "email": "john@example.com",
  "password": "Password123@"
}
```

### 🔹 User Login
**POST** `/api/Home/login`
```json
{
  "email": "john@example.com",
  "password": "Password123@"
}
```

## 📝 Validations
- **Name:** Required, min 3 characters.
- **Email:** Must be a valid format.
- **Password:** Must be **6-14 characters**,

## 📩 Email Confirmation
- After registration, a confirmation email is sent.
- Users must verify their email before logging in.

## 📷 Screenshots
(Add screenshots of UI and API responses here)

## 📌 Future Enhancements
- **Forgot Password & Reset Password**
- **Two-Factor Authentication (2FA)**
- **OAuth (Google, GitHub) Login**

---
Made with ❤️ by Jeet Garala

📧 Contact: jeetgarala2603@gmail.com

