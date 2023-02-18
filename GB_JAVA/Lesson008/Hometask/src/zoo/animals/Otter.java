package zoo.animals;

import zoo.Predator;
import zoo.abilities.Runable;
import zoo.abilities.Swimable;

public class Otter extends Predator implements Runable, Swimable {
    private int runSpeed;
    private int swimSpeed;
    private int maxDepth;

    public Otter(String name) {
        super(name);
        runSpeed = 20;
        swimSpeed = 80;
        maxDepth = 30;
    }

    @Override
    public int getSpeedRun() {
        return runSpeed;
    }

    @Override
    public String say() {
        return "Mrrrr";
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
