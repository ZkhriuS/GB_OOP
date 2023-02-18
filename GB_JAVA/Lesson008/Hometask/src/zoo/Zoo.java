package zoo;

import zoo.abilities.Flyable;
import zoo.abilities.Runable;
import zoo.abilities.Sayable;
import zoo.abilities.Swimable;

import java.util.ArrayList;
import java.util.List;

public class Zoo {

    List<Animal> animalList = new ArrayList<>();
    Sayable radio;

    public Zoo(List<Animal> animals, Sayable sayableObj) {
        this.radio = sayableObj;
        animalList.addAll(animals);

    }

    public void addAnimal(Animal animal) {
        animalList.add(animal);
    }

    public void addAnimal(List<Animal> animals) {
        animalList.addAll(animals);
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public List<Sayable> getSayable() {
        List<Sayable> sayableList = new ArrayList<>();
        for (Animal animal : this.animalList) {
            sayableList.add(animal);
        }
        sayableList.add(this.radio);
        return sayableList;
    }

    public List<Runable> getRunableList() {
        List<Runable> runableList = new ArrayList<>();
        for (Animal animal : this.animalList) {
            if (animal instanceof Runable) {
                runableList.add((Runable) animal);
            }
        }
        return runableList;
    }

    public List<Flyable> getFlyableList() {
        List<Flyable> flyableList = new ArrayList<>();
        for (Animal animal : this.animalList) {
            if (animal instanceof Flyable) {
                flyableList.add((Flyable) animal);
            }
        }
        return flyableList;
    }
    public List<Swimable> getSwimableList() {
        List<Swimable> swimableList = new ArrayList<>();
        for (Animal animal : this.animalList) {
            if (animal instanceof Swimable) {
                swimableList.add((Swimable) animal);
            }
        }
        return swimableList;
    }

    public Animal getRunChampion(){
        List<Runable> runners = getRunableList();
        Runable champion = runners.get(0);
        for (Runable r : runners){
            if(champion.getSpeedRun() < r.getSpeedRun()){
                champion = r;
            }
        }
        return (Animal) champion;
    }

    public Animal getFlightChampion(){
        List<Flyable> flyers = getFlyableList();
        Flyable champion = flyers.get(0);
        for (Flyable r : flyers){
            if(champion.getSpeedFlyable() < r.getSpeedFlyable()){
                champion = r;
            }
        }
        return (Animal) champion;
    }

    public Animal getSwimChampion(){
        List<Swimable> swimmers = getSwimableList();
        Swimable champion = swimmers.get(0);
        for (Swimable s : swimmers){
            if(champion.getSwimSpeed() < s.getSwimSpeed()){
                champion = s;
            }
        }
        return (Animal) champion;
    }

    public void printRunable(List<Runable> animals){
        System.out.println("____Runable___________");
        for (Runable animal : animals) {
            System.out.println(((Animal)animal).getName());
            System.out.println(((Animal)animal).say());
            System.out.println(animal.getSpeedRun() + "\n");
        }
    }
    public void printFlyable(List<Flyable> animals){
        System.out.println("____Flyable___________");
        for (Flyable animal : animals) {
            System.out.println(((Animal)animal).getName());
            System.out.println(((Animal)animal).say());
            System.out.println(animal.getSpeedFlyable());
            System.out.println(animal.getHigh() + "\n");
        }
    }
    public void printSwimable(List<Swimable> animals){
        System.out.println("____Swimable__________");
        for (Swimable animal : getSwimableList()) {
            System.out.println(((Animal)animal).getName());
            System.out.println(((Animal)animal).say());
            System.out.println(animal.getSwimSpeed());
            System.out.println(animal.getMaxDepth() + "\n");
        }
    }


}


