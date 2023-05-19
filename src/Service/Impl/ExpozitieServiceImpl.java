package Service.Impl;

import Exceptii.InvalidNumarExpozitiiException;
import Exceptii.NuEsteExpozitiaException;
import Exceptii.NuSuntExpozitiiException;
import Exceptii.NuSuntMuzeeException;
import Model.Expozitie;
import Service.ExpozitieService;
import Utile.AuditSingleton;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static Validari.ExpozitieValidare.validareExponate;
import static Validari.MuzeuValidare.validareExpozitii;

public class ExpozitieServiceImpl implements ExpozitieService {
    Set<Expozitie> expozitii;

    @Override
    public void addExpozitie(Expozitie expozitie) throws Exception {
        boolean expozitieValida = true;
        try {
            if (!validareExponate(expozitie.getExponate()))
                throw new InvalidNumarExpozitiiException("Numarul de expozitii nu poate fi 0");
        } catch (InvalidNumarExpozitiiException exceptie) {
            expozitieValida = false;
            System.out.println(exceptie.getMessage());
        }

        if (expozitieValida) {
            if (expozitii == null)
                expozitii = new HashSet<>();
            expozitii.add(expozitie);
            AuditSingleton.INSTANCE.writeAction("Adaugare expozitie");
        }
    }

    @Override
    public void addExpozitie(String[] expozitie) throws Exception {
        boolean expozitieValida = true;
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        int id = Integer.parseInt(expozitie[0]);
        String denumire = expozitie[1];
        Date dataInceput = dateFormat.parse(expozitie[2]);
        Date dataFinal = dateFormat.parse(expozitie[3]);
        int idMuzeu = Integer.parseInt(expozitie[4]);

        if (expozitii == null)
            expozitii = new HashSet<>();
        expozitii.add(new Expozitie(id, denumire, dataInceput, dataFinal, idMuzeu));
        AuditSingleton.INSTANCE.writeAction("Adaugare expozitie");

    }

    @Override
    public Set<Expozitie> getExpozitii() throws Exception {
        try {
            if (expozitii == null)
                throw new NuSuntExpozitiiException("Lista de expozitii este goala.");
        } catch (NuSuntExpozitiiException exception) {
            System.out.println(exception.getMessage());
        }
        AuditSingleton.INSTANCE.writeAction("Get expozitie");
        return expozitii;
    }

    @Override
    public Expozitie getExpozitie(int id) throws Exception {
        Expozitie expozitieGasita = new Expozitie();
        boolean gasit = false;
        try {
            if (expozitii == null) {
                throw new NuSuntExpozitiiException("Lista de expozitii este goala.");
            }
            for (Expozitie expozitie : expozitii) {
                if (id == expozitie.getId()) {
                    expozitieGasita = expozitie;
                    gasit = true;
                }
            }
            if (!gasit) {
                throw new NuEsteExpozitiaException("Expozitia cautata nu a fost gasita.");
            }
        } catch (NuSuntExpozitiiException | NuEsteExpozitiaException exception) {
            System.out.println(exception.getMessage());
        }
        AuditSingleton.INSTANCE.writeAction("Get expozitie dupa id");
        return expozitieGasita;
    }
}
