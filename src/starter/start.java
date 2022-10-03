package starter;

import java.util.Scanner;

import battles.Battle1v1;
import battles.Battle1v1Plus;
import battles.Battle2v2;
import battles.Battle2v2Plus;
import droids.D1;
import droids.D2;
import droids.D3;
import droids.D4;

public class start {
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
        D1 d1 = new D1();
        D2 d2 = new D2();
        D3 d3 = new D3();
        D4 d4 = new D4();

        System.out.println(d1);
        System.out.println("\n");
        System.out.println(d2);
        System.out.println("\n");
        System.out.println(d3);
        System.out.println("\n");
        System.out.println(d4);
        System.out.println("\n");
    }
}
