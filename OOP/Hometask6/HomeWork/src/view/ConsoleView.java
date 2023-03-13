package view;

import model.ConsoleReport;
import model.User;
import persister.ConsolePersister;

public class ConsoleView implements View{
    private ConsoleReport reporter;
    private ConsolePersister persister;
    public ConsoleView(User user){
        reporter = new ConsoleReport(user);
        persister = new ConsolePersister(reporter);
    }
    @Override
    public void display() {
        reporter.report();
        persister.save();
    }
}
