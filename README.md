\# Microservices Flow: User Registration \& Email Event-Driven



This project is a practical demonstration of a scalable microservices architecture built with \*\*Java 25\*\* and \*\*Spring Boot 3.5\*\*. The primary goal was to consolidate expertise in asynchronous communication and infrastructure orchestration using Docker.



The workflow simulates a standard integration pattern: a user registration route in `ms-user` that triggers an event via \*\*RabbitMQ\*\* to an `ms-email` service responsible for processing and final delivery.



---



\## 🚀 Tech Stack



| Category | Technology |

| :--- | :--- |

| \*\*Language\*\* | Java 25 (LTS) |

| \*\*Framework\*\* | Spring Boot 3.5.9 |

| \*\*Messaging\*\* | RabbitMQ (Message Broker) |

| \*\*Database\*\* | PostgreSQL 15 |

| \*\*Migrations\*\* | Flyway |

| \*\*Container\*\* | Docker \& Docker Compose |

| \*\*Build Tool\*\* | Maven |



---



\## 🛠️ Architectural Pillars



This project was designed as an infrastructure laboratory, prioritizing the following engineering principles:



\### 1. Asynchronous Communication \& Resilience

Utilizes RabbitMQ to ensure that the user registration service remains independent of the email service's availability (Decoupling). This architecture prevents cascading failures and manages traffic spikes through message queuing.



\### 2. Data Governance (Flyway)

Database schema control is handled by \*\*Flyway\*\*. This ensures the database is versioned, auditables, and independent of Hibernate's `ddl-auto` lifecycle, providing a professional approach to production-ready database management.



\### 3. Persistence \& Timezone Synchronization

\* \*\*Named Volumes:\*\* Configured Docker volumes to ensure PostgreSQL data persists even after running `docker-compose down`.

---



\## 💻 Developer Experience (DX) \& Setup



The project is structured to support both a full stack deploy and a high-speed local development workflow.



\### Prerequisites

\* Docker and Docker Compose installed.

\* JDK 25 (if running services locally outside of Docker).



\### Configuration

Create a `.env` file in the root directory based on the following model:



```env

\# Database

DB\_USER=postgres

DB\_PASSWORD=your\_password

DB\_PORT=5432



\# RabbitMQ

RABBIT\_USER=guest

RABBIT\_PASS=guest



\# Email Credentials (App Password)

MAIL\_USER=your\_email@gmail.com

MAIL\_PASSWORD=your\_app\_password

```



\### Execution Modes



\*\*A) Full Stack Mode (Docker Only):\*\*

To spin up the entire infrastructure and applications:

```bash

docker-compose up -d --build

```



\*\*B) Infra-Only Mode (Recommended for Development):\*\*

Spin up only the Database and the Message Broker, allowing you to run and debug the microservices directly from your IDE for a faster feedback loop:

```bash

docker-compose up -d postgres rabbitmq

```



---



\## 🧪 Testing the Flow



Once the stack is up, you can validate the registration and the event trigger using the following command:



```powershell

curl -X POST http://localhost:8081/users `

&nbsp;    -H "Content-Type: application/json" `

&nbsp;    -d '{"name": "Developer Name", "email": "dev@example.com"}'

```



\*\*What to verify:\*\*

1\. \*\*HTTP Status 201:\*\* Created user JSON returned by `ms-user`.

2\. \*\*Logs:\*\* Check `ms-email` logs to see the message being consumed from the broker.

3\. \*\*Persistence:\*\* Use a database client (like DBeaver) to verify the `users` and `emails` tables in their respective databases.



---



\## ⚠️ Disclaimer

This project is strictly for \*\*architectural and infrastructure educational purposes\*\*. Complex business logic, exhaustive validations, or advanced security layers were intentionally omitted to keep the focus on service integration and infrastructure resilience.

