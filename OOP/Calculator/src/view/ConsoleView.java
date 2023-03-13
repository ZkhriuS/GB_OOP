package view;

import controller.ComplexController;
import controller.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleView implements View{
    private List<Button> buttonList;
    private Controller controller;
    private String expression;

    public ConsoleView(Controller controller){
        this.controller = controller;
        buttonList = new ArrayList<>();
        buttonList.add(new NumberButton("number (Ввести комплексное число)", true));
        buttonList.add(new OperationButton("operation (Ввести операцию)", false));
        buttonList.add(new OperationButton("calculate (Рассчитать)", false));
        buttonList.add(new StateButton("exit (Выйти)", true));
        expression="";
    }
    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
    @Override
    public void display() {
        Commands com = Commands.NONE;
        while (true) {
            System.out.println(expression);
            menu();
            String command = prompt("Введите команду: ");
            com = Commands.valueOf(command.toUpperCase(Locale.ROOT));
            try {
                switch (com) {
                    case NUMBER:
                        addNumber();
                        break;
                    case OPERATION:
                        addOperation();
                        break;
                    case CALCULATE:
                        calculate();
                        break;
                    case EXIT:
                        return;
                }
            } catch( Exception e){
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }
    private void addNumber() throws Exception{
        expression +=((ComplexController)controller).addComplexNumber(prompt("Введите комплексное число: "));
        for (Button b: buttonList) {
            if(b instanceof NumberButton)
                b.click();
            else
                b.activate();
        }
    }
    private void addOperation() throws Exception{
        expression+=((ComplexController)controller).addOperation(prompt("Введите операцию: "));
        for (Button b: buttonList) {
            if(b instanceof OperationButton)
                b.click();
            else
                b.activate();
        }
    }

    private void calculate(){
        System.out.println("= " + controller.calculate());
        expression = "";
        for (Button b: buttonList) {
            if(b instanceof OperationButton)
                b.click();
            else
                b.activate();
        }
    }

    private void menu(){
        int i=1;
        for(Button button : buttonList){
            if(button.isActive())
                System.out.println(i++ +". "+button.menu());
        }
    }
}
