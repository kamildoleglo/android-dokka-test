/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 1997, 2014, Oracle and/or its affiliates. All rights reserved.
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

import java.util.concurrent.ForkJoinPool;
import java.util.function.BinaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.DoubleStream;

/**
 * This class contains various methods for manipulating arrays (such as
 * sorting and searching). This class also contains a static factory
 * that allows arrays to be viewed as lists.
 *
 * <p>The methods in this class all throw a {@code NullPointerException},
 * if the specified array reference is null, except where noted.
 *
 * <p>The documentation for the methods contained in this class includes
 * briefs description of the <i>implementations</i>. Such descriptions should
 * be regarded as <i>implementation notes</i>, rather than parts of the
 * <i>specification</i>. Implementors should feel free to substitute other
 * algorithms, so long as the specification itself is adhered to. (For
 * example, the algorithm used by {@code sort(Object[])} does not have to be
 * a MergeSort, but it does have to be <i>stable</i>.)
 *
 * <p>This class is a member of the
 * <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/collections/index.html">
 * Java Collections Framework</a>.
 *
 * @author Josh Bloch
 * @author Neal Gafter
 * @author John Rose
 * @since  1.2
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Arrays {

private Arrays() { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified array into ascending numerical order.
 *
 * <p>Implementation note: The sorting algorithm is a Dual-Pivot Quicksort
 * by Vladimir Yaroslavskiy, Jon Bentley, and Joshua Bloch. This algorithm
 * offers O(n log(n)) performance on many data sets that cause other
 * quicksorts to degrade to quadratic performance, and is typically
 * faster than traditional (one-pivot) Quicksort implementations.
 *
 * @param a the array to be sorted
 * @apiSince 1
 */

public static void sort(@androidx.annotation.NonNull int[] a) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified range of the array into ascending order. The range
 * to be sorted extends from the index {@code fromIndex}, inclusive, to
 * the index {@code toIndex}, exclusive. If {@code fromIndex == toIndex},
 * the range to be sorted is empty.
 *
 * <p>Implementation note: The sorting algorithm is a Dual-Pivot Quicksort
 * by Vladimir Yaroslavskiy, Jon Bentley, and Joshua Bloch. This algorithm
 * offers O(n log(n)) performance on many data sets that cause other
 * quicksorts to degrade to quadratic performance, and is typically
 * faster than traditional (one-pivot) Quicksort implementations.
 *
 * @param a the array to be sorted
 * @param fromIndex the index of the first element, inclusive, to be sorted
 * @param toIndex the index of the last element, exclusive, to be sorted
 *
 * @throws java.lang.IllegalArgumentException if {@code fromIndex > toIndex}
 * @throws java.lang.ArrayIndexOutOfBoundsException
 *     if {@code fromIndex < 0} or {@code toIndex > a.length}
 * @apiSince 1
 */

public static void sort(@androidx.annotation.NonNull int[] a, int fromIndex, int toIndex) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified array into ascending numerical order.
 *
 * <p>Implementation note: The sorting algorithm is a Dual-Pivot Quicksort
 * by Vladimir Yaroslavskiy, Jon Bentley, and Joshua Bloch. This algorithm
 * offers O(n log(n)) performance on many data sets that cause other
 * quicksorts to degrade to quadratic performance, and is typically
 * faster than traditional (one-pivot) Quicksort implementations.
 *
 * @param a the array to be sorted
 * @apiSince 1
 */

public static void sort(@androidx.annotation.NonNull long[] a) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified range of the array into ascending order. The range
 * to be sorted extends from the index {@code fromIndex}, inclusive, to
 * the index {@code toIndex}, exclusive. If {@code fromIndex == toIndex},
 * the range to be sorted is empty.
 *
 * <p>Implementation note: The sorting algorithm is a Dual-Pivot Quicksort
 * by Vladimir Yaroslavskiy, Jon Bentley, and Joshua Bloch. This algorithm
 * offers O(n log(n)) performance on many data sets that cause other
 * quicksorts to degrade to quadratic performance, and is typically
 * faster than traditional (one-pivot) Quicksort implementations.
 *
 * @param a the array to be sorted
 * @param fromIndex the index of the first element, inclusive, to be sorted
 * @param toIndex the index of the last element, exclusive, to be sorted
 *
 * @throws java.lang.IllegalArgumentException if {@code fromIndex > toIndex}
 * @throws java.lang.ArrayIndexOutOfBoundsException
 *     if {@code fromIndex < 0} or {@code toIndex > a.length}
 * @apiSince 1
 */

public static void sort(@androidx.annotation.NonNull long[] a, int fromIndex, int toIndex) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified array into ascending numerical order.
 *
 * <p>Implementation note: The sorting algorithm is a Dual-Pivot Quicksort
 * by Vladimir Yaroslavskiy, Jon Bentley, and Joshua Bloch. This algorithm
 * offers O(n log(n)) performance on many data sets that cause other
 * quicksorts to degrade to quadratic performance, and is typically
 * faster than traditional (one-pivot) Quicksort implementations.
 *
 * @param a the array to be sorted
 * @apiSince 1
 */

public static void sort(@androidx.annotation.NonNull short[] a) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified range of the array into ascending order. The range
 * to be sorted extends from the index {@code fromIndex}, inclusive, to
 * the index {@code toIndex}, exclusive. If {@code fromIndex == toIndex},
 * the range to be sorted is empty.
 *
 * <p>Implementation note: The sorting algorithm is a Dual-Pivot Quicksort
 * by Vladimir Yaroslavskiy, Jon Bentley, and Joshua Bloch. This algorithm
 * offers O(n log(n)) performance on many data sets that cause other
 * quicksorts to degrade to quadratic performance, and is typically
 * faster than traditional (one-pivot) Quicksort implementations.
 *
 * @param a the array to be sorted
 * @param fromIndex the index of the first element, inclusive, to be sorted
 * @param toIndex the index of the last element, exclusive, to be sorted
 *
 * @throws java.lang.IllegalArgumentException if {@code fromIndex > toIndex}
 * @throws java.lang.ArrayIndexOutOfBoundsException
 *     if {@code fromIndex < 0} or {@code toIndex > a.length}
 * @apiSince 1
 */

public static void sort(@androidx.annotation.NonNull short[] a, int fromIndex, int toIndex) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified array into ascending numerical order.
 *
 * <p>Implementation note: The sorting algorithm is a Dual-Pivot Quicksort
 * by Vladimir Yaroslavskiy, Jon Bentley, and Joshua Bloch. This algorithm
 * offers O(n log(n)) performance on many data sets that cause other
 * quicksorts to degrade to quadratic performance, and is typically
 * faster than traditional (one-pivot) Quicksort implementations.
 *
 * @param a the array to be sorted
 * @apiSince 1
 */

public static void sort(@androidx.annotation.NonNull char[] a) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified range of the array into ascending order. The range
 * to be sorted extends from the index {@code fromIndex}, inclusive, to
 * the index {@code toIndex}, exclusive. If {@code fromIndex == toIndex},
 * the range to be sorted is empty.
 *
 * <p>Implementation note: The sorting algorithm is a Dual-Pivot Quicksort
 * by Vladimir Yaroslavskiy, Jon Bentley, and Joshua Bloch. This algorithm
 * offers O(n log(n)) performance on many data sets that cause other
 * quicksorts to degrade to quadratic performance, and is typically
 * faster than traditional (one-pivot) Quicksort implementations.
 *
 * @param a the array to be sorted
 * @param fromIndex the index of the first element, inclusive, to be sorted
 * @param toIndex the index of the last element, exclusive, to be sorted
 *
 * @throws java.lang.IllegalArgumentException if {@code fromIndex > toIndex}
 * @throws java.lang.ArrayIndexOutOfBoundsException
 *     if {@code fromIndex < 0} or {@code toIndex > a.length}
 * @apiSince 1
 */

public static void sort(@androidx.annotation.NonNull char[] a, int fromIndex, int toIndex) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified array into ascending numerical order.
 *
 * <p>Implementation note: The sorting algorithm is a Dual-Pivot Quicksort
 * by Vladimir Yaroslavskiy, Jon Bentley, and Joshua Bloch. This algorithm
 * offers O(n log(n)) performance on many data sets that cause other
 * quicksorts to degrade to quadratic performance, and is typically
 * faster than traditional (one-pivot) Quicksort implementations.
 *
 * @param a the array to be sorted
 * @apiSince 1
 */

public static void sort(@androidx.annotation.NonNull byte[] a) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified range of the array into ascending order. The range
 * to be sorted extends from the index {@code fromIndex}, inclusive, to
 * the index {@code toIndex}, exclusive. If {@code fromIndex == toIndex},
 * the range to be sorted is empty.
 *
 * <p>Implementation note: The sorting algorithm is a Dual-Pivot Quicksort
 * by Vladimir Yaroslavskiy, Jon Bentley, and Joshua Bloch. This algorithm
 * offers O(n log(n)) performance on many data sets that cause other
 * quicksorts to degrade to quadratic performance, and is typically
 * faster than traditional (one-pivot) Quicksort implementations.
 *
 * @param a the array to be sorted
 * @param fromIndex the index of the first element, inclusive, to be sorted
 * @param toIndex the index of the last element, exclusive, to be sorted
 *
 * @throws java.lang.IllegalArgumentException if {@code fromIndex > toIndex}
 * @throws java.lang.ArrayIndexOutOfBoundsException
 *     if {@code fromIndex < 0} or {@code toIndex > a.length}
 * @apiSince 1
 */

public static void sort(@androidx.annotation.NonNull byte[] a, int fromIndex, int toIndex) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified array into ascending numerical order.
 *
 * <p>The {@code <} relation does not provide a total order on all float
 * values: {@code -0.0f == 0.0f} is {@code true} and a {@code Float.NaN}
 * value compares neither less than, greater than, nor equal to any value,
 * even itself. This method uses the total order imposed by the method
 * {@link java.lang.Float#compareTo Float#compareTo}: {@code -0.0f} is treated as less than value
 * {@code 0.0f} and {@code Float.NaN} is considered greater than any
 * other value and all {@code Float.NaN} values are considered equal.
 *
 * <p>Implementation note: The sorting algorithm is a Dual-Pivot Quicksort
 * by Vladimir Yaroslavskiy, Jon Bentley, and Joshua Bloch. This algorithm
 * offers O(n log(n)) performance on many data sets that cause other
 * quicksorts to degrade to quadratic performance, and is typically
 * faster than traditional (one-pivot) Quicksort implementations.
 *
 * @param a the array to be sorted
 * @apiSince 1
 */

public static void sort(@androidx.annotation.NonNull float[] a) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified range of the array into ascending order. The range
 * to be sorted extends from the index {@code fromIndex}, inclusive, to
 * the index {@code toIndex}, exclusive. If {@code fromIndex == toIndex},
 * the range to be sorted is empty.
 *
 * <p>The {@code <} relation does not provide a total order on all float
 * values: {@code -0.0f == 0.0f} is {@code true} and a {@code Float.NaN}
 * value compares neither less than, greater than, nor equal to any value,
 * even itself. This method uses the total order imposed by the method
 * {@link java.lang.Float#compareTo Float#compareTo}: {@code -0.0f} is treated as less than value
 * {@code 0.0f} and {@code Float.NaN} is considered greater than any
 * other value and all {@code Float.NaN} values are considered equal.
 *
 * <p>Implementation note: The sorting algorithm is a Dual-Pivot Quicksort
 * by Vladimir Yaroslavskiy, Jon Bentley, and Joshua Bloch. This algorithm
 * offers O(n log(n)) performance on many data sets that cause other
 * quicksorts to degrade to quadratic performance, and is typically
 * faster than traditional (one-pivot) Quicksort implementations.
 *
 * @param a the array to be sorted
 * @param fromIndex the index of the first element, inclusive, to be sorted
 * @param toIndex the index of the last element, exclusive, to be sorted
 *
 * @throws java.lang.IllegalArgumentException if {@code fromIndex > toIndex}
 * @throws java.lang.ArrayIndexOutOfBoundsException
 *     if {@code fromIndex < 0} or {@code toIndex > a.length}
 * @apiSince 1
 */

public static void sort(@androidx.annotation.NonNull float[] a, int fromIndex, int toIndex) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified array into ascending numerical order.
 *
 * <p>The {@code <} relation does not provide a total order on all double
 * values: {@code -0.0d == 0.0d} is {@code true} and a {@code Double.NaN}
 * value compares neither less than, greater than, nor equal to any value,
 * even itself. This method uses the total order imposed by the method
 * {@link java.lang.Double#compareTo Double#compareTo}: {@code -0.0d} is treated as less than value
 * {@code 0.0d} and {@code Double.NaN} is considered greater than any
 * other value and all {@code Double.NaN} values are considered equal.
 *
 * <p>Implementation note: The sorting algorithm is a Dual-Pivot Quicksort
 * by Vladimir Yaroslavskiy, Jon Bentley, and Joshua Bloch. This algorithm
 * offers O(n log(n)) performance on many data sets that cause other
 * quicksorts to degrade to quadratic performance, and is typically
 * faster than traditional (one-pivot) Quicksort implementations.
 *
 * @param a the array to be sorted
 * @apiSince 1
 */

public static void sort(@androidx.annotation.NonNull double[] a) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified range of the array into ascending order. The range
 * to be sorted extends from the index {@code fromIndex}, inclusive, to
 * the index {@code toIndex}, exclusive. If {@code fromIndex == toIndex},
 * the range to be sorted is empty.
 *
 * <p>The {@code <} relation does not provide a total order on all double
 * values: {@code -0.0d == 0.0d} is {@code true} and a {@code Double.NaN}
 * value compares neither less than, greater than, nor equal to any value,
 * even itself. This method uses the total order imposed by the method
 * {@link java.lang.Double#compareTo Double#compareTo}: {@code -0.0d} is treated as less than value
 * {@code 0.0d} and {@code Double.NaN} is considered greater than any
 * other value and all {@code Double.NaN} values are considered equal.
 *
 * <p>Implementation note: The sorting algorithm is a Dual-Pivot Quicksort
 * by Vladimir Yaroslavskiy, Jon Bentley, and Joshua Bloch. This algorithm
 * offers O(n log(n)) performance on many data sets that cause other
 * quicksorts to degrade to quadratic performance, and is typically
 * faster than traditional (one-pivot) Quicksort implementations.
 *
 * @param a the array to be sorted
 * @param fromIndex the index of the first element, inclusive, to be sorted
 * @param toIndex the index of the last element, exclusive, to be sorted
 *
 * @throws java.lang.IllegalArgumentException if {@code fromIndex > toIndex}
 * @throws java.lang.ArrayIndexOutOfBoundsException
 *     if {@code fromIndex < 0} or {@code toIndex > a.length}
 * @apiSince 1
 */

public static void sort(@androidx.annotation.NonNull double[] a, int fromIndex, int toIndex) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified array into ascending numerical order.
 *
 * @implNote The sorting algorithm is a parallel sort-merge that breaks the
 * array into sub-arrays that are themselves sorted and then merged. When
 * the sub-array length reaches a minimum granularity, the sub-array is
 * sorted using the appropriate {@link java.util.Arrays#sort(byte[]) Arrays#sort(byte[])}
 * method. If the length of the specified array is less than the minimum
 * granularity, then it is sorted using the appropriate {@link java.util.Arrays#sort(byte[]) Arrays#sort(byte[])} method. The algorithm requires a
 * working space no greater than the size of the original array. The
 * {@link java.util.concurrent.ForkJoinPool#commonPool() ForkJoinPool#commonPool()} is used to
 * execute any parallel tasks.
 *
 * @param a the array to be sorted
 *
 * @since 1.8
 * @apiSince 24
 */

public static void parallelSort(@androidx.annotation.NonNull byte[] a) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified range of the array into ascending numerical order.
 * The range to be sorted extends from the index {@code fromIndex},
 * inclusive, to the index {@code toIndex}, exclusive. If
 * {@code fromIndex == toIndex}, the range to be sorted is empty.
 *
 * @implNote The sorting algorithm is a parallel sort-merge that breaks the
 * array into sub-arrays that are themselves sorted and then merged. When
 * the sub-array length reaches a minimum granularity, the sub-array is
 * sorted using the appropriate {@link java.util.Arrays#sort(byte[]) Arrays#sort(byte[])}
 * method. If the length of the specified array is less than the minimum
 * granularity, then it is sorted using the appropriate {@link java.util.Arrays#sort(byte[]) Arrays#sort(byte[])} method. The algorithm requires a working
 * space no greater than the size of the specified range of the original
 * array. The {@link java.util.concurrent.ForkJoinPool#commonPool() ForkJoinPool#commonPool()} is
 * used to execute any parallel tasks.
 *
 * @param a the array to be sorted
 * @param fromIndex the index of the first element, inclusive, to be sorted
 * @param toIndex the index of the last element, exclusive, to be sorted
 *
 * @throws java.lang.IllegalArgumentException if {@code fromIndex > toIndex}
 * @throws java.lang.ArrayIndexOutOfBoundsException
 *     if {@code fromIndex < 0} or {@code toIndex > a.length}
 *
 * @since 1.8
 * @apiSince 24
 */

public static void parallelSort(@androidx.annotation.NonNull byte[] a, int fromIndex, int toIndex) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified array into ascending numerical order.
 *
 * @implNote The sorting algorithm is a parallel sort-merge that breaks the
 * array into sub-arrays that are themselves sorted and then merged. When
 * the sub-array length reaches a minimum granularity, the sub-array is
 * sorted using the appropriate {@link java.util.Arrays#sort(char[]) Arrays#sort(char[])}
 * method. If the length of the specified array is less than the minimum
 * granularity, then it is sorted using the appropriate {@link java.util.Arrays#sort(char[]) Arrays#sort(char[])} method. The algorithm requires a
 * working space no greater than the size of the original array. The
 * {@link java.util.concurrent.ForkJoinPool#commonPool() ForkJoinPool#commonPool()} is used to
 * execute any parallel tasks.
 *
 * @param a the array to be sorted
 *
 * @since 1.8
 * @apiSince 24
 */

public static void parallelSort(@androidx.annotation.NonNull char[] a) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified range of the array into ascending numerical order.
 * The range to be sorted extends from the index {@code fromIndex},
 * inclusive, to the index {@code toIndex}, exclusive. If
 * {@code fromIndex == toIndex}, the range to be sorted is empty.
 *
 @implNote The sorting algorithm is a parallel sort-merge that breaks the
 * array into sub-arrays that are themselves sorted and then merged. When
 * the sub-array length reaches a minimum granularity, the sub-array is
 * sorted using the appropriate {@link java.util.Arrays#sort(char[]) Arrays#sort(char[])}
 * method. If the length of the specified array is less than the minimum
 * granularity, then it is sorted using the appropriate {@link java.util.Arrays#sort(char[]) Arrays#sort(char[])} method. The algorithm requires a working
 * space no greater than the size of the specified range of the original
 * array. The {@link java.util.concurrent.ForkJoinPool#commonPool() ForkJoinPool#commonPool()} is
 * used to execute any parallel tasks.
 *
 * @param a the array to be sorted
 * @param fromIndex the index of the first element, inclusive, to be sorted
 * @param toIndex the index of the last element, exclusive, to be sorted
 *
 * @throws java.lang.IllegalArgumentException if {@code fromIndex > toIndex}
 * @throws java.lang.ArrayIndexOutOfBoundsException
 *     if {@code fromIndex < 0} or {@code toIndex > a.length}
 *
 * @since 1.8
 * @apiSince 24
 */

public static void parallelSort(@androidx.annotation.NonNull char[] a, int fromIndex, int toIndex) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified array into ascending numerical order.
 *
 * @implNote The sorting algorithm is a parallel sort-merge that breaks the
 * array into sub-arrays that are themselves sorted and then merged. When
 * the sub-array length reaches a minimum granularity, the sub-array is
 * sorted using the appropriate {@link java.util.Arrays#sort(short[]) Arrays#sort(short[])}
 * method. If the length of the specified array is less than the minimum
 * granularity, then it is sorted using the appropriate {@link java.util.Arrays#sort(short[]) Arrays#sort(short[])} method. The algorithm requires a
 * working space no greater than the size of the original array. The
 * {@link java.util.concurrent.ForkJoinPool#commonPool() ForkJoinPool#commonPool()} is used to
 * execute any parallel tasks.
 *
 * @param a the array to be sorted
 *
 * @since 1.8
 * @apiSince 24
 */

public static void parallelSort(@androidx.annotation.NonNull short[] a) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified range of the array into ascending numerical order.
 * The range to be sorted extends from the index {@code fromIndex},
 * inclusive, to the index {@code toIndex}, exclusive. If
 * {@code fromIndex == toIndex}, the range to be sorted is empty.
 *
 * @implNote The sorting algorithm is a parallel sort-merge that breaks the
 * array into sub-arrays that are themselves sorted and then merged. When
 * the sub-array length reaches a minimum granularity, the sub-array is
 * sorted using the appropriate {@link java.util.Arrays#sort(short[]) Arrays#sort(short[])}
 * method. If the length of the specified array is less than the minimum
 * granularity, then it is sorted using the appropriate {@link java.util.Arrays#sort(short[]) Arrays#sort(short[])} method. The algorithm requires a working
 * space no greater than the size of the specified range of the original
 * array. The {@link java.util.concurrent.ForkJoinPool#commonPool() ForkJoinPool#commonPool()} is
 * used to execute any parallel tasks.
 *
 * @param a the array to be sorted
 * @param fromIndex the index of the first element, inclusive, to be sorted
 * @param toIndex the index of the last element, exclusive, to be sorted
 *
 * @throws java.lang.IllegalArgumentException if {@code fromIndex > toIndex}
 * @throws java.lang.ArrayIndexOutOfBoundsException
 *     if {@code fromIndex < 0} or {@code toIndex > a.length}
 *
 * @since 1.8
 * @apiSince 24
 */

public static void parallelSort(@androidx.annotation.NonNull short[] a, int fromIndex, int toIndex) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified array into ascending numerical order.
 *
 * @implNote The sorting algorithm is a parallel sort-merge that breaks the
 * array into sub-arrays that are themselves sorted and then merged. When
 * the sub-array length reaches a minimum granularity, the sub-array is
 * sorted using the appropriate {@link java.util.Arrays#sort(int[]) Arrays#sort(int[])}
 * method. If the length of the specified array is less than the minimum
 * granularity, then it is sorted using the appropriate {@link java.util.Arrays#sort(int[]) Arrays#sort(int[])} method. The algorithm requires a
 * working space no greater than the size of the original array. The
 * {@link java.util.concurrent.ForkJoinPool#commonPool() ForkJoinPool#commonPool()} is used to
 * execute any parallel tasks.
 *
 * @param a the array to be sorted
 *
 * @since 1.8
 * @apiSince 24
 */

public static void parallelSort(@androidx.annotation.NonNull int[] a) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified range of the array into ascending numerical order.
 * The range to be sorted extends from the index {@code fromIndex},
 * inclusive, to the index {@code toIndex}, exclusive. If
 * {@code fromIndex == toIndex}, the range to be sorted is empty.
 *
 * @implNote The sorting algorithm is a parallel sort-merge that breaks the
 * array into sub-arrays that are themselves sorted and then merged. When
 * the sub-array length reaches a minimum granularity, the sub-array is
 * sorted using the appropriate {@link java.util.Arrays#sort(int[]) Arrays#sort(int[])}
 * method. If the length of the specified array is less than the minimum
 * granularity, then it is sorted using the appropriate {@link java.util.Arrays#sort(int[]) Arrays#sort(int[])} method. The algorithm requires a working
 * space no greater than the size of the specified range of the original
 * array. The {@link java.util.concurrent.ForkJoinPool#commonPool() ForkJoinPool#commonPool()} is
 * used to execute any parallel tasks.
 *
 * @param a the array to be sorted
 * @param fromIndex the index of the first element, inclusive, to be sorted
 * @param toIndex the index of the last element, exclusive, to be sorted
 *
 * @throws java.lang.IllegalArgumentException if {@code fromIndex > toIndex}
 * @throws java.lang.ArrayIndexOutOfBoundsException
 *     if {@code fromIndex < 0} or {@code toIndex > a.length}
 *
 * @since 1.8
 * @apiSince 24
 */

public static void parallelSort(@androidx.annotation.NonNull int[] a, int fromIndex, int toIndex) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified array into ascending numerical order.
 *
 * @implNote The sorting algorithm is a parallel sort-merge that breaks the
 * array into sub-arrays that are themselves sorted and then merged. When
 * the sub-array length reaches a minimum granularity, the sub-array is
 * sorted using the appropriate {@link java.util.Arrays#sort(long[]) Arrays#sort(long[])}
 * method. If the length of the specified array is less than the minimum
 * granularity, then it is sorted using the appropriate {@link java.util.Arrays#sort(long[]) Arrays#sort(long[])} method. The algorithm requires a
 * working space no greater than the size of the original array. The
 * {@link java.util.concurrent.ForkJoinPool#commonPool() ForkJoinPool#commonPool()} is used to
 * execute any parallel tasks.
 *
 * @param a the array to be sorted
 *
 * @since 1.8
 * @apiSince 24
 */

public static void parallelSort(@androidx.annotation.NonNull long[] a) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified range of the array into ascending numerical order.
 * The range to be sorted extends from the index {@code fromIndex},
 * inclusive, to the index {@code toIndex}, exclusive. If
 * {@code fromIndex == toIndex}, the range to be sorted is empty.
 *
 * @implNote The sorting algorithm is a parallel sort-merge that breaks the
 * array into sub-arrays that are themselves sorted and then merged. When
 * the sub-array length reaches a minimum granularity, the sub-array is
 * sorted using the appropriate {@link java.util.Arrays#sort(long[]) Arrays#sort(long[])}
 * method. If the length of the specified array is less than the minimum
 * granularity, then it is sorted using the appropriate {@link java.util.Arrays#sort(long[]) Arrays#sort(long[])} method. The algorithm requires a working
 * space no greater than the size of the specified range of the original
 * array. The {@link java.util.concurrent.ForkJoinPool#commonPool() ForkJoinPool#commonPool()} is
 * used to execute any parallel tasks.
 *
 * @param a the array to be sorted
 * @param fromIndex the index of the first element, inclusive, to be sorted
 * @param toIndex the index of the last element, exclusive, to be sorted
 *
 * @throws java.lang.IllegalArgumentException if {@code fromIndex > toIndex}
 * @throws java.lang.ArrayIndexOutOfBoundsException
 *     if {@code fromIndex < 0} or {@code toIndex > a.length}
 *
 * @since 1.8
 * @apiSince 24
 */

public static void parallelSort(@androidx.annotation.NonNull long[] a, int fromIndex, int toIndex) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified array into ascending numerical order.
 *
 * <p>The {@code <} relation does not provide a total order on all float
 * values: {@code -0.0f == 0.0f} is {@code true} and a {@code Float.NaN}
 * value compares neither less than, greater than, nor equal to any value,
 * even itself. This method uses the total order imposed by the method
 * {@link java.lang.Float#compareTo Float#compareTo}: {@code -0.0f} is treated as less than value
 * {@code 0.0f} and {@code Float.NaN} is considered greater than any
 * other value and all {@code Float.NaN} values are considered equal.
 *
 * @implNote The sorting algorithm is a parallel sort-merge that breaks the
 * array into sub-arrays that are themselves sorted and then merged. When
 * the sub-array length reaches a minimum granularity, the sub-array is
 * sorted using the appropriate {@link java.util.Arrays#sort(float[]) Arrays#sort(float[])}
 * method. If the length of the specified array is less than the minimum
 * granularity, then it is sorted using the appropriate {@link java.util.Arrays#sort(float[]) Arrays#sort(float[])} method. The algorithm requires a
 * working space no greater than the size of the original array. The
 * {@link java.util.concurrent.ForkJoinPool#commonPool() ForkJoinPool#commonPool()} is used to
 * execute any parallel tasks.
 *
 * @param a the array to be sorted
 *
 * @since 1.8
 * @apiSince 24
 */

public static void parallelSort(@androidx.annotation.NonNull float[] a) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified range of the array into ascending numerical order.
 * The range to be sorted extends from the index {@code fromIndex},
 * inclusive, to the index {@code toIndex}, exclusive. If
 * {@code fromIndex == toIndex}, the range to be sorted is empty.
 *
 * <p>The {@code <} relation does not provide a total order on all float
 * values: {@code -0.0f == 0.0f} is {@code true} and a {@code Float.NaN}
 * value compares neither less than, greater than, nor equal to any value,
 * even itself. This method uses the total order imposed by the method
 * {@link java.lang.Float#compareTo Float#compareTo}: {@code -0.0f} is treated as less than value
 * {@code 0.0f} and {@code Float.NaN} is considered greater than any
 * other value and all {@code Float.NaN} values are considered equal.
 *
 * @implNote The sorting algorithm is a parallel sort-merge that breaks the
 * array into sub-arrays that are themselves sorted and then merged. When
 * the sub-array length reaches a minimum granularity, the sub-array is
 * sorted using the appropriate {@link java.util.Arrays#sort(float[]) Arrays#sort(float[])}
 * method. If the length of the specified array is less than the minimum
 * granularity, then it is sorted using the appropriate {@link java.util.Arrays#sort(float[]) Arrays#sort(float[])} method. The algorithm requires a working
 * space no greater than the size of the specified range of the original
 * array. The {@link java.util.concurrent.ForkJoinPool#commonPool() ForkJoinPool#commonPool()} is
 * used to execute any parallel tasks.
 *
 * @param a the array to be sorted
 * @param fromIndex the index of the first element, inclusive, to be sorted
 * @param toIndex the index of the last element, exclusive, to be sorted
 *
 * @throws java.lang.IllegalArgumentException if {@code fromIndex > toIndex}
 * @throws java.lang.ArrayIndexOutOfBoundsException
 *     if {@code fromIndex < 0} or {@code toIndex > a.length}
 *
 * @since 1.8
 * @apiSince 24
 */

public static void parallelSort(@androidx.annotation.NonNull float[] a, int fromIndex, int toIndex) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified array into ascending numerical order.
 *
 * <p>The {@code <} relation does not provide a total order on all double
 * values: {@code -0.0d == 0.0d} is {@code true} and a {@code Double.NaN}
 * value compares neither less than, greater than, nor equal to any value,
 * even itself. This method uses the total order imposed by the method
 * {@link java.lang.Double#compareTo Double#compareTo}: {@code -0.0d} is treated as less than value
 * {@code 0.0d} and {@code Double.NaN} is considered greater than any
 * other value and all {@code Double.NaN} values are considered equal.
 *
 * @implNote The sorting algorithm is a parallel sort-merge that breaks the
 * array into sub-arrays that are themselves sorted and then merged. When
 * the sub-array length reaches a minimum granularity, the sub-array is
 * sorted using the appropriate {@link java.util.Arrays#sort(double[]) Arrays#sort(double[])}
 * method. If the length of the specified array is less than the minimum
 * granularity, then it is sorted using the appropriate {@link java.util.Arrays#sort(double[]) Arrays#sort(double[])} method. The algorithm requires a
 * working space no greater than the size of the original array. The
 * {@link java.util.concurrent.ForkJoinPool#commonPool() ForkJoinPool#commonPool()} is used to
 * execute any parallel tasks.
 *
 * @param a the array to be sorted
 *
 * @since 1.8
 * @apiSince 24
 */

public static void parallelSort(@androidx.annotation.NonNull double[] a) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified range of the array into ascending numerical order.
 * The range to be sorted extends from the index {@code fromIndex},
 * inclusive, to the index {@code toIndex}, exclusive. If
 * {@code fromIndex == toIndex}, the range to be sorted is empty.
 *
 * <p>The {@code <} relation does not provide a total order on all double
 * values: {@code -0.0d == 0.0d} is {@code true} and a {@code Double.NaN}
 * value compares neither less than, greater than, nor equal to any value,
 * even itself. This method uses the total order imposed by the method
 * {@link java.lang.Double#compareTo Double#compareTo}: {@code -0.0d} is treated as less than value
 * {@code 0.0d} and {@code Double.NaN} is considered greater than any
 * other value and all {@code Double.NaN} values are considered equal.
 *
 * @implNote The sorting algorithm is a parallel sort-merge that breaks the
 * array into sub-arrays that are themselves sorted and then merged. When
 * the sub-array length reaches a minimum granularity, the sub-array is
 * sorted using the appropriate {@link java.util.Arrays#sort(double[]) Arrays#sort(double[])}
 * method. If the length of the specified array is less than the minimum
 * granularity, then it is sorted using the appropriate {@link java.util.Arrays#sort(double[]) Arrays#sort(double[])} method. The algorithm requires a working
 * space no greater than the size of the specified range of the original
 * array. The {@link java.util.concurrent.ForkJoinPool#commonPool() ForkJoinPool#commonPool()} is
 * used to execute any parallel tasks.
 *
 * @param a the array to be sorted
 * @param fromIndex the index of the first element, inclusive, to be sorted
 * @param toIndex the index of the last element, exclusive, to be sorted
 *
 * @throws java.lang.IllegalArgumentException if {@code fromIndex > toIndex}
 * @throws java.lang.ArrayIndexOutOfBoundsException
 *     if {@code fromIndex < 0} or {@code toIndex > a.length}
 *
 * @since 1.8
 * @apiSince 24
 */

public static void parallelSort(@androidx.annotation.NonNull double[] a, int fromIndex, int toIndex) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified array of objects into ascending order, according
 * to the {@linkplain java.lang.Comparable Comparable} of its elements.
 * All elements in the array must implement the {@link java.lang.Comparable Comparable}
 * interface.  Furthermore, all elements in the array must be
 * <i>mutually comparable</i> (that is, {@code e1.compareTo(e2)} must
 * not throw a {@code ClassCastException} for any elements {@code e1}
 * and {@code e2} in the array).
 *
 * <p>This sort is guaranteed to be <i>stable</i>:  equal elements will
 * not be reordered as a result of the sort.
 *
 * @implNote The sorting algorithm is a parallel sort-merge that breaks the
 * array into sub-arrays that are themselves sorted and then merged. When
 * the sub-array length reaches a minimum granularity, the sub-array is
 * sorted using the appropriate {@link java.util.Arrays#sort(java.lang.Object[]) Arrays#sort(Object[])}
 * method. If the length of the specified array is less than the minimum
 * granularity, then it is sorted using the appropriate {@link java.util.Arrays#sort(java.lang.Object[]) Arrays#sort(Object[])} method. The algorithm requires a
 * working space no greater than the size of the original array. The
 * {@link java.util.concurrent.ForkJoinPool#commonPool() ForkJoinPool#commonPool()} is used to
 * execute any parallel tasks.
 *
 * @param <T> the class of the objects to be sorted
 * @param a the array to be sorted
 *
 * @throws java.lang.ClassCastException if the array contains elements that are not
 *         <i>mutually comparable</i> (for example, strings and integers)
 * @throws java.lang.IllegalArgumentException (optional) if the natural
 *         ordering of the array elements is found to violate the
 *         {@link java.lang.Comparable Comparable} contract
 *
 * @since 1.8
 * @apiSince 24
 */

public static <T extends java.lang.Comparable<? super T>> void parallelSort(@androidx.annotation.NonNull T[] a) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified range of the specified array of objects into
 * ascending order, according to the
 * {@linkplain java.lang.Comparable Comparable} of its
 * elements.  The range to be sorted extends from index
 * {@code fromIndex}, inclusive, to index {@code toIndex}, exclusive.
 * (If {@code fromIndex==toIndex}, the range to be sorted is empty.)  All
 * elements in this range must implement the {@link java.lang.Comparable Comparable}
 * interface.  Furthermore, all elements in this range must be <i>mutually
 * comparable</i> (that is, {@code e1.compareTo(e2)} must not throw a
 * {@code ClassCastException} for any elements {@code e1} and
 * {@code e2} in the array).
 *
 * <p>This sort is guaranteed to be <i>stable</i>:  equal elements will
 * not be reordered as a result of the sort.
 *
 * @implNote The sorting algorithm is a parallel sort-merge that breaks the
 * array into sub-arrays that are themselves sorted and then merged. When
 * the sub-array length reaches a minimum granularity, the sub-array is
 * sorted using the appropriate {@link java.util.Arrays#sort(java.lang.Object[]) Arrays#sort(Object[])}
 * method. If the length of the specified array is less than the minimum
 * granularity, then it is sorted using the appropriate {@link java.util.Arrays#sort(java.lang.Object[]) Arrays#sort(Object[])} method. The algorithm requires a working
 * space no greater than the size of the specified range of the original
 * array. The {@link java.util.concurrent.ForkJoinPool#commonPool() ForkJoinPool#commonPool()} is
 * used to execute any parallel tasks.
 *
 * @param <T> the class of the objects to be sorted
 * @param a the array to be sorted
 * @param fromIndex the index of the first element (inclusive) to be
 *        sorted
 * @param toIndex the index of the last element (exclusive) to be sorted
 * @throws java.lang.IllegalArgumentException if {@code fromIndex > toIndex} or
 *         (optional) if the natural ordering of the array elements is
 *         found to violate the {@link java.lang.Comparable Comparable} contract
 * @throws java.lang.ArrayIndexOutOfBoundsException if {@code fromIndex < 0} or
 *         {@code toIndex > a.length}
 * @throws java.lang.ClassCastException if the array contains elements that are
 *         not <i>mutually comparable</i> (for example, strings and
 *         integers).
 *
 * @since 1.8
 * @apiSince 24
 */

public static <T extends java.lang.Comparable<? super T>> void parallelSort(@androidx.annotation.NonNull T[] a, int fromIndex, int toIndex) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified array of objects according to the order induced by
 * the specified comparator.  All elements in the array must be
 * <i>mutually comparable</i> by the specified comparator (that is,
 * {@code c.compare(e1, e2)} must not throw a {@code ClassCastException}
 * for any elements {@code e1} and {@code e2} in the array).
 *
 * <p>This sort is guaranteed to be <i>stable</i>:  equal elements will
 * not be reordered as a result of the sort.
 *
 * @implNote The sorting algorithm is a parallel sort-merge that breaks the
 * array into sub-arrays that are themselves sorted and then merged. When
 * the sub-array length reaches a minimum granularity, the sub-array is
 * sorted using the appropriate {@link java.util.Arrays#sort(java.lang.Object[]) Arrays#sort(Object[])}
 * method. If the length of the specified array is less than the minimum
 * granularity, then it is sorted using the appropriate {@link java.util.Arrays#sort(java.lang.Object[]) Arrays#sort(Object[])} method. The algorithm requires a
 * working space no greater than the size of the original array. The
 * {@link java.util.concurrent.ForkJoinPool#commonPool() ForkJoinPool#commonPool()} is used to
 * execute any parallel tasks.
 *
 * @param <T> the class of the objects to be sorted
 * @param a the array to be sorted
 * @param cmp the comparator to determine the order of the array.  A
 *        {@code null} value indicates that the elements'
 *        {@linkplain java.lang.Comparable Comparable} should be used.
 * @throws java.lang.ClassCastException if the array contains elements that are
 *         not <i>mutually comparable</i> using the specified comparator
 * @throws java.lang.IllegalArgumentException (optional) if the comparator is
 *         found to violate the {@link java.util.Comparator} contract
 *
 * @since 1.8
 * @apiSince 24
 */

public static <T> void parallelSort(@androidx.annotation.NonNull T[] a, @androidx.annotation.Nullable java.util.Comparator<? super T> cmp) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified range of the specified array of objects according
 * to the order induced by the specified comparator.  The range to be
 * sorted extends from index {@code fromIndex}, inclusive, to index
 * {@code toIndex}, exclusive.  (If {@code fromIndex==toIndex}, the
 * range to be sorted is empty.)  All elements in the range must be
 * <i>mutually comparable</i> by the specified comparator (that is,
 * {@code c.compare(e1, e2)} must not throw a {@code ClassCastException}
 * for any elements {@code e1} and {@code e2} in the range).
 *
 * <p>This sort is guaranteed to be <i>stable</i>:  equal elements will
 * not be reordered as a result of the sort.
 *
 * @implNote The sorting algorithm is a parallel sort-merge that breaks the
 * array into sub-arrays that are themselves sorted and then merged. When
 * the sub-array length reaches a minimum granularity, the sub-array is
 * sorted using the appropriate {@link java.util.Arrays#sort(java.lang.Object[]) Arrays#sort(Object[])}
 * method. If the length of the specified array is less than the minimum
 * granularity, then it is sorted using the appropriate {@link java.util.Arrays#sort(java.lang.Object[]) Arrays#sort(Object[])} method. The algorithm requires a working
 * space no greater than the size of the specified range of the original
 * array. The {@link java.util.concurrent.ForkJoinPool#commonPool() ForkJoinPool#commonPool()} is
 * used to execute any parallel tasks.
 *
 * @param <T> the class of the objects to be sorted
 * @param a the array to be sorted
 * @param fromIndex the index of the first element (inclusive) to be
 *        sorted
 * @param toIndex the index of the last element (exclusive) to be sorted
 * @param cmp the comparator to determine the order of the array.  A
 *        {@code null} value indicates that the elements'
 *        {@linkplain java.lang.Comparable Comparable} should be used.
 * @throws java.lang.IllegalArgumentException if {@code fromIndex > toIndex} or
 *         (optional) if the natural ordering of the array elements is
 *         found to violate the {@link java.lang.Comparable Comparable} contract
 * @throws java.lang.ArrayIndexOutOfBoundsException if {@code fromIndex < 0} or
 *         {@code toIndex > a.length}
 * @throws java.lang.ClassCastException if the array contains elements that are
 *         not <i>mutually comparable</i> (for example, strings and
 *         integers).
 *
 * @since 1.8
 * @apiSince 24
 */

public static <T> void parallelSort(@androidx.annotation.NonNull T[] a, int fromIndex, int toIndex, @androidx.annotation.Nullable java.util.Comparator<? super T> cmp) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified array of objects into ascending order, according
 * to the {@linkplain java.lang.Comparable Comparable} of its elements.
 * All elements in the array must implement the {@link java.lang.Comparable Comparable}
 * interface.  Furthermore, all elements in the array must be
 * <i>mutually comparable</i> (that is, {@code e1.compareTo(e2)} must
 * not throw a {@code ClassCastException} for any elements {@code e1}
 * and {@code e2} in the array).
 *
 * <p>This sort is guaranteed to be <i>stable</i>:  equal elements will
 * not be reordered as a result of the sort.
 *
 * <p>Implementation note: This implementation is a stable, adaptive,
 * iterative mergesort that requires far fewer than n lg(n) comparisons
 * when the input array is partially sorted, while offering the
 * performance of a traditional mergesort when the input array is
 * randomly ordered.  If the input array is nearly sorted, the
 * implementation requires approximately n comparisons.  Temporary
 * storage requirements vary from a small constant for nearly sorted
 * input arrays to n/2 object references for randomly ordered input
 * arrays.
 *
 * <p>The implementation takes equal advantage of ascending and
 * descending order in its input array, and can take advantage of
 * ascending and descending order in different parts of the the same
 * input array.  It is well-suited to merging two or more sorted arrays:
 * simply concatenate the arrays and sort the resulting array.
 *
 * <p>The implementation was adapted from Tim Peters's list sort for Python
 * (<a href="http://svn.python.org/projects/python/trunk/Objects/listsort.txt">
 * TimSort</a>).  It uses techniques from Peter McIlroy's "Optimistic
 * Sorting and Information Theoretic Complexity", in Proceedings of the
 * Fourth Annual ACM-SIAM Symposium on Discrete Algorithms, pp 467-474,
 * January 1993.
 *
 * @param a the array to be sorted
 * @throws java.lang.ClassCastException if the array contains elements that are not
 *         <i>mutually comparable</i> (for example, strings and integers)
 * @throws java.lang.IllegalArgumentException (optional) if the natural
 *         ordering of the array elements is found to violate the
 *         {@link java.lang.Comparable Comparable} contract
 * @apiSince 1
 */

public static void sort(@androidx.annotation.NonNull java.lang.Object[] a) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified range of the specified array of objects into
 * ascending order, according to the
 * {@linkplain java.lang.Comparable Comparable} of its
 * elements.  The range to be sorted extends from index
 * {@code fromIndex}, inclusive, to index {@code toIndex}, exclusive.
 * (If {@code fromIndex==toIndex}, the range to be sorted is empty.)  All
 * elements in this range must implement the {@link java.lang.Comparable Comparable}
 * interface.  Furthermore, all elements in this range must be <i>mutually
 * comparable</i> (that is, {@code e1.compareTo(e2)} must not throw a
 * {@code ClassCastException} for any elements {@code e1} and
 * {@code e2} in the array).
 *
 * <p>This sort is guaranteed to be <i>stable</i>:  equal elements will
 * not be reordered as a result of the sort.
 *
 * <p>Implementation note: This implementation is a stable, adaptive,
 * iterative mergesort that requires far fewer than n lg(n) comparisons
 * when the input array is partially sorted, while offering the
 * performance of a traditional mergesort when the input array is
 * randomly ordered.  If the input array is nearly sorted, the
 * implementation requires approximately n comparisons.  Temporary
 * storage requirements vary from a small constant for nearly sorted
 * input arrays to n/2 object references for randomly ordered input
 * arrays.
 *
 * <p>The implementation takes equal advantage of ascending and
 * descending order in its input array, and can take advantage of
 * ascending and descending order in different parts of the the same
 * input array.  It is well-suited to merging two or more sorted arrays:
 * simply concatenate the arrays and sort the resulting array.
 *
 * <p>The implementation was adapted from Tim Peters's list sort for Python
 * (<a href="http://svn.python.org/projects/python/trunk/Objects/listsort.txt">
 * TimSort</a>).  It uses techniques from Peter McIlroy's "Optimistic
 * Sorting and Information Theoretic Complexity", in Proceedings of the
 * Fourth Annual ACM-SIAM Symposium on Discrete Algorithms, pp 467-474,
 * January 1993.
 *
 * @param a the array to be sorted
 * @param fromIndex the index of the first element (inclusive) to be
 *        sorted
 * @param toIndex the index of the last element (exclusive) to be sorted
 * @throws java.lang.IllegalArgumentException if {@code fromIndex > toIndex} or
 *         (optional) if the natural ordering of the array elements is
 *         found to violate the {@link java.lang.Comparable Comparable} contract
 * @throws java.lang.ArrayIndexOutOfBoundsException if {@code fromIndex < 0} or
 *         {@code toIndex > a.length}
 * @throws java.lang.ClassCastException if the array contains elements that are
 *         not <i>mutually comparable</i> (for example, strings and
 *         integers).
 * @apiSince 1
 */

public static void sort(@androidx.annotation.NonNull java.lang.Object[] a, int fromIndex, int toIndex) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified array of objects according to the order induced by
 * the specified comparator.  All elements in the array must be
 * <i>mutually comparable</i> by the specified comparator (that is,
 * {@code c.compare(e1, e2)} must not throw a {@code ClassCastException}
 * for any elements {@code e1} and {@code e2} in the array).
 *
 * <p>This sort is guaranteed to be <i>stable</i>:  equal elements will
 * not be reordered as a result of the sort.
 *
 * <p>Implementation note: This implementation is a stable, adaptive,
 * iterative mergesort that requires far fewer than n lg(n) comparisons
 * when the input array is partially sorted, while offering the
 * performance of a traditional mergesort when the input array is
 * randomly ordered.  If the input array is nearly sorted, the
 * implementation requires approximately n comparisons.  Temporary
 * storage requirements vary from a small constant for nearly sorted
 * input arrays to n/2 object references for randomly ordered input
 * arrays.
 *
 * <p>The implementation takes equal advantage of ascending and
 * descending order in its input array, and can take advantage of
 * ascending and descending order in different parts of the the same
 * input array.  It is well-suited to merging two or more sorted arrays:
 * simply concatenate the arrays and sort the resulting array.
 *
 * <p>The implementation was adapted from Tim Peters's list sort for Python
 * (<a href="http://svn.python.org/projects/python/trunk/Objects/listsort.txt">
 * TimSort</a>).  It uses techniques from Peter McIlroy's "Optimistic
 * Sorting and Information Theoretic Complexity", in Proceedings of the
 * Fourth Annual ACM-SIAM Symposium on Discrete Algorithms, pp 467-474,
 * January 1993.
 *
 * @param <T> the class of the objects to be sorted
 * @param a the array to be sorted
 * @param c the comparator to determine the order of the array.  A
 *        {@code null} value indicates that the elements'
 *        {@linkplain java.lang.Comparable Comparable} should be used.
 * @throws java.lang.ClassCastException if the array contains elements that are
 *         not <i>mutually comparable</i> using the specified comparator
 * @throws java.lang.IllegalArgumentException (optional) if the comparator is
 *         found to violate the {@link java.util.Comparator Comparator} contract
 * @apiSince 1
 */

public static <T> void sort(@androidx.annotation.NonNull T[] a, @androidx.annotation.Nullable java.util.Comparator<? super T> c) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified range of the specified array of objects according
 * to the order induced by the specified comparator.  The range to be
 * sorted extends from index {@code fromIndex}, inclusive, to index
 * {@code toIndex}, exclusive.  (If {@code fromIndex==toIndex}, the
 * range to be sorted is empty.)  All elements in the range must be
 * <i>mutually comparable</i> by the specified comparator (that is,
 * {@code c.compare(e1, e2)} must not throw a {@code ClassCastException}
 * for any elements {@code e1} and {@code e2} in the range).
 *
 * <p>This sort is guaranteed to be <i>stable</i>:  equal elements will
 * not be reordered as a result of the sort.
 *
 * <p>Implementation note: This implementation is a stable, adaptive,
 * iterative mergesort that requires far fewer than n lg(n) comparisons
 * when the input array is partially sorted, while offering the
 * performance of a traditional mergesort when the input array is
 * randomly ordered.  If the input array is nearly sorted, the
 * implementation requires approximately n comparisons.  Temporary
 * storage requirements vary from a small constant for nearly sorted
 * input arrays to n/2 object references for randomly ordered input
 * arrays.
 *
 * <p>The implementation takes equal advantage of ascending and
 * descending order in its input array, and can take advantage of
 * ascending and descending order in different parts of the the same
 * input array.  It is well-suited to merging two or more sorted arrays:
 * simply concatenate the arrays and sort the resulting array.
 *
 * <p>The implementation was adapted from Tim Peters's list sort for Python
 * (<a href="http://svn.python.org/projects/python/trunk/Objects/listsort.txt">
 * TimSort</a>).  It uses techniques from Peter McIlroy's "Optimistic
 * Sorting and Information Theoretic Complexity", in Proceedings of the
 * Fourth Annual ACM-SIAM Symposium on Discrete Algorithms, pp 467-474,
 * January 1993.
 *
 * @param <T> the class of the objects to be sorted
 * @param a the array to be sorted
 * @param fromIndex the index of the first element (inclusive) to be
 *        sorted
 * @param toIndex the index of the last element (exclusive) to be sorted
 * @param c the comparator to determine the order of the array.  A
 *        {@code null} value indicates that the elements'
 *        {@linkplain java.lang.Comparable Comparable} should be used.
 * @throws java.lang.ClassCastException if the array contains elements that are not
 *         <i>mutually comparable</i> using the specified comparator.
 * @throws java.lang.IllegalArgumentException if {@code fromIndex > toIndex} or
 *         (optional) if the comparator is found to violate the
 *         {@link java.util.Comparator Comparator} contract
 * @throws java.lang.ArrayIndexOutOfBoundsException if {@code fromIndex < 0} or
 *         {@code toIndex > a.length}
 * @apiSince 1
 */

public static <T> void sort(@androidx.annotation.NonNull T[] a, int fromIndex, int toIndex, @androidx.annotation.Nullable java.util.Comparator<? super T> c) { throw new RuntimeException("Stub!"); }

/**
 * Cumulates, in parallel, each element of the given array in place,
 * using the supplied function. For example if the array initially
 * holds {@code [2, 1, 0, 3]} and the operation performs addition,
 * then upon return the array holds {@code [2, 3, 3, 6]}.
 * Parallel prefix computation is usually more efficient than
 * sequential loops for large arrays.
 *
 * @param <T> the class of the objects in the array
 * @param array the array, which is modified in-place by this method
 * @param op a side-effect-free, associative function to perform the
 * cumulation
 * @throws java.lang.NullPointerException if the specified array or function is null
 * @since 1.8
 * @apiSince 24
 */

public static <T> void parallelPrefix(@androidx.annotation.NonNull T[] array, @androidx.annotation.NonNull java.util.function.BinaryOperator<T> op) { throw new RuntimeException("Stub!"); }

/**
 * Performs {@link #parallelPrefix(java.lang.Object[],java.util.function.BinaryOperator)}
 * for the given subrange of the array.
 *
 * @param <T> the class of the objects in the array
 * @param array the array
 * @param fromIndex the index of the first element, inclusive
 * @param toIndex the index of the last element, exclusive
 * @param op a side-effect-free, associative function to perform the
 * cumulation
 * @throws java.lang.IllegalArgumentException if {@code fromIndex > toIndex}
 * @throws java.lang.ArrayIndexOutOfBoundsException
 *     if {@code fromIndex < 0} or {@code toIndex > array.length}
 * @throws java.lang.NullPointerException if the specified array or function is null
 * @since 1.8
 * @apiSince 24
 */

public static <T> void parallelPrefix(@androidx.annotation.NonNull T[] array, int fromIndex, int toIndex, @androidx.annotation.NonNull java.util.function.BinaryOperator<T> op) { throw new RuntimeException("Stub!"); }

/**
 * Cumulates, in parallel, each element of the given array in place,
 * using the supplied function. For example if the array initially
 * holds {@code [2, 1, 0, 3]} and the operation performs addition,
 * then upon return the array holds {@code [2, 3, 3, 6]}.
 * Parallel prefix computation is usually more efficient than
 * sequential loops for large arrays.
 *
 * @param array the array, which is modified in-place by this method
 * @param op a side-effect-free, associative function to perform the
 * cumulation
 * @throws java.lang.NullPointerException if the specified array or function is null
 * @since 1.8
 * @apiSince 24
 */

public static void parallelPrefix(@androidx.annotation.NonNull long[] array, @androidx.annotation.NonNull java.util.function.LongBinaryOperator op) { throw new RuntimeException("Stub!"); }

/**
 * Performs {@link #parallelPrefix(long[],java.util.function.LongBinaryOperator)}
 * for the given subrange of the array.
 *
 * @param array the array
 * @param fromIndex the index of the first element, inclusive
 * @param toIndex the index of the last element, exclusive
 * @param op a side-effect-free, associative function to perform the
 * cumulation
 * @throws java.lang.IllegalArgumentException if {@code fromIndex > toIndex}
 * @throws java.lang.ArrayIndexOutOfBoundsException
 *     if {@code fromIndex < 0} or {@code toIndex > array.length}
 * @throws java.lang.NullPointerException if the specified array or function is null
 * @since 1.8
 * @apiSince 24
 */

public static void parallelPrefix(@androidx.annotation.NonNull long[] array, int fromIndex, int toIndex, @androidx.annotation.NonNull java.util.function.LongBinaryOperator op) { throw new RuntimeException("Stub!"); }

/**
 * Cumulates, in parallel, each element of the given array in place,
 * using the supplied function. For example if the array initially
 * holds {@code [2.0, 1.0, 0.0, 3.0]} and the operation performs addition,
 * then upon return the array holds {@code [2.0, 3.0, 3.0, 6.0]}.
 * Parallel prefix computation is usually more efficient than
 * sequential loops for large arrays.
 *
 * <p> Because floating-point operations may not be strictly associative,
 * the returned result may not be identical to the value that would be
 * obtained if the operation was performed sequentially.
 *
 * @param array the array, which is modified in-place by this method
 * @param op a side-effect-free function to perform the cumulation
 * @throws java.lang.NullPointerException if the specified array or function is null
 * @since 1.8
 * @apiSince 24
 */

public static void parallelPrefix(@androidx.annotation.NonNull double[] array, @androidx.annotation.NonNull java.util.function.DoubleBinaryOperator op) { throw new RuntimeException("Stub!"); }

/**
 * Performs {@link #parallelPrefix(double[],java.util.function.DoubleBinaryOperator)}
 * for the given subrange of the array.
 *
 * @param array the array
 * @param fromIndex the index of the first element, inclusive
 * @param toIndex the index of the last element, exclusive
 * @param op a side-effect-free, associative function to perform the
 * cumulation
 * @throws java.lang.IllegalArgumentException if {@code fromIndex > toIndex}
 * @throws java.lang.ArrayIndexOutOfBoundsException
 *     if {@code fromIndex < 0} or {@code toIndex > array.length}
 * @throws java.lang.NullPointerException if the specified array or function is null
 * @since 1.8
 * @apiSince 24
 */

public static void parallelPrefix(@androidx.annotation.NonNull double[] array, int fromIndex, int toIndex, @androidx.annotation.NonNull java.util.function.DoubleBinaryOperator op) { throw new RuntimeException("Stub!"); }

/**
 * Cumulates, in parallel, each element of the given array in place,
 * using the supplied function. For example if the array initially
 * holds {@code [2, 1, 0, 3]} and the operation performs addition,
 * then upon return the array holds {@code [2, 3, 3, 6]}.
 * Parallel prefix computation is usually more efficient than
 * sequential loops for large arrays.
 *
 * @param array the array, which is modified in-place by this method
 * @param op a side-effect-free, associative function to perform the
 * cumulation
 * @throws java.lang.NullPointerException if the specified array or function is null
 * @since 1.8
 * @apiSince 24
 */

public static void parallelPrefix(@androidx.annotation.NonNull int[] array, @androidx.annotation.NonNull java.util.function.IntBinaryOperator op) { throw new RuntimeException("Stub!"); }

/**
 * Performs {@link #parallelPrefix(int[],java.util.function.IntBinaryOperator)}
 * for the given subrange of the array.
 *
 * @param array the array
 * @param fromIndex the index of the first element, inclusive
 * @param toIndex the index of the last element, exclusive
 * @param op a side-effect-free, associative function to perform the
 * cumulation
 * @throws java.lang.IllegalArgumentException if {@code fromIndex > toIndex}
 * @throws java.lang.ArrayIndexOutOfBoundsException
 *     if {@code fromIndex < 0} or {@code toIndex > array.length}
 * @throws java.lang.NullPointerException if the specified array or function is null
 * @since 1.8
 * @apiSince 24
 */

public static void parallelPrefix(@androidx.annotation.NonNull int[] array, int fromIndex, int toIndex, @androidx.annotation.NonNull java.util.function.IntBinaryOperator op) { throw new RuntimeException("Stub!"); }

/**
 * Searches the specified array of longs for the specified value using the
 * binary search algorithm.  The array must be sorted (as
 * by the {@link #sort(long[])} method) prior to making this call.  If it
 * is not sorted, the results are undefined.  If the array contains
 * multiple elements with the specified value, there is no guarantee which
 * one will be found.
 *
 * @param a the array to be searched
 * @param key the value to be searched for
 * @return index of the search key, if it is contained in the array;
 *         otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.  The
 *         <i>insertion point</i> is defined as the point at which the
 *         key would be inserted into the array: the index of the first
 *         element greater than the key, or <tt>a.length</tt> if all
 *         elements in the array are less than the specified key.  Note
 *         that this guarantees that the return value will be &gt;= 0 if
 *         and only if the key is found.
 * @apiSince 1
 */

public static int binarySearch(@androidx.annotation.NonNull long[] a, long key) { throw new RuntimeException("Stub!"); }

/**
 * Searches a range of
 * the specified array of longs for the specified value using the
 * binary search algorithm.
 * The range must be sorted (as
 * by the {@link #sort(long[],int,int)} method)
 * prior to making this call.  If it
 * is not sorted, the results are undefined.  If the range contains
 * multiple elements with the specified value, there is no guarantee which
 * one will be found.
 *
 * @param a the array to be searched
 * @param fromIndex the index of the first element (inclusive) to be
 *          searched
 * @param toIndex the index of the last element (exclusive) to be searched
 * @param key the value to be searched for
 * @return index of the search key, if it is contained in the array
 *         within the specified range;
 *         otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.  The
 *         <i>insertion point</i> is defined as the point at which the
 *         key would be inserted into the array: the index of the first
 *         element in the range greater than the key,
 *         or <tt>toIndex</tt> if all
 *         elements in the range are less than the specified key.  Note
 *         that this guarantees that the return value will be &gt;= 0 if
 *         and only if the key is found.
 * @throws java.lang.IllegalArgumentException
 *         if {@code fromIndex > toIndex}
 * @throws java.lang.ArrayIndexOutOfBoundsException
 *         if {@code fromIndex < 0 or toIndex > a.length}
 * @since 1.6
 * @apiSince 9
 */

public static int binarySearch(@androidx.annotation.NonNull long[] a, int fromIndex, int toIndex, long key) { throw new RuntimeException("Stub!"); }

/**
 * Searches the specified array of ints for the specified value using the
 * binary search algorithm.  The array must be sorted (as
 * by the {@link #sort(int[])} method) prior to making this call.  If it
 * is not sorted, the results are undefined.  If the array contains
 * multiple elements with the specified value, there is no guarantee which
 * one will be found.
 *
 * @param a the array to be searched
 * @param key the value to be searched for
 * @return index of the search key, if it is contained in the array;
 *         otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.  The
 *         <i>insertion point</i> is defined as the point at which the
 *         key would be inserted into the array: the index of the first
 *         element greater than the key, or <tt>a.length</tt> if all
 *         elements in the array are less than the specified key.  Note
 *         that this guarantees that the return value will be &gt;= 0 if
 *         and only if the key is found.
 * @apiSince 1
 */

public static int binarySearch(@androidx.annotation.NonNull int[] a, int key) { throw new RuntimeException("Stub!"); }

/**
 * Searches a range of
 * the specified array of ints for the specified value using the
 * binary search algorithm.
 * The range must be sorted (as
 * by the {@link #sort(int[],int,int)} method)
 * prior to making this call.  If it
 * is not sorted, the results are undefined.  If the range contains
 * multiple elements with the specified value, there is no guarantee which
 * one will be found.
 *
 * @param a the array to be searched
 * @param fromIndex the index of the first element (inclusive) to be
 *          searched
 * @param toIndex the index of the last element (exclusive) to be searched
 * @param key the value to be searched for
 * @return index of the search key, if it is contained in the array
 *         within the specified range;
 *         otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.  The
 *         <i>insertion point</i> is defined as the point at which the
 *         key would be inserted into the array: the index of the first
 *         element in the range greater than the key,
 *         or <tt>toIndex</tt> if all
 *         elements in the range are less than the specified key.  Note
 *         that this guarantees that the return value will be &gt;= 0 if
 *         and only if the key is found.
 * @throws java.lang.IllegalArgumentException
 *         if {@code fromIndex > toIndex}
 * @throws java.lang.ArrayIndexOutOfBoundsException
 *         if {@code fromIndex < 0 or toIndex > a.length}
 * @since 1.6
 * @apiSince 9
 */

public static int binarySearch(@androidx.annotation.NonNull int[] a, int fromIndex, int toIndex, int key) { throw new RuntimeException("Stub!"); }

/**
 * Searches the specified array of shorts for the specified value using
 * the binary search algorithm.  The array must be sorted
 * (as by the {@link #sort(short[])} method) prior to making this call.  If
 * it is not sorted, the results are undefined.  If the array contains
 * multiple elements with the specified value, there is no guarantee which
 * one will be found.
 *
 * @param a the array to be searched
 * @param key the value to be searched for
 * @return index of the search key, if it is contained in the array;
 *         otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.  The
 *         <i>insertion point</i> is defined as the point at which the
 *         key would be inserted into the array: the index of the first
 *         element greater than the key, or <tt>a.length</tt> if all
 *         elements in the array are less than the specified key.  Note
 *         that this guarantees that the return value will be &gt;= 0 if
 *         and only if the key is found.
 * @apiSince 1
 */

public static int binarySearch(@androidx.annotation.NonNull short[] a, short key) { throw new RuntimeException("Stub!"); }

/**
 * Searches a range of
 * the specified array of shorts for the specified value using
 * the binary search algorithm.
 * The range must be sorted
 * (as by the {@link #sort(short[],int,int)} method)
 * prior to making this call.  If
 * it is not sorted, the results are undefined.  If the range contains
 * multiple elements with the specified value, there is no guarantee which
 * one will be found.
 *
 * @param a the array to be searched
 * @param fromIndex the index of the first element (inclusive) to be
 *          searched
 * @param toIndex the index of the last element (exclusive) to be searched
 * @param key the value to be searched for
 * @return index of the search key, if it is contained in the array
 *         within the specified range;
 *         otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.  The
 *         <i>insertion point</i> is defined as the point at which the
 *         key would be inserted into the array: the index of the first
 *         element in the range greater than the key,
 *         or <tt>toIndex</tt> if all
 *         elements in the range are less than the specified key.  Note
 *         that this guarantees that the return value will be &gt;= 0 if
 *         and only if the key is found.
 * @throws java.lang.IllegalArgumentException
 *         if {@code fromIndex > toIndex}
 * @throws java.lang.ArrayIndexOutOfBoundsException
 *         if {@code fromIndex < 0 or toIndex > a.length}
 * @since 1.6
 * @apiSince 9
 */

public static int binarySearch(@androidx.annotation.NonNull short[] a, int fromIndex, int toIndex, short key) { throw new RuntimeException("Stub!"); }

/**
 * Searches the specified array of chars for the specified value using the
 * binary search algorithm.  The array must be sorted (as
 * by the {@link #sort(char[])} method) prior to making this call.  If it
 * is not sorted, the results are undefined.  If the array contains
 * multiple elements with the specified value, there is no guarantee which
 * one will be found.
 *
 * @param a the array to be searched
 * @param key the value to be searched for
 * @return index of the search key, if it is contained in the array;
 *         otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.  The
 *         <i>insertion point</i> is defined as the point at which the
 *         key would be inserted into the array: the index of the first
 *         element greater than the key, or <tt>a.length</tt> if all
 *         elements in the array are less than the specified key.  Note
 *         that this guarantees that the return value will be &gt;= 0 if
 *         and only if the key is found.
 * @apiSince 1
 */

public static int binarySearch(@androidx.annotation.NonNull char[] a, char key) { throw new RuntimeException("Stub!"); }

/**
 * Searches a range of
 * the specified array of chars for the specified value using the
 * binary search algorithm.
 * The range must be sorted (as
 * by the {@link #sort(char[],int,int)} method)
 * prior to making this call.  If it
 * is not sorted, the results are undefined.  If the range contains
 * multiple elements with the specified value, there is no guarantee which
 * one will be found.
 *
 * @param a the array to be searched
 * @param fromIndex the index of the first element (inclusive) to be
 *          searched
 * @param toIndex the index of the last element (exclusive) to be searched
 * @param key the value to be searched for
 * @return index of the search key, if it is contained in the array
 *         within the specified range;
 *         otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.  The
 *         <i>insertion point</i> is defined as the point at which the
 *         key would be inserted into the array: the index of the first
 *         element in the range greater than the key,
 *         or <tt>toIndex</tt> if all
 *         elements in the range are less than the specified key.  Note
 *         that this guarantees that the return value will be &gt;= 0 if
 *         and only if the key is found.
 * @throws java.lang.IllegalArgumentException
 *         if {@code fromIndex > toIndex}
 * @throws java.lang.ArrayIndexOutOfBoundsException
 *         if {@code fromIndex < 0 or toIndex > a.length}
 * @since 1.6
 * @apiSince 9
 */

public static int binarySearch(@androidx.annotation.NonNull char[] a, int fromIndex, int toIndex, char key) { throw new RuntimeException("Stub!"); }

/**
 * Searches the specified array of bytes for the specified value using the
 * binary search algorithm.  The array must be sorted (as
 * by the {@link #sort(byte[])} method) prior to making this call.  If it
 * is not sorted, the results are undefined.  If the array contains
 * multiple elements with the specified value, there is no guarantee which
 * one will be found.
 *
 * @param a the array to be searched
 * @param key the value to be searched for
 * @return index of the search key, if it is contained in the array;
 *         otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.  The
 *         <i>insertion point</i> is defined as the point at which the
 *         key would be inserted into the array: the index of the first
 *         element greater than the key, or <tt>a.length</tt> if all
 *         elements in the array are less than the specified key.  Note
 *         that this guarantees that the return value will be &gt;= 0 if
 *         and only if the key is found.
 * @apiSince 1
 */

public static int binarySearch(@androidx.annotation.NonNull byte[] a, byte key) { throw new RuntimeException("Stub!"); }

/**
 * Searches a range of
 * the specified array of bytes for the specified value using the
 * binary search algorithm.
 * The range must be sorted (as
 * by the {@link #sort(byte[],int,int)} method)
 * prior to making this call.  If it
 * is not sorted, the results are undefined.  If the range contains
 * multiple elements with the specified value, there is no guarantee which
 * one will be found.
 *
 * @param a the array to be searched
 * @param fromIndex the index of the first element (inclusive) to be
 *          searched
 * @param toIndex the index of the last element (exclusive) to be searched
 * @param key the value to be searched for
 * @return index of the search key, if it is contained in the array
 *         within the specified range;
 *         otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.  The
 *         <i>insertion point</i> is defined as the point at which the
 *         key would be inserted into the array: the index of the first
 *         element in the range greater than the key,
 *         or <tt>toIndex</tt> if all
 *         elements in the range are less than the specified key.  Note
 *         that this guarantees that the return value will be &gt;= 0 if
 *         and only if the key is found.
 * @throws java.lang.IllegalArgumentException
 *         if {@code fromIndex > toIndex}
 * @throws java.lang.ArrayIndexOutOfBoundsException
 *         if {@code fromIndex < 0 or toIndex > a.length}
 * @since 1.6
 * @apiSince 9
 */

public static int binarySearch(@androidx.annotation.NonNull byte[] a, int fromIndex, int toIndex, byte key) { throw new RuntimeException("Stub!"); }

/**
 * Searches the specified array of doubles for the specified value using
 * the binary search algorithm.  The array must be sorted
 * (as by the {@link #sort(double[])} method) prior to making this call.
 * If it is not sorted, the results are undefined.  If the array contains
 * multiple elements with the specified value, there is no guarantee which
 * one will be found.  This method considers all NaN values to be
 * equivalent and equal.
 *
 * @param a the array to be searched
 * @param key the value to be searched for
 * @return index of the search key, if it is contained in the array;
 *         otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.  The
 *         <i>insertion point</i> is defined as the point at which the
 *         key would be inserted into the array: the index of the first
 *         element greater than the key, or <tt>a.length</tt> if all
 *         elements in the array are less than the specified key.  Note
 *         that this guarantees that the return value will be &gt;= 0 if
 *         and only if the key is found.
 * @apiSince 1
 */

public static int binarySearch(@androidx.annotation.NonNull double[] a, double key) { throw new RuntimeException("Stub!"); }

/**
 * Searches a range of
 * the specified array of doubles for the specified value using
 * the binary search algorithm.
 * The range must be sorted
 * (as by the {@link #sort(double[],int,int)} method)
 * prior to making this call.
 * If it is not sorted, the results are undefined.  If the range contains
 * multiple elements with the specified value, there is no guarantee which
 * one will be found.  This method considers all NaN values to be
 * equivalent and equal.
 *
 * @param a the array to be searched
 * @param fromIndex the index of the first element (inclusive) to be
 *          searched
 * @param toIndex the index of the last element (exclusive) to be searched
 * @param key the value to be searched for
 * @return index of the search key, if it is contained in the array
 *         within the specified range;
 *         otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.  The
 *         <i>insertion point</i> is defined as the point at which the
 *         key would be inserted into the array: the index of the first
 *         element in the range greater than the key,
 *         or <tt>toIndex</tt> if all
 *         elements in the range are less than the specified key.  Note
 *         that this guarantees that the return value will be &gt;= 0 if
 *         and only if the key is found.
 * @throws java.lang.IllegalArgumentException
 *         if {@code fromIndex > toIndex}
 * @throws java.lang.ArrayIndexOutOfBoundsException
 *         if {@code fromIndex < 0 or toIndex > a.length}
 * @since 1.6
 * @apiSince 9
 */

public static int binarySearch(@androidx.annotation.NonNull double[] a, int fromIndex, int toIndex, double key) { throw new RuntimeException("Stub!"); }

/**
 * Searches the specified array of floats for the specified value using
 * the binary search algorithm. The array must be sorted
 * (as by the {@link #sort(float[])} method) prior to making this call. If
 * it is not sorted, the results are undefined. If the array contains
 * multiple elements with the specified value, there is no guarantee which
 * one will be found. This method considers all NaN values to be
 * equivalent and equal.
 *
 * @param a the array to be searched
 * @param key the value to be searched for
 * @return index of the search key, if it is contained in the array;
 *         otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>. The
 *         <i>insertion point</i> is defined as the point at which the
 *         key would be inserted into the array: the index of the first
 *         element greater than the key, or <tt>a.length</tt> if all
 *         elements in the array are less than the specified key. Note
 *         that this guarantees that the return value will be &gt;= 0 if
 *         and only if the key is found.
 * @apiSince 1
 */

public static int binarySearch(@androidx.annotation.NonNull float[] a, float key) { throw new RuntimeException("Stub!"); }

/**
 * Searches a range of
 * the specified array of floats for the specified value using
 * the binary search algorithm.
 * The range must be sorted
 * (as by the {@link #sort(float[],int,int)} method)
 * prior to making this call. If
 * it is not sorted, the results are undefined. If the range contains
 * multiple elements with the specified value, there is no guarantee which
 * one will be found. This method considers all NaN values to be
 * equivalent and equal.
 *
 * @param a the array to be searched
 * @param fromIndex the index of the first element (inclusive) to be
 *          searched
 * @param toIndex the index of the last element (exclusive) to be searched
 * @param key the value to be searched for
 * @return index of the search key, if it is contained in the array
 *         within the specified range;
 *         otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>. The
 *         <i>insertion point</i> is defined as the point at which the
 *         key would be inserted into the array: the index of the first
 *         element in the range greater than the key,
 *         or <tt>toIndex</tt> if all
 *         elements in the range are less than the specified key. Note
 *         that this guarantees that the return value will be &gt;= 0 if
 *         and only if the key is found.
 * @throws java.lang.IllegalArgumentException
 *         if {@code fromIndex > toIndex}
 * @throws java.lang.ArrayIndexOutOfBoundsException
 *         if {@code fromIndex < 0 or toIndex > a.length}
 * @since 1.6
 * @apiSince 9
 */

public static int binarySearch(@androidx.annotation.NonNull float[] a, int fromIndex, int toIndex, float key) { throw new RuntimeException("Stub!"); }

/**
 * Searches the specified array for the specified object using the binary
 * search algorithm. The array must be sorted into ascending order
 * according to the
 * {@linkplain java.lang.Comparable Comparable}
 * of its elements (as by the
 * {@link #sort(java.lang.Object[])} method) prior to making this call.
 * If it is not sorted, the results are undefined.
 * (If the array contains elements that are not mutually comparable (for
 * example, strings and integers), it <i>cannot</i> be sorted according
 * to the natural ordering of its elements, hence results are undefined.)
 * If the array contains multiple
 * elements equal to the specified object, there is no guarantee which
 * one will be found.
 *
 * @param a the array to be searched
 * @param key the value to be searched for
 * @return index of the search key, if it is contained in the array;
 *         otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.  The
 *         <i>insertion point</i> is defined as the point at which the
 *         key would be inserted into the array: the index of the first
 *         element greater than the key, or <tt>a.length</tt> if all
 *         elements in the array are less than the specified key.  Note
 *         that this guarantees that the return value will be &gt;= 0 if
 *         and only if the key is found.
 * @throws java.lang.ClassCastException if the search key is not comparable to the
 *         elements of the array.
 * @apiSince 1
 */

public static int binarySearch(@androidx.annotation.NonNull java.lang.Object[] a, @androidx.annotation.NonNull java.lang.Object key) { throw new RuntimeException("Stub!"); }

/**
 * Searches a range of
 * the specified array for the specified object using the binary
 * search algorithm.
 * The range must be sorted into ascending order
 * according to the
 * {@linkplain java.lang.Comparable Comparable}
 * of its elements (as by the
 * {@link #sort(java.lang.Object[],int,int)} method) prior to making this
 * call.  If it is not sorted, the results are undefined.
 * (If the range contains elements that are not mutually comparable (for
 * example, strings and integers), it <i>cannot</i> be sorted according
 * to the natural ordering of its elements, hence results are undefined.)
 * If the range contains multiple
 * elements equal to the specified object, there is no guarantee which
 * one will be found.
 *
 * @param a the array to be searched
 * @param fromIndex the index of the first element (inclusive) to be
 *          searched
 * @param toIndex the index of the last element (exclusive) to be searched
 * @param key the value to be searched for
 * @return index of the search key, if it is contained in the array
 *         within the specified range;
 *         otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.  The
 *         <i>insertion point</i> is defined as the point at which the
 *         key would be inserted into the array: the index of the first
 *         element in the range greater than the key,
 *         or <tt>toIndex</tt> if all
 *         elements in the range are less than the specified key.  Note
 *         that this guarantees that the return value will be &gt;= 0 if
 *         and only if the key is found.
 * @throws java.lang.ClassCastException if the search key is not comparable to the
 *         elements of the array within the specified range.
 * @throws java.lang.IllegalArgumentException
 *         if {@code fromIndex > toIndex}
 * @throws java.lang.ArrayIndexOutOfBoundsException
 *         if {@code fromIndex < 0 or toIndex > a.length}
 * @since 1.6
 * @apiSince 9
 */

public static int binarySearch(@androidx.annotation.NonNull java.lang.Object[] a, int fromIndex, int toIndex, @androidx.annotation.NonNull java.lang.Object key) { throw new RuntimeException("Stub!"); }

/**
 * Searches the specified array for the specified object using the binary
 * search algorithm.  The array must be sorted into ascending order
 * according to the specified comparator (as by the
 * {@link #sort(java.lang.Object[],java.util.Comparator) sort(T[], Comparator)}
 * method) prior to making this call.  If it is
 * not sorted, the results are undefined.
 * If the array contains multiple
 * elements equal to the specified object, there is no guarantee which one
 * will be found.
 *
 * @param <T> the class of the objects in the array
 * @param a the array to be searched
 * @param key the value to be searched for
 * @param c the comparator by which the array is ordered.  A
 *        <tt>null</tt> value indicates that the elements'
 *        {@linkplain java.lang.Comparable Comparable} should be used.
 * @return index of the search key, if it is contained in the array;
 *         otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.  The
 *         <i>insertion point</i> is defined as the point at which the
 *         key would be inserted into the array: the index of the first
 *         element greater than the key, or <tt>a.length</tt> if all
 *         elements in the array are less than the specified key.  Note
 *         that this guarantees that the return value will be &gt;= 0 if
 *         and only if the key is found.
 * @throws java.lang.ClassCastException if the array contains elements that are not
 *         <i>mutually comparable</i> using the specified comparator,
 *         or the search key is not comparable to the
 *         elements of the array using this comparator.
 * @apiSince 1
 */

public static <T> int binarySearch(@androidx.annotation.NonNull T[] a, T key, @androidx.annotation.Nullable java.util.Comparator<? super T> c) { throw new RuntimeException("Stub!"); }

/**
 * Searches a range of
 * the specified array for the specified object using the binary
 * search algorithm.
 * The range must be sorted into ascending order
 * according to the specified comparator (as by the
 * {@link #sort(java.lang.Object[],int,int,java.util.Comparator)
 * sort(T[], int, int, Comparator)}
 * method) prior to making this call.
 * If it is not sorted, the results are undefined.
 * If the range contains multiple elements equal to the specified object,
 * there is no guarantee which one will be found.
 *
 * @param <T> the class of the objects in the array
 * @param a the array to be searched
 * @param fromIndex the index of the first element (inclusive) to be
 *          searched
 * @param toIndex the index of the last element (exclusive) to be searched
 * @param key the value to be searched for
 * @param c the comparator by which the array is ordered.  A
 *        <tt>null</tt> value indicates that the elements'
 *        {@linkplain java.lang.Comparable Comparable} should be used.
 * @return index of the search key, if it is contained in the array
 *         within the specified range;
 *         otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.  The
 *         <i>insertion point</i> is defined as the point at which the
 *         key would be inserted into the array: the index of the first
 *         element in the range greater than the key,
 *         or <tt>toIndex</tt> if all
 *         elements in the range are less than the specified key.  Note
 *         that this guarantees that the return value will be &gt;= 0 if
 *         and only if the key is found.
 * @throws java.lang.ClassCastException if the range contains elements that are not
 *         <i>mutually comparable</i> using the specified comparator,
 *         or the search key is not comparable to the
 *         elements in the range using this comparator.
 * @throws java.lang.IllegalArgumentException
 *         if {@code fromIndex > toIndex}
 * @throws java.lang.ArrayIndexOutOfBoundsException
 *         if {@code fromIndex < 0 or toIndex > a.length}
 * @since 1.6
 * @apiSince 9
 */

public static <T> int binarySearch(@androidx.annotation.NonNull T[] a, int fromIndex, int toIndex, T key, @androidx.annotation.Nullable java.util.Comparator<? super T> c) { throw new RuntimeException("Stub!"); }

/**
 * Returns <tt>true</tt> if the two specified arrays of longs are
 * <i>equal</i> to one another.  Two arrays are considered equal if both
 * arrays contain the same number of elements, and all corresponding pairs
 * of elements in the two arrays are equal.  In other words, two arrays
 * are equal if they contain the same elements in the same order.  Also,
 * two array references are considered equal if both are <tt>null</tt>.<p>
 *
 * @param a one array to be tested for equality
 * @param a2 the other array to be tested for equality
 * @return <tt>true</tt> if the two arrays are equal
 * @apiSince 1
 */

public static boolean equals(@androidx.annotation.Nullable long[] a, @androidx.annotation.Nullable long[] a2) { throw new RuntimeException("Stub!"); }

/**
 * Returns <tt>true</tt> if the two specified arrays of ints are
 * <i>equal</i> to one another.  Two arrays are considered equal if both
 * arrays contain the same number of elements, and all corresponding pairs
 * of elements in the two arrays are equal.  In other words, two arrays
 * are equal if they contain the same elements in the same order.  Also,
 * two array references are considered equal if both are <tt>null</tt>.<p>
 *
 * @param a one array to be tested for equality
 * @param a2 the other array to be tested for equality
 * @return <tt>true</tt> if the two arrays are equal
 * @apiSince 1
 */

public static boolean equals(@androidx.annotation.Nullable int[] a, @androidx.annotation.Nullable int[] a2) { throw new RuntimeException("Stub!"); }

/**
 * Returns <tt>true</tt> if the two specified arrays of shorts are
 * <i>equal</i> to one another.  Two arrays are considered equal if both
 * arrays contain the same number of elements, and all corresponding pairs
 * of elements in the two arrays are equal.  In other words, two arrays
 * are equal if they contain the same elements in the same order.  Also,
 * two array references are considered equal if both are <tt>null</tt>.<p>
 *
 * @param a one array to be tested for equality
 * @param a2 the other array to be tested for equality
 * @return <tt>true</tt> if the two arrays are equal
 * @apiSince 1
 */

public static boolean equals(@androidx.annotation.Nullable short[] a, @androidx.annotation.Nullable short[] a2) { throw new RuntimeException("Stub!"); }

/**
 * Returns <tt>true</tt> if the two specified arrays of chars are
 * <i>equal</i> to one another.  Two arrays are considered equal if both
 * arrays contain the same number of elements, and all corresponding pairs
 * of elements in the two arrays are equal.  In other words, two arrays
 * are equal if they contain the same elements in the same order.  Also,
 * two array references are considered equal if both are <tt>null</tt>.<p>
 *
 * @param a one array to be tested for equality
 * @param a2 the other array to be tested for equality
 * @return <tt>true</tt> if the two arrays are equal
 * @apiSince 1
 */

public static boolean equals(@androidx.annotation.Nullable char[] a, @androidx.annotation.Nullable char[] a2) { throw new RuntimeException("Stub!"); }

/**
 * Returns <tt>true</tt> if the two specified arrays of bytes are
 * <i>equal</i> to one another.  Two arrays are considered equal if both
 * arrays contain the same number of elements, and all corresponding pairs
 * of elements in the two arrays are equal.  In other words, two arrays
 * are equal if they contain the same elements in the same order.  Also,
 * two array references are considered equal if both are <tt>null</tt>.<p>
 *
 * @param a one array to be tested for equality
 * @param a2 the other array to be tested for equality
 * @return <tt>true</tt> if the two arrays are equal
 * @apiSince 1
 */

public static boolean equals(@androidx.annotation.Nullable byte[] a, @androidx.annotation.Nullable byte[] a2) { throw new RuntimeException("Stub!"); }

/**
 * Returns <tt>true</tt> if the two specified arrays of booleans are
 * <i>equal</i> to one another.  Two arrays are considered equal if both
 * arrays contain the same number of elements, and all corresponding pairs
 * of elements in the two arrays are equal.  In other words, two arrays
 * are equal if they contain the same elements in the same order.  Also,
 * two array references are considered equal if both are <tt>null</tt>.<p>
 *
 * @param a one array to be tested for equality
 * @param a2 the other array to be tested for equality
 * @return <tt>true</tt> if the two arrays are equal
 * @apiSince 1
 */

public static boolean equals(@androidx.annotation.Nullable boolean[] a, @androidx.annotation.Nullable boolean[] a2) { throw new RuntimeException("Stub!"); }

/**
 * Returns <tt>true</tt> if the two specified arrays of doubles are
 * <i>equal</i> to one another.  Two arrays are considered equal if both
 * arrays contain the same number of elements, and all corresponding pairs
 * of elements in the two arrays are equal.  In other words, two arrays
 * are equal if they contain the same elements in the same order.  Also,
 * two array references are considered equal if both are <tt>null</tt>.<p>
 *
 * Two doubles <tt>d1</tt> and <tt>d2</tt> are considered equal if:
 * <pre>    <tt>new Double(d1).equals(new Double(d2))</tt></pre>
 * (Unlike the <tt>==</tt> operator, this method considers
 * <tt>NaN</tt> equals to itself, and 0.0d unequal to -0.0d.)
 *
 * @param a one array to be tested for equality
 * @param a2 the other array to be tested for equality
 * @return <tt>true</tt> if the two arrays are equal
 * @see java.lang.Double#equals(Object)
 * @apiSince 1
 */

public static boolean equals(@androidx.annotation.Nullable double[] a, @androidx.annotation.Nullable double[] a2) { throw new RuntimeException("Stub!"); }

/**
 * Returns <tt>true</tt> if the two specified arrays of floats are
 * <i>equal</i> to one another.  Two arrays are considered equal if both
 * arrays contain the same number of elements, and all corresponding pairs
 * of elements in the two arrays are equal.  In other words, two arrays
 * are equal if they contain the same elements in the same order.  Also,
 * two array references are considered equal if both are <tt>null</tt>.<p>
 *
 * Two floats <tt>f1</tt> and <tt>f2</tt> are considered equal if:
 * <pre>    <tt>new Float(f1).equals(new Float(f2))</tt></pre>
 * (Unlike the <tt>==</tt> operator, this method considers
 * <tt>NaN</tt> equals to itself, and 0.0f unequal to -0.0f.)
 *
 * @param a one array to be tested for equality
 * @param a2 the other array to be tested for equality
 * @return <tt>true</tt> if the two arrays are equal
 * @see java.lang.Float#equals(Object)
 * @apiSince 1
 */

public static boolean equals(@androidx.annotation.Nullable float[] a, @androidx.annotation.Nullable float[] a2) { throw new RuntimeException("Stub!"); }

/**
 * Returns <tt>true</tt> if the two specified arrays of Objects are
 * <i>equal</i> to one another.  The two arrays are considered equal if
 * both arrays contain the same number of elements, and all corresponding
 * pairs of elements in the two arrays are equal.  Two objects <tt>e1</tt>
 * and <tt>e2</tt> are considered <i>equal</i> if <tt>(e1==null ? e2==null
 * : e1.equals(e2))</tt>.  In other words, the two arrays are equal if
 * they contain the same elements in the same order.  Also, two array
 * references are considered equal if both are <tt>null</tt>.<p>
 *
 * @param a one array to be tested for equality
 * @param a2 the other array to be tested for equality
 * @return <tt>true</tt> if the two arrays are equal
 * @apiSince 1
 */

public static boolean equals(@androidx.annotation.Nullable java.lang.Object[] a, @androidx.annotation.Nullable java.lang.Object[] a2) { throw new RuntimeException("Stub!"); }

/**
 * Assigns the specified long value to each element of the specified array
 * of longs.
 *
 * @param a the array to be filled
 * @param val the value to be stored in all elements of the array
 * @apiSince 1
 */

public static void fill(@androidx.annotation.NonNull long[] a, long val) { throw new RuntimeException("Stub!"); }

/**
 * Assigns the specified long value to each element of the specified
 * range of the specified array of longs.  The range to be filled
 * extends from index <tt>fromIndex</tt>, inclusive, to index
 * <tt>toIndex</tt>, exclusive.  (If <tt>fromIndex==toIndex</tt>, the
 * range to be filled is empty.)
 *
 * @param a the array to be filled
 * @param fromIndex the index of the first element (inclusive) to be
 *        filled with the specified value
 * @param toIndex the index of the last element (exclusive) to be
 *        filled with the specified value
 * @param val the value to be stored in all elements of the array
 * @throws java.lang.IllegalArgumentException if <tt>fromIndex &gt; toIndex</tt>
 * @throws java.lang.ArrayIndexOutOfBoundsException if <tt>fromIndex &lt; 0</tt> or
 *         <tt>toIndex &gt; a.length</tt>
 * @apiSince 1
 */

public static void fill(@androidx.annotation.NonNull long[] a, int fromIndex, int toIndex, long val) { throw new RuntimeException("Stub!"); }

/**
 * Assigns the specified int value to each element of the specified array
 * of ints.
 *
 * @param a the array to be filled
 * @param val the value to be stored in all elements of the array
 * @apiSince 1
 */

public static void fill(@androidx.annotation.NonNull int[] a, int val) { throw new RuntimeException("Stub!"); }

/**
 * Assigns the specified int value to each element of the specified
 * range of the specified array of ints.  The range to be filled
 * extends from index <tt>fromIndex</tt>, inclusive, to index
 * <tt>toIndex</tt>, exclusive.  (If <tt>fromIndex==toIndex</tt>, the
 * range to be filled is empty.)
 *
 * @param a the array to be filled
 * @param fromIndex the index of the first element (inclusive) to be
 *        filled with the specified value
 * @param toIndex the index of the last element (exclusive) to be
 *        filled with the specified value
 * @param val the value to be stored in all elements of the array
 * @throws java.lang.IllegalArgumentException if <tt>fromIndex &gt; toIndex</tt>
 * @throws java.lang.ArrayIndexOutOfBoundsException if <tt>fromIndex &lt; 0</tt> or
 *         <tt>toIndex &gt; a.length</tt>
 * @apiSince 1
 */

public static void fill(@androidx.annotation.NonNull int[] a, int fromIndex, int toIndex, int val) { throw new RuntimeException("Stub!"); }

/**
 * Assigns the specified short value to each element of the specified array
 * of shorts.
 *
 * @param a the array to be filled
 * @param val the value to be stored in all elements of the array
 * @apiSince 1
 */

public static void fill(@androidx.annotation.NonNull short[] a, short val) { throw new RuntimeException("Stub!"); }

/**
 * Assigns the specified short value to each element of the specified
 * range of the specified array of shorts.  The range to be filled
 * extends from index <tt>fromIndex</tt>, inclusive, to index
 * <tt>toIndex</tt>, exclusive.  (If <tt>fromIndex==toIndex</tt>, the
 * range to be filled is empty.)
 *
 * @param a the array to be filled
 * @param fromIndex the index of the first element (inclusive) to be
 *        filled with the specified value
 * @param toIndex the index of the last element (exclusive) to be
 *        filled with the specified value
 * @param val the value to be stored in all elements of the array
 * @throws java.lang.IllegalArgumentException if <tt>fromIndex &gt; toIndex</tt>
 * @throws java.lang.ArrayIndexOutOfBoundsException if <tt>fromIndex &lt; 0</tt> or
 *         <tt>toIndex &gt; a.length</tt>
 * @apiSince 1
 */

public static void fill(@androidx.annotation.NonNull short[] a, int fromIndex, int toIndex, short val) { throw new RuntimeException("Stub!"); }

/**
 * Assigns the specified char value to each element of the specified array
 * of chars.
 *
 * @param a the array to be filled
 * @param val the value to be stored in all elements of the array
 * @apiSince 1
 */

public static void fill(@androidx.annotation.NonNull char[] a, char val) { throw new RuntimeException("Stub!"); }

/**
 * Assigns the specified char value to each element of the specified
 * range of the specified array of chars.  The range to be filled
 * extends from index <tt>fromIndex</tt>, inclusive, to index
 * <tt>toIndex</tt>, exclusive.  (If <tt>fromIndex==toIndex</tt>, the
 * range to be filled is empty.)
 *
 * @param a the array to be filled
 * @param fromIndex the index of the first element (inclusive) to be
 *        filled with the specified value
 * @param toIndex the index of the last element (exclusive) to be
 *        filled with the specified value
 * @param val the value to be stored in all elements of the array
 * @throws java.lang.IllegalArgumentException if <tt>fromIndex &gt; toIndex</tt>
 * @throws java.lang.ArrayIndexOutOfBoundsException if <tt>fromIndex &lt; 0</tt> or
 *         <tt>toIndex &gt; a.length</tt>
 * @apiSince 1
 */

public static void fill(@androidx.annotation.NonNull char[] a, int fromIndex, int toIndex, char val) { throw new RuntimeException("Stub!"); }

/**
 * Assigns the specified byte value to each element of the specified array
 * of bytes.
 *
 * @param a the array to be filled
 * @param val the value to be stored in all elements of the array
 * @apiSince 1
 */

public static void fill(@androidx.annotation.NonNull byte[] a, byte val) { throw new RuntimeException("Stub!"); }

/**
 * Assigns the specified byte value to each element of the specified
 * range of the specified array of bytes.  The range to be filled
 * extends from index <tt>fromIndex</tt>, inclusive, to index
 * <tt>toIndex</tt>, exclusive.  (If <tt>fromIndex==toIndex</tt>, the
 * range to be filled is empty.)
 *
 * @param a the array to be filled
 * @param fromIndex the index of the first element (inclusive) to be
 *        filled with the specified value
 * @param toIndex the index of the last element (exclusive) to be
 *        filled with the specified value
 * @param val the value to be stored in all elements of the array
 * @throws java.lang.IllegalArgumentException if <tt>fromIndex &gt; toIndex</tt>
 * @throws java.lang.ArrayIndexOutOfBoundsException if <tt>fromIndex &lt; 0</tt> or
 *         <tt>toIndex &gt; a.length</tt>
 * @apiSince 1
 */

public static void fill(@androidx.annotation.NonNull byte[] a, int fromIndex, int toIndex, byte val) { throw new RuntimeException("Stub!"); }

/**
 * Assigns the specified boolean value to each element of the specified
 * array of booleans.
 *
 * @param a the array to be filled
 * @param val the value to be stored in all elements of the array
 * @apiSince 1
 */

public static void fill(@androidx.annotation.NonNull boolean[] a, boolean val) { throw new RuntimeException("Stub!"); }

/**
 * Assigns the specified boolean value to each element of the specified
 * range of the specified array of booleans.  The range to be filled
 * extends from index <tt>fromIndex</tt>, inclusive, to index
 * <tt>toIndex</tt>, exclusive.  (If <tt>fromIndex==toIndex</tt>, the
 * range to be filled is empty.)
 *
 * @param a the array to be filled
 * @param fromIndex the index of the first element (inclusive) to be
 *        filled with the specified value
 * @param toIndex the index of the last element (exclusive) to be
 *        filled with the specified value
 * @param val the value to be stored in all elements of the array
 * @throws java.lang.IllegalArgumentException if <tt>fromIndex &gt; toIndex</tt>
 * @throws java.lang.ArrayIndexOutOfBoundsException if <tt>fromIndex &lt; 0</tt> or
 *         <tt>toIndex &gt; a.length</tt>
 * @apiSince 1
 */

public static void fill(@androidx.annotation.NonNull boolean[] a, int fromIndex, int toIndex, boolean val) { throw new RuntimeException("Stub!"); }

/**
 * Assigns the specified double value to each element of the specified
 * array of doubles.
 *
 * @param a the array to be filled
 * @param val the value to be stored in all elements of the array
 * @apiSince 1
 */

public static void fill(@androidx.annotation.NonNull double[] a, double val) { throw new RuntimeException("Stub!"); }

/**
 * Assigns the specified double value to each element of the specified
 * range of the specified array of doubles.  The range to be filled
 * extends from index <tt>fromIndex</tt>, inclusive, to index
 * <tt>toIndex</tt>, exclusive.  (If <tt>fromIndex==toIndex</tt>, the
 * range to be filled is empty.)
 *
 * @param a the array to be filled
 * @param fromIndex the index of the first element (inclusive) to be
 *        filled with the specified value
 * @param toIndex the index of the last element (exclusive) to be
 *        filled with the specified value
 * @param val the value to be stored in all elements of the array
 * @throws java.lang.IllegalArgumentException if <tt>fromIndex &gt; toIndex</tt>
 * @throws java.lang.ArrayIndexOutOfBoundsException if <tt>fromIndex &lt; 0</tt> or
 *         <tt>toIndex &gt; a.length</tt>
 * @apiSince 1
 */

public static void fill(@androidx.annotation.NonNull double[] a, int fromIndex, int toIndex, double val) { throw new RuntimeException("Stub!"); }

/**
 * Assigns the specified float value to each element of the specified array
 * of floats.
 *
 * @param a the array to be filled
 * @param val the value to be stored in all elements of the array
 * @apiSince 1
 */

public static void fill(@androidx.annotation.NonNull float[] a, float val) { throw new RuntimeException("Stub!"); }

/**
 * Assigns the specified float value to each element of the specified
 * range of the specified array of floats.  The range to be filled
 * extends from index <tt>fromIndex</tt>, inclusive, to index
 * <tt>toIndex</tt>, exclusive.  (If <tt>fromIndex==toIndex</tt>, the
 * range to be filled is empty.)
 *
 * @param a the array to be filled
 * @param fromIndex the index of the first element (inclusive) to be
 *        filled with the specified value
 * @param toIndex the index of the last element (exclusive) to be
 *        filled with the specified value
 * @param val the value to be stored in all elements of the array
 * @throws java.lang.IllegalArgumentException if <tt>fromIndex &gt; toIndex</tt>
 * @throws java.lang.ArrayIndexOutOfBoundsException if <tt>fromIndex &lt; 0</tt> or
 *         <tt>toIndex &gt; a.length</tt>
 * @apiSince 1
 */

public static void fill(@androidx.annotation.NonNull float[] a, int fromIndex, int toIndex, float val) { throw new RuntimeException("Stub!"); }

/**
 * Assigns the specified Object reference to each element of the specified
 * array of Objects.
 *
 * @param a the array to be filled
 * @param val the value to be stored in all elements of the array
 * @throws java.lang.ArrayStoreException if the specified value is not of a
 *         runtime type that can be stored in the specified array
 * @apiSince 1
 */

public static void fill(@androidx.annotation.NonNull java.lang.Object[] a, @androidx.annotation.Nullable java.lang.Object val) { throw new RuntimeException("Stub!"); }

/**
 * Assigns the specified Object reference to each element of the specified
 * range of the specified array of Objects.  The range to be filled
 * extends from index <tt>fromIndex</tt>, inclusive, to index
 * <tt>toIndex</tt>, exclusive.  (If <tt>fromIndex==toIndex</tt>, the
 * range to be filled is empty.)
 *
 * @param a the array to be filled
 * @param fromIndex the index of the first element (inclusive) to be
 *        filled with the specified value
 * @param toIndex the index of the last element (exclusive) to be
 *        filled with the specified value
 * @param val the value to be stored in all elements of the array
 * @throws java.lang.IllegalArgumentException if <tt>fromIndex &gt; toIndex</tt>
 * @throws java.lang.ArrayIndexOutOfBoundsException if <tt>fromIndex &lt; 0</tt> or
 *         <tt>toIndex &gt; a.length</tt>
 * @throws java.lang.ArrayStoreException if the specified value is not of a
 *         runtime type that can be stored in the specified array
 * @apiSince 1
 */

public static void fill(@androidx.annotation.NonNull java.lang.Object[] a, int fromIndex, int toIndex, @androidx.annotation.Nullable java.lang.Object val) { throw new RuntimeException("Stub!"); }

/**
 * Copies the specified array, truncating or padding with nulls (if necessary)
 * so the copy has the specified length.  For all indices that are
 * valid in both the original array and the copy, the two arrays will
 * contain identical values.  For any indices that are valid in the
 * copy but not the original, the copy will contain <tt>null</tt>.
 * Such indices will exist if and only if the specified length
 * is greater than that of the original array.
 * The resulting array is of exactly the same class as the original array.
 *
 * @param <T> the class of the objects in the array
 * @param original the array to be copied
 * @param newLength the length of the copy to be returned
 * @return a copy of the original array, truncated or padded with nulls
 *     to obtain the specified length
 * @throws java.lang.NegativeArraySizeException if <tt>newLength</tt> is negative
 * @throws java.lang.NullPointerException if <tt>original</tt> is null
 * @since 1.6
 * @apiSince 9
 */

@androidx.annotation.NonNull
public static <T> T[] copyOf(@androidx.annotation.NonNull T[] original, int newLength) { throw new RuntimeException("Stub!"); }

/**
 * Copies the specified array, truncating or padding with nulls (if necessary)
 * so the copy has the specified length.  For all indices that are
 * valid in both the original array and the copy, the two arrays will
 * contain identical values.  For any indices that are valid in the
 * copy but not the original, the copy will contain <tt>null</tt>.
 * Such indices will exist if and only if the specified length
 * is greater than that of the original array.
 * The resulting array is of the class <tt>newType</tt>.
 *
 * @param <U> the class of the objects in the original array
 * @param <T> the class of the objects in the returned array
 * @param original the array to be copied
 * @param newLength the length of the copy to be returned
 * @param newType the class of the copy to be returned
 * @return a copy of the original array, truncated or padded with nulls
 *     to obtain the specified length
 * @throws java.lang.NegativeArraySizeException if <tt>newLength</tt> is negative
 * @throws java.lang.NullPointerException if <tt>original</tt> is null
 * @throws java.lang.ArrayStoreException if an element copied from
 *     <tt>original</tt> is not of a runtime type that can be stored in
 *     an array of class <tt>newType</tt>
 * @since 1.6
 * @apiSince 9
 */

@androidx.annotation.NonNull
public static <T, U> T[] copyOf(@androidx.annotation.NonNull U[] original, int newLength, @androidx.annotation.NonNull java.lang.Class<? extends T[]> newType) { throw new RuntimeException("Stub!"); }

/**
 * Copies the specified array, truncating or padding with zeros (if necessary)
 * so the copy has the specified length.  For all indices that are
 * valid in both the original array and the copy, the two arrays will
 * contain identical values.  For any indices that are valid in the
 * copy but not the original, the copy will contain <tt>(byte)0</tt>.
 * Such indices will exist if and only if the specified length
 * is greater than that of the original array.
 *
 * @param original the array to be copied
 * @param newLength the length of the copy to be returned
 * @return a copy of the original array, truncated or padded with zeros
 *     to obtain the specified length
 * @throws java.lang.NegativeArraySizeException if <tt>newLength</tt> is negative
 * @throws java.lang.NullPointerException if <tt>original</tt> is null
 * @since 1.6
 * @apiSince 9
 */

@androidx.annotation.NonNull
public static byte[] copyOf(@androidx.annotation.NonNull byte[] original, int newLength) { throw new RuntimeException("Stub!"); }

/**
 * Copies the specified array, truncating or padding with zeros (if necessary)
 * so the copy has the specified length.  For all indices that are
 * valid in both the original array and the copy, the two arrays will
 * contain identical values.  For any indices that are valid in the
 * copy but not the original, the copy will contain <tt>(short)0</tt>.
 * Such indices will exist if and only if the specified length
 * is greater than that of the original array.
 *
 * @param original the array to be copied
 * @param newLength the length of the copy to be returned
 * @return a copy of the original array, truncated or padded with zeros
 *     to obtain the specified length
 * @throws java.lang.NegativeArraySizeException if <tt>newLength</tt> is negative
 * @throws java.lang.NullPointerException if <tt>original</tt> is null
 * @since 1.6
 * @apiSince 9
 */

@androidx.annotation.NonNull
public static short[] copyOf(@androidx.annotation.NonNull short[] original, int newLength) { throw new RuntimeException("Stub!"); }

/**
 * Copies the specified array, truncating or padding with zeros (if necessary)
 * so the copy has the specified length.  For all indices that are
 * valid in both the original array and the copy, the two arrays will
 * contain identical values.  For any indices that are valid in the
 * copy but not the original, the copy will contain <tt>0</tt>.
 * Such indices will exist if and only if the specified length
 * is greater than that of the original array.
 *
 * @param original the array to be copied
 * @param newLength the length of the copy to be returned
 * @return a copy of the original array, truncated or padded with zeros
 *     to obtain the specified length
 * @throws java.lang.NegativeArraySizeException if <tt>newLength</tt> is negative
 * @throws java.lang.NullPointerException if <tt>original</tt> is null
 * @since 1.6
 * @apiSince 9
 */

@androidx.annotation.NonNull
public static int[] copyOf(@androidx.annotation.NonNull int[] original, int newLength) { throw new RuntimeException("Stub!"); }

/**
 * Copies the specified array, truncating or padding with zeros (if necessary)
 * so the copy has the specified length.  For all indices that are
 * valid in both the original array and the copy, the two arrays will
 * contain identical values.  For any indices that are valid in the
 * copy but not the original, the copy will contain <tt>0L</tt>.
 * Such indices will exist if and only if the specified length
 * is greater than that of the original array.
 *
 * @param original the array to be copied
 * @param newLength the length of the copy to be returned
 * @return a copy of the original array, truncated or padded with zeros
 *     to obtain the specified length
 * @throws java.lang.NegativeArraySizeException if <tt>newLength</tt> is negative
 * @throws java.lang.NullPointerException if <tt>original</tt> is null
 * @since 1.6
 * @apiSince 9
 */

@androidx.annotation.NonNull
public static long[] copyOf(@androidx.annotation.NonNull long[] original, int newLength) { throw new RuntimeException("Stub!"); }

/**
 * Copies the specified array, truncating or padding with null characters (if necessary)
 * so the copy has the specified length.  For all indices that are valid
 * in both the original array and the copy, the two arrays will contain
 * identical values.  For any indices that are valid in the copy but not
 * the original, the copy will contain <tt>'\\u000'</tt>.  Such indices
 * will exist if and only if the specified length is greater than that of
 * the original array.
 *
 * @param original the array to be copied
 * @param newLength the length of the copy to be returned
 * @return a copy of the original array, truncated or padded with null characters
 *     to obtain the specified length
 * @throws java.lang.NegativeArraySizeException if <tt>newLength</tt> is negative
 * @throws java.lang.NullPointerException if <tt>original</tt> is null
 * @since 1.6
 * @apiSince 9
 */

@androidx.annotation.NonNull
public static char[] copyOf(@androidx.annotation.NonNull char[] original, int newLength) { throw new RuntimeException("Stub!"); }

/**
 * Copies the specified array, truncating or padding with zeros (if necessary)
 * so the copy has the specified length.  For all indices that are
 * valid in both the original array and the copy, the two arrays will
 * contain identical values.  For any indices that are valid in the
 * copy but not the original, the copy will contain <tt>0f</tt>.
 * Such indices will exist if and only if the specified length
 * is greater than that of the original array.
 *
 * @param original the array to be copied
 * @param newLength the length of the copy to be returned
 * @return a copy of the original array, truncated or padded with zeros
 *     to obtain the specified length
 * @throws java.lang.NegativeArraySizeException if <tt>newLength</tt> is negative
 * @throws java.lang.NullPointerException if <tt>original</tt> is null
 * @since 1.6
 * @apiSince 9
 */

@androidx.annotation.NonNull
public static float[] copyOf(@androidx.annotation.NonNull float[] original, int newLength) { throw new RuntimeException("Stub!"); }

/**
 * Copies the specified array, truncating or padding with zeros (if necessary)
 * so the copy has the specified length.  For all indices that are
 * valid in both the original array and the copy, the two arrays will
 * contain identical values.  For any indices that are valid in the
 * copy but not the original, the copy will contain <tt>0d</tt>.
 * Such indices will exist if and only if the specified length
 * is greater than that of the original array.
 *
 * @param original the array to be copied
 * @param newLength the length of the copy to be returned
 * @return a copy of the original array, truncated or padded with zeros
 *     to obtain the specified length
 * @throws java.lang.NegativeArraySizeException if <tt>newLength</tt> is negative
 * @throws java.lang.NullPointerException if <tt>original</tt> is null
 * @since 1.6
 * @apiSince 9
 */

@androidx.annotation.NonNull
public static double[] copyOf(@androidx.annotation.NonNull double[] original, int newLength) { throw new RuntimeException("Stub!"); }

/**
 * Copies the specified array, truncating or padding with <tt>false</tt> (if necessary)
 * so the copy has the specified length.  For all indices that are
 * valid in both the original array and the copy, the two arrays will
 * contain identical values.  For any indices that are valid in the
 * copy but not the original, the copy will contain <tt>false</tt>.
 * Such indices will exist if and only if the specified length
 * is greater than that of the original array.
 *
 * @param original the array to be copied
 * @param newLength the length of the copy to be returned
 * @return a copy of the original array, truncated or padded with false elements
 *     to obtain the specified length
 * @throws java.lang.NegativeArraySizeException if <tt>newLength</tt> is negative
 * @throws java.lang.NullPointerException if <tt>original</tt> is null
 * @since 1.6
 * @apiSince 9
 */

@androidx.annotation.NonNull
public static boolean[] copyOf(@androidx.annotation.NonNull boolean[] original, int newLength) { throw new RuntimeException("Stub!"); }

/**
 * Copies the specified range of the specified array into a new array.
 * The initial index of the range (<tt>from</tt>) must lie between zero
 * and <tt>original.length</tt>, inclusive.  The value at
 * <tt>original[from]</tt> is placed into the initial element of the copy
 * (unless <tt>from == original.length</tt> or <tt>from == to</tt>).
 * Values from subsequent elements in the original array are placed into
 * subsequent elements in the copy.  The final index of the range
 * (<tt>to</tt>), which must be greater than or equal to <tt>from</tt>,
 * may be greater than <tt>original.length</tt>, in which case
 * <tt>null</tt> is placed in all elements of the copy whose index is
 * greater than or equal to <tt>original.length - from</tt>.  The length
 * of the returned array will be <tt>to - from</tt>.
 * <p>
 * The resulting array is of exactly the same class as the original array.
 *
 * @param <T> the class of the objects in the array
 * @param original the array from which a range is to be copied
 * @param from the initial index of the range to be copied, inclusive
 * @param to the final index of the range to be copied, exclusive.
 *     (This index may lie outside the array.)
 * @return a new array containing the specified range from the original array,
 *     truncated or padded with nulls to obtain the required length
 * @throws java.lang.ArrayIndexOutOfBoundsException if {@code from < 0}
 *     or {@code from > original.length}
 * @throws java.lang.IllegalArgumentException if <tt>from &gt; to</tt>
 * @throws java.lang.NullPointerException if <tt>original</tt> is null
 * @since 1.6
 * @apiSince 9
 */

@androidx.annotation.NonNull
public static <T> T[] copyOfRange(@androidx.annotation.NonNull T[] original, int from, int to) { throw new RuntimeException("Stub!"); }

/**
 * Copies the specified range of the specified array into a new array.
 * The initial index of the range (<tt>from</tt>) must lie between zero
 * and <tt>original.length</tt>, inclusive.  The value at
 * <tt>original[from]</tt> is placed into the initial element of the copy
 * (unless <tt>from == original.length</tt> or <tt>from == to</tt>).
 * Values from subsequent elements in the original array are placed into
 * subsequent elements in the copy.  The final index of the range
 * (<tt>to</tt>), which must be greater than or equal to <tt>from</tt>,
 * may be greater than <tt>original.length</tt>, in which case
 * <tt>null</tt> is placed in all elements of the copy whose index is
 * greater than or equal to <tt>original.length - from</tt>.  The length
 * of the returned array will be <tt>to - from</tt>.
 * The resulting array is of the class <tt>newType</tt>.
 *
 * @param <U> the class of the objects in the original array
 * @param <T> the class of the objects in the returned array
 * @param original the array from which a range is to be copied
 * @param from the initial index of the range to be copied, inclusive
 * @param to the final index of the range to be copied, exclusive.
 *     (This index may lie outside the array.)
 * @param newType the class of the copy to be returned
 * @return a new array containing the specified range from the original array,
 *     truncated or padded with nulls to obtain the required length
 * @throws java.lang.ArrayIndexOutOfBoundsException if {@code from < 0}
 *     or {@code from > original.length}
 * @throws java.lang.IllegalArgumentException if <tt>from &gt; to</tt>
 * @throws java.lang.NullPointerException if <tt>original</tt> is null
 * @throws java.lang.ArrayStoreException if an element copied from
 *     <tt>original</tt> is not of a runtime type that can be stored in
 *     an array of class <tt>newType</tt>.
 * @since 1.6
 * @apiSince 9
 */

@androidx.annotation.NonNull
public static <T, U> T[] copyOfRange(@androidx.annotation.NonNull U[] original, int from, int to, @androidx.annotation.NonNull java.lang.Class<? extends T[]> newType) { throw new RuntimeException("Stub!"); }

/**
 * Copies the specified range of the specified array into a new array.
 * The initial index of the range (<tt>from</tt>) must lie between zero
 * and <tt>original.length</tt>, inclusive.  The value at
 * <tt>original[from]</tt> is placed into the initial element of the copy
 * (unless <tt>from == original.length</tt> or <tt>from == to</tt>).
 * Values from subsequent elements in the original array are placed into
 * subsequent elements in the copy.  The final index of the range
 * (<tt>to</tt>), which must be greater than or equal to <tt>from</tt>,
 * may be greater than <tt>original.length</tt>, in which case
 * <tt>(byte)0</tt> is placed in all elements of the copy whose index is
 * greater than or equal to <tt>original.length - from</tt>.  The length
 * of the returned array will be <tt>to - from</tt>.
 *
 * @param original the array from which a range is to be copied
 * @param from the initial index of the range to be copied, inclusive
 * @param to the final index of the range to be copied, exclusive.
 *     (This index may lie outside the array.)
 * @return a new array containing the specified range from the original array,
 *     truncated or padded with zeros to obtain the required length
 * @throws java.lang.ArrayIndexOutOfBoundsException if {@code from < 0}
 *     or {@code from > original.length}
 * @throws java.lang.IllegalArgumentException if <tt>from &gt; to</tt>
 * @throws java.lang.NullPointerException if <tt>original</tt> is null
 * @since 1.6
 * @apiSince 9
 */

@androidx.annotation.NonNull
public static byte[] copyOfRange(@androidx.annotation.NonNull byte[] original, int from, int to) { throw new RuntimeException("Stub!"); }

/**
 * Copies the specified range of the specified array into a new array.
 * The initial index of the range (<tt>from</tt>) must lie between zero
 * and <tt>original.length</tt>, inclusive.  The value at
 * <tt>original[from]</tt> is placed into the initial element of the copy
 * (unless <tt>from == original.length</tt> or <tt>from == to</tt>).
 * Values from subsequent elements in the original array are placed into
 * subsequent elements in the copy.  The final index of the range
 * (<tt>to</tt>), which must be greater than or equal to <tt>from</tt>,
 * may be greater than <tt>original.length</tt>, in which case
 * <tt>(short)0</tt> is placed in all elements of the copy whose index is
 * greater than or equal to <tt>original.length - from</tt>.  The length
 * of the returned array will be <tt>to - from</tt>.
 *
 * @param original the array from which a range is to be copied
 * @param from the initial index of the range to be copied, inclusive
 * @param to the final index of the range to be copied, exclusive.
 *     (This index may lie outside the array.)
 * @return a new array containing the specified range from the original array,
 *     truncated or padded with zeros to obtain the required length
 * @throws java.lang.ArrayIndexOutOfBoundsException if {@code from < 0}
 *     or {@code from > original.length}
 * @throws java.lang.IllegalArgumentException if <tt>from &gt; to</tt>
 * @throws java.lang.NullPointerException if <tt>original</tt> is null
 * @since 1.6
 * @apiSince 9
 */

@androidx.annotation.NonNull
public static short[] copyOfRange(@androidx.annotation.NonNull short[] original, int from, int to) { throw new RuntimeException("Stub!"); }

/**
 * Copies the specified range of the specified array into a new array.
 * The initial index of the range (<tt>from</tt>) must lie between zero
 * and <tt>original.length</tt>, inclusive.  The value at
 * <tt>original[from]</tt> is placed into the initial element of the copy
 * (unless <tt>from == original.length</tt> or <tt>from == to</tt>).
 * Values from subsequent elements in the original array are placed into
 * subsequent elements in the copy.  The final index of the range
 * (<tt>to</tt>), which must be greater than or equal to <tt>from</tt>,
 * may be greater than <tt>original.length</tt>, in which case
 * <tt>0</tt> is placed in all elements of the copy whose index is
 * greater than or equal to <tt>original.length - from</tt>.  The length
 * of the returned array will be <tt>to - from</tt>.
 *
 * @param original the array from which a range is to be copied
 * @param from the initial index of the range to be copied, inclusive
 * @param to the final index of the range to be copied, exclusive.
 *     (This index may lie outside the array.)
 * @return a new array containing the specified range from the original array,
 *     truncated or padded with zeros to obtain the required length
 * @throws java.lang.ArrayIndexOutOfBoundsException if {@code from < 0}
 *     or {@code from > original.length}
 * @throws java.lang.IllegalArgumentException if <tt>from &gt; to</tt>
 * @throws java.lang.NullPointerException if <tt>original</tt> is null
 * @since 1.6
 * @apiSince 9
 */

@androidx.annotation.NonNull
public static int[] copyOfRange(@androidx.annotation.NonNull int[] original, int from, int to) { throw new RuntimeException("Stub!"); }

/**
 * Copies the specified range of the specified array into a new array.
 * The initial index of the range (<tt>from</tt>) must lie between zero
 * and <tt>original.length</tt>, inclusive.  The value at
 * <tt>original[from]</tt> is placed into the initial element of the copy
 * (unless <tt>from == original.length</tt> or <tt>from == to</tt>).
 * Values from subsequent elements in the original array are placed into
 * subsequent elements in the copy.  The final index of the range
 * (<tt>to</tt>), which must be greater than or equal to <tt>from</tt>,
 * may be greater than <tt>original.length</tt>, in which case
 * <tt>0L</tt> is placed in all elements of the copy whose index is
 * greater than or equal to <tt>original.length - from</tt>.  The length
 * of the returned array will be <tt>to - from</tt>.
 *
 * @param original the array from which a range is to be copied
 * @param from the initial index of the range to be copied, inclusive
 * @param to the final index of the range to be copied, exclusive.
 *     (This index may lie outside the array.)
 * @return a new array containing the specified range from the original array,
 *     truncated or padded with zeros to obtain the required length
 * @throws java.lang.ArrayIndexOutOfBoundsException if {@code from < 0}
 *     or {@code from > original.length}
 * @throws java.lang.IllegalArgumentException if <tt>from &gt; to</tt>
 * @throws java.lang.NullPointerException if <tt>original</tt> is null
 * @since 1.6
 * @apiSince 9
 */

@androidx.annotation.NonNull
public static long[] copyOfRange(@androidx.annotation.NonNull long[] original, int from, int to) { throw new RuntimeException("Stub!"); }

/**
 * Copies the specified range of the specified array into a new array.
 * The initial index of the range (<tt>from</tt>) must lie between zero
 * and <tt>original.length</tt>, inclusive.  The value at
 * <tt>original[from]</tt> is placed into the initial element of the copy
 * (unless <tt>from == original.length</tt> or <tt>from == to</tt>).
 * Values from subsequent elements in the original array are placed into
 * subsequent elements in the copy.  The final index of the range
 * (<tt>to</tt>), which must be greater than or equal to <tt>from</tt>,
 * may be greater than <tt>original.length</tt>, in which case
 * <tt>'\\u000'</tt> is placed in all elements of the copy whose index is
 * greater than or equal to <tt>original.length - from</tt>.  The length
 * of the returned array will be <tt>to - from</tt>.
 *
 * @param original the array from which a range is to be copied
 * @param from the initial index of the range to be copied, inclusive
 * @param to the final index of the range to be copied, exclusive.
 *     (This index may lie outside the array.)
 * @return a new array containing the specified range from the original array,
 *     truncated or padded with null characters to obtain the required length
 * @throws java.lang.ArrayIndexOutOfBoundsException if {@code from < 0}
 *     or {@code from > original.length}
 * @throws java.lang.IllegalArgumentException if <tt>from &gt; to</tt>
 * @throws java.lang.NullPointerException if <tt>original</tt> is null
 * @since 1.6
 * @apiSince 9
 */

@androidx.annotation.NonNull
public static char[] copyOfRange(@androidx.annotation.NonNull char[] original, int from, int to) { throw new RuntimeException("Stub!"); }

/**
 * Copies the specified range of the specified array into a new array.
 * The initial index of the range (<tt>from</tt>) must lie between zero
 * and <tt>original.length</tt>, inclusive.  The value at
 * <tt>original[from]</tt> is placed into the initial element of the copy
 * (unless <tt>from == original.length</tt> or <tt>from == to</tt>).
 * Values from subsequent elements in the original array are placed into
 * subsequent elements in the copy.  The final index of the range
 * (<tt>to</tt>), which must be greater than or equal to <tt>from</tt>,
 * may be greater than <tt>original.length</tt>, in which case
 * <tt>0f</tt> is placed in all elements of the copy whose index is
 * greater than or equal to <tt>original.length - from</tt>.  The length
 * of the returned array will be <tt>to - from</tt>.
 *
 * @param original the array from which a range is to be copied
 * @param from the initial index of the range to be copied, inclusive
 * @param to the final index of the range to be copied, exclusive.
 *     (This index may lie outside the array.)
 * @return a new array containing the specified range from the original array,
 *     truncated or padded with zeros to obtain the required length
 * @throws java.lang.ArrayIndexOutOfBoundsException if {@code from < 0}
 *     or {@code from > original.length}
 * @throws java.lang.IllegalArgumentException if <tt>from &gt; to</tt>
 * @throws java.lang.NullPointerException if <tt>original</tt> is null
 * @since 1.6
 * @apiSince 9
 */

@androidx.annotation.NonNull
public static float[] copyOfRange(@androidx.annotation.NonNull float[] original, int from, int to) { throw new RuntimeException("Stub!"); }

/**
 * Copies the specified range of the specified array into a new array.
 * The initial index of the range (<tt>from</tt>) must lie between zero
 * and <tt>original.length</tt>, inclusive.  The value at
 * <tt>original[from]</tt> is placed into the initial element of the copy
 * (unless <tt>from == original.length</tt> or <tt>from == to</tt>).
 * Values from subsequent elements in the original array are placed into
 * subsequent elements in the copy.  The final index of the range
 * (<tt>to</tt>), which must be greater than or equal to <tt>from</tt>,
 * may be greater than <tt>original.length</tt>, in which case
 * <tt>0d</tt> is placed in all elements of the copy whose index is
 * greater than or equal to <tt>original.length - from</tt>.  The length
 * of the returned array will be <tt>to - from</tt>.
 *
 * @param original the array from which a range is to be copied
 * @param from the initial index of the range to be copied, inclusive
 * @param to the final index of the range to be copied, exclusive.
 *     (This index may lie outside the array.)
 * @return a new array containing the specified range from the original array,
 *     truncated or padded with zeros to obtain the required length
 * @throws java.lang.ArrayIndexOutOfBoundsException if {@code from < 0}
 *     or {@code from > original.length}
 * @throws java.lang.IllegalArgumentException if <tt>from &gt; to</tt>
 * @throws java.lang.NullPointerException if <tt>original</tt> is null
 * @since 1.6
 * @apiSince 9
 */

@androidx.annotation.NonNull
public static double[] copyOfRange(@androidx.annotation.NonNull double[] original, int from, int to) { throw new RuntimeException("Stub!"); }

/**
 * Copies the specified range of the specified array into a new array.
 * The initial index of the range (<tt>from</tt>) must lie between zero
 * and <tt>original.length</tt>, inclusive.  The value at
 * <tt>original[from]</tt> is placed into the initial element of the copy
 * (unless <tt>from == original.length</tt> or <tt>from == to</tt>).
 * Values from subsequent elements in the original array are placed into
 * subsequent elements in the copy.  The final index of the range
 * (<tt>to</tt>), which must be greater than or equal to <tt>from</tt>,
 * may be greater than <tt>original.length</tt>, in which case
 * <tt>false</tt> is placed in all elements of the copy whose index is
 * greater than or equal to <tt>original.length - from</tt>.  The length
 * of the returned array will be <tt>to - from</tt>.
 *
 * @param original the array from which a range is to be copied
 * @param from the initial index of the range to be copied, inclusive
 * @param to the final index of the range to be copied, exclusive.
 *     (This index may lie outside the array.)
 * @return a new array containing the specified range from the original array,
 *     truncated or padded with false elements to obtain the required length
 * @throws java.lang.ArrayIndexOutOfBoundsException if {@code from < 0}
 *     or {@code from > original.length}
 * @throws java.lang.IllegalArgumentException if <tt>from &gt; to</tt>
 * @throws java.lang.NullPointerException if <tt>original</tt> is null
 * @since 1.6
 * @apiSince 9
 */

@androidx.annotation.NonNull
public static boolean[] copyOfRange(@androidx.annotation.NonNull boolean[] original, int from, int to) { throw new RuntimeException("Stub!"); }

/**
 * Returns a fixed-size list backed by the specified array.  (Changes to
 * the returned list "write through" to the array.)  This method acts
 * as bridge between array-based and collection-based APIs, in
 * combination with {@link java.util.Collection#toArray Collection#toArray}.  The returned list is
 * serializable and implements {@link java.util.RandomAccess RandomAccess}.
 *
 * <p>This method also provides a convenient way to create a fixed-size
 * list initialized to contain several elements:
 * <pre>
 *     List&lt;String&gt; stooges = Arrays.asList("Larry", "Moe", "Curly");
 * </pre>
 *
 * @param <T> the class of the objects in the array
 * @param a the array by which the list will be backed
 * @return a list view of the specified array
 * @apiSince 1
 */

@androidx.annotation.NonNull
@java.lang.SafeVarargs
public static <T> java.util.List<T> asList(@androidx.annotation.NonNull T... a) { throw new RuntimeException("Stub!"); }

/**
 * Returns a hash code based on the contents of the specified array.
 * For any two <tt>long</tt> arrays <tt>a</tt> and <tt>b</tt>
 * such that <tt>Arrays.equals(a, b)</tt>, it is also the case that
 * <tt>Arrays.hashCode(a) == Arrays.hashCode(b)</tt>.
 *
 * <p>The value returned by this method is the same value that would be
 * obtained by invoking the {@link java.util.List#hashCode() List#hashCode()}
 * method on a {@link java.util.List List} containing a sequence of {@link java.lang.Long Long}
 * instances representing the elements of <tt>a</tt> in the same order.
 * If <tt>a</tt> is <tt>null</tt>, this method returns 0.
 *
 * @param a the array whose hash value to compute
 * @return a content-based hash code for <tt>a</tt>
 * @since 1.5
 * @apiSince 1
 */

public static int hashCode(@androidx.annotation.Nullable long[] a) { throw new RuntimeException("Stub!"); }

/**
 * Returns a hash code based on the contents of the specified array.
 * For any two non-null <tt>int</tt> arrays <tt>a</tt> and <tt>b</tt>
 * such that <tt>Arrays.equals(a, b)</tt>, it is also the case that
 * <tt>Arrays.hashCode(a) == Arrays.hashCode(b)</tt>.
 *
 * <p>The value returned by this method is the same value that would be
 * obtained by invoking the {@link java.util.List#hashCode() List#hashCode()}
 * method on a {@link java.util.List List} containing a sequence of {@link java.lang.Integer Integer}
 * instances representing the elements of <tt>a</tt> in the same order.
 * If <tt>a</tt> is <tt>null</tt>, this method returns 0.
 *
 * @param a the array whose hash value to compute
 * @return a content-based hash code for <tt>a</tt>
 * @since 1.5
 * @apiSince 1
 */

public static int hashCode(@androidx.annotation.Nullable int[] a) { throw new RuntimeException("Stub!"); }

/**
 * Returns a hash code based on the contents of the specified array.
 * For any two <tt>short</tt> arrays <tt>a</tt> and <tt>b</tt>
 * such that <tt>Arrays.equals(a, b)</tt>, it is also the case that
 * <tt>Arrays.hashCode(a) == Arrays.hashCode(b)</tt>.
 *
 * <p>The value returned by this method is the same value that would be
 * obtained by invoking the {@link java.util.List#hashCode() List#hashCode()}
 * method on a {@link java.util.List List} containing a sequence of {@link java.lang.Short Short}
 * instances representing the elements of <tt>a</tt> in the same order.
 * If <tt>a</tt> is <tt>null</tt>, this method returns 0.
 *
 * @param a the array whose hash value to compute
 * @return a content-based hash code for <tt>a</tt>
 * @since 1.5
 * @apiSince 1
 */

public static int hashCode(@androidx.annotation.Nullable short[] a) { throw new RuntimeException("Stub!"); }

/**
 * Returns a hash code based on the contents of the specified array.
 * For any two <tt>char</tt> arrays <tt>a</tt> and <tt>b</tt>
 * such that <tt>Arrays.equals(a, b)</tt>, it is also the case that
 * <tt>Arrays.hashCode(a) == Arrays.hashCode(b)</tt>.
 *
 * <p>The value returned by this method is the same value that would be
 * obtained by invoking the {@link java.util.List#hashCode() List#hashCode()}
 * method on a {@link java.util.List List} containing a sequence of {@link java.lang.Character Character}
 * instances representing the elements of <tt>a</tt> in the same order.
 * If <tt>a</tt> is <tt>null</tt>, this method returns 0.
 *
 * @param a the array whose hash value to compute
 * @return a content-based hash code for <tt>a</tt>
 * @since 1.5
 * @apiSince 1
 */

public static int hashCode(@androidx.annotation.Nullable char[] a) { throw new RuntimeException("Stub!"); }

/**
 * Returns a hash code based on the contents of the specified array.
 * For any two <tt>byte</tt> arrays <tt>a</tt> and <tt>b</tt>
 * such that <tt>Arrays.equals(a, b)</tt>, it is also the case that
 * <tt>Arrays.hashCode(a) == Arrays.hashCode(b)</tt>.
 *
 * <p>The value returned by this method is the same value that would be
 * obtained by invoking the {@link java.util.List#hashCode() List#hashCode()}
 * method on a {@link java.util.List List} containing a sequence of {@link java.lang.Byte Byte}
 * instances representing the elements of <tt>a</tt> in the same order.
 * If <tt>a</tt> is <tt>null</tt>, this method returns 0.
 *
 * @param a the array whose hash value to compute
 * @return a content-based hash code for <tt>a</tt>
 * @since 1.5
 * @apiSince 1
 */

public static int hashCode(@androidx.annotation.Nullable byte[] a) { throw new RuntimeException("Stub!"); }

/**
 * Returns a hash code based on the contents of the specified array.
 * For any two <tt>boolean</tt> arrays <tt>a</tt> and <tt>b</tt>
 * such that <tt>Arrays.equals(a, b)</tt>, it is also the case that
 * <tt>Arrays.hashCode(a) == Arrays.hashCode(b)</tt>.
 *
 * <p>The value returned by this method is the same value that would be
 * obtained by invoking the {@link java.util.List#hashCode() List#hashCode()}
 * method on a {@link java.util.List List} containing a sequence of {@link java.lang.Boolean Boolean}
 * instances representing the elements of <tt>a</tt> in the same order.
 * If <tt>a</tt> is <tt>null</tt>, this method returns 0.
 *
 * @param a the array whose hash value to compute
 * @return a content-based hash code for <tt>a</tt>
 * @since 1.5
 * @apiSince 1
 */

public static int hashCode(@androidx.annotation.Nullable boolean[] a) { throw new RuntimeException("Stub!"); }

/**
 * Returns a hash code based on the contents of the specified array.
 * For any two <tt>float</tt> arrays <tt>a</tt> and <tt>b</tt>
 * such that <tt>Arrays.equals(a, b)</tt>, it is also the case that
 * <tt>Arrays.hashCode(a) == Arrays.hashCode(b)</tt>.
 *
 * <p>The value returned by this method is the same value that would be
 * obtained by invoking the {@link java.util.List#hashCode() List#hashCode()}
 * method on a {@link java.util.List List} containing a sequence of {@link java.lang.Float Float}
 * instances representing the elements of <tt>a</tt> in the same order.
 * If <tt>a</tt> is <tt>null</tt>, this method returns 0.
 *
 * @param a the array whose hash value to compute
 * @return a content-based hash code for <tt>a</tt>
 * @since 1.5
 * @apiSince 1
 */

public static int hashCode(@androidx.annotation.Nullable float[] a) { throw new RuntimeException("Stub!"); }

/**
 * Returns a hash code based on the contents of the specified array.
 * For any two <tt>double</tt> arrays <tt>a</tt> and <tt>b</tt>
 * such that <tt>Arrays.equals(a, b)</tt>, it is also the case that
 * <tt>Arrays.hashCode(a) == Arrays.hashCode(b)</tt>.
 *
 * <p>The value returned by this method is the same value that would be
 * obtained by invoking the {@link java.util.List#hashCode() List#hashCode()}
 * method on a {@link java.util.List List} containing a sequence of {@link java.lang.Double Double}
 * instances representing the elements of <tt>a</tt> in the same order.
 * If <tt>a</tt> is <tt>null</tt>, this method returns 0.
 *
 * @param a the array whose hash value to compute
 * @return a content-based hash code for <tt>a</tt>
 * @since 1.5
 * @apiSince 1
 */

public static int hashCode(@androidx.annotation.Nullable double[] a) { throw new RuntimeException("Stub!"); }

/**
 * Returns a hash code based on the contents of the specified array.  If
 * the array contains other arrays as elements, the hash code is based on
 * their identities rather than their contents.  It is therefore
 * acceptable to invoke this method on an array that contains itself as an
 * element,  either directly or indirectly through one or more levels of
 * arrays.
 *
 * <p>For any two arrays <tt>a</tt> and <tt>b</tt> such that
 * <tt>Arrays.equals(a, b)</tt>, it is also the case that
 * <tt>Arrays.hashCode(a) == Arrays.hashCode(b)</tt>.
 *
 * <p>The value returned by this method is equal to the value that would
 * be returned by <tt>Arrays.asList(a).hashCode()</tt>, unless <tt>a</tt>
 * is <tt>null</tt>, in which case <tt>0</tt> is returned.
 *
 * @param a the array whose content-based hash code to compute
 * @return a content-based hash code for <tt>a</tt>
 * @see #deepHashCode(Object[])
 * @since 1.5
 * @apiSince 1
 */

public static int hashCode(@androidx.annotation.Nullable java.lang.Object[] a) { throw new RuntimeException("Stub!"); }

/**
 * Returns a hash code based on the "deep contents" of the specified
 * array.  If the array contains other arrays as elements, the
 * hash code is based on their contents and so on, ad infinitum.
 * It is therefore unacceptable to invoke this method on an array that
 * contains itself as an element, either directly or indirectly through
 * one or more levels of arrays.  The behavior of such an invocation is
 * undefined.
 *
 * <p>For any two arrays <tt>a</tt> and <tt>b</tt> such that
 * <tt>Arrays.deepEquals(a, b)</tt>, it is also the case that
 * <tt>Arrays.deepHashCode(a) == Arrays.deepHashCode(b)</tt>.
 *
 * <p>The computation of the value returned by this method is similar to
 * that of the value returned by {@link java.util.List#hashCode() List#hashCode()} on a list
 * containing the same elements as <tt>a</tt> in the same order, with one
 * difference: If an element <tt>e</tt> of <tt>a</tt> is itself an array,
 * its hash code is computed not by calling <tt>e.hashCode()</tt>, but as
 * by calling the appropriate overloading of <tt>Arrays.hashCode(e)</tt>
 * if <tt>e</tt> is an array of a primitive type, or as by calling
 * <tt>Arrays.deepHashCode(e)</tt> recursively if <tt>e</tt> is an array
 * of a reference type.  If <tt>a</tt> is <tt>null</tt>, this method
 * returns 0.
 *
 * @param a the array whose deep-content-based hash code to compute
 * @return a deep-content-based hash code for <tt>a</tt>
 * @see #hashCode(Object[])
 * @since 1.5
 * @apiSince 1
 */

public static int deepHashCode(@androidx.annotation.Nullable java.lang.Object[] a) { throw new RuntimeException("Stub!"); }

/**
 * Returns <tt>true</tt> if the two specified arrays are <i>deeply
 * equal</i> to one another.  Unlike the {@link #equals(java.lang.Object[],java.lang.Object[])}
 * method, this method is appropriate for use with nested arrays of
 * arbitrary depth.
 *
 * <p>Two array references are considered deeply equal if both
 * are <tt>null</tt>, or if they refer to arrays that contain the same
 * number of elements and all corresponding pairs of elements in the two
 * arrays are deeply equal.
 *
 * <p>Two possibly <tt>null</tt> elements <tt>e1</tt> and <tt>e2</tt> are
 * deeply equal if any of the following conditions hold:
 * <ul>
 *    <li> <tt>e1</tt> and <tt>e2</tt> are both arrays of object reference
 *         types, and <tt>Arrays.deepEquals(e1, e2) would return true</tt>
 *    <li> <tt>e1</tt> and <tt>e2</tt> are arrays of the same primitive
 *         type, and the appropriate overloading of
 *         <tt>Arrays.equals(e1, e2)</tt> would return true.
 *    <li> <tt>e1 == e2</tt>
 *    <li> <tt>e1.equals(e2)</tt> would return true.
 * </ul>
 * Note that this definition permits <tt>null</tt> elements at any depth.
 *
 * <p>If either of the specified arrays contain themselves as elements
 * either directly or indirectly through one or more levels of arrays,
 * the behavior of this method is undefined.
 *
 * @param a1 one array to be tested for equality
 * @param a2 the other array to be tested for equality
 * @return <tt>true</tt> if the two arrays are equal
 * @see #equals(Object[],Object[])
 * @see java.util.Objects#deepEquals(Object, Object)
 * @since 1.5
 * @apiSince 1
 */

public static boolean deepEquals(@androidx.annotation.Nullable java.lang.Object[] a1, @androidx.annotation.Nullable java.lang.Object[] a2) { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of the contents of the specified array.
 * The string representation consists of a list of the array's elements,
 * enclosed in square brackets (<tt>"[]"</tt>).  Adjacent elements are
 * separated by the characters <tt>", "</tt> (a comma followed by a
 * space).  Elements are converted to strings as by
 * <tt>String.valueOf(long)</tt>.  Returns <tt>"null"</tt> if <tt>a</tt>
 * is <tt>null</tt>.
 *
 * @param a the array whose string representation to return
 * @return a string representation of <tt>a</tt>
 * @since 1.5
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.lang.String toString(@androidx.annotation.Nullable long[] a) { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of the contents of the specified array.
 * The string representation consists of a list of the array's elements,
 * enclosed in square brackets (<tt>"[]"</tt>).  Adjacent elements are
 * separated by the characters <tt>", "</tt> (a comma followed by a
 * space).  Elements are converted to strings as by
 * <tt>String.valueOf(int)</tt>.  Returns <tt>"null"</tt> if <tt>a</tt> is
 * <tt>null</tt>.
 *
 * @param a the array whose string representation to return
 * @return a string representation of <tt>a</tt>
 * @since 1.5
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.lang.String toString(@androidx.annotation.Nullable int[] a) { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of the contents of the specified array.
 * The string representation consists of a list of the array's elements,
 * enclosed in square brackets (<tt>"[]"</tt>).  Adjacent elements are
 * separated by the characters <tt>", "</tt> (a comma followed by a
 * space).  Elements are converted to strings as by
 * <tt>String.valueOf(short)</tt>.  Returns <tt>"null"</tt> if <tt>a</tt>
 * is <tt>null</tt>.
 *
 * @param a the array whose string representation to return
 * @return a string representation of <tt>a</tt>
 * @since 1.5
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.lang.String toString(@androidx.annotation.Nullable short[] a) { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of the contents of the specified array.
 * The string representation consists of a list of the array's elements,
 * enclosed in square brackets (<tt>"[]"</tt>).  Adjacent elements are
 * separated by the characters <tt>", "</tt> (a comma followed by a
 * space).  Elements are converted to strings as by
 * <tt>String.valueOf(char)</tt>.  Returns <tt>"null"</tt> if <tt>a</tt>
 * is <tt>null</tt>.
 *
 * @param a the array whose string representation to return
 * @return a string representation of <tt>a</tt>
 * @since 1.5
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.lang.String toString(@androidx.annotation.Nullable char[] a) { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of the contents of the specified array.
 * The string representation consists of a list of the array's elements,
 * enclosed in square brackets (<tt>"[]"</tt>).  Adjacent elements
 * are separated by the characters <tt>", "</tt> (a comma followed
 * by a space).  Elements are converted to strings as by
 * <tt>String.valueOf(byte)</tt>.  Returns <tt>"null"</tt> if
 * <tt>a</tt> is <tt>null</tt>.
 *
 * @param a the array whose string representation to return
 * @return a string representation of <tt>a</tt>
 * @since 1.5
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.lang.String toString(@androidx.annotation.Nullable byte[] a) { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of the contents of the specified array.
 * The string representation consists of a list of the array's elements,
 * enclosed in square brackets (<tt>"[]"</tt>).  Adjacent elements are
 * separated by the characters <tt>", "</tt> (a comma followed by a
 * space).  Elements are converted to strings as by
 * <tt>String.valueOf(boolean)</tt>.  Returns <tt>"null"</tt> if
 * <tt>a</tt> is <tt>null</tt>.
 *
 * @param a the array whose string representation to return
 * @return a string representation of <tt>a</tt>
 * @since 1.5
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.lang.String toString(@androidx.annotation.Nullable boolean[] a) { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of the contents of the specified array.
 * The string representation consists of a list of the array's elements,
 * enclosed in square brackets (<tt>"[]"</tt>).  Adjacent elements are
 * separated by the characters <tt>", "</tt> (a comma followed by a
 * space).  Elements are converted to strings as by
 * <tt>String.valueOf(float)</tt>.  Returns <tt>"null"</tt> if <tt>a</tt>
 * is <tt>null</tt>.
 *
 * @param a the array whose string representation to return
 * @return a string representation of <tt>a</tt>
 * @since 1.5
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.lang.String toString(@androidx.annotation.Nullable float[] a) { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of the contents of the specified array.
 * The string representation consists of a list of the array's elements,
 * enclosed in square brackets (<tt>"[]"</tt>).  Adjacent elements are
 * separated by the characters <tt>", "</tt> (a comma followed by a
 * space).  Elements are converted to strings as by
 * <tt>String.valueOf(double)</tt>.  Returns <tt>"null"</tt> if <tt>a</tt>
 * is <tt>null</tt>.
 *
 * @param a the array whose string representation to return
 * @return a string representation of <tt>a</tt>
 * @since 1.5
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.lang.String toString(@androidx.annotation.Nullable double[] a) { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of the contents of the specified array.
 * If the array contains other arrays as elements, they are converted to
 * strings by the {@link java.lang.Object#toString Object#toString} method inherited from
 * <tt>Object</tt>, which describes their <i>identities</i> rather than
 * their contents.
 *
 * <p>The value returned by this method is equal to the value that would
 * be returned by <tt>Arrays.asList(a).toString()</tt>, unless <tt>a</tt>
 * is <tt>null</tt>, in which case <tt>"null"</tt> is returned.
 *
 * @param a the array whose string representation to return
 * @return a string representation of <tt>a</tt>
 * @see #deepToString(Object[])
 * @since 1.5
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.lang.String toString(@androidx.annotation.Nullable java.lang.Object[] a) { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of the "deep contents" of the specified
 * array.  If the array contains other arrays as elements, the string
 * representation contains their contents and so on.  This method is
 * designed for converting multidimensional arrays to strings.
 *
 * <p>The string representation consists of a list of the array's
 * elements, enclosed in square brackets (<tt>"[]"</tt>).  Adjacent
 * elements are separated by the characters <tt>", "</tt> (a comma
 * followed by a space).  Elements are converted to strings as by
 * <tt>String.valueOf(Object)</tt>, unless they are themselves
 * arrays.
 *
 * <p>If an element <tt>e</tt> is an array of a primitive type, it is
 * converted to a string as by invoking the appropriate overloading of
 * <tt>Arrays.toString(e)</tt>.  If an element <tt>e</tt> is an array of a
 * reference type, it is converted to a string as by invoking
 * this method recursively.
 *
 * <p>To avoid infinite recursion, if the specified array contains itself
 * as an element, or contains an indirect reference to itself through one
 * or more levels of arrays, the self-reference is converted to the string
 * <tt>"[...]"</tt>.  For example, an array containing only a reference
 * to itself would be rendered as <tt>"[[...]]"</tt>.
 *
 * <p>This method returns <tt>"null"</tt> if the specified array
 * is <tt>null</tt>.
 *
 * @param a the array whose string representation to return
 * @return a string representation of <tt>a</tt>
 * @see #toString(Object[])
 * @since 1.5
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.lang.String deepToString(@androidx.annotation.Nullable java.lang.Object[] a) { throw new RuntimeException("Stub!"); }

/**
 * Set all elements of the specified array, using the provided
 * generator function to compute each element.
 *
 * <p>If the generator function throws an exception, it is relayed to
 * the caller and the array is left in an indeterminate state.
 *
 * @param <T> type of elements of the array
 * @param array array to be initialized
 * @param generator a function accepting an index and producing the desired
 *        value for that position
 * @throws java.lang.NullPointerException if the generator is null
 * @since 1.8
 * @apiSince 24
 */

public static <T> void setAll(@androidx.annotation.NonNull T[] array, @androidx.annotation.NonNull java.util.function.IntFunction<? extends T> generator) { throw new RuntimeException("Stub!"); }

/**
 * Set all elements of the specified array, in parallel, using the
 * provided generator function to compute each element.
 *
 * <p>If the generator function throws an exception, an unchecked exception
 * is thrown from {@code parallelSetAll} and the array is left in an
 * indeterminate state.
 *
 * @param <T> type of elements of the array
 * @param array array to be initialized
 * @param generator a function accepting an index and producing the desired
 *        value for that position
 * @throws java.lang.NullPointerException if the generator is null
 * @since 1.8
 * @apiSince 24
 */

public static <T> void parallelSetAll(@androidx.annotation.NonNull T[] array, @androidx.annotation.NonNull java.util.function.IntFunction<? extends T> generator) { throw new RuntimeException("Stub!"); }

/**
 * Set all elements of the specified array, using the provided
 * generator function to compute each element.
 *
 * <p>If the generator function throws an exception, it is relayed to
 * the caller and the array is left in an indeterminate state.
 *
 * @param array array to be initialized
 * @param generator a function accepting an index and producing the desired
 *        value for that position
 * @throws java.lang.NullPointerException if the generator is null
 * @since 1.8
 * @apiSince 24
 */

public static void setAll(@androidx.annotation.NonNull int[] array, @androidx.annotation.NonNull java.util.function.IntUnaryOperator generator) { throw new RuntimeException("Stub!"); }

/**
 * Set all elements of the specified array, in parallel, using the
 * provided generator function to compute each element.
 *
 * <p>If the generator function throws an exception, an unchecked exception
 * is thrown from {@code parallelSetAll} and the array is left in an
 * indeterminate state.
 *
 * @param array array to be initialized
 * @param generator a function accepting an index and producing the desired
 * value for that position
 * @throws java.lang.NullPointerException if the generator is null
 * @since 1.8
 * @apiSince 24
 */

public static void parallelSetAll(@androidx.annotation.NonNull int[] array, @androidx.annotation.NonNull java.util.function.IntUnaryOperator generator) { throw new RuntimeException("Stub!"); }

/**
 * Set all elements of the specified array, using the provided
 * generator function to compute each element.
 *
 * <p>If the generator function throws an exception, it is relayed to
 * the caller and the array is left in an indeterminate state.
 *
 * @param array array to be initialized
 * @param generator a function accepting an index and producing the desired
 *        value for that position
 * @throws java.lang.NullPointerException if the generator is null
 * @since 1.8
 * @apiSince 24
 */

public static void setAll(@androidx.annotation.NonNull long[] array, @androidx.annotation.NonNull java.util.function.IntToLongFunction generator) { throw new RuntimeException("Stub!"); }

/**
 * Set all elements of the specified array, in parallel, using the
 * provided generator function to compute each element.
 *
 * <p>If the generator function throws an exception, an unchecked exception
 * is thrown from {@code parallelSetAll} and the array is left in an
 * indeterminate state.
 *
 * @param array array to be initialized
 * @param generator a function accepting an index and producing the desired
 *        value for that position
 * @throws java.lang.NullPointerException if the generator is null
 * @since 1.8
 * @apiSince 24
 */

public static void parallelSetAll(@androidx.annotation.NonNull long[] array, @androidx.annotation.NonNull java.util.function.IntToLongFunction generator) { throw new RuntimeException("Stub!"); }

/**
 * Set all elements of the specified array, using the provided
 * generator function to compute each element.
 *
 * <p>If the generator function throws an exception, it is relayed to
 * the caller and the array is left in an indeterminate state.
 *
 * @param array array to be initialized
 * @param generator a function accepting an index and producing the desired
 *        value for that position
 * @throws java.lang.NullPointerException if the generator is null
 * @since 1.8
 * @apiSince 24
 */

public static void setAll(@androidx.annotation.NonNull double[] array, @androidx.annotation.NonNull java.util.function.IntToDoubleFunction generator) { throw new RuntimeException("Stub!"); }

/**
 * Set all elements of the specified array, in parallel, using the
 * provided generator function to compute each element.
 *
 * <p>If the generator function throws an exception, an unchecked exception
 * is thrown from {@code parallelSetAll} and the array is left in an
 * indeterminate state.
 *
 * @param array array to be initialized
 * @param generator a function accepting an index and producing the desired
 *        value for that position
 * @throws java.lang.NullPointerException if the generator is null
 * @since 1.8
 * @apiSince 24
 */

public static void parallelSetAll(@androidx.annotation.NonNull double[] array, @androidx.annotation.NonNull java.util.function.IntToDoubleFunction generator) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link java.util.Spliterator Spliterator} covering all of the specified array.
 *
 * <p>The spliterator reports {@link java.util.Spliterator#SIZED Spliterator#SIZED},
 * {@link java.util.Spliterator#SUBSIZED Spliterator#SUBSIZED}, {@link java.util.Spliterator#ORDERED Spliterator#ORDERED}, and
 * {@link java.util.Spliterator#IMMUTABLE Spliterator#IMMUTABLE}.
 *
 * @param <T> type of elements
 * @param array the array, assumed to be unmodified during use
 * @return a spliterator for the array elements
 * @since 1.8
 * @apiSince 24
 */

@androidx.annotation.NonNull
public static <T> java.util.Spliterator<T> spliterator(@androidx.annotation.NonNull T[] array) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link java.util.Spliterator Spliterator} covering the specified range of the
 * specified array.
 *
 * <p>The spliterator reports {@link java.util.Spliterator#SIZED Spliterator#SIZED},
 * {@link java.util.Spliterator#SUBSIZED Spliterator#SUBSIZED}, {@link java.util.Spliterator#ORDERED Spliterator#ORDERED}, and
 * {@link java.util.Spliterator#IMMUTABLE Spliterator#IMMUTABLE}.
 *
 * @param <T> type of elements
 * @param array the array, assumed to be unmodified during use
 * @param startInclusive the first index to cover, inclusive
 * @param endExclusive index immediately past the last index to cover
 * @return a spliterator for the array elements
 * @throws java.lang.ArrayIndexOutOfBoundsException if {@code startInclusive} is
 *         negative, {@code endExclusive} is less than
 *         {@code startInclusive}, or {@code endExclusive} is greater than
 *         the array size
 * @since 1.8
 * @apiSince 24
 */

@androidx.annotation.NonNull
public static <T> java.util.Spliterator<T> spliterator(@androidx.annotation.NonNull T[] array, int startInclusive, int endExclusive) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link java.util.Spliterator.OfInt Spliterator.OfInt} covering all of the specified array.
 *
 * <p>The spliterator reports {@link java.util.Spliterator#SIZED Spliterator#SIZED},
 * {@link java.util.Spliterator#SUBSIZED Spliterator#SUBSIZED}, {@link java.util.Spliterator#ORDERED Spliterator#ORDERED}, and
 * {@link java.util.Spliterator#IMMUTABLE Spliterator#IMMUTABLE}.
 *
 * @param array the array, assumed to be unmodified during use
 * @return a spliterator for the array elements
 * @since 1.8
 * @apiSince 24
 */

@androidx.annotation.NonNull
public static java.util.Spliterator.OfInt spliterator(@androidx.annotation.NonNull int[] array) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link java.util.Spliterator.OfInt Spliterator.OfInt} covering the specified range of the
 * specified array.
 *
 * <p>The spliterator reports {@link java.util.Spliterator#SIZED Spliterator#SIZED},
 * {@link java.util.Spliterator#SUBSIZED Spliterator#SUBSIZED}, {@link java.util.Spliterator#ORDERED Spliterator#ORDERED}, and
 * {@link java.util.Spliterator#IMMUTABLE Spliterator#IMMUTABLE}.
 *
 * @param array the array, assumed to be unmodified during use
 * @param startInclusive the first index to cover, inclusive
 * @param endExclusive index immediately past the last index to cover
 * @return a spliterator for the array elements
 * @throws java.lang.ArrayIndexOutOfBoundsException if {@code startInclusive} is
 *         negative, {@code endExclusive} is less than
 *         {@code startInclusive}, or {@code endExclusive} is greater than
 *         the array size
 * @since 1.8
 * @apiSince 24
 */

@androidx.annotation.NonNull
public static java.util.Spliterator.OfInt spliterator(@androidx.annotation.NonNull int[] array, int startInclusive, int endExclusive) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link java.util.Spliterator.OfLong Spliterator.OfLong} covering all of the specified array.
 *
 * <p>The spliterator reports {@link java.util.Spliterator#SIZED Spliterator#SIZED},
 * {@link java.util.Spliterator#SUBSIZED Spliterator#SUBSIZED}, {@link java.util.Spliterator#ORDERED Spliterator#ORDERED}, and
 * {@link java.util.Spliterator#IMMUTABLE Spliterator#IMMUTABLE}.
 *
 * @param array the array, assumed to be unmodified during use
 * @return the spliterator for the array elements
 * @since 1.8
 * @apiSince 24
 */

@androidx.annotation.NonNull
public static java.util.Spliterator.OfLong spliterator(@androidx.annotation.NonNull long[] array) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link java.util.Spliterator.OfLong Spliterator.OfLong} covering the specified range of the
 * specified array.
 *
 * <p>The spliterator reports {@link java.util.Spliterator#SIZED Spliterator#SIZED},
 * {@link java.util.Spliterator#SUBSIZED Spliterator#SUBSIZED}, {@link java.util.Spliterator#ORDERED Spliterator#ORDERED}, and
 * {@link java.util.Spliterator#IMMUTABLE Spliterator#IMMUTABLE}.
 *
 * @param array the array, assumed to be unmodified during use
 * @param startInclusive the first index to cover, inclusive
 * @param endExclusive index immediately past the last index to cover
 * @return a spliterator for the array elements
 * @throws java.lang.ArrayIndexOutOfBoundsException if {@code startInclusive} is
 *         negative, {@code endExclusive} is less than
 *         {@code startInclusive}, or {@code endExclusive} is greater than
 *         the array size
 * @since 1.8
 * @apiSince 24
 */

@androidx.annotation.NonNull
public static java.util.Spliterator.OfLong spliterator(@androidx.annotation.NonNull long[] array, int startInclusive, int endExclusive) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link java.util.Spliterator.OfDouble Spliterator.OfDouble} covering all of the specified
 * array.
 *
 * <p>The spliterator reports {@link java.util.Spliterator#SIZED Spliterator#SIZED},
 * {@link java.util.Spliterator#SUBSIZED Spliterator#SUBSIZED}, {@link java.util.Spliterator#ORDERED Spliterator#ORDERED}, and
 * {@link java.util.Spliterator#IMMUTABLE Spliterator#IMMUTABLE}.
 *
 * @param array the array, assumed to be unmodified during use
 * @return a spliterator for the array elements
 * @since 1.8
 * @apiSince 24
 */

@androidx.annotation.NonNull
public static java.util.Spliterator.OfDouble spliterator(@androidx.annotation.NonNull double[] array) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link java.util.Spliterator.OfDouble Spliterator.OfDouble} covering the specified range of
 * the specified array.
 *
 * <p>The spliterator reports {@link java.util.Spliterator#SIZED Spliterator#SIZED},
 * {@link java.util.Spliterator#SUBSIZED Spliterator#SUBSIZED}, {@link java.util.Spliterator#ORDERED Spliterator#ORDERED}, and
 * {@link java.util.Spliterator#IMMUTABLE Spliterator#IMMUTABLE}.
 *
 * @param array the array, assumed to be unmodified during use
 * @param startInclusive the first index to cover, inclusive
 * @param endExclusive index immediately past the last index to cover
 * @return a spliterator for the array elements
 * @throws java.lang.ArrayIndexOutOfBoundsException if {@code startInclusive} is
 *         negative, {@code endExclusive} is less than
 *         {@code startInclusive}, or {@code endExclusive} is greater than
 *         the array size
 * @since 1.8
 * @apiSince 24
 */

@androidx.annotation.NonNull
public static java.util.Spliterator.OfDouble spliterator(@androidx.annotation.NonNull double[] array, int startInclusive, int endExclusive) { throw new RuntimeException("Stub!"); }

/**
 * Returns a sequential {@link java.util.stream.Stream Stream} with the specified array as its
 * source.
 *
 * @param <T> The type of the array elements
 * @param array The array, assumed to be unmodified during use
 * @return a {@code Stream} for the array
 * @since 1.8
 * @apiSince 24
 */

@androidx.annotation.NonNull
public static <T> java.util.stream.Stream<T> stream(@androidx.annotation.NonNull T[] array) { throw new RuntimeException("Stub!"); }

/**
 * Returns a sequential {@link java.util.stream.Stream Stream} with the specified range of the
 * specified array as its source.
 *
 * @param <T> the type of the array elements
 * @param array the array, assumed to be unmodified during use
 * @param startInclusive the first index to cover, inclusive
 * @param endExclusive index immediately past the last index to cover
 * @return a {@code Stream} for the array range
 * @throws java.lang.ArrayIndexOutOfBoundsException if {@code startInclusive} is
 *         negative, {@code endExclusive} is less than
 *         {@code startInclusive}, or {@code endExclusive} is greater than
 *         the array size
 * @since 1.8
 * @apiSince 24
 */

@androidx.annotation.NonNull
public static <T> java.util.stream.Stream<T> stream(@androidx.annotation.NonNull T[] array, int startInclusive, int endExclusive) { throw new RuntimeException("Stub!"); }

/**
 * Returns a sequential {@link java.util.stream.IntStream IntStream} with the specified array as its
 * source.
 *
 * @param array the array, assumed to be unmodified during use
 * @return an {@code IntStream} for the array
 * @since 1.8
 * @apiSince 24
 */

@androidx.annotation.NonNull
public static java.util.stream.IntStream stream(@androidx.annotation.NonNull int[] array) { throw new RuntimeException("Stub!"); }

/**
 * Returns a sequential {@link java.util.stream.IntStream IntStream} with the specified range of the
 * specified array as its source.
 *
 * @param array the array, assumed to be unmodified during use
 * @param startInclusive the first index to cover, inclusive
 * @param endExclusive index immediately past the last index to cover
 * @return an {@code IntStream} for the array range
 * @throws java.lang.ArrayIndexOutOfBoundsException if {@code startInclusive} is
 *         negative, {@code endExclusive} is less than
 *         {@code startInclusive}, or {@code endExclusive} is greater than
 *         the array size
 * @since 1.8
 * @apiSince 24
 */

@androidx.annotation.NonNull
public static java.util.stream.IntStream stream(@androidx.annotation.NonNull int[] array, int startInclusive, int endExclusive) { throw new RuntimeException("Stub!"); }

/**
 * Returns a sequential {@link java.util.stream.LongStream LongStream} with the specified array as its
 * source.
 *
 * @param array the array, assumed to be unmodified during use
 * @return a {@code LongStream} for the array
 * @since 1.8
 * @apiSince 24
 */

@androidx.annotation.NonNull
public static java.util.stream.LongStream stream(@androidx.annotation.NonNull long[] array) { throw new RuntimeException("Stub!"); }

/**
 * Returns a sequential {@link java.util.stream.LongStream LongStream} with the specified range of the
 * specified array as its source.
 *
 * @param array the array, assumed to be unmodified during use
 * @param startInclusive the first index to cover, inclusive
 * @param endExclusive index immediately past the last index to cover
 * @return a {@code LongStream} for the array range
 * @throws java.lang.ArrayIndexOutOfBoundsException if {@code startInclusive} is
 *         negative, {@code endExclusive} is less than
 *         {@code startInclusive}, or {@code endExclusive} is greater than
 *         the array size
 * @since 1.8
 * @apiSince 24
 */

@androidx.annotation.NonNull
public static java.util.stream.LongStream stream(@androidx.annotation.NonNull long[] array, int startInclusive, int endExclusive) { throw new RuntimeException("Stub!"); }

/**
 * Returns a sequential {@link java.util.stream.DoubleStream DoubleStream} with the specified array as its
 * source.
 *
 * @param array the array, assumed to be unmodified during use
 * @return a {@code DoubleStream} for the array
 * @since 1.8
 * @apiSince 24
 */

@androidx.annotation.NonNull
public static java.util.stream.DoubleStream stream(@androidx.annotation.NonNull double[] array) { throw new RuntimeException("Stub!"); }

/**
 * Returns a sequential {@link java.util.stream.DoubleStream DoubleStream} with the specified range of the
 * specified array as its source.
 *
 * @param array the array, assumed to be unmodified during use
 * @param startInclusive the first index to cover, inclusive
 * @param endExclusive index immediately past the last index to cover
 * @return a {@code DoubleStream} for the array range
 * @throws java.lang.ArrayIndexOutOfBoundsException if {@code startInclusive} is
 *         negative, {@code endExclusive} is less than
 *         {@code startInclusive}, or {@code endExclusive} is greater than
 *         the array size
 * @since 1.8
 * @apiSince 24
 */

@androidx.annotation.NonNull
public static java.util.stream.DoubleStream stream(@androidx.annotation.NonNull double[] array, int startInclusive, int endExclusive) { throw new RuntimeException("Stub!"); }
}

