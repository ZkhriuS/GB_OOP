package format;

import model.Notable;
import model.Note;

import java.util.ArrayList;
import java.util.List;

public class FormatTXT implements Format{
    private final String extension;
    private final String format;
    private final String regex;

    public String getRegex() {
        return regex;
    }

    public FormatTXT(){
        extension = "txt";
        format = "%s$ [%s].\n\t\t\t%s\n%s";
        regex = "(\\$ \\[)|(\\]\\.\n\t{3})|(\n)";
    }
    @Override
    public String toFormat(Note note) {
        return String.format(format, note.getId(), note.getDate(), note.getTitle(), note.getText());
    }

    @Override
    public Note fromFormat(String data) {
        String[] model = data.split(regex, 4);
        if(model.length<4)
            return null;
        Note note = new Note(model[ModelTXT.TITLE.ordinal()]);
        note.setId(model[ModelTXT.ID.ordinal()]);
        note.setText(model[ModelTXT.TEXT.ordinal()]);
        note.setDate(model[ModelTXT.DATE.ordinal()]);
        return note;
    }

    @Override
    public String getExtension() {
        return extension;
    }

    @Override
    public String allToFormat(List<Note> notes) {
        StringBuilder data = new StringBuilder();
        for (Note note:notes) {
            data.append(toFormat(note)).append("\n\n");
        }
        return data.toString();
    }

    @Override
    public List<Note> allFromFormat(String data) {
        List<Note> notes = new ArrayList<>();
        String[] strNotes = data.split("\n\n+");
        for (String s: strNotes) {
            Note note = fromFormat(s);
            if(note!=null)
                notes.add(note);
        }
        return notes;
    }
}
