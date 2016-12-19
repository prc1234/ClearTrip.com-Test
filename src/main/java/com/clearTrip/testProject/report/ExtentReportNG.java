package com.clearTrip.testProject.report;

import java.util.Calendar;
import java.util.Date;

import org.testng.IResultMap;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.IReporter;
import com.relevantcodes.extentreports.LogStatus;

public abstract class ExtentReportNG implements IReporter {
		private static ExtentReports report;
	    private static ExtentTest extlogger; 
	
	    public static final String filePath = System.getProperty("user.dir")+"\\report\\report"+System.currentTimeMillis()+".html";
		
	public static ExtentReports initializeReport(){
		
		if (report == null) { 
            report = new ExtentReports(filePath, true);
        }	
		
		return report;
	}
	
	
	public static ExtentTest initializeextentlogger(String comment){
				
		extlogger=report.startTest(comment);
				return extlogger;
	}

	 
}
