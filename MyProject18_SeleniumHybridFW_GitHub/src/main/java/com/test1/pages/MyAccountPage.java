package com.test1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends PageBase {
	
	// ################ NOTES  ################
	// Generally, we need to find web elements and perform required actions on them as per multiple test cases to test a web page or feature
	// Examples: 1) MyAccountPage => Test login by entering only user name
	// 			 2) MyAccountPage => Test login without user name or password
	// We don’t want our web element => find strategy to be scattered across different methods in a page class
	// We need one single web element instance with find strategy to represent the web element and using that we can perform multiple actons as per differetnt test cases
	// That’s why we have Page Factory
	
	@FindBy(id="login")
	private WebElement loginButton;
	
	@FindBy(id="username")
	private WebElement username;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="user_info")
	private WebElement userInfo;
	
//	@FindBy(id="order")
//	private WebElement userOrders;
	
	
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	public MyAccountPage loginAs(String username, String password)
	{
		this.username.sendKeys(username);
		this.password.sendKeys(password);
		this.loginButton.click();
		
		return new MyAccountPage(driver);
	}
	
	public boolean isLoginSuccessful(String username)
	{
		return this.userInfo.getText().contains(username);
	}
	
	public MyAccountPage tryLoginWithUsernameOnly(String username)
	{
		this.username.sendKeys(username);
		this.loginButton.click();
				
		return new MyAccountPage(driver);
	}
	
	public MyAccountPage tryLoginWithNoInput()
	{
		this.loginButton.click();
		
		return new MyAccountPage(driver);
	}

}
