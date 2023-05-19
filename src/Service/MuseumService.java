package Service;

import Model.Museum;

import java.util.List;

public interface MuseumService {
    void addMuseum(Museum museum) throws Exception;
    void addMuseum(String[] museum) throws Exception;
    List<Museum> getMuseums() throws Exception;
    Museum getMuseum(int museum) throws Exception;
}
