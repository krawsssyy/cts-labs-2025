package Tests;
import org.junit.*;
import static org.junit.Assert.*;

public class UnitTests {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("Setup before test class creation");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("Destruction of resources allocated in setUpBeforeClass");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Setup the test class");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Destruction of resources allocated in setUp");
    }


    // unit tests are very important, as they allow us to ensure that our work behaves as expected
    // handles all the edge cases we could think of, and is safe to release to production
    // by testing, we can ensure we covered the simpler/moderate bugs that can appear
    // more extensive testing can ensure that even hard bugs can be covered thus making them not appear
    // hence, testing is a vital part of developing software
    // it may seem tedious and boring, but for every small class you will write in your future, you will have to ensure
    // proper test coverage, as to avoid bugs and therefore money and time losses on your side and your company's
    // Test-Drive-Development
    // write failing test -> write minimal code to pass the test (-> refactor the code if needed) -> repeat with more tests (adhering to the given paradigms)

    // CORRECT - a paradigm for how to write good tests and think of cases to consider
    // KEEP THIS IN MIND FOR ALL TESTS YOU WRITE
    // C - corectness/conformance - does the returned value conform to the expected format?
    // - test data formats and adherence to protocls and standards
    // - for example, testing that email addresses match valid patterns
    // O - ordering - is the data ordered appropriately?
    // - verify that sequence-dependent/sorting algorithms do work correctly
    // - for example, ensuring that search results are returned in their order of relevance
    // R - range - is the value between reasonable bounds?
    // - test various ranges (numeric ranges, collection sizes, string lenghts and so on..)
    // - for example, testing that the age is between 0 and 150
    // R - reference - does the code reference external dependencies correctly, and with all possible cases?
    // - test database connections, API integrations, file systems interactions and so on
    // - for example, test that the code handles a database connection failure correctly
    // E - existence - does the value exist when expected?
    // - test for null values, verify that all fields are present, ensure file/resource availability
    // - for example, test behaviour for when config files are missing
    // C - cardinality - does the set of values have enough values?
    // - test collection sizes, array bounds, one-to-many relationships
    // - for example, testing that a shopping cart has the required amount of items
    // T - time - is everything happening in the right order?
    // - test timeouts, delays, verify sequence of operations, check the accuracy and ordering of timestamps
    // - for example, testing that coupons expire at the correct time

    // step 1 - write failing test
    @Test
    public void testSumCorrectResult() {
        Calculator calc = new Calculator();
        int result = calc.sum(2, 3);
        assertEquals(5, result); // will fail initially (at step 1)
        // however, after doing step 2, the test will pass
    }

    // Right-BICEP
    // Right - test for correctness, i.e. we should test that 2 + 2 does equal 4, and not that 2 + 2 does not equal 5
    // tested with the first test
    // B - boundaries - test min/max values, empty collections, null values, testing inside and outside the valid ranges

    @Test
    public void testSumWithBoundaryValues() {
        // step 3 - new test, but given that our simple implementation covers it, no need for anything else as it already passes
        Calculator calc = new Calculator();
        // assertEquals requires both operands to be of the same type
        assertEquals((Integer)Integer.MAX_VALUE, calc.sum(Integer.MAX_VALUE, 0));
        assertEquals((Integer)Integer.MIN_VALUE, calc.sum(Integer.MIN_VALUE, 0));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testAddNumbersWithOverflow() {
        // step 4 - write another failing test
        Calculator calc = new Calculator();
        calc.sum(Integer.MAX_VALUE, 1); // overflow - will fail initially since no exception is thrown
    }
    // .. more tests with bounds (for null values - would require more refactoring - and so on..)

    // I - inverse
    // test opposite relations (undo/redo, add/subtract, encrypt/decrypt etc..)

    @Test
    public void testSumInverseWithSubtraction() {
        // test will succeed, so no need for anything else here
        // because of the simplicity of the example and the properties of addition, future tests will pass
        // thus no need for refactoring code
        Calculator calc = new Calculator();
        int result = calc.sum(10, -5);
        assertEquals(5, result);
    }

    @Test
    public void testSumInverseWithSubtractionAndBigNumbers() {
        // test already passes so nothing else required
        Calculator calc = new Calculator();
        assertEquals((Integer)(-1), calc.sum(Integer.MAX_VALUE, Integer.MIN_VALUE)); // (2^31 - 1 + (-2^31)
    }

    // C - cross-check
    // using alternative methods to compare results

    @Test
    public void testSumUsingLoopsCrossCheck() {
        // test passes - nothing else required
        Calculator calc = new Calculator();
        int a = 4, b = 5;
        int expected = 0;
        for (int i = 0; i < b; i++) {
            expected++;
        }
        for (int i = 0; i < a; i++) {
            expected++;
        }

        assertEquals((Integer)expected, calc.sum(a, b));
    }

    // E - errors
    // test with invalid inputs, resource exhaustion, various external errors etc..

    @Test(expected = UnsupportedOperationException.class)
    public void testAddNumbersWithNull() {
        // step 6 - write another failing test
        Calculator calc = new Calculator();
        calc.sum(1, null); // will fail initially
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testAddNumbersWithNull2() {
        // due to refactorings at step 7, this will pass, thus nothing else needed
        Calculator calc = new Calculator();
        calc.sum(null, 1);
    }

    // P - performance
    // verify algorithms meet performance requirements, test with large datasets, check memory usage

    @Test
    public void testSumPerformance() {
        Calculator calc = new Calculator();
        long start = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            calc.sum(i, i);
        }
        long duration = System.nanoTime() - start;
        assertTrue(duration < 50_000_000); // 50ms
    }
}
