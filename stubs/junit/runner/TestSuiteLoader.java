
package junit.runner;


/**
 * An interface to define how a test suite should be loaded.
 *
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface TestSuiteLoader {

/** @apiSince 1 */

public java.lang.Class load(java.lang.String suiteClassName) throws java.lang.ClassNotFoundException;

/** @apiSince 1 */

public java.lang.Class reload(java.lang.Class aClass) throws java.lang.ClassNotFoundException;
}

