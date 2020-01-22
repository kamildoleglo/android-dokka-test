/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */


package java.util;

import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.DoubleConsumer;
import java.util.function.LongConsumer;

/**
 * A base type for primitive specializations of {@code Iterator}.  Specialized
 * subtypes are provided for {@link java.util.PrimitiveIterator.OfInt OfInt}, {@link java.util.PrimitiveIterator.OfLong OfLong}, and
 * {@link java.util.PrimitiveIterator.OfDouble OfDouble} values.
 *
 * <p>The specialized subtype default implementations of {@link java.util.Iterator#next Iterator#next}
 * and {@link java.util.Iterator#forEachRemaining(java.util.function.Consumer) Iterator#forEachRemaining(java.util.function.Consumer)} box
 * primitive values to instances of their corresponding wrapper class.  Such
 * boxing may offset any advantages gained when using the primitive
 * specializations.  To avoid boxing, the corresponding primitive-based methods
 * should be used.  For example, {@link java.util.PrimitiveIterator.OfInt#nextInt() PrimitiveIterator.OfInt#nextInt()} and
 * {@link java.util.PrimitiveIterator.OfInt#forEachRemaining(java.util.function.IntConsumer) PrimitiveIterator.OfInt#forEachRemaining(java.util.function.IntConsumer)}
 * should be used in preference to {@link java.util.PrimitiveIterator.OfInt#next() PrimitiveIterator.OfInt#next()} and
 * {@link java.util.PrimitiveIterator.OfInt#forEachRemaining(java.util.function.Consumer) PrimitiveIterator.OfInt#forEachRemaining(java.util.function.Consumer)}.
 *
 * <p>Iteration of primitive values using boxing-based methods
 * {@link java.util.Iterator#next Iterator#next} and
 * {@link java.util.Iterator#forEachRemaining(java.util.function.Consumer) Iterator#forEachRemaining(java.util.function.Consumer)},
 * does not affect the order in which the values, transformed to boxed values,
 * are encountered.
 *
 * @implNote
 * If the boolean system property {@code org.openjdk.java.util.stream.tripwire}
 * is set to {@code true} then diagnostic warnings are reported if boxing of
 * primitive values occur when operating on primitive subtype specializations.
 *
 * @param <T> the type of elements returned by this PrimitiveIterator.  The
 *        type must be a wrapper type for a primitive type, such as
 *        {@code Integer} for the primitive {@code int} type.
 * @param <T_CONS> the type of primitive consumer.  The type must be a
 *        primitive specialization of {@link java.util.function.Consumer} for
 *        {@code T}, such as {@link java.util.function.IntConsumer} for
 *        {@code Integer}.
 *
 * @since 1.8
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface PrimitiveIterator<T, T_CONS> extends java.util.Iterator<T> {

/**
 * Performs the given action for each remaining element, in the order
 * elements occur when iterating, until all elements have been processed
 * or the action throws an exception.  Errors or runtime exceptions
 * thrown by the action are relayed to the caller.
 *
 * @param action The action to be performed for each element
 * @throws java.lang.NullPointerException if the specified action is null
 * @apiSince 24
 */

public void forEachRemaining(T_CONS action);
/**
 * An Iterator specialized for {@code double} values.
 * @since 1.8
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OfDouble extends java.util.PrimitiveIterator<java.lang.Double,java.util.function.DoubleConsumer> {

/**
 * Returns the next {@code double} element in the iteration.
 *
 * @return the next {@code double} element in the iteration
 * @throws java.util.NoSuchElementException if the iteration has no more elements
 * @apiSince 24
 */

public double nextDouble();

/**
 * Performs the given action for each remaining element until all elements
 * have been processed or the action throws an exception.  Actions are
 * performed in the order of iteration, if that order is specified.
 * Exceptions thrown by the action are relayed to the caller.
 *
 * @implSpec
 * <p>The default implementation behaves as if:
 * <pre>{@code
 *     while (hasNext())
 *         action.accept(nextDouble());
 * }</pre>
 *
 * @param action The action to be performed for each element
 * @throws java.lang.NullPointerException if the specified action is null
 * @apiSince 24
 */

public default void forEachRemaining(java.util.function.DoubleConsumer action) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @implSpec
 * The default implementation boxes the result of calling
 * {@link #nextDouble()}, and returns that boxed result.
 * @apiSince 24
 */

public default java.lang.Double next() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @implSpec
 * If the action is an instance of {@code DoubleConsumer} then it is
 * cast to {@code DoubleConsumer} and passed to
 * {@link #forEachRemaining}; otherwise the action is adapted to
 * an instance of {@code DoubleConsumer}, by boxing the argument of
 * {@code DoubleConsumer}, and then passed to
 * {@link #forEachRemaining}.
 * @apiSince 24
 */

public default void forEachRemaining(java.util.function.Consumer<? super java.lang.Double> action) { throw new RuntimeException("Stub!"); }
}

/**
 * An Iterator specialized for {@code int} values.
 * @since 1.8
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OfInt extends java.util.PrimitiveIterator<java.lang.Integer,java.util.function.IntConsumer> {

/**
 * Returns the next {@code int} element in the iteration.
 *
 * @return the next {@code int} element in the iteration
 * @throws java.util.NoSuchElementException if the iteration has no more elements
 * @apiSince 24
 */

public int nextInt();

/**
 * Performs the given action for each remaining element until all elements
 * have been processed or the action throws an exception.  Actions are
 * performed in the order of iteration, if that order is specified.
 * Exceptions thrown by the action are relayed to the caller.
 *
 * @implSpec
 * <p>The default implementation behaves as if:
 * <pre>{@code
 *     while (hasNext())
 *         action.accept(nextInt());
 * }</pre>
 *
 * @param action The action to be performed for each element
 * @throws java.lang.NullPointerException if the specified action is null
 * @apiSince 24
 */

public default void forEachRemaining(java.util.function.IntConsumer action) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @implSpec
 * The default implementation boxes the result of calling
 * {@link #nextInt()}, and returns that boxed result.
 * @apiSince 24
 */

public default java.lang.Integer next() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @implSpec
 * If the action is an instance of {@code IntConsumer} then it is cast
 * to {@code IntConsumer} and passed to {@link #forEachRemaining};
 * otherwise the action is adapted to an instance of
 * {@code IntConsumer}, by boxing the argument of {@code IntConsumer},
 * and then passed to {@link #forEachRemaining}.
 * @apiSince 24
 */

public default void forEachRemaining(java.util.function.Consumer<? super java.lang.Integer> action) { throw new RuntimeException("Stub!"); }
}

/**
 * An Iterator specialized for {@code long} values.
 * @since 1.8
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OfLong extends java.util.PrimitiveIterator<java.lang.Long,java.util.function.LongConsumer> {

/**
 * Returns the next {@code long} element in the iteration.
 *
 * @return the next {@code long} element in the iteration
 * @throws java.util.NoSuchElementException if the iteration has no more elements
 * @apiSince 24
 */

public long nextLong();

/**
 * Performs the given action for each remaining element until all elements
 * have been processed or the action throws an exception.  Actions are
 * performed in the order of iteration, if that order is specified.
 * Exceptions thrown by the action are relayed to the caller.
 *
 * @implSpec
 * <p>The default implementation behaves as if:
 * <pre>{@code
 *     while (hasNext())
 *         action.accept(nextLong());
 * }</pre>
 *
 * @param action The action to be performed for each element
 * @throws java.lang.NullPointerException if the specified action is null
 * @apiSince 24
 */

public default void forEachRemaining(java.util.function.LongConsumer action) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @implSpec
 * The default implementation boxes the result of calling
 * {@link #nextLong()}, and returns that boxed result.
 * @apiSince 24
 */

public default java.lang.Long next() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @implSpec
 * If the action is an instance of {@code LongConsumer} then it is cast
 * to {@code LongConsumer} and passed to {@link #forEachRemaining};
 * otherwise the action is adapted to an instance of
 * {@code LongConsumer}, by boxing the argument of {@code LongConsumer},
 * and then passed to {@link #forEachRemaining}.
 * @apiSince 24
 */

public default void forEachRemaining(java.util.function.Consumer<? super java.lang.Long> action) { throw new RuntimeException("Stub!"); }
}

}

