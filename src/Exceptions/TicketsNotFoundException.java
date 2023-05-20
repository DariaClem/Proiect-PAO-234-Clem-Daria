package Exceptions;

public class TicketsNotFoundException extends RuntimeException {
    public TicketsNotFoundException(String message) {
        super(message);
    }
}
