package com.clearTrip.testProject.dataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.DataProvider;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import com.clearTrip.testProject.utility.ExcelUtils;

//@SuppressWarnings("unused")
public class clearTripDataProvider {
	
	@DataProvider(name="roundTripBookingData")
	  public static Object[][] flightBookingData() throws Exception{
	 
		   //  Setting up the Test Data Excel file		
		return ExcelUtils.getExcelData(System.getProperty("user.dir")+"\\src\\main\\java\\TestData\\TestData.xls","FlightSearch");
		
	}
	
	}	 
	

	


