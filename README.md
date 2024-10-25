# Intelligent Kitchen Inventory Management System

## Introduction

The **Intelligent Kitchen Inventory Management System** is an innovative application designed to streamline kitchen inventory management. This system provides users with tools to efficiently track food items, manage shopping lists, and create personalized meal plans based on nutritional needs. The application aims to minimize food waste while optimizing meal preparation, making it an essential tool for anyone looking to enhance their culinary experience.

## Key Features

- **Dynamic Inventory Management**: Effortlessly add, update, and delete inventory items, with automatic tracking of expiration dates to ensure freshness.
- **Automated Shopping Lists**: Generate shopping lists based on selected recipes and dietary preferences, helping you make informed shopping decisions.
- **BMR Calculation and Menu Recommendations**: Calculate your Basal Metabolic Rate (BMR) based on personal metrics and receive tailored meal suggestions to meet your daily caloric intake.

## Prerequisites

Before you begin, ensure you have the following installed on your machine:

- **Java**: Version 11 or higher
- **Maven**: Version 3.6 or higher

## Getting Started

Follow these steps to set up and run the application on your local machine:

### 1. Clone the Repository

Start by cloning the repository:

```bash
git clone https://github.com/IMESHIN-O/IntelReci-backend.git
```

### 2. Navigate to the Project Directory
```bash
cd ../IntelReci-backend
```

### 3. Build the Project
Use Maven to build the project. This process compiles the code, runs tests, and packages the application into an executable format.

For macOS/Linux users, run:
```bash
./mvnw clean install
```
For Windows users, run:
```bash
mvnw.cmd clean install
```

### 4. Run the Application
After a successful build, launch the application with:

For macOS/Linux users:
```bash
./mvnw spring-boot:run
```
For Windows users:
```bash
mvnw.cmd spring-boot:run
```
### Access the Application
You can access the web-based app through http://3.25.115.176/

## Project Structure

The project follows a standard Maven directory layout:

- **src/**
  - **main/**: Contains the main application code.
    - **java/**: Java source files.
      - **com/example/inventorymanagement/**: The main package containing application logic, divided into:
        - **config/**: Configuration files for application settings.
        - **controller/**: Handles user requests and responses.
        - **model/**: Defines the data structures used in the application.
        - **repository/**: Interfaces for data access.
        - **service/**: Business logic of the application.
        - **util/**: Utility classes and helper methods.
- **test/**: Contains unit tests for ensuring application stability.
