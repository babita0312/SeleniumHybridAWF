package com.tt.qa.scripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tt.qa.common.CommonActions;

public class TicTocActivity_ApprovalsMenu extends CommonActions
{
	 public String today;
	 WebDriverWait wait = new WebDriverWait(driver,20);
	 Actions action = new Actions(driver);
	 public static String Screenshot_filepath = System.getProperty("user.dir") +"\\ScreenShots\\"; 	
	 CommonActions CommonActionskeys_obj = new CommonActions();

	 
	public void admin_click_on_approvalsTab_toApprove_UserActivity() throws InterruptedException
	{
		Thread.sleep(3000);
		CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("act_activityBtn"))).click();
		Thread.sleep(2000);
		CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("actvty_approveBtn"))).click();	
	}
	
	public void admin_click_on_CalendarTab_toSlelectCustomRange_and_pickDates() throws InterruptedException
	{
		Thread.sleep(4000);
		CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("actvty_apprvCalendarBx"))).click();
	    WebElement customeRange = CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("actvty_apprvCal_CustomRange")));
		Thread.sleep(3000);					
	    customeRange.click();
	 }
		
    public void admin_select_StartDate_and_endDate_from_Cal() throws InterruptedException
    {

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
    
    public void admin_click_on_rejectButton() throws InterruptedException
    {
    	Thread.sleep(2000);
    	
    	WebElement rjctbutton = CommonActions.driver.findElement(
				By.xpath(CommonActions.testConfig.getProperty("actvty_apprvRejctBtn")));
        rjctbutton.click();
        Thread.sleep(2000);
    	
        // Validation text before click on chkbox button 
    	String text = CommonActions.driver.findElement(
				By.xpath(CommonActions.testConfig.getProperty("actvty_apprvValidateTx"))).getText();
    	if(text.trim().contains("Please select an activity and then click the reject button."))
    	{
    		System.out.println("Validation is :" + text);
    	}
    	
    	// click on Checkbox before click on reject button
    	CommonActions.driver.findElement(
				By.xpath(CommonActions.testConfig.getProperty("actvty_apprvCheckbx"))).click();
    	Thread.sleep(2000);
    	rjctbutton.click();
    	
    	// Reason_popUp window displayed
    	
    	
    	CommonActions.driver.findElement(
				By.xpath(CommonActions.testConfig.getProperty("actvty_apprvSubmitbtn"))).click();
    	
    	text = CommonActions.driver.findElement(
				By.xpath(CommonActions.testConfig.getProperty("actvty_apprvValidateTx"))).getText();
    		Thread.sleep(3000);
    	
    	if(text.trim().contains("Please enter the reason for rejecting the activity."))
    	{
    		System.out.println("Please enter the reason for rejecting the activity.");  
    		Thread.sleep(3000);
    		CommonActions.driver.findElement(
    				By.xpath(CommonActions.testConfig.getProperty("actvty_apprvReason_popUpwin"))).sendKeys("Incorrect User actvity.");
    		//CommonActionskeys_obj.takeScreenshot("valid_UserName" , Screenshot_filepath);
    		Thread.sleep(3000);
    	}
    	Thread.sleep(3000);
    	CommonActions.driver.findElement(
				By.xpath(CommonActions.testConfig.getProperty("actvty_apprvCancelbtn"))).click();
    	
    }
    
    public void admin_click_on_edit_Button_to_Edit_UserActivity() throws InterruptedException
    {
    	Thread.sleep(3000);
    	CommonActions.driver.findElement(
				By.xpath(CommonActions.testConfig.getProperty("actvty_apprvEditbtn"))).click();
    	Thread.sleep(3000);
    	
    	System.out.println("Admin is on :" + CommonActions.driver.findElement(
				By.xpath(CommonActions.testConfig.getProperty("actvty_apprvActivityEdit_pageHeadrTxt"))).getText() + "Page");
    	
    	System.out.println("User Name :" + CommonActions.driver.findElement(
				By.xpath(CommonActions.testConfig.getProperty("actvty_apprvActivityEdit_username"))).getText());
    	System.out.println("supervisor is :" + CommonActions.driver.findElement(
				By.xpath(CommonActions.testConfig.getProperty("actvty_apprvActivityEdit_supervisor"))).getText());
    	System.out.println("Manager is :" + CommonActions.driver.findElement(
				By.xpath(CommonActions.testConfig.getProperty("actvty_apprvActivityEdit_manager"))).getText());    	
    	System.out.println("Today date is :" + CommonActions.driver.findElement(
				By.xpath(CommonActions.testConfig.getProperty("actvty_apprvActivityEdit-date"))).getText());
    	System.out.println("Today date is :" + CommonActions.driver.findElement(
				By.xpath(CommonActions.testConfig.getProperty("actvty_apprvActivityEdit_timezone"))).getText());
    	
    	// Calendar date 
    	String calDate = CommonActions.driver.findElement(
				By.xpath(CommonActions.testConfig.getProperty("actvty_apprvActvtyEdit_calDate"))).getAttribute("value");
    	
    	System.out.println("Actvity date is :" + calDate);
    	
    	// Selecting AutoApproval CheckBox		
    	WebElement chkbx_button = CommonActions.driver.findElement(
				By.xpath(CommonActions.testConfig.getProperty("actvty_apprvActivityEdit_chkbx")));    		
    
 //*** 	System.out.println(chkbx_button.isDisplayed() + " ::" + chkbx_button.isEnabled() + " ");
    	try {
    		
    		wait.until(ExpectedConditions.presenceOfElementLocated(
    				By.xpath(CommonActions.testConfig.getProperty("actvty_apprvActivityEdit_chkbx"))));
    		
    		action.moveToElement(chkbx_button).build().perform();
    		Thread.sleep(3000);
    	    chkbx_button.click();
    	}
    	catch(Exception ex){
    	}
    	
    	// Submit button 
    	Thread.sleep(3000);
    	CommonActions.driver.findElement(
    			               By.xpath(CommonActions.testConfig.getProperty("actvty_apprvActvtyEdit_submit"))).click();
    	
    	//cancel button
    	Thread.sleep(3000);
    	CommonActions.driver.findElement(
    			               By.xpath(CommonActions.testConfig.getProperty("actvty_apprvCanclbtn"))).click();
    	
    	}
 
	
}
