package Service;

import Model.Muzeu;
import Model.Utilizator;

import java.util.List;

public interface MuzeuService {
    void addMuzeu(Muzeu muzeu) throws Exception;

    List<Muzeu> getMuzeu() throws Exception;
}
