/*
 * Copyright (C) 2009 The Android Open Source Project
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


package android.bluetooth;

import java.io.IOException;

/**
 * A listening Bluetooth socket.
 *
 * <p>The interface for Bluetooth Sockets is similar to that of TCP sockets:
 * {@link java.net.Socket} and {@link java.net.ServerSocket}. On the server
 * side, use a {@link android.bluetooth.BluetoothServerSocket BluetoothServerSocket} to create a listening server
 * socket. When a connection is accepted by the {@link android.bluetooth.BluetoothServerSocket BluetoothServerSocket},
 * it will return a new {@link android.bluetooth.BluetoothSocket BluetoothSocket} to manage the connection.
 * On the client side, use a single {@link android.bluetooth.BluetoothSocket BluetoothSocket} to both initiate
 * an outgoing connection and to manage the connection.
 *
 * <p>For Bluetooth BR/EDR, the most common type of socket is RFCOMM, which is the type supported by
 * the Android APIs. RFCOMM is a connection-oriented, streaming transport over Bluetooth BR/EDR. It
 * is also known as the Serial Port Profile (SPP). To create a listening
 * {@link android.bluetooth.BluetoothServerSocket BluetoothServerSocket} that's ready for incoming Bluetooth BR/EDR connections, use {@link android.bluetooth.BluetoothAdapter#listenUsingRfcommWithServiceRecord BluetoothAdapter#listenUsingRfcommWithServiceRecord}.
 *
 * <p>For Bluetooth LE, the socket uses LE Connection-oriented Channel (CoC). LE CoC is a
 * connection-oriented, streaming transport over Bluetooth LE and has a credit-based flow control.
 * Correspondingly, use {@link android.bluetooth.BluetoothAdapter#listenUsingL2capChannel BluetoothAdapter#listenUsingL2capChannel} to create a listening {@link android.bluetooth.BluetoothServerSocket BluetoothServerSocket}
 * that's ready for incoming Bluetooth LE CoC connections. For LE CoC, you can use {@link #getPsm()}
 * to get the protocol/service multiplexer (PSM) value that the peer needs to use to connect to your
 * socket.
 *
 * <p> After the listening {@link android.bluetooth.BluetoothServerSocket BluetoothServerSocket} is created, call {@link #accept()} to
 * listen for incoming connection requests. This call will block until a connection is established,
 * at which point, it will return a {@link android.bluetooth.BluetoothSocket BluetoothSocket} to manage the connection. Once the
 * {@link android.bluetooth.BluetoothSocket BluetoothSocket} is acquired, it's a good idea to call {@link #close()} on the {@link android.bluetooth.BluetoothServerSocket BluetoothServerSocket} when it's no longer needed for accepting
 * connections. Closing the {@link android.bluetooth.BluetoothServerSocket BluetoothServerSocket} will <em>not</em> close the returned
 * {@link android.bluetooth.BluetoothSocket BluetoothSocket}.
 *
 * <p>{@link android.bluetooth.BluetoothServerSocket BluetoothServerSocket} is thread
 * safe. In particular, {@link #close} will always immediately abort ongoing
 * operations and close the server socket.
 *
 * <p class="note"><strong>Note:</strong>
 * Requires the {@link android.Manifest.permission#BLUETOOTH} permission.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about using Bluetooth, read the
 * <a href="{@docRoot}guide/topics/connectivity/bluetooth.html">Bluetooth</a> developer guide.</p>
 * </div>
 *
 * {@see BluetoothSocket}
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class BluetoothServerSocket implements java.io.Closeable {

BluetoothServerSocket() { throw new RuntimeException("Stub!"); }

/**
 * Block until a connection is established.
 * <p>Returns a connected {@link android.bluetooth.BluetoothSocket BluetoothSocket} on successful connection.
 * <p>Once this call returns, it can be called again to accept subsequent
 * incoming connections.
 * <p>{@link #close} can be used to abort this call from another thread.
 *
 * @return a connected {@link android.bluetooth.BluetoothSocket BluetoothSocket}
 * @throws java.io.IOException on error, for example this call was aborted, or timeout
 * @apiSince 5
 */

public android.bluetooth.BluetoothSocket accept() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Block until a connection is established, with timeout.
 * <p>Returns a connected {@link android.bluetooth.BluetoothSocket BluetoothSocket} on successful connection.
 * <p>Once this call returns, it can be called again to accept subsequent
 * incoming connections.
 * <p>{@link #close} can be used to abort this call from another thread.
 *
 * @return a connected {@link android.bluetooth.BluetoothSocket BluetoothSocket}
 * @throws java.io.IOException on error, for example this call was aborted, or timeout
 * @apiSince 5
 */

public android.bluetooth.BluetoothSocket accept(int timeout) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Immediately close this socket, and release all associated resources.
 * <p>Causes blocked calls on this socket in other threads to immediately
 * throw an IOException.
 * <p>Closing the {@link android.bluetooth.BluetoothServerSocket BluetoothServerSocket} will <em>not</em>
 * close any {@link android.bluetooth.BluetoothSocket BluetoothSocket} received from {@link #accept()}.
 * @apiSince 5
 */

public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Returns the assigned dynamic protocol/service multiplexer (PSM) value for the listening L2CAP
 * Connection-oriented Channel (CoC) server socket. This server socket must be returned by the
 * {@link android.bluetooth.BluetoothAdapter#listenUsingL2capChannel() BluetoothAdapter#listenUsingL2capChannel()} or {@link android.bluetooth.BluetoothAdapter#listenUsingInsecureL2capChannel() BluetoothAdapter#listenUsingInsecureL2capChannel()}. The returned value is undefined if this
 * method is called on non-L2CAP server sockets.
 *
 * @return the assigned PSM or LE_PSM value depending on transport
 * @apiSince 29
 */

public int getPsm() { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

