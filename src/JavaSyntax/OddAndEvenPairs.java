package JavaSyntax;

import java.util.Scanner;

/**
 * Created by marin on 1/23/16.
 */
public class OddAndEvenPairs {

    public static boolean isEven(int x) {
        if (x % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        System.out.println("Input integers:");
        Scanner input = new Scanner(System.in);
        String numList = input.nextLine();

        String[] nums = numList.split("\\s+");

        if (!isEven(nums.length)) {
            System.out.println("Invalid length");
            System.exit(0);
        }

        for (int i = 0; i < nums.length; i += 2) {

            int first = Integer.parseInt(nums[i]);
            int second = Integer.parseInt(nums[i+1]);

            if (isEven(first) && isEven(second)) {
                System.out.printf("%s, %s -> both are even\n", first, second);

            } else if (!isEven(first) && !isEven(second)) {
                System.out.printf("%s, %s -> both are odd\n", first, second);

            } else {
                System.out.printf("%s, %s -> different\n", first, second);
            }
        }

    }
}
