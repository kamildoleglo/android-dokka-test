/*
 * Copyright (c) 1998, 2013, Oracle and/or its affiliates. All rights reserved.
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



package java.security.cert;

import java.security.Provider;
import java.io.InputStream;
import java.util.List;
import java.util.Iterator;

/**
 * This class defines the <i>Service Provider Interface</i> (<b>SPI</b>)
 * for the {@code CertificateFactory} class.
 * All the abstract methods in this class must be implemented by each
 * cryptographic service provider who wishes to supply the implementation
 * of a certificate factory for a particular certificate type, e.g., X.509.
 *
 * <p>Certificate factories are used to generate certificate, certification path
 * ({@code CertPath}) and certificate revocation list (CRL) objects from
 * their encodings.
 *
 * <p>A certificate factory for X.509 must return certificates that are an
 * instance of {@code java.security.cert.X509Certificate}, and CRLs
 * that are an instance of {@code java.security.cert.X509CRL}.
 *
 * @author Hemma Prafullchandra
 * @author Jan Luehe
 * @author Sean Mullan
 *
 *
 * @see java.security.cert.CertificateFactory
 * @see java.security.cert.Certificate
 * @see java.security.cert.X509Certificate
 * @see java.security.cert.CertPath
 * @see java.security.cert.CRL
 * @see java.security.cert.X509CRL
 *
 * @since 1.2
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class CertificateFactorySpi {

/** @apiSince 1 */

public CertificateFactorySpi() { throw new RuntimeException("Stub!"); }

/**
 * Generates a certificate object and initializes it with
 * the data read from the input stream {@code inStream}.
 *
 * <p>In order to take advantage of the specialized certificate format
 * supported by this certificate factory,
 * the returned certificate object can be typecast to the corresponding
 * certificate class. For example, if this certificate
 * factory implements X.509 certificates, the returned certificate object
 * can be typecast to the {@code X509Certificate} class.
 *
 * <p>In the case of a certificate factory for X.509 certificates, the
 * certificate provided in {@code inStream} must be DER-encoded and
 * may be supplied in binary or printable (Base64) encoding. If the
 * certificate is provided in Base64 encoding, it must be bounded at
 * the beginning by -----BEGIN CERTIFICATE-----, and must be bounded at
 * the end by -----END CERTIFICATE-----.
 *
 * <p>Note that if the given input stream does not support
 * {@link java.io.InputStream#mark(int) mark} and
 * {@link java.io.InputStream#reset() reset}, this method will
 * consume the entire input stream. Otherwise, each call to this
 * method consumes one certificate and the read position of the input stream
 * is positioned to the next available byte after the inherent
 * end-of-certificate marker. If the data in the
 * input stream does not contain an inherent end-of-certificate marker (other
 * than EOF) and there is trailing data after the certificate is parsed, a
 * {@code CertificateException} is thrown.
 *
 * @param inStream an input stream with the certificate data.
 *
 * @return a certificate object initialized with the data
 * from the input stream.
 *
 * @exception java.security.cert.CertificateException on parsing errors.
 * @apiSince 1
 */

public abstract java.security.cert.Certificate engineGenerateCertificate(java.io.InputStream inStream) throws java.security.cert.CertificateException;

/**
 * Generates a {@code CertPath} object and initializes it with
 * the data read from the {@code InputStream} inStream. The data
 * is assumed to be in the default encoding.
 *
 * <p> This method was added to version 1.4 of the Java 2 Platform
 * Standard Edition. In order to maintain backwards compatibility with
 * existing service providers, this method cannot be {@code abstract}
 * and by default throws an {@code UnsupportedOperationException}.
 *
 * @param inStream an {@code InputStream} containing the data
 * @return a {@code CertPath} initialized with the data from the
 *   {@code InputStream}
 * @exception java.security.cert.CertificateException if an exception occurs while decoding
 * @exception java.lang.UnsupportedOperationException if the method is not supported
 * @since 1.4
 * @apiSince 1
 */

public java.security.cert.CertPath engineGenerateCertPath(java.io.InputStream inStream) throws java.security.cert.CertificateException { throw new RuntimeException("Stub!"); }

/**
 * Generates a {@code CertPath} object and initializes it with
 * the data read from the {@code InputStream} inStream. The data
 * is assumed to be in the specified encoding.
 *
 * <p> This method was added to version 1.4 of the Java 2 Platform
 * Standard Edition. In order to maintain backwards compatibility with
 * existing service providers, this method cannot be {@code abstract}
 * and by default throws an {@code UnsupportedOperationException}.
 *
 * @param inStream an {@code InputStream} containing the data
 * @param encoding the encoding used for the data
 * @return a {@code CertPath} initialized with the data from the
 *   {@code InputStream}
 * @exception java.security.cert.CertificateException if an exception occurs while decoding or
 *   the encoding requested is not supported
 * @exception java.lang.UnsupportedOperationException if the method is not supported
 * @since 1.4
 * @apiSince 1
 */

public java.security.cert.CertPath engineGenerateCertPath(java.io.InputStream inStream, java.lang.String encoding) throws java.security.cert.CertificateException { throw new RuntimeException("Stub!"); }

/**
 * Generates a {@code CertPath} object and initializes it with
 * a {@code List} of {@code Certificate}s.
 * <p>
 * The certificates supplied must be of a type supported by the
 * {@code CertificateFactory}. They will be copied out of the supplied
 * {@code List} object.
 *
 * <p> This method was added to version 1.4 of the Java 2 Platform
 * Standard Edition. In order to maintain backwards compatibility with
 * existing service providers, this method cannot be {@code abstract}
 * and by default throws an {@code UnsupportedOperationException}.
 *
 * @param certificates a {@code List} of {@code Certificate}s
 * @return a {@code CertPath} initialized with the supplied list of
 *   certificates
 * @exception java.security.cert.CertificateException if an exception occurs
 * @exception java.lang.UnsupportedOperationException if the method is not supported
 * @since 1.4
 * @apiSince 1
 */

public java.security.cert.CertPath engineGenerateCertPath(java.util.List<? extends java.security.cert.Certificate> certificates) throws java.security.cert.CertificateException { throw new RuntimeException("Stub!"); }

/**
 * Returns an iteration of the {@code CertPath} encodings supported
 * by this certificate factory, with the default encoding first. See
 * the CertPath Encodings section in the <a href=
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#CertPathEncodings">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard encoding names.
 * <p>
 * Attempts to modify the returned {@code Iterator} via its
 * {@code remove} method result in an
 * {@code UnsupportedOperationException}.
 *
 * <p> This method was added to version 1.4 of the Java 2 Platform
 * Standard Edition. In order to maintain backwards compatibility with
 * existing service providers, this method cannot be {@code abstract}
 * and by default throws an {@code UnsupportedOperationException}.
 *
 * @return an {@code Iterator} over the names of the supported
 *         {@code CertPath} encodings (as {@code String}s)
 * @exception java.lang.UnsupportedOperationException if the method is not supported
 * @since 1.4
 * @apiSince 1
 */

public java.util.Iterator<java.lang.String> engineGetCertPathEncodings() { throw new RuntimeException("Stub!"); }

/**
 * Returns a (possibly empty) collection view of the certificates read
 * from the given input stream {@code inStream}.
 *
 * <p>In order to take advantage of the specialized certificate format
 * supported by this certificate factory, each element in
 * the returned collection view can be typecast to the corresponding
 * certificate class. For example, if this certificate
 * factory implements X.509 certificates, the elements in the returned
 * collection can be typecast to the {@code X509Certificate} class.
 *
 * <p>In the case of a certificate factory for X.509 certificates,
 * {@code inStream} may contain a single DER-encoded certificate
 * in the formats described for
 * {@link java.security.cert.CertificateFactory#generateCertificate(java.io.InputStream) CertificateFactory#generateCertificate(java.io.InputStream)}.
 * In addition, {@code inStream} may contain a PKCS#7 certificate
 * chain. This is a PKCS#7 <i>SignedData</i> object, with the only
 * significant field being <i>certificates</i>. In particular, the
 * signature and the contents are ignored. This format allows multiple
 * certificates to be downloaded at once. If no certificates are present,
 * an empty collection is returned.
 *
 * <p>Note that if the given input stream does not support
 * {@link java.io.InputStream#mark(int) mark} and
 * {@link java.io.InputStream#reset() reset}, this method will
 * consume the entire input stream.
 *
 * @param inStream the input stream with the certificates.
 *
 * @return a (possibly empty) collection view of
 * java.security.cert.Certificate objects
 * initialized with the data from the input stream.
 *
 * @exception java.security.cert.CertificateException on parsing errors.
 * @apiSince 1
 */

public abstract java.util.Collection<? extends java.security.cert.Certificate> engineGenerateCertificates(java.io.InputStream inStream) throws java.security.cert.CertificateException;

/**
 * Generates a certificate revocation list (CRL) object and initializes it
 * with the data read from the input stream {@code inStream}.
 *
 * <p>In order to take advantage of the specialized CRL format
 * supported by this certificate factory,
 * the returned CRL object can be typecast to the corresponding
 * CRL class. For example, if this certificate
 * factory implements X.509 CRLs, the returned CRL object
 * can be typecast to the {@code X509CRL} class.
 *
 * <p>Note that if the given input stream does not support
 * {@link java.io.InputStream#mark(int) mark} and
 * {@link java.io.InputStream#reset() reset}, this method will
 * consume the entire input stream. Otherwise, each call to this
 * method consumes one CRL and the read position of the input stream
 * is positioned to the next available byte after the inherent
 * end-of-CRL marker. If the data in the
 * input stream does not contain an inherent end-of-CRL marker (other
 * than EOF) and there is trailing data after the CRL is parsed, a
 * {@code CRLException} is thrown.
 *
 * @param inStream an input stream with the CRL data.
 *
 * @return a CRL object initialized with the data
 * from the input stream.
 *
 * @exception java.security.cert.CRLException on parsing errors.
 * @apiSince 1
 */

public abstract java.security.cert.CRL engineGenerateCRL(java.io.InputStream inStream) throws java.security.cert.CRLException;

/**
 * Returns a (possibly empty) collection view of the CRLs read
 * from the given input stream {@code inStream}.
 *
 * <p>In order to take advantage of the specialized CRL format
 * supported by this certificate factory, each element in
 * the returned collection view can be typecast to the corresponding
 * CRL class. For example, if this certificate
 * factory implements X.509 CRLs, the elements in the returned
 * collection can be typecast to the {@code X509CRL} class.
 *
 * <p>In the case of a certificate factory for X.509 CRLs,
 * {@code inStream} may contain a single DER-encoded CRL.
 * In addition, {@code inStream} may contain a PKCS#7 CRL
 * set. This is a PKCS#7 <i>SignedData</i> object, with the only
 * significant field being <i>crls</i>. In particular, the
 * signature and the contents are ignored. This format allows multiple
 * CRLs to be downloaded at once. If no CRLs are present,
 * an empty collection is returned.
 *
 * <p>Note that if the given input stream does not support
 * {@link java.io.InputStream#mark(int) mark} and
 * {@link java.io.InputStream#reset() reset}, this method will
 * consume the entire input stream.
 *
 * @param inStream the input stream with the CRLs.
 *
 * @return a (possibly empty) collection view of
 * java.security.cert.CRL objects initialized with the data from the input
 * stream.
 *
 * @exception java.security.cert.CRLException on parsing errors.
 * @apiSince 1
 */

public abstract java.util.Collection<? extends java.security.cert.CRL> engineGenerateCRLs(java.io.InputStream inStream) throws java.security.cert.CRLException;
}

