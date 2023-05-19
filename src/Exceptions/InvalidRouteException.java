package Exceptions;

public class InvalidRouteException extends RuntimeException {
    public InvalidRouteException(String mesaj) {
        super(mesaj);
    }
}
