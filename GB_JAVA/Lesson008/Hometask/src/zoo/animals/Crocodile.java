package zoo.animals;

import zoo.Predator;
import zoo.abilities.Flyable;
import zoo.abilities.Runable;
import zoo.abilities.Swimable;

public class Crocodile extends Predator implements Runable, Flyable, Swimable {
    private int flightSpeed;
    private int flightHing;
    private int runSpeed;
    private int swimSpeed;
    private int maxDepth;

    public Crocodile(String name) {
        super(name);
        flightSpeed = 15;
        flightHing = 5;
        runSpeed = 100;
        swimSpeed = 60;
        maxDepth = 125;
    }

    @Override
    public String say() {
        return "Shhhhh";
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
    public int getSwimSpeed() {
        return swimSpeed;
    }

    @Override
    public int getMaxDepth() {
        return maxDepth;
    }
}