package battles;

import droids.*;

public class Battle2v2 extends Battle2v2Blueprint{
    protected void move(DroidBlueprint attacker, DroidBlueprint defender) {
        String[] drawDroid1 = attacker.getDroidLook();
        String[] drawDroid2 = defender.getDroidLook();
        String[] droidHit = {"  ,     ", "+=(====>", "  '     "};
        System.out.println();

        for (int i = 0; i < 3; i++) {
            System.out.println(drawDroid1[i] + "\t" + droidHit[i] + "\t" + drawDroid2[i]);
        }
        defender.setHealth(defender.getHealth() - attacker.getDamage(defender));
        System.out.println(attacker);
        System.out.println(defender);
        System.out.println();
    }
}
