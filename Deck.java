package cardgame;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	
	private ArrayList<Card> cards = new ArrayList<Card>();
	private int amountPenalties = 4;
	
	public Deck() {		//default values
		this.amountPenalties = 4;
		createDeck();
	}
	
	public Deck(int amountPenalties) {
		this.amountPenalties = amountPenalties;
		createDeck();
	}
	
	private void createDeck() {
		
		//add amount penalty cards to the deck
		for (int i=0; i<amountPenalties; i++) {
			cards.add(new Card("Penalty", "Penalty"));
		}
		
		//add all the standard cards to the deck
		String[] values = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
		String[] suits = {"Club","Diamond","Heart","Spade"};
		
		for (int i=0; i<values.length; i++) {
			for (int j=0; j<suits.length; j++) {
				cards.add(new Card(values[i], suits[j]));
				
			}
		}
	}

	//print the entire deck
	public void printDeck() {
		for(int i=0; i<cards.size(); i++) {
			System.out.println(this.cards.get(i).getValue() + " of " + this.cards.get(i).getSuit() + " : " + this.cards.get(i).getNumberValue() );
		}
	}
	
	public void shuffleCards() {
		Collections.shuffle(cards);
	}
	
	public ArrayList<Card> getCardList() {
		return this.cards;
	}
	
	public void setCardList(ArrayList<Card> cards) {
		this.cards = cards;
	}
	
	public int getAmountPenalties() {
		return this.amountPenalties;
	}
	
	public void setAmountPenalties(int amountPenalties) {
		this.amountPenalties = amountPenalties;
	}
	
}
