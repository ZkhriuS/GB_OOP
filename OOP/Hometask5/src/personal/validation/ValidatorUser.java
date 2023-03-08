package personal.validation;

import personal.model.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUser implements Validator{
    protected Pattern namePattern;
    protected Pattern phonePattern;
    private User user;
    public ValidatorUser() {
        namePattern = Pattern.compile("^\\p{javaUpperCase}\\p{javaLowerCase}+$");
        phonePattern = Pattern.compile("^((8|\\+375)[\\- ]?)?(\\(?\\d{2}\\)?[\\- ]?)?\\d{3}[\\- ]?\\d{2}[\\- ]?\\d{2}$");
        this.user = user;
    }
    public void setUser(User user){
        this.user = user;
    }
    @Override
    public void validate() throws Exception {
        Matcher firstNameMatcher= namePattern.matcher(user.getFirstName());
        Matcher lastNameMatcher= namePattern.matcher(user.getLastName());
        Matcher phoneMatcher = phonePattern.matcher(user.getPhone());
        if(!firstNameMatcher.find())
            throw new Exception("Такое имя не допустимо!");
        if(!lastNameMatcher.find())
            throw new Exception("Такая фамилия не допустима");
        if(!phoneMatcher.find())
            throw new Exception("Такой номер телефона не допустим");
    }
}
