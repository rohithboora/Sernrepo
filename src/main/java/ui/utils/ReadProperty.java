package ui.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperty {
	
	public static String loadPropertyValue(String keyword, String propertyfile) {
		Properties props = new Properties();
		FileInputStream filePath = null;
		String UserDir = System.getProperty("user.dir");

		String filePathString = UserDir+ File.separator +"src"+ File.separator +"main"+ File.separator +"resources"+ File.separator +"properties"+ File.separator +propertyfile+".properties";
    	try{
			filePath = new FileInputStream(filePathString);
			props.load(filePath);
			filePath.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return props.getProperty(keyword, propertyfile);
	}
}

