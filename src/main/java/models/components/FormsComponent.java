package models.components;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class FormsComponent {

    private final AppiumDriver<MobileElement> appiumDriver;
    private final By textInputSel = MobileBy.AccessibilityId("text-input");
    private final By inputTextResultSel = MobileBy.AccessibilityId("input-text-result");
    private final By switchButtonSel = MobileBy.AccessibilityId("switch");
    private final By switchStatusSel = MobileBy.AccessibilityId("switch-text");

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Form components')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Form components\"")
    private MobileElement removeKeyboard;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'Select an item')]")
    @iOSXCUITFindBy(id = "text_input")
    private MobileElement dropdownSel;

    @AndroidFindBy(id = "com.wdiodemoapp:id/select_dialog_listview")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypePickerWheel")
    private MobileElement dropdownList;

    @AndroidFindBy(accessibility = "button-Active")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Active\"")
    private MobileElement activeBtn;

    public FormsComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(10)), this);
    }

    @Step("Text input as {textInput}")
    public void textInput(String textInput) {
        if (!textInput.isEmpty()) {
            MobileElement textInputField = appiumDriver.findElement(textInputSel);
            textInputField.clear();
            textInputField.sendKeys(textInput);
            removeKeyboard.click();
        }
    }

    public String getInputTextResult() {
        return appiumDriver.findElement(inputTextResultSel).getText().trim();
    }

    @Step("Toggle ON to OFF")
    public void switchBtnOnToOff() {
        String beforeClickText = appiumDriver.findElement(switchStatusSel).getText();
        appiumDriver.findElement(switchButtonSel).click();
        String afterClickText = appiumDriver.findElement(switchStatusSel).getText();
        Assert.assertNotEquals(beforeClickText, afterClickText, "[ERR] Switch status: no change!");
    }

    @Step("Toggle OFF to ON")
    public void switchBtnOffToOn() {
        String beforeClickText = appiumDriver.findElement(switchStatusSel).getText();
        appiumDriver.findElement(switchButtonSel).click();
        String afterClickText = appiumDriver.findElement(switchStatusSel).getText();
        Assert.assertNotEquals(beforeClickText, afterClickText, "[ERR] Switch status: no change!");
    }

    public void showDropdownList() {
        dropdownSel.click();
    }

    public void dropdownPickerWheel() {
        dropdownList.sendKeys("webdriver.io is awesome");
        dropdownSel.click();
        dropdownList.sendKeys("Appium is awesome");
        dropdownSel.click();
        dropdownList.sendKeys("This app is awesome");
        appiumDriver.findElement(doneBtn).click();
    }

    public void dropdownChoices() {
        for (int index = 0; index < choices.size(); index++) {
            appiumDriver.findElement(choices.get(index)).click();
            appiumDriver.findElement(dropdown).click();
        }
        appiumDriver.findElement(MobileBy.xpath("//android.widget.CheckedTextView[contains(@text, 'Select an item')]")).click();
    }
    private final By doneBtn = MobileBy.AccessibilityId("done_button");
    private final By dropdown = MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"Dropdown\"]");

    private final By firstChoice = MobileBy.xpath("//android.widget.CheckedTextView[contains(@text, 'webdriver.io')]");
    private final By secondChoice = MobileBy.xpath("//android.widget.CheckedTextView[contains(@text, 'Appium')]");
    private final By thirdChoice = MobileBy.xpath("//android.widget.CheckedTextView[contains(@text, 'This app')]");
    private final List<By> choices = Arrays.asList(firstChoice, secondChoice, thirdChoice);

    public void clickOnActiveBtn() {
        activeBtn.click();
    }

    @AndroidFindBy(id = "android:id/button1")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"OK\"")
    private MobileElement okButtonElem;

    public void clickOnOkButtonElem() {
        okButtonElem.click();
    }
}
