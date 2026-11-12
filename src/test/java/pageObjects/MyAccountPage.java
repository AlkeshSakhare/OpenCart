package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Logout")
    WebElement btnLogout;
    private By lblMyAccount = By.xpath("//h2[contains(text(),'My Account')]");
    private By loginError = By.cssSelector(".alert-danger");

    public boolean isLoginSuccessful() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.presenceOfElementLocated(lblMyAccount),
                ExpectedConditions.visibilityOfElementLocated(loginError)));
        return !driver.findElements(lblMyAccount).isEmpty();
    }

    public void clickLogoutBtn() {
        btnLogout.click();
    }

}
