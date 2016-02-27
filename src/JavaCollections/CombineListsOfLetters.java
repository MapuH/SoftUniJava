package JavaCollections;

import java.util.*;

/**
 * Created by marin on 2/21/16.
 *
 * Write a program that reads two lists of letters l1 and l2
 * and combines them: appends all letters c from l2 to the end of l1,
 * but only when c does not appear in l1. Print the obtained combined list.
 * All lists are given as sequence of letters separated by a single space, each at a separate line.
 * Use ArrayList<Character> of chars to keep the input and output lists.
 *
 */
public class CombineListsOfLetters {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter first letters list:");
        char[] cArray1 = input.nextLine().replaceAll(" ", "").toCharArray();
        List<Character> l1 = new ArrayList<>();
        for (char c : cArray1) {
            l1.add(c);
        }

        System.out.println("Enter second letters list:");
        char[] cArray2 = input.nextLine().replaceAll(" ", "").toCharArray();
        List<Character> l2 = new ArrayList<>();
        for (char c : cArray2) {
            l2.add(c);
        }

        List<Character> l3 = new ArrayList<>(l1);
        for (char c : l2) {
            if (!l1.contains(c)) {
                l3.add(c);
            }
        }

        for (int i = 0; i < l3.size(); i++) {
            if (i == l3.size()-1) {
                System.out.print(l3.get(i));
            } else {
                System.out.print(l3.get(i) + " ");
            }
        }

    }
}
