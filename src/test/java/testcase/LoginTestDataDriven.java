package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataDriven;

public class LoginTestDataDriven extends BaseClass {
    
    @Test(dataProvider = "LoginDataDrivenData", dataProviderClass = DataDriven.class, groups = "Datadriven")
    public void verifyLoginDataDrivenTest(String email, String pwd, String isValid) {
        try {
            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccountBtn();
            homePage.clickLoginBtn();
            log.info("Navigating to login page");
            LoginPage loginPage = new LoginPage(driver);
            loginPage.setEmailId(email);
            loginPage.setPassword(pwd);
            loginPage.clickLoginBtn();
            MyAccountPage myAccountPage = new MyAccountPage(driver);
            boolean actualResult = myAccountPage.isLoginSuccessful();
            boolean expectedResult = Boolean.parseBoolean(isValid);
            log.info("Expected login result: {}", expectedResult);
            log.info("Actual login result: {}", actualResult);
            Assert.assertEquals(actualResult, expectedResult, "Login result mismatch for: " + email);
            if (actualResult) {
                log.info("Login succeeded for {}", email);
                myAccountPage.clickLogoutBtn();
            } else {
                log.info("Login failed as expected for {}", email);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
