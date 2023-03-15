package logger;

import view.View;

import java.io.IOException;
import java.util.logging.*;

public class ConsoleViewLog extends ViewLog{
    public ConsoleViewLog(View view){
        this.view = view;
        logger = Logger.getLogger(View.class.getName());
        setParams();
    }

    @Override
    public void display() {
        log("Запущено консольное приложение...");
        view.display();
        log("Работа с консольным приложением завершена.");
    }

    @Override
    public String prompt(String message) {
        return view.prompt(message);
    }
}
