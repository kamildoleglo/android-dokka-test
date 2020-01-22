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


/**
 * A UNIX-domain (AF_LOCAL) socket address. For use with
 * android.net.LocalSocket and android.net.LocalServerSocket.
 *
 * On the Android system, these names refer to names in the Linux
 * abstract (non-filesystem) UNIX domain namespace.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class LocalSocketAddress {

/**
 * Creates an instance with a given name.
 *
 * @param name non-null name
 * @param namespace namespace the name should be created in.
 * @apiSince 1
 */

public LocalSocketAddress(java.lang.String name, android.net.LocalSocketAddress.Namespace namespace) { throw new RuntimeException("Stub!"); }

/**
 * Creates an instance with a given name in the {@link android.net.LocalSocketAddress.Namespace#ABSTRACT Namespace#ABSTRACT}
 * namespace
 *
 * @param name non-null name
 * @apiSince 1
 */

public LocalSocketAddress(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the string name of this address
 * @return string name
 * @apiSince 1
 */

public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * Returns the namespace used by this address.
 *
 * @return non-null a namespace
 * @apiSince 1
 */

public android.net.LocalSocketAddress.Namespace getNamespace() { throw new RuntimeException("Stub!"); }
/**
 * The namespace that this address exists in. See also
 * include/cutils/sockets.h ANDROID_SOCKET_NAMESPACE_*
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum Namespace {
/**
 * A socket in the Linux abstract namespace
 * @apiSince 1
 */

ABSTRACT,
/**
 * A socket in the Android reserved namespace in /dev/socket.
 * Only the init process may create a socket here.
 * @apiSince 1
 */

RESERVED,
/**
 * A socket named with a normal filesystem path.
 * @apiSince 1
 */

FILESYSTEM;
}

}

