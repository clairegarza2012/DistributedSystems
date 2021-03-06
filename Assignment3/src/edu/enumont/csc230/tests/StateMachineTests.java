package edu.enumont.csc230.tests;

import org.junit.Test;

import edu.enumont.csc230.StateMachine;
import edu.enumont.csc230.Enums.States;

public class StateMachineTests {

	private StateMachine stateMachine = new StateMachine();
	
	@Test
	public void test() {

		String s = "Hi";
		States state = stateMachine.doStateThings(s);
		String response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
		
		s = "Howdy";
		state = stateMachine.doStateThings(s);
		response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
		
		s = "Aloha";
		state = stateMachine.doStateThings(s);
		response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
		
		s = "Hello";
		state = stateMachine.doStateThings(s);
		response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
	}

	@Test
	public void HiTests(){
		String s = "Hip";
		States state = stateMachine.doStateThings(s);
		String response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
		
		s = "Ahi ";
		state = stateMachine.doStateThings(s);
		response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
		
		s = "Ahio";
		state = stateMachine.doStateThings(s);
		response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
		
		s = "Hi There!";
		state = stateMachine.doStateThings(s);
		response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
		
		s = "Hi!";
		state = stateMachine.doStateThings(s);
		response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
		
		s = "Words Hi!";
		state = stateMachine.doStateThings(s);
		response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
	}
	
	@Test
	public void HowdyTests(){
		String s = "Howdy Partner!";
		States state = stateMachine.doStateThings(s);
		String response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
		
		s = "Ahowdy ";
		state = stateMachine.doStateThings(s);
		response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
		
		s = "Ahowdyo";
		state = stateMachine.doStateThings(s);
		response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
		
		s = "Howdy!!";
		state = stateMachine.doStateThings(s);
		response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
		
		s = "Words Howdy!";
		state = stateMachine.doStateThings(s);
		response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
	}
	
	@Test
	public void AlohaTests(){
		String s = "Aloha!!";
		States state = stateMachine.doStateThings(s);
		String response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
		
		s = "AAloha ";
		state = stateMachine.doStateThings(s);
		response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
		
		s = "Alohao";
		state = stateMachine.doStateThings(s);
		response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
		
		s = "Words Aloha!";
		state = stateMachine.doStateThings(s);
		response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
	}
	
	@Test
	public void HelloTests(){
		String s = "Hello Neighbor!";
		States state = stateMachine.doStateThings(s);
		String response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
		
		s = "Helloo";
		state = stateMachine.doStateThings(s);
		response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
		
		s = "MeHello";
		state = stateMachine.doStateThings(s);
		response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
		
		s = "Words Hello!";
		state = stateMachine.doStateThings(s);
		response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
	}
}
