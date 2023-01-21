package tests_sa;

import driver_sa.DriverFactory;
import driver_sa.Platform;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.util.List;

public class BaseTest {


    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
        appiumDriver.quit();
    }

}
