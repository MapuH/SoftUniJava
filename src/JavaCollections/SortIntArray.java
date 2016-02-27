package JavaCollections;

import java.util.*;

/**
 * Created by marin on 2/17/16.
 *
 * Write a program to enter a number n
 * and n integer numbers and sort and print them.
 * Keep the numbers in array of integers: int[]
 */
public class SortIntArray {

    public static void main(String[] args) {
        System.out.println("How many numbers in the array?:");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int[] intArray = new int[n];

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            intArray[i] = input.nextInt();
        }

        Arrays.sort(intArray);

        for (int j : intArray) {
            System.out.print(j + " ");
        }
    }
}
