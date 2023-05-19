package Service;

import Model.Expozitie;

import java.util.List;
import java.util.Set;

public interface ExpozitieService {
    void addExpozitie(Expozitie expozitie) throws Exception;

    Set<Expozitie> getExpozitii() throws Exception;
    Expozitie getExpozitie(int id) throws Exception;
}
