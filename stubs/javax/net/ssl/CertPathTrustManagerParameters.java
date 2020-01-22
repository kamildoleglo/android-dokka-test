/*
 * Copyright (c) 2003, Oracle and/or its affiliates. All rights reserved.
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

import java.security.cert.CertPathParameters;

/**
 * A wrapper for CertPathParameters. This class is used to pass validation
 * settings to CertPath based {@link javax.net.ssl.TrustManager TrustManager}s using the
 * {@link javax.net.ssl.TrustManagerFactory#init(javax.net.ssl.ManagerFactoryParameters) TrustManagerFactory#init(ManagerFactoryParameters)} method.
 *
 * <p>Instances of this class are immutable.
 *
 * @see javax.net.ssl.X509TrustManager
 * @see javax.net.ssl.TrustManagerFactory
 * @see java.security.cert.CertPathParameters
 *
 * @since   1.5
 * @author  Andreas Sterbenz
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class CertPathTrustManagerParameters implements javax.net.ssl.ManagerFactoryParameters {

/**
 * Construct new CertPathTrustManagerParameters from the specified
 * parameters. The parameters are cloned to protect against subsequent
 * modification.
 *
 * @param parameters the CertPathParameters to be used
 *
 * @throws java.lang.NullPointerException if parameters is null
 * @apiSince 1
 */

public CertPathTrustManagerParameters(java.security.cert.CertPathParameters parameters) { throw new RuntimeException("Stub!"); }

/**
 * Return a clone of the CertPathParameters encapsulated by this class.
 *
 * @return a clone of the CertPathParameters encapsulated by this class.
 * @apiSince 1
 */

public java.security.cert.CertPathParameters getParameters() { throw new RuntimeException("Stub!"); }
}

