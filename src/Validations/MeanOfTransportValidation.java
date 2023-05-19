package Validations;

import Utils.AuditSingleton;

import java.util.List;

public class MeanOfTransportValidation {
    public static boolean routeValidation(List<String> route) {
        AuditSingleton.INSTANCE.writeAction("Means of transport route validation");
        return route.size() > 1;
    }

    public static boolean numberValidation(int number) {
        AuditSingleton.INSTANCE.writeAction("Means of transport number validation");
        return number > 0;
    }
}
