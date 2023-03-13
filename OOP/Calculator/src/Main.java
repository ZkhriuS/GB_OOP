import controller.ComplexController;
import model.ComplexOperation;
import view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        try {
            ComplexOperation calculator = new ComplexOperation();
            ComplexController controller = new ComplexController(calculator);
            ConsoleView view = new ConsoleView(controller);
            view.display();
        } catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
