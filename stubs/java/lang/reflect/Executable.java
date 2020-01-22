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



package java.lang.reflect;

import java.lang.annotation.Annotation;

/**
 * A shared superclass for the common functionality of {@link java.lang.reflect.Method Method}
 * and {@link java.lang.reflect.Constructor Constructor}.
 *
 * @since 1.8
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class Executable extends java.lang.reflect.AccessibleObject implements java.lang.reflect.Member, java.lang.reflect.GenericDeclaration {

Executable() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@code Class} object representing the class or interface
 * that declares the executable represented by this object.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public abstract java.lang.Class<?> getDeclaringClass();

/**
 * Returns the name of the executable represented by this object.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public abstract java.lang.String getName();

/**
 * Returns the Java language {@linkplain java.lang.reflect.Modifier Modifier} for
 * the executable represented by this object.
 * @apiSince 26
 */

public abstract int getModifiers();

/**
 * Returns an array of {@code TypeVariable} objects that represent the
 * type variables declared by the generic declaration represented by this
 * {@code GenericDeclaration} object, in declaration order.  Returns an
 * array of length 0 if the underlying generic declaration declares no type
 * variables.
 *
 * @return an array of {@code TypeVariable} objects that represent
 *     the type variables declared by this generic declaration
 * @throws java.lang.reflect.GenericSignatureFormatError if the generic
 *     signature of this generic declaration does not conform to
 *     the format specified in
 *     <cite>The Java&trade; Virtual Machine Specification</cite>
 * @apiSince 26
 */

@androidx.annotation.NonNull
public abstract java.lang.reflect.TypeVariable<?>[] getTypeParameters();

/**
 * Returns an array of {@code Class} objects that represent the formal
 * parameter types, in declaration order, of the executable
 * represented by this object.  Returns an array of length
 * 0 if the underlying executable takes no parameters.
 *
 * @return the parameter types for the executable this object
 * represents
 * @apiSince 26
 */

@androidx.annotation.NonNull
public abstract java.lang.Class<?>[] getParameterTypes();

/**
 * Returns the number of formal parameters (whether explicitly
 * declared or implicitly declared or neither) for the executable
 * represented by this object.
 *
 * @return The number of formal parameters for the executable this
 * object represents
 * @apiSince 26
 */

public int getParameterCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns an array of {@code Type} objects that represent the formal
 * parameter types, in declaration order, of the executable represented by
 * this object. Returns an array of length 0 if the
 * underlying executable takes no parameters.
 *
 * <p>If a formal parameter type is a parameterized type,
 * the {@code Type} object returned for it must accurately reflect
 * the actual type parameters used in the source code.
 *
 * <p>If a formal parameter type is a type variable or a parameterized
 * type, it is created. Otherwise, it is resolved.
 *
 * @return an array of {@code Type}s that represent the formal
 *     parameter types of the underlying executable, in declaration order
 * @throws java.lang.reflect.GenericSignatureFormatError
 *     if the generic method signature does not conform to the format
 *     specified in
 *     <cite>The Java&trade; Virtual Machine Specification</cite>
 * @throws java.lang.TypeNotPresentException if any of the parameter
 *     types of the underlying executable refers to a non-existent type
 *     declaration
 * @throws java.lang.reflect.MalformedParameterizedTypeException if any of
 *     the underlying executable's parameter types refer to a parameterized
 *     type that cannot be instantiated for any reason
 * @apiSince 26
 */

@androidx.annotation.NonNull
public java.lang.reflect.Type[] getGenericParameterTypes() { throw new RuntimeException("Stub!"); }

/**
 * Returns an array of {@code Parameter} objects that represent
 * all the parameters to the underlying executable represented by
 * this object.  Returns an array of length 0 if the executable
 * has no parameters.
 *
 * <p>The parameters of the underlying executable do not necessarily
 * have unique names, or names that are legal identifiers in the
 * Java programming language (JLS 3.8).
 *
 * @throws java.lang.reflect.MalformedParametersException if the class file contains
 * a MethodParameters attribute that is improperly formatted.
 * @return an array of {@code Parameter} objects representing all
 * the parameters to the executable this object represents.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public java.lang.reflect.Parameter[] getParameters() { throw new RuntimeException("Stub!"); }

/**
 * Returns an array of {@code Class} objects that represent the
 * types of exceptions declared to be thrown by the underlying
 * executable represented by this object.  Returns an array of
 * length 0 if the executable declares no exceptions in its {@code
 * throws} clause.
 *
 * @return the exception types declared as being thrown by the
 * executable this object represents
 * @apiSince 26
 */

@androidx.annotation.NonNull
public abstract java.lang.Class<?>[] getExceptionTypes();

/**
 * Returns an array of {@code Type} objects that represent the
 * exceptions declared to be thrown by this executable object.
 * Returns an array of length 0 if the underlying executable declares
 * no exceptions in its {@code throws} clause.
 *
 * <p>If an exception type is a type variable or a parameterized
 * type, it is created. Otherwise, it is resolved.
 *
 * @return an array of Types that represent the exception types
 *     thrown by the underlying executable
 * @throws java.lang.reflect.GenericSignatureFormatError
 *     if the generic method signature does not conform to the format
 *     specified in
 *     <cite>The Java&trade; Virtual Machine Specification</cite>
 * @throws java.lang.TypeNotPresentException if the underlying executable's
 *     {@code throws} clause refers to a non-existent type declaration
 * @throws java.lang.reflect.MalformedParameterizedTypeException if
 *     the underlying executable's {@code throws} clause refers to a
 *     parameterized type that cannot be instantiated for any reason
 * @apiSince 26
 */

@androidx.annotation.NonNull
public java.lang.reflect.Type[] getGenericExceptionTypes() { throw new RuntimeException("Stub!"); }

/**
 * Returns a string describing this {@code Executable}, including
 * any type parameters.
 * @return a string describing this {@code Executable}, including
 * any type parameters
 * @apiSince 26
 */

@androidx.annotation.NonNull
public abstract java.lang.String toGenericString();

/**
 * Returns {@code true} if this executable was declared to take a
 * variable number of arguments; returns {@code false} otherwise.
 *
 * @return {@code true} if an only if this executable was declared
 * to take a variable number of arguments.
 * @apiSince 26
 */

public boolean isVarArgs() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if this executable is a synthetic
 * construct; returns {@code false} otherwise.
 *
 * @return true if and only if this executable is a synthetic
 * construct as defined by
 * <cite>The Java&trade; Language Specification</cite>.
 * @jls 13.1 The Form of a Binary
 * @apiSince 26
 */

public boolean isSynthetic() { throw new RuntimeException("Stub!"); }

/**
 * Returns an array of arrays of {@code Annotation}s that
 * represent the annotations on the formal parameters, in
 * declaration order, of the {@code Executable} represented by
 * this object.  Synthetic and mandated parameters (see
 * explanation below), such as the outer "this" parameter to an
 * inner class constructor will be represented in the returned
 * array.  If the executable has no parameters (meaning no formal,
 * no synthetic, and no mandated parameters), a zero-length array
 * will be returned.  If the {@code Executable} has one or more
 * parameters, a nested array of length zero is returned for each
 * parameter with no annotations. The annotation objects contained
 * in the returned arrays are serializable.  The caller of this
 * method is free to modify the returned arrays; it will have no
 * effect on the arrays returned to other callers.
 *
 * A compiler may add extra parameters that are implicitly
 * declared in source ("mandated"), as well as parameters that
 * are neither implicitly nor explicitly declared in source
 * ("synthetic") to the parameter list for a method.  See {@link
 * java.lang.reflect.Parameter} for more information.
 *
 * @see java.lang.reflect.Parameter
 * @see java.lang.reflect.Parameter#getAnnotations
 * @return an array of arrays that represent the annotations on
 *    the formal and implicit parameters, in declaration order, of
 *    the executable represented by this object
 * @apiSince 26
 */

@androidx.annotation.NonNull
public abstract java.lang.annotation.Annotation[][] getParameterAnnotations();

/**
 * {@inheritDoc}
 * @throws java.lang.NullPointerException  {@inheritDoc}
 * @apiSince 26
 */

@androidx.annotation.Nullable
public <T extends java.lang.annotation.Annotation> T getAnnotation(@androidx.annotation.NonNull java.lang.Class<T> annotationClass) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @throws java.lang.NullPointerException {@inheritDoc}
 * @apiSince 26
 */

public <T extends java.lang.annotation.Annotation> T[] getAnnotationsByType(@androidx.annotation.NonNull java.lang.Class<T> annotationClass) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 26
 */

@androidx.annotation.NonNull
public java.lang.annotation.Annotation[] getDeclaredAnnotations() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public final boolean isAnnotationPresent(@androidx.annotation.NonNull java.lang.Class<? extends java.lang.annotation.Annotation> annotationType) { throw new RuntimeException("Stub!"); }
}

