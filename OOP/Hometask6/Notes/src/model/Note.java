package model;

import java.util.Objects;

public class Note implements Notable {
    protected static final String[] comments = {"\nID", "\nДата,время: ", "\nЗаголовок \"", "\"\nТекст: "};
    private String id;
    private String title;
    private String text;
    private String date;

    public Note(){

    }

    public Note(Note other){
        this.id= other.getId();
        this.title = other.getTitle();
        this.date = other.getDate();
        this.text = other.getText();
    }

    public Note(String title){
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Note)) return false;
        Note note = (Note) o;
        return id.equals(note.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, text, date);
    }

    @Override
    public String toString() {
        return comments[0]+id+
                comments[1]+date+
                comments[2]+title+
                comments[3]+text;
    }
}
