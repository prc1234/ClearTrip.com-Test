package com.clearTrip.testProject.pageObjects;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.clearTrip.testProject.WebDriverActions.WebDriversActions;
import com.clearTrip.testProject.utility.BaseClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BookFlightPageObject extends BaseClass {
	
private  WebDriver driver;
static ExtentReports extent;
static ExtentTest extentTest;
	
  //  @FindBy(xpath="//*[@id='flightForm']/section[2]/div[3]/div[3]/button")
	@FindBy(name="Book")
	private WebElement btn_bookFlight;
    
    @FindBy(xpath="//*[@id='itinBlock']/div/div/div[1]/h1/text()")
    private WebElement OnwardsJourneyItn;
    

    

    public BookFlightPageObject(WebDriver driver){
    	this.driver = driver;
    	WebDriverWait wait=new WebDriverWait(driver,30);
    }
    


    public void bookTicket(String originDestination, String returnDestination){
    	try{
    		WebDriverWait wait=new WebDriverWait(driver,30);
    		
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("stripes")));
            WebElement inputElement=driver.findElement(By.xpath("//button[text()='Book']"));

            try {
                    ((JavascriptExecutor)driver).executeScript("arguments[0].click();", inputElement);

            } catch (StaleElementReferenceException e) {
                System.out.println("Element is not attached to the page document "+ e.getStackTrace());
            } catch (NoSuchElementException e) {
                System.out.println("Element was not found in DOM "+ e.getStackTrace());
            } catch (Exception e) {
                System.out.println("Unable to click on element "+ e.getStackTrace());
            }
    		
    	}
    	
    	catch(Exception e){

			extentTest.log(LogStatus.FAIL, e);

    		Assert.fail("Book Ticket Failed"+ e);
    	}
    	
    	
    }
    
    
}
