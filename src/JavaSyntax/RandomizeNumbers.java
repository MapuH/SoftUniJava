package JavaSyntax;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by marin on 1/23/16.
 */
public class RandomizeNumbers {

    public static void main(String[] args) {

        System.out.println("Please, enter 2 numbers to form a range:");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();

        ArrayList<Integer> randList = new ArrayList<>();
        for (int i = Math.min(n, m); i <= Math.max(n, m); i++) {
            randList.add(i);
        }

        Collections.shuffle(randList);

        for (int num : randList) {
            System.out.print(num + " ");
        }
    }

}
