package eecs2030.lab6;

/**
 * This class implements a playing card with one of 52 possible values.
 * @author Andriy
 */
public class Card {
	private String card;
	private CardValue value;
	private CardSuit suit;
	
	/**
	 * Creates a new card with the specified Value (Rank) and Suit
	 * @param cardValue rank
	 * @param suit card suit
	 */
	public Card (CardValue cardValue, CardSuit suit){
		this.value = cardValue;
		this.suit = suit;
		this.card = this.value + " " + this.suit;
	}

	/**
	 * @return card value (rank)
	 */
	public CardValue getCardValue(){
		return this.value;
	}

	/**
	 * @return card suit
	 */
	public CardSuit getSuit()
	{
		return this.suit;
	}

	@Override
	public String toString(){
		return this.card;
	}
}
