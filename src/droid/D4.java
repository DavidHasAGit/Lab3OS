package droid;

public class D4 extends DroidBlueprint {
    public D4() {
        this.name = "Gigantic";
        this.health = 6000;
    }

    public double getDamage(DroidBlueprint opponent){
        return 800;
    }

    public String[] getDroidLook() {
        return new String[]{"(@_@)", "/[0]\\", " | \\ "};
    }

    @Override
    public String toString() {
        return "    (@_@)    NAME: Gigantic\n\t/[0])    HEALTH: " + this.health + "hp\n\t | \\     DAMAGE: 800hp";
    }
}
