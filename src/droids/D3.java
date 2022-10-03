package droids;

import java.util.Random;

public class D3 extends DroidBlueprint {
    public D3() {
        this.name = "Stealer";
        this.health = 4500;
    }

    public double getDamage(DroidBlueprint opponent){
        Random rand = new Random();
        double random = rand.nextDouble();
        if (random < 0.50) return opponent.getDamage(this)*1.5;
        else return 700;
    }

    public String[] getDroidLook() {
        return new String[]{"($_$)", "/[1]\\", " | | "};
    }

    @Override
    public String toString() {
        return "    ($_$)    NAME: Stealer\n\t/[1]\\    HEALTH: " + this.health + "hp\n\t | |     DAMAGE: 150% of opponent's damage or 700hp (random)";
    }
}
