package Exceptions;

public class MuseumsNotFoundException extends RuntimeException {
    public MuseumsNotFoundException(String message) {
        super(message);
    }
}
