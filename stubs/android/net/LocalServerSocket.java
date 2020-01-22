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


package android.net;

import java.io.IOException;

/**
 * Non-standard class for creating an inbound UNIX-domain socket
 * in the Linux abstract namespace.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class LocalServerSocket implements java.io.Closeable {

/**
 * Creates a new server socket listening at specified name.
 * On the Android platform, the name is created in the Linux
 * abstract namespace (instead of on the filesystem).
 *
 * @param name address for socket
 * @throws java.io.IOException
 * @apiSince 1
 */

public LocalServerSocket(java.lang.String name) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Create a LocalServerSocket from a file descriptor that's already
 * been created and bound. listen() will be called immediately on it.
 * Used for cases where file descriptors are passed in via environment
 * variables
 *
 * @param fd bound file descriptor
 * @throws java.io.IOException
 * @apiSince 1
 */

public LocalServerSocket(java.io.FileDescriptor fd) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Obtains the socket's local address
 *
 * @return local address
 * @apiSince 1
 */

public android.net.LocalSocketAddress getLocalSocketAddress() { throw new RuntimeException("Stub!"); }

/**
 * Accepts a new connection to the socket. Blocks until a new
 * connection arrives.
 *
 * @return a socket representing the new connection.
 * @throws java.io.IOException
 * @apiSince 1
 */

public android.net.LocalSocket accept() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Returns file descriptor or null if not yet open/already closed
 *
 * @return fd or null
 * @apiSince 1
 */

public java.io.FileDescriptor getFileDescriptor() { throw new RuntimeException("Stub!"); }

/**
 * Closes server socket.
 *
 * @throws java.io.IOException
 * @apiSince 1
 */

public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }
}

