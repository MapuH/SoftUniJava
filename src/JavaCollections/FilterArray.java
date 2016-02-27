package JavaCollections;

import com.sun.deploy.util.StringUtils;
import java.util.*;

/**
 * Created by marin on 2/24/16.
 *
 * Write a program that filters an array of strings,
 * leaving only the strings with length greater than 3 characters.
 *
 * NOTE: Not using .filter() as working with Java 7!
 */
public class FilterArray {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter text:");

        String[] words = input.nextLine().split(" ");
        List<String> filtered = new ArrayList<>();

        for (String word : words) {
            if (word.length() > 3) {
                filtered.add(word);
            }
        }

        System.out.println(StringUtils.join(filtered, " "));


    }
}
