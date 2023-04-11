package Validari;

import java.util.List;

public class MijlocDeTransportValidare {
    public static boolean validareRuta(List<String> ruta) {
        return ruta.size() > 1;
    }

    public static boolean validareNumar(int numar) {
        return numar > 0;
    }
}
