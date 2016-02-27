package JavaCollections;

import java.util.*;

/**
 * Created by marin on 2/18/16.
 *
 * Write a program that enters an array of strings
 * and finds in it all sequences of equal elements.
 * The input strings are given as a single line, separated by a space.
 * Note: the count of the input strings is not explicitly specified,
 * so you might need to read the first input line as a string and split it by a space.
 */
public class SequencesOfEqualStrings {

    public static void main(String[] args) {

        System.out.println("Enter input string:");
        Scanner input = new Scanner(System.in);

        String[] elements = input.nextLine().split(" ");
        Map<String, Integer> stringMap = new LinkedHashMap<>();

        for (String element : elements) {
            if (!stringMap.containsKey(element)) {
                stringMap.put(element, 1);
            } else {
                stringMap.put(element, stringMap.get(element) + 1);
            }
        }

        for (String word : stringMap.keySet()) {
            for (int i = 1; i <= stringMap.get(word); i++) {
                if (i == stringMap.get(word)){
                    System.out.print(word + "\r\n");
                } else {
                    System.out.print(word + " ");
                }
            }
        }

    }
}
