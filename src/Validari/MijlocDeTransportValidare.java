package Validari;

import Utile.AuditSingleton;

import java.util.List;

public class MijlocDeTransportValidare {
    public static boolean validareRuta(List<String> ruta) {
        AuditSingleton.INSTANCE.writeAction("Validare ruta mijloc de transport");
        return ruta.size() > 1;
    }

    public static boolean validareNumar(int numar) {
        AuditSingleton.INSTANCE.writeAction("Validare numar mijloc de transport");
        return numar > 0;
    }
}
