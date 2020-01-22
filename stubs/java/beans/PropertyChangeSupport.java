/*
 * Copyright (c) 1996, 2013, Oracle and/or its affiliates. All rights reserved.
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


package java.beans;


/**
 * This is a utility class that can be used by beans that support bound
 * properties.  It manages a list of listeners and dispatches
 * {@link java.beans.PropertyChangeEvent PropertyChangeEvent}s to them.  You can use an instance of this class
 * as a member field of your bean and delegate these types of work to it.
 * The {@link java.beans.PropertyChangeListener PropertyChangeListener} can be registered for all properties
 * or for a property specified by name.
 * <p>
 * Here is an example of {@code PropertyChangeSupport} usage that follows
 * the rules and recommendations laid out in the JavaBeans&trade; specification:
 * <pre>
 * public class MyBean {
 *     private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
 *
 *     public void addPropertyChangeListener(PropertyChangeListener listener) {
 *         this.pcs.addPropertyChangeListener(listener);
 *     }
 *
 *     public void removePropertyChangeListener(PropertyChangeListener listener) {
 *         this.pcs.removePropertyChangeListener(listener);
 *     }
 *
 *     private String value;
 *
 *     public String getValue() {
 *         return this.value;
 *     }
 *
 *     public void setValue(String newValue) {
 *         String oldValue = this.value;
 *         this.value = newValue;
 *         this.pcs.firePropertyChange("value", oldValue, newValue);
 *     }
 *
 *     [...]
 * }
 * </pre>
 * <p>
 * A {@code PropertyChangeSupport} instance is thread-safe.
 * <p>
 * This class is serializable.  When it is serialized it will save
 * (and restore) any listeners that are themselves serializable.  Any
 * non-serializable listeners will be skipped during serialization.
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class PropertyChangeSupport implements java.io.Serializable {

/**
 * Constructs a <code>PropertyChangeSupport</code> object.
 *
 * @param sourceBean  The bean to be given as the source for any events.
 * @apiSince 3
 */

public PropertyChangeSupport(java.lang.Object sourceBean) { throw new RuntimeException("Stub!"); }

/**
 * Add a PropertyChangeListener to the listener list.
 * The listener is registered for all properties.
 * The same listener object may be added more than once, and will be called
 * as many times as it is added.
 * If <code>listener</code> is null, no exception is thrown and no action
 * is taken.
 *
 * @param listener  The PropertyChangeListener to be added
 * @apiSince 3
 */

public void addPropertyChangeListener(java.beans.PropertyChangeListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Remove a PropertyChangeListener from the listener list.
 * This removes a PropertyChangeListener that was registered
 * for all properties.
 * If <code>listener</code> was added more than once to the same event
 * source, it will be notified one less time after being removed.
 * If <code>listener</code> is null, or was never added, no exception is
 * thrown and no action is taken.
 *
 * @param listener  The PropertyChangeListener to be removed
 * @apiSince 3
 */

public void removePropertyChangeListener(java.beans.PropertyChangeListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Returns an array of all the listeners that were added to the
 * PropertyChangeSupport object with addPropertyChangeListener().
 * <p>
 * If some listeners have been added with a named property, then
 * the returned array will be a mixture of PropertyChangeListeners
 * and <code>PropertyChangeListenerProxy</code>s. If the calling
 * method is interested in distinguishing the listeners then it must
 * test each element to see if it's a
 * <code>PropertyChangeListenerProxy</code>, perform the cast, and examine
 * the parameter.
 *
 * <pre>{@code
 * PropertyChangeListener[] listeners = bean.getPropertyChangeListeners();
 * for (int i = 0; i < listeners.length; i++) {
 *   if (listeners[i] instanceof PropertyChangeListenerProxy) {
 *     PropertyChangeListenerProxy proxy =
 *                    (PropertyChangeListenerProxy)listeners[i];
 *     if (proxy.getPropertyName().equals("foo")) {
 *       // proxy is a PropertyChangeListener which was associated
 *       // with the property named "foo"
 *     }
 *   }
 * }
 * }</pre>
 *
 * @see java.beans.PropertyChangeListenerProxy
 * @return all of the <code>PropertyChangeListeners</code> added or an
 *         empty array if no listeners have been added
 * @since 1.4
 * @apiSince 3
 */

public java.beans.PropertyChangeListener[] getPropertyChangeListeners() { throw new RuntimeException("Stub!"); }

/**
 * Add a PropertyChangeListener for a specific property.  The listener
 * will be invoked only when a call on firePropertyChange names that
 * specific property.
 * The same listener object may be added more than once.  For each
 * property,  the listener will be invoked the number of times it was added
 * for that property.
 * If <code>propertyName</code> or <code>listener</code> is null, no
 * exception is thrown and no action is taken.
 *
 * @param propertyName  The name of the property to listen on.
 * @param listener  The PropertyChangeListener to be added
 * @apiSince 3
 */

public void addPropertyChangeListener(java.lang.String propertyName, java.beans.PropertyChangeListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Remove a PropertyChangeListener for a specific property.
 * If <code>listener</code> was added more than once to the same event
 * source for the specified property, it will be notified one less time
 * after being removed.
 * If <code>propertyName</code> is null,  no exception is thrown and no
 * action is taken.
 * If <code>listener</code> is null, or was never added for the specified
 * property, no exception is thrown and no action is taken.
 *
 * @param propertyName  The name of the property that was listened on.
 * @param listener  The PropertyChangeListener to be removed
 * @apiSince 3
 */

public void removePropertyChangeListener(java.lang.String propertyName, java.beans.PropertyChangeListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Returns an array of all the listeners which have been associated
 * with the named property.
 *
 * @param propertyName  The name of the property being listened to
 * @return all of the <code>PropertyChangeListeners</code> associated with
 *         the named property.  If no such listeners have been added,
 *         or if <code>propertyName</code> is null, an empty array is
 *         returned.
 * @since 1.4
 * @apiSince 3
 */

public java.beans.PropertyChangeListener[] getPropertyChangeListeners(java.lang.String propertyName) { throw new RuntimeException("Stub!"); }

/**
 * Reports a bound property update to listeners
 * that have been registered to track updates of
 * all properties or a property with the specified name.
 * <p>
 * No event is fired if old and new values are equal and non-null.
 * <p>
 * This is merely a convenience wrapper around the more general
 * {@link #firePropertyChange(java.beans.PropertyChangeEvent)} method.
 *
 * @param propertyName  the programmatic name of the property that was changed
 * @param oldValue      the old value of the property
 * @param newValue      the new value of the property
 * @apiSince 3
 */

public void firePropertyChange(java.lang.String propertyName, java.lang.Object oldValue, java.lang.Object newValue) { throw new RuntimeException("Stub!"); }

/**
 * Reports an integer bound property update to listeners
 * that have been registered to track updates of
 * all properties or a property with the specified name.
 * <p>
 * No event is fired if old and new values are equal.
 * <p>
 * This is merely a convenience wrapper around the more general
 * {@link #firePropertyChange(java.lang.String,java.lang.Object,java.lang.Object)}  method.
 *
 * @param propertyName  the programmatic name of the property that was changed
 * @param oldValue      the old value of the property
 * @param newValue      the new value of the property
 * @apiSince 3
 */

public void firePropertyChange(java.lang.String propertyName, int oldValue, int newValue) { throw new RuntimeException("Stub!"); }

/**
 * Reports a boolean bound property update to listeners
 * that have been registered to track updates of
 * all properties or a property with the specified name.
 * <p>
 * No event is fired if old and new values are equal.
 * <p>
 * This is merely a convenience wrapper around the more general
 * {@link #firePropertyChange(java.lang.String,java.lang.Object,java.lang.Object)}  method.
 *
 * @param propertyName  the programmatic name of the property that was changed
 * @param oldValue      the old value of the property
 * @param newValue      the new value of the property
 * @apiSince 3
 */

public void firePropertyChange(java.lang.String propertyName, boolean oldValue, boolean newValue) { throw new RuntimeException("Stub!"); }

/**
 * Fires a property change event to listeners
 * that have been registered to track updates of
 * all properties or a property with the specified name.
 * <p>
 * No event is fired if the given event's old and new values are equal and non-null.
 *
 * @param event  the {@code PropertyChangeEvent} to be fired
 * @apiSince 3
 */

public void firePropertyChange(java.beans.PropertyChangeEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Reports a bound indexed property update to listeners
 * that have been registered to track updates of
 * all properties or a property with the specified name.
 * <p>
 * No event is fired if old and new values are equal and non-null.
 * <p>
 * This is merely a convenience wrapper around the more general
 * {@link #firePropertyChange(java.beans.PropertyChangeEvent)} method.
 *
 * @param propertyName  the programmatic name of the property that was changed
 * @param index         the index of the property element that was changed
 * @param oldValue      the old value of the property
 * @param newValue      the new value of the property
 * @since 1.5
 * @apiSince 3
 */

public void fireIndexedPropertyChange(java.lang.String propertyName, int index, java.lang.Object oldValue, java.lang.Object newValue) { throw new RuntimeException("Stub!"); }

/**
 * Reports an integer bound indexed property update to listeners
 * that have been registered to track updates of
 * all properties or a property with the specified name.
 * <p>
 * No event is fired if old and new values are equal.
 * <p>
 * This is merely a convenience wrapper around the more general
 * {@link #fireIndexedPropertyChange(java.lang.String,int,java.lang.Object,java.lang.Object)} method.
 *
 * @param propertyName  the programmatic name of the property that was changed
 * @param index         the index of the property element that was changed
 * @param oldValue      the old value of the property
 * @param newValue      the new value of the property
 * @since 1.5
 * @apiSince 3
 */

public void fireIndexedPropertyChange(java.lang.String propertyName, int index, int oldValue, int newValue) { throw new RuntimeException("Stub!"); }

/**
 * Reports a boolean bound indexed property update to listeners
 * that have been registered to track updates of
 * all properties or a property with the specified name.
 * <p>
 * No event is fired if old and new values are equal.
 * <p>
 * This is merely a convenience wrapper around the more general
 * {@link #fireIndexedPropertyChange(java.lang.String,int,java.lang.Object,java.lang.Object)} method.
 *
 * @param propertyName  the programmatic name of the property that was changed
 * @param index         the index of the property element that was changed
 * @param oldValue      the old value of the property
 * @param newValue      the new value of the property
 * @since 1.5
 * @apiSince 3
 */

public void fireIndexedPropertyChange(java.lang.String propertyName, int index, boolean oldValue, boolean newValue) { throw new RuntimeException("Stub!"); }

/**
 * Check if there are any listeners for a specific property, including
 * those registered on all properties.  If <code>propertyName</code>
 * is null, only check for listeners registered on all properties.
 *
 * @param propertyName  the property name.
 * @return true if there are one or more listeners for the given property
 * @apiSince 3
 */

public boolean hasListeners(java.lang.String propertyName) { throw new RuntimeException("Stub!"); }
}

