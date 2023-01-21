package tests;

import org.testng.annotations.Test;
import test_flow.WebviewFlow;

public class WebviewTest extends BaseTest {

    @Test
    public void testWebview() {
        WebviewFlow flow = new WebviewFlow(getDriver());
        flow.goToWebviewScreen();
        flow.switchToWebviewContext();
        flow.getTextAndHyperLink();
        flow.switchBackNativeApp();
    }
}
