
package junit.framework;


/**
 * Thrown when an assert equals for Strings failed.
 *
 * Inspired by a patch from Alex Chaffee mailto:alex@purpletech.com
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ComparisonFailure extends junit.framework.AssertionFailedError {

/**
 * Constructs a comparison failure.
 * @param message the identifying message or null
 * @param expected the expected string value
 * @param actual the actual string value
 * @apiSince 1
 */

public ComparisonFailure(java.lang.String message, java.lang.String expected, java.lang.String actual) { throw new RuntimeException("Stub!"); }

/**
 * Returns "..." in place of common prefix and "..." in
 * place of common suffix between expected and actual.
 *
 * @see java.lang.Throwable#getMessage()
 * @apiSince 1
 */

public java.lang.String getMessage() { throw new RuntimeException("Stub!"); }

/**
 * Gets the actual string value
 * @return the actual string value
 * @apiSince 16
 */

public java.lang.String getActual() { throw new RuntimeException("Stub!"); }

/**
 * Gets the expected string value
 * @return the expected string value
 * @apiSince 16
 */

public java.lang.String getExpected() { throw new RuntimeException("Stub!"); }
}

