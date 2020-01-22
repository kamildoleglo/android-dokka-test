/*
 * Copyright (c) 2003, 2012, Oracle and/or its affiliates. All rights reserved.
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



package java.util;

import java.io.NotSerializableException;

/**
 * Thrown to indicate that an operation could not complete because
 * the input did not conform to the appropriate XML document type
 * for a collection of properties, as per the {@link java.util.Properties Properties}
 * specification.<p>
 *
 * Note, that although InvalidPropertiesFormatException inherits Serializable
 * interface from Exception, it is not intended to be Serializable. Appropriate
 * serialization methods are implemented to throw NotSerializableException.
 *
 * @see     java.util.Properties
 * @since   1.5
 * @serial exclude
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class InvalidPropertiesFormatException extends java.io.IOException {

/**
 * Constructs an InvalidPropertiesFormatException with the specified
 * cause.
 *
 * @param  cause the cause (which is saved for later retrieval by the
 *         {@link java.lang.Throwable#getCause() Throwable#getCause()} method).
 * @apiSince 1
 */

public InvalidPropertiesFormatException(java.lang.Throwable cause) { throw new RuntimeException("Stub!"); }

/**
 * Constructs an InvalidPropertiesFormatException with the specified
 * detail message.
 *
 * @param   message   the detail message. The detail message is saved for
 *          later retrieval by the {@link java.lang.Throwable#getMessage() Throwable#getMessage()} method.
 * @apiSince 1
 */

public InvalidPropertiesFormatException(java.lang.String message) { throw new RuntimeException("Stub!"); }
}

