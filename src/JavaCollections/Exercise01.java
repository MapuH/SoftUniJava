package JavaCollections;

import java.util.*;

/**
 * Created by marin on 2/16/16.
 * NOTE: Not using streams as working on Java 7.
 *
 * Write a program that filters an array of strings,
 * finds the numbers in it,
 * and maps them to a list of integers.
 * Sum all the integers and print the result.
 */

public class Exercise01 {

    public static int sumIntList(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }

    public static void main(String[] args) {

        System.out.println("Enter input:");
        Scanner input = new Scanner(System.in);
        String[] elements = input.nextLine().split(" ");

        List<Integer> myInts = new ArrayList<>();

        for (String element : elements) {
            if (element.matches("^[1-9]\\d*$")) {
                myInts.add(Integer.parseInt(element));
            }
        }

        System.out.println(sumIntList(myInts));
    }
}
