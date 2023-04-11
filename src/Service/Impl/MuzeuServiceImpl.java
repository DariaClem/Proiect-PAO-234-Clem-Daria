package Service.Impl;

import Exceptii.InvalidNumarExpozitiiException;
import Exceptii.NuSuntMuzeeException;
import Model.Muzeu;
import Service.MuzeuService;

import java.util.ArrayList;
import java.util.List;

import static Validari.MuzeuValidare.validareExpozitii;

public class MuzeuServiceImpl implements MuzeuService {
    List<Muzeu> muzee;

    @Override
    public void addMuzeu(Muzeu muzeu) throws Exception {
        boolean muzeuValid = true;
        try {
            if (!validareExpozitii(muzeu.getExpozitii()))
                throw new InvalidNumarExpozitiiException("Numarul de expozitii nu poate fi 0");
        } catch (InvalidNumarExpozitiiException exceptie) {
            muzeuValid = false;
            System.out.println(exceptie.getMessage());
        }

        if (muzeuValid) {
            if (muzee == null)
                muzee = new ArrayList<>();
            muzee.add(muzeu);
        }
    }

    @Override
    public List<Muzeu> getMuzeu() throws Exception {
        try {
            if (muzee == null)
                throw new NuSuntMuzeeException("Lista de muzee este goala.");
        } catch (NuSuntMuzeeException exception) {
            System.out.println(exception.getMessage());
        }
        return muzee;
    }
}
