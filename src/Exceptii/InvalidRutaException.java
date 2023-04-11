package Exceptii;

public class InvalidRutaException extends RuntimeException {
    public InvalidRutaException(String mesaj) {
        super(mesaj);
    }
}
