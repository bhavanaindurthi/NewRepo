package com.diathrive.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.diathrive.utilities.DiathriveUtilities;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='account-history-empty-button']/a")
	private WebElement btnGoToLogin;
	
	@FindBy(xpath="//h2[text()='Welcome back']")
	private WebElement txtWelcomBack;
	
	@FindBy(xpath="//ul[@class='header-nav-section']//*[@href='https://diathrive.com/resources']")
	WebElement lnkHeaderResources;
	
	@FindBy(xpath="//ul[@class='header-nav-section']//*[@href='https://diathrive.com/blog']")
	WebElement lnkBlog_UnderResources;
	
	By h1MyAccountBy = By.xpath("//h1[text()='My Account']");
	public String getHomePage() {
		ExpectedConditions.presenceOfElementLocated(h1MyAccountBy);
		ExpectedConditions.presenceOfElementLocated(h1MyAccountBy);
		return driver.findElement(h1MyAccountBy).getText().trim();
	}
	
	public void clickLogin() {
		btnGoToLogin.click();
		DiathriveUtilities diathriveUtilities = new DiathriveUtilities(driver);
		diathriveUtilities.isDisplayed(txtWelcomBack);
	}
	public BlogPage gotToBlog() {
		moveToElement(lnkHeaderResources);
		ExpectedConditions.visibilityOf(lnkBlog_UnderResources);
		clickOnBlogLink(lnkBlog_UnderResources);
		return new BlogPage(driver);
	}
	public void moveToElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	public void clickOnBlogLink(WebElement element) {
		lnkBlog_UnderResources.click();
	}
}
