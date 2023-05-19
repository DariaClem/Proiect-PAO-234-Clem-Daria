package Exceptions;

public class ExhibitionsNotFoundException extends RuntimeException {
    public ExhibitionsNotFoundException(String mesaj) {
        super(mesaj);
    }
}
