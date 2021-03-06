package edu.neumont.csc230;

import org.junit.Test;

public class StateMachineTests {

	private StateMachine stateMachine = new StateMachine();
	
	@Test
	public void test() {
		String s = "Hi";
		States state = stateMachine.doStateThings(s);
		String response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
		
		s = "Hello";
		state = stateMachine.doStateThings(s);
		response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
		
		s = "Howdy";
		state = stateMachine.doStateThings(s);
		response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
		
		s = "Aloha";
		state = stateMachine.doStateThings(s);
		response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
		
		s = "Thanks";
		state = stateMachine.doStateThings(s);
		response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
		
		s = "Thank You!";
		state = stateMachine.doStateThings(s);
		response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
	}

	@Test
	public void testHi(){
		String s = "Hi There";
		States state = stateMachine.doStateThings(s);
		String response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
		
		s = "   hi";
		state = stateMachine.doStateThings(s);
		response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
		
		s = "hip";
		state = stateMachine.doStateThings(s);
		response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
	}
	
	@Test
	public void testAloha(){
		String s = "Aloha Amigo!";
		States state = stateMachine.doStateThings(s);
		String response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
		
		s = " aloha";
		state = stateMachine.doStateThings(s);
		response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
		
		s = "notAloha";
		state = stateMachine.doStateThings(s);
		response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
	}
	
	@Test
	public void testHello(){
		String s = "Hello There!";
		States state = stateMachine.doStateThings(s);
		String response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
		
		s = " hello ";
		state = stateMachine.doStateThings(s);
		response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
		
		s = "nothello";
		state = stateMachine.doStateThings(s);
		response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
	}
	
	@Test 
	public void testHowdy(){
		String s = "Howdy Partner!";
		States state = stateMachine.doStateThings(s);
		String response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
		
		s = "  howdy!";
		state = stateMachine.doStateThings(s);
		response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
		
		s = "nothowdy";
		state = stateMachine.doStateThings(s);
		response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
	}

	@Test 
	public void testThanks(){
		String s = "Thanks!";
		States state = stateMachine.doStateThings(s);
		String response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
		
		s = "thank";
		state = stateMachine.doStateThings(s);
		response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
		
		s = " thanks!!";
		state = stateMachine.doStateThings(s);
		response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
		
		s = "nothanks";
		state = stateMachine.doStateThings(s);
		response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
	}
	
	@Test public void testThankYou(){
		String s = "Thank You!";
		States state = stateMachine.doStateThings(s);
		String response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
		
		s = "  thank You!";
		state = stateMachine.doStateThings(s);
		response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
		
		s = "No Thank You.";
		state = stateMachine.doStateThings(s);
		response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
		
		s = "ThankYou";
		state = stateMachine.doStateThings(s);
		response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
		
		s = " notThank You!";
		state = stateMachine.doStateThings(s);
		response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
	}

}
