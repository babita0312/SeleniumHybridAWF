package com.tt.qa.scripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.tt.qa.common.CommonActions;

public class TicToc_Activity_Menu extends CommonActions
{
	//public static WebDriver driver;  
	public String today;
	private WebElement cell;
	public String celtext;
	public static String Screenshot_filepath = System.getProperty("user.dir") +"\\ScreenShots\\";
	public static String filepath = System.getProperty("user.dir") +"\\src\\test\\java\\com\\tt\\qa\\config\\Config.properties";

	CommonActions CommonActionskeys_obj = new CommonActions();

	public void user_clicks_on_ActivityDate_Entry_Caledar_field_EnterDate_clicks_on_Search_button_and_validates_validation_tblActvityData() throws Throwable
	{
		Thread.sleep(3000);
		CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("act_activityBtn"))).click();
        today = getCurrentDay(); 
        System.out.println("Today's Date: " + today + "\n");        
        try
         {
        	Thread.sleep(3000);
         CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("act_datepickers"))).click();
          WebElement dateWidgetFrom = CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("act_datepickers_table")));
          List<WebElement> rows = dateWidgetFrom.findElements(By.tagName("tr"));
          List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
         for (WebElement cell: columns) {
        	/*If you want to click 18th Date
            if (cell.getText().equals("18")) {
            	cell.click();
                break;
            }*/
            if (cell.getText().equals(today)) {
                cell.click();
                break;
            }
         }
         try {
        	 Thread.sleep(4000);
         } catch (InterruptedException e) {
        	 e.printStackTrace();
         }
       }
       catch(org.openqa.selenium.StaleElementReferenceException ex){
       }    
         
        try {
        Thread.sleep(4000);
         CommonActions.click_on_search_button_To_view_data();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex){
        	
  	  }
      // CommonActionskeys_obj.takeScreenshot("valid_UserName" , Screenshot_filepath);
       Thread.sleep(3000);
	}
	
	
	
	public void user_click_on_Copy_Actvity_Calendar_to_copy_actvity_from_privious_date() throws InterruptedException
	{
		Thread.sleep(3000);
		CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("act_copyActivity_datepickers"))).click();
        WebElement dateWidgetFrom = CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("act_copyActivity_datepickers_table")));
        List<WebElement> rows = dateWidgetFrom.findElements(By.tagName("tr"));
        List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
        for (WebElement cell: columns) {
            if (cell.getText().equals("5"))
            {
               cell.click();
               break;
            } 
        }
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
       }
        Thread.sleep(3000);         
	 }
	
	   
	  
	public void user_click_on_Copy_Actvities_button_and_validates_validation_Message()throws InterruptedException
	   {
		  Thread.sleep(3000);
		  CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("act_copyactivityBtn"))).click();
		  Thread.sleep(1000);
		  try
		  {
		     String validation_NotificationTxt = CommonActions.driver.findElement(
				                                   By.xpath(CommonActions.testConfig.getProperty("act_copyactivityBtnNotificationTxt"))).getText();
		 
		  // System.out.println(validation_NotificationTxt);
		   
		   if(validation_NotificationTxt.equalsIgnoreCase(validation_NotificationTxt))
		   {
			   System.out.println("User Clicks on CopyActivies Button to check whether entry is availabale :" + validation_NotificationTxt);
		   }
		   else{
			   System.out.println("Please try adding new activities manually.");
		   }
		 }
		 catch(org.openqa.selenium.NoSuchElementException ex) {			  
		  }
	   }
	public static void user_clicks_on_Clear_button() throws Throwable
	     {
	 		Thread.sleep(3000);
	 		WebElement clear_btn = CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("activity_clear_btn")));
	 		
	 		try{	 			
	 		clear_btn.click();
	 		String Actual = CommonActions.driver.findElement(By.xpath("activity_datatableSearchTxt")).getText();
	 		String Expected= "";
	 		if(Actual.contains(Expected))
	 		{
	 		  System.out.println("Clear button successfully clears all textboxes data");
	 		}
	 		else{
	 		    System.out.println("Clear button doesn't clear the data in all textboxes");
	 		}
	 		
	      }
	 		catch(Exception ex){
	 			
	 		}
     
	     }
     public void user_clicks_on_AddNew_Activity_button_enters_Mandatory_fields_clicks_on_ADD_button_and_validates_validation_Message() throws InterruptedException
      {
	     Thread.sleep(5000);
	     CommonActions.driver.findElement(By.id("btnActivityAdd")).click();
	     String actual_EmployeeText =  CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("activity_addNewBtn_UserTxt"))).getText().trim();
	    // System.out.println("actual_EmployeeText is :" + actual_EmployeeText);
	     
	     String expected_EmployeeText = CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("activity_addNewBtn_ExpectedTxt"))).getText();
	   // System.out.println("expected_EmployeeText is :" + expected_EmployeeText);
		 if(actual_EmployeeText.contains(expected_EmployeeText))
		  {
			System.out.println(" Authentication Successful " + actual_EmployeeText);
		  }
		 else {
		    System.out.println("Invalid User Name " + expected_EmployeeText);	
		  }
		
		System.out.println("Supervisor is: " + CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("activity_addNewBtn_SupervisorTxt"))).getText());
		System.out.println("Date :" + CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("activity_addNewBtn_DateTxt"))).getText());
		System.out.println("Time Zone :" + CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("activity_addNewBtn_timeZoneTxt"))).getText());
		System.out.println("Manager : " + CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("activity_addNewBtn_Managertxt"))).getText());
		WebElement element = CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("activity_addNewBtn_chkboxAutoApprovebtn")));
		boolean status = element.isEnabled();
		// Check that if the Text field is enabled, if yes enter value
		if(status){
		    element.click();
		}		
		else
		{
			System.out.println("AutoApproval checkbox is Not Enabled ");
		}
			
	   
	   
	   try {
           Thread.sleep(2000);
       } catch (InterruptedException e) {
           e.printStackTrace();
      }
  }
	   
     public void user_choose_project_Activity_from_activity_dropdown_list() throws InterruptedException
     {
    	 // Again click on copy button without copy the date from 
    	 Thread.sleep(5000);
    	 CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("actvity_addNewBtn_copybtn"))).click();
    	 String validation_NotificationTxt = CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("activity_copyactivityBtnvalidationTxt"))).getText();

    	 System.out.println("..............Please fill in all the mandatory fields.......!");
    	 if(validation_NotificationTxt.contains("Please fill in all the mandatory fields before clicking the 'Add Activity' button")) 
    	 {
    		 String searchText = "Project Activity";
    		 WebElement dropdown = CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("activity_projectActivityTab"))); 
    		 dropdown.click(); // assuming you have to click the "dropdown" to open it
    		 List<WebElement> options = dropdown.findElements(By.xpath(CommonActions.testConfig.getProperty("activity_projectActivity_list")));
    		 for (WebElement option : options)
    		 {
    			 System.out.println("----------- "+option.getText());
    			 if (option.getText().contains(searchText))
    			 {
    				 option.click(); // click the desired option
    				 break;
    			 }
    		 }

    		 Thread.sleep(2000);
    		 String searchText1 = "Age of Learning";
    		 WebElement dropdown_1 = CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("activity_clientsTab"))); 
    		 dropdown_1.click();
    		 List<WebElement> clientsList = CommonActions.driver.findElements(By.xpath(CommonActions.testConfig.getProperty("activity_clientsTab_list")));
    		 for(WebElement list : clientsList)
    		 {
    			 if (list.getText().contains(searchText1))
    			 {
    				 list.click(); // click the desired option
    				 break;
    			 }
    		 }

    		 Thread.sleep(2000);
    		 String searchText2 = "ABCmouse";	  
    		 WebElement dropdown_2  = CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("activity_projectTab")));
    		 dropdown_2.click();
    		 List<WebElement> projectList = CommonActions.driver.findElements(By.xpath(CommonActions.testConfig.getProperty("activity_projectTab_list")));
    		 for(WebElement list : projectList)
    		 {
    			 if (list.getText().contains(searchText2))
    			 {
    				 Thread.sleep(2000);
    				 list.click(); // click the desired option
    				 break;
    			 }
    		 }

    		 Thread.sleep(2000);
    		 String searchText3 = "Bangalore";
    		 WebElement dropdown_3 = CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("activity_loactionsTab")));
    		 dropdown_3.click();
    		 List<WebElement> location_list = CommonActions.driver.findElements(By.xpath(CommonActions.testConfig.getProperty("activity_loactionsTab_list"))); 
    		 for(WebElement list : location_list)
    		 {
    			 if (list.getText().contains(searchText3))
    			 {
    				 list.click(); // click the desired option
    				 break;
    			 }
    		 }

    		 Thread.sleep(2000);
    		 String searchText4 = "Admin";
    		 WebElement dropdown_4 = CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("activity_workTypeTab"))); 
    		 dropdown_4.click();
    		 List<WebElement> work_Typelist = CommonActions.driver.findElements(By.xpath(CommonActions.testConfig.getProperty("activity_workTypeTab_list"))); 
    		 for(WebElement list : work_Typelist)
    		 {
    			 if (list.getText().contains(searchText4))
    			 {
    				 Thread.sleep(2000);
    				 list.click(); // click the desired option
    				 break;
    			 }
    		 }

    		 Thread.sleep(2000);
    		 String searchText5 = "Non-Billable";
    		 WebElement dropdown_5 = CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("activity_billingTab"))); 
    		 dropdown_5.click();
    		 Thread.sleep(2000);
    		 List<WebElement> billing_Typelist = CommonActions.driver.findElements(By.xpath(CommonActions.testConfig.getProperty("activity_billingTab_list")));
    		 for(WebElement list : billing_Typelist)
    		 {
    			 if (list.getText().contains(searchText5))
    			 {
    				 Thread.sleep(2000);
    				 list.click(); // click the desired option
    				 break;
    			 }
    		 }

    		 Thread.sleep(3000);
    		 String searchText6 = "Windows and Mac";
    		 WebElement dropdown_6 = CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("activity_plateformTab"))); 
    		 Thread.sleep(2000);
    		 dropdown_6.click();
    		 List<WebElement> plateform_list = CommonActions.driver.findElements(By.xpath(CommonActions.testConfig.getProperty("activity_plateformTab_list")));
    		 for(WebElement list : plateform_list)
    		 {
    			 if (list.getText().contains(searchText6))
    			 {
    				 Thread.sleep(2000);
    				 list.click(); // click the desired option
    				 break;
    			 }
    		 }

    		 Thread.sleep(3000);
    		 String searchText7 = "Functionality";
    		 WebElement dropdown_7 = CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("activity_testTab"))); 
    		 dropdown_7.click();
    		 List<WebElement> Test_Typelist = CommonActions.driver.findElements(By.xpath(CommonActions.testConfig.getProperty("activity_testTab_list")));
    		 for(WebElement list : Test_Typelist)
    		 {
    			 if (list.getText().contains(searchText7))
    			 {
    				 list.click(); // click the desired option
    				 break;
    			 }
    		 }

    		 Thread.sleep(3000);
    		 String searchText8 = "DB_Lanaguge_MOD";
    		 WebElement dropdown_8 = CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("activity_languageTab"))); 
    		 dropdown_8.click();	   
    		 List<WebElement> language_Typelist = CommonActions.driver.findElements(By.xpath(CommonActions.testConfig.getProperty("activity_languageTab_list")));
    		 for(WebElement list : language_Typelist)
    		 {
    			 if (list.getText().contains(searchText8))
    			 {
    				 Thread.sleep(2000);
    				 list.click(); // click the desired option
    				 break;
    			 }
    		 }

    		 // SpinButton  
    		 Thread.sleep(3000);
    		 CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("activity_durationTab_Hrs"))).sendKeys("8");
    		 CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("activity_durationTab_Mint"))).sendKeys("59");


    		 // TextArea WebElement
    		 WebElement ele = CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("activity_commentsTab")));
    		 ele.sendKeys("Modification Comment TextArea");

    		 //click on add activity button 
    		 CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("activity_addActivityBtn"))).click();
    	 }
	  }
    
		 
    public void user_choose_Miscellaneous_Activty_from_activity_dropdown_list() throws InterruptedException
		 {
			 
			   String searchText = "Miscellaneous Activity";
			   WebElement dropdown = CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("activity_miscellaneousActivityTab"))); 
			   dropdown.click(); // assuming you have to click the "dropdown" to open it
			   Thread.sleep(1000);
			   List<WebElement> options = dropdown.findElements(By.xpath(CommonActions.testConfig.getProperty("activity_miscellaneousActivity_list")));
			   for (WebElement option : options)
			   {
				   System.out.println("----------- "+option.getText());
				   if (option.getText().contains(searchText))
				   {
					   option.click(); // click the desired option
					   break;
				   }
			   }
			   
			   
			   Thread.sleep(3000);
			   String searchText1 = "London";
			   WebElement dropdown1 = CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("activity_miscellaneous_locationTab")));
			   dropdown1.click();
			   List<WebElement> location_list = CommonActions.driver.findElements(By.xpath(CommonActions.testConfig.getProperty("activity_miscellaneous_location-list"))); 
			   for(WebElement list : location_list)
			   {
				   if (list.getText().contains(searchText1))
				   {
					   list.click(); // click the desired option
					   break;
				   }
			   }
			   
			   
			   Thread.sleep(3000);
			   String searchText2 = "Admin - Overtime";
			   WebElement dropdown2 = CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("activity_miscellaneous_WorkTypTab")));
			   dropdown2.click();
			   List<WebElement> workType_list = CommonActions.driver.findElements(By.xpath(CommonActions.testConfig.getProperty("activity_miscellaneous_WorkTyp-lst"))); 
			   for(WebElement list : workType_list)
			   {
				   if (list.getText().contains(searchText2))
				   {
					   list.click(); // click the desired option
					   break;
				   }
			   }
			   
			// SpinButton  
			   Thread.sleep(3000);
			   CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("activity_miscellaneous_durationTab_hr"))).sendKeys("7");
			   CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("activity_miscellaneous_durationTab_mint"))).sendKeys("59");
			   
			   // TextArea WebElement
			   WebElement ele = CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("activity_miscellaneous_commentTab")));
			   ele.sendKeys("Modification Comment TextArea");

			   //click on add activity button 
			   CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("activity_miscellaneous_addActivityBtn"))).click();
			   
			   user_validates_validation_Message_isRowEmpty_in_tblActivity();
			   Thread.sleep(1000);
		       click_on_EditActivities_button_From_Add_New_Window();
		       Thread.sleep(2000);		    
		       user_click_on_submitBtn_and_validates_validation_Message();
		       Thread.sleep(2000);
		 }
	   
       
 

  public void user_validates_validation_Message_isRowEmpty_in_tblActivity() throws InterruptedException                                                                                                       
  {
	  Thread.sleep(4000);	  
	  //Here we are storing the value from the first cell in to the string variable
	  String sCellValue = CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("activity_Entry_tbl"))).getText();	  
	  String uSerNameCell = CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("activity_profileName_validationTxt"))).getText();
	    
	  if(sCellValue.contains(uSerNameCell)) {
		  System.out.println("Successfully Added New Activity And CellValue is " + " : " + sCellValue + " Hence Cell Exist in WebTable ");
	  }
	  else	  {
		  System.out.println("Cell Doesn't Exist in WebTable");
	  }
	  Thread.sleep(3000);
  }

  public void click_on_EditActivities_button_From_Add_New_Window() throws InterruptedException
  {
	  Thread.sleep(2000);
	  WebElement edit_btn = CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("activity_addNewBtn_editbtn")));
	  WebElement updateActivity_btn = CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("activity_addNewBtn_updatebtn")));
	  boolean varifyEditbtn = edit_btn.isEnabled();
	  try {
	  if(varifyEditbtn==true)
	  {
		  edit_btn.click();	   	
		  Thread.sleep(4000);	
		 // click_on_deleteActivities_button(); 
		  System.out.println("Change the activities which needs to be updated & click on UPDATE ACTIVITY BUTTON ");
		  Thread.sleep(3000);
		  updateActivity_btn.click();
		  user_click_on_submitBtn_and_validates_validation_Message();		  
	  }
	  else
	   {
		  System.out.println("Unable to click on button");
	   }
	  }
       catch(org.openqa.selenium.NoSuchElementException e) {		  
	  }
      catch(org.openqa.selenium.StaleElementReferenceException ex){
        	
	  }
  }
  
  public static void user_click_on_submitBtn_and_validates_validation_Message() throws InterruptedException
  {
	  Thread.sleep(3000);
	  try
	  {
	     WebElement sUbmit_btn = CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("activity_submitBtn")));	
	     boolean verifySubmit_btn = sUbmit_btn.isEnabled();
	  
	      System.out.println("verifySubmit_btn"+  verifySubmit_btn);
	      if(verifySubmit_btn==true)
	      {
	    	  sUbmit_btn.click();		  
	    	  Thread.sleep(3000);
	    	  String activity_updated = CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("actvity_validationTxt"))).getText().trim();
	    	  if(activity_updated.equals(activity_updated))
	    	  {
	    		  System.out.println("Activity has been updated successfully");
	    	  }
	    	  else if(activity_updated.contains("Please enter activity details."))
	    	  {
	    		  System.out.println("Please enter activity details.");
	    	  }
	    	  else
	    	  {
	    		  System.out.println("Fill the mandatory fields");
	    	  }
	       }
	      }	
	  catch(org.openqa.selenium.NoSuchElementException e) {
		  
	  }
      catch(org.openqa.selenium.StaleElementReferenceException ex){
        	
	  }
    }
  public  void user_click_on_delete_Activities_button_from_Add_New_Windows() throws InterruptedException
  {
	  WebElement dElete_btn = CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("activity_addNewBtn_deletebtn")));
	  String sCellValue = CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("activity_updateTbl_validationTxt"))).getText();	  
	  boolean verifyDeletebtn = dElete_btn.isEnabled();
	  WebElement sUbmitbtn = CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("activity_submitBtn")));
	  boolean sUbmitbtn1 = dElete_btn.isEnabled();
	  if(verifyDeletebtn==true)	 
	  {
		  dElete_btn.click();
		  Thread.sleep(3000);
	  
	   if(sCellValue.contains("No data available in table"))
		{
			  System.out.println("Data is deleted from table");
			  Thread.sleep(2000);
		} 
	    else
	    {
	    	System.out.println("Please fill the activity entry and submit it");
	    	user_choose_Miscellaneous_Activty_from_activity_dropdown_list();
	    	
	    }
     }
 }
  public void user_click_on_Edit_button_From_Main_ActivitiesPage() throws InterruptedException
  {
	  Thread.sleep(5000);
	  WebElement edit = CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("actvity_frmMainPage_editbtn")));
	  boolean status  = edit.isEnabled();
	  try
	  {
		  if(status)
		  {
			  Thread.sleep(2000);
			  edit.click();
		  }
	  }
  catch(NullPointerException e) {		  
	  }
      catch(org.openqa.selenium.StaleElementReferenceException ex){        	
	  }	  
	  
	   Thread.sleep(3000);
	   click_on_EditActivities_button_From_Add_New_Window();
  }
  

  public void user_click_on_delete_button_From_Main_AcvtivityPage() throws InterruptedException
  {
	  Thread.sleep(5000);
	  WebElement delete_button= CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("actvity_deletebtn_frmMainPage")));
	  boolean status  = delete_button.isEnabled();
	  try
	  {
		  if(status){
			  Thread.sleep(2000);
			  delete_button.click();
			}
		    
	  }
	  catch(NoSuchElementException ex) {	  
      }
	  
	  Thread.sleep(3000);
	  CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("actvity_confirmBtnTxt"))).click();
	  Thread.sleep(2000);

  }
  
 
  public void user_click_on_User_Search_View_To_View_User_Details() throws InterruptedException
  {
	  Thread.sleep(1000);
	  WebElement user_view = CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("activity_userSearchView_popUp")));
	  boolean status  = user_view.isEnabled();
	  if(status)
	  {
		  Thread.sleep(3000);
	      user_view.click();
	  }
	  
	  String sErach_viewText = CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("activity_userSearchView_txt"))).getText();
	  System.out.println("User Search View Text is "  +  sErach_viewText);
	  
	  // fill any of the fields and search
	  
	   Thread.sleep(3000);
 if(driver.findElement(By.xpath(CommonActions.testConfig.getProperty("activity_searchuservalidsummary"))).getText()
		                                .trim().contains("Use any one of the search criteria(Name, Role, Email, City) to view the required user details."))
	 {  
	   String searchText6 = "Bangalore1";
	   WebElement dropdown = CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("actvity_userSV_citydropdownTab"))); 
	   Thread.sleep(2000);
	   dropdown.click();
	   List<WebElement> city_list = CommonActions.driver.findElements(By.xpath(CommonActions.testConfig.getProperty("activity_userSV_citydropdownTab_list")));
	   for(WebElement list : city_list)
	   {
		   if (list.getText().contains(searchText6))
		   {
			   Thread.sleep(2000);
			   list.click(); // click the desired option
			   break;
		   }
	   }
	  
	   CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("actvty_userSV_NameBx"))).sendKeys("babita");
	   CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("actvty_userSV_RoleNameBx"))).sendKeys("Quality Engineer");
	   CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("actvty_userSV_EmailBx"))).sendKeys("babita.thakur@ptw.com");
	   
	   Thread.sleep(3000);
	   String searchText = "Active";
	   WebElement dropdown_1 = CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("actvty_userSV_StatusTab"))); 
	   Thread.sleep(2000);
	   dropdown_1.click();
	   List<WebElement> status_list = CommonActions.driver.findElements(By.xpath(CommonActions.testConfig.getProperty("actvty_userSV_StatusTab_list1")));
	   for(WebElement list : status_list)
	   {
		   if (list.getText().contains(searchText))
		   {
			   Thread.sleep(2000);
			   list.click(); // click the desired option 	        
		        break;
		   }
	   }
	   
	   Thread.sleep(3000);
	   WebElement search_btton =   CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("actvty_userSV_searchBtn")));
	   boolean status_1  = search_btton.isEnabled();
		  if(status_1)
		  {
			  Thread.sleep(3000);
			  search_btton.click();
		  }
		  
		  if(CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("actvty_userSV_AllActivty_tpyeStatus"))).getText().contains("All"))
		  {
		      WebElement mytable = CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("actvty_userSVTable")));	
			  List < WebElement > rows_table = mytable.findElements(By.tagName("tr"));
			  int rows_count = rows_table.size();	  
			  for (int row = 0; row < rows_count; row++)
			  {
				  List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("td"));
				  for (WebElement cell : Columns_row){
			         			     
				  if(Columns_row.size()> 0 && cell.getText().contains("baita")) {
					 System.out.println("Cell data available in table" + Columns_row.size() + "UserActivity available in table" ); 
				  }
				  else {
					  System.out.println("No matching records found");
				   }
			    }
		      }
			  
		  }
		  else if(CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("actvty_userSV_ActiveStatus']"))).getText().contains("Active"))
		  {
			  WebElement mytable = CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("actvty_userSVTable")));	
			  List < WebElement > rows_table = mytable.findElements(By.tagName("tr"));
			  int rows_count = rows_table.size();	  
			  for (int row = 0; row < rows_count; row++)
			  {
				  List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("td"));
				  for (WebElement cell : Columns_row){
			         			     
				  if(Columns_row.size()> 0 && cell.getText().contains("baita")) {
					 System.out.println("Cell data available in table" + Columns_row.size() + "UserActivity available in table" ); 
				  }
				  else {
					  System.out.println("No matching records found");
				   }
			    }
		      }
		  }
		  else if(CommonActions.driver.findElement(By.xpath("actvty_userSV_Inactive_status")).getText().contains("InActive"))
		  {
			  WebElement mytable = CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty("actvty_userSVTable")));	
			  List < WebElement > rows_table = mytable.findElements(By.tagName("tr"));
			  int rows_count = rows_table.size();	  
			  for (int row = 0; row < rows_count; row++)
			  {
				  List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("td"));
				  for (WebElement cell : Columns_row){
			         			     
				  if(Columns_row.size()> 0 && cell.getText().contains("baita")) {
					 System.out.println("Cell data available in table" + Columns_row.size() + "UserActivity available in table" ); 
				  }
				  else {
					  System.out.println("No matching records found");
				   }
			    }
		      } 
		  }
	  
		  // check whether Previous button & Next button is enable 
		  
		  WebElement Previous_button = CommonActions.driver.findElement(By.xpath("actvty_userSView_previousbtn"));
		  boolean status1 =Previous_button.isEnabled();
			  if(status1)
			  {
				  Thread.sleep(3000);
				  Previous_button.click();
			  }
			  else
			  {
				  WebElement Next_button = CommonActions.driver.findElement(By.xpath("actvty_userSView_nextbtn"));
				  boolean status2 =Previous_button.isEnabled();
				  if(status2)
				  {
					  Thread.sleep(3000);
					  Next_button.click();
				  }
				  else
					// clear button
					  Thread.sleep(3000);
					  WebElement clear_btton =  CommonActions.driver.findElement(By.xpath("actvty_userSView_clickbtn"));
					  boolean  status3 = clear_btton.isEnabled();
					  if(status3)
					  {
						  Thread.sleep(3000);
						  clear_btton.click();
						  
					  }
					  
			  }
		  }
		  
       }
  
  }


	  
  

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
