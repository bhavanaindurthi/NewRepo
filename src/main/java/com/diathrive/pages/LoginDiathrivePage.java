package com.diathrive.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginDiathrivePage {
	public static Logger log = Logger.getLogger(LoginDiathrivePage.class);
	WebDriver driver;
	
	/**
	 * page factory method to initialize driver at class level at the time object creation
	 * @param driver
	 */
	public LoginDiathrivePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//************************** page object factory annotationn to create element with xpaths- **********************************
	// ************************ in future we change this to By class to remove dependency of waiting element until it is found by @FindBy annotation***********
	// follow convention of java and best practices from solid design pattern 

	@FindBy(xpath="//h2[text()='Login']//following-sibling::form//input[@name='login']")
	WebElement txtboxEmail;
	
	@FindBy(xpath="//h2[text()='Login']//following-sibling::form//input[@name='password']")
	WebElement txtboxPassword;
	
	@FindBy(xpath="//h2[text()='Login']//following-sibling::form//button")
	WebElement btnLogin;
	
	By btnCloseUnlockSaleBy = By.xpath("//button[@id='button3']");
	By frameUnlockSalePopupBy = By.xpath("//iframe[@aria-label='Modal Overlay Box Frame']");
	
	public void signIn() {
		btnLogin.click();
		hardWait(3);
	}
	
	public void setUserName() {
		txtboxEmail.sendKeys("ravinskanni@gmail.com");
		ExpectedConditions.visibilityOf(txtboxEmail);
	}
	
	public void setPassword() {
		txtboxPassword.sendKeys("abcd@123E");
		ExpectedConditions.visibilityOf(txtboxPassword);
	}
	
	public String getWelcomePageURL() {
		return driver.getCurrentUrl();
	}
	
	// in future we will get rid of using exception blocks which are un-necessary, how to find that we see
	public HomePage login() {
		log.info("username ;");
		log.info("password ;");
		try {
			setUserName();
			setPassword();
			signIn();
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new HomePage(driver);
	}
	
	public void hardWait(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
