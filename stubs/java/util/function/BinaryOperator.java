/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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


package java.util.function;

import java.util.Comparator;

/**
 * Represents an operation upon two operands of the same type, producing a result
 * of the same type as the operands.  This is a specialization of
 * {@link java.util.function.BiFunction BiFunction} for the case where the operands and the result are all of
 * the same type.
 *
 * <p>This is a <a href="package-summary.html">functional interface</a>
 * whose functional method is {@link #apply(java.lang.Object,java.lang.Object)}.
 *
 * @param <T> the type of the operands and result of the operator
 *
 * @see java.util.function.BiFunction
 * @see java.util.function.UnaryOperator
 * @since 1.8
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@java.lang.FunctionalInterface
public interface BinaryOperator<T> extends java.util.function.BiFunction<T,T,T> {

/**
 * Returns a {@link java.util.function.BinaryOperator BinaryOperator} which returns the lesser of two elements
 * according to the specified {@code Comparator}.
 *
 * @param <T> the type of the input arguments of the comparator
 * @param comparator a {@code Comparator} for comparing the two values
 * @return a {@code BinaryOperator} which returns the lesser of its operands,
 *         according to the supplied {@code Comparator}
 * @throws java.lang.NullPointerException if the argument is null
 * @apiSince 24
 */

public static <T> java.util.function.BinaryOperator<T> minBy(java.util.Comparator<? super T> comparator) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link java.util.function.BinaryOperator BinaryOperator} which returns the greater of two elements
 * according to the specified {@code Comparator}.
 *
 * @param <T> the type of the input arguments of the comparator
 * @param comparator a {@code Comparator} for comparing the two values
 * @return a {@code BinaryOperator} which returns the greater of its operands,
 *         according to the supplied {@code Comparator}
 * @throws java.lang.NullPointerException if the argument is null
 * @apiSince 24
 */

public static <T> java.util.function.BinaryOperator<T> maxBy(java.util.Comparator<? super T> comparator) { throw new RuntimeException("Stub!"); }
}

