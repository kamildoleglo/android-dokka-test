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


/**
 * Represents a function that accepts one argument and produces a result.
 *
 * <p>This is a <a href="package-summary.html">functional interface</a>
 * whose functional method is {@link #apply(java.lang.Object)}.
 *
 * @param <T> the type of the input to the function
 * @param <R> the type of the result of the function
 *
 * @since 1.8
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@java.lang.FunctionalInterface
public interface Function<T, R> {

/**
 * Applies this function to the given argument.
 *
 * @param t the function argument
 * @return the function result
 * @apiSince 24
 */

public R apply(T t);

/**
 * Returns a composed function that first applies the {@code before}
 * function to its input, and then applies this function to the result.
 * If evaluation of either function throws an exception, it is relayed to
 * the caller of the composed function.
 *
 * @param <V> the type of input to the {@code before} function, and to the
 *           composed function
 * @param before the function to apply before this function is applied
 * @return a composed function that first applies the {@code before}
 * function and then applies this function
 * @throws java.lang.NullPointerException if before is null
 *
 * @see #andThen(Function)
 * @apiSince 24
 */

public default <V> java.util.function.Function<V,R> compose(java.util.function.Function<? super V,? extends T> before) { throw new RuntimeException("Stub!"); }

/**
 * Returns a composed function that first applies this function to
 * its input, and then applies the {@code after} function to the result.
 * If evaluation of either function throws an exception, it is relayed to
 * the caller of the composed function.
 *
 * @param <V> the type of output of the {@code after} function, and of the
 *           composed function
 * @param after the function to apply after this function is applied
 * @return a composed function that first applies this function and then
 * applies the {@code after} function
 * @throws java.lang.NullPointerException if after is null
 *
 * @see #compose(Function)
 * @apiSince 24
 */

public default <V> java.util.function.Function<T,V> andThen(java.util.function.Function<? super R,? extends V> after) { throw new RuntimeException("Stub!"); }

/**
 * Returns a function that always returns its input argument.
 *
 * @param <T> the type of the input and output objects to the function
 * @return a function that always returns its input argument
 * @apiSince 24
 */

public static <T> java.util.function.Function<T,T> identity() { throw new RuntimeException("Stub!"); }
}

