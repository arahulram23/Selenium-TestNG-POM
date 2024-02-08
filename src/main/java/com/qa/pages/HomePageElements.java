package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageElements {

	private WebDriver driver;

	public HomePageElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@title='Assign Leave']")
	private WebElement assignLeaveBtn;

	@FindBy(xpath = "//button[@title='Leave List']")
	private WebElement leaveListBtn;

	public WebElement getAssignLeaveBtn() {
		return assignLeaveBtn;
	}

	public WebElement getLeaveListBtn() {
		return leaveListBtn;
	}

	public WebElement getTimesheetsBtn() {
		return timesheetsBtn;
	}

	public WebElement getApplyLeaveBtn() {
		return applyLeaveBtn;
	}

	public WebElement getMyLeaveBtn() {
		return myleaveBtn;
	}

	public WebElement getMyTimesheetBtn() {
		return myTimesheetBtn;
	}

	public WebElement getUsername() {
		return username;
	}

	/**
	 * @return the maintenancePageBtn
	 */
	public WebElement getMaintenancePageBtn() {
		return maintenancePageBtn;
	}

	/**
	 * @return the adminPageBtn
	 */
	public WebElement getAdminPageBtn() {
		return adminPageBtn;
	}

	@FindBy(xpath = "//button[@title='Timesheets']")
	private WebElement timesheetsBtn;
	@FindBy(xpath = "//button[@title='Apply Leave']")
	private WebElement applyLeaveBtn;
	@FindBy(xpath = "//button[@title='My Leave']")
	private WebElement myleaveBtn;
	@FindBy(xpath = "//button[@title='My Timesheet']")
	private WebElement myTimesheetBtn;
	@FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
	private WebElement username;

	@FindBy(xpath = "//span[text()='Maintenance']")
	private WebElement maintenancePageBtn;

	@FindBy(xpath = "//span[text()='Admin']")
	private WebElement adminPageBtn;

	public AdminPageElements adminPage() {
		getAdminPageBtn().click();
		return new AdminPageElements(driver);
	}

}
