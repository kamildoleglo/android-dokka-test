/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 2000, 2013, Oracle and/or its affiliates. All rights reserved.
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



package java.util.prefs;

import java.util.*;
import java.io.*;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Float;
import java.lang.Double;

/**
 * This class provides a skeletal implementation of the {@link java.util.prefs.Preferences Preferences}
 * class, greatly easing the task of implementing it.
 *
 * <p><strong>This class is for <tt>Preferences</tt> implementers only.
 * Normal users of the <tt>Preferences</tt> facility should have no need to
 * consult this documentation.  The {@link java.util.prefs.Preferences Preferences} documentation
 * should suffice.</strong>
 *
 * <p>Implementors must override the nine abstract service-provider interface
 * (SPI) methods: {@link #getSpi(java.lang.String)}, {@link #putSpi(java.lang.String,java.lang.String)},
 * {@link #removeSpi(java.lang.String)}, {@link #childSpi(java.lang.String)}, {@link
 * #removeNodeSpi()}, {@link #keysSpi()}, {@link #childrenNamesSpi()}, {@link
 * #syncSpi()} and {@link #flushSpi()}.  All of the concrete methods specify
 * precisely how they are implemented atop these SPI methods.  The implementor
 * may, at his discretion, override one or more of the concrete methods if the
 * default implementation is unsatisfactory for any reason, such as
 * performance.
 *
 * <p>The SPI methods fall into three groups concerning exception
 * behavior. The <tt>getSpi</tt> method should never throw exceptions, but it
 * doesn't really matter, as any exception thrown by this method will be
 * intercepted by {@link #get(java.lang.String,java.lang.String)}, which will return the specified
 * default value to the caller.  The <tt>removeNodeSpi, keysSpi,
 * childrenNamesSpi, syncSpi</tt> and <tt>flushSpi</tt> methods are specified
 * to throw {@link java.util.prefs.BackingStoreException BackingStoreException}, and the implementation is required
 * to throw this checked exception if it is unable to perform the operation.
 * The exception propagates outward, causing the corresponding API method
 * to fail.
 *
 * <p>The remaining SPI methods {@link #putSpi(java.lang.String,java.lang.String)}, {@link
 * #removeSpi(java.lang.String)} and {@link #childSpi(java.lang.String)} have more complicated
 * exception behavior.  They are not specified to throw
 * <tt>BackingStoreException</tt>, as they can generally obey their contracts
 * even if the backing store is unavailable.  This is true because they return
 * no information and their effects are not required to become permanent until
 * a subsequent call to {@link java.util.prefs.Preferences#flush() Preferences#flush()} or
 * {@link java.util.prefs.Preferences#sync() Preferences#sync()}. Generally speaking, these SPI methods should not
 * throw exceptions.  In some implementations, there may be circumstances
 * under which these calls cannot even enqueue the requested operation for
 * later processing.  Even under these circumstances it is generally better to
 * simply ignore the invocation and return, rather than throwing an
 * exception.  Under these circumstances, however, all subsequent invocations
 * of <tt>flush()</tt> and <tt>sync</tt> should return <tt>false</tt>, as
 * returning <tt>true</tt> would imply that all previous operations had
 * successfully been made permanent.
 *
 * <p>There is one circumstance under which <tt>putSpi, removeSpi and
 * childSpi</tt> <i>should</i> throw an exception: if the caller lacks
 * sufficient privileges on the underlying operating system to perform the
 * requested operation.  This will, for instance, occur on most systems
 * if a non-privileged user attempts to modify system preferences.
 * (The required privileges will vary from implementation to
 * implementation.  On some implementations, they are the right to modify the
 * contents of some directory in the file system; on others they are the right
 * to modify contents of some key in a registry.)  Under any of these
 * circumstances, it would generally be undesirable to let the program
 * continue executing as if these operations would become permanent at a later
 * time.  While implementations are not required to throw an exception under
 * these circumstances, they are encouraged to do so.  A {@link java.lang.SecurityException SecurityException} would be appropriate.
 *
 * <p>Most of the SPI methods require the implementation to read or write
 * information at a preferences node.  The implementor should beware of the
 * fact that another VM may have concurrently deleted this node from the
 * backing store.  It is the implementation's responsibility to recreate the
 * node if it has been deleted.
 *
 * <p>Implementation note: In Sun's default <tt>Preferences</tt>
 * implementations, the user's identity is inherited from the underlying
 * operating system and does not change for the lifetime of the virtual
 * machine.  It is recognized that server-side <tt>Preferences</tt>
 * implementations may have the user identity change from request to request,
 * implicitly passed to <tt>Preferences</tt> methods via the use of a
 * static {@link java.lang.ThreadLocal ThreadLocal} instance.  Authors of such implementations are
 * <i>strongly</i> encouraged to determine the user at the time preferences
 * are accessed (for example by the {@link #get(java.lang.String,java.lang.String)} or {@link
 * #put(java.lang.String,java.lang.String)} method) rather than permanently associating a user
 * with each <tt>Preferences</tt> instance.  The latter behavior conflicts
 * with normal <tt>Preferences</tt> usage and would lead to great confusion.
 *
 * @author  Josh Bloch
 * @see     java.util.prefs.Preferences
 * @since   1.4
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class AbstractPreferences extends java.util.prefs.Preferences {

/**
 * Creates a preference node with the specified parent and the specified
 * name relative to its parent.
 *
 * @param parent the parent of this preference node, or null if this
 *               is the root.
 * @param name the name of this preference node, relative to its parent,
 *             or <tt>""</tt> if this is the root.
 * @throws java.lang.IllegalArgumentException if <tt>name</tt> contains a slash
 *          (<tt>'/'</tt>),  or <tt>parent</tt> is <tt>null</tt> and
 *          name isn't <tt>""</tt>.
 * @apiSince 1
 */

protected AbstractPreferences(java.util.prefs.AbstractPreferences parent, java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Implements the <tt>put</tt> method as per the specification in
 * {@link java.util.prefs.Preferences#put(java.lang.String,java.lang.String) Preferences#put(String,String)}.
 *
 * <p>This implementation checks that the key and value are legal,
 * obtains this preference node's lock, checks that the node
 * has not been removed, invokes {@link #putSpi(java.lang.String,java.lang.String)}, and if
 * there are any preference change listeners, enqueues a notification
 * event for processing by the event dispatch thread.
 *
 * @param key key with which the specified value is to be associated.
 * @param value value to be associated with the specified key.
 * @throws java.lang.NullPointerException if key or value is <tt>null</tt>.
 * @throws java.lang.IllegalArgumentException if <tt>key.length()</tt> exceeds
 *       <tt>MAX_KEY_LENGTH</tt> or if <tt>value.length</tt> exceeds
 *       <tt>MAX_VALUE_LENGTH</tt>.
 * @throws java.lang.IllegalStateException if this node (or an ancestor) has been
 *         removed with the {@link #removeNode()} method.
 * @apiSince 1
 */

public void put(java.lang.String key, java.lang.String value) { throw new RuntimeException("Stub!"); }

/**
 * Implements the <tt>get</tt> method as per the specification in
 * {@link java.util.prefs.Preferences#get(java.lang.String,java.lang.String) Preferences#get(String,String)}.
 *
 * <p>This implementation first checks to see if <tt>key</tt> is
 * <tt>null</tt> throwing a <tt>NullPointerException</tt> if this is
 * the case.  Then it obtains this preference node's lock,
 * checks that the node has not been removed, invokes {@link
 * #getSpi(java.lang.String)}, and returns the result, unless the <tt>getSpi</tt>
 * invocation returns <tt>null</tt> or throws an exception, in which case
 * this invocation returns <tt>def</tt>.
 *
 * @param key key whose associated value is to be returned.
 * @param def the value to be returned in the event that this
 *        preference node has no value associated with <tt>key</tt>.
 * @return the value associated with <tt>key</tt>, or <tt>def</tt>
 *         if no value is associated with <tt>key</tt>.
 * @throws java.lang.IllegalStateException if this node (or an ancestor) has been
 *         removed with the {@link #removeNode()} method.
 * @throws java.lang.NullPointerException if key is <tt>null</tt>.  (A
 *         <tt>null</tt> default <i>is</i> permitted.)
 * @apiSince 1
 */

public java.lang.String get(java.lang.String key, java.lang.String def) { throw new RuntimeException("Stub!"); }

/**
 * Implements the <tt>remove(String)</tt> method as per the specification
 * in {@link java.util.prefs.Preferences#remove(java.lang.String) Preferences#remove(String)}.
 *
 * <p>This implementation obtains this preference node's lock,
 * checks that the node has not been removed, invokes
 * {@link #removeSpi(java.lang.String)} and if there are any preference
 * change listeners, enqueues a notification event for processing by the
 * event dispatch thread.
 *
 * @param key key whose mapping is to be removed from the preference node.
 * @throws java.lang.IllegalStateException if this node (or an ancestor) has been
 *         removed with the {@link #removeNode()} method.
 * @throws java.lang.NullPointerException {@inheritDoc}.
 * @apiSince 1
 */

public void remove(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Implements the <tt>clear</tt> method as per the specification in
 * {@link java.util.prefs.Preferences#clear() Preferences#clear()}.
 *
 * <p>This implementation obtains this preference node's lock,
 * invokes {@link #keys()} to obtain an array of keys, and
 * iterates over the array invoking {@link #remove(java.lang.String)} on each key.
 *
 * @throws java.util.prefs.BackingStoreException if this operation cannot be completed
 *         due to a failure in the backing store, or inability to
 *         communicate with it.
 * @throws java.lang.IllegalStateException if this node (or an ancestor) has been
 *         removed with the {@link #removeNode()} method.
 * @apiSince 1
 */

public void clear() throws java.util.prefs.BackingStoreException { throw new RuntimeException("Stub!"); }

/**
 * Implements the <tt>putInt</tt> method as per the specification in
 * {@link java.util.prefs.Preferences#putInt(java.lang.String,int) Preferences#putInt(String,int)}.
 *
 * <p>This implementation translates <tt>value</tt> to a string with
 * {@link java.lang.Integer#toString(int) Integer#toString(int)} and invokes {@link #put(java.lang.String,java.lang.String)}
 * on the result.
 *
 * @param key key with which the string form of value is to be associated.
 * @param value value whose string form is to be associated with key.
 * @throws java.lang.NullPointerException if key is <tt>null</tt>.
 * @throws java.lang.IllegalArgumentException if <tt>key.length()</tt> exceeds
 *         <tt>MAX_KEY_LENGTH</tt>.
 * @throws java.lang.IllegalStateException if this node (or an ancestor) has been
 *         removed with the {@link #removeNode()} method.
 * @apiSince 1
 */

public void putInt(java.lang.String key, int value) { throw new RuntimeException("Stub!"); }

/**
 * Implements the <tt>getInt</tt> method as per the specification in
 * {@link java.util.prefs.Preferences#getInt(java.lang.String,int) Preferences#getInt(String,int)}.
 *
 * <p>This implementation invokes {@link #get(java.lang.String,java.lang.String) <tt>get(key,
 * null)</tt>}.  If the return value is non-null, the implementation
 * attempts to translate it to an <tt>int</tt> with
 * {@link java.lang.Integer#parseInt(java.lang.String) Integer#parseInt(String)}.  If the attempt succeeds, the return
 * value is returned by this method.  Otherwise, <tt>def</tt> is returned.
 *
 * @param key key whose associated value is to be returned as an int.
 * @param def the value to be returned in the event that this
 *        preference node has no value associated with <tt>key</tt>
 *        or the associated value cannot be interpreted as an int.
 * @return the int value represented by the string associated with
 *         <tt>key</tt> in this preference node, or <tt>def</tt> if the
 *         associated value does not exist or cannot be interpreted as
 *         an int.
 * @throws java.lang.IllegalStateException if this node (or an ancestor) has been
 *         removed with the {@link #removeNode()} method.
 * @throws java.lang.NullPointerException if <tt>key</tt> is <tt>null</tt>.
 * @apiSince 1
 */

public int getInt(java.lang.String key, int def) { throw new RuntimeException("Stub!"); }

/**
 * Implements the <tt>putLong</tt> method as per the specification in
 * {@link java.util.prefs.Preferences#putLong(java.lang.String,long) Preferences#putLong(String,long)}.
 *
 * <p>This implementation translates <tt>value</tt> to a string with
 * {@link java.lang.Long#toString(long) Long#toString(long)} and invokes {@link #put(java.lang.String,java.lang.String)}
 * on the result.
 *
 * @param key key with which the string form of value is to be associated.
 * @param value value whose string form is to be associated with key.
 * @throws java.lang.NullPointerException if key is <tt>null</tt>.
 * @throws java.lang.IllegalArgumentException if <tt>key.length()</tt> exceeds
 *         <tt>MAX_KEY_LENGTH</tt>.
 * @throws java.lang.IllegalStateException if this node (or an ancestor) has been
 *         removed with the {@link #removeNode()} method.
 * @apiSince 1
 */

public void putLong(java.lang.String key, long value) { throw new RuntimeException("Stub!"); }

/**
 * Implements the <tt>getLong</tt> method as per the specification in
 * {@link java.util.prefs.Preferences#getLong(java.lang.String,long) Preferences#getLong(String,long)}.
 *
 * <p>This implementation invokes {@link #get(java.lang.String,java.lang.String) <tt>get(key,
 * null)</tt>}.  If the return value is non-null, the implementation
 * attempts to translate it to a <tt>long</tt> with
 * {@link java.lang.Long#parseLong(java.lang.String) Long#parseLong(String)}.  If the attempt succeeds, the return
 * value is returned by this method.  Otherwise, <tt>def</tt> is returned.
 *
 * @param key key whose associated value is to be returned as a long.
 * @param def the value to be returned in the event that this
 *        preference node has no value associated with <tt>key</tt>
 *        or the associated value cannot be interpreted as a long.
 * @return the long value represented by the string associated with
 *         <tt>key</tt> in this preference node, or <tt>def</tt> if the
 *         associated value does not exist or cannot be interpreted as
 *         a long.
 * @throws java.lang.IllegalStateException if this node (or an ancestor) has been
 *         removed with the {@link #removeNode()} method.
 * @throws java.lang.NullPointerException if <tt>key</tt> is <tt>null</tt>.
 * @apiSince 1
 */

public long getLong(java.lang.String key, long def) { throw new RuntimeException("Stub!"); }

/**
 * Implements the <tt>putBoolean</tt> method as per the specification in
 * {@link java.util.prefs.Preferences#putBoolean(java.lang.String,boolean) Preferences#putBoolean(String,boolean)}.
 *
 * <p>This implementation translates <tt>value</tt> to a string with
 * {@link java.lang.String#valueOf(boolean) String#valueOf(boolean)} and invokes {@link #put(java.lang.String,java.lang.String)}
 * on the result.
 *
 * @param key key with which the string form of value is to be associated.
 * @param value value whose string form is to be associated with key.
 * @throws java.lang.NullPointerException if key is <tt>null</tt>.
 * @throws java.lang.IllegalArgumentException if <tt>key.length()</tt> exceeds
 *         <tt>MAX_KEY_LENGTH</tt>.
 * @throws java.lang.IllegalStateException if this node (or an ancestor) has been
 *         removed with the {@link #removeNode()} method.
 * @apiSince 1
 */

public void putBoolean(java.lang.String key, boolean value) { throw new RuntimeException("Stub!"); }

/**
 * Implements the <tt>getBoolean</tt> method as per the specification in
 * {@link java.util.prefs.Preferences#getBoolean(java.lang.String,boolean) Preferences#getBoolean(String,boolean)}.
 *
 * <p>This implementation invokes {@link #get(java.lang.String,java.lang.String) <tt>get(key,
 * null)</tt>}.  If the return value is non-null, it is compared with
 * <tt>"true"</tt> using {@link java.lang.String#equalsIgnoreCase(java.lang.String) String#equalsIgnoreCase(String)}.  If the
 * comparison returns <tt>true</tt>, this invocation returns
 * <tt>true</tt>.  Otherwise, the original return value is compared with
 * <tt>"false"</tt>, again using {@link java.lang.String#equalsIgnoreCase(java.lang.String) String#equalsIgnoreCase(String)}.
 * If the comparison returns <tt>true</tt>, this invocation returns
 * <tt>false</tt>.  Otherwise, this invocation returns <tt>def</tt>.
 *
 * @param key key whose associated value is to be returned as a boolean.
 * @param def the value to be returned in the event that this
 *        preference node has no value associated with <tt>key</tt>
 *        or the associated value cannot be interpreted as a boolean.
 * @return the boolean value represented by the string associated with
 *         <tt>key</tt> in this preference node, or <tt>def</tt> if the
 *         associated value does not exist or cannot be interpreted as
 *         a boolean.
 * @throws java.lang.IllegalStateException if this node (or an ancestor) has been
 *         removed with the {@link #removeNode()} method.
 * @throws java.lang.NullPointerException if <tt>key</tt> is <tt>null</tt>.
 * @apiSince 1
 */

public boolean getBoolean(java.lang.String key, boolean def) { throw new RuntimeException("Stub!"); }

/**
 * Implements the <tt>putFloat</tt> method as per the specification in
 * {@link java.util.prefs.Preferences#putFloat(java.lang.String,float) Preferences#putFloat(String,float)}.
 *
 * <p>This implementation translates <tt>value</tt> to a string with
 * {@link java.lang.Float#toString(float) Float#toString(float)} and invokes {@link #put(java.lang.String,java.lang.String)}
 * on the result.
 *
 * @param key key with which the string form of value is to be associated.
 * @param value value whose string form is to be associated with key.
 * @throws java.lang.NullPointerException if key is <tt>null</tt>.
 * @throws java.lang.IllegalArgumentException if <tt>key.length()</tt> exceeds
 *         <tt>MAX_KEY_LENGTH</tt>.
 * @throws java.lang.IllegalStateException if this node (or an ancestor) has been
 *         removed with the {@link #removeNode()} method.
 * @apiSince 1
 */

public void putFloat(java.lang.String key, float value) { throw new RuntimeException("Stub!"); }

/**
 * Implements the <tt>getFloat</tt> method as per the specification in
 * {@link java.util.prefs.Preferences#getFloat(java.lang.String,float) Preferences#getFloat(String,float)}.
 *
 * <p>This implementation invokes {@link #get(java.lang.String,java.lang.String) <tt>get(key,
 * null)</tt>}.  If the return value is non-null, the implementation
 * attempts to translate it to an <tt>float</tt> with
 * {@link java.lang.Float#parseFloat(java.lang.String) Float#parseFloat(String)}.  If the attempt succeeds, the return
 * value is returned by this method.  Otherwise, <tt>def</tt> is returned.
 *
 * @param key key whose associated value is to be returned as a float.
 * @param def the value to be returned in the event that this
 *        preference node has no value associated with <tt>key</tt>
 *        or the associated value cannot be interpreted as a float.
 * @return the float value represented by the string associated with
 *         <tt>key</tt> in this preference node, or <tt>def</tt> if the
 *         associated value does not exist or cannot be interpreted as
 *         a float.
 * @throws java.lang.IllegalStateException if this node (or an ancestor) has been
 *         removed with the {@link #removeNode()} method.
 * @throws java.lang.NullPointerException if <tt>key</tt> is <tt>null</tt>.
 * @apiSince 1
 */

public float getFloat(java.lang.String key, float def) { throw new RuntimeException("Stub!"); }

/**
 * Implements the <tt>putDouble</tt> method as per the specification in
 * {@link java.util.prefs.Preferences#putDouble(java.lang.String,double) Preferences#putDouble(String,double)}.
 *
 * <p>This implementation translates <tt>value</tt> to a string with
 * {@link java.lang.Double#toString(double) Double#toString(double)} and invokes {@link #put(java.lang.String,java.lang.String)}
 * on the result.
 *
 * @param key key with which the string form of value is to be associated.
 * @param value value whose string form is to be associated with key.
 * @throws java.lang.NullPointerException if key is <tt>null</tt>.
 * @throws java.lang.IllegalArgumentException if <tt>key.length()</tt> exceeds
 *         <tt>MAX_KEY_LENGTH</tt>.
 * @throws java.lang.IllegalStateException if this node (or an ancestor) has been
 *         removed with the {@link #removeNode()} method.
 * @apiSince 1
 */

public void putDouble(java.lang.String key, double value) { throw new RuntimeException("Stub!"); }

/**
 * Implements the <tt>getDouble</tt> method as per the specification in
 * {@link java.util.prefs.Preferences#getDouble(java.lang.String,double) Preferences#getDouble(String,double)}.
 *
 * <p>This implementation invokes {@link #get(java.lang.String,java.lang.String) <tt>get(key,
 * null)</tt>}.  If the return value is non-null, the implementation
 * attempts to translate it to an <tt>double</tt> with
 * {@link java.lang.Double#parseDouble(java.lang.String) Double#parseDouble(String)}.  If the attempt succeeds, the return
 * value is returned by this method.  Otherwise, <tt>def</tt> is returned.
 *
 * @param key key whose associated value is to be returned as a double.
 * @param def the value to be returned in the event that this
 *        preference node has no value associated with <tt>key</tt>
 *        or the associated value cannot be interpreted as a double.
 * @return the double value represented by the string associated with
 *         <tt>key</tt> in this preference node, or <tt>def</tt> if the
 *         associated value does not exist or cannot be interpreted as
 *         a double.
 * @throws java.lang.IllegalStateException if this node (or an ancestor) has been
 *         removed with the {@link #removeNode()} method.
 * @throws java.lang.NullPointerException if <tt>key</tt> is <tt>null</tt>.
 * @apiSince 1
 */

public double getDouble(java.lang.String key, double def) { throw new RuntimeException("Stub!"); }

/**
 * Implements the <tt>putByteArray</tt> method as per the specification in
 * {@link java.util.prefs.Preferences#putByteArray(java.lang.String,byte[]) Preferences#putByteArray(String,byte[])}.
 *
 * @param key key with which the string form of value is to be associated.
 * @param value value whose string form is to be associated with key.
 * @throws java.lang.NullPointerException if key or value is <tt>null</tt>.
 * @throws java.lang.IllegalArgumentException if key.length() exceeds MAX_KEY_LENGTH
 *         or if value.length exceeds MAX_VALUE_LENGTH*3/4.
 * @throws java.lang.IllegalStateException if this node (or an ancestor) has been
 *         removed with the {@link #removeNode()} method.
 * @apiSince 1
 */

public void putByteArray(java.lang.String key, byte[] value) { throw new RuntimeException("Stub!"); }

/**
 * Implements the <tt>getByteArray</tt> method as per the specification in
 * {@link java.util.prefs.Preferences#getByteArray(java.lang.String,byte[]) Preferences#getByteArray(String,byte[])}.
 *
 * @param key key whose associated value is to be returned as a byte array.
 * @param def the value to be returned in the event that this
 *        preference node has no value associated with <tt>key</tt>
 *        or the associated value cannot be interpreted as a byte array.
 * @return the byte array value represented by the string associated with
 *         <tt>key</tt> in this preference node, or <tt>def</tt> if the
 *         associated value does not exist or cannot be interpreted as
 *         a byte array.
 * @throws java.lang.IllegalStateException if this node (or an ancestor) has been
 *         removed with the {@link #removeNode()} method.
 * @throws java.lang.NullPointerException if <tt>key</tt> is <tt>null</tt>.  (A
 *         <tt>null</tt> value for <tt>def</tt> <i>is</i> permitted.)
 * @apiSince 1
 */

public byte[] getByteArray(java.lang.String key, byte[] def) { throw new RuntimeException("Stub!"); }

/**
 * Implements the <tt>keys</tt> method as per the specification in
 * {@link java.util.prefs.Preferences#keys() Preferences#keys()}.
 *
 * <p>This implementation obtains this preference node's lock, checks that
 * the node has not been removed and invokes {@link #keysSpi()}.
 *
 * @return an array of the keys that have an associated value in this
 *         preference node.
 * @throws java.util.prefs.BackingStoreException if this operation cannot be completed
 *         due to a failure in the backing store, or inability to
 *         communicate with it.
 * @throws java.lang.IllegalStateException if this node (or an ancestor) has been
 *         removed with the {@link #removeNode()} method.
 * @apiSince 1
 */

public java.lang.String[] keys() throws java.util.prefs.BackingStoreException { throw new RuntimeException("Stub!"); }

/**
 * Implements the <tt>children</tt> method as per the specification in
 * {@link java.util.prefs.Preferences#childrenNames() Preferences#childrenNames()}.
 *
 * <p>This implementation obtains this preference node's lock, checks that
 * the node has not been removed, constructs a <tt>TreeSet</tt> initialized
 * to the names of children already cached (the children in this node's
 * "child-cache"), invokes {@link #childrenNamesSpi()}, and adds all of the
 * returned child-names into the set.  The elements of the tree set are
 * dumped into a <tt>String</tt> array using the <tt>toArray</tt> method,
 * and this array is returned.
 *
 * @return the names of the children of this preference node.
 * @throws java.util.prefs.BackingStoreException if this operation cannot be completed
 *         due to a failure in the backing store, or inability to
 *         communicate with it.
 * @throws java.lang.IllegalStateException if this node (or an ancestor) has been
 *         removed with the {@link #removeNode()} method.
 * @see #cachedChildren()
 * @apiSince 1
 */

public java.lang.String[] childrenNames() throws java.util.prefs.BackingStoreException { throw new RuntimeException("Stub!"); }

/**
 * Returns all known unremoved children of this node.
 *
 * @return all known unremoved children of this node.
 * @apiSince 1
 */

protected final java.util.prefs.AbstractPreferences[] cachedChildren() { throw new RuntimeException("Stub!"); }

/**
 * Implements the <tt>parent</tt> method as per the specification in
 * {@link java.util.prefs.Preferences#parent() Preferences#parent()}.
 *
 * <p>This implementation obtains this preference node's lock, checks that
 * the node has not been removed and returns the parent value that was
 * passed to this node's constructor.
 *
 * @return the parent of this preference node.
 * @throws java.lang.IllegalStateException if this node (or an ancestor) has been
 *         removed with the {@link #removeNode()} method.
 * @apiSince 1
 */

public java.util.prefs.Preferences parent() { throw new RuntimeException("Stub!"); }

/**
 * Implements the <tt>node</tt> method as per the specification in
 * {@link java.util.prefs.Preferences#node(java.lang.String) Preferences#node(String)}.
 *
 * <p>This implementation obtains this preference node's lock and checks
 * that the node has not been removed.  If <tt>path</tt> is <tt>""</tt>,
 * this node is returned; if <tt>path</tt> is <tt>"/"</tt>, this node's
 * root is returned.  If the first character in <tt>path</tt> is
 * not <tt>'/'</tt>, the implementation breaks <tt>path</tt> into
 * tokens and recursively traverses the path from this node to the
 * named node, "consuming" a name and a slash from <tt>path</tt> at
 * each step of the traversal.  At each step, the current node is locked
 * and the node's child-cache is checked for the named node.  If it is
 * not found, the name is checked to make sure its length does not
 * exceed <tt>MAX_NAME_LENGTH</tt>.  Then the {@link #childSpi(java.lang.String)}
 * method is invoked, and the result stored in this node's child-cache.
 * If the newly created <tt>Preferences</tt> object's {@link #newNode}
 * field is <tt>true</tt> and there are any node change listeners,
 * a notification event is enqueued for processing by the event dispatch
 * thread.
 *
 * <p>When there are no more tokens, the last value found in the
 * child-cache or returned by <tt>childSpi</tt> is returned by this
 * method.  If during the traversal, two <tt>"/"</tt> tokens occur
 * consecutively, or the final token is <tt>"/"</tt> (rather than a name),
 * an appropriate <tt>IllegalArgumentException</tt> is thrown.
 *
 * <p> If the first character of <tt>path</tt> is <tt>'/'</tt>
 * (indicating an absolute path name) this preference node's
 * lock is dropped prior to breaking <tt>path</tt> into tokens, and
 * this method recursively traverses the path starting from the root
 * (rather than starting from this node).  The traversal is otherwise
 * identical to the one described for relative path names.  Dropping
 * the lock on this node prior to commencing the traversal at the root
 * node is essential to avoid the possibility of deadlock, as per the
 * {@link #lock locking invariant}.
 *
 * @param path the path name of the preference node to return.
 * @return the specified preference node.
 * @throws java.lang.IllegalArgumentException if the path name is invalid (i.e.,
 *         it contains multiple consecutive slash characters, or ends
 *         with a slash character and is more than one character long).
 * @throws java.lang.IllegalStateException if this node (or an ancestor) has been
 *         removed with the {@link #removeNode()} method.
 * @apiSince 1
 */

public java.util.prefs.Preferences node(java.lang.String path) { throw new RuntimeException("Stub!"); }

/**
 * Implements the <tt>nodeExists</tt> method as per the specification in
 * {@link java.util.prefs.Preferences#nodeExists(java.lang.String) Preferences#nodeExists(String)}.
 *
 * <p>This implementation is very similar to {@link #node(java.lang.String)},
 * except that {@link #getChild(java.lang.String)} is used instead of {@link
 * #childSpi(java.lang.String)}.
 *
 * @param path the path name of the node whose existence is to be checked.
 * @return true if the specified node exists.
 * @throws java.util.prefs.BackingStoreException if this operation cannot be completed
 *         due to a failure in the backing store, or inability to
 *         communicate with it.
 * @throws java.lang.IllegalArgumentException if the path name is invalid (i.e.,
 *         it contains multiple consecutive slash characters, or ends
 *         with a slash character and is more than one character long).
 * @throws java.lang.IllegalStateException if this node (or an ancestor) has been
 *         removed with the {@link #removeNode()} method and
 *         <tt>pathname</tt> is not the empty string (<tt>""</tt>).
 * @apiSince 1
 */

public boolean nodeExists(java.lang.String path) throws java.util.prefs.BackingStoreException { throw new RuntimeException("Stub!"); }

/**
 * Implements the <tt>removeNode()</tt> method as per the specification in
 * {@link java.util.prefs.Preferences#removeNode() Preferences#removeNode()}.
 *
 * <p>This implementation checks to see that this node is the root; if so,
 * it throws an appropriate exception.  Then, it locks this node's parent,
 * and calls a recursive helper method that traverses the subtree rooted at
 * this node.  The recursive method locks the node on which it was called,
 * checks that it has not already been removed, and then ensures that all
 * of its children are cached: The {@link #childrenNamesSpi()} method is
 * invoked and each returned child name is checked for containment in the
 * child-cache.  If a child is not already cached, the {@link
 * #childSpi(java.lang.String)} method is invoked to create a <tt>Preferences</tt>
 * instance for it, and this instance is put into the child-cache.  Then
 * the helper method calls itself recursively on each node contained in its
 * child-cache.  Next, it invokes {@link #removeNodeSpi()}, marks itself
 * as removed, and removes itself from its parent's child-cache.  Finally,
 * if there are any node change listeners, it enqueues a notification
 * event for processing by the event dispatch thread.
 *
 * <p>Note that the helper method is always invoked with all ancestors up
 * to the "closest non-removed ancestor" locked.
 *
 * @throws java.lang.IllegalStateException if this node (or an ancestor) has already
 *         been removed with the {@link #removeNode()} method.
 * @throws java.lang.UnsupportedOperationException if this method is invoked on
 *         the root node.
 * @throws java.util.prefs.BackingStoreException if this operation cannot be completed
 *         due to a failure in the backing store, or inability to
 *         communicate with it.
 * @apiSince 1
 */

public void removeNode() throws java.util.prefs.BackingStoreException { throw new RuntimeException("Stub!"); }

/**
 * Implements the <tt>name</tt> method as per the specification in
 * {@link java.util.prefs.Preferences#name() Preferences#name()}.
 *
 * <p>This implementation merely returns the name that was
 * passed to this node's constructor.
 *
 * @return this preference node's name, relative to its parent.
 * @apiSince 1
 */

public java.lang.String name() { throw new RuntimeException("Stub!"); }

/**
 * Implements the <tt>absolutePath</tt> method as per the specification in
 * {@link java.util.prefs.Preferences#absolutePath() Preferences#absolutePath()}.
 *
 * <p>This implementation merely returns the absolute path name that
 * was computed at the time that this node was constructed (based on
 * the name that was passed to this node's constructor, and the names
 * that were passed to this node's ancestors' constructors).
 *
 * @return this preference node's absolute path name.
 * @apiSince 1
 */

public java.lang.String absolutePath() { throw new RuntimeException("Stub!"); }

/**
 * Implements the <tt>isUserNode</tt> method as per the specification in
 * {@link java.util.prefs.Preferences#isUserNode() Preferences#isUserNode()}.
 *
 * <p>This implementation compares this node's root node (which is stored
 * in a private field) with the value returned by
 * {@link java.util.prefs.Preferences#userRoot() Preferences#userRoot()}.  If the two object references are
 * identical, this method returns true.
 *
 * @return <tt>true</tt> if this preference node is in the user
 *         preference tree, <tt>false</tt> if it's in the system
 *         preference tree.
 * @apiSince 1
 */

public boolean isUserNode() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void addPreferenceChangeListener(java.util.prefs.PreferenceChangeListener pcl) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void removePreferenceChangeListener(java.util.prefs.PreferenceChangeListener pcl) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void addNodeChangeListener(java.util.prefs.NodeChangeListener ncl) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void removeNodeChangeListener(java.util.prefs.NodeChangeListener ncl) { throw new RuntimeException("Stub!"); }

/**
 * Put the given key-value association into this preference node.  It is
 * guaranteed that <tt>key</tt> and <tt>value</tt> are non-null and of
 * legal length.  Also, it is guaranteed that this node has not been
 * removed.  (The implementor needn't check for any of these things.)
 *
 * <p>This method is invoked with the lock on this node held.
 * @param key the key
 * @param value the value
 * @apiSince 1
 */

protected abstract void putSpi(java.lang.String key, java.lang.String value);

/**
 * Return the value associated with the specified key at this preference
 * node, or <tt>null</tt> if there is no association for this key, or the
 * association cannot be determined at this time.  It is guaranteed that
 * <tt>key</tt> is non-null.  Also, it is guaranteed that this node has
 * not been removed.  (The implementor needn't check for either of these
 * things.)
 *
 * <p> Generally speaking, this method should not throw an exception
 * under any circumstances.  If, however, if it does throw an exception,
 * the exception will be intercepted and treated as a <tt>null</tt>
 * return value.
 *
 * <p>This method is invoked with the lock on this node held.
 *
 * @param key the key
 * @return the value associated with the specified key at this preference
 *          node, or <tt>null</tt> if there is no association for this
 *          key, or the association cannot be determined at this time.
 * @apiSince 1
 */

protected abstract java.lang.String getSpi(java.lang.String key);

/**
 * Remove the association (if any) for the specified key at this
 * preference node.  It is guaranteed that <tt>key</tt> is non-null.
 * Also, it is guaranteed that this node has not been removed.
 * (The implementor needn't check for either of these things.)
 *
 * <p>This method is invoked with the lock on this node held.
 * @param key the key
 * @apiSince 1
 */

protected abstract void removeSpi(java.lang.String key);

/**
 * Removes this preference node, invalidating it and any preferences that
 * it contains.  The named child will have no descendants at the time this
 * invocation is made (i.e., the {@link java.util.prefs.Preferences#removeNode() Preferences#removeNode()} method
 * invokes this method repeatedly in a bottom-up fashion, removing each of
 * a node's descendants before removing the node itself).
 *
 * <p>This method is invoked with the lock held on this node and its
 * parent (and all ancestors that are being removed as a
 * result of a single invocation to {@link java.util.prefs.Preferences#removeNode() Preferences#removeNode()}).
 *
 * <p>The removal of a node needn't become persistent until the
 * <tt>flush</tt> method is invoked on this node (or an ancestor).
 *
 * <p>If this node throws a <tt>BackingStoreException</tt>, the exception
 * will propagate out beyond the enclosing {@link #removeNode()}
 * invocation.
 *
 * @throws java.util.prefs.BackingStoreException if this operation cannot be completed
 *         due to a failure in the backing store, or inability to
 *         communicate with it.
 * @apiSince 1
 */

protected abstract void removeNodeSpi() throws java.util.prefs.BackingStoreException;

/**
 * Returns all of the keys that have an associated value in this
 * preference node.  (The returned array will be of size zero if
 * this node has no preferences.)  It is guaranteed that this node has not
 * been removed.
 *
 * <p>This method is invoked with the lock on this node held.
 *
 * <p>If this node throws a <tt>BackingStoreException</tt>, the exception
 * will propagate out beyond the enclosing {@link #keys()} invocation.
 *
 * @return an array of the keys that have an associated value in this
 *         preference node.
 * @throws java.util.prefs.BackingStoreException if this operation cannot be completed
 *         due to a failure in the backing store, or inability to
 *         communicate with it.
 * @apiSince 1
 */

protected abstract java.lang.String[] keysSpi() throws java.util.prefs.BackingStoreException;

/**
 * Returns the names of the children of this preference node.  (The
 * returned array will be of size zero if this node has no children.)
 * This method need not return the names of any nodes already cached,
 * but may do so without harm.
 *
 * <p>This method is invoked with the lock on this node held.
 *
 * <p>If this node throws a <tt>BackingStoreException</tt>, the exception
 * will propagate out beyond the enclosing {@link #childrenNames()}
 * invocation.
 *
 * @return an array containing the names of the children of this
 *         preference node.
 * @throws java.util.prefs.BackingStoreException if this operation cannot be completed
 *         due to a failure in the backing store, or inability to
 *         communicate with it.
 * @apiSince 1
 */

protected abstract java.lang.String[] childrenNamesSpi() throws java.util.prefs.BackingStoreException;

/**
 * Returns the named child if it exists, or <tt>null</tt> if it does not.
 * It is guaranteed that <tt>nodeName</tt> is non-null, non-empty,
 * does not contain the slash character ('/'), and is no longer than
 * {@link #MAX_NAME_LENGTH} characters.  Also, it is guaranteed
 * that this node has not been removed.  (The implementor needn't check
 * for any of these things if he chooses to override this method.)
 *
 * <p>Finally, it is guaranteed that the named node has not been returned
 * by a previous invocation of this method or {@link #childSpi} after the
 * last time that it was removed.  In other words, a cached value will
 * always be used in preference to invoking this method.  (The implementor
 * needn't maintain his own cache of previously returned children if he
 * chooses to override this method.)
 *
 * <p>This implementation obtains this preference node's lock, invokes
 * {@link #childrenNames()} to get an array of the names of this node's
 * children, and iterates over the array comparing the name of each child
 * with the specified node name.  If a child node has the correct name,
 * the {@link #childSpi(java.lang.String)} method is invoked and the resulting
 * node is returned.  If the iteration completes without finding the
 * specified name, <tt>null</tt> is returned.
 *
 * @param nodeName name of the child to be searched for.
 * @return the named child if it exists, or null if it does not.
 * @throws java.util.prefs.BackingStoreException if this operation cannot be completed
 *         due to a failure in the backing store, or inability to
 *         communicate with it.
 * @apiSince 1
 */

protected java.util.prefs.AbstractPreferences getChild(java.lang.String nodeName) throws java.util.prefs.BackingStoreException { throw new RuntimeException("Stub!"); }

/**
 * Returns the named child of this preference node, creating it if it does
 * not already exist.  It is guaranteed that <tt>name</tt> is non-null,
 * non-empty, does not contain the slash character ('/'), and is no longer
 * than {@link #MAX_NAME_LENGTH} characters.  Also, it is guaranteed that
 * this node has not been removed.  (The implementor needn't check for any
 * of these things.)
 *
 * <p>Finally, it is guaranteed that the named node has not been returned
 * by a previous invocation of this method or {@link #getChild(java.lang.String)}
 * after the last time that it was removed.  In other words, a cached
 * value will always be used in preference to invoking this method.
 * Subclasses need not maintain their own cache of previously returned
 * children.
 *
 * <p>The implementer must ensure that the returned node has not been
 * removed.  If a like-named child of this node was previously removed, the
 * implementer must return a newly constructed <tt>AbstractPreferences</tt>
 * node; once removed, an <tt>AbstractPreferences</tt> node
 * cannot be "resuscitated."
 *
 * <p>If this method causes a node to be created, this node is not
 * guaranteed to be persistent until the <tt>flush</tt> method is
 * invoked on this node or one of its ancestors (or descendants).
 *
 * <p>This method is invoked with the lock on this node held.
 *
 * @param name The name of the child node to return, relative to
 *        this preference node.
 * @return The named child node.
 * @apiSince 1
 */

protected abstract java.util.prefs.AbstractPreferences childSpi(java.lang.String name);

/**
 * Returns the absolute path name of this preferences node.
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Implements the <tt>sync</tt> method as per the specification in
 * {@link java.util.prefs.Preferences#sync() Preferences#sync()}.
 *
 * <p>This implementation calls a recursive helper method that locks this
 * node, invokes syncSpi() on it, unlocks this node, and recursively
 * invokes this method on each "cached child."  A cached child is a child
 * of this node that has been created in this VM and not subsequently
 * removed.  In effect, this method does a depth first traversal of the
 * "cached subtree" rooted at this node, calling syncSpi() on each node in
 * the subTree while only that node is locked. Note that syncSpi() is
 * invoked top-down.
 *
 * @throws java.util.prefs.BackingStoreException if this operation cannot be completed
 *         due to a failure in the backing store, or inability to
 *         communicate with it.
 * @throws java.lang.IllegalStateException if this node (or an ancestor) has been
 *         removed with the {@link #removeNode()} method.
 * @see #flush()
 * @apiSince 1
 */

public void sync() throws java.util.prefs.BackingStoreException { throw new RuntimeException("Stub!"); }

/**
 * This method is invoked with this node locked.  The contract of this
 * method is to synchronize any cached preferences stored at this node
 * with any stored in the backing store.  (It is perfectly possible that
 * this node does not exist on the backing store, either because it has
 * been deleted by another VM, or because it has not yet been created.)
 * Note that this method should <i>not</i> synchronize the preferences in
 * any subnodes of this node.  If the backing store naturally syncs an
 * entire subtree at once, the implementer is encouraged to override
 * sync(), rather than merely overriding this method.
 *
 * <p>If this node throws a <tt>BackingStoreException</tt>, the exception
 * will propagate out beyond the enclosing {@link #sync()} invocation.
 *
 * @throws java.util.prefs.BackingStoreException if this operation cannot be completed
 *         due to a failure in the backing store, or inability to
 *         communicate with it.
 * @apiSince 1
 */

protected abstract void syncSpi() throws java.util.prefs.BackingStoreException;

/**
 * Implements the <tt>flush</tt> method as per the specification in
 * {@link java.util.prefs.Preferences#flush() Preferences#flush()}.
 *
 * <p>This implementation calls a recursive helper method that locks this
 * node, invokes flushSpi() on it, unlocks this node, and recursively
 * invokes this method on each "cached child."  A cached child is a child
 * of this node that has been created in this VM and not subsequently
 * removed.  In effect, this method does a depth first traversal of the
 * "cached subtree" rooted at this node, calling flushSpi() on each node in
 * the subTree while only that node is locked. Note that flushSpi() is
 * invoked top-down.
 *
 * <p> If this method is invoked on a node that has been removed with
 * the {@link #removeNode()} method, flushSpi() is invoked on this node,
 * but not on others.
 *
 * @throws java.util.prefs.BackingStoreException if this operation cannot be completed
 *         due to a failure in the backing store, or inability to
 *         communicate with it.
 * @see #flush()
 * @apiSince 1
 */

public void flush() throws java.util.prefs.BackingStoreException { throw new RuntimeException("Stub!"); }

/**
 * This method is invoked with this node locked.  The contract of this
 * method is to force any cached changes in the contents of this
 * preference node to the backing store, guaranteeing their persistence.
 * (It is perfectly possible that this node does not exist on the backing
 * store, either because it has been deleted by another VM, or because it
 * has not yet been created.)  Note that this method should <i>not</i>
 * flush the preferences in any subnodes of this node.  If the backing
 * store naturally flushes an entire subtree at once, the implementer is
 * encouraged to override flush(), rather than merely overriding this
 * method.
 *
 * <p>If this node throws a <tt>BackingStoreException</tt>, the exception
 * will propagate out beyond the enclosing {@link #flush()} invocation.
 *
 * @throws java.util.prefs.BackingStoreException if this operation cannot be completed
 *         due to a failure in the backing store, or inability to
 *         communicate with it.
 * @apiSince 1
 */

protected abstract void flushSpi() throws java.util.prefs.BackingStoreException;

/**
 * Returns <tt>true</tt> iff this node (or an ancestor) has been
 * removed with the {@link #removeNode()} method.  This method
 * locks this node prior to returning the contents of the private
 * field used to track this state.
 *
 * @return <tt>true</tt> iff this node (or an ancestor) has been
 *       removed with the {@link #removeNode()} method.
 * @apiSince 1
 */

protected boolean isRemoved() { throw new RuntimeException("Stub!"); }

/**
 * Implements the <tt>exportNode</tt> method as per the specification in
 * {@link java.util.prefs.Preferences#exportNode(java.io.OutputStream) Preferences#exportNode(OutputStream)}.
 *
 * @param os the output stream on which to emit the XML document.
 * @throws java.io.IOException if writing to the specified output stream
 *         results in an <tt>IOException</tt>.
 * @throws java.util.prefs.BackingStoreException if preference data cannot be read from
 *         backing store.
 * @apiSince 1
 */

public void exportNode(java.io.OutputStream os) throws java.util.prefs.BackingStoreException, java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Implements the <tt>exportSubtree</tt> method as per the specification in
 * {@link java.util.prefs.Preferences#exportSubtree(java.io.OutputStream) Preferences#exportSubtree(OutputStream)}.
 *
 * @param os the output stream on which to emit the XML document.
 * @throws java.io.IOException if writing to the specified output stream
 *         results in an <tt>IOException</tt>.
 * @throws java.util.prefs.BackingStoreException if preference data cannot be read from
 *         backing store.
 * @apiSince 1
 */

public void exportSubtree(java.io.OutputStream os) throws java.util.prefs.BackingStoreException, java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * An object whose monitor is used to lock this node.  This object
 * is used in preference to the node itself to reduce the likelihood of
 * intentional or unintentional denial of service due to a locked node.
 * To avoid deadlock, a node is <i>never</i> locked by a thread that
 * holds a lock on a descendant of that node.
 * @apiSince 1
 */

protected final java.lang.Object lock;
{ lock = null; }

/**
 * This field should be <tt>true</tt> if this node did not exist in the
 * backing store prior to the creation of this object.  The field
 * is initialized to false, but may be set to true by a subclass
 * constructor (and should not be modified thereafter).  This field
 * indicates whether a node change event should be fired when
 * creation is complete.
 * @apiSince 1
 */

protected boolean newNode = false;
}

