
package junit.framework;


/**
 * A Listener for test progress
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface TestListener {

/**
 * An error occurred.
 * @apiSince 1
 */

public void addError(junit.framework.Test test, java.lang.Throwable t);

/**
 * A failure occurred.
 * @apiSince 1
 */

public void addFailure(junit.framework.Test test, junit.framework.AssertionFailedError t);

/**
 * A test ended.
 * @apiSince 1
 */

public void endTest(junit.framework.Test test);

/**
 * A test started.
 * @apiSince 1
 */

public void startTest(junit.framework.Test test);
}

