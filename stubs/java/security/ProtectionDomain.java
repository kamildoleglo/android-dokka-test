/*
 * Copyright (C) 2014 The Android Open Source Project
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
 * Legacy security code; do not use.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ProtectionDomain {

/** @apiSince 1 */

public ProtectionDomain(java.security.CodeSource codesource, java.security.PermissionCollection permissions) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public ProtectionDomain(java.security.CodeSource codesource, java.security.PermissionCollection permissions, java.lang.ClassLoader classloader, java.security.Principal[] principals) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final java.security.CodeSource getCodeSource() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final java.lang.ClassLoader getClassLoader() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final java.security.Principal[] getPrincipals() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final java.security.PermissionCollection getPermissions() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean implies(java.security.Permission permission) { throw new RuntimeException("Stub!"); }
}

