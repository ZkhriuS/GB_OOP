package personal.model;

import personal.format.Format;

import java.util.List;

public interface FileOperation {
    List<String> readAllLines();

    void saveAllLines(List<String> lines, Format format);
}