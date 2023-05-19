package Validations;

import Model.Exhibit;
import Utils.AuditSingleton;

import java.util.List;

public class ExhibitionValidation {
    public static boolean exhibitsValidation(List<Exhibit> exhibitsList) {
        AuditSingleton.INSTANCE.writeAction("Exhibition validation");
        return exhibitsList.size() != 0;
    }
}
