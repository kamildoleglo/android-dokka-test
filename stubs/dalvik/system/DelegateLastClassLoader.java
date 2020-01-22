/*
 * Copyright (C) 2017 The Android Open Source Project
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
 * limitations under the License
 */



package dalvik.system;


/**
 * A {@code ClassLoader} implementation that implements a <b>delegate last</b> lookup policy.
 * For every class or resource this loader is requested to load, the following lookup order
 * is employed:
 *
 * <ul>
 *     <li>The boot classpath is always searched first</li>
 *     <li>Then, the list of {@code dex} files associated with this classloaders's
 *     {@code dexPath} is searched.</li>
 *     <li>Finally, this classloader will delegate to the specified {@code parent}.</li>
 * </ul>
 * @apiSince 27
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class DelegateLastClassLoader extends dalvik.system.PathClassLoader {

/**
 * Equivalent to calling {@link #DelegateLastClassLoader(java.lang.String,java.lang.String,java.lang.ClassLoader,boolean)}
 * with {@code librarySearchPath = null, delegateResourceLoading = true}.
 * @apiSince 27
 */

public DelegateLastClassLoader(java.lang.String dexPath, java.lang.ClassLoader parent) { super((java.lang.String)null, (java.lang.ClassLoader)null); throw new RuntimeException("Stub!"); }

/**
 * Equivalent to calling {@link #DelegateLastClassLoader(java.lang.String,java.lang.String,java.lang.ClassLoader,boolean)}
 * with {@code delegateResourceLoading = true}.
 * @apiSince 27
 */

public DelegateLastClassLoader(java.lang.String dexPath, java.lang.String librarySearchPath, java.lang.ClassLoader parent) { super((java.lang.String)null, (java.lang.ClassLoader)null); throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code DelegateLastClassLoader} that operates on a given {@code dexPath}
 * and a {@code librarySearchPath}.
 *
 * The {@code dexPath} should consist of one or more of the following, separated by
 * {@code File.pathSeparator}, which is {@code ":"} on Android.
 *
 * <ul>
 * <li>JAR/ZIP/APK files, possibly containing a "classes.dex" file as well as arbitrary
 * resources.
 * <li>Raw ".dex" files (not inside a zip file).
 * </ul>
 *
 * Unlike {@link dalvik.system.PathClassLoader PathClassLoader}, this classloader will attempt to locate classes
 * (or resources) using the following lookup order.
 * <ul>
 *     <li>The boot classpath is always searched first.</li>
 *     <li>Then, the list of {@code dex} files contained in {@code dexPath} is searched./li>
 *     <li>Lastly, this classloader will delegate to the specified {@code parent}.</li>
 * </ul>
 *
 * Note that this is in contrast to other standard classloaders that follow the delegation
 * model. In those classloaders, the {@code parent} is always searched first.
 *
 * {@code librarySearchPath} specifies one more directories containing native library files,
 * separated by {@code File.pathSeparator}.
 *
 * @param dexPath the list of jar/apk files containing classes and resources, delimited by
 *                {@code File.pathSeparator}, which defaults to {@code ":"} on Android.
 * @param librarySearchPath the list of directories containing native libraries, delimited
 *                          by {@code File.pathSeparator}; may be {@code null}.
 * @param parent the parent class loader. May be {@code null} for the boot classloader.
 * @param delegateResourceLoading whether to delegate resource loading to the parent if
 *                                the resource is not found. This does not affect class
 *                                loading delegation.
 * @apiSince 29
 */

public DelegateLastClassLoader(@androidx.annotation.NonNull java.lang.String dexPath, @androidx.annotation.Nullable java.lang.String librarySearchPath, @androidx.annotation.Nullable java.lang.ClassLoader parent, boolean delegateResourceLoading) { super((java.lang.String)null, (java.lang.ClassLoader)null); throw new RuntimeException("Stub!"); }

/** @apiSince 27 */

protected java.lang.Class<?> loadClass(java.lang.String name, boolean resolve) throws java.lang.ClassNotFoundException { throw new RuntimeException("Stub!"); }

/** @apiSince 27 */

public java.net.URL getResource(java.lang.String name) { throw new RuntimeException("Stub!"); }

/** @apiSince 27 */

public java.util.Enumeration<java.net.URL> getResources(java.lang.String name) throws java.io.IOException { throw new RuntimeException("Stub!"); }
}

