# Interview Scheduler Backend

A Spring Boot-based RESTful backend service for scheduling interviews between students and interviewers. It manages availability slots and allows booking interviews based on time and role.

## 🔧 Features

- Add & retrieve availability for students and interviewers
- Book interviews with time overlap checks
- Fetch interviews by student or interviewer
- RESTful APIs with Spring Boot
- CORS-enabled for frontend integration
- In-memory database support (H2) or configurable to MySQL/PostgreSQL

## 🛠️ Tech Stack

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database (default)
- Lombok
- Maven


## 🚀 Getting Started

### Prerequisites

- Java 17+
- Maven

### Clone the repository

```bash
git clone https://github.com/yourusername/interview-scheduler-backend.git
cd interview-scheduler-backend
```

### Run the application

```bash
mvn spring-boot:run
```

> The app will be live at: http://localhost:8080

---

## 📡 API Endpoints

### 🔹 Availability

| Method | Endpoint                         | Description                      |
|--------|----------------------------------|----------------------------------|
| POST   | `/availability/add`             | Add availability for a user      |
| GET    | `/availability/all`             | Fetch all availability slots     |
| GET    | `/availability/role/{role}`     | Fetch slots by role              |

### 🔹 Interview

| Method | Endpoint                                      | Description                             |
|--------|-----------------------------------------------|-----------------------------------------|
| POST   | `/api/interview/book`                        | Book an interview                       |
| GET    | `/api/interview/all`                         | Get all interviews                      |
| GET    | `/api/interview/student/{studentId}`         | Get interviews by student ID            |
| GET    | `/api/interview/interviewer/{interviewerId}` | Get interviews by interviewer ID        |

---

## 🧪 Sample JSON (for testing)

### Availability
```json
{
  "userId": 1,
  "role": "student",
  "startTime": "2025-07-20T10:00:00",
  "endTime": "2025-07-20T11:00:00"
}
```

### Interview Booking
```json
{
  "studentId": 1,
  "interviewerId": 2,
  "startTime": "2025-07-20T10:00:00",
  "endTime": "2025-07-20T10:30:00"
}
```

---

## 🧠 Concepts Implemented

- Conflict-free time slot matching
- Separation of concerns (controller-service-repository)
- RESTful API design
- Role-based availability filtering
- Exception handling

---

## 📎 Future Improvements

- JWT-based authentication & role management
- Frontend integration
- Email notifications for interviews
- Admin dashboard with analytics

---

## 👨‍💻 Author

**Soumyakanta Rout**  
Java | Spring Boot | Full Stack Developer  
🔗 [LinkedIn](https://www.linkedin.com/in/soumyakanta-rout) 

