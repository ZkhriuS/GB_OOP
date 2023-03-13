import model.User;
import view.ConsoleView;
import view.View;

public class Main{
    public static void main(String[] args){
        User user = new User("Bob");
        View view = new ConsoleView(user);
        view.display();
    }
}