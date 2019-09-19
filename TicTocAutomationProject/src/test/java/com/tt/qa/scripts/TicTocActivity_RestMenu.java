package com.tt.qa.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tt.qa.common.CommonActions;

public class TicTocActivity_RestMenu extends CommonActions{
	
	 public static String Screenshot_filepath = System.getProperty("user.dir") +"\\ScreenShots\\";	
	 public String today;
	 WebDriverWait wait = new WebDriverWait(driver,20);
	 Actions action = new Actions(driver);
	 CommonActions CommonActionskeys_obj = new CommonActions();
	 
	 public void admin_click_on_Reset_button() throws InterruptedException
	 {
		    Thread.sleep(3000);
			CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("act_activityBtn"))).click();
			
			// click on reset tab
			Thread.sleep(3000);
			CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("actvty_rsetBtn"))).click();
			
			Thread.sleep(2000);
	    	WebElement left_Caldate=CommonActions.driver.findElement(
	    			By.xpath(CommonActions.testConfig.getProperty("actvty_apprvCaldateWidgetPrev")));
	    	System.out.println("Prev Selected date is :" + left_Caldate.getText());

	    	try
	    	{
	    		wait.until(ExpectedConditions.visibilityOfElementLocated(
	    				By.xpath(CommonActions.testConfig.getProperty("actvty_apprvCaldateWidgetPrev"))));	
	    		action.moveToElement(left_Caldate).build().perform();
	    		left_Caldate.click();
	    		try {
	    			Thread.sleep(4000);
	    		} catch (InterruptedException e) {
	    			e.printStackTrace();
	    		}
	    	}catch(org.openqa.selenium.StaleElementReferenceException ex){
	    	}
	    	Thread.sleep(2000);
	    	WebElement right_Caldate=CommonActions.driver.findElement(
	    			By.xpath(CommonActions.testConfig.getProperty("actvty_apprvCaldateWidgetNext")));
	    	System.out.println("Next Selected date is :" + right_Caldate.getText());
	    	try {
	    		wait.until(ExpectedConditions.visibilityOfElementLocated(
	    				By.xpath(CommonActions.testConfig.getProperty("actvty_apprvCaldateWidgetNext"))));
	    		action.moveToElement(right_Caldate).build().perform();
	    		right_Caldate.click();

	    		try {
	    			Thread.sleep(4000);
	    		} catch (InterruptedException e) {
	    			e.printStackTrace();
	    		}
	    	}catch(org.openqa.selenium.StaleElementReferenceException ex){
	    	}
	    	String Text = CommonActions.driver.findElement(
	    			By.xpath(CommonActions.testConfig.getProperty("actvty_apprvSelectedDates"))).getText();
	    	if(Text.contains("05/22/2019 - 06/21/2019"))
	    	{
	    		CommonActions.driver.findElement(
	    				By.xpath(CommonActions.testConfig.getProperty("actvty_apprvApplyBtn"))).click();
	    		Thread.sleep(3000);
	    	}
	    	else
	    	{
	    		Thread.sleep(3000);
	    		CommonActions.driver.findElement(
	    				By.xpath(CommonActions.testConfig.getProperty("actvty_apprvCancelBtn"))).click();
	    	}
			  
	    	CommonActions.click_on_search_button_To_view_data();
	    	Thread.sleep(2000);
	    	CommonActions.enterText_into_Search_textBox("actvty_apprvSrchTxtBx", "babita");
	    	CommonActions.validate_isRowCellEmpty_inTable("actvty_apprvtblActivityData", "Babita Thakur-71156");
	 }
}
