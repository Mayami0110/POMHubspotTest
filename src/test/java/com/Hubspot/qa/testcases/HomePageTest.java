package com.Hubspot.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Hubspot.qa.base.TestBase;
import com.Hubspot.qa.pages.HomePage;
import com.Hubspot.qa.pages.LoginPage;
import com.Hubspot.qa.pages.NewCustomerPage;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	NewCustomerPage newCustomer;
	
	public HomePageTest() {
		
		super();
	}
	
	//testcases should be independent from each other
	
	@BeforeMethod
	public void setup() {
		initializations();
		
		loginPage = new LoginPage();
		homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		
		String homePageTitle= homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, prop.getProperty("homePageTitle"),"HomePageTitle is Not matching");
		
	}
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		
		Assert.assertTrue(homePage.verifyCorrectUserName(), "User Name is not Correct");
	}
	
	@Test(priority=3)
	public void verifyNewCustomerTest() {
		
		newCustomer= homePage.clickOnNewCustomerLink();
	}
	
	
	
	
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
	}

}
