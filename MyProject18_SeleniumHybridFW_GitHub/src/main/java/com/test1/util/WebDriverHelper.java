package com.test1.util;

import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
public class WebDriverHelper 
{
	public static WebDriver createDriver(String browser)
	{
		WebDriver driver=null;
		
		
		if(browser.equalsIgnoreCase("Firefox"))
		{
			// Firefox Browser Setup
			// Change gecko driver location as per your local folder path
			System.setProperty("webdriver.gecko.driver","F:\\17Oct18_Selenium_Batch\\Software\\geckodriver-v0.23.0-win64\\geckodriver.exe");
			//FirefoxOptions fo = new FirefoxOptions();
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("Chrome"))
		{
			// Chrome Browser Setup
			// Change chrome driver location as per your local folder path
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Babita\\Downloads\\chromedriver.exe");
			//ChromeOptions co = new ChromeOptions();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("IE"))
		{
			// IE Browser Setup
			/*
			 * We need to do following setup in IE before running Selenium scripts in IE
			 * 1) Internet Options => Security Tab => Enable Protected Mode must be enabled or disabled for all zones
			 * 2) IE Zoom level must be set to 100% only
			 */
			// Change IE driver location as per your local folder path
			System.setProperty("webdriver.ie.driver","F:\\17Oct18_Selenium_Batch\\Software\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
			//InternetExplorerOptions ieo = new InternetExplorerOptions();
			driver = new InternetExplorerDriver();
		}
		else
		{
			throw new InvalidParameterException(browser + " - is not a valid web browser for web driver.");
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}
	
	public static void quitDriver(WebDriver driver)
	{
		// Do all clean up logic
		driver.quit();
	}
	
	public static void getScreenShot(WebDriver driver , String filePath) throws IOException
	{

	   File imgFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	  //save the browser screenshot file to new file with the specified location
	
	    FileUtils.copyFile(imgFile,new File(filePath));
	}
} 
		
