package Utility;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {
	
	Properties prop = new Properties();
	public PropertiesUtility() {
		try {
		
	//Step1. create java representation of file
		 	FileReader fr= new FileReader("./src/test/resources/CommonData.properties");
		 		prop.load(fr);
		 	
			} catch (IOException e) {

				e.printStackTrace();

			}
	}

	public String getPropertyData(String key) {
		
		return prop.getProperty(key);
		
	
	}
	
}
