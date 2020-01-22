/*
 * Copyright (c) 2003, 2013, Oracle and/or its affiliates. All rights reserved.
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


package java.lang;

import java.util.Iterator;
import java.util.Spliterator;

/**
 * Implementing this interface allows an object to be the target of
 * the "for-each loop" statement. See
 * <strong>
 * <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/language/foreach.html">For-each Loop</a>
 * </strong>
 *
 * @param <T> the type of elements returned by the iterator
 *
 * @since 1.5
 * @jls 14.14.2 The enhanced for statement
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface Iterable<T> {

/**
 * Returns an iterator over elements of type {@code T}.
 *
 * @return an Iterator.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.util.Iterator<T> iterator();

/**
 * Performs the given action for each element of the {@code Iterable}
 * until all elements have been processed or the action throws an
 * exception.  Unless otherwise specified by the implementing class,
 * actions are performed in the order of iteration (if an iteration order
 * is specified).  Exceptions thrown by the action are relayed to the
 * caller.
 *
 * @implSpec
 * <p>The default implementation behaves as if:
 * <pre>{@code
 *     for (T t : this)
 *         action.accept(t);
 * }</pre>
 *
 * @param action The action to be performed for each element
 * @throws java.lang.NullPointerException if the specified action is null
 * @since 1.8
 * @apiSince 24
 */

public default void forEach(@androidx.annotation.NonNull java.util.function.Consumer<? super T> action) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@link java.util.Spliterator Spliterator} over the elements described by this
 * {@code Iterable}.
 *
 * @implSpec
 * The default implementation creates an
 * <em><a href="Spliterator.html#binding">early-binding</a></em>
 * spliterator from the iterable's {@code Iterator}.  The spliterator
 * inherits the <em>fail-fast</em> properties of the iterable's iterator.
 *
 * @implNote
 * The default implementation should usually be overridden.  The
 * spliterator returned by the default implementation has poor splitting
 * capabilities, is unsized, and does not report any spliterator
 * characteristics. Implementing classes can nearly always provide a
 * better implementation.
 *
 * @return a {@code Spliterator} over the elements described by this
 * {@code Iterable}.
 * @since 1.8
 * @apiSince 24
 */

@androidx.annotation.NonNull
public default java.util.Spliterator<T> spliterator() { throw new RuntimeException("Stub!"); }
}

