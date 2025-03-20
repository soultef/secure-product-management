# Spring Boot E-Commerce Application
This project is a Spring Boot-based e-commerce application that allows administrators to manage products securely through a web interface. The application follows the Model-View-Controller (MVC) architecture and integrates key features such as role-based access control, Thymeleaf for form handling, and Spring Boot Actuator for application monitoring.

# Key Features
1. MVC Architecture
   The application is structured using the MVC design pattern.
   Model: Represents the application's data (e.g., Product entities).
   View: HTML views are rendered using Thymeleaf templates.
   Controller: Handles HTTP requests and delegates business logic to services.
2. Product Management
   Secure functionality to create, update, and display products.
   Each product has attributes such as name, price, description, and category.
3. User Roles and Security
   Implement role-based access control (RBAC) with two user roles:
   USER: Can view products.
   ADMIN: Can create, update, and delete products.
   Uses Spring Security to manage authentication and authorization.
4. Thymeleaf Forms
   Thymeleaf is used for creating and rendering forms for product management (e.g., adding and updating products).
   The application provides a user-friendly interface for managing product data.
5. Spring Boot Actuator
   Actuator endpoints are enabled to monitor the health and performance of the application.
   Provides endpoints such as /actuator/health and /actuator/metrics to monitor application metrics.
   Project Setup
   Prerequisites
   Java 11 or newer
   Maven or Gradle (depending on your setup)
   An IDE (e.g., IntelliJ IDEA, Eclipse)
   Database (e.g., H2 for development, MySQL for production)
   Steps to Run the Application
   Clone the repository:

bash
Copy
Edit
git clone https://github.com/your-username/spring-boot-ecommerce.git
cd spring-boot-ecommerce
Install dependencies:

If you're using Maven:

bash
Copy
Edit
mvn clean install
If you're using Gradle:

bash
Copy
Edit
./gradlew build
Configure application properties:

Update application.properties for database connection and other configurations.

properties
Copy
Edit
# Example database configuration
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce
spring.datasource.username=root
spring.datasource.password=root
Run the application:

You can run the application using the following command:

bash
Copy
Edit
mvn spring-boot:run
Or if you're using Gradle:

bash
Copy
Edit
./gradlew bootRun
Access the application:

Once the application is running, open your browser and go to:

plaintext
Copy
Edit
http://localhost:8080
Default User Roles
ADMIN:
Username: admin
Password: admin123
USER:
Username: user
Password: user123
Endpoints
Product Management:

View products: /products
Add product (Admin only): /products/add
Update product (Admin only): /products/{id}/edit
Delete product (Admin only): /products/{id}/delete
Monitoring with Spring Boot Actuator:

Application health: /actuator/health
Metrics: /actuator/metrics
Technologies Used
Spring Boot: For building the back-end application.
Spring Security: For handling authentication and authorization.
Spring Data JPA: For data access and managing products in the database.
Thymeleaf: For rendering dynamic HTML pages.
Spring Boot Actuator: For application monitoring and health checks.
H2/MySQL: For database management.
Contributing
If you'd like to contribute to this project, please fork the repository and create a pull request. Any improvements, bug fixes, or enhancements are welcome!

License
This project is licensed under the MIT License.
