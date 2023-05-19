package Exceptions;

public class InvalidNameException extends RuntimeException {
    public InvalidNameException(String mesaj) {
        super(mesaj);
    }
}
