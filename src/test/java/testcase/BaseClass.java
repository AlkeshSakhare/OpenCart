package testcase;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class BaseClass {
    static WebDriver driver;
    String url;
    Faker faker = new Faker();
    Logger log = null;
    Properties properties;

    @Parameters({"browser", "os"})
    @BeforeClass(groups = {"Sanity", "Regression", "Master"})
    void setUp(String browser, String os) {
        try {
            log = LogManager.getLogger(this.getClass());
            properties = new Properties();
            properties.load(new FileReader("src/test/resources/config.properties"));
            url = properties.getProperty("url");
            switch (browser.toLowerCase()) {
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "ie":
                    driver = new InternetExplorerDriver();
                    break;
                default:
                    log.error("Please enter edge, firefox, ie or chrome browser");
                    return;
            }
            log.info("Launching {} browser", browser);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            log.info("Navigate to {}", url);
            driver.get(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Parameters({"browser"})
    @AfterClass(groups = {"Sanity", "Regression", "Master"})
    void tearDown(String browser) {
        log.info("Closing {} browser", browser);
        driver.quit();
    }

    public String captureScreen(String tname) {
        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
        File targetFile = new File(targetFilePath);

        sourceFile.renameTo(targetFile);

        return targetFilePath;
    }
}
