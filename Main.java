import controller.NoteController;
import models.FailOperationNote;
import models.FailOperationTxt;
import models.NoteOperation;
import models.NoteOperatoinTxt;
import views.Button;
import views.View;
import views.ViewTerminal;


public class Main {
    public static void main(String[] args) {
        View view = new ViewTerminal();
        FailOperationNote fileOperation = new FailOperationTxt("C:\\Users\\Turbo Boost\\CodeCodeCode\\OOP\\OOP_6\\notes.txt");
        NoteOperation operation = new NoteOperatoinTxt(fileOperation);
        NoteController controller = new NoteController(operation);
        Button button = new Button(controller, view);
        button.run();
    }
}