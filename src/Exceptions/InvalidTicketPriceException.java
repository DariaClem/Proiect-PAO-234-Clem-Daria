package Exceptions;

public class InvalidTicketPriceException extends RuntimeException {
    public InvalidTicketPriceException(String mesaj) {
        super(mesaj);
    }
}
