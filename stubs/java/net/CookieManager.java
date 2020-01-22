/*
 * Copyright (C) 2014 The Android Open Source Project
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
 * CookieManager provides a concrete implementation of {@link java.net.CookieHandler CookieHandler},
 * which separates the storage of cookies from the policy surrounding accepting
 * and rejecting cookies. A CookieManager is initialized with a {@link java.net.CookieStore CookieStore}
 * which manages storage, and a {@link java.net.CookiePolicy CookiePolicy} object, which makes
 * policy decisions on cookie acceptance/rejection.
 *
 * <p> The HTTP cookie management in java.net package looks like:
 * <blockquote>
 * <pre>{@code
 *                  use
 * CookieHandler <------- HttpURLConnection
 *       ^
 *       | impl
 *       |         use
 * CookieManager -------> CookiePolicy
 *             |   use
 *             |--------> HttpCookie
 *             |              ^
 *             |              | use
 *             |   use        |
 *             |--------> CookieStore
 *                            ^
 *                            | impl
 *                            |
 *                  Internal in-memory implementation
 * }</pre>
 * <ul>
 *   <li>
 *     CookieHandler is at the core of cookie management. User can call
 *     CookieHandler.setDefault to set a concrete CookieHanlder implementation
 *     to be used.
 *   </li>
 *   <li>
 *     CookiePolicy.shouldAccept will be called by CookieManager.put to see whether
 *     or not one cookie should be accepted and put into cookie store. User can use
 *     any of three pre-defined CookiePolicy, namely ACCEPT_ALL, ACCEPT_NONE and
 *     ACCEPT_ORIGINAL_SERVER, or user can define his own CookiePolicy implementation
 *     and tell CookieManager to use it.
 *   </li>
 *   <li>
 *     CookieStore is the place where any accepted HTTP cookie is stored in.
 *     If not specified when created, a CookieManager instance will use an internal
 *     in-memory implementation. Or user can implements one and tell CookieManager
 *     to use it.
 *   </li>
 *   <li>
 *     Currently, only CookieStore.add(URI, HttpCookie) and CookieStore.get(URI)
 *     are used by CookieManager. Others are for completeness and might be needed
 *     by a more sophisticated CookieStore implementation, e.g. a NetscapeCookieSotre.
 *   </li>
 * </ul>
 * </blockquote>
 *
 * <p>There're various ways user can hook up his own HTTP cookie management behavior, e.g.
 * <blockquote>
 * <ul>
 *   <li>Use CookieHandler.setDefault to set a brand new {@link java.net.CookieHandler CookieHandler} implementation
 *   <li>Let CookieManager be the default {@link java.net.CookieHandler CookieHandler} implementation,
 *       but implement user's own {@link java.net.CookieStore CookieStore} and {@link java.net.CookiePolicy CookiePolicy}
 *       and tell default CookieManager to use them:
 *     <blockquote><pre>
 *       // this should be done at the beginning of an HTTP session
 *       CookieHandler.setDefault(new CookieManager(new MyCookieStore(), new MyCookiePolicy()));
 *     </pre></blockquote>
 *   <li>Let CookieManager be the default {@link java.net.CookieHandler CookieHandler} implementation, but
 *       use customized {@link java.net.CookiePolicy CookiePolicy}:
 *     <blockquote><pre>
 *       // this should be done at the beginning of an HTTP session
 *       CookieHandler.setDefault(new CookieManager());
 *       // this can be done at any point of an HTTP session
 *       ((CookieManager)CookieHandler.getDefault()).setCookiePolicy(new MyCookiePolicy());
 *     </pre></blockquote>
 * </ul>
 * </blockquote>
 *
 * <p>The implementation conforms to <a href="http://www.ietf.org/rfc/rfc2965.txt">RFC 2965</a>, section 3.3.
 *
 * @see java.net.CookiePolicy
 * @author Edward Wang
 * @since 1.6
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class CookieManager extends java.net.CookieHandler {

/**
 * Create a new cookie manager.
 *
 * <p>This constructor will create new cookie manager with default
 * cookie store and accept policy. The effect is same as
 * {@code CookieManager(null, null)}.
 * @apiSince 9
 */

public CookieManager() { throw new RuntimeException("Stub!"); }

/**
 * Create a new cookie manager with specified cookie store and cookie policy.
 *
 * @param store     a {@code CookieStore} to be used by cookie manager.
 *                  if {@code null}, cookie manager will use a default one,
 *                  which is an in-memory CookieStore implementation.
 * @param cookiePolicy      a {@code CookiePolicy} instance
 *                          to be used by cookie manager as policy callback.
 *                          if {@code null}, ACCEPT_ORIGINAL_SERVER will
 *                          be used.
 * @apiSince 9
 */

public CookieManager(java.net.CookieStore store, java.net.CookiePolicy cookiePolicy) { throw new RuntimeException("Stub!"); }

/**
 * To set the cookie policy of this cookie manager.
 *
 * <p> A instance of {@code CookieManager} will have
 * cookie policy ACCEPT_ORIGINAL_SERVER by default. Users always
 * can call this method to set another cookie policy.
 *
 * @param cookiePolicy      the cookie policy. Can be {@code null}, which
 *                          has no effects on current cookie policy.
 * @apiSince 9
 */

public void setCookiePolicy(java.net.CookiePolicy cookiePolicy) { throw new RuntimeException("Stub!"); }

/**
 * To retrieve current cookie store.
 *
 * @return  the cookie store currently used by cookie manager.
 * @apiSince 9
 */

public java.net.CookieStore getCookieStore() { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public java.util.Map<java.lang.String,java.util.List<java.lang.String>> get(java.net.URI uri, java.util.Map<java.lang.String,java.util.List<java.lang.String>> requestHeaders) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public void put(java.net.URI uri, java.util.Map<java.lang.String,java.util.List<java.lang.String>> responseHeaders) throws java.io.IOException { throw new RuntimeException("Stub!"); }
}

