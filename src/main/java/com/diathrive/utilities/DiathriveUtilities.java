package com.diathrive.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DiathriveUtilities {
	WebDriver driver;
	WebDriverWait wait; 
	public DiathriveUtilities(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isDisplayed(WebElement element) {
		wait = wait = new WebDriverWait(driver, 10);;
		wait.until(ExpectedConditions.visibilityOf(element));
		return true;
	}
	
	public boolean isElementLocated(By xpath) {
		wait = wait = new WebDriverWait(driver, 10);;
		wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
		return true;
	}
}
