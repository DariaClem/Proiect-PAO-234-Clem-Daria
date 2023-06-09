package Service.Impl;

import Exceptii.InvalidCNPException;
import Exceptii.InvalidNumeException;
import Exceptii.NuEsteUtilizatorulException;
import Exceptii.NuSuntUtilizatoriException;
import Model.Utilizator;
import Service.UtilizatorService;

import java.util.*;

import static Validari.UtilizatorValidare.validareCNP;
import static Validari.UtilizatorValidare.validareNumePrenume;

public class UtilizatorServiceImpl implements UtilizatorService {

    List<Utilizator> utilizatori;

    @Override
    public void addUtilizator(Utilizator utilizator) throws Exception {
        boolean utilizatorValid = true;

        try {
            if (!validareCNP(utilizator.getCNP())) {
                throw new InvalidCNPException("CNP-ul trebuie sa contina 13 cifre!");
            }

            if (!validareNumePrenume(utilizator.getNume(), utilizator.getPrenume())) {
                throw new InvalidNumeException("Numele si prenumele nu pot contine cifre!");
            }
        } catch (InvalidCNPException | InvalidNumeException exceptie) {
            utilizatorValid = false;
            System.out.println(exceptie.getMessage());
        }

        if (utilizatorValid) {
            if (utilizatori == null) {
                utilizatori = new ArrayList<>();
            }
            utilizatori.add(utilizator);
        }
    }

    @Override
    public void deleteUtilizator(Utilizator utilizator) throws Exception {
        try {
            if (utilizatori == null)
                throw new NuSuntUtilizatoriException("Lista de utilizatori este goala");

            boolean gasit = false;
            for (Utilizator user : utilizatori) {
                if (user == utilizator) {
                    gasit = true;
                    break;
                }
            }

            if (gasit)
                utilizatori.remove(utilizator);
            else
                throw new NuEsteUtilizatorulException("Utilizatorul cautat nu a fost gasit");

        } catch (NuSuntUtilizatoriException | NuEsteUtilizatorulException exceptie) {
            System.out.println(exceptie.getMessage());
        }
    }

    @Override
    public void deleteUtilizator(String nume, String prenume) throws Exception {
        try {
            if (utilizatori == null)
                throw new NuSuntUtilizatoriException("Lista de utilizatori este goala");

            Utilizator utilizatorGasit = getUtilizator(nume, prenume);
            utilizatori.remove(utilizatorGasit);

        } catch (NuSuntUtilizatoriException | NuEsteUtilizatorulException exceptie) {
            System.out.println(exceptie.getMessage());
        }
    }

    @Override
    public List<Utilizator> getUtilizatori() throws Exception {
        try {
            if (utilizatori == null)
                throw new NuSuntUtilizatoriException("Lista de utilizatori este goala");
            Collections.sort(utilizatori);
        } catch (NuSuntUtilizatoriException exceptie) {
            System.out.println(exceptie.getMessage());
        }
        return utilizatori;
    }

    @Override
    public Utilizator getUtilizator(String nume, String prenume) throws Exception {
        Utilizator utilizatorGasit = new Utilizator();
        boolean gasit = false;
        try {
            if (utilizatori == null) {
                throw new NuSuntUtilizatoriException("Lista de utilizatori este goala");
            }
            for (Utilizator utilizator : utilizatori) {
                if (Objects.equals(utilizator.getNume(), nume) && Objects.equals(utilizator.getPrenume(), prenume)) {
                    utilizatorGasit = utilizator;
                    gasit = true;
                }
            }
            if (!gasit) {
                throw new NuEsteUtilizatorulException("Utilizatorul cautat nu a fost gasit");
            }
        } catch (NuSuntUtilizatoriException | NuEsteUtilizatorulException exceptie) {
            System.out.println(exceptie.getMessage());
        }
        return utilizatorGasit;
    }
}
