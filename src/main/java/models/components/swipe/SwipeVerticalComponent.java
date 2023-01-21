package models.components.swipe;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import models.components.global.MobileScreenSize;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public class SwipeVerticalComponent {

    private final AppiumDriver<MobileElement> appiumDriver;

    public SwipeVerticalComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void swipeFromBottomToTop() {
        MobileScreenSize size = new MobileScreenSize(appiumDriver);
        int xAnchor = 50 * size.getScreenWidth(size.getWindowSize()) / 100;
        int yStartPoint = 70 * size.getScreenHeight(size.getWindowSize()) / 100;
        int yEndPoint = 20 * size.getScreenHeight(size.getWindowSize()) / 100;

        // Using TouchAction to swipe
        TouchAction touchAction = new TouchAction(appiumDriver);
        touchAction
                .press(point(xAnchor, yStartPoint))
                .waitAction(waitOptions(ofMillis(500)))
                .moveTo(point(xAnchor, yEndPoint))
                .release()
                .perform();
    }
}
