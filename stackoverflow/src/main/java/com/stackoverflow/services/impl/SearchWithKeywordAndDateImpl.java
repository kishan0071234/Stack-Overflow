package com.stackoverflow.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.stackoverflow.contributors.Contributors;
import com.stackoverflow.pojo.Item;
import com.stackoverflow.pojo.Questions;
import com.stackoverflow.properties.ConfigProperties;
import com.stoackoverflow.services.SearchWithKeywordAndDate;

public class SearchWithKeywordAndDateImpl implements SearchWithKeywordAndDate {

    static RestTemplate restTemplate =null;
    static Properties properties=null;
    static String searchWithKeywordAndDate =null;
    static HttpHeaders headers =null;
    static HttpEntity<String> entity =null;
   
    //loading the properties file and creating restTempalte only once
    static {
    	
    	properties=loadProperties();
    	restTemplate=new RestTemplate();
		restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory()); //To accept gzip data
    	headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    entity = new HttpEntity<String>("parameters", headers); 
	    searchWithKeywordAndDate=properties.getProperty("stackoverflow.search.api");
    }
    
    /*
     * This method is used to
     * load the properties file
     */
    public static Properties loadProperties() {
    	
    	ConfigProperties configProperties=new ConfigProperties();
    	return configProperties.loadProperties();
    }

    /*
     * This method is used to 
     * get all questions related
     * to keyword and dates
     */
    @Override
    public List<Item> getAllQuestions(String keyword,String fromDate,String toDate) {
    	
    	//calling the rest api to fetch all questions
    	if(!StringUtils.isEmpty(keyword) && !StringUtils.isEmpty(fromDate) && !StringUtils.isEmpty(toDate)) {
	    ResponseEntity<Questions> data = restTemplate.exchange(searchWithKeywordAndDate+"search?site=stackoverflow&intitle="+keyword+"&fromdate="+fromDate+"&todate="+toDate, HttpMethod.GET, entity, Questions.class);

		 if(data.getStatusCode().is2xxSuccessful() && CollectionUtils.isNotEmpty(data.getBody().getItems())) {
       	    return data.getBody().getItems();
		 }
    	} 
		 return Collections.emptyList();
    }
    /*
     * This method is used to get
     * all questions which are answered
     * for the question
     */
    @Override
    public List<Item> getAllAnsweredQuestions(String keyword,String fromDate,String toDate) {
    	
    	if(!StringUtils.isEmpty(keyword) && !StringUtils.isEmpty(fromDate) && !StringUtils.isEmpty(toDate)) {
       try {
       	//calling the rest api to fetch all questions
	    ResponseEntity<Questions> data = restTemplate.exchange(searchWithKeywordAndDate+"search?site=stackoverflow&intitle="+keyword+"&fromDate="+fromDate+"&toDate="+toDate, HttpMethod.GET, entity, Questions.class);
		  
		 if(data.getStatusCode().is2xxSuccessful() && CollectionUtils.isNotEmpty(data.getBody().getItems())) {
		
		//Filtering the questions that are answered
		  return data.getBody().getItems()
		          .stream()
				  .filter(isAnswer->isAnswer.getIsAnswered())
				  .collect(Collectors.toList());
		           }
                }
       catch(Exception exception) {
	       exception.getStackTrace();
            }
       	}
		  return Collections.emptyList();
    }
     /*
      * This method is used to get
      * top most viewed questions
      */
    @Override
    public List<Item> getMostViewedQuestionsAnswered(String keyword,String fromDate,String toDate) {
    	
    	List<Item> items=new ArrayList<>();
    	if(!StringUtils.isEmpty(keyword) && !StringUtils.isEmpty(fromDate) && !StringUtils.isEmpty(toDate)) {

		  try {   
		    ResponseEntity<Questions> data = restTemplate.exchange(searchWithKeywordAndDate+"search?site=stackoverflow&intitle="+keyword+"&fromDate="+fromDate+"&toDate="+toDate, HttpMethod.GET, entity, Questions.class);
		    
		 if(data.getStatusCode().is2xxSuccessful() && CollectionUtils.isNotEmpty(data.getBody().getItems())) {
		
			//adding the questions to list that are answered and has atleast 1 viewcount
    	   data.getBody().getItems()
          .stream()
		  .filter(isAnswer->isAnswer.getIsAnswered() && isAnswer.getViewCount()>0)
		  .forEach(viewCount->items.add(viewCount));
    	   
    	   //sorting the questions in descending order w.r.t. viewCount and returning top 10 questions
	   return items.stream().sorted(Comparator.comparing(Item::getViewCount)
	               .reversed())
	               .limit(Integer.parseInt(properties.getProperty("stackoverflow.top.questions.count")))
                   .collect(Collectors.toList());
	      }
		  }
		  catch(Exception exception) {
         exception.getStackTrace();
          }
       	}
		  return Collections.emptyList();
	      }	
    /*
     * This method is used to
     * get all contributors for the top questions.
     */
    @Override
    public List<com.stackoverflow.contributors.Item> getAllContributors(int questionId) {
    	

    	try {
		    ResponseEntity<Contributors> data = restTemplate.exchange(searchWithKeywordAndDate+"questions/"+questionId+"/answers?site=stackoverflow", HttpMethod.GET, entity, Contributors.class);

		    if(data.getStatusCode().is2xxSuccessful() && CollectionUtils.isNotEmpty(data.getBody().getItems())) {

 				 return data.getBody().getItems()
 						 .stream().collect(Collectors.toList());
 			 }
    	}
    	catch(Exception exception) {
    		exception.getStackTrace();
    	}
       	
			  return Collections.emptyList();
    }
    /*
     * This method is used to get all
     * contributors to the most viewed and answered
     * questions
     */
    @Override
       public List<List<com.stackoverflow.contributors.Item>> getContributorsToAnsweredQuestions(String keyword,String fromDate,String toDate) {
	
            List<List<com.stackoverflow.contributors.Item>> listOfItems=new ArrayList<>();    
            if(!StringUtils.isEmpty(keyword) && !StringUtils.isEmpty(fromDate) && !StringUtils.isEmpty(toDate)) {

            //getting most viewed questions and finding the contributors for that questions
            getMostViewedQuestionsAnswered(keyword, fromDate, toDate) 
	          .forEach(contributors->{
	        	  listOfItems.add(getAllContributors(contributors.getQuestionId()));
	        	 	          });
           	}
            return listOfItems;
	}

    /*
     * This method is used to get
     * top questions that
     * are unAnswered.
     */
	@Override
	public List<Item> getMostViewedQuestionsUnanswered(String keyword, String fromDate, String toDate) {

    	List<Item> items=new ArrayList<>();
    	if(!StringUtils.isEmpty(keyword) && !StringUtils.isEmpty(fromDate) && !StringUtils.isEmpty(toDate)) {

		  try {   
		    ResponseEntity<Questions> data = restTemplate.exchange(searchWithKeywordAndDate+"search?site=stackoverflow&intitle="+keyword+"&fromDate="+fromDate+"&toDate="+toDate, HttpMethod.GET, entity, Questions.class);
		     
		 if(data.getStatusCode().is2xxSuccessful() && CollectionUtils.isNotEmpty(data.getBody().getItems())) {
		
			//adding the questions to list that are answered and has atleast 1 viewcount
    	   data.getBody().getItems()
          .stream()
		  .filter(isAnswer->!isAnswer.getIsAnswered()&&isAnswer.getViewCount()>0)
		  .forEach(viewCount->items.add(viewCount));
    	   
    	   //sorting the questions in descending order w.r.t. viewCount and returning top questions
	   return items.stream().sorted(Comparator.comparing(Item::getViewCount)
	               .reversed())
	               .limit(Integer.parseInt(properties.getProperty("stackoverflow.top.questions.count")))
                   .collect(Collectors.toList()); 
	      }
		  } 
		  catch(Exception exception) {
         exception.getStackTrace();
          }
       	}
		  return Collections.emptyList();
	}
}