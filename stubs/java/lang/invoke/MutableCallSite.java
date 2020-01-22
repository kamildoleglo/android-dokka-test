/*
 * Copyright (c) 2008, 2013, Oracle and/or its affiliates. All rights reserved.
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



package java.lang.invoke;


/**
 * A {@code MutableCallSite} is a {@link java.lang.invoke.CallSite CallSite} whose target variable
 * behaves like an ordinary field.
 * An {@code invokedynamic} instruction linked to a {@code MutableCallSite} delegates
 * all calls to the site's current target.
 * The {@linkplain java.lang.invoke.CallSite#dynamicInvoker CallSite#dynamicInvoker} of a mutable call site
 * also delegates each call to the site's current target.
 * <p>
 * Here is an example of a mutable call site which introduces a
 * state variable into a method handle chain.
 * <!-- JavaDocExamplesTest.testMutableCallSite -->
 * <blockquote><pre>{@code
 MutableCallSite name = new MutableCallSite(MethodType.methodType(String.class));
 MethodHandle MH_name = name.dynamicInvoker();
 MethodType MT_str1 = MethodType.methodType(String.class);
 MethodHandle MH_upcase = MethodHandles.lookup()
   .findVirtual(String.class, "toUpperCase", MT_str1);
 MethodHandle worker1 = MethodHandles.filterReturnValue(MH_name, MH_upcase);
 name.setTarget(MethodHandles.constant(String.class, "Rocky"));
 assertEquals("ROCKY", (String) worker1.invokeExact());
 name.setTarget(MethodHandles.constant(String.class, "Fred"));
 assertEquals("FRED", (String) worker1.invokeExact());
 // (mutation can be continued indefinitely)
 * }</pre></blockquote>
 * <p>
 * The same call site may be used in several places at once.
 * <blockquote><pre>{@code
 MethodType MT_str2 = MethodType.methodType(String.class, String.class);
 MethodHandle MH_cat = lookup().findVirtual(String.class,
 "concat", methodType(String.class, String.class));
 MethodHandle MH_dear = MethodHandles.insertArguments(MH_cat, 1, ", dear?");
 MethodHandle worker2 = MethodHandles.filterReturnValue(MH_name, MH_dear);
 assertEquals("Fred, dear?", (String) worker2.invokeExact());
 name.setTarget(MethodHandles.constant(String.class, "Wilma"));
 assertEquals("WILMA", (String) worker1.invokeExact());
 assertEquals("Wilma, dear?", (String) worker2.invokeExact());
 * }</pre></blockquote>
 * <p>
 * <em>Non-synchronization of target values:</em>
 * A write to a mutable call site's target does not force other threads
 * to become aware of the updated value.  Threads which do not perform
 * suitable synchronization actions relative to the updated call site
 * may cache the old target value and delay their use of the new target
 * value indefinitely.
 * (This is a normal consequence of the Java Memory Model as applied
 * to object fields.)
 * <p>
 * For target values which will be frequently updated, consider using
 * a {@linkplain java.lang.invoke.VolatileCallSite VolatileCallSite} instead.
 * @author John Rose, JSR 292 EG
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class MutableCallSite extends java.lang.invoke.CallSite {

/**
 * Creates a blank call site object with the given method type.
 * The initial target is set to a method handle of the given type
 * which will throw an {@link java.lang.IllegalStateException IllegalStateException} if called.
 * <p>
 * The type of the call site is permanently set to the given type.
 * <p>
 * Before this {@code CallSite} object is returned from a bootstrap method,
 * or invoked in some other manner,
 * it is usually provided with a more useful target method,
 * via a call to {@link java.lang.invoke.CallSite#setTarget(java.lang.invoke.MethodHandle) CallSite#setTarget(MethodHandle)}.
 * @param type the method type that this call site will have
 * @throws java.lang.NullPointerException if the proposed type is null
 * @apiSince 26
 */

public MutableCallSite(java.lang.invoke.MethodType type) { throw new RuntimeException("Stub!"); }

/**
 * Creates a call site object with an initial target method handle.
 * The type of the call site is permanently set to the initial target's type.
 * @param target the method handle that will be the initial target of the call site
 * @throws java.lang.NullPointerException if the proposed target is null
 * @apiSince 26
 */

public MutableCallSite(java.lang.invoke.MethodHandle target) { throw new RuntimeException("Stub!"); }

/**
 * Returns the target method of the call site, which behaves
 * like a normal field of the {@code MutableCallSite}.
 * <p>
 * The interactions of {@code getTarget} with memory are the same
 * as of a read from an ordinary variable, such as an array element or a
 * non-volatile, non-final field.
 * <p>
 * In particular, the current thread may choose to reuse the result
 * of a previous read of the target from memory, and may fail to see
 * a recent update to the target by another thread.
 *
 * @return the linkage state of this call site, a method handle which can change over time
 * @see #setTarget
 * @apiSince 26
 */

public final java.lang.invoke.MethodHandle getTarget() { throw new RuntimeException("Stub!"); }

/**
 * Updates the target method of this call site, as a normal variable.
 * The type of the new target must agree with the type of the old target.
 * <p>
 * The interactions with memory are the same
 * as of a write to an ordinary variable, such as an array element or a
 * non-volatile, non-final field.
 * <p>
 * In particular, unrelated threads may fail to see the updated target
 * until they perform a read from memory.
 * Stronger guarantees can be created by putting appropriate operations
 * into the bootstrap method and/or the target methods used
 * at any given call site.
 *
 * @param newTarget the new target
 * @throws java.lang.NullPointerException if the proposed new target is null
 * @throws java.lang.invoke.WrongMethodTypeException if the proposed new target
 *         has a method type that differs from the previous target
 * @see #getTarget
 * @apiSince 26
 */

public void setTarget(java.lang.invoke.MethodHandle newTarget) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 26
 */

public final java.lang.invoke.MethodHandle dynamicInvoker() { throw new RuntimeException("Stub!"); }
}

