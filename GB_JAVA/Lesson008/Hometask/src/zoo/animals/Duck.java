package zoo.animals;

import zoo.Herbivores;
import zoo.abilities.Flyable;
import zoo.abilities.Runable;
import zoo.abilities.Swimable;

public class Duck extends Herbivores implements Flyable, Runable, Swimable {
    private int flightSpeed;
    private int flightHing;
    private int runSpeed;
    private int swimSpeed;
    private int maxDepth;

    public Duck(String name) {
        super(name);
        flightSpeed = 15;
        flightHing = 5;
        runSpeed = 10;
        swimSpeed = 35;
        maxDepth = 15;
    }

    @Override
    public String say() {
        return "Krya Krya!";
    }


    @Override
    public int getSpeedFlyable() {
        return this.flightSpeed;
    }

    @Override
    public int getHigh() {
        return this.flightHing;
    }

    @Override
    public int getSpeedRun() {
        return this.runSpeed;
    }

    @Override
    public int getMaxDepth() {
        return maxDepth;
    }

    @Override
    public int getSwimSpeed() {
        return swimSpeed;
    }
}