package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.base.BaseFunction;

public class LoginPageElements extends BaseFunction {
    private WebDriver driver;

    @FindBy(xpath = "//input[@name='username']")
    private WebElement username_txtBox;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement password_txtBox;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement login_btn;

    @FindBy(xpath = "//p[text()='Invalid credentials']")
    private WebElement error_message;

    public LoginPageElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getError_message() {
        return error_message;
    }

    public WebElement getUsername_txtBox() {
        return username_txtBox;
    }

    public WebElement getPassword_txtBox() {
        return password_txtBox;
    }

    public WebElement getLogin_btn() {
        return login_btn;
    }

    public HomePageElements login(String username, String password) {
        getUsername_txtBox().sendKeys(username);
        getPassword_txtBox().sendKeys(password);
        getLogin_btn().click();
        return new HomePageElements(driver);
    }
}
