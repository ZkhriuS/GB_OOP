package personal.model;

import personal.format.Format;

import java.util.ArrayList;
import java.util.List;

public class RepositoryFile implements Repository {
    private List<UserMapper> mappers;
    private FileOperation fileOperation;

    public RepositoryFile(FileOperation fileOperation, List<Format> formats) {
        this.fileOperation = fileOperation;
        mappers = new ArrayList<>();
        for (Format format:formats) {
            mappers.add(new UserMapper(format));
        }
    }
    public void saveAllFormats(List<User> users){
        for (UserMapper mapper: mappers) {
            fileOperation.saveAllLines(mapper.usersToLines(users), mapper.getFormat());
        }
    }

    @Override
    public void deleteUser(User user){
        List<User> users = getAllUsers();
        users.remove(user);
        saveAllFormats(users);
    }

    @Override
    public List<User> getAllUsers() {
        List<String> lines = fileOperation.readAllLines();
        UserMapper mapper = new UserMapper(Format.fileExtention(FileOperationImpl.getDefaultFileName()));
        List<User> users = new ArrayList<>();
        for (String line : lines) {
            users.add(mapper.map(line));
        }
        return users;
    }

    @Override
    public String createUser(User user) {
        List<User> users = getAllUsers();
        int newId = idIncrement();
        String id = String.format("%d", newId);
        user.setId(id);
        users.add(user);
        saveAllFormats(users);
        return id;
    }

    @Override
    public String updateUser(User user, String id) {
        List<User> users = getAllUsers();
        for(User u : users){
            if(u.getId().equals(id)){
                u.setFirstName(user.getFirstName());
                u.setLastName(user.getLastName());
                u.setPhone(user.getPhone());
            }
        }
        saveAllFormats(users);
        return id;
    }

    @Override
    public int idIncrement() {
        List<User> users = getAllUsers();
        int max = 0;
        for (User item : users) {
            int id = Integer.parseInt(item.getId());
            if (max < id){
                max = id;
            }
        }
        return max + 1;
    }
}