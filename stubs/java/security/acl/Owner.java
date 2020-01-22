/*
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



package java.security.acl;

import java.security.Principal;

/**
 * Interface for managing owners of Access Control Lists (ACLs) or ACL
 * configurations. (Note that the Acl interface in the
 * {@code  java.security.acl} package extends this Owner
 * interface.) The initial owner Principal should be specified as an
 * argument to the constructor of the class implementing this interface.
 *
 * @see java.security.acl.Acl
 *
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface Owner {

/**
 * Adds an owner. Only owners can modify ACL contents. The caller
 * principal must be an owner of the ACL in order to invoke this method.
 * That is, only an owner can add another owner. The initial owner is
 * configured at ACL construction time.
 *
 * @param caller the principal invoking this method. It must be an owner
 * of the ACL.
 *
 * @param owner the owner that should be added to the list of owners.
 *
 * @return true if successful, false if owner is already an owner.
 * @exception java.security.acl.NotOwnerException if the caller principal is not an owner
 * of the ACL.
 * @apiSince 1
 */

public boolean addOwner(java.security.Principal caller, java.security.Principal owner) throws java.security.acl.NotOwnerException;

/**
 * Deletes an owner. If this is the last owner in the ACL, an exception is
 * raised.<p>
 *
 * The caller principal must be an owner of the ACL in order to invoke
 * this method.
 *
 * @param caller the principal invoking this method. It must be an owner
 * of the ACL.
 *
 * @param owner the owner to be removed from the list of owners.
 *
 * @return true if the owner is removed, false if the owner is not part
 * of the list of owners.
 *
 * @exception java.security.acl.NotOwnerException if the caller principal is not an owner
 * of the ACL.
 *
 * @exception java.security.acl.LastOwnerException if there is only one owner left, so that
 * deleteOwner would leave the ACL owner-less.
 * @apiSince 1
 */

public boolean deleteOwner(java.security.Principal caller, java.security.Principal owner) throws java.security.acl.LastOwnerException, java.security.acl.NotOwnerException;

/**
 * Returns true if the given principal is an owner of the ACL.
 *
 * @param owner the principal to be checked to determine whether or not
 * it is an owner.
 *
 * @return true if the passed principal is in the list of owners, false
 * if not.
 * @apiSince 1
 */

public boolean isOwner(java.security.Principal owner);
}

