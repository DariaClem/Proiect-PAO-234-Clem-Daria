package Exceptions;

public class MuseumNotFoundException extends RuntimeException {
    public MuseumNotFoundException(String message) {
        super(message);
    }
}
