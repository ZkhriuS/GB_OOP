package personal.format;

import java.util.Arrays;
import java.util.List;

public class FormatCSV implements Format{
    private final String separator;
    private final String lineSeparator;
    public FormatCSV(){
        separator = ";";
        lineSeparator = "\n\n";
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
        FormatCSV formatCSV = (FormatCSV) o;
        return separator.equals(formatCSV.separator) && lineSeparator.equals(formatCSV.lineSeparator);
    }

    @Override
    public String getLineSeparator() {
        return lineSeparator;
    }
}
