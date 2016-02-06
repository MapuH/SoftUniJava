package JavaIntro;

import java.util.Scanner;

/**
 * Created by marin on 1/20/16.
 */
public class Problem08 {

    public static float average(float x, float y, float z) {
        return (x + y + z)/3;
    }

    public static void main(String[] args) {

        System.out.print("Enter three numbers: ");
        Scanner input = new Scanner(System.in);
        float a = input.nextFloat();
        float b = input.nextFloat();
        float c = input.nextFloat();

        System.out.printf("Average: %.2f", average(a, b, c));

    }
}
