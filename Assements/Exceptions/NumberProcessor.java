package Exceptions;

public class NumberProcessor {
    public int computeFunction(int n) throws NegativeNumberException {
        System.out.println("Function is running");
        return n * fact(n);
    }

    private int fact(int n) throws NegativeNumberException {
        if (n < 0) {
            throw new NegativeNumberException();
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * fact(n - 1);
    }
}
