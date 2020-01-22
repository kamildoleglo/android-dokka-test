/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 2013, 2015, Oracle and/or its affiliates. All rights reserved.
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


package java.lang;

import java.security.Policy;
import java.security.ProtectionDomain;
import java.security.CodeSource;
import java.net.URL;
import java.util.Enumeration;
import java.io.IOException;

/**
 * A class loader is an object that is responsible for loading classes. The
 * class <tt>ClassLoader</tt> is an abstract class.  Given the <a
 * href="#name">binary name</a> of a class, a class loader should attempt to
 * locate or generate data that constitutes a definition for the class.  A
 * typical strategy is to transform the name into a file name and then read a
 * "class file" of that name from a file system.
 *
 * <p> Every {@link java.lang.Class Class} object contains a {@link java.lang.Class#getClassLoader() Class#getClassLoader()} to the <tt>ClassLoader</tt> that defined
 * it.
 *
 * <p> <tt>Class</tt> objects for array classes are not created by class
 * loaders, but are created automatically as required by the Java runtime.
 * The class loader for an array class, as returned by {@link java.lang.Class#getClassLoader() Class#getClassLoader()} is the same as the class loader for its element
 * type; if the element type is a primitive type, then the array class has no
 * class loader.
 *
 * <p> Applications implement subclasses of <tt>ClassLoader</tt> in order to
 * extend the manner in which the Java virtual machine dynamically loads
 * classes.
 *
 * <p> Class loaders may typically be used by security managers to indicate
 * security domains.
 *
 * <p> The <tt>ClassLoader</tt> class uses a delegation model to search for
 * classes and resources.  Each instance of <tt>ClassLoader</tt> has an
 * associated parent class loader.  When requested to find a class or
 * resource, a <tt>ClassLoader</tt> instance will delegate the search for the
 * class or resource to its parent class loader before attempting to find the
 * class or resource itself.  The virtual machine's built-in class loader,
 * called the "bootstrap class loader", does not itself have a parent but may
 * serve as the parent of a <tt>ClassLoader</tt> instance.
 *
 * <p> Class loaders that support concurrent loading of classes are known as
 * <em>parallel capable</em> class loaders and are required to register
 * themselves at their class initialization time by invoking the
 * {@link
 * #registerAsParallelCapable <tt>ClassLoader.registerAsParallelCapable</tt>}
 * method. Note that the <tt>ClassLoader</tt> class is registered as parallel
 * capable by default. However, its subclasses still need to register themselves
 * if they are parallel capable. <br>
 * In environments in which the delegation model is not strictly
 * hierarchical, class loaders need to be parallel capable, otherwise class
 * loading can lead to deadlocks because the loader lock is held for the
 * duration of the class loading process (see {@link #loadClass
 * <tt>loadClass</tt>} methods).
 *
 * <p> Normally, the Java virtual machine loads classes from the local file
 * system in a platform-dependent manner.  For example, on UNIX systems, the
 * virtual machine loads classes from the directory defined by the
 * <tt>CLASSPATH</tt> environment variable.
 *
 * <p> However, some classes may not originate from a file; they may originate
 * from other sources, such as the network, or they could be constructed by an
 * application.  The method {@link #defineClass(java.lang.String,byte[],int,int)
 * <tt>defineClass</tt>} converts an array of bytes into an instance of class
 * <tt>Class</tt>. Instances of this newly defined class can be created using
 * {@link java.lang.Class#newInstance Class#newInstance}.
 *
 * <p> The methods and constructors of objects created by a class loader may
 * reference other classes.  To determine the class(es) referred to, the Java
 * virtual machine invokes the {@link #loadClass <tt>loadClass</tt>} method of
 * the class loader that originally created the class.
 *
 * <p> For example, an application could create a network class loader to
 * download class files from a server.  Sample code might look like:
 *
 * <blockquote><pre>
 *   ClassLoader loader&nbsp;= new NetworkClassLoader(host,&nbsp;port);
 *   Object main&nbsp;= loader.loadClass("Main", true).newInstance();
 *       &nbsp;.&nbsp;.&nbsp;.
 * </pre></blockquote>
 *
 * <p> The network class loader subclass must define the methods {@link
 * #findClass <tt>findClass</tt>} and <tt>loadClassData</tt> to load a class
 * from the network.  Once it has downloaded the bytes that make up the class,
 * it should use the method {@link #defineClass <tt>defineClass</tt>} to
 * create a class instance.  A sample implementation is:
 *
 * <blockquote><pre>
 *     class NetworkClassLoader extends ClassLoader {
 *         String host;
 *         int port;
 *
 *         public Class findClass(String name) {
 *             byte[] b = loadClassData(name);
 *             return defineClass(name, b, 0, b.length);
 *         }
 *
 *         private byte[] loadClassData(String name) {
 *             // load the class data from the connection
 *             &nbsp;.&nbsp;.&nbsp;.
 *         }
 *     }
 * </pre></blockquote>
 *
 * <h3> <a name="name">Binary names</a> </h3>
 *
 * <p> Any class name provided as a {@link java.lang.String String} parameter to methods in
 * <tt>ClassLoader</tt> must be a binary name as defined by
 * <cite>The Java&trade; Language Specification</cite>.
 *
 * <p> Examples of valid class names include:
 * <blockquote><pre>
 *   "java.lang.String"
 *   "javax.swing.JSpinner$DefaultEditor"
 *   "java.security.KeyStore$Builder$FileBuilder$1"
 *   "java.net.URLClassLoader$3$1"
 * </pre></blockquote>
 *
 * @see      #resolveClass(Class)
 * @since 1.0
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class ClassLoader {

/**
 * Creates a new class loader using the specified parent class loader for
 * delegation.
 *
 * <p> If there is a security manager, its {@link java.lang.SecurityManager#checkCreateClassLoader() SecurityManager#checkCreateClassLoader()} method is invoked.  This may result in
 * a security exception.  </p>
 *
 * @param  parent
 *         The parent class loader
 *
 * @throws  java.lang.SecurityException
 *          If a security manager exists and its
 *          <tt>checkCreateClassLoader</tt> method doesn't allow creation
 *          of a new class loader.
 *
 * @since  1.2
 * @apiSince 1
 */

protected ClassLoader(java.lang.ClassLoader parent) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new class loader using the <tt>ClassLoader</tt> returned by
 * the method {@link #getSystemClassLoader()
 * <tt>getSystemClassLoader()</tt>} as the parent class loader.
 *
 * <p> If there is a security manager, its {@link java.lang.SecurityManager#checkCreateClassLoader() SecurityManager#checkCreateClassLoader()} method is invoked.  This may result in
 * a security exception.  </p>
 *
 * @throws  java.lang.SecurityException
 *          If a security manager exists and its
 *          <tt>checkCreateClassLoader</tt> method doesn't allow creation
 *          of a new class loader.
 * @apiSince 1
 */

protected ClassLoader() { throw new RuntimeException("Stub!"); }

/**
 * Loads the class with the specified <a href="#name">binary name</a>.
 * This method searches for classes in the same manner as the {@link
 * #loadClass(java.lang.String,boolean)} method.  It is invoked by the Java virtual
 * machine to resolve class references.  Invoking this method is equivalent
 * to invoking {@link #loadClass(java.lang.String,boolean) <tt>loadClass(name,
 * false)</tt>}.
 *
 * @param  name
 *         The <a href="#name">binary name</a> of the class
 *
 * @return  The resulting <tt>Class</tt> object
 *
 * @throws  java.lang.ClassNotFoundException
 *          If the class was not found
 * @apiSince 1
 */

public java.lang.Class<?> loadClass(java.lang.String name) throws java.lang.ClassNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Loads the class with the specified <a href="#name">binary name</a>.  The
 * default implementation of this method searches for classes in the
 * following order:
 *
 * <ol>
 *
 *   <li><p> Invoke {@link #findLoadedClass(java.lang.String)} to check if the class
 *   has already been loaded.  </p></li>
 *
 *   <li><p> Invoke the {@link #loadClass(java.lang.String) <tt>loadClass</tt>} method
 *   on the parent class loader.  If the parent is <tt>null</tt> the class
 *   loader built-in to the virtual machine is used, instead.  </p></li>
 *
 *   <li><p> Invoke the {@link #findClass(java.lang.String)} method to find the
 *   class.  </p></li>
 *
 * </ol>
 *
 * <p> If the class was found using the above steps, and the
 * <tt>resolve</tt> flag is true, this method will then invoke the {@link
 * #resolveClass(java.lang.Class)} method on the resulting <tt>Class</tt> object.
 *
 * <p> Subclasses of <tt>ClassLoader</tt> are encouraged to override {@link
 * #findClass(java.lang.String)}, rather than this method.  </p>
 *
 *
 * @param  name
 *         The <a href="#name">binary name</a> of the class
 *
 * @param  resolve
 *         If <tt>true</tt> then resolve the class
 *
 * @return  The resulting <tt>Class</tt> object
 *
 * @throws  java.lang.ClassNotFoundException
 *          If the class could not be found
 * @apiSince 1
 */

protected java.lang.Class<?> loadClass(java.lang.String name, boolean resolve) throws java.lang.ClassNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Finds the class with the specified <a href="#name">binary name</a>.
 * This method should be overridden by class loader implementations that
 * follow the delegation model for loading classes, and will be invoked by
 * the {@link #loadClass <tt>loadClass</tt>} method after checking the
 * parent class loader for the requested class.  The default implementation
 * throws a <tt>ClassNotFoundException</tt>.
 *
 * @param  name
 *         The <a href="#name">binary name</a> of the class
 *
 * @return  The resulting <tt>Class</tt> object
 *
 * @throws  java.lang.ClassNotFoundException
 *          If the class could not be found
 *
 * @since  1.2
 * @apiSince 1
 */

protected java.lang.Class<?> findClass(java.lang.String name) throws java.lang.ClassNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Converts an array of bytes into an instance of class <tt>Class</tt>.
 * Before the <tt>Class</tt> can be used it must be resolved.  This method
 * is deprecated in favor of the version that takes a <a
 * href="#name">binary name</a> as its first argument, and is more secure.
 *
 * @param  b
 *         The bytes that make up the class data.  The bytes in positions
 *         <tt>off</tt> through <tt>off+len-1</tt> should have the format
 *         of a valid class file as defined by
 *         <cite>The Java&trade; Virtual Machine Specification</cite>.
 *
 * @param  off
 *         The start offset in <tt>b</tt> of the class data
 *
 * @param  len
 *         The length of the class data
 *
 * @return  The <tt>Class</tt> object that was created from the specified
 *          class data
 *
 * @throws  java.lang.ClassFormatError
 *          If the data did not contain a valid class
 *
 * @throws  java.lang.IndexOutOfBoundsException
 *          If either <tt>off</tt> or <tt>len</tt> is negative, or if
 *          <tt>off+len</tt> is greater than <tt>b.length</tt>.
 *
 * @throws  java.lang.SecurityException
 *          If an attempt is made to add this class to a package that
 *          contains classes that were signed by a different set of
 *          certificates than this class, or if an attempt is made
 *          to define a class in a package with a fully-qualified name
 *          that starts with "{@code java.}".
 *
 * @see  #loadClass(String, boolean)
 * @see  #resolveClass(Class)
 *
 * @deprecated  Replaced by {@link #defineClass(java.lang.String,byte[],int,int)
 * defineClass(String, byte[], int, int)}
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
protected final java.lang.Class<?> defineClass(byte[] b, int off, int len) throws java.lang.ClassFormatError { throw new RuntimeException("Stub!"); }

/**
 * Converts an array of bytes into an instance of class <tt>Class</tt>.
 * Before the <tt>Class</tt> can be used it must be resolved.
 *
 * <p> This method assigns a default {@link java.security.ProtectionDomain
 * <tt>ProtectionDomain</tt>} to the newly defined class.  The
 * <tt>ProtectionDomain</tt> is effectively granted the same set of
 * permissions returned when {@link
 * java.security.Policy#getPermissions(java.security.CodeSource)
 * <tt>Policy.getPolicy().getPermissions(new CodeSource(null, null))</tt>}
 * is invoked.  The default domain is created on the first invocation of
 * {@link #defineClass(java.lang.String,byte[],int,int) <tt>defineClass</tt>},
 * and re-used on subsequent invocations.
 *
 * <p> To assign a specific <tt>ProtectionDomain</tt> to the class, use
 * the {@link #defineClass(java.lang.String,byte[],int,int,java.security.ProtectionDomain) <tt>defineClass</tt>} method that takes a
 * <tt>ProtectionDomain</tt> as one of its arguments.  </p>
 *
 * @param  name
 *         The expected <a href="#name">binary name</a> of the class, or
 *         <tt>null</tt> if not known
 *
 * @param  b
 *         The bytes that make up the class data.  The bytes in positions
 *         <tt>off</tt> through <tt>off+len-1</tt> should have the format
 *         of a valid class file as defined by
 *         <cite>The Java&trade; Virtual Machine Specification</cite>.
 *
 * @param  off
 *         The start offset in <tt>b</tt> of the class data
 *
 * @param  len
 *         The length of the class data
 *
 * @return  The <tt>Class</tt> object that was created from the specified
 *          class data.
 *
 * @throws  java.lang.ClassFormatError
 *          If the data did not contain a valid class
 *
 * @throws  java.lang.IndexOutOfBoundsException
 *          If either <tt>off</tt> or <tt>len</tt> is negative, or if
 *          <tt>off+len</tt> is greater than <tt>b.length</tt>.
 *
 * @throws  java.lang.SecurityException
 *          If an attempt is made to add this class to a package that
 *          contains classes that were signed by a different set of
 *          certificates than this class (which is unsigned), or if
 *          <tt>name</tt> begins with "<tt>java.</tt>".
 *
 * @see  #loadClass(String, boolean)
 * @see  #resolveClass(Class)
 * @see  java.security.CodeSource
 * @see  java.security.SecureClassLoader
 *
 * @since  1.1
 * @apiSince 1
 */

protected final java.lang.Class<?> defineClass(java.lang.String name, byte[] b, int off, int len) throws java.lang.ClassFormatError { throw new RuntimeException("Stub!"); }

/**
 * Converts an array of bytes into an instance of class <tt>Class</tt>,
 * with an optional <tt>ProtectionDomain</tt>.  If the domain is
 * <tt>null</tt>, then a default domain will be assigned to the class as
 * specified in the documentation for {@link #defineClass(java.lang.String,byte[],int,int)}.  Before the class can be used it must be resolved.
 *
 * <p> The first class defined in a package determines the exact set of
 * certificates that all subsequent classes defined in that package must
 * contain.  The set of certificates for a class is obtained from the
 * {@link java.security.CodeSource <tt>CodeSource</tt>} within the
 * <tt>ProtectionDomain</tt> of the class.  Any classes added to that
 * package must contain the same set of certificates or a
 * <tt>SecurityException</tt> will be thrown.  Note that if
 * <tt>name</tt> is <tt>null</tt>, this check is not performed.
 * You should always pass in the <a href="#name">binary name</a> of the
 * class you are defining as well as the bytes.  This ensures that the
 * class you are defining is indeed the class you think it is.
 *
 * <p> The specified <tt>name</tt> cannot begin with "<tt>java.</tt>", since
 * all classes in the "<tt>java.*</tt> packages can only be defined by the
 * bootstrap class loader.  If <tt>name</tt> is not <tt>null</tt>, it
 * must be equal to the <a href="#name">binary name</a> of the class
 * specified by the byte array "<tt>b</tt>", otherwise a {@link java.lang.NoClassDefFoundError NoClassDefFoundError} will be thrown. </p>
 *
 * @param  name
 *         The expected <a href="#name">binary name</a> of the class, or
 *         <tt>null</tt> if not known
 *
 * @param  b
 *         The bytes that make up the class data. The bytes in positions
 *         <tt>off</tt> through <tt>off+len-1</tt> should have the format
 *         of a valid class file as defined by
 *         <cite>The Java&trade; Virtual Machine Specification</cite>.
 *
 * @param  off
 *         The start offset in <tt>b</tt> of the class data
 *
 * @param  len
 *         The length of the class data
 *
 * @param  protectionDomain
 *         The ProtectionDomain of the class
 *
 * @return  The <tt>Class</tt> object created from the data,
 *          and optional <tt>ProtectionDomain</tt>.
 *
 * @throws  java.lang.ClassFormatError
 *          If the data did not contain a valid class
 *
 * @throws  java.lang.NoClassDefFoundError
 *          If <tt>name</tt> is not equal to the <a href="#name">binary
 *          name</a> of the class specified by <tt>b</tt>
 *
 * @throws  java.lang.IndexOutOfBoundsException
 *          If either <tt>off</tt> or <tt>len</tt> is negative, or if
 *          <tt>off+len</tt> is greater than <tt>b.length</tt>.
 *
 * @throws  java.lang.SecurityException
 *          If an attempt is made to add this class to a package that
 *          contains classes that were signed by a different set of
 *          certificates than this class, or if <tt>name</tt> begins with
 *          "<tt>java.</tt>".
 * @apiSince 1
 */

protected final java.lang.Class<?> defineClass(java.lang.String name, byte[] b, int off, int len, java.security.ProtectionDomain protectionDomain) throws java.lang.ClassFormatError { throw new RuntimeException("Stub!"); }

/**
 * Converts a {@link java.nio.ByteBuffer <tt>ByteBuffer</tt>}
 * into an instance of class <tt>Class</tt>,
 * with an optional <tt>ProtectionDomain</tt>.  If the domain is
 * <tt>null</tt>, then a default domain will be assigned to the class as
 * specified in the documentation for {@link #defineClass(java.lang.String,byte[],int,int)}.  Before the class can be used it must be resolved.
 *
 * <p>The rules about the first class defined in a package determining the
 * set of certificates for the package, and the restrictions on class names
 * are identical to those specified in the documentation for {@link
 * #defineClass(java.lang.String,byte[],int,int,java.security.ProtectionDomain)}.
 *
 * <p> An invocation of this method of the form
 * <i>cl</i><tt>.defineClass(</tt><i>name</i><tt>,</tt>
 * <i>bBuffer</i><tt>,</tt> <i>pd</i><tt>)</tt> yields exactly the same
 * result as the statements
 *
 *<p> <tt>
 * ...<br>
 * byte[] temp = new byte[bBuffer.{@link
 * java.nio.ByteBuffer#remaining remaining}()];<br>
 *     bBuffer.{@link java.nio.ByteBuffer#get(byte[])
 * get}(temp);<br>
 *     return {@link #defineClass(java.lang.String,byte[],int,int,java.security.ProtectionDomain)
 * cl.defineClass}(name, temp, 0,
 * temp.length, pd);<br>
 * </tt></p>
 *
 * @param  name
 *         The expected <a href="#name">binary name</a>. of the class, or
 *         <tt>null</tt> if not known
 *
 * @param  b
 *         The bytes that make up the class data. The bytes from positions
 *         <tt>b.position()</tt> through <tt>b.position() + b.limit() -1
 *         </tt> should have the format of a valid class file as defined by
 *         <cite>The Java&trade; Virtual Machine Specification</cite>.
 *
 * @param  protectionDomain
 *         The ProtectionDomain of the class, or <tt>null</tt>.
 *
 * @return  The <tt>Class</tt> object created from the data,
 *          and optional <tt>ProtectionDomain</tt>.
 *
 * @throws  java.lang.ClassFormatError
 *          If the data did not contain a valid class.
 *
 * @throws  java.lang.NoClassDefFoundError
 *          If <tt>name</tt> is not equal to the <a href="#name">binary
 *          name</a> of the class specified by <tt>b</tt>
 *
 * @throws  java.lang.SecurityException
 *          If an attempt is made to add this class to a package that
 *          contains classes that were signed by a different set of
 *          certificates than this class, or if <tt>name</tt> begins with
 *          "<tt>java.</tt>".
 *
 * @see      #defineClass(String, byte[], int, int, ProtectionDomain)
 *
 * @since  1.5
 * @apiSince 1
 */

protected final java.lang.Class<?> defineClass(java.lang.String name, java.nio.ByteBuffer b, java.security.ProtectionDomain protectionDomain) throws java.lang.ClassFormatError { throw new RuntimeException("Stub!"); }

/**
 * Links the specified class.  This (misleadingly named) method may be
 * used by a class loader to link a class.  If the class <tt>c</tt> has
 * already been linked, then this method simply returns. Otherwise, the
 * class is linked as described in the "Execution" chapter of
 * <cite>The Java&trade; Language Specification</cite>.
 *
 * @param  c
 *         The class to link
 *
 * @throws  java.lang.NullPointerException
 *          If <tt>c</tt> is <tt>null</tt>.
 *
 * @see  #defineClass(String, byte[], int, int)
 * @apiSince 1
 */

protected final void resolveClass(java.lang.Class<?> c) { throw new RuntimeException("Stub!"); }

/**
 * Finds a class with the specified <a href="#name">binary name</a>,
 * loading it if necessary.
 *
 * <p> This method loads the class through the system class loader (see
 * {@link #getSystemClassLoader()}).  The <tt>Class</tt> object returned
 * might have more than one <tt>ClassLoader</tt> associated with it.
 * Subclasses of <tt>ClassLoader</tt> need not usually invoke this method,
 * because most class loaders need to override just {@link
 * #findClass(java.lang.String)}.  </p>
 *
 * @param  name
 *         The <a href="#name">binary name</a> of the class
 *
 * @return  The <tt>Class</tt> object for the specified <tt>name</tt>
 *
 * @throws  java.lang.ClassNotFoundException
 *          If the class could not be found
 *
 * @see  #ClassLoader(ClassLoader)
 * @see  #getParent()
 * @apiSince 1
 */

protected final java.lang.Class<?> findSystemClass(java.lang.String name) throws java.lang.ClassNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Returns the class with the given <a href="#name">binary name</a> if this
 * loader has been recorded by the Java virtual machine as an initiating
 * loader of a class with that <a href="#name">binary name</a>.  Otherwise
 * <tt>null</tt> is returned.
 *
 * @param  name
 *         The <a href="#name">binary name</a> of the class
 *
 * @return  The <tt>Class</tt> object, or <tt>null</tt> if the class has
 *          not been loaded
 *
 * @since  1.1
 * @apiSince 1
 */

protected final java.lang.Class<?> findLoadedClass(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Sets the signers of a class.  This should be invoked after defining a
 * class.
 *
 * @param  c
 *         The <tt>Class</tt> object
 *
 * @param  signers
 *         The signers for the class
 *
 * @since  1.1
 * @apiSince 1
 */

protected final void setSigners(java.lang.Class<?> c, java.lang.Object[] signers) { throw new RuntimeException("Stub!"); }

/**
 * Finds the resource with the given name.  A resource is some data
 * (images, audio, text, etc) that can be accessed by class code in a way
 * that is independent of the location of the code.
 *
 * <p> The name of a resource is a '<tt>/</tt>'-separated path name that
 * identifies the resource.
 *
 * <p> This method will first search the parent class loader for the
 * resource; if the parent is <tt>null</tt> the path of the class loader
 * built-in to the virtual machine is searched.  That failing, this method
 * will invoke {@link #findResource(java.lang.String)} to find the resource.  </p>
 *
 * @apiNote When overriding this method it is recommended that an
 * implementation ensures that any delegation is consistent with the {@link
 * #getResources(java.lang.String) getResources(String)} method.
 *
 * @param  name
 *         The resource name
 *
 * @return  A <tt>URL</tt> object for reading the resource, or
 *          <tt>null</tt> if the resource could not be found or the invoker
 *          doesn't have adequate  privileges to get the resource.
 *
 * @since  1.1
 * @apiSince 1
 */

public java.net.URL getResource(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Finds all the resources with the given name. A resource is some data
 * (images, audio, text, etc) that can be accessed by class code in a way
 * that is independent of the location of the code.
 *
 * <p>The name of a resource is a <tt>/</tt>-separated path name that
 * identifies the resource.
 *
 * <p> The search order is described in the documentation for {@link
 * #getResource(java.lang.String)}.  </p>
 *
 * @apiNote When overriding this method it is recommended that an
 * implementation ensures that any delegation is consistent with the {@link
 * #getResource(java.lang.String) getResource(String)} method. This should
 * ensure that the first element returned by the Enumeration's
 * {@code nextElement} method is the same resource that the
 * {@code getResource(String)} method would return.
 *
 * @param  name
 *         The resource name
 *
 * @return  An enumeration of {@link java.net.URL <tt>URL</tt>} objects for
 *          the resource.  If no resources could  be found, the enumeration
 *          will be empty.  Resources that the class loader doesn't have
 *          access to will not be in the enumeration.
 *
 * @throws  java.io.IOException
 *          If I/O errors occur
 *
 * @see  #findResources(String)
 *
 * @since  1.2
 * @apiSince 1
 */

public java.util.Enumeration<java.net.URL> getResources(java.lang.String name) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Finds the resource with the given name. Class loader implementations
 * should override this method to specify where to find resources.
 *
 * @param  name
 *         The resource name
 *
 * @return  A <tt>URL</tt> object for reading the resource, or
 *          <tt>null</tt> if the resource could not be found
 *
 * @since  1.2
 * @apiSince 1
 */

protected java.net.URL findResource(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Returns an enumeration of {@link java.net.URL <tt>URL</tt>} objects
 * representing all the resources with the given name. Class loader
 * implementations should override this method to specify where to load
 * resources from.
 *
 * @param  name
 *         The resource name
 *
 * @return  An enumeration of {@link java.net.URL <tt>URL</tt>} objects for
 *          the resources
 *
 * @throws  java.io.IOException
 *          If I/O errors occur
 *
 * @since  1.2
 * @apiSince 1
 */

protected java.util.Enumeration<java.net.URL> findResources(java.lang.String name) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Registers the caller as parallel capable.
 * The registration succeeds if and only if all of the following
 * conditions are met:
 * <ol>
 * <li> no instance of the caller has been created</li>
 * <li> all of the super classes (except class Object) of the caller are
 * registered as parallel capable</li>
 * </ol>
 * <p>Note that once a class loader is registered as parallel capable, there
 * is no way to change it back.</p>
 *
 * @return  true if the caller is successfully registered as
 *          parallel capable and false if otherwise.
 *
 * @since   1.7
 * @apiSince 24
 */

protected static boolean registerAsParallelCapable() { throw new RuntimeException("Stub!"); }

/**
 * Find a resource of the specified name from the search path used to load
 * classes.  This method locates the resource through the system class
 * loader (see {@link #getSystemClassLoader()}).
 *
 * @param  name
 *         The resource name
 *
 * @return  A {@link java.net.URL <tt>URL</tt>} object for reading the
 *          resource, or <tt>null</tt> if the resource could not be found
 *
 * @since  1.1
 * @apiSince 1
 */

public static java.net.URL getSystemResource(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Finds all resources of the specified name from the search path used to
 * load classes.  The resources thus found are returned as an
 * {@link java.util.Enumeration <tt>Enumeration</tt>} of {@link
 * java.net.URL <tt>URL</tt>} objects.
 *
 * <p> The search order is described in the documentation for {@link
 * #getSystemResource(java.lang.String)}.  </p>
 *
 * @param  name
 *         The resource name
 *
 * @return  An enumeration of resource {@link java.net.URL <tt>URL</tt>}
 *          objects
 *
 * @throws  java.io.IOException
 *          If I/O errors occur
 
 * @since  1.2
 * @apiSince 1
 */

public static java.util.Enumeration<java.net.URL> getSystemResources(java.lang.String name) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Returns an input stream for reading the specified resource.
 *
 * <p> The search order is described in the documentation for {@link
 * #getResource(java.lang.String)}.  </p>
 *
 * @param  name
 *         The resource name
 *
 * @return  An input stream for reading the resource, or <tt>null</tt>
 *          if the resource could not be found
 *
 * @since  1.1
 * @apiSince 1
 */

public java.io.InputStream getResourceAsStream(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Open for reading, a resource of the specified name from the search path
 * used to load classes.  This method locates the resource through the
 * system class loader (see {@link #getSystemClassLoader()}).
 *
 * @param  name
 *         The resource name
 *
 * @return  An input stream for reading the resource, or <tt>null</tt>
 *          if the resource could not be found
 *
 * @since  1.1
 * @apiSince 1
 */

public static java.io.InputStream getSystemResourceAsStream(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Returns the parent class loader for delegation. Some implementations may
 * use <tt>null</tt> to represent the bootstrap class loader. This method
 * will return <tt>null</tt> in such implementations if this class loader's
 * parent is the bootstrap class loader.
 *
 * <p> If a security manager is present, and the invoker's class loader is
 * not <tt>null</tt> and is not an ancestor of this class loader, then this
 * method invokes the security manager's {@link java.lang.SecurityManager#checkPermission(java.security.Permission) SecurityManager#checkPermission(java.security.Permission)} method with a {@link java.lang.RuntimePermission#RuntimePermission(java.lang.String) RuntimePermission#RuntimePermission(String)} permission to verify
 * access to the parent class loader is permitted.  If not, a
 * <tt>SecurityException</tt> will be thrown.  </p>
 *
 * @return  The parent <tt>ClassLoader</tt>
 *
 * @throws  java.lang.SecurityException
 *          If a security manager exists and its <tt>checkPermission</tt>
 *          method doesn't allow access to this class loader's parent class
 *          loader.
 *
 * @since  1.2
 * @apiSince 1
 */

public final java.lang.ClassLoader getParent() { throw new RuntimeException("Stub!"); }

/**
 * Returns the system class loader for delegation.  This is the default
 * delegation parent for new <tt>ClassLoader</tt> instances, and is
 * typically the class loader used to start the application.
 *
 * <p> This method is first invoked early in the runtime's startup
 * sequence, at which point it creates the system class loader and sets it
 * as the context class loader of the invoking <tt>Thread</tt>.
 *
 * <p> The default system class loader is an implementation-dependent
 * instance of this class.
 *
 * <p> If a security manager is present, and the invoker's class loader is
 * not <tt>null</tt> and the invoker's class loader is not the same as or
 * an ancestor of the system class loader, then this method invokes the
 * security manager's {@link java.lang.SecurityManager#checkPermission(java.security.Permission) SecurityManager#checkPermission(java.security.Permission)} method with a {@link java.lang.RuntimePermission#RuntimePermission(java.lang.String) RuntimePermission#RuntimePermission(String)} permission to verify
 * access to the system class loader.  If not, a
 * <tt>SecurityException</tt> will be thrown.  </p>
 *
 * @return  The system <tt>ClassLoader</tt> for delegation, or
 *          <tt>null</tt> if none
 *
 * @throws  java.lang.SecurityException
 *          If a security manager exists and its <tt>checkPermission</tt>
 *          method doesn't allow access to the system class loader.
 *
 * @throws  java.lang.IllegalStateException
 *          If invoked recursively during the construction of the class
 *          loader specified by the "<tt>java.system.class.loader</tt>"
 *          property.
 *
 * @throws  java.lang.Error
 *          If the system property "<tt>java.system.class.loader</tt>"
 *          is defined but the named class could not be loaded, the
 *          provider class does not define the required constructor, or an
 *          exception is thrown by that constructor when it is invoked. The
 *          underlying cause of the error can be retrieved via the
 *          {@link java.lang.Throwable#getCause() Throwable#getCause()} method.
 *
 * @revised  1.4
 * @apiSince 1
 */

public static java.lang.ClassLoader getSystemClassLoader() { throw new RuntimeException("Stub!"); }

/**
 * Defines a package by name in this <tt>ClassLoader</tt>.  This allows
 * class loaders to define the packages for their classes. Packages must
 * be created before the class is defined, and package names must be
 * unique within a class loader and cannot be redefined or changed once
 * created.
 *
 * @param  name
 *         The package name
 *
 * @param  specTitle
 *         The specification title
 *
 * @param  specVersion
 *         The specification version
 *
 * @param  specVendor
 *         The specification vendor
 *
 * @param  implTitle
 *         The implementation title
 *
 * @param  implVersion
 *         The implementation version
 *
 * @param  implVendor
 *         The implementation vendor
 *
 * @param  sealBase
 *         If not <tt>null</tt>, then this package is sealed with
 *         respect to the given code source {@link java.net.URL
 *         <tt>URL</tt>}  object.  Otherwise, the package is not sealed.
 *
 * @return  The newly defined <tt>Package</tt> object
 *
 * @throws  java.lang.IllegalArgumentException
 *          If package name duplicates an existing package either in this
 *          class loader or one of its ancestors
 *
 * @since  1.2
 * @apiSince 1
 */

protected java.lang.Package definePackage(java.lang.String name, java.lang.String specTitle, java.lang.String specVersion, java.lang.String specVendor, java.lang.String implTitle, java.lang.String implVersion, java.lang.String implVendor, java.net.URL sealBase) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Returns a <tt>Package</tt> that has been defined by this class loader
 * or any of its ancestors.
 *
 * @param  name
 *         The package name
 *
 * @return  The <tt>Package</tt> corresponding to the given name, or
 *          <tt>null</tt> if not found
 *
 * @since  1.2
 * @apiSince 1
 */

protected java.lang.Package getPackage(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Returns all of the <tt>Packages</tt> defined by this class loader and
 * its ancestors.
 *
 * @return  The array of <tt>Package</tt> objects defined by this
 *          <tt>ClassLoader</tt>
 *
 * @since  1.2
 * @apiSince 1
 */

protected java.lang.Package[] getPackages() { throw new RuntimeException("Stub!"); }

/**
 * Returns the absolute path name of a native library.  The VM invokes this
 * method to locate the native libraries that belong to classes loaded with
 * this class loader. If this method returns <tt>null</tt>, the VM
 * searches the library along the path specified as the
 * "<tt>java.library.path</tt>" property.
 *
 * @param  libname
 *         The library name
 *
 * @return  The absolute path of the native library
 *
 * @see  java.lang.System#loadLibrary(String)
 * @see  java.lang.System#mapLibraryName(String)
 *
 * @since  1.2
 * @apiSince 1
 */

protected java.lang.String findLibrary(java.lang.String libname) { throw new RuntimeException("Stub!"); }

/**
 * Sets the default assertion status for this class loader.  This setting
 * determines whether classes loaded by this class loader and initialized
 * in the future will have assertions enabled or disabled by default.
 * This setting may be overridden on a per-package or per-class basis by
 * invoking {@link #setPackageAssertionStatus(java.lang.String,boolean)} or {@link
 * #setClassAssertionStatus(java.lang.String,boolean)}.
 *
 * @param  enabled
 *         <tt>true</tt> if classes loaded by this class loader will
 *         henceforth have assertions enabled by default, <tt>false</tt>
 *         if they will have assertions disabled by default.
 *
 * @since  1.4
 * @apiSince 1
 */

public void setDefaultAssertionStatus(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Sets the package default assertion status for the named package.  The
 * package default assertion status determines the assertion status for
 * classes initialized in the future that belong to the named package or
 * any of its "subpackages".
 *
 * <p> A subpackage of a package named p is any package whose name begins
 * with "<tt>p.</tt>".  For example, <tt>javax.swing.text</tt> is a
 * subpackage of <tt>javax.swing</tt>, and both <tt>java.util</tt> and
 * <tt>java.lang.reflect</tt> are subpackages of <tt>java</tt>.
 *
 * <p> In the event that multiple package defaults apply to a given class,
 * the package default pertaining to the most specific package takes
 * precedence over the others.  For example, if <tt>javax.lang</tt> and
 * <tt>javax.lang.reflect</tt> both have package defaults associated with
 * them, the latter package default applies to classes in
 * <tt>javax.lang.reflect</tt>.
 *
 * <p> Package defaults take precedence over the class loader's default
 * assertion status, and may be overridden on a per-class basis by invoking
 * {@link #setClassAssertionStatus(java.lang.String,boolean)}.  </p>
 *
 * @param  packageName
 *         The name of the package whose package default assertion status
 *         is to be set. A <tt>null</tt> value indicates the unnamed
 *         package that is "current"
 *         (see section 7.4.2 of
 *         <cite>The Java&trade; Language Specification</cite>.)
 *
 * @param  enabled
 *         <tt>true</tt> if classes loaded by this classloader and
 *         belonging to the named package or any of its subpackages will
 *         have assertions enabled by default, <tt>false</tt> if they will
 *         have assertions disabled by default.
 *
 * @since  1.4
 * @apiSince 1
 */

public void setPackageAssertionStatus(java.lang.String packageName, boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Sets the desired assertion status for the named top-level class in this
 * class loader and any nested classes contained therein.  This setting
 * takes precedence over the class loader's default assertion status, and
 * over any applicable per-package default.  This method has no effect if
 * the named class has already been initialized.  (Once a class is
 * initialized, its assertion status cannot change.)
 *
 * <p> If the named class is not a top-level class, this invocation will
 * have no effect on the actual assertion status of any class. </p>
 *
 * @param  className
 *         The fully qualified class name of the top-level class whose
 *         assertion status is to be set.
 *
 * @param  enabled
 *         <tt>true</tt> if the named class is to have assertions
 *         enabled when (and if) it is initialized, <tt>false</tt> if the
 *         class is to have assertions disabled.
 *
 * @since  1.4
 * @apiSince 1
 */

public void setClassAssertionStatus(java.lang.String className, boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Sets the default assertion status for this class loader to
 * <tt>false</tt> and discards any package defaults or class assertion
 * status settings associated with the class loader.  This method is
 * provided so that class loaders can be made to ignore any command line or
 * persistent assertion status settings and "start with a clean slate."
 *
 * @since  1.4
 * @apiSince 1
 */

public void clearAssertionStatus() { throw new RuntimeException("Stub!"); }
}

