package Service;

import Model.Exhibit;

import java.util.List;

public interface ExhibitsService {
    void addExhibit(Exhibit exhibit) throws Exception;
    void addExhibit(String[] exhibit) throws Exception;
    List<Exhibit> getExhibits() throws Exception;
    Exhibit getExhibit(int id) throws Exception;
}
