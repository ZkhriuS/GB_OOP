package armour;

public class Hauberk extends Armour{
    private double abrasion;
    public Hauberk(int protection) {
        super(protection);
        name = "кольчуга";
        minProtection=20;
        maxProtection=35;
        abrasion = 0.86;
    }

    @Override
    public int activate(int damage) {
        protection = (int) (abrasion * protection);
        if(protection < damage)
            return damage - protection;
        else
            return 0;
    }

    public static int generateProtection(){
        minProtection=20;
        maxProtection=35;
        return Armour.generateProtection();
    }
}
