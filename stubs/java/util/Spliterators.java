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

import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import java.util.function.Consumer;

/**
 * Static classes and methods for operating on or creating instances of
 * {@link java.util.Spliterator Spliterator} and its primitive specializations
 * {@link java.util.Spliterator.OfInt Spliterator.OfInt}, {@link java.util.Spliterator.OfLong Spliterator.OfLong}, and
 * {@link java.util.Spliterator.OfDouble Spliterator.OfDouble}.
 *
 * @see java.util.Spliterator
 * @since 1.8
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Spliterators {

private Spliterators() { throw new RuntimeException("Stub!"); }

/**
 * Creates an empty {@code Spliterator}
 *
 * <p>The empty spliterator reports {@link java.util.Spliterator#SIZED Spliterator#SIZED} and
 * {@link java.util.Spliterator#SUBSIZED Spliterator#SUBSIZED}.  Calls to
 * {@link java.util.Spliterator#trySplit()} always return {@code null}.
 *
 * @param <T> Type of elements
 * @return An empty spliterator
 * @apiSince 24
 */

public static <T> java.util.Spliterator<T> emptySpliterator() { throw new RuntimeException("Stub!"); }

/**
 * Creates an empty {@code Spliterator.OfInt}
 *
 * <p>The empty spliterator reports {@link java.util.Spliterator#SIZED Spliterator#SIZED} and
 * {@link java.util.Spliterator#SUBSIZED Spliterator#SUBSIZED}.  Calls to
 * {@link java.util.Spliterator#trySplit()} always return {@code null}.
 *
 * @return An empty spliterator
 * @apiSince 24
 */

public static java.util.Spliterator.OfInt emptyIntSpliterator() { throw new RuntimeException("Stub!"); }

/**
 * Creates an empty {@code Spliterator.OfLong}
 *
 * <p>The empty spliterator reports {@link java.util.Spliterator#SIZED Spliterator#SIZED} and
 * {@link java.util.Spliterator#SUBSIZED Spliterator#SUBSIZED}.  Calls to
 * {@link java.util.Spliterator#trySplit()} always return {@code null}.
 *
 * @return An empty spliterator
 * @apiSince 24
 */

public static java.util.Spliterator.OfLong emptyLongSpliterator() { throw new RuntimeException("Stub!"); }

/**
 * Creates an empty {@code Spliterator.OfDouble}
 *
 * <p>The empty spliterator reports {@link java.util.Spliterator#SIZED Spliterator#SIZED} and
 * {@link java.util.Spliterator#SUBSIZED Spliterator#SUBSIZED}.  Calls to
 * {@link java.util.Spliterator#trySplit()} always return {@code null}.
 *
 * @return An empty spliterator
 * @apiSince 24
 */

public static java.util.Spliterator.OfDouble emptyDoubleSpliterator() { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code Spliterator} covering the elements of a given array,
 * using a customized set of spliterator characteristics.
 *
 * <p>This method is provided as an implementation convenience for
 * Spliterators which store portions of their elements in arrays, and need
 * fine control over Spliterator characteristics.  Most other situations in
 * which a Spliterator for an array is needed should use
 * {@link java.util.Arrays#spliterator(java.lang.Object[]) Arrays#spliterator(Object[])}.
 *
 * <p>The returned spliterator always reports the characteristics
 * {@code SIZED} and {@code SUBSIZED}.  The caller may provide additional
 * characteristics for the spliterator to report; it is common to
 * additionally specify {@code IMMUTABLE} and {@code ORDERED}.
 *
 * @param <T> Type of elements
 * @param array The array, assumed to be unmodified during use
 * @param additionalCharacteristics Additional spliterator characteristics
 *        of this spliterator's source or elements beyond {@code SIZED} and
 *        {@code SUBSIZED} which are are always reported
 * @return A spliterator for an array
 * @throws java.lang.NullPointerException if the given array is {@code null}
 * @see java.util.Arrays#spliterator(Object[])
 * @apiSince 24
 */

public static <T> java.util.Spliterator<T> spliterator(java.lang.Object[] array, int additionalCharacteristics) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code Spliterator} covering a range of elements of a given
 * array, using a customized set of spliterator characteristics.
 *
 * <p>This method is provided as an implementation convenience for
 * Spliterators which store portions of their elements in arrays, and need
 * fine control over Spliterator characteristics.  Most other situations in
 * which a Spliterator for an array is needed should use
 * {@link java.util.Arrays#spliterator(java.lang.Object[]) Arrays#spliterator(Object[])}.
 *
 * <p>The returned spliterator always reports the characteristics
 * {@code SIZED} and {@code SUBSIZED}.  The caller may provide additional
 * characteristics for the spliterator to report; it is common to
 * additionally specify {@code IMMUTABLE} and {@code ORDERED}.
 *
 * @param <T> Type of elements
 * @param array The array, assumed to be unmodified during use
 * @param fromIndex The least index (inclusive) to cover
 * @param toIndex One past the greatest index to cover
 * @param additionalCharacteristics Additional spliterator characteristics
 *        of this spliterator's source or elements beyond {@code SIZED} and
 *        {@code SUBSIZED} which are are always reported
 * @return A spliterator for an array
 * @throws java.lang.NullPointerException if the given array is {@code null}
 * @throws java.lang.ArrayIndexOutOfBoundsException if {@code fromIndex} is negative,
 *         {@code toIndex} is less than {@code fromIndex}, or
 *         {@code toIndex} is greater than the array size
 * @see java.util.Arrays#spliterator(Object[], int, int)
 * @apiSince 24
 */

public static <T> java.util.Spliterator<T> spliterator(java.lang.Object[] array, int fromIndex, int toIndex, int additionalCharacteristics) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code Spliterator.OfInt} covering the elements of a given array,
 * using a customized set of spliterator characteristics.
 *
 * <p>This method is provided as an implementation convenience for
 * Spliterators which store portions of their elements in arrays, and need
 * fine control over Spliterator characteristics.  Most other situations in
 * which a Spliterator for an array is needed should use
 * {@link java.util.Arrays#spliterator(int[]) Arrays#spliterator(int[])}.
 *
 * <p>The returned spliterator always reports the characteristics
 * {@code SIZED} and {@code SUBSIZED}.  The caller may provide additional
 * characteristics for the spliterator to report; it is common to
 * additionally specify {@code IMMUTABLE} and {@code ORDERED}.
 *
 * @param array The array, assumed to be unmodified during use
 * @param additionalCharacteristics Additional spliterator characteristics
 *        of this spliterator's source or elements beyond {@code SIZED} and
 *        {@code SUBSIZED} which are are always reported
 * @return A spliterator for an array
 * @throws java.lang.NullPointerException if the given array is {@code null}
 * @see java.util.Arrays#spliterator(int[])
 * @apiSince 24
 */

public static java.util.Spliterator.OfInt spliterator(int[] array, int additionalCharacteristics) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code Spliterator.OfInt} covering a range of elements of a
 * given array, using a customized set of spliterator characteristics.
 *
 * <p>This method is provided as an implementation convenience for
 * Spliterators which store portions of their elements in arrays, and need
 * fine control over Spliterator characteristics.  Most other situations in
 * which a Spliterator for an array is needed should use
 * {@link java.util.Arrays#spliterator(int[],int,int) Arrays#spliterator(int[], int, int)}.
 *
 * <p>The returned spliterator always reports the characteristics
 * {@code SIZED} and {@code SUBSIZED}.  The caller may provide additional
 * characteristics for the spliterator to report; it is common to
 * additionally specify {@code IMMUTABLE} and {@code ORDERED}.
 *
 * @param array The array, assumed to be unmodified during use
 * @param fromIndex The least index (inclusive) to cover
 * @param toIndex One past the greatest index to cover
 * @param additionalCharacteristics Additional spliterator characteristics
 *        of this spliterator's source or elements beyond {@code SIZED} and
 *        {@code SUBSIZED} which are are always reported
 * @return A spliterator for an array
 * @throws java.lang.NullPointerException if the given array is {@code null}
 * @throws java.lang.ArrayIndexOutOfBoundsException if {@code fromIndex} is negative,
 *         {@code toIndex} is less than {@code fromIndex}, or
 *         {@code toIndex} is greater than the array size
 * @see java.util.Arrays#spliterator(int[], int, int)
 * @apiSince 24
 */

public static java.util.Spliterator.OfInt spliterator(int[] array, int fromIndex, int toIndex, int additionalCharacteristics) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code Spliterator.OfLong} covering the elements of a given array,
 * using a customized set of spliterator characteristics.
 *
 * <p>This method is provided as an implementation convenience for
 * Spliterators which store portions of their elements in arrays, and need
 * fine control over Spliterator characteristics.  Most other situations in
 * which a Spliterator for an array is needed should use
 * {@link java.util.Arrays#spliterator(long[]) Arrays#spliterator(long[])}.
 *
 * <p>The returned spliterator always reports the characteristics
 * {@code SIZED} and {@code SUBSIZED}.  The caller may provide additional
 * characteristics for the spliterator to report; it is common to
 * additionally specify {@code IMMUTABLE} and {@code ORDERED}.
 *
 * @param array The array, assumed to be unmodified during use
 * @param additionalCharacteristics Additional spliterator characteristics
 *        of this spliterator's source or elements beyond {@code SIZED} and
 *        {@code SUBSIZED} which are are always reported
 * @return A spliterator for an array
 * @throws java.lang.NullPointerException if the given array is {@code null}
 * @see java.util.Arrays#spliterator(long[])
 * @apiSince 24
 */

public static java.util.Spliterator.OfLong spliterator(long[] array, int additionalCharacteristics) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code Spliterator.OfLong} covering a range of elements of a
 * given array, using a customized set of spliterator characteristics.
 *
 * <p>This method is provided as an implementation convenience for
 * Spliterators which store portions of their elements in arrays, and need
 * fine control over Spliterator characteristics.  Most other situations in
 * which a Spliterator for an array is needed should use
 * {@link java.util.Arrays#spliterator(long[],int,int) Arrays#spliterator(long[], int, int)}.
 *
 * <p>The returned spliterator always reports the characteristics
 * {@code SIZED} and {@code SUBSIZED}.  The caller may provide additional
 * characteristics for the spliterator to report.  (For example, if it is
 * known the array will not be further modified, specify {@code IMMUTABLE};
 * if the array data is considered to have an an encounter order, specify
 * {@code ORDERED}).  The method {@link java.util.Arrays#spliterator(long[],int,int) Arrays#spliterator(long[], int, int)} can
 * often be used instead, which returns a spliterator that reports
 * {@code SIZED}, {@code SUBSIZED}, {@code IMMUTABLE}, and {@code ORDERED}.
 *
 * @param array The array, assumed to be unmodified during use
 * @param fromIndex The least index (inclusive) to cover
 * @param toIndex One past the greatest index to cover
 * @param additionalCharacteristics Additional spliterator characteristics
 *        of this spliterator's source or elements beyond {@code SIZED} and
 *        {@code SUBSIZED} which are are always reported
 * @return A spliterator for an array
 * @throws java.lang.NullPointerException if the given array is {@code null}
 * @throws java.lang.ArrayIndexOutOfBoundsException if {@code fromIndex} is negative,
 *         {@code toIndex} is less than {@code fromIndex}, or
 *         {@code toIndex} is greater than the array size
 * @see java.util.Arrays#spliterator(long[], int, int)
 * @apiSince 24
 */

public static java.util.Spliterator.OfLong spliterator(long[] array, int fromIndex, int toIndex, int additionalCharacteristics) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code Spliterator.OfDouble} covering the elements of a given array,
 * using a customized set of spliterator characteristics.
 *
 * <p>This method is provided as an implementation convenience for
 * Spliterators which store portions of their elements in arrays, and need
 * fine control over Spliterator characteristics.  Most other situations in
 * which a Spliterator for an array is needed should use
 * {@link java.util.Arrays#spliterator(double[]) Arrays#spliterator(double[])}.
 *
 * <p>The returned spliterator always reports the characteristics
 * {@code SIZED} and {@code SUBSIZED}.  The caller may provide additional
 * characteristics for the spliterator to report; it is common to
 * additionally specify {@code IMMUTABLE} and {@code ORDERED}.
 *
 * @param array The array, assumed to be unmodified during use
 * @param additionalCharacteristics Additional spliterator characteristics
 *        of this spliterator's source or elements beyond {@code SIZED} and
 *        {@code SUBSIZED} which are are always reported
 * @return A spliterator for an array
 * @throws java.lang.NullPointerException if the given array is {@code null}
 * @see java.util.Arrays#spliterator(double[])
 * @apiSince 24
 */

public static java.util.Spliterator.OfDouble spliterator(double[] array, int additionalCharacteristics) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code Spliterator.OfDouble} covering a range of elements of a
 * given array, using a customized set of spliterator characteristics.
 *
 * <p>This method is provided as an implementation convenience for
 * Spliterators which store portions of their elements in arrays, and need
 * fine control over Spliterator characteristics.  Most other situations in
 * which a Spliterator for an array is needed should use
 * {@link java.util.Arrays#spliterator(double[],int,int) Arrays#spliterator(double[], int, int)}.
 *
 * <p>The returned spliterator always reports the characteristics
 * {@code SIZED} and {@code SUBSIZED}.  The caller may provide additional
 * characteristics for the spliterator to report.  (For example, if it is
 * known the array will not be further modified, specify {@code IMMUTABLE};
 * if the array data is considered to have an an encounter order, specify
 * {@code ORDERED}).  The method {@link java.util.Arrays#spliterator(long[],int,int) Arrays#spliterator(long[], int, int)} can
 * often be used instead, which returns a spliterator that reports
 * {@code SIZED}, {@code SUBSIZED}, {@code IMMUTABLE}, and {@code ORDERED}.
 *
 * @param array The array, assumed to be unmodified during use
 * @param fromIndex The least index (inclusive) to cover
 * @param toIndex One past the greatest index to cover
 * @param additionalCharacteristics Additional spliterator characteristics
 *        of this spliterator's source or elements beyond {@code SIZED} and
 *        {@code SUBSIZED} which are are always reported
 * @return A spliterator for an array
 * @throws java.lang.NullPointerException if the given array is {@code null}
 * @throws java.lang.ArrayIndexOutOfBoundsException if {@code fromIndex} is negative,
 *         {@code toIndex} is less than {@code fromIndex}, or
 *         {@code toIndex} is greater than the array size
 * @see java.util.Arrays#spliterator(double[], int, int)
 * @apiSince 24
 */

public static java.util.Spliterator.OfDouble spliterator(double[] array, int fromIndex, int toIndex, int additionalCharacteristics) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code Spliterator} using the given collection's
 * {@link java.util.Collection#iterator()} as the source of elements, and
 * reporting its {@link java.util.Collection#size()} as its initial size.
 *
 * <p>The spliterator is
 * <em><a href="Spliterator.html#binding">late-binding</a></em>, inherits
 * the <em>fail-fast</em> properties of the collection's iterator, and
 * implements {@code trySplit} to permit limited parallelism.
 *
 * @param <T> Type of elements
 * @param c The collection
 * @param characteristics Characteristics of this spliterator's source or
 *        elements.  The characteristics {@code SIZED} and {@code SUBSIZED}
 *        are additionally reported unless {@code CONCURRENT} is supplied.
 * @return A spliterator from an iterator
 * @throws java.lang.NullPointerException if the given collection is {@code null}
 * @apiSince 24
 */

public static <T> java.util.Spliterator<T> spliterator(java.util.Collection<? extends T> c, int characteristics) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code Spliterator} using a given {@code Iterator}
 * as the source of elements, and with a given initially reported size.
 *
 * <p>The spliterator is not
 * <em><a href="Spliterator.html#binding">late-binding</a></em>, inherits
 * the <em>fail-fast</em> properties of the iterator, and implements
 * {@code trySplit} to permit limited parallelism.
 *
 * <p>Traversal of elements should be accomplished through the spliterator.
 * The behaviour of splitting and traversal is undefined if the iterator is
 * operated on after the spliterator is returned, or the initially reported
 * size is not equal to the actual number of elements in the source.
 *
 * @param <T> Type of elements
 * @param iterator The iterator for the source
 * @param size The number of elements in the source, to be reported as
 *        initial {@code estimateSize}
 * @param characteristics Characteristics of this spliterator's source or
 *        elements.  The characteristics {@code SIZED} and {@code SUBSIZED}
 *        are additionally reported unless {@code CONCURRENT} is supplied.
 * @return A spliterator from an iterator
 * @throws java.lang.NullPointerException if the given iterator is {@code null}
 * @apiSince 24
 */

public static <T> java.util.Spliterator<T> spliterator(java.util.Iterator<? extends T> iterator, long size, int characteristics) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code Spliterator} using a given {@code Iterator}
 * as the source of elements, with no initial size estimate.
 *
 * <p>The spliterator is not
 * <em><a href="Spliterator.html#binding">late-binding</a></em>, inherits
 * the <em>fail-fast</em> properties of the iterator, and implements
 * {@code trySplit} to permit limited parallelism.
 *
 * <p>Traversal of elements should be accomplished through the spliterator.
 * The behaviour of splitting and traversal is undefined if the iterator is
 * operated on after the spliterator is returned.
 *
 * @param <T> Type of elements
 * @param iterator The iterator for the source
 * @param characteristics Characteristics of this spliterator's source
 *        or elements ({@code SIZED} and {@code SUBSIZED}, if supplied, are
 *        ignored and are not reported.)
 * @return A spliterator from an iterator
 * @throws java.lang.NullPointerException if the given iterator is {@code null}
 * @apiSince 24
 */

public static <T> java.util.Spliterator<T> spliteratorUnknownSize(java.util.Iterator<? extends T> iterator, int characteristics) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code Spliterator.OfInt} using a given
 * {@code IntStream.IntIterator} as the source of elements, and with a given
 * initially reported size.
 *
 * <p>The spliterator is not
 * <em><a href="Spliterator.html#binding">late-binding</a></em>, inherits
 * the <em>fail-fast</em> properties of the iterator, and implements
 * {@code trySplit} to permit limited parallelism.
 *
 * <p>Traversal of elements should be accomplished through the spliterator.
 * The behaviour of splitting and traversal is undefined if the iterator is
 * operated on after the spliterator is returned, or the initially reported
 * size is not equal to the actual number of elements in the source.
 *
 * @param iterator The iterator for the source
 * @param size The number of elements in the source, to be reported as
 *        initial {@code estimateSize}.
 * @param characteristics Characteristics of this spliterator's source or
 *        elements.  The characteristics {@code SIZED} and {@code SUBSIZED}
 *        are additionally reported unless {@code CONCURRENT} is supplied.
 * @return A spliterator from an iterator
 * @throws java.lang.NullPointerException if the given iterator is {@code null}
 * @apiSince 24
 */

public static java.util.Spliterator.OfInt spliterator(java.util.PrimitiveIterator.OfInt iterator, long size, int characteristics) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code Spliterator.OfInt} using a given
 * {@code IntStream.IntIterator} as the source of elements, with no initial
 * size estimate.
 *
 * <p>The spliterator is not
 * <em><a href="Spliterator.html#binding">late-binding</a></em>, inherits
 * the <em>fail-fast</em> properties of the iterator, and implements
 * {@code trySplit} to permit limited parallelism.
 *
 * <p>Traversal of elements should be accomplished through the spliterator.
 * The behaviour of splitting and traversal is undefined if the iterator is
 * operated on after the spliterator is returned.
 *
 * @param iterator The iterator for the source
 * @param characteristics Characteristics of this spliterator's source
 *        or elements ({@code SIZED} and {@code SUBSIZED}, if supplied, are
 *        ignored and are not reported.)
 * @return A spliterator from an iterator
 * @throws java.lang.NullPointerException if the given iterator is {@code null}
 * @apiSince 24
 */

public static java.util.Spliterator.OfInt spliteratorUnknownSize(java.util.PrimitiveIterator.OfInt iterator, int characteristics) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code Spliterator.OfLong} using a given
 * {@code LongStream.LongIterator} as the source of elements, and with a
 * given initially reported size.
 *
 * <p>The spliterator is not
 * <em><a href="Spliterator.html#binding">late-binding</a></em>, inherits
 * the <em>fail-fast</em> properties of the iterator, and implements
 * {@code trySplit} to permit limited parallelism.
 *
 * <p>Traversal of elements should be accomplished through the spliterator.
 * The behaviour of splitting and traversal is undefined if the iterator is
 * operated on after the spliterator is returned, or the initially reported
 * size is not equal to the actual number of elements in the source.
 *
 * @param iterator The iterator for the source
 * @param size The number of elements in the source, to be reported as
 *        initial {@code estimateSize}.
 * @param characteristics Characteristics of this spliterator's source or
 *        elements.  The characteristics {@code SIZED} and {@code SUBSIZED}
 *        are additionally reported unless {@code CONCURRENT} is supplied.
 * @return A spliterator from an iterator
 * @throws java.lang.NullPointerException if the given iterator is {@code null}
 * @apiSince 24
 */

public static java.util.Spliterator.OfLong spliterator(java.util.PrimitiveIterator.OfLong iterator, long size, int characteristics) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code Spliterator.OfLong} using a given
 * {@code LongStream.LongIterator} as the source of elements, with no
 * initial size estimate.
 *
 * <p>The spliterator is not
 * <em><a href="Spliterator.html#binding">late-binding</a></em>, inherits
 * the <em>fail-fast</em> properties of the iterator, and implements
 * {@code trySplit} to permit limited parallelism.
 *
 * <p>Traversal of elements should be accomplished through the spliterator.
 * The behaviour of splitting and traversal is undefined if the iterator is
 * operated on after the spliterator is returned.
 *
 * @param iterator The iterator for the source
 * @param characteristics Characteristics of this spliterator's source
 *        or elements ({@code SIZED} and {@code SUBSIZED}, if supplied, are
 *        ignored and are not reported.)
 * @return A spliterator from an iterator
 * @throws java.lang.NullPointerException if the given iterator is {@code null}
 * @apiSince 24
 */

public static java.util.Spliterator.OfLong spliteratorUnknownSize(java.util.PrimitiveIterator.OfLong iterator, int characteristics) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code Spliterator.OfDouble} using a given
 * {@code DoubleStream.DoubleIterator} as the source of elements, and with a
 * given initially reported size.
 *
 * <p>The spliterator is not
 * <em><a href="Spliterator.html#binding">late-binding</a></em>, inherits
 * the <em>fail-fast</em> properties of the iterator, and implements
 * {@code trySplit} to permit limited parallelism.
 *
 * <p>Traversal of elements should be accomplished through the spliterator.
 * The behaviour of splitting and traversal is undefined if the iterator is
 * operated on after the spliterator is returned, or the initially reported
 * size is not equal to the actual number of elements in the source.
 *
 * @param iterator The iterator for the source
 * @param size The number of elements in the source, to be reported as
 *        initial {@code estimateSize}
 * @param characteristics Characteristics of this spliterator's source or
 *        elements.  The characteristics {@code SIZED} and {@code SUBSIZED}
 *        are additionally reported unless {@code CONCURRENT} is supplied.
 * @return A spliterator from an iterator
 * @throws java.lang.NullPointerException if the given iterator is {@code null}
 * @apiSince 24
 */

public static java.util.Spliterator.OfDouble spliterator(java.util.PrimitiveIterator.OfDouble iterator, long size, int characteristics) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code Spliterator.OfDouble} using a given
 * {@code DoubleStream.DoubleIterator} as the source of elements, with no
 * initial size estimate.
 *
 * <p>The spliterator is not
 * <em><a href="Spliterator.html#binding">late-binding</a></em>, inherits
 * the <em>fail-fast</em> properties of the iterator, and implements
 * {@code trySplit} to permit limited parallelism.
 *
 * <p>Traversal of elements should be accomplished through the spliterator.
 * The behaviour of splitting and traversal is undefined if the iterator is
 * operated on after the spliterator is returned.
 *
 * @param iterator The iterator for the source
 * @param characteristics Characteristics of this spliterator's source
 *        or elements ({@code SIZED} and {@code SUBSIZED}, if supplied, are
 *        ignored and are not reported.)
 * @return A spliterator from an iterator
 * @throws java.lang.NullPointerException if the given iterator is {@code null}
 * @apiSince 24
 */

public static java.util.Spliterator.OfDouble spliteratorUnknownSize(java.util.PrimitiveIterator.OfDouble iterator, int characteristics) { throw new RuntimeException("Stub!"); }

/**
 * Creates an {@code Iterator} from a {@code Spliterator}.
 *
 * <p>Traversal of elements should be accomplished through the iterator.
 * The behaviour of traversal is undefined if the spliterator is operated
 * after the iterator is returned.
 *
 * @param <T> Type of elements
 * @param spliterator The spliterator
 * @return An iterator
 * @throws java.lang.NullPointerException if the given spliterator is {@code null}
 * @apiSince 24
 */

public static <T> java.util.Iterator<T> iterator(java.util.Spliterator<? extends T> spliterator) { throw new RuntimeException("Stub!"); }

/**
 * Creates an {@code PrimitiveIterator.OfInt} from a
 * {@code Spliterator.OfInt}.
 *
 * <p>Traversal of elements should be accomplished through the iterator.
 * The behaviour of traversal is undefined if the spliterator is operated
 * after the iterator is returned.
 *
 * @param spliterator The spliterator
 * @return An iterator
 * @throws java.lang.NullPointerException if the given spliterator is {@code null}
 * @apiSince 24
 */

public static java.util.PrimitiveIterator.OfInt iterator(java.util.Spliterator.OfInt spliterator) { throw new RuntimeException("Stub!"); }

/**
 * Creates an {@code PrimitiveIterator.OfLong} from a
 * {@code Spliterator.OfLong}.
 *
 * <p>Traversal of elements should be accomplished through the iterator.
 * The behaviour of traversal is undefined if the spliterator is operated
 * after the iterator is returned.
 *
 * @param spliterator The spliterator
 * @return An iterator
 * @throws java.lang.NullPointerException if the given spliterator is {@code null}
 * @apiSince 24
 */

public static java.util.PrimitiveIterator.OfLong iterator(java.util.Spliterator.OfLong spliterator) { throw new RuntimeException("Stub!"); }

/**
 * Creates an {@code PrimitiveIterator.OfDouble} from a
 * {@code Spliterator.OfDouble}.
 *
 * <p>Traversal of elements should be accomplished through the iterator.
 * The behaviour of traversal is undefined if the spliterator is operated
 * after the iterator is returned.
 *
 * @param spliterator The spliterator
 * @return An iterator
 * @throws java.lang.NullPointerException if the given spliterator is {@code null}
 * @apiSince 24
 */

public static java.util.PrimitiveIterator.OfDouble iterator(java.util.Spliterator.OfDouble spliterator) { throw new RuntimeException("Stub!"); }
/**
 * An abstract {@code Spliterator.OfDouble} that implements
 * {@code trySplit} to permit limited parallelism.
 *
 * <p>To implement a spliterator an extending class need only
 * implement {@link #tryAdvance(java.util.function.DoubleConsumer)}
 * tryAdvance}.  The extending class should override
 * {@link #forEachRemaining(java.util.function.DoubleConsumer)} forEach} if
 * it can provide a more performant implementation.
 *
 * @apiNote
 * This class is a useful aid for creating a spliterator when it is not
 * possible or difficult to efficiently partition elements in a manner
 * allowing balanced parallel computation.
 *
 * <p>An alternative to using this class, that also permits limited
 * parallelism, is to create a spliterator from an iterator
 * (see {@link #spliterator(java.util.PrimitiveIterator.OfDouble,long,int)}.
 * Depending on the circumstances using an iterator may be easier or more
 * convenient than extending this class. For example, if there is already an
 * iterator available to use then there is no need to extend this class.
 *
 * @see #spliterator(java.util.PrimitiveIterator.OfDouble, long, int)
 * @since 1.8
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class AbstractDoubleSpliterator implements java.util.Spliterator.OfDouble {

/**
 * Creates a spliterator reporting the given estimated size and
 * characteristics.
 *
 * @param est the estimated size of this spliterator if known, otherwise
 *        {@code Long.MAX_VALUE}.
 * @param additionalCharacteristics properties of this spliterator's
 *        source or elements.  If {@code SIZED} is reported then this
 *        spliterator will additionally report {@code SUBSIZED}.
 * @apiSince 24
 */

protected AbstractDoubleSpliterator(long est, int additionalCharacteristics) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * This implementation permits limited parallelism.
 * @apiSince 24
 */

public java.util.Spliterator.OfDouble trySplit() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * @implSpec
 * This implementation returns the estimated size as reported when
 * created and, if the estimate size is known, decreases in size when
 * split.
 * @apiSince 24
 */

public long estimateSize() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * @implSpec
 * This implementation returns the characteristics as reported when
 * created.
 * @apiSince 24
 */

public int characteristics() { throw new RuntimeException("Stub!"); }
}

/**
 * An abstract {@code Spliterator.OfInt} that implements {@code trySplit} to
 * permit limited parallelism.
 *
 * <p>To implement a spliterator an extending class need only
 * implement {@link #tryAdvance(java.util.function.IntConsumer)}
 * tryAdvance}.  The extending class should override
 * {@link #forEachRemaining(java.util.function.IntConsumer)} forEach} if it
 * can provide a more performant implementation.
 *
 * @apiNote
 * This class is a useful aid for creating a spliterator when it is not
 * possible or difficult to efficiently partition elements in a manner
 * allowing balanced parallel computation.
 *
 * <p>An alternative to using this class, that also permits limited
 * parallelism, is to create a spliterator from an iterator
 * (see {@link #spliterator(java.util.PrimitiveIterator.OfInt,long,int)}.
 * Depending on the circumstances using an iterator may be easier or more
 * convenient than extending this class. For example, if there is already an
 * iterator available to use then there is no need to extend this class.
 *
 * @see #spliterator(java.util.PrimitiveIterator.OfInt, long, int)
 * @since 1.8
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class AbstractIntSpliterator implements java.util.Spliterator.OfInt {

/**
 * Creates a spliterator reporting the given estimated size and
 * characteristics.
 *
 * @param est the estimated size of this spliterator if known, otherwise
 *        {@code Long.MAX_VALUE}.
 * @param additionalCharacteristics properties of this spliterator's
 *        source or elements.  If {@code SIZED} is reported then this
 *        spliterator will additionally report {@code SUBSIZED}.
 * @apiSince 24
 */

protected AbstractIntSpliterator(long est, int additionalCharacteristics) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * This implementation permits limited parallelism.
 * @apiSince 24
 */

public java.util.Spliterator.OfInt trySplit() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * @implSpec
 * This implementation returns the estimated size as reported when
 * created and, if the estimate size is known, decreases in size when
 * split.
 * @apiSince 24
 */

public long estimateSize() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * @implSpec
 * This implementation returns the characteristics as reported when
 * created.
 * @apiSince 24
 */

public int characteristics() { throw new RuntimeException("Stub!"); }
}

/**
 * An abstract {@code Spliterator.OfLong} that implements {@code trySplit}
 * to permit limited parallelism.
 *
 * <p>To implement a spliterator an extending class need only
 * implement {@link #tryAdvance(java.util.function.LongConsumer)}
 * tryAdvance}.  The extending class should override
 * {@link #forEachRemaining(java.util.function.LongConsumer)} forEach} if it
 * can provide a more performant implementation.
 *
 * @apiNote
 * This class is a useful aid for creating a spliterator when it is not
 * possible or difficult to efficiently partition elements in a manner
 * allowing balanced parallel computation.
 *
 * <p>An alternative to using this class, that also permits limited
 * parallelism, is to create a spliterator from an iterator
 * (see {@link #spliterator(java.util.PrimitiveIterator.OfLong,long,int)}.
 * Depending on the circumstances using an iterator may be easier or more
 * convenient than extending this class. For example, if there is already an
 * iterator available to use then there is no need to extend this class.
 *
 * @see #spliterator(java.util.PrimitiveIterator.OfLong, long, int)
 * @since 1.8
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class AbstractLongSpliterator implements java.util.Spliterator.OfLong {

/**
 * Creates a spliterator reporting the given estimated size and
 * characteristics.
 *
 * @param est the estimated size of this spliterator if known, otherwise
 *        {@code Long.MAX_VALUE}.
 * @param additionalCharacteristics properties of this spliterator's
 *        source or elements.  If {@code SIZED} is reported then this
 *        spliterator will additionally report {@code SUBSIZED}.
 * @apiSince 24
 */

protected AbstractLongSpliterator(long est, int additionalCharacteristics) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * This implementation permits limited parallelism.
 * @apiSince 24
 */

public java.util.Spliterator.OfLong trySplit() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * @implSpec
 * This implementation returns the estimated size as reported when
 * created and, if the estimate size is known, decreases in size when
 * split.
 * @apiSince 24
 */

public long estimateSize() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * @implSpec
 * This implementation returns the characteristics as reported when
 * created.
 * @apiSince 24
 */

public int characteristics() { throw new RuntimeException("Stub!"); }
}

/**
 * An abstract {@code Spliterator} that implements {@code trySplit} to
 * permit limited parallelism.
 *
 * <p>An extending class need only
 * implement {@link #tryAdvance(java.util.function.Consumer) tryAdvance}.
 * The extending class should override
 * {@link #forEachRemaining(java.util.function.Consumer) forEach} if it can
 * provide a more performant implementation.
 *
 * @apiNote
 * This class is a useful aid for creating a spliterator when it is not
 * possible or difficult to efficiently partition elements in a manner
 * allowing balanced parallel computation.
 *
 * <p>An alternative to using this class, that also permits limited
 * parallelism, is to create a spliterator from an iterator
 * (see {@link #spliterator(java.util.Iterator,long,int)}.  Depending on the
 * circumstances using an iterator may be easier or more convenient than
 * extending this class, such as when there is already an iterator
 * available to use.
 *
 * @see #spliterator(Iterator, long, int)
 * @since 1.8
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class AbstractSpliterator<T> implements java.util.Spliterator<T> {

/**
 * Creates a spliterator reporting the given estimated size and
 * additionalCharacteristics.
 *
 * @param est the estimated size of this spliterator if known, otherwise
 *        {@code Long.MAX_VALUE}.
 * @param additionalCharacteristics properties of this spliterator's
 *        source or elements.  If {@code SIZED} is reported then this
 *        spliterator will additionally report {@code SUBSIZED}.
 * @apiSince 24
 */

protected AbstractSpliterator(long est, int additionalCharacteristics) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * This implementation permits limited parallelism.
 * @apiSince 24
 */

public java.util.Spliterator<T> trySplit() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * @implSpec
 * This implementation returns the estimated size as reported when
 * created and, if the estimate size is known, decreases in size when
 * split.
 * @apiSince 24
 */

public long estimateSize() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * @implSpec
 * This implementation returns the characteristics as reported when
 * created.
 * @apiSince 24
 */

public int characteristics() { throw new RuntimeException("Stub!"); }
}

}

