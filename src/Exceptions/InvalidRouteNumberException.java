package Exceptions;

public class InvalidRouteNumberException extends RuntimeException {
    public InvalidRouteNumberException(String mesaj) {
        super(mesaj);
    }
}
