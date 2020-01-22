/*
 * Copyright (C) 2017 The Android Open Source Project
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
import java.net.InetAddress;
import java.net.Socket;
import java.io.FileDescriptor;

/**
 * This class contains methods for managing IPsec sessions. Once configured, the kernel will apply
 * confidentiality (encryption) and integrity (authentication) to IP traffic.
 *
 * <p>Note that not all aspects of IPsec are permitted by this API. Applications may create
 * transport mode security associations and apply them to individual sockets. Applications looking
 * to create a VPN should use {@link android.net.VpnService VpnService}.
 *
 * @see <a href="https://tools.ietf.org/html/rfc4301">RFC 4301, Security Architecture for the
 *     Internet Protocol</a>
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class IpSecManager {

IpSecManager() { throw new RuntimeException("Stub!"); }

/**
 * Reserve a random SPI for traffic bound to or from the specified destination address.
 *
 * <p>If successful, this SPI is guaranteed available until released by a call to {@link android.net.IpSecManager.SecurityParameterIndex#close() SecurityParameterIndex#close()}.
 *
 * @param destinationAddress the destination address for traffic bearing the requested SPI.
 *     For inbound traffic, the destination should be an address currently assigned on-device.
 * This value must never be {@code null}.
 * @return the reserved SecurityParameterIndex
 * This value will never be {@code null}.
 * @throws {@link #ResourceUnavailableException} indicating that too many SPIs are
 *     currently allocated for this user
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.net.IpSecManager.SecurityParameterIndex allocateSecurityParameterIndex(@androidx.annotation.NonNull java.net.InetAddress destinationAddress) throws android.net.IpSecManager.ResourceUnavailableException { throw new RuntimeException("Stub!"); }

/**
 * Reserve the requested SPI for traffic bound to or from the specified destination address.
 *
 * <p>If successful, this SPI is guaranteed available until released by a call to {@link android.net.IpSecManager.SecurityParameterIndex#close() SecurityParameterIndex#close()}.
 *
 * @param destinationAddress the destination address for traffic bearing the requested SPI.
 *     For inbound traffic, the destination should be an address currently assigned on-device.
 * This value must never be {@code null}.
 * @param requestedSpi the requested SPI. The range 1-255 is reserved and may not be used. See
 *     RFC 4303 Section 2.1.
 * @return the reserved SecurityParameterIndex
 * This value will never be {@code null}.
 * @throws {@link #ResourceUnavailableException} indicating that too many SPIs are
 *     currently allocated for this user
 * @throws {@link #SpiUnavailableException} indicating that the requested SPI could not be
 *     reserved
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.net.IpSecManager.SecurityParameterIndex allocateSecurityParameterIndex(@androidx.annotation.NonNull java.net.InetAddress destinationAddress, int requestedSpi) throws android.net.IpSecManager.ResourceUnavailableException, android.net.IpSecManager.SpiUnavailableException { throw new RuntimeException("Stub!"); }

/**
 * Apply an IPsec transform to a stream socket.
 *
 * <p>This applies transport mode encapsulation to the given socket. Once applied, I/O on the
 * socket will be encapsulated according to the parameters of the {@code IpSecTransform}. When
 * the transform is removed from the socket by calling {@link #removeTransportModeTransforms},
 * unprotected traffic can resume on that socket.
 *
 * <p>For security reasons, the destination address of any traffic on the socket must match the
 * remote {@code InetAddress} of the {@code IpSecTransform}. Attempts to send traffic to any
 * other IP address will result in an IOException. In addition, reads and writes on the socket
 * will throw IOException if the user deactivates the transform (by calling {@link android.net.IpSecTransform#close() IpSecTransform#close()}) without calling {@link #removeTransportModeTransforms}.
 *
 * <p>Note that when applied to TCP sockets, calling {@link android.net.IpSecTransform#close() IpSecTransform#close()} on an
 * applied transform before completion of graceful shutdown may result in the shutdown sequence
 * failing to complete. As such, applications requiring graceful shutdown MUST close the socket
 * prior to deactivating the applied transform. Socket closure may be performed asynchronously
 * (in batches), so the returning of a close function does not guarantee shutdown of a socket.
 * Setting an SO_LINGER timeout results in socket closure being performed synchronously, and is
 * sufficient to ensure shutdown.
 *
 * Specifically, if the transform is deactivated (by calling {@link android.net.IpSecTransform#close() IpSecTransform#close()}),
 * prior to the socket being closed, the standard [FIN - FIN/ACK - ACK], or the reset [RST]
 * packets are dropped due to the lack of a valid Transform. Similarly, if a socket without the
 * SO_LINGER option set is closed, the delayed/batched FIN packets may be dropped.
 *
 * <h4>Rekey Procedure</h4>
 *
 * <p>When applying a new tranform to a socket in the outbound direction, the previous transform
 * will be removed and the new transform will take effect immediately, sending all traffic on
 * the new transform; however, when applying a transform in the inbound direction, traffic
 * on the old transform will continue to be decrypted and delivered until that transform is
 * deallocated by calling {@link android.net.IpSecTransform#close() IpSecTransform#close()}. This overlap allows lossless rekey
 * procedures where both transforms are valid until both endpoints are using the new transform
 * and all in-flight packets have been received.
 *
 * @param socket a stream socket
 * This value must never be {@code null}.
 * @param direction the direction in which the transform should be applied
 * Value is {@link android.net.IpSecManager#DIRECTION_IN}, or {@link android.net.IpSecManager#DIRECTION_OUT}
 * @param transform a transport mode {@code IpSecTransform}
 * This value must never be {@code null}.
 * @throws java.io.IOException indicating that the transform could not be applied
 * @apiSince 28
 */

public void applyTransportModeTransform(@androidx.annotation.NonNull java.net.Socket socket, int direction, @androidx.annotation.NonNull android.net.IpSecTransform transform) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Apply an IPsec transform to a datagram socket.
 *
 * <p>This applies transport mode encapsulation to the given socket. Once applied, I/O on the
 * socket will be encapsulated according to the parameters of the {@code IpSecTransform}. When
 * the transform is removed from the socket by calling {@link #removeTransportModeTransforms},
 * unprotected traffic can resume on that socket.
 *
 * <p>For security reasons, the destination address of any traffic on the socket must match the
 * remote {@code InetAddress} of the {@code IpSecTransform}. Attempts to send traffic to any
 * other IP address will result in an IOException. In addition, reads and writes on the socket
 * will throw IOException if the user deactivates the transform (by calling {@link android.net.IpSecTransform#close() IpSecTransform#close()}) without calling {@link #removeTransportModeTransforms}.
 *
 * <h4>Rekey Procedure</h4>
 *
 * <p>When applying a new tranform to a socket in the outbound direction, the previous transform
 * will be removed and the new transform will take effect immediately, sending all traffic on
 * the new transform; however, when applying a transform in the inbound direction, traffic
 * on the old transform will continue to be decrypted and delivered until that transform is
 * deallocated by calling {@link android.net.IpSecTransform#close() IpSecTransform#close()}. This overlap allows lossless rekey
 * procedures where both transforms are valid until both endpoints are using the new transform
 * and all in-flight packets have been received.
 *
 * @param socket a datagram socket
 * This value must never be {@code null}.
 * @param direction the direction in which the transform should be applied
 * Value is {@link android.net.IpSecManager#DIRECTION_IN}, or {@link android.net.IpSecManager#DIRECTION_OUT}
 * @param transform a transport mode {@code IpSecTransform}
 * This value must never be {@code null}.
 * @throws java.io.IOException indicating that the transform could not be applied
 * @apiSince 28
 */

public void applyTransportModeTransform(@androidx.annotation.NonNull java.net.DatagramSocket socket, int direction, @androidx.annotation.NonNull android.net.IpSecTransform transform) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Apply an IPsec transform to a socket.
 *
 * <p>This applies transport mode encapsulation to the given socket. Once applied, I/O on the
 * socket will be encapsulated according to the parameters of the {@code IpSecTransform}. When
 * the transform is removed from the socket by calling {@link #removeTransportModeTransforms},
 * unprotected traffic can resume on that socket.
 *
 * <p>For security reasons, the destination address of any traffic on the socket must match the
 * remote {@code InetAddress} of the {@code IpSecTransform}. Attempts to send traffic to any
 * other IP address will result in an IOException. In addition, reads and writes on the socket
 * will throw IOException if the user deactivates the transform (by calling {@link android.net.IpSecTransform#close() IpSecTransform#close()}) without calling {@link #removeTransportModeTransforms}.
 *
 * <p>Note that when applied to TCP sockets, calling {@link android.net.IpSecTransform#close() IpSecTransform#close()} on an
 * applied transform before completion of graceful shutdown may result in the shutdown sequence
 * failing to complete. As such, applications requiring graceful shutdown MUST close the socket
 * prior to deactivating the applied transform. Socket closure may be performed asynchronously
 * (in batches), so the returning of a close function does not guarantee shutdown of a socket.
 * Setting an SO_LINGER timeout results in socket closure being performed synchronously, and is
 * sufficient to ensure shutdown.
 *
 * Specifically, if the transform is deactivated (by calling {@link android.net.IpSecTransform#close() IpSecTransform#close()}),
 * prior to the socket being closed, the standard [FIN - FIN/ACK - ACK], or the reset [RST]
 * packets are dropped due to the lack of a valid Transform. Similarly, if a socket without the
 * SO_LINGER option set is closed, the delayed/batched FIN packets may be dropped.
 *
 * <h4>Rekey Procedure</h4>
 *
 * <p>When applying a new tranform to a socket in the outbound direction, the previous transform
 * will be removed and the new transform will take effect immediately, sending all traffic on
 * the new transform; however, when applying a transform in the inbound direction, traffic
 * on the old transform will continue to be decrypted and delivered until that transform is
 * deallocated by calling {@link android.net.IpSecTransform#close() IpSecTransform#close()}. This overlap allows lossless rekey
 * procedures where both transforms are valid until both endpoints are using the new transform
 * and all in-flight packets have been received.
 *
 * @param socket a socket file descriptor
 * This value must never be {@code null}.
 * @param direction the direction in which the transform should be applied
 * Value is {@link android.net.IpSecManager#DIRECTION_IN}, or {@link android.net.IpSecManager#DIRECTION_OUT}
 * @param transform a transport mode {@code IpSecTransform}
 * This value must never be {@code null}.
 * @throws java.io.IOException indicating that the transform could not be applied
 * @apiSince 28
 */

public void applyTransportModeTransform(@androidx.annotation.NonNull java.io.FileDescriptor socket, int direction, @androidx.annotation.NonNull android.net.IpSecTransform transform) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Remove an IPsec transform from a stream socket.
 *
 * <p>Once removed, traffic on the socket will not be encrypted. Removing transforms from a
 * socket allows the socket to be reused for communication in the clear.
 *
 * <p>If an {@code IpSecTransform} object applied to this socket was deallocated by calling
 * {@link android.net.IpSecTransform#close() IpSecTransform#close()}, then communication on the socket will fail until this method
 * is called.
 *
 * @param socket a socket that previously had a transform applied to it
 * This value must never be {@code null}.
 * @throws java.io.IOException indicating that the transform could not be removed from the socket
 * @apiSince 28
 */

public void removeTransportModeTransforms(@androidx.annotation.NonNull java.net.Socket socket) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Remove an IPsec transform from a datagram socket.
 *
 * <p>Once removed, traffic on the socket will not be encrypted. Removing transforms from a
 * socket allows the socket to be reused for communication in the clear.
 *
 * <p>If an {@code IpSecTransform} object applied to this socket was deallocated by calling
 * {@link android.net.IpSecTransform#close() IpSecTransform#close()}, then communication on the socket will fail until this method
 * is called.
 *
 * @param socket a socket that previously had a transform applied to it
 * This value must never be {@code null}.
 * @throws java.io.IOException indicating that the transform could not be removed from the socket
 * @apiSince 28
 */

public void removeTransportModeTransforms(@androidx.annotation.NonNull java.net.DatagramSocket socket) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Remove an IPsec transform from a socket.
 *
 * <p>Once removed, traffic on the socket will not be encrypted. Removing transforms from a
 * socket allows the socket to be reused for communication in the clear.
 *
 * <p>If an {@code IpSecTransform} object applied to this socket was deallocated by calling
 * {@link android.net.IpSecTransform#close() IpSecTransform#close()}, then communication on the socket will fail until this method
 * is called.
 *
 * @param socket a socket that previously had a transform applied to it
 * This value must never be {@code null}.
 * @throws java.io.IOException indicating that the transform could not be removed from the socket
 * @apiSince 28
 */

public void removeTransportModeTransforms(@androidx.annotation.NonNull java.io.FileDescriptor socket) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Open a socket for UDP encapsulation and bind to the given port.
 *
 * <p>See {@link android.net.IpSecManager.UdpEncapsulationSocket UdpEncapsulationSocket} for the proper way to close the returned socket.
 *
 * @param port a local UDP port
 * @return a socket that is bound to the given port
 * This value will never be {@code null}.
 * @throws java.io.IOException indicating that the socket could not be opened or bound
 * @throws android.net.IpSecManager.ResourceUnavailableException indicating that too many encapsulation sockets are open
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.net.IpSecManager.UdpEncapsulationSocket openUdpEncapsulationSocket(int port) throws java.io.IOException, android.net.IpSecManager.ResourceUnavailableException { throw new RuntimeException("Stub!"); }

/**
 * Open a socket for UDP encapsulation.
 *
 * <p>See {@link android.net.IpSecManager.UdpEncapsulationSocket UdpEncapsulationSocket} for the proper way to close the returned socket.
 *
 * <p>The local port of the returned socket can be obtained by calling {@link android.net.IpSecManager.UdpEncapsulationSocket#getPort() UdpEncapsulationSocket#getPort()}.
 *
 * @return a socket that is bound to a local port
 * This value will never be {@code null}.
 * @throws java.io.IOException indicating that the socket could not be opened or bound
 * @throws android.net.IpSecManager.ResourceUnavailableException indicating that too many encapsulation sockets are open
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.net.IpSecManager.UdpEncapsulationSocket openUdpEncapsulationSocket() throws java.io.IOException, android.net.IpSecManager.ResourceUnavailableException { throw new RuntimeException("Stub!"); }

/**
 * Used when applying a transform to direct traffic through an {@link android.net.IpSecTransform IpSecTransform}
 * towards the host.
 *
 * <p>See {@link #applyTransportModeTransform(java.net.Socket,int,android.net.IpSecTransform)}.
 * @apiSince 28
 */

public static final int DIRECTION_IN = 0; // 0x0

/**
 * Used when applying a transform to direct traffic through an {@link android.net.IpSecTransform IpSecTransform}
 * away from the host.
 *
 * <p>See {@link #applyTransportModeTransform(java.net.Socket,int,android.net.IpSecTransform)}.
 * @apiSince 28
 */

public static final int DIRECTION_OUT = 1; // 0x1
/**
 * Thrown to indicate that an IPsec resource is unavailable.
 *
 * <p>This could apply to resources such as sockets, {@link android.net.IpSecManager.SecurityParameterIndex SecurityParameterIndex}, {@link android.net.IpSecTransform IpSecTransform}, or other system resources. If this exception is thrown, users should release
 * allocated objects of the type requested.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class ResourceUnavailableException extends android.util.AndroidException {

ResourceUnavailableException() { throw new RuntimeException("Stub!"); }
}

/**
 * This class represents a reserved SPI.
 *
 * <p>Objects of this type are used to track reserved security parameter indices. They can be
 * obtained by calling {@link android.net.IpSecManager#allocateSecurityParameterIndex IpSecManager#allocateSecurityParameterIndex} and must be released
 * by calling {@link #close()} when they are no longer needed.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class SecurityParameterIndex implements java.lang.AutoCloseable {

private SecurityParameterIndex() { throw new RuntimeException("Stub!"); }

/**
 * Get the underlying SPI held by this object.
 * @apiSince 28
 */

public int getSpi() { throw new RuntimeException("Stub!"); }

/**
 * Release an SPI that was previously reserved.
 *
 * <p>Release an SPI for use by other users in the system. If a SecurityParameterIndex is
 * applied to an IpSecTransform, it will become unusable for future transforms but should
 * still be closed to ensure system resources are released.
 * @apiSince 28
 */

public void close() { throw new RuntimeException("Stub!"); }

/**
 * Check that the SPI was closed properly.
 * @apiSince 28
 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

/**
 * Thrown to indicate that a requested SPI is in use.
 *
 * <p>The combination of remote {@code InetAddress} and SPI must be unique across all apps on
 * one device. If this error is encountered, a new SPI is required before a transform may be
 * created. This error can be avoided by calling {@link android.net.IpSecManager#allocateSecurityParameterIndex IpSecManager#allocateSecurityParameterIndex}.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class SpiUnavailableException extends android.util.AndroidException {

SpiUnavailableException() { throw new RuntimeException("Stub!"); }

/**
 * Get the SPI that caused a collision.
 * @apiSince 28
 */

public int getSpi() { throw new RuntimeException("Stub!"); }
}

/**
 * This class provides access to a UDP encapsulation Socket.
 *
 * <p>{@code UdpEncapsulationSocket} wraps a system-provided datagram socket intended for IKEv2
 * signalling and UDP encapsulated IPsec traffic. Instances can be obtained by calling {@link android.net.IpSecManager#openUdpEncapsulationSocket IpSecManager#openUdpEncapsulationSocket}. The provided socket cannot be re-bound by the
 * caller. The caller should not close the {@code FileDescriptor} returned by {@link
 * #getFileDescriptor}, but should use {@link #close} instead.
 *
 * <p>Allowing the user to close or unbind a UDP encapsulation socket could impact the traffic
 * of the next user who binds to that port. To prevent this scenario, these sockets are held
 * open by the system so that they may only be closed by calling {@link #close} or when the user
 * process exits.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class UdpEncapsulationSocket implements java.lang.AutoCloseable {

private UdpEncapsulationSocket() { throw new RuntimeException("Stub!"); }

/**
 * Get the encapsulation socket's file descriptor.
 * @apiSince 28
 */

public java.io.FileDescriptor getFileDescriptor() { throw new RuntimeException("Stub!"); }

/**
 * Get the bound port of the wrapped socket.
 * @apiSince 28
 */

public int getPort() { throw new RuntimeException("Stub!"); }

/**
 * Close this socket.
 *
 * <p>This closes the wrapped socket. Open encapsulation sockets count against a user's
 * resource limits, and forgetting to close them eventually will result in {@link android.net.IpSecManager.ResourceUnavailableException ResourceUnavailableException} being thrown.
 * @apiSince 28
 */

public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Check that the socket was closed properly.
 * @apiSince 28
 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

}

