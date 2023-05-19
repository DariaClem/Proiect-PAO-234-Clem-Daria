package Exceptions;

public class ExhibitNotFoundException extends RuntimeException {
    public ExhibitNotFoundException(String message) {
        super(message);
    }
}
