package personal.views;

import personal.controllers.UserController;
import personal.model.User;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ViewUser {

    private UserController userController;

    public ViewUser(UserController userController) {
        this.userController = userController;
    }

    public void run(){
        Commands com = Commands.NONE;
        while (true) {
            String command = prompt("Введите команду: ");
            com = Commands.valueOf(command.toUpperCase(Locale.ROOT));
            try {
                switch (com) {
                    case CREATE:
                        createUser();
                        break;
                    case READ:
                        readUser();
                        break;
                    case LIST:
                        listUsers();
                        break;
                    case UPDATE:
                        updateUser();
                        break;
                    case DELETE:
                        deleteUser();
                        break;
                    case EXIT:
                        return;
                }
            } catch( Exception e){
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private void deleteUser() throws RuntimeException{
        try{
            User user = findUser();
            userController.deleteUser(user);
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    private void updateUser() throws RuntimeException{
        try{
            User user = findUser();
            System.out.println("Нажмите Enter, чтобы не редактировать поле");
            User updatedUser = setUserData();
            userController.updateUser(updatedUser, user);
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    private void listUsers(){
        try {
            List<User> userList = userController.listUser();
            for (User u : userList) {
                System.out.println(u);
            }
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    private void readUser() throws RuntimeException{
        try {
            User user = findUser();
            System.out.println(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private User findUser() throws RuntimeException{
        String id = prompt("Идентификатор пользователя: ");
        try {
            return userController.readUser(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void createUser() throws RuntimeException{
        try {
            userController.saveUser(setUserData());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private User setUserData(){
        String firstName = prompt("Имя: ");
        String lastName = prompt("Фамилия: ");
        String phone = prompt("Номер телефона: ");
        return new User(firstName, lastName, phone);
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }


}