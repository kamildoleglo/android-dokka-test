/*
 * Copyright (c) 2007, 2009, Oracle and/or its affiliates. All rights reserved.
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


/**
 * Thrown when a file system operation fails on one or two files. This class is
 * the general class for file system exceptions.
 *
 * @since 1.7
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class FileSystemException extends java.io.IOException {

/**
 * Constructs an instance of this class. This constructor should be used
 * when an operation involving one file fails and there isn't any additional
 * information to explain the reason.
 *
 * @param   file
 *          a string identifying the file or {@code null} if not known.
 * @apiSince 26
 */

public FileSystemException(java.lang.String file) { throw new RuntimeException("Stub!"); }

/**
 * Constructs an instance of this class. This constructor should be used
 * when an operation involving two files fails, or there is additional
 * information to explain the reason.
 *
 * @param   file
 *          a string identifying the file or {@code null} if not known.
 * @param   other
 *          a string identifying the other file or {@code null} if there
 *          isn't another file or if not known
 * @param   reason
 *          a reason message with additional information or {@code null}
 * @apiSince 26
 */

public FileSystemException(java.lang.String file, java.lang.String other, java.lang.String reason) { throw new RuntimeException("Stub!"); }

/**
 * Returns the file used to create this exception.
 *
 * @return  the file (can be {@code null})
 * @apiSince 26
 */

public java.lang.String getFile() { throw new RuntimeException("Stub!"); }

/**
 * Returns the other file used to create this exception.
 *
 * @return  the other file (can be {@code null})
 * @apiSince 26
 */

public java.lang.String getOtherFile() { throw new RuntimeException("Stub!"); }

/**
 * Returns the string explaining why the file system operation failed.
 *
 * @return  the string explaining why the file system operation failed
 * @apiSince 26
 */

public java.lang.String getReason() { throw new RuntimeException("Stub!"); }

/**
 * Returns the detail message string.
 * @apiSince 26
 */

public java.lang.String getMessage() { throw new RuntimeException("Stub!"); }
}

