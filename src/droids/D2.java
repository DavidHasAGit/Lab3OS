package droids;

public class D2 extends DroidBlueprint {
    public D2() {
        this.name = "Healer";
        this.health = 3000;
    }

    public double getDamage(DroidBlueprint opponent){
        this.health += 400;
        return 1000;
    }

    public String[] getDroidLook() {
        return new String[]{"(^_^)", "/[+]\\", " | | "};
    }

    @Override
    public String toString() {
        return "    (^_^)    NAME: Healer\n\t/[+]\\    HEALTH: " + this.health + "hp\n\t | |     DAMAGE: 1000hp and healing 400hp itself";
    }
}
