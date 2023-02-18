package zoo;

import zoo.abilities.Flyable;
import zoo.abilities.Runable;
import zoo.abilities.Sayable;
import zoo.abilities.Swimable;

public abstract class Animal implements Sayable {

    private String name;

    protected Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public abstract String feed();

    @Override
    public String toString() {
        StringBuilder srt = new StringBuilder();
        if (this instanceof Runable) {
            srt.append(" Скорость бега - > " + ((Runable) this).getSpeedRun());
        }
        if (this instanceof Flyable) {
            srt.append(" Скорость полёта - > " + ((Flyable) this).getSpeedFlyable());
        }
        if (this instanceof Swimable) {
            srt.append(" Скорость плавания - > " + ((Swimable) this).getSwimSpeed());
        }
        return String.format(srt + " %s ест %s", this.name, this.feed());
    }
}