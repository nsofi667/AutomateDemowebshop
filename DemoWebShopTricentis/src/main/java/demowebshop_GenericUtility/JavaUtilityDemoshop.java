package demowebshop_GenericUtility;

import java.util.Date;
import java.util.Random;

/*
 * this class consists methods related to java 
 */
public class JavaUtilityDemoshop {

		/**
		 * This method is used to generate random number
		 * @return
		 */
		public int toGenerateRandomNumber() {
			Random r=new Random();
			int random =r.nextInt(1000);
			return random;
		}
		
		
		public String toGenerateSystemTimeDate() {
			Date d=new Date();
			String date[]=d.toString().split(" ");
			String day = date[0];
			String month = date[1];
			String date1 = date[2];
			String time = date[3].replace(":", "-");
			String year = date[5];
			
			String finalDate = day+" "+month+" "+" "+date1+" "+time+" "+year;
			return finalDate;
			
			
		}
}
