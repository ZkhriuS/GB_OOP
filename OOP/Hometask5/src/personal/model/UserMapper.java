package personal.model;

import personal.format.Format;
import personal.validation.Validator;
import personal.validation.ValidatorFormat;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    private Format format;
    public UserMapper(Format format){
        this.format = format;
    }
    public String map(User user) {
        return format.toString(user.dataList());
    }

    public User map(String line) {
        List<String> lines = format.split(line);
        return new User(lines.get(0), lines.get(1), lines.get(2), lines.get(3));
    }

    public List<String> usersToLines(List<User> users){
        List<String> lines = new ArrayList<>();
        for (User item: users) {
            lines.add(map(item));
        }
        return lines;
    }

    public Format getFormat() {
        return format;
    }
}