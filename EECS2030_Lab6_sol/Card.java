package eecs2030.lab6;

/**
 * This class implements a playing card with one of 52 possible values.
 * @author Andriy
 */
public class Card {
	private CardValue value;
	private CardSuit suit;

	/**
	 * Creates a new card with the specified Value (Rank) and Suit
	 * @param cardValue rank
	 * @param suit card suit
	 */
	public Card (CardValue cardValue, CardSuit suit)
	{
		this.value = cardValue;
		this.suit = suit;
	}

	/**
	 * @return card value (rank)
	 */
	public CardValue getCardValue()
	{
		return value;
	}

	/**
	 * @return card suit
	 */
	public CardSuit getSuit()
	{
		return suit;
	}

	@Override
	public String toString(){
		return this.value + " " + this.suit;
	}
}
