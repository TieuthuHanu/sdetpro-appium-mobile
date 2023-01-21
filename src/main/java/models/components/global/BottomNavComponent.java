package models.components.global;

import context.Contexts;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import models.components.WebviewComponent;
import org.openqa.selenium.By;

public class BottomNavComponent {

    private final AppiumDriver<MobileElement> appiumDriver;
    private final By homeIconSel = MobileBy.AccessibilityId("Home");
    private final By loginIconSel = MobileBy.AccessibilityId("Login");
    private final By formsIconSel = MobileBy.AccessibilityId("Forms");
    private final By swipeIconSel = MobileBy.AccessibilityId("Swipe");
    private final By webviewIconSel = MobileBy.AccessibilityId("Webview");

    public BottomNavComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void clickOnHomeIconNav() {
        appiumDriver.findElement(homeIconSel).click();
    }

    public void clickOnLoginIconNav() {
        appiumDriver.findElement(loginIconSel).click();
    }

    public void clickOnFormsIconNav() {
        appiumDriver.findElement(formsIconSel).click();
    }

    public void clickOnSwipeIconNav() {
        appiumDriver.findElement(swipeIconSel).click();
    }

    public void clickOnWebviewIconNav() {
        appiumDriver.findElement(webviewIconSel).click();
    }




}
