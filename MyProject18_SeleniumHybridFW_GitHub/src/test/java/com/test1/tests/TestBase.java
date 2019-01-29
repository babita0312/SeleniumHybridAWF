package com.test1.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.maven.surefire.shade.org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.test1.pages.HomePage;
import com.test1.util.DataDrivenHelper;
import com.test1.util.ExtentManager;
import com.test1.util.WebDriverHelper;


// ctrl+shift +o - to actomatically fix the import statement error 
public class TestBase {
	
	protected WebDriver driver;
	protected String baseURL;
	
// testConfig needs to be static member so that after initialisation in beforeSuite(), 
// testConfig can be shared & reused across all test classes
	static protected Properties testConfig;
	protected HomePage homePG;
	protected Logger logger;
	
	protected static ExtentReports extent;
	protected static ThreadLocal parentTestThread = new ThreadLocal();
	protected static ThreadLocal testThread = new ThreadLocal();
	protected ExtentTest parentTest;
	protected ExtentTest test;
	protected String testFailureScreenshotPath;
	
	@BeforeSuite
	public void beforeSuite() throws FileNotFoundException, IOException
	{
		
		FileUtils.deleteDirectory(new File("TestFailureScreenshots"));
		PropertyConfigurator.configure("log4j.properties");
		testConfig = new Properties();
		testConfig.load(new FileInputStream("TestConfig.properties"));
		
		String extentReportFilePath = "ExtentHtmlReport.html";
		extent = ExtentManager.createInstance(extentReportFilePath );
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(extentReportFilePath);
		extent.attachReporter(htmlReporter);
	}
	
	@BeforeMethod
	public void testSetUp(Method method)
	{
		logger = Logger.getLogger(this.getClass().getSimpleName()+ ".class");
		logger.info("..................Starting " + method.getName() + "................  " );
		
		
		driver = WebDriverHelper.createDriver(testConfig.getProperty("browser"));	
		baseURL = testConfig.getProperty("baseUrl");
		driver.get(baseURL);
		homePG = new HomePage(driver);
	}
	
	@AfterMethod
	public void testTearDown(ITestResult result) throws InterruptedException, IOException
	{
		// if the test result is fail, capture the screenshot
				if (result.getStatus() == ITestResult.FAILURE)
				{
					// Gives path like TestFailureScreenshots\com.test1.tests.HomePageTests.testPageTitle.png
					testFailureScreenshotPath = "TestFailureScreenshots/" 
															+ getClass().getName() // full class name - com.test1.tests.HomePageTests
															+ "." 
															+ result.getName() // test method name - testPageTitle 
															+ ".png";
					WebDriverHelper.getScreenShot(driver, testFailureScreenshotPath);
				}
		
		
		// close the browser
		Thread.sleep(2000);
		driver.quit();
		
		logger.info("..................Ending " + result.getName() + "................  " );
	}
	
	@DataProvider
	public Object[][] dataProvider(Method method)
	{
		DataDrivenHelper ddh = new DataDrivenHelper(testConfig.getProperty("mastertestdatafile"));
		
		Object[][] testData = ddh.getTestCaseDataSets(testConfig.getProperty("testdatasheet"), method.getName());
		
		return testData;
	}

	@BeforeClass
    public synchronized void beforeClass() {
		parentTest = extent.createTest(getClass().getName());
		parentTestThread.set(parentTest);
      }

    @BeforeMethod
    public synchronized void beforeMethod(Method method) {
        test =  parentTest.createNode(method.getName());
        testThread.set(test);
    }

    @AfterMethod(dependsOnMethods="testTearDown")
    public synchronized void afterMethod(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE)
            test.fail(result.getThrowable(),MediaEntityBuilder.createScreenCaptureFromPath(testFailureScreenshotPath).build());
        else if (result.getStatus() == ITestResult.SKIP)
            test.skip(result.getThrowable());
        else
           test.pass("Test passed");

        extent.flush();
    }

}
