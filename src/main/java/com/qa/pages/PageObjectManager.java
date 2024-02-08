package com.qa.pages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private final WebDriver driver;
    private HomePageElements homePageElements;
    private LoginPageElements loginPageElements;
    private AdminPageElements adminPageElements;

    public PageObjectManager(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver instance cannot be null");
        }
        this.driver = driver;
    }


    public HomePageElements getHomePageElements() {
        if (homePageElements == null) {
            synchronized (this) {
                if (homePageElements == null) {
                    homePageElements = new HomePageElements(driver);
                }
            }
        }
        return homePageElements;
    }


    public LoginPageElements getLoginPageElements() {
        if (loginPageElements == null) {
            synchronized (this) {
                if (loginPageElements == null) {
                    loginPageElements = new LoginPageElements(driver);
                }
            }
        }
        return loginPageElements;
    }


    public AdminPageElements getAdminPageElements() {
        if (adminPageElements == null) {
            synchronized (this) {
                if (adminPageElements == null) {
                    adminPageElements = new AdminPageElements(driver);
                }
            }
        }
        return adminPageElements;
    }
}
