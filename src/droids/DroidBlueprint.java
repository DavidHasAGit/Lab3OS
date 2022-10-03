package droids;

public abstract class DroidBlueprint {
    String name;
    double health;
    public abstract double getDamage(DroidBlueprint opponent);

    public abstract String[] getDroidLook();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }
}
