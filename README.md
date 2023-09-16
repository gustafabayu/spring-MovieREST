Overview
This project is a Java Spring Boot application that provides a RESTful API for managing movie data. It includes endpoints for listing, retrieving, adding, updating, and deleting movies. The API uses PostgreSQL as the database for storing movie information.

Prerequisites
Before you begin, ensure you have met the following requirements:
- Java Development Kit (JDK) 17 or higher installed.
- Apache Maven installed.
- PostgreSQL database server installed and running.
- Your PostgreSQL database credentials (username and password).

Getting Started
To get started with this project, follow these steps:

1. Clone the repository to your local machine:
git clone https://github.com/your-username/movie-api.git

2. Navigate to the project directory:
cd movie-api

3. Configure the database settings in src/main/resources/application.properties or src/main/resources/application.yml (See Database Configuration).

4. Build the project:
mvn clean install

5. Run the application:
mvn spring-boot:run

The API should now be running locally at http://localhost:8080.
