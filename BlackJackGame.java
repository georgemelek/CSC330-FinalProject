package FinalProject;
import java.util.Scanner;

public class BlackJackGame {

  private Scanner input = new Scanner(System.in);
  private Player player;
  private Deck deck = new Deck();
  private Dealer dealer = new Dealer();
  private int numWins = 0;

  public void start() {
    //game start and rule explanation
    System.out.println("Welcome to our BlackJack Game! \n"
    		+ "This is how the game will go: You will get \n"
    		+ "two cards face up, the dealer will also get \n"
    		+ "two cards, but one face down, one face up. \n"
    		+ "You will then decide to hit or stand based off of \n"
    		+ "your card total vs the dealer's total and what you \n"
    		+ "think he will eventually get. The goal of the game \n"
    		+ "is to get either exactly 21, or less than 21 but more \n"
    		+ "than the dealer. Each card has a value of its number, \n"
    		+ "and face cards are all 10, and aces could be 1 or 11. \n"
    		+ "I think the more you play, the more you'll get it. \n"
    		+ "Have fun!");

    String playerName;

    //create instance of player
    player = new Player();

    //asks for name and sets name
    System.out.print("What is the player's name? ");
		playerName = input.next();
    player.setPlayerName(playerName);
  }

  //get player bet/wager amount
  public void getBets() {
    int betAmount;

    if (player.getDepositAmount() > 0) {
    	System.out.print("How much would you like to wager? You may wager up to " + player.getDepositAmount());
//    	while (!input.hasNextInt() || (input.nextInt() <= 0) || input.nextInt() > player.getDepositAmount()) {
//    		System.out.println("Invalid wager. Please try again!");
//    		System.out.print("How much would you like to wager? You may wager up to " + player.getDepositAmount());
//    		input.next(); 
//    	}
    	betAmount = input.nextInt();
    	player.setBetAmount(betAmount);
    }
  }

  // Shuffles the deck
  public void shuffle() {
		deck.shuffle();
  }

  //deal cards
  public void deal(){
	  //i<2 for 2 cards each initially
	  for(int i=0; i<2; i++){
		  if(player.getDepositAmount() > 0){
			  player.addCard(deck.nextCard());
		  }
		  dealer.addCard(deck.nextCard());
    }
  }

  //initial check if dealer has BJ from beginning
  public void hasBlackJack() {
	  if(dealer.hasBlackJack()){
		  System.out.println("Dealer has BlackJack!");
		  if (player.getCardsTotal() == 21 ) {
			  System.out.println(player.getPlayerName() + " pushes");
			  player.resetBetAmount();
		  } 
		  else {
			  System.out.println(player.getPlayerName() + " loses");
			  player.loss();
		  }
	  }
	  else {
		  if (player.getCardsTotal() == 21 ) {
			  System.out.println(player.getPlayerName() + " has blackjack!");
			  player.hasBlackjack();
		  }
	  }
  }

  //player turn    hit/stand
  public void standOrHit() {
    String move;
    char c;

    System.out.println();
	System.out.println(player.getPlayerName() + " has " + player.displayCards());

    do {
      do {
        System.out.print(" (H)it or (S)tand? ");
				move = input.next();
				c = move.toUpperCase().charAt(0);
        } while ( ! ( c == 'H' || c == 'S' ) );
      
        if ( c == 'H' ) {
          player.addCard(deck.nextCard());
          System.out.println(player.getPlayerName() + " has " + player.displayCards());
        }
    } while (c != 'S' && player.getCardsTotal() <= 21 );
}

  //dealer turn
  public void dealerPlay() {
	  dealer.dealerPlay(deck);
  }

  //checks all game cases for winner
  public void statusOfBets() {
    System.out.println();

    if( player.getCardsTotal() > 21 ) {
		System.out.println(player.getPlayerName() + " has busted");
		player.loss();
		System.out.println("You have won: " + numWins + " times.");
	}
    else if ( player.getCardsTotal() == dealer.calculateTotal() ) {
		System.out.println(player.getPlayerName() + " has pushed");
		player.setBetAmount(0);
		System.out.println("You have won: " + numWins + " times.");
	}
    else if ( player.getCardsTotal() < dealer.calculateTotal() && dealer.calculateTotal() <= 21 ) {
		System.out.println(player.getPlayerName() + " has lost");
		player.loss();
		System.out.println("You have won: " + numWins + " times.");
	}
    else if (player.getCardsTotal() == 21) {
		System.out.println(player.getPlayerName() + " has won with blackjack!");
		player.hasBlackjack();
		numWins++;
		System.out.println("You have won: " + numWins + " times.");
	}
    else {
		System.out.println(player.getPlayerName() + " has won");
		player.win();
		numWins++;
		System.out.println("You have won: " + numWins + " times.");
	}
  }

  // display player hands
  public void displayStatus() {
    if(player.getDepositAmount() > 0){
    	System.out.println(player.getPlayerName() + " has " + player.displayCards());
	}
    System.out.println("Dealer has " + dealer.displayCards(true, true));
  }

  //displays how much player has left
  public void moneyStatus() {
    if(player.getDepositAmount() > 0){
    	System.out.println(player.getPlayerName() + " has " + player.getDepositAmount());
	}
    if(player.getDepositAmount() == 0){
    	System.out.println(player.getPlayerName() + " has " + player.getDepositAmount() + " and is out of the game.");
    	player.remove();
	}
  }

  //reset hands
  public void clearHands(){
    player.clearHand();
    dealer.clearHand();
  }

  // This decides to force the game to end when all players lose or lets players choose to keep playing or not
	public boolean playingAgain() {
		String choice;
		char c;
		Boolean playState = true;
		if(forceEnd()) {
			playState = false;	
		}
		else {
			do {
				System.out.println("");
				System.out.print("Do you want to play again (Y)es or (N)o? ");
				choice = input.next();
				c = choice.toUpperCase().charAt(0);
			} while ( ! ( c == 'Y' || c == 'N' ) );
			if(c == 'N')
			{
				playState = false;
			}
		}
		return playState;
	}
	
	// This says true or false to forcing the game to end
	public boolean forceEnd() {
		boolean end = false;
		
		
		if(player.getDepositAmount() == -1){
			end = true;
		}
		
		if(end){
			System.out.println("");
			System.out.println("The player has lost and the game ends.");
		}
		
		return end;
	}
	
	// This is the endgame code for when all players are out of the game or players decide to stop playing
	public void end() {
		int endAmount;
		String endState = " no change.";
		System.out.println("");
		
		if(player.getDepositAmount() == -1){
			player.resetDepsoit();
		}
		endAmount = player.getDepositAmount() - 250;
		if(endAmount > 0){
			endState = " gain of ";
		}
		else if(endAmount < 0){
			endState = " loss of ";
		}
		System.out.println(player.getPlayerName() + " has ended the game with " + player.getDepositAmount() + ".");
		
		if(endState != " no change."){
			System.out.println("A" + endState + Math.abs(endAmount) + ".");
		}
		else{
			System.out.println("No change from their starting value.");	
		}
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("Thank you for playing!");
	}
	public void play() {
		do{
			shuffle();
			getBets();
			deal();
			displayStatus();
			hasBlackJack();
			standOrHit();
			dealerPlay();
			statusOfBets();
			moneyStatus();
			clearHands();
		} while(playingAgain());
	}
  
}