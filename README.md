# Rozgar Backend    
daddad

Rozgar Backend is a Java Spring Boot application designed to serve as an all-in-one platform for customers to hire service providers, from carpenters to technicians and beauticians. The backend provides RESTful APIs for customers and service providers to interact with the platform, manage profiles, list services, make bookings, submit reviews, and more.

## Features

- **`User Authentication`**: Secure user registration and login using JWT tokens.
- **`Profile Management`**: Allows customers and service providers to manage their profiles.
- **`Service Listing`**: Enables service providers to create and manage service listings.
- **`Booking Management`**: Facilitates booking services by customers and management by service providers.
- **`Review and Rating`**: Allows customers to submit reviews and ratings for completed bookings.
- **`Search and Filtering`**: Provides search and filtering capabilities for service listings based on location, service type, availability, etc.
- **`Notification System`**: Supports sending notifications to users for booking confirmations, reminders, etc.
- **`Payment Integration`**: Integrates with payment gateways for processing payments for bookings.

## Technologies Used

- Java
- Spring Boot
- PostgreSQL for the database
- JSON Web Tokens (JWT) for authentication
- Hibernate ORM for database interaction
- Spring Security for access control
- RESTful APIs using Spring MVC

## Setup Instructions

1. **Clone the Repository**:

   ```bash
   git clone https://github.com/legendkartik45/rozgar-backend.git

Certainly! Here's a more detailed API documentation with request payload examples and response structures:

---

# Rozgar Backend API Documentation

This document outlines the RESTful APIs provided by Rozgar Backend for interacting with the platform.

## Base URL

The base URL for all API endpoints is `http://localhost:8080/api`.

## Authentication

To access protected endpoints, you need to include an authentication token in the request headers. Obtain the token by logging in to the system.

### Headers

- `Authorization`: Bearer <token>

## Endpoints

### Users

- **Register User**

  ```http
  POST /users/register
  ```

  Registers a new user with the system.

  **Request Payload:**

  ```json
  {
    "username": "example_user",
    "email": "example@example.com",
    "password": "example_password",
    "userType": "customer"
  }
  ```

  **Response:**

  - `201 Created`: User successfully registered.
  - `400 Bad Request`: Missing or invalid parameters.

- **Login User**

  ```http
  POST /users/login
  ```

  Authenticates a user and generates a JWT token for subsequent requests.

  **Request Payload:**

  ```json
  {
    "email": "example@example.com",
    "password": "example_password"
  }
  ```

  **Response:**

  - `200 OK`: User successfully logged in. Response includes JWT token.
  - `401 Unauthorized`: Invalid credentials.

### Profiles

- **Get User Profile**

  ```http
  GET /profiles/{userId}
  ```

  Retrieves the profile of the specified user.

  **Response:**

  ```json
  {
    "userId": "123",
    "username": "example_user",
    "email": "example@example.com",
    "userType": "customer",
    "profile": {
      "firstName": "John",
      "lastName": "Doe",
      "phoneNumber": "+1234567890"
    }
  }
  ```

  - `200 OK`: Profile successfully retrieved.
  - `404 Not Found`: User not found.

- **Update User Profile**

  ```http
  PUT /profiles/{userId}
  ```

  Updates the profile information of the specified user.

  **Request Payload:**

  ```json
  {
    "firstName": "John",
    "lastName": "Doe",
    "phoneNumber": "+1234567890"
  }
  ```

  **Response:**

  - `200 OK`: Profile successfully updated.
  - `400 Bad Request`: Missing or invalid parameters.
  - `404 Not Found`: User not found.

### Services

- **Create Service Listing**

  ```http
  POST /services
  ```

  Creates a new service listing.

  **Request Payload:**

  ```json
  {
    "serviceType": "Carpenter",
    "description": "Provide carpentry services.",
    "price": 50.00,
    "availability": "Monday to Friday, 9:00 AM to 5:00 PM",
    "location": "City, Country"
  }
  ```

  **Response:**

  - `201 Created`: Service listing successfully created.
  - `400 Bad Request`: Missing or invalid parameters.

- **Get Service Listing**

  ```http
  GET /services/{serviceId}
  ```

  Retrieves the details of a specific service listing.

  **Response:**

  ```json
  {
    "serviceId": "123",
    "serviceType": "Carpenter",
    "description": "Provide carpentry services.",
    "price": 50.00,
    "availability": "Monday to Friday, 9:00 AM to 5:00 PM",
    "location": "City, Country"
  }
  ```

  - `200 OK`: Service listing successfully retrieved.
  - `404 Not Found`: Service listing not found.

### Bookings

- **Book Service**

  ```http
  POST /bookings
  ```

  Books a service for a customer.

  **Request Payload:**

  ```json
  {
    "serviceId": "123",
    "bookingDateTime": "2024-05-15T10:00:00",
    "additionalNotes": "Bring your own materials."
  }
  ```

  **Response:**

  - `201 Created`: Booking successfully created.
  - `400 Bad Request`: Missing or invalid parameters.
  - `404 Not Found`: Service listing not found.

- **Get Bookings**

  ```http
  GET /bookings?userId={userId}
  ```

  Retrieves the bookings made by the specified user.

  **Response:**

  ```json
  [
    {
      "bookingId": "123",
      "serviceId": "456",
      "bookingDateTime": "2024-05-15T10:00:00",
      "additionalNotes": "Bring your own materials.",
      "status": "Confirmed"
    }
  ]
  ```

  - `200 OK`: Bookings successfully retrieved.

### Reviews

- **Submit Review**

  ```http
  POST /reviews
  ```

  Submits a review for a completed booking.

  **Request Payload:**

  ```json
  {
    "bookingId": "123",
    "rating": 5,
    "comment": "Excellent service provided."
  }
  ```

  **Response:**

  - `201 Created`: Review successfully submitted.
  - `400 Bad Request`: Missing or invalid parameters.
  - `404 Not Found`: Booking not found.

- **Get Reviews**

  ```http
  GET /reviews?userId={userId}
  ```

  Retrieves the reviews submitted by the specified user.


