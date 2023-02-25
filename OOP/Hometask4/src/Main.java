import armour.*;
import items.Archer;
import items.SwordMan;
import items.Warrior;
import team.Team;
import weapons.Bow;
import weapons.Sword;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Team<Archer> archerTeam = new Team<>("Archers", 4);
        for(int i=0; i<archerTeam.getSize(); i++){
            Archer archer = new Archer("Archer"+i, new Bow());
            archer.addArmourItem(new Helmet(Helmet.generateProtection()))
                    .addArmourItem(new Hauberk(Hauberk.generateProtection()));
            archerTeam.addWarrior(archer);
        }

        System.out.println(archerTeam);

        Team<Warrior> mixTeam = new Team<>("Mixer", 4);
        SwordMan swordMan1 = new SwordMan("SwordMan1", new Sword());
        swordMan1.addArmourItem(new Helmet(Helmet.generateProtection()))
                .addArmourItem(new Hauberk(Hauberk.generateProtection()))
                .addArmourItem(new Shield(Shield.generateProtection()));
        SwordMan swordMan2 = new SwordMan("SwordMan2", new Sword());
        swordMan2.addArmourItem(new SuperShield(SuperShield.generateProtection()));
        mixTeam.addWarrior(new Archer("Archer4", new Bow()))
                .addWarrior(new SwordMan("SwordMan0", new Sword()))
                .addWarrior(swordMan1)
                .addWarrior(swordMan2);

        System.out.println(mixTeam);

        archerTeam.battle(mixTeam);

        if (archerTeam.getSize()>0)
            System.out.println("Победила команда "+archerTeam.getName());
        else
            System.out.println("Победила команда "+mixTeam.getName());
    }
}