package validation;

import model.ComplexNumber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorComplexNumber implements Validator{
    protected Pattern numberPattern;
    protected ComplexNumber number;
    protected String input;
    public ValidatorComplexNumber(String input){
        numberPattern = Pattern.compile("([+-]?\\d+)?([+-]?\\d+i)?");
        this.input = input;
        number = new ComplexNumber();
    }

    public ComplexNumber getNumber() {
        return number;
    }

    @Override
    public void validate() throws Exception {
        Matcher numberMatcher= numberPattern.matcher(input);
        if(!numberMatcher.find())
            throw new Exception("Введенное значение не является комплексным числом!");
        String[] parts = input.split("[+-]", 0);
        if(parts.length==1){
            if(parts[0].contains("i")) {
                number.setRe(0);
                number.setIm(Double.parseDouble(input.substring(0, input.length() - 1)));
            } else{
                number.setRe(Double.parseDouble(input));
                number.setIm(0);
            }
        } else if(parts.length>2){
            number.setRe(Double.parseDouble(input.charAt(0)+parts[1]));
            number.setIm(Double.parseDouble(input.charAt(parts[1].length()+1)+parts[2].substring(0, parts[2].length() - 1)));
        }
        else if(!parts[0].equals("")){
            number.setRe(Double.parseDouble(parts[0]));
            number.setIm(Double.parseDouble(input.charAt(parts[0].length())+parts[1].substring(0, parts[1].length() - 1)));
        } else{
            if(parts[1].contains("i")) {
                number.setRe(0);
                number.setIm(Double.parseDouble(input.substring(0, input.length() - 1)));
            } else{
                number.setRe(Double.parseDouble(input));
                number.setIm(0);
            }
        }
    }
}
