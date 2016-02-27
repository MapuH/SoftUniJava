package JavaCollections;

import com.sun.deploy.util.StringUtils;
import java.util.*;

/**
 * Created by marin on 2/21/16.
 *
 * At the first line at the console you are given a piece of text.
 * Extract all words from it and print them in alphabetical order.
 * Consider each non-letter character as word separator.
 * Take the repeating words only once. Ignore the character casing.
 * Print the result words in a single line, separated by spaces.
 *
 */
public class ExtractUniqueWords {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter text:");
        String[] words = input.nextLine().toLowerCase().split("\\W+");

        SortedSet<String> uniqueWords = new TreeSet<>();
        Collections.addAll(uniqueWords, words);

        System.out.println(StringUtils.join(uniqueWords, " "));

    }
}
