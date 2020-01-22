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
 * <P>The class that defines the constants that are used to identify generic
 * SQL types, called JDBC types.
 * <p>
 * This class is never instantiated.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Types {

private Types() { throw new RuntimeException("Stub!"); }

/**
 * The constant in the Java programming language, sometimes referred to
 * as a type code, that identifies the generic SQL type
 * <code>ARRAY</code>.
 * @since 1.2
 * @apiSince 1
 */

public static final int ARRAY = 2003; // 0x7d3

/**
 * <P>The constant in the Java programming language, sometimes referred
 * to as a type code, that identifies the generic SQL type
 * <code>BIGINT</code>.
 * @apiSince 1
 */

public static final int BIGINT = -5; // 0xfffffffb

/**
 * <P>The constant in the Java programming language, sometimes referred
 * to as a type code, that identifies the generic SQL type
 * <code>BINARY</code>.
 * @apiSince 1
 */

public static final int BINARY = -2; // 0xfffffffe

/**
 * <P>The constant in the Java programming language, sometimes referred
 * to as a type code, that identifies the generic SQL type
 * <code>BIT</code>.
 * @apiSince 1
 */

public static final int BIT = -7; // 0xfffffff9

/**
 * The constant in the Java programming language, sometimes referred to
 * as a type code, that identifies the generic SQL type
 * <code>BLOB</code>.
 * @since 1.2
 * @apiSince 1
 */

public static final int BLOB = 2004; // 0x7d4

/**
 * The constant in the Java programming language, somtimes referred to
 * as a type code, that identifies the generic SQL type <code>BOOLEAN</code>.
 *
 * @since 1.4
 * @apiSince 1
 */

public static final int BOOLEAN = 16; // 0x10

/**
 * <P>The constant in the Java programming language, sometimes referred
 * to as a type code, that identifies the generic SQL type
 * <code>CHAR</code>.
 * @apiSince 1
 */

public static final int CHAR = 1; // 0x1

/**
 * The constant in the Java programming language, sometimes referred to
 * as a type code, that identifies the generic SQL type
 * <code>CLOB</code>.
 * @since 1.2
 * @apiSince 1
 */

public static final int CLOB = 2005; // 0x7d5

/**
 * The constant in the Java programming language, somtimes referred to
 * as a type code, that identifies the generic SQL type <code>DATALINK</code>.
 *
 * @since 1.4
 * @apiSince 1
 */

public static final int DATALINK = 70; // 0x46

/**
 * <P>The constant in the Java programming language, sometimes referred
 * to as a type code, that identifies the generic SQL type
 * <code>DATE</code>.
 * @apiSince 1
 */

public static final int DATE = 91; // 0x5b

/**
 * <P>The constant in the Java programming language, sometimes referred
 * to as a type code, that identifies the generic SQL type
 * <code>DECIMAL</code>.
 * @apiSince 1
 */

public static final int DECIMAL = 3; // 0x3

/**
 * The constant in the Java programming language, sometimes referred to
 * as a type code, that identifies the generic SQL type
 * <code>DISTINCT</code>.
 * @since 1.2
 * @apiSince 1
 */

public static final int DISTINCT = 2001; // 0x7d1

/**
 * <P>The constant in the Java programming language, sometimes referred
 * to as a type code, that identifies the generic SQL type
 * <code>DOUBLE</code>.
 * @apiSince 1
 */

public static final int DOUBLE = 8; // 0x8

/**
 * <P>The constant in the Java programming language, sometimes referred
 * to as a type code, that identifies the generic SQL type
 * <code>FLOAT</code>.
 * @apiSince 1
 */

public static final int FLOAT = 6; // 0x6

/**
 * <P>The constant in the Java programming language, sometimes referred
 * to as a type code, that identifies the generic SQL type
 * <code>INTEGER</code>.
 * @apiSince 1
 */

public static final int INTEGER = 4; // 0x4

/**
 * The constant in the Java programming language, sometimes referred to
 * as a type code, that identifies the generic SQL type
 * <code>JAVA_OBJECT</code>.
 * @since 1.2
 * @apiSince 1
 */

public static final int JAVA_OBJECT = 2000; // 0x7d0

/**
 * The constant in the Java programming language, sometimes referred to
 * as a type code, that identifies the generic SQL type <code>LONGNVARCHAR</code>.
 *
 * @since 1.6
 * @apiSince 9
 */

public static final int LONGNVARCHAR = -16; // 0xfffffff0

/**
 * <P>The constant in the Java programming language, sometimes referred
 * to as a type code, that identifies the generic SQL type
 * <code>LONGVARBINARY</code>.
 * @apiSince 1
 */

public static final int LONGVARBINARY = -4; // 0xfffffffc

/**
 * <P>The constant in the Java programming language, sometimes referred
 * to as a type code, that identifies the generic SQL type
 * <code>LONGVARCHAR</code>.
 * @apiSince 1
 */

public static final int LONGVARCHAR = -1; // 0xffffffff

/**
 * The constant in the Java programming language, sometimes referred to
 * as a type code, that identifies the generic SQL type <code>NCHAR</code>
 *
 * @since 1.6
 * @apiSince 9
 */

public static final int NCHAR = -15; // 0xfffffff1

/**
 * The constant in the Java programming language, sometimes referred to
 * as a type code, that identifies the generic SQL type <code>NCLOB</code>.
 *
 * @since 1.6
 * @apiSince 9
 */

public static final int NCLOB = 2011; // 0x7db

/**
 * <P>The constant in the Java programming language
 * that identifies the generic SQL value
 * <code>NULL</code>.
 * @apiSince 1
 */

public static final int NULL = 0; // 0x0

/**
 * <P>The constant in the Java programming language, sometimes referred
 * to as a type code, that identifies the generic SQL type
 * <code>NUMERIC</code>.
 * @apiSince 1
 */

public static final int NUMERIC = 2; // 0x2

/**
 * The constant in the Java programming language, sometimes referred to
 * as a type code, that identifies the generic SQL type <code>NVARCHAR</code>.
 *
 * @since 1.6
 * @apiSince 9
 */

public static final int NVARCHAR = -9; // 0xfffffff7

/**
 * The constant in the Java programming language that indicates
 * that the SQL type is database-specific and
 * gets mapped to a Java object that can be accessed via
 * the methods <code>getObject</code> and <code>setObject</code>.
 * @apiSince 1
 */

public static final int OTHER = 1111; // 0x457

/**
 * <P>The constant in the Java programming language, sometimes referred
 * to as a type code, that identifies the generic SQL type
 * <code>REAL</code>.
 * @apiSince 1
 */

public static final int REAL = 7; // 0x7

/**
 * The constant in the Java programming language, sometimes referred to
 * as a type code, that identifies the generic SQL type
 * <code>REF</code>.
 * @since 1.2
 * @apiSince 1
 */

public static final int REF = 2006; // 0x7d6

/**
 * The constant in the Java programming language, sometimes referred to
 * as a type code, that identifies the generic SQL type <code>ROWID</code>
 *
 * @since 1.6
 *
 * @apiSince 9
 */

public static final int ROWID = -8; // 0xfffffff8

/**
 * <P>The constant in the Java programming language, sometimes referred
 * to as a type code, that identifies the generic SQL type
 * <code>SMALLINT</code>.
 * @apiSince 1
 */

public static final int SMALLINT = 5; // 0x5

/**
 * The constant in the Java programming language, sometimes referred to
 * as a type code, that identifies the generic SQL type <code>XML</code>.
 *
 * @since 1.6
 * @apiSince 9
 */

public static final int SQLXML = 2009; // 0x7d9

/**
 * The constant in the Java programming language, sometimes referred to
 * as a type code, that identifies the generic SQL type
 * <code>STRUCT</code>.
 * @since 1.2
 * @apiSince 1
 */

public static final int STRUCT = 2002; // 0x7d2

/**
 * <P>The constant in the Java programming language, sometimes referred
 * to as a type code, that identifies the generic SQL type
 * <code>TIME</code>.
 * @apiSince 1
 */

public static final int TIME = 92; // 0x5c

/**
 * <P>The constant in the Java programming language, sometimes referred
 * to as a type code, that identifies the generic SQL type
 * <code>TIMESTAMP</code>.
 * @apiSince 1
 */

public static final int TIMESTAMP = 93; // 0x5d

/**
 * <P>The constant in the Java programming language, sometimes referred
 * to as a type code, that identifies the generic SQL type
 * <code>TINYINT</code>.
 * @apiSince 1
 */

public static final int TINYINT = -6; // 0xfffffffa

/**
 * <P>The constant in the Java programming language, sometimes referred
 * to as a type code, that identifies the generic SQL type
 * <code>VARBINARY</code>.
 * @apiSince 1
 */

public static final int VARBINARY = -3; // 0xfffffffd

/**
 * <P>The constant in the Java programming language, sometimes referred
 * to as a type code, that identifies the generic SQL type
 * <code>VARCHAR</code>.
 * @apiSince 1
 */

public static final int VARCHAR = 12; // 0xc
}

