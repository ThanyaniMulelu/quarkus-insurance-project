# Quarkus Insurance Microservices Project

This project demonstrates a microservices architecture for an insurance company, built using Quarkus. It comprises several independent services: Customer, Policy, Claims, and Quote.

## Project Structure

- `quarkus-insurance-project/`: Parent Maven project.
- `customer-service/`: Manages customer information.
- `policy-service/`: Handles insurance policies.
- `claims-service/`: Manages insurance claims.
- `quote-service/`: Generates and manages insurance quotes.

## Technologies Used

- Java 17+: Programming language.
- **Quarkus**: Cloud-native Java framework for microservices.
- **Maven**: Build automation tool.
- **Hibernate ORM with Panache**: Object-relational mapping for simplified data access.
- **H2 Database**: In-memory database for development and testing.
- **REST APIs**: For inter-service communication.
- **MicroProfile Rest Client**: For invoking RESTful services.

## Installation and Setup (Local)

To set up and run this project locally, follow these steps:
cd policy-service
mvn quarkus:dev

### Prerequisites

- **Java Development Kit (JDK) 17 or higher**: Ensure JDK 17 is installed and configured in your `PATH`.
- **Apache Maven 3.8.x or higher**: Ensure Maven is installed and configured in your `PATH`.

### Steps

1.  **Clone the repository (if applicable):**

    ```bash
    git clone <repository-url>
    cd quarkus-insurance-project
    ```

    _(Note: If you received this project as a zip file, extract it and navigate to the `quarkus-insurance-project` directory.)_

2.  **Build the entire project:**
    Navigate to the root directory of the project (`quarkus-insurance-project/`) and run the Maven build command:

    ```bash
    mvn clean install
    ```

    This command will compile all modules, run tests, and install the artifacts into your local Maven repository. This might take a few minutes on the first run as Maven downloads all necessary dependencies.

3.  **Run individual services:**
    Each service can be run independently. Navigate to the respective service directory and start it using the Quarkus Maven plugin:

    - **Customer Service:**

      ```bash
      cd customer-service
      mvn quarkus:dev
      ```

    - **Policy Service:**

      ```bash
      cd policy-service
      mvn quarkus:dev
      ```

    - **Claims Service:**

      ```bash
      cd claims-service
      mvn quarkus:dev
      ```

    - **Quote Service:**
      ```bash
      cd quote-service
      mvn quarkus:dev
      ```

    Each `mvn quarkus:dev` command will start the service in development mode, enabling live coding and automatic recompilation on code changes.

## API Endpoints (Examples)

Once the services are running, you can access their REST endpoints. By default, Quarkus applications run on port 8080. If you run multiple services simultaneously, they will automatically bind to different ports (e.g., 8081, 8082, etc.) in development mode.

### Customer Service (Example: running on http://localhost:8080)

- `GET /customers`: Get all customers.
- `GET /customers/{id}`: Get customer by ID.
- `POST /customers`: Create a new customer.
- `PUT /customers/{id}`: Update an existing customer.
- `DELETE /customers/{id}`: Delete a customer.

### Policy Service (Example: running on http://localhost:8081)

- `GET /policies`: Get all policies.
- `GET /policies/{id}`: Get policy by ID.
- `POST /policies`: Create a new policy.
- `PUT /policies/{id}`: Update an existing policy.
- `DELETE /policies/{id}`: Delete a policy.

### Claims Service (Example: running on http://localhost:8082)

- `GET /claims`: Get all claims.
- `GET /claims/{id}`: Get claim by ID.
- `POST /claims`: Create a new claim.
- `PUT /claims/{id}`: Update an existing claim.
- `DELETE /claims/{id}`: Delete a claim.

### Quote Service (Example: running on http://localhost:8083)

- `GET /quotes`: Get all quotes.
- `GET /quotes/{id}`: Get quote by ID.
- `POST /quotes`: Create a new quote.
- `PUT /quotes/{id}`: Update an existing quote.
- `DELETE /quotes/{id}`: Delete a quote.
