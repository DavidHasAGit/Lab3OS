package droid;

public class D1 extends DroidBlueprint {
    public D1() {
        this.name = "Percentagist";
        this.health = 3000;
    }
    public double getDamage(DroidBlueprint opponent){
        if(opponent.getHealth()*0.5 <= 750) {
            return 750;
        }
        return opponent.getHealth()*0.5;
    }

    public String[] getDroidLook() {
        return new String[]{"(0_0)", "/[%]\\", " | | "};
    }

    @Override
    public String toString() {
        return "    (0_0)    NAME: Percentagist\n\t/[%]\\    HEALTH: " + this.health + "hp\n\t | |     DAMAGE: Half of opponent's health or 750hp(if opponent have < 1500hp)";
    }
}