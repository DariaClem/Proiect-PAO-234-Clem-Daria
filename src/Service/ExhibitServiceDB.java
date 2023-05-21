package Service;

import Model.Exhibit;

import java.util.List;

public interface ExhibitServiceDB {
    public void addExhibit(Exhibit exhibit);

    public void addExhibit(String name, String description, String originCountry, String originDate, int exhibitionId);

    public List<Exhibit> getAllExhibits();

    public Exhibit getExhibit(int id);

    public List<Exhibit> getExhibit(String name);
    public List<Exhibit> getExhibitByExhibitionId(int id);

    public void editExhibit(String property, String newValue, String criterion, String value);

    public void deleteAllExhibits();

    public void deleteExhibit(int id);

    public void deleteExhibit(String name);
}
