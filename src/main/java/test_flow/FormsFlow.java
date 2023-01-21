package test_flow;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import models.components.FormsComponent;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

public class FormsFlow extends BaseFlow {

    private String inputField = null;

    public FormsFlow(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(10)), this);
    }

    public FormsFlow(AppiumDriver<MobileElement> appiumDriver, String inputField) {
        super(appiumDriver);
        this.inputField = inputField;
    }

    public void userInput() {
        FormsComponent formsComp = new FormsComponent(appiumDriver);
        formsComp.textInput(inputField);
    }

    @Step("Verify user input can be displayed")
    public void verifyInputDisplay() {
        FormsComponent formsComp = new FormsComponent(appiumDriver);
        String actual = formsComp.getInputTextResult();
        Assert.assertEquals(actual, inputField, "[ERR] User input str: not match");
    }

    public void verifySwitchOnToOff() {
        FormsComponent formsComp = new FormsComponent(appiumDriver);
        formsComp.switchBtnOnToOff();
    }

    public void verifySwitchOffToOn() {
        FormsComponent formsComp = new FormsComponent(appiumDriver);
        formsComp.switchBtnOffToOn();
    }

    public void verifyDropdownList() {
        FormsComponent formsComp = new FormsComponent(appiumDriver);
        formsComp.showDropdownList();
//        formsComp.dropdownPickerWheel();
        formsComp.dropdownChoices();
    }

    public void verifyActiveBtn() {
        FormsComponent formsComp = new FormsComponent(appiumDriver);
        formsComp.clickOnActiveBtn();

        String actual = "This button is active";
        String expected = activeText.getText().trim();
        Assert.assertEquals(actual, expected, "[ERR] Active button is not working!");

        formsComp.clickOnOkButtonElem();
    }

    @AndroidFindBy(id = "android:id/message")
    @iOSXCUITFindBy(accessibility = "This button is active")
    private MobileElement activeText;
}
