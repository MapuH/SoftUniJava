package JavaSyntax;

import java.util.Scanner;

/**
 * Created by marin on 1/22/16.
 */
public class RectangleArea {

    public static int rectArea(int x, int y) {
        return x * y;
    }

    public static void main(String[] args) {

        System.out.print("Please, enter two integers: ");
        Scanner input = new Scanner(System.in);
        int sideA = input.nextInt();
        int sideB = input.nextInt();

        System.out.printf("Area of the triangle is %s", rectArea(sideA, sideB));

    }
}
