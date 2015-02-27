package edu.neumont.cscs230.words;

import edu.neumont.cscs230.Word;

public class Article extends Word{

	private String article;
	
	public Article(String s){
		article = s;
	}
	
	public String getArticle(){
		return article;
	}

	@Override
	public String toString() {
		return "Article";
	}

	@Override
	public String getResponse() {

		return article;
	}
	
}
