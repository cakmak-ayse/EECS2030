package eecs2030.lab6;

/**
 * This class implements a playing card with one of 52 possible values.
 * @author Andriy
 */
public class Card {
    private CardSuit suit; 
    private CardValue value; 
    private String card;

	/**
	 * Creates a new card with the specified Value (Rank) and Suit
	 * @param cardValue rank
	 * @param suit card suit
	 */
	public Card (CardValue cardValue, CardSuit suit)
	{	
		//TODO
		this.suit = suit;
		this.value = cardValue;		
		this.card = this.value + " " + this.suit;
	}

	/**
	 * @return card value (rank)
	 */
	public CardValue getCardValue()
	{
		//TODO
		return this.value;
	}

	/**
	 * @return card suit
	 */
	public CardSuit getSuit()
	{
		//TODO
		return this.suit;
	}

	@Override
	public String toString(){
		//TODO
//		return getCardValue() + " " + getSuit();
		// return this.suit + " " + this.value;
		 return this.card;
		
	}
}
