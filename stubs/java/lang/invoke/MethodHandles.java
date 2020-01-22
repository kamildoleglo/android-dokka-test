/*
 * Copyright (c) 2008, 2017, Oracle and/or its affiliates. All rights reserved.
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

import java.lang.reflect.*;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

/**
 * This class consists exclusively of static methods that operate on or return
 * method handles. They fall into several categories:
 * <ul>
 * <li>Lookup methods which help create method handles for methods and fields.
 * <li>Combinator methods, which combine or transform pre-existing method handles into new ones.
 * <li>Other factory methods to create method handles that emulate other common JVM operations or control flow patterns.
 * </ul>
 * <p>
 * @author John Rose, JSR 292 EG
 * @since 1.7
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class MethodHandles {

private MethodHandles() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link java.lang.invoke.MethodHandles.Lookup Lookup} with
 * full capabilities to emulate all supported bytecode behaviors of the caller.
 * These capabilities include <a href="MethodHandles.Lookup.html#privacc">private access</a> to the caller.
 * Factory methods on the lookup object can create
 * <a href="MethodHandleInfo.html#directmh">direct method handles</a>
 * for any member that the caller has access to via bytecodes,
 * including protected and private fields and methods.
 * This lookup object is a <em>capability</em> which may be delegated to trusted agents.
 * Do not store it in place where untrusted code can access it.
 * <p>
 * This method is caller sensitive, which means that it may return different
 * values to different callers.
 * <p>
 * For any given caller class {@code C}, the lookup object returned by this call
 * has equivalent capabilities to any lookup object
 * supplied by the JVM to the bootstrap method of an
 * <a href="package-summary.html#indyinsn">invokedynamic instruction</a>
 * executing in the same caller class {@code C}.
 * @return a lookup object for the caller of this method, with private access
 * @apiSince 26
 */

public static java.lang.invoke.MethodHandles.Lookup lookup() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link java.lang.invoke.MethodHandles.Lookup Lookup} which is trusted minimally.
 * It can only be used to create method handles to
 * publicly accessible fields and methods.
 * <p>
 * As a matter of pure convention, the {@linkplain java.lang.invoke.MethodHandles.Lookup#lookupClass Lookup#lookupClass}
 * of this lookup object will be {@link java.lang.Object}.
 *
 * <p style="font-size:smaller;">
 * <em>Discussion:</em>
 * The lookup class can be changed to any other class {@code C} using an expression of the form
 * {@link java.lang.invoke.MethodHandles.Lookup#in Lookup#in}.
 * Since all classes have equal access to public names,
 * such a change would confer no new access rights.
 * A public lookup object is always subject to
 * <a href="MethodHandles.Lookup.html#secmgr">security manager checks</a>.
 * Also, it cannot access
 * <a href="MethodHandles.Lookup.html#callsens">caller sensitive methods</a>.
 * @return a lookup object which is trusted minimally
 * @apiSince 26
 */

public static java.lang.invoke.MethodHandles.Lookup publicLookup() { throw new RuntimeException("Stub!"); }

/**
 * Performs an unchecked "crack" of a
 * <a href="MethodHandleInfo.html#directmh">direct method handle</a>.
 * The result is as if the user had obtained a lookup object capable enough
 * to crack the target method handle, called
 * {@link java.lang.invoke.MethodHandles.Lookup#revealDirect Lookup.revealDirect}
 * on the target to obtain its symbolic reference, and then called
 * {@link java.lang.invoke.MethodHandleInfo#reflectAs MethodHandleInfo.reflectAs}
 * to resolve the symbolic reference to a member.
 * <p>
 * If there is a security manager, its {@code checkPermission} method
 * is called with a {@code ReflectPermission("suppressAccessChecks")} permission.
 * @param <T> the desired type of the result, either {@link java.lang.reflect.Member Member} or a subtype
 * @param target a direct method handle to crack into symbolic reference components
 * @param expected a class object representing the desired result type {@code T}
 * @return a reference to the method, constructor, or field object
 * @exception java.lang.SecurityException if the caller is not privileged to call {@code setAccessible}
 * @exception java.lang.NullPointerException if either argument is {@code null}
 * @exception java.lang.IllegalArgumentException if the target is not a direct method handle
 * @exception java.lang.ClassCastException if the member is not of the expected type
 * @since 1.8
 * @apiSince 26
 */

public static <T extends java.lang.reflect.Member> T reflectAs(java.lang.Class<T> expected, java.lang.invoke.MethodHandle target) { throw new RuntimeException("Stub!"); }

/**
 * Produces a method handle giving read access to elements of an array.
 * The type of the method handle will have a return type of the array's
 * element type.  Its first argument will be the array type,
 * and the second will be {@code int}.
 * @param arrayClass an array type
 * @return a method handle which can load values from the given array type
 * @throws java.lang.NullPointerException if the argument is null
 * @throws  java.lang.IllegalArgumentException if arrayClass is not an array type
 * @apiSince 26
 */

public static java.lang.invoke.MethodHandle arrayElementGetter(java.lang.Class<?> arrayClass) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Produces a method handle giving write access to elements of an array.
 * The type of the method handle will have a void return type.
 * Its last argument will be the array's element type.
 * The first and second arguments will be the array type and int.
 * @param arrayClass the class of an array
 * @return a method handle which can store values into the array type
 * @throws java.lang.NullPointerException if the argument is null
 * @throws java.lang.IllegalArgumentException if arrayClass is not an array type
 * @apiSince 26
 */

public static java.lang.invoke.MethodHandle arrayElementSetter(java.lang.Class<?> arrayClass) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
    * Produces a method handle which will invoke any method handle of the
    * given {@code type}, with a given number of trailing arguments replaced by
    * a single trailing {@code Object[]} array.
    * The resulting invoker will be a method handle with the following
    * arguments:
    * <ul>
    * <li>a single {@code MethodHandle} target
    * <li>zero or more leading values (counted by {@code leadingArgCount})
    * <li>an {@code Object[]} array containing trailing arguments
    * </ul>
    * <p>
    * The invoker will invoke its target like a call to {@link java.lang.invoke.MethodHandle#invoke MethodHandle#invoke} with
    * the indicated {@code type}.
    * That is, if the target is exactly of the given {@code type}, it will behave
    * like {@code invokeExact}; otherwise it behave as if {@link java.lang.invoke.MethodHandle#asType MethodHandle#asType}
    * is used to convert the target to the required {@code type}.
    * <p>
    * The type of the returned invoker will not be the given {@code type}, but rather
    * will have all parameters except the first {@code leadingArgCount}
    * replaced by a single array of type {@code Object[]}, which will be
    * the final parameter.
    * <p>
    * Before invoking its target, the invoker will spread the final array, apply
    * reference casts as necessary, and unbox and widen primitive arguments.
    * If, when the invoker is called, the supplied array argument does
    * not have the correct number of elements, the invoker will throw
    * an {@link java.lang.IllegalArgumentException IllegalArgumentException} instead of invoking the target.
    * <p>
    * This method is equivalent to the following code (though it may be more efficient):
    * <blockquote><pre>{@code
 MethodHandle invoker = MethodHandles.invoker(type);
 int spreadArgCount = type.parameterCount() - leadingArgCount;
 invoker = invoker.asSpreader(Object[].class, spreadArgCount);
 return invoker;
    * }</pre></blockquote>
    * This method throws no reflective or security exceptions.
    * @param type the desired target type
    * @param leadingArgCount number of fixed arguments, to be passed unchanged to the target
    * @return a method handle suitable for invoking any method handle of the given type
    * @throws java.lang.NullPointerException if {@code type} is null
    * @throws java.lang.IllegalArgumentException if {@code leadingArgCount} is not in
    *                  the range from 0 to {@code type.parameterCount()} inclusive,
    *                  or if the resulting method handle's type would have
    *          <a href="MethodHandle.html#maxarity">too many parameters</a>
    * @apiSince 26
     */

public static java.lang.invoke.MethodHandle spreadInvoker(java.lang.invoke.MethodType type, int leadingArgCount) { throw new RuntimeException("Stub!"); }

/**
 * Produces a special <em>invoker method handle</em> which can be used to
 * invoke any method handle of the given type, as if by {@link java.lang.invoke.MethodHandle#invokeExact MethodHandle#invokeExact}.
 * The resulting invoker will have a type which is
 * exactly equal to the desired type, except that it will accept
 * an additional leading argument of type {@code MethodHandle}.
 * <p>
 * This method is equivalent to the following code (though it may be more efficient):
 * {@code publicLookup().findVirtual(MethodHandle.class, "invokeExact", type)}
 *
 * <p style="font-size:smaller;">
 * <em>Discussion:</em>
 * Invoker method handles can be useful when working with variable method handles
 * of unknown types.
 * For example, to emulate an {@code invokeExact} call to a variable method
 * handle {@code M}, extract its type {@code T},
 * look up the invoker method {@code X} for {@code T},
 * and call the invoker method, as {@code X.invoke(T, A...)}.
 * (It would not work to call {@code X.invokeExact}, since the type {@code T}
 * is unknown.)
 * If spreading, collecting, or other argument transformations are required,
 * they can be applied once to the invoker {@code X} and reused on many {@code M}
 * method handle values, as long as they are compatible with the type of {@code X}.
 * <p style="font-size:smaller;">
 * <em>(Note:  The invoker method is not available via the Core Reflection API.
 * An attempt to call {@linkplain java.lang.reflect.Method#invoke java.lang.reflect.Method.invoke}
 * on the declared {@code invokeExact} or {@code invoke} method will raise an
 * {@link java.lang.UnsupportedOperationException UnsupportedOperationException}.)</em>
 * <p>
 * This method throws no reflective or security exceptions.
 * @param type the desired target type
 * @return a method handle suitable for invoking any method handle of the given type
 * @throws java.lang.IllegalArgumentException if the resulting method handle's type would have
 *          <a href="MethodHandle.html#maxarity">too many parameters</a>
 * @apiSince 26
 */

public static java.lang.invoke.MethodHandle exactInvoker(java.lang.invoke.MethodType type) { throw new RuntimeException("Stub!"); }

/**
 * Produces a special <em>invoker method handle</em> which can be used to
 * invoke any method handle compatible with the given type, as if by {@link java.lang.invoke.MethodHandle#invoke MethodHandle#invoke}.
 * The resulting invoker will have a type which is
 * exactly equal to the desired type, except that it will accept
 * an additional leading argument of type {@code MethodHandle}.
 * <p>
 * Before invoking its target, if the target differs from the expected type,
 * the invoker will apply reference casts as
 * necessary and box, unbox, or widen primitive values, as if by {@link java.lang.invoke.MethodHandle#asType MethodHandle#asType}.
 * Similarly, the return value will be converted as necessary.
 * If the target is a {@linkplain java.lang.invoke.MethodHandle#asVarargsCollector MethodHandle#asVarargsCollector},
 * the required arity conversion will be made, again as if by {@link java.lang.invoke.MethodHandle#asType MethodHandle#asType}.
 * <p>
 * This method is equivalent to the following code (though it may be more efficient):
 * {@code publicLookup().findVirtual(MethodHandle.class, "invoke", type)}
 * <p style="font-size:smaller;">
 * <em>Discussion:</em>
 * A {@linkplain java.lang.invoke.MethodType#genericMethodType MethodType#genericMethodType} is one which
 * mentions only {@code Object} arguments and return values.
 * An invoker for such a type is capable of calling any method handle
 * of the same arity as the general type.
 * <p style="font-size:smaller;">
 * <em>(Note:  The invoker method is not available via the Core Reflection API.
 * An attempt to call {@linkplain java.lang.reflect.Method#invoke java.lang.reflect.Method.invoke}
 * on the declared {@code invokeExact} or {@code invoke} method will raise an
 * {@link java.lang.UnsupportedOperationException UnsupportedOperationException}.)</em>
 * <p>
 * This method throws no reflective or security exceptions.
 * @param type the desired target type
 * @return a method handle suitable for invoking any method handle convertible to the given type
 * @throws java.lang.IllegalArgumentException if the resulting method handle's type would have
 *          <a href="MethodHandle.html#maxarity">too many parameters</a>
 * @apiSince 26
 */

public static java.lang.invoke.MethodHandle invoker(java.lang.invoke.MethodType type) { throw new RuntimeException("Stub!"); }

/**
 * Produces a method handle which adapts the type of the
 * given method handle to a new type by pairwise argument and return type conversion.
 * The original type and new type must have the same number of arguments.
 * The resulting method handle is guaranteed to report a type
 * which is equal to the desired new type.
 * <p>
 * If the original type and new type are equal, returns target.
 * <p>
 * The same conversions are allowed as for {@link java.lang.invoke.MethodHandle#asType MethodHandle#asType},
 * and some additional conversions are also applied if those conversions fail.
 * Given types <em>T0</em>, <em>T1</em>, one of the following conversions is applied
 * if possible, before or instead of any conversions done by {@code asType}:
 * <ul>
 * <li>If <em>T0</em> and <em>T1</em> are references, and <em>T1</em> is an interface type,
 *     then the value of type <em>T0</em> is passed as a <em>T1</em> without a cast.
 *     (This treatment of interfaces follows the usage of the bytecode verifier.)
 * <li>If <em>T0</em> is boolean and <em>T1</em> is another primitive,
 *     the boolean is converted to a byte value, 1 for true, 0 for false.
 *     (This treatment follows the usage of the bytecode verifier.)
 * <li>If <em>T1</em> is boolean and <em>T0</em> is another primitive,
 *     <em>T0</em> is converted to byte via Java casting conversion (JLS 5.5),
 *     and the low order bit of the result is tested, as if by {@code (x & 1) != 0}.
 * <li>If <em>T0</em> and <em>T1</em> are primitives other than boolean,
 *     then a Java casting conversion (JLS 5.5) is applied.
 *     (Specifically, <em>T0</em> will convert to <em>T1</em> by
 *     widening and/or narrowing.)
 * <li>If <em>T0</em> is a reference and <em>T1</em> a primitive, an unboxing
 *     conversion will be applied at runtime, possibly followed
 *     by a Java casting conversion (JLS 5.5) on the primitive value,
 *     possibly followed by a conversion from byte to boolean by testing
 *     the low-order bit.
 * <li>If <em>T0</em> is a reference and <em>T1</em> a primitive,
 *     and if the reference is null at runtime, a zero value is introduced.
 * </ul>
 * @param target the method handle to invoke after arguments are retyped
 * @param newType the expected type of the new method handle
 * @return a method handle which delegates to the target after performing
 *           any necessary argument conversions, and arranges for any
 *           necessary return value conversions
 * @throws java.lang.NullPointerException if either argument is null
 * @throws java.lang.invoke.WrongMethodTypeException if the conversion cannot be made
 * @see java.lang.invoke.MethodHandle#asType
 * @apiSince 26
 */

public static java.lang.invoke.MethodHandle explicitCastArguments(java.lang.invoke.MethodHandle target, java.lang.invoke.MethodType newType) { throw new RuntimeException("Stub!"); }

/**
    * Produces a method handle which adapts the calling sequence of the
    * given method handle to a new type, by reordering the arguments.
    * The resulting method handle is guaranteed to report a type
    * which is equal to the desired new type.
    * <p>
    * The given array controls the reordering.
    * Call {@code #I} the number of incoming parameters (the value
    * {@code newType.parameterCount()}, and call {@code #O} the number
    * of outgoing parameters (the value {@code target.type().parameterCount()}).
    * Then the length of the reordering array must be {@code #O},
    * and each element must be a non-negative number less than {@code #I}.
    * For every {@code N} less than {@code #O}, the {@code N}-th
    * outgoing argument will be taken from the {@code I}-th incoming
    * argument, where {@code I} is {@code reorder[N]}.
    * <p>
    * No argument or return value conversions are applied.
    * The type of each incoming argument, as determined by {@code newType},
    * must be identical to the type of the corresponding outgoing parameter
    * or parameters in the target method handle.
    * The return type of {@code newType} must be identical to the return
    * type of the original target.
    * <p>
    * The reordering array need not specify an actual permutation.
    * An incoming argument will be duplicated if its index appears
    * more than once in the array, and an incoming argument will be dropped
    * if its index does not appear in the array.
    * As in the case of {@link #dropArguments(java.lang.invoke.MethodHandle,int,java.util.List) dropArguments},
    * incoming arguments which are not mentioned in the reordering array
    * are may be any type, as determined only by {@code newType}.
    * <blockquote><pre>{@code
 import static java.lang.invoke.MethodHandles.*;
 import static java.lang.invoke.MethodType.*;
 ...
 MethodType intfn1 = methodType(int.class, int.class);
 MethodType intfn2 = methodType(int.class, int.class, int.class);
 MethodHandle sub = ... (int x, int y) -> (x-y) ...;
 assert(sub.type().equals(intfn2));
 MethodHandle sub1 = permuteArguments(sub, intfn2, 0, 1);
 MethodHandle rsub = permuteArguments(sub, intfn2, 1, 0);
 assert((int)rsub.invokeExact(1, 100) == 99);
 MethodHandle add = ... (int x, int y) -> (x+y) ...;
 assert(add.type().equals(intfn2));
 MethodHandle twice = permuteArguments(add, intfn1, 0, 0);
 assert(twice.type().equals(intfn1));
 assert((int)twice.invokeExact(21) == 42);
    * }</pre></blockquote>
    * @param target the method handle to invoke after arguments are reordered
    * @param newType the expected type of the new method handle
    * @param reorder an index array which controls the reordering
    * @return a method handle which delegates to the target after it
    *           drops unused arguments and moves and/or duplicates the other arguments
    * @throws java.lang.NullPointerException if any argument is null
    * @throws java.lang.IllegalArgumentException if the index array length is not equal to
    *                  the arity of the target, or if any index array element
    *                  not a valid index for a parameter of {@code newType},
    *                  or if two corresponding parameter types in
    *                  {@code target.type()} and {@code newType} are not identical,
    * @apiSince 26
     */

public static java.lang.invoke.MethodHandle permuteArguments(java.lang.invoke.MethodHandle target, java.lang.invoke.MethodType newType, int... reorder) { throw new RuntimeException("Stub!"); }

/**
 * Produces a method handle of the requested return type which returns the given
 * constant value every time it is invoked.
 * <p>
 * Before the method handle is returned, the passed-in value is converted to the requested type.
 * If the requested type is primitive, widening primitive conversions are attempted,
 * else reference conversions are attempted.
 * <p>The returned method handle is equivalent to {@code identity(type).bindTo(value)}.
 * @param type the return type of the desired method handle
 * @param value the value to return
 * @return a method handle of the given return type and no arguments, which always returns the given value
 * @throws java.lang.NullPointerException if the {@code type} argument is null
 * @throws java.lang.ClassCastException if the value cannot be converted to the required return type
 * @throws java.lang.IllegalArgumentException if the given type is {@code void.class}
 * @apiSince 26
 */

public static java.lang.invoke.MethodHandle constant(java.lang.Class<?> type, java.lang.Object value) { throw new RuntimeException("Stub!"); }

/**
 * Produces a method handle which returns its sole argument when invoked.
 * @param type the type of the sole parameter and return value of the desired method handle
 * @return a unary method handle which accepts and returns the given type
 * @throws java.lang.NullPointerException if the argument is null
 * @throws java.lang.IllegalArgumentException if the given type is {@code void.class}
 * @apiSince 26
 */

public static java.lang.invoke.MethodHandle identity(java.lang.Class<?> type) { throw new RuntimeException("Stub!"); }

/**
 * Provides a target method handle with one or more <em>bound arguments</em>
 * in advance of the method handle's invocation.
 * The formal parameters to the target corresponding to the bound
 * arguments are called <em>bound parameters</em>.
 * Returns a new method handle which saves away the bound arguments.
 * When it is invoked, it receives arguments for any non-bound parameters,
 * binds the saved arguments to their corresponding parameters,
 * and calls the original target.
 * <p>
 * The type of the new method handle will drop the types for the bound
 * parameters from the original target type, since the new method handle
 * will no longer require those arguments to be supplied by its callers.
 * <p>
 * Each given argument object must match the corresponding bound parameter type.
 * If a bound parameter type is a primitive, the argument object
 * must be a wrapper, and will be unboxed to produce the primitive value.
 * <p>
 * The {@code pos} argument selects which parameters are to be bound.
 * It may range between zero and <i>N-L</i> (inclusively),
 * where <i>N</i> is the arity of the target method handle
 * and <i>L</i> is the length of the values array.
 * @param target the method handle to invoke after the argument is inserted
 * @param pos where to insert the argument (zero for the first)
 * @param values the series of arguments to insert
 * @return a method handle which inserts an additional argument,
 *         before calling the original method handle
 * @throws java.lang.NullPointerException if the target or the {@code values} array is null
 * @see java.lang.invoke.MethodHandle#bindTo
 * @apiSince 26
 */

public static java.lang.invoke.MethodHandle insertArguments(java.lang.invoke.MethodHandle target, int pos, java.lang.Object... values) { throw new RuntimeException("Stub!"); }

/**
    * Produces a method handle which will discard some dummy arguments
    * before calling some other specified <i>target</i> method handle.
    * The type of the new method handle will be the same as the target's type,
    * except it will also include the dummy argument types,
    * at some given position.
    * <p>
    * The {@code pos} argument may range between zero and <i>N</i>,
    * where <i>N</i> is the arity of the target.
    * If {@code pos} is zero, the dummy arguments will precede
    * the target's real arguments; if {@code pos} is <i>N</i>
    * they will come after.
    * <p>
    * <b>Example:</b>
    * <blockquote><pre>{@code
 import static java.lang.invoke.MethodHandles.*;
 import static java.lang.invoke.MethodType.*;
 ...
 MethodHandle cat = lookup().findVirtual(String.class,
 "concat", methodType(String.class, String.class));
 assertEquals("xy", (String) cat.invokeExact("x", "y"));
 MethodType bigType = cat.type().insertParameterTypes(0, int.class, String.class);
 MethodHandle d0 = dropArguments(cat, 0, bigType.parameterList().subList(0,2));
 assertEquals(bigType, d0.type());
 assertEquals("yz", (String) d0.invokeExact(123, "x", "y", "z"));
    * }</pre></blockquote>
    * <p>
    * This method is also equivalent to the following code:
    * <blockquote><pre>
    * {@link #dropArguments(java.lang.invoke.MethodHandle,int,java.lang.Class...) dropArguments}{@code (target, pos, valueTypes.toArray(new Class[0]))}
    * </pre></blockquote>
    * @param target the method handle to invoke after the arguments are dropped
    * @param valueTypes the type(s) of the argument(s) to drop
    * @param pos position of first argument to drop (zero for the leftmost)
    * @return a method handle which drops arguments of the given types,
    *         before calling the original method handle
    * @throws java.lang.NullPointerException if the target is null,
    *                              or if the {@code valueTypes} list or any of its elements is null
    * @throws java.lang.IllegalArgumentException if any element of {@code valueTypes} is {@code void.class},
    *                  or if {@code pos} is negative or greater than the arity of the target,
    *                  or if the new method handle's type would have too many parameters
    * @apiSince 26
     */

public static java.lang.invoke.MethodHandle dropArguments(java.lang.invoke.MethodHandle target, int pos, java.util.List<java.lang.Class<?>> valueTypes) { throw new RuntimeException("Stub!"); }

/**
    * Produces a method handle which will discard some dummy arguments
    * before calling some other specified <i>target</i> method handle.
    * The type of the new method handle will be the same as the target's type,
    * except it will also include the dummy argument types,
    * at some given position.
    * <p>
    * The {@code pos} argument may range between zero and <i>N</i>,
    * where <i>N</i> is the arity of the target.
    * If {@code pos} is zero, the dummy arguments will precede
    * the target's real arguments; if {@code pos} is <i>N</i>
    * they will come after.
    * <p>
    * <b>Example:</b>
    * <blockquote><pre>{@code
 import static java.lang.invoke.MethodHandles.*;
 import static java.lang.invoke.MethodType.*;
 ...
 MethodHandle cat = lookup().findVirtual(String.class,
 "concat", methodType(String.class, String.class));
 assertEquals("xy", (String) cat.invokeExact("x", "y"));
 MethodHandle d0 = dropArguments(cat, 0, String.class);
 assertEquals("yz", (String) d0.invokeExact("x", "y", "z"));
 MethodHandle d1 = dropArguments(cat, 1, String.class);
 assertEquals("xz", (String) d1.invokeExact("x", "y", "z"));
 MethodHandle d2 = dropArguments(cat, 2, String.class);
 assertEquals("xy", (String) d2.invokeExact("x", "y", "z"));
 MethodHandle d12 = dropArguments(cat, 1, int.class, boolean.class);
 assertEquals("xz", (String) d12.invokeExact("x", 12, true, "z"));
    * }</pre></blockquote>
    * <p>
    * This method is also equivalent to the following code:
    * <blockquote><pre>
    * {@link #dropArguments(java.lang.invoke.MethodHandle,int,java.util.List) dropArguments}{@code (target, pos, Arrays.asList(valueTypes))}
    * </pre></blockquote>
    * @param target the method handle to invoke after the arguments are dropped
    * @param valueTypes the type(s) of the argument(s) to drop
    * @param pos position of first argument to drop (zero for the leftmost)
    * @return a method handle which drops arguments of the given types,
    *         before calling the original method handle
    * @throws java.lang.NullPointerException if the target is null,
    *                              or if the {@code valueTypes} array or any of its elements is null
    * @throws java.lang.IllegalArgumentException if any element of {@code valueTypes} is {@code void.class},
    *                  or if {@code pos} is negative or greater than the arity of the target,
    *                  or if the new method handle's type would have
    *                  <a href="MethodHandle.html#maxarity">too many parameters</a>
    * @apiSince 26
     */

public static java.lang.invoke.MethodHandle dropArguments(java.lang.invoke.MethodHandle target, int pos, java.lang.Class<?>... valueTypes) { throw new RuntimeException("Stub!"); }

/**
    * Adapts a target method handle by pre-processing
    * one or more of its arguments, each with its own unary filter function,
    * and then calling the target with each pre-processed argument
    * replaced by the result of its corresponding filter function.
    * <p>
    * The pre-processing is performed by one or more method handles,
    * specified in the elements of the {@code filters} array.
    * The first element of the filter array corresponds to the {@code pos}
    * argument of the target, and so on in sequence.
    * <p>
    * Null arguments in the array are treated as identity functions,
    * and the corresponding arguments left unchanged.
    * (If there are no non-null elements in the array, the original target is returned.)
    * Each filter is applied to the corresponding argument of the adapter.
    * <p>
    * If a filter {@code F} applies to the {@code N}th argument of
    * the target, then {@code F} must be a method handle which
    * takes exactly one argument.  The type of {@code F}'s sole argument
    * replaces the corresponding argument type of the target
    * in the resulting adapted method handle.
    * The return type of {@code F} must be identical to the corresponding
    * parameter type of the target.
    * <p>
    * It is an error if there are elements of {@code filters}
    * (null or not)
    * which do not correspond to argument positions in the target.
    * <p><b>Example:</b>
    * <blockquote><pre>{@code
 import static java.lang.invoke.MethodHandles.*;
 import static java.lang.invoke.MethodType.*;
 ...
 MethodHandle cat = lookup().findVirtual(String.class,
 "concat", methodType(String.class, String.class));
 MethodHandle upcase = lookup().findVirtual(String.class,
 "toUpperCase", methodType(String.class));
 assertEquals("xy", (String) cat.invokeExact("x", "y"));
 MethodHandle f0 = filterArguments(cat, 0, upcase);
 assertEquals("Xy", (String) f0.invokeExact("x", "y")); // Xy
 MethodHandle f1 = filterArguments(cat, 1, upcase);
 assertEquals("xY", (String) f1.invokeExact("x", "y")); // xY
 MethodHandle f2 = filterArguments(cat, 0, upcase, upcase);
 assertEquals("XY", (String) f2.invokeExact("x", "y")); // XY
    * }</pre></blockquote>
    * <p> Here is pseudocode for the resulting adapter:
    * <blockquote><pre>{@code
    * V target(P... p, A[i]... a[i], B... b);
    * A[i] filter[i](V[i]);
    * T adapter(P... p, V[i]... v[i], B... b) {
    *   return target(p..., f[i](v[i])..., b...);
    * }
    * }</pre></blockquote>
    *
    * @param target the method handle to invoke after arguments are filtered
    * @param pos the position of the first argument to filter
    * @param filters method handles to call initially on filtered arguments
    * @return method handle which incorporates the specified argument filtering logic
    * @throws java.lang.NullPointerException if the target is null
    *                              or if the {@code filters} array is null
    * @throws java.lang.IllegalArgumentException if a non-null element of {@code filters}
    *          does not match a corresponding argument type of target as described above,
    *          or if the {@code pos+filters.length} is greater than {@code target.type().parameterCount()},
    *          or if the resulting method handle's type would have
    *          <a href="MethodHandle.html#maxarity">too many parameters</a>
    * @apiSince 26
     */

public static java.lang.invoke.MethodHandle filterArguments(java.lang.invoke.MethodHandle target, int pos, java.lang.invoke.MethodHandle... filters) { throw new RuntimeException("Stub!"); }

/**
    * Adapts a target method handle by pre-processing
    * a sub-sequence of its arguments with a filter (another method handle).
    * The pre-processed arguments are replaced by the result (if any) of the
    * filter function.
    * The target is then called on the modified (usually shortened) argument list.
    * <p>
    * If the filter returns a value, the target must accept that value as
    * its argument in position {@code pos}, preceded and/or followed by
    * any arguments not passed to the filter.
    * If the filter returns void, the target must accept all arguments
    * not passed to the filter.
    * No arguments are reordered, and a result returned from the filter
    * replaces (in order) the whole subsequence of arguments originally
    * passed to the adapter.
    * <p>
    * The argument types (if any) of the filter
    * replace zero or one argument types of the target, at position {@code pos},
    * in the resulting adapted method handle.
    * The return type of the filter (if any) must be identical to the
    * argument type of the target at position {@code pos}, and that target argument
    * is supplied by the return value of the filter.
    * <p>
    * In all cases, {@code pos} must be greater than or equal to zero, and
    * {@code pos} must also be less than or equal to the target's arity.
    * <p><b>Example:</b>
    * <blockquote><pre>{@code
 import static java.lang.invoke.MethodHandles.*;
 import static java.lang.invoke.MethodType.*;
 ...
 MethodHandle deepToString = publicLookup()
 .findStatic(Arrays.class, "deepToString", methodType(String.class, Object[].class));
 
 MethodHandle ts1 = deepToString.asCollector(String[].class, 1);
 assertEquals("[strange]", (String) ts1.invokeExact("strange"));
 
 MethodHandle ts2 = deepToString.asCollector(String[].class, 2);
 assertEquals("[up, down]", (String) ts2.invokeExact("up", "down"));
 
 MethodHandle ts3 = deepToString.asCollector(String[].class, 3);
 MethodHandle ts3_ts2 = collectArguments(ts3, 1, ts2);
 assertEquals("[top, [up, down], strange]",
            (String) ts3_ts2.invokeExact("top", "up", "down", "strange"));
 
 MethodHandle ts3_ts2_ts1 = collectArguments(ts3_ts2, 3, ts1);
 assertEquals("[top, [up, down], [strange]]",
            (String) ts3_ts2_ts1.invokeExact("top", "up", "down", "strange"));
 
 MethodHandle ts3_ts2_ts3 = collectArguments(ts3_ts2, 1, ts3);
 assertEquals("[top, [[up, down, strange], charm], bottom]",
            (String) ts3_ts2_ts3.invokeExact("top", "up", "down", "strange", "charm", "bottom"));
    * }</pre></blockquote>
    * <p> Here is pseudocode for the resulting adapter:
    * <blockquote><pre>{@code
    * T target(A...,V,C...);
    * V filter(B...);
    * T adapter(A... a,B... b,C... c) {
    *   V v = filter(b...);
    *   return target(a...,v,c...);
    * }
    * // and if the filter has no arguments:
    * T target2(A...,V,C...);
    * V filter2();
    * T adapter2(A... a,C... c) {
    *   V v = filter2();
    *   return target2(a...,v,c...);
    * }
    * // and if the filter has a void return:
    * T target3(A...,C...);
    * void filter3(B...);
    * void adapter3(A... a,B... b,C... c) {
    *   filter3(b...);
    *   return target3(a...,c...);
    * }
    * }</pre></blockquote>
    * <p>
    * A collection adapter {@code collectArguments(mh, 0, coll)} is equivalent to
    * one which first "folds" the affected arguments, and then drops them, in separate
    * steps as follows:
    * <blockquote><pre>{@code
    * mh = MethodHandles.dropArguments(mh, 1, coll.type().parameterList()); //step 2
    * mh = MethodHandles.foldArguments(mh, coll); //step 1
    * }</pre></blockquote>
    * If the target method handle consumes no arguments besides than the result
    * (if any) of the filter {@code coll}, then {@code collectArguments(mh, 0, coll)}
    * is equivalent to {@code filterReturnValue(coll, mh)}.
    * If the filter method handle {@code coll} consumes one argument and produces
    * a non-void result, then {@code collectArguments(mh, N, coll)}
    * is equivalent to {@code filterArguments(mh, N, coll)}.
    * Other equivalences are possible but would require argument permutation.
    *
    * @param target the method handle to invoke after filtering the subsequence of arguments
    * @param pos the position of the first adapter argument to pass to the filter,
    *            and/or the target argument which receives the result of the filter
    * @param filter method handle to call on the subsequence of arguments
    * @return method handle which incorporates the specified argument subsequence filtering logic
    * @throws java.lang.NullPointerException if either argument is null
    * @throws java.lang.IllegalArgumentException if the return type of {@code filter}
    *          is non-void and is not the same as the {@code pos} argument of the target,
    *          or if {@code pos} is not between 0 and the target's arity, inclusive,
    *          or if the resulting method handle's type would have
    *          <a href="MethodHandle.html#maxarity">too many parameters</a>
    * @see java.lang.invoke.MethodHandles#foldArguments
    * @see java.lang.invoke.MethodHandles#filterArguments
    * @see java.lang.invoke.MethodHandles#filterReturnValue
    * @apiSince 26
     */

public static java.lang.invoke.MethodHandle collectArguments(java.lang.invoke.MethodHandle target, int pos, java.lang.invoke.MethodHandle filter) { throw new RuntimeException("Stub!"); }

/**
    * Adapts a target method handle by post-processing
    * its return value (if any) with a filter (another method handle).
    * The result of the filter is returned from the adapter.
    * <p>
    * If the target returns a value, the filter must accept that value as
    * its only argument.
    * If the target returns void, the filter must accept no arguments.
    * <p>
    * The return type of the filter
    * replaces the return type of the target
    * in the resulting adapted method handle.
    * The argument type of the filter (if any) must be identical to the
    * return type of the target.
    * <p><b>Example:</b>
    * <blockquote><pre>{@code
 import static java.lang.invoke.MethodHandles.*;
 import static java.lang.invoke.MethodType.*;
 ...
 MethodHandle cat = lookup().findVirtual(String.class,
 "concat", methodType(String.class, String.class));
 MethodHandle length = lookup().findVirtual(String.class,
 "length", methodType(int.class));
 System.out.println((String) cat.invokeExact("x", "y")); // xy
 MethodHandle f0 = filterReturnValue(cat, length);
 System.out.println((int) f0.invokeExact("x", "y")); // 2
    * }</pre></blockquote>
    * <p> Here is pseudocode for the resulting adapter:
    * <blockquote><pre>{@code
    * V target(A...);
    * T filter(V);
    * T adapter(A... a) {
    *   V v = target(a...);
    *   return filter(v);
    * }
    * // and if the target has a void return:
    * void target2(A...);
    * T filter2();
    * T adapter2(A... a) {
    *   target2(a...);
    *   return filter2();
    * }
    * // and if the filter has a void return:
    * V target3(A...);
    * void filter3(V);
    * void adapter3(A... a) {
    *   V v = target3(a...);
    *   filter3(v);
    * }
    * }</pre></blockquote>
    * @param target the method handle to invoke before filtering the return value
    * @param filter method handle to call on the return value
    * @return method handle which incorporates the specified return value filtering logic
    * @throws java.lang.NullPointerException if either argument is null
    * @throws java.lang.IllegalArgumentException if the argument list of {@code filter}
    *          does not match the return type of target as described above
    * @apiSince 26
     */

public static java.lang.invoke.MethodHandle filterReturnValue(java.lang.invoke.MethodHandle target, java.lang.invoke.MethodHandle filter) { throw new RuntimeException("Stub!"); }

/**
    * Adapts a target method handle by pre-processing
    * some of its arguments, and then calling the target with
    * the result of the pre-processing, inserted into the original
    * sequence of arguments.
    * <p>
    * The pre-processing is performed by {@code combiner}, a second method handle.
    * Of the arguments passed to the adapter, the first {@code N} arguments
    * are copied to the combiner, which is then called.
    * (Here, {@code N} is defined as the parameter count of the combiner.)
    * After this, control passes to the target, with any result
    * from the combiner inserted before the original {@code N} incoming
    * arguments.
    * <p>
    * If the combiner returns a value, the first parameter type of the target
    * must be identical with the return type of the combiner, and the next
    * {@code N} parameter types of the target must exactly match the parameters
    * of the combiner.
    * <p>
    * If the combiner has a void return, no result will be inserted,
    * and the first {@code N} parameter types of the target
    * must exactly match the parameters of the combiner.
    * <p>
    * The resulting adapter is the same type as the target, except that the
    * first parameter type is dropped,
    * if it corresponds to the result of the combiner.
    * <p>
    * (Note that {@link #dropArguments(java.lang.invoke.MethodHandle,int,java.util.List) dropArguments} can be used to remove any arguments
    * that either the combiner or the target does not wish to receive.
    * If some of the incoming arguments are destined only for the combiner,
    * consider using {@link java.lang.invoke.MethodHandle#asCollector MethodHandle#asCollector} instead, since those
    * arguments will not need to be live on the stack on entry to the
    * target.)
    * <p><b>Example:</b>
    * <blockquote><pre>{@code
 import static java.lang.invoke.MethodHandles.*;
 import static java.lang.invoke.MethodType.*;
 ...
 MethodHandle trace = publicLookup().findVirtual(java.io.PrintStream.class,
 "println", methodType(void.class, String.class))
   .bindTo(System.out);
 MethodHandle cat = lookup().findVirtual(String.class,
 "concat", methodType(String.class, String.class));
 assertEquals("boojum", (String) cat.invokeExact("boo", "jum"));
 MethodHandle catTrace = foldArguments(cat, trace);
 // also prints "boo":
 assertEquals("boojum", (String) catTrace.invokeExact("boo", "jum"));
    * }</pre></blockquote>
    * <p> Here is pseudocode for the resulting adapter:
    * <blockquote><pre>{@code
    * // there are N arguments in A...
    * T target(V, A[N]..., B...);
    * V combiner(A...);
    * T adapter(A... a, B... b) {
    *   V v = combiner(a...);
    *   return target(v, a..., b...);
    * }
    * // and if the combiner has a void return:
    * T target2(A[N]..., B...);
    * void combiner2(A...);
    * T adapter2(A... a, B... b) {
    *   combiner2(a...);
    *   return target2(a..., b...);
    * }
    * }</pre></blockquote>
    * @param target the method handle to invoke after arguments are combined
    * @param combiner method handle to call initially on the incoming arguments
    * @return method handle which incorporates the specified argument folding logic
    * @throws java.lang.NullPointerException if either argument is null
    * @throws java.lang.IllegalArgumentException if {@code combiner}'s return type
    *          is non-void and not the same as the first argument type of
    *          the target, or if the initial {@code N} argument types
    *          of the target
    *          (skipping one matching the {@code combiner}'s return type)
    *          are not identical with the argument types of {@code combiner}
    * @apiSince 26
     */

public static java.lang.invoke.MethodHandle foldArguments(java.lang.invoke.MethodHandle target, java.lang.invoke.MethodHandle combiner) { throw new RuntimeException("Stub!"); }

/**
 * Makes a method handle which adapts a target method handle,
 * by guarding it with a test, a boolean-valued method handle.
 * If the guard fails, a fallback handle is called instead.
 * All three method handles must have the same corresponding
 * argument and return types, except that the return type
 * of the test must be boolean, and the test is allowed
 * to have fewer arguments than the other two method handles.
 * <p> Here is pseudocode for the resulting adapter:
 * <blockquote><pre>{@code
 * boolean test(A...);
 * T target(A...,B...);
 * T fallback(A...,B...);
 * T adapter(A... a,B... b) {
 *   if (test(a...))
 *     return target(a..., b...);
 *   else
 *     return fallback(a..., b...);
 * }
 * }</pre></blockquote>
 * Note that the test arguments ({@code a...} in the pseudocode) cannot
 * be modified by execution of the test, and so are passed unchanged
 * from the caller to the target or fallback as appropriate.
 * @param test method handle used for test, must return boolean
 * @param target method handle to call if test passes
 * @param fallback method handle to call if test fails
 * @return method handle which incorporates the specified if/then/else logic
 * @throws java.lang.NullPointerException if any argument is null
 * @throws java.lang.IllegalArgumentException if {@code test} does not return boolean,
 *          or if all three method types do not match (with the return
 *          type of {@code test} changed to match that of the target).
 * @apiSince 26
 */

public static java.lang.invoke.MethodHandle guardWithTest(java.lang.invoke.MethodHandle test, java.lang.invoke.MethodHandle target, java.lang.invoke.MethodHandle fallback) { throw new RuntimeException("Stub!"); }

/**
 * Makes a method handle which adapts a target method handle,
 * by running it inside an exception handler.
 * If the target returns normally, the adapter returns that value.
 * If an exception matching the specified type is thrown, the fallback
 * handle is called instead on the exception, plus the original arguments.
 * <p>
 * The target and handler must have the same corresponding
 * argument and return types, except that handler may omit trailing arguments
 * (similarly to the predicate in {@link #guardWithTest guardWithTest}).
 * Also, the handler must have an extra leading parameter of {@code exType} or a supertype.
 * <p> Here is pseudocode for the resulting adapter:
 * <blockquote><pre>{@code
 * T target(A..., B...);
 * T handler(ExType, A...);
 * T adapter(A... a, B... b) {
 *   try {
 *     return target(a..., b...);
 *   } catch (ExType ex) {
 *     return handler(ex, a...);
 *   }
 * }
 * }</pre></blockquote>
 * Note that the saved arguments ({@code a...} in the pseudocode) cannot
 * be modified by execution of the target, and so are passed unchanged
 * from the caller to the handler, if the handler is invoked.
 * <p>
 * The target and handler must return the same type, even if the handler
 * always throws.  (This might happen, for instance, because the handler
 * is simulating a {@code finally} clause).
 * To create such a throwing handler, compose the handler creation logic
 * with {@link #throwException throwException},
 * in order to create a method handle of the correct return type.
 * @param target method handle to call
 * @param exType the type of exception which the handler will catch
 * @param handler method handle to call if a matching exception is thrown
 * @return method handle which incorporates the specified try/catch logic
 * @throws java.lang.NullPointerException if any argument is null
 * @throws java.lang.IllegalArgumentException if {@code handler} does not accept
 *          the given exception type, or if the method handle types do
 *          not match in their return types and their
 *          corresponding parameters
 * @apiSince 26
 */

public static java.lang.invoke.MethodHandle catchException(java.lang.invoke.MethodHandle target, java.lang.Class<? extends java.lang.Throwable> exType, java.lang.invoke.MethodHandle handler) { throw new RuntimeException("Stub!"); }

/**
 * Produces a method handle which will throw exceptions of the given {@code exType}.
 * The method handle will accept a single argument of {@code exType},
 * and immediately throw it as an exception.
 * The method type will nominally specify a return of {@code returnType}.
 * The return type may be anything convenient:  It doesn't matter to the
 * method handle's behavior, since it will never return normally.
 * @param returnType the return type of the desired method handle
 * @param exType the parameter type of the desired method handle
 * @return method handle which can throw the given exceptions
 * @throws java.lang.NullPointerException if either argument is null
 * @apiSince 26
 */

public static java.lang.invoke.MethodHandle throwException(java.lang.Class<?> returnType, java.lang.Class<? extends java.lang.Throwable> exType) { throw new RuntimeException("Stub!"); }
/**
 * A <em>lookup object</em> is a factory for creating method handles,
 * when the creation requires access checking.
 * Method handles do not perform
 * access checks when they are called, but rather when they are created.
 * Therefore, method handle access
 * restrictions must be enforced when a method handle is created.
 * The caller class against which those restrictions are enforced
 * is known as the {@linkplain #lookupClass lookup class}.
 * <p>
 * A lookup class which needs to create method handles will call
 * {@link #lookup MethodHandles.lookup} to create a factory for itself.
 * When the {@code Lookup} factory object is created, the identity of the lookup class is
 * determined, and securely stored in the {@code Lookup} object.
 * The lookup class (or its delegates) may then use factory methods
 * on the {@code Lookup} object to create method handles for access-checked members.
 * This includes all methods, constructors, and fields which are allowed to the lookup class,
 * even private ones.
 *
 * <h1><a name="lookups"></a>Lookup Factory Methods</h1>
 * The factory methods on a {@code Lookup} object correspond to all major
 * use cases for methods, constructors, and fields.
 * Each method handle created by a factory method is the functional
 * equivalent of a particular <em>bytecode behavior</em>.
 * (Bytecode behaviors are described in section 5.4.3.5 of the Java Virtual Machine Specification.)
 * Here is a summary of the correspondence between these factory methods and
 * the behavior the resulting method handles:
 * <table border=1 cellpadding=5 summary="lookup method behaviors">
 * <tr>
 *     <th><a name="equiv"></a>lookup expression</th>
 *     <th>member</th>
 *     <th>bytecode behavior</th>
 * </tr>
 * <tr>
 *     <td>{@link java.lang.invoke.MethodHandles.Lookup#findGetter lookup.findGetter(C.class,"f",FT.class)}</td>
 *     <td>{@code FT f;}</td><td>{@code (T) this.f;}</td>
 * </tr>
 * <tr>
 *     <td>{@link java.lang.invoke.MethodHandles.Lookup#findStaticGetter lookup.findStaticGetter(C.class,"f",FT.class)}</td>
 *     <td>{@code static}<br>{@code FT f;}</td><td>{@code (T) C.f;}</td>
 * </tr>
 * <tr>
 *     <td>{@link java.lang.invoke.MethodHandles.Lookup#findSetter lookup.findSetter(C.class,"f",FT.class)}</td>
 *     <td>{@code FT f;}</td><td>{@code this.f = x;}</td>
 * </tr>
 * <tr>
 *     <td>{@link java.lang.invoke.MethodHandles.Lookup#findStaticSetter lookup.findStaticSetter(C.class,"f",FT.class)}</td>
 *     <td>{@code static}<br>{@code FT f;}</td><td>{@code C.f = arg;}</td>
 * </tr>
 * <tr>
 *     <td>{@link java.lang.invoke.MethodHandles.Lookup#findVirtual lookup.findVirtual(C.class,"m",MT)}</td>
 *     <td>{@code T m(A*);}</td><td>{@code (T) this.m(arg*);}</td>
 * </tr>
 * <tr>
 *     <td>{@link java.lang.invoke.MethodHandles.Lookup#findStatic lookup.findStatic(C.class,"m",MT)}</td>
 *     <td>{@code static}<br>{@code T m(A*);}</td><td>{@code (T) C.m(arg*);}</td>
 * </tr>
 * <tr>
 *     <td>{@link java.lang.invoke.MethodHandles.Lookup#findSpecial lookup.findSpecial(C.class,"m",MT,this.class)}</td>
 *     <td>{@code T m(A*);}</td><td>{@code (T) super.m(arg*);}</td>
 * </tr>
 * <tr>
 *     <td>{@link java.lang.invoke.MethodHandles.Lookup#findConstructor lookup.findConstructor(C.class,MT)}</td>
 *     <td>{@code C(A*);}</td><td>{@code new C(arg*);}</td>
 * </tr>
 * <tr>
 *     <td>{@link java.lang.invoke.MethodHandles.Lookup#unreflectGetter lookup.unreflectGetter(aField)}</td>
 *     <td>({@code static})?<br>{@code FT f;}</td><td>{@code (FT) aField.get(thisOrNull);}</td>
 * </tr>
 * <tr>
 *     <td>{@link java.lang.invoke.MethodHandles.Lookup#unreflectSetter lookup.unreflectSetter(aField)}</td>
 *     <td>({@code static})?<br>{@code FT f;}</td><td>{@code aField.set(thisOrNull, arg);}</td>
 * </tr>
 * <tr>
 *     <td>{@link java.lang.invoke.MethodHandles.Lookup#unreflect lookup.unreflect(aMethod)}</td>
 *     <td>({@code static})?<br>{@code T m(A*);}</td><td>{@code (T) aMethod.invoke(thisOrNull, arg*);}</td>
 * </tr>
 * <tr>
 *     <td>{@link java.lang.invoke.MethodHandles.Lookup#unreflectConstructor lookup.unreflectConstructor(aConstructor)}</td>
 *     <td>{@code C(A*);}</td><td>{@code (C) aConstructor.newInstance(arg*);}</td>
 * </tr>
 * <tr>
 *     <td>{@link java.lang.invoke.MethodHandles.Lookup#unreflect lookup.unreflect(aMethod)}</td>
 *     <td>({@code static})?<br>{@code T m(A*);}</td><td>{@code (T) aMethod.invoke(thisOrNull, arg*);}</td>
 * </tr>
 * </table>
 *
 * Here, the type {@code C} is the class or interface being searched for a member,
 * documented as a parameter named {@code refc} in the lookup methods.
 * The method type {@code MT} is composed from the return type {@code T}
 * and the sequence of argument types {@code A*}.
 * The constructor also has a sequence of argument types {@code A*} and
 * is deemed to return the newly-created object of type {@code C}.
 * Both {@code MT} and the field type {@code FT} are documented as a parameter named {@code type}.
 * The formal parameter {@code this} stands for the self-reference of type {@code C};
 * if it is present, it is always the leading argument to the method handle invocation.
 * (In the case of some {@code protected} members, {@code this} may be
 * restricted in type to the lookup class; see below.)
 * The name {@code arg} stands for all the other method handle arguments.
 * In the code examples for the Core Reflection API, the name {@code thisOrNull}
 * stands for a null reference if the accessed method or field is static,
 * and {@code this} otherwise.
 * The names {@code aMethod}, {@code aField}, and {@code aConstructor} stand
 * for reflective objects corresponding to the given members.
 * <p>
 * In cases where the given member is of variable arity (i.e., a method or constructor)
 * the returned method handle will also be of {@linkplain java.lang.invoke.MethodHandle#asVarargsCollector MethodHandle#asVarargsCollector}.
 * In all other cases, the returned method handle will be of fixed arity.
 * <p style="font-size:smaller;">
 * <em>Discussion:</em>
 * The equivalence between looked-up method handles and underlying
 * class members and bytecode behaviors
 * can break down in a few ways:
 * <ul style="font-size:smaller;">
 * <li>If {@code C} is not symbolically accessible from the lookup class's loader,
 * the lookup can still succeed, even when there is no equivalent
 * Java expression or bytecoded constant.
 * <li>Likewise, if {@code T} or {@code MT}
 * is not symbolically accessible from the lookup class's loader,
 * the lookup can still succeed.
 * For example, lookups for {@code MethodHandle.invokeExact} and
 * {@code MethodHandle.invoke} will always succeed, regardless of requested type.
 * <li>If there is a security manager installed, it can forbid the lookup
 * on various grounds (<a href="MethodHandles.Lookup.html#secmgr">see below</a>).
 * By contrast, the {@code ldc} instruction on a {@code CONSTANT_MethodHandle}
 * constant is not subject to security manager checks.
 * <li>If the looked-up method has a
 * <a href="MethodHandle.html#maxarity">very large arity</a>,
 * the method handle creation may fail, due to the method handle
 * type having too many parameters.
 * </ul>
 *
 * <h1><a name="access"></a>Access checking</h1>
 * Access checks are applied in the factory methods of {@code Lookup},
 * when a method handle is created.
 * This is a key difference from the Core Reflection API, since
 * {@link java.lang.reflect.Method#invoke java.lang.reflect.Method.invoke}
 * performs access checking against every caller, on every call.
 * <p>
 * All access checks start from a {@code Lookup} object, which
 * compares its recorded lookup class against all requests to
 * create method handles.
 * A single {@code Lookup} object can be used to create any number
 * of access-checked method handles, all checked against a single
 * lookup class.
 * <p>
 * A {@code Lookup} object can be shared with other trusted code,
 * such as a metaobject protocol.
 * A shared {@code Lookup} object delegates the capability
 * to create method handles on private members of the lookup class.
 * Even if privileged code uses the {@code Lookup} object,
 * the access checking is confined to the privileges of the
 * original lookup class.
 * <p>
 * A lookup can fail, because
 * the containing class is not accessible to the lookup class, or
 * because the desired class member is missing, or because the
 * desired class member is not accessible to the lookup class, or
 * because the lookup object is not trusted enough to access the member.
 * In any of these cases, a {@code ReflectiveOperationException} will be
 * thrown from the attempted lookup.  The exact class will be one of
 * the following:
 * <ul>
 * <li>NoSuchMethodException &mdash; if a method is requested but does not exist
 * <li>NoSuchFieldException &mdash; if a field is requested but does not exist
 * <li>IllegalAccessException &mdash; if the member exists but an access check fails
 * </ul>
 * <p>
 * In general, the conditions under which a method handle may be
 * looked up for a method {@code M} are no more restrictive than the conditions
 * under which the lookup class could have compiled, verified, and resolved a call to {@code M}.
 * Where the JVM would raise exceptions like {@code NoSuchMethodError},
 * a method handle lookup will generally raise a corresponding
 * checked exception, such as {@code NoSuchMethodException}.
 * And the effect of invoking the method handle resulting from the lookup
 * is <a href="MethodHandles.Lookup.html#equiv">exactly equivalent</a>
 * to executing the compiled, verified, and resolved call to {@code M}.
 * The same point is true of fields and constructors.
 * <p style="font-size:smaller;">
 * <em>Discussion:</em>
 * Access checks only apply to named and reflected methods,
 * constructors, and fields.
 * Other method handle creation methods, such as
 * {@link java.lang.invoke.MethodHandle#asType MethodHandle#asType},
 * do not require any access checks, and are used
 * independently of any {@code Lookup} object.
 * <p>
 * If the desired member is {@code protected}, the usual JVM rules apply,
 * including the requirement that the lookup class must be either be in the
 * same package as the desired member, or must inherit that member.
 * (See the Java Virtual Machine Specification, sections 4.9.2, 5.4.3.5, and 6.4.)
 * In addition, if the desired member is a non-static field or method
 * in a different package, the resulting method handle may only be applied
 * to objects of the lookup class or one of its subclasses.
 * This requirement is enforced by narrowing the type of the leading
 * {@code this} parameter from {@code C}
 * (which will necessarily be a superclass of the lookup class)
 * to the lookup class itself.
 * <p>
 * The JVM imposes a similar requirement on {@code invokespecial} instruction,
 * that the receiver argument must match both the resolved method <em>and</em>
 * the current class.  Again, this requirement is enforced by narrowing the
 * type of the leading parameter to the resulting method handle.
 * (See the Java Virtual Machine Specification, section 4.10.1.9.)
 * <p>
 * The JVM represents constructors and static initializer blocks as internal methods
 * with special names ({@code "<init>"} and {@code "<clinit>"}).
 * The internal syntax of invocation instructions allows them to refer to such internal
 * methods as if they were normal methods, but the JVM bytecode verifier rejects them.
 * A lookup of such an internal method will produce a {@code NoSuchMethodException}.
 * <p>
 * In some cases, access between nested classes is obtained by the Java compiler by creating
 * an wrapper method to access a private method of another class
 * in the same top-level declaration.
 * For example, a nested class {@code C.D}
 * can access private members within other related classes such as
 * {@code C}, {@code C.D.E}, or {@code C.B},
 * but the Java compiler may need to generate wrapper methods in
 * those related classes.  In such cases, a {@code Lookup} object on
 * {@code C.E} would be unable to those private members.
 * A workaround for this limitation is the {@link java.lang.invoke.MethodHandles.Lookup#in Lookup#in} method,
 * which can transform a lookup on {@code C.E} into one on any of those other
 * classes, without special elevation of privilege.
 * <p>
 * The accesses permitted to a given lookup object may be limited,
 * according to its set of {@link #lookupModes lookupModes},
 * to a subset of members normally accessible to the lookup class.
 * For example, the {@link #publicLookup publicLookup}
 * method produces a lookup object which is only allowed to access
 * public members in public classes.
 * The caller sensitive method {@link #lookup lookup}
 * produces a lookup object with full capabilities relative to
 * its caller class, to emulate all supported bytecode behaviors.
 * Also, the {@link java.lang.invoke.MethodHandles.Lookup#in Lookup#in} method may produce a lookup object
 * with fewer access modes than the original lookup object.
 *
 * <p style="font-size:smaller;">
 * <a name="privacc"></a>
 * <em>Discussion of private access:</em>
 * We say that a lookup has <em>private access</em>
 * if its {@linkplain #lookupModes lookup modes}
 * include the possibility of accessing {@code private} members.
 * As documented in the relevant methods elsewhere,
 * only lookups with private access possess the following capabilities:
 * <ul style="font-size:smaller;">
 * <li>access private fields, methods, and constructors of the lookup class
 * <li>create method handles which invoke <a href="MethodHandles.Lookup.html#callsens">caller sensitive</a> methods,
 *     such as {@code Class.forName}
 * <li>create method handles which {@link java.lang.invoke.MethodHandles.Lookup#findSpecial Lookup#findSpecial} instructions
 * <li>avoid <a href="MethodHandles.Lookup.html#secmgr">package access checks</a>
 *     for classes accessible to the lookup class
 * <li>create {@link java.lang.invoke.MethodHandles.Lookup#in Lookup#in} which have private access to other classes
 *     within the same package member
 * </ul>
 * <p style="font-size:smaller;">
 * Each of these permissions is a consequence of the fact that a lookup object
 * with private access can be securely traced back to an originating class,
 * whose <a href="MethodHandles.Lookup.html#equiv">bytecode behaviors</a> and Java language access permissions
 * can be reliably determined and emulated by method handles.
 *
 * <h1><a name="secmgr"></a>Security manager interactions</h1>
 * Although bytecode instructions can only refer to classes in
 * a related class loader, this API can search for methods in any
 * class, as long as a reference to its {@code Class} object is
 * available.  Such cross-loader references are also possible with the
 * Core Reflection API, and are impossible to bytecode instructions
 * such as {@code invokestatic} or {@code getfield}.
 * There is a {@linkplain java.lang.SecurityManager security manager API}
 * to allow applications to check such cross-loader references.
 * These checks apply to both the {@code MethodHandles.Lookup} API
 * and the Core Reflection API
 * (as found on {@link java.lang.Class Class}).
 * <p>
 * If a security manager is present, member lookups are subject to
 * additional checks.
 * From one to three calls are made to the security manager.
 * Any of these calls can refuse access by throwing a
 * {@link java.lang.SecurityException SecurityException}.
 * Define {@code smgr} as the security manager,
 * {@code lookc} as the lookup class of the current lookup object,
 * {@code refc} as the containing class in which the member
 * is being sought, and {@code defc} as the class in which the
 * member is actually defined.
 * The value {@code lookc} is defined as <em>not present</em>
 * if the current lookup object does not have
 * <a href="MethodHandles.Lookup.html#privacc">private access</a>.
 * The calls are made according to the following rules:
 * <ul>
 * <li><b>Step 1:</b>
 *     If {@code lookc} is not present, or if its class loader is not
 *     the same as or an ancestor of the class loader of {@code refc},
 *     then {@link java.lang.SecurityManager#checkPackageAccess SecurityManager#checkPackageAccess} is called,
 *     where {@code refcPkg} is the package of {@code refc}.
 * <li><b>Step 2:</b>
 *     If the retrieved member is not public and
 *     {@code lookc} is not present, then
 *     {@link java.lang.SecurityManager#checkPermission SecurityManager#checkPermission}
 *     with {@code RuntimePermission("accessDeclaredMembers")} is called.
 * <li><b>Step 3:</b>
 *     If the retrieved member is not public,
 *     and if {@code lookc} is not present,
 *     and if {@code defc} and {@code refc} are different,
 *     then {@link java.lang.SecurityManager#checkPackageAccess SecurityManager#checkPackageAccess} is called,
 *     where {@code defcPkg} is the package of {@code defc}.
 * </ul>
 * Security checks are performed after other access checks have passed.
 * Therefore, the above rules presuppose a member that is public,
 * or else that is being accessed from a lookup class that has
 * rights to access the member.
 *
 * <h1><a name="callsens"></a>Caller sensitive methods</h1>
 * A small number of Java methods have a special property called caller sensitivity.
 * A <em>caller-sensitive</em> method can behave differently depending on the
 * identity of its immediate caller.
 * <p>
 * If a method handle for a caller-sensitive method is requested,
 * the general rules for <a href="MethodHandles.Lookup.html#equiv">bytecode behaviors</a> apply,
 * but they take account of the lookup class in a special way.
 * The resulting method handle behaves as if it were called
 * from an instruction contained in the lookup class,
 * so that the caller-sensitive method detects the lookup class.
 * (By contrast, the invoker of the method handle is disregarded.)
 * Thus, in the case of caller-sensitive methods,
 * different lookup classes may give rise to
 * differently behaving method handles.
 * <p>
 * In cases where the lookup object is
 * {@link #publicLookup publicLookup()},
 * or some other lookup object without
 * <a href="MethodHandles.Lookup.html#privacc">private access</a>,
 * the lookup class is disregarded.
 * In such cases, no caller-sensitive method handle can be created,
 * access is forbidden, and the lookup fails with an
 * {@code IllegalAccessException}.
 * <p style="font-size:smaller;">
 * <em>Discussion:</em>
 * For example, the caller-sensitive method
 * {@link java.lang.Class#forName(String) Class.forName(x)}
 * can return varying classes or throw varying exceptions,
 * depending on the class loader of the class that calls it.
 * A public lookup of {@code Class.forName} will fail, because
 * there is no reasonable way to determine its bytecode behavior.
 * <p style="font-size:smaller;">
 * If an application caches method handles for broad sharing,
 * it should use {@code publicLookup()} to create them.
 * If there is a lookup of {@code Class.forName}, it will fail,
 * and the application must take appropriate action in that case.
 * It may be that a later lookup, perhaps during the invocation of a
 * bootstrap method, can incorporate the specific identity
 * of the caller, making the method accessible.
 * <p style="font-size:smaller;">
 * The function {@code MethodHandles.lookup} is caller sensitive
 * so that there can be a secure foundation for lookups.
 * Nearly all other methods in the JSR 292 API rely on lookup
 * objects to check access requests.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Lookup {

Lookup() { throw new RuntimeException("Stub!"); }

/** Tells which class is performing the lookup.  It is this class against
 *  which checks are performed for visibility and access permissions.
 *  <p>
 *  The class implies a maximum level of access permission,
 *  but the permissions may be additionally limited by the bitmask
 *  {@link #lookupModes lookupModes}, which controls whether non-public members
 *  can be accessed.
 *  @return the lookup class, on behalf of which this lookup object finds members
 * @apiSince 26
 */

public java.lang.Class<?> lookupClass() { throw new RuntimeException("Stub!"); }

/** Tells which access-protection classes of members this lookup object can produce.
 *  The result is a bit-mask of the bits
 *  {@linkplain #PUBLIC PUBLIC (0x01)},
 *  {@linkplain #PRIVATE PRIVATE (0x02)},
 *  {@linkplain #PROTECTED PROTECTED (0x04)},
 *  and {@linkplain #PACKAGE PACKAGE (0x08)}.
 *  <p>
 *  A freshly-created lookup object
 *  on the {@linkplain java.lang.invoke.MethodHandles#lookup() caller's class}
 *  has all possible bits set, since the caller class can access all its own members.
 *  A lookup object on a new lookup class
 *  {@linkplain java.lang.invoke.MethodHandles.Lookup#in created from a previous lookup object}
 *  may have some mode bits set to zero.
 *  The purpose of this is to restrict access via the new lookup object,
 *  so that it can access only names which can be reached by the original
 *  lookup object, and also by the new lookup class.
 *  @return the lookup modes, which limit the kinds of access performed by this lookup object
 * @apiSince 26
 */

public int lookupModes() { throw new RuntimeException("Stub!"); }

/**
 * Creates a lookup on the specified new lookup class.
 * The resulting object will report the specified
 * class as its own {@link #lookupClass lookupClass}.
 * <p>
 * However, the resulting {@code Lookup} object is guaranteed
 * to have no more access capabilities than the original.
 * In particular, access capabilities can be lost as follows:<ul>
 * <li>If the new lookup class differs from the old one,
 * protected members will not be accessible by virtue of inheritance.
 * (Protected members may continue to be accessible because of package sharing.)
 * <li>If the new lookup class is in a different package
 * than the old one, protected and default (package) members will not be accessible.
 * <li>If the new lookup class is not within the same package member
 * as the old one, private members will not be accessible.
 * <li>If the new lookup class is not accessible to the old lookup class,
 * then no members, not even public members, will be accessible.
 * (In all other cases, public members will continue to be accessible.)
 * </ul>
 *
 * @param requestedLookupClass the desired lookup class for the new lookup object
 * @return a lookup object which reports the desired lookup class
 * @throws java.lang.NullPointerException if the argument is null
 * @apiSince 26
 */

public java.lang.invoke.MethodHandles.Lookup in(java.lang.Class<?> requestedLookupClass) { throw new RuntimeException("Stub!"); }

/**
 * Displays the name of the class from which lookups are to be made.
 * (The name is the one reported by {@link java.lang.Class#getName() Class.getName}.)
 * If there are restrictions on the access permitted to this lookup,
 * this is indicated by adding a suffix to the class name, consisting
 * of a slash and a keyword.  The keyword represents the strongest
 * allowed access, and is chosen as follows:
 * <ul>
 * <li>If no access is allowed, the suffix is "/noaccess".
 * <li>If only public access is allowed, the suffix is "/public".
 * <li>If only public and package access are allowed, the suffix is "/package".
 * <li>If only public, package, and private access are allowed, the suffix is "/private".
 * </ul>
 * If none of the above cases apply, it is the case that full
 * access (public, package, private, and protected) is allowed.
 * In this case, no suffix is added.
 * This is true only of an object obtained originally from
 * {@link java.lang.invoke.MethodHandles#lookup MethodHandles.lookup}.
 * Objects created by {@link java.lang.invoke.MethodHandles.Lookup#in Lookup.in}
 * always have restricted access, and will display a suffix.
 * <p>
 * (It may seem strange that protected access should be
 * stronger than private access.  Viewed independently from
 * package access, protected access is the first to be lost,
 * because it requires a direct subclass relationship between
 * caller and callee.)
 * @see #in
 * @apiSince 26
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
        * Produces a method handle for a static method.
        * The type of the method handle will be that of the method.
        * (Since static methods do not take receivers, there is no
        * additional receiver argument inserted into the method handle type,
        * as there would be with {@link #findVirtual findVirtual} or {@link #findSpecial findSpecial}.)
        * The method and all its argument types must be accessible to the lookup object.
        * <p>
        * The returned method handle will have
        * {@linkplain java.lang.invoke.MethodHandle#asVarargsCollector MethodHandle#asVarargsCollector} if and only if
        * the method's variable arity modifier bit ({@code 0x0080}) is set.
        * <p>
        * If the returned method handle is invoked, the method's class will
        * be initialized, if it has not already been initialized.
        * <p><b>Example:</b>
        * <blockquote><pre>{@code
 import static java.lang.invoke.MethodHandles.*;
 import static java.lang.invoke.MethodType.*;
 ...
 MethodHandle MH_asList = publicLookup().findStatic(Arrays.class,
 "asList", methodType(List.class, Object[].class));
 assertEquals("[x, y]", MH_asList.invoke("x", "y").toString());
        * }</pre></blockquote>
        * @param refc the class from which the method is accessed
        * @param name the name of the method
        * @param type the type of the method
        * @return the desired method handle
        * @throws java.lang.NoSuchMethodException if the method does not exist
        * @throws java.lang.IllegalAccessException if access checking fails,
        *                                or if the method is not {@code static},
        *                                or if the method's variable arity modifier bit
        *                                is set and {@code asVarargsCollector} fails
        * @exception java.lang.SecurityException if a security manager is present and it
        *                              <a href="MethodHandles.Lookup.html#secmgr">refuses access</a>
        * @throws java.lang.NullPointerException if any argument is null
        * @apiSince 26
         */

public java.lang.invoke.MethodHandle findStatic(java.lang.Class<?> refc, java.lang.String name, java.lang.invoke.MethodType type) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException { throw new RuntimeException("Stub!"); }

/**
        * Produces a method handle for a virtual method.
        * The type of the method handle will be that of the method,
        * with the receiver type (usually {@code refc}) prepended.
        * The method and all its argument types must be accessible to the lookup object.
        * <p>
        * When called, the handle will treat the first argument as a receiver
        * and dispatch on the receiver's type to determine which method
        * implementation to enter.
        * (The dispatching action is identical with that performed by an
        * {@code invokevirtual} or {@code invokeinterface} instruction.)
        * <p>
        * The first argument will be of type {@code refc} if the lookup
        * class has full privileges to access the member.  Otherwise
        * the member must be {@code protected} and the first argument
        * will be restricted in type to the lookup class.
        * <p>
        * The returned method handle will have
        * {@linkplain java.lang.invoke.MethodHandle#asVarargsCollector MethodHandle#asVarargsCollector} if and only if
        * the method's variable arity modifier bit ({@code 0x0080}) is set.
        * <p>
        * Because of the general <a href="MethodHandles.Lookup.html#equiv">equivalence</a> between {@code invokevirtual}
        * instructions and method handles produced by {@code findVirtual},
        * if the class is {@code MethodHandle} and the name string is
        * {@code invokeExact} or {@code invoke}, the resulting
        * method handle is equivalent to one produced by
        * {@link java.lang.invoke.MethodHandles#exactInvoker MethodHandles.exactInvoker} or
        * {@link java.lang.invoke.MethodHandles#invoker MethodHandles.invoker}
        * with the same {@code type} argument.
        *
        * <b>Example:</b>
        * <blockquote><pre>{@code
 import static java.lang.invoke.MethodHandles.*;
 import static java.lang.invoke.MethodType.*;
 ...
 MethodHandle MH_concat = publicLookup().findVirtual(String.class,
 "concat", methodType(String.class, String.class));
 MethodHandle MH_hashCode = publicLookup().findVirtual(Object.class,
 "hashCode", methodType(int.class));
 MethodHandle MH_hashCode_String = publicLookup().findVirtual(String.class,
 "hashCode", methodType(int.class));
 assertEquals("xy", (String) MH_concat.invokeExact("x", "y"));
 assertEquals("xy".hashCode(), (int) MH_hashCode.invokeExact((Object)"xy"));
 assertEquals("xy".hashCode(), (int) MH_hashCode_String.invokeExact("xy"));
 // interface method:
 MethodHandle MH_subSequence = publicLookup().findVirtual(CharSequence.class,
 "subSequence", methodType(CharSequence.class, int.class, int.class));
 assertEquals("def", MH_subSequence.invoke("abcdefghi", 3, 6).toString());
 // constructor "internal method" must be accessed differently:
 MethodType MT_newString = methodType(void.class); //()V for new String()
 try { assertEquals("impossible", lookup()
       .findVirtual(String.class, "<init>", MT_newString));
 } catch (NoSuchMethodException ex) { } // OK
 MethodHandle MH_newString = publicLookup()
 .findConstructor(String.class, MT_newString);
 assertEquals("", (String) MH_newString.invokeExact());
        * }</pre></blockquote>
        *
        * @param refc the class or interface from which the method is accessed
        * @param name the name of the method
        * @param type the type of the method, with the receiver argument omitted
        * @return the desired method handle
        * @throws java.lang.NoSuchMethodException if the method does not exist
        * @throws java.lang.IllegalAccessException if access checking fails,
        *                                or if the method is {@code static}
        *                                or if the method's variable arity modifier bit
        *                                is set and {@code asVarargsCollector} fails
        * @exception java.lang.SecurityException if a security manager is present and it
        *                              <a href="MethodHandles.Lookup.html#secmgr">refuses access</a>
        * @throws java.lang.NullPointerException if any argument is null
        * @apiSince 26
         */

public java.lang.invoke.MethodHandle findVirtual(java.lang.Class<?> refc, java.lang.String name, java.lang.invoke.MethodType type) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException { throw new RuntimeException("Stub!"); }

/**
        * Produces a method handle which creates an object and initializes it, using
        * the constructor of the specified type.
        * The parameter types of the method handle will be those of the constructor,
        * while the return type will be a reference to the constructor's class.
        * The constructor and all its argument types must be accessible to the lookup object.
        * <p>
        * The requested type must have a return type of {@code void}.
        * (This is consistent with the JVM's treatment of constructor type descriptors.)
        * <p>
        * The returned method handle will have
        * {@linkplain java.lang.invoke.MethodHandle#asVarargsCollector MethodHandle#asVarargsCollector} if and only if
        * the constructor's variable arity modifier bit ({@code 0x0080}) is set.
        * <p>
        * If the returned method handle is invoked, the constructor's class will
        * be initialized, if it has not already been initialized.
        * <p><b>Example:</b>
        * <blockquote><pre>{@code
 import static java.lang.invoke.MethodHandles.*;
 import static java.lang.invoke.MethodType.*;
 ...
 MethodHandle MH_newArrayList = publicLookup().findConstructor(
 ArrayList.class, methodType(void.class, Collection.class));
 Collection orig = Arrays.asList("x", "y");
 Collection copy = (ArrayList) MH_newArrayList.invokeExact(orig);
 assert(orig != copy);
 assertEquals(orig, copy);
 // a variable-arity constructor:
 MethodHandle MH_newProcessBuilder = publicLookup().findConstructor(
 ProcessBuilder.class, methodType(void.class, String[].class));
 ProcessBuilder pb = (ProcessBuilder)
 MH_newProcessBuilder.invoke("x", "y", "z");
 assertEquals("[x, y, z]", pb.command().toString());
        * }</pre></blockquote>
        * @param refc the class or interface from which the method is accessed
        * @param type the type of the method, with the receiver argument omitted, and a void return type
        * @return the desired method handle
        * @throws java.lang.NoSuchMethodException if the constructor does not exist
        * @throws java.lang.IllegalAccessException if access checking fails
        *                                or if the method's variable arity modifier bit
        *                                is set and {@code asVarargsCollector} fails
        * @exception java.lang.SecurityException if a security manager is present and it
        *                              <a href="MethodHandles.Lookup.html#secmgr">refuses access</a>
        * @throws java.lang.NullPointerException if any argument is null
        * @apiSince 26
         */

public java.lang.invoke.MethodHandle findConstructor(java.lang.Class<?> refc, java.lang.invoke.MethodType type) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException { throw new RuntimeException("Stub!"); }

/**
        * Produces an early-bound method handle for a virtual method.
        * It will bypass checks for overriding methods on the receiver,
        * <a href="MethodHandles.Lookup.html#equiv">as if called</a> from an {@code invokespecial}
        * instruction from within the explicitly specified {@code specialCaller}.
        * The type of the method handle will be that of the method,
        * with a suitably restricted receiver type prepended.
        * (The receiver type will be {@code specialCaller} or a subtype.)
        * The method and all its argument types must be accessible
        * to the lookup object.
        * <p>
        * Before method resolution,
        * if the explicitly specified caller class is not identical with the
        * lookup class, or if this lookup object does not have
        * <a href="MethodHandles.Lookup.html#privacc">private access</a>
        * privileges, the access fails.
        * <p>
        * The returned method handle will have
        * {@linkplain java.lang.invoke.MethodHandle#asVarargsCollector MethodHandle#asVarargsCollector} if and only if
        * the method's variable arity modifier bit ({@code 0x0080}) is set.
        * <p style="font-size:smaller;">
        * <em>(Note:  JVM internal methods named {@code "<init>"} are not visible to this API,
        * even though the {@code invokespecial} instruction can refer to them
        * in special circumstances.  Use {@link #findConstructor findConstructor}
        * to access instance initialization methods in a safe manner.)</em>
        * <p><b>Example:</b>
        * <blockquote><pre>{@code
 import static java.lang.invoke.MethodHandles.*;
 import static java.lang.invoke.MethodType.*;
 ...
 static class Listie extends ArrayList {
 public String toString() { return "[wee Listie]"; }
 static Lookup lookup() { return MethodHandles.lookup(); }
 }
 ...
 // no access to constructor via invokeSpecial:
 MethodHandle MH_newListie = Listie.lookup()
 .findConstructor(Listie.class, methodType(void.class));
 Listie l = (Listie) MH_newListie.invokeExact();
 try { assertEquals("impossible", Listie.lookup().findSpecial(
       Listie.class, "<init>", methodType(void.class), Listie.class));
 } catch (NoSuchMethodException ex) { } // OK
 // access to super and self methods via invokeSpecial:
 MethodHandle MH_super = Listie.lookup().findSpecial(
 ArrayList.class, "toString" , methodType(String.class), Listie.class);
 MethodHandle MH_this = Listie.lookup().findSpecial(
 Listie.class, "toString" , methodType(String.class), Listie.class);
 MethodHandle MH_duper = Listie.lookup().findSpecial(
 Object.class, "toString" , methodType(String.class), Listie.class);
 assertEquals("[]", (String) MH_super.invokeExact(l));
 assertEquals(""+l, (String) MH_this.invokeExact(l));
 assertEquals("[]", (String) MH_duper.invokeExact(l)); // ArrayList method
 try { assertEquals("inaccessible", Listie.lookup().findSpecial(
       String.class, "toString", methodType(String.class), Listie.class));
 } catch (IllegalAccessException ex) { } // OK
 Listie subl = new Listie() { public String toString() { return "[subclass]"; } };
 assertEquals(""+l, (String) MH_this.invokeExact(subl)); // Listie method
        * }</pre></blockquote>
        *
        * @param refc the class or interface from which the method is accessed
        * @param name the name of the method (which must not be "&lt;init&gt;")
        * @param type the type of the method, with the receiver argument omitted
        * @param specialCaller the proposed calling class to perform the {@code invokespecial}
        * @return the desired method handle
        * @throws java.lang.NoSuchMethodException if the method does not exist
        * @throws java.lang.IllegalAccessException if access checking fails
        *                                or if the method's variable arity modifier bit
        *                                is set and {@code asVarargsCollector} fails
        * @exception java.lang.SecurityException if a security manager is present and it
        *                              <a href="MethodHandles.Lookup.html#secmgr">refuses access</a>
        * @throws java.lang.NullPointerException if any argument is null
        * @apiSince 26
         */

public java.lang.invoke.MethodHandle findSpecial(java.lang.Class<?> refc, java.lang.String name, java.lang.invoke.MethodType type, java.lang.Class<?> specialCaller) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException { throw new RuntimeException("Stub!"); }

/**
 * Produces a method handle giving read access to a non-static field.
 * The type of the method handle will have a return type of the field's
 * value type.
 * The method handle's single argument will be the instance containing
 * the field.
 * Access checking is performed immediately on behalf of the lookup class.
 * @param refc the class or interface from which the method is accessed
 * @param name the field's name
 * @param type the field's type
 * @return a method handle which can load values from the field
 * @throws java.lang.NoSuchFieldException if the field does not exist
 * @throws java.lang.IllegalAccessException if access checking fails, or if the field is {@code static}
 * @exception java.lang.SecurityException if a security manager is present and it
 *                              <a href="MethodHandles.Lookup.html#secmgr">refuses access</a>
 * @throws java.lang.NullPointerException if any argument is null
 * @apiSince 26
 */

public java.lang.invoke.MethodHandle findGetter(java.lang.Class<?> refc, java.lang.String name, java.lang.Class<?> type) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException { throw new RuntimeException("Stub!"); }

/**
 * Produces a method handle giving write access to a non-static field.
 * The type of the method handle will have a void return type.
 * The method handle will take two arguments, the instance containing
 * the field, and the value to be stored.
 * The second argument will be of the field's value type.
 * Access checking is performed immediately on behalf of the lookup class.
 * @param refc the class or interface from which the method is accessed
 * @param name the field's name
 * @param type the field's type
 * @return a method handle which can store values into the field
 * @throws java.lang.NoSuchFieldException if the field does not exist
 * @throws java.lang.IllegalAccessException if access checking fails, or if the field is {@code static}
 * @exception java.lang.SecurityException if a security manager is present and it
 *                              <a href="MethodHandles.Lookup.html#secmgr">refuses access</a>
 * @throws java.lang.NullPointerException if any argument is null
 * @apiSince 26
 */

public java.lang.invoke.MethodHandle findSetter(java.lang.Class<?> refc, java.lang.String name, java.lang.Class<?> type) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException { throw new RuntimeException("Stub!"); }

/**
 * Produces a method handle giving read access to a static field.
 * The type of the method handle will have a return type of the field's
 * value type.
 * The method handle will take no arguments.
 * Access checking is performed immediately on behalf of the lookup class.
 * <p>
 * If the returned method handle is invoked, the field's class will
 * be initialized, if it has not already been initialized.
 * @param refc the class or interface from which the method is accessed
 * @param name the field's name
 * @param type the field's type
 * @return a method handle which can load values from the field
 * @throws java.lang.NoSuchFieldException if the field does not exist
 * @throws java.lang.IllegalAccessException if access checking fails, or if the field is not {@code static}
 * @exception java.lang.SecurityException if a security manager is present and it
 *                              <a href="MethodHandles.Lookup.html#secmgr">refuses access</a>
 * @throws java.lang.NullPointerException if any argument is null
 * @apiSince 26
 */

public java.lang.invoke.MethodHandle findStaticGetter(java.lang.Class<?> refc, java.lang.String name, java.lang.Class<?> type) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException { throw new RuntimeException("Stub!"); }

/**
 * Produces a method handle giving write access to a static field.
 * The type of the method handle will have a void return type.
 * The method handle will take a single
 * argument, of the field's value type, the value to be stored.
 * Access checking is performed immediately on behalf of the lookup class.
 * <p>
 * If the returned method handle is invoked, the field's class will
 * be initialized, if it has not already been initialized.
 * @param refc the class or interface from which the method is accessed
 * @param name the field's name
 * @param type the field's type
 * @return a method handle which can store values into the field
 * @throws java.lang.NoSuchFieldException if the field does not exist
 * @throws java.lang.IllegalAccessException if access checking fails, or if the field is not {@code static}
 * @exception java.lang.SecurityException if a security manager is present and it
 *                              <a href="MethodHandles.Lookup.html#secmgr">refuses access</a>
 * @throws java.lang.NullPointerException if any argument is null
 * @apiSince 26
 */

public java.lang.invoke.MethodHandle findStaticSetter(java.lang.Class<?> refc, java.lang.String name, java.lang.Class<?> type) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException { throw new RuntimeException("Stub!"); }

/**
        * Produces an early-bound method handle for a non-static method.
        * The receiver must have a supertype {@code defc} in which a method
        * of the given name and type is accessible to the lookup class.
        * The method and all its argument types must be accessible to the lookup object.
        * The type of the method handle will be that of the method,
        * without any insertion of an additional receiver parameter.
        * The given receiver will be bound into the method handle,
        * so that every call to the method handle will invoke the
        * requested method on the given receiver.
        * <p>
        * The returned method handle will have
        * {@linkplain java.lang.invoke.MethodHandle#asVarargsCollector MethodHandle#asVarargsCollector} if and only if
        * the method's variable arity modifier bit ({@code 0x0080}) is set
        * <em>and</em> the trailing array argument is not the only argument.
        * (If the trailing array argument is the only argument,
        * the given receiver value will be bound to it.)
        * <p>
        * This is equivalent to the following code:
        * <blockquote><pre>{@code
 import static java.lang.invoke.MethodHandles.*;
 import static java.lang.invoke.MethodType.*;
 ...
 MethodHandle mh0 = lookup().findVirtual(defc, name, type);
 MethodHandle mh1 = mh0.bindTo(receiver);
 MethodType mt1 = mh1.type();
 if (mh0.isVarargsCollector())
 mh1 = mh1.asVarargsCollector(mt1.parameterType(mt1.parameterCount()-1));
 return mh1;
        * }</pre></blockquote>
        * where {@code defc} is either {@code receiver.getClass()} or a super
        * type of that class, in which the requested method is accessible
        * to the lookup class.
        * (Note that {@code bindTo} does not preserve variable arity.)
        * @param receiver the object from which the method is accessed
        * @param name the name of the method
        * @param type the type of the method, with the receiver argument omitted
        * @return the desired method handle
        * @throws java.lang.NoSuchMethodException if the method does not exist
        * @throws java.lang.IllegalAccessException if access checking fails
        *                                or if the method's variable arity modifier bit
        *                                is set and {@code asVarargsCollector} fails
        * @exception java.lang.SecurityException if a security manager is present and it
        *                              <a href="MethodHandles.Lookup.html#secmgr">refuses access</a>
        * @throws java.lang.NullPointerException if any argument is null
        * @see java.lang.invoke.MethodHandle#bindTo
        * @see #findVirtual
        * @apiSince 26
         */

public java.lang.invoke.MethodHandle bind(java.lang.Object receiver, java.lang.String name, java.lang.invoke.MethodType type) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException { throw new RuntimeException("Stub!"); }

/**
 * Makes a <a href="MethodHandleInfo.html#directmh">direct method handle</a>
 * to <i>m</i>, if the lookup class has permission.
 * If <i>m</i> is non-static, the receiver argument is treated as an initial argument.
 * If <i>m</i> is virtual, overriding is respected on every call.
 * Unlike the Core Reflection API, exceptions are <em>not</em> wrapped.
 * The type of the method handle will be that of the method,
 * with the receiver type prepended (but only if it is non-static).
 * If the method's {@code accessible} flag is not set,
 * access checking is performed immediately on behalf of the lookup class.
 * If <i>m</i> is not public, do not share the resulting handle with untrusted parties.
 * <p>
 * The returned method handle will have
 * {@linkplain java.lang.invoke.MethodHandle#asVarargsCollector MethodHandle#asVarargsCollector} if and only if
 * the method's variable arity modifier bit ({@code 0x0080}) is set.
 * <p>
 * If <i>m</i> is static, and
 * if the returned method handle is invoked, the method's class will
 * be initialized, if it has not already been initialized.
 * @param m the reflected method
 * @return a method handle which can invoke the reflected method
 * @throws java.lang.IllegalAccessException if access checking fails
 *                                or if the method's variable arity modifier bit
 *                                is set and {@code asVarargsCollector} fails
 * @throws java.lang.NullPointerException if the argument is null
 * @apiSince 26
 */

public java.lang.invoke.MethodHandle unreflect(java.lang.reflect.Method m) throws java.lang.IllegalAccessException { throw new RuntimeException("Stub!"); }

/**
 * Produces a method handle for a reflected method.
 * It will bypass checks for overriding methods on the receiver,
 * <a href="MethodHandles.Lookup.html#equiv">as if called</a> from an {@code invokespecial}
 * instruction from within the explicitly specified {@code specialCaller}.
 * The type of the method handle will be that of the method,
 * with a suitably restricted receiver type prepended.
 * (The receiver type will be {@code specialCaller} or a subtype.)
 * If the method's {@code accessible} flag is not set,
 * access checking is performed immediately on behalf of the lookup class,
 * as if {@code invokespecial} instruction were being linked.
 * <p>
 * Before method resolution,
 * if the explicitly specified caller class is not identical with the
 * lookup class, or if this lookup object does not have
 * <a href="MethodHandles.Lookup.html#privacc">private access</a>
 * privileges, the access fails.
 * <p>
 * The returned method handle will have
 * {@linkplain java.lang.invoke.MethodHandle#asVarargsCollector MethodHandle#asVarargsCollector} if and only if
 * the method's variable arity modifier bit ({@code 0x0080}) is set.
 * @param m the reflected method
 * @param specialCaller the class nominally calling the method
 * @return a method handle which can invoke the reflected method
 * @throws java.lang.IllegalAccessException if access checking fails
 *                                or if the method's variable arity modifier bit
 *                                is set and {@code asVarargsCollector} fails
 * @throws java.lang.NullPointerException if any argument is null
 * @apiSince 26
 */

public java.lang.invoke.MethodHandle unreflectSpecial(java.lang.reflect.Method m, java.lang.Class<?> specialCaller) throws java.lang.IllegalAccessException { throw new RuntimeException("Stub!"); }

/**
 * Produces a method handle for a reflected constructor.
 * The type of the method handle will be that of the constructor,
 * with the return type changed to the declaring class.
 * The method handle will perform a {@code newInstance} operation,
 * creating a new instance of the constructor's class on the
 * arguments passed to the method handle.
 * <p>
 * If the constructor's {@code accessible} flag is not set,
 * access checking is performed immediately on behalf of the lookup class.
 * <p>
 * The returned method handle will have
 * {@linkplain java.lang.invoke.MethodHandle#asVarargsCollector MethodHandle#asVarargsCollector} if and only if
 * the constructor's variable arity modifier bit ({@code 0x0080}) is set.
 * <p>
 * If the returned method handle is invoked, the constructor's class will
 * be initialized, if it has not already been initialized.
 * @param c the reflected constructor
 * @return a method handle which can invoke the reflected constructor
 * @throws java.lang.IllegalAccessException if access checking fails
 *                                or if the method's variable arity modifier bit
 *                                is set and {@code asVarargsCollector} fails
 * @throws java.lang.NullPointerException if the argument is null
 * @apiSince 26
 */

public java.lang.invoke.MethodHandle unreflectConstructor(java.lang.reflect.Constructor<?> c) throws java.lang.IllegalAccessException { throw new RuntimeException("Stub!"); }

/**
 * Produces a method handle giving read access to a reflected field.
 * The type of the method handle will have a return type of the field's
 * value type.
 * If the field is static, the method handle will take no arguments.
 * Otherwise, its single argument will be the instance containing
 * the field.
 * If the field's {@code accessible} flag is not set,
 * access checking is performed immediately on behalf of the lookup class.
 * <p>
 * If the field is static, and
 * if the returned method handle is invoked, the field's class will
 * be initialized, if it has not already been initialized.
 * @param f the reflected field
 * @return a method handle which can load values from the reflected field
 * @throws java.lang.IllegalAccessException if access checking fails
 * @throws java.lang.NullPointerException if the argument is null
 * @apiSince 26
 */

public java.lang.invoke.MethodHandle unreflectGetter(java.lang.reflect.Field f) throws java.lang.IllegalAccessException { throw new RuntimeException("Stub!"); }

/**
 * Produces a method handle giving write access to a reflected field.
 * The type of the method handle will have a void return type.
 * If the field is static, the method handle will take a single
 * argument, of the field's value type, the value to be stored.
 * Otherwise, the two arguments will be the instance containing
 * the field, and the value to be stored.
 * If the field's {@code accessible} flag is not set,
 * access checking is performed immediately on behalf of the lookup class.
 * <p>
 * If the field is static, and
 * if the returned method handle is invoked, the field's class will
 * be initialized, if it has not already been initialized.
 * @param f the reflected field
 * @return a method handle which can store values into the reflected field
 * @throws java.lang.IllegalAccessException if access checking fails
 * @throws java.lang.NullPointerException if the argument is null
 * @apiSince 26
 */

public java.lang.invoke.MethodHandle unreflectSetter(java.lang.reflect.Field f) throws java.lang.IllegalAccessException { throw new RuntimeException("Stub!"); }

/**
 * Cracks a <a href="MethodHandleInfo.html#directmh">direct method handle</a>
 * created by this lookup object or a similar one.
 * Security and access checks are performed to ensure that this lookup object
 * is capable of reproducing the target method handle.
 * This means that the cracking may fail if target is a direct method handle
 * but was created by an unrelated lookup object.
 * This can happen if the method handle is <a href="MethodHandles.Lookup.html#callsens">caller sensitive</a>
 * and was created by a lookup object for a different class.
 * @param target a direct method handle to crack into symbolic reference components
 * @return a symbolic reference which can be used to reconstruct this method handle from this lookup object
 * @exception java.lang.SecurityException if a security manager is present and it
 *                              <a href="MethodHandles.Lookup.html#secmgr">refuses access</a>
 * @throws java.lang.IllegalArgumentException if the target is not a direct method handle or if access checking fails
 * @exception java.lang.NullPointerException if the target is {@code null}
 * @see java.lang.invoke.MethodHandleInfo
 * @since 1.8
 * @apiSince 26
 */

public java.lang.invoke.MethodHandleInfo revealDirect(java.lang.invoke.MethodHandle target) { throw new RuntimeException("Stub!"); }

/** A single-bit mask representing {@code package} access (default access),
 *  which may contribute to the result of {@link #lookupModes lookupModes}.
 *  The value is {@code 0x08}, which does not correspond meaningfully to
 *  any particular {@linkplain java.lang.reflect.Modifier modifier bit}.
 * @apiSince 26
 */

public static final int PACKAGE = 8; // 0x8

/** A single-bit mask representing {@code private} access,
 *  which may contribute to the result of {@link #lookupModes lookupModes}.
 *  The value, {@code 0x02}, happens to be the same as the value of the
 *  {@code private} {@linkplain java.lang.reflect.Modifier#PRIVATE modifier bit}.
 * @apiSince 26
 */

public static final int PRIVATE = 2; // 0x2

/** A single-bit mask representing {@code protected} access,
 *  which may contribute to the result of {@link #lookupModes lookupModes}.
 *  The value, {@code 0x04}, happens to be the same as the value of the
 *  {@code protected} {@linkplain java.lang.reflect.Modifier#PROTECTED modifier bit}.
 * @apiSince 26
 */

public static final int PROTECTED = 4; // 0x4

/** A single-bit mask representing {@code public} access,
 *  which may contribute to the result of {@link #lookupModes lookupModes}.
 *  The value, {@code 0x01}, happens to be the same as the value of the
 *  {@code public} {@linkplain java.lang.reflect.Modifier#PUBLIC modifier bit}.
 * @apiSince 26
 */

public static final int PUBLIC = 1; // 0x1
}

}

