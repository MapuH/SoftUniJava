package JavaIntro;

import java.util.Scanner;

/**
 * Created by marin on 1/19/16.
 */
public class Problem05 {

    public static void printRow(char letter) {

        for (char c = 'a'; c <= letter ; c++) {
            System.out.print(c + " ");
        }
        System.out.print("\n");

    }

    public static void main(String[] args) {

        System.out.print("Please, enter a number between 2 and 26: ");
        Scanner input = new Scanner(System.in);
        int col = input.nextInt();

        for (int i = 97; i < col+97 ; i++) {
            printRow((char) i);
        }

        for (int i = 97+col-2; i >= 97; i--) {
            printRow((char) i);
        }

    }
}
