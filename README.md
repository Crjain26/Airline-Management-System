###  ✈️ AIRLINE MANAGEMENT SYSTEM


A modular **Airline Management System** built in **Java** with **MySQL database** and JDBC connectivity.

It supports:
- Viewing all flights
- Booking flights for customers
- Viewing customer bookings


## ⚙️ Prerequisites

- Java 17+ (JDK installed and added to PATH)
- MySQL Server installed and running
- VS Code with **Java Extension Pack**
- MySQL JDBC Driver (`mysql-connector-j-8.x.x.jar`)


## 🛠 Database Setup

1. Open MySQL CLI or Workbench.
2. Create database and tables:

```
CREATE DATABASE airline_db;
USE airline_db;

CREATE TABLE Flight (
    flight_number VARCHAR(10) PRIMARY KEY,
    source VARCHAR(50),
    destination VARCHAR(50),
    seats INT
);

CREATE TABLE Customer (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE
);

CREATE TABLE Booking (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    flight_number VARCHAR(10),
    FOREIGN KEY (customer_id) REFERENCES Customer(id),
    FOREIGN KEY (flight_number) REFERENCES Flight(flight_number)
);
```

## 🔌 Setup MySQL JDBC Driver

Download JDBC driver from MySQL Connector J.
# Link jar file to VS Code SetUp
> Go To JAVA Projects Below Timeline inside VS Code.

> Add Jar File to Referenced Libraries for JDBC Connectivity.

## 🔑 Configure Database Connection

In DBConnection.java, update your MySQL username/password:

private static final String URL = "jdbc:mysql://localhost:3306/airline_db";
private static final String USER = "root";        // your MySQL username
private static final String PASSWORD = "password"; // your MySQL password


## Now your Airline Management System is ready to run inside VS Code with MySQL backend!
