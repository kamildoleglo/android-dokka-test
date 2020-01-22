/*
 * Copyright (c) 1994, 2012, Oracle and/or its affiliates. All rights reserved.
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
 * This class represents an observable object, or "data"
 * in the model-view paradigm. It can be subclassed to represent an
 * object that the application wants to have observed.
 * <p>
 * An observable object can have one or more observers. An observer
 * may be any object that implements interface <tt>Observer</tt>. After an
 * observable instance changes, an application calling the
 * <code>Observable</code>'s <code>notifyObservers</code> method
 * causes all of its observers to be notified of the change by a call
 * to their <code>update</code> method.
 * <p>
 * The order in which notifications will be delivered is unspecified.
 * The default implementation provided in the Observable class will
 * notify Observers in the order in which they registered interest, but
 * subclasses may change this order, use no guaranteed order, deliver
 * notifications on separate threads, or may guarantee that their
 * subclass follows this order, as they choose.
 * <p>
 * Note that this notification mechanism has nothing to do with threads
 * and is completely separate from the <tt>wait</tt> and <tt>notify</tt>
 * mechanism of class <tt>Object</tt>.
 * <p>
 * When an observable object is newly created, its set of observers is
 * empty. Two observers are considered the same if and only if the
 * <tt>equals</tt> method returns true for them.
 *
 * @author  Chris Warth
 * @see     java.util.Observable#notifyObservers()
 * @see     java.util.Observable#notifyObservers(java.lang.Object)
 * @see     java.util.Observer
 * @see     java.util.Observer#update(java.util.Observable, java.lang.Object)
 * @since   JDK1.0
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Observable {

/**
 * Construct an Observable with zero Observers.
 * @apiSince 1
 */

public Observable() { throw new RuntimeException("Stub!"); }

/**
 * Adds an observer to the set of observers for this object, provided
 * that it is not the same as some observer already in the set.
 * The order in which notifications will be delivered to multiple
 * observers is not specified. See the class comment.
 *
 * @param   o   an observer to be added.
 * @throws java.lang.NullPointerException   if the parameter o is null.
 * @apiSince 1
 */

public synchronized void addObserver(java.util.Observer o) { throw new RuntimeException("Stub!"); }

/**
 * Deletes an observer from the set of observers of this object.
 * Passing <CODE>null</CODE> to this method will have no effect.
 * @param   o   the observer to be deleted.
 * @apiSince 1
 */

public synchronized void deleteObserver(java.util.Observer o) { throw new RuntimeException("Stub!"); }

/**
 * If this object has changed, as indicated by the
 * <code>hasChanged</code> method, then notify all of its observers
 * and then call the <code>clearChanged</code> method to
 * indicate that this object has no longer changed.
 * <p>
 * Each observer has its <code>update</code> method called with two
 * arguments: this observable object and <code>null</code>. In other
 * words, this method is equivalent to:
 * <blockquote><tt>
 * notifyObservers(null)</tt></blockquote>
 *
 * @see     java.util.Observable#clearChanged()
 * @see     java.util.Observable#hasChanged()
 * @see     java.util.Observer#update(java.util.Observable, java.lang.Object)
 * @apiSince 1
 */

public void notifyObservers() { throw new RuntimeException("Stub!"); }

/**
 * If this object has changed, as indicated by the
 * <code>hasChanged</code> method, then notify all of its observers
 * and then call the <code>clearChanged</code> method to indicate
 * that this object has no longer changed.
 * <p>
 * Each observer has its <code>update</code> method called with two
 * arguments: this observable object and the <code>arg</code> argument.
 *
 * @param   arg   any object.
 * @see     java.util.Observable#clearChanged()
 * @see     java.util.Observable#hasChanged()
 * @see     java.util.Observer#update(java.util.Observable, java.lang.Object)
 * @apiSince 1
 */

public void notifyObservers(java.lang.Object arg) { throw new RuntimeException("Stub!"); }

/**
 * Clears the observer list so that this object no longer has any observers.
 * @apiSince 1
 */

public synchronized void deleteObservers() { throw new RuntimeException("Stub!"); }

/**
 * Marks this <tt>Observable</tt> object as having been changed; the
 * <tt>hasChanged</tt> method will now return <tt>true</tt>.
 * @apiSince 1
 */

protected synchronized void setChanged() { throw new RuntimeException("Stub!"); }

/**
 * Indicates that this object has no longer changed, or that it has
 * already notified all of its observers of its most recent change,
 * so that the <tt>hasChanged</tt> method will now return <tt>false</tt>.
 * This method is called automatically by the
 * <code>notifyObservers</code> methods.
 *
 * @see     java.util.Observable#notifyObservers()
 * @see     java.util.Observable#notifyObservers(java.lang.Object)
 * @apiSince 1
 */

protected synchronized void clearChanged() { throw new RuntimeException("Stub!"); }

/**
 * Tests if this object has changed.
 *
 * @return  <code>true</code> if and only if the <code>setChanged</code>
 *          method has been called more recently than the
 *          <code>clearChanged</code> method on this object;
 *          <code>false</code> otherwise.
 * @see     java.util.Observable#clearChanged()
 * @see     java.util.Observable#setChanged()
 * @apiSince 1
 */

public synchronized boolean hasChanged() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of observers of this <tt>Observable</tt> object.
 *
 * @return  the number of observers of this object.
 * @apiSince 1
 */

public synchronized int countObservers() { throw new RuntimeException("Stub!"); }
}

