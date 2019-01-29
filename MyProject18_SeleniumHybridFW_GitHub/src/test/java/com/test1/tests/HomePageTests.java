package com.test1.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test1.pages.HomePage;

public class HomePageTests extends TestBase {
	

	@Test(priority =1)
	public void testPageTitle()
	{
		String actualTitle = homePG.getTitle();
		test.pass("Get the home page title");
		test.info("Page title Value :" + actualTitle );
		
		Assert.assertEquals(actualTitle, 
				"ABSoft Trainings – E-Commerce test web site | Home Page_Fail",
				"Title is not correct");
	}
	
	//@Test
	public void newTest()
	{
		
	}

}
