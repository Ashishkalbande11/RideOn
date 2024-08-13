# RideOn 🚖

RideOn is a dynamic taxi booking application developed using Java, Spring Boot, Hibernate, and MySQL. It provides a seamless experience for users to book cabs and receive instant email confirmations. The application is designed to optimize performance and scalability, making it a reliable choice for taxi booking services.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Contributing](#contributing)
- [Contact](#contact)

## Features

- **Dynamic Taxi Booking**: Allows users to book taxis easily with real-time availability.
- **Email Confirmation**: Sends instant email notifications to users upon successful booking.
- **Efficient Database Operations**: Utilizes Hibernate and HQL for optimized database queries.
- **Scalable Architecture**: Designed to handle a growing user base and increased demand.

## Technologies Used

- **Java**
- **Spring Boot**
- **Hibernate**
- **MySQL**
- **REST API**

## Getting Started

### Prerequisites

Before you begin, ensure you have the following installed:

- Java 8 or higher
- Maven
- MySQL
- IDE (e.g., IntelliJ IDEA, Eclipse)

### Installation

1. **Clone the repository:**

    ```bash
    git clone https://github.com/Ashishkalbande11/RideOn.git
    cd RideOn
    ```

2. **Configure the MySQL database:**

    - Create a database named `rideon`.
    - Update the `application.properties` file with your MySQL credentials.

3. **Build the project:**

    ```bash
    mvn clean install
    ```

4. **Run the application:**

    ```bash
    mvn spring-boot:run
    ```

## Usage

Once the application is up and running, you can access the API via `http://localhost:8080`. The API can be tested using tools like Postman or via direct browser requests.

### Example:

- **Book a Taxi:**

    ```http
    POST /my-taxi/book-cab
    ```

    **Payload:**
    ```json
    {
        "source": "string",
        "destination": "string",
        "distanceInKm": 0,
        "customerEmailId": "string",
        "bookingDate": "2024-08-13T03:25:19.990Z"
    }
    ```

## API Endpoints

Here are some of the key API endpoints:

- **/my-taxi/add-customer** - New customer registration.
- **/my-taxi/customer/{email}/trip-bookings** - Get all bookings of customers.
- **/my-taxi/add-driver** - New registration of driver with cab.
- **/my-taxi/driver/{driverId}/trip-booking** - Get all booking of driver.

Refer to the [API documentation](#) for a full list of endpoints and their usage.

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/your-feature-name`).
3. Make your changes.
4. Commit your changes (`git commit -m 'Add some feature'`).
5. Push to the branch (`git push origin feature/your-feature-name`).
6. Create a Pull Request.


## Contact

For any inquiries or feedback, feel free to contact me:

- **Name**: Ashish Kalbande
- **Email**: ashishkalbande60@gmail.com
- **LinkedIn**: [Ashish Kalbande](https://www.linkedin.com/in/ashish-kalbande-0b4786200/)

---

Thank you for checking out RideOn! If you find this project useful, please consider giving it a star 🌟 on GitHub.
