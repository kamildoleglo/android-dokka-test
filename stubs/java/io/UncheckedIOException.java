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


package java.io;


/**
 * Wraps an {@link java.io.IOException IOException} with an unchecked exception.
 *
 * @since   1.8
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class UncheckedIOException extends java.lang.RuntimeException {

/**
 * Constructs an instance of this class.
 *
 * @param   message
 *          the detail message, can be null
 * @param   cause
 *          the {@code IOException}
 *
 * @throws  java.lang.NullPointerException
 *          if the cause is {@code null}
 * @apiSince 24
 */

public UncheckedIOException(java.lang.String message, java.io.IOException cause) { throw new RuntimeException("Stub!"); }

/**
 * Constructs an instance of this class.
 *
 * @param   cause
 *          the {@code IOException}
 *
 * @throws  java.lang.NullPointerException
 *          if the cause is {@code null}
 * @apiSince 24
 */

public UncheckedIOException(java.io.IOException cause) { throw new RuntimeException("Stub!"); }

/**
 * Returns the cause of this exception.
 *
 * @return  the {@code IOException} which is the cause of this exception.
 * @apiSince 24
 */

public java.io.IOException getCause() { throw new RuntimeException("Stub!"); }
}

