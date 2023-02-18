package zoo.animals;

import zoo.Predator;
import zoo.abilities.Runable;

public class Leo extends Predator implements Runable {
    private int runSpeed;
    public Leo(String name) {
        super(name);
        runSpeed = 300;
    }

    @Override
    public String say() {
        return "Rrrr!";
    }


    @Override
    public int getSpeedRun() {
        return this.runSpeed;
    }
}