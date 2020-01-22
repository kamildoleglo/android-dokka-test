
package junit.framework;


/**
 * A <code>TestFailure</code> collects a failed test together with
 * the caught exception.
 * @see junit.framework.TestResult
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TestFailure {

/**
 * Constructs a TestFailure with the given test and exception.
 * @apiSince 1
 */

public TestFailure(junit.framework.Test failedTest, java.lang.Throwable thrownException) { throw new RuntimeException("Stub!"); }

/**
 * Gets the failed test.
 * @apiSince 1
 */

public junit.framework.Test failedTest() { throw new RuntimeException("Stub!"); }

/**
 * Gets the thrown exception.
 * @apiSince 1
 */

public java.lang.Throwable thrownException() { throw new RuntimeException("Stub!"); }

/**
 * Returns a short description of the failure.
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String trace() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String exceptionMessage() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean isFailure() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected junit.framework.Test fFailedTest;

/** @apiSince 1 */

protected java.lang.Throwable fThrownException;
}

