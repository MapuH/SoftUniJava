package JavaIntro;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by marin on 1/20/16.
 */
public class Problem07 {

    public static void main(String[] args) {

        HashMap<Character, String> ghettoNum = new HashMap<>();
        ghettoNum.put('0', "Gee");
        ghettoNum.put('1', "Bro");
        ghettoNum.put('2', "Zuz");
        ghettoNum.put('3', "Ma");
        ghettoNum.put('4', "Duh");
        ghettoNum.put('5', "Yo");
        ghettoNum.put('6', "Dis");
        ghettoNum.put('7', "Hood");
        ghettoNum.put('8', "Jam");
        ghettoNum.put('9', "Mack");

        System.out.print("Please, enter a number: ");
        Scanner input = new Scanner(System.in);
        String n = input.next();

        for (int i = 0; i < n.length(); i++) {
            char c = n.charAt(i);
            System.out.print(ghettoNum.get(c));
        }
    }
}
