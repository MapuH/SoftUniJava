package JavaCollections;

import java.util.*;

/**
 * Created by marin on 2/19/16.
 *
 * Write a program to count the number of words in given sentence.
 * Use any non-letter character as word separator.
 *
 */
public class CountAllWords {

    public static void main(String[] args) {

        System.out.println("Write a sentence:");
        Scanner input = new Scanner(System.in);

        String[] words = input.nextLine().split("\\W+");
        System.out.println(words.length);

    }
}
