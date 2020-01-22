/*
 * Copyright (c) 2005, 2006, Oracle and/or its affiliates. All rights reserved.
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

/*
 * Created on Apr 28, 2005
 */


package javax.sql;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * A <code>StatementEvent</code> is sent to all <code>StatementEventListener</code>s which were
 * registered with a <code>PooledConnection</code>. This occurs when the driver determines that a
 * <code>PreparedStatement</code> that is associated with the <code>PooledConnection</code> has been closed or the driver determines
 * is invalid.
 * <p>
 * @since 1.6
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class StatementEvent extends java.util.EventObject {

/**
 * Constructs a <code>StatementEvent</code> with the specified <code>PooledConnection</code> and
 * <code>PreparedStatement</code>.  The <code>SQLException</code> contained in the event defaults to
 * null.
 * <p>
 * @param con                   The <code>PooledConnection</code> that the closed or invalid
 * <code>PreparedStatement</code>is associated with.
 * @param statement             The <code>PreparedStatement</code> that is bieng closed or is invalid
 * <p>
 * @throws java.lang.IllegalArgumentException if <code>con</code> is null.
 *
 * @since 1.6
 * @apiSince 9
 */

public StatementEvent(javax.sql.PooledConnection con, java.sql.PreparedStatement statement) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Constructs a <code>StatementEvent</code> with the specified <code>PooledConnection</code>,
 * <code>PreparedStatement</code> and <code>SQLException</code>
 * <p>
 * @param con                   The <code>PooledConnection</code> that the closed or invalid <code>PreparedStatement</code>
 * is associated with.
 * @param statement             The <code>PreparedStatement</code> that is being closed or is invalid
 * @param exception             The <code>SQLException </code>the driver is about to throw to
 *                                              the application
 *
 * @throws java.lang.IllegalArgumentException if <code>con</code> is null.
 * <p>
 * @since 1.6
 * @apiSince 9
 */

public StatementEvent(javax.sql.PooledConnection con, java.sql.PreparedStatement statement, java.sql.SQLException exception) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Returns the <code>PreparedStatement</code> that is being closed or is invalid
 * <p>
 * @return      The <code>PreparedStatement</code> that is being closed or is invalid
 * <p>
 * @since 1.6
 * @apiSince 9
 */

public java.sql.PreparedStatement getStatement() { throw new RuntimeException("Stub!"); }

/**
 * Returns the <code>SQLException</code> the driver is about to throw
 * <p>
 * @return      The <code>SQLException</code> the driver is about to throw
 * <p>
 * @since 1.6
 * @apiSince 9
 */

public java.sql.SQLException getSQLException() { throw new RuntimeException("Stub!"); }
}

