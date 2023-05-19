package Exceptions;

public class MuseumsNotFoundException extends RuntimeException {
    public MuseumsNotFoundException(String mesaj) {
        super(mesaj);
    }
}
