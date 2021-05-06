package FinalProject;

public class Card {

	private int cardValue = 0;
	private char cardSuit = ' ';
	
	
	public Card(char suit, int value){
		cardSuit = suit;
		cardValue = value;
	}
	
	public String getNameOfSuit() {
		String suit;
		switch(cardSuit) {
			case 'C': suit = "Clubs"; break;
			case 'D': suit = "Diamonds"; break;
			case 'H': suit = "Hearts"; break;
			case 'S': suit = "Spades"; break;
			default: suit = "Unknown"; break;
		}
		return suit;
	}
	
	public char getSuit() {
		return cardSuit;
	}
	
	public String getNameOfValue() {
		String value;
		switch(cardValue) {
			case 1: value = "Ace"; break;
			case 2: value = "Two"; break;
			case 3: value = "Three"; break;
			case 4: value = "Four"; break;
			case 5: value = "Five"; break;
			case 6: value = "Six"; break;
			case 7: value = "Seven"; break;
			case 8: value = "Eight"; break;
			case 9: value = "Nine"; break;
			case 10: value = "Ten"; break;
			case 11: value = "Jack"; break;
			case 12: value = "Queen"; break;
			case 13: value = "King"; break;
			default: value = "UnknownValue"; break;
		}
		return value;
	}
	
	public int getValue() {
		return cardValue;
	}

//	public boolean compareTo(Card card) {
//		return this.cardSuit == card.getSuit() && this.cardValue == card.getValue();
//	}
	public String toString(){
		return getNameOfSuit() + " " + this.cardValue;
	}
	
}