package edu.enumont.csc230;

import edu.enumont.csc230.Enums.States;


public class StateMachine {

	public States doStateThings(String s){

		s = s.toUpperCase();

		States state = States.Initial;

		for (char c : s.toCharArray()){

			state = nextState(state, c);
		}

		return state;
	}

	public String getResponse(States state){

		String response = "Do not compute!";

		if (state == States.AcceptAloha || state == States.K){
			response = "Aloha";
		}else if (state == States.AcceptHi || state == States.F){
			response = "Hey There!";
		}else if (state == States.AcceptHello || state == States.R) {
			response = "Sup";
		}else if (state == States.AcceptHowdy || state == States.O) {
			response = "Howdy Partner!";
		}else {
			response = "Do not compute!";
		}

		return response;
	}

	private States nextState(States state, char c) {

		States newState = state;

		switch (state){
			case Initial:
				if (c == 'H'){
					newState = States.A;
				}else if (c == 'A'){
					newState = States.B;
				}else if (c == ' '){
					newState = States.Initial;
				}else {
					newState = States.C;
				}break;
			case A:
				if (c == 'O'){
					newState = States.D;
				}else if (c == 'E'){
					newState = States.E;
				}else if (c == 'I'){
					newState = States.F;
				}else if (c == ' '){
					newState = States.Initial;
				}else {
					newState = States.C;
				}break;
			case B:
				if (c == 'L'){
					newState = States.H;
				}else if (c == ' '){
					newState = States.Initial;
				}else {
					newState = States.C;
				}break;
			case C:
				newState = (c == ' ')? States.Initial : States.C;
				break;
			case D:
				if (c == 'W'){
					newState = States.M;
				}else if (c == ' '){
					newState = States.Initial;
				}else{
					newState = States.C;
				}break;
			case E:
				if (c == 'L'){
					newState = States.P;
				}else if (c == ' '){
					newState = States.Initial;
				}else {
					newState = States.C;
				}break;
			case F:
				if (c == ' ' || isPunctuation(c)){
					newState = States.AcceptHi;
				}else {
					newState = States.C;
				}break;
			case H:
				if (c == 'O'){
					newState = States.I;
				}else if (c == ' '){
					newState = States.Initial;
				}else {
					newState = States.C;
				}break;
			case I:
				if (c == 'H'){
					newState = States.J;
				}else if (c == ' '){
					newState = States.Initial;
				}else {
					newState = States.C;
				}break;
			case J:
				if (c == 'A'){
					newState = States.K;
				}else if (c == ' '){
					newState = States.Initial;
				}else {
					newState = States.C;
				}break;
			case K:
				if (c == ' ' || isPunctuation(c)){
					newState = States.AcceptAloha;
				}else {
					newState = States.C;
				}break;
			case M:
				if (c == 'D'){
					newState = States.N;
				}else if (c == ' '){
					newState = States.Initial;
				}else {
					newState = States.C;
				}break;
			case N:
				if (c == 'Y'){
					newState = States.O;
				}else if (c == ' '){
					newState = States.Initial;
				}else {
					newState = States.C;
				}break;
			case O:
				if (c == ' ' || isPunctuation(c)){
					newState = States.AcceptHowdy;
				}else {
					newState = States.C;
				}break;
			case P: 
				if (c == 'L'){
					newState = States.Q;
				}else if (c == ' '){
					newState = States.Initial;
				}else {
					newState = States.C;
				}break;
			case Q:
				if (c == 'O'){
					newState = States.R;
				}else if (c == ' '){
					newState = States.Initial;
				}else {
					newState = States.C;
				}break;
			case R:
				if (c == ' ' || isPunctuation(c)){
					newState = States.AcceptHello;
				}else {
					newState = States.C;
				}break;
			case AcceptHi:
				newState = States.AcceptHi;
				break;
			case AcceptHello:
				newState = States.AcceptHello;
				break;
			case AcceptAloha:
				newState = States.AcceptAloha;
				break;
			case AcceptHowdy:
				newState = States.AcceptHowdy;
				break;
		}

		return newState;
	}

	private boolean isPunctuation(char c){

		return (c == '!') | (c == '.') | (c == '?');
	}
}
