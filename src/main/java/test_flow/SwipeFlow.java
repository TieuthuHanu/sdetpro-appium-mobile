package test_flow;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import models.components.swipe.SwipeHorizontalComponent;
import models.components.swipe.SwipeVerticalComponent;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

public class SwipeFlow extends BaseFlow {

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'FULLY OPEN SOURCE')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"FULLY OPEN SOURCE\"")
    private MobileElement firstBoard;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'GREAT COMMUNITY')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"GREAT COMMUNITY\"")
    private MobileElement secondBoard;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'JS.FOUNDATION')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"JS.FOUNDATION\"")
    private MobileElement thirdBoard;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'SUPPORT VIDEOS')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"SUPPORT VIDEOS\"")
    private MobileElement fourthBoard;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'EXTENDABLE')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"EXTENDABLE\"")
    private MobileElement fifthBoard;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'COMPATIBLE')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"COMPATIBLE\"")
    private MobileElement sixthBoard;

    public SwipeFlow(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(10)), this);
    }

    public void swipeHorizontal() {
        SwipeHorizontalComponent swipe001 = new SwipeHorizontalComponent(appiumDriver);
        String first = firstBoard.getText();
        String one = "FULLY OPEN SOURCE";
        Assert.assertEquals(first, one, "[ERR]");
        System.out.println("First text is: " + first + " | " + one);

        swipe001.swipeFromRightToLeft();
        String second = secondBoard.getText();
        String two = "GREAT COMMUNITY";
        Assert.assertEquals(second, two, "[ERR]");
        System.out.println("Second text is: " + second + " | " + two);

        swipe001.swipeFromRightToLeft();
        String third = thirdBoard.getText();
        String three = "JS.FOUNDATION";
        Assert.assertEquals(third, three, "[ERR]");
        System.out.println("Third text is: " + third + " | " + three);

        swipe001.swipeFromRightToLeft();
        String fourth = fourthBoard.getText();
        String four = "SUPPORT VIDEOS";
        Assert.assertEquals(fourth, four, "[ERR]");
        System.out.println("Fourth text is: " + fourth + " | " + four);

        swipe001.swipeFromRightToLeft();
        String fifth = fifthBoard.getText();
        String five = "EXTENDABLE";
        Assert.assertEquals(fifth, five, "[ERR]");
        System.out.println("Fifth text is: " + fifth + " | " + five);

        swipe001.swipeFromRightToLeft();
        String sixth = sixthBoard.getText();
        String six = "COMPATIBLE";
        Assert.assertEquals(sixth, six, "[ERR]");
        System.out.println("Sixth text is: " + sixth + " | " + six);
    }

//        for (int index = 0; index < 5; index++) {
//            swipe001.swipeFromRightToLeft();
//            System.out.println(actualTexts().get(index));
//        }

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'You found me!!!')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"You found me!!!\"")
    private MobileElement swipeIconSel;

    public void swipeVertical() {
        SwipeVerticalComponent swipe001 = new SwipeVerticalComponent(appiumDriver);
        swipe001.swipeFromBottomToTop();
        swipe001.swipeFromBottomToTop();
        swipe001.swipeFromBottomToTop();

//        while (!(swipeIconSel.isDisplayed())) {
//            swipe001.swipeFromBottomToTop();
//        }
        System.out.println(swipeIconSel.getText());
    }
}
