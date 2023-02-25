package armour;

public class Shield extends Armour implements Removable{

    private double abrasion;
    public Shield(int protection){
        super(protection);
        name = "щит";
        minProtection=10;
        maxProtection=30;
        abrasion = 0.73;
    }

    @Override
    public int activate(int damage) {
        if(isOn()) {
            protection = (int) (abrasion * protection);
            if (protection < damage)
                return damage - protection;
            else
                return 0;
        }
        else
            return damage;
    }

    @Override
    public String takeOff() {
        on = false;
        return "снимает " + name + " ";
    }

    @Override
    public String putOn() {
        on = true;
        return "держит " + name + " ";
    }

    public static int generateProtection(){
        minProtection=10;
        maxProtection=30;
        return Armour.generateProtection();
    }

}
