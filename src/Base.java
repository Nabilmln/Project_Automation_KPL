//package uaskpl.appiumtest;

import java.io.File;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base {
    public static AndroidDriver<AndroidElement> capabilities() throws Exception {
        try {
            DesiredCapabilities cap = new DesiredCapabilities();
            
            File appDir = new File("src");
            File app = new File(appDir, "hnTicket.apk");
            
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
            cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
            cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
            cap.setCapability(MobileCapabilityType.NO_RESET, true);
            cap.setCapability(MobileCapabilityType.FULL_RESET, false);
            
            AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/"), cap);
            return driver;
        } catch (Exception e) {
            System.err.println("Failed to initialize driver: " + e.getMessage());
            throw e;
        }
    }
}