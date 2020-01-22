/*
 * Copyright (c) 2003, 2007, Oracle and/or its affiliates. All rights reserved.
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



package javax.crypto.spec;

import java.security.spec.MGF1ParameterSpec;

/**
 * This class specifies the set of parameters used with OAEP Padding,
 * as defined in the
 * <a href="http://www.ietf.org/rfc/rfc3447.txt">PKCS #1</a>
 * standard.
 *
 * Its ASN.1 definition in PKCS#1 standard is described below:
 * <pre>
 * RSAES-OAEP-params ::= SEQUENCE {
 *   hashAlgorithm      [0] OAEP-PSSDigestAlgorithms     DEFAULT sha1,
 *   maskGenAlgorithm   [1] PKCS1MGFAlgorithms  DEFAULT mgf1SHA1,
 *   pSourceAlgorithm   [2] PKCS1PSourceAlgorithms  DEFAULT pSpecifiedEmpty
 * }
 * </pre>
 * where
 * <pre>
 * OAEP-PSSDigestAlgorithms    ALGORITHM-IDENTIFIER ::= {
 *   { OID id-sha1 PARAMETERS NULL   }|
 *   { OID id-sha256 PARAMETERS NULL }|
 *   { OID id-sha384 PARAMETERS NULL }|
 *   { OID id-sha512 PARAMETERS NULL },
 *   ...  -- Allows for future expansion --
 * }
 * PKCS1MGFAlgorithms    ALGORITHM-IDENTIFIER ::= {
 *   { OID id-mgf1 PARAMETERS OAEP-PSSDigestAlgorithms },
 *   ...  -- Allows for future expansion --
 * }
 * PKCS1PSourceAlgorithms    ALGORITHM-IDENTIFIER ::= {
 *   { OID id-pSpecified PARAMETERS OCTET STRING },
 *   ...  -- Allows for future expansion --
 * }
 * </pre>
 * <p>Note: the OAEPParameterSpec.DEFAULT uses the following:
 *     message digest  -- "SHA-1"
 *     mask generation function (mgf) -- "MGF1"
 *     parameters for mgf -- MGF1ParameterSpec.SHA1
 *     source of encoding input -- PSource.PSpecified.DEFAULT
 *
 * @see java.security.spec.MGF1ParameterSpec
 * @see javax.crypto.spec.PSource
 *
 * @author Valerie Peng
 *
 * @since 1.5
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class OAEPParameterSpec implements java.security.spec.AlgorithmParameterSpec {

/**
 * Constructs a parameter set for OAEP padding as defined in
 * the PKCS #1 standard using the specified message digest
 * algorithm <code>mdName</code>, mask generation function
 * algorithm <code>mgfName</code>, parameters for the mask
 * generation function <code>mgfSpec</code>, and source of
 * the encoding input P <code>pSrc</code>.
 *
 * @param mdName the algorithm name for the message digest.
 * @param mgfName the algorithm name for the mask generation
 * function.
 * @param mgfSpec the parameters for the mask generation function.
 * If null is specified, null will be returned by getMGFParameters().
 * @param pSrc the source of the encoding input P.
 * @exception java.lang.NullPointerException if <code>mdName</code>,
 * <code>mgfName</code>, or <code>pSrc</code> is null.
 * @apiSince 1
 */

public OAEPParameterSpec(java.lang.String mdName, java.lang.String mgfName, java.security.spec.AlgorithmParameterSpec mgfSpec, javax.crypto.spec.PSource pSrc) { throw new RuntimeException("Stub!"); }

/**
 * Returns the message digest algorithm name.
 *
 * @return the message digest algorithm name.
 * @apiSince 1
 */

public java.lang.String getDigestAlgorithm() { throw new RuntimeException("Stub!"); }

/**
 * Returns the mask generation function algorithm name.
 *
 * @return the mask generation function algorithm name.
 * @apiSince 1
 */

public java.lang.String getMGFAlgorithm() { throw new RuntimeException("Stub!"); }

/**
 * Returns the parameters for the mask generation function.
 *
 * @return the parameters for the mask generation function.
 * @apiSince 1
 */

public java.security.spec.AlgorithmParameterSpec getMGFParameters() { throw new RuntimeException("Stub!"); }

/**
 * Returns the source of encoding input P.
 *
 * @return the source of encoding input P.
 * @apiSince 1
 */

public javax.crypto.spec.PSource getPSource() { throw new RuntimeException("Stub!"); }

/**
 * The OAEP parameter set with all default values.
 * @apiSince 1
 */

public static final javax.crypto.spec.OAEPParameterSpec DEFAULT;
static { DEFAULT = null; }
}

