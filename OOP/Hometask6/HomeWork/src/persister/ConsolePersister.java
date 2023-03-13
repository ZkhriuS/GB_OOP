package persister;

import model.Reportable;

public class ConsolePersister implements Persistable{
    private Reportable reporter;

    public ConsolePersister(Reportable reporter){
        this.reporter = reporter;
    }

    public void save(){
        System.out.println("Save user: " + reporter.info());
    }
}