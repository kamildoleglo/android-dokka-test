/*
 * Copyright (c) 2003, 2011, Oracle and/or its affiliates. All rights reserved.
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



package javax.net.ssl;

import java.util.*;
import java.security.KeyStore;

/**
 * A parameters object for X509KeyManagers that encapsulates a List
 * of KeyStore.Builders.
 *
 * @see java.security.KeyStore.Builder
 * @see javax.net.ssl.X509KeyManager
 *
 * @author  Andreas Sterbenz
 * @since   1.5
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class KeyStoreBuilderParameters implements javax.net.ssl.ManagerFactoryParameters {

/**
 * Construct new KeyStoreBuilderParameters from the specified
 * {@linkplain java.security.KeyStore.Builder}.
 *
 * @param builder the Builder object
 * @exception java.lang.NullPointerException if builder is null
 * @apiSince 1
 */

public KeyStoreBuilderParameters(java.security.KeyStore.Builder builder) { throw new RuntimeException("Stub!"); }

/**
 * Construct new KeyStoreBuilderParameters from a List
 * of {@linkplain java.security.KeyStore.Builder}s. Note that the list
 * is cloned to protect against subsequent modification.
 *
 * @param parameters the List of Builder objects
 * @exception java.lang.NullPointerException if parameters is null
 * @exception java.lang.IllegalArgumentException if parameters is an empty list
 * @apiSince 1
 */

public KeyStoreBuilderParameters(java.util.List<java.security.KeyStore.Builder> parameters) { throw new RuntimeException("Stub!"); }

/**
 * Return the unmodifiable List of the
 * {@linkplain java.security.KeyStore.Builder}s
 * encapsulated by this object.
 *
 * @return the unmodifiable List of the
 * {@linkplain java.security.KeyStore.Builder}s
 * encapsulated by this object.
 * @apiSince 1
 */

public java.util.List<java.security.KeyStore.Builder> getParameters() { throw new RuntimeException("Stub!"); }
}

