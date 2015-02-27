package edu.neumont.csc230.words;

import edu.neumont.csc230.Word;

public class Verb extends Word{

	private String verb;
	
	public Verb(String s){
		verb = s;
	}
	
	public String getVerb(){
		return verb;
	}

	@Override
	public String toString() {
		return "Verb";
	}

	@Override
	public String getResponse() {

		if (verb.equals("am")){
			return "are"; 
		}
		
		return verb;
	}

}
