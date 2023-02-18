package zoo.animals;

import zoo.Herbivores;
import zoo.abilities.Flyable;

public class Cow extends Herbivores implements Flyable {
    private int flightSpeed;
    private int flightHing;
    public Cow(String name) {
        super(name);
        flightSpeed = 13;
        flightHing = 2;
    }

    @Override
    public String say() {
        return "Muu!";
    }

    @Override
    public int getSpeedFlyable() {
        return this.flightSpeed;
    }

    @Override
    public int getHigh() {
        return this.flightHing;
    }
}