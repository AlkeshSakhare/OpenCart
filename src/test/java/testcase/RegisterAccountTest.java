package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegisterAccountPage;

public class RegisterAccountTest extends BaseClass {


    @Test
    void registerAccountTest() {
        try {
            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccountBtn();
            homePage.clickRegisterBtn();
            RegisterAccountPage registerAccountPage = new RegisterAccountPage(driver);
            registerAccountPage.setFirstName(faker.name().firstName());
            registerAccountPage.setLastName(faker.name().lastName());
            String emailId = faker.internet().emailAddress();
            log.info("EmailId: {}", emailId);
            registerAccountPage.setEmail(emailId);
            registerAccountPage.setTelephoneTxt(faker.phoneNumber().cellPhone());
            String password = faker.internet().password();
            log.info("password: {}", password);
            registerAccountPage.setPasswordTxt(password);
            registerAccountPage.setConfirmPasswordTxt(password);
            registerAccountPage.clickPrivacyPolicyChckBox();
            registerAccountPage.clickContinueBtn();
            String expectedSuccessMSG = "Congratulations! Your new account has been successfully created!";
            String actualSuccessMSG = registerAccountPage.getSuccessMSG();
            log.info("actualSuccessMSG: {}", actualSuccessMSG);
            Assert.assertEquals(actualSuccessMSG, expectedSuccessMSG);
        } catch (Exception e) {
            log.error(e);
            Assert.fail();
        }

    }
}
