package eecs2030.lab6;

import java.util.HashMap;
import java.util.Map;

/**
 * This class implements poker game-related methods
 * @author Andriy
 *
 */
public class Poker {
	private Poker(){};
	
	/**
	 * Checks if a hand contains a Pair: https://en.wikipedia.org/wiki/List_of_poker_hands#One_pair
	 * @param hand
	 * @return true if the hand contains exactly one pair of cards with the same value (rank)
	 * 
	 */
	public static boolean hasPair(PokerHand hand){
		Map<CardValue, Integer> map = new HashMap<>();
		for (Card card : hand){
			if (map.containsKey(card.getCardValue())){
				map.put(card.getCardValue(), map.get(card.getCardValue()) + 1);
			}
			else map.put(card.getCardValue(), 1);
		}

		int numPairs = 0;
		for (CardValue key : map.keySet()){
			if (map.get(key) == 2) numPairs++;
			if (numPairs == 1) return true;
		}
		return false;
	}

	/**
	 * Checks if a hand contains a Pair: https://en.wikipedia.org/wiki/List_of_poker_hands#Two_pair
	 * @param hand
	 * @return true if the hand contains exactly two pairs of cards with the same value (rank)
	 * NOTE: Full house https://en.wikipedia.org/wiki/List_of_poker_hands#Full_house hands  
	 * are to be excluded
	 */
	public static boolean has2Pairs(PokerHand hand){
		Map<CardValue, Integer> map = new HashMap<>();
		for (Card card : hand){
			if (map.containsKey(card.getCardValue())){
				map.put(card.getCardValue(), map.get(card.getCardValue()) + 1);
			}
			else map.put(card.getCardValue(), 1);
		}
		
		int numPairs = 0;
		for (CardValue key : map.keySet()){
			if (map.get(key) == 2) numPairs++;
			if (numPairs == 2) return true;
		}
		return false;
	}

}
