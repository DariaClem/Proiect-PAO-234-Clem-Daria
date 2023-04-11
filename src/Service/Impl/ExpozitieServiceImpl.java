package Service.Impl;

import Exceptii.InvalidNumarExpozitiiException;
import Exceptii.NuSuntExpozitiiException;
import Exceptii.NuSuntMuzeeException;
import Model.Expozitie;
import Service.ExpozitieService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        }
    }

    @Override
    public Set<Expozitie> getExpozitie() throws Exception {
        try {
            if (expozitii == null)
                throw new NuSuntExpozitiiException("Lista de muzee este goala.");
        } catch (NuSuntExpozitiiException exception) {
            System.out.println(exception.getMessage());
        }
        return expozitii;
    }
}
