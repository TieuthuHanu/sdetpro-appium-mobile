package models.components.global;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.time.Duration;

public class MobileScreenSize {

    private final AppiumDriver<MobileElement> appiumDriver;

    public MobileScreenSize(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public Dimension getWindowSize() {
        return appiumDriver.manage().window().getSize();
    }

    public int getScreenWidth(Dimension windowSize) {
        return windowSize.getWidth();
    }

    public int getScreenHeight(Dimension windowSize) {
        return windowSize.getHeight();
    }

//    public void calculateTouchPoint() {
//        int xStartPoint = 50 * screenWidth / 100;
//        int xEndPoint = 50 * screenWidth / 100;
//
//        int yStartPoint = 20 * screenHeight / 100;
//        int yEndPoint = 20 * screenHeight / 100;
//
//        PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
//        TouchAction touchAction = new TouchAction(appiumDriver).press(startPoint);
//    }
}
