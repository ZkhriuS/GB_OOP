package armour;

public class Helmet extends Armour{
    private double abrasion;
    public Helmet(int protection) {
        super(protection);
        name = "шлем";
        abrasion = 0.93;
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
        minProtection=3;
        maxProtection=20;
        return Armour.generateProtection();
    }

}
