# 🏥 Hospital Management System API

A RESTful backend built with **Spring Boot** for managing hospital staff, focusing on **nurses**, **supervisors**, and **authentication**. This system allows admins to create nurse accounts, supervisors to assign shifts and manage salaries/bonuses, and nurses to view their schedules and financial info.


## 🔐 Authentication

Uses **Spring Security** with authentication via **national ID**. JWT tokens (or session-based, depending on your implementation) are required for protected endpoints.

---

## 🚀 Features

- **Authentication**
  - Admin login
  - Create nurse accounts
- **Nurse Capabilities**
  - View personal shifts
  - View financial info (salary and bonus)
- **Supervisor Capabilities**
  - Assign shifts to nurses
  - Set nurse salary and bonuses

---

## 📡 API Endpoints

### 🔑 `/api/auth`

| Method | Endpoint             | Description                   |
|--------|----------------------|-------------------------------|
| POST   | `/login`             | Admin login                   |
| POST   | `/create-nurse`      | Create a new nurse account    |

> Example `LoginRequest`:
```json
{
  "nationalId": "12345678901234",
  "password": "securePass"
}
```

> Example `CreateNurseRequest`:
```json
{
  "name": "Jane Doe",
  "nationalId": "12345678901234",
  "password": "securePass"
}
```

---

### 👩‍⚕️ `/nurses`

| Method | Endpoint             | Description              |
|--------|----------------------|--------------------------|
| GET    | `/my-shifts`         | View authenticated nurse's assigned shifts |

---

### 🧑‍💼 `/supervisor`

| Method | Endpoint               | Description                    |
|--------|------------------------|--------------------------------|
| POST   | `/assign-shift`        | Assign shift to nurse          |
| POST   | `/set-salary`          | Update nurse salary            |
| POST   | `/set-bonus`           | Update nurse bonus             |
| GET    | `/my-financial-info`   | Get own financial info (for nurse login) |

> Example `NurseShiftRequest`:
```json
{
  "nurseNationalId": "12345678901234",
  "shiftDate": "2025-06-21",
  "shiftTime": "MORNING"
}
```

> Example `NurseCompensationRequest`:
```json
{
  "nurseNationalId": "12345678901234",
  "salary": 8000,
  "bonus": 500
}
```

---

## 🛠 Technologies

- **Java 22**
- **Spring Boot**
- **Spring Security**
- **Lombok**
- **Maven**
- **PostgreSQL** (or any other relational DB)
- **JWT Authentication** (if implemented)
