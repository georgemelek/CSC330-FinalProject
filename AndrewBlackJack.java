package FinalProject;

public class AndrewBlackJack {
	private int playerWins;
	private int dealerWins;
	private int gamesPlayed;
	private int currentPot;
	
	
	int getPlayerWins() {
		return this.playerWins;
	}
	
	void setPlayerWins() {
		this.playerWins = this.gamesPlayed - this.dealerWins;
	}
	
	int getDealerWins() {
		return this.dealerWins;
	}
	
	void setDealererWins() {
		this.dealerWins = this.gamesPlayed - this.playerWins;
	}
	
	void displayGameInfo() {
		System.out.println("Games Played: " + this.gamesPlayed);
		System.out.println("Player Wins: " + this.playerWins);
		System.out.println("Dealer Wins: " + this.dealerWins);
	}
	
	void checkWinner() {
		//needs hand total from other class if this class is not keeping track of it
		//increments player/dealer wins also in this function
	}
	
	void dealerMove() {
		//might be in dealer class instead
		//needs to apply black jack dealer rules
	}
	
	
}