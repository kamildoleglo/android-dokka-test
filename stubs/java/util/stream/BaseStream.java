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


package java.util.stream;


/**
 * Base interface for streams, which are sequences of elements supporting
 * sequential and parallel aggregate operations.  The following example
 * illustrates an aggregate operation using the stream types {@link java.util.stream.Stream Stream}
 * and {@link java.util.stream.IntStream IntStream}, computing the sum of the weights of the red widgets:
 *
 * <pre>{@code
 *     int sum = widgets.stream()
 *                      .filter(w -> w.getColor() == RED)
 *                      .mapToInt(w -> w.getWeight())
 *                      .sum();
 * }</pre>
 *
 * See the class documentation for {@link java.util.stream.Stream Stream} and the package documentation
 * for <a href="package-summary.html">java.util.stream</a> for additional
 * specification of streams, stream operations, stream pipelines, and
 * parallelism, which governs the behavior of all stream types.
 *
 * @param <T> the type of the stream elements
 * @param <S> the type of of the stream implementing {@code BaseStream}
 * @since 1.8
 * @see java.util.stream.Stream
 * @see java.util.stream.IntStream
 * @see java.util.stream.LongStream
 * @see java.util.stream.DoubleStream
 * @see <a href="package-summary.html">java.util.stream</a>
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface BaseStream<T, S extends java.util.stream.BaseStream<T, S>> extends java.lang.AutoCloseable {

/**
 * Returns an iterator for the elements of this stream.
 *
 * <p>This is a <a href="package-summary.html#StreamOps">terminal
 * operation</a>.
 *
 * @return the element iterator for this stream
 * @apiSince 24
 */

public java.util.Iterator<T> iterator();

/**
 * Returns a spliterator for the elements of this stream.
 *
 * <p>This is a <a href="package-summary.html#StreamOps">terminal
 * operation</a>.
 *
 * @return the element spliterator for this stream
 * @apiSince 24
 */

public java.util.Spliterator<T> spliterator();

/**
 * Returns whether this stream, if a terminal operation were to be executed,
 * would execute in parallel.  Calling this method after invoking an
 * terminal stream operation method may yield unpredictable results.
 *
 * @return {@code true} if this stream would execute in parallel if executed
 * @apiSince 24
 */

public boolean isParallel();

/**
 * Returns an equivalent stream that is sequential.  May return
 * itself, either because the stream was already sequential, or because
 * the underlying stream state was modified to be sequential.
 *
 * <p>This is an <a href="package-summary.html#StreamOps">intermediate
 * operation</a>.
 *
 * @return a sequential stream
 * @apiSince 24
 */

public S sequential();

/**
 * Returns an equivalent stream that is parallel.  May return
 * itself, either because the stream was already parallel, or because
 * the underlying stream state was modified to be parallel.
 *
 * <p>This is an <a href="package-summary.html#StreamOps">intermediate
 * operation</a>.
 *
 * @return a parallel stream
 * @apiSince 24
 */

public S parallel();

/**
 * Returns an equivalent stream that is
 * <a href="package-summary.html#Ordering">unordered</a>.  May return
 * itself, either because the stream was already unordered, or because
 * the underlying stream state was modified to be unordered.
 *
 * <p>This is an <a href="package-summary.html#StreamOps">intermediate
 * operation</a>.
 *
 * @return an unordered stream
 * @apiSince 24
 */

public S unordered();

/**
 * Returns an equivalent stream with an additional close handler.  Close
 * handlers are run when the {@link #close()} method
 * is called on the stream, and are executed in the order they were
 * added.  All close handlers are run, even if earlier close handlers throw
 * exceptions.  If any close handler throws an exception, the first
 * exception thrown will be relayed to the caller of {@code close()}, with
 * any remaining exceptions added to that exception as suppressed exceptions
 * (unless one of the remaining exceptions is the same exception as the
 * first exception, since an exception cannot suppress itself.)  May
 * return itself.
 *
 * <p>This is an <a href="package-summary.html#StreamOps">intermediate
 * operation</a>.
 *
 * @param closeHandler A task to execute when the stream is closed
 * @return a stream with a handler that is run if the stream is closed
 * @apiSince 24
 */

public S onClose(java.lang.Runnable closeHandler);

/**
 * Closes this stream, causing all close handlers for this stream pipeline
 * to be called.
 *
 * @see java.lang.AutoCloseable#close()
 * @apiSince 24
 */

public void close();
}

