/*
 * Copyright (c) 2004, 2013, Oracle and/or its affiliates. All rights reserved.
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



package java.net;


/**
 * Thrown to indicate that a HTTP request needs to be retried
 * but cannot be retried automatically, due to streaming mode
 * being enabled.
 *
 * @author  Michael McMahon
 * @since   1.5
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class HttpRetryException extends java.io.IOException {

/**
 * Constructs a new {@code HttpRetryException} from the
 * specified response code and exception detail message
 *
 * @param   detail   the detail message.
 * @param   code   the HTTP response code from server.
 * @apiSince 1
 */

public HttpRetryException(java.lang.String detail, int code) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new {@code HttpRetryException} with detail message
 * responseCode and the contents of the Location response header field.
 *
 * @param   detail   the detail message.
 * @param   code   the HTTP response code from server.
 * @param   location   the URL to be redirected to
 * @apiSince 1
 */

public HttpRetryException(java.lang.String detail, int code, java.lang.String location) { throw new RuntimeException("Stub!"); }

/**
 * Returns the http response code
 *
 * @return  The http response code.
 * @apiSince 1
 */

public int responseCode() { throw new RuntimeException("Stub!"); }

/**
 * Returns a string explaining why the http request could
 * not be retried.
 *
 * @return  The reason string
 * @apiSince 1
 */

public java.lang.String getReason() { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of the Location header field if the
 * error resulted from redirection.
 *
 * @return The location string
 * @apiSince 1
 */

public java.lang.String getLocation() { throw new RuntimeException("Stub!"); }
}

