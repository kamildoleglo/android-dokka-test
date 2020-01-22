/* GENERATED SOURCE. DO NOT MODIFY. */
// © 2017 and later: Unicode, Inc. and others.
// License & terms of use: http://www.unicode.org/copyright.html#License

package android.icu.number;

import java.math.BigDecimal;
import java.text.AttributedCharacterIterator;

/**
 * The result of a number formatting operation. This class allows the result to be exported in several
 * data types, including a String, an AttributedCharacterIterator, and a BigDecimal.
 *
 * Instances of this class are immutable and thread-safe.
 *
 * @see android.icu.number.NumberFormatter
 * @apiSince R
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class FormattedNumber implements java.lang.CharSequence {

FormattedNumber() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince R
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * @hide draft / provisional / internal are hidden on Android
 */

public int length() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * @hide draft / provisional / internal are hidden on Android
 */

public char charAt(int index) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * @hide draft / provisional / internal are hidden on Android
 */

public java.lang.CharSequence subSequence(int start, int end) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince R
 */

public java.text.AttributedCharacterIterator toCharacterIterator() { throw new RuntimeException("Stub!"); }

/**
 * Export the formatted number as a BigDecimal. This endpoint is useful for obtaining the exact
 * number being printed after scaling and rounding have been applied by the number formatting
 * pipeline.
 *
 * @return A BigDecimal representation of the formatted number.
 * @see android.icu.number.NumberFormatter
 * @apiSince R
 */

public java.math.BigDecimal toBigDecimal() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * @hide draft / provisional / internal are hidden on Android
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * @hide draft / provisional / internal are hidden on Android
 */

public boolean equals(java.lang.Object other) { throw new RuntimeException("Stub!"); }
}

