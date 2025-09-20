"# PatientManagementSystem"

**Overview of MohanK231/PatientManagementSystem**

The PatientManagementSystem is designed to manage various aspects of patient care and services. The system is modular, consisting of several services that work together to provide a comprehensive solution for patient management. Below is an overview of its goals, main modules, and how they fit together.



**Goals**

The primary goals of the PatientManagementSystem include:



**Patient Management:** To provide functionalities for managing patient records, including creation, updates, and retrieval of patient information.

Billing Services: To handle billing and payment processes associated with patient care.

Security: To ensure secure access and management of sensitive patient data through authentication and authorization mechanisms.

Analytics: To gather and analyze data related to patient care and service usage for better decision-making.

**Main Modules**

The system is divided into several key modules, each responsible for specific functionalities:

**Patient Service**

Path: patient-service/src/main/java/com/pm/patientservice

Description: Manages patient records, including creating, updating, and retrieving patient information. It includes controllers, services, and data transfer objects (DTOs) for handling patient data.

**Billing Service**

Path: billing-service/src/main/java/com/pm/billingservice

Description: Responsible for managing billing processes, including generating invoices and processing payments. It integrates with the patient service to link billing information with patient records.

**Analytics Service**

Path: analytics-service/src/main/java/com/pm/analyticsservice

Description: Collects and analyzes data from the patient and billing services to provide insights into patient care and service efficiency.

**API Gateway**

Path: api-gateway/src/main/java/com/pm/apigateway

Description: Acts as a single entry point for all client requests, routing them to the appropriate service. It also handles cross-cutting concerns such as authentication and logging.

**Security Service**

Path: security-service/src/main/java/com/example/securityservice

Description: Manages user authentication and authorization, ensuring that only authorized personnel can access sensitive patient data.

**Infrastructure**

Path: infrastructure/src/main/java/org/pm/stack

Description: Provides the necessary infrastructure for deploying and managing the services, including configuration and deployment scripts.

**Integration Tests**

Path: integration-tests/src/main/java/org/pm
Description: Contains tests to ensure that the various services work together as expected, validating the overall functionality of the system.

How They Fit Together

The modules are designed to work together in a microservices architecture:
In this project, multiple microservices are implemented, each responsible for a specific domain. Here's how they interact with each other and the database usage:

**Service Interactions**
**API Gateway** (api-gateway/src/main/java/com/pm/apigateway/ApiGatewayApplication.java):

Acts as the entry point for client requests.
It routes requests to the appropriate microservices (e.g., Patient Service, Billing Service, etc.).

**Patient Service** (patient-service/src/main/java/com/pm/patientservice/PatientServiceApplication.java):

Manages patient-related operations.
Uses a JPA Repository (patient-service/src/main/java/com/pm/patientservice/repository/PatientRepository.java) to interact with the database. The repository extends JpaRepository, which provides CRUD operations for the Patient entity.
The database used is likely a relational database (e.g., PostgreSQL, MySQL) since JPA is typically used with relational databases.

**Billing Service** (billing-service/src/main/java/com/pm/billingservice/BillingServiceApplication.java):

Handles billing-related operations.
Implements a gRPC service (billing-service/src/main/java/com/pm/billingservice/grpc/BillingGrpcService.java) to create billing accounts.
It communicates with the Patient Service via gRPC, allowing for efficient inter-service communication.

**Analytics Service** (analytics-service/src/main/java/com/pm/analyticsservice/AnalyticsServiceApplication.java):

Consumes events related to patients using Kafka (analytics-service/src/main/java/com/pm/analyticsservice/kafka/KafkaConsumer.java).
It listens to a Kafka topic named "patient" to process patient events for analytics purposes.

**Security Service** (security-service/src/main/java/com/example/securityservice/SecurityServiceApplication.java):

Manages authentication and authorization.
Provides endpoints for login and token validation (security-service/src/main/java/com/example/securityservice/controller/AuthController.java).
It likely uses a database to store user credentials and roles.

**Patient Service:**

Uses a relational database through JPA for storing patient information.
The PatientRepository interface allows for operations like checking if a patient exists by email.

**Billing Service:**

The database usage is not explicitly mentioned in the provided files, but it may also use a relational database or another storage mechanism depending on the implementation.
Security Service:

Likely uses a database to manage user accounts and authentication tokens.

**Summary**
Inter-Service Communication: The services communicate through HTTP (API Gateway to services) and gRPC (Patient Service to Billing Service). The Analytics Service consumes events from Kafka.
Database: The Patient Service uses a relational database via JPA, while the Billing and Security Services may also use databases.
