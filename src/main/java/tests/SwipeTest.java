package tests;

import org.testng.annotations.Test;
import test_flow.SwipeFlow;

public class SwipeTest extends BaseTest {

    @Test (description = "Test Swipe Page")
    public void testSwipePage() {
        SwipeFlow swipeFlow = new SwipeFlow(getDriver());
        swipeFlow.goToSwipeScreen();
        swipeFlow.swipeHorizontal();
        swipeFlow.swipeVertical();
    }
}
