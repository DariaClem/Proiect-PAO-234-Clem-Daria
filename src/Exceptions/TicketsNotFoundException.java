package Exceptions;

public class TicketsNotFoundException extends RuntimeException {
    public TicketsNotFoundException(String mesaj) {
        super(mesaj);
    }
}
