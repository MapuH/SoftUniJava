package JavaCollections;

import java.util.*;

/**
 * Created by marin on 2/23/16.
 *
 * We are given a sequence of N playing cards from a standard deck.
 * The input consists of several cards (face + suit), separated by a space.
 * Write a program to calculate and print at the console
 * the frequency of each card face in format "card_face -> frequency".
 * The frequency is calculated by the formula appearances / N and
 * is expressed in percentages with exactly 2 digits after the decimal point.
 * The card faces with their frequency should be printed
 * in the order of the card face's first appearance in the input.
 * The same card can appear multiple times in the input,
 * but it's face should be listed only once in the output.
 *
 */
public class CardFrequencies {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter sequence of cards:");

        String[] cards = input.nextLine().split("\\W+");

        Map<String, Integer> cardCount = new LinkedHashMap<>();

        for (String card : cards) {
            if (!cardCount.containsKey(card)) {
                cardCount.put(card, 1);
            } else {
                cardCount.put(card, cardCount.get(card) + 1);
            }
        }

        for (Map.Entry<String,Integer> entry : cardCount.entrySet()) {
            System.out.printf("%s -> %.2f%%\n", entry.getKey(), ((double) entry.getValue()/cards.length)*100);
        }


    }
}
