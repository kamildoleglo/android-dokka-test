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



package java.nio.file.attribute;


/**
 * Defines the permissions for use with the permissions component of an ACL
 * {@link java.nio.file.attribute.AclEntry AclEntry}.
 *
 * @since 1.7
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum AclEntryPermission {
/**
 * Permission to read the data of the file.
 * @apiSince 26
 */

READ_DATA,
/**
 * Permission to modify the file's data.
 * @apiSince 26
 */

WRITE_DATA,
/**
 * Permission to append data to a file.
 * @apiSince 26
 */

APPEND_DATA,
/**
 * Permission to read the named attributes of a file.
 *
 * <p> <a href="http://www.ietf.org/rfc/rfc3530.txt">RFC&nbsp;3530: Network
 * File System (NFS) version 4 Protocol</a> defines <em>named attributes</em>
 * as opaque files associated with a file in the file system.
 * @apiSince 26
 */

READ_NAMED_ATTRS,
/**
 * Permission to write the named attributes of a file.
 *
 * <p> <a href="http://www.ietf.org/rfc/rfc3530.txt">RFC&nbsp;3530: Network
 * File System (NFS) version 4 Protocol</a> defines <em>named attributes</em>
 * as opaque files associated with a file in the file system.
 * @apiSince 26
 */

WRITE_NAMED_ATTRS,
/**
 * Permission to execute a file.
 * @apiSince 26
 */

EXECUTE,
/**
 * Permission to delete a file or directory within a directory.
 * @apiSince 26
 */

DELETE_CHILD,
/**
 * The ability to read (non-acl) file attributes.
 * @apiSince 26
 */

READ_ATTRIBUTES,
/**
 * The ability to write (non-acl) file attributes.
 * @apiSince 26
 */

WRITE_ATTRIBUTES,
/**
 * Permission to delete the file.
 * @apiSince 26
 */

DELETE,
/**
 * Permission to read the ACL attribute.
 * @apiSince 26
 */

READ_ACL,
/**
 * Permission to write the ACL attribute.
 * @apiSince 26
 */

WRITE_ACL,
/**
 * Permission to change the owner.
 * @apiSince 26
 */

WRITE_OWNER,
/**
 * Permission to access file locally at the server with synchronous reads
 * and writes.
 * @apiSince 26
 */

SYNCHRONIZE;

/**
 * Permission to add a new file to a directory (equal to {@link #WRITE_DATA})
 * @apiSince 26
 */

public static final java.nio.file.attribute.AclEntryPermission ADD_FILE = null;

/**
 * Permission to create a subdirectory to a directory (equal to {@link #APPEND_DATA})
 * @apiSince 26
 */

public static final java.nio.file.attribute.AclEntryPermission ADD_SUBDIRECTORY = null;

/**
 * Permission to list the entries of a directory (equal to {@link #READ_DATA})
 * @apiSince 26
 */

public static final java.nio.file.attribute.AclEntryPermission LIST_DIRECTORY = null;
}

