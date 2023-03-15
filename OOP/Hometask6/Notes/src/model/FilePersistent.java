package model;

import format.Format;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FilePersistent implements Persistable<Notable> {
    private String filePath;
    private Format format;

    public FilePersistent(Format format) {
        this.format = format;
    }

    public FilePersistent(Format format, String filename) {
        this(format);
        filePath = filename + "." + format.getExtension();
    }

    public String read(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder result = new StringBuilder();
            while (reader.ready()) {
                result.append(reader.readLine()).append("\n");
            }
            return result.toString();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не создан!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла!");
            e.printStackTrace();
        }
        return null;
    }

    public void write(File file, String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(data);
        } catch (FileNotFoundException e) {
            throw new NullPointerException();
        } catch (IOException e) {
            System.out.println("Ошибка записи файла!");
            e.printStackTrace();
        }
    }

    public List<Notable> getData() {
        try {
            File file = new File(filePath);
            return new ArrayList<>(format.allFromFormat(read(file)));
        } catch (NullPointerException e) {
            System.out.println("Неверно указан путь к файлу!");
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public void save(List<Notable> data) {
        try {
            File file = new File(filePath);
            List<Note> notes = new ArrayList<>();
            for (Notable note : data) {
                notes.add((Note) note);
            }
            String result = format.allToFormat(notes);
            write(file, result);
        } catch (NullPointerException e) {
            System.out.println("Неверно указан путь к файлу!");
            e.printStackTrace();
        }

    }
}
