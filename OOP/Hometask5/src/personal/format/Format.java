package personal.format;

import java.util.List;

public interface Format {
    List<String> split(String data);
    String toString(List<String> data);
    String getLineSeparator();
    static Format fileExtention(String filename){
        String extension = filename.split("\\.")[1];
        if (extension.equals("txt"))
            return new FormatTXT();
        if (extension.equals("csv"))
            return new FormatCSV();
        return null;
    }
}
