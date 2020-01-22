/*
 * Copyright (c) 2012, 2013, Oracle and/or its affiliates. All rights reserved.
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


/**
 * Represents an operation on a single {@code double}-valued operand that produces
 * a {@code double}-valued result.  This is the primitive type specialization of
 * {@link java.util.function.UnaryOperator UnaryOperator} for {@code double}.
 *
 * <p>This is a <a href="package-summary.html">functional interface</a>
 * whose functional method is {@link #applyAsDouble(double)}.
 *
 * @see java.util.function.UnaryOperator
 * @since 1.8
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@java.lang.FunctionalInterface
public interface DoubleUnaryOperator {

/**
 * Applies this operator to the given operand.
 *
 * @param operand the operand
 * @return the operator result
 * @apiSince 24
 */

public double applyAsDouble(double operand);

/**
 * Returns a composed operator that first applies the {@code before}
 * operator to its input, and then applies this operator to the result.
 * If evaluation of either operator throws an exception, it is relayed to
 * the caller of the composed operator.
 *
 * @param before the operator to apply before this operator is applied
 * @return a composed operator that first applies the {@code before}
 * operator and then applies this operator
 * @throws java.lang.NullPointerException if before is null
 *
 * @see #andThen(DoubleUnaryOperator)
 * @apiSince 24
 */

public default java.util.function.DoubleUnaryOperator compose(java.util.function.DoubleUnaryOperator before) { throw new RuntimeException("Stub!"); }

/**
 * Returns a composed operator that first applies this operator to
 * its input, and then applies the {@code after} operator to the result.
 * If evaluation of either operator throws an exception, it is relayed to
 * the caller of the composed operator.
 *
 * @param after the operator to apply after this operator is applied
 * @return a composed operator that first applies this operator and then
 * applies the {@code after} operator
 * @throws java.lang.NullPointerException if after is null
 *
 * @see #compose(DoubleUnaryOperator)
 * @apiSince 24
 */

public default java.util.function.DoubleUnaryOperator andThen(java.util.function.DoubleUnaryOperator after) { throw new RuntimeException("Stub!"); }

/**
 * Returns a unary operator that always returns its input argument.
 *
 * @return a unary operator that always returns its input argument
 * @apiSince 24
 */

public static java.util.function.DoubleUnaryOperator identity() { throw new RuntimeException("Stub!"); }
}

