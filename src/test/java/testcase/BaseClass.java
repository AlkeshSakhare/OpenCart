package testcase;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    WebDriver driver;
    String url;
    Faker faker = new Faker();
    Logger log = null;
    Properties properties;

    @Parameters({"browser"})
    @BeforeClass
    void setUp(String browser) {
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
                default:
                    log.error("Please enter edge or firefox browser");
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
    @AfterClass
    void tearDown(String browser) {
        log.info("Closing {} browser", browser);
        driver.quit();
    }
}
