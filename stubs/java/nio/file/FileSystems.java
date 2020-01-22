/*
 * Copyright (c) 2007, 2013, Oracle and/or its affiliates. All rights reserved.
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



package java.nio.file;

import java.util.*;
import java.nio.file.spi.FileSystemProvider;
import java.net.URI;
import java.io.IOException;

/**
 * Factory methods for file systems. This class defines the {@link #getDefault
 * getDefault} method to get the default file system and factory methods to
 * construct other types of file systems.
 *
 * <p> The first invocation of any of the methods defined by this class causes
 * the default {@link java.nio.file.spi.FileSystemProvider FileSystemProvider} to be loaded. The default
 * provider, identified by the URI scheme "file", creates the {@link java.nio.file.FileSystem FileSystem}
 * that provides access to the file systems accessible to the Java virtual
 * machine. If the process of loading or initializing the default provider fails
 * then an unspecified error is thrown.
 *
 * <p> The first invocation of the {@link java.nio.file.spi.FileSystemProvider#installedProviders FileSystemProvider#installedProviders} method, by way of invoking any of the {@code
 * newFileSystem} methods defined by this class, locates and loads all
 * installed file system providers. Installed providers are loaded using the
 * service-provider loading facility defined by the {@link java.util.ServiceLoader ServiceLoader} class.
 * Installed providers are loaded using the system class loader. If the
 * system class loader cannot be found then the extension class loader is used;
 * if there is no extension class loader then the bootstrap class loader is used.
 * Providers are typically installed by placing them in a JAR file on the
 * application class path or in the extension directory, the JAR file contains a
 * provider-configuration file named {@code java.nio.file.spi.FileSystemProvider}
 * in the resource directory {@code META-INF/services}, and the file lists one or
 * more fully-qualified names of concrete subclass of {@link java.nio.file.spi.FileSystemProvider FileSystemProvider}
 * that have a zero argument constructor.
 * The ordering that installed providers are located is implementation specific.
 * If a provider is instantiated and its {@link java.nio.file.spi.FileSystemProvider#getScheme() FileSystemProvider#getScheme()} returns the same URI scheme of a provider that was previously
 * instantiated then the most recently instantiated duplicate is discarded. URI
 * schemes are compared without regard to case. During construction a provider
 * may safely access files associated with the default provider but care needs
 * to be taken to avoid circular loading of other installed providers. If
 * circular loading of installed providers is detected then an unspecified error
 * is thrown.
 *
 * <p> This class also defines factory methods that allow a {@link java.lang.ClassLoader ClassLoader}
 * to be specified when locating a provider. As with installed providers, the
 * provider classes are identified by placing the provider configuration file
 * in the resource directory {@code META-INF/services}.
 *
 * <p> If a thread initiates the loading of the installed file system providers
 * and another thread invokes a method that also attempts to load the providers
 * then the method will block until the loading completes.
 *
 * @since 1.7
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class FileSystems {

private FileSystems() { throw new RuntimeException("Stub!"); }

/**
 * Returns the default {@code FileSystem}. The default file system creates
 * objects that provide access to the file systems accessible to the Java
 * virtual machine. The <em>working directory</em> of the file system is
 * the current user directory, named by the system property {@code user.dir}.
 * This allows for interoperability with the {@link java.io.File java.io.File}
 * class.
 *
 * <p> The first invocation of any of the methods defined by this class
 * locates the default {@link java.nio.file.spi.FileSystemProvider FileSystemProvider} object. Where the
 * system property {@code java.nio.file.spi.DefaultFileSystemProvider} is
 * not defined then the default provider is a system-default provider that
 * is invoked to create the default file system.
 *
 * <p> If the system property {@code java.nio.file.spi.DefaultFileSystemProvider}
 * is defined then it is taken to be a list of one or more fully-qualified
 * names of concrete provider classes identified by the URI scheme
 * {@code "file"}. Where the property is a list of more than one name then
 * the names are separated by a comma. Each class is loaded, using the system
 * class loader, and instantiated by invoking a one argument constructor
 * whose formal parameter type is {@code FileSystemProvider}. The providers
 * are loaded and instantiated in the order they are listed in the property.
 * If this process fails or a provider's scheme is not equal to {@code "file"}
 * then an unspecified error is thrown. URI schemes are normally compared
 * without regard to case but for the default provider, the scheme is
 * required to be {@code "file"}. The first provider class is instantiated
 * by invoking it with a reference to the system-default provider.
 * The second provider class is instantiated by invoking it with a reference
 * to the first provider instance. The third provider class is instantiated
 * by invoking it with a reference to the second instance, and so on. The
 * last provider to be instantiated becomes the default provider; its {@code
 * getFileSystem} method is invoked with the URI {@code "file:///"} to
 * get a reference to the default file system.
 *
 * <p> Subsequent invocations of this method return the file system that was
 * returned by the first invocation.
 *
 * @return  the default file system
 * @apiSince 26
 */

public static java.nio.file.FileSystem getDefault() { throw new RuntimeException("Stub!"); }

/**
 * Returns a reference to an existing {@code FileSystem}.
 *
 * <p> This method iterates over the {@link java.nio.file.spi.FileSystemProvider#installedProviders() FileSystemProvider#installedProviders()} providers to locate the provider that is identified by the URI
 * {@link java.net.URI#getScheme URI#getScheme} of the given URI. URI schemes are compared
 * without regard to case. The exact form of the URI is highly provider
 * dependent. If found, the provider's {@link java.nio.file.spi.FileSystemProvider#getFileSystem FileSystemProvider#getFileSystem} method is invoked to obtain a reference to the {@code
 * FileSystem}.
 *
 * <p> Once a file system created by this provider is {@link java.nio.file.FileSystem#close FileSystem#close} it is provider-dependent if this method returns a reference to
 * the closed file system or throws {@link java.nio.file.FileSystemNotFoundException FileSystemNotFoundException}.
 * If the provider allows a new file system to be created with the same URI
 * as a file system it previously created then this method throws the
 * exception if invoked after the file system is closed (and before a new
 * instance is created by the {@link #newFileSystem newFileSystem} method).
 *
 * <p> If a security manager is installed then a provider implementation
 * may require to check a permission before returning a reference to an
 * existing file system. In the case of the {@link java.nio.file.FileSystems#getDefault FileSystems#getDefault} file system, no permission check is required.
 *
 * @param   uri  the URI to locate the file system
 *
 * @return  the reference to the file system
 *
 * @throws  java.lang.IllegalArgumentException
 *          if the pre-conditions for the {@code uri} parameter are not met
 * @throws  java.nio.file.FileSystemNotFoundException
 *          if the file system, identified by the URI, does not exist
 * @throws  java.nio.file.ProviderNotFoundException
 *          if a provider supporting the URI scheme is not installed
 * @throws  java.lang.SecurityException
 *          if a security manager is installed and it denies an unspecified
 *          permission
 * @apiSince 26
 */

public static java.nio.file.FileSystem getFileSystem(java.net.URI uri) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new file system that is identified by a {@link java.net.URI URI}
 *
 * <p> This method iterates over the {@link java.nio.file.spi.FileSystemProvider#installedProviders() FileSystemProvider#installedProviders()} providers to locate the provider that is identified by the URI
 * {@link java.net.URI#getScheme URI#getScheme} of the given URI. URI schemes are compared
 * without regard to case. The exact form of the URI is highly provider
 * dependent. If found, the provider's {@link java.nio.file.spi.FileSystemProvider#newFileSystem(java.net.URI,java.util.Map) FileSystemProvider#newFileSystem(URI,Map)} method is invoked to construct the new file system.
 *
 * <p> Once a file system is {@link java.nio.file.FileSystem#close FileSystem#close} it is
 * provider-dependent if the provider allows a new file system to be created
 * with the same URI as a file system it previously created.
 *
 * <p> <b>Usage Example:</b>
 * Suppose there is a provider identified by the scheme {@code "memory"}
 * installed:
 * <pre>
 *   Map&lt;String,String&gt; env = new HashMap&lt;&gt;();
 *   env.put("capacity", "16G");
 *   env.put("blockSize", "4k");
 *   FileSystem fs = FileSystems.newFileSystem(URI.create("memory:///?name=logfs"), env);
 * </pre>
 *
 * @param   uri
 *          the URI identifying the file system
 * @param   env
 *          a map of provider specific properties to configure the file system;
 *          may be empty
 *
 * @return  a new file system
 *
 * @throws  java.lang.IllegalArgumentException
 *          if the pre-conditions for the {@code uri} parameter are not met,
 *          or the {@code env} parameter does not contain properties required
 *          by the provider, or a property value is invalid
 * @throws  java.nio.file.FileSystemAlreadyExistsException
 *          if the file system has already been created
 * @throws  java.nio.file.ProviderNotFoundException
 *          if a provider supporting the URI scheme is not installed
 * @throws  java.io.IOException
 *          if an I/O error occurs creating the file system
 * @throws  java.lang.SecurityException
 *          if a security manager is installed and it denies an unspecified
 *          permission required by the file system provider implementation
 * @apiSince 26
 */

public static java.nio.file.FileSystem newFileSystem(java.net.URI uri, java.util.Map<java.lang.String,?> env) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new file system that is identified by a {@link java.net.URI URI}
 *
 * <p> This method first attempts to locate an installed provider in exactly
 * the same manner as the {@link #newFileSystem(java.net.URI,java.util.Map) newFileSystem(URI,Map)}
 * method. If none of the installed providers support the URI scheme then an
 * attempt is made to locate the provider using the given class loader. If a
 * provider supporting the URI scheme is located then its {@link java.nio.file.spi.FileSystemProvider#newFileSystem(java.net.URI,java.util.Map) FileSystemProvider#newFileSystem(URI,Map)} is
 * invoked to construct the new file system.
 *
 * @param   uri
 *          the URI identifying the file system
 * @param   env
 *          a map of provider specific properties to configure the file system;
 *          may be empty
 * @param   loader
 *          the class loader to locate the provider or {@code null} to only
 *          attempt to locate an installed provider
 *
 * @return  a new file system
 *
 * @throws  java.lang.IllegalArgumentException
 *          if the pre-conditions for the {@code uri} parameter are not met,
 *          or the {@code env} parameter does not contain properties required
 *          by the provider, or a property value is invalid
 * @throws  java.nio.file.FileSystemAlreadyExistsException
 *          if the URI scheme identifies an installed provider and the file
 *          system has already been created
 * @throws  java.nio.file.ProviderNotFoundException
 *          if a provider supporting the URI scheme is not found
 * @throws  java.util.ServiceConfigurationError
 *          when an error occurs while loading a service provider
 * @throws  java.io.IOException
 *          an I/O error occurs creating the file system
 * @throws  java.lang.SecurityException
 *          if a security manager is installed and it denies an unspecified
 *          permission required by the file system provider implementation
 * @apiSince 26
 */

public static java.nio.file.FileSystem newFileSystem(java.net.URI uri, java.util.Map<java.lang.String,?> env, java.lang.ClassLoader loader) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new {@code FileSystem} to access the contents of a file as a
 * file system.
 *
 * <p> This method makes use of specialized providers that create pseudo file
 * systems where the contents of one or more files is treated as a file
 * system.
 *
 * <p> This method iterates over the {@link java.nio.file.spi.FileSystemProvider#installedProviders() FileSystemProvider#installedProviders()} providers. It invokes, in turn, each provider's {@link java.nio.file.spi.FileSystemProvider#newFileSystem(java.nio.file.Path,java.util.Map) FileSystemProvider#newFileSystem(Path,Map)} method
 * with an empty map. If a provider returns a file system then the iteration
 * terminates and the file system is returned. If none of the installed
 * providers return a {@code FileSystem} then an attempt is made to locate
 * the provider using the given class loader. If a provider returns a file
 * system then the lookup terminates and the file system is returned.
 *
 * @param   path
 *          the path to the file
 * @param   loader
 *          the class loader to locate the provider or {@code null} to only
 *          attempt to locate an installed provider
 *
 * @return  a new file system
 *
 * @throws  java.nio.file.ProviderNotFoundException
 *          if a provider supporting this file type cannot be located
 * @throws  java.util.ServiceConfigurationError
 *          when an error occurs while loading a service provider
 * @throws  java.io.IOException
 *          if an I/O error occurs
 * @throws  java.lang.SecurityException
 *          if a security manager is installed and it denies an unspecified
 *          permission
 * @apiSince 26
 */

public static java.nio.file.FileSystem newFileSystem(java.nio.file.Path path, java.lang.ClassLoader loader) throws java.io.IOException { throw new RuntimeException("Stub!"); }
}

