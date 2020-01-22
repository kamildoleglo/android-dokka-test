/*
 * Copyright (C) 2006 The Android Open Source Project
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


package android.content.res;

import java.io.InputStream;

/**
 * Provides access to an application's raw asset files; see {@link android.content.res.Resources Resources}
 * for the way most applications will want to retrieve their resource data.
 * This class presents a lower-level API that allows you to open and read raw
 * files that have been bundled with the application as a simple stream of
 * bytes.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class AssetManager implements java.lang.AutoCloseable {

AssetManager() { throw new RuntimeException("Stub!"); }

/**
 * Close this asset manager.
 * @apiSince 1
 */

public void close() { throw new RuntimeException("Stub!"); }

/**
 * Open an asset using ACCESS_STREAMING mode.  This provides access to
 * files that have been bundled with an application as assets -- that is,
 * files placed in to the "assets" directory.
 *
 * @param fileName The name of the asset to open.  This name can be hierarchical.
 *
 * This value must never be {@code null}.
 * @see #open(String, int)
 * @see #list
 
 * @return This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.io.InputStream open(@androidx.annotation.NonNull java.lang.String fileName) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Open an asset using an explicit access mode, returning an InputStream to
 * read its contents.  This provides access to files that have been bundled
 * with an application as assets -- that is, files placed in to the
 * "assets" directory.
 *
 * @param fileName The name of the asset to open.  This name can be hierarchical.
 * This value must never be {@code null}.
 * @param accessMode Desired access mode for retrieving the data.
 *
 * @see #ACCESS_UNKNOWN
 * @see #ACCESS_STREAMING
 * @see #ACCESS_RANDOM
 * @see #ACCESS_BUFFER
 * @see #open(String)
 * @see #list
 
 * @return This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.io.InputStream open(@androidx.annotation.NonNull java.lang.String fileName, int accessMode) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Open an uncompressed asset by mmapping it and returning an {@link android.content.res.AssetFileDescriptor AssetFileDescriptor}.
 * This provides access to files that have been bundled with an application as assets -- that
 * is, files placed in to the "assets" directory.
 *
 * The asset must be uncompressed, or an exception will be thrown.
 *
 * @param fileName The name of the asset to open.  This name can be hierarchical.
 * This value must never be {@code null}.
 * @return An open AssetFileDescriptor.
 
 * This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public android.content.res.AssetFileDescriptor openFd(@androidx.annotation.NonNull java.lang.String fileName) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Return a String array of all the assets at the given path.
 *
 * @param path A relative path within the assets, i.e., "docs/home.html".
 *
 * This value must never be {@code null}.
 * @return String[] Array of strings, one for each asset.  These file
 *         names are relative to 'path'.  You can open the file by
 *         concatenating 'path' and a name in the returned string (via
 *         File) and passing that to open().
 *
 * This value may be {@code null}.
 * @see #open
 * @apiSince 1
 */

@androidx.annotation.Nullable
public java.lang.String[] list(@androidx.annotation.NonNull java.lang.String path) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Open a non-asset as an asset by mmapping it and returning an {@link android.content.res.AssetFileDescriptor AssetFileDescriptor}.
 * This provides direct access to all of the files included in an application
 * package (not only its assets).  Applications should not normally use this.
 *
 * The asset must not be compressed, or an exception will be thrown.
 *
 * @param fileName Name of the asset to retrieve.
 
 * This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public android.content.res.AssetFileDescriptor openNonAssetFd(@androidx.annotation.NonNull java.lang.String fileName) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Open a non-asset as an asset by mmapping it and returning an {@link android.content.res.AssetFileDescriptor AssetFileDescriptor}.
 * This provides direct access to all of the files included in an application
 * package (not only its assets).  Applications should not normally use this.
 *
 * The asset must not be compressed, or an exception will be thrown.
 *
 * @param cookie Identifier of the package to be opened.
 * @param fileName Name of the asset to retrieve.
 
 * This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public android.content.res.AssetFileDescriptor openNonAssetFd(int cookie, @androidx.annotation.NonNull java.lang.String fileName) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Retrieve a parser for a compiled XML file.
 *
 * @param fileName The name of the file to retrieve.
 
 * This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public android.content.res.XmlResourceParser openXmlResourceParser(@androidx.annotation.NonNull java.lang.String fileName) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Retrieve a parser for a compiled XML file.
 *
 * @param cookie Identifier of the package to be opened.
 * @param fileName The name of the file to retrieve.
 
 * This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public android.content.res.XmlResourceParser openXmlResourceParser(int cookie, @androidx.annotation.NonNull java.lang.String fileName) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/**
 * Get the locales that this asset manager contains data for.
 *
 * <p>On SDK 21 (Android 5.0: Lollipop) and above, Locale strings are valid
 * <a href="https://tools.ietf.org/html/bcp47">BCP-47</a> language tags and can be
 * parsed using {@link java.util.Locale#forLanguageTag(String)}.
 *
 * <p>On SDK 20 (Android 4.4W: Kitkat for watches) and below, locale strings
 * are of the form {@code ll_CC} where {@code ll} is a two letter language code,
 * and {@code CC} is a two letter country code.
 * @apiSince 1
 */

public java.lang.String[] getLocales() { throw new RuntimeException("Stub!"); }

/**
 * Mode for {@link #open(java.lang.String,int)}: Attempt to load contents into
 * memory, for fast small reads.
 * @apiSince 1
 */

public static final int ACCESS_BUFFER = 3; // 0x3

/**
 * Mode for {@link #open(java.lang.String,int)}: Read chunks, and seek forward and
 * backward.
 * @apiSince 1
 */

public static final int ACCESS_RANDOM = 1; // 0x1

/**
 * Mode for {@link #open(java.lang.String,int)}: Read sequentially, with an
 * occasional forward seek.
 * @apiSince 1
 */

public static final int ACCESS_STREAMING = 2; // 0x2

/**
 * Mode for {@link #open(java.lang.String,int)}: no specific information about how
 * data will be accessed.
 * @apiSince 1
 */

public static final int ACCESS_UNKNOWN = 0; // 0x0
/** @apiSince 1 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class AssetInputStream extends java.io.InputStream {

private AssetInputStream() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int read() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param b This value must never be {@code null}.
 * @apiSince 1
 */

public int read(@androidx.annotation.NonNull byte[] b) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param b This value must never be {@code null}.
 * @apiSince 1
 */

public int read(@androidx.annotation.NonNull byte[] b, int off, int len) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public long skip(long n) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int available() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean markSupported() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void mark(int readlimit) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void reset() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }
}

}

