package edu.neumont.csc230.words;

import edu.neumont.csc230.Word;

public class Noun extends Word{

	private String noun;
	
	public Noun(String s){
		noun = s;
	}
	
	public String getNoun(){
		return noun;
	}


	@Override
	public String toString() {
		return "Noun";
	}

	@Override
	public String getResponse() {

		return noun;
	}
	
}
