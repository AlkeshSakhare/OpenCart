package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[value='Login']")
    WebElement btnLogin;
    @FindBy(id = "input-email")
    WebElement txtEmailId;
    @FindBy(id = "input-password")
    WebElement txtPassword;

    public void clickLoginBtn() {
        btnLogin.click();
    }

    public void setEmailId(String emailId) {
        txtEmailId.sendKeys(emailId);
    }

    public void setPassword(String pwd) {
        txtPassword.sendKeys(pwd);
    }

}
