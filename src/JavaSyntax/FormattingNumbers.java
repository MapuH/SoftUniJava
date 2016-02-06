package JavaSyntax;

import java.util.Scanner;

/**
 * Created by marin on 1/23/16.
 */
public class FormattingNumbers {

    public static void main(String[] args) {

        System.out.println("Please, enter values:");
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        double b = input.nextDouble();
        double c = input.nextDouble();

        String aBin = String.format("%10s", Integer.toBinaryString(a)).replace(' ', '0');

        System.out.printf("|%1$-10X|%2$10s|%3$10.2f|%4$-10.3f|", a, aBin, b, c);
    }
}
