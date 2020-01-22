/*
 * Copyright (C) 2010 The Android Open Source Project
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


package android.net.rtp;


/**
 * RtpStream represents the base class of streams which send and receive network
 * packets with media payloads over Real-time Transport Protocol (RTP).
 *
 * <p class="note">Using this class requires
 * {@link android.Manifest.permission#INTERNET} permission.</p>
 * @apiSince 12
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class RtpStream {

RtpStream() { throw new RuntimeException("Stub!"); }

/**
 * Returns the network address of the local host.
 * @apiSince 12
 */

public java.net.InetAddress getLocalAddress() { throw new RuntimeException("Stub!"); }

/**
 * Returns the network port of the local host.
 * @apiSince 12
 */

public int getLocalPort() { throw new RuntimeException("Stub!"); }

/**
 * Returns the network address of the remote host or {@code null} if the
 * stream is not associated.
 * @apiSince 12
 */

public java.net.InetAddress getRemoteAddress() { throw new RuntimeException("Stub!"); }

/**
 * Returns the network port of the remote host or {@code -1} if the stream
 * is not associated.
 * @apiSince 12
 */

public int getRemotePort() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if the stream is busy. In this case most of the
 * setter methods are disabled. This method is intended to be overridden
 * by subclasses.
 * @apiSince 12
 */

public boolean isBusy() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current mode.
 * @apiSince 12
 */

public int getMode() { throw new RuntimeException("Stub!"); }

/**
 * Changes the current mode. It must be one of {@link #MODE_NORMAL},
 * {@link #MODE_SEND_ONLY}, and {@link #MODE_RECEIVE_ONLY}.
 *
 * @param mode The mode to change to.
 * @throws java.lang.IllegalArgumentException if the mode is invalid.
 * @throws java.lang.IllegalStateException if the stream is busy.
 * @see #isBusy()
 * @apiSince 12
 */

public void setMode(int mode) { throw new RuntimeException("Stub!"); }

/**
 * Associates with a remote host. This defines the destination of the
 * outgoing packets.
 *
 * @param address The network address of the remote host.
 * @param port The network port of the remote host.
 * @throws java.lang.IllegalArgumentException if the address is not supported or the
 *     port is invalid.
 * @throws java.lang.IllegalStateException if the stream is busy.
 * @see #isBusy()
 * @apiSince 12
 */

public void associate(java.net.InetAddress address, int port) { throw new RuntimeException("Stub!"); }

/**
 * Releases allocated resources. The stream becomes inoperable after calling
 * this method.
 *
 * @throws java.lang.IllegalStateException if the stream is busy.
 * @see #isBusy()
 * @apiSince 12
 */

public void release() { throw new RuntimeException("Stub!"); }

/** @apiSince 12 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/**
 * This mode indicates that the stream sends and receives packets at the
 * same time. This is the initial mode for new streams.
 * @apiSince 12
 */

public static final int MODE_NORMAL = 0; // 0x0

/**
 * This mode indicates that the stream only receives packets.
 * @apiSince 12
 */

public static final int MODE_RECEIVE_ONLY = 2; // 0x2

/**
 * This mode indicates that the stream only sends packets.
 * @apiSince 12
 */

public static final int MODE_SEND_ONLY = 1; // 0x1
}

