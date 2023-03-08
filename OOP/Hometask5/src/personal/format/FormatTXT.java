package personal.format;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class FormatTXT implements Format{
    private final String separator;
    private final String lineSeparator;
    public FormatTXT(){
        separator = ",";
        lineSeparator = "\n";
    }

    @Override
    public List<String> split(String data){
        return Arrays.asList(data.split(separator));
    }

    @Override
    public String toString(List<String> data) {
        StringBuilder result = new StringBuilder();
        for(String str : data){
            result.append(separator);
            result.append(str);
        }
        result.deleteCharAt(0);
        return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormatTXT formatTXT = (FormatTXT) o;
        return separator.equals(formatTXT.separator) && lineSeparator.equals(formatTXT.lineSeparator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(separator, lineSeparator);
    }

    @Override
    public String getLineSeparator() {
        return lineSeparator;
    }
}
