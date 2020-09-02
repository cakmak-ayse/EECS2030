package eecs2030.lab6;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		//TODO
		Set<String> allValue = new HashSet<>();
		Set<String> repeat = new HashSet<>();
		for (Card eleOfhand : hand) {
			String[] array = eleOfhand.toString().split(" ");
			String value = array[0];
			if (!allValue.contains(value)) {
				allValue.add(value);
			} else {
				repeat.add(value);
			}

		}
		return repeat.size() == 1 | repeat.size() == 2;
	}

	/**
	 * Checks if a hand contains a Pair: https://en.wikipedia.org/wiki/List_of_poker_hands#Two_pair
	 * @param hand
	 * @return true if the hand contains exactly two pairs of cards with the same value (rank)
	 * NOTE: Full house https://en.wikipedia.org/wiki/List_of_poker_hands#Full_house hands  
	 * are to be excluded
	 */
	public static boolean has2Pairs(PokerHand hand){
		//TODO
		Set<String> allValue = new HashSet<>();
		Set<String> repeat = new HashSet<>();
		for (Card eleOfhand : hand) {
			String[] array = eleOfhand.toString().split(" ");
			String value = array[0];
			if (!allValue.contains(value)) {
				allValue.add(value);
			} else {
				repeat.add(value);
			}

		}
		return repeat.size() == 2;
	}
}
