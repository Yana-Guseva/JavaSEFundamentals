package javase.homework._05._02;

/**
 * Created by Yana on 05.11.2015.
 */
public class KeyException extends Exception {
    @Override
    public String getMessage() {
        return "There is no such key in *.property file.";
    }
}
