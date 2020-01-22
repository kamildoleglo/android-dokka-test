/*
 * Copyright (c) 2000, 2013, Oracle and/or its affiliates. All rights reserved.
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


/**
 * An exception indicating one of a variety of problems encountered when
 * validating a certification path.
 * <p>
 * A {@code CertPathValidatorException} provides support for wrapping
 * exceptions. The {@link #getCause getCause} method returns the throwable,
 * if any, that caused this exception to be thrown.
 * <p>
 * A {@code CertPathValidatorException} may also include the
 * certification path that was being validated when the exception was thrown,
 * the index of the certificate in the certification path that caused the
 * exception to be thrown, and the reason that caused the failure. Use the
 * {@link #getCertPath getCertPath}, {@link #getIndex getIndex}, and
 * {@link #getReason getReason} methods to retrieve this information.
 *
 * <p>
 * <b>Concurrent Access</b>
 * <p>
 * Unless otherwise specified, the methods defined in this class are not
 * thread-safe. Multiple threads that need to access a single
 * object concurrently should synchronize amongst themselves and
 * provide the necessary locking. Multiple threads each manipulating
 * separate objects need not synchronize.
 *
 * @see java.security.cert.CertPathValidator
 *
 * @since       1.4
 * @author      Yassir Elley
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class CertPathValidatorException extends java.security.GeneralSecurityException {

/**
 * Creates a {@code CertPathValidatorException} with
 * no detail message.
 * @apiSince 1
 */

public CertPathValidatorException() { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code CertPathValidatorException} with the given
 * detail message. A detail message is a {@code String} that
 * describes this particular exception.
 *
 * @param msg the detail message
 * @apiSince 1
 */

public CertPathValidatorException(java.lang.String msg) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code CertPathValidatorException} that wraps the
 * specified throwable. This allows any exception to be converted into a
 * {@code CertPathValidatorException}, while retaining information
 * about the wrapped exception, which may be useful for debugging. The
 * detail message is set to ({@code cause==null ? null : cause.toString()})
 * (which typically contains the class and detail message of
 * cause).
 *
 * @param cause the cause (which is saved for later retrieval by the
 * {@link #getCause getCause()} method). (A {@code null} value is
 * permitted, and indicates that the cause is nonexistent or unknown.)
 * @apiSince 1
 */

public CertPathValidatorException(java.lang.Throwable cause) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code CertPathValidatorException} with the specified
 * detail message and cause.
 *
 * @param msg the detail message
 * @param cause the cause (which is saved for later retrieval by the
 * {@link #getCause getCause()} method). (A {@code null} value is
 * permitted, and indicates that the cause is nonexistent or unknown.)
 * @apiSince 1
 */

public CertPathValidatorException(java.lang.String msg, java.lang.Throwable cause) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code CertPathValidatorException} with the specified
 * detail message, cause, certification path, and index.
 *
 * @param msg the detail message (or {@code null} if none)
 * @param cause the cause (or {@code null} if none)
 * @param certPath the certification path that was in the process of
 * being validated when the error was encountered
 * @param index the index of the certificate in the certification path
 * that caused the error (or -1 if not applicable). Note that
 * the list of certificates in a {@code CertPath} is zero based.
 * @throws java.lang.IndexOutOfBoundsException if the index is out of range
 * {@code (index < -1 || (certPath != null && index >=
 * certPath.getCertificates().size()) }
 * @throws java.lang.IllegalArgumentException if {@code certPath} is
 * {@code null} and {@code index} is not -1
 * @apiSince 1
 */

public CertPathValidatorException(java.lang.String msg, java.lang.Throwable cause, java.security.cert.CertPath certPath, int index) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code CertPathValidatorException} with the specified
 * detail message, cause, certification path, index, and reason.
 *
 * @param msg the detail message (or {@code null} if none)
 * @param cause the cause (or {@code null} if none)
 * @param certPath the certification path that was in the process of
 * being validated when the error was encountered
 * @param index the index of the certificate in the certification path
 * that caused the error (or -1 if not applicable). Note that
 * the list of certificates in a {@code CertPath} is zero based.
 * @param reason the reason the validation failed
 * @throws java.lang.IndexOutOfBoundsException if the index is out of range
 * {@code (index < -1 || (certPath != null && index >=
 * certPath.getCertificates().size()) }
 * @throws java.lang.IllegalArgumentException if {@code certPath} is
 * {@code null} and {@code index} is not -1
 * @throws java.lang.NullPointerException if {@code reason} is {@code null}
 *
 * @since 1.7
 * @apiSince 24
 */

public CertPathValidatorException(java.lang.String msg, java.lang.Throwable cause, java.security.cert.CertPath certPath, int index, java.security.cert.CertPathValidatorException.Reason reason) { throw new RuntimeException("Stub!"); }

/**
 * Returns the certification path that was being validated when
 * the exception was thrown.
 *
 * @return the {@code CertPath} that was being validated when
 * the exception was thrown (or {@code null} if not specified)
 * @apiSince 1
 */

public java.security.cert.CertPath getCertPath() { throw new RuntimeException("Stub!"); }

/**
 * Returns the index of the certificate in the certification path
 * that caused the exception to be thrown. Note that the list of
 * certificates in a {@code CertPath} is zero based. If no
 * index has been set, -1 is returned.
 *
 * @return the index that has been set, or -1 if none has been set
 * @apiSince 1
 */

public int getIndex() { throw new RuntimeException("Stub!"); }

/**
 * Returns the reason that the validation failed. The reason is
 * associated with the index of the certificate returned by
 * {@link #getIndex}.
 *
 * @return the reason that the validation failed, or
 *    {@code BasicReason.UNSPECIFIED} if a reason has not been
 *    specified
 *
 * @since 1.7
 * @apiSince 24
 */

public java.security.cert.CertPathValidatorException.Reason getReason() { throw new RuntimeException("Stub!"); }
/**
 * The BasicReason enumerates the potential reasons that a certification
 * path of any type may be invalid.
 *
 * @since 1.7
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum BasicReason implements java.security.cert.CertPathValidatorException.Reason {
/**
 * Unspecified reason.
 * @apiSince 24
 */

UNSPECIFIED,
/**
 * The certificate is expired.
 * @apiSince 24
 */

EXPIRED,
/**
 * The certificate is not yet valid.
 * @apiSince 24
 */

NOT_YET_VALID,
/**
 * The certificate is revoked.
 * @apiSince 24
 */

REVOKED,
/**
 * The revocation status of the certificate could not be determined.
 * @apiSince 24
 */

UNDETERMINED_REVOCATION_STATUS,
/**
 * The signature is invalid.
 * @apiSince 24
 */

INVALID_SIGNATURE,
/**
 * The public key or the signature algorithm has been constrained.
 * @apiSince 24
 */

ALGORITHM_CONSTRAINED;
}

/**
 * The reason the validation algorithm failed.
 *
 * @since 1.7
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface Reason extends java.io.Serializable {
}

}

