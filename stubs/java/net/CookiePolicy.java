/*
 * Copyright (c) 2005, 2013, Oracle and/or its affiliates. All rights reserved.
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
 * CookiePolicy implementations decide which cookies should be accepted
 * and which should be rejected. Three pre-defined policy implementations
 * are provided, namely ACCEPT_ALL, ACCEPT_NONE and ACCEPT_ORIGINAL_SERVER.
 *
 * <p>See RFC 2965 sec. 3.3 and 7 for more detail.
 *
 * @author Edward Wang
 * @since 1.6
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface CookiePolicy {

/**
 * Will be called to see whether or not this cookie should be accepted.
 *
 * @param uri       the URI to consult accept policy with
 * @param cookie    the HttpCookie object in question
 * @return          {@code true} if this cookie should be accepted;
 *                  otherwise, {@code false}
 * @apiSince 9
 */

public boolean shouldAccept(java.net.URI uri, java.net.HttpCookie cookie);

/**
 * One pre-defined policy which accepts all cookies.
 * @apiSince 9
 */

public static final java.net.CookiePolicy ACCEPT_ALL = null;

/**
 * One pre-defined policy which accepts no cookies.
 * @apiSince 9
 */

public static final java.net.CookiePolicy ACCEPT_NONE = null;

/**
 * One pre-defined policy which only accepts cookies from original server.
 * @apiSince 9
 */

public static final java.net.CookiePolicy ACCEPT_ORIGINAL_SERVER = null;
}

