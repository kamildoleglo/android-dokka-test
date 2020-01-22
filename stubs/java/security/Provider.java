/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 1996, 2014, Oracle and/or its affiliates. All rights reserved.
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



package java.security;

import java.io.*;
import java.util.*;
import java.lang.ref.*;
import java.lang.reflect.*;
import java.security.Security;

/**
 * This class represents a "provider" for the
 * Java Security API, where a provider implements some or all parts of
 * Java Security. Services that a provider may implement include:
 *
 * <ul>
 *
 * <li>Algorithms (such as DSA, RSA, MD5 or SHA-1).
 *
 * <li>Key generation, conversion, and management facilities (such as for
 * algorithm-specific keys).
 *
 *</ul>
 *
 * <p>Each provider has a name and a version number, and is configured
 * in each runtime it is installed in.
 *
 * <p>See <a href =
 * "https://docs.oracle.com/javase/8/docs/technotes/guides/security/crypto/CryptoSpec.html#Provider">The Provider Class</a>
 * in the "Java Cryptography Architecture API Specification &amp; Reference"
 * for information about how a particular type of provider, the
 * cryptographic service provider, works and is installed. However,
 * please note that a provider can be used to implement any security
 * service in Java that uses a pluggable architecture with a choice
 * of implementations that fit underneath.
 *
 * <p>Some provider implementations may encounter unrecoverable internal
 * errors during their operation, for example a failure to communicate with a
 * security token. A {@link java.security.ProviderException ProviderException} should be used to indicate
 * such errors.
 *
 * <p>The service type {@code Provider} is reserved for use by the
 * security framework. Services of this type cannot be added, removed,
 * or modified by applications.
 * The following attributes are automatically placed in each Provider object:
 * <table cellspacing=4>
 * <caption><b>Attributes Automatically Placed in a Provider Object</b></caption>
 * <tr><th>Name</th><th>Value</th>
 * <tr><td>{@code Provider.id name}</td>
 *    <td>{@code String.valueOf(provider.getName())}</td>
 * <tr><td>{@code Provider.id version}</td>
 *     <td>{@code String.valueOf(provider.getVersion())}</td>
 * <tr><td>{@code Provider.id info}</td>
     <td>{@code String.valueOf(provider.getInfo())}</td>
 * <tr><td>{@code Provider.id className}</td>
 *     <td>{@code provider.getClass().getName()}</td>
 * </table>
 *
 * @author Benjamin Renaud
 * @author Andreas Sterbenz
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class Provider extends java.util.Properties {

/**
 * Constructs a provider with the specified name, version number,
 * and information.
 *
 * @param name the provider name.
 *
 * @param version the provider version number.
 *
 * @param info a description of the provider and its services.
 * @apiSince 1
 */

protected Provider(java.lang.String name, double version, java.lang.String info) { throw new RuntimeException("Stub!"); }

/**
 * Returns the name of this provider.
 *
 * @return the name of this provider.
 * @apiSince 1
 */

public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * Returns the version number for this provider.
 *
 * @return the version number for this provider.
 * @apiSince 1
 */

public double getVersion() { throw new RuntimeException("Stub!"); }

/**
 * Returns a human-readable description of the provider and its
 * services.  This may return an HTML page, with relevant links.
 *
 * @return a description of the provider and its services.
 * @apiSince 1
 */

public java.lang.String getInfo() { throw new RuntimeException("Stub!"); }

/**
 * Returns a string with the name and the version number
 * of this provider.
 *
 * @return the string with the name and the version number
 * for this provider.
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Clears this provider so that it no longer contains the properties
 * used to look up facilities implemented by the provider.
 *
 * <p>If a security manager is enabled, its {@code checkSecurityAccess}
 * method is called with the string {@code "clearProviderProperties."+name}
 * (where {@code name} is the provider name) to see if it's ok to clear
 * this provider.
 *
 * @throws  java.lang.SecurityException
 *          if a security manager exists and its {@link
 *          java.lang.SecurityManager#checkSecurityAccess} method
 *          denies access to clear this provider
 *
 * @since 1.2
 * @apiSince 1
 */

public synchronized void clear() { throw new RuntimeException("Stub!"); }

/**
 * Reads a property list (key and element pairs) from the input stream.
 *
 * @param inStream   the input stream.
 * @exception  java.io.IOException  if an error occurred when reading from the
 *               input stream.
 * @see java.util.Properties#load
 * @apiSince 1
 */

public synchronized void load(java.io.InputStream inStream) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Copies all of the mappings from the specified Map to this provider.
 * These mappings will replace any properties that this provider had
 * for any of the keys currently in the specified Map.
 *
 * @since 1.2
 * @apiSince 1
 */

public synchronized void putAll(java.util.Map<?,?> t) { throw new RuntimeException("Stub!"); }

/**
 * Returns an unmodifiable Set view of the property entries contained
 * in this Provider.
 *
 * @see   java.util.Map.Entry
 * @since 1.2
 * @apiSince 1
 */

public synchronized java.util.Set<java.util.Map.Entry<java.lang.Object,java.lang.Object>> entrySet() { throw new RuntimeException("Stub!"); }

/**
 * Returns an unmodifiable Set view of the property keys contained in
 * this provider.
 *
 * @since 1.2
 * @apiSince 1
 */

public java.util.Set<java.lang.Object> keySet() { throw new RuntimeException("Stub!"); }

/**
 * Returns an unmodifiable Collection view of the property values
 * contained in this provider.
 *
 * @since 1.2
 * @apiSince 1
 */

public java.util.Collection<java.lang.Object> values() { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@code key} property to have the specified
 * {@code value}.
 *
 * <p>If a security manager is enabled, its {@code checkSecurityAccess}
 * method is called with the string {@code "putProviderProperty."+name},
 * where {@code name} is the provider name, to see if it's ok to set this
 * provider's property values.
 *
 * @throws  java.lang.SecurityException
 *          if a security manager exists and its {@link
 *          java.lang.SecurityManager#checkSecurityAccess} method
 *          denies access to set property values.
 *
 * @since 1.2
 * @apiSince 1
 */

public synchronized java.lang.Object put(java.lang.Object key, java.lang.Object value) { throw new RuntimeException("Stub!"); }

/**
 * If the specified key is not already associated with a value (or is mapped
 * to {@code null}) associates it with the given value and returns
 * {@code null}, else returns the current value.
 *
 * <p>If a security manager is enabled, its {@code checkSecurityAccess}
 * method is called with the string {@code "putProviderProperty."+name},
 * where {@code name} is the provider name, to see if it's ok to set this
 * provider's property values.
 *
 * @throws  java.lang.SecurityException
 *          if a security manager exists and its {@link
 *          java.lang.SecurityManager#checkSecurityAccess} method
 *          denies access to set property values.
 *
 * @since 1.8
 * @apiSince 24
 */

public synchronized java.lang.Object putIfAbsent(java.lang.Object key, java.lang.Object value) { throw new RuntimeException("Stub!"); }

/**
 * Removes the {@code key} property (and its corresponding
 * {@code value}).
 *
 * <p>If a security manager is enabled, its {@code checkSecurityAccess}
 * method is called with the string {@code "removeProviderProperty."+name},
 * where {@code name} is the provider name, to see if it's ok to remove this
 * provider's properties.
 *
 * @throws  java.lang.SecurityException
 *          if a security manager exists and its {@link
 *          java.lang.SecurityManager#checkSecurityAccess} method
 *          denies access to remove this provider's properties.
 *
 * @since 1.2
 * @apiSince 1
 */

public synchronized java.lang.Object remove(java.lang.Object key) { throw new RuntimeException("Stub!"); }

/**
 * Removes the entry for the specified key only if it is currently
 * mapped to the specified value.
 *
 * <p>If a security manager is enabled, its {@code checkSecurityAccess}
 * method is called with the string {@code "removeProviderProperty."+name},
 * where {@code name} is the provider name, to see if it's ok to remove this
 * provider's properties.
 *
 * @throws  java.lang.SecurityException
 *          if a security manager exists and its {@link
 *          java.lang.SecurityManager#checkSecurityAccess} method
 *          denies access to remove this provider's properties.
 *
 * @since 1.8
 * @apiSince 24
 */

public synchronized boolean remove(java.lang.Object key, java.lang.Object value) { throw new RuntimeException("Stub!"); }

/**
 * Replaces the entry for the specified key only if currently
 * mapped to the specified value.
 *
 * <p>If a security manager is enabled, its {@code checkSecurityAccess}
 * method is called with the string {@code "putProviderProperty."+name},
 * where {@code name} is the provider name, to see if it's ok to set this
 * provider's property values.
 *
 * @throws  java.lang.SecurityException
 *          if a security manager exists and its {@link
 *          java.lang.SecurityManager#checkSecurityAccess} method
 *          denies access to set property values.
 *
 * @since 1.8
 * @apiSince 24
 */

public synchronized boolean replace(java.lang.Object key, java.lang.Object oldValue, java.lang.Object newValue) { throw new RuntimeException("Stub!"); }

/**
 * Replaces the entry for the specified key only if it is
 * currently mapped to some value.
 *
 * <p>If a security manager is enabled, its {@code checkSecurityAccess}
 * method is called with the string {@code "putProviderProperty."+name},
 * where {@code name} is the provider name, to see if it's ok to set this
 * provider's property values.
 *
 * @throws  java.lang.SecurityException
 *          if a security manager exists and its {@link
 *          java.lang.SecurityManager#checkSecurityAccess} method
 *          denies access to set property values.
 *
 * @since 1.8
 * @apiSince 24
 */

public synchronized java.lang.Object replace(java.lang.Object key, java.lang.Object value) { throw new RuntimeException("Stub!"); }

/**
 * Replaces each entry's value with the result of invoking the given
 * function on that entry, in the order entries are returned by an entry
 * set iterator, until all entries have been processed or the function
 * throws an exception.
 *
 * <p>If a security manager is enabled, its {@code checkSecurityAccess}
 * method is called with the string {@code "putProviderProperty."+name},
 * where {@code name} is the provider name, to see if it's ok to set this
 * provider's property values.
 *
 * @throws  java.lang.SecurityException
 *          if a security manager exists and its {@link
 *          java.lang.SecurityManager#checkSecurityAccess} method
 *          denies access to set property values.
 *
 * @since 1.8
 * @apiSince 24
 */

public synchronized void replaceAll(java.util.function.BiFunction<? super java.lang.Object,? super java.lang.Object,?> function) { throw new RuntimeException("Stub!"); }

/**
 * Attempts to compute a mapping for the specified key and its
 * current mapped value (or {@code null} if there is no current
 * mapping).
 *
 * <p>If a security manager is enabled, its {@code checkSecurityAccess}
 * method is called with the strings {@code "putProviderProperty."+name}
 * and {@code "removeProviderProperty."+name}, where {@code name} is the
 * provider name, to see if it's ok to set this provider's property values
 * and remove this provider's properties.
 *
 * @throws  java.lang.SecurityException
 *          if a security manager exists and its {@link
 *          java.lang.SecurityManager#checkSecurityAccess} method
 *          denies access to set property values or remove properties.
 *
 * @since 1.8
 * @apiSince 24
 */

public synchronized java.lang.Object compute(java.lang.Object key, java.util.function.BiFunction<? super java.lang.Object,? super java.lang.Object,?> remappingFunction) { throw new RuntimeException("Stub!"); }

/**
 * If the specified key is not already associated with a value (or
 * is mapped to {@code null}), attempts to compute its value using
 * the given mapping function and enters it into this map unless
 * {@code null}.
 *
 * <p>If a security manager is enabled, its {@code checkSecurityAccess}
 * method is called with the strings {@code "putProviderProperty."+name}
 * and {@code "removeProviderProperty."+name}, where {@code name} is the
 * provider name, to see if it's ok to set this provider's property values
 * and remove this provider's properties.
 *
 * @throws  java.lang.SecurityException
 *          if a security manager exists and its {@link
 *          java.lang.SecurityManager#checkSecurityAccess} method
 *          denies access to set property values and remove properties.
 *
 * @since 1.8
 * @apiSince 24
 */

public synchronized java.lang.Object computeIfAbsent(java.lang.Object key, java.util.function.Function<? super java.lang.Object,?> mappingFunction) { throw new RuntimeException("Stub!"); }

/**
 * If the value for the specified key is present and non-null, attempts to
 * compute a new mapping given the key and its current mapped value.
 *
 * <p>If a security manager is enabled, its {@code checkSecurityAccess}
 * method is called with the strings {@code "putProviderProperty."+name}
 * and {@code "removeProviderProperty."+name}, where {@code name} is the
 * provider name, to see if it's ok to set this provider's property values
 * and remove this provider's properties.
 *
 * @throws  java.lang.SecurityException
 *          if a security manager exists and its {@link
 *          java.lang.SecurityManager#checkSecurityAccess} method
 *          denies access to set property values or remove properties.
 *
 * @since 1.8
 * @apiSince 24
 */

public synchronized java.lang.Object computeIfPresent(java.lang.Object key, java.util.function.BiFunction<? super java.lang.Object,? super java.lang.Object,?> remappingFunction) { throw new RuntimeException("Stub!"); }

/**
 * If the specified key is not already associated with a value or is
 * associated with null, associates it with the given value. Otherwise,
 * replaces the value with the results of the given remapping function,
 * or removes if the result is null. This method may be of use when
 * combining multiple mapped values for a key.
 *
 * <p>If a security manager is enabled, its {@code checkSecurityAccess}
 * method is called with the strings {@code "putProviderProperty."+name}
 * and {@code "removeProviderProperty."+name}, where {@code name} is the
 * provider name, to see if it's ok to set this provider's property values
 * and remove this provider's properties.
 *
 * @throws  java.lang.SecurityException
 *          if a security manager exists and its {@link
 *          java.lang.SecurityManager#checkSecurityAccess} method
 *          denies access to set property values or remove properties.
 *
 * @since 1.8
 * @apiSince 24
 */

public synchronized java.lang.Object merge(java.lang.Object key, java.lang.Object value, java.util.function.BiFunction<? super java.lang.Object,? super java.lang.Object,?> remappingFunction) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.Object get(java.lang.Object key) { throw new RuntimeException("Stub!"); }

/**
 * @since 1.8
 * @apiSince 24
 */

public synchronized java.lang.Object getOrDefault(java.lang.Object key, java.lang.Object defaultValue) { throw new RuntimeException("Stub!"); }

/**
 * @since 1.8
 * @apiSince 24
 */

public synchronized void forEach(java.util.function.BiConsumer<? super java.lang.Object,? super java.lang.Object> action) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.util.Enumeration<java.lang.Object> keys() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.util.Enumeration<java.lang.Object> elements() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String getProperty(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Get the service describing this Provider's implementation of the
 * specified type of this algorithm or alias. If no such
 * implementation exists, this method returns null. If there are two
 * matching services, one added to this provider using
 * {@link #putService putService()} and one added via {@link #put put()},
 * the service added via {@link #putService putService()} is returned.
 *
 * @param type the type of {@link java.security.Provider.Service Service} requested
 * (for example, {@code MessageDigest})
 * @param algorithm the case insensitive algorithm name (or alternate
 * alias) of the service requested (for example, {@code SHA-1})
 *
 * @return the service describing this Provider's matching service
 * or null if no such service exists
 *
 * @throws java.lang.NullPointerException if type or algorithm is null
 *
 * @since 1.5
 * @apiSince 1
 */

public synchronized java.security.Provider.Service getService(java.lang.String type, java.lang.String algorithm) { throw new RuntimeException("Stub!"); }

/**
 * Get an unmodifiable Set of all services supported by
 * this Provider.
 *
 * @return an unmodifiable Set of all services supported by
 * this Provider
 *
 * @since 1.5
 * @apiSince 1
 */

public synchronized java.util.Set<java.security.Provider.Service> getServices() { throw new RuntimeException("Stub!"); }

/**
 * Add a service. If a service of the same type with the same algorithm
 * name exists and it was added using {@link #putService putService()},
 * it is replaced by the new service.
 * This method also places information about this service
 * in the provider's Hashtable values in the format described in the
 * <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/security/crypto/CryptoSpec.html">
 * Java Cryptography Architecture API Specification &amp; Reference </a>.
 *
 * <p>Also, if there is a security manager, its
 * {@code checkSecurityAccess} method is called with the string
 * {@code "putProviderProperty."+name}, where {@code name} is
 * the provider name, to see if it's ok to set this provider's property
 * values. If the default implementation of {@code checkSecurityAccess}
 * is used (that is, that method is not overriden), then this results in
 * a call to the security manager's {@code checkPermission} method with
 * a {@code SecurityPermission("putProviderProperty."+name)}
 * permission.
 *
 * @param s the Service to add
 *
 * @throws java.lang.SecurityException
 *      if a security manager exists and its {@link
 *      java.lang.SecurityManager#checkSecurityAccess} method denies
 *      access to set property values.
 * @throws java.lang.NullPointerException if s is null
 *
 * @since 1.5
 * @apiSince 1
 */

protected synchronized void putService(java.security.Provider.Service s) { throw new RuntimeException("Stub!"); }

/**
 * Remove a service previously added using
 * {@link #putService putService()}. The specified service is removed from
 * this provider. It will no longer be returned by
 * {@link #getService getService()} and its information will be removed
 * from this provider's Hashtable.
 *
 * <p>Also, if there is a security manager, its
 * {@code checkSecurityAccess} method is called with the string
 * {@code "removeProviderProperty."+name}, where {@code name} is
 * the provider name, to see if it's ok to remove this provider's
 * properties. If the default implementation of
 * {@code checkSecurityAccess} is used (that is, that method is not
 * overriden), then this results in a call to the security manager's
 * {@code checkPermission} method with a
 * {@code SecurityPermission("removeProviderProperty."+name)}
 * permission.
 *
 * @param s the Service to be removed
 *
 * @throws  java.lang.SecurityException
 *          if a security manager exists and its {@link
 *          java.lang.SecurityManager#checkSecurityAccess} method denies
 *          access to remove this provider's properties.
 * @throws java.lang.NullPointerException if s is null
 *
 * @since 1.5
 * @apiSince 1
 */

protected synchronized void removeService(java.security.Provider.Service s) { throw new RuntimeException("Stub!"); }
/**
 * The description of a security service. It encapsulates the properties
 * of a service and contains a factory method to obtain new implementation
 * instances of this service.
 *
 * <p>Each service has a provider that offers the service, a type,
 * an algorithm name, and the name of the class that implements the
 * service. Optionally, it also includes a list of alternate algorithm
 * names for this service (aliases) and attributes, which are a map of
 * (name, value) String pairs.
 *
 * <p>This class defines the methods {@link #supportsParameter
 * supportsParameter()} and {@link #newInstance newInstance()}
 * which are used by the Java security framework when it searches for
 * suitable services and instantiates them. The valid arguments to those
 * methods depend on the type of service. For the service types defined
 * within Java SE, see the
 * <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/security/crypto/CryptoSpec.html">
 * Java Cryptography Architecture API Specification &amp; Reference </a>
 * for the valid values.
 * Note that components outside of Java SE can define additional types of
 * services and their behavior.
 *
 * <p>Instances of this class are immutable.
 *
 * @since 1.5
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Service {

/**
 * Construct a new service.
 *
 * @param provider the provider that offers this service
 * @param type the type of this service
 * @param algorithm the algorithm name
 * @param className the name of the class implementing this service
 * @param aliases List of aliases or null if algorithm has no aliases
 * @param attributes Map of attributes or null if this implementation
 *                   has no attributes
 *
 * @throws java.lang.NullPointerException if provider, type, algorithm, or
 * className is null
 * @apiSince 1
 */

public Service(java.security.Provider provider, java.lang.String type, java.lang.String algorithm, java.lang.String className, java.util.List<java.lang.String> aliases, java.util.Map<java.lang.String,java.lang.String> attributes) { throw new RuntimeException("Stub!"); }

/**
 * Get the type of this service. For example, {@code MessageDigest}.
 *
 * @return the type of this service
 * @apiSince 1
 */

public final java.lang.String getType() { throw new RuntimeException("Stub!"); }

/**
 * Return the name of the algorithm of this service. For example,
 * {@code SHA-1}.
 *
 * @return the algorithm of this service
 * @apiSince 1
 */

public final java.lang.String getAlgorithm() { throw new RuntimeException("Stub!"); }

/**
 * Return the Provider of this service.
 *
 * @return the Provider of this service
 * @apiSince 1
 */

public final java.security.Provider getProvider() { throw new RuntimeException("Stub!"); }

/**
 * Return the name of the class implementing this service.
 *
 * @return the name of the class implementing this service
 * @apiSince 1
 */

public final java.lang.String getClassName() { throw new RuntimeException("Stub!"); }

/**
 * Return the value of the specified attribute or null if this
 * attribute is not set for this Service.
 *
 * @param name the name of the requested attribute
 *
 * @return the value of the specified attribute or null if the
 *         attribute is not present
 *
 * @throws java.lang.NullPointerException if name is null
 * @apiSince 1
 */

public final java.lang.String getAttribute(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Return a new instance of the implementation described by this
 * service. The security provider framework uses this method to
 * construct implementations. Applications will typically not need
 * to call it.
 *
 * <p>The default implementation uses reflection to invoke the
 * standard constructor for this type of service.
 * Security providers can override this method to implement
 * instantiation in a different way.
 * For details and the values of constructorParameter that are
 * valid for the various types of services see the
 * <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/security/crypto/CryptoSpec.html">
 * Java Cryptography Architecture API Specification &amp;
 * Reference</a>.
 *
 * @param constructorParameter the value to pass to the constructor,
 * or null if this type of service does not use a constructorParameter.
 *
 * @return a new implementation of this service
 *
 * @throws java.security.InvalidParameterException if the value of
 * constructorParameter is invalid for this type of service.
 * @throws java.security.NoSuchAlgorithmException if instantiation failed for
 * any other reason.
 * @apiSince 1
 */

public java.lang.Object newInstance(java.lang.Object constructorParameter) throws java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/**
 * Test whether this Service can use the specified parameter.
 * Returns false if this service cannot use the parameter. Returns
 * true if this service can use the parameter, if a fast test is
 * infeasible, or if the status is unknown.
 *
 * <p>The security provider framework uses this method with
 * some types of services to quickly exclude non-matching
 * implementations for consideration.
 * Applications will typically not need to call it.
 *
 * <p>For details and the values of parameter that are valid for the
 * various types of services see the top of this class and the
 * <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/security/crypto/CryptoSpec.html">
 * Java Cryptography Architecture API Specification &amp;
 * Reference</a>.
 * Security providers can override it to implement their own test.
 *
 * @param parameter the parameter to test
 *
 * @return false if this this service cannot use the specified
 * parameter; true if it can possibly use the parameter
 *
 * @throws java.security.InvalidParameterException if the value of parameter is
 * invalid for this type of service or if this method cannot be
 * used with this type of service
 * @apiSince 1
 */

public boolean supportsParameter(java.lang.Object parameter) { throw new RuntimeException("Stub!"); }

/**
 * Return a String representation of this service.
 *
 * @return a String representation of this service.
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

}

