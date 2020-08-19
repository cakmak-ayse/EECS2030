package eecs2030.lab6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Implements a poker hand containing exactly 5 distinct cards 
 * @author Andriy
 *
 */
public class PokerHand implements Iterable <Card>{
	List <Card> hand;
	
	/**
	 * Creates a new hand from a collection of 5 cards
	 * the hand must contain exactly 5 cards, and they must be distinct
	 * @param hand
	 * @throws IllegalArgumentException if the conditions above a violated
	 */
	public PokerHand(Collection<Card> hand) {	
		this.hand = new ArrayList<>();
		for(Card handss : hand) {
			this.hand.add(handss);
		}
	
		if (this.hand.size() != 5){
			throw new IllegalArgumentException();
		}

		
	}

	/**
	 * Creates a new hand from 5 separate card objects
	 * there should be exactly 5 parameters, and they must be distinct
	 * @param hand 5 card objects
	 * @throws IllegalArgumentException if the conditions above a violated
	 */
	public PokerHand(Card... hand) {
		this.hand = new ArrayList<>();
		for(Card handss : hand) {
			this.hand.add(handss);
		}
		
		if(this.hand.size() != 5) {
			throw new IllegalArgumentException();
		}	
	}

	/**
	 * @return a list of cards currently held
	 */
	public List <Card> getHand (){
		List<Card> ans = new ArrayList<>();
		for(Card handss : this.hand) {
			ans.add(handss);
		}
		return ans;
		
	}

	@Override
	public String toString (){
		return this.hand.toString();
	}

	@Override
	public Iterator <Card> iterator() {
		return this.hand.iterator();
	}

}
