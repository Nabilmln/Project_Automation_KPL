Project_Automation_KPL
This repository contains an Appium-based automation testing project for the hnTicket Android application, developed as part of the Final Project (UAS) for the Software Quality Assurance course (KPL). The project automates key user flows, including login, registration, ticket purchasing, and cancellation, using Java and Appium.
Table of Contents

Project Overview
Prerequisites
Setup Instructions
Running the Tests
Project Structure
Test Cases
Contributing
License

Project Overview
The hnTicket application is a mobile ticketing platform. This project automates its testing using Appium, a cross-platform mobile automation tool. The tests are written in Java, use Maven for dependency management, and run on an Android emulator. The automation covers critical functionalities such as user authentication, ticket booking, and cancellation, ensuring the app's reliability.
Prerequisites
Before running the project, ensure you have the following installed:

Java: JDK 21 (or compatible version)
Maven: 3.8.6 or later
Eclipse IDE: 2023-09 or later
Android Studio: 2023.1.1 (Hedgehog) or later
Appium: 2.x (via npm)
Node.js: 16.x or later (for Appium)
Android Emulator: API 35 (Android 15, sdk_gphone64_x86_64)
Appium Java Client: Version 7.6.0
Selenium Java: Version 3.141.59
Git: For cloning the repository

Setup Instructions

Clone the Repository:
git clone https://github.com/Nabilmln/Project_Automation_KPL.git
cd Project_Automation_KPL


Install Appium:
npm install -g appium
appium driver install uiautomator2


Set Up Android Emulator:

Open Android Studio > Tools > Device Manager.
Create an AVD (Medium_Phone_API_35, sdk_gphone64_x86_64, API 35).
Start the emulator and verify:adb devices

Should show emulator-5554 device.


Place hnTicket.apk:

Ensure hnTicket.apk is in the src/ directory (src/hnTicket.apk).
If missing, obtain the APK and place it in C:\Users\USER DK\eclipse-workspace\UAS_KPL\src.


Import Project into Eclipse:

Open Eclipse > File > Import > Maven > Existing Maven Projects.
Select C:\Users\USER DK\eclipse-workspace\UAS_KPL.
Update dependencies:mvn clean install




Start Appium Server:
appium

Ensure it runs on http://127.0.0.1:4723/.


Running the Tests

Open Basics.java:

Navigate to src/test/java/uas/kpl/Basics.java in Eclipse.


Run Tests:

Right-click Basics.java > Run As > Java Application.
In Run Configurations, set Main class to uas.kpl.Basics.
Monitor console output for test results (e.g., "Test 7 - Ticket Cancellation: Passed").


Troubleshooting:

Appium Errors: Check server logs and ensure port 4723 is free.
Emulator Issues: Restart ADB:adb kill-server
adb start-server


Dependency Issues: Run mvn clean install and refresh Eclipse (Right-click project > Maven > Update Project).



Project Structure
UAS_KPL/
├── src/              
│   └── (default package)
│       ├── Basics.java           # Main test class with test cases
│       └── Base.java             # Appium driver setup
|   └── hnTicket.apk              # APK file for the app under test
├── pom.xml                       # Maven dependencies
└── README.md                     # Project documentation


Basics.java: Contains test methods (e.g., navigateToLogin, buyTicket, cancelTicket) using XPath locators and UiScrollable for scrolling.
Base.java: Configures Appium capabilities (e.g., deviceName: emulator-5554, app: src/hnTicket.apk).
pom.xml: Defines dependencies (Appium Java Client 7.6.0, Selenium 3.141.59, SLF4J, Logback, Hamcrest).

Test Cases
The project automates the following scenarios:

Navigate to Login: Clicks the "Explore" button to reach the login page.
Register New Account: Registers a user with name, phone, and password.
Login with Registered Account: Logs in with registered credentials.
Scroll Home Page: Scrolls the home page horizontally using UiScrollable.
Select Movie: Selects a movie from the list.
Buy Ticket: Purchases a ticket with user details, scrolling to the "Buy Ticket" button.
Cancel Ticket: Cancels a ticket from the profile’s ticket history, scrolling to the "Delete" button.
Logout: Logs out from the profile page.

Contributing
Contributions are welcome! To contribute:

Fork the repository.
Create a branch: git checkout -b feature/your-feature.
Commit changes: git commit -m "Add your feature".
Push: git push origin feature/your-feature.
Open a pull request on GitHub.

Please ensure tests pass and follow the existing coding style (XPath locators, Thread.sleep).
License
This project is licensed under the MIT License. See the LICENSE file for details.
