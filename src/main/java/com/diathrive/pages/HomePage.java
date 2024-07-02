package com.diathrive.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
	By h1MyAccountBy = By.xpath("//h1[text()='My Account']");
	public String getHomePage() {
		ExpectedConditions.presenceOfElementLocated(h1MyAccountBy);
		return driver.findElement(h1MyAccountBy).getText().trim();
	}
	
	public void clickLogin() {
		btnGoToLogin.click();
		DiathriveUtilities diathriveUtilities = new DiathriveUtilities(driver);
		diathriveUtilities.isDisplayed(txtWelcomBack);
	}
}
