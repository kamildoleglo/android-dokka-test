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



package java.lang.invoke;

import java.lang.reflect.*;
import java.util.*;
import java.lang.invoke.MethodHandles.Lookup;

/**
 * A symbolic reference obtained by cracking a direct method handle
 * into its consitutent symbolic parts.
 * To crack a direct method handle, call {@link java.lang.invoke.MethodHandles.Lookup#revealDirect Lookup#revealDirect}.
 * <h1><a name="directmh"></a>Direct Method Handles</h1>
 * A <em>direct method handle</em> represents a method, constructor, or field without
 * any intervening argument bindings or other transformations.
 * The method, constructor, or field referred to by a direct method handle is called
 * its <em>underlying member</em>.
 * Direct method handles may be obtained in any of these ways:
 * <ul>
 * <li>By executing an {@code ldc} instruction on a {@code CONSTANT_MethodHandle} constant.
 *     (See the Java Virtual Machine Specification, sections 4.4.8 and 5.4.3.)
 * <li>By calling one of the <a href="MethodHandles.Lookup.html#lookups">Lookup Factory Methods</a>,
 *     such as {@link java.lang.invoke.MethodHandles.Lookup#findVirtual Lookup#findVirtual},
 *     to resolve a symbolic reference into a method handle.
 *     A symbolic reference consists of a class, name string, and type.
 * <li>By calling the factory method {@link java.lang.invoke.MethodHandles.Lookup#unreflect Lookup#unreflect}
 *     or {@link java.lang.invoke.MethodHandles.Lookup#unreflectSpecial Lookup#unreflectSpecial}
 *     to convert a {@link java.lang.reflect.Method Method} into a method handle.
 * <li>By calling the factory method {@link java.lang.invoke.MethodHandles.Lookup#unreflectConstructor Lookup#unreflectConstructor}
 *     to convert a {@link java.lang.reflect.Constructor Constructor} into a method handle.
 * <li>By calling the factory method {@link java.lang.invoke.MethodHandles.Lookup#unreflectGetter Lookup#unreflectGetter}
 *     or {@link java.lang.invoke.MethodHandles.Lookup#unreflectSetter Lookup#unreflectSetter}
 *     to convert a {@link java.lang.reflect.Field Field} into a method handle.
 * </ul>
 *
 * <h1>Restrictions on Cracking</h1>
 * Given a suitable {@code Lookup} object, it is possible to crack any direct method handle
 * to recover a symbolic reference for the underlying method, constructor, or field.
 * Cracking must be done via a {@code Lookup} object equivalent to that which created
 * the target method handle, or which has enough access permissions to recreate
 * an equivalent method handle.
 * <p>
 * If the underlying method is <a href="MethodHandles.Lookup.html#callsens">caller sensitive</a>,
 * the direct method handle will have been "bound" to a particular caller class, the
 * {@linkplain java.lang.invoke.MethodHandles.Lookup#lookupClass() lookup class}
 * of the lookup object used to create it.
 * Cracking this method handle with a different lookup class will fail
 * even if the underlying method is public (like {@code Class.forName}).
 * <p>
 * The requirement of lookup object matching provides a "fast fail" behavior
 * for programs which may otherwise trust erroneous revelation of a method
 * handle with symbolic information (or caller binding) from an unexpected scope.
 * Use {@link java.lang.invoke.MethodHandles#reflectAs} to override this limitation.
 *
 * <h1><a name="refkinds"></a>Reference kinds</h1>
 * The <a href="MethodHandles.Lookup.html#lookups">Lookup Factory Methods</a>
 * correspond to all major use cases for methods, constructors, and fields.
 * These use cases may be distinguished using small integers as follows:
 * <table border=1 cellpadding=5 summary="reference kinds">
 * <tr><th>reference kind</th><th>descriptive name</th><th>scope</th><th>member</th><th>behavior</th></tr>
 * <tr>
 *     <td>{@code 1}</td><td>{@code REF_getField}</td><td>{@code class}</td>
 *     <td>{@code FT f;}</td><td>{@code (T) this.f;}</td>
 * </tr>
 * <tr>
 *     <td>{@code 2}</td><td>{@code REF_getStatic}</td><td>{@code class} or {@code interface}</td>
 *     <td>{@code static}<br>{@code FT f;}</td><td>{@code (T) C.f;}</td>
 * </tr>
 * <tr>
 *     <td>{@code 3}</td><td>{@code REF_putField}</td><td>{@code class}</td>
 *     <td>{@code FT f;}</td><td>{@code this.f = x;}</td>
 * </tr>
 * <tr>
 *     <td>{@code 4}</td><td>{@code REF_putStatic}</td><td>{@code class}</td>
 *     <td>{@code static}<br>{@code FT f;}</td><td>{@code C.f = arg;}</td>
 * </tr>
 * <tr>
 *     <td>{@code 5}</td><td>{@code REF_invokeVirtual}</td><td>{@code class}</td>
 *     <td>{@code T m(A*);}</td><td>{@code (T) this.m(arg*);}</td>
 * </tr>
 * <tr>
 *     <td>{@code 6}</td><td>{@code REF_invokeStatic}</td><td>{@code class} or {@code interface}</td>
 *     <td>{@code static}<br>{@code T m(A*);}</td><td>{@code (T) C.m(arg*);}</td>
 * </tr>
 * <tr>
 *     <td>{@code 7}</td><td>{@code REF_invokeSpecial}</td><td>{@code class} or {@code interface}</td>
 *     <td>{@code T m(A*);}</td><td>{@code (T) super.m(arg*);}</td>
 * </tr>
 * <tr>
 *     <td>{@code 8}</td><td>{@code REF_newInvokeSpecial}</td><td>{@code class}</td>
 *     <td>{@code C(A*);}</td><td>{@code new C(arg*);}</td>
 * </tr>
 * <tr>
 *     <td>{@code 9}</td><td>{@code REF_invokeInterface}</td><td>{@code interface}</td>
 *     <td>{@code T m(A*);}</td><td>{@code (T) this.m(arg*);}</td>
 * </tr>
 * </table>
 * @since 1.8
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface MethodHandleInfo {

/**
 * Returns the reference kind of the cracked method handle, which in turn
 * determines whether the method handle's underlying member was a constructor, method, or field.
 * See the <a href="MethodHandleInfo.html#refkinds">table above</a> for definitions.
 * @return the integer code for the kind of reference used to access the underlying member
 * @apiSince 26
 */

public int getReferenceKind();

/**
 * Returns the class in which the cracked method handle's underlying member was defined.
 * @return the declaring class of the underlying member
 * @apiSince 26
 */

public java.lang.Class<?> getDeclaringClass();

/**
 * Returns the name of the cracked method handle's underlying member.
 * This is {@code "<init>"} if the underlying member was a constructor,
 * else it is a simple method name or field name.
 * @return the simple name of the underlying member
 * @apiSince 26
 */

public java.lang.String getName();

/**
 * Returns the nominal type of the cracked symbolic reference, expressed as a method type.
 * If the reference is to a constructor, the return type will be {@code void}.
 * If it is to a non-static method, the method type will not mention the {@code this} parameter.
 * If it is to a field and the requested access is to read the field,
 * the method type will have no parameters and return the field type.
 * If it is to a field and the requested access is to write the field,
 * the method type will have one parameter of the field type and return {@code void}.
 * <p>
 * Note that original direct method handle may include a leading {@code this} parameter,
 * or (in the case of a constructor) will replace the {@code void} return type
 * with the constructed class.
 * The nominal type does not include any {@code this} parameter,
 * and (in the case of a constructor) will return {@code void}.
 * @return the type of the underlying member, expressed as a method type
 * @apiSince 26
 */

public java.lang.invoke.MethodType getMethodType();

/**
 * Reflects the underlying member as a method, constructor, or field object.
 * If the underlying member is public, it is reflected as if by
 * {@code getMethod}, {@code getConstructor}, or {@code getField}.
 * Otherwise, it is reflected as if by
 * {@code getDeclaredMethod}, {@code getDeclaredConstructor}, or {@code getDeclaredField}.
 * The underlying member must be accessible to the given lookup object.
 * @param <T> the desired type of the result, either {@link java.lang.reflect.Member Member} or a subtype
 * @param expected a class object representing the desired result type {@code T}
 * @param lookup the lookup object that created this MethodHandleInfo, or one with equivalent access privileges
 * @return a reference to the method, constructor, or field object
 * @exception java.lang.ClassCastException if the member is not of the expected type
 * @exception java.lang.NullPointerException if either argument is {@code null}
 * @exception java.lang.IllegalArgumentException if the underlying member is not accessible to the given lookup object
 * @apiSince 26
 */

public <T extends java.lang.reflect.Member> T reflectAs(java.lang.Class<T> expected, java.lang.invoke.MethodHandles.Lookup lookup);

/**
 * Returns the access modifiers of the underlying member.
 * @return the Java language modifiers for underlying member,
 *         or -1 if the member cannot be accessed
 * @see java.lang.reflect.Modifier
 * @see #reflectAs
 * @apiSince 26
 */

public int getModifiers();

/**
 * Determines if the underlying member was a variable arity method or constructor.
 * Such members are represented by method handles that are varargs collectors.
 * @implSpec
 * This produces a result equivalent to:
 * <pre>{@code
 *     getReferenceKind() >= REF_invokeVirtual && Modifier.isTransient(getModifiers())
 * }</pre>
 *
 *
 * @return {@code true} if and only if the underlying member was declared with variable arity.
 * @apiSince 26
 */

public default boolean isVarArgs() { throw new RuntimeException("Stub!"); }

/**
 * Returns the descriptive name of the given reference kind,
 * as defined in the <a href="MethodHandleInfo.html#refkinds">table above</a>.
 * The conventional prefix "REF_" is omitted.
 * @param referenceKind an integer code for a kind of reference used to access a class member
 * @return a mixed-case string such as {@code "getField"}
 * @exception java.lang.IllegalArgumentException if the argument is not a valid
 *            <a href="MethodHandleInfo.html#refkinds">reference kind number</a>
 * @apiSince 26
 */

public static java.lang.String referenceKindToString(int referenceKind) { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation for a {@code MethodHandleInfo},
 * given the four parts of its symbolic reference.
 * This is defined to be of the form {@code "RK C.N:MT"}, where {@code RK} is the
 * {@linkplain #referenceKindToString reference kind string} for {@code kind},
 * {@code C} is the {@linkplain java.lang.Class#getName name} of {@code defc}
 * {@code N} is the {@code name}, and
 * {@code MT} is the {@code type}.
 * These four values may be obtained from the
 * {@linkplain #getReferenceKind reference kind},
 * {@linkplain #getDeclaringClass declaring class},
 * {@linkplain #getName member name},
 * and {@linkplain #getMethodType method type}
 * of a {@code MethodHandleInfo} object.
 *
 * @implSpec
 * This produces a result equivalent to:
 * <pre>{@code
 *     String.format("%s %s.%s:%s", referenceKindToString(kind), defc.getName(), name, type)
 * }</pre>
 *
 * @param kind the {@linkplain #getReferenceKind reference kind} part of the symbolic reference
 * @param defc the {@linkplain #getDeclaringClass declaring class} part of the symbolic reference
 * @param name the {@linkplain #getName member name} part of the symbolic reference
 * @param type the {@linkplain #getMethodType method type} part of the symbolic reference
 * @return a string of the form {@code "RK C.N:MT"}
 * @exception java.lang.IllegalArgumentException if the first argument is not a valid
 *            <a href="MethodHandleInfo.html#refkinds">reference kind number</a>
 * @exception java.lang.NullPointerException if any reference argument is {@code null}
 * @apiSince 26
 */

public static java.lang.String toString(int kind, java.lang.Class<?> defc, java.lang.String name, java.lang.invoke.MethodType type) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated This internal method was accidentally added to API 26 and must not be used. No
 *             replacement is available but it is possible to replicate using information from
 *             the <a href="MethodHandleInfo.html#refkinds">table above</a>, e.g.
 *             {@code refKind >= 1 && refKind <= 9}. There are no guarantees that this logic
 *             will work if future versions extend the table.
 * @apiSince 26
 * @deprecatedSince 29
 */

@Deprecated
public static boolean refKindIsValid(int refKind) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated This internal method was accidentally added to API 26 and must not be used. No
 *             replacement is available but it is possible to replicate using information from
 *             the <a href="MethodHandleInfo.html#refkinds">table above</a>, e.g.
 *             {@code refKind >= 1 && refKind <= 4}.  There are no guarantees that this logic
 *             will work if future versions extend the table.
 * @apiSince 26
 * @deprecatedSince 29
 */

@Deprecated
public static boolean refKindIsField(int refKind) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated This internal method was accidentally added to API 26 and must not be used. Use
 *             {@link java.lang.invoke.MethodHandleInfo#referenceKindToString(int) MethodHandleInfo#referenceKindToString(int)} instead.
 * @apiSince 26
 * @deprecatedSince 29
 */

@Deprecated
public static java.lang.String refKindName(int refKind) { throw new RuntimeException("Stub!"); }

/**
 * A direct method handle reference kind,
 * as defined in the <a href="MethodHandleInfo.html#refkinds">table above</a>.
 * @apiSince 26
 */

public static final int REF_getField = 1; // 0x1

/** @apiSince 26 */

public static final int REF_getStatic = 2; // 0x2

/** @apiSince 26 */

public static final int REF_invokeInterface = 9; // 0x9

/** @apiSince 26 */

public static final int REF_invokeSpecial = 7; // 0x7

/** @apiSince 26 */

public static final int REF_invokeStatic = 6; // 0x6

/** @apiSince 26 */

public static final int REF_invokeVirtual = 5; // 0x5

/** @apiSince 26 */

public static final int REF_newInvokeSpecial = 8; // 0x8

/** @apiSince 26 */

public static final int REF_putField = 3; // 0x3

/** @apiSince 26 */

public static final int REF_putStatic = 4; // 0x4
}

