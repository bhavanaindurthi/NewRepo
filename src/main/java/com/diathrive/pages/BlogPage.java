package com.diathrive.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BlogPage {
	public static Logger log = Logger.getLogger(LoginDiathrivePage.class);
	WebDriver driver;
	
	/**
	 * page factory method to initialize driver at class level at the time object creation
	 * @param driver
	 */
	public BlogPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul[@class='header-nav-section']//*[@href='https://diathrive.com/resources']")
	WebElement lnkHeaderResources;
	
	@FindBy(xpath="//ul[@class='header-nav-section']//*[@href='https://diathrive.com/blog']")
	WebElement lnkBlog_UnderResources;
	
	public String getBlogPageURL() {
		return driver.getCurrentUrl();
	}
}
