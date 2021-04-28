package FinalProject;


public class Dealer {
	private Hand dealerHand = new Hand();
	
	public void addCard(Card card) {
		dealerHand.addCard(card);
	}
	public int calculateTotal() {
		return dealerHand.calculateTotal();
	}
	public void clearHand() {
		dealerHand.clearHand();
	}
	public boolean hasBlackjack() {
		if(dealerHand.calculateTotal() == 21) {
			return true;
		}
		else {
			return false;
		}
	}
}
	/*public static void main(String[] args) {
		shuffleDeck();
		do(){
		    dealCards(){
    		    give two random cards to Player, isViewable = true for both;
    		    give two random cards to Dealer, isViewable = false for one and true for the other;
    		    playerTotal = player.cacluateTotal();
    		    dealerTotal = dealer.cacluateTotal();
    		    while(!player.stands){
    		        System.out.println("Would you like to Hit or stand?");
    		        if(player.hits){
        		        player.addCard();
        		        playerTotal = player.cacluateTotal();
    		        }
    		        if(player.stands){
    		            make isViewable true for the card that was originally false;
    		            dealerTotal = dealer.cacluateTotal();
    		            //don't know how to implement strategy on how
    		            //to decide whether to add cards depending on score,
    		            //but we'll figure that out later
    		        }
    		    }
    		    
	    	}
		}while(playerTotal < 21)
		
		determineWinner(){
		    if(playerTotal>21){
		        System.out.println("Sorry Player, you lost!");
    		}
    		else if (dealerTotal > 21){
    		    System.out.println("Congrats Player, you won!");
    		}
    		else if (playerTotal == 21){
    		    System.out.println("Congrats Player, you have Blackjack!");
    		}
    		else if (dealerTotal == 21){
    		    System.out.println("Sorry Player, the dealer has Blackjack!");
    		}
    		else if (dealerTotal < 21 && playerTotal < 21){
    		    if(playerTotal > dealerTotal){
    		        System.out.println("Congrats Player, you won!");
    		    }
    		    else if (dealerTotal > playerTotal){
    		        System.out.println("Congrats Player, you won!");
    		    }
    		}
		
		
	    }
	}

}*/
