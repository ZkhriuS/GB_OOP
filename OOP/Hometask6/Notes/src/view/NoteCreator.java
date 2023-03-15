package view;

import model.Notable;
import model.Note;

public interface NoteCreator extends Notable {
    Notable create() throws Exception;
    Notable parse(String data);
    Notable setTitle();
    Notable setText();
}
