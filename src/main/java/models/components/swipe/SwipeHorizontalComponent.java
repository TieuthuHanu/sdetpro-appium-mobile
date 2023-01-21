package models.components.swipe;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
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

public class SwipeHorizontalComponent {

    private final AppiumDriver<MobileElement> appiumDriver;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Swipe horizontal')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Swipe horizontal\"")
    private MobileElement swipeTextSel;

    public SwipeHorizontalComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(10)), this);
    }

    public void swipeFromRightToLeft() {
        MobileScreenSize size = new MobileScreenSize(appiumDriver);
        Dimension windowSize = size.getWindowSize();
        int xStartPoint = 50 * size.getScreenWidth(windowSize) / 100;
        int xEndPoint = 20 * size.getScreenWidth(windowSize) / 100;
        int yAnchor = 70 * size.getScreenHeight(windowSize) / 100;

        // Wait until user is on Swipe screen
        WebDriverWait wait = new WebDriverWait(appiumDriver, 10L);
        wait.until(ExpectedConditions.visibilityOf(swipeTextSel));

        // Using TouchAction to swipe
        TouchAction touchAction = new TouchAction(appiumDriver);
        touchAction
                .press(point(xStartPoint, yAnchor))
                .waitAction(waitOptions(ofMillis(250)))
                .moveTo(point(xEndPoint, yAnchor))
                .release()
                .perform();
    }
}
