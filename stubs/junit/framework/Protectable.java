
package junit.framework;


/**
 * A <em>Protectable</em> can be run and can throw a Throwable.
 *
 * @see junit.framework.TestResult
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface Protectable {

/**
 * Run the the following method protected.
 * @apiSince 1
 */

public void protect() throws java.lang.Throwable;
}

