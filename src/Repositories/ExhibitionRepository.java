package Repositories;

import Configuration.DatabaseConfiguration;
import Constants.ExhibitionsConstants;
import Model.Exhibition;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ExhibitionRepository {
    private final DatabaseConfiguration databaseConfiguration;

    public ExhibitionRepository(DatabaseConfiguration databaseConfiguration) {
        this.databaseConfiguration = databaseConfiguration;
    }

    private Exhibition createExhibition(ResultSet resultSet) throws SQLException {
        return new Exhibition(resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getDate("startDate"),
                resultSet.getDate("endDate"),
                resultSet.getInt("museumId"));
    }

    private List<Exhibition> extractData(ResultSet resultSet) throws SQLException {
        List<Exhibition> exhibitions = new ArrayList<>();

        while (resultSet.next()) {
            Exhibition exhibition = createExhibition(resultSet);
            exhibitions.add(exhibition);
        }

        return exhibitions;
    }

    public int addExhibition(Exhibition exhibition) throws SQLException {
        PreparedStatement preparedStatement = databaseConfiguration.getConnection().prepareStatement(ExhibitionsConstants.QUERY_CREATE_EXHIBITION);
        preparedStatement.setInt(1, exhibition.getId());
        preparedStatement.setString(2, exhibition.getName());
        preparedStatement.setDate(3, (Date) exhibition.getStartDate());
        preparedStatement.setDate(4, (Date) exhibition.getStartDate());
        preparedStatement.setInt(5, exhibition.getMuseumId());
        return preparedStatement.executeUpdate();
    }

    public int addExhibition(String name, Date startDate, Date endDate, int museumId) throws SQLException {
        PreparedStatement preparedStatement = databaseConfiguration.getConnection().prepareStatement(ExhibitionsConstants.QUERY_CREATE_EXHIBITION);
        preparedStatement.setString(1, name);
        preparedStatement.setDate(2, startDate);
        preparedStatement.setDate(3, endDate);
        preparedStatement.setInt(4, museumId);
        return preparedStatement.executeUpdate();
    }

    public List<Exhibition> getAllExhibitions() throws SQLException {
        Statement statement = databaseConfiguration.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(ExhibitionsConstants.QUERY_GET_ALL_EXHIBITIONS);

        return extractData(resultSet);
    }

    public Exhibition getExhibition(int id) throws SQLException {
        PreparedStatement preparedStatement = databaseConfiguration.getConnection().prepareStatement(ExhibitionsConstants.QUERY_GET_EXHIBITION_BY_ID);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next())
            return createExhibition(resultSet);
        else
            return null;
    }

    public List<Exhibition> getExhibition(String name) throws SQLException {
        PreparedStatement preparedStatement = databaseConfiguration.getConnection().prepareStatement(ExhibitionsConstants.QUERY_GET_EXHIBITION_BY_NAME);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();

        return extractData(resultSet);
    }

    public List<Exhibition> getExhibitionByMuseumId(int id) throws SQLException {
        PreparedStatement preparedStatement = databaseConfiguration.getConnection().prepareStatement(ExhibitionsConstants.QUERY_GET_EXHIBITION_BY_MUSEUMID);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        return extractData(resultSet);
    }

    public void editExhibition(String property, String newValue, String criterion, String value) throws Exception {
        String queryUpdatePropertyByCriterion = "update smartcity.exhibition set " + property + " = ";
        if (property.equals("id") || property.equals("museumId")) {
            queryUpdatePropertyByCriterion += Integer.parseInt(newValue) + " where " + criterion + " = ";
        } else {
            queryUpdatePropertyByCriterion += "'" + newValue + "' where " + criterion + " = ";
        }
        if (criterion.equals("id") || criterion.equals("museumId")) {
            queryUpdatePropertyByCriterion += Integer.parseInt(value);
        } else {
            queryUpdatePropertyByCriterion += "'" + value + "'";
        }

        Statement statement = databaseConfiguration.getConnection().createStatement();
        statement.executeUpdate(queryUpdatePropertyByCriterion);
    }

    public void deleteAllExhibitions() throws SQLException {
        Statement statement = databaseConfiguration.getConnection().createStatement();
        statement.executeUpdate(ExhibitionsConstants.QUERY_DELETE_ALL_EXHIBITIONS);
    }

    public void deleteExhibition(int id) throws SQLException {
        PreparedStatement preparedStatement = databaseConfiguration.getConnection().prepareStatement(ExhibitionsConstants.QUERY_DELETE_EXHIBITION_BY_ID);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    public void deleteExhibition(String name) throws SQLException {
        PreparedStatement preparedStatement = databaseConfiguration.getConnection().prepareStatement(ExhibitionsConstants.QUERY_DELETE_EXHIBITION_BY_NAME);
        preparedStatement.setString(1, name);
        preparedStatement.executeUpdate();
    }
}
