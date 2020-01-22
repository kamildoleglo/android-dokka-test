
package junit.runner;

import junit.framework.Test;

/**
 * Base class for all test runners.
 * This class was born live on stage in Sardinia during XP2000.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class BaseTestRunner implements junit.framework.TestListener {

public BaseTestRunner() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public synchronized void startTest(junit.framework.Test test) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected static void setPreferences(java.util.Properties preferences) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected static java.util.Properties getPreferences() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static void savePreferences() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setPreference(java.lang.String key, java.lang.String value) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public synchronized void endTest(junit.framework.Test test) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public synchronized void addError(junit.framework.Test test, java.lang.Throwable t) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public synchronized void addFailure(junit.framework.Test test, junit.framework.AssertionFailedError t) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public abstract void testStarted(java.lang.String testName);

/** @apiSince 1 */

public abstract void testEnded(java.lang.String testName);

/** @apiSince 1 */

public abstract void testFailed(int status, junit.framework.Test test, java.lang.Throwable t);

/**
 * Returns the Test corresponding to the given suite. This is
 * a template method, subclasses override runFailed(), clearStatus().
 * @apiSince 1
 */

public junit.framework.Test getTest(java.lang.String suiteClassName) { throw new RuntimeException("Stub!"); }

/**
 * Returns the formatted string of the elapsed time.
 * @apiSince 1
 */

public java.lang.String elapsedTimeAsString(long runTime) { throw new RuntimeException("Stub!"); }

/**
 * Processes the command line arguments and
 * returns the name of the suite class to run or null
 * @apiSince 1
 */

protected java.lang.String processArguments(java.lang.String[] args) { throw new RuntimeException("Stub!"); }

/**
 * Sets the loading behaviour of the test runner
 * @apiSince 1
 */

public void setLoading(boolean enable) { throw new RuntimeException("Stub!"); }

/**
 * Extract the class name from a String in VA/Java style
 * @apiSince 1
 */

public java.lang.String extractClassName(java.lang.String className) { throw new RuntimeException("Stub!"); }

/**
 * Truncates a String to the maximum length.
 * @apiSince 1
 */

public static java.lang.String truncate(java.lang.String s) { throw new RuntimeException("Stub!"); }

/**
 * Override to define how to handle a failed loading of
 * a test suite.
 * @apiSince 1
 */

protected abstract void runFailed(java.lang.String message);

/**
 * Returns the loader to be used.
 *
 * @deprecated not present in JUnit4.10
 * @apiSince 1
 * @deprecatedSince 16
 */

@Deprecated
public junit.runner.TestSuiteLoader getLoader() { throw new RuntimeException("Stub!"); }

/**
 * Returns the loaded Class for a suite name.
 * @apiSince 1
 */

protected java.lang.Class<?> loadSuiteClass(java.lang.String suiteClassName) throws java.lang.ClassNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Clears the status message.
 * @apiSince 1
 */

protected void clearStatus() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected boolean useReloadingTestSuiteLoader() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static java.lang.String getPreference(java.lang.String key) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static int getPreference(java.lang.String key, int dflt) { throw new RuntimeException("Stub!"); }

/**
 * Returns a filtered stack trace
 * @apiSince 1
 */

public static java.lang.String getFilteredTrace(java.lang.Throwable t) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated not present in JUnit4.10
 * @apiSince 1
 * @deprecatedSince 16
 */

@Deprecated
public static boolean inVAJava() { throw new RuntimeException("Stub!"); }

/**
 * Filters stack frames from internal JUnit classes
 * @apiSince 1
 */

public static java.lang.String getFilteredTrace(java.lang.String stack) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected static boolean showStackRaw() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static final java.lang.String SUITE_METHODNAME = "suite";
}

