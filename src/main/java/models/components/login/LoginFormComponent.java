package models.components.login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static io.appium.java_client.MobileBy.AccessibilityId;

public class LoginFormComponent {

    private final AppiumDriver<MobileElement> appiumDriver;
    private final By usernameSel = AccessibilityId("input-email");
    private final By passwordSel = AccessibilityId("input-password");
    private final By loginBtnSel = AccessibilityId("button-LOGIN");

    public LoginFormComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(10)), this);
    }

    @Step("Input username as {usernameText}")
    public void usernameElem(String usernameText) {
        if (!usernameText.isEmpty()) {
            MobileElement usernameElem = appiumDriver.findElement(usernameSel);
            usernameElem.clear();
            usernameElem.sendKeys(usernameText);
        }
    }

    @AndroidFindBy(xpath = "//*[contains(@text, 'Please enter a valid email address')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Please enter a valid email address\"")
    private MobileElement incorrectEmailTextSel;

    @AndroidFindBy(xpath = "//*[contains(@text, 'Please enter at least 8 characters')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Please enter at least 8 characters\"")
    private MobileElement incorrectPasswordTextSel;

    @AndroidFindBy(xpath = "//*[contains(@text, 'Success')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Success\"")
    private MobileElement loginSuccessfullyTextSel;

    public String getIncorrectEmailTextSel() {
        return incorrectEmailTextSel.getText().trim();
    }

    @Step("Input password as {passwordText}")
    public void passwordElem(String passwordText) {
        if (!passwordText.isEmpty()) {
            MobileElement passwordElem = appiumDriver.findElement(passwordSel);
            passwordElem.clear();
            passwordElem.sendKeys(passwordText);
        }
    }

    public String getIncorrectPasswordTextSel() {
        return incorrectPasswordTextSel.getText().trim();
    }

    @Step("Click on login button")
    public void loginBtnElem() {
        appiumDriver.findElement(loginBtnSel).click();
    }

    public String getLoginSuccessfullyTextSel() {
        return loginSuccessfullyTextSel.getText();
    }
}
