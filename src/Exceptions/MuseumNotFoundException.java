package Exceptions;

public class MuseumNotFoundException extends RuntimeException {
    public MuseumNotFoundException(String mesaj) {
        super(mesaj);
    }
}
