package Service;

import Model.User;

import java.util.List;

public interface UserService {
    void addUser(User user) throws Exception;
    void addUser(String[] user) throws Exception;

    void deleteUser(User user) throws Exception;

    void deleteUser(String lastName, String firstName) throws Exception;

    List<User> getUsers() throws Exception;

    User getUser(String lastName, String firstName) throws Exception;
    User getUser(int id) throws Exception;
}
