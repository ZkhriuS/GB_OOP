package personal.model;

import java.util.List;

public interface Repository {
    List<User> getAllUsers();
    String createUser(User user);
    String updateUser(User user, String id);
    void deleteUser(User user);
    int idIncrement();
}