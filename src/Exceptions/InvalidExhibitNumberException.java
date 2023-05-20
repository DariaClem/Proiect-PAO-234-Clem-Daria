package Exceptions;

public class InvalidExhibitNumberException extends RuntimeException {
    public InvalidExhibitNumberException(String message) {
        super(message);
    }
}
