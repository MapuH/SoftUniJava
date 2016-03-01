package JavaOOP.exercise;

import JavaOOP.exercise.Exceptions.OutOfEnergyException;

/**
 * Created by marin on 3/1/16.
 *
 * Design a simple program that simulates a battle between a mage and a warrior.
 * Both characters have similar features as well as some unique abilities.
 */
public class Main {

    public static void main(String[] args) {

        GameCharacter gandalf = new Mage("Gandalf");
        GameCharacter leonidis = new Warrior("Leonidis");

        int roundCount = 0;
        while (true) {
            System.out.println("ROUND: " + ++roundCount);
            try {
                if (roundCount % 2 != 0) {
                    leonidis.attack(gandalf);
                    gandalf.attack(leonidis);
                } else {
                    gandalf.attack(leonidis);
                    leonidis.attack(gandalf);
                }
            } catch (OutOfEnergyException e) {
                System.out.println(e.getMessage());
                break;
            }

            System.out.println();
        }

        if (gandalf.getHealth() > leonidis.getHealth()) {
            System.out.println("Winner is " + gandalf.getName().toUpperCase());
        } else if (leonidis.getHealth() > gandalf.getHealth()) {
            System.out.println("Winner is " + leonidis.getName().toUpperCase());
        } else {
            System.out.println("It is a draw!");
        }
    }
}
