package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import platform.Platform;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory implements MobileCapabilityTypeEx {

    private AppiumDriver<MobileElement> appiumDriver;

    public static AppiumDriver<MobileElement> getDriver(Platform platform) {
        AppiumDriver<MobileElement> appiumDriver = null;
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(PLATFORM_NAME, "iOS");
        desiredCapabilities.setCapability(PLATFORM_VERSION, "15.2");
        desiredCapabilities.setCapability(AUTOMATION_NAME, "XCUITest");
        desiredCapabilities.setCapability(DEVICE_NAME, "iPhone 12");
        desiredCapabilities.setCapability(BUNDLE_ID, "org.wdioNativeDemoApp");
//        desiredCapabilities.setCapability(APP_ACTIVITY, "com.wdiodemoapp.MainActivity");
        URL appiumServer = null;

        try {
            appiumServer = new URL("http://localhost:4723/wd/hub");
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (appiumServer == null)
            throw new RuntimeException("Can't construct the appium server @http://localhost:4723/wd/hub");

        switch (platform) {
            case ANDROID:
                appiumDriver = new AndroidDriver<MobileElement>(appiumServer, desiredCapabilities);
                break;
            case IOS:
                appiumDriver = new IOSDriver<MobileElement>(appiumServer, desiredCapabilities);
                break;
        }

        // Implicit wait | Interval time 500ms
        appiumDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        return appiumDriver;
    }

    public AppiumDriver<MobileElement> getDriver(Platform platform, String udid, String systemPort, String platformVersion) {
        String remoteInfoViaEnvVar = System.getenv("remote");
        String remoteInfoViaCommandVar = System.getProperty("remote");
        String isRemote = remoteInfoViaEnvVar == null ? remoteInfoViaCommandVar : remoteInfoViaEnvVar;
        if (isRemote == null)
            throw new IllegalArgumentException("Please provide env variable [env]");

        String targetServer = "http://localhost:4723/wd/hub";
        if (isRemote.equals("true")) {
            String hubIpAdd = System.getenv("hub");
            if (hubIpAdd == null)
                hubIpAdd = System.getProperty("hub");
            if (hubIpAdd == null)
                throw new IllegalArgumentException("Please provide hub ip address via env variable [hub]");
            targetServer = hubIpAdd + ":4444/wd/hub";
        }

        if (appiumDriver == null) {
            URL appiumServer = null;
//            String targetServer = "http://address:4444/wd/hub";

            try {
//                appiumServer = new URL("http://localhost:4723/wd/hub");
                appiumServer = new URL(targetServer);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (appiumServer == null)
                throw new RuntimeException("Can't connect to selenium grid!");

            // Desired Capabilities
            DesiredCapabilities desiredCaps = new DesiredCapabilities();
            desiredCaps.setCapability(PLATFORM_NAME, platform);

            switch (platform) {
                case ANDROID:
                    desiredCaps.setCapability(AUTOMATION_NAME, "uiautomator2");
                    desiredCaps.setCapability(UDID, udid);
                    desiredCaps.setCapability(APP_PACKAGE, "com.wdiodemoapp");
                    desiredCaps.setCapability(APP_ACTIVITY, "com.wdiodemoapp.MainActivity");
                    desiredCaps.setCapability(SYSTEM_PORT, systemPort);
                    appiumDriver = new AndroidDriver<MobileElement>(appiumServer, desiredCaps);
                    break;
                case IOS:
                    desiredCaps.setCapability(AUTOMATION_NAME, "XCUITest");
                    desiredCaps.setCapability(PLATFORM_VERSION, platformVersion);
                    desiredCaps.setCapability(DEVICE_NAME, udid);
                    desiredCaps.setCapability(BUNDLE_ID, "org.wdioNativeDemoApp");
                    desiredCaps.setCapability(WDA_LOCAL_PORT, systemPort);
                    appiumDriver = new IOSDriver<MobileElement>(appiumServer, desiredCaps);
                    break;
            }
            // Implicit wait | Interval time 500ms
            appiumDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
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
