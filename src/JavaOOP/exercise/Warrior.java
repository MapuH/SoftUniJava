package JavaOOP.exercise;

import JavaOOP.exercise.Exceptions.OutOfEnergyException;

public class Warrior extends GameCharacter {

    private static final int BASE_HEALTH = 5000;
    private static final int BASE_POWER = 200;
    private static final int BASE_ENERGY = 1000;
    private static final int BASE_ATTACK_COST = 150;
    private static final double POWER_SURGE_THRESHOLD = 0.3;
    private static final double BLOCK_THRESHOLD = 0.6;

    public Warrior(int health, int power, int energy, int attackCost, String name) {
        super(health, power, energy, attackCost, name);
    }

    public Warrior(String name) {
        this(BASE_HEALTH, BASE_POWER, BASE_ENERGY, BASE_ATTACK_COST, name);
    }

    @Override
    public void attack(GameCharacter other) throws OutOfEnergyException {

        if (other == this) {
            throw new IllegalStateException("Can't attack itself!");
        }

        if (this.getEnergy() < this.getAttackCost()) {
            throw new OutOfEnergyException(this.getName() + " is out of energy. Battle over.");
        }

        boolean hadPowerSurge = Math.random() < POWER_SURGE_THRESHOLD;
        if (hadPowerSurge) {
            System.out.printf("Warrior %s was lucky. Free attack.\n", this.getName());
        } else {
            this.setEnergy(this.getEnergy() - this.getAttackCost());
        }

        other.respond(this.getPower());
    }

    @Override
    public void respond(int damage) {

        boolean hasBlocked = Math.random() < BLOCK_THRESHOLD;
        if (hasBlocked) {
            System.out.printf("Warrior %s blocked the attack!\n", this.getName());
            damage = damage / 2;
        }

        this.setHealth(this.getHealth() - damage);
        System.out.println(damage + " damage dealt!");
    }
}
