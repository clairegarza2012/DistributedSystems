package edu.neumont.cscs230;

import edu.neumont.cscs230.words.Article;
import edu.neumont.cscs230.words.Noun;
import edu.neumont.cscs230.words.ProNoun;
import edu.neumont.cscs230.words.Proposition;
import edu.neumont.cscs230.words.Verb;

public abstract class Word {
	
	public static Word getType(String s){
		
		Word word = null;
		s = s.toLowerCase();
		
		if (isVerb(s)){
			word = new Verb(s);
		}else if (isNoun(s)){
			word = new Noun(s);
		}else if (isProposition(s)){
			word = new Proposition(s);
		}else if (isArticle(s)){
			word = new Article(s);
		}else if (isProNoun(s)){
			word = new ProNoun(s);
		}
			
		return word;
	}

	private static boolean isProNoun(String s) {
		return s.equals("i") || s.equals("me");
	}

	private static boolean isArticle(String s) {

		return s.equals("a") || s.equals("the");
	}

	private static boolean isProposition(String s) {

		return s.equals("with");
	}

	private static boolean isNoun(String s) {

		return s.equals("dog") || s.equals("fish") || s.equals("cat") || s.equals("cheese");
	}

	private static boolean isVerb(String s) {

		return s.equals("bites") || s.equals("chases") || s.equals("am") || s.equals("like");
	}

	public abstract String toString();	
	
	public abstract String getResponse();
}