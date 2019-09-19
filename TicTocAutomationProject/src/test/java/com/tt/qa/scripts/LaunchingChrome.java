package com.tt.qa.scripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.tt.qa.common.CommonActions;
import com.tt.qa.scripts.LoginPage;
import com.tt.qa.scripts.TicToc_Activity_Menu;

public class LaunchingChrome extends CommonActions
{

	
 @SuppressWarnings("static-access")
public static void main(String[] args) throws Throwable	   
 {
	
	    CommonActions CommonActionskeys_obj = new CommonActions();
	
		CommonActionskeys_obj.getproperties();
		CommonActionskeys_obj.openBrowser();
		CommonActionskeys_obj.navigateurl();
		Thread.sleep(3000);
		CommonActionskeys_obj.testPageTitle("loginPageTitle");
		
		LoginPage obj_LoginPage = new LoginPage();		
		obj_LoginPage.User_loginPage_loginAs("UserName", "Password");
        obj_LoginPage.isLoginSuccessfulFor("UserName");
    	System.out.println("------------------------------------------");
    	
//    	TicToc_Activity_Menu obj_TicToc_Activity_Menu = new TicToc_Activity_Menu();
//    	
//    	obj_TicToc_Activity_Menu.user_clicks_on_ActivityDate_Entry_Caledar_field_EnterDate_clicks_on_Search_button_and_validates_validation_tblActvityData();
//    	obj_TicToc_Activity_Menu.user_click_on_Copy_Actvity_Calendar_to_copy_actvity_from_privious_date();
//    	obj_TicToc_Activity_Menu.user_click_on_Copy_Actvities_button_and_validates_validation_Message();
//    	obj_TicToc_Activity_Menu.user_click_on_SearchTxt_Box_fields_and_enter_data_and_validates_Text_in_column();
//    	TicToc_Activity_Menu.user_clicks_on_Clear_button();
//    	obj_TicToc_Activity_Menu.user_clicks_on_AddNew_Activity_button_enters_Mandatory_fields_clicks_on_ADD_button_and_validates_validation_Message();
//    	obj_TicToc_Activity_Menu.user_choose_project_Activity_from_activity_dropdown_list();
//    	
//    	obj_TicToc_Activity_Menu.user_validates_validation_Message_isRowEmpty_in_tblActivity();
//    	obj_TicToc_Activity_Menu.click_on_EditActivities_button_From_Add_New_Window();
//    	obj_TicToc_Activity_Menu.user_click_on_delete_Activities_button_from_Add_New_Windows();
//    	//TicToc_Activity_Menu.user_click_on_submitBtn_and_validates_validation_Message();
//    	obj_TicToc_Activity_Menu.user_click_on_Edit_button_From_Main_ActivitiesPage();
//    	obj_TicToc_Activity_Menu.user_click_on_delete_button_From_Main_AcvtivityPage();
//    	obj_TicToc_Activity_Menu.user_click_on_User_Search_View_To_View_User_Details();
    	
//    	
//    	TicTocActivity_ApprovalsMenu obj_approvalsMenu = new TicTocActivity_ApprovalsMenu();
//    	obj_approvalsMenu.admin_click_on_approvalsTab_toApprove_UserActivity();
//    	obj_approvalsMenu.admin_click_on_CalendarTab_toSlelectCustomRange_and_pickDates();
//    	obj_approvalsMenu.admin_select_StartDate_and_endDate_from_Cal();
//    	obj_approvalsMenu.admin_click_on_rejectButton();
//    	obj_approvalsMenu.admin_click_on_edit_Button_to_Edit_UserActivity();
//    	
    	
    	TicTocActivity_RestMenu obj_resetbutton = new TicTocActivity_RestMenu();
    	obj_resetbutton.admin_click_on_Reset_button();
	}    
        
		
	   
	
}
	
	
		
	 

