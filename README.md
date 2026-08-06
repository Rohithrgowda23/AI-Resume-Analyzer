# AI Resume Analyzer

An AI-powered Resume Analyzer that helps job seekers evaluate and improve their resumes using Google's Gemini AI. The application analyzes uploaded resumes, calculates ATS compatibility, extracts technical skills, provides personalized improvement suggestions, and recommends relevant jobs based on the candidate's profile.

## ✨ Features

* AI-powered resume analysis using Gemini AI
* ATS (Applicant Tracking System) score generation
* Resume improvement suggestions
* Technical skill extraction
* Job recommendations using the Adzuna API
* Secure JWT Authentication
* Google OAuth Login
* Email OTP verification using Brevo
* Resume upload and management
* Previous resume history
* Responsive React user interface

## 🛠️ Tech Stack

### Backend

* Java 17
* Spring Boot 3
* Spring Security
* JWT Authentication
* Spring Data JPA
* Hibernate
* MySQL (Aiven)
* Maven

### Frontend

* React 19
* Vite
* React Router
* JavaScript
* CSS

### AI & External APIs

* Google Gemini AI
* Adzuna Job Search API
* Brevo Email API
* Google OAuth 2.0

## 📂 Project Structure

```
AI-Resume-Analyzer
│
├── ResumeBackend
│   ├── src
│   ├── pom.xml
│   └── Dockerfile
│
├── ResumeFrontend
│   ├── src
│   ├── package.json
│   └── Dockerfile
│
└── README.md
```

## 🚀 Getting Started

### Clone the repository

```bash
git clone https://github.com/your-username/AI-Resume-Analyzer.git
```

### Backend

```bash
cd ResumeBackend
./mvnw spring-boot:run
```

### Frontend

```bash
cd ResumeFrontend
npm install
npm run dev
```

## 🔐 Environment Variables

Configure the following environment variables before running the application:

* DB_URL
* DB_USERNAME
* DB_PASSWORD
* BREVO_API_KEY
* GEMINI_API_KEY
* GOOGLE_CLIENT_ID
* GOOGLE_CLIENT_SECRET
* ADZUNA_APP_ID
* ADZUNA_APP_KEY
* JWT_SECRET

## ☁️ Deployment

* **Backend:** Render (Docker)
* **Frontend:** Render or Vercel
* **Database:** Aiven MySQL

## 📌 Future Enhancements

* Resume ranking system
* AI interview preparation
* Resume comparison
* Resume templates
* Company recommendation engine
* AI-generated interview questions
* Multi-language resume support

## 👨‍💻 Author

**Rohith R Gowda**

If you found this project useful, consider giving it a ⭐ on GitHub.
