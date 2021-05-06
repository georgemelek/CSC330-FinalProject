package FinalProject;


public class Dealer {
	private Hand dealerHand = new Hand();
	
	public void addCard(Card card) {
		dealerHand.addCard(card);
	}
	
	public void clearHand() {
		dealerHand.clearHand();
	}
	
	public int calculateTotal() {
		return dealerHand.calculateTotal();
	}
	
	public void dealerPlay(Deck deck) {
		while(dealerHand.calculateTotal() <= 16) {
			System.out.println("Dealer's Total: " + dealerHand.calculateTotal() + " and hits");
			dealerHand.addCard(deck.nextCard());
			System.out.println("Dealer " + this.displayCards(true, false));
		}
		if(dealerHand.calculateTotal() > 21) {
			System.out.println("Dealer has went over 21 and has lost." + this.displayCards(true, false));
		}
		else {
			System.out.println("Dealer decides to stand. " + this.displayCards(true, false));
		}
	}
	
	public boolean hasBlackJack() {
		if(dealerHand.calculateTotal() == 21) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String displayCards(boolean isDealer, boolean isHidden) {
		return dealerHand.displayCards(isDealer, isHidden);
	}
}