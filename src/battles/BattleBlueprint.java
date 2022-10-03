package battles;

import java.util.Random;
import java.util.Scanner;

public class BattleBlueprint {
    public static Scanner scan = new Scanner(System.in);
    public static Random rand = new Random();
    protected String[] chooseObject(int objectPos) {
        String[] stone = {" @@@@ ", "@@@@@@", "@@@@@@", " @@@@ "};
        String[] scissors = {"#    #", " #  # ", "  ##  ", "##  ##"};
        String[] paper = {"######", "######", "######", "######"};

        if (objectPos == 0) {
            return stone;
        } else if (objectPos == 1) {
            return scissors;
        } else {
            return paper;
        }
    }
    protected boolean firstDroidStarts() {
        String[][] field = new String[2][4];

        System.out.println("       #          ###");
        System.out.println("      ##         #  #");
        System.out.println("     # #           # ");
        System.out.println("       #          ###\n");

        while (true) {
            int d1Object = rand.nextInt(3);
            field[0] = chooseObject(d1Object);
            int d2Object = rand.nextInt(3);
            field[1] = chooseObject(d2Object);

            for (int i = 0; i < field[0].length; i++) {
                System.out.println("\t" + field[0][i] + "\t\t" + field[1][i]);
            }
            System.out.println();
            if (d1Object == d2Object) continue;
            return (d1Object == 0 && d2Object == 1) || (d1Object == 1 && d2Object == 2) || (d1Object == 2 && d2Object == 0);
        }
    }
}
