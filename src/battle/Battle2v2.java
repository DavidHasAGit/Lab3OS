package battle;

import droid.*;

import java.util.Scanner;

public class Battle2v2 extends BattleBlueprint {
    public static Scanner scan = new Scanner(System.in);
    DroidBlueprint[] droids = new DroidBlueprint[4];
    private void setDroid(int dNum, int dOrder) {
        switch (dNum) {
            case 1 -> this.droids[dOrder] = new D1();
            case 2 -> this.droids[dOrder] = new D2();
            case 3 -> this.droids[dOrder] = new D3();
            case 4 -> this.droids[dOrder] = new D4();
        }
    }
    public void chooseDroid() {
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

        System.out.print("Choose the captain of the first team: ");
        int choice1 = scan.nextInt();
        while(choice1 < 1 || choice1 > 4) {
            System.out.print("Invalid input. Try again: ");
            choice1 = scan.nextInt();
        }
        setDroid(choice1, 1);

        System.out.print("Choose second droid of the first team(droids cannot be repeated): ");
        int choice2 = scan.nextInt();
        while(choice2 < 1 || choice2 > 4 || choice2 == choice1) {
            System.out.print("Invalid input. Try again: ");
            choice2 = scan.nextInt();
        }
        setDroid(choice2, 2);

        System.out.print("Choose the captain of the second team(droids cannot be repeated): ");
        int choice3 = scan.nextInt();
        while(choice3 < 1 || choice3 > 4 || choice3 == choice1 || choice3 == choice2) {
            System.out.print("Invalid input. Try again: ");
            choice3 = scan.nextInt();
        }
        setDroid(choice3, 3);

        System.out.print("Choose second droid of the second team(droids cannot be repeated): ");
        int choice4 = scan.nextInt();
        while(choice4 < 1 || choice4 > 4 || choice4 == choice1 || choice4 == choice2 || choice4 == choice3) {
            System.out.print("Invalid input. Try again: ");
            choice4 = scan.nextInt();
        }
        setDroid(choice4, 4);
    }

    private void congratulation(DroidBlueprint winner1, DroidBlueprint winner2, DroidBlueprint loser1, DroidBlueprint loser2) {
        System.out.println("#   #   #   #  #    #  #    ####    ###      ###   ");
        System.out.println("#   #   #   ## #    ## #    #       #  #    #     @");
        System.out.println("#   #   #   # ##    # ##    ###     ###      ##    ");
        System.out.println("# # #   #   #  #    #  #    #       # #        #  @");
        System.out.println(" # #    #   #  #    #  #    ####    #  #    ###    ");

        System.out.println("\n" + winner1 + "\n" + winner2 + "\n");

        System.out.println("#        ##      ###    ####    ###      ###   ");
        System.out.println("#       #  #    #       #       #  #    #     @");
        System.out.println("#       #  #     ##     ###     ###      ##    ");
        System.out.println("#       #  #       #    #       # #        #  @");
        System.out.println("#####    ##     ###     ####    #  #    ###    ");

        System.out.println("\n" + loser1 + "\n" + loser2 + "\n");
    }

    protected void move(DroidBlueprint attacker, DroidBlueprint defender) {
        defender.setHealth(defender.getHealth() - attacker.getDamage(defender));
    }
    private boolean gameEnd(DroidBlueprint defender) {
        if (defender.getHealth() <= 0) {
            defender.setHealth(0);
            if (defender == droids[0] || defender == droids[1]) {
                if (droids[0].getHealth() <= 0 && droids[1].getHealth() <= 0) {
                    congratulation(droids[2], droids[3], droids[0], droids[1]);
                    return true;
                }
            }
            else {
                if (droids[2].getHealth() <= 0 && droids[3].getHealth() <= 0) {
                    congratulation(droids[0], droids[1], droids[2], droids[3]);
                    return true;
                }
            }
        }
        return false;
    }
    private DroidBlueprint hit(DroidBlueprint attacker, DroidBlueprint defender1, DroidBlueprint defender2) {
        if ((defender1.getHealth() < defender2.getHealth() && defender1.getHealth() > 0) || defender2.getHealth() <= 0) {
            move(attacker, defender1);
            showMove(attacker, defender1);
            return defender1;
        } else {
            move(attacker, defender2);
            showMove(attacker, defender2);
            return defender2;
        }
    }
    private void fight(DroidBlueprint firstDroid, DroidBlueprint secondDroid, DroidBlueprint thirdDroid, DroidBlueprint fourthDroid) {
        int i = 1;
        while (true) {
            if (firstDroid.getHealth() > 0) {
                System.out.println("HIT " + i++ + "!!!");
                if (gameEnd( hit(firstDroid, thirdDroid, fourthDroid) )) break;
            }
            if (thirdDroid.getHealth() > 0) {
                System.out.println("HIT " + i++ + "!!!");
                if (gameEnd( hit(thirdDroid, firstDroid, secondDroid) )) break;
            }
            if (secondDroid.getHealth() > 0) {
                System.out.println("HIT " + i++ + "!!!");
                if (gameEnd( hit(secondDroid, thirdDroid, fourthDroid) )) break;
            }
            if (fourthDroid.getHealth() > 0) {
                System.out.println("HIT " + i++ + "!!!");
                if (gameEnd( hit(fourthDroid, firstDroid, secondDroid) )) break;
            }
        }
    }
    private void getHealthBack(double[] healths) {
        for (int i = 0; i < droids.length; i++) droids[i].setHealth(healths[i]);
    }
    public void battle() {
        chooseDroid();
        double[] healths = new double[4];
        for (int i = 0; i < healths.length; i++) healths[i] = droids[i].getHealth();

        if (firstDroidStarts()) {
            System.out.println("\t" + droids[0].getName() + " STARTS!!!\n");
            fight(droids[0], droids[1], droids[2], droids[3]);
            getHealthBack(healths);
        } else {
            System.out.println("\t" + droids[2].getName() + " STARTS!!!\n");
            fight(droids[2], droids[3], droids[0], droids[1]);
            getHealthBack(healths);
        }
    }
}
