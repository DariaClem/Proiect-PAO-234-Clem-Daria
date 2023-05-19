package Exceptions;

public class InvalidExhibitNumberException extends RuntimeException {
    public InvalidExhibitNumberException(String mesaj) {
        super(mesaj);
    }
}
