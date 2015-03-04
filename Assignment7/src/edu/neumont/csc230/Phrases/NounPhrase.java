package edu.neumont.csc230.Phrases;

import edu.neumont.csc230.Word;
import edu.neumont.csc230.words.Article;
import edu.neumont.csc230.words.Noun;
import edu.neumont.csc230.words.Proposition;

public class NounPhrase extends Word{

	private String s;
	private String response;
	
	public NounPhrase(Article article, Noun noun){
		s = article.getArticle() + " " + noun.getNoun();
		response = article.getResponse() + " " + noun.getResponse();
	}
	
	public NounPhrase(Article article, Noun noun, Proposition proposition, NounPhrase nounPhrase){
		s = article.getArticle() + " " + noun.getNoun() + " " + proposition.getProposition() + " " + nounPhrase.getNounPhrase();
		response = article.getResponse() + " " + noun.getResponse() + " " + proposition.getResponse() + " " + nounPhrase.getResponse();
	}
	
	public String getNounPhrase(){
		return s;
	}

	@Override
	public String toString() {
		return "NounPhrase";
	}

	@Override
	public String getResponse() {

		return response;
	}

}
