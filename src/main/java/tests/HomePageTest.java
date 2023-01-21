package tests;

import org.testng.annotations.Test;
import test_flow.HomeFlow;

public class HomePageTest extends BaseTest {

    @Test (description = "Test Home Page")
    public void testHomePage() {
        HomeFlow homeFlow = new HomeFlow(getDriver());
        homeFlow.goToHomeScreen();
        homeFlow.verifyAppPurposeDisplay();
        homeFlow.verifySupportDisplay();
    }
}
