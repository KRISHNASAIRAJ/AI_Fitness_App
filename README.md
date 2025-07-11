Sure! Here's a clean and simple **README.md** formatted for your AI-Fitness project, excluding CI/CD and Docker references:

---

# AI-Fitness 🏋️‍♂️🤖

AI-Fitness is a **Spring Boot microservices-based fitness application** that enables users to register, track their fitness activities, and receive AI-generated recommendations, suggestions, and safety measures based on their activities.
The system follows a **microservices architecture** with inter-service communication handled asynchronously via **RabbitMQ** and uses **Gemini AI** to generate insights.

---

## 📚 Architecture Overview

The AI-Fitness application consists of the following microservices:

| Service Name         | Description                                                                          |
| -------------------- | ------------------------------------------------------------------------------------ |
| **User-Service**     | Handles user registration and validation.                                            |
| **Activity-Service** | Allows users to register fitness activities and publishes them to RabbitMQ.          |
| **AI-Service**       | Consumes activities from RabbitMQ and uses Gemini AI to generate recommendations.    |
| **API Gateway**      | Acts as the single entry point and routes requests to the appropriate microservices. |
| **Eureka Server**    | Manages service discovery for microservices.                                         |
| **Config Server**    | Centralizes and manages external configurations for all microservices.               |

---

## 🛠️ Tech Stack

* **Spring Boot**
* **Spring Cloud Gateway**
* **Spring Cloud Eureka**
* **Spring Cloud Config Server**
* **RabbitMQ** - for asynchronous messaging
* **Gemini AI** - for generating activity-based recommendations
* **Java 21**

---

## 🔁 Core Workflow

1. **User-Service**:

    * Registers users and validates user accounts.
    * Example Endpoint: `POST /v1/users/register`, `GET /v1/users/{id}/validate`

2. **Activity-Service**:

    * Registers user activities and publishes them to RabbitMQ.
    * Example Endpoint: `POST /v1/activities/register`

3. **AI-Service**:

    * Listens to activity events from RabbitMQ.
    * Processes them using Gemini AI to generate:

        * Recommendations
        * Suggestions
        * Safety measures
    * Example Endpoint: `GET /v1/recommendations/{activity}`

4. **API Gateway**:

    * Handles routing based on URI paths.
    * Example Routes:

        * `/v1/users/**` → User-Service
        * `/v1/activities/**` → Activity-Service
        * `/v1/recommendations/**` → AI-Service

5. **Eureka Server**:

    * Registers and discovers all services.

6. **Config Server**:

    * Provides centralized configuration to each microservice.

---

## 🌐 Example API Flow

```
[User] → Register Activity → [Activity-Service] → Send Message to RabbitMQ → [AI-Service] → Fetch AI Recommendations
```

---

## ⚙️ Running the Application (Local Development)

### Prerequisites:

* Java 21
* Maven
* RabbitMQ running locally (default port: 5672)

### Suggested Run Order:

1. Start **Eureka Server**
2. Start **Config Server**
3. Start each microservice (**User-Service**, **Activity-Service**, **AI-Service**)
4. Start **API Gateway**

Access Points:

* **API Gateway:** `http://localhost:8080`
* **Eureka Server:** `http://localhost:8761`
* **RabbitMQ Dashboard:** `http://localhost:15672`

---

## 📄 Example Endpoints (via API Gateway)

| Method | Endpoint                           | Description                            |
| ------ | ---------------------------------- | -------------------------------------- |
| POST   | /v1/users/register                 | Register a new user                    |
| GET    | /v1/users/{id}/validate            | Validate an existing user              |
| POST   | /v1/activities/register            | Register a new activity                |
| GET    | /v1/recommendations/{activityName} | Get AI recommendations for an activity |

---

## 🤝 Acknowledgments

* **RabbitMQ** - Message broker for asynchronous communication.
* **Gemini AI** - AI-generated recommendations and safety insights.
* Spring Cloud Ecosystem.

---
