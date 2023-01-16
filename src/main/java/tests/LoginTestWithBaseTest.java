package tests;

import io.qameta.allure.TmsLink;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test_data.DataObjectBuilder;
import test_data.LoginCred;
import test_flow.LoginFlow;

public class LoginTestWithBaseTest extends BaseTest {

    @TmsLink("TEST-123")
    @Test(dataProvider = "loginCredData")
    public void testLogin(LoginCred loginCred) {
        LoginFlow loginFlow = new LoginFlow(getDriver(), loginCred.getUsername(), loginCred.getPassword());
        loginFlow.goToLoginScreen();
        loginFlow.login();
        loginFlow.verifyLogin();
    }

    @DataProvider
    public LoginCred[] loginCredData() {
        String filePath = "/src/main/java/test_data/LoginCreds.json";
        return DataObjectBuilder.buildDataObject(filePath, LoginCred[].class);
    }
}
