/*
 * Copyright (C) 2016 The Android Open Source Project
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


/**
 * A {@link java.lang.ClassLoader ClassLoader} implementation that loads classes from a
 * buffer containing a DEX file. This can be used to execute code that
 * has not been written to the local file system.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class InMemoryDexClassLoader extends dalvik.system.BaseDexClassLoader {

/**
 * Create an in-memory DEX class loader with the given dex buffers.
 *
 * @param dexBuffers array of buffers containing DEX files between
 *                       <tt>buffer.position()</tt> and <tt>buffer.limit()</tt>.
 * @param librarySearchPath the list of directories containing native
 *   libraries, delimited by {@code File.pathSeparator}; may be {@code null}
 * @param parent the parent class loader for delegation.
 * @apiSince 29
 */

public InMemoryDexClassLoader(@androidx.annotation.NonNull java.nio.ByteBuffer[] dexBuffers, @androidx.annotation.Nullable java.lang.String librarySearchPath, @androidx.annotation.Nullable java.lang.ClassLoader parent) { super(null, null, null, null); throw new RuntimeException("Stub!"); }

/**
 * Create an in-memory DEX class loader with the given dex buffers.
 *
 * @param dexBuffers array of buffers containing DEX files between
 *                       <tt>buffer.position()</tt> and <tt>buffer.limit()</tt>.
 * @param parent the parent class loader for delegation.
 * @apiSince 27
 */

public InMemoryDexClassLoader(@androidx.annotation.NonNull java.nio.ByteBuffer[] dexBuffers, @androidx.annotation.Nullable java.lang.ClassLoader parent) { super(null, null, null, null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new in-memory DEX class loader.
 *
 * @param dexBuffer buffer containing DEX file contents between
 *                       <tt>buffer.position()</tt> and <tt>buffer.limit()</tt>.
 * @param parent the parent class loader for delegation.
 * @apiSince 26
 */

public InMemoryDexClassLoader(@androidx.annotation.NonNull java.nio.ByteBuffer dexBuffer, @androidx.annotation.Nullable java.lang.ClassLoader parent) { super(null, null, null, null); throw new RuntimeException("Stub!"); }
}

