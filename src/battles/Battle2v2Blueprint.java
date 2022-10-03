package battles;

import droids.*;

import java.util.Scanner;

public abstract class Battle2v2Blueprint extends BattleBlueprint {
    public static Scanner scan = new Scanner(System.in);
    DroidBlueprint droid1, droid2, droid3, droid4;
    private void setDroid(int dNum, int dOrder) {
        switch (dNum) {
            case 1:
                if (dOrder == 1) this.droid1 = new D1();
                else if (dOrder == 2) this.droid2 = new D1();
                else if (dOrder == 3) this.droid3 = new D1();
                else this.droid4 = new D1();
                break;
            case 2:
                if (dOrder == 1) this.droid1 = new D2();
                else if (dOrder == 2) this.droid2 = new D2();
                else if (dOrder == 3) this.droid3 = new D2();
                else this.droid4 = new D2();
                break;
            case 3:
                if (dOrder == 1) this.droid1 = new D3();
                else if (dOrder == 2) this.droid2 = new D3();
                else if (dOrder == 3) this.droid3 = new D3();
                else this.droid4 = new D3();
                break;
            case 4:
                if (dOrder == 1) this.droid1 = new D4();
                else if (dOrder == 2) this.droid2 = new D4();
                else if (dOrder == 3) this.droid3 = new D4();
                else this.droid4 = new D4();
                break;
        }
    }

    public void chooseDroid() {
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

    protected abstract void move(DroidBlueprint attacker, DroidBlueprint defender);

    private boolean gameEnd(DroidBlueprint defender) {
        if (defender.getHealth() <= 0) {
            defender.setHealth(0);
            if (defender == droid1 || defender == droid2) {
                if (droid1.getHealth() <= 0 && droid2.getHealth() <= 0) {
                    congratulation(droid3, droid4, droid1, droid2);
                    return true;
                }
            }
            else {
                if (droid3.getHealth() <= 0 && droid4.getHealth() <= 0) {
                    congratulation(droid1, droid2, droid3, droid4);
                    return true;
                }
            }
        }
        return false;
    }
    private void fight(DroidBlueprint firstDroid, DroidBlueprint secondDroid, DroidBlueprint thirdDroid, DroidBlueprint fourthDroid) {
        int i = 1;
        while (true) {
            if (firstDroid.getHealth() > 0) {
                System.out.println("HIT " + i++ + "!!!");
                if ((thirdDroid.getHealth() < fourthDroid.getHealth() && thirdDroid.getHealth() > 0) || fourthDroid.getHealth() <= 0) {
                    move(firstDroid, thirdDroid);
                    if (gameEnd(thirdDroid)) break;
                } else {
                    move(firstDroid, fourthDroid);
                    if (gameEnd(fourthDroid)) break;
                }
            }

            if (secondDroid.getHealth() > 0) {
                System.out.println("HIT " + i++ + "!!!");
                if ((firstDroid.getHealth() < secondDroid.getHealth() && firstDroid.getHealth() > 0) || secondDroid.getHealth() <= 0) {
                    move(thirdDroid, firstDroid);
                    if (gameEnd(firstDroid)) break;
                } else {
                    move(thirdDroid, secondDroid);
                    if (gameEnd(secondDroid)) break;
                }
            }

            if (thirdDroid.getHealth() > 0) {
                System.out.println("HIT " + i++ + "!!!");
                if ((thirdDroid.getHealth() < fourthDroid.getHealth() && thirdDroid.getHealth() > 0) || fourthDroid.getHealth() <= 0) {
                    move(secondDroid, thirdDroid);
                    if (gameEnd(thirdDroid)) break;
                } else {
                    move(secondDroid, fourthDroid);
                    if (gameEnd(fourthDroid)) break;
                }
            }

            if (fourthDroid.getHealth() > 0) {
                System.out.println("HIT " + i++ + "!!!");
                if ((firstDroid.getHealth() < secondDroid.getHealth() && firstDroid.getHealth() > 0) || secondDroid.getHealth() <= 0) {
                    move(fourthDroid, firstDroid);
                    if (gameEnd(firstDroid)) break;
                } else {
                    move(fourthDroid, secondDroid);
                    if (gameEnd(secondDroid)) break;
                }
            }
        }
    }
    private void getHealthBack(double firstDroidHealth, double secondDroidHealth, double thirdDroidHealth, double fourthDroidHealth) {
        droid1.setHealth(firstDroidHealth);
        droid2.setHealth(secondDroidHealth);
        droid3.setHealth(thirdDroidHealth);
        droid4.setHealth(fourthDroidHealth);
    }
    public void battle() {
        chooseDroid();
        double firstDroidHealth = droid1.getHealth();
        double secondDroidHealth = droid2.getHealth();
        double thirdDroidHealth = droid3.getHealth();
        double fourthDroidHealth = droid4.getHealth();
        if (firstDroidStarts()) {
            System.out.println("\t" + droid1.getName() + " STARTS!!!\n");
            fight(droid1, droid2, droid3, droid4);
            getHealthBack(firstDroidHealth, secondDroidHealth,thirdDroidHealth, fourthDroidHealth);
        } else {
            System.out.println("\t" + droid3.getName() + " STARTS!!!\n");
            fight(droid3, droid4, droid1, droid2);
            getHealthBack(firstDroidHealth, secondDroidHealth,thirdDroidHealth, fourthDroidHealth);
        }
    }
}
