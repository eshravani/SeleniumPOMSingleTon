# SeleniumPOMSingleTon
Selenium Page Object Model framework with Java, TestNG and Maven
Amazon Automation Project
Overview
This project demonstrates basic automation of Amazon’s website using a Page Object Model (POM) with a singleton framework. It automates functionalities such as retrieving the second-highest price of products, extracting options from dropdown menus, and identifying broken links on the page. The project is built with Maven as the build tool and uses TestNG for test configuration and execution.

Features
Page Object Model (POM): Structured to improve code readability and reusability.
Singleton Framework: Ensures that only a single instance of a class is created, optimizing memory usage.
Automated Functionalities:
Retrieve the second-highest price from a list of products.
Get all options available in dropdown menus.
Find and log broken links on the page.
Properties File: Stores URLs and other configurable data, loaded dynamically at runtime.
Extent Reporting: Provides detailed test reports with execution outcomes.
Jenkins Integration: Configured for continuous integration and testing.
Project Structure
bash
Copy code
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── pages              # Page classes following POM
│   │   │   ├── utils              # Utility classes (e.g., for reading properties)
│   │   ├── resources
│   │   │   └── config.properties  # Configuration file for URL and other properties
│   ├── test
│       ├── java
│       │   ├── tests              # Test classes containing TestNG tests
│       │   └── testng.xml         # TestNG configuration file
│── pom.xml                        # Maven build configuration file
Setup Instructions
Prerequisites
Java 17
Maven
TestNG plugin installed (if running tests in an IDE)
Installation
Clone this repository:
bash
Copy code
git clone https://github.com/yourusername/amazon-automation.git
Navigate into the project directory:
bash
Copy code
cd amazon-automation
Install dependencies using Maven:
bash
Copy code
mvn clean install
Configuration
Modify the config.properties file in src/main/resources to set the base URL and any other configuration parameters.
Running Tests
To execute tests, run:

bash
Copy code
mvn test
Alternatively, you can run tests via TestNG XML:

bash
Copy code
mvn test -DsuiteXmlFile=testng.xml
Reporting
The project is configured with Extent Reports for detailed reporting. Reports are generated in the /test-output/ directory after each test run.

Continuous Integration
This project is integrated with Jenkins CI/CD for automated test execution on each code commit.

Usage
This framework is flexible and can be used to expand API testing on Amazon’s site or other e-commerce sites with minimal modification.
