package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[title='My Account']")
    WebElement btnMyAccount;
    @FindBy(xpath = "//a[contains(text(),'Register')]")
    WebElement btnRegister;
    @FindBy(linkText = "Login")
    WebElement btnLogin;

    public void clickMyAccountBtn() {
        btnMyAccount.click();
    }

    public void clickRegisterBtn() {
        btnRegister.click();
    }

    public void clickLoginBtn() {
        btnLogin.click();
    }
}
