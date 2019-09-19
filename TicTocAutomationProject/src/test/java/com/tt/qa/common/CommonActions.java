package com.tt.qa.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CommonActions
{
	public static WebDriver driver;  
	public static Properties testConfig;
	public static String filepath = System.getProperty("user.dir") +"\\src\\test\\java\\com\\tt\\qa\\config\\Config.properties";
	public String getdate=getDateTime();
	

	public String getDateTime(){
		
		   SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");  
		   Date date = new Date();  
		   String dateTime = formatter.format(date).toString();
	       return dateTime;
    }
	public void getproperties(){
	    	
		testConfig = new Properties();
	    	try{
	    		testConfig.load(new FileInputStream(filepath));
	    	}
	    	catch (IOException ex){
	            ex.printStackTrace();
	    	}
	}
	public void openBrowser() throws FileNotFoundException, IOException {
	    	
	    	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") +"\\src\\test\\java\\com\\tt\\resources\\chromedriver.exe");
			driver = new ChromeDriver();	
			driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		    driver.get(testConfig.getProperty("URL"));
		    System.out.println("Initialize Driver");
	 }
	 public void navigateurl(){
		 
	     driver.get(testConfig.getProperty("URL"));
	     System.out.println("Navigate URL");
	 }
	         
	 public static String getCurrentDay(){
		 // Create a Calendar Object //Get The Current Day
		 Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		 //Get Current Day as a number
		 int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
		 //  System.out.println("Today Int: " + todayInt +"\n"); //Integer to String Conversion
		 String todayStr = Integer.toString(todayInt);
		 //  System.out.println("Today Date: " + todayStr);
		 return todayStr;
	 }    
	 public static void click_on_search_button_To_view_data() throws InterruptedException{
		 Thread.sleep(3000); 			
		 driver.findElement(By.xpath(testConfig.getProperty("act_searchBtn"))).click();			  
		 WebElement mytable = driver.findElement(By.xpath(testConfig.getProperty("act_searchTableData")));	
		 //To locate rows of table. 
		 List < WebElement > rows_table = mytable.findElements(By.tagName("tr"));
		 //To calculate no of rows In table.
		 int rows_count = rows_table.size();
		 System.out.println("No of rows in table :" + rows_table.size());
		 //Loop will execute till the last row of table.
		 for (int row = 0; row < rows_count; row++) {
			 //To locate columns(cells) of that specific row.
			 List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("td"));
			 //To calculate no of columns (cells). In that specific row.
			 int columns_count = Columns_row.size();
			 System.out.println("Number of cells In Row " + row + " are " + columns_count);
			 //Loop will execute till the last cell of that specific row.
			 for (int column = 0; column < columns_count; column++)
			 {
				 if(rows_table.isEmpty() && Columns_row.isEmpty()){
					 System.out.println("No data available in table");
				 }
				 else{
					 // To retrieve text from that specific cell.
					 String celtext = Columns_row.get(column).getText();
					 System.out.println("Cell Value of row number " + row + " and column number " + column + " Is " + celtext);
				 }
			 }
			 System.out.println("-------------------------------------------------- ");
		 }
	  }
	  public static void enterText_into_Search_textBox(String xpath , String text) throws InterruptedException {
		 // send the data into search box and check data is available whatever u searched 
	    	 Thread.sleep(3000);
	    	 driver.findElement(By.xpath(CommonActions.testConfig.getProperty(xpath))).sendKeys(text);
	  }
	  public static void validate_isRowCellEmpty_inTable(String xpath,String text) throws InterruptedException{
	    	 Thread.sleep(3000);   
	    	 WebElement mytable = CommonActions.driver.findElement(By.xpath(CommonActions.testConfig.getProperty(xpath)));	
	    	 List < WebElement > rows_table = mytable.findElements(By.tagName("tr"));
	    	 int rows_count = rows_table.size();
	    	 for (int row = 0; row < rows_count; row++)
	    	 {
	    		 List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("td"));
	    		 int datafound=0;
	    		 for (WebElement cell : Columns_row){
	    			 if(Columns_row.size() > 0 && cell.getText().contains(text)) {	    				 
	    				 System.out.println("Cell data available in table :" +cell.getText());
	    				 datafound++;
	    				 break;
	    			}
	    		 }
	    	      if(datafound==0){
	    	    	  System.out.println("No matching records found");
	    	      }
	          }
	  }
//	  public String takeScreenshot(String name,String filename){
//		   // Take screenshot and store as a file format
//		   File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		   try {
//		       FileUtils.copyFile(src, new File(filename  + "\\" +  name +"_"+  getdate + ".png"));		      
//		     }
//		   catch (IOException e){
//		     System.out.println(e.getMessage());
//		   }
//		return name;
//	 }
	 public void createsubfolder(String filename) {
		 File fileStructure = new File(filename  + getdate);

		 // File object has a method called as exists() which
		 // Tests whether the file or directory denoted by 
		 // this abstract pathname exists. 
		 if(! fileStructure.exists()){
			 // File object has a method called as mkdir() which
			 // Creates the directory named by this abstract pathname. 
			 if (fileStructure.mkdir()) {
				 System.out.println("New Folder/Directory created .... ");
			 }
			 else {
				 System.out.println("Oops!!! Something blown up file creation...");
			 }
		 }else {
			System.out.println("File already exists !!! ...");
		 }
	 }
	 public void testPageTitle(String title){
		 String actualTitle = driver.getTitle();
		 String pageTitle = testConfig.getProperty(title);
		 if(actualTitle.contains(pageTitle)){
			 System.out.println("Verify the page title : " + driver.getTitle());
		 }
		 else{
			 System.out.println("ERROR:Page title is Incorrect.");
		 }
	 }	
	 public void dynamic_DropDownList(String selectText) throws InterruptedException {
		    Select sortOrder = new Select(driver.findElement(By.xpath(testConfig.getProperty(selectText))));		    
		    System.out.println("Default option: " + 
		    		sortOrder.getFirstSelectedOption().getText());		    
		    Thread.sleep(2000);
		   // Get all options - get all by text, get count
		    List<WebElement> options =  sortOrder.getOptions();
		    System.out.println("All options count: " + options.size());		    
		    for(WebElement option: options) {
		    	 System.out.println(option.getText());
		    }
		    // Set a specific option
		 /* Thread.sleep(2000);
		    sortOrder.selectByIndex(1);
		    sortOrder = new Select(driver.findElement(By.xpath(testConfig.getProperty(selectText))));
		    System.out.println("Current selected option: " + 
		    		sortOrder.getFirstSelectedOption().getText());
			Thread.sleep(2000);
			    
			    sortOrder.selectByValue("date");
			    sortOrder = new Select(driver.findElement(By.xpath(testConfig.getProperty(selectText))));
			    System.out.println("Current selected option: " + 
						sortOrder.getFirstSelectedOption().getText());
			 Thread.sleep(2000);			    
			    sortOrder.selectByVisibleText("Sort by price: low to high");
			    sortOrder = new Select(driver.findElement(By.name("orderby")));
			    // Get current selected option
			    System.out.println("Current selected option: " + 
						sortOrder.getFirstSelectedOption().getText());
			 Thread.sleep(2000);*/
	 }
	 public String User_loginAs(String username) {
		 
		    driver.findElement(By.id("UserName")).sendKeys(testConfig.getProperty(username));
			return username;
	 }
	 public void click_On_Button(String button) throws InterruptedException{
		 
	  WebElement btn = driver.findElement(By.xpath(testConfig.getProperty(button)));
	  boolean status = btn.isEnabled();
	  if(status){
		  
		  Thread.sleep(3000);
		  btn.click();
	  }
    }
	public static void quitDriver(){
   	     driver.quit();
   	}
  
}
