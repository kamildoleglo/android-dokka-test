/*
 * Copyright (c) 2010, 2011, Oracle and/or its affiliates. All rights reserved.
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



package java.nio.file;

import java.io.IOException;

/**
 * Runtime exception thrown if an I/O error is encountered when iterating over
 * the entries in a directory. The I/O error is retrieved as an {@link java.io.IOException IOException} using the {@link #getCause() getCause()} method.
 *
 * @since 1.7
 * @see java.nio.file.DirectoryStream
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class DirectoryIteratorException extends java.util.ConcurrentModificationException {

/**
 * Constructs an instance of this class.
 *
 * @param   cause
 *          the {@code IOException} that caused the directory iteration
 *          to fail
 *
 * @throws  java.lang.NullPointerException
 *          if the cause is {@code null}
 * @apiSince 26
 */

public DirectoryIteratorException(java.io.IOException cause) { throw new RuntimeException("Stub!"); }

/**
 * Returns the cause of this exception.
 *
 * @return  the cause
 * @apiSince 26
 */

public java.io.IOException getCause() { throw new RuntimeException("Stub!"); }
}

