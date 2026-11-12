package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class LoginTest extends BaseClass {

    @Test(groups = {"Sanity", "Master"})
    public void verifyLoginTest() {
        try {
            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccountBtn();
            homePage.clickLoginBtn();
            log.info("Navigating to login page");
            LoginPage loginPage = new LoginPage(driver);
            loginPage.setEmailId(properties.getProperty("email"));
            loginPage.setPassword(properties.getProperty("password"));
            loginPage.clickLoginBtn();
            MyAccountPage myAccountPage = new MyAccountPage(driver);
            boolean isLoginSuccess = myAccountPage.isLoginSuccessful();
            if (isLoginSuccess) {
                log.info("Login succeed");

            } else {
                log.info("Login failed");
            }
            Assert.assertTrue(isLoginSuccess);
        } catch (Exception e) {
            log.error(e);
        }
    }
}
