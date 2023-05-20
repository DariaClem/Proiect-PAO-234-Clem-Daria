package Service;

import Model.User;
import java.util.List;

public interface UserServiceDB {
    public void addUser(User user);

    public void addUser(String lastName, String firstName, String CNP, String address);

    public List<User> getAllUsers();

    public User getUser(int id);

    public List<User> getUser(String lastName, String firstName);

    public void editUser(String property, String newValue, String criterion, String value);

    public void deleteAllUsers();

    public void deleteUser(int id);

    public void deleteUser(String lastName, String firstName);
}
