package edu.neumont.csc230;

public class StateMachine {

	public States doStateThings(String s){

		States state = States.Initial;

		for (char c : s.toCharArray()){

			state = nextState(state, c);
		}

		return state;
	}

	public String getResponse(States state){

		Response r = new Response(state);
		
		return r.getResponse();
	}

	private States nextState(States state, char c) {

		States newState = state;

		switch (state){
			case Initial:
				if (c == 'H'){
					newState = States.H;
				}else if (c == 'h'){
					newState = States.h;
				}else if (c == 'A'){
					newState = States.A;
				}else if (c == 'a'){
					newState = States.a;
				}else if (c == 'T'){
					newState = States.T;
				}else if (c == 't'){
					newState = States.t;
				}else if (c == ' '){
					newState = States.Initial;
				}else {
					newState = States.BadState;
				}break;
			case A:
			case a:
				if (c == 'l'){
					newState = States.L;
				}else if (c == ' '){
					newState = States.Initial;
				}else {
					newState = States.BadState;
				}break;
			case AcceptAloha:
				newState = States.AcceptAloha;
				break;
			case AcceptHello:
				newState = States.AcceptHello;
				break;
			case AcceptHi:
				newState = States.AcceptHi;
				break;
			case AcceptHowdy:
				newState = States.AcceptHowdy;
				break;
			case AcceptThanks:
				newState = States.AcceptThanks;
				break;
			case AcceptYou:
				newState = States.AcceptYou;
				break;
			case Aloha:
				 newState = (isPunctuation(c) || c == ' ') ? States.AcceptAloha: States.BadState;
				break;
			case BadState:
				newState = (c == ' ') ? States.Initial : States.BadState;
				break;
			case H:
			case h:
				if (c == 'i'){
					newState = States.Hi;
				}else if (c == 'e'){
					newState = States.e;
				}else if (c == 'o'){
					newState = States.o;
				}else if (c == ' '){
					newState = States.Initial;
				}else {
					newState = States.BadState;
				}break;
			case Hello:
				newState = (isPunctuation(c) || c == ' ') ? States.AcceptHello : States.BadState;
				break;
			case Hi:
				newState = (isPunctuation(c) || c == ' ') ? States.AcceptHi : States.BadState;
				break;
			case Howdy:
				newState = (isPunctuation(c) || c == ' ') ? States.AcceptHowdy : States.BadState;
				break;
			case L:
				if (c == 'o'){
					newState = States.O;
				}else if (c == ' '){
					newState = States.Initial;
				}else {
					newState = States.BadState;
				}break;
			case O:
				if (c == 'h'){
					newState = States.oh;
				}else if (c == ' '){
					newState = States.Initial;
				}else {
					newState = States.BadState;
				}break;
			case Space:
				if (c == ' '){
					newState = States.Space;
				}else if (c == 'y' || c == 'Y'){
					newState = States.y;
				}else {
					newState = States.BadState;
				}break;
			case T:
			case t:
				if (c == 'h'){
					newState = States.b;
				}else if (c == ' '){
					newState = States.Initial;
				}else {
					newState = States.BadState;
				}break;
			case Thanks:
				newState = (isPunctuation(c) || c == ' ') ? States.AcceptThanks : States.BadState;
				break;
			case b:
				if (c == 'a'){
					newState = States.c;
				}else if (c == ' '){
					newState = States.Initial;
				}else {
					newState = States.BadState;
				}break;
			case c:
				if (c == 'n'){
					newState = States.n;
				}else if (c == ' '){
					newState = States.Initial;
				}else {
					newState = States.BadState;
				}break;
			case d:
				if (c == 'y'){
					newState = States.Howdy;
				}else if (c == ' '){
					newState = States.Initial;
				}else {
					newState = States.BadState;
				}break;
			case e:
				if (c == 'l'){
					newState = States.l;
				}else if (c == ' '){
					newState = States.Initial;
				}else {
					newState = States.BadState;
				}break;
			case g:
				if (c == 'u'){
					newState = States.you;
				}else if (c == ' '){
					newState = States.Initial;
				}else {
					newState = States.BadState;
				}break;
			case k:
				if (c == 's'){
					newState = States.Thanks;
				}else if (c == 'y' || c == 'Y'){
					newState = States.y;
				}else if (c == ' '){
					newState = States.Space;
				}else {
					newState = States.BadState;
				}break;
			case l:
				if (c == 'l'){
					newState = States.ll;
				}else if (c == ' '){
					newState = States.Initial;
				}else {
					newState = States.BadState;
				}break;
			case ll:
				if (c == 'o'){
					newState = States.Hello;
				}else if (c == ' '){
					newState = States.Initial;
				}else {
					newState = States.BadState;
				}break;
			case n:
				if (c == 'k'){
					newState = States.k;
				}else if (c == ' '){
					newState = States.Initial;
				}else {
					newState = States.BadState;
				}break;
			case o:
				if (c == 'w'){
					newState = States.w;
				}else if (c == ' '){
					newState = States.Initial;
				}else {
					newState = States.BadState;
				}break;
			case oh:
				if (c == 'a'){
					newState = States.Aloha;
				}else if (c == ' '){
					newState = States.Initial;
				}else {
					newState = States.BadState;
				}break;
			case w:
				if (c == 'd'){
					 newState = States.d;
				}else if (c == ' '){
					newState = States.Initial;
				}else {
					newState = States.BadState;
				}break;
			case y:
				if (c == 'o'){
					newState = States.g;
				}else if (c == ' '){
					newState = States.Initial;
				}else {
					newState = States.BadState;
				}break;
			case you:
				newState = (isPunctuation(c) || c == 'c') ? States.AcceptYou : States.BadState;
				break;
		}

		return newState;
	}

	private boolean isPunctuation(char c){

		return (c == '!') | (c == '.') | (c == '?');
	}
	
	public static void main(String[] args){
		
		StateMachine stateMachine = new StateMachine();
		
		String s = "Thanks";
		States state = stateMachine.doStateThings(s);
		String response = stateMachine.getResponse(state);
		System.out.println("Sent: " + s + "\nResponse: " + response + "\n");
		
	}
}
