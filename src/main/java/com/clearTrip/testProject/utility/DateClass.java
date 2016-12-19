package com.clearTrip.testProject.utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateClass {
	
	public boolean compareDate(String date1, String date2){
		DateFormat format = new SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH);
		Date dt_date1;
		Date dt_date2;
	
		try {
			dt_date1 = format.parse(date1);
			dt_date2 = format.parse(date2);
			
			 if (dt_date1.compareTo(dt_date2)<0){
			   //   System.out.println("Start date is lesser than end date");
			 return false;
			 }
			  else if (dt_date1.compareTo(dt_date2)>0){
			     // System.out.println("Start date is greater than end date"); 
			 return true;
			  }
			  else{
			     // System.out.println("Both Dates are equal"); 
			return true;
			  }
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			return false;
		}
		
		
	}

}
