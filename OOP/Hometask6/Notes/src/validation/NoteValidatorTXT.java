package validation;

import format.FormatTXT;
import model.Note;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NoteValidatorTXT implements NoteValidator{
    private FormatTXT format;
    private Pattern pattern;
    private Note note;
    public  NoteValidatorTXT(){
        format = new FormatTXT();
        pattern = Pattern.compile(format.getRegex());
    }

    @Override
    public void setNote(Note note) {
        this.note = note;
    }

    @Override
    public void validate() throws Exception {
        if(validateNote(note.getTitle()))
            throw new Exception("Заголовок содержит запрещенные символы: "+format.getRegex());
    }

    public boolean validateNote(String field){
        Matcher matcher = pattern.matcher(field);
        return matcher.find();

    }
}
