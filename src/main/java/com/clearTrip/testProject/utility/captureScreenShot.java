package com.clearTrip.testProject.utility;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class captureScreenShot {
	
	public static String takeScreenShot(WebDriver driver, String name){
		
		 try{
	            //take screenshot and save it in a file
	            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	            //copy the file to the required path
	          FileUtils.copyFile(screenshot,new File(System.getProperty("user.dir")+"\\screenshots\\"+name+".png"));

	        }catch(Exception e){
	            //if it fails to take screenshot then this block will execute
	            System.out.println("Failure to take screenshot "+e);
	        }
	        finally
	        {
	            //Whatever happens with the screenshot, driver will quit.
	            driver.quit();
	        }
		return name;
		 
	}

}
