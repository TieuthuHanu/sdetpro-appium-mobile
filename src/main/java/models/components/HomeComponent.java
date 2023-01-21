package models.components;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class HomeComponent {

    private final AppiumDriver<MobileElement> appiumDriver;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Demo app for')]")
    @iOSXCUITFindBy(accessibility = "Demo app for the appium-boilerplate")
    private MobileElement appPurposeTextSel;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Support')]")
    @iOSXCUITFindBy(accessibility = "Support")
    private MobileElement supportTextSel;

    public HomeComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(10)), this);
    }

    public String getAppPurposeText() {
        return appPurposeTextSel.getText().trim();
    }

    public String getSupportText() {
        return supportTextSel.getText().trim();
    }
}
