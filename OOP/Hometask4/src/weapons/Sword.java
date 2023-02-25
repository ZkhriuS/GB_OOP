package weapons;

public class Sword implements Weapon {
    @Override
    public int damage() {
        return 70;
    }

    @Override
    public String toString() {
        return "Damage sword= " + damage();
    }
}