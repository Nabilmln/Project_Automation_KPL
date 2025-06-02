# Project_Automation_KPL

Automated testing suite for the `hnTicket` Android application using Appium, developed for the Software Quality Assurance (KPL) Final Project (UAS). This project automates user flows such as login, registration, ticket purchasing, and cancellation using Java, Maven, and Appium.

## Table of Contents
- [Project Overview](#project-overview)
- [Prerequisites](#prerequisites)
- [Setup](#setup)
- [Running Tests](#running-tests)
- [Project Structure](#project-structure)
- [Test Cases](#test-cases)
- [Contributing](#contributing)
- [License](#license)

## Project Overview
The `hnTicket` app is a mobile ticketing platform. This project uses Appium to automate functional testing of its core features, ensuring reliability and user experience quality. Tests are executed on an Android emulator and managed via Maven in Eclipse.

## Prerequisites
- Java JDK 21
- Maven 3.8.6+
- Eclipse IDE 2023-09+
- Android Studio Hedgehog (2023.1.1)+
- Appium 2.x (via npm)
- Node.js 16.x+
- Android Emulator (API 35, `sdk_gphone64_x86_64`)
- Git

## Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/Nabilmln/Project_Automation_KPL.git
   cd Project_Automation_KPL
   ```
2. Install Appium and UiAutomator2 driver:
   ```bash
   npm install -g appium
   appium driver install uiautomator2
   ```
3. Configure Android Emulator:
   - In Android Studio, create an AVD (`Medium_Phone_API_35`, API 35).
   - Verify emulator:
     ```bash
     adb devices
     ```
     Ensure `emulator-5554` appears.
4. Place `hnTicket.apk` in `src/` (`src/hnTicket.apk`).
5. Import project into Eclipse:
   - *File* > *Import* > *Maven* > *Existing Maven Projects*.
   - Select project root.
   - Run:
     ```bash
     mvn clean install
     ```
6. Start Appium server:
   ```bash
   appium
   ```
   Confirm it runs on `http://127.0.0.1:4723/`.

## Running Tests
1. Open `src/test/java/uas/kpl/Basics.java` in Eclipse.
2. Run as Java Application:
   - Right-click `Basics.java` > *Run As* > *Java Application*.
   - In *Run Configurations*, set *Main class* to `uas.kpl.Basics`.
3. View console output for test results.

**Troubleshooting**:
- **Appium**: Check `http://127.0.0.1:4723/` and logs.
- **Emulator**: Restart ADB:
  ```bash
  adb kill-server
  adb start-server
  ```
- **Dependencies**: Refresh Eclipse (*Maven* > *Update Project*) after `mvn clean install`.

## Project Structure
```plaintext
Project_Automation_KPL/
├── src/
│   ├── hnTicket.apk              # App under test
│   └── test/java/uas/kpl/
│       ├── Basics.java           # Test cases
│       └── Base.java             # Appium setup
├── pom.xml                       # Maven configuration
└── README.md                     # Documentation
```

- **Basics.java**: Implements test cases with XPath locators and `UiScrollable`.
- **Base.java**: Configures Appium driver (device: `emulator-5554`, app: `src/hnTicket.apk`).
- **pom.xml**: Dependencies (Appium Java Client 7.6.0, Selenium 3.141.59).

## Test Cases
1. **Navigate to Login**: Access login page via "Explore" button.
2. **Register New Account**: Create user with name, phone, password.
3. **Login**: Authenticate with registered credentials.
4. **Scroll Home Page**: Scroll horizontally using `UiScrollable`.
5. **Select Movie**: Choose a movie from the list.
6. **Buy Ticket**: Purchase ticket, scrolling to "Buy Ticket" button.
7. **Cancel Ticket**: Cancel ticket from profile, scrolling to "Delete" button.
8. **Logout**: Log out from profile page.

## Contributing
1. Fork the repository.
2. Create a branch:
   ```bash
   git checkout -b feature/your-feature
   ```
3. Commit changes:
   ```bash
   git commit -m "Add your feature"
   ```
4. Push:
   ```bash
   git push origin feature/your-feature
   ```
5. Open a pull request.

Maintain XPath locators and `Thread.sleep` style.

## License
MIT License. See [LICENSE](LICENSE) for details.