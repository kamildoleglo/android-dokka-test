/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package android.util;


/**
 * Immutable class for describing the range of two numeric values.
 * <p>
 * A range (or "interval") defines the inclusive boundaries around a contiguous span of
 * values of some {@link java.lang.Comparable Comparable} type; for example,
 * "integers from 1 to 100 inclusive."
 * </p>
 * <p>
 * All ranges are bounded, and the left side of the range is always {@code <=}
 * the right side of the range.
 * </p>
 *
 * <p>Although the implementation itself is immutable, there is no restriction that objects
 * stored must also be immutable. If mutable objects are stored here, then the range
 * effectively becomes mutable. </p>
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Range<T extends java.lang.Comparable<? super T>> {

/**
 * Create a new immutable range.
 *
 * <p>
 * The endpoints are {@code [lower, upper]}; that
 * is the range is bounded. {@code lower} must be {@link java.lang.Comparable#compareTo Comparable#compareTo}
 * to {@code upper}.
 * </p>
 *
 * @param lower The lower endpoint (inclusive)
 * @param upper The upper endpoint (inclusive)
 *
 * @throws java.lang.NullPointerException if {@code lower} or {@code upper} is {@code null}
 * @apiSince 21
 */

public Range(T lower, T upper) { throw new RuntimeException("Stub!"); }

/**
 * Create a new immutable range, with the argument types inferred.
 *
 * <p>
 * The endpoints are {@code [lower, upper]}; that
 * is the range is bounded. {@code lower} must be {@link java.lang.Comparable#compareTo Comparable#compareTo}
 * to {@code upper}.
 * </p>
 *
 * @param lower The lower endpoint (inclusive)
 * @param upper The upper endpoint (inclusive)
 *
 * @throws java.lang.NullPointerException if {@code lower} or {@code upper} is {@code null}
 * @apiSince 21
 */

public static <T extends java.lang.Comparable<? super T>> android.util.Range<T> create(T lower, T upper) { throw new RuntimeException("Stub!"); }

/**
 * Get the lower endpoint.
 *
 * @return a non-{@code null} {@code T} reference
 * @apiSince 21
 */

public T getLower() { throw new RuntimeException("Stub!"); }

/**
 * Get the upper endpoint.
 *
 * @return a non-{@code null} {@code T} reference
 * @apiSince 21
 */

public T getUpper() { throw new RuntimeException("Stub!"); }

/**
 * Checks if the {@code value} is within the bounds of this range.
 *
 * <p>A value is considered to be within this range if it's {@code >=}
 * the lower endpoint <i>and</i> {@code <=} the upper endpoint (using the {@link java.lang.Comparable Comparable}
 * interface.)</p>
 *
 * @param value a non-{@code null} {@code T} reference
 * @return {@code true} if the value is within this inclusive range, {@code false} otherwise
 *
 * @throws java.lang.NullPointerException if {@code value} was {@code null}
 * @apiSince 21
 */

public boolean contains(T value) { throw new RuntimeException("Stub!"); }

/**
 * Checks if another {@code range} is within the bounds of this range.
 *
 * <p>A range is considered to be within this range if both of its endpoints
 * are within this range.</p>
 *
 * @param range a non-{@code null} {@code T} reference
 * @return {@code true} if the range is within this inclusive range, {@code false} otherwise
 *
 * @throws java.lang.NullPointerException if {@code range} was {@code null}
 * @apiSince 21
 */

public boolean contains(android.util.Range<T> range) { throw new RuntimeException("Stub!"); }

/**
 * Compare two ranges for equality.
 *
 * <p>A range is considered equal if and only if both the lower and upper endpoints
 * are also equal.</p>
 *
 * @return {@code true} if the ranges are equal, {@code false} otherwise
 * @apiSince 21
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Clamps {@code value} to this range.
 *
 * <p>If the value is within this range, it is returned.  Otherwise, if it
 * is {@code <} than the lower endpoint, the lower endpoint is returned,
 * else the upper endpoint is returned. Comparisons are performed using the
 * {@link java.lang.Comparable Comparable} interface.</p>
 *
 * @param value a non-{@code null} {@code T} reference
 * @return {@code value} clamped to this range.
 * @apiSince 21
 */

public T clamp(T value) { throw new RuntimeException("Stub!"); }

/**
 * Returns the intersection of this range and another {@code range}.
 * <p>
 * E.g. if a {@code <} b {@code <} c {@code <} d, the
 * intersection of [a, c] and [b, d] ranges is [b, c].
 * As the endpoints are object references, there is no guarantee
 * which specific endpoint reference is used from the input ranges:</p>
 * <p>
 * E.g. if a {@code ==} a' {@code <} b {@code <} c, the
 * intersection of [a, b] and [a', c] ranges could be either
 * [a, b] or ['a, b], where [a, b] could be either the exact
 * input range, or a newly created range with the same endpoints.</p>
 *
 * @param range a non-{@code null} {@code Range<T>} reference
 * @return the intersection of this range and the other range.
 *
 * @throws java.lang.NullPointerException if {@code range} was {@code null}
 * @throws java.lang.IllegalArgumentException if the ranges are disjoint.
 * @apiSince 21
 */

public android.util.Range<T> intersect(android.util.Range<T> range) { throw new RuntimeException("Stub!"); }

/**
 * Returns the intersection of this range and the inclusive range
 * specified by {@code [lower, upper]}.
 * <p>
 * See {@link #intersect(android.util.Range)} for more details.</p>
 *
 * @param lower a non-{@code null} {@code T} reference
 * @param upper a non-{@code null} {@code T} reference
 * @return the intersection of this range and the other range
 *
 * @throws java.lang.NullPointerException if {@code lower} or {@code upper} was {@code null}
 * @throws java.lang.IllegalArgumentException if the ranges are disjoint.
 * @apiSince 21
 */

public android.util.Range<T> intersect(T lower, T upper) { throw new RuntimeException("Stub!"); }

/**
 * Returns the smallest range that includes this range and
 * another {@code range}.
 * <p>
 * E.g. if a {@code <} b {@code <} c {@code <} d, the
 * extension of [a, c] and [b, d] ranges is [a, d].
 * As the endpoints are object references, there is no guarantee
 * which specific endpoint reference is used from the input ranges:</p>
 * <p>
 * E.g. if a {@code ==} a' {@code <} b {@code <} c, the
 * extension of [a, b] and [a', c] ranges could be either
 * [a, c] or ['a, c], where ['a, c] could be either the exact
 * input range, or a newly created range with the same endpoints.</p>
 *
 * @param range a non-{@code null} {@code Range<T>} reference
 * @return the extension of this range and the other range.
 *
 * @throws java.lang.NullPointerException if {@code range} was {@code null}
 * @apiSince 21
 */

public android.util.Range<T> extend(android.util.Range<T> range) { throw new RuntimeException("Stub!"); }

/**
 * Returns the smallest range that includes this range and
 * the inclusive range specified by {@code [lower, upper]}.
 * <p>
 * See {@link #extend(android.util.Range)} for more details.</p>
 *
 * @param lower a non-{@code null} {@code T} reference
 * @param upper a non-{@code null} {@code T} reference
 * @return the extension of this range and the other range.
 *
 * @throws java.lang.NullPointerException if {@code lower} or {@code
 *                              upper} was {@code null}
 * @apiSince 21
 */

public android.util.Range<T> extend(T lower, T upper) { throw new RuntimeException("Stub!"); }

/**
 * Returns the smallest range that includes this range and
 * the {@code value}.
 * <p>
 * See {@link #extend(android.util.Range)} for more details, as this method is
 * equivalent to {@code extend(Range.create(value, value))}.</p>
 *
 * @param value a non-{@code null} {@code T} reference
 * @return the extension of this range and the value.
 *
 * @throws java.lang.NullPointerException if {@code value} was {@code null}
 * @apiSince 21
 */

public android.util.Range<T> extend(T value) { throw new RuntimeException("Stub!"); }

/**
 * Return the range as a string representation {@code "[lower, upper]"}.
 *
 * @return string representation of the range
 * @apiSince 21
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 21
 */

public int hashCode() { throw new RuntimeException("Stub!"); }
}

