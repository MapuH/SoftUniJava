package JavaSyntax;

import java.util.Scanner;

/**
 * Created by marin on 1/23/16.
 */
public class Base7ToDecimal {

    public static void main(String[] args) {

        System.out.println("Please, enter a base-7 number:");
        Scanner input = new Scanner(System.in);
        String base7 = input.next();

        System.out.println(Integer.valueOf(base7, 7));
    }
}
