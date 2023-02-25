package items;

import armour.Armour;
import weapons.Bow;
import weapons.Sword;

public class SwordMan extends Warrior<Sword> {
    public SwordMan(String name, Sword weapon) {
        super(name, weapon);
    }


    @Override
    public String toString() {
        return super.toString() + " Type = SwordMan";
    }
    @Override
    public Warrior<Sword> addArmourItem(Armour item) {
        super.addArmourItem(item);
        return this;
    }
}