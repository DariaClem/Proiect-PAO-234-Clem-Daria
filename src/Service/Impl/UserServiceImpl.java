package Service.Impl;

import Exceptions.InvalidCNPException;
import Exceptions.InvalidNameException;
import Exceptions.InvalidNameException;
import Exceptions.UserNotFoundException;
import Exceptions.UsersNotFoundException;
import Model.User;
import Service.UserService;
import Utils.AuditSingleton;

import java.util.*;

import static Validations.UserValidation.*;

public class UserServiceImpl implements UserService {

    List<User> users;

    @Override
    public void addUser(User user) throws Exception {
        boolean userValid = true;

        try {
            if (!CNPValidation(user.getCNP())) {
                throw new InvalidCNPException("CNP must have 13 digits!");
            }

            if (!nameValidation(user.getLastName(), user.getFirstName())) {
                throw new InvalidNameException("Last name and first name cannot have numbers!");
            }
        } catch (InvalidCNPException | InvalidNameException exception) {
            userValid = false;
            System.out.println(exception.getMessage());
        }

        if (userValid) {
            if (users == null) {
                users = new ArrayList<>();
            }
            users.add(user);
            AuditSingleton.INSTANCE.writeAction("Add user");
        }
    }

    @Override
    public void addUser(String[] user) throws Exception {
        boolean userValid = true;

        int id = Integer.parseInt(user[0]);
        String lastName = user[1];
        String firstName = user[2];
        String cnp = user[3];
        String address = user[4];

        try {
            if (!CNPValidation(cnp)) {
                throw new InvalidCNPException("CNP must have 13 digits!");
            }

            if (!nameValidation(lastName, firstName)) {
                throw new InvalidNameException("Last name and first name cannot have numbers!");
            }
        } catch (InvalidCNPException | InvalidNameException exception) {
            userValid = false;
            System.out.println(exception.getMessage());
        }

        if (userValid) {
            if (users == null) {
                users = new ArrayList<>();
            }
            users.add(new User(id, lastName, firstName, cnp, address));
            AuditSingleton.INSTANCE.writeAction("Add user");
        }
    }

    @Override
    public void deleteUser(User user) throws Exception {
        try {
            if (users == null)
                throw new UsersNotFoundException("Users list is empty");

            boolean found = false;
            for (User currentUser : users) {
                if (currentUser == user) {
                    found = true;
                    break;
                }
            }

            if (found) {
                users.remove(user);
                AuditSingleton.INSTANCE.writeAction("Delete user");
            } else
                throw new UserNotFoundException("The requested user was not found");

        } catch (UsersNotFoundException | UserNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void deleteUser(String lastName, String firstName) throws Exception {
        try {
            if (users == null)
                throw new UsersNotFoundException("Users list is empty");

            User foundUser = getUser(lastName, firstName);
            users.remove(foundUser);
            AuditSingleton.INSTANCE.writeAction("Delete user");

        } catch (UsersNotFoundException | UserNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public List<User> getUsers() throws Exception {
        try {
            if (users == null)
                throw new UsersNotFoundException("Users list is empty");
            Collections.sort(users);
        } catch (UsersNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
        AuditSingleton.INSTANCE.writeAction("Get user");
        return users;
    }

    @Override
    public User getUser(String lastName, String firstName) throws Exception {
        User foundUser = new User();
        boolean found = false;
        try {
            if (users == null) {
                throw new UsersNotFoundException("Users list is empty");
            }
            for (User user : users) {
                if (Objects.equals(user.getLastName(), lastName) && Objects.equals(user.getFirstName(), firstName)) {
                    foundUser = user;
                    found = true;
                }
            }
            if (!found) {
                throw new UserNotFoundException("The requested user was not found");
            }
        } catch (UsersNotFoundException | UserNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
        AuditSingleton.INSTANCE.writeAction("Get user by last name");
        return foundUser;
    }

    @Override
    public User getUser(int id) throws Exception {
        User foundUser = new User();
        boolean found = false;
        try {
            if (users == null) {
                throw new UsersNotFoundException("Users list is empty");
            }
            for (User user : users) {
                if (id == user.getId()) {
                    foundUser = user;
                    found = true;
                }
            }
            if (!found) {
                throw new UserNotFoundException("The requested user was not found");
            }
        } catch (UsersNotFoundException | UserNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
        AuditSingleton.INSTANCE.writeAction("Get user by id");
        return foundUser;
    }
}
