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
 * This class specifies the set of parameters used with mask generation
 * function MGF1 in OAEP Padding and RSA-PSS signature scheme, as
 * defined in the
 * <a href="http://www.ietf.org/rfc/rfc3447.txt">PKCS #1 v2.1</a>
 * standard.
 *
 * <p>Its ASN.1 definition in PKCS#1 standard is described below:
 * <pre>
 * MGF1Parameters ::= OAEP-PSSDigestAlgorthms
 * </pre>
 * where
 * <pre>
 * OAEP-PSSDigestAlgorithms    ALGORITHM-IDENTIFIER ::= {
 *   { OID id-sha1 PARAMETERS NULL   }|
 *   { OID id-sha224 PARAMETERS NULL   }|
 *   { OID id-sha256 PARAMETERS NULL }|
 *   { OID id-sha384 PARAMETERS NULL }|
 *   { OID id-sha512 PARAMETERS NULL },
 *   ...  -- Allows for future expansion --
 * }
 * </pre>
 * @see java.security.spec.PSSParameterSpec
 * @see javax.crypto.spec.OAEPParameterSpec
 *
 * @author Valerie Peng
 *
 * @since 1.5
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class MGF1ParameterSpec implements java.security.spec.AlgorithmParameterSpec {

/**
 * Constructs a parameter set for mask generation function MGF1
 * as defined in the PKCS #1 standard.
 *
 * @param mdName the algorithm name for the message digest
 * used in this mask generation function MGF1.
 * @exception java.lang.NullPointerException if {@code mdName} is null.
 * @apiSince 1
 */

public MGF1ParameterSpec(java.lang.String mdName) { throw new RuntimeException("Stub!"); }

/**
 * Returns the algorithm name of the message digest used by the mask
 * generation function.
 *
 * @return the algorithm name of the message digest.
 * @apiSince 1
 */

public java.lang.String getDigestAlgorithm() { throw new RuntimeException("Stub!"); }

/**
 * The MGF1ParameterSpec which uses "SHA-1" message digest.
 * @apiSince 1
 */

public static final java.security.spec.MGF1ParameterSpec SHA1;
static { SHA1 = null; }

/**
 * The MGF1ParameterSpec which uses "SHA-224" message digest.
 * @apiSince 26
 */

public static final java.security.spec.MGF1ParameterSpec SHA224;
static { SHA224 = null; }

/**
 * The MGF1ParameterSpec which uses "SHA-256" message digest.
 * @apiSince 1
 */

public static final java.security.spec.MGF1ParameterSpec SHA256;
static { SHA256 = null; }

/**
 * The MGF1ParameterSpec which uses "SHA-384" message digest.
 * @apiSince 1
 */

public static final java.security.spec.MGF1ParameterSpec SHA384;
static { SHA384 = null; }

/**
 * The MGF1ParameterSpec which uses SHA-512 message digest.
 * @apiSince 1
 */

public static final java.security.spec.MGF1ParameterSpec SHA512;
static { SHA512 = null; }
}

