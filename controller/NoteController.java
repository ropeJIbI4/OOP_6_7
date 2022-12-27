package controller;

import java.util.List;

import models.Note;
import models.NoteOperation;

public class NoteController {

    private NoteOperation noteOperation;

    public NoteController(NoteOperation noteOperation) {
        this.noteOperation = noteOperation;
    }

    public void saveNote(Note note) throws Exception {
        validateNote(note);
        noteOperation.CreateNote(note);
    }

    public List<Note> readNoteList() {
        return noteOperation.getAllNote();
    }

    public Note readNote(String noteId) throws Exception {
        return noteOperation.readNote(noteId);
    }

    public Note updateNote(Note note) throws Exception {
        validateNote(note);
        return noteOperation.updateNote(note);
    }

    public void deleteNote(String deleteId) throws Exception {
        noteOperation.deleteNote(deleteId);
    }

    private void validateNote(Note note) throws Exception {
        if (note.getData().isEmpty()) {
            throw new Exception("Отсутствует дата");
        }
        if (note.getHeader().isEmpty()) {
            throw new Exception("Отсутствует заголовок");
        }
        if (note.getText().isEmpty()) {
            throw new Exception("Отсутствует содержание");
        }
    }
}