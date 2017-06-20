package com.abhishek.challenges.deckOfCards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
	private ArrayList<Card> cards;

	 Deck(){
		cards = new ArrayList<Card>();
		
		//52 cards >> 13 cards of from each of four suits
		for (int suit=0; suit<4; suit++){
			for (int rank=0; rank<13; rank++){
			   cards.add(new Card(suit,rank));
			 }
		}
	}

	public void shuffleCards(){
		// method 1
			Random random = new Random();
			// shuffling cards >> swapping randomly selected pairs for 50 times
			for (int i=0; i<50; i++){
				int rand1 = random.nextInt(cards.size()-1);
				int rand2 = random.nextInt(cards.size()-1);
				// swapping two cards in two index locations of the list
				Card card1 = (Card) cards.get(rand1);
				Card card2 = (Card) cards.get(rand2);
				cards.set(rand2, card1);
				cards.set(rand1, card2);
			}
		
		// method 2
		// or just use static shuffle methods from Collections Class
//			Collections.shuffle(cards);
		
	}
	public Card drawCardFromDeck(){	   
		return cards.remove(0);
	}

	public int getTotalCards(){
		return cards.size();
	}
}
