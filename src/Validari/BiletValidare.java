package Validari;

import Utile.AuditSingleton;

public class BiletValidare {
    public static boolean validarePretBilet(float pret) {
        AuditSingleton.INSTANCE.writeAction("Validare bilet");
        return pret > 0;
    }
}
