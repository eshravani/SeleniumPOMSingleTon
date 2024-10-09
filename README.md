# Selenium Page Object Model SIngleTon Design pattern

This project is a basic automation framework for Amazon’s website using the Selenium Page Object Model (POM) with a singleton design pattern. The framework supports test case execution for various functionalities such as retrieving the second-highest price of products, extracting options from dropdown menus, and identifying broken links. It’s designed with Maven as the build tool and uses TestNG for configuration and test execution.

## Features

- **Page Object Model (POM)**: Organized code structure to enhance readability and reusability.
- **Singleton Framework**: Ensures a single instance of classes, improving memory efficiency.
- **Automated Functionalities**:
  - Retrieve the second-highest price from a list of products.
  - Extract all options available in dropdown menus.
  - Find and log broken links on the page.
- **Properties File**: Stores URLs and configurable data, loaded dynamically at runtime.
- **Extent Reporting**: Detailed test execution reports.
- **Jenkins Integration**: Continuous Integration setup for automated test execution on code commits.

## Prerequisites
Java 17
Maven
TestNG (plugin required if running tests in an IDE)
Setup Instructions
1. Clone the Repository
bash
Copy code
git clone https://github.com/yourusername/amazon-automation.git
2. Navigate to Project Directory
bash
Copy code
cd amazon-automation
3. Install Dependencies
bash
Copy code
mvn clean install
4. Configuration
Modify the config.properties file located at src/main/resources to set the base URL and other parameters as needed.

Running Tests
Running All Tests
To execute tests, use:

bash
Copy code
mvn test
Running Tests Using TestNG XML
You can also run tests specified in a TestNG XML file:

bash
Copy code
mvn test -DsuiteXmlFile=testng.xml
Reporting
The framework uses Extent Reports for detailed test reports. After each test execution, reports are generated in the /test-output/ directory.

Continuous Integration
The project is integrated with Jenkins for CI/CD, allowing automated test execution on each code commit.

Usage
This framework is flexible and can be expanded for API testing on Amazon or other e-commerce sites with minimal modification.

Contributing
Contributions are welcome! Please feel free to submit a pull request or open an issue.

Note: This is a demo project to showcase automation skills using the Selenium Page Object Model (POM) with a singleton pattern. Amazon’s website and its elements may change over time, requiring updates to selectors or configurations.
