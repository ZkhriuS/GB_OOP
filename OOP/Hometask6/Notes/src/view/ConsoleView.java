package view;

import controller.Controller;
import controller.NoteController;
import model.Notable;
import model.Note;
import validation.Validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleView implements View{
    private Controller controller;
    private NoteCreator creator;
    public ConsoleView(){

    }
    public ConsoleView(Controller controller, NoteCreator creator){
        this.controller = controller;
        this.creator = creator;
    }
    @Override
    public void display() {
        while (true) {
            menu();
            String command = prompt("Введите команду: ");
            Commands com = Commands.valueOf(command.toUpperCase(Locale.ROOT));
            try {
                switch (com) {
                    case ADD:
                        addNote();
                        break;
                    case READ:
                        readNote();
                        break;
                    case ALL:
                        listNotes();
                        break;
                    case UPDATE:
                        updateNote();
                        break;
                    case DELETE:
                        deleteNote();
                        break;
                    case EXIT:
                        return;
                    default: throw new Exception("Неверное имя команды");
                }
            } catch( Exception e){
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private void deleteNote() throws Exception{
        System.out.println(controller.deleteNote(creator.parse(readNote())));
    }

    private void updateNote() throws Exception{
        Notable note = creator.parse(readNote());
        System.out.println("1. title\n2. text");
        String command = prompt("Введите команду для обновления данных: ").toLowerCase(Locale.ROOT);
        if(command.equals("title"))
        {
            note=creator.setTitle();
        }
        else if(command.equals("text")){
            note=creator.setText();
        }
        System.out.println(controller.updateNote(note));
        System.out.println(controller.getNote(note.getId()));
    }

    private void listNotes() {
        System.out.println(controller.list());
    }

    private String readNote() {
        String output = controller.getNote(prompt("Введите ID записи: "));
        System.out.println(output);
        return output;
    }

    private void addNote() throws Exception{
        Notable note = creator.create();
        System.out.println(controller.createNote(note));
        controller.getNote(note.getId());
    }

    private void menu(){
        int i=1;
        for(Commands command : Commands.values()){
            System.out.println(i++ +". "+command);
        }
    }

    @Override
    public String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
