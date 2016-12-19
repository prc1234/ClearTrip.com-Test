package com.clearTrip.Testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.clearTrip.testProject.ConstantData.Constants;
import com.clearTrip.testProject.dataProvider.clearTripDataProvider;
import com.clearTrip.testProject.pageObjects.BookFlightPageObject;
import com.clearTrip.testProject.pageObjects.SearchFlightsPageObject;
import com.clearTrip.testProject.report.ExtentReportNG;
import com.clearTrip.testProject.utility.BaseClass;
import com.clearTrip.testProject.utility.UtilityClass;
import com.clearTrip.testProject.utility.captureScreenShot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class RoundTripBooking extends BaseClass {
	
	static WebDriver driver;
	SearchFlightsPageObject searchFlights;
	WebDriverWait wait;
	private static ExtentReports report ;
    private static ExtentTest extlogger; 

	
	@Test(dataProviderClass=clearTripDataProvider.class , dataProvider="roundTripBookingData")
	//public static void roundTrip(String fromDstn, String ToDstn, String fromDate, String toDate, int Adults, int Children,int infants ){
	public static void roundTrip(String  TestCaseId, String fromDestn, String toDestn, String departDate, String returnDate, String Adults, String Children, String infants){
		
	
		report =   ExtentReportNG.initializeReport();
    	extlogger = ExtentReportNG.initializeextentlogger("Testing Clear Trip");
		
		BaseClass refBaseClass = new BaseClass();
		String browser = UtilityClass.readPropertiesFile(Constants.path_propertiesFile, Constants.browser);
		driver = refBaseClass.initializeBrowser(browser,UtilityClass.readPropertiesFile(Constants.path_propertiesFile, Constants.URL));
		SearchFlightsPageObject SearchFlightsPageObject = PageFactory.initElements(driver,SearchFlightsPageObject.class );

		try {
			
			//Check if the Book button is enabled then proceed else the test fails with error message.
			boolean boolSearchFlight = SearchFlightsPageObject.searchFlight( fromDestn, toDestn, departDate, returnDate, Adults, Children, infants);
			if(boolSearchFlight == true){
				BookFlightPageObject BookFlightPageObject = PageFactory.initElements(driver, BookFlightPageObject.class);
			//	Thread.sleep(20000);
				BookFlightPageObject.bookTicket(fromDestn, toDestn);
			}
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	 @AfterMethod
	    protected void afterMethod(ITestResult result) {
	        if (result.getStatus() == ITestResult.FAILURE) {
	            extlogger.log(LogStatus.FAIL, result.getThrowable());
	        } else if (result.getStatus() == ITestResult.SKIP) {
	        	extlogger.log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
	        } else {
	        	extlogger.log(LogStatus.PASS, "Test passed");
	        }
	        
	        report.endTest(extlogger);        
	        report.flush();
	     //   System.out.println(System.getProperty("user.dir")+"\\report"+System.currentTimeMillis()+".html");
	        driver.get(ExtentReportNG.filePath);
	        
	    }

	
	
}
