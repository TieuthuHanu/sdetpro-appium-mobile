package tests;

import io.qameta.allure.Issue;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test_data.DataObjectBuilder;
import test_data.FormsInputField;
import test_flow.FormsFlow;

public class FormsTest extends BaseTest {

    @Test(priority = 1, dataProvider = "inputFieldData")
    @Issue("JIRA-321")
    public void testUserInput(FormsInputField formsInputField) {
        FormsFlow formsFlow = new FormsFlow(getDriver(), formsInputField.getInputField());
        formsFlow.goToFormsScreen();
        formsFlow.userInput();
        formsFlow.verifyInputDisplay();
    }

    @DataProvider
    public FormsInputField[] inputFieldData() {
        String filePath = "/src/main/java/test_data/FormsInputFieldData.json";
        return DataObjectBuilder.buildDataObject(filePath, FormsInputField[].class);
    }

    @Test(priority = 2)
    public void testForms() {
        FormsFlow formsFlow = new FormsFlow(getDriver());
        formsFlow.verifySwitchOnToOff();
        formsFlow.verifySwitchOffToOn();
        formsFlow.verifyDropdownList();
        formsFlow.verifyActiveBtn();
    }
}
