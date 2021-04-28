package FinalProject;

public class Hand {
	private  Card[] hand = new Card[15];
	private int numCards = 0;
	
	public int calculateTotal(){
		int total = 0;
		int aces = 0;
		for(Card aCard : this.hand){
			//Switch of possible values
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
				case ACE: aces += 1; break;
			}			
		}
		
		//Aces criteria
		for(int i = 0; i < aces; i++){
			if (total > 10){
				total += 1;
			}
			else{
				total += 11;
			}
		}
		
		//Return
		return total;
	}
	public String toString(boolean isDealer, boolean isHidden) {
		String str = "";
		String aceStr = "";
		boolean aceBool = false;
		int total = 0;
		for(int i = 0; i < numCards; i++) {
			//checks that for dealer
			//the first card will not show if supposed to be hidden
			if( isDealer && isHidden && i == 0) {
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
		if( aceBool && (total+10 <= 21) ) {
			aceStr = " or " + (total+10);
		}
		if(isHidden) {
			return str;
		}
		else {
			return str + " totals " + total + aceStr;
		}
	}
	public void addCard(Card card) {
		numCards++;
		hand[numCards] = card;
	}
	
	public void clearHand() {
		numCards = 0;
	}
}