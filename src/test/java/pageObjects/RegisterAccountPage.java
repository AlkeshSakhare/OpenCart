package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterAccountPage extends BasePage {
    public RegisterAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-firstname")
    WebElement txtFirstName;
    @FindBy(id = "input-lastname")
    WebElement txtLastName;
    @FindBy(id = "input-email")
    WebElement txtEmail;
    @FindBy(id = "input-telephone")
    WebElement txtTelephone;
    @FindBy(id = "input-password")
    WebElement txtPassword;
    @FindBy(id = "input-confirm")
    WebElement txtConfirmpassword;
    @FindBy(css = "[name='agree']")
    WebElement checkBoxPrivacyPolicy;
    @FindBy(css = "[value='Continue']")
    WebElement btnContinue;
    @FindBy(xpath = "//*[@id='content']/p")
    WebElement msgSuccess;

    public void setFirstName(String fname) {
        txtFirstName.sendKeys(fname);
    }

    public void setLastName(String lname) {
        txtLastName.sendKeys(lname);
    }

    public void setEmail(String email) {
        txtEmail.sendKeys(email);
    }

    public void setTelephoneTxt(String telephone) {
        txtTelephone.sendKeys(telephone);
    }

    public void setPasswordTxt(String pwd) {
        txtPassword.sendKeys(pwd);
    }

    public void setConfirmPasswordTxt(String pwd) {
        txtConfirmpassword.sendKeys(pwd);
    }

    public void clickPrivacyPolicyChckBox() {
        checkBoxPrivacyPolicy.click();
    }

    public void clickContinueBtn() {
        btnContinue.click();
    }

    public String getSuccessMSG() {
        return msgSuccess.getText();
    }
}
