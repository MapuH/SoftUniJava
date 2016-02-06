package JavaSyntax;

import java.util.Scanner;

/**
 * Created by marin on 1/25/16.
 */
public class HitTheTarget {

    public static void main(String[] args) {

        System.out.print("Please, enter the target: ");
        Scanner input = new Scanner(System.in);
        int target = input.nextInt();

        for (int i = 1; i <= 20 ; i++) {

            for (int j = 1; j <= 20 ; j++) {

                if (i + j == target) {
                    System.out.printf("%s + %s = %s\n", i, j, target);
                }

                if (i - j == target) {
                    System.out.printf("%s - %s = %s\n", i, j, target);
                }

            }

        }
    }
}
