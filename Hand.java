package FinalProject;

public class Hand {
	private int numCards = 0;
	private  Card[] hand = new Card[12];
	
//	public Hand() {
//		for(int i = 0; i< 12;i++) {
//			hand[i] = new Card(' ', 0);
//		}
//	}
	
	
	public void addCard(Card card) {
		hand[numCards++] = card;
	}
	
	public void clearHand() {
		numCards = 0;
	}

	public int calculateTotal(){
		int total = 0;
		int numAces = 0;
		boolean isAce = false;
		for(int i = 0; i < numCards; i++){
			int cardValue = hand[i].getValue();
			if(cardValue > 10) {
				cardValue = 10;
			}
			else if (cardValue == 1) {
				isAce = true;
			}
			total+=cardValue;
		}
		if( isAce && (total + 10 <= 21) ) {
			total+=10;
		}
		return total;
	}
	
	//We will have a different display depending on two parameters:
	//if we are displaying the dealer's cards, and if
	//we are hiding one of the dealer's cards
	public String displayCards(boolean isDealer, boolean isHidden) {
		String str = "";
		//Adding a conditional section based on adding 1 or 11
		String aceStr = "";
		boolean isAce = false;
		int total = 0;
		for(int i = 0; i < numCards; i++) {
			//checks that for dealer
			//the first card will not show if supposed to be hidden
			if( isDealer && isHidden && i == 0 ) {
				str = "Only showing:";
			}
			else {
				int value = hand[i].getValue();
				String valueStr = " ";
				if(value > 10) {
					valueStr = hand[i].getNameOfValue().substring(0,1);
				}
				else if (value == 1) {
					valueStr = "A";
				}
				else {
					valueStr = Integer.toString(value);
				}
				str += " " + valueStr + hand[i].getSuit();
				if(value > 10) {
					value = 10;
				}
				else if (value == 1) {
					isAce = true;
				}
				total+= value;
			}
			
		}
		if( isAce && (total+10 <= 21) ) {
			aceStr = " or " + (total+10);
		}
		
		if(isHidden) {
			return str;
		}
		else {
			return str + " totals " + total + aceStr;
		}
	}
	
}