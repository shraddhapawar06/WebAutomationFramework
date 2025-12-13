# Test Automation Framework



This is a scalable, modular, data-driven UI Test Automation Framework built using Java 21 and TestNG, designed for local + cloud execution (LambdaTest).
It incorporates modern automation engineering practices like:
✔ Page Object Model (POM)
✔ Config-driven execution
✔ Cross-browser testing
✔ Parallel execution
✔ Headless mode
✔ CI-ready structure
✔ Robust reporting & logging


## 🚀About Me
I'm a full stack developer...

Hi, My name is Shraddha Pawar. I have 8 years of Automation testing experience by using technologies  like Selenium Webdriver, Rest Assured.

My major experties is in Java programming language.
## Author

- @shraddhapawar06(https://github.com/shraddhapawar06)

- Email Address : shraddhapawar06@gmail.com
## 🔗 Links

[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/shraddhapawar06)

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/shraddhapawar06/)



## Pre-Requistes

- Few software should be installed before running the automation framework on a machine.
- Java 11 - Environment variable path should be set up correctly
- Maven - path setup should be done


- Download link for Maven- https://maven.apache.org/download.cgi

## Key Features 

- **Java 11 based automation framework**
- TestNG as test runner (parallel execution, grouping,               prioritization)

- Maven CLI parameters for runtime configuration : browser (chrome/firefox/edge),isLambdaTest (true/false),isHeadless (true/false)

- LambdaTest integration for cloud-based cross-browser execution
- Extent Reports for rich HTML reporting
- Log4j for detailed execution-level logging (saved in /Logs)
- Data-driven testing using-OpenCSV (CSV input),GSON (JSON input),Apache POI (Excel input)

- Test data generation using Java Faker
- Page Object Model (POM) for maintainability
- Support for headless execution for faster test runs
- Fully CI/CD-ready (GitHub Actions / Jenkins)

## Technologies used :

- Language :	Java 21
- Test Runner : TestNG
- Build Tool : Maven
- Cloud Execution	: LambdaTest
- Reporting : Extent Reports
- Logging	: Log4j
- Data Driven	: OpenCSV, Apache POI (Excel), GSON (JSON)
- Test Data Generation :	Java Faker
- Browser Automation :	Selenium WebDriver






## Setup Instruction

**Clone the Repository**

```bash
  git clone https://github.com/shraddhapawar06/WebAutomationFramework.git

  cd Test-Automation-WebAutomationFramework
  ```


  **Running tests on LambdaTest**


```bash
  mvn clean test -Dbrowser=chrome -DisLambdaTest=true -DisHeadless=false - X
  ```

  **Running tests on Local machine in headless mode**


```bash
  mvn clean test -Dbrowser=chrome -DisLambdaTest=false -DisHeadless=true - X
```

**Reporting & Logging**

- ExtentReport utility → Creates HTML report and report created at Reports/report.html

- Log4j for detailed execution-level logging (saved in /Logs)

**Integrated the project github actions**

This WebAutomationFramework is Integrated with github actions.
This tests will be executed at 11.30pm IST every day.
The report will be archieved in gh-pages branch.
You can view the html report at https://shraddhapawar06.github.io/WebAutomationFramework/ExtentReport.html

