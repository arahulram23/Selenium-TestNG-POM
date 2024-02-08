package com.qa.base;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BaseFunction {
    protected WebDriver driver = null;

    public WebDriver launchBrowser(String option) {
        try {
            if (option.equalsIgnoreCase("chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized");
                driver = new ChromeDriver(options);
            } else if (option.equalsIgnoreCase("edge")) {
                EdgeOptions options = new EdgeOptions();
                options.addArguments("start-maximized");
                driver = new EdgeDriver(options);
            } else if (option.equalsIgnoreCase("firefox")) {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("start-maximized");
                driver = new FirefoxDriver(options);
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            return driver;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void closeBrowser() {
        try {
            if (driver != null) {
                driver.quit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void navigateToURL(String url) {
        try {
            if (driver != null) {
                driver.get(url);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void click(WebElement element) {
        try {
            if (element != null && driver != null) {
                element.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getPageTitle() {
        try {
            return driver.getTitle();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getCurrentURL() {
        try {
            return driver.getCurrentUrl();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
