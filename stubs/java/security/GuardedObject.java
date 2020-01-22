/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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



package java.security;


/**
 * A GuardedObject is an object that is used to protect access to
 * another object.
 *
 * <p>A GuardedObject encapsulates a target object and a Guard object,
 * such that access to the target object is possible
 * only if the Guard object allows it.
 * Once an object is encapsulated by a GuardedObject,
 * access to that object is controlled by the {@code getObject}
 * method, which invokes the
 * {@code checkGuard} method on the Guard object that is
 * guarding access. If access is not allowed,
 * an exception is thrown.
 *
 * @see java.security.Guard
 * @see java.security.Permission
 *
 * @author Roland Schemers
 * @author Li Gong
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class GuardedObject implements java.io.Serializable {

/**
 * Constructs a GuardedObject using the specified object and guard.
 * If the Guard object is null, then no restrictions will
 * be placed on who can access the object.
 *
 * @param object the object to be guarded.
 *
 * @param guard the Guard object that guards access to the object.
 * @apiSince 1
 */

public GuardedObject(java.lang.Object object, java.security.Guard guard) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the guarded object, or throws an exception if access
 * to the guarded object is denied by the guard.
 *
 * @return the guarded object.
 *
 * @exception java.lang.SecurityException if access to the guarded object is
 * denied.
 * @apiSince 1
 */

public java.lang.Object getObject() throws java.lang.SecurityException { throw new RuntimeException("Stub!"); }
}

