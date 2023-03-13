package model;

public class ConsoleReport implements Reportable{
    User user;
    public ConsoleReport(User user){
        this.user = user;
    }
    @Override
    public void report(){
        System.out.println("Report for user: " + info());
    }

    @Override
    public String info() {
        return user.getName();
    }
}
