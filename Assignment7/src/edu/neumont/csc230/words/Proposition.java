package edu.neumont.csc230.words;

import edu.neumont.csc230.Word;

public class Proposition extends Word{

	private String s;
	
	public Proposition(String s){
		this.s = s;
	}
	
	public String getProposition(){
		return s;
	}


	@Override
	public String toString() {
		return "Proposition";
	}

	@Override
	public String getResponse() {

		return s;
	}
	
}
