package FinalProject;
import java.util.*;  
import java.util.Scanner; 

public class Player {
	
    // Variables 
	private String playerName; 
	private int deposit; 
	private int betAmount; 
	private int playerMove;
	private Hand hand = new Hand();
	
    // Constructor
    public Player() { 
		hand = new Hand(); 
    	deposit = 250;
	}
	
    // Player Name 
	public void setPlayerName(String name) { 
		playerName = name;
	}
	
	public String getPlayerName() { 
		return this.playerName; 
	}
	
	//Bet Amount
	public void setBetAmount(int bet) {
		betAmount = bet;
	}
	
	//Cards Amount
	public int getCardsTotal() {
		return hand.calculateTotal();
	}
	
//    // Player Deposit 
//	public void setDepositAmount() { 
//		Scanner depositAmount = new Scanner(System.in); 
//		System.out.println("How much would you like to deposit");
//		// Assert its a number
//		try { 
//			int deposit = depositAmount.nextInt();
//		}catch (NumberFormatException e) { 
//			System.out.println("Deposit must be an integer value");
//		}
//	}
	
	public void resetDepsoit() {
		deposit = 0;
	}
	
	public void loss() {
		deposit -= betAmount;
		betAmount = 0;
	}
	
	public void win() {
		deposit += betAmount;
		betAmount = 0;
	}
	
    public int getDepositAmount() { 
		return this.deposit; 
	}
    
    public void hasBlackjack() {
    	deposit += betAmount * 1.5;
    	betAmount = 0;
    }
    
	
    
//    // Bet Amount 
//	public void setBetAmount() { 
//		Scanner bet = new Scanner(System.in); 
//		System.out.println("How much would you like to bet");
//		// Assert its a number
//		try { 
//			int betAmount = bet.nextInt();
//		}catch (NumberFormatException e) { 
//			System.out.println("Wager must be an integer value");
//		}
//	}
//	public int getBetAmount() { 
//		return this.betAmount; 
//	}
	
    
//    // Player Move : Player has four options: 
//	//   Hit - pop one more card off deck stack 
//	//   Stand - player value does not change
//	//   Double Down - one card, double bet
//	//   Split - if two player cards are the same, play as two hands ( save for later ) 
//	public void setPlayerMove() { 
//		Scanner move = new Scanner(System.in); 
//		System.out.println("Enter the number only: (1) to hit, (2) to stand, (3) to double down!"); 
//		try { 
//			int playerMove = move.nextInt(); 
//		}catch(NumberFormatException e){ 
//			System.out.println("Option must be an integer value");
//		}
//	}
//	
//    public int getPlayerMove() { 
//		return this.playerMove; 
//	}
	
	public void addCard(Card card) {
		hand.addCard(card);
	}
	
	public void clearHand() {
		hand.clearHand();
	}
	public void remove() {
		deposit = -1;
	}
	public void resetBetAmount() {
		betAmount = 0;
	}
	
    public String displayCards() {
    	return hand.displayCards(false, false);
    }
    
}