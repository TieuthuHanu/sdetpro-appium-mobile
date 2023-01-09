package models.components.login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginFormComponent {

    private final AppiumDriver<MobileElement> appiumDriver;
    private final By usernameSel = MobileBy.AccessibilityId("input-email");
    private final By incorrectEmailTextSel = MobileBy.xpath("//*[contains(@text, 'Please enter a valid email address')]");
    private final By passwordSel = MobileBy.AccessibilityId("input-password");
    private final By incorrectPasswordTextSel = MobileBy.xpath("//*[contains(@text, 'Please enter at least 8 characters')]");
    private final By loginBtnSel = MobileBy.AccessibilityId("button-LOGIN");
    private final By loginSuccessfullyTextSel = MobileBy.xpath("//*[contains(@text, 'Success')]");

    public LoginFormComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void usernameElem(String usernameText) {
        if (!usernameText.isEmpty())
            appiumDriver.findElement(usernameSel).sendKeys(usernameText);
    }

    public String getIncorrectEmailTextSel() {
        return appiumDriver.findElement(incorrectEmailTextSel).getText();
    }

    public void passwordElem(String passwordText) {
        if (!passwordText.isEmpty())
            appiumDriver.findElement(passwordSel).sendKeys(passwordText);
    }

    public String getIncorrectPasswordTextSel() {
        return appiumDriver.findElement(incorrectPasswordTextSel).getText();
    }

    public void loginBtnElem() {
        appiumDriver.findElement(loginBtnSel).click();
    }

    public String getLoginSuccessfullyTextSel() {
        return appiumDriver.findElement(loginSuccessfullyTextSel).getText();
    }
}
