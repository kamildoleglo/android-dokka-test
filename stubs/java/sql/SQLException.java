/*
 * Copyright (c) 1996, 2006, Oracle and/or its affiliates. All rights reserved.
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



package java.sql;


/**
 * <P>An exception that provides information on a database access
 * error or other errors.
 *
 * <P>Each <code>SQLException</code> provides several kinds of information:
 * <UL>
 *   <LI> a string describing the error.  This is used as the Java Exception
 *       message, available via the method <code>getMesasge</code>.
 *   <LI> a "SQLstate" string, which follows either the XOPEN SQLstate conventions
 *        or the SQL:2003 conventions.
 *       The values of the SQLState string are described in the appropriate spec.
 *       The <code>DatabaseMetaData</code> method <code>getSQLStateType</code>
 *       can be used to discover whether the driver returns the XOPEN type or
 *       the SQL:2003 type.
 *   <LI> an integer error code that is specific to each vendor.  Normally this will
 *       be the actual error code returned by the underlying database.
 *   <LI> a chain to a next Exception.  This can be used to provide additional
 *       error information.
 *   <LI> the causal relationship, if any for this <code>SQLException</code>.
 * </UL>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SQLException extends java.lang.Exception implements java.lang.Iterable<java.lang.Throwable> {

/**
 *  Constructs a <code>SQLException</code> object with a given
 * <code>reason</code>, <code>SQLState</code>  and
 * <code>vendorCode</code>.
 *
 * The <code>cause</code> is not initialized, and may subsequently be
 * initialized by a call to the
 * {@link java.lang.Throwable#initCause(java.lang.Throwable) Throwable#initCause(java.lang.Throwable)} method.
 * <p>
 * @param reason a description of the exception
 * @param SQLState an XOPEN or SQL:2003 code identifying the exception
 * @param vendorCode a database vendor-specific exception code
 * @apiSince 1
 */

public SQLException(java.lang.String reason, java.lang.String SQLState, int vendorCode) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a <code>SQLException</code> object with a given
 * <code>reason</code> and <code>SQLState</code>.
 *
 * The <code>cause</code> is not initialized, and may subsequently be
 * initialized by a call to the
 * {@link java.lang.Throwable#initCause(java.lang.Throwable) Throwable#initCause(java.lang.Throwable)} method. The vendor code
 * is initialized to 0.
 * <p>
 * @param reason a description of the exception
 * @param SQLState an XOPEN or SQL:2003 code identifying the exception
 * @apiSince 1
 */

public SQLException(java.lang.String reason, java.lang.String SQLState) { throw new RuntimeException("Stub!"); }

/**
 *  Constructs a <code>SQLException</code> object with a given
 * <code>reason</code>. The  <code>SQLState</code>  is initialized to
 * <code>null</code> and the vender code is initialized to 0.
 *
 * The <code>cause</code> is not initialized, and may subsequently be
 * initialized by a call to the
 * {@link java.lang.Throwable#initCause(java.lang.Throwable) Throwable#initCause(java.lang.Throwable)} method.
 * <p>
 * @param reason a description of the exception
 * @apiSince 1
 */

public SQLException(java.lang.String reason) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a <code>SQLException</code> object.
 * The <code>reason</code>, <code>SQLState</code> are initialized
 * to <code>null</code> and the vendor code is initialized to 0.
 *
 * The <code>cause</code> is not initialized, and may subsequently be
 * initialized by a call to the
 * {@link java.lang.Throwable#initCause(java.lang.Throwable) Throwable#initCause(java.lang.Throwable)} method.
 * <p>
 * @apiSince 1
 */

public SQLException() { throw new RuntimeException("Stub!"); }

/**
 *  Constructs a <code>SQLException</code> object with a given
 * <code>cause</code>.
 * The <code>SQLState</code> is initialized
 * to <code>null</code> and the vendor code is initialized to 0.
 * The <code>reason</code>  is initialized to <code>null</code> if
 * <code>cause==null</code> or to <code>cause.toString()</code> if
 * <code>cause!=null</code>.
 * <p>
 * @param cause the underlying reason for this <code>SQLException</code>
 * (which is saved for later retrieval by the <code>getCause()</code> method);
 * may be null indicating the cause is non-existent or unknown.
 * @since 1.6
 * @apiSince 9
 */

public SQLException(java.lang.Throwable cause) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a <code>SQLException</code> object with a given
 * <code>reason</code> and  <code>cause</code>.
 * The <code>SQLState</code> is  initialized to <code>null</code>
 * and the vendor code is initialized to 0.
 * <p>
 * @param reason a description of the exception.
 * @param cause the underlying reason for this <code>SQLException</code>
 * (which is saved for later retrieval by the <code>getCause()</code> method);
 * may be null indicating the cause is non-existent or unknown.
 * @since 1.6
 * @apiSince 9
 */

public SQLException(java.lang.String reason, java.lang.Throwable cause) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a <code>SQLException</code> object with a given
 * <code>reason</code>, <code>SQLState</code> and  <code>cause</code>.
 * The vendor code is initialized to 0.
 * <p>
 * @param reason a description of the exception.
 * @param sqlState an XOPEN or SQL:2003 code identifying the exception
 * @param cause the underlying reason for this <code>SQLException</code>
 * (which is saved for later retrieval by the
 * <code>getCause()</code> method); may be null indicating
 *     the cause is non-existent or unknown.
 * @since 1.6
 * @apiSince 9
 */

public SQLException(java.lang.String reason, java.lang.String sqlState, java.lang.Throwable cause) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a <code>SQLException</code> object with a given
 * <code>reason</code>, <code>SQLState</code>, <code>vendorCode</code>
 * and  <code>cause</code>.
 * <p>
 * @param reason a description of the exception
 * @param sqlState an XOPEN or SQL:2003 code identifying the exception
 * @param vendorCode a database vendor-specific exception code
 * @param cause the underlying reason for this <code>SQLException</code>
 * (which is saved for later retrieval by the <code>getCause()</code> method);
 * may be null indicating the cause is non-existent or unknown.
 * @since 1.6
 * @apiSince 9
 */

public SQLException(java.lang.String reason, java.lang.String sqlState, int vendorCode, java.lang.Throwable cause) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the SQLState for this <code>SQLException</code> object.
 *
 * @return the SQLState value
 * @apiSince 1
 */

public java.lang.String getSQLState() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the vendor-specific exception code
 * for this <code>SQLException</code> object.
 *
 * @return the vendor's error code
 * @apiSince 1
 */

public int getErrorCode() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the exception chained to this
 * <code>SQLException</code> object by setNextException(SQLException ex).
 *
 * @return the next <code>SQLException</code> object in the chain;
 *         <code>null</code> if there are none
 * @see #setNextException
 * @apiSince 1
 */

public java.sql.SQLException getNextException() { throw new RuntimeException("Stub!"); }

/**
 * Adds an <code>SQLException</code> object to the end of the chain.
 *
 * @param ex the new exception that will be added to the end of
 *            the <code>SQLException</code> chain
 * @see #getNextException
 * @apiSince 1
 */

public void setNextException(java.sql.SQLException ex) { throw new RuntimeException("Stub!"); }

/**
 * Returns an iterator over the chained SQLExceptions.  The iterator will
 * be used to iterate over each SQLException and its underlying cause
 * (if any).
 *
 * @return an iterator over the chained SQLExceptions and causes in the proper
 * order
 *
 * @since 1.6
 * @apiSince 9
 */

public java.util.Iterator<java.lang.Throwable> iterator() { throw new RuntimeException("Stub!"); }
}

