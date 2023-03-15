import controller.Controller;
import controller.NoteController;
import format.Format;
import format.FormatTXT;
import model.FilePersistent;
import model.RepositoryFile;
import validation.NoteValidatorTXT;
import view.ConsoleView;
import view.NoteCreator;
import view.NoteViewCreator;
import view.View;

public class Main {
    public static void main(String[] args) {
        Format format = new FormatTXT();
        FilePersistent filePersistent = new FilePersistent(format, "notes");
        RepositoryFile repositoryFile = new RepositoryFile(filePersistent);
        Controller controller = new NoteController(repositoryFile);
        NoteCreator creator = new NoteViewCreator(new ConsoleView(), new NoteValidatorTXT());
        View view = new ConsoleView(controller, creator);
        view.display();
    }
}
