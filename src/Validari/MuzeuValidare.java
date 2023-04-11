package Validari;

import Model.Expozitie;

import java.util.List;
import java.util.Set;

public class MuzeuValidare {
    public static boolean validareExpozitii(Set<Expozitie> expozitieList) {
        return expozitieList.size() != 0;
    }
}
