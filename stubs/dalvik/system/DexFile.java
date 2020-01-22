/*
 * Copyright (C) 2007 The Android Open Source Project
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
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * Loads DEX files. This class is meant for internal use and should not be used
 * by applications.
 *
 * @deprecated This class should not be used directly by applications. It will hurt
 *     performance in most cases and will lead to incorrect execution of bytecode in
 *     the worst case. Applications should use one of the standard classloaders such
 *     as {@link dalvik.system.PathClassLoader} instead. <b>This API will be removed
 *     in a future Android release</b>.
 * @apiSince 1
 * @deprecatedSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public final class DexFile {

/**
 * Opens a DEX file from a given File object.
 *
 * @deprecated Applications should use one of the standard classloaders such
 *     as {@link dalvik.system.PathClassLoader} instead. <b>This API will be removed
 *     in a future Android release</b>.
 * @apiSince 1
 */

@Deprecated
public DexFile(java.io.File file) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Opens a DEX file from a given filename.
 *
 * @deprecated Applications should use one of the standard classloaders such
 *     as {@link dalvik.system.PathClassLoader} instead. <b>This API will be removed
 *     in a future Android release</b>.
 * @apiSince 1
 */

@Deprecated
public DexFile(java.lang.String fileName) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Open a DEX file, specifying the file in which the optimized DEX
 * data should be written.  If the optimized form exists and appears
 * to be current, it will be used; if not, the VM will attempt to
 * regenerate it.
 *
 * @deprecated Applications should use one of the standard classloaders such
 *     as {@link dalvik.system.PathClassLoader} instead. <b>This API will be removed
 *     in a future Android release</b>.
 * @apiSince 3
 * @deprecatedSince 26
 */

@Deprecated
public static dalvik.system.DexFile loadDex(java.lang.String sourcePathName, java.lang.String outputPathName, int flags) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Gets the name of the (already opened) DEX file.
 *
 * @return the file name
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Closes the DEX file.
 * <p>
 * This may not be able to release all of the resources. If classes from this DEX file are
 * still resident, the DEX file can't be unmapped. In the case where we do not release all
 * the resources, close is called again in the finalizer.
 *
 * @throws java.io.IOException
 *             if an I/O error occurs during closing the file, which
 *             normally should not happen
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Loads a class. Returns the class on success, or a {@code null} reference
 * on failure.
 * <p>
 * If you are not calling this from a class loader, this is most likely not
 * going to do what you want. Use {@link java.lang.Class#forName(java.lang.String) Class#forName(String)} instead.
 * <p>
 * The method does not throw {@link java.lang.ClassNotFoundException ClassNotFoundException} if the class
 * isn't found because it isn't reasonable to throw exceptions wildly every
 * time a class is not found in the first DEX file we look at.
 *
 * @param name
 *            the class name, which should look like "java/lang/String"
 *
 * @param loader
 *            the class loader that tries to load the class (in most cases
 *            the caller of the method
 *
 * @return the {@link java.lang.Class Class} object representing the class, or {@code null}
 *         if the class cannot be loaded
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public java.lang.Class loadClass(java.lang.String name, java.lang.ClassLoader loader) { throw new RuntimeException("Stub!"); }

/**
 * Enumerate the names of the classes in this DEX file.
 *
 * @return an enumeration of names of classes contained in the DEX file, in
 *         the usual internal form (like "java/lang/String").
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public java.util.Enumeration<java.lang.String> entries() { throw new RuntimeException("Stub!"); }

/**
 * Called when the class is finalized. Makes sure the DEX file is closed.
 *
 * @throws java.io.IOException
 *             if an I/O error occurs during closing the file, which
 *             normally should not happen
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the VM believes that the apk/jar file is out of date
 * and should be passed through "dexopt" again.
 *
 * @param fileName the absolute path to the apk/jar file to examine.
 * @return true if dexopt should be called on the file, false otherwise.
 * @throws java.io.FileNotFoundException if fileName is not readable,
 *         not a file, or not present.
 * @throws java.io.IOException if fileName is not a valid apk/jar file or
 *         if problems occur while parsing it.
 * @throws java.lang.NullPointerException if fileName is null.
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public static native boolean isDexOptNeeded(java.lang.String fileName) throws java.io.FileNotFoundException, java.io.IOException;
}

