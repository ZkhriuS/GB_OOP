package zoo.animals;

import zoo.AquaPredator;
import zoo.abilities.Swimable;

public class Dolphin extends AquaPredator implements Swimable {
    private int swimSpeed;
    private int maxDepth;

    public Dolphin(String name)
    {
        super(name);
        swimSpeed = 200;
        maxDepth = 500;
    }
    @Override
    public String say() {
        return "Iiiiiiuuuuuu";
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
