package edu.neumont.csc230.Phrases;

import edu.neumont.csc230.Word;
import edu.neumont.csc230.words.Noun;
import edu.neumont.csc230.words.ProNoun;
import edu.neumont.csc230.words.Verb;

public class VerbPhrase extends Word{

	private String s;
	private String response;
	
	public VerbPhrase(Verb verb){
		s = verb.getVerb();
		response = verb.getResponse();
	}
	
	public VerbPhrase(Verb verb, NounPhrase nounPhrase){
		s = verb.getVerb() + " " + nounPhrase.getNounPhrase();
		response = verb.getResponse() + " " + nounPhrase.getResponse();
	}
	
	public VerbPhrase(VerbPhrase verbPhrase, NounPhrase nounPhrase){
		s = verbPhrase.getVerbPhrase() + " " + nounPhrase.getNounPhrase();
		response = verbPhrase.getResponse() + " " + nounPhrase.getResponse();
	}
	
	public VerbPhrase(ProNoun pronoun, Verb verb, Noun noun){
		s = pronoun.getProNoun() + " " + verb.getVerb() + " " + noun.getNoun();
		response = pronoun.getResponse() + " " + verb.getResponse() + " " + noun.getResponse();
	}
	
	public VerbPhrase(Verb v, ProNoun pronoun){
		s = v.getVerb() + " " + pronoun.getProNoun();
		response = v.getResponse() + " " + pronoun.getResponse();
	}
	
	public VerbPhrase(ProNoun pronoun, Verb v){
		s = pronoun.getProNoun() + " " + v.getVerb();
		response = pronoun.getResponse() + " " + v.getResponse();
	}
	
	public String getVerbPhrase(){
		return s;
	}

	@Override
	public String toString() {
		return "VerbPhrase";
	}

	@Override
	public String getResponse() {

		return response;
	}
	
}
