/*
 * Copyright (c) 2007, 2013, Oracle and/or its affiliates. All rights reserved.
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



package java.nio.file.attribute;

import java.io.IOException;

/**
 * A file attribute view that provides a view of the legacy "DOS" file attributes.
 * These attributes are supported by file systems such as the File Allocation
 * Table (FAT) format commonly used in <em>consumer devices</em>.
 *
 * <p> A {@code DosFileAttributeView} is a {@link java.nio.file.attribute.BasicFileAttributeView BasicFileAttributeView} that
 * additionally supports access to the set of DOS attribute flags that are used
 * to indicate if the file is read-only, hidden, a system file, or archived.
 *
 * <p> Where dynamic access to file attributes is required, the attributes
 * supported by this attribute view are as defined by {@code
 * BasicFileAttributeView}, and in addition, the following attributes are
 * supported:
 * <blockquote>
 * <table border="1" cellpadding="8" summary="Supported attributes">
 *   <tr>
 *     <th> Name </th>
 *     <th> Type </th>
 *   </tr>
 *   <tr>
 *     <td> readonly </td>
 *     <td> {@link java.lang.Boolean Boolean} </td>
 *   </tr>
 *   <tr>
 *     <td> hidden </td>
 *     <td> {@link java.lang.Boolean Boolean} </td>
 *   </tr>
 *   <tr>
 *     <td> system </td>
 *     <td> {@link java.lang.Boolean Boolean} </td>
 *   </tr>
 *   <tr>
 *     <td> archive </td>
 *     <td> {@link java.lang.Boolean Boolean} </td>
 *   </tr>
 * </table>
 * </blockquote>
 *
 * <p> The {@link java.nio.file.Files#getAttribute getAttribute} method may
 * be used to read any of these attributes, or any of the attributes defined by
 * {@link java.nio.file.attribute.BasicFileAttributeView BasicFileAttributeView} as if by invoking the {@link #readAttributes
 * readAttributes()} method.
 *
 * <p> The {@link java.nio.file.Files#setAttribute setAttribute} method may
 * be used to update the file's last modified time, last access time or create
 * time attributes as defined by {@link java.nio.file.attribute.BasicFileAttributeView BasicFileAttributeView}. It may also be
 * used to update the DOS attributes as if by invoking the {@link #setReadOnly
 * setReadOnly}, {@link #setHidden setHidden}, {@link #setSystem setSystem}, and
 * {@link #setArchive setArchive} methods respectively.
 *
 * @since 1.7
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface DosFileAttributeView extends java.nio.file.attribute.BasicFileAttributeView {

/**
 * Returns the name of the attribute view. Attribute views of this type
 * have the name {@code "dos"}.
 * @apiSince 26
 */

public java.lang.String name();

/**
 * @throws  java.io.IOException                             {@inheritDoc}
 * @throws  java.lang.SecurityException                       {@inheritDoc}
 * @apiSince 26
 */

public java.nio.file.attribute.DosFileAttributes readAttributes() throws java.io.IOException;

/**
 * Updates the value of the read-only attribute.
 *
 * <p> It is implementation specific if the attribute can be updated as an
 * atomic operation with respect to other file system operations. An
 * implementation may, for example, require to read the existing value of
 * the DOS attribute in order to update this attribute.
 *
 * @param   value
 *          the new value of the attribute
 *
 * @throws  java.io.IOException
 *          if an I/O error occurs
 * @throws  java.lang.SecurityException
 *          In the case of the default, and a security manager is installed,
 *          its  {@link java.lang.SecurityManager#checkWrite(java.lang.String) SecurityManager#checkWrite(String)} method
 *          is invoked to check write access to the file
 * @apiSince 26
 */

public void setReadOnly(boolean value) throws java.io.IOException;

/**
 * Updates the value of the hidden attribute.
 *
 * <p> It is implementation specific if the attribute can be updated as an
 * atomic operation with respect to other file system operations. An
 * implementation may, for example, require to read the existing value of
 * the DOS attribute in order to update this attribute.
 *
 * @param   value
 *          the new value of the attribute
 *
 * @throws  java.io.IOException
 *          if an I/O error occurs
 * @throws  java.lang.SecurityException
 *          In the case of the default, and a security manager is installed,
 *          its  {@link java.lang.SecurityManager#checkWrite(java.lang.String) SecurityManager#checkWrite(String)} method
 *          is invoked to check write access to the file
 * @apiSince 26
 */

public void setHidden(boolean value) throws java.io.IOException;

/**
 * Updates the value of the system attribute.
 *
 * <p> It is implementation specific if the attribute can be updated as an
 * atomic operation with respect to other file system operations. An
 * implementation may, for example, require to read the existing value of
 * the DOS attribute in order to update this attribute.
 *
 * @param   value
 *          the new value of the attribute
 *
 * @throws  java.io.IOException
 *          if an I/O error occurs
 * @throws  java.lang.SecurityException
 *          In the case of the default, and a security manager is installed,
 *          its  {@link java.lang.SecurityManager#checkWrite(java.lang.String) SecurityManager#checkWrite(String)} method
 *          is invoked to check write access to the file
 * @apiSince 26
 */

public void setSystem(boolean value) throws java.io.IOException;

/**
 * Updates the value of the archive attribute.
 *
 * <p> It is implementation specific if the attribute can be updated as an
 * atomic operation with respect to other file system operations. An
 * implementation may, for example, require to read the existing value of
 * the DOS attribute in order to update this attribute.
 *
 * @param   value
 *          the new value of the attribute
 *
 * @throws  java.io.IOException
 *          if an I/O error occurs
 * @throws  java.lang.SecurityException
 *          In the case of the default, and a security manager is installed,
 *          its  {@link java.lang.SecurityManager#checkWrite(java.lang.String) SecurityManager#checkWrite(String)} method
 *          is invoked to check write access to the file
 * @apiSince 26
 */

public void setArchive(boolean value) throws java.io.IOException;
}

