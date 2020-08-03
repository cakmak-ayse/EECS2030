package eecs2030.lab6;

import java.util.HashSet;
import java.util.Set;

public class TestCase {
	private TestCase(){};

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
		System.out.println(hand);

		for (Card eleOfhand : hand) {
			System.out.println(eleOfhand);
			
			String[] array = eleOfhand.toString().split(" ");
			String value = array[0];
			System.out.println(value);

			if (!allValue.contains(value)) {
				allValue.add(value);
			} else {
				repeat.add(value);
			}
			System.out.println(allValue);
			System.out.println(repeat + "\n");
		}
		return repeat.size() == 1 | repeat.size() == 2;

//		T | T => F
//		T | F => T
//		F | T => T
//		F | F => F
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
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CardDeck deck = new CardDeck();
		deck.shuffle();
//		System.out.println(deck);

		PokerHand hand = new PokerHand(deck.draw5Cards());
//		System.out.println(hand);
		
		System.out.println(TestCase.hasPair(hand));
	}

}
