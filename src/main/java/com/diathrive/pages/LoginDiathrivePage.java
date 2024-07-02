package com.diathrive.pages;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.diathrive.base.BasePage;
import com.diathrive.utilities.DiathriveUtilities;

public class LoginDiathrivePage {
	public static Logger log = Logger.getLogger(LoginDiathrivePage.class);
	WebDriver driver;
	public LoginDiathrivePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h2[text()='Login']//following-sibling::form//input[@name='login']")
	WebElement txtboxEmail;
	
	@FindBy(xpath="//h2[text()='Login']//following-sibling::form//input[@name='password']")
	WebElement txtboxPassword;
	
	@FindBy(xpath="//h2[text()='Login']//following-sibling::form//button")
	WebElement btnLogin;
	
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
	
	public String verifyWelcomePage() {
		return driver.getCurrentUrl();
	}
	
	By btnCloseUnlockSaleBy = By.xpath("//button[@id='button3']");
	By frameUnlockSalePopupBy = By.xpath("//iframe[@aria-label='Modal Overlay Box Frame']");
	
	public HomePage login() {
		HomePage homePage = new HomePage(driver);
		log.info("username ;");
		log.info("password ;");
		try {
			//homePage.clickLogin();
			setUserName();
			setPassword();
			signIn();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new HomePage(driver);
	}
	
	private void checkPopUpDisplayed() {
		BasePage basePage = new BasePage();
		if(basePage.fluentWait(frameUnlockSalePopupBy).isDisplayed()) {
			driver.switchTo().frame(driver.findElement(frameUnlockSalePopupBy));
			driver.findElement(btnCloseUnlockSaleBy).click();
		}
	}
	
	public void hardWait(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
