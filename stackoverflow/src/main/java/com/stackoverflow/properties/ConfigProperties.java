package com.stackoverflow.properties;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {

    private Properties configProperties = new Properties();

    String propertyFile="config.properties";
    
    /*
     * This method is used to fetch config.properties
     * file and load in the classpath
     */
    public Properties loadProperties() {
    	     InputStream inputStream=  this.getClass().getResourceAsStream("/com/stackoverflow/properties/"+propertyFile);
    	       try {
    	    	
    	    	   if(null!=inputStream) {
    	    		   
    	    		   configProperties.load(inputStream);
    	    	   }
    	    	   
    	    	   else {
    	    		   
    	    		   throw new FileNotFoundException("Property File:"+propertyFile+"not found in the classpath");
    	    	   }
    	       
    } catch (Exception e) {
		System.out.println("Exception: " + e);
	} finally { 
		try {
			inputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	       return configProperties;
    }
}
