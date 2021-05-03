package edu.cuny.csi.csc330.finalproject;

// public class blackjack {
// 	private int playerWins;
// 	private int dealerWins;
// 	private int gamesPlayed;
// 	private int currentPot;
	
	
// 	int getPlayerWins() {
// 		return this.playerWins;
// 	}
	
// 	void setPlayerWins() {
// 		this.playerWins = this.gamesPlayed - this.dealerWins;
// 	}
	
// 	int getDealerWins() {
// 		return this.dealerWins;
// 	}
	
// 	void setDealererWins() {
// 		this.dealerWins = this.gamesPlayed - this.playerWins;
// 	}
	
// 	void displayGameInfo() {
// 		System.out.println("Games Played: " + this.gamesPlayed);
// 		System.out.println("Player Wins: " + this.playerWins);
// 		System.out.println("Dealer Wins: " + this.dealerWins);
// 	}
	
// 	void checkWinner() {
// 		//needs hand total from other class if this class is not keeping track of it
// 		//increments player/dealer wins also in this function
// 	}
	
// 	void dealerMove() {
// 		//might be in dealer class instead
// 		//needs to apply black jack dealer rules
// 	}
	
	
// }


import java.util.Scanner;

public class BlackJackGame {

  private Scanner input = new Scanner(System.in);
  private int numPlayers = 1;
  private Player player;
  private Deck deck;
  private Dealer dealer = new Dealer();

  public void start() {
    //game start and rule explanation
    System.out.println("Welcome to Blackjack!");
		System.out.println("");
		System.out.println("  BLACKJACK RULES: ");
		System.out.println("	-The player is dealt 2 cards. The dealer is dealt 2 cards with one face-up and one face-down.");
		System.out.println("	-Cards are equal to their value with face cards being 10 and an Ace being 1 or 11.");
		System.out.println("	-The players cards are added up for their total.");
		System.out.println("	-Player “Hit” to gain another card from the deck. Player “Stay” to keep their current card total.");
		System.out.println("	-Dealer “Hits” until they equal or exceed 17.");
		System.out.println("	-The goal is to have a higher card total than the dealer without going over 21.");
		System.out.println("	-If the player total equals the dealer total, it is a “Push” and the hand ends."); 
		System.out.println("	-Player win their bet if they beat the dealer. Player win 1.5x their bet if they get “Blackjack” which is 21.");
		System.out.println("");
		System.out.println("");

    String playerName;

    //create instance of player
    player = new Player();

    //asks for name and sets name
    System.out.print("What is the player's name? ");
		playerName = input.next();
    player.setName(playerName);
  }

  //get player bet/wager amount
  public void getBets() {
    int betAmount;

    if (player.getBank() > 0) {
      System.out.print("How much would you like to wager? You may wager up to " + player.getBank);
      while (!input.hasNextInt() || (input.nextInt() <= 0) || input.nextInt() > player.getBank()) {
        System.out.println("Invalid wager. Please try again!");
        System.out.print("How much would you like to wager? You may wager up to " + player.getBank());
        input.next(); 
      }
      betAmount = input.nextInt();
    }
  }

  // Shuffles the deck
	public void shuffle() throws InvalidDeckPositionException, InvalidCardSuitException, InvalidCardValueException {
		deck.shuffle();
		
	}

  //deal cards
  public void deal(){
    for(int i=0; i<2; i++){
      if(players[i].getBank() > 0)
			{
				player.addCard(deck.nextCard());
			}
      dealer.addCard(deck.nextCard());
    }
  }

  //initial check if dealer has BJ
  public void hasBlackJack() {
    
    if(dealer.hasBlackJack()){
      System.out.println("Dealer has BlackJack!");

      if (player.getTotal() == 21 ) {
					System.out.println(players.getName() + " pushes");
					players.push();
				} 
      else {
					System.out.println(players.getName() + " loses");
					players[i].bust();
				}	
    }
    else {
      if (dealer.peek() ) {
				System.out.println("Dealer peeks and does not have a BlackJack");
			}
      if (player[i].getTotal() == 21 ) {
        System.out.println(player.getName() + " has blackjack!");
				players.blackjack();
				}
    }
  }

  //player turn    hit/stand
  public void standOrHit() {
    String move;
    char c;

    System.out.println();
		System.out.println(player.getName() + " has " + player.getHandString());

    do {
      do {
        System.out.print(player.getName() + " (H)it or (S)tand? ");
				move = input.next();
				c = move.toUpperCase().charAt(0);
        } while ( ! ( c == 'H' || c == 'S' ) );
        if ( c == 'H' ) {
          player.addCard(deck.nextCard());
          System.out.println(player.getName() + " has " + player.getHandString());
          }
          } while (c != 'S' && players[i].getTotal() <= 21 );
	}

  //dealer turn
  public void dealerPlay() {
    boolean isSomePlayerStillInTheGame = false;
    if (players[i].getBet() > 0 && players[i].getTotal() <= 21 ) {
      isSomePlayerStillInTheGame = true;
		}
    if (isSomePlayerStillInTheGame) {
      dealer.dealerPlay(deck);
		}
  }

  //checks all game cases for winner
  public void statusOfBets() {
    System.out.println();

    if( player.getTotal() > 21 ) {
					System.out.println(player.getName() + " has busted");
					player.bust();
				} else if ( player.getTotal() == dealer.calculateTotal() ) {
					System.out.println(player.getName() + " has pushed");
					player.push();
				} else if ( player.getTotal() < dealer.calculateTotal() && dealer.calculateTotal() <= 21 ) {
					System.out.println(player.getName() + " has lost");
					player.loss();
				} else if (player.getTotal() == 21) {
					System.out.println(player.getName() + " has won with blackjack!");
					player.blackjack();
				} else {
					System.out.println(player.getName() + " has won");
					player.win();
				}
  }

  // display player hands
  public void displayStatus() {
    if(players[i].getBank() > 0)
			{
			System.out.println(player.getName() + " has " + players[i].getHandString());
			}
    System.out.println("Dealer has " + dealer.getHandString(true, true));
  }

  //displays how much player has left
  public void moneyStatus() {
    if(player.getBank() > 0)
			{
			System.out.println(player.getName() + " has " + player.getBank());
			}
			if(player.getBank() == 0)
			{
			System.out.println(player.getName() + " has " + player.getBank() + " and is out of the game.");
			player.removeFromGame();
			}
  }

  //reset hands
  public void clearHands(){
    player.clearHand();
    dealer.clearHand()
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
		int endCount = 0;
		
		
			if(player.getBank() == -1)
			{
				endCount++;
			}
		
		if(endCount == users)
		{
			end = true;
		}
		if(end)
		{
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
			
				if(player.getBank() == -1)
				{
					player.resetBank();
				}
				endAmount = player.getBank() - 100;
				if(endAmount > 0)
				{
					endState = " gain of ";
				}
				else if(endAmount < 0)
				{
					endState = " loss of ";
				}
				System.out.println(player.getName() + " has ended the game with " + player.getBank() + ".");
				if(endState != " no change.")
				{
				System.out.println("A" + endState + Math.abs(endAmount) + ".");
				}
				else
				{
				System.out.println("No change from their starting value.");	
				}
				System.out.println("");
			
			System.out.println("");
			System.out.println("");
			System.out.println("Thank you for playing!");
		}

  
}