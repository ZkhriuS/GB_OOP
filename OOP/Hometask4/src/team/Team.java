package team;

import armour.Armour;
import items.DistanceAttacker;
import items.Warrior;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Team<T extends Warrior> {
    private List<T> team = new ArrayList<>();
    private String name;
    private int size;

    private Random random = new Random();

    public Team(String name, int size) {
        this.name = name;
        this.size =size;
    }

    public Team<T> addWarrior(T warrior) {
        team.add(warrior);
        return this;
    }

    public Team<T> addWarrior(T warrior, Armour item) {
        team.add((T) warrior.addArmourItem(item));
        return this;
    }
    public Team<T> addWarrior(T warrior, List<Armour> armour) {
        for (Armour item:armour) {
            warrior.addArmourItem(item);
        }
        team.add(warrior);
        return this;
    }

    public int getMaxDistance() {
        int distance = 0;
        for (T item : team) {
            if (!(item instanceof DistanceAttacker)) {
                continue;
            }
            DistanceAttacker temp = (DistanceAttacker) item;
            if (temp.getDistance() > distance) {
                distance = temp.getDistance();
            }
        }
        return distance;
    }

    public int getTeamDamage() {
        int sum = 0;
        for (T item : team) {
            sum += item.getMaxDamage();
        }
        return sum;
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public void battle(Team otherTeam){
        while(size>0 && otherTeam.getSize()>0){
            Warrior thisWarrior = chooseWarrior();
            Warrior otherWarrior = otherTeam.chooseWarrior();
            printAction(thisWarrior, otherWarrior, thisWarrior.hitDamage(otherWarrior));
            System.out.println(otherTeam);
            System.out.println("---------------------------------");
            if(!otherWarrior.isAlive())
                if(!otherTeam.removeWarrior(otherWarrior))
                    return;
            thisWarrior = chooseWarrior();
            otherWarrior = otherTeam.chooseWarrior();
            printAction(otherWarrior, thisWarrior, otherWarrior.hitDamage(thisWarrior));
            System.out.println(this);
            System.out.println("---------------------------------");
            if(!thisWarrior.isAlive())
                if(!removeWarrior(thisWarrior))
                    return;
        }
    }

    public T chooseWarrior(){
        int index = random.nextInt(getSize());
        return team.get(index);
    }

    public boolean removeWarrior(Warrior warrior){
        team.remove(warrior);
        size--;
        return size>0;
    }

    public void printAction(Warrior first, Warrior second, int damage){
        StringBuilder actionMessage = new StringBuilder();
        if(damage > 0) {
            actionMessage.append("Воин ").append(first.getName()).append(" нанес урон ");
            actionMessage.append(damage + second.getProtection()).append(" воину ").append(second.getName());
        }else{
            actionMessage.append("Воин ").append(second.getName()).append(" защитился от атаки воина ");
            actionMessage.append(first.getName());
        }
        System.out.println(actionMessage);
    }

    @Override
    public String toString() {
        StringBuilder teamBuilder = new StringBuilder();
        teamBuilder.append("\t\t\tКоманда ").append(name).append("\n");
        teamBuilder.append("Воины\tЗдоровье\tЗащита\n");
        for (T item : team) {
            teamBuilder.append(item.getName()).append("\t\t").append(item.getHealthPoint()).append("\t\t").append(item.getProtection()).append("\n");
        }
        return teamBuilder.append("\n").toString();
    }
}