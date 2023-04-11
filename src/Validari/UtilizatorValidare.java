package Validari;

public class UtilizatorValidare {
    public static boolean validareCNP(String cnp) {
        if (!cnp.matches("[0-9]+"))
            return false;
        return cnp.length() == 13;
    }

    public static boolean validareNumePrenume(String nume, String prenume) {
        return !(nume + prenume).matches("[0-9]+");
    }
}
