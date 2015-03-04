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
	
	public Sentence(NounPhrase nounPhrase){
		s = nounPhrase.getNounPhrase();
		response = nounPhrase.getResponse();
	}
	
	public String getSentence(){
		return s;
	}

	@Override
	public String toString() {
		return "Sentence";
	}

	public String getResponse(int num, Sentence prevSent) {

		switch (num){
			case 0:
				return getResponseZero();
			case 1:
				return getResponseOne(prevSent);
			case 2:
				return getResponseTwo();
			case 3:
				return getResponseThree();
			default:
				return getResponseZero();
		}
	}

	private String getResponseThree() {
		
		if (response.startsWith("i")){
			if (response.contains("like") || response.contains("hate")){
				response = response.replace(" too!", "");
				String responseYou =  response.replaceFirst("i", "you");
				response = "Yeah, I just said " + response + ", because you said that " + responseYou + ".\n";
				responseYou = responseYou.replace("you ", "");
				response += "I don't actually " + responseYou + ".";
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

	private String getResponseTwo() {
	
		response = s + " too!";
		return response;
	}

	private String getResponseOne(Sentence prevSent) {
		
		if (response.contains("you")){
			if (response.contains("like") || response.contains("hate")){
				String[] responseArray = response.split("\\s|\\?");
				response = response.replace("Why do", "What about " + responseArray[responseArray.length - 1] + " makes");
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
		if (s.contains("flavor") || s.contains("taste")){
			String[] prevSentArray = prevSent.getSentence().split("\\s|\\.|\\?|!");
			response = "What about " + s + " of " + prevSentArray[prevSentArray.length - 1] + " do you like?";
		}
		
		return response;
	}

	private String getResponseZero() {
		
		if (response.startsWith("you")){
			if (response.contains("like") || response.contains("hate")){
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
		else if (response.contains("flavor") || response.contains("taste")){
			response = "Interesting. What else do you like?";
		}
		
		return response;
	}

	@Override
	public String getResponse() {
		return getResponseZero();
	}
	
}
