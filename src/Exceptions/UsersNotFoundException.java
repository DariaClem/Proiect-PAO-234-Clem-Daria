package Exceptions;

public class UsersNotFoundException extends RuntimeException {
    public UsersNotFoundException(String mesaj) {
        super(mesaj);
    }
}
