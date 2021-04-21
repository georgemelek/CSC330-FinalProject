package edu.cuny.csi.csc330.FinalProject;
import java.util.*;  
import java.util.Scanner; 
public class Player {
	
    // Variables 
	private String playerName; 
	private int deposit; 
	private int betAmount; 
	private int playerMove;
	private final static int DEFAULT_NUM_PLAYERS = 1; 
	
    // Constructor
    public Player() { 
		 init(DEFAULT_NUM_PLAYERS);
	}
	
    // Player Name 
	public void setPlayerName() { 
		Scanner newPlayer = new Scanner(System.in); 
		System.out.println("Enter Player Name: "); 
		String playerName = newPlayer.nextLine(); 
		}
	public String getPlayerName() { 
		return this.playerName; 
	}
	
    // Player Deposit 
	public void setDepositAmount() { 
		Scanner depositAmount = new Scanner(System.in); 
		System.out.println("How much would you like to deposit");
		// Assert its a number
		try { 
			int deposit = depositAmount.nextInt();
		}catch (NumberFormatException e) { 
			System.out.println("Deposit must be an integer value");
		}
	}
	
    public int getDepositAmount() { 
		return this.deposit; 
	}
	
    
    // Bet Amount 
	public void setBetAmount() { 
		Scanner bet = new Scanner(System.in); 
		System.out.println("How much would you like to bet");
		// Assert its a number
		try { 
			int betAmount = bet.nextInt();
		}catch (NumberFormatException e) { 
			System.out.println("Wager must be an integer value");
		}
	}
	public int getBetAmount() { 
		return this.betAmount; 
	}
	
    
    // Player Move : Player has four options: 
	//   Hit - pop one more card off deck stack 
	//   Stand - player value does not change
	//   Double Down - one card, double bet
	//   Split - if two player cards are the same, play as two hands ( save for later ) 
	public void setPlayerMove() { 
		Scanner move = new Scanner(System.in); 
		System.out.println("Enter the number only: (1) to hit, (2) to stand, (3) to double down!"); 
		try { 
			int playerMove = move.nextInt(); 
		}catch(NumberFormatException e){ 
			System.out.println("Option must be an integer value");
		}
	}
	
    public int getPlayerMove() { 
		return this.playerMove; 
	}
	
    
    // this will depend upon the class with cards 
	public void playerAction() {
		int CASE = this.playerMove;
		 switch(CASE) { 
		 	case 1: 
		 		//Deck.draw_card 
		 		break;
		 	case 2: 
		 		// Game check who wins 
		 		break; 
		 	case 3:
		 		// Deck.draw_card (MAX OF 1)
		 		break; 
		}
	}
	
    
    // Display 
	public void displayHeader() { 
		// psuedo code 
		// Player Name 		Balance 		Wager 		Player Wins		Dealer Wins 
		// I can include functions that update balance, wager, wins etc 
	}
	
    private void init(int handsDealt) { 
		//For the amount of players at table 
		for (int i = 1; i <= handsDealt; i++) { 
			Player p = new Player(); 
		}
	}
	
    public static void main(String[] args) { 
	}
}