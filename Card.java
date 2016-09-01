package cardgame;

public class Card {
	private String value;
	private String suit;
	
	public Card() {	//default values
		this.value = "";
		this.suit = "";
		
	}
	
	public Card(String value, String suit) {
		this.value = value;
		this.suit = suit;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public void setSuit(String suit) {
		this.suit = suit;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public String getSuit() {
		return this.suit;
	}
	
	//get a number value for the card value
	public int getNumberValue() {
		int numberValue = 0;
		
		if(value == "2") {
			numberValue = 2;
		}
		else if( value == "3") {
			numberValue = 3;
		}
		else if( value == "4") {
			numberValue = 4;
		}
		else if( value == "5") {
			numberValue = 5;
		}
		else if( value == "6") {
			numberValue = 6;
		}
		else if( value == "7") {
			numberValue = 7;
		}
		else if( value == "8") {
			numberValue = 8;
		}
		else if( value == "9") {
			numberValue = 9;
		}
		else if( value == "10") {
			numberValue = 10;
		}
		else if( value == "Jack") {
			numberValue = 11;
		}
		else if( value == "Queen") {
			numberValue = 12;
		}
		else if( value == "King") {
			numberValue = 13;
		}
		else if( value == "Ace") {
			numberValue = 14;
		}
		else {	//penalty
			numberValue = 0;
		}
		
		return numberValue;
	}
	
	//get a number value for the card suit
	public int getNumberSuit() {
		int numberSuit = 0;
		
		if(suit == "Club") {
			numberSuit = 1;
		}
		else if( suit == "Diamond") {
			numberSuit = 2;
		}
		else if( suit == "Heart") {
			numberSuit = 3;
		}
		else if( suit == "Spade") {
			numberSuit = 4;
		}
		else {	//penalty
			numberSuit = 0;
		}
		
		return numberSuit;
	}
}
