package Service;

import Model.Museum;

import java.util.List;

public interface MuseumServiceDB {

    public void addMuseum(Museum museum);

    public void addMuseum(String name, String address);

    public List<Museum> getAllMuseums();

    public Museum getMuseum(int id);

    public List<Museum> getMuseum(String name);

    public void editMuseum(String property, String newValue, String criterion, String value);

    public void deleteAllMuseums();

    public void deleteMuseum(int id);

    public void deleteMuseum(String name);
}