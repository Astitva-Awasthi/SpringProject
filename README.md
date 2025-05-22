
# Jira Clone – Spring Boot Project

A simplified Jira-like issue tracking system built using **Spring Boot**. This backend application manages projects, issues, sprints, and user assignments — emulating core functionalities of Atlassian's Jira.

---

## ✨ Features

- **Project Management**: Create, update, and delete projects.
- **Issue Tracking**: Manage issues with statuses like `TO_DO`, `IN_PROGRESS`, and `DONE`.
- **User Management**: Create users and assign them to issues or projects.
- **Sprint Management**: Create sprints and associate issues with them.
- **Issue-Sprint Mapping**: Link multiple issues to a sprint (many-to-many support).
- **Role-Based Access Control** (Planned): Differentiate access by roles (e.g., Admin, Developer).
- **RESTful APIs**: Clean and scalable REST endpoints for frontend or integrations.

---

## 🛠 Technologies Used

- Java 8+
- Spring Boot
- Spring Data JPA (Hibernate)
- MySQL (or any relational DB)
- Maven (for build automation)

---

## 🚀 Getting Started

### ✅ Prerequisites

- Java Development Kit (JDK) 8 or higher
- Maven 3.6+
- MySQL or preferred RDBMS

---

### 🔧 Installation

1. **Clone the repository:**

```bash
git clone https://github.com/Astitva-Awasthi/SpringProject.git
cd SpringProject
```

2. **Configure the database in `application.properties`:**

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/jiraclone
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

3. **Build and run the application:**

```bash
mvn clean install
mvn spring-boot:run
```

Application will start at: [http://localhost:8080](http://localhost:8080)

---

## 📡 API Endpoints

### 🔹 Projects

| Method | Endpoint         | Description              |
|--------|------------------|--------------------------|
| GET    | `/api/projects`  | Get all projects         |
| POST   | `/api/projects`  | Create a new project     |
| PUT    | `/api/projects/{id}` | Update a project   |
| DELETE | `/api/projects/{id}` | Delete a project   |

---

### 🔹 Issues

| Method | Endpoint         | Description              |
|--------|------------------|--------------------------|
| GET    | `/api/issues`    | Get all issues           |
| POST   | `/api/issues`    | Create a new issue       |
| PUT    | `/api/issues/{id}` | Update an issue       |
| DELETE | `/api/issues/{id}` | Delete an issue       |

---

### 🔹 Users

| Method | Endpoint         | Description              |
|--------|------------------|--------------------------|
| GET    | `/api/users`     | Get all users            |
| POST   | `/api/users`     | Create a new user        |
| PUT    | `/api/users/{id}` | Update a user          |
| DELETE | `/api/users/{id}` | Delete a user          |

---

### 🔹 Sprints

| Method | Endpoint         | Description              |
|--------|------------------|--------------------------|
| GET    | `/api/sprints`   | Get all sprints          |
| POST   | `/api/sprints`   | Create a new sprint      |
| PUT    | `/api/sprints/{id}` | Update a sprint      |
| DELETE | `/api/sprints/{id}` | Delete a sprint      |

---

### 🔹 Sprint-Issue Mapping

| Method | Endpoint                                | Description                              |
|--------|------------------------------------------|------------------------------------------|
| POST   | `/api/sprint-issues`                     | Add an issue to a sprint (by ID)         |
| DELETE | `/api/sprint-issues`                     | Remove an issue from a sprint (by ID)    |
| GET    | `/api/sprint-issues/sprint/{sprintId}`   | Get all mappings for a sprint            |
| GET    | `/api/sprint-issues/issue/{issueId}`     | Get all mappings for an issue            |
| GET    | `/api/sprint-issues/full/sprint/{id}`    | Get all full issues in a given sprint    |

---

## 📘 Notes

- Authentication/Authorization (RBAC) is under development.
- For API testing, use Postman or Swagger (you can integrate SpringDoc/OpenAPI).
- Consider adding pagination and filtering for large datasets.

---

## 🤝 Contributing

Contributions are welcome! Fork the repo and submit a pull request with enhancements or bug fixes.

---

## 📄 License

This project is licensed under the **MIT License**. See the [LICENSE](LICENSE) file for details.

---

## 🙏 Acknowledgments

- Inspired by Atlassian’s **Jira** for its robust project and issue tracking capabilities.
