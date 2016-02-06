package JavaSyntax;

import java.util.Scanner;

/**
 * Created by marin on 1/25/16.
 */
public class ExtractWords {

    public static void main(String[] args) {

        System.out.println("Please, enter a string:");
        Scanner input = new Scanner(System.in);
        String unfiltered = input.nextLine();

        String[] words = unfiltered.split("[^a-zA-Z]+|\\b[a-zA-Z]{1}\\b");

        for (int i = 0; i < words.length ; i++) {
            if (i == words.length-1) {
                System.out.print(words[i]);
            } else {
                System.out.print(words[i] + " ");
            }
        }
    }
}
