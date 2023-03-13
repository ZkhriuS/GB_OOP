package view;

public class OperationButton extends Button{
    public OperationButton(String action, boolean active) {
        super(action, active);
    }

    @Override
    public void click() {
        active = false;
    }
}
