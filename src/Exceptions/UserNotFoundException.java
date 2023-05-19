package Exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String mesaj) {
        super(mesaj);
    }
}
