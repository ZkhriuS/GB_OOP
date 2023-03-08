package personal.controllers;

import personal.model.Repository;
import personal.model.User;
import personal.validation.ValidatorUser;

import java.util.List;

public class UserController {
    private final Repository repository;
    private ValidatorUser validator;

    public UserController(Repository repository) {
        this.repository = repository;
        validator = new ValidatorUser();
    }

    public void saveUser(User user) throws Exception{
        try {
            validator.setUser(user);
            validator.validate();
            repository.createUser(user);
        } catch(Exception e){
            throw new Exception(e);
        }
    }

    public void updateUser(User user, User nextUser) throws Exception {
        try {
            validator.setUser(nextUser);
            validator.validate();
            if (nextUser.getFirstName().equals(""))
                nextUser.setFirstName(user.getFirstName());
            if (nextUser.getLastName().equals(""))
                nextUser.setLastName(user.getLastName());
            if (nextUser.getPhone().equals(""))
                nextUser.setPhone(user.getPhone());
            repository.updateUser(nextUser, user.getId());
        } catch(Exception e){
            throw new Exception(e);
        }
    }

    public User readUser(String userId) throws Exception {
        List<User> users = repository.getAllUsers();
        for (User user : users) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }
        throw new Exception("User not found");
    }

    public List<User> listUser (){
        return repository.getAllUsers();
    }

    public void deleteUser(User user){
        repository.deleteUser(user);
    }
}