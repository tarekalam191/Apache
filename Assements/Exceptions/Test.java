

public class NegativeNumberException extends Exception {
    public NegativeNumberException() {
        super("Negative Number Exception: Could not handle negative numbers.");
    }
}

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

public class Test {
    public static void main(String[] args) {
        try {
            NumberProcessor processor = new NumberProcessor();
            int result = processor.computeFunction(5); // Example input
            System.out.println("Result: " + result);
        } catch (NegativeNumberException e) {
            System.out.println(e.getMessage());
        }
    }
}
