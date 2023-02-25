package armour;

public class SuperShield extends Shield{
    public SuperShield(int protection) {
        super(protection);
        name = "супер щит";

    }
    public static int generateProtection(){
        minProtection = 10;
        maxProtection = 30;
        return Armour.generateProtection();
    }
    @Override
    public int activate(int damage) {
        if(isOn()) {
            if (protection < damage)
                return damage - protection;
            else
                return 0;
        }
        else
            return damage;
    }
}
