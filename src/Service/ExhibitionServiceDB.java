package Service;

import Model.Exhibition;

import java.sql.*;
import java.util.List;

public interface ExhibitionServiceDB {
    public void addExhibition(Exhibition exhibition);

    public void addExhibition(String name, Date startDate, Date endDate, int museumId);

    public List<Exhibition> getAllExhibitions();

    public Exhibition getExhibition(int id);

    public List<Exhibition> getExhibition(String name);

    public void editExhibition(String property, String newValue, String criterion, String value);

    public void deleteAllExhibitions();

    public void deleteExhibition(int id);

    public void deleteExhibition(String name);
}
