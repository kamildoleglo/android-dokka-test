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
 * A {@code CallSite} is a holder for a variable {@link java.lang.invoke.MethodHandle MethodHandle},
 * which is called its {@code target}.
 * An {@code invokedynamic} instruction linked to a {@code CallSite} delegates
 * all calls to the site's current target.
 * A {@code CallSite} may be associated with several {@code invokedynamic}
 * instructions, or it may be "free floating", associated with none.
 * In any case, it may be invoked through an associated method handle
 * called its {@linkplain #dynamicInvoker dynamic invoker}.
 * <p>
 * {@code CallSite} is an abstract class which does not allow
 * direct subclassing by users.  It has three immediate,
 * concrete subclasses that may be either instantiated or subclassed.
 * <ul>
 * <li>If a mutable target is not required, an {@code invokedynamic} instruction
 * may be permanently bound by means of a {@linkplain java.lang.invoke.ConstantCallSite ConstantCallSite}.
 * <li>If a mutable target is required which has volatile variable semantics,
 * because updates to the target must be immediately and reliably witnessed by other threads,
 * a {@linkplain java.lang.invoke.VolatileCallSite VolatileCallSite} may be used.
 * <li>Otherwise, if a mutable target is required,
 * a {@linkplain java.lang.invoke.MutableCallSite MutableCallSite} may be used.
 * </ul>
 * <p>
 * A non-constant call site may be <em>relinked</em> by changing its target.
 * The new target must have the same {@linkplain java.lang.invoke.MethodHandle#type() MethodHandle#type()}
 * as the previous target.
 * Thus, though a call site can be relinked to a series of
 * successive targets, it cannot change its type.
 * <p>
 * Here is a sample use of call sites and bootstrap methods which links every
 * dynamic call site to print its arguments:
 <blockquote><pre>{@code
 static void test() throws Throwable {
   // THE FOLLOWING LINE IS PSEUDOCODE FOR A JVM INSTRUCTION
   InvokeDynamic[#bootstrapDynamic].baz("baz arg", 2, 3.14);
 }
 private static void printArgs(Object... args) {
 System.out.println(java.util.Arrays.deepToString(args));
 }
 private static final MethodHandle printArgs;
 static {
 MethodHandles.Lookup lookup = MethodHandles.lookup();
 Class thisClass = lookup.lookupClass();  // (who am I?)
 printArgs = lookup.findStatic(thisClass,
     "printArgs", MethodType.methodType(void.class, Object[].class));
 }
 private static CallSite bootstrapDynamic(MethodHandles.Lookup caller, String name, MethodType type) {
 // ignore caller and name, but match the type:
 return new ConstantCallSite(printArgs.asType(type));
 }
 }</pre></blockquote>
 * @author John Rose, JSR 292 EG
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class CallSite {

CallSite() { throw new RuntimeException("Stub!"); }

/**
 * Returns the type of this call site's target.
 * Although targets may change, any call site's type is permanent, and can never change to an unequal type.
 * The {@code setTarget} method enforces this invariant by refusing any new target that does
 * not have the previous target's type.
 * @return the type of the current target, which is also the type of any future target
 * @apiSince 26
 */

public java.lang.invoke.MethodType type() { throw new RuntimeException("Stub!"); }

/**
 * Returns the target method of the call site, according to the
 * behavior defined by this call site's specific class.
 * The immediate subclasses of {@code CallSite} document the
 * class-specific behaviors of this method.
 *
 * @return the current linkage state of the call site, its target method handle
 * @see java.lang.invoke.ConstantCallSite
 * @see java.lang.invoke.VolatileCallSite
 * @see #setTarget
 * @see java.lang.invoke.ConstantCallSite#getTarget
 * @see java.lang.invoke.MutableCallSite#getTarget
 * @see java.lang.invoke.VolatileCallSite#getTarget
 * @apiSince 26
 */

public abstract java.lang.invoke.MethodHandle getTarget();

/**
 * Updates the target method of this call site, according to the
 * behavior defined by this call site's specific class.
 * The immediate subclasses of {@code CallSite} document the
 * class-specific behaviors of this method.
 * <p>
 * The type of the new target must be {@linkplain java.lang.invoke.MethodType#equals MethodType#equals}
 * the type of the old target.
 *
 * @param newTarget the new target
 * @throws java.lang.NullPointerException if the proposed new target is null
 * @throws java.lang.invoke.WrongMethodTypeException if the proposed new target
 *         has a method type that differs from the previous target
 * @see java.lang.invoke.CallSite#getTarget
 * @see java.lang.invoke.ConstantCallSite#setTarget
 * @see java.lang.invoke.MutableCallSite#setTarget
 * @see java.lang.invoke.VolatileCallSite#setTarget
 * @apiSince 26
 */

public abstract void setTarget(java.lang.invoke.MethodHandle newTarget);

/**
 * Produces a method handle equivalent to an invokedynamic instruction
 * which has been linked to this call site.
 * <p>
 * This method is equivalent to the following code:
 * <blockquote><pre>{@code
 * MethodHandle getTarget, invoker, result;
 * getTarget = MethodHandles.publicLookup().bind(this, "getTarget", MethodType.methodType(MethodHandle.class));
 * invoker = MethodHandles.exactInvoker(this.type());
 * result = MethodHandles.foldArguments(invoker, getTarget)
 * }</pre></blockquote>
 *
 * @return a method handle which always invokes this call site's current target
 * @apiSince 26
 */

public abstract java.lang.invoke.MethodHandle dynamicInvoker();
}

