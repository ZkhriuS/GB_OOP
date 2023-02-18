import zoo.*;
import zoo.abilities.Flyable;
import zoo.abilities.Runable;
import zoo.abilities.Swimable;
import zoo.animals.*;
import zoo.radio.Radio;
import zoo.abilities.Sayable;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Animal> animalsList = List.of(
                new Cow("Мурка"),
                new Dolphin("Касатик"),
                new Crocodile("Гена"),
                new Leo("Симба - Леопольд"),
                new Goat("Маруська"),
                new Otter("Лариса"),
                new Duck("Дональд Дак")
        );
        Zoo zoo = new Zoo(animalsList, new Radio());

        for (Sayable animal : zoo.getSayable()) {
            System.out.println(animal.say());
        }
        zoo.printRunable(zoo.getRunableList());
        zoo.printFlyable(zoo.getFlyableList());
        zoo.printSwimable(zoo.getSwimableList());
        System.out.println("____Определяем чемпиона по бегу_____");
        System.out.println(zoo.getRunChampion());
        System.out.println("____Определяем чемпиона по полётам_______");
        System.out.println(zoo.getFlightChampion());
        System.out.println("____Определяем чемпиона по плаванию_______");
        System.out.println(zoo.getSwimChampion());

    }
    //https://www.plantuml.com/
}