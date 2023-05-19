package Service;

import Model.Exponat;
import Model.Muzeu;

import java.util.List;

public interface ExponateService {
    void addExponat(Exponat exponat) throws Exception;

    List<Exponat> getExponate() throws Exception;
    Exponat getExponat(int id) throws Exception;
}
