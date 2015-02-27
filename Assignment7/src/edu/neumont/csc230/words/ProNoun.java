package edu.neumont.csc230.words;

import edu.neumont.csc230.Word;

public class ProNoun extends Word{

	private String s;
	
	public ProNoun(String s){
		this.s = s;
	}
	
	public String getProNoun(){
		return s;
	}
	
	@Override
	public String toString() {
		return "ProNoun";
	}

	@Override
	public String getResponse() {

		if (s.equals("i")){
			return "you";
		}
		
		return s;
	}

}
