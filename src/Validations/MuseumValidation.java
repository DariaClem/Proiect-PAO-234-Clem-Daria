package Validations;

import Model.Exhibition;
import Utils.AuditSingleton;

import java.util.Set;

public class MuseumValidation {
    public static boolean exhibitionsValidation(Set<Exhibition> exhibitionList) {
        AuditSingleton.INSTANCE.writeAction("Exhibition validation");
        return exhibitionList.size() != 0;
    }
}
