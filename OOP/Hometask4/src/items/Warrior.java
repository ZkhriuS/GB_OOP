package items;

import armour.Armour;
import weapons.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Warrior<T extends Weapon> {
    private String name;
    protected T weapon;
    protected List<Armour> armour;
    protected Random rnd = new Random();
    private int healthPoint;


    public Warrior(String name, T weapon) {
        this.name = name;
        this.weapon = weapon;
        healthPoint = 100;
        armour = new ArrayList<>();
    }
    public Warrior<T> addArmourItem(Armour item){
        if(!containsArmour(item))
            armour.add(item);
        return this;
    }
    public boolean containsArmour(Armour item){
        for(Armour a: armour){
            if(item.equals(a))
                return true;
        }
        return false;
    }

    public int getHealthPoint() {
        return healthPoint;
    }
    public String getName(){
        return name;
    }

    public void reduceHealthPoint(int damage) {
        this.healthPoint -= damage;
    }

    public int hitDamage(Warrior enemy) {
        int damage = rnd.nextInt(weapon.damage());
        List<Armour> armourList = enemy.getArmour();
        for (Armour item: armourList) {
            damage = item.activate(damage);
        }
        enemy.reduceHealthPoint(damage);
        return damage;
    }

    public int getMaxDamage() {
        return weapon.damage();
    }
    public boolean isAlive(){
        return healthPoint>0;
    }

    public int getProtection(){
        int result = 0;
        for(Armour item: armour){
            result += item.getProtection();
        }
        return result;
    }

    public List<Armour> getArmour() {
        return armour;
    }

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder();
        for (Armour item : armour) {
            result.append(item);
        }
        return "Warrior{" +
                "name='" + name + '\'' +
                ", weapon=" + weapon +
                ", healthPoint=" + healthPoint +
                '}' + result;
    }

}