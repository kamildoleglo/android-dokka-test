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


package android.os;

import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.UncheckedIOException;
import java.io.IOException;
import java.net.Socket;
import java.net.DatagramSocket;
import android.content.ContentProvider;
import android.content.BroadcastReceiver;

/**
 * The FileDescriptor returned by {@link android.os.Parcel#readFileDescriptor Parcel#readFileDescriptor}, allowing
 * you to close it when done with it.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ParcelFileDescriptor implements android.os.Parcelable, java.io.Closeable {

/**
 * Create a new ParcelFileDescriptor wrapped around another descriptor. By
 * default all method calls are delegated to the wrapped descriptor.
 * @apiSince 1
 */

public ParcelFileDescriptor(android.os.ParcelFileDescriptor wrapped) { throw new RuntimeException("Stub!"); }

/**
 * Create a new ParcelFileDescriptor accessing a given file.
 *
 * @param file The file to be opened.
 * @param mode The desired access mode, must be one of
 *            {@link #MODE_READ_ONLY}, {@link #MODE_WRITE_ONLY}, or
 *            {@link #MODE_READ_WRITE}; may also be any combination of
 *            {@link #MODE_CREATE}, {@link #MODE_TRUNCATE},
 *            {@link #MODE_WORLD_READABLE}, and
 *            {@link #MODE_WORLD_WRITEABLE}.
 * @return a new ParcelFileDescriptor pointing to the given file.
 * @throws java.io.FileNotFoundException if the given file does not exist or can not
 *             be opened with the requested mode.
 * @see #parseMode(String)
 * @apiSince 1
 */

public static android.os.ParcelFileDescriptor open(java.io.File file, int mode) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Create a new ParcelFileDescriptor accessing a given file.
 *
 * @param file The file to be opened.
 * @param mode The desired access mode, must be one of
 *            {@link #MODE_READ_ONLY}, {@link #MODE_WRITE_ONLY}, or
 *            {@link #MODE_READ_WRITE}; may also be any combination of
 *            {@link #MODE_CREATE}, {@link #MODE_TRUNCATE},
 *            {@link #MODE_WORLD_READABLE}, and
 *            {@link #MODE_WORLD_WRITEABLE}.
 * @param handler to call listener from; must not be null.
 * @param listener to be invoked when the returned descriptor has been
 *            closed; must not be null.
 * @return a new ParcelFileDescriptor pointing to the given file.
 * @throws java.io.FileNotFoundException if the given file does not exist or can not
 *             be opened with the requested mode.
 * @see #parseMode(String)
 * @apiSince 19
 */

public static android.os.ParcelFileDescriptor open(java.io.File file, int mode, android.os.Handler handler, android.os.ParcelFileDescriptor.OnCloseListener listener) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Create a new ParcelFileDescriptor that is a dup of an existing
 * FileDescriptor.  This obeys standard POSIX semantics, where the
 * new file descriptor shared state such as file position with the
 * original file descriptor.
 * @apiSince 13
 */

public static android.os.ParcelFileDescriptor dup(java.io.FileDescriptor orig) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Create a new ParcelFileDescriptor that is a dup of the existing
 * FileDescriptor.  This obeys standard POSIX semantics, where the
 * new file descriptor shared state such as file position with the
 * original file descriptor.
 * @apiSince 14
 */

public android.os.ParcelFileDescriptor dup() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Create a new ParcelFileDescriptor from a raw native fd.  The new
 * ParcelFileDescriptor holds a dup of the original fd passed in here,
 * so you must still close that fd as well as the new ParcelFileDescriptor.
 *
 * @param fd The native fd that the ParcelFileDescriptor should dup.
 *
 * @return Returns a new ParcelFileDescriptor holding a FileDescriptor
 * for a dup of the given fd.
 * @apiSince 13
 */

public static android.os.ParcelFileDescriptor fromFd(int fd) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Take ownership of a raw native fd in to a new ParcelFileDescriptor.
 * The returned ParcelFileDescriptor now owns the given fd, and will be
 * responsible for closing it.
 * <p>
 * <strong>WARNING:</strong> You must not close the fd yourself after
 * this call, and ownership of the file descriptor must have been
 * released prior to the call to this function.
 *
 * @param fd The native fd that the ParcelFileDescriptor should adopt.
 *
 * @return Returns a new ParcelFileDescriptor holding a FileDescriptor
 * for the given fd.
 * @apiSince 13
 */

public static android.os.ParcelFileDescriptor adoptFd(int fd) { throw new RuntimeException("Stub!"); }

/**
 * Create a new ParcelFileDescriptor from the specified Socket.  The new
 * ParcelFileDescriptor holds a dup of the original FileDescriptor in
 * the Socket, so you must still close the Socket as well as the new
 * ParcelFileDescriptor.
 * <p>
 * <strong>WARNING:</strong> Prior to API level 29, this function would not
 * actually dup the Socket's FileDescriptor, and would take a
 * reference to the its internal FileDescriptor instead. If the Socket
 * gets garbage collected before the ParcelFileDescriptor, this may
 * lead to the ParcelFileDescriptor being unexpectedly closed. To avoid
 * this, the following pattern can be used:
 * <pre>{@code
 *    ParcelFileDescriptor pfd = ParcelFileDescriptor.fromSocket(socket).dup();
 * }</pre>
 *
 * @param socket The Socket whose FileDescriptor is used to create
 *               a new ParcelFileDescriptor.
 *
 * @return A new ParcelFileDescriptor with a duped copy of the
 * FileDescriptor of the specified Socket.
 *
 * @throws java.io.UncheckedIOException if {@link #dup(java.io.FileDescriptor)} throws IOException.
 * @apiSince 1
 */

public static android.os.ParcelFileDescriptor fromSocket(java.net.Socket socket) { throw new RuntimeException("Stub!"); }

/**
 * Create a new ParcelFileDescriptor from the specified DatagramSocket. The
 * new ParcelFileDescriptor holds a dup of the original FileDescriptor in
 * the DatagramSocket, so you must still close the DatagramSocket as well
 * as the new ParcelFileDescriptor.
 * <p>
 * <strong>WARNING:</strong> Prior to API level 29, this function would not
 * actually dup the DatagramSocket's FileDescriptor, and would take a
 * reference to the its internal FileDescriptor instead. If the DatagramSocket
 * gets garbage collected before the ParcelFileDescriptor, this may
 * lead to the ParcelFileDescriptor being unexpectedly closed. To avoid
 * this, the following pattern can be used:
 * <pre>{@code
 *    ParcelFileDescriptor pfd = ParcelFileDescriptor.fromDatagramSocket(socket).dup();
 * }</pre>
 *
 * @param datagramSocket The DatagramSocket whose FileDescriptor is used
 *               to create a new ParcelFileDescriptor.
 *
 * @return A new ParcelFileDescriptor with a duped copy of the
 * FileDescriptor of the specified Socket.
 *
 * @throws java.io.UncheckedIOException if {@link #dup(java.io.FileDescriptor)} throws IOException.
 * @apiSince 14
 */

public static android.os.ParcelFileDescriptor fromDatagramSocket(java.net.DatagramSocket datagramSocket) { throw new RuntimeException("Stub!"); }

/**
 * Create two ParcelFileDescriptors structured as a data pipe.  The first
 * ParcelFileDescriptor in the returned array is the read side; the second
 * is the write side.
 * @apiSince 9
 */

public static android.os.ParcelFileDescriptor[] createPipe() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Create two ParcelFileDescriptors structured as a data pipe. The first
 * ParcelFileDescriptor in the returned array is the read side; the second
 * is the write side.
 * <p>
 * The write end has the ability to deliver an error message through
 * {@link #closeWithError(java.lang.String)} which can be handled by the read end
 * calling {@link #checkError()}, usually after detecting an EOF.
 * This can also be used to detect remote crashes.
 * @apiSince 19
 */

public static android.os.ParcelFileDescriptor[] createReliablePipe() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Create two ParcelFileDescriptors structured as a pair of sockets
 * connected to each other. The two sockets are indistinguishable.
 * @apiSince 19
 */

public static android.os.ParcelFileDescriptor[] createSocketPair() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Create two ParcelFileDescriptors structured as a pair of sockets
 * connected to each other. The two sockets are indistinguishable.
 * <p>
 * Both ends have the ability to deliver an error message through
 * {@link #closeWithError(java.lang.String)} which can be detected by the other end
 * calling {@link #checkError()}, usually after detecting an EOF.
 * This can also be used to detect remote crashes.
 * @apiSince 19
 */

public static android.os.ParcelFileDescriptor[] createReliableSocketPair() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Converts a string representing a file mode, such as "rw", into a bitmask suitable for use
 * with {@link #open}.
 * <p>
 * @param mode The string representation of the file mode. Can be "r", "w", "wt", "wa", "rw"
 *             or "rwt".
 * @return A bitmask representing the given file mode.
 * @throws java.lang.IllegalArgumentException if the given string does not match a known file mode.
 * @apiSince 19
 */

public static int parseMode(java.lang.String mode) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the actual FileDescriptor associated with this object.
 *
 * @return Returns the FileDescriptor associated with this object.
 * @apiSince 1
 */

public java.io.FileDescriptor getFileDescriptor() { throw new RuntimeException("Stub!"); }

/**
 * Return the total size of the file representing this fd, as determined by
 * {@code stat()}. Returns -1 if the fd is not a file.
 * @apiSince 3
 */

public long getStatSize() { throw new RuntimeException("Stub!"); }

/**
 * Return the native fd int for this ParcelFileDescriptor.  The
 * ParcelFileDescriptor still owns the fd, and it still must be closed
 * through this API.
 * <p>
 * <strong>WARNING:</strong> Do not call close on the return value of this
 * function or pass it to a function that assumes ownership of the fd.
 * @apiSince 12
 */

public int getFd() { throw new RuntimeException("Stub!"); }

/**
 * Return the native fd int for this ParcelFileDescriptor and detach it from
 * the object here. You are now responsible for closing the fd in native
 * code.
 * <p>
 * You should not detach when the original creator of the descriptor is
 * expecting a reliable signal through {@link #close()} or
 * {@link #closeWithError(java.lang.String)}.
 *
 * @see #canDetectErrors()
 * @apiSince 12
 */

public int detachFd() { throw new RuntimeException("Stub!"); }

/**
 * Close the ParcelFileDescriptor. This implementation closes the underlying
 * OS resources allocated to represent this stream.
 *
 * @throws java.io.IOException
 *             If an error occurs attempting to close this ParcelFileDescriptor.
 * @apiSince 1
 */

public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Close the ParcelFileDescriptor, informing any peer that an error occurred
 * while processing. If the creator of this descriptor is not observing
 * errors, it will close normally.
 *
 * @param msg describing the error; must not be null.
 * @apiSince 19
 */

public void closeWithError(java.lang.String msg) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Indicates if this ParcelFileDescriptor can communicate and detect remote
 * errors/crashes.
 *
 * @see #checkError()
 * @apiSince 19
 */

public boolean canDetectErrors() { throw new RuntimeException("Stub!"); }

/**
 * Detect and throw if the other end of a pipe or socket pair encountered an
 * error or crashed. This allows a reader to distinguish between a valid EOF
 * and an error/crash.
 * <p>
 * If this ParcelFileDescriptor is unable to detect remote errors, it will
 * return silently.
 *
 * @throws java.io.IOException for normal errors.
 * @throws android.os.ParcelFileDescriptor.FileDescriptorDetachedException
 *            if the remote side called {@link #detachFd()}. Once detached, the remote
 *            side is unable to communicate any errors through
 *            {@link #closeWithError(java.lang.String)}.
 * @see #canDetectErrors()
 * @apiSince 19
 */

public void checkError() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * If {@link android.os.Parcelable#PARCELABLE_WRITE_RETURN_VALUE Parcelable#PARCELABLE_WRITE_RETURN_VALUE} is set in flags,
 * the file descriptor will be closed after a copy is written to the Parcel.
 * @apiSince 1
 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.os.ParcelFileDescriptor> CREATOR;
static { CREATOR = null; }

/**
 * For use with {@link #open}: append to end of file while writing.
 * @apiSince 3
 */

public static final int MODE_APPEND = 33554432; // 0x2000000

/**
 * For use with {@link #open}: create the file if it doesn't already exist.
 * @apiSince 1
 */

public static final int MODE_CREATE = 134217728; // 0x8000000

/**
 * For use with {@link #open}: open the file with read-only access.
 * @apiSince 1
 */

public static final int MODE_READ_ONLY = 268435456; // 0x10000000

/**
 * For use with {@link #open}: open the file with read and write access.
 * @apiSince 1
 */

public static final int MODE_READ_WRITE = 805306368; // 0x30000000

/**
 * For use with {@link #open}: erase contents of file when opening.
 * @apiSince 1
 */

public static final int MODE_TRUNCATE = 67108864; // 0x4000000

/**
 * For use with {@link #open}: if {@link #MODE_CREATE} has been supplied and
 * this file doesn't already exist, then create the file with permissions
 * such that any application can read it.
 *
 * @deprecated Creating world-readable files is very dangerous, and likely
 *             to cause security holes in applications. It is strongly
 *             discouraged; instead, applications should use more formal
 *             mechanism for interactions such as {@link android.content.ContentProvider ContentProvider},
 *             {@link android.content.BroadcastReceiver BroadcastReceiver}, and {@link android.app.Service}.
 *             There are no guarantees that this access mode will remain on
 *             a file, such as when it goes through a backup and restore.
 * @apiSince 1
 * @deprecatedSince 19
 */

@Deprecated public static final int MODE_WORLD_READABLE = 1; // 0x1

/**
 * For use with {@link #open}: if {@link #MODE_CREATE} has been supplied and
 * this file doesn't already exist, then create the file with permissions
 * such that any application can write it.
 *
 * @deprecated Creating world-writable files is very dangerous, and likely
 *             to cause security holes in applications. It is strongly
 *             discouraged; instead, applications should use more formal
 *             mechanism for interactions such as {@link android.content.ContentProvider ContentProvider},
 *             {@link android.content.BroadcastReceiver BroadcastReceiver}, and {@link android.app.Service}.
 *             There are no guarantees that this access mode will remain on
 *             a file, such as when it goes through a backup and restore.
 * @apiSince 1
 * @deprecatedSince 19
 */

@Deprecated public static final int MODE_WORLD_WRITEABLE = 2; // 0x2

/**
 * For use with {@link #open}: open the file with write-only access.
 * @apiSince 1
 */

public static final int MODE_WRITE_ONLY = 536870912; // 0x20000000
/**
 * An InputStream you can create on a ParcelFileDescriptor, which will
 * take care of calling {@link android.os.ParcelFileDescriptor#close ParcelFileDescriptor#close} for you when the stream is closed.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class AutoCloseInputStream extends java.io.FileInputStream {

/** @apiSince 1 */

public AutoCloseInputStream(android.os.ParcelFileDescriptor pfd) { super((java.io.FileDescriptor)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int read() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int read(byte[] b) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int read(byte[] b, int off, int len) throws java.io.IOException { throw new RuntimeException("Stub!"); }
}

/**
 * An OutputStream you can create on a ParcelFileDescriptor, which will
 * take care of calling {@link android.os.ParcelFileDescriptor#close ParcelFileDescriptor#close} for you when the stream is closed.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class AutoCloseOutputStream extends java.io.FileOutputStream {

/** @apiSince 1 */

public AutoCloseOutputStream(android.os.ParcelFileDescriptor pfd) { super((java.io.FileDescriptor)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }
}

/**
 * Exception that indicates that the file descriptor was detached.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class FileDescriptorDetachedException extends java.io.IOException {

/** @apiSince 19 */

public FileDescriptorDetachedException() { throw new RuntimeException("Stub!"); }
}

/**
 * Callback indicating that a ParcelFileDescriptor has been closed.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnCloseListener {

/**
 * Event indicating the ParcelFileDescriptor to which this listener was
 * attached has been closed.
 *
 * @param e error state, or {@code null} if closed cleanly.
 *        If the close event was the result of
 *        {@link android.os.ParcelFileDescriptor#detachFd() ParcelFileDescriptor#detachFd()}, this will be a
 *        {@link android.os.ParcelFileDescriptor.FileDescriptorDetachedException FileDescriptorDetachedException}. After detach the
 *        remote side may continue reading/writing to the underlying
 *        {@link java.io.FileDescriptor FileDescriptor}, but they can no longer deliver
 *        reliable close/error events.
 * @apiSince 19
 */

public void onClose(java.io.IOException e);
}

}

