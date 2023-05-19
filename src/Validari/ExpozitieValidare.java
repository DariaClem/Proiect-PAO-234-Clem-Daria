package Validari;

import Model.Exponat;
import Utile.AuditSingleton;

import java.util.List;
import java.util.Set;

public class ExpozitieValidare {
    public static boolean validareExponate(List<Exponat> exponateList) {
        AuditSingleton.INSTANCE.writeAction("Validare exponat");
        return exponateList.size() != 0;
    }
}
