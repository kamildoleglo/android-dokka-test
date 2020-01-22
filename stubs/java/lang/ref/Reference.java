/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 1997, 2017, Oracle and/or its affiliates. All rights reserved.
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



package java.lang.ref;


/**
 * Abstract base class for reference objects.  This class defines the
 * operations common to all reference objects.  Because reference objects are
 * implemented in close cooperation with the garbage collector, this class may
 * not be subclassed directly.
 *
 * @author   Mark Reinhold
 * @since    1.2
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class Reference<T> {

Reference() { throw new RuntimeException("Stub!"); }

/**
 * Returns this reference object's referent.  If this reference object has
 * been cleared, either by the program or by the garbage collector, then
 * this method returns <code>null</code>.
 *
 * @return   The object to which this reference refers, or
 *           <code>null</code> if this reference object has been cleared
 * @apiSince 1
 */

public T get() { throw new RuntimeException("Stub!"); }

/**
 * Clears this reference object.  Invoking this method will not cause this
 * object to be enqueued.
 *
 * <p> This method is invoked only by Java code; when the garbage collector
 * clears references it does so directly, without invoking this method.
 * @apiSince 1
 */

public void clear() { throw new RuntimeException("Stub!"); }

/**
 * Tells whether or not this reference object has been enqueued, either by
 * the program or by the garbage collector.  If this reference object was
 * not registered with a queue when it was created, then this method will
 * always return <code>false</code>.
 *
 * @return   <code>true</code> if and only if this reference object has
 *           been enqueued
 * @apiSince 1
 */

public boolean isEnqueued() { throw new RuntimeException("Stub!"); }

/**
 * Adds this reference object to the queue with which it is registered,
 * if any.
 *
 * <p> This method is invoked only by Java code; when the garbage collector
 * enqueues references it does so directly, without invoking this method.
 *
 * @return   <code>true</code> if this reference object was successfully
 *           enqueued; <code>false</code> if it was already enqueued or if
 *           it was not registered with a queue when it was created
 * @apiSince 1
 */

public boolean enqueue() { throw new RuntimeException("Stub!"); }

/**
 * Ensures that the object referenced by the given reference remains
 * <a href="package-summary.html#reachability"><em>strongly reachable</em></a>,
 * regardless of any prior actions of the program that might otherwise cause
 * the object to become unreachable; thus, the referenced object is not
 * reclaimable by garbage collection at least until after the invocation of
 * this method.  Invocation of this method does not itself initiate garbage
 * collection or finalization.
 *
 * <p> This method establishes an ordering for
 * <a href="package-summary.html#reachability"><em>strong reachability</em></a>
 * with respect to garbage collection.  It controls relations that are
 * otherwise only implicit in a program -- the reachability conditions
 * triggering garbage collection.  This method is designed for use in
 * uncommon situations of premature finalization where using
 * {@code synchronized} blocks or methods, or using other synchronization
 * facilities are not possible or do not provide the desired control.  This
 * method is applicable only when reclamation may have visible effects,
 * which is possible for objects with finalizers (See
 * <a href="https://docs.oracle.com/javase/specs/jls/se8/html/jls-12.html#jls-12.6">
 * Section 12.6 17 of <cite>The Java&trade; Language Specification</cite></a>)
 * that are implemented in ways that rely on ordering control for correctness.
 *
 * @apiNote
 * Finalization may occur whenever the virtual machine detects that no
 * reference to an object will ever be stored in the heap: The garbage
 * collector may reclaim an object even if the fields of that object are
 * still in use, so long as the object has otherwise become unreachable.
 * This may have surprising and undesirable effects in cases such as the
 * following example in which the bookkeeping associated with a class is
 * managed through array indices.  Here, method {@code action} uses a
 * {@code reachabilityFence} to ensure that the {@code Resource} object is
 * not reclaimed before bookkeeping on an associated
 * {@code ExternalResource} has been performed; in particular here, to
 * ensure that the array slot holding the {@code ExternalResource} is not
 * nulled out in method {@link java.lang.Object#finalize Object#finalize}, which may otherwise run
 * concurrently.
 *
 * <pre> {@code
 * class Resource {
 *   private static ExternalResource[] externalResourceArray = ...
 *
 *   int myIndex;
 *   Resource(...) {
 *     myIndex = ...
 *     externalResourceArray[myIndex] = ...;
 *     ...
 *   }
 *   protected void finalize() {
 *     externalResourceArray[myIndex] = null;
 *     ...
 *   }
 *   public void action() {
 *     try {
 *       // ...
 *       int i = myIndex;
 *       Resource.update(externalResourceArray[i]);
 *     } finally {
 *       Reference.reachabilityFence(this);
 *     }
 *   }
 *   private static void update(ExternalResource ext) {
 *     ext.status = ...;
 *   }
 * }}</pre>
 *
 * Here, the invocation of {@code reachabilityFence} is nonintuitively
 * placed <em>after</em> the call to {@code update}, to ensure that the
 * array slot is not nulled out by {@link java.lang.Object#finalize Object#finalize} before the
 * update, even if the call to {@code action} was the last use of this
 * object.  This might be the case if, for example a usage in a user program
 * had the form {@code new Resource().action();} which retains no other
 * reference to this {@code Resource}.  While probably overkill here,
 * {@code reachabilityFence} is placed in a {@code finally} block to ensure
 * that it is invoked across all paths in the method.  In a method with more
 * complex control paths, you might need further precautions to ensure that
 * {@code reachabilityFence} is encountered along all of them.
 *
 * <p> It is sometimes possible to better encapsulate use of
 * {@code reachabilityFence}.  Continuing the above example, if it were
 * acceptable for the call to method {@code update} to proceed even if the
 * finalizer had already executed (nulling out slot), then you could
 * localize use of {@code reachabilityFence}:
 *
 * <pre> {@code
 * public void action2() {
 *   // ...
 *   Resource.update(getExternalResource());
 * }
 * private ExternalResource getExternalResource() {
 *   ExternalResource ext = externalResourceArray[myIndex];
 *   Reference.reachabilityFence(this);
 *   return ext;
 * }}</pre>
 *
 * <p> Method {@code reachabilityFence} is not required in constructions
 * that themselves ensure reachability.  For example, because objects that
 * are locked cannot, in general, be reclaimed, it would suffice if all
 * accesses of the object, in all methods of class {@code Resource}
 * (including {@code finalize}) were enclosed in {@code synchronized (this)}
 * blocks.  (Further, such blocks must not include infinite loops, or
 * themselves be unreachable, which fall into the corner case exceptions to
 * the "in general" disclaimer.)  However, method {@code reachabilityFence}
 * remains a better option in cases where this approach is not as efficient,
 * desirable, or possible; for example because it would encounter deadlock.
 *
 * @param ref the reference. If {@code null}, this method has no effect.
 * @since 9
 * @apiSince 28
 */

public static void reachabilityFence(java.lang.Object ref) { throw new RuntimeException("Stub!"); }
}

