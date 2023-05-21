package Repositories;

import Configuration.DatabaseConfiguration;
import Constants.MuseumsConstants;
import Model.Museum;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MuseumRepository {
    private final DatabaseConfiguration databaseConfiguration;

    public MuseumRepository(DatabaseConfiguration databaseConfiguration) {
        this.databaseConfiguration = databaseConfiguration;
    }
    private Museum createMuseum(ResultSet resultSet) throws SQLException {
        return new Museum(resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("address"));
    }

    private List<Museum> extractData(ResultSet resultSet) throws SQLException {
        List<Museum> museums = new ArrayList<>();

        while (resultSet.next()) {
            Museum museum = createMuseum(resultSet);
            museums.add(museum);
        }

        return museums;
    }

    public int addMuseum(Museum museum) throws SQLException {
        PreparedStatement preparedStatement = databaseConfiguration.getConnection().prepareStatement(MuseumsConstants.QUERY_CREATE_MUSEUM);
        preparedStatement.setInt(1, museum.getId());
        preparedStatement.setString(2, museum.getName());
        preparedStatement.setString(3, museum.getAddress());
        return preparedStatement.executeUpdate();
    }

    public int addMuseum(String name, String address) throws SQLException {
        PreparedStatement preparedStatement = databaseConfiguration.getConnection().prepareStatement(MuseumsConstants.QUERY_CREATE_MUSEUM);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, address);
        return preparedStatement.executeUpdate();
    }

    public List<Museum> getAllMuseums() throws SQLException {
        Statement statement = databaseConfiguration.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(MuseumsConstants.QUERY_GET_ALL_MUSEUMS);

        return extractData(resultSet);
    }

    public Museum getMuseum(int id) throws SQLException {
        PreparedStatement preparedStatement = databaseConfiguration.getConnection().prepareStatement(MuseumsConstants.QUERY_GET_MUSEUM_BY_ID);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next())
            return createMuseum(resultSet);
        else
            return null;
    }

    public List<Museum> getMuseum(String name) throws SQLException {
        PreparedStatement preparedStatement = databaseConfiguration.getConnection().prepareStatement(MuseumsConstants.QUERY_GET_MUSEUM_BY_NAME);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();

        return extractData(resultSet);
    }

    public void editMuseum(String property, String newValue, String criterion, String value) throws SQLException {
        String queryUpdatePropertyByCriterion = "update smartcity.museum set " + property + " = ";

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

    public void deleteAllMuseums() throws SQLException {
        Statement statement = databaseConfiguration.getConnection().createStatement();
        statement.executeUpdate(MuseumsConstants.QUERY_DELETE_ALL_MUSEUMS);
    }

    public void deleteMuseum(int id) throws SQLException {
        PreparedStatement preparedStatement = databaseConfiguration.getConnection().prepareStatement(MuseumsConstants.QUERY_DELETE_MUSEUM_BY_ID);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    public void deleteMuseum(String name) throws SQLException {
        PreparedStatement preparedStatement = databaseConfiguration.getConnection().prepareStatement(MuseumsConstants.QUERY_DELETE_MUSEUM_BY_ID);
        preparedStatement.setString(1, name);
        preparedStatement.executeUpdate();
    }
}
