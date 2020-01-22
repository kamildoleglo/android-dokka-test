/*
 * Copyright (c) 1998, 2011, Oracle and/or its affiliates. All rights reserved.
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
 * The subclass of {@link java.sql.SQLException SQLException} thrown when an error
 * occurs during a batch update operation.  In addition to the
 * information provided by {@link java.sql.SQLException SQLException}, a
 * <code>BatchUpdateException</code> provides the update
 * counts for all commands that were executed successfully during the
 * batch update, that is, all commands that were executed before the error
 * occurred.  The order of elements in an array of update counts
 * corresponds to the order in which commands were added to the batch.
 * <P>
 * After a command in a batch update fails to execute properly
 * and a <code>BatchUpdateException</code> is thrown, the driver
 * may or may not continue to process the remaining commands in
 * the batch.  If the driver continues processing after a failure,
 * the array returned by the method
 * <code>BatchUpdateException.getUpdateCounts</code> will have
 * an element for every command in the batch rather than only
 * elements for the commands that executed successfully before
 * the error.  In the case where the driver continues processing
 * commands, the array element for any command
 * that failed is <code>Statement.EXECUTE_FAILED</code>.
 * <P>
 * @since 1.2
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class BatchUpdateException extends java.sql.SQLException {

/**
 * Constructs a <code>BatchUpdateException</code> object initialized with a given
 * <code>reason</code>, <code>SQLState</code>, <code>vendorCode</code> and
 * <code>updateCounts</code>.
 * The <code>cause</code> is not initialized, and may subsequently be
 * initialized by a call to the
 * {@link java.lang.Throwable#initCause(java.lang.Throwable) Throwable#initCause(java.lang.Throwable)} method.
 * <p>
 *
 * @param reason a description of the error
 * @param SQLState an XOPEN or SQL:2003 code identifying the exception
 * @param vendorCode an exception code used by a particular
 * database vendor
 * @param updateCounts an array of <code>int</code>, with each element
 * indicating the update count, <code>Statement.SUCCESS_NO_INFO</code> or
 * <code>Statement.EXECUTE_FAILED</code> for each SQL command in
 * the batch for JDBC drivers that continue processing
 * after a command failure; an update count or
 * <code>Statement.SUCCESS_NO_INFO</code> for each SQL command in the batch
 * prior to the failure for JDBC drivers that stop processing after a command
 * failure
 * @since 1.2
 * @apiSince 1
 */

public BatchUpdateException(java.lang.String reason, java.lang.String SQLState, int vendorCode, int[] updateCounts) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a <code>BatchUpdateException</code> object initialized with a given
 * <code>reason</code>, <code>SQLState</code> and
 * <code>updateCounts</code>.
 * The <code>cause</code> is not initialized, and may subsequently be
 * initialized by a call to the
 * {@link java.lang.Throwable#initCause(java.lang.Throwable) Throwable#initCause(java.lang.Throwable)} method. The vendor code
 * is initialized to 0.
 * <p>
 *
 * @param reason a description of the exception
 * @param SQLState an XOPEN or SQL:2003 code identifying the exception
 * @param updateCounts an array of <code>int</code>, with each element
 * indicating the update count, <code>Statement.SUCCESS_NO_INFO</code> or
 * <code>Statement.EXECUTE_FAILED</code> for each SQL command in
 * the batch for JDBC drivers that continue processing
 * after a command failure; an update count or
 * <code>Statement.SUCCESS_NO_INFO</code> for each SQL command in the batch
 * prior to the failure for JDBC drivers that stop processing after a command
 * failure
 * @since 1.2
 * @apiSince 1
 */

public BatchUpdateException(java.lang.String reason, java.lang.String SQLState, int[] updateCounts) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a <code>BatchUpdateException</code> object initialized with a given
 * <code>reason</code> and <code>updateCounts</code>.
 * The <code>cause</code> is not initialized, and may subsequently be
 * initialized by a call to the
 * {@link java.lang.Throwable#initCause(java.lang.Throwable) Throwable#initCause(java.lang.Throwable)} method.  The
 * <code>SQLState</code> is initialized to <code>null</code>
 * and the vender code is initialized to 0.
 * <p>
 *
 *
 * @param reason a description of the exception
 * @param updateCounts an array of <code>int</code>, with each element
 * indicating the update count, <code>Statement.SUCCESS_NO_INFO</code> or
 * <code>Statement.EXECUTE_FAILED</code> for each SQL command in
 * the batch for JDBC drivers that continue processing
 * after a command failure; an update count or
 * <code>Statement.SUCCESS_NO_INFO</code> for each SQL command in the batch
 * prior to the failure for JDBC drivers that stop processing after a command
 * failure
 * @since 1.2
 * @apiSince 1
 */

public BatchUpdateException(java.lang.String reason, int[] updateCounts) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a <code>BatchUpdateException</code> object initialized with a given
 * <code>updateCounts</code>.
 * initialized by a call to the
 * {@link java.lang.Throwable#initCause(java.lang.Throwable) Throwable#initCause(java.lang.Throwable)} method. The  <code>reason</code>
 * and <code>SQLState</code> are initialized to null and the vendor code
 * is initialized to 0.
 * <p>
 *
 * @param updateCounts an array of <code>int</code>, with each element
 * indicating the update count, <code>Statement.SUCCESS_NO_INFO</code> or
 * <code>Statement.EXECUTE_FAILED</code> for each SQL command in
 * the batch for JDBC drivers that continue processing
 * after a command failure; an update count or
 * <code>Statement.SUCCESS_NO_INFO</code> for each SQL command in the batch
 * prior to the failure for JDBC drivers that stop processing after a command
 * failure
 * @since 1.2
 * @apiSince 1
 */

public BatchUpdateException(int[] updateCounts) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a <code>BatchUpdateException</code> object.
 * The <code>reason</code>, <code>SQLState</code> and <code>updateCounts</code>
 *  are initialized to <code>null</code> and the vendor code is initialized to 0.
 * The <code>cause</code> is not initialized, and may subsequently be
 * initialized by a call to the
 * {@link java.lang.Throwable#initCause(java.lang.Throwable) Throwable#initCause(java.lang.Throwable)} method.
 * <p>
 *
 * @since 1.2
 * @apiSince 1
 */

public BatchUpdateException() { throw new RuntimeException("Stub!"); }

/**
 * Constructs a <code>BatchUpdateException</code> object initialized with
 *  a given <code>cause</code>.
 * The <code>SQLState</code> and <code>updateCounts</code>
 * are initialized
 * to <code>null</code> and the vendor code is initialized to 0.
 * The <code>reason</code>  is initialized to <code>null</code> if
 * <code>cause==null</code> or to <code>cause.toString()</code> if
 *  <code>cause!=null</code>.
 * @param cause the underlying reason for this <code>SQLException</code>
 * (which is saved for later retrieval by the <code>getCause()</code> method);
 * may be null indicating the cause is non-existent or unknown.
 * @since 1.6
 * @apiSince 9
 */

public BatchUpdateException(java.lang.Throwable cause) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a <code>BatchUpdateException</code> object initialized with a
 * given <code>cause</code> and <code>updateCounts</code>.
 * The <code>SQLState</code> is initialized
 * to <code>null</code> and the vendor code is initialized to 0.
 * The <code>reason</code>  is initialized to <code>null</code> if
 * <code>cause==null</code> or to <code>cause.toString()</code> if
 * <code>cause!=null</code>.
 *
 * @param updateCounts an array of <code>int</code>, with each element
 * indicating the update count, <code>Statement.SUCCESS_NO_INFO</code> or
 * <code>Statement.EXECUTE_FAILED</code> for each SQL command in
 * the batch for JDBC drivers that continue processing
 * after a command failure; an update count or
 * <code>Statement.SUCCESS_NO_INFO</code> for each SQL command in the batch
 * prior to the failure for JDBC drivers that stop processing after a command
 * failure
 * @param cause the underlying reason for this <code>SQLException</code>
 * (which is saved for later retrieval by the <code>getCause()</code> method); may be null indicating
 * the cause is non-existent or unknown.
 * @since 1.6
 * @apiSince 9
  */

public BatchUpdateException(int[] updateCounts, java.lang.Throwable cause) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a <code>BatchUpdateException</code> object initialized with
 * a given <code>reason</code>, <code>cause</code>
 * and <code>updateCounts</code>. The <code>SQLState</code> is initialized
 * to <code>null</code> and the vendor code is initialized to 0.
 *
 * @param reason a description of the exception
 * @param updateCounts an array of <code>int</code>, with each element
 *indicating the update count, <code>Statement.SUCCESS_NO_INFO</code> or
 * <code>Statement.EXECUTE_FAILED</code> for each SQL command in
 * the batch for JDBC drivers that continue processing
 * after a command failure; an update count or
 * <code>Statement.SUCCESS_NO_INFO</code> for each SQL command in the batch
 * prior to the failure for JDBC drivers that stop processing after a command
 * failure
 * @param cause the underlying reason for this <code>SQLException</code> (which is saved for later retrieval by the <code>getCause()</code> method);
 * may be null indicating
 * the cause is non-existent or unknown.
 * @since 1.6
 * @apiSince 9
  */

public BatchUpdateException(java.lang.String reason, int[] updateCounts, java.lang.Throwable cause) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a <code>BatchUpdateException</code> object initialized with
 * a given <code>reason</code>, <code>SQLState</code>,<code>cause</code>, and
 * <code>updateCounts</code>. The vendor code is initialized to 0.
 *
 * @param reason a description of the exception
 * @param SQLState an XOPEN or SQL:2003 code identifying the exception
 * @param updateCounts an array of <code>int</code>, with each element
 * indicating the update count, <code>Statement.SUCCESS_NO_INFO</code> or
 * <code>Statement.EXECUTE_FAILED</code> for each SQL command in
 * the batch for JDBC drivers that continue processing
 * after a command failure; an update count or
 * <code>Statement.SUCCESS_NO_INFO</code> for each SQL command in the batch
 * prior to the failure for JDBC drivers that stop processing after a command
 * failure
 * @param cause the underlying reason for this <code>SQLException</code> (which is saved for later retrieval by the <code>getCause()</code> method);
 * may be null indicating
 * the cause is non-existent or unknown.
 * @since 1.6
 * @apiSince 9
  */

public BatchUpdateException(java.lang.String reason, java.lang.String SQLState, int[] updateCounts, java.lang.Throwable cause) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a <code>BatchUpdateException</code> object initialized with
 * a given <code>reason</code>, <code>SQLState</code>, <code>vendorCode</code>
 * <code>cause</code> and <code>updateCounts</code>.
 *
 * @param reason a description of the error
 * @param SQLState an XOPEN or SQL:2003 code identifying the exception
 * @param vendorCode an exception code used by a particular
 * database vendor
 * @param updateCounts an array of <code>int</code>, with each element
 *indicating the update count, <code>Statement.SUCCESS_NO_INFO</code> or
 * <code>Statement.EXECUTE_FAILED</code> for each SQL command in
 * the batch for JDBC drivers that continue processing
 * after a command failure; an update count or
 * <code>Statement.SUCCESS_NO_INFO</code> for each SQL command in the batch
 * prior to the failure for JDBC drivers that stop processing after a command
 * failure
 * @param cause the underlying reason for this <code>SQLException</code> (which is saved for later retrieval by the <code>getCause()</code> method);
 * may be null indicating
 * the cause is non-existent or unknown.
 * @since 1.6
 * @apiSince 9
  */

public BatchUpdateException(java.lang.String reason, java.lang.String SQLState, int vendorCode, int[] updateCounts, java.lang.Throwable cause) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the update count for each update statement in the batch
 * update that executed successfully before this exception occurred.
 * A driver that implements batch updates may or may not continue to
 * process the remaining commands in a batch when one of the commands
 * fails to execute properly. If the driver continues processing commands,
 * the array returned by this method will have as many elements as
 * there are commands in the batch; otherwise, it will contain an
 * update count for each command that executed successfully before
 * the <code>BatchUpdateException</code> was thrown.
 *<P>
 * The possible return values for this method were modified for
 * the Java 2 SDK, Standard Edition, version 1.3.  This was done to
 * accommodate the new option of continuing to process commands
 * in a batch update after a <code>BatchUpdateException</code> object
 * has been thrown.
 *
 * @return an array of <code>int</code> containing the update counts
 * for the updates that were executed successfully before this error
 * occurred.  Or, if the driver continues to process commands after an
 * error, one of the following for every command in the batch:
 * <OL>
 * <LI>an update count
 *  <LI><code>Statement.SUCCESS_NO_INFO</code> to indicate that the command
 *     executed successfully but the number of rows affected is unknown
 *  <LI><code>Statement.EXECUTE_FAILED</code> to indicate that the command
 *     failed to execute successfully
 * </OL>
 * @since 1.3
 * @apiSince 1
 */

public int[] getUpdateCounts() { throw new RuntimeException("Stub!"); }
}

