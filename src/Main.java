import java.util.Scanner;

import battle.Battle1v1;
import battle.Battle1v1Plus;
import battle.Battle2v2;
import battle.Battle2v2Plus;
import droid.*;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        while (true){
            System.out.print("1. Show exist droids\n" +
                    "2. Battle 1v1\n" +
                    "3. Battle 1v1+\n" +
                    "4. Battle 2v2\n" +
                    "5. Battle 2v2+\n" +
                    "6. Exit\n" +
                    "Your choice: ");
            switch (scan.nextInt()) {
                case 1:
                    showDroids();
                    break;
                case 2:
                    Battle1v1 battle1v1 = new Battle1v1();
                    battle1v1.battle();
                    break;
                case 3:
                    Battle1v1Plus battle1v1Plus = new Battle1v1Plus();
                    battle1v1Plus.battle();
                    break;
                case 4:
                    Battle2v2 battle2v2 = new Battle2v2();
                    battle2v2.battle();
                    break;
                case 5:
                    Battle2v2Plus battle2v2Plus = new Battle2v2Plus();
                    battle2v2Plus.battle();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("There is no such choice");
            }
        }
    }
    public static void showDroids(){
        DroidBlueprint[] dr = new DroidBlueprint[4];
        dr[0] = new D1();
        dr[1] = new D2();
        dr[2] = new D3();
        dr[3] = new D4();

        for (DroidBlueprint i : dr) {
            System.out.println(i);
            System.out.println("\n");
        }
    }
}
