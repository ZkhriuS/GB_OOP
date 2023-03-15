package view;

import model.Notable;
import model.Note;
import validation.NoteValidator;
import validation.Validator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class NoteViewCreator extends Note implements NoteCreator{
    private View view;
    private NoteValidator validator;
    public NoteViewCreator(View view, NoteValidator validator){
        this.view = view;
        this.validator = validator;
    }
    @Override
    public Notable create() throws Exception{
        this.setTitle(view.prompt("Введите заголовок: "));
        this.setId("0");
        this.setDate(LocalDateTime.now().toString().replace('T', ','));
        buildText();
        validator.setNote(this);
        validator.validate();
        return this;
    }

    private void buildText() {
        StringBuilder text = new StringBuilder(view.prompt("Чтобы закончить ввод текста добавьте конце строки '$end$'\nВведите текст:\n"));
        while(text.length()<5 || !text.substring(text.length()-5).equals("$end$")){
            text.append("\n").append(view.prompt(""));
        }
        this.setText(text.toString().substring(0, text.length()-5));
    }

    @Override
    public Notable parse(String data) {
        setId(data.split(comments[0])[1].split(comments[1])[0]);
        setDate(data.split(comments[1])[1].split(comments[2])[0]);
        setTitle(data.split(comments[2])[1].split(comments[3])[0]);
        setText(data.split(comments[3])[1]);
        return this;
    }

    @Override
    public Notable setTitle() {
        this.setTitle(view.prompt("Введите новый заголовок: "));
        this.setDate(LocalDateTime.now().toString().replace('T', ','));
        return this;
    }

    @Override
    public Notable setText() {
        buildText();
        this.setDate(LocalDateTime.now().toString().replace('T', ','));
        return this;
    }
}
