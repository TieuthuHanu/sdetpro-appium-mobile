package test_flow;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.HomeComponent;

public class HomeFlow extends BaseFlow {

    public HomeFlow(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    public void verifyAppPurposeDisplay() {
        HomeComponent hC001 = new HomeComponent(appiumDriver);
        System.out.println(hC001.getAppPurposeText());
    }

    public void verifySupportDisplay() {
        HomeComponent hC002 = new HomeComponent(appiumDriver);
        System.out.println(hC002.getSupportText());
    }
}
