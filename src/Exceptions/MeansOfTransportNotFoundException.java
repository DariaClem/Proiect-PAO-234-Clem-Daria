package Exceptions;

public class MeansOfTransportNotFoundException extends RuntimeException {
    public MeansOfTransportNotFoundException(String mesaj) {
        super(mesaj);
    }
}
