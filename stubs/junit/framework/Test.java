
package junit.framework;


/**
 * A <em>Test</em> can be run and collect its results.
 *
 * @see junit.framework.TestResult
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface Test {

/**
 * Counts the number of test cases that will be run by this test.
 * @apiSince 1
 */

public int countTestCases();

/**
 * Runs a test and collects its result in a TestResult instance.
 * @apiSince 1
 */

public void run(junit.framework.TestResult result);
}

