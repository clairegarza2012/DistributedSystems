package edu.neumont.csc230;

import edu.neumont.csc230.Enums.States;

public class StateMachine {

	public States containsHiNotSubstring(String s){
		
		s = s.toUpperCase();
		
		States state = States.Initial;
		
		for (char c : s.toCharArray()){
			
			state = nextState(state, c);
		}
		
		return state;
	}

	private States nextState(States state, char c) {

		States newState = state;
		
		switch (state){
			case Initial:
				if (c == 'H'){
					newState = States.B;
				}else if (c == ' '){
					newState = States.Initial;
				}else {
					newState = States.C;
				}
				break;
			case B:
				if (c =='I'){
					newState = States.Approved1;
				}else if (c == ' '){
					newState = States.Initial;
				}else {
					newState = States.C;
				}
				break;
			case C:
				newState = (c == ' ') ? States.Initial : States.C;
				break;
			case Approved1:
				newState = (c == ' ' || isPunctuation(c)) ? States.Approved2: States.C;
				break;
			case Approved2:
				newState = States.Approved2;
		}
		
		return newState;
	}
	
	private boolean isPunctuation(char c){
		
		return (c == '!') | (c == '.') | (c == '?');
	}
}
