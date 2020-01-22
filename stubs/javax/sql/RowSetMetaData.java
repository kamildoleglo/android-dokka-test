/*
 * Copyright (c) 2000, 2005, Oracle and/or its affiliates. All rights reserved.
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

import java.sql.*;

/**
 * An object that contains information about the columns in a
 * <code>RowSet</code> object.  This interface is
 * an extension of the <code>ResultSetMetaData</code> interface with
 * methods for setting the values in a <code>RowSetMetaData</code> object.
 * When a <code>RowSetReader</code> object reads data into a <code>RowSet</code>
 * object, it creates a <code>RowSetMetaData</code> object and initializes it
 * using the methods in the <code>RowSetMetaData</code> interface.  Then the
 * reader passes the <code>RowSetMetaData</code> object to the rowset.
 * <P>
 * The methods in this interface are invoked internally when an application
 * calls the method <code>RowSet.execute</code>; an application
 * programmer would not use them directly.
 *
 * @since 1.4
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface RowSetMetaData extends java.sql.ResultSetMetaData {

/**
 * Sets the number of columns in the <code>RowSet</code> object to
 * the given number.
 *
 * @param columnCount the number of columns in the <code>RowSet</code> object
 * @exception java.sql.SQLException if a database access error occurs
 * @apiSince 1
 */

public void setColumnCount(int columnCount) throws java.sql.SQLException;

/**
 * Sets whether the designated column is automatically numbered,
 * The default is for a <code>RowSet</code> object's
 * columns not to be automatically numbered.
 *
 * @param columnIndex the first column is 1, the second is 2, ...
 * @param property <code>true</code> if the column is automatically
 *                 numbered; <code>false</code> if it is not
 *
 * @exception java.sql.SQLException if a database access error occurs
 * @apiSince 1
 */

public void setAutoIncrement(int columnIndex, boolean property) throws java.sql.SQLException;

/**
 * Sets whether the designated column is case sensitive.
 * The default is <code>false</code>.
 *
 * @param columnIndex the first column is 1, the second is 2, ...
 * @param property <code>true</code> if the column is case sensitive;
 *                 <code>false</code> if it is not
 *
 * @exception java.sql.SQLException if a database access error occurs
 * @apiSince 1
 */

public void setCaseSensitive(int columnIndex, boolean property) throws java.sql.SQLException;

/**
 * Sets whether the designated column can be used in a where clause.
 * The default is <code>false</code>.
 *
 * @param columnIndex the first column is 1, the second is 2, ...
 * @param property <code>true</code> if the column can be used in a
 *                 <code>WHERE</code> clause; <code>false</code> if it cannot
 *
 * @exception java.sql.SQLException if a database access error occurs
 * @apiSince 1
 */

public void setSearchable(int columnIndex, boolean property) throws java.sql.SQLException;

/**
 * Sets whether the designated column is a cash value.
 * The default is <code>false</code>.
 *
 * @param columnIndex the first column is 1, the second is 2, ...
 * @param property <code>true</code> if the column is a cash value;
 *                 <code>false</code> if it is not
 *
 * @exception java.sql.SQLException if a database access error occurs
 * @apiSince 1
 */

public void setCurrency(int columnIndex, boolean property) throws java.sql.SQLException;

/**
 * Sets whether the designated column's value can be set to
 * <code>NULL</code>.
 * The default is <code>ResultSetMetaData.columnNullableUnknown</code>
 *
 * @param columnIndex the first column is 1, the second is 2, ...
 * @param property one of the following constants:
 *                 <code>ResultSetMetaData.columnNoNulls</code>,
 *                 <code>ResultSetMetaData.columnNullable</code>, or
 *                 <code>ResultSetMetaData.columnNullableUnknown</code>
 *
 * @exception java.sql.SQLException if a database access error occurs
 * @apiSince 1
 */

public void setNullable(int columnIndex, int property) throws java.sql.SQLException;

/**
 * Sets whether the designated column is a signed number.
 * The default is <code>false</code>.
 *
 * @param columnIndex the first column is 1, the second is 2, ...
 * @param property <code>true</code> if the column is a signed number;
 *                 <code>false</code> if it is not
 *
 * @exception java.sql.SQLException if a database access error occurs
 * @apiSince 1
 */

public void setSigned(int columnIndex, boolean property) throws java.sql.SQLException;

/**
 * Sets the designated column's normal maximum width in chars to the
 * given <code>int</code>.
 *
 * @param columnIndex the first column is 1, the second is 2, ...
 * @param size the normal maximum number of characters for
 *           the designated column
 *
 * @exception java.sql.SQLException if a database access error occurs
 * @apiSince 1
 */

public void setColumnDisplaySize(int columnIndex, int size) throws java.sql.SQLException;

/**
 * Sets the suggested column title for use in printouts and
 * displays, if any, to the given <code>String</code>.
 *
 * @param columnIndex the first column is 1, the second is 2, ...
 * @param label the column title
 * @exception java.sql.SQLException if a database access error occurs
 * @apiSince 1
 */

public void setColumnLabel(int columnIndex, java.lang.String label) throws java.sql.SQLException;

/**
 * Sets the name of the designated column to the given <code>String</code>.
 *
 * @param columnIndex the first column is 1, the second is 2, ...
 * @param columnName the designated column's name
 * @exception java.sql.SQLException if a database access error occurs
 * @apiSince 1
 */

public void setColumnName(int columnIndex, java.lang.String columnName) throws java.sql.SQLException;

/**
 * Sets the name of the designated column's table's schema, if any, to
 * the given <code>String</code>.
 *
 * @param columnIndex the first column is 1, the second is 2, ...
 * @param schemaName the schema name
 * @exception java.sql.SQLException if a database access error occurs
 * @apiSince 1
 */

public void setSchemaName(int columnIndex, java.lang.String schemaName) throws java.sql.SQLException;

/**
 * Sets the designated column's number of decimal digits to the
 * given <code>int</code>.
 *
 * @param columnIndex the first column is 1, the second is 2, ...
 * @param precision the total number of decimal digits
 * @exception java.sql.SQLException if a database access error occurs
 * @apiSince 1
 */

public void setPrecision(int columnIndex, int precision) throws java.sql.SQLException;

/**
 * Sets the designated column's number of digits to the
 * right of the decimal point to the given <code>int</code>.
 *
 * @param columnIndex the first column is 1, the second is 2, ...
 * @param scale the number of digits to right of decimal point
 * @exception java.sql.SQLException if a database access error occurs
 * @apiSince 1
 */

public void setScale(int columnIndex, int scale) throws java.sql.SQLException;

/**
 * Sets the designated column's table name, if any, to the given
 * <code>String</code>.
 *
 * @param columnIndex the first column is 1, the second is 2, ...
 * @param tableName the column's table name
 * @exception java.sql.SQLException if a database access error occurs
 * @apiSince 1
 */

public void setTableName(int columnIndex, java.lang.String tableName) throws java.sql.SQLException;

/**
 * Sets the designated column's table's catalog name, if any, to the given
 * <code>String</code>.
 *
 * @param columnIndex the first column is 1, the second is 2, ...
 * @param catalogName the column's catalog name
 * @exception java.sql.SQLException if a database access error occurs
 * @apiSince 1
 */

public void setCatalogName(int columnIndex, java.lang.String catalogName) throws java.sql.SQLException;

/**
 * Sets the designated column's SQL type to the one given.
 *
 * @param columnIndex the first column is 1, the second is 2, ...
 * @param SQLType the column's SQL type
 * @exception java.sql.SQLException if a database access error occurs
 * @see java.sql.Types
 * @apiSince 1
 */

public void setColumnType(int columnIndex, int SQLType) throws java.sql.SQLException;

/**
 * Sets the designated column's type name that is specific to the
 * data source, if any, to the given <code>String</code>.
 *
 * @param columnIndex the first column is 1, the second is 2, ...
 * @param typeName data source specific type name.
 * @exception java.sql.SQLException if a database access error occurs
 * @apiSince 1
 */

public void setColumnTypeName(int columnIndex, java.lang.String typeName) throws java.sql.SQLException;
}

