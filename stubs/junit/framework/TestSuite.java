
package junit.framework;


/**
 * <p>A <code>TestSuite</code> is a <code>Composite</code> of Tests.
 * It runs a collection of test cases. Here is an example using
 * the dynamic test definition.
 * <pre>
 * TestSuite suite= new TestSuite();
 * suite.addTest(new MathTest("testAdd"));
 * suite.addTest(new MathTest("testDivideByZero"));
 * </pre>
 * </p>
 *
 * <p>Alternatively, a TestSuite can extract the tests to be run automatically.
 * To do so you pass the class of your TestCase class to the
 * TestSuite constructor.
 * <pre>
 * TestSuite suite= new TestSuite(MathTest.class);
 * </pre>
 * </p>
 *
 * <p>This constructor creates a suite with all the methods
 * starting with "test" that take no arguments.</p>
 *
 * <p>A final option is to do the same for a large array of test classes.
 * <pre>
 * Class[] testClasses = { MathTest.class, AnotherTest.class }
 * TestSuite suite= new TestSuite(testClasses);
 * </pre>
 * </p>
 *
 * @see junit.framework.Test
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TestSuite implements junit.framework.Test {

/**
 * Constructs an empty TestSuite.
 * @apiSince 1
 */

public TestSuite() { throw new RuntimeException("Stub!"); }

/**
 * Constructs a TestSuite from the given class. Adds all the methods
 * starting with "test" as test cases to the suite.
 * Parts of this method were written at 2337 meters in the Hueffihuette,
 * Kanton Uri
 * @apiSince 1
 */

public TestSuite(java.lang.Class<?> theClass) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a TestSuite from the given class with the given name.
 * @see junit.framework.TestSuite#TestSuite(Class)
 * @apiSince 1
 */

public TestSuite(java.lang.Class<? extends junit.framework.TestCase> theClass, java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Constructs an empty TestSuite.
 * @apiSince 1
 */

public TestSuite(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a TestSuite from the given array of classes.
 * @param classes {@link junit.framework.TestCase TestCase}s
 * @apiSince 16
 */

public TestSuite(java.lang.Class<?>... classes) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a TestSuite from the given array of classes with the given name.
 * @see junit.framework.TestSuite#TestSuite(Class[])
 * @apiSince 16
 */

public TestSuite(java.lang.Class<? extends junit.framework.TestCase>[] classes, java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * ...as the moon sets over the early morning Merlin, Oregon
 * mountains, our intrepid adventurers type...
 * @apiSince 1
 */

public static junit.framework.Test createTest(java.lang.Class<?> theClass, java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Gets a constructor which takes a single String as
 * its argument or a no arg constructor.
 * @apiSince 1
 */

public static java.lang.reflect.Constructor<?> getTestConstructor(java.lang.Class<?> theClass) throws java.lang.NoSuchMethodException { throw new RuntimeException("Stub!"); }

/**
 * Returns a test which will fail and log a warning message.
 * @apiSince 16
 */

public static junit.framework.Test warning(java.lang.String message) { throw new RuntimeException("Stub!"); }

/**
 * Adds a test to the suite.
 * @apiSince 1
 */

public void addTest(junit.framework.Test test) { throw new RuntimeException("Stub!"); }

/**
 * Adds the tests from the given class to the suite
 * @apiSince 1
 */

public void addTestSuite(java.lang.Class<? extends junit.framework.TestCase> testClass) { throw new RuntimeException("Stub!"); }

/**
 * Counts the number of test cases that will be run by this test.
 * @apiSince 1
 */

public int countTestCases() { throw new RuntimeException("Stub!"); }

/**
 * Returns the name of the suite. Not all
 * test suites have a name and this method
 * can return null.
 * @apiSince 1
 */

public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * Runs the tests and collects their result in a TestResult.
 * @apiSince 1
 */

public void run(junit.framework.TestResult result) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void runTest(junit.framework.Test test, junit.framework.TestResult result) { throw new RuntimeException("Stub!"); }

/**
 * Sets the name of the suite.
 * @param name the name to set
 * @apiSince 1
 */

public void setName(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Returns the test at the given index
 * @apiSince 1
 */

public junit.framework.Test testAt(int index) { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of tests in this suite
 * @apiSince 1
 */

public int testCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns the tests as an enumeration
 * @apiSince 1
 */

public java.util.Enumeration<junit.framework.Test> tests() { throw new RuntimeException("Stub!"); }

/**
 @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

