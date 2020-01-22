/*
 * Copyright (c) 2000, 2006, Oracle and/or its affiliates. All rights reserved.
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



package javax.sql;

import java.sql.SQLException;

/**
 * <P>An <code>Event</code> object that provides information about the
 * source of a connection-related event.  <code>ConnectionEvent</code>
 * objects are generated when an application closes a pooled connection
 * and when an error occurs.  The <code>ConnectionEvent</code> object
 * contains two kinds of information:
 * <UL>
 *   <LI>The pooled connection closed by the application
 *   <LI>In the case of an error event, the <code>SQLException</code>
 *       about to be thrown to the application
 * </UL>
 *
 * @since 1.4
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ConnectionEvent extends java.util.EventObject {

/**
 * <P>Constructs a <code>ConnectionEvent</code> object initialized with
 * the given <code>PooledConnection</code> object. <code>SQLException</code>
 * defaults to <code>null</code>.
 *
 * @param con the pooled connection that is the source of the event
 * @throws java.lang.IllegalArgumentException if <code>con</code> is null.
 * @apiSince 1
 */

public ConnectionEvent(javax.sql.PooledConnection con) { super(null); throw new RuntimeException("Stub!"); }

/**
 * <P>Constructs a <code>ConnectionEvent</code> object initialized with
 * the given <code>PooledConnection</code> object and
 * <code>SQLException</code> object.
 *
 * @param con the pooled connection that is the source of the event
 * @param ex the SQLException about to be thrown to the application
 * @throws java.lang.IllegalArgumentException if <code>con</code> is null.
 * @apiSince 1
 */

public ConnectionEvent(javax.sql.PooledConnection con, java.sql.SQLException ex) { super(null); throw new RuntimeException("Stub!"); }

/**
 * <P>Retrieves the <code>SQLException</code> for this
 * <code>ConnectionEvent</code> object. May be <code>null</code>.
 *
 * @return the SQLException about to be thrown or <code>null</code>
 * @apiSince 1
 */

public java.sql.SQLException getSQLException() { throw new RuntimeException("Stub!"); }
}

