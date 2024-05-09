package com.tutorialsninja.qa.utilities;

import java.util.Date;

public class Utilities 
{
/* in case if you need to change email address every single time to avoid being email getting block and to use multiple email 
	  addresses each time, use date class of util package 
*/	
		public static String generateEmailTimeStamp() 
		{
			Date date = new Date();
			return date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
		} 
		
		public static final int IMPLICIT_WAIT_TIMER=10;
		public static final int PAGE_LOAD_TIMER=10;
		
}
