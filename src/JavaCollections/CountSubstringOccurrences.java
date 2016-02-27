package JavaCollections;

import java.util.*;

/**
 * Created by marin on 2/19/16.
 *
 * Write a program to find how many times given string appears in given text as substring.
 * The text is given at the first input line.
 * The search string is given at the second input line.
 * The output is an integer number. Please ignore the character casing.
 */
public class CountSubstringOccurrences {

    public static void main(String[] args) {

        System.out.println("Enter text:");
        Scanner input = new Scanner(System.in);
        String line = input.nextLine().toLowerCase();

        System.out.println("What substring are you looking for?:");
        String substr = input.nextLine().toLowerCase();

        int counter = 0;
        while (line.contains(substr)) {
            counter ++;
            line = line.substring(line.indexOf(substr) + 1);
        }

        System.out.println(counter);

    }
}
