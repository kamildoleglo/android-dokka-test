/*
 * Copyright (c) 1997, 2007, Oracle and/or its affiliates. All rights reserved.
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



package javax.crypto.interfaces;


/**
 * The interface to a Diffie-Hellman public key.
 *
 * @author Jan Luehe
 *
 * @see javax.crypto.interfaces.DHKey
 * @see javax.crypto.interfaces.DHPrivateKey
 * @since 1.4
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface DHPublicKey extends javax.crypto.interfaces.DHKey,  java.security.PublicKey {

/**
 * Returns the public value, <code>y</code>.
 *
 * @return the public value, <code>y</code>
 * @apiSince 1
 */

public java.math.BigInteger getY();

/**
 * The class fingerprint that is set to indicate serialization
 * compatibility since J2SE 1.4.
 * @apiSince 1
 */

public static final long serialVersionUID = -6628103563352519193L; // 0xa4043eed23df4de7L
}
