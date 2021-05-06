package FinalProject;

import java.util.Random;

public class Deck {
	private int nextCardIndex;
	Card[] deck = new Card[52];

	public Deck(){
		int count = 0;
		for (int i = 1; i <= 13; i++) {
			deck[count] = new Card('C', i);
			count++;
		}
		for (int i = 1; i <= 13; i++) {
			deck[count] = new Card('D', i);
			count++;
		}
		for (int i = 1; i <= 13; i++) {
			deck[count] = new Card('H', i);
			count++;
		}
		for (int i = 1; i <= 13; i++) {
			deck[count] = new Card('S', i);
			count++;
		}
		nextCardIndex = 0;
	}
	private boolean isIndexGood(int index){
		if (index < 0 || index > 51) {
			return false;
		}
		else {
			return true;
		}
	}
	
	private void swapCards(int index1, int index2){	
		Card temp;

		if(isIndexGood(index1) && isIndexGood(index2)) {
			temp = deck[index1];
			deck[index1] = deck[index2];
			deck[index2] = temp;
		}
	}

	public void shuffle(){
		Random rn = new Random();
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < deck.length; j++) {
				swapCards(i, rn.nextInt(52));
			}
		}
		nextCardIndex = 0;
	}
	
	public Card getCard(int index){
		if(isIndexGood(index)) {
			return deck[index];
		}
		else {
			return null;
		}
	}
	
	public String toString() {
		String str = "";
		for (int i = 0; i < deck.length; i++) {
			str +=	deck[i].toString() + " ";
		}
		return str;
	}

	public Card nextCard() {
		if (nextCardIndex < 0 || nextCardIndex > 51) {
			System.out.println("Invalid card position.");
		}
		return deck[nextCardIndex++];
	}

}

