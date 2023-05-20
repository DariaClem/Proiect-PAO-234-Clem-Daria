package Exceptions;

public class MeansOfTransportNotFoundException extends RuntimeException {
    public MeansOfTransportNotFoundException(String message) {
        super(message);
    }
}
