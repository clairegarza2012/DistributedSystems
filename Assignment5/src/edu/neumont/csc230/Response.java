package edu.neumont.csc230;

import java.util.Random;

public class Response {

	private Random rand = new Random();
	private String response = "";
	
	public Response(States state){

		int ran = rand.nextInt(2);
				
		String response = "Do not compute!";

		if (state == States.AcceptAloha || state == States.Aloha) {
			response = getAlohaResponse(ran);
		}else if (state == States.AcceptHi || state == States.Hi) {
			response = getHiResponse(ran);
		}else if (state == States.AcceptHello || state == States.Hello) {
			response = getHelloResponse(ran);
		}else if (state == States.AcceptHowdy || state == States.Howdy) {
			response = getHowdyResponse(ran);
		}else if (state == States.Thanks || state == States.AcceptThanks
				|| state == States.you || state == States.AcceptYou) {
			response = getThanksResponse(ran);
		}else {
			response = getDefaultResponse();
		}
		
		this.response = response;
	}
	
	private String getDefaultResponse() {

		int ran = rand.nextInt(4);
		
		String strang = "";
		
		if (ran == 0){
			strang = "What great weather!";
		}else if (ran == 1){
			strang = "Tell me about yourself";
		}else if (ran == 2){
			strang = "What do you like to do?";
		}else if (ran == 3){
			strang = "What makes you sad?";
		}else{
			strang = "I goofed";
		}
		
		return strang;
	}

	private String getThanksResponse(int ran) {
		
		return (ran == 0)? "You're Welcome!" : "No, Thank You!";
	}

	private String getHowdyResponse(int ran) {

		return "Howdy Partner!";
	}

	private String getHelloResponse(int ran) {

		return (ran == 0)? "Hello" : "How are you?";
	}

	private String getHiResponse(int ran) {
		
		return (ran == 0)? "Hi" : "Sup!";
	}

	private String getAlohaResponse(int ran) {
		
		return (ran == 0)? "Aloha" : "Surfs Up!";
	}

	public String getResponse(){
		return response;
	}
}
