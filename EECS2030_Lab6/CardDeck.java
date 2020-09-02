package eecs2030.lab6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/** 
 * Implements a deck of 52 cards, e.g., for a poker game
 * @author Andriy
 *
 */
public class CardDeck implements Iterable <Card>{
	private List<Card> deck;
	
	/**
	 * Creates a new deck of cards. The deck will contain 52 distinct cards.
	 * the deck may or may not be shuffled
	 */
	public CardDeck ()
	{
		this.deck = new ArrayList<>();
		for(CardSuit suit : CardSuit.values()) {
			for(CardValue rank : CardValue.values()) {
				deck.add(new Card(rank, suit));
			}
		}
	}

	/**
	 * Shuffles the deck
	 */
	public void shuffle(){
		//TODO
		Collections.shuffle(deck);
	}

	/**
	 * returns a collection of 5 cards taken from the top of deck.
	 * After the operation those 5 cards should be removed from the deck
	 * and its size is decreased by 5.
	 * @return a collection of 5 cards taken from the top of deck
	 */
	public Collection<Card> draw5Cards (){
		//TODO
		List<Card> remove5Card = new ArrayList<>();
		for(int i = 1; i < 6; i++) {
			Card hand = deck .remove(deck.size() - 1);
			remove5Card.add(hand);
		}
		return remove5Card;		
	}

	/**
	 * After the operation this card should be removed from the deck
	 * and its size is decreased by 1.
	 * @return a card from the top of the deck
	 */
	public Card drawCard (){
		//TODO
		Card removeACard = deck.remove(deck.size() - 1);
		return removeACard;
	}

	/**
	 * @return current deck size, a value between 0 and 52 inclusive
	 */
	public int size(){
		//TODO
		return deck.size();
	}

	@Override
	public String toString (){
		//TODO
		return this.deck.toString();
				//"Drawing one card: " + drawCard();
	}

	@Override
	public Iterator <Card> iterator() {
		//TODO
		return this.deck.iterator();
	}

}
