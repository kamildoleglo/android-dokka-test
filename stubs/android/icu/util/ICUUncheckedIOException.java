/* GENERATED SOURCE. DO NOT MODIFY. */
// © 2016 and later: Unicode, Inc. and others.
// License & terms of use: http://www.unicode.org/copyright.html#License
/*
 *******************************************************************************
 * Copyright (C) 2014-2015, International Business Machines Corporation and
 * others. All Rights Reserved.
 *******************************************************************************
 */

package android.icu.util;


/**
 * Unchecked version of {@link java.io.IOException}.
 * Some ICU APIs do not throw the standard exception but instead wrap it
 * into this unchecked version.
 *
 * <p>This currently extends {@link java.lang.RuntimeException RuntimeException},
 * but when ICU can rely on Java 8 this class should be changed to extend
 * java.io.UncheckedIOException instead.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ICUUncheckedIOException extends java.lang.RuntimeException {

/**
 * Default constructor.
 * @apiSince 24
 */

public ICUUncheckedIOException() { throw new RuntimeException("Stub!"); }

/**
 * Constructor.
 *
 * @param message exception message string
 * @apiSince 24
 */

public ICUUncheckedIOException(java.lang.String message) { throw new RuntimeException("Stub!"); }

/**
 * Constructor.
 *
 * @param cause original exception (normally a {@link java.io.IOException})
 * @apiSince 24
 */

public ICUUncheckedIOException(java.lang.Throwable cause) { throw new RuntimeException("Stub!"); }

/**
 * Constructor.
 *
 * @param message exception message string
 * @param cause original exception (normally a {@link java.io.IOException})
 * @apiSince 24
 */

public ICUUncheckedIOException(java.lang.String message, java.lang.Throwable cause) { throw new RuntimeException("Stub!"); }
}

