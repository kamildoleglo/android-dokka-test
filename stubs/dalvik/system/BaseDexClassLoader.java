/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */



package dalvik.system;

import java.io.File;

/**
 * Base class for common functionality between various dex-based
 * {@link java.lang.ClassLoader ClassLoader} implementations.
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class BaseDexClassLoader extends java.lang.ClassLoader {

/**
 * Constructs an instance.
 * Note that all the *.jar and *.apk files from {@code dexPath} might be
 * first extracted in-memory before the code is loaded. This can be avoided
 * by passing raw dex files (*.dex) in the {@code dexPath}.
 *
 * @param dexPath the list of jar/apk files containing classes and
 * resources, delimited by {@code File.pathSeparator}, which
 * defaults to {@code ":"} on Android.
 * @param optimizedDirectory this parameter is deprecated and has no effect since API level 26.
 * @param librarySearchPath the list of directories containing native
 * libraries, delimited by {@code File.pathSeparator}; may be
 * {@code null}
 * @param parent the parent class loader
 * @apiSince 14
 */

public BaseDexClassLoader(java.lang.String dexPath, java.io.File optimizedDirectory, java.lang.String librarySearchPath, java.lang.ClassLoader parent) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

protected java.lang.Class<?> findClass(java.lang.String name) throws java.lang.ClassNotFoundException { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

protected java.net.URL findResource(java.lang.String name) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

protected java.util.Enumeration<java.net.URL> findResources(java.lang.String name) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public java.lang.String findLibrary(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Returns package information for the given package.
 * Unfortunately, instances of this class don't really have this
 * information, and as a non-secure {@code ClassLoader}, it isn't
 * even required to, according to the spec. Yet, we want to
 * provide it, in order to make all those hopeful callers of
 * {@code myClass.getPackage().getName()} happy. Thus we construct
 * a {@code Package} object the first time it is being requested
 * and fill most of the fields with dummy values. The {@code
 * Package} object is then put into the {@code ClassLoader}'s
 * package cache, so we see the same one next time. We don't
 * create {@code Package} objects for {@code null} arguments or
 * for the default package.
 *
 * <p>There is a limited chance that we end up with multiple
 * {@code Package} objects representing the same package: It can
 * happen when when a package is scattered across different JAR
 * files which were loaded by different {@code ClassLoader}
 * instances. This is rather unlikely, and given that this whole
 * thing is more or less a workaround, probably not worth the
 * effort to address.
 *
 * @param name the name of the class
 * @return the package information for the class, or {@code null}
 * if there is no package information available for it
 * @apiSince 14
 */

protected synchronized java.lang.Package getPackage(java.lang.String name) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

