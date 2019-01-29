package com.test1.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test1.pages.HomePage;
import com.test1.util.DataDrivenHelper;

public class MyAccountPageTests extends TestBase{
	
	// ################ NOTES  ################
	// Data Driven Framework or Data Driven Testing refers to running the same test multiple times with different input datasets.
	// These datasets are often stored in external sources like excel file, xml file, text file, and database.
	// The Data Driven Framework provides mainly following benefits. It reduces maintenance and improves test coverage :
	// 	1) Repeat the test script for different test datasets
	// 	2) Reuse the test code
	
//	@Test(dataProvider="dataProvider")
	public void testSuccessfulLogin(String username, String password)
	{
				boolean testResult =  homePG
											.clickMyAccountLink()
											.loginAs(username, password)
											.isLoginSuccessful(username);
				// 1) Standard User, 2) Store Manager, 3) Store Admin, 4) Store Contributor
				
				Assert.assertTrue(testResult, "Login Test FAILED, can't find username in user info section");
	}
	

	@Test
	public void testPageTitle()
	{
		String actualTitle = homePG
									.clickMyAccountLink()
									.getTitle();
		
		Assert.assertEquals(actualTitle, 
				"My Account | ABSoft Trainings – E-Commerce test web site",
				"Title is not correct");
	}
	
//	@Test
//	public void testCheckLostPasswordLink()
//	{
//		homePG.clickMyAccountLink().
//	}
	
}
