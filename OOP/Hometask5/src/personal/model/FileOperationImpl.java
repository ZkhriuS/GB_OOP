package personal.model;

import personal.format.Format;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileOperationImpl implements FileOperation {

    private final static String defaultFileName = "users.txt";
    private List<String> fileNames;

    public FileOperationImpl(List<String> fileNames) {
        this.fileNames = fileNames;
        for (String fileName: fileNames) {
            try (FileWriter writer = new FileWriter(fileName, true)) {
                writer.flush();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @Override
    public List<String> readAllLines() {
        String fileName = FileOperationImpl.getDefaultFileName();
        List<String> lines = new ArrayList<>();
            try {
                File file = new File(fileName);
                //создаем объект FileReader для объекта File
                FileReader fr = new FileReader(file);
                //создаем BufferedReader с существующего FileReader для построчного считывания
                BufferedReader reader = new BufferedReader(fr);
                // считаем сначала первую строку
                String line = reader.readLine();
                if (line != null) {
                    lines.add(line);
                }
                while (line != null) {
                    // считываем остальные строки в цикле
                    line = reader.readLine();
                    if (line != null) {
                        lines.add(line);
                    }
                }
                fr.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        return lines;
    }

    @Override
    public void saveAllLines(List<String> lines, Format format) {
        for (String fileName :fileNames) {
           if( Format.fileExtention(fileName).equals(format)) {
               try (FileWriter writer = new FileWriter(fileName, false)) {
                   for (String line : lines) {
                       // запись всей строки
                       writer.write(line);
                       // запись по символам
                       writer.append(format.getLineSeparator());
                   }
                   writer.flush();
               } catch (IOException ex) {
                   System.out.println(ex.getMessage());
               }
           }
        }
    }

    public static String getDefaultFileName() {
        return defaultFileName;
    }
}