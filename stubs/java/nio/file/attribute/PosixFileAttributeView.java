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

import java.nio.file.*;
import java.util.Set;
import java.io.IOException;

/**
 * A file attribute view that provides a view of the file attributes commonly
 * associated with files on file systems used by operating systems that implement
 * the Portable Operating System Interface (POSIX) family of standards.
 *
 * <p> Operating systems that implement the <a href="http://www.opengroup.org">
 * POSIX</a> family of standards commonly use file systems that have a
 * file <em>owner</em>, <em>group-owner</em>, and related <em>access
 * permissions</em>. This file attribute view provides read and write access
 * to these attributes.
 *
 * <p> The {@link #readAttributes() readAttributes} method is used to read the
 * file's attributes. The file {@link java.nio.file.attribute.PosixFileAttributes#owner() PosixFileAttributes#owner()} is
 * represented by a {@link java.nio.file.attribute.UserPrincipal UserPrincipal} that is the identity of the file owner
 * for the purposes of access control. The {@link java.nio.file.attribute.PosixFileAttributes#group() PosixFileAttributes#group()}, represented by a {@link java.nio.file.attribute.GroupPrincipal GroupPrincipal}, is the identity of the
 * group owner, where a group is an identity created for administrative purposes
 * so as to determine the access rights for the members of the group.
 *
 * <p> The {@link java.nio.file.attribute.PosixFileAttributes#permissions() PosixFileAttributes#permissions()} attribute is a
 * set of access permissions. This file attribute view provides access to the nine
 * permission defined by the {@link java.nio.file.attribute.PosixFilePermission PosixFilePermission} class.
 * These nine permission bits determine the <em>read</em>, <em>write</em>, and
 * <em>execute</em> access for the file owner, group, and others (others
 * meaning identities other than the owner and members of the group). Some
 * operating systems and file systems may provide additional permission bits
 * but access to these other bits is not defined by this class in this release.
 *
 * <p> <b>Usage Example:</b>
 * Suppose we need to print out the owner and access permissions of a file:
 * <pre>
 *     Path file = ...
 *     PosixFileAttributes attrs = Files.getFileAttributeView(file, PosixFileAttributeView.class)
 *         .readAttributes();
 *     System.out.format("%s %s%n",
 *         attrs.owner().getName(),
 *         PosixFilePermissions.toString(attrs.permissions()));
 * </pre>
 *
 * <h2> Dynamic Access </h2>
 * <p> Where dynamic access to file attributes is required, the attributes
 * supported by this attribute view are as defined by {@link java.nio.file.attribute.BasicFileAttributeView BasicFileAttributeView} and {@link java.nio.file.attribute.FileOwnerAttributeView FileOwnerAttributeView}, and in addition,
 * the following attributes are supported:
 * <blockquote>
 * <table border="1" cellpadding="8" summary="Supported attributes">
 *   <tr>
 *     <th> Name </th>
 *     <th> Type </th>
 *   </tr>
 *  <tr>
 *     <td> "permissions" </td>
 *     <td> {@link java.util.Set Set}&lt;{@link java.nio.file.attribute.PosixFilePermission PosixFilePermission}&gt; </td>
 *   </tr>
 *   <tr>
 *     <td> "group" </td>
 *     <td> {@link java.nio.file.attribute.GroupPrincipal GroupPrincipal} </td>
 *   </tr>
 * </table>
 * </blockquote>
 *
 * <p> The {@link java.nio.file.Files#getAttribute Files#getAttribute} method may be used to read
 * any of these attributes, or any of the attributes defined by {@link java.nio.file.attribute.BasicFileAttributeView BasicFileAttributeView} as if by invoking the {@link #readAttributes
 * readAttributes()} method.
 *
 * <p> The {@link java.nio.file.Files#setAttribute Files#setAttribute} method may be used to update
 * the file's last modified time, last access time or create time attributes as
 * defined by {@link java.nio.file.attribute.BasicFileAttributeView BasicFileAttributeView}. It may also be used to update
 * the permissions, owner, or group-owner as if by invoking the {@link
 * #setPermissions setPermissions}, {@link #setOwner setOwner}, and {@link
 * #setGroup setGroup} methods respectively.
 *
 * <h2> Setting Initial Permissions </h2>
 * <p> Implementations supporting this attribute view may also support setting
 * the initial permissions when creating a file or directory. The
 * initial permissions are provided to the {@link java.nio.file.Files#createFile Files#createFile}
 * or {@link java.nio.file.Files#createDirectory Files#createDirectory} methods as a {@link java.nio.file.attribute.FileAttribute FileAttribute} with {@link java.nio.file.attribute.FileAttribute#name FileAttribute#name} {@code "posix:permissions"}
 * and a {@link java.nio.file.attribute.FileAttribute#value FileAttribute#value} that is the set of permissions. The
 * following example uses the {@link java.nio.file.attribute.PosixFilePermissions#asFileAttribute PosixFilePermissions#asFileAttribute} method to construct a {@code FileAttribute} when creating a
 * file:
 *
 * <pre>
 *     Path path = ...
 *     Set&lt;PosixFilePermission&gt; perms =
 *         EnumSet.of(OWNER_READ, OWNER_WRITE, OWNER_EXECUTE, GROUP_READ);
 *     Files.createFile(path, PosixFilePermissions.asFileAttribute(perms));
 * </pre>
 *
 * <p> When the access permissions are set at file creation time then the actual
 * value of the permissions may differ that the value of the attribute object.
 * The reasons for this are implementation specific. On UNIX systems, for
 * example, a process has a <em>umask</em> that impacts the permission bits
 * of newly created files. Where an implementation supports the setting of
 * the access permissions, and the underlying file system supports access
 * permissions, then it is required that the value of the actual access
 * permissions will be equal or less than the value of the attribute
 * provided to the {@link java.nio.file.Files#createFile Files#createFile} or {@link java.nio.file.Files#createDirectory Files#createDirectory} methods. In other words, the file may
 * be more secure than requested.
 *
 * @since 1.7
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface PosixFileAttributeView extends java.nio.file.attribute.BasicFileAttributeView,  java.nio.file.attribute.FileOwnerAttributeView {

/**
 * Returns the name of the attribute view. Attribute views of this type
 * have the name {@code "posix"}.
 * @apiSince 26
 */

public java.lang.String name();

/**
 * @throws  java.io.IOException                {@inheritDoc}
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, a security manager is
 *          installed, and it denies {@link java.lang.RuntimePermission RuntimePermission}<tt>("accessUserInformation")</tt>
 *          or its {@link java.lang.SecurityManager#checkRead(java.lang.String) SecurityManager#checkRead(String)} method
 *          denies read access to the file.
 * @apiSince 26
 */

public java.nio.file.attribute.PosixFileAttributes readAttributes() throws java.io.IOException;

/**
 * Updates the file permissions.
 *
 * @param   perms
 *          the new set of permissions
 *
 * @throws  java.lang.ClassCastException
 *          if the sets contains elements that are not of type {@code
 *          PosixFilePermission}
 * @throws  java.io.IOException
 *          if an I/O error occurs
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, a security manager is
 *          installed, and it denies {@link java.lang.RuntimePermission RuntimePermission}<tt>("accessUserInformation")</tt>
 *          or its {@link java.lang.SecurityManager#checkWrite(java.lang.String) SecurityManager#checkWrite(String)}
 *          method denies write access to the file.
 * @apiSince 26
 */

public void setPermissions(java.util.Set<java.nio.file.attribute.PosixFilePermission> perms) throws java.io.IOException;

/**
 * Updates the file group-owner.
 *
 * @param   group
 *          the new file group-owner
 *
 * @throws  java.io.IOException
 *          if an I/O error occurs
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, it denies {@link java.lang.RuntimePermission RuntimePermission}<tt>("accessUserInformation")</tt>
 *          or its {@link java.lang.SecurityManager#checkWrite(java.lang.String) SecurityManager#checkWrite(String)}
 *          method denies write access to the file.
 * @apiSince 26
 */

public void setGroup(java.nio.file.attribute.GroupPrincipal group) throws java.io.IOException;
}

