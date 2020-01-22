
package junit.framework;


/**
 * A set of assert methods.  Messages are only displayed when an assert fails.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Assert {

/**
 * Protect constructor since it is a static only class
 * @apiSince 1
 */

protected Assert() { throw new RuntimeException("Stub!"); }

/**
 * Asserts that a condition is true. If it isn't it throws
 * an AssertionFailedError with the given message.
 * @apiSince 1
 */

public static void assertTrue(java.lang.String message, boolean condition) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that a condition is true. If it isn't it throws
 * an AssertionFailedError.
 * @apiSince 1
 */

public static void assertTrue(boolean condition) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that a condition is false. If it isn't it throws
 * an AssertionFailedError with the given message.
 * @apiSince 1
 */

public static void assertFalse(java.lang.String message, boolean condition) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that a condition is false. If it isn't it throws
 * an AssertionFailedError.
 * @apiSince 1
 */

public static void assertFalse(boolean condition) { throw new RuntimeException("Stub!"); }

/**
 * Fails a test with the given message.
 * @apiSince 1
 */

public static void fail(java.lang.String message) { throw new RuntimeException("Stub!"); }

/**
 * Fails a test with no message.
 * @apiSince 1
 */

public static void fail() { throw new RuntimeException("Stub!"); }

/**
 * Asserts that two objects are equal. If they are not
 * an AssertionFailedError is thrown with the given message.
 * @apiSince 1
 */

public static void assertEquals(java.lang.String message, java.lang.Object expected, java.lang.Object actual) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that two objects are equal. If they are not
 * an AssertionFailedError is thrown.
 * @apiSince 1
 */

public static void assertEquals(java.lang.Object expected, java.lang.Object actual) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that two Strings are equal.
 * @apiSince 1
 */

public static void assertEquals(java.lang.String message, java.lang.String expected, java.lang.String actual) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that two Strings are equal.
 * @apiSince 1
 */

public static void assertEquals(java.lang.String expected, java.lang.String actual) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that two doubles are equal concerning a delta.  If they are not
 * an AssertionFailedError is thrown with the given message.  If the expected
 * value is infinity then the delta value is ignored.
 * @apiSince 1
 */

public static void assertEquals(java.lang.String message, double expected, double actual, double delta) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that two doubles are equal concerning a delta. If the expected
 * value is infinity then the delta value is ignored.
 * @apiSince 1
 */

public static void assertEquals(double expected, double actual, double delta) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that two floats are equal concerning a positive delta. If they
 * are not an AssertionFailedError is thrown with the given message. If the
 * expected value is infinity then the delta value is ignored.
 * @apiSince 1
 */

public static void assertEquals(java.lang.String message, float expected, float actual, float delta) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that two floats are equal concerning a delta. If the expected
 * value is infinity then the delta value is ignored.
 * @apiSince 1
 */

public static void assertEquals(float expected, float actual, float delta) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that two longs are equal. If they are not
 * an AssertionFailedError is thrown with the given message.
 * @apiSince 1
 */

public static void assertEquals(java.lang.String message, long expected, long actual) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that two longs are equal.
 * @apiSince 1
 */

public static void assertEquals(long expected, long actual) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that two booleans are equal. If they are not
 * an AssertionFailedError is thrown with the given message.
 * @apiSince 1
 */

public static void assertEquals(java.lang.String message, boolean expected, boolean actual) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that two booleans are equal.
 * @apiSince 1
 */

public static void assertEquals(boolean expected, boolean actual) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that two bytes are equal. If they are not
 * an AssertionFailedError is thrown with the given message.
 * @apiSince 1
 */

public static void assertEquals(java.lang.String message, byte expected, byte actual) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that two bytes are equal.
 * @apiSince 1
 */

public static void assertEquals(byte expected, byte actual) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that two chars are equal. If they are not
 * an AssertionFailedError is thrown with the given message.
 * @apiSince 1
 */

public static void assertEquals(java.lang.String message, char expected, char actual) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that two chars are equal.
 * @apiSince 1
 */

public static void assertEquals(char expected, char actual) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that two shorts are equal. If they are not
 * an AssertionFailedError is thrown with the given message.
 * @apiSince 1
 */

public static void assertEquals(java.lang.String message, short expected, short actual) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that two shorts are equal.
 * @apiSince 1
 */

public static void assertEquals(short expected, short actual) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that two ints are equal. If they are not
 * an AssertionFailedError is thrown with the given message.
 * @apiSince 1
 */

public static void assertEquals(java.lang.String message, int expected, int actual) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that two ints are equal.
 * @apiSince 1
 */

public static void assertEquals(int expected, int actual) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that an object isn't null.
 * @apiSince 1
 */

public static void assertNotNull(java.lang.Object object) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that an object isn't null. If it is
 * an AssertionFailedError is thrown with the given message.
 * @apiSince 1
 */

public static void assertNotNull(java.lang.String message, java.lang.Object object) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that an object is null. If it isn't an {@link java.lang.AssertionError AssertionError} is
 * thrown.
 * Message contains: Expected: <null> but was: object
 *
 * @param object
 *            Object to check or <code>null</code>
 * @apiSince 1
 */

public static void assertNull(java.lang.Object object) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that an object is null.  If it is not
 * an AssertionFailedError is thrown with the given message.
 * @apiSince 1
 */

public static void assertNull(java.lang.String message, java.lang.Object object) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that two objects refer to the same object. If they are not
 * an AssertionFailedError is thrown with the given message.
 * @apiSince 1
 */

public static void assertSame(java.lang.String message, java.lang.Object expected, java.lang.Object actual) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that two objects refer to the same object. If they are not
 * the same an AssertionFailedError is thrown.
 * @apiSince 1
 */

public static void assertSame(java.lang.Object expected, java.lang.Object actual) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that two objects do not refer to the same object. If they do
 * refer to the same object an AssertionFailedError is thrown with the
 * given message.
 * @apiSince 1
 */

public static void assertNotSame(java.lang.String message, java.lang.Object expected, java.lang.Object actual) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that two objects do not refer to the same object. If they do
 * refer to the same object an AssertionFailedError is thrown.
 * @apiSince 1
 */

public static void assertNotSame(java.lang.Object expected, java.lang.Object actual) { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public static void failSame(java.lang.String message) { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public static void failNotSame(java.lang.String message, java.lang.Object expected, java.lang.Object actual) { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public static void failNotEquals(java.lang.String message, java.lang.Object expected, java.lang.Object actual) { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public static java.lang.String format(java.lang.String message, java.lang.Object expected, java.lang.Object actual) { throw new RuntimeException("Stub!"); }
}

