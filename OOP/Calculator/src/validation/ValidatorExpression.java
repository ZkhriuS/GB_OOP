package validation;

import model.Expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorExpression implements Validator{
    protected Pattern numberPattern;
    protected Pattern operationPattern;
    private Expression expression;
    private String input;
    public ValidatorExpression(String input, Expression expression) {
        numberPattern = Pattern.compile("([+-]?\\d+)?([+-]\\d+i)?");
        operationPattern = Pattern.compile("[+\\-*/:()]");
        this.expression = expression;
        this.input = input;
    }

    @Override
    public void validate() throws Exception {

    }
}
