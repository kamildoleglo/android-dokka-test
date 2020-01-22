/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 1995, 2006, Oracle and/or its affiliates. All rights reserved.
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



package java.lang;

import java.security.*;
import java.net.InetAddress;

/**
 * Legacy security code; do not use.
 *
 * <p>Security managers do <i>not</i> provide a secure environment for
 * executing untrusted code and are unsupported on Android. Untrusted code
 * cannot be safely isolated within a single VM on Android. Application
 * developers can assume that there's no SecurityManager installed,
 * i.e. {@link java.lang.System#getSecurityManager()} will return null.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SecurityManager {

/** @apiSince 1 */

public SecurityManager() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link #checkPermission} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public boolean getInCheck() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected java.lang.Class[] getClassContext() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link #checkPermission} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
protected java.lang.ClassLoader currentClassLoader() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link #checkPermission} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
protected java.lang.Class<?> currentLoadedClass() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link #checkPermission} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
protected int classDepth(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link #checkPermission} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
protected int classLoaderDepth() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link #checkPermission} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
protected boolean inClass(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link #checkPermission} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
protected boolean inClassLoader() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.Object getSecurityContext() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void checkPermission(java.security.Permission perm) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void checkPermission(java.security.Permission perm, java.lang.Object context) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void checkCreateClassLoader() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void checkAccess(java.lang.Thread t) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void checkAccess(java.lang.ThreadGroup g) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void checkExit(int status) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void checkExec(java.lang.String cmd) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void checkLink(java.lang.String lib) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void checkRead(java.io.FileDescriptor fd) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void checkRead(java.lang.String file) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void checkRead(java.lang.String file, java.lang.Object context) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void checkWrite(java.io.FileDescriptor fd) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void checkWrite(java.lang.String file) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void checkDelete(java.lang.String file) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void checkConnect(java.lang.String host, int port) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void checkConnect(java.lang.String host, int port, java.lang.Object context) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void checkListen(int port) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void checkAccept(java.lang.String host, int port) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void checkMulticast(java.net.InetAddress maddr) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated use {@link #checkMulticast(java.net.InetAddress)} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public void checkMulticast(java.net.InetAddress maddr, byte ttl) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void checkPropertiesAccess() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void checkPropertyAccess(java.lang.String key) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean checkTopLevelWindow(java.lang.Object window) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void checkPrintJobAccess() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void checkSystemClipboardAccess() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void checkAwtEventQueueAccess() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void checkPackageAccess(java.lang.String pkg) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void checkPackageDefinition(java.lang.String pkg) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void checkSetFactory() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void checkMemberAccess(java.lang.Class<?> clazz, int which) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void checkSecurityAccess(java.lang.String target) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current thread's thread group.
 * @apiSince 1
 */

public java.lang.ThreadGroup getThreadGroup() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link #checkPermission} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated protected boolean inCheck;
}

