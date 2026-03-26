# Cloud Security Gateway 🛡️

A high-performance, stateless API Gateway built with **Spring Cloud Gateway** and **Spring WebFlux**. This project acts as the security perimeter for a microservices architecture, implementing JWT-based authentication at the edge.

## 🚀 Key Features
- **Edge Authentication:** Centralized JWT validation using a custom `GatewayFilter`.
- **Reactive Architecture:** Built on **Project Reactor (Netty)** for non-blocking, high-concurrency request handling.
- **Stateless Security:** Configured with `Spring Security` to be fully stateless (no sessions/cookies).
- **Dynamic Routing:** Decouples client requests from internal microservice locations.

## 🏗️ Architecture
The Gateway acts as a "Reverse Proxy." Every request must pass through a security filter chain before being routed to the downstream services (e.g., Order Service).



## 🛠️ Tech Stack
- **Java 17**
- **Spring Boot 3.2.5**
- **Spring Cloud 2023.0.0** (Leyton Release Train)
- **jjwt (Java JWT)** for digital signature verification.

## ⚙️ How It Works
1. **Intercept:** The `AuthenticationFilter` intercepts the `Authorization` header.
2. **Validate:** `JwtUtils` re-calculates the HMAC-SHA signature using a shared secret.
3. **Route:** If valid, the request is proxied to the target microservice defined in `application.yml`.
4. **Reject:** Invalid or missing tokens receive a `401 Unauthorized` response immediately.

## 🚦 Getting Started
1. Clone the repository.
2. Ensure your Order Service (or any backend) is running on `http://localhost:8080`.
3. Run the gateway:
   ```bash
   ./mvnw spring-boot:run