package validation;

import model.ComplexNumber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorOperation implements Validator{
    protected Pattern operationPattern;
    protected String operation;
    protected String input;
    public ValidatorOperation(String input){
        operationPattern = Pattern.compile("[+\\-*/:()]");
        this.input = input;
    }

    public String getOperation() {
        return operation;
    }

    @Override
    public void validate() throws Exception {
        Matcher operationMatcher= operationPattern.matcher(input);
        if(!operationMatcher.find())
            throw new Exception("Введенное значение не является операцией!");
        operation = input;
    }
}
