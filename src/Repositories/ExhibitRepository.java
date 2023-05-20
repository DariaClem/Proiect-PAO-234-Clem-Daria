package Repositories;

import Configuration.DatabaseConfiguration;
import Constants.ExhibitsConstants;
import Model.Exhibit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExhibitRepository {
    private final DatabaseConfiguration databaseConfiguration;

    public ExhibitRepository(DatabaseConfiguration databaseConfiguration) {
        this.databaseConfiguration = databaseConfiguration;
    }

    private Exhibit createExhibit (ResultSet resultSet) throws SQLException {
        return new Exhibit(resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("description"),
                resultSet.getString("originCountry"),
                resultSet.getString("originDate"),
                resultSet.getInt("exhibitionId"));
    }

    private List<Exhibit> extractData(ResultSet resultSet) throws SQLException {
        List<Exhibit> exhibits = new ArrayList<>();

        while (resultSet.next()) {
            Exhibit exhibit = createExhibit(resultSet);
            exhibits.add(exhibit);
        }

        return exhibits;
    }

    public int addExhibit(Exhibit exhibit) throws SQLException {
        PreparedStatement preparedStatement = databaseConfiguration.getConnection().prepareStatement(ExhibitsConstants.QUERY_CREATE_EXHIBIT);
        preparedStatement.setInt(1, exhibit.getId());
        preparedStatement.setString(2, exhibit.getName());
        preparedStatement.setString(3, exhibit.getDescription());
        preparedStatement.setString(4, exhibit.getOriginCountry());
        preparedStatement.setString(5, exhibit.getOriginDate());
        preparedStatement.setInt(6, exhibit.getExhibitionId());

        return preparedStatement.executeUpdate();
    }

    public int addExhibit(String name, String description, String originCountry, String originDate, int exhibitionId) throws SQLException {
        PreparedStatement preparedStatement = databaseConfiguration.getConnection().prepareStatement(ExhibitsConstants.QUERY_CREATE_EXHIBIT);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, description);
        preparedStatement.setString(3, originCountry);
        preparedStatement.setString(4, originDate);
        preparedStatement.setInt(5, exhibitionId);

        return preparedStatement.executeUpdate();
    }

    public List<Exhibit> getAllExhibits() throws SQLException {
        Statement statement = databaseConfiguration.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(ExhibitsConstants.QUERY_GET_ALL_EXHIBITS);

        return extractData(resultSet);
    }

    public Exhibit getExhibit(int id) throws SQLException {
        PreparedStatement preparedStatement = databaseConfiguration.getConnection().prepareStatement(ExhibitsConstants.QUERY_GET_EXHIBIT_BY_ID);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next())
            return createExhibit(resultSet);
        else
            return null;
    }

    public List<Exhibit> getExhibit(String name) throws SQLException {
        PreparedStatement preparedStatement = databaseConfiguration.getConnection().prepareStatement(ExhibitsConstants.QUERY_GET_EXHIBIT_BY_NAME);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();

        return extractData(resultSet);
    }

    public void editExhibit(String property, String newValue, String criterion, String value) throws SQLException {
        String queryUpdatePropertyByCriterion = "update smartcity.exhibit set " + property + " = ";

        if (property.equals("id")) {
            queryUpdatePropertyByCriterion += Integer.parseInt(newValue) + "where " + criterion + " = ";
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

    public void deleteAllExhibits() throws SQLException {
        Statement statement = databaseConfiguration.getConnection().createStatement();
        statement.executeUpdate(ExhibitsConstants.QUERY_DELETE_ALL_EXHIBITS);
    }

    public void deleteExhibit(int id) throws SQLException {
        PreparedStatement preparedStatement = databaseConfiguration.getConnection().prepareStatement(ExhibitsConstants.QUERY_DELETE_EXHIBIT_BY_ID);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    public void deleteExhibit(String name) throws SQLException {
        PreparedStatement preparedStatement = databaseConfiguration.getConnection().prepareStatement(ExhibitsConstants.QUERY_DELETE_EXHIBIT_BY_ID);
        preparedStatement.setString(1, name);
        preparedStatement.executeUpdate();
    }
}
