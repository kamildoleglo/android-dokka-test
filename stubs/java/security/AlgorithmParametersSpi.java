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

import java.io.*;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;

/**
 * This class defines the <i>Service Provider Interface</i> (<b>SPI</b>)
 * for the {@code AlgorithmParameters} class, which is used to manage
 * algorithm parameters.
 *
 * <p> All the abstract methods in this class must be implemented by each
 * cryptographic service provider who wishes to supply parameter management
 * for a particular algorithm.
 *
 * @author Jan Luehe
 *
 *
 * @see java.security.AlgorithmParameters
 * @see java.security.spec.AlgorithmParameterSpec
 * @see java.security.spec.DSAParameterSpec
 *
 * @since 1.2
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class AlgorithmParametersSpi {

/** @apiSince 1 */

public AlgorithmParametersSpi() { throw new RuntimeException("Stub!"); }

/**
 * Initializes this parameters object using the parameters
 * specified in {@code paramSpec}.
 *
 * @param paramSpec the parameter specification.
 *
 * @exception java.security.spec.InvalidParameterSpecException if the given parameter
 * specification is inappropriate for the initialization of this parameter
 * object.
 * @apiSince 1
 */

protected abstract void engineInit(java.security.spec.AlgorithmParameterSpec paramSpec) throws java.security.spec.InvalidParameterSpecException;

/**
 * Imports the specified parameters and decodes them
 * according to the primary decoding format for parameters.
 * The primary decoding format for parameters is ASN.1, if an ASN.1
 * specification for this type of parameters exists.
 *
 * @param params the encoded parameters.
 *
 * @exception java.io.IOException on decoding errors
 * @apiSince 1
 */

protected abstract void engineInit(byte[] params) throws java.io.IOException;

/**
 * Imports the parameters from {@code params} and
 * decodes them according to the specified decoding format.
 * If {@code format} is null, the
 * primary decoding format for parameters is used. The primary decoding
 * format is ASN.1, if an ASN.1 specification for these parameters
 * exists.
 *
 * @param params the encoded parameters.
 *
 * @param format the name of the decoding format.
 *
 * @exception java.io.IOException on decoding errors
 * @apiSince 1
 */

protected abstract void engineInit(byte[] params, java.lang.String format) throws java.io.IOException;

/**
 * Returns a (transparent) specification of this parameters
 * object.
 * {@code paramSpec} identifies the specification class in which
 * the parameters should be returned. It could, for example, be
 * {@code DSAParameterSpec.class}, to indicate that the
 * parameters should be returned in an instance of the
 * {@code DSAParameterSpec} class.
 *
 * @param <T> the type of the parameter specification to be returned
 *
 * @param paramSpec the specification class in which
 * the parameters should be returned.
 *
 * @return the parameter specification.
 *
 * @exception java.security.spec.InvalidParameterSpecException if the requested parameter
 * specification is inappropriate for this parameter object.
 * @apiSince 1
 */

protected abstract <T extends java.security.spec.AlgorithmParameterSpec> T engineGetParameterSpec(java.lang.Class<T> paramSpec) throws java.security.spec.InvalidParameterSpecException;

/**
 * Returns the parameters in their primary encoding format.
 * The primary encoding format for parameters is ASN.1, if an ASN.1
 * specification for this type of parameters exists.
 *
 * @return the parameters encoded using their primary encoding format.
 *
 * @exception java.io.IOException on encoding errors.
 * @apiSince 1
 */

protected abstract byte[] engineGetEncoded() throws java.io.IOException;

/**
 * Returns the parameters encoded in the specified format.
 * If {@code format} is null, the
 * primary encoding format for parameters is used. The primary encoding
 * format is ASN.1, if an ASN.1 specification for these parameters
 * exists.
 *
 * @param format the name of the encoding format.
 *
 * @return the parameters encoded using the specified encoding scheme.
 *
 * @exception java.io.IOException on encoding errors.
 * @apiSince 1
 */

protected abstract byte[] engineGetEncoded(java.lang.String format) throws java.io.IOException;

/**
 * Returns a formatted string describing the parameters.
 *
 * @return a formatted string describing the parameters.
 * @apiSince 1
 */

protected abstract java.lang.String engineToString();
}

