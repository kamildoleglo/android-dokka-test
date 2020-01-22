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
 * Checked exception thrown when a file system operation is denied, typically
 * due to a file permission or other access check.
 *
 * <p> This exception is not related to the {@link
 * java.security.AccessControlException AccessControlException} or {@link java.lang.SecurityException SecurityException} thrown by access controllers or security managers when
 * access to a file is denied.
 *
 * @since 1.7
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AccessDeniedException extends java.nio.file.FileSystemException {

/**
 * Constructs an instance of this class.
 *
 * @param   file
 *          a string identifying the file or {@code null} if not known
 * @apiSince 26
 */

public AccessDeniedException(java.lang.String file) { super((java.lang.String)null); throw new RuntimeException("Stub!"); }

/**
 * Constructs an instance of this class.
 *
 * @param   file
 *          a string identifying the file or {@code null} if not known
 * @param   other
 *          a string identifying the other file or {@code null} if not known
 * @param   reason
 *          a reason message with additional information or {@code null}
 * @apiSince 26
 */

public AccessDeniedException(java.lang.String file, java.lang.String other, java.lang.String reason) { super((java.lang.String)null); throw new RuntimeException("Stub!"); }
}
