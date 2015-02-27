package edu.neumont.csc230.words;

import edu.neumont.csc230.Word;

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
