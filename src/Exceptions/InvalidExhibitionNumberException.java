package Exceptions;

public class InvalidExhibitionNumberException extends RuntimeException {
    public InvalidExhibitionNumberException(String mesaj) {
        super(mesaj);
    }
}
