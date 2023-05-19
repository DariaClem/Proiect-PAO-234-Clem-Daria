package Exceptions;

public class ExhibitionNotFoundException extends RuntimeException {
    public ExhibitionNotFoundException(String message) {
        super(message);
    }
}
