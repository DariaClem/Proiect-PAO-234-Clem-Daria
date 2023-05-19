package Validations;

import Utils.AuditSingleton;

public class TicketValidation {
    public static boolean ticketPriceValidation(float price) {
        AuditSingleton.INSTANCE.writeAction("Ticket validation");
        return price > 0;
    }
}
