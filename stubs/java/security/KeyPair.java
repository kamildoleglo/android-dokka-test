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



package java.security;

import java.util.*;

/**
 * This class is a simple holder for a key pair (a public key and a
 * private key). It does not enforce any security, and, when initialized,
 * should be treated like a PrivateKey.
 *
 * @see java.security.PublicKey
 * @see java.security.PrivateKey
 *
 * @author Benjamin Renaud
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class KeyPair implements java.io.Serializable {

/**
 * Constructs a key pair from the given public key and private key.
 *
 * <p>Note that this constructor only stores references to the public
 * and private key components in the generated key pair. This is safe,
 * because {@code Key} objects are immutable.
 *
 * @param publicKey the public key.
 *
 * @param privateKey the private key.
 * @apiSince 1
 */

public KeyPair(java.security.PublicKey publicKey, java.security.PrivateKey privateKey) { throw new RuntimeException("Stub!"); }

/**
 * Returns a reference to the public key component of this key pair.
 *
 * @return a reference to the public key.
 * @apiSince 1
 */

public java.security.PublicKey getPublic() { throw new RuntimeException("Stub!"); }

/**
 * Returns a reference to the private key component of this key pair.
 *
 * @return a reference to the private key.
 * @apiSince 1
 */

public java.security.PrivateKey getPrivate() { throw new RuntimeException("Stub!"); }
}

