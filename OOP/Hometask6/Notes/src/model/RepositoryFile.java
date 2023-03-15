package model;

import java.util.ArrayList;
import java.util.List;

public class RepositoryFile implements Repository<Notable>{
    private List<Notable> notes;
    private final FilePersistent file;

    public RepositoryFile(FilePersistent file){
        this.file = file;
        notes = new ArrayList<>();
    }

    @Override
    public Notable find(Notable note){
        for (Notable item:notes) {
            if(item.getId().equals(note.getId()))
            {
                return item;
            }
        }
        return note;
    }

    @Override
    public String create(Notable note) {
        note.setId(String.valueOf(idIncrement()));
        notes = readAll();
        if (notes==null)
            notes= new ArrayList<>();
        notes.add(note);
        file.save(notes);
        return note.getId();
    }

    @Override
    public List<Notable> readAll() {
        return file.getData();
    }

    @Override
    public String update(Notable note) {
        notes=readAll();
        String id = null;
        List<Notable> updatedNotes = new ArrayList<>();
        for (Notable item:notes) {
            if(item.getId().equals(note.getId()))
            {
                id = item.getId();
                item=note;
                item.setId(id);
            }
            updatedNotes.add(item);
        }
        file.save(updatedNotes);
        return id;
    }

    @Override
    public String delete(Notable note) {
        notes = readAll();
        notes.remove(note);
        file.save(notes);
        return note.getId();
    }

    @Override
    public int idIncrement() {
        int max = 0;
        for (Notable item : notes) {
            int id = Integer.parseInt(item.getId());
            if (max < id){
                max = id;
            }
        }
        return max + 1;
    }
}
