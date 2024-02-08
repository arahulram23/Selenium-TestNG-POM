package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseFunction;

public class AdminPageElements extends BaseFunction {
	private WebDriver driver;

	public AdminPageElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='oxd-topbar-header-breadcrumb']/child::h6")
	private WebElement adminPageBreadcrumb;

	public WebElement getAdminPageBreadcrumb() {
		return adminPageBreadcrumb;
	}

	@FindBy(xpath = "//a[text()='OrangeHRM, Inc']")
	private WebElement footerHRMLink;

	public WebElement getFooterHRMLink() {
		return footerHRMLink;
	}

	@FindBy(xpath = "//a[text()='Job Titles']")
	private WebElement jobTitleBtn;
	
	@FindBy(xpath="(//nav[@role='navigation'])[2]//child::li[2]")
	private WebElement jobDropdownBtn;
	
	@FindBy(xpath="//h6[text()='Job Titles']")
	private WebElement jobTitleTableTitle;


	public WebElement getJobTitleBtn() {
		return jobTitleBtn;
	}


	public WebElement getJobDropdownBtn() {
		return jobDropdownBtn;
	}


	public WebElement getJobTitleTableTitle() {
		return jobTitleTableTitle;
	}


}
