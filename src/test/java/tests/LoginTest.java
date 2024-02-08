package tests;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseFunction;
import com.qa.config.ConfigReader;
import com.qa.pages.PageObjectManager;

public class LoginTest extends BaseFunction {
    private static final Logger logger = LogManager.getLogger(LoginTest.class);
    private PageObjectManager pom;

    @BeforeMethod
    public void setUp() {
        logger.info("Setting up test environment...");
        String browser = ConfigReader.getInstance().getBrowser();
        driver = launchBrowser(browser);
        pom = new PageObjectManager(driver);
        navigateToURL(ConfigReader.getInstance().getURL());
    }

    @Test
    public void loginTestValidUsernamePassword() {
        logger.info("Starting loginTestValidUsernamePassword test...");
        try {
            pom.getLoginPageElements().getUsername_txtBox().sendKeys("Admin");
            pom.getLoginPageElements().getPassword_txtBox().sendKeys("admin123");
            pom.getLoginPageElements().getLogin_btn().click();
            logger.info("Login successful with valid username and password.");
        } catch (Throwable t) {
            logger.error("Login failed with valid username and password: " + t.getMessage());
            throw t;
        }
    }

    @Test
    public void loginTestInValidPassword() {
        logger.info("Starting loginTestInValidPassword test...");
        try {
            pom.getLoginPageElements().getUsername_txtBox().sendKeys("Admin");
            pom.getLoginPageElements().getPassword_txtBox().sendKeys("password");
            pom.getLoginPageElements().getLogin_btn().click();
            logger.info("Login failed with invalid password.");
        } catch (Throwable t) {
            logger.error("Login failed with invalid password: " + t.getMessage());
            throw t;
        }
    }

    @Test
    public void loginTestInValidUsername() {
        logger.info("Starting loginTestInValidUsername test...");
        try {
            pom.getLoginPageElements().getUsername_txtBox().sendKeys("username");
            pom.getLoginPageElements().getPassword_txtBox().sendKeys("admin123");
            pom.getLoginPageElements().getLogin_btn().click();
            logger.info("Login failed with invalid username.");
        } catch (Throwable t) {
            logger.error("Login failed with invalid username: " + t.getMessage());
            throw t;
        }
    }

    @Test
    public void loginTestInValidUsernamePassword() {
        logger.info("Starting loginTestInValidUsernamePassword test...");
        try {
            pom.getLoginPageElements().getUsername_txtBox().sendKeys("username");
            pom.getLoginPageElements().getPassword_txtBox().sendKeys("password");
            pom.getLoginPageElements().getLogin_btn().click();
            logger.info("Login failed with invalid username and password.");
        } catch (Throwable t) {
            logger.error("Login failed with invalid username and password: " + t.getMessage());
            throw t;
        }
    }

    @AfterMethod
    public void tearDown() {
        logger.info("Tearing down test environment...");
        closeBrowser();
    }
}
