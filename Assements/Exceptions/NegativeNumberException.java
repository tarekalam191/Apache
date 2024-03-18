package Exceptions;

public class NegativeNumberException extends Exception {
    public NegativeNumberException() {
        super("Negative Number Exception: Could not handle negative numbers.");
    }
}