package zoo.animals;

import zoo.Herbivores;
import zoo.abilities.Runable;

public class Goat extends Herbivores implements Runable {
    private int runSpeed;
    public Goat(String name) {
        super(name);
        runSpeed = 4;
    }

    @Override
    public String say() {
        return "Beee!";
    }

    @Override
    public int getSpeedRun() {
        return this.runSpeed;
    }
}