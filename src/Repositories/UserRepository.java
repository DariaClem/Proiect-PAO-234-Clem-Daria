package Repositories;

import Configuration.DatabaseConfiguration;
import Constants.UsersConstants;
import Exceptions.UserNotFoundException;
import Model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private final DatabaseConfiguration databaseConfiguration;

    public UserRepository(DatabaseConfiguration databaseConfiguration) {
        this.databaseConfiguration = databaseConfiguration;
    }

    private User createUser(ResultSet resultSet) throws SQLException, UserNotFoundException {
        User user = new User(resultSet.getInt("id"),
                resultSet.getString("lastName"),
                resultSet.getString("firstName"),
                resultSet.getString("CNP"),
                resultSet.getString("address"));
        return user;
    }

    private List<User> extractData(ResultSet resultSet) throws SQLException {
        List<User> users = new ArrayList<>();

        while (resultSet.next()) {

            User user = createUser(resultSet);
            users.add(user);
        }

        return users;
    }

    public int addUser(User user) throws SQLException {
        PreparedStatement preparedStatement = databaseConfiguration.getConnection().prepareStatement(UsersConstants.QUERY_CREATE_USER);
        preparedStatement.setInt(1, user.getId());
        preparedStatement.setString(2, user.getLastName());
        preparedStatement.setString(3, user.getFirstName());
        preparedStatement.setString(4, user.getCNP());
        preparedStatement.setString(5, user.getAddress());
        return preparedStatement.executeUpdate();
    }

    public int addUser(String lastName, String firstName, String CNP, String address) throws SQLException {
        PreparedStatement preparedStatement = databaseConfiguration.getConnection().prepareStatement(UsersConstants.QUERY_CREATE_USER);
        preparedStatement.setString(1, lastName);
        preparedStatement.setString(2, firstName);
        preparedStatement.setString(3, CNP);
        preparedStatement.setString(4, address);
        return preparedStatement.executeUpdate();
    }

    public List<User> getAllUsers() throws SQLException {
        // Necesar pentru a executa instrucțiuni sql
        Statement statement = databaseConfiguration.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(UsersConstants.QUERY_GET_ALL_USERS);

        return extractData(resultSet);
    }

    public User getUser(int id) throws SQLException {
        PreparedStatement preparedStatement = databaseConfiguration.getConnection().prepareStatement(UsersConstants.QUERY_GET_USER_BY_ID);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next())
            return createUser(resultSet);
        else
            return null;
    }

    public List<User> getUser(String lastName, String firstName) throws SQLException {
        PreparedStatement preparedStatement = databaseConfiguration.getConnection().prepareStatement(UsersConstants.QUERY_GET_USER_BY_NAME);
        preparedStatement.setString(1, lastName);
        preparedStatement.setString(2, firstName);
        ResultSet resultSet = preparedStatement.executeQuery();
        return extractData(resultSet);
    }

    public void editUser(String property, String newValue, String criterion, String value) throws SQLException {
        String queryUpdatePropertyByCriterion = "update smartcity.user set " + property + " = ";
        if (property.equals("id")) {
            queryUpdatePropertyByCriterion += Integer.parseInt(newValue) + " where " + criterion + " = ";
        } else {
            queryUpdatePropertyByCriterion += "'" + newValue + "' where " + criterion + " = ";
        }
        if (criterion.equals("id")) {
            queryUpdatePropertyByCriterion += Integer.parseInt(value);
        } else {
            queryUpdatePropertyByCriterion += "'" + value + "'";
        }
        Statement statement = databaseConfiguration.getConnection().createStatement();
        statement.executeUpdate(queryUpdatePropertyByCriterion);
    }

    public void deleteAllUsers() throws SQLException {
        Statement statement = databaseConfiguration.getConnection().createStatement();
        statement.executeUpdate(UsersConstants.QUERY_DELETE_ALL_USERS);
    }

    public void deleteUser(int id) throws SQLException {
        PreparedStatement preparedStatement = databaseConfiguration.getConnection().prepareStatement(UsersConstants.QUERY_DELETE_USER_BY_ID);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    public void deleteUser(String lastName, String firstName) throws SQLException {
        PreparedStatement preparedStatement = databaseConfiguration.getConnection().prepareStatement(UsersConstants.QUERY_DELETE_USER_BY_NAME);
        preparedStatement.setString(1, lastName);
        preparedStatement.setString(2, firstName);
        preparedStatement.executeUpdate();
    }
}
