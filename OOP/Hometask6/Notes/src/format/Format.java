package format;

import model.Notable;
import model.Note;

import java.util.List;

public interface Format {
    String allToFormat(List<Note> notes);
    List<Note> allFromFormat(String data);
    String toFormat(Note note);
    Note fromFormat(String data);
    String getExtension();
}
