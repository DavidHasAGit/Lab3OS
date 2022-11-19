package battle;

import droid.*;

public class Battle1v1 extends BattleBlueprint {
    DroidBlueprint[] droids = new DroidBlueprint[2];
    private void setDroid(int dNum, int dOrder) {
        switch (dNum) {
            case 1 -> this.droids[dOrder] = new D1();
            case 2 -> this.droids[dOrder] = new D2();
            case 3 -> this.droids[dOrder] = new D3();
            case 4 -> this.droids[dOrder] = new D4();
        }
    }
    private void chooseDroid() {
        DroidBlueprint[] dr = new DroidBlueprint[4];
        dr[0] = new D1();
        dr[1] = new D2();
        dr[2] = new D3();
        dr[3] = new D4();

        System.out.println("       #");
        System.out.println("      ##");
        System.out.println("     # #");
        System.out.println("       #");
        System.out.println(dr[0] + "\n");
        System.out.println("     ###");
        System.out.println("    #  #");
        System.out.println("      # ");
        System.out.println("     ###");
        System.out.println(dr[1] + "\n");
        System.out.println("    ####");
        System.out.println("      # ");
        System.out.println("       #");
        System.out.println("     ###");
        System.out.println(dr[2] + "\n");
        System.out.println("    #   #");
        System.out.println("    #   #");
        System.out.println("    #####");
        System.out.println("        #");
        System.out.println(dr[3] + "\n");

        System.out.print("Choose first droid(the order does not matter): ");
        int choice1 = scan.nextInt();
        while(choice1 < 1 || choice1 > 4) {
            System.out.print("Invalid input. Try again: ");
            choice1 = scan.nextInt();
        }
        setDroid(choice1, 0);

        System.out.print("Choose second droid(droids cannot be repeated): ");
        int choice2 = scan.nextInt();
        while(choice2 < 1 || choice2 > 4 || choice2 == choice1) {
            System.out.print("Invalid input. Try again: ");
            choice2 = scan.nextInt();
        }
        setDroid(choice2, 1);
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
    protected void move(DroidBlueprint attacker, DroidBlueprint defender) {
        defender.setHealth(defender.getHealth() - attacker.getDamage(defender));
    }
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
            showMove(firstDroid, secondDroid);
            if (gameEnd(firstDroid, firstDroidHealth, secondDroid, secondDroidHealth)) break;

            System.out.println("HIT " + i++ + "!!!");
            move(secondDroid, firstDroid);
            showMove(secondDroid, firstDroid);
            if (gameEnd(secondDroid, secondDroidHealth, firstDroid, firstDroidHealth)) break;
        }
    }
    public void battle() {
        chooseDroid();
        if (firstDroidStarts()) {
            System.out.println("\t" + droids[0].getName() + " STARTS!!!\n");
            fight(droids[0], droids[1]);
        } else {
            System.out.println("\t" + droids[1].getName() + " STARTS!!!\n");
            fight(droids[1], droids[0]);
        }
    }
}
