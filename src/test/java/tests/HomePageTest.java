package tests;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseFunction;
import com.qa.pages.PageObjectManager;
import com.qa.pages.HomePageElements;

public class HomePageTest extends BaseFunction {
    private static final Logger logger = LogManager.getLogger(HomePageTest.class);
    private PageObjectManager pom;
    private HomePageElements homePage;

    @BeforeMethod
    public void setUp() {
        logger.info("Setting up test environment...");
        String browser = "chrome";
        driver = launchBrowser(browser);
        pom = new PageObjectManager(driver);
        navigateToURL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        pom.getLoginPageElements().login("Admin", "admin123");
        homePage = pom.getHomePageElements(); // Instantiate HomePageElements once before tests
    }

    @AfterMethod
    public void tearDown() {
        logger.info("Tearing down test environment...");
        closeBrowser();
    }

    @Test
    public void verifyHomePageTitleTest() {
        logger.info("Executing verifyHomePageTitleTest...");
        String homePageTitle = getPageTitle();
        try {
            Assert.assertEquals(homePageTitle, "OrangeHRM", "Home page title not matched");
            logger.info("Home page title matched successfully.");
        } catch (AssertionError e) {
            logger.error("Home page title not matched.");
            throw e;
        }
    }

    @Test
    public void verifyAssignLeaveBtnTest() {
        logger.info("Executing verifyAssignLeaveBtnTest...");
        try {
            Assert.assertTrue(homePage.getAssignLeaveBtn().isDisplayed(), "The Assign Leave Button is not available");
            logger.info("Assign Leave Button is displayed.");
        } catch (AssertionError e) {
            logger.error("The Assign Leave Button is not available.");
            throw e;
        }
    }

    @Test
    public void verifyLeaveListBtnTest() {
        logger.info("Executing verifyLeaveListBtnTest...");
        try {
            Assert.assertTrue(homePage.getLeaveListBtn().isDisplayed(), "The Leave List Button is not available");
            logger.info("Leave List Button is displayed.");
        } catch (AssertionError e) {
            logger.error("The Leave List Button is not available.");
            throw e;
        }
    }

    @Test
    public void verifyApplyLeaveBtnTest() {
        logger.info("Executing verifyApplyLeaveBtnTest...");
        try {
            Assert.assertTrue(homePage.getApplyLeaveBtn().isDisplayed(), "The Apply Leave Button is not available");
            logger.info("Apply Leave Button is displayed.");
        } catch (AssertionError e) {
            logger.error("The Apply Leave Button is not available.");
            throw e;
        }
    }

    @Test
    public void verifyMyLeaveBtnTest() {
        logger.info("Executing verifyMyLeaveBtnTest...");
        try {
            Assert.assertTrue(homePage.getMyLeaveBtn().isDisplayed(), "The My Leave Button is not available");
            logger.info("My Leave Button is displayed.");
        } catch (AssertionError e) {
            logger.error("The My Leave Button is not available.");
            throw e;
        }
    }

    @Test
    public void verifyTimesheetsBtnTest() {
        logger.info("Executing verifyTimesheetsBtnTest...");
        try {
            Assert.assertTrue(homePage.getTimesheetsBtn().isDisplayed(), "The Timesheets Button is not available");
            logger.info("Timesheets Button is displayed.");
        } catch (AssertionError e) {
            logger.error("The Timesheets Button is not available.");
            throw e;
        }
    }

    @Test
    public void verifyMyTimesheetsBtnTest() {
        logger.info("Executing verifyMyTimesheetsBtnTest...");
        try {
            Assert.assertTrue(homePage.getMyTimesheetBtn().isDisplayed(), "The My Timesheets Button is not available");
            logger.info("My Timesheets Button is displayed.");
        } catch (AssertionError e) {
            logger.error("The My Timesheets Button is not available.");
            throw e;
        }
    }

    @Test
    public void verifyUsernameIsDisplayed() {
        logger.info("Executing verifyUsernameIsDisplayed...");
        String username = homePage.getUsername().getText();
        try {
            Assert.assertEquals(username, "Rahul", "Incorrect username is displayed");
            logger.info("Username is displayed correctly.");
        } catch (AssertionError e) {
            logger.error("Incorrect username is displayed.");
            throw e;
        }
    }
}
