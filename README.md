# Spring Boot E-Commerce Application
This project is a Spring Boot-based e-commerce application that allows administrators to manage products securely through a web interface. The application follows the Model-View-Controller (MVC) architecture and integrates key features such as role-based access control, Thymeleaf for form handling, and Spring Boot Actuator for application monitoring.

# Key Features
1. MVC Architecture
   The application is structured using the MVC design pattern.
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
 # Project Setup
   ### Prerequisites
   Java 11 or newer
   Maven
   An IDE (e.g., IntelliJ IDEA, Eclipse)
   Database MySQL
  ### Steps to Run the Application
   #### 1.Clone the repository:
      bash:
      git clone https://github.com/soultef/spring-boot-ecommerce.git
      cd spring-boot-ecommerce
      
   #### 2.Install dependencies:
      mvn clean install

   #### 3.Configure application properties:
      # Example database configuration
      spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce
      spring.datasource.username=root
      spring.datasource.password=root

   #### 4.Run the application:
      mvn spring-boot:run


You can run the application using the following command:

Once the application is running, open your browser and go to:
http://localhost:8080
<!-- These username and password is for development perpose only-->
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
