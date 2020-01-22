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


/**
 * Utility methods useful for working with files.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class FileUtils {

private FileUtils() { throw new RuntimeException("Stub!"); }

/**
 * Copy the contents of one stream to another.
 * <p>
 * Attempts to use several optimization strategies to copy the data in the
 * kernel before falling back to a userspace copy as a last resort.
 *
 * @param in This value must never be {@code null}.
 * @param out This value must never be {@code null}.
 * @return number of bytes copied.
 * @apiSince 29
 */

public static long copy(@androidx.annotation.NonNull java.io.InputStream in, @androidx.annotation.NonNull java.io.OutputStream out) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Copy the contents of one stream to another.
 * <p>
 * Attempts to use several optimization strategies to copy the data in the
 * kernel before falling back to a userspace copy as a last resort.
 *
 * @param signal to signal if the copy should be cancelled early.
 * This value may be {@code null}.
 * @param executor that listener events should be delivered via.
 * This value may be {@code null}.
 * @param listener to be periodically notified as the copy progresses.
 * This value may be {@code null}.
 * @param in This value must never be {@code null}.
 * @param out This value must never be {@code null}.
 * @return number of bytes copied.
 * @apiSince 29
 */

public static long copy(@androidx.annotation.NonNull java.io.InputStream in, @androidx.annotation.NonNull java.io.OutputStream out, @androidx.annotation.Nullable android.os.CancellationSignal signal, @androidx.annotation.Nullable java.util.concurrent.Executor executor, @androidx.annotation.Nullable android.os.FileUtils.ProgressListener listener) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Copy the contents of one FD to another.
 * <p>
 * Attempts to use several optimization strategies to copy the data in the
 * kernel before falling back to a userspace copy as a last resort.
 *
 * @param in This value must never be {@code null}.
 * @param out This value must never be {@code null}.
 * @return number of bytes copied.
 * @apiSince 29
 */

public static long copy(@androidx.annotation.NonNull java.io.FileDescriptor in, @androidx.annotation.NonNull java.io.FileDescriptor out) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Copy the contents of one FD to another.
 * <p>
 * Attempts to use several optimization strategies to copy the data in the
 * kernel before falling back to a userspace copy as a last resort.
 *
 * @param signal to signal if the copy should be cancelled early.
 * This value may be {@code null}.
 * @param executor that listener events should be delivered via.
 * This value may be {@code null}.
 * @param listener to be periodically notified as the copy progresses.
 * This value may be {@code null}.
 * @param in This value must never be {@code null}.
 * @param out This value must never be {@code null}.
 * @return number of bytes copied.
 * @apiSince 29
 */

public static long copy(@androidx.annotation.NonNull java.io.FileDescriptor in, @androidx.annotation.NonNull java.io.FileDescriptor out, @androidx.annotation.Nullable android.os.CancellationSignal signal, @androidx.annotation.Nullable java.util.concurrent.Executor executor, @androidx.annotation.Nullable android.os.FileUtils.ProgressListener listener) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Closes the given object quietly, ignoring any checked exceptions. Does
 * nothing if the given object is {@code null}.
 *
 * @deprecated This method may suppress potentially significant exceptions, particularly when
 *   closing writable resources. With a writable resource, a failure thrown from {@code close()}
 *   should be considered as significant as a failure thrown from a write method because it may
 *   indicate a failure to flush bytes to the underlying resource.
 
 * @param closeable This value may be {@code null}.
 * @apiSince 29
 * @deprecatedSince R
 */

@Deprecated
public static void closeQuietly(@androidx.annotation.Nullable java.lang.AutoCloseable closeable) { throw new RuntimeException("Stub!"); }

/**
 * Closes the given object quietly, ignoring any checked exceptions. Does
 * nothing if the given object is {@code null}.
 *
 * @deprecated This method may suppress potentially significant exceptions, particularly when
 *   closing writable resources. With a writable resource, a failure thrown from {@code close()}
 *   should be considered as significant as a failure thrown from a write method because it may
 *   indicate a failure to flush bytes to the underlying resource.
 
 * @param fd This value may be {@code null}.
 * @apiSince 29
 * @deprecatedSince R
 */

@Deprecated
public static void closeQuietly(@androidx.annotation.Nullable java.io.FileDescriptor fd) { throw new RuntimeException("Stub!"); }
/**
 * Listener that is called periodically as progress is made.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface ProgressListener {

/** @apiSince 29 */

public void onProgress(long progress);
}

}

