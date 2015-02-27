package edu.neumont.csc230;

import edu.neumont.csc230.Phrases.NounPhrase;
import edu.neumont.csc230.Phrases.VerbPhrase;
import edu.neumont.csc230.words.ProNoun;

public class Sentence extends Word{

	private String s;
	private String response;
	
	public Sentence(NounPhrase nounPhrase, VerbPhrase verbPhrase){
		s = nounPhrase.getNounPhrase() + " " + verbPhrase.getVerbPhrase();
		response = nounPhrase.getResponse() + " " + verbPhrase.getResponse();
	}
	
	public Sentence(ProNoun pronoun, VerbPhrase verbPhrase){
		s = pronoun.getProNoun() + " " + verbPhrase.getVerbPhrase();
		response = pronoun.getResponse() + " " + verbPhrase.getResponse();
	}
	
	public Sentence(VerbPhrase verbPhrase){
		s = verbPhrase.getVerbPhrase();
		response = verbPhrase.getResponse();
	}
	
	public String getSentence(){
		return s;
	}

	@Override
	public String toString() {
		return "Sentence";
	}

	@Override
	public String getResponse() {

		if (response.startsWith("you")){
			if (response.contains("like")){
				response = "Why do " + response + "?";
			} else if (response.contains("are")){
				response = response.replace("are", "like being");
				response = "How do " + response + "?";
			}
		}
		else if (response.contains("chases")){
			response = "Sounds Fun!";
		}
		else if (response.contains("bites")){
			response = "Ouch!!";
		}
		
		return response;
	}
	
}
