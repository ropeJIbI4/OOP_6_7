package views;

import java.util.Scanner;

import models.Note;

public class ViewTerminal implements View {
        
    public ViewTerminal() {
    }

    @Override
    public String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    @Override
    public Note setNote(boolean forUpdate) {
        String idString = null;
        if (forUpdate) {
            idString = prompt("Идентификатор записи: ");
        }
        String data = prompt("Дата: ");
        String header = prompt("Заголовок: ");
        String text = prompt("Содержание: ");
        if (forUpdate) {
            return new Note(idString, data, header,text);
        }
        return new Note(data, header,text);
    }
}