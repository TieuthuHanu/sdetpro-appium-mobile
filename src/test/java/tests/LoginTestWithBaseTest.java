package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test_data.DataObjectBuilder;
import test_data.LoginCred;
import test_flow.LoginFlow;

public class LoginTestWithBaseTest extends BaseTest {

    @Test (dataProvider = "loginCredsData")
    public void testLogin(LoginCred loginCred) {
        LoginFlow loginFlow = new LoginFlow(appiumDriver, loginCred.getUsername(), loginCred.getPassword());
        loginFlow.goToLoginScreen();
        loginFlow.login();
        loginFlow.verifyLogin();
    }

    @DataProvider
    public LoginCred[] loginCredsData() {
        String filePath = "/src/test/java/test_data/LoginCreds.json";
        return DataObjectBuilder.buildDataObject(filePath, LoginCred[].class);
    }
}
