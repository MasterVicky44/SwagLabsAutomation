# Swag Labs Automation Framework

A robust, scalable Selenium test automation framework for [Swag Labs](https://www.saucedemo.com/), built using **Java**, **Selenium WebDriver**, and **TestNG**. 
The framework includes real-world automation features such as custom reporting, retry mechanisms, failure screenshots, and logging support.

---

## ✅ Features

- 🔹 Selenium WebDriver for browser automation  
- 🔹 TestNG for test orchestration  
- 🔹 **ExtentReports** for detailed HTML reports  
- 🔹 **Retry Logic** for flaky test handling  
- 🔹 **Screenshot capture on test failure**  
- 🔹 **Logging utility** for debugging and traceability  
- 🔹 Page Object Model (POM) for clean code structure  [Using PageFactory Design Pattern]
- 🔹 Maven for build and dependency management

---

## 🛠️ Tech Stack

- Java 17+
- Selenium WebDriver
- TestNG
- ExtentReports
- Maven
- Chrome browser (default)
- Log4j (or Java Util Logging) for logs

---


🔄 Retry Logic
Each failed test is retried automatically via a custom TestNG RetryAnalyzer. You can configure the retry count in the utility class.

📜 Logging
Execution logs are generated using a logging utility and saved under the logs/ folder. Helps in debugging test failures efficiently.

📂 Reports & Logs Location
**Artifact	Path**
Extent Report	src/test/resources/Reports/ExtentReport.html
Logs	src/test/resources/logs/SwagLabsTest.log

## 🚀 Getting Started

### ✅ Prerequisites

- Java 17 or higher
- Maven installed
- Chrome browser installed

### ✅ Clone the Repository

1. Clone the Project.
   "git clone https://github.com/your-username/SwagLabs-Test-Automation.git"
2. Run Below command to Run Test case from terminal. 
"mvn clean test -DsuiteXmlFile=testng.xml"
3. To Run From any IDE, make sure all dependency in POM.xml is available in the System and then run testng.xml.
4. Report and logs location are provide above. 



