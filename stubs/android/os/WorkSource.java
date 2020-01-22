
package android.os;


/**
 * Describes the source of some work that may be done by someone else.
 * Currently the public representation of what a work source is is not
 * defined; this is an opaque container.
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class WorkSource implements android.os.Parcelable {

/**
 * Create an empty work source.
 * @apiSince 9
 */

public WorkSource() { throw new RuntimeException("Stub!"); }

/**
 * Create a new WorkSource that is a copy of an existing one.
 * If <var>orig</var> is null, an empty WorkSource is created.
 * @apiSince 9
 */

public WorkSource(android.os.WorkSource orig) { throw new RuntimeException("Stub!"); }

/**
 * Clear this WorkSource to be empty.
 * @apiSince 9
 */

public void clear() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param o This value may be {@code null}.
 * @apiSince 9
 */

public boolean equals(@androidx.annotation.Nullable java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Compare this WorkSource with another.
 * @param other The WorkSource to compare against.
 * @return If there is a difference, true is returned.
 * @apiSince 9
 */

public boolean diff(android.os.WorkSource other) { throw new RuntimeException("Stub!"); }

/**
 * Replace the current contents of this work source with the given
 * work source.  If {@code other} is null, the current work source
 * will be made empty.
 * @apiSince 9
 */

public void set(android.os.WorkSource other) { throw new RuntimeException("Stub!"); }

/**
 * Merge the contents of <var>other</var> WorkSource in to this one.
 *
 * @param other The other WorkSource whose contents are to be merged.
 * @return Returns true if any new sources were added.
 * @apiSince 9
 */

public boolean add(android.os.WorkSource other) { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public boolean remove(android.os.WorkSource other) { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.os.WorkSource> CREATOR;
static { CREATOR = null; }
}

