/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 1997, 2011, Oracle and/or its affiliates. All rights reserved.
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
public abstract class Policy {

/** @apiSince 1 */

public Policy() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static java.security.Policy getPolicy() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static void setPolicy(java.security.Policy p) { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public static java.security.Policy getInstance(java.lang.String type, java.security.Policy.Parameters params) throws java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public static java.security.Policy getInstance(java.lang.String type, java.security.Policy.Parameters params, java.lang.String provider) throws java.security.NoSuchAlgorithmException, java.security.NoSuchProviderException { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public static java.security.Policy getInstance(java.lang.String type, java.security.Policy.Parameters params, java.security.Provider provider) throws java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public java.security.Provider getProvider() { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public java.lang.String getType() { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public java.security.Policy.Parameters getParameters() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.security.PermissionCollection getPermissions(java.security.CodeSource codesource) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.security.PermissionCollection getPermissions(java.security.ProtectionDomain domain) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean implies(java.security.ProtectionDomain domain, java.security.Permission permission) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void refresh() { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public static final java.security.PermissionCollection UNSUPPORTED_EMPTY_COLLECTION;
static { UNSUPPORTED_EMPTY_COLLECTION = null; }
/** @apiSince 9 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface Parameters {
}

}

