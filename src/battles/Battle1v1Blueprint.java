package battles;

import droids.*;

public abstract class Battle1v1Blueprint extends BattleBlueprint {
    DroidBlueprint droid1, droid2;
    private void setDroid(int dNum, int dOrder) {
        switch (dNum) {
            case 1:
                if (dOrder == 1) this.droid1 = new D1();
                else this.droid2 = new D1();
                break;
            case 2:
                if (dOrder == 1) this.droid1 = new D2();
                else this.droid2 = new D2();
                break;
            case 3:
                if (dOrder == 1) this.droid1 = new D3();
                else this.droid2 = new D3();
                break;
            case 4:
                if (dOrder == 1) this.droid1 = new D4();
                else this.droid2 = new D4();
                break;
        }
    }
    private void chooseDroid() {
        D1 d1 = new D1();
        D2 d2 = new D2();
        D3 d3 = new D3();
        D4 d4 = new D4();

        System.out.println("       #");
        System.out.println("      ##");
        System.out.println("     # #");
        System.out.println("       #");
        System.out.println(d1 + "\n");
        System.out.println("     ###");
        System.out.println("    #  #");
        System.out.println("      # ");
        System.out.println("     ###");
        System.out.println(d2 + "\n");
        System.out.println("    ####");
        System.out.println("      # ");
        System.out.println("       #");
        System.out.println("     ###");
        System.out.println(d3 + "\n");
        System.out.println("    #   #");
        System.out.println("    #   #");
        System.out.println("    #####");
        System.out.println("        #");
        System.out.println(d4 + "\n");

        System.out.print("Choose first droid(the order does not matter): ");
        int choice1 = scan.nextInt();
        while(choice1 < 1 || choice1 > 4) {
            System.out.print("Invalid input. Try again: ");
            choice1 = scan.nextInt();
        }
        setDroid(choice1, 1);

        System.out.print("Choose second droid(droids cannot be repeated): ");
        int choice2 = scan.nextInt();
        while(choice2 < 1 || choice2 > 4 || choice2 == choice1) {
            System.out.print("Invalid input. Try again: ");
            choice2 = scan.nextInt();
        }
        setDroid(choice2, 2);
    }
    private void congratulation(DroidBlueprint winner, DroidBlueprint loser) {
        System.out.println("#   #   #   #  #    #  #    ####    ###    ");
        System.out.println("#   #   #   ## #    ## #    #       #  #  @");
        System.out.println("#   #   #   # ##    # ##    ###     ###    ");
        System.out.println("# # #   #   #  #    #  #    #       # #   @");
        System.out.println(" # #    #   #  #    #  #    ####    #  #   ");

        System.out.println("\n" + winner + "\n");

        System.out.println("#        ##      ###    ####    ###    ");
        System.out.println("#       #  #    #       #       #  #  @");
        System.out.println("#       #  #     ##     ###     ###    ");
        System.out.println("#       #  #       #    #       # #   @");
        System.out.println("#####    ##     ###     ####    #  #   ");

        System.out.println("\n" + loser + "\n");
    }
    protected abstract void move(DroidBlueprint attacker, DroidBlueprint defender);
    private boolean gameEnd(DroidBlueprint attacker, double attackerHealth, DroidBlueprint defender, double defenderHealth) {
        if(defender.getHealth() <= 0) {
            defender.setHealth(0);
            congratulation(attacker, defender);
            attacker.setHealth(attackerHealth);
            defender.setHealth(defenderHealth);
            return true;
        } else return false;
    }
    private void fight(DroidBlueprint firstDroid, DroidBlueprint secondDroid) {
        double firstDroidHealth = firstDroid.getHealth();
        double secondDroidHealth = secondDroid.getHealth();
        int i = 1;

        while(true) {
            System.out.println("HIT " + i++ + "!!!");
            move(firstDroid, secondDroid);
            if (gameEnd(firstDroid, firstDroidHealth, secondDroid, secondDroidHealth)) break;

            System.out.println("HIT " + i++ + "!!!");
            move(secondDroid, firstDroid);
            if (gameEnd(secondDroid, secondDroidHealth, firstDroid, firstDroidHealth)) break;
        }
    }
    public void battle() {
        chooseDroid();
        if (firstDroidStarts()) {
            System.out.println("\t" + droid1.getName() + " STARTS!!!\n");
            fight(droid1, droid2);
        } else {
            System.out.println("\t" + droid2.getName() + " STARTS!!!\n");
            fight(droid2, droid1);
        }
    }
}
