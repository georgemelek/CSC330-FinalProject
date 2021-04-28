package FinalProject;
import java.util.ArrayList;
import java.util.Random;

public class Deck {

	private ArrayList<Card> cards;
	
	public Deck(){
		//Create a new deck of playing cards
		this.cards = new ArrayList<Card>();
	
	}
	
	//Add 52 playing cards to a deck
	public void createFullDeck(){
		//Generate Cards
		for(Suit cardSuit : Suit.values()){
			//Loop through Values
			for(Value cardValue : Value.values()){
				//Add new card to the mix
				this.cards.add(new Card(cardSuit,cardValue));
			}
		}
	}
	
	
//Shuffle deck of cards
public void shuffle(){
	ArrayList<Card> tempDeck = new ArrayList<Card>();
	//Randomly pick from the old deck and copy values to the new deck
	Random random = new Random();
	int randomCardIndex = 0;
	int originalSize = this.cards.size();
	for(int i = 0; i < originalSize; i++){
		randomCardIndex = random.nextInt((this.cards.size()));
		//throw random card into new deck
		tempDeck.add(this.cards.get(randomCardIndex));
		//remove picked from old deck
		this.cards.remove(randomCardIndex);
	}
	
	//set this.deck to our newly shuffled deck
	this.cards = tempDeck;
}
	
	
	//Remove a card from the deck
	public void removeCard(int i){
		this.cards.remove(i);
	}
	//Get card from deck
	public Card getCard(int i){
		return this.cards.get(i);
	}
	
	//Add card to deck
	public void addCard(Card addCard){
		this.cards.add(addCard);
	}
	
	//Draw a top card from deck
	public Card draw(){
		//Add card to this deck from whatever deck its coming from
		//this.cards.add(decksCards.getCard(0));
		//Remove the card in the deck its coming from
		Card tempCard = cards.get(0);
		this.cards.remove(0);
		return cards.get(0);
		
	}
	
	
	public int deckSize(){
		return this.cards.size();
	}
	
	//Calculate the value of deck
	public int cardsValue(){
		int totalValue = 0;
		int aces = 0;
		//For every card in the deck
		for(Card aCard : this.cards){
			//Switch of possible values
			switch(aCard.getValue()){
				case TWO: totalValue += 2; break;
				case THREE: totalValue += 3; break;
				case FOUR: totalValue += 4; break;
				case FIVE: totalValue += 5; break;
				case SIX: totalValue += 6; break;
				case SEVEN: totalValue += 7; break;
				case EIGHT: totalValue += 8; break;
				case NINE: totalValue += 9; break;
				case TEN: totalValue += 10; break;
				case JACK: totalValue += 10; break;
				case QUEEN: totalValue += 10; break;
				case KING: totalValue += 10; break;
				case ACE: aces += 1; break;
			}			
		}
		
		//Aces criteria
		for(int i = 0; i < aces; i++){
			if (totalValue > 10){
				totalValue += 1;
			}
			else{
				totalValue += 11;
			}
		}
		
		//Return
		return totalValue;
	
	}
	//Use to print out deck
		public String toString(){
			String cardListOutput = "";
			int i = 0;
			for(Card aCard : this.cards){
				cardListOutput += "\n" + aCard.toString();
				i++;
			}
			return cardListOutput;
		}
	
	
}