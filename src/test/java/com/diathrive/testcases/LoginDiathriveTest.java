package com.diathrive.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.diathrive.base.BasePage;
import com.diathrive.pages.HomePage;
import com.diathrive.pages.LoginDiathrivePage;
import com.diathrive.utilities.ExcelDataReader;


public class LoginDiathriveTest extends BasePage{
	public static Logger log = Logger.getLogger(LoginDiathriveTest.class);
	
	@DataProvider(name = "testData")
    public Object[][] testData() {
        return ExcelDataReader.getTestData(System.getProperty("user.dir")+"\\src\\main\\resources\\excels\\testdata.xlsx", "Sheet1");
    }
	
	//dataProvider = "testData" String username, String password
	@Test
	public void loginDiathriveTest() {
		LoginDiathrivePage loginPage = new LoginDiathrivePage(getDriver());
		System.out.println("username ;" );
		log.info("password ;" );
		HomePage homePage = loginPage.login();
		Assert.assertTrue(homePage.getHomePage().contains("My Account"),"Successfully logged in");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
