
package junit.framework;


/**
 * A test case defines the fixture to run multiple tests. To define a test case<br/>
 * <ol>
 *   <li>implement a subclass of <code>TestCase</code></li>
 *   <li>define instance variables that store the state of the fixture</li>
 *   <li>initialize the fixture state by overriding {@link #setUp()}</li>
 *   <li>clean-up after a test by overriding {@link #tearDown()}.</li>
 * </ol>
 * Each test runs in its own fixture so there
 * can be no side effects among test runs.
 * Here is an example:
 * <pre>
 * public class MathTest extends TestCase {
 *    protected double fValue1;
 *    protected double fValue2;
 *
 *    protected void setUp() {
 *       fValue1= 2.0;
 *       fValue2= 3.0;
 *    }
 * }
 * </pre>
 *
 * For each test implement a method which interacts
 * with the fixture. Verify the expected results with assertions specified
 * by calling {@link junit.framework.Assert#assertTrue(String, boolean)} with a boolean.
 * <pre>
 *    public void testAdd() {
 *       double result= fValue1 + fValue2;
 *       assertTrue(result == 5.0);
 *    }
 * </pre>
 *
 * Once the methods are defined you can run them. The framework supports
 * both a static type safe and more dynamic way to run a test.
 * In the static way you override the runTest method and define the method to
 * be invoked. A convenient way to do so is with an anonymous inner class.
 * <pre>
 * TestCase test= new MathTest("add") {
 *    public void runTest() {
 *       testAdd();
 *    }
 * };
 * test.run();
 * </pre>
 *
 * The dynamic way uses reflection to implement {@link #runTest()}. It dynamically finds
 * and invokes a method.
 * In this case the name of the test case has to correspond to the test method
 * to be run.
 * <pre>
 * TestCase test= new MathTest("testAdd");
 * test.run();
 * </pre>
 *
 * The tests to be run can be collected into a TestSuite. JUnit provides
 * different <i>test runners</i> which can run a test suite and collect the results.
 * A test runner either expects a static method <code>suite</code> as the entry
 * point to get a test to run or it will extract the suite automatically.
 * <pre>
 * public static Test suite() {
 *    suite.addTest(new MathTest("testAdd"));
 *    suite.addTest(new MathTest("testDivideByZero"));
 *    return suite;
 * }
 * </pre>
 * @see junit.framework.TestResult
 * @see junit.framework.TestSuite
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class TestCase extends junit.framework.Assert implements junit.framework.Test {

/**
 * No-arg constructor to enable serialization. This method
 * is not intended to be used by mere mortals without calling setName().
 * @apiSince 1
 */

public TestCase() { throw new RuntimeException("Stub!"); }

/**
 * Constructs a test case with the given name.
 * @apiSince 1
 */

public TestCase(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Counts the number of test cases executed by run(TestResult result).
 * @apiSince 1
 */

public int countTestCases() { throw new RuntimeException("Stub!"); }

/**
 * Creates a default TestResult object
 *
 * @see junit.framework.TestResult
 * @apiSince 1
 */

protected junit.framework.TestResult createResult() { throw new RuntimeException("Stub!"); }

/**
 * A convenience method to run this test, collecting the results with a
 * default TestResult object.
 *
 * @see junit.framework.TestResult
 * @apiSince 1
 */

public junit.framework.TestResult run() { throw new RuntimeException("Stub!"); }

/**
 * Runs the test case and collects the results in TestResult.
 * @apiSince 1
 */

public void run(junit.framework.TestResult result) { throw new RuntimeException("Stub!"); }

/**
 * Runs the bare test sequence.
 * @throws java.lang.Throwable if any exception is thrown
 * @apiSince 1
 */

public void runBare() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/**
 * Override to run the test and assert its state.
 * @throws java.lang.Throwable if any exception is thrown
 * @apiSince 1
 */

protected void runTest() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/**
 * Sets up the fixture, for example, open a network connection.
 * This method is called before a test is executed.
 * @apiSince 1
 */

protected void setUp() throws java.lang.Exception { throw new RuntimeException("Stub!"); }

/**
 * Tears down the fixture, for example, close a network connection.
 * This method is called after a test is executed.
 * @apiSince 1
 */

protected void tearDown() throws java.lang.Exception { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of the test case
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Gets the name of a TestCase
 * @return the name of the TestCase
 * @apiSince 1
 */

public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * Sets the name of a TestCase
 * @param name the name to set
 * @apiSince 1
 */

public void setName(java.lang.String name) { throw new RuntimeException("Stub!"); }
}

