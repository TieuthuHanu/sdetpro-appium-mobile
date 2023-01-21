package driver_sa;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory implements MobileCapabilityTypeExt {

    private static AppiumDriver<MobileElement> appiumDriver;

    public static AppiumDriver<MobileElement> getDriver(Platform platform) {
        String targetServer = "http://localhost:4723/wd/hub";
        if (appiumDriver == null) {
            URL appiumServer = null;
            try {
                appiumServer = new URL(targetServer);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (appiumServer == null)
                throw new RuntimeException("Can't connect to appium server!");

            DesiredCapabilities desiredCaps = new DesiredCapabilities();
            desiredCaps.setCapability(PLATFORM_NAME, platform);
            switch (platform) {
                case ANDROID:
                    desiredCaps.setCapability(AUTOMATION_NAME, "uiautomator2");
                    desiredCaps.setCapability(UDID, "LMK500ZPZXWODEEYTC");
                    desiredCaps.setCapability(APP_PACKAGE, "com.tuhuynh.sdetproecommerce");
                    desiredCaps.setCapability(APP_ACTIVITY, "host.exp.exponent.MainActivity");
//                    desiredCaps.setCapability(SYSTEM_PORT, "systemPort");
                    appiumDriver = new AndroidDriver<MobileElement>(appiumServer, desiredCaps);
                    break;
                case IOS:
                    desiredCaps.setCapability(AUTOMATION_NAME, "XCUITest");
                    desiredCaps.setCapability(DEVICE_NAME, "udid");
                    desiredCaps.setCapability(PLATFORM_VERSION, "platformVersion");
                    desiredCaps.setCapability(BUNDLE_ID, "com.tuhuynh.sdetproecommerce");
//                    desiredCaps.setCapability(WDA_LOCAL_PORT, "systemPort");
                    appiumDriver = new IOSDriver<MobileElement>(appiumServer, desiredCaps);
                    break;
            }
            // Implicit wait
            appiumDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        }
        return appiumDriver;
    }

    public void quitAppiumDriver() {
        if (appiumDriver != null) {
            appiumDriver.quit();
            appiumDriver = null;
        }
    }
}
