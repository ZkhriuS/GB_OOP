package armour;

import java.util.Random;

public abstract class Armour {
    protected String name;
    protected int protection;
    protected static int maxProtection, minProtection;
    protected static Random random = new Random();
    protected boolean on;
    public Armour(int protection) {
        this.protection = protection;
        on = true;
    }
    public Armour(){
        protection = 0;
        on = false;
    }

    public abstract int activate(int damage);
    public boolean isOn(){
        return on;
    }

    public int getProtection() {
        return protection;
    }

    public static int generateProtection() {
        return random.nextInt(minProtection, maxProtection);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        if(isOn()) {
            sb.append(name);
            sb.append(": protection=").append(protection);
        }
        return sb + "\n";
    }
}
