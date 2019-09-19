package com.tt.qa.scripts;

import org.openqa.selenium.By;

import com.tt.qa.common.CommonActions;




public class LoginPage extends CommonActions
{
	//public static WebDriver driver;	
	//public static Properties testConfig;
	public static String filepath = System.getProperty("user.dir") +"\\src\\test\\java\\com\\tt\\qa\\config\\Config.properties";
	CommonActions CommonActionskeys_obj = new CommonActions();

	public void User_loginPage_loginAs(String username, String password)
	{
		System.out.println("Start LoginAs Function ..");
		CommonActions.driver.findElement(By.id("UserName")).sendKeys(CommonActions.testConfig.getProperty(username));
		CommonActions.driver.findElement(By.id("txtPassword")).sendKeys(CommonActions.testConfig.getProperty(password));
		CommonActions.driver.findElement(By.id("btnLogin")).click();
	 }
	
	
	public String isLoginSuccessfulFor(String username)
	{
		String usertext = driver.findElement(By.xpath(testConfig.getProperty("accountholder_name"))).getText();
		System.out.println(usertext);
		if (driver.findElement(By.xpath(testConfig.getProperty("accountholder_name"))).getText().startsWith("Babita"))
		{
			System.out.println("Login Test PASSED!");
		}
		else
		{
			System.out.println("Login Test FAILED!");
		}
		System.out.println("------------------------------------------");
		return usertext;
		
    }
	
	
	
} 
