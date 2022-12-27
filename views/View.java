package views;

import models.Note;

public interface View {
     String prompt(String message);
     Note setNote(boolean forUpdate);
}