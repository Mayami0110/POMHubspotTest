package com.Hubspot.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Hubspot.qa.base.TestBase;
import com.Hubspot.qa.pages.HomePage;
import com.Hubspot.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initializations();
		
		loginPage = new LoginPage();
	}
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
	}
	
	@Test(priority=0)
	public void loginPageTitleTest() {
		
		
		
		String title=loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, prop.getProperty("loginTitle"));
	}
	
@Test(priority=1)
public void loginTest() {

	homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	
}

}
