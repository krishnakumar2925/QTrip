# QTrip Test Automation Framework

This project is an automated test suite for the QTrip Dynamic Web Application using **Selenium WebDriver**, **TestNG**, and **ExtentReports**. 
It follows a modular framework architecture and includes Singleton WebDriver implementation, parameterized tests, and custom test reporting.
---

## 🧪 Technologies Used

- Java
- Selenium WebDriver
- TestNG
- ExtentReports (v2.40.2)
- Gradle (or Maven)
- Zalenium (for remote grid execution)
- Page Object Model (POM)
---
## ⚙️ Setup Instructions

### Prerequisites
- Java JDK 11+
- Gradle or Maven
- Chrome Browser
- Zalenium (if remote execution is required)
---
📂 Report Path: Reports/report.html

Key Features

✅ Singleton pattern for both WebDriver and Report
✅ Parameterized tests using TestNG's DataProvider
✅ Screenshots on failure
✅ Dynamic test logging via ExtentReports
✅ Easy configuration of environment and browser
✅ POM Design for maintainability
✅ Docker-ready Zalenium for cross-browser execution

Troubleshooting

NullPointerException in Tests
Ensure DriverSingleton.getDriver() returns a valid driver instance.
Check that you do not call driver.get() or similar methods before initializing the driver.
Make sure you're not flushing ExtentReports too early in your test cycle (@AfterMethod vs @AfterSuite).

Extent Report Not Generating?
Confirm the config path: extent_customization_configs.xml
Check that Reports/ folder exists and is writable.
Don’t flush too early; call flush() only once per test method via endTest()





