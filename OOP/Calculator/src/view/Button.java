package view;

import controller.Controller;

public abstract class Button implements Clickable{
    protected String symbol;
    protected String action;
    protected boolean active;
    public Button(String action, boolean active){
        this.action = action;
        this.active = active;
    }
    public void activate(){
        active = true;
    }
    public boolean isActive(){
        return active;
    }
    public String menu(){
        return action;
    };
}
