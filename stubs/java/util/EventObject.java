/*
 * Copyright (c) 1996, 2003, Oracle and/or its affiliates. All rights reserved.
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



package java.util;


/**
 * <p>
 * The root class from which all event state objects shall be derived.
 * <p>
 * All Events are constructed with a reference to the object, the "source",
 * that is logically deemed to be the object upon which the Event in question
 * initially occurred upon.
 *
 * @since JDK1.1
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class EventObject implements java.io.Serializable {

/**
 * Constructs a prototypical Event.
 *
 * @param    source    The object on which the Event initially occurred.
 * @exception  java.lang.IllegalArgumentException  if source is null.
 * @apiSince 1
 */

public EventObject(java.lang.Object source) { throw new RuntimeException("Stub!"); }

/**
 * The object on which the Event initially occurred.
 *
 * @return   The object on which the Event initially occurred.
 * @apiSince 1
 */

public java.lang.Object getSource() { throw new RuntimeException("Stub!"); }

/**
 * Returns a String representation of this EventObject.
 *
 * @return  A a String representation of this EventObject.
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * The object on which the Event initially occurred.
 * @apiSince 1
 */

protected transient java.lang.Object source;
}

