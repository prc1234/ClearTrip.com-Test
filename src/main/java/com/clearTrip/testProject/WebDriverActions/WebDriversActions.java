package com.clearTrip.testProject.WebDriverActions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriversActions {

	 public void clickElement(WebDriver driver, WebElement element)
	    {
		 
		 try{
		 	element.click();
		 	
		 	if(element.isEnabled()){
		 		element.sendKeys(Keys.RETURN);
		 	}
		 	
		 }
		 
		 catch(Exception e){
			 System.out.println("element not clickable");
		 }
	    }
}
