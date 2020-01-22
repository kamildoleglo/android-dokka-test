/*
 * Copyright (C) 2019 The Android Open Source Project
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

import java.util.concurrent.Executor;
import android.os.RemoteException;

/**
 * Allows applications to request that the system periodically send specific packets on their
 * behalf, using hardware offload to save battery power.
 *
 * To request that the system send keepalives, call one of the methods that return a
 * {@link android.net.SocketKeepalive SocketKeepalive} object, such as {@link android.net.ConnectivityManager#createSocketKeepalive ConnectivityManager#createSocketKeepalive},
 * passing in a non-null callback. If the {@link android.net.SocketKeepalive SocketKeepalive} is successfully
 * started, the callback's {@code onStarted} method will be called. If an error occurs,
 * {@code onError} will be called, specifying one of the {@code ERROR_*} constants in this
 * class.
 *
 * To stop an existing keepalive, call {@link android.net.SocketKeepalive#stop SocketKeepalive#stop}. The system will call
 * {@link android.net.SocketKeepalive.Callback#onStopped SocketKeepalive.Callback#onStopped} if the operation was successful or
 * {@link android.net.SocketKeepalive.Callback#onError SocketKeepalive.Callback#onError} if an error occurred.
 *
 * For cellular, the device MUST support at least 1 keepalive slot.
 *
 * For WiFi, the device SHOULD support keepalive offload. If it does not, it MUST reply with
 * {@link android.net.SocketKeepalive.Callback#onError SocketKeepalive.Callback#onError} with {@code ERROR_UNSUPPORTED} to any keepalive offload
 * request. If it does, it MUST support at least 3 concurrent keepalive slots.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class SocketKeepalive implements java.lang.AutoCloseable {

SocketKeepalive() { throw new RuntimeException("Stub!"); }

/**
 * Request that keepalive be started with the given {@code intervalSec}. See
 * {@link android.net.SocketKeepalive SocketKeepalive}. If the remote binder dies, or the binder call throws an exception
 * when invoking start or stop of the {@link android.net.SocketKeepalive SocketKeepalive}, a {@link android.os.RemoteException RemoteException} will be
 * thrown into the {@code executor}. This is typically not important to catch because the remote
 * party is the system, so if it is not in shape to communicate through binder the system is
 * probably going down anyway. If the caller cares regardless, it can use a custom
 * {@link java.util.concurrent.Executor Executor} to catch the {@link android.os.RemoteException RemoteException}.
 *
 * @param intervalSec The target interval in seconds between keepalive packet transmissions.
 *                    The interval should be between 10 seconds and 3600 seconds, otherwise
 *                    {@link #ERROR_INVALID_INTERVAL} will be returned.
 
 * Value is between MIN_INTERVAL_SEC and MAX_INTERVAL_SEC inclusive
 * @apiSince 29
 */

public final void start(int intervalSec) { throw new RuntimeException("Stub!"); }

/**
 * Requests that keepalive be stopped. The application must wait for {@link android.net.SocketKeepalive.Callback#onStopped Callback#onStopped}
 * before using the object. See {@link android.net.SocketKeepalive SocketKeepalive}.
 * @apiSince 29
 */

public final void stop() { throw new RuntimeException("Stub!"); }

/**
 * Deactivate this {@link android.net.SocketKeepalive SocketKeepalive} and free allocated resources. The instance won't be
 * usable again if {@code close()} is called.
 * @apiSince 29
 */

public final void close() { throw new RuntimeException("Stub!"); }

/**
 * The hardware returned an error.
 * @apiSince 29
 */

public static final int ERROR_HARDWARE_ERROR = -31; // 0xffffffe1

/**
 * The limitation of resource is reached.
 * @apiSince 29
 */

public static final int ERROR_INSUFFICIENT_RESOURCES = -32; // 0xffffffe0

/**
 * The packet transmission interval is invalid (e.g., too short).
 * @apiSince 29
 */

public static final int ERROR_INVALID_INTERVAL = -24; // 0xffffffe8

/** The specified IP addresses are invalid. For example, the specified source IP address is
 * not configured on the specified {@code Network}.     * @apiSince 29
 */

public static final int ERROR_INVALID_IP_ADDRESS = -21; // 0xffffffeb

/**
 * The packet length is invalid (e.g., too long).
 * @apiSince 29
 */

public static final int ERROR_INVALID_LENGTH = -23; // 0xffffffe9

/**
 * The specified {@code Network} is not connected.
 * @apiSince 29
 */

public static final int ERROR_INVALID_NETWORK = -20; // 0xffffffec

/**
 * The requested port is invalid.
 * @apiSince 29
 */

public static final int ERROR_INVALID_PORT = -22; // 0xffffffea

/**
 * The target socket is invalid.
 * @apiSince 29
 */

public static final int ERROR_INVALID_SOCKET = -25; // 0xffffffe7

/**
 * The target socket is not idle.
 * @apiSince 29
 */

public static final int ERROR_SOCKET_NOT_IDLE = -26; // 0xffffffe6

/**
 * The device does not support this request.
 * @apiSince 29
 */

public static final int ERROR_UNSUPPORTED = -30; // 0xffffffe2
/**
 * The callback which app can use to learn the status changes of {@link android.net.SocketKeepalive SocketKeepalive}. See
 * {@link android.net.SocketKeepalive SocketKeepalive}.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Callback {

public Callback() { throw new RuntimeException("Stub!"); }

/**
 * The requested keepalive was successfully started.
 * @apiSince 29
 */

public void onStarted() { throw new RuntimeException("Stub!"); }

/**
 * The keepalive was successfully stopped.
 * @apiSince 29
 */

public void onStopped() { throw new RuntimeException("Stub!"); }

/**
 * An error occurred.
 * @param error Value is {@link android.net.SocketKeepalive#ERROR_INVALID_NETWORK}, {@link android.net.SocketKeepalive#ERROR_INVALID_IP_ADDRESS}, {@link android.net.SocketKeepalive#ERROR_INVALID_PORT}, {@link android.net.SocketKeepalive#ERROR_INVALID_LENGTH}, {@link android.net.SocketKeepalive#ERROR_INVALID_INTERVAL}, {@link android.net.SocketKeepalive#ERROR_INVALID_SOCKET}, or {@link android.net.SocketKeepalive#ERROR_SOCKET_NOT_IDLE}
 * @apiSince 29
 */

public void onError(int error) { throw new RuntimeException("Stub!"); }

/** The keepalive on a TCP socket was stopped because the socket received data. This is
 * never called for UDP sockets.         * @apiSince 29
 */

public void onDataReceived() { throw new RuntimeException("Stub!"); }
}

}

