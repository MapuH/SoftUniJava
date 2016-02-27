package JavaCollections;

import java.util.*;

/**
 * Created by marin on 2/23/16.
 *
 * Write a program to find the most frequent word in a text and print it,
 * as well as how many times it appears in format "word -> count".
 * Consider any non-letter character as a word separator.
 * Ignore the character casing. If several words have the same maximal frequency,
 * print all of them in alphabetical order.
 *
 */
public class MostFrequentWord {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter text:");
        String[] words = input.nextLine().toLowerCase().split("\\W+");
        Map<String, Integer> wordDict = new TreeMap<>();

        for (String word : words) {
            if (!wordDict.containsKey(word)) {
                wordDict.put(word, 1);
            } else {
                wordDict.put(word, wordDict.get(word) + 1);
            }
        }

        int maxValue = Collections.max(wordDict.values());
        for (Map.Entry<String, Integer> entry : wordDict.entrySet()) {
            if (entry.getValue() == maxValue) {
                System.out.printf("%s -> %d times\n", entry.getKey(), entry.getValue());
            }
        }

    }
}
