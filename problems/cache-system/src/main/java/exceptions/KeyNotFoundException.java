package exceptions;

public class KeyNotFoundException extends RuntimeException {

    public KeyNotFoundException() {
        super("key not found in storage");
    }

}
