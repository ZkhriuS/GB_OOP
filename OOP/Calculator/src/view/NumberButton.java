package view;

public class NumberButton extends Button{
    public NumberButton(String action, boolean active) {
        super(action, active);
    }

    @Override
    public void click() {
        active = false;
    }
}
