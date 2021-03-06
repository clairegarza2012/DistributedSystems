package edu.neumont.csc230.tests;

import org.junit.Assert;
import org.junit.Test;

import edu.neumont.csc230.StateMachine;
import edu.neumont.csc230.Enums.States;

public class StateMachineTest {

	private StateMachine stateMachine = new StateMachine();

	@Test
	public void test() {

		String s = "HI";

		States state = stateMachine.containsHiNotSubstring(s);

		Assert.assertEquals(States.Approved1, state);
	}

	@Test
	public void containsHiNotSubstring(){

		String s = "HI!!!!";

		States state = stateMachine.containsHiNotSubstring(s);
		Assert.assertEquals(States.Approved2, state);
		
		s = "My name is hi.";

		state = stateMachine.containsHiNotSubstring(s);
		Assert.assertEquals(States.Approved2, state);
		
		s = "My name is  hi";

		state = stateMachine.containsHiNotSubstring(s);
		Assert.assertEquals(States.Approved1, state);
		
		s = "Hi Partner.";

		state = stateMachine.containsHiNotSubstring(s);
		Assert.assertEquals(States.Approved2, state);
		
		s = "I hi hello";

		state = stateMachine.containsHiNotSubstring(s);
		Assert.assertEquals(States.Approved2, state);
	}

	@Test
	public void containsHiSubstring(){

		String s = "This has the substring \"hi\"";

		States state = stateMachine.containsHiNotSubstring(s);
		Assert.assertEquals(States.C, state);
		
		s = "HIPartner";

		state = stateMachine.containsHiNotSubstring(s);
		Assert.assertEquals(States.C, state);
		
		s = "I hip";

		state = stateMachine.containsHiNotSubstring(s);
		Assert.assertEquals(States.C, state);
		
		s = "I h";

		state = stateMachine.containsHiNotSubstring(s);
		Assert.assertEquals(States.B, state);
	}

	@Test
	public void doesNotContainHi(){

		String s = "I am just a random string";

		States state = stateMachine.containsHiNotSubstring(s);
		Assert.assertEquals(States.C, state);
		
		s = "I am just a random string that ends in a space ";

		state = stateMachine.containsHiNotSubstring(s);
		Assert.assertEquals(States.Initial, state);
	}
}
