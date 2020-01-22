/*
 * Copyright (c) 2003, 2013, Oracle and/or its affiliates. All rights reserved.
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


package java.security.spec;


/**
 * This immutable class specifies an elliptic curve public key with
 * its associated parameters.
 *
 * @see java.security.spec.KeySpec
 * @see java.security.spec.ECPoint
 * @see java.security.spec.ECParameterSpec
 *
 * @author Valerie Peng
 *
 * @since 1.5
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ECPublicKeySpec implements java.security.spec.KeySpec {

/**
 * Creates a new ECPublicKeySpec with the specified
 * parameter values.
 * @param w the public point.
 * @param params the associated elliptic curve domain
 * parameters.
 * @exception java.lang.NullPointerException if {@code w}
 * or {@code params} is null.
 * @exception java.lang.IllegalArgumentException if {@code w}
 * is point at infinity, i.e. ECPoint.POINT_INFINITY
 * @apiSince 1
 */

public ECPublicKeySpec(java.security.spec.ECPoint w, java.security.spec.ECParameterSpec params) { throw new RuntimeException("Stub!"); }

/**
 * Returns the public point W.
 * @return the public point W.
 * @apiSince 1
 */

public java.security.spec.ECPoint getW() { throw new RuntimeException("Stub!"); }

/**
 * Returns the associated elliptic curve domain
 * parameters.
 * @return the EC domain parameters.
 * @apiSince 1
 */

public java.security.spec.ECParameterSpec getParams() { throw new RuntimeException("Stub!"); }
}

