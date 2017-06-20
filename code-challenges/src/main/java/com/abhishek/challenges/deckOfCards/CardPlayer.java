package com.abhishek.challenges.deckOfCards;

import java.util.ArrayList;

public class CardPlayer{
	private ArrayList<Card> hand;
	private int HAND_SIZE = 5;
	
	public CardPlayer(){
		hand = new ArrayList<Card>();
	}
	
	public void add(Card C){
		hand.add(C);
	}
	
	public void showCards(){
		System.out.println(hand);
	}
	
	public int handSize(){
		return HAND_SIZE;
	}
}
