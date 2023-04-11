package Exceptii;

public class InvalidPretBilet extends RuntimeException {
    public InvalidPretBilet(String mesaj) {
        super(mesaj);
    }
}
