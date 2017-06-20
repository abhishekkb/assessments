package com.abhishek.challenges.deckOfCards;

public class DeckOfCardsDemo{
	public static void main(String[] args){
		Deck deck = new Deck();
		Card card;
		CardPlayer player = new CardPlayer();

		deck.shuffleCards();

		// Deals/draws a hand from the Deck to a player.
		for(int i=0; i<player.handSize(); i++){
			card = deck.drawCardFromDeck();
			player.add(card);
		}
		
		player.showCards();
	}
}

