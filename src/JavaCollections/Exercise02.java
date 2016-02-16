package JavaCollections;

import java.util.*;

/**
 * Created by marin on 2/16/16.
 *
 * Problem 2. Print numbers from 1 to N using recursion
 */
public class Exercise02 {

    private static void printRecursive(int n) {
        if (n < 1) {
            return;
        }

        printRecursive(n - 1);
        System.out.println(n);
    }

    public static void main(String[] args) {

        System.out.println("Enter integer number:");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        printRecursive(n);
    }
}
