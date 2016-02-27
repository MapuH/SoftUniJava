package JavaCollections;

import java.util.*;

/**
 * Created by marin on 2/19/16.
 *
 * Write a program to find how many times a word appears in given text.
 * The text is given at the first input line.
 * The target word is given at the second input line.
 * The output is an integer number. Please ignore the character casing.
 * Consider that any non-letter character is a word separator.
 */
public class CountSpecifiedWord {

    public static void main(String[] args) {

        System.out.println("Enter text:");
        Scanner input = new Scanner(System.in);
        String[] words = input.nextLine().toLowerCase().split("\\W+");

        System.out.println("Which word are you looking for?:");
        String target = input.nextLine().toLowerCase();

        int counter = 0;
        for (String word : words) {
            if (word.equals(target)) {
                counter ++;
            }
        }

        System.out.println(counter);

    }
}
