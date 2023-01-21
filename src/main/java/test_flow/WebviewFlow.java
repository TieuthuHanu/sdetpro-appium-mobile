package test_flow;

import context.Contexts;
import context.WaitMoreThanOneContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.WebviewComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class WebviewFlow extends BaseFlow {

    public WebviewFlow(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    public void switchToWebviewContext() {
        // Wait more than one context
        WebDriverWait wait = new WebDriverWait(appiumDriver, 15L);
        wait.until(new WaitMoreThanOneContext(appiumDriver));

        appiumDriver.context(Contexts.WEB_VIEW_ANDROID);
//        appiumDriver.context(Contexts.WEB_VIEW_IOS);
    }

    public void getTextAndHyperLink() {
        WebviewComponent webview = new WebviewComponent(appiumDriver);
        webview.clickOnMenuToggleBtnElem();
        webview.menuList();
    }

    public void switchBackNativeApp() {
        appiumDriver.context(Contexts.NATIVE);
    }
}
