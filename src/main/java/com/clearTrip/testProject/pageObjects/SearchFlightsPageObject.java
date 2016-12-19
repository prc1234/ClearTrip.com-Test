package com.clearTrip.testProject.pageObjects;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.clearTrip.testProject.ConstantData.Constants;
import com.clearTrip.testProject.report.ExtentReportNG;
import com.clearTrip.testProject.utility.DateClass;
import com.clearTrip.testProject.utility.UtilityClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.jna.platform.win32.OaIdl.DATE;

import junit.framework.Assert;

public class SearchFlightsPageObject {
	
	private  WebDriver driver;
	private static ExtentReports report ;
	private static ExtentTest extlogger; 
	
    @FindBy(id="RoundTrip")
    private WebElement radioBtn_roundTrip;
    
    @FindBy(id="FromTag")
    private WebElement txtBox_FromDestn;
    
    @FindBy(id="ToTag")
    private WebElement txtBox_toDestn;
    
    @FindBy(id="DepartDate")
    private WebElement cal_departDate;
   
    @FindBy(id="ORtrip")
    private WebElement cal_departDateCalendar;
    

    @FindBy(id="ReturnDateContainer")
    private WebElement cal_ReturnDateCalendar;
    
    
    @FindBy(id="ReturnDate")
    private WebElement cal_ReturnDate;
    
    @FindBy(id="Adults")
    private  WebElement dropdown_adults;
  
    @FindBy(id="Childrens")
    private WebElement dropdown_children;
    
    @FindBy(id="Infants")
    private  WebElement dropdown_infants;
    
    @FindBy(id="SearchBtn")
    private WebElement btn_searchBtn;

    @FindBy(id="homeErrorMessage")
    private WebElement txt_errorMessage;

    
    
    public SearchFlightsPageObject(WebDriver driver){

        this.driver = driver;
        //This initElements method will create all WebElements
        
     //  System.out.println("driver is "+driver);

    }
    
  
    public boolean searchFlight( String fromDestn, String toDestn, String departDate, String returnDate, String Adults, String Children, String infants  ){
   
    	try{
    	UtilityClass refUtilityClass = new UtilityClass();
    	WebDriverWait wait   = refUtilityClass.implicitWait(driver);
    	
    	report =   ExtentReportNG.initializeReport();
    	extlogger = ExtentReportNG.initializeextentlogger("Start Testing ClearTrip");
 	
    	//extent = Reporting.intializeExtentReport(extent);
    	//click on the round trip radio button
    	radioBtn_roundTrip.click();  
    	extlogger.log(LogStatus.INFO,"Clicked on the round trip radio button");
    	
    	txtBox_toDestn.sendKeys(fromDestn);
    	extlogger.log(LogStatus.INFO,"Entered From Destn");
        
    	txtBox_FromDestn.sendKeys(toDestn);
    	extlogger.log(LogStatus.INFO,"Entered to Destn");
        
    	
    	cal_departDate.clear();
    	cal_departDate.sendKeys(departDate);	
    	extlogger.log(LogStatus.INFO,"Entered Depart date");
        
    	cal_ReturnDate.clear();
    	cal_ReturnDate.sendKeys(returnDate);
    	extlogger.log(LogStatus.INFO,"Entered Return Destn");
        
    	cal_ReturnDate.sendKeys(Keys.TAB);
    	btn_searchBtn.click();
    	extlogger.log(LogStatus.INFO,"Clicked Search Button");
        
    	
    	DateClass ref = new DateClass();
    	Boolean bool_date = ref.compareDate(departDate, returnDate);
    	
    	
    	
    	//this check is to assert if the start date is lesser than or equal to the end date
    	if(bool_date.equals(true))
    	{    	
    	
    		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    		WebElement btn_bookButton = driver.findElement(By.xpath("//*[@id='flightForm']/section[2]/div[3]/div[3]/button"));
    		
	    	if(btn_bookButton.isEnabled()){

	        	extlogger.log(LogStatus.PASS,"Ticket booking button is enabled"); 
	    		Assert.assertTrue("Ticket booking button is enabled", true);
	    		return true;
	    	}
	    	else{
	    		extlogger.log(LogStatus.FAIL,"Ticket booking button is not enabled"); 
	    		Assert.assertFalse("Ticket booking button is not enabled", true);
	    		return false;
	    	}
    	
    	}
    	
    	else{
    		
    		String errorMsg = txt_errorMessage.getText();
    		//extlogger.log(LogStatus.FAIL,"Correct Date was not entered"); 
    	//	Assert.assertEquals(UtilityClass.readPropertiesFile(Constants.path_propertiesFile, Constants.errorMsg), errorMsg);
    		return true;
    	}
    	
    	}
    	catch(Exception e)
    	{
    		//e.printStackTrace();
    		
    		extlogger.log(LogStatus.FAIL,e); 
    		Assert.fail("Element Not found");
    		return false;
    	}
    	
    	
    }
    
    
    
    

}
