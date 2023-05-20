package Exceptions;

public class ExhibitsNotFoundException extends RuntimeException {
    public ExhibitsNotFoundException(String message) {
        super(message);
    }
}
