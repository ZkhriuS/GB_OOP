package personal;

import personal.controllers.UserController;
import personal.format.Format;
import personal.format.FormatCSV;
import personal.format.FormatTXT;
import personal.model.FileOperation;
import personal.model.FileOperationImpl;
import personal.model.Repository;
import personal.model.RepositoryFile;
import personal.views.ViewUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> fileNames = new ArrayList<>(Arrays.asList("users.txt", "users.csv"));
        try {
            List<Format> formats = fileExtensions(fileNames);
            FileOperation fileOperation = new FileOperationImpl(fileNames);
            Repository repository = new RepositoryFile(fileOperation, formats);
            UserController controller = new UserController(repository);
            ViewUser view = new ViewUser(controller);
            view.run();
        } catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private static List<Format> fileExtensions(List<String> fileNames) throws RuntimeException{
        List<Format> formats = new ArrayList<>();
        for(String name : fileNames) {
            formats.add(Format.fileExtention(name));
        }
        if(formats.isEmpty())
            throw new RuntimeException("Неизвестный формат файла");
        return formats;
    }
}