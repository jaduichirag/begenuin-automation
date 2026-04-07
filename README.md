# begenuin-automation
Selenium TestNG Automation Framework for begenuin


# BeGenuin Automation Framework

This project is a Selenium-based automation framework built using **Java, TestNG, and Maven** for testing the BeGenuin web platform.

---

## Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Maven
- WebDriverManager
- Extent Reports

---

## Project Structure
begenuin-automation

│── src/test/java

│ ├── base # BaseTest setup

│ ├── pages # Page Object Model classes

│ ├── tests # Test classes


│ ├── utils # Utilities (Config, Wait)

│

│── testng.xml # Test suite configuration

│── pom.xml # Dependencies


##  Features

- Page Object Model (POM) design
- TestNG test execution
- Centralized configuration
- Dynamic element handling
- Explicit wait implementation
- Cross-browser ready (extendable)

---

## How to Run Tests

```bash
mvn clean test
