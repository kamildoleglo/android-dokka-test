/*
 * Copyright (C) 2012 The Android Open Source Project
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

import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

/**
 * A connected or connecting Bluetooth socket.
 *
 * <p>The interface for Bluetooth Sockets is similar to that of TCP sockets:
 * {@link java.net.Socket} and {@link java.net.ServerSocket}. On the server
 * side, use a {@link android.bluetooth.BluetoothServerSocket BluetoothServerSocket} to create a listening server
 * socket. When a connection is accepted by the {@link android.bluetooth.BluetoothServerSocket BluetoothServerSocket},
 * it will return a new {@link android.bluetooth.BluetoothSocket BluetoothSocket} to manage the connection.
 * On the client side, use a single {@link android.bluetooth.BluetoothSocket BluetoothSocket} to both initiate
 * an outgoing connection and to manage the connection.
 *
 * <p>The most common type of Bluetooth socket is RFCOMM, which is the type
 * supported by the Android APIs. RFCOMM is a connection-oriented, streaming
 * transport over Bluetooth. It is also known as the Serial Port Profile (SPP).
 *
 * <p>To create a {@link android.bluetooth.BluetoothSocket BluetoothSocket} for connecting to a known device, use
 * {@link android.bluetooth.BluetoothDevice#createRfcommSocketToServiceRecord BluetoothDevice#createRfcommSocketToServiceRecord}.
 * Then call {@link #connect()} to attempt a connection to the remote device.
 * This call will block until a connection is established or the connection
 * fails.
 *
 * <p>To create a {@link android.bluetooth.BluetoothSocket BluetoothSocket} as a server (or "host"), see the
 * {@link android.bluetooth.BluetoothServerSocket BluetoothServerSocket} documentation.
 *
 * <p>Once the socket is connected, whether initiated as a client or accepted
 * as a server, open the IO streams by calling {@link #getInputStream} and
 * {@link #getOutputStream} in order to retrieve {@link java.io.InputStream}
 * and {@link java.io.OutputStream} objects, respectively, which are
 * automatically connected to the socket.
 *
 * <p>{@link android.bluetooth.BluetoothSocket BluetoothSocket} is thread
 * safe. In particular, {@link #close} will always immediately abort ongoing
 * operations and close the socket.
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
 * {@see BluetoothServerSocket}
 * {@see java.io.InputStream}
 * {@see java.io.OutputStream}
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class BluetoothSocket implements java.io.Closeable {

BluetoothSocket() { throw new RuntimeException("Stub!"); }

/** @hide */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/**
 * Get the remote device this socket is connecting, or connected, to.
 *
 * @return remote device
 * @apiSince 5
 */

public android.bluetooth.BluetoothDevice getRemoteDevice() { throw new RuntimeException("Stub!"); }

/**
 * Get the input stream associated with this socket.
 * <p>The input stream will be returned even if the socket is not yet
 * connected, but operations on that stream will throw IOException until
 * the associated socket is connected.
 *
 * @return InputStream
 * @apiSince 5
 */

public java.io.InputStream getInputStream() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Get the output stream associated with this socket.
 * <p>The output stream will be returned even if the socket is not yet
 * connected, but operations on that stream will throw IOException until
 * the associated socket is connected.
 *
 * @return OutputStream
 * @apiSince 5
 */

public java.io.OutputStream getOutputStream() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Get the connection status of this socket, ie, whether there is an active connection with
 * remote device.
 *
 * @return true if connected false if not connected
 * @apiSince 14
 */

public boolean isConnected() { throw new RuntimeException("Stub!"); }

/**
 * Attempt to connect to a remote device.
 * <p>This method will block until a connection is made or the connection
 * fails. If this method returns without an exception then this socket
 * is now connected.
 * <p>Creating new connections to
 * remote Bluetooth devices should not be attempted while device discovery
 * is in progress. Device discovery is a heavyweight procedure on the
 * Bluetooth adapter and will significantly slow a device connection.
 * Use {@link android.bluetooth.BluetoothAdapter#cancelDiscovery() BluetoothAdapter#cancelDiscovery()} to cancel an ongoing
 * discovery. Discovery is not managed by the Activity,
 * but is run as a system service, so an application should always call
 * {@link android.bluetooth.BluetoothAdapter#cancelDiscovery() BluetoothAdapter#cancelDiscovery()} even if it
 * did not directly request a discovery, just to be sure.
 * <p>{@link #close} can be used to abort this call from another thread.
 *
 * @throws java.io.IOException on error, for example connection failure
 * @apiSince 5
 */

public void connect() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Get the maximum supported Transmit packet size for the underlying transport.
 * Use this to optimize the writes done to the output socket, to avoid sending
 * half full packets.
 *
 * @return the maximum supported Transmit packet size for the underlying transport.
 * @apiSince 23
 */

public int getMaxTransmitPacketSize() { throw new RuntimeException("Stub!"); }

/**
 * Get the maximum supported Receive packet size for the underlying transport.
 * Use this to optimize the reads done on the input stream, as any call to read
 * will return a maximum of this amount of bytes - or for some transports a
 * multiple of this value.
 *
 * @return the maximum supported Receive packet size for the underlying transport.
 * @apiSince 23
 */

public int getMaxReceivePacketSize() { throw new RuntimeException("Stub!"); }

/**
 * Get the type of the underlying connection.
 *
 * @return one of {@link #TYPE_RFCOMM}, {@link #TYPE_SCO} or {@link #TYPE_L2CAP}
 * @apiSince 23
 */

public int getConnectionType() { throw new RuntimeException("Stub!"); }

/**
 * L2CAP socket
 * @apiSince 23
 */

public static final int TYPE_L2CAP = 3; // 0x3

/**
 * RFCOMM socket
 * @apiSince 23
 */

public static final int TYPE_RFCOMM = 1; // 0x1

/**
 * SCO socket
 * @apiSince 23
 */

public static final int TYPE_SCO = 2; // 0x2
}

