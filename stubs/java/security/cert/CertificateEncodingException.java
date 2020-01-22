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



package java.security.cert;


/**
 * Certificate Encoding Exception. This is thrown whenever an error
 * occurs while attempting to encode a certificate.
 *
 * @author Hemma Prafullchandra
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class CertificateEncodingException extends java.security.cert.CertificateException {

/**
 * Constructs a CertificateEncodingException with no detail message. A
 * detail message is a String that describes this particular
 * exception.
 * @apiSince 1
 */

public CertificateEncodingException() { throw new RuntimeException("Stub!"); }

/**
 * Constructs a CertificateEncodingException with the specified detail
 * message. A detail message is a String that describes this
 * particular exception.
 *
 * @param message the detail message.
 * @apiSince 1
 */

public CertificateEncodingException(java.lang.String message) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code CertificateEncodingException} with the specified
 * detail message and cause.
 *
 * @param message the detail message (which is saved for later retrieval
 *        by the {@link #getMessage()} method).
 * @param cause the cause (which is saved for later retrieval by the
 *        {@link #getCause()} method).  (A {@code null} value is permitted,
 *        and indicates that the cause is nonexistent or unknown.)
 * @since 1.5
 * @apiSince 1
 */

public CertificateEncodingException(java.lang.String message, java.lang.Throwable cause) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code CertificateEncodingException}
 * with the specified cause and a detail message of
 * {@code (cause==null ? null : cause.toString())}
 * (which typically contains the class and detail message of
 * {@code cause}).
 *
 * @param cause the cause (which is saved for later retrieval by the
 *        {@link #getCause()} method).  (A {@code null} value is permitted,
 *        and indicates that the cause is nonexistent or unknown.)
 * @since 1.5
 * @apiSince 1
 */

public CertificateEncodingException(java.lang.Throwable cause) { throw new RuntimeException("Stub!"); }
}

