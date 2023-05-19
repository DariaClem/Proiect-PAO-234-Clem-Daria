package Service.Impl;

import Exceptii.InvalidNumarExpozitiiException;
import Exceptii.NuEsteMuzeulException;
import Exceptii.NuSuntMuzeeException;
import Model.Muzeu;
import Service.MuzeuService;
import Utile.AuditSingleton;

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
            AuditSingleton.INSTANCE.writeAction("Adaugare muzeu");
        }
    }

    @Override
    public List<Muzeu> getMuzee() throws Exception {
        try {
            if (muzee == null)
                throw new NuSuntMuzeeException("Lista de muzee este goala.");
        } catch (NuSuntMuzeeException exception) {
            System.out.println(exception.getMessage());
        }
        AuditSingleton.INSTANCE.writeAction("Get muzee");
        return muzee;
    }

    @Override
    public Muzeu getMuzeu(int id) throws Exception {
        Muzeu muzeuGasit = new Muzeu();
        boolean gasit = false;
        try {
            if (muzee == null) {
                throw new NuSuntMuzeeException("Lista de muzee este goala.");
            }
            for (Muzeu muzeu : muzee) {
                if (id == muzeu.getId()) {
                    muzeuGasit = muzeu;
                    gasit = true;
                }
            }
            if (!gasit) {
                throw new NuEsteMuzeulException("Muzeul nu exista.");
            }
        } catch (NuSuntMuzeeException | NuEsteMuzeulException exception) {
            System.out.println(exception.getMessage());
        }
        AuditSingleton.INSTANCE.writeAction("Get muzeu dupa id");
        return muzeuGasit;
    }
}
