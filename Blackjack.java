package FinalProject;

import java.util.Scanner;

public class Blackjack {
	private static Player user = new Player();
	private Deck deck;
	private Dealer dealer = new Dealer();
	
	
	public static void displayRules() {
		System.out.println("Welcome to our Blackjack Game!\n"
				+ "The rules of the game are simple:\n"
				+ "You and the dealer both receieve two cards,\n"
				+ "but the dealer has one shown and the other hidden.\n"
				+ "You add the total of your card values, and the goal\n"
				+ "of the game is to reach Blackjack, or have more than the dealer,\n"
				+ "but less than Blackjack.\n"
				+ "Whoa, whoa, whoa! What is all this about card values\n"
				+ "and what's Blackjack?! Well, each card has a value:\n"
				+ "Cards 1-10 have the simple value of 1-10, face cards (J, Q, K)\n"
				+ "all equal 10, and aces can equal 1 or 10, depending on your situation.\n"
				+ "Based on the amount you have vs. what the dealer has, you decide to hit or stand\n"
				+ "You hit to get another card from the deck, you stand to keep your cards and\n"
				+ "see what the dealer will get. All this in effort to get Blackjack (value of 21)\n"
				+ "or at least more than what the Dealer has but less than Blackjack.\n"
				+ "I think the more you play our game, the more you'll get it.\n"
				+ "Good luck and have fun!");
	}
	public void dealCards() {
		for(int i = 0; i < 2; i++) {
			user.addCard(deck.draw());
			dealer.addCard(deck.draw());
		}
		
	}
	
	public void printStatus() {
		System.out.println(user.getPlayerName() + "'s Cards are: " + user.displayCards());
	}
	public static void main(String[] args) {
		displayRules();
		
		user.setPlayerName();
		
		Hand userHand = new Hand();
		
		System.out.println(user.getPlayerName() + " has a hand of: ");
		Deck playingDeck = new Deck();
		playingDeck.createFullDeck();
		System.out.println(playingDeck);
		playingDeck.shuffle();
		System.out.println("Deck Was Shuffled");

		System.out.println(playingDeck);
		Deck playerDeck = new Deck();
		Deck dealerDeck = new Deck();

	}
	
}