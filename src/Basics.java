//package uas.kpl;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;

public class Basics extends Base {
    private AndroidDriver<AndroidElement> driver;

    public void setup() throws Exception {
        try {
            System.out.println("Initializing driver...");
            driver = capabilities();
            if (driver == null) {
                throw new RuntimeException("Driver is null after capabilities()");
            }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Thread.sleep(5000);
            System.out.println("Driver initialized successfully");
        } catch (Exception e) {
            System.err.println("Setup failed: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    public void navigateToLogin() throws Exception {
        try {
            System.out.println("Test 1: Navigate to login page...");
            driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.example.hntiket:id/btnExplore']")).click();
            Thread.sleep(2000);
            System.out.println("Test 1 - Navigate to Login: Passed");
        } catch (Exception e) {
            System.err.println("Test 1 failed: " + e.getMessage());
            throw e;
        }
    }

    public void registerNewAccount() throws Exception {
        try {
            System.out.println("Test 2: Register with new account...");
            driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.example.hntiket:id/tvRegister']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.example.hntiket:id/etFullName']")).sendKeys("Muhammad Nabil Maulana");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.example.hntiket:id/etPhone']")).sendKeys("081234567888");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.example.hntiket:id/etPassword']")).sendKeys("password123");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.example.hntiket:id/btnRegister']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.example.hntiket:id/btnGoToLogin']")).click();
            Thread.sleep(2000);
            System.out.println("Test 2 - Register Success: Passed");
        } catch (Exception e) {
            System.err.println("Test 2 failed: " + e.getMessage());
            throw e;
        }
    }

    public void loginWithRegisteredAccount() throws Exception {
        try {
            System.out.println("Test 3: Login with registered account...");
            driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.example.hntiket:id/etPhone']")).sendKeys("081234567888");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.example.hntiket:id/etPassword']")).sendKeys("password123");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.example.hntiket:id/btnLogin']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.example.hntiket:id/btnContinue']")).click();
            Thread.sleep(2000);
            System.out.println("Test 3 - Login Success: Passed");
        } catch (Exception e) {
            System.err.println("Test 3 failed: " + e.getMessage());
            throw e;
        }
    }

//    public void scrollHomePage() throws Exception {
//        try {
//            System.out.println("Test 4: Scroll home page...");
//            // Scroll right
//            driver.findElementByAndroidUIAutomator(
//                "new UiScrollable(new UiSelector().xpath(\"//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]\")).setAsHorizontalList().scrollForward(1)"
//            );
//            Thread.sleep(2000);
//            // Scroll left
//            driver.findElementByAndroidUIAutomator(
//                "new UiScrollable(new UiSelector().xpath(\"//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]\")).setAsHorizontalList().scrollBackward(1)"
//            );
//            Thread.sleep(2000);
//            System.out.println("Test 4 - Scroll Home Page: Passed");
//        } catch (Exception e) {
//            System.err.println("Test 4 failed: " + e.getMessage());
//            throw e;
//        }
//    }

    public void selectMovie() throws Exception {
        try {
            System.out.println("Test 5: Select movie...");
            driver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.example.hntiket:id/imageMovie2']")).click();
            Thread.sleep(2000);
            System.out.println("Test 5 - Movie Selection: Passed");
        } catch (Exception e) {
            System.err.println("Test 5 failed: " + e.getMessage());
            throw e;
        }
    }

    public void buyTicket() throws Exception {
        try {
            System.out.println("Test 6: Buy ticket...");
            // Klik tombol Buy untuk masuk ke halaman pemesanan
            driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.example.hntiket:id/btnBuy']")).click();
            Thread.sleep(2000);
            // Isi form pemesanan
            driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.example.hntiket:id/inputFullName']")).sendKeys("Muhammad Nabil Maulana");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.example.hntiket:id/inputPhone']")).sendKeys("081234567888");
            Thread.sleep(2000);
            // Scroll down to btnBuyTicket
            driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(" +
                "new UiSelector().resourceId(\"com.example.hntiket:id/btnBuyTicket\"))"
            );
            Thread.sleep(2000);
            // Klik tombol Buy Ticket
            driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.example.hntiket:id/btnBuyTicket']")).click();
            Thread.sleep(2000);
            // Konfirmasi popup
            driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();
            Thread.sleep(2000);
            System.out.println("Test 6 - Ticket Purchase: Passed");
        } catch (Exception e) {
            System.err.println("Test 6 failed: " + e.getMessage());
            throw e;
        }
    }
    
    public void cancelTicket() throws Exception {
        try {
            System.out.println("Test 7: Cancel ticket...");
            // Klik ikon Profile
            driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Profile']")).click();
            Thread.sleep(2000);
            // Klik menu ticket history (misalnya, "My Tickets" atau item pertama)
            driver.findElement(By.xpath("//android.widget.TextView[@text='My Tickets'] | (//android.widget.LinearLayout[@resource-id='android:id/content'])[1]")).click();
            Thread.sleep(2000);
            // Scroll ke deleteButton
            driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(" +
                "new UiSelector().resourceId(\"com.example.hntiket:id/deleteButton\"))"
            );
            Thread.sleep(2000);
            // Klik deleteButton
            driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.example.hntiket:id/deleteButton']")).click();
            Thread.sleep(2000);
            // Konfirmasi pembatalan
            driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();
            Thread.sleep(2000);
            // Klik tombol Back
            driver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.example.hntiket:id/buttonBack']")).click();
            Thread.sleep(2000);
            System.out.println("Test 7 - Ticket Cancellation: Passed");
        } catch (Exception e) {
            System.err.println("Test 7 failed: " + e.getMessage());
            throw e;
        }
    }

    public void logout() throws Exception {
        try {
            System.out.println("Test 8: Log out...");
            driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Profile']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("(//android.widget.LinearLayout[@resource-id='android:id/content'])[2]")).click();
            Thread.sleep(2000);
            System.out.println("Test 8 - Logout: Passed");
        } catch (Exception e) {
            System.err.println("Test 8 failed: " + e.getMessage());
            throw e;
        }
    }

    public void tearDown() {
        try {
            if (driver != null) {
                driver.quit();
                System.out.println("Driver closed successfully");
            }
        } catch (Exception e) {
            System.err.println("Error while closing driver: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Basics basics = new Basics();
        try {
            basics.setup();
            basics.navigateToLogin();
            basics.registerNewAccount();
            basics.loginWithRegisteredAccount();
//            basics.scrollHomePage();
            basics.selectMovie();
            basics.buyTicket();
            basics.cancelTicket();
            basics.logout();
        } catch (Exception e) {
            System.err.println("Error in main: " + e.getMessage());
            e.printStackTrace();
        } finally {
            basics.tearDown();
        }
    }
}