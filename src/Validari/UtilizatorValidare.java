package Validari;

import Utile.AuditSingleton;

public class UtilizatorValidare {
    public static boolean validareCNP(String cnp) {
        AuditSingleton.INSTANCE.writeAction("Validare CNP utilizator");
        if (!cnp.matches("[0-9]+"))
            return false;
        return cnp.length() == 13;
    }

    public static boolean validareNumePrenume(String nume, String prenume) {
        AuditSingleton.INSTANCE.writeAction("Validare nume utilizator");
        return !(nume + prenume).matches("[0-9]+");
    }
}
