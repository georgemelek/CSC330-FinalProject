package FinalProject;

public class Hand {
	private int numCards = 0;
	private  Card[] hand = new Card[15];
	
	public void addCard(Card card) {
		numCards++;
		hand[numCards] = card;
	}
	
	public void clearHand() {
		numCards = 0;
	}

	public int calculateTotal(){
		int total = 0;
		int numAces = 0;
		for(Card aCard : hand){
			switch(aCard.getValue()){
				case TWO: total += 2; break;
				case THREE: total += 3; break;
				case FOUR: total += 4; break;
				case FIVE: total += 5; break;
				case SIX: total += 6; break;
				case SEVEN: total += 7; break;
				case EIGHT: total += 8; break;
				case NINE: total += 9; break;
				case TEN: total += 10; break;
				case JACK: total += 10; break;
				case QUEEN: total += 10; break;
				case KING: total += 10; break;
				case ACE: numAces += 1; break;
			}			
		}
		
		for(int i = 0; i < numAces; i++){
			//If total is already 11, adding 11 would
			//make it 22, a bust, so only add 1
			if (total > 10){
				total += 1;
			}
			else{
				total += 11;
			}
		}
		return total;
	}
	
	//We will have a different display depending on two parameters:
	//if we are displaying the dealer's cards, and if
	//we are hiding one of the dealer's cards
	public String toString(boolean isDealer, boolean isHidden) {
		String str = "";
		//Going to add a conditional section based on adding 1 or 11
		String aceStr = "";
		boolean aceBool = false;
		int total = 0;
		for(int i = 0; i < numCards; i++) {
			//checks that for dealer
			//the first card will not show if supposed to be hidden
			if( isDealer && isHidden && i == 0 ) {
				str = "Only showing:";
			}
			else {
				int value = 0;
				String valueStr = hand[i].getValue().name();
				switch(hand[i].getValue()){
					case TWO: value += 2; break;
					case THREE: value += 3; break;
					case FOUR: value += 4; break;
					case FIVE: value += 5; break;
					case SIX: value += 6; break;
					case SEVEN: value += 7; break;
					case EIGHT: value += 8; break;
					case NINE: value += 9; break;
					case TEN: value += 10; break;
					case JACK: value += 10; break;
					case QUEEN: value += 10; break;
					case KING: value += 10; break;
					case ACE: value += 1; aceBool = true; break;
				}
				str+= " " + valueStr + hand[i].getClass();
				total += value;
			}
			
		}
		if( aceBool && ( total+10 <= 21 ) ) {
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