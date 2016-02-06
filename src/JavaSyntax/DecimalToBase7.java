package JavaSyntax;

import java.util.Scanner;

/**
 * Created by marin on 1/23/16.
 */
public class DecimalToBase7 {

    public static void main(String[] args) {

        System.out.println("Please, enter a decimal integer:");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        System.out.println(Integer.toString(n, 7));

    }
}
