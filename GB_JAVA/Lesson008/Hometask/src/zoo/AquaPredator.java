package zoo;

public abstract class AquaPredator extends Predator{
    public AquaPredator(String name) {
        super(name);
    }

    @Override
    public String feed() {
        return "fish";
    }
}
