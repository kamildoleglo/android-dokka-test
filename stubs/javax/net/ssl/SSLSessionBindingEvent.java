/*
 * Copyright (c) 1997, 2005, Oracle and/or its affiliates. All rights reserved.
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


/**
 * This event is propagated to a SSLSessionBindingListener.
 * When a listener object is bound or unbound to an SSLSession by
 * {@link javax.net.ssl.SSLSession#putValue(java.lang.String,java.lang.Object) SSLSession#putValue(String, Object)}
 * or {@link javax.net.ssl.SSLSession#removeValue(java.lang.String) SSLSession#removeValue(String)}, objects which
 * implement the SSLSessionBindingListener will be receive an
 * event of this type.  The event's <code>name</code> field is the
 * key in which the listener is being bound or unbound.
 *
 * @see javax.net.ssl.SSLSession
 * @see javax.net.ssl.SSLSessionBindingListener
 *
 * @since 1.4
 * @author Nathan Abramson
 * @author David Brownell
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SSLSessionBindingEvent extends java.util.EventObject {

/**
 * Constructs a new SSLSessionBindingEvent.
 *
 * @param session the SSLSession acting as the source of the event
 * @param name the name to which the object is being bound or unbound
 * @exception  java.lang.IllegalArgumentException  if <code>session</code> is null.
 * @apiSince 1
 */

public SSLSessionBindingEvent(javax.net.ssl.SSLSession session, java.lang.String name) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Returns the name to which the object is being bound, or the name
 * from which the object is being unbound.
 *
 * @return the name to which the object is being bound or unbound
 * @apiSince 1
 */

public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * Returns the SSLSession into which the listener is being bound or
 * from which the listener is being unbound.
 *
 * @return the <code>SSLSession</code>
 * @apiSince 1
 */

public javax.net.ssl.SSLSession getSession() { throw new RuntimeException("Stub!"); }
}

