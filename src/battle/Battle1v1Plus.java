package battle;

import droid.*;

import java.util.Random;

public class Battle1v1Plus extends Battle1v1 {
    public static Random rand = new Random();
    private double getRandomAbility() {
        double ability = rand.nextDouble();
        if (ability < 0.1) System.out.println("   V   ");
        else if (ability < 0.2) System.out.println("         V   ");
        else if (ability < 0.4) System.out.println("               V   ");
        else if (ability < 0.8) System.out.println("                     V   ");
        else System.out.println("                           V   ");

        System.out.println("+-----+-----+-----+-----+-----+");
        System.out.println("| A W | A L | X2D | +HP | SKP |");
        System.out.println("+-----+-----+-----+-----+-----+");
        return ability;
    }
    protected void move(DroidBlueprint attacker, DroidBlueprint defender) {
        double ability = getRandomAbility();
        if (ability < 0.1) {
            System.out.println("AUTOMATIC WIN!!!\n" + defender.getName() + " ran out of the ring and was hit by a car");
            defender.setHealth(0);
        }
        else if (ability < 0.2) {
            System.out.println("AUTOMATIC LOSE!!!\n" + attacker.getName() + " ran out of the ring and was hit by a car");
            attacker.setHealth(0);
        }
        else if (ability < 0.4) {
            System.out.println(attacker.getName() + " IS VERY ANGRY!!!");
            defender.setHealth(defender.getHealth() - (2 * attacker.getDamage(defender)));
        }
        else if (ability < 0.8) {
            System.out.println(attacker.getName() + " drinks something");
            attacker.setHealth(attacker.getHealth() + 500);
            defender.setHealth(defender.getHealth() - attacker.getDamage(defender));
        }
        else {
            System.out.println(attacker.getName() + " got tired and missed the move");
        }
    }
}
