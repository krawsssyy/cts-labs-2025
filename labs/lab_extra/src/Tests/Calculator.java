package Tests;

public class Calculator {
    // base class
    public Integer sum(Integer a, Integer b) {
        // return a + b; // step 2 - write minimal code for passing the test
        // no refactoring required after step 2
        // step 7 - refactor the code to adhere to the test at step 6
        if (a == null || b == null) { // due to checking for int values at step 5, this has to come before that check
            throw new UnsupportedOperationException("One or more values are null!");
        }
        // step 5 - refactor the code to adhere to the test at step 4
        if ((a == Integer.MAX_VALUE && b > 0) || (a > 0 && b == Integer.MAX_VALUE)) {
            throw new UnsupportedOperationException("Value too big, will overflow!");
        }

        return a + b;
    }
}
