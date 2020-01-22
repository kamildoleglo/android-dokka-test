/*
 * Copyright (c) 2007, 2011, Oracle and/or its affiliates. All rights reserved.
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
 * A file attribute view that supports reading or updating the owner of a file.
 * This file attribute view is intended for file system implementations that
 * support a file attribute that represents an identity that is the owner of
 * the file. Often the owner of a file is the identity of the entity that
 * created the file.
 *
 * <p> The {@link #getOwner getOwner} or {@link #setOwner setOwner} methods may
 * be used to read or update the owner of the file.
 *
 * <p> The {@link java.nio.file.Files#getAttribute getAttribute} and
 * {@link java.nio.file.Files#setAttribute setAttribute} methods may also be
 * used to read or update the owner. In that case, the owner attribute is
 * identified by the name {@code "owner"}, and the value of the attribute is
 * a {@link java.nio.file.attribute.UserPrincipal UserPrincipal}.
 *
 * @since 1.7
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface FileOwnerAttributeView extends java.nio.file.attribute.FileAttributeView {

/**
 * Returns the name of the attribute view. Attribute views of this type
 * have the name {@code "owner"}.
 * @apiSince 26
 */

public java.lang.String name();

/**
 * Read the file owner.
 *
 * <p> It it implementation specific if the file owner can be a {@link java.nio.file.attribute.GroupPrincipal GroupPrincipal}.
 *
 * @return  the file owner
 *
 * @throws  java.io.IOException
 *          if an I/O error occurs
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, a security manager is
 *          installed, and it denies {@link java.lang.RuntimePermission RuntimePermission}<tt>("accessUserInformation")</tt> or its
 *          {@link java.lang.SecurityManager#checkRead(java.lang.String) SecurityManager#checkRead(String)} method
 *          denies read access to the file.
 * @apiSince 26
 */

public java.nio.file.attribute.UserPrincipal getOwner() throws java.io.IOException;

/**
 * Updates the file owner.
 *
 * <p> It it implementation specific if the file owner can be a {@link java.nio.file.attribute.GroupPrincipal GroupPrincipal}. To ensure consistent and correct behavior
 * across platforms it is recommended that this method should only be used
 * to set the file owner to a user principal that is not a group.
 *
 * @param   owner
 *          the new file owner
 *
 * @throws  java.io.IOException
 *          if an I/O error occurs, or the {@code owner} parameter is a
 *          group and this implementation does not support setting the owner
 *          to a group
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, a security manager is
 *          installed, and it denies {@link java.lang.RuntimePermission RuntimePermission}<tt>("accessUserInformation")</tt> or its
 *          {@link java.lang.SecurityManager#checkWrite(java.lang.String) SecurityManager#checkWrite(String)} method
 *          denies write access to the file.
 * @apiSince 26
 */

public void setOwner(java.nio.file.attribute.UserPrincipal owner) throws java.io.IOException;
}

