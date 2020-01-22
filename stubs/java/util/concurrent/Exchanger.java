/*
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

/*
 * This file is available under and governed by the GNU General Public
 * License version 2 only, as published by the Free Software Foundation.
 * However, the following notice accompanied the original version of this
 * file:
 *
 * Written by Doug Lea, Bill Scherer, and Michael Scott with
 * assistance from members of JCP JSR-166 Expert Group and released to
 * the public domain, as explained at
 * http://creativecommons.org/publicdomain/zero/1.0/
 */



package java.util.concurrent;


/**
 * A synchronization point at which threads can pair and swap elements
 * within pairs.  Each thread presents some object on entry to the
 * {@link #exchange exchange} method, matches with a partner thread,
 * and receives its partner's object on return.  An Exchanger may be
 * viewed as a bidirectional form of a {@link java.util.concurrent.SynchronousQueue SynchronousQueue}.
 * Exchangers may be useful in applications such as genetic algorithms
 * and pipeline designs.
 *
 * <p><b>Sample Usage:</b>
 * Here are the highlights of a class that uses an {@code Exchanger}
 * to swap buffers between threads so that the thread filling the
 * buffer gets a freshly emptied one when it needs it, handing off the
 * filled one to the thread emptying the buffer.
 * <pre> {@code
 * class FillAndEmpty {
 *   Exchanger<DataBuffer> exchanger = new Exchanger<>();
 *   DataBuffer initialEmptyBuffer = ... a made-up type
 *   DataBuffer initialFullBuffer = ...
 *
 *   class FillingLoop implements Runnable {
 *     public void run() {
 *       DataBuffer currentBuffer = initialEmptyBuffer;
 *       try {
 *         while (currentBuffer != null) {
 *           addToBuffer(currentBuffer);
 *           if (currentBuffer.isFull())
 *             currentBuffer = exchanger.exchange(currentBuffer);
 *         }
 *       } catch (InterruptedException ex) { ... handle ... }
 *     }
 *   }
 *
 *   class EmptyingLoop implements Runnable {
 *     public void run() {
 *       DataBuffer currentBuffer = initialFullBuffer;
 *       try {
 *         while (currentBuffer != null) {
 *           takeFromBuffer(currentBuffer);
 *           if (currentBuffer.isEmpty())
 *             currentBuffer = exchanger.exchange(currentBuffer);
 *         }
 *       } catch (InterruptedException ex) { ... handle ...}
 *     }
 *   }
 *
 *   void start() {
 *     new Thread(new FillingLoop()).start();
 *     new Thread(new EmptyingLoop()).start();
 *   }
 * }}</pre>
 *
 * <p>Memory consistency effects: For each pair of threads that
 * successfully exchange objects via an {@code Exchanger}, actions
 * prior to the {@code exchange()} in each thread
 * <a href="package-summary.html#MemoryVisibility"><i>happen-before</i></a>
 * those subsequent to a return from the corresponding {@code exchange()}
 * in the other thread.
 *
 * @since 1.5
 * @author Doug Lea and Bill Scherer and Michael Scott
 * @param <V> The type of objects that may be exchanged
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Exchanger<V> {

/**
 * Creates a new Exchanger.
 * @apiSince 1
 */

public Exchanger() { throw new RuntimeException("Stub!"); }

/**
 * Waits for another thread to arrive at this exchange point (unless
 * the current thread is {@linkplain java.lang.Thread#interrupt Thread#interrupt}),
 * and then transfers the given object to it, receiving its object
 * in return.
 *
 * <p>If another thread is already waiting at the exchange point then
 * it is resumed for thread scheduling purposes and receives the object
 * passed in by the current thread.  The current thread returns immediately,
 * receiving the object passed to the exchange by that other thread.
 *
 * <p>If no other thread is already waiting at the exchange then the
 * current thread is disabled for thread scheduling purposes and lies
 * dormant until one of two things happens:
 * <ul>
 * <li>Some other thread enters the exchange; or
 * <li>Some other thread {@linkplain java.lang.Thread#interrupt Thread#interrupt}
 * the current thread.
 * </ul>
 * <p>If the current thread:
 * <ul>
 * <li>has its interrupted status set on entry to this method; or
 * <li>is {@linkplain java.lang.Thread#interrupt Thread#interrupt} while waiting
 * for the exchange,
 * </ul>
 * then {@link java.lang.InterruptedException InterruptedException} is thrown and the current thread's
 * interrupted status is cleared.
 *
 * @param x the object to exchange
 * @return the object provided by the other thread
 * @throws java.lang.InterruptedException if the current thread was
 *         interrupted while waiting
 * @apiSince 1
 */

public V exchange(V x) throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/**
 * Waits for another thread to arrive at this exchange point (unless
 * the current thread is {@linkplain java.lang.Thread#interrupt Thread#interrupt} or
 * the specified waiting time elapses), and then transfers the given
 * object to it, receiving its object in return.
 *
 * <p>If another thread is already waiting at the exchange point then
 * it is resumed for thread scheduling purposes and receives the object
 * passed in by the current thread.  The current thread returns immediately,
 * receiving the object passed to the exchange by that other thread.
 *
 * <p>If no other thread is already waiting at the exchange then the
 * current thread is disabled for thread scheduling purposes and lies
 * dormant until one of three things happens:
 * <ul>
 * <li>Some other thread enters the exchange; or
 * <li>Some other thread {@linkplain java.lang.Thread#interrupt Thread#interrupt}
 * the current thread; or
 * <li>The specified waiting time elapses.
 * </ul>
 * <p>If the current thread:
 * <ul>
 * <li>has its interrupted status set on entry to this method; or
 * <li>is {@linkplain java.lang.Thread#interrupt Thread#interrupt} while waiting
 * for the exchange,
 * </ul>
 * then {@link java.lang.InterruptedException InterruptedException} is thrown and the current thread's
 * interrupted status is cleared.
 *
 * <p>If the specified waiting time elapses then {@link java.util.concurrent.TimeoutException TimeoutException} is thrown.  If the time is less than or equal
 * to zero, the method will not wait at all.
 *
 * @param x the object to exchange
 * @param timeout the maximum time to wait
 * @param unit the time unit of the {@code timeout} argument
 * @return the object provided by the other thread
 * @throws java.lang.InterruptedException if the current thread was
 *         interrupted while waiting
 * @throws java.util.concurrent.TimeoutException if the specified waiting time elapses
 *         before another thread enters the exchange
 * @apiSince 1
 */

public V exchange(V x, long timeout, java.util.concurrent.TimeUnit unit) throws java.lang.InterruptedException, java.util.concurrent.TimeoutException { throw new RuntimeException("Stub!"); }
}

