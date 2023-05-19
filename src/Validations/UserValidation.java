package Validations;

import Utils.AuditSingleton;

public class UserValidation {
    public static boolean CNPValidation(String cnp) {
        AuditSingleton.INSTANCE.writeAction("User CNP validation");
        if (!cnp.matches("[0-9]+"))
            return false;
        return cnp.length() == 13;
    }

    public static boolean nameValidation(String lastName, String firstName) {
        AuditSingleton.INSTANCE.writeAction("User name validation");
        return !(lastName + firstName).matches("[0-9]+");
    }
}
