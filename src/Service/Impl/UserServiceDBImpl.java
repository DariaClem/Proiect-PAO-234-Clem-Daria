package Service.Impl;

import Exceptions.UserNotFoundException;
import Exceptions.UsersNotFoundException;
import Model.User;
import Repositories.UserRepository;
import Service.UserServiceDB;

import java.sql.SQLException;
import java.util.List;

public class UserServiceDBImpl implements UserServiceDB {
    private UserRepository userRepository;

    public UserServiceDBImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserServiceDBImpl() {
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(User user) {
        try {
            userRepository.addUser(user);
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void addUser(String lastName, String firstName, String CNP, String address) {
        try {
            userRepository.addUser(lastName, firstName, CNP, address);
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public List<User> getAllUsers() {
        try {
            List<User> users = userRepository.getAllUsers();
            if (users.size() < 1)
                throw new UsersNotFoundException("Users list is empty.");
            return users;
        } catch (SQLException | UsersNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }

    @Override
    public User getUser(int id) {
        try {
            User user = userRepository.getUser(id);
            if (user == null)
                throw new UserNotFoundException("The requested user was not found.");
            return user;
        } catch (SQLException | UserNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }

    @Override
    public List<User> getUser(String lastName, String firstName) {
        try {
            List<User> users = userRepository.getUser(lastName, firstName);
            if (users.size() < 1)
                throw new UserNotFoundException("The requested user was not found.");
            return users;
        } catch (SQLException | UserNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }

    @Override
    public void editUser(String property, String newValue, String criterion, String value) {
        try {
            userRepository.editUser(property, newValue, criterion, value);
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void deleteAllUsers() {
        try {
            userRepository.deleteAllUsers();
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void deleteUser(int id) {
        try {
            userRepository.deleteUser(id);
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void deleteUser(String lastName, String firstName) {
        try {
            userRepository.deleteUser(lastName, firstName);
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
