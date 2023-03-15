package controller;

import model.Notable;

public interface Controller {
    String createNote(Notable note);
    String updateNote(Notable note);
    String deleteNote(Notable note);
    String getNote(String id);
    String list();
}
