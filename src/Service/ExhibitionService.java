package Service;

import Model.Exhibition;

import java.util.Set;

public interface ExhibitionService {
    void addExhibition(Exhibition exhibition) throws Exception;
    void addExhibition(String[] exhibition) throws Exception;

    Set<Exhibition> getExhibitions() throws Exception;
    Exhibition getExhibition(int id) throws Exception;
}
