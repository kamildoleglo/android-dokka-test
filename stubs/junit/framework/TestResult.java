
package junit.framework;

import java.util.Enumeration;

/**
 * A <code>TestResult</code> collects the results of executing
 * a test case. It is an instance of the Collecting Parameter pattern.
 * The test framework distinguishes between <i>failures</i> and <i>errors</i>.
 * A failure is anticipated and checked for with assertions. Errors are
 * unanticipated problems like an {@link java.lang.ArrayIndexOutOfBoundsException ArrayIndexOutOfBoundsException}.
 *
 * @see junit.framework.Test
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TestResult {

/** @apiSince 1 */

public TestResult() { throw new RuntimeException("Stub!"); }

/**
 * Adds an error to the list of errors. The passed in exception
 * caused the error.
 * @apiSince 1
 */

public synchronized void addError(junit.framework.Test test, java.lang.Throwable t) { throw new RuntimeException("Stub!"); }

/**
 * Adds a failure to the list of failures. The passed in exception
 * caused the failure.
 * @apiSince 1
 */

public synchronized void addFailure(junit.framework.Test test, junit.framework.AssertionFailedError t) { throw new RuntimeException("Stub!"); }

/**
 * Registers a TestListener
 * @apiSince 1
 */

public synchronized void addListener(junit.framework.TestListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Unregisters a TestListener
 * @apiSince 1
 */

public synchronized void removeListener(junit.framework.TestListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Informs the result that a test was completed.
 * @apiSince 1
 */

public void endTest(junit.framework.Test test) { throw new RuntimeException("Stub!"); }

/**
 * Gets the number of detected errors.
 * @apiSince 1
 */

public synchronized int errorCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns an Enumeration for the errors
 * @apiSince 1
 */

public synchronized java.util.Enumeration<junit.framework.TestFailure> errors() { throw new RuntimeException("Stub!"); }

/**
 * Gets the number of detected failures.
 * @apiSince 1
 */

public synchronized int failureCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns an Enumeration for the failures
 * @apiSince 1
 */

public synchronized java.util.Enumeration<junit.framework.TestFailure> failures() { throw new RuntimeException("Stub!"); }

/**
 * Runs a TestCase.
 * @apiSince 1
 */

protected void run(junit.framework.TestCase test) { throw new RuntimeException("Stub!"); }

/**
 * Gets the number of run tests.
 * @apiSince 1
 */

public synchronized int runCount() { throw new RuntimeException("Stub!"); }

/**
 * Runs a TestCase.
 * @apiSince 1
 */

public void runProtected(junit.framework.Test test, junit.framework.Protectable p) { throw new RuntimeException("Stub!"); }

/**
 * Checks whether the test run should stop
 * @apiSince 1
 */

public synchronized boolean shouldStop() { throw new RuntimeException("Stub!"); }

/**
 * Informs the result that a test will be started.
 * @apiSince 1
 */

public void startTest(junit.framework.Test test) { throw new RuntimeException("Stub!"); }

/**
 * Marks that the test run should stop.
 * @apiSince 1
 */

public synchronized void stop() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the entire test was successful or not.
 * @apiSince 1
 */

public synchronized boolean wasSuccessful() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected java.util.Vector<junit.framework.TestFailure> fErrors;

/** @apiSince 1 */

protected java.util.Vector<junit.framework.TestFailure> fFailures;

/** @apiSince 1 */

protected java.util.Vector<junit.framework.TestListener> fListeners;

/** @apiSince 1 */

protected int fRunTests;
}

