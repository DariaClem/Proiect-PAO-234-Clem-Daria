package Exceptions;

public class ExhibitionsNotFoundException extends RuntimeException {
    public ExhibitionsNotFoundException(String message) {
        super(message);
    }
}
