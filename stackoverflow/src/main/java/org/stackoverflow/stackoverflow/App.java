package org.stackoverflow.stackoverflow;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import com.stackoverflow.contributors.Contributors;
import com.stackoverflow.contributors.Item;
import com.stackoverflow.pojo.Questions;
import com.stackoverflow.properties.ConfigProperties;
import com.stackoverflow.services.impl.SearchWithKeywordAndDateImpl;

/**
 * Hello world!
 *
 */
@SuppressWarnings("unused")
public class App 
{
    public static void main( String[] args ) throws ParseException 
    {
    	SearchWithKeywordAndDateImpl searchKeyword=new SearchWithKeywordAndDateImpl();
    	ConfigProperties configProperties=new ConfigProperties();
    	Properties properties=configProperties.loadProperties();
    	
	  List<com.stackoverflow.pojo.Item> allQuestions=searchKeyword.getAllQuestions(properties.getProperty("stackoverflow.search.keyword"),properties.getProperty("stackoverflow.search.fromdate"),properties.getProperty("stackoverflow.search.todate"));
      
      List<com.stackoverflow.pojo.Item> ans= searchKeyword.getAllAnsweredQuestions(properties.getProperty("stackoverflow.search.keyword"),properties.getProperty("stackoverflow.search.fromdate"),properties.getProperty("stackoverflow.search.todate"));
                
      List<com.stackoverflow.pojo.Item> ques= searchKeyword.getMostViewedQuestionsUnanswered(properties.getProperty("stackoverflow.search.keyword"),properties.getProperty("stackoverflow.search.fromdate"),properties.getProperty("stackoverflow.search.todate"));
     
      List<com.stackoverflow.pojo.Item> ansQues= searchKeyword.getMostViewedQuestionsAnswered(properties.getProperty("stackoverflow.search.keyword"),properties.getProperty("stackoverflow.search.fromdate"),properties.getProperty("stackoverflow.search.todate"));

      List<List<Item>> contributors= searchKeyword.getContributorsToAnsweredQuestions(properties.getProperty("stackoverflow.search.keyword"),properties.getProperty("stackoverflow.search.fromdate"),properties.getProperty("stackoverflow.search.todate"));
    }
}
