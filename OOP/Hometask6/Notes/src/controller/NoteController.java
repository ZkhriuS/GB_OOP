package controller;


import model.Notable;
import model.Note;
import model.Repository;

import java.util.List;

public class NoteController implements Controller{
    private Repository<Notable> repository;


    public NoteController(Repository<Notable> repository){
        this.repository = repository;
    }

    public String createNote(Notable note){
        String id = repository.create(note);
        return "Новая запись с ID"+ id +" успешно создана!";
    }
    public String updateNote(Notable note){
        String id = repository.update(note);
        if(id==null)
            return "Запись не найдена!";
        return "Запись с ID"+id+" успешно обновлена!";
    }

    public String deleteNote(Notable note){
        String id = repository.delete(note);
        if(id==null)
            return "Запись не найдена!";
        return "Запись с ID"+id+" успешно удалена!";
    }

    public String getNote(String id){
        List<Notable> notes = repository.readAll();
        for (Notable note:notes) {
            if(note.getId().equals(id)){
                return note.toString();
            }
        }
        return "Запись не найдена!";
    }

    public String list(){
        List<Notable> notes = repository.readAll();
        if(notes.isEmpty())
            return "Не создано ни одной записи!";
        StringBuilder result = new StringBuilder();
        for (Notable note:notes) {
            result.append(note).append("\n");
        }
        return result.toString();
    }

}
