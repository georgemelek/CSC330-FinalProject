package FinalProject;

public class Blackjack {
	
	public static void main(String[] args) {
		BlackjackClient game = new BlackjackClient();
		
		game.start();
		while(game.playingAgain()) {
			game.shuffle();
			game.getBets();
			game.deal();
			game.displayStatus();
			game.hasBlackjack();
			game.standOrHit();
			game.dealerPlay();
			game.statusOfBets();
			game.moneyStatus();
			game.clearHands();
		}
		game.end();
	}
	
}