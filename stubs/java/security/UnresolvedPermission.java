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

import java.lang.reflect.*;
import java.security.cert.*;

/**
 * Legacy security code; do not use.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class UnresolvedPermission extends java.security.Permission implements java.io.Serializable {

/** @apiSince 1 */

public UnresolvedPermission(java.lang.String type, java.lang.String name, java.lang.String actions, java.security.cert.Certificate[] certs) { super(null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean implies(java.security.Permission p) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String getActions() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String getUnresolvedType() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String getUnresolvedName() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String getUnresolvedActions() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.security.cert.Certificate[] getUnresolvedCerts() { throw new RuntimeException("Stub!"); }
}

