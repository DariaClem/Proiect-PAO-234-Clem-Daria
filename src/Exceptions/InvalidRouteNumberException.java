package Exceptions;

public class InvalidRouteNumberException extends RuntimeException {
    public InvalidRouteNumberException(String message) {
        super(message);
    }
}
