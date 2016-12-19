package com.clearTrip.testProject.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityClass {
	
	
	public static String readPropertiesFile(String filePath, String key){
		  
		FileInputStream input = null;
		String value = null;
		
		try {
			 input = new FileInputStream(filePath);
			 Properties prop = new Properties();
			 prop.load(input);
			 
			value =  prop.getProperty(key);
			
		}
			catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("File not found "+filePath);
				//e.printStackTrace();
			}
		
		return value;
		
	}

	
	public WebDriverWait implicitWait(WebDriver driver){
	WebDriverWait wait = new WebDriverWait(driver, 10);
	return wait;
	
	}
}
