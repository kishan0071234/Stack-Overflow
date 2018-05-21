package com.stoackoverflow.services;

import java.util.List;

import com.stackoverflow.pojo.Item;

public interface SearchWithKeywordAndDate {

	 public List<Item> getAllQuestions(String keyword,String fromDate,String toDate);
	 
	 public List<Item> getAllAnsweredQuestions(String keyword,String fromDate,String toDate);
	 
	 public List<Item> getMostViewedQuestionsAnswered(String keyword,String fromDate,String toDate);
	 
	 public List<Item> getMostViewedQuestionsUnanswered(String keyword,String fromDate,String toDate);
	 
	 public List<com.stackoverflow.contributors.Item> getAllContributors(int questionId);
	 
	 public List<List<com.stackoverflow.contributors.Item>> getContributorsToAnsweredQuestions(String keyword,String fromDate,String toDate);
}
