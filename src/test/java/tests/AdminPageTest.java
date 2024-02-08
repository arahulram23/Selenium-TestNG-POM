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

public class AdminPageTest extends BaseFunction {
    private static final Logger logger = LogManager.getLogger(AdminPageTest.class);
    private PageObjectManager pom;

    @BeforeMethod
    public void setUp() {
        logger.info("Setting up test environment...");
        String browser = ConfigReader.getInstance().getBrowser();
        driver = launchBrowser(browser);
        pom = new PageObjectManager(driver);
        navigateToURL(ConfigReader.getInstance().getURL());
        pom.getLoginPageElements().login(ConfigReader.getInstance().getUsername(), ConfigReader.getInstance().getPassword());
        pom.getHomePageElements().adminPage();
    }

    @AfterMethod
    public void tearDown() {
        logger.info("Tearing down test environment...");
        closeBrowser();
    }

    @Test
    public void urlTest() {
        logger.info("Executing urlTest...");
        String getUrl = getCurrentURL();
        logger.info("Current URL: {}", getUrl);
    }

    @Test
    public void adminBreadcrumbTest() {
        logger.info("Executing adminBreadcrumbTest...");
        String actual = pom.getAdminPageElements().getAdminPageBreadcrumb().getText();
        try {
            Assert.assertEquals(actual, "Admin", "Incorrect Breadcrumb value");
            logger.info("Breadcrumb value is correct.");
        } catch (AssertionError e) {
            logger.error("Incorrect Breadcrumb value: {}", actual);
            throw e;
        }
    }

    @Test
    public void verifyFooterLink() {
        logger.info("Executing verifyFooterLink...");
        String actual = pom.getAdminPageElements().getFooterHRMLink().getAttribute("href");
        try {
            Assert.assertEquals(actual, "http://www.orangehrm.com/", "The given link is broken or different");
            logger.info("Footer link is correct.");
        } catch (AssertionError e) {
            logger.error("The given link is broken or different: {}", actual);
            throw e;
        }
    }

    @Test
    public void verifyJobTitleHeading() {
        logger.info("Executing verifyJobTitleHeading...");
        pom.getAdminPageElements().getJobDropdownBtn().click();
        pom.getAdminPageElements().getJobTitleBtn().click();
        String actual = pom.getAdminPageElements().getJobTitleTableTitle().getText();
        try {
            Assert.assertEquals(actual, "Job Titles", "The Expected heading is different");
            logger.info("Job Title Heading is correct.");
        } catch (AssertionError e) {
            logger.error("The Expected heading is different: {}", actual);
            throw e;
        }
    }
}
