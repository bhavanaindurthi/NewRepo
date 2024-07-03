package com.diathrive.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.diathrive.base.BasePage;
import com.diathrive.pages.BlogPage;
import com.diathrive.pages.HomePage;
import com.diathrive.pages.LoginDiathrivePage;
import com.diathrive.utilities.ExcelDataReader;

public class BlogTest extends BasePage{
public static Logger log = Logger.getLogger(LoginDiathriveTest.class);
	
	@DataProvider(name = "testData")
    public Object[][] testData() {
        return ExcelDataReader.getTestData(System.getProperty("user.dir")+"\\src\\main\\resources\\excels\\testdata.xlsx", "Sheet1");
    }
	
	//dataProvider = "testData" String username, String password
	@Test
	public void verifyBlogNavigation() {
		LoginDiathrivePage loginPage = new LoginDiathrivePage(getDriver());
		log.info("verify blog page navigation!");
		HomePage homePage = loginPage.login();
		Assert.assertTrue(homePage.getHomePage().contains("My Account"),"Successfully logged in");
		BlogPage blogPage = homePage.gotToBlog();
		Assert.assertTrue(blogPage.getBlogPageURL().contains("https://diathrive.com/blog"),"Successfully logged in");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
