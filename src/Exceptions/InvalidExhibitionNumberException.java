package Exceptions;

public class InvalidExhibitionNumberException extends RuntimeException {
    public InvalidExhibitionNumberException(String message) {
        super(message);
    }
}
