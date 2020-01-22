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
 * Written by Doug Lea with assistance from members of JCP JSR-166
 * Expert Group and released to the public domain, as explained at
 * http://creativecommons.org/publicdomain/zero/1.0/
 */



package java.util.concurrent;


/**
 * A reusable synchronization barrier, similar in functionality to
 * {@link java.util.concurrent.CyclicBarrier CyclicBarrier} and
 * {@link java.util.concurrent.CountDownLatch CountDownLatch}
 * but supporting more flexible usage.
 *
 * <p><b>Registration.</b> Unlike the case for other barriers, the
 * number of parties <em>registered</em> to synchronize on a phaser
 * may vary over time.  Tasks may be registered at any time (using
 * methods {@link #register}, {@link #bulkRegister}, or forms of
 * constructors establishing initial numbers of parties), and
 * optionally deregistered upon any arrival (using {@link
 * #arriveAndDeregister}).  As is the case with most basic
 * synchronization constructs, registration and deregistration affect
 * only internal counts; they do not establish any further internal
 * bookkeeping, so tasks cannot query whether they are registered.
 * (However, you can introduce such bookkeeping by subclassing this
 * class.)
 *
 * <p><b>Synchronization.</b> Like a {@code CyclicBarrier}, a {@code
 * Phaser} may be repeatedly awaited.  Method {@link
 * #arriveAndAwaitAdvance} has effect analogous to {@link
 * java.util.concurrent.CyclicBarrier#await CyclicBarrier.await}. Each
 * generation of a phaser has an associated phase number. The phase
 * number starts at zero, and advances when all parties arrive at the
 * phaser, wrapping around to zero after reaching {@code
 * Integer.MAX_VALUE}. The use of phase numbers enables independent
 * control of actions upon arrival at a phaser and upon awaiting
 * others, via two kinds of methods that may be invoked by any
 * registered party:
 *
 * <ul>
 *
 *   <li><b>Arrival.</b> Methods {@link #arrive} and
 *       {@link #arriveAndDeregister} record arrival.  These methods
 *       do not block, but return an associated <em>arrival phase
 *       number</em>; that is, the phase number of the phaser to which
 *       the arrival applied. When the final party for a given phase
 *       arrives, an optional action is performed and the phase
 *       advances.  These actions are performed by the party
 *       triggering a phase advance, and are arranged by overriding
 *       method {@link #onAdvance(int,int)}, which also controls
 *       termination. Overriding this method is similar to, but more
 *       flexible than, providing a barrier action to a {@code
 *       CyclicBarrier}.
 *
 *   <li><b>Waiting.</b> Method {@link #awaitAdvance} requires an
 *       argument indicating an arrival phase number, and returns when
 *       the phaser advances to (or is already at) a different phase.
 *       Unlike similar constructions using {@code CyclicBarrier},
 *       method {@code awaitAdvance} continues to wait even if the
 *       waiting thread is interrupted. Interruptible and timeout
 *       versions are also available, but exceptions encountered while
 *       tasks wait interruptibly or with timeout do not change the
 *       state of the phaser. If necessary, you can perform any
 *       associated recovery within handlers of those exceptions,
 *       often after invoking {@code forceTermination}.  Phasers may
 *       also be used by tasks executing in a {@link java.util.concurrent.ForkJoinPool ForkJoinPool}.
 *       Progress is ensured if the pool's parallelismLevel can
 *       accommodate the maximum number of simultaneously blocked
 *       parties.
 *
 * </ul>
 *
 * <p><b>Termination.</b> A phaser may enter a <em>termination</em>
 * state, that may be checked using method {@link #isTerminated}. Upon
 * termination, all synchronization methods immediately return without
 * waiting for advance, as indicated by a negative return value.
 * Similarly, attempts to register upon termination have no effect.
 * Termination is triggered when an invocation of {@code onAdvance}
 * returns {@code true}. The default implementation returns {@code
 * true} if a deregistration has caused the number of registered
 * parties to become zero.  As illustrated below, when phasers control
 * actions with a fixed number of iterations, it is often convenient
 * to override this method to cause termination when the current phase
 * number reaches a threshold. Method {@link #forceTermination} is
 * also available to abruptly release waiting threads and allow them
 * to terminate.
 *
 * <p><b>Tiering.</b> Phasers may be <em>tiered</em> (i.e.,
 * constructed in tree structures) to reduce contention. Phasers with
 * large numbers of parties that would otherwise experience heavy
 * synchronization contention costs may instead be set up so that
 * groups of sub-phasers share a common parent.  This may greatly
 * increase throughput even though it incurs greater per-operation
 * overhead.
 *
 * <p>In a tree of tiered phasers, registration and deregistration of
 * child phasers with their parent are managed automatically.
 * Whenever the number of registered parties of a child phaser becomes
 * non-zero (as established in the {@link #Phaser(java.util.concurrent.Phaser,int)}
 * constructor, {@link #register}, or {@link #bulkRegister}), the
 * child phaser is registered with its parent.  Whenever the number of
 * registered parties becomes zero as the result of an invocation of
 * {@link #arriveAndDeregister}, the child phaser is deregistered
 * from its parent.
 *
 * <p><b>Monitoring.</b> While synchronization methods may be invoked
 * only by registered parties, the current state of a phaser may be
 * monitored by any caller.  At any given moment there are {@link
 * #getRegisteredParties} parties in total, of which {@link
 * #getArrivedParties} have arrived at the current phase ({@link
 * #getPhase}).  When the remaining ({@link #getUnarrivedParties})
 * parties arrive, the phase advances.  The values returned by these
 * methods may reflect transient states and so are not in general
 * useful for synchronization control.  Method {@link #toString}
 * returns snapshots of these state queries in a form convenient for
 * informal monitoring.
 *
 * <p><b>Sample usages:</b>
 *
 * <p>A {@code Phaser} may be used instead of a {@code CountDownLatch}
 * to control a one-shot action serving a variable number of parties.
 * The typical idiom is for the method setting this up to first
 * register, then start the actions, then deregister, as in:
 *
 * <pre> {@code
 * void runTasks(List<Runnable> tasks) {
 *   final Phaser phaser = new Phaser(1); // "1" to register self
 *   // create and start threads
 *   for (final Runnable task : tasks) {
 *     phaser.register();
 *     new Thread() {
 *       public void run() {
 *         phaser.arriveAndAwaitAdvance(); // await all creation
 *         task.run();
 *       }
 *     }.start();
 *   }
 *
 *   // allow threads to start and deregister self
 *   phaser.arriveAndDeregister();
 * }}</pre>
 *
 * <p>One way to cause a set of threads to repeatedly perform actions
 * for a given number of iterations is to override {@code onAdvance}:
 *
 * <pre> {@code
 * void startTasks(List<Runnable> tasks, final int iterations) {
 *   final Phaser phaser = new Phaser() {
 *     protected boolean onAdvance(int phase, int registeredParties) {
 *       return phase >= iterations || registeredParties == 0;
 *     }
 *   };
 *   phaser.register();
 *   for (final Runnable task : tasks) {
 *     phaser.register();
 *     new Thread() {
 *       public void run() {
 *         do {
 *           task.run();
 *           phaser.arriveAndAwaitAdvance();
 *         } while (!phaser.isTerminated());
 *       }
 *     }.start();
 *   }
 *   phaser.arriveAndDeregister(); // deregister self, don't wait
 * }}</pre>
 *
 * If the main task must later await termination, it
 * may re-register and then execute a similar loop:
 * <pre> {@code
 *   // ...
 *   phaser.register();
 *   while (!phaser.isTerminated())
 *     phaser.arriveAndAwaitAdvance();}</pre>
 *
 * <p>Related constructions may be used to await particular phase numbers
 * in contexts where you are sure that the phase will never wrap around
 * {@code Integer.MAX_VALUE}. For example:
 *
 * <pre> {@code
 * void awaitPhase(Phaser phaser, int phase) {
 *   int p = phaser.register(); // assumes caller not already registered
 *   while (p < phase) {
 *     if (phaser.isTerminated())
 *       // ... deal with unexpected termination
 *     else
 *       p = phaser.arriveAndAwaitAdvance();
 *   }
 *   phaser.arriveAndDeregister();
 * }}</pre>
 *
 *
 * <p>To create a set of {@code n} tasks using a tree of phasers, you
 * could use code of the following form, assuming a Task class with a
 * constructor accepting a {@code Phaser} that it registers with upon
 * construction. After invocation of {@code build(new Task[n], 0, n,
 * new Phaser())}, these tasks could then be started, for example by
 * submitting to a pool:
 *
 * <pre> {@code
 * void build(Task[] tasks, int lo, int hi, Phaser ph) {
 *   if (hi - lo > TASKS_PER_PHASER) {
 *     for (int i = lo; i < hi; i += TASKS_PER_PHASER) {
 *       int j = Math.min(i + TASKS_PER_PHASER, hi);
 *       build(tasks, i, j, new Phaser(ph));
 *     }
 *   } else {
 *     for (int i = lo; i < hi; ++i)
 *       tasks[i] = new Task(ph);
 *       // assumes new Task(ph) performs ph.register()
 *   }
 * }}</pre>
 *
 * The best value of {@code TASKS_PER_PHASER} depends mainly on
 * expected synchronization rates. A value as low as four may
 * be appropriate for extremely small per-phase task bodies (thus
 * high rates), or up to hundreds for extremely large ones.
 *
 * <p><b>Implementation notes</b>: This implementation restricts the
 * maximum number of parties to 65535. Attempts to register additional
 * parties result in {@code IllegalStateException}. However, you can and
 * should create tiered phasers to accommodate arbitrarily large sets
 * of participants.
 *
 * @since 1.7
 * @author Doug Lea
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Phaser {

/**
 * Creates a new phaser with no initially registered parties, no
 * parent, and initial phase number 0. Any thread using this
 * phaser will need to first register for it.
 * @apiSince 21
 */

public Phaser() { throw new RuntimeException("Stub!"); }

/**
 * Creates a new phaser with the given number of registered
 * unarrived parties, no parent, and initial phase number 0.
 *
 * @param parties the number of parties required to advance to the
 * next phase
 * @throws java.lang.IllegalArgumentException if parties less than zero
 * or greater than the maximum number of parties supported
 * @apiSince 21
 */

public Phaser(int parties) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to {@link #Phaser(java.util.concurrent.Phaser,int) Phaser(parent, 0)}.
 *
 * @param parent the parent phaser
 * @apiSince 21
 */

public Phaser(java.util.concurrent.Phaser parent) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new phaser with the given parent and number of
 * registered unarrived parties.  When the given parent is non-null
 * and the given number of parties is greater than zero, this
 * child phaser is registered with its parent.
 *
 * @param parent the parent phaser
 * @param parties the number of parties required to advance to the
 * next phase
 * @throws java.lang.IllegalArgumentException if parties less than zero
 * or greater than the maximum number of parties supported
 * @apiSince 21
 */

public Phaser(java.util.concurrent.Phaser parent, int parties) { throw new RuntimeException("Stub!"); }

/**
 * Adds a new unarrived party to this phaser.  If an ongoing
 * invocation of {@link #onAdvance} is in progress, this method
 * may await its completion before returning.  If this phaser has
 * a parent, and this phaser previously had no registered parties,
 * this child phaser is also registered with its parent. If
 * this phaser is terminated, the attempt to register has
 * no effect, and a negative value is returned.
 *
 * @return the arrival phase number to which this registration
 * applied.  If this value is negative, then this phaser has
 * terminated, in which case registration has no effect.
 * @throws java.lang.IllegalStateException if attempting to register more
 * than the maximum supported number of parties
 * @apiSince 21
 */

public int register() { throw new RuntimeException("Stub!"); }

/**
 * Adds the given number of new unarrived parties to this phaser.
 * If an ongoing invocation of {@link #onAdvance} is in progress,
 * this method may await its completion before returning.  If this
 * phaser has a parent, and the given number of parties is greater
 * than zero, and this phaser previously had no registered
 * parties, this child phaser is also registered with its parent.
 * If this phaser is terminated, the attempt to register has no
 * effect, and a negative value is returned.
 *
 * @param parties the number of additional parties required to
 * advance to the next phase
 * @return the arrival phase number to which this registration
 * applied.  If this value is negative, then this phaser has
 * terminated, in which case registration has no effect.
 * @throws java.lang.IllegalStateException if attempting to register more
 * than the maximum supported number of parties
 * @throws java.lang.IllegalArgumentException if {@code parties < 0}
 * @apiSince 21
 */

public int bulkRegister(int parties) { throw new RuntimeException("Stub!"); }

/**
 * Arrives at this phaser, without waiting for others to arrive.
 *
 * <p>It is a usage error for an unregistered party to invoke this
 * method.  However, this error may result in an {@code
 * IllegalStateException} only upon some subsequent operation on
 * this phaser, if ever.
 *
 * @return the arrival phase number, or a negative value if terminated
 * @throws java.lang.IllegalStateException if not terminated and the number
 * of unarrived parties would become negative
 * @apiSince 21
 */

public int arrive() { throw new RuntimeException("Stub!"); }

/**
 * Arrives at this phaser and deregisters from it without waiting
 * for others to arrive. Deregistration reduces the number of
 * parties required to advance in future phases.  If this phaser
 * has a parent, and deregistration causes this phaser to have
 * zero parties, this phaser is also deregistered from its parent.
 *
 * <p>It is a usage error for an unregistered party to invoke this
 * method.  However, this error may result in an {@code
 * IllegalStateException} only upon some subsequent operation on
 * this phaser, if ever.
 *
 * @return the arrival phase number, or a negative value if terminated
 * @throws java.lang.IllegalStateException if not terminated and the number
 * of registered or unarrived parties would become negative
 * @apiSince 21
 */

public int arriveAndDeregister() { throw new RuntimeException("Stub!"); }

/**
 * Arrives at this phaser and awaits others. Equivalent in effect
 * to {@code awaitAdvance(arrive())}.  If you need to await with
 * interruption or timeout, you can arrange this with an analogous
 * construction using one of the other forms of the {@code
 * awaitAdvance} method.  If instead you need to deregister upon
 * arrival, use {@code awaitAdvance(arriveAndDeregister())}.
 *
 * <p>It is a usage error for an unregistered party to invoke this
 * method.  However, this error may result in an {@code
 * IllegalStateException} only upon some subsequent operation on
 * this phaser, if ever.
 *
 * @return the arrival phase number, or the (negative)
 * {@linkplain #getPhase() current phase} if terminated
 * @throws java.lang.IllegalStateException if not terminated and the number
 * of unarrived parties would become negative
 * @apiSince 21
 */

public int arriveAndAwaitAdvance() { throw new RuntimeException("Stub!"); }

/**
 * Awaits the phase of this phaser to advance from the given phase
 * value, returning immediately if the current phase is not equal
 * to the given phase value or this phaser is terminated.
 *
 * @param phase an arrival phase number, or negative value if
 * terminated; this argument is normally the value returned by a
 * previous call to {@code arrive} or {@code arriveAndDeregister}.
 * @return the next arrival phase number, or the argument if it is
 * negative, or the (negative) {@linkplain #getPhase() current phase}
 * if terminated
 * @apiSince 21
 */

public int awaitAdvance(int phase) { throw new RuntimeException("Stub!"); }

/**
 * Awaits the phase of this phaser to advance from the given phase
 * value, throwing {@code InterruptedException} if interrupted
 * while waiting, or returning immediately if the current phase is
 * not equal to the given phase value or this phaser is
 * terminated.
 *
 * @param phase an arrival phase number, or negative value if
 * terminated; this argument is normally the value returned by a
 * previous call to {@code arrive} or {@code arriveAndDeregister}.
 * @return the next arrival phase number, or the argument if it is
 * negative, or the (negative) {@linkplain #getPhase() current phase}
 * if terminated
 * @throws java.lang.InterruptedException if thread interrupted while waiting
 * @apiSince 21
 */

public int awaitAdvanceInterruptibly(int phase) throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/**
 * Awaits the phase of this phaser to advance from the given phase
 * value or the given timeout to elapse, throwing {@code
 * InterruptedException} if interrupted while waiting, or
 * returning immediately if the current phase is not equal to the
 * given phase value or this phaser is terminated.
 *
 * @param phase an arrival phase number, or negative value if
 * terminated; this argument is normally the value returned by a
 * previous call to {@code arrive} or {@code arriveAndDeregister}.
 * @param timeout how long to wait before giving up, in units of
 *        {@code unit}
 * @param unit a {@code TimeUnit} determining how to interpret the
 *        {@code timeout} parameter
 * @return the next arrival phase number, or the argument if it is
 * negative, or the (negative) {@linkplain #getPhase() current phase}
 * if terminated
 * @throws java.lang.InterruptedException if thread interrupted while waiting
 * @throws java.util.concurrent.TimeoutException if timed out while waiting
 * @apiSince 21
 */

public int awaitAdvanceInterruptibly(int phase, long timeout, java.util.concurrent.TimeUnit unit) throws java.lang.InterruptedException, java.util.concurrent.TimeoutException { throw new RuntimeException("Stub!"); }

/**
 * Forces this phaser to enter termination state.  Counts of
 * registered parties are unaffected.  If this phaser is a member
 * of a tiered set of phasers, then all of the phasers in the set
 * are terminated.  If this phaser is already terminated, this
 * method has no effect.  This method may be useful for
 * coordinating recovery after one or more tasks encounter
 * unexpected exceptions.
 * @apiSince 21
 */

public void forceTermination() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current phase number. The maximum phase number is
 * {@code Integer.MAX_VALUE}, after which it restarts at
 * zero. Upon termination, the phase number is negative,
 * in which case the prevailing phase prior to termination
 * may be obtained via {@code getPhase() + Integer.MIN_VALUE}.
 *
 * @return the phase number, or a negative value if terminated
 * @apiSince 21
 */

public final int getPhase() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of parties registered at this phaser.
 *
 * @return the number of parties
 * @apiSince 21
 */

public int getRegisteredParties() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of registered parties that have arrived at
 * the current phase of this phaser. If this phaser has terminated,
 * the returned value is meaningless and arbitrary.
 *
 * @return the number of arrived parties
 * @apiSince 21
 */

public int getArrivedParties() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of registered parties that have not yet
 * arrived at the current phase of this phaser. If this phaser has
 * terminated, the returned value is meaningless and arbitrary.
 *
 * @return the number of unarrived parties
 * @apiSince 21
 */

public int getUnarrivedParties() { throw new RuntimeException("Stub!"); }

/**
 * Returns the parent of this phaser, or {@code null} if none.
 *
 * @return the parent of this phaser, or {@code null} if none
 * @apiSince 21
 */

public java.util.concurrent.Phaser getParent() { throw new RuntimeException("Stub!"); }

/**
 * Returns the root ancestor of this phaser, which is the same as
 * this phaser if it has no parent.
 *
 * @return the root ancestor of this phaser
 * @apiSince 21
 */

public java.util.concurrent.Phaser getRoot() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if this phaser has been terminated.
 *
 * @return {@code true} if this phaser has been terminated
 * @apiSince 21
 */

public boolean isTerminated() { throw new RuntimeException("Stub!"); }

/**
 * Overridable method to perform an action upon impending phase
 * advance, and to control termination. This method is invoked
 * upon arrival of the party advancing this phaser (when all other
 * waiting parties are dormant).  If this method returns {@code
 * true}, this phaser will be set to a final termination state
 * upon advance, and subsequent calls to {@link #isTerminated}
 * will return true. Any (unchecked) Exception or Error thrown by
 * an invocation of this method is propagated to the party
 * attempting to advance this phaser, in which case no advance
 * occurs.
 *
 * <p>The arguments to this method provide the state of the phaser
 * prevailing for the current transition.  The effects of invoking
 * arrival, registration, and waiting methods on this phaser from
 * within {@code onAdvance} are unspecified and should not be
 * relied on.
 *
 * <p>If this phaser is a member of a tiered set of phasers, then
 * {@code onAdvance} is invoked only for its root phaser on each
 * advance.
 *
 * <p>To support the most common use cases, the default
 * implementation of this method returns {@code true} when the
 * number of registered parties has become zero as the result of a
 * party invoking {@code arriveAndDeregister}.  You can disable
 * this behavior, thus enabling continuation upon future
 * registrations, by overriding this method to always return
 * {@code false}:
 *
 * <pre> {@code
 * Phaser phaser = new Phaser() {
 *   protected boolean onAdvance(int phase, int parties) { return false; }
 * }}</pre>
 *
 * @param phase the current phase number on entry to this method,
 * before this phaser is advanced
 * @param registeredParties the current number of registered parties
 * @return {@code true} if this phaser should terminate
 * @apiSince 21
 */

protected boolean onAdvance(int phase, int registeredParties) { throw new RuntimeException("Stub!"); }

/**
 * Returns a string identifying this phaser, as well as its
 * state.  The state, in brackets, includes the String {@code
 * "phase = "} followed by the phase number, {@code "parties = "}
 * followed by the number of registered parties, and {@code
 * "arrived = "} followed by the number of arrived parties.
 *
 * @return a string identifying this phaser, as well as its state
 * @apiSince 21
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

