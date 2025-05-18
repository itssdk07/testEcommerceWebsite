# testEcommerceWebsite

Automation testing project for an e-commerce website using **Selenium with Java**, built and managed with **Maven** and powered by the **TestNG** framework. This project validates core user workflows from login to order completion with 20 robust test cases—executed within ~30 seconds.

## Project Overview

This project automates the end-to-end testing flow of an e-commerce platform, ensuring that all critical user journeys are functioning as expected. The test suite covers:

1. Login Functionality  
2. Inventory Page Tests  
3. Cart Tests  
4. Checkout Flow (End-to-End Order Placement)  
5.  Logout Functionality  

## Technologies Used

- Java  
- Selenium WebDriver  
- Maven (Build Management)  
- TestNG (Testing Framework)  

## Installation Instructions

1. Ensure **Java**, **Maven**, and **Selenium WebDriver** are installed on your machine.
2. Clone or download this repository:https://github.com/itssdk07/testEcommerceWebsite.git
3. Open the project in your preferred **IDE** (e.g., IntelliJ IDEA or Eclipse).
4. Install the required dependencies (Maven will handle them via `pom.xml`).
5. Configure and ensure the correct browser driver is set up (e.g., `chromedriver`).
6. Navigate to `pom.xml`, right-click, and select **Run Tests**.


## Usage

- The project contains automated scripts that simulate user interactions with an e-commerce website.
- All 20 test cases execute on a predefined website and validate its key functionality.
- The test suite completes in under 30 seconds, offering quick feedback on the application’s state.

## Learnings

Through building this project, I’ve gained strong practical experience in automation testing, including:

- Implemented **Page Object Model (POM)** design pattern to structure the code efficiently and maintainably.
- Practiced writing clean and reusable test scripts with **TestNG annotations**.
- Explored and applied different **Selenium locators**, **browser navigation techniques**, and **mouse interaction commands**.
- Learned how to configure and manage a Maven-based test automation framework.
- Understood how to simulate and validate end-to-end user workflows in a web environment.
- Currently exploring integration of **AI-driven analysis** to automatically suggest solutions when test cases fail — to assist developers more efficiently.

## Future Scope

- Add **CI/CD integration** with GitHub Actions or Jenkins.
- Extend test coverage to include **edge cases** and **negative scenarios**.
- Implement **AI-based failure analysis** to suggest possible fixes or highlight code changes when test cases fail.
- Add **report generation** (e.g., Allure or Extent Reports) for better visibility of test results.

