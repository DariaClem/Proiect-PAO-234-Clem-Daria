package Exceptions;

public class ExhibitsNotFoundException extends RuntimeException {
    public ExhibitsNotFoundException(String mesaj) {
        super(mesaj);
    }
}
