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



package android.system;

import java.io.IOException;
import java.net.SocketException;

/**
 * A checked exception thrown when {@link android.system.Os Os} methods fail. This exception contains the native
 * errno value, for comparison against the constants in {@link android.system.OsConstants OsConstants}, should sophisticated
 * callers need to adjust their behavior based on the exact failure.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ErrnoException extends java.lang.Exception {

/**
 * Constructs an instance with the given function name and errno value.
 * @apiSince 21
 */

public ErrnoException(java.lang.String functionName, int errno) { throw new RuntimeException("Stub!"); }

/**
 * Constructs an instance with the given function name, errno value, and cause.
 * @apiSince 21
 */

public ErrnoException(java.lang.String functionName, int errno, java.lang.Throwable cause) { throw new RuntimeException("Stub!"); }

/**
 * Converts the stashed function name and errno value to a human-readable string.
 * We do this here rather than in the constructor so that callers only pay for
 * this if they need it.
 * @apiSince 21
 */

public java.lang.String getMessage() { throw new RuntimeException("Stub!"); }

/**
 * Throws an {@link java.io.IOException IOException} with a message based on {@link #getMessage()} and with this
 * instance as the cause.
 *
 * <p>This method always terminates by throwing the exception. Callers can write
 * {@code throw e.rethrowAsIOException()} to make that clear to the compiler.
 * @apiSince R
 */

@androidx.annotation.NonNull
public java.io.IOException rethrowAsIOException() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Throws a {@link java.net.SocketException SocketException} with a message based on {@link #getMessage()} and with this
 * instance as the cause.
 *
 * <p>This method always terminates by throwing the exception. Callers can write
 * {@code throw e.rethrowAsIOException()} to make that clear to the compiler.
 * @apiSince R
 */

@androidx.annotation.NonNull
public java.net.SocketException rethrowAsSocketException() throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * The errno value, for comparison with the {@code E} constants in {@link android.system.OsConstants OsConstants}.
 * @apiSince 21
 */

public final int errno;
{ errno = 0; }
}

