package view;

public class StateButton extends Button{
    private boolean state;

    public StateButton(String action, boolean active) {
        super(action, active);
        state = false;
    }

    public boolean getState() {
        return state;
    }

    @Override
    public void click() {
        state =! state;
    }
}
