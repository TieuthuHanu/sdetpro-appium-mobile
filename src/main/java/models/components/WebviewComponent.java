package models.components;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class WebviewComponent {

    private final AppiumDriver<MobileElement> appiumDriver;

    public WebviewComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void clickOnMenuToggleBtnElem() {
        WebElement navToggleBtn = appiumDriver.findElementByCssSelector(".navbar__toggle");
        navToggleBtn.click();
    }

    public void menuList() {
        List<MobileElement> menuList = appiumDriver.findElementsByCssSelector(".menu__list li a");
        List<MenuItemData> menuItemDataList = new ArrayList<>();

        if(menuList.isEmpty())
            Assert.fail("List is empty!");

        for (MobileElement item: menuList) {
            String itemText = item.getText();
            String itemHref = item.getAttribute("href");
            if (itemHref.contains("github"))
                menuItemDataList.add(new MenuItemData("GitHub", itemHref));
            else if (itemHref.contains("twitter"))
                menuItemDataList.add(new MenuItemData("Twitter", itemHref));
            else
                menuItemDataList.add(new MenuItemData(itemText, itemHref));
        }

        for (MenuItemData menuItem : menuItemDataList) {
            System.out.println("Item: " + menuItem.getName() + ", href: " + menuItem.getHref());
        }
    }

    public static class MenuItemData {
        private String name;
        private String href;

        public MenuItemData(String name, String href) {
            this.name = name;
            this.href = href;
        }

        public String getName() {
            return name;
        }

        public String getHref() {
            return href;
        }
    }
}
