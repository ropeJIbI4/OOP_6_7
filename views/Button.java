package views;
import java.util.List;

import controller.NoteController;
import models.Note;

public class Button {

    private NoteController noteController;
    private View view;   

    public Button(NoteController noteController, View view) {
        this.noteController = noteController;
        this.view = view;
    }

    public void run() {
        Commands com = Commands.NONE;

        while (true) {
            String command = view.prompt("Введите команду: ");
            try {
                com = Commands.valueOf(command);
            } catch (IllegalArgumentException e) {
                System.out.println("Неопознанная команда");
            }
            if (com == Commands.EXIT)
                return;
            try {
                switch (com) {

                    case CREATE:
                        Note note = view.setNote(false);
                        noteController.saveNote(note);
                        break;
                    case READ:
                        String id = view.prompt("Идентификатор записи: ");
                        Note readNote = noteController.readNote(id);
                        System.out.println(readNote);
                        break;
                    case LIST:
                        List<Note> noteList = noteController.readNoteList();
                        for (Note item : noteList) {
                            System.out.println(item);
                            System.out.println();
                        }
                        break;
                    case UPDATE:
                        Note updateNote = view.setNote(true);
                        noteController.updateNote(updateNote);
                        break;
                    case DELETE:
                        String deleteId = view.prompt("Идентификатор записи: ");
                        noteController.deleteNote(deleteId);
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}