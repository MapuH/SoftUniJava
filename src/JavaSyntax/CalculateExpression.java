package JavaSyntax;

import java.util.Scanner;

/**
 * Created by marin on 1/23/16.
 */
public class CalculateExpression {

    public static void main(String[] args) {

        System.out.println("Please, enter 3 floating point numbers:");
        Scanner input = new Scanner(System.in);
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();

        double f1 = Math.pow(((Math.pow(a, 2) + Math.pow(b, 2))/(Math.pow(a, 2) - Math.pow(b, 2))), ((a+b+c)/Math.sqrt(c)));

        double f2 = Math.pow(Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 3), a-b);

        double avg = (a+b+c)/3;
        double favg = (f1+f2)/2;

        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f", f1, f2, avg-favg);
    }
}
