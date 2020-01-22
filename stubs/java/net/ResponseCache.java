/*
 * Copyright (c) 2003, 2013, Oracle and/or its affiliates. All rights reserved.
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

import java.io.IOException;
import java.util.Map;

/**
 * Represents implementations of URLConnection caches. An instance of
 * such a class can be registered with the system by doing
 * ResponseCache.setDefault(ResponseCache), and the system will call
 * this object in order to:
 *
 *    <ul><li>store resource data which has been retrieved from an
 *            external source into the cache</li>
 *         <li>try to fetch a requested resource that may have been
 *            stored in the cache</li>
 *    </ul>
 *
 * The ResponseCache implementation decides which resources
 * should be cached, and for how long they should be cached. If a
 * request resource cannot be retrieved from the cache, then the
 * protocol handlers will fetch the resource from its original
 * location.
 *
 * The settings for URLConnection#useCaches controls whether the
 * protocol is allowed to use a cached response.
 *
 * For more information on HTTP caching, see <a
 * href="http://www.ietf.org/rfc/rfc2616.txt"><i>RFC&nbsp;2616: Hypertext
 * Transfer Protocol -- HTTP/1.1</i></a>
 *
 * @author Yingxian Wang
 * @since 1.5
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class ResponseCache {

/** @apiSince 1 */

public ResponseCache() { throw new RuntimeException("Stub!"); }

/**
 * Gets the system-wide response cache.
 *
 * @throws  java.lang.SecurityException
 *          If a security manager has been installed and it denies
 * {@link java.net.NetPermission NetPermission}{@code ("getResponseCache")}
 *
 * @see #setDefault(ResponseCache)
 * @return the system-wide {@code ResponseCache}
 * @since 1.5
 * @apiSince 1
 */

public static synchronized java.net.ResponseCache getDefault() { throw new RuntimeException("Stub!"); }

/**
 * Sets (or unsets) the system-wide cache.
 *
 * Note: non-standard procotol handlers may ignore this setting.
 *
 * @param responseCache The response cache, or
 *          {@code null} to unset the cache.
 *
 * @throws  java.lang.SecurityException
 *          If a security manager has been installed and it denies
 * {@link java.net.NetPermission NetPermission}{@code ("setResponseCache")}
 *
 * @see #getDefault()
 * @since 1.5
 * @apiSince 1
 */

public static synchronized void setDefault(java.net.ResponseCache responseCache) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the cached response based on the requesting uri,
 * request method and request headers. Typically this method is
 * called by the protocol handler before it sends out the request
 * to get the network resource. If a cached response is returned,
 * that resource is used instead.
 *
 * @param uri a {@code URI} used to reference the requested
 *            network resource
 * @param rqstMethod a {@code String} representing the request
 *            method
 * @param rqstHeaders - a Map from request header
 *            field names to lists of field values representing
 *            the current request headers
 * @return a {@code CacheResponse} instance if available
 *          from cache, or null otherwise
 * @throws  java.io.IOException if an I/O error occurs
 * @throws  java.lang.IllegalArgumentException if any one of the arguments is null
 *
 * @see     java.net.URLConnection#setUseCaches(boolean)
 * @see     java.net.URLConnection#getUseCaches()
 * @see     java.net.URLConnection#setDefaultUseCaches(boolean)
 * @see     java.net.URLConnection#getDefaultUseCaches()
 * @apiSince 1
 */

public abstract java.net.CacheResponse get(java.net.URI uri, java.lang.String rqstMethod, java.util.Map<java.lang.String,java.util.List<java.lang.String>> rqstHeaders) throws java.io.IOException;

/**
 * The protocol handler calls this method after a resource has
 * been retrieved, and the ResponseCache must decide whether or
 * not to store the resource in its cache. If the resource is to
 * be cached, then put() must return a CacheRequest object which
 * contains an OutputStream that the protocol handler will
 * use to write the resource into the cache. If the resource is
 * not to be cached, then put must return null.
 *
 * @param uri a {@code URI} used to reference the requested
 *            network resource
 * @param conn - a URLConnection instance that is used to fetch
 *            the response to be cached
 * @return a {@code CacheRequest} for recording the
 *            response to be cached. Null return indicates that
 *            the caller does not intend to cache the response.
 * @throws java.io.IOException if an I/O error occurs
 * @throws java.lang.IllegalArgumentException if any one of the arguments is
 *            null
 * @apiSince 1
 */

public abstract java.net.CacheRequest put(java.net.URI uri, java.net.URLConnection conn) throws java.io.IOException;
}

