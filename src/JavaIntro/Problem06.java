package JavaIntro;

import java.util.Scanner;

/**
 * Created by marin on 1/20/16.
 */
public class Problem06 {

    public static void main(String[] args) {

        System.out.print("Please, enter a number >=1: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int totalSum = 0;

        for (int i = 1; i <= n; i++) {
            totalSum += i;
        }

        System.out.println(totalSum);
    }
}
