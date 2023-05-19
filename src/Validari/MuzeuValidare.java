package Validari;

import Model.Expozitie;
import Utile.AuditSingleton;

import java.util.List;
import java.util.Set;

public class MuzeuValidare {
    public static boolean validareExpozitii(Set<Expozitie> expozitieList) {
        AuditSingleton.INSTANCE.writeAction("Validare expozitie");
        return expozitieList.size() != 0;
    }
}
