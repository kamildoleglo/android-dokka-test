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

import java.io.FileDescriptor;
import android.os.ParcelFileDescriptor;

/**
 * File descriptor of an entry in the AssetManager.  This provides your own
 * opened FileDescriptor that can be used to read the data, as well as the
 * offset and length of that entry's data in the file.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AssetFileDescriptor implements android.os.Parcelable, java.io.Closeable {

/**
 * Create a new AssetFileDescriptor from the given values.
 *
 * @param fd The underlying file descriptor.
 * @param startOffset The location within the file that the asset starts.
 *            This must be 0 if length is UNKNOWN_LENGTH.
 * @param length The number of bytes of the asset, or
 *            {@link #UNKNOWN_LENGTH} if it extends to the end of the file.
 * @apiSince 1
 */

public AssetFileDescriptor(android.os.ParcelFileDescriptor fd, long startOffset, long length) { throw new RuntimeException("Stub!"); }

/**
 * Create a new AssetFileDescriptor from the given values.
 *
 * @param fd The underlying file descriptor.
 * @param startOffset The location within the file that the asset starts.
 *            This must be 0 if length is UNKNOWN_LENGTH.
 * @param length The number of bytes of the asset, or
 *            {@link #UNKNOWN_LENGTH} if it extends to the end of the file.
 * @param extras additional details that can be used to interpret the
 *            underlying file descriptor. May be null.
 * @apiSince 19
 */

public AssetFileDescriptor(android.os.ParcelFileDescriptor fd, long startOffset, long length, android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * The AssetFileDescriptor contains its own ParcelFileDescriptor, which
 * in addition to the normal FileDescriptor object also allows you to close
 * the descriptor when you are done with it.
 * @apiSince 1
 */

public android.os.ParcelFileDescriptor getParcelFileDescriptor() { throw new RuntimeException("Stub!"); }

/**
 * Returns the FileDescriptor that can be used to read the data in the
 * file.
 * @apiSince 1
 */

public java.io.FileDescriptor getFileDescriptor() { throw new RuntimeException("Stub!"); }

/**
 * Returns the byte offset where this asset entry's data starts.
 * @apiSince 1
 */

public long getStartOffset() { throw new RuntimeException("Stub!"); }

/**
 * Returns any additional details that can be used to interpret the
 * underlying file descriptor. May be null.
 * @apiSince 19
 */

public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/**
 * Returns the total number of bytes of this asset entry's data.  May be
 * {@link #UNKNOWN_LENGTH} if the asset extends to the end of the file.
 * If the AssetFileDescriptor was constructed with {@link #UNKNOWN_LENGTH},
 * this will use {@link android.os.ParcelFileDescriptor#getStatSize() ParcelFileDescriptor#getStatSize()} to find the total size of the file,
 * returning that number if found or {@link #UNKNOWN_LENGTH} if it could
 * not be determined.
 *
 * @see #getDeclaredLength()
 * @apiSince 1
 */

public long getLength() { throw new RuntimeException("Stub!"); }

/**
 * Return the actual number of bytes that were declared when the
 * AssetFileDescriptor was constructed.  Will be
 * {@link #UNKNOWN_LENGTH} if the length was not declared, meaning data
 * should be read to the end of the file.
 *
 * @see #getDeclaredLength()
 * @apiSince 3
 */

public long getDeclaredLength() { throw new RuntimeException("Stub!"); }

/**
 * Convenience for calling <code>getParcelFileDescriptor().close()</code>.
 * @apiSince 1
 */

public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Create and return a new auto-close input stream for this asset.  This
 * will either return a full asset {@link android.content.res.AssetFileDescriptor.AutoCloseInputStream AutoCloseInputStream}, or
 * an underlying {@link android.os.ParcelFileDescriptor.AutoCloseInputStream ParcelFileDescriptor.AutoCloseInputStream} depending on whether the
 * the object represents a complete file or sub-section of a file.  You
 * should only call this once for a particular asset.
 * @apiSince 3
 */

public java.io.FileInputStream createInputStream() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Create and return a new auto-close output stream for this asset.  This
 * will either return a full asset {@link android.content.res.AssetFileDescriptor.AutoCloseOutputStream AutoCloseOutputStream}, or
 * an underlying {@link android.os.ParcelFileDescriptor.AutoCloseOutputStream ParcelFileDescriptor.AutoCloseOutputStream} depending on whether the
 * the object represents a complete file or sub-section of a file.  You
 * should only call this once for a particular asset.
 * @apiSince 3
 */

public java.io.FileOutputStream createOutputStream() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.content.res.AssetFileDescriptor> CREATOR;
static { CREATOR = null; }

/**
 * Length used with {@link #AssetFileDescriptor(android.os.ParcelFileDescriptor,long,long)}
 * and {@link #getDeclaredLength} when a length has not been declared.  This means
 * the data extends to the end of the file.
 * @apiSince 3
 */

public static final long UNKNOWN_LENGTH = -1L; // 0xffffffffffffffffL
/**
 * An InputStream you can create on a ParcelFileDescriptor, which will
 * take care of calling {@link android.os.ParcelFileDescriptor#close ParcelFileDescriptor#close} for you when the stream is closed.
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class AutoCloseInputStream extends android.os.ParcelFileDescriptor.AutoCloseInputStream {

/** @apiSince 3 */

public AutoCloseInputStream(android.content.res.AssetFileDescriptor fd) throws java.io.IOException { super(null); throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public int available() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public int read() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public int read(byte[] buffer, int offset, int count) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public int read(byte[] buffer) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public long skip(long count) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public void mark(int readlimit) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public boolean markSupported() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public synchronized void reset() throws java.io.IOException { throw new RuntimeException("Stub!"); }
}

/**
 * An OutputStream you can create on a ParcelFileDescriptor, which will
 * take care of calling {@link android.os.ParcelFileDescriptor#close ParcelFileDescriptor#close} for you when the stream is closed.
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class AutoCloseOutputStream extends android.os.ParcelFileDescriptor.AutoCloseOutputStream {

/** @apiSince 3 */

public AutoCloseOutputStream(android.content.res.AssetFileDescriptor fd) throws java.io.IOException { super(null); throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public void write(byte[] buffer, int offset, int count) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public void write(byte[] buffer) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public void write(int oneByte) throws java.io.IOException { throw new RuntimeException("Stub!"); }
}

}

