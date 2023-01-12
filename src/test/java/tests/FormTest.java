package tests;

import org.testng.annotations.Test;
import test_flow.FormFlow;

public class FormTest extends BaseTest {

    @Test
    public void testFormsScreen() {
        System.out.println("--> Session ID: " + getDriver().getSessionId());
        FormFlow formFlow = new FormFlow(getDriver());
        formFlow.goToFormsScreen();
        formFlow.checkSwitchBtn();
    }
}
