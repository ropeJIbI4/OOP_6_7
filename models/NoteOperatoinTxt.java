package models;

import java.util.ArrayList;
import java.util.List;



public class NoteOperatoinTxt implements NoteOperation {

    private NoteMapper mapper = new NoteMapper();
    private FailOperationNote fileOperation;

    public NoteOperatoinTxt(FailOperationNote fileOperation) {
        this.fileOperation = fileOperation;
    }

    @Override
    public List<Note> getAllNote() {
        List<String> lines = fileOperation.readAllLines();
        List<Note> notes = new ArrayList<>();
        for (String line : lines) {
            notes.add(mapper.map(line));
        }
        return notes;
    }

    @Override
    public String CreateNote(Note note) {
        List<Note> notes = getAllNote();
        int max = 0;
        for (Note item : notes) {
            int id = Integer.parseInt(item.getId());
            if (max < id) {
                max = id;
            }
        }
        int newId = max + 1;
        String id = String.format("%d", newId);
        note.setId(id);
        notes.add(note);
        saveNotes(notes);
        return id;
    }

    private void saveNotes(List<Note> notes) {
        List<String> lines = new ArrayList<>();
        for (Note item : notes) {
            lines.add(mapper.map(item));
        }
        fileOperation.saveAllLines(lines);
    }

    @Override
    public Note updateNote(Note note) throws Exception {
        List<Note> notes = getAllNote();
        Note foundedNote = findNoteById(notes, note.getId());
        foundedNote.setData(note.getData());
        foundedNote.setHeader(note.getHeader());
        foundedNote.setText(note.getText());
        saveNotes(notes);
        return foundedNote;
    }

    private Note findNoteById(List<Note> notes, String noteId) throws Exception {
        for (Note note : notes) {
            if (note.getId().equals(noteId)) {
                return note;
            }
        }
        throw new Exception("Запись не найдена");
    }

    @Override
    public Note readNote(String noteId) throws Exception {
        List<Note> notes = getAllNote();
        return findNoteById(notes, noteId);
    }

    @Override
    public void deleteNote(String deleteId) throws Exception {
        List<Note> notes = getAllNote();
        Note deleteNote = findNoteById(notes, deleteId);
        notes.remove(deleteNote);
        saveNotes(notes);
    }

}