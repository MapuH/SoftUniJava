package JavaSyntax;

import java.util.Scanner;

/**
 * Created by marin on 1/22/16.
 */
public class TriangleArea {

    public static int triangleArea(int pointAx, int pointAy, int pointBx, int pointBy, int pointCx, int pointCy) {

        return Math.abs((pointAx*(pointBy-pointCy) + pointBx*(pointCy-pointAy) + pointCx*(pointAy-pointBy))/2);
    }

    public static void main(String[] args) {

        System.out.println("Please, enter co-ordinates of 3 points:");
        Scanner input = new Scanner(System.in);
        int ax = input.nextInt();
        int ay = input.nextInt();
        int bx = input.nextInt();
        int by = input.nextInt();
        int cx = input.nextInt();
        int cy = input.nextInt();

        System.out.printf("Area of the triangle is %s", triangleArea(ax,ay, bx, by, cx, cy));

    }
}
