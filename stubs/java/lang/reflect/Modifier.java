/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 1996, 2013, Oracle and/or its affiliates. All rights reserved.
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


/**
 * The Modifier class provides {@code static} methods and
 * constants to decode class and member access modifiers.  The sets of
 * modifiers are represented as integers with distinct bit positions
 * representing different modifiers.  The values for the constants
 * representing the modifiers are taken from the tables in sections 4.1, 4.4, 4.5, and 4.7 of
 * <cite>The Java&trade; Virtual Machine Specification</cite>.
 *
 * @see java.lang.Class#getModifiers()
 * @see java.lang.reflect.Member#getModifiers()
 *
 * @author Nakul Saraiya
 * @author Kenneth Russell
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Modifier {

/** @apiSince 1 */

public Modifier() { throw new RuntimeException("Stub!"); }

/**
 * Return {@code true} if the integer argument includes the
 * {@code public} modifier, {@code false} otherwise.
 *
 * @param   mod a set of modifiers
 * @return {@code true} if {@code mod} includes the
 * {@code public} modifier; {@code false} otherwise.
 * @apiSince 1
 */

public static boolean isPublic(int mod) { throw new RuntimeException("Stub!"); }

/**
 * Return {@code true} if the integer argument includes the
 * {@code private} modifier, {@code false} otherwise.
 *
 * @param   mod a set of modifiers
 * @return {@code true} if {@code mod} includes the
 * {@code private} modifier; {@code false} otherwise.
 * @apiSince 1
 */

public static boolean isPrivate(int mod) { throw new RuntimeException("Stub!"); }

/**
 * Return {@code true} if the integer argument includes the
 * {@code protected} modifier, {@code false} otherwise.
 *
 * @param   mod a set of modifiers
 * @return {@code true} if {@code mod} includes the
 * {@code protected} modifier; {@code false} otherwise.
 * @apiSince 1
 */

public static boolean isProtected(int mod) { throw new RuntimeException("Stub!"); }

/**
 * Return {@code true} if the integer argument includes the
 * {@code static} modifier, {@code false} otherwise.
 *
 * @param   mod a set of modifiers
 * @return {@code true} if {@code mod} includes the
 * {@code static} modifier; {@code false} otherwise.
 * @apiSince 1
 */

public static boolean isStatic(int mod) { throw new RuntimeException("Stub!"); }

/**
 * Return {@code true} if the integer argument includes the
 * {@code final} modifier, {@code false} otherwise.
 *
 * @param   mod a set of modifiers
 * @return {@code true} if {@code mod} includes the
 * {@code final} modifier; {@code false} otherwise.
 * @apiSince 1
 */

public static boolean isFinal(int mod) { throw new RuntimeException("Stub!"); }

/**
 * Return {@code true} if the integer argument includes the
 * {@code synchronized} modifier, {@code false} otherwise.
 *
 * @param   mod a set of modifiers
 * @return {@code true} if {@code mod} includes the
 * {@code synchronized} modifier; {@code false} otherwise.
 * @apiSince 1
 */

public static boolean isSynchronized(int mod) { throw new RuntimeException("Stub!"); }

/**
 * Return {@code true} if the integer argument includes the
 * {@code volatile} modifier, {@code false} otherwise.
 *
 * @param   mod a set of modifiers
 * @return {@code true} if {@code mod} includes the
 * {@code volatile} modifier; {@code false} otherwise.
 * @apiSince 1
 */

public static boolean isVolatile(int mod) { throw new RuntimeException("Stub!"); }

/**
 * Return {@code true} if the integer argument includes the
 * {@code transient} modifier, {@code false} otherwise.
 *
 * @param   mod a set of modifiers
 * @return {@code true} if {@code mod} includes the
 * {@code transient} modifier; {@code false} otherwise.
 * @apiSince 1
 */

public static boolean isTransient(int mod) { throw new RuntimeException("Stub!"); }

/**
 * Return {@code true} if the integer argument includes the
 * {@code native} modifier, {@code false} otherwise.
 *
 * @param   mod a set of modifiers
 * @return {@code true} if {@code mod} includes the
 * {@code native} modifier; {@code false} otherwise.
 * @apiSince 1
 */

public static boolean isNative(int mod) { throw new RuntimeException("Stub!"); }

/**
 * Return {@code true} if the integer argument includes the
 * {@code interface} modifier, {@code false} otherwise.
 *
 * @param   mod a set of modifiers
 * @return {@code true} if {@code mod} includes the
 * {@code interface} modifier; {@code false} otherwise.
 * @apiSince 1
 */

public static boolean isInterface(int mod) { throw new RuntimeException("Stub!"); }

/**
 * Return {@code true} if the integer argument includes the
 * {@code abstract} modifier, {@code false} otherwise.
 *
 * @param   mod a set of modifiers
 * @return {@code true} if {@code mod} includes the
 * {@code abstract} modifier; {@code false} otherwise.
 * @apiSince 1
 */

public static boolean isAbstract(int mod) { throw new RuntimeException("Stub!"); }

/**
 * Return {@code true} if the integer argument includes the
 * {@code strictfp} modifier, {@code false} otherwise.
 *
 * @param   mod a set of modifiers
 * @return {@code true} if {@code mod} includes the
 * {@code strictfp} modifier; {@code false} otherwise.
 * @apiSince 1
 */

public static boolean isStrict(int mod) { throw new RuntimeException("Stub!"); }

/**
 * Return a string describing the access modifier flags in
 * the specified modifier. For example:
 * <blockquote><pre>
 *    public final synchronized strictfp
 * </pre></blockquote>
 * The modifier names are returned in an order consistent with the
 * suggested modifier orderings given in sections 8.1.1, 8.3.1, 8.4.3, 8.8.3, and 9.1.1 of
 * <cite>The Java&trade; Language Specification</cite>.
 * The full modifier ordering used by this method is:
 * <blockquote> {@code
 * public protected private abstract static final transient
 * volatile synchronized native strictfp
 * interface } </blockquote>
 * The {@code interface} modifier discussed in this class is
 * not a true modifier in the Java language and it appears after
 * all other modifiers listed by this method.  This method may
 * return a string of modifiers that are not valid modifiers of a
 * Java entity; in other words, no checking is done on the
 * possible validity of the combination of modifiers represented
 * by the input.
 *
 * Note that to perform such checking for a known kind of entity,
 * such as a constructor or method, first AND the argument of
 * {@code toString} with the appropriate mask from a method like
 * {@link #constructorModifiers} or {@link #methodModifiers}.
 *
 * @param   mod a set of modifiers
 * @return  a string representation of the set of modifiers
 * represented by {@code mod}
 * @apiSince 1
 */

public static java.lang.String toString(int mod) { throw new RuntimeException("Stub!"); }

/**
 * Return an {@code int} value OR-ing together the source language
 * modifiers that can be applied to a class.
 * @return an {@code int} value OR-ing together the source language
 * modifiers that can be applied to a class.
 *
 * @jls 8.1.1 Class Modifiers
 * @since 1.7
 * @apiSince 19
 */

public static int classModifiers() { throw new RuntimeException("Stub!"); }

/**
 * Return an {@code int} value OR-ing together the source language
 * modifiers that can be applied to an interface.
 * @return an {@code int} value OR-ing together the source language
 * modifiers that can be applied to an interface.
 *
 * @jls 9.1.1 Interface Modifiers
 * @since 1.7
 * @apiSince 19
 */

public static int interfaceModifiers() { throw new RuntimeException("Stub!"); }

/**
 * Return an {@code int} value OR-ing together the source language
 * modifiers that can be applied to a constructor.
 * @return an {@code int} value OR-ing together the source language
 * modifiers that can be applied to a constructor.
 *
 * @jls 8.8.3 Constructor Modifiers
 * @since 1.7
 * @apiSince 19
 */

public static int constructorModifiers() { throw new RuntimeException("Stub!"); }

/**
 * Return an {@code int} value OR-ing together the source language
 * modifiers that can be applied to a method.
 * @return an {@code int} value OR-ing together the source language
 * modifiers that can be applied to a method.
 *
 * @jls 8.4.3 Method Modifiers
 * @since 1.7
 * @apiSince 19
 */

public static int methodModifiers() { throw new RuntimeException("Stub!"); }

/**
 * Return an {@code int} value OR-ing together the source language
 * modifiers that can be applied to a field.
 * @return an {@code int} value OR-ing together the source language
 * modifiers that can be applied to a field.
 *
 * @jls 8.3.1 Field Modifiers
 * @since 1.7
 * @apiSince 19
 */

public static int fieldModifiers() { throw new RuntimeException("Stub!"); }

/**
 * Return an {@code int} value OR-ing together the source language
 * modifiers that can be applied to a parameter.
 * @return an {@code int} value OR-ing together the source language
 * modifiers that can be applied to a parameter.
 *
 * @jls 8.4.1 Formal Parameters
 * @since 1.8
 * @apiSince 26
 */

public static int parameterModifiers() { throw new RuntimeException("Stub!"); }

/**
 * The {@code int} value representing the {@code abstract}
 * modifier.
 * @apiSince 1
 */

public static final int ABSTRACT = 1024; // 0x400

/**
 * The {@code int} value representing the {@code final}
 * modifier.
 * @apiSince 1
 */

public static final int FINAL = 16; // 0x10

/**
 * The {@code int} value representing the {@code interface}
 * modifier.
 * @apiSince 1
 */

public static final int INTERFACE = 512; // 0x200

/**
 * The {@code int} value representing the {@code native}
 * modifier.
 * @apiSince 1
 */

public static final int NATIVE = 256; // 0x100

/**
 * The {@code int} value representing the {@code private}
 * modifier.
 * @apiSince 1
 */

public static final int PRIVATE = 2; // 0x2

/**
 * The {@code int} value representing the {@code protected}
 * modifier.
 * @apiSince 1
 */

public static final int PROTECTED = 4; // 0x4

/**
 * The {@code int} value representing the {@code public}
 * modifier.
 * @apiSince 1
 */

public static final int PUBLIC = 1; // 0x1

/**
 * The {@code int} value representing the {@code static}
 * modifier.
 * @apiSince 1
 */

public static final int STATIC = 8; // 0x8

/**
 * The {@code int} value representing the {@code strictfp}
 * modifier.
 * @apiSince 1
 */

public static final int STRICT = 2048; // 0x800

/**
 * The {@code int} value representing the {@code synchronized}
 * modifier.
 * @apiSince 1
 */

public static final int SYNCHRONIZED = 32; // 0x20

/**
 * The {@code int} value representing the {@code transient}
 * modifier.
 * @apiSince 1
 */

public static final int TRANSIENT = 128; // 0x80

/**
 * The {@code int} value representing the {@code volatile}
 * modifier.
 * @apiSince 1
 */

public static final int VOLATILE = 64; // 0x40
}

