package demowebshop_GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consist methods to read data from property file
 */
public class PropertyUtilityDemoshop {
		
		/**
		 * This method will read data from property file provided with key
		 * @throws IOException 
		 */
		public String toReadDataFromPropertyFile(String key) throws IOException {
			FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\demoshopTestData.properties");
			Properties prop=new Properties();
			prop.load(fis);
			String value = prop.getProperty(key);
			return value;
		}
}
