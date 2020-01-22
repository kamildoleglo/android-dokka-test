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

/**
 * This class represents a transform, which roughly corresponds to an IPsec Security Association.
 *
 * <p>Transforms are created using {@link android.net.IpSecTransform.Builder IpSecTransform.Builder}. Each {@code IpSecTransform}
 * object encapsulates the properties and state of an IPsec security association. That includes,
 * but is not limited to, algorithm choice, key material, and allocated system resources.
 *
 * @see <a href="https://tools.ietf.org/html/rfc4301">RFC 4301, Security Architecture for the
 *     Internet Protocol</a>
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class IpSecTransform implements java.lang.AutoCloseable {

IpSecTransform() { throw new RuntimeException("Stub!"); }

/**
 * Standard equals.
 * @apiSince 28
 */

public boolean equals(java.lang.Object other) { throw new RuntimeException("Stub!"); }

/**
 * Deactivate this {@code IpSecTransform} and free allocated resources.
 *
 * <p>Deactivating a transform while it is still applied to a socket will result in errors on
 * that socket. Make sure to remove transforms by calling {@link android.net.IpSecManager#removeTransportModeTransforms IpSecManager#removeTransportModeTransforms}. Note, removing an {@code IpSecTransform} from a
 * socket will not deactivate it (because one transform may be applied to multiple sockets).
 *
 * <p>It is safe to call this method on a transform that has already been deactivated.
 * @apiSince 28
 */

public void close() { throw new RuntimeException("Stub!"); }

/**
 * Check that the transform was closed properly.
 * @apiSince 28
 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
/**
 * This class is used to build {@link android.net.IpSecTransform IpSecTransform} objects.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Builder {

/**
 * Create a new IpSecTransform.Builder.
 *
 * @param context current context
 
 * This value must never be {@code null}.
 * @apiSince 28
 */

public Builder(@androidx.annotation.NonNull android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Set the encryption algorithm.
 *
 * <p>Encryption is mutually exclusive with authenticated encryption.
 *
 * @param algo {@link android.net.IpSecAlgorithm IpSecAlgorithm} specifying the encryption to be applied.
 
 * This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.net.IpSecTransform.Builder setEncryption(@androidx.annotation.NonNull android.net.IpSecAlgorithm algo) { throw new RuntimeException("Stub!"); }

/**
 * Set the authentication (integrity) algorithm.
 *
 * <p>Authentication is mutually exclusive with authenticated encryption.
 *
 * @param algo {@link android.net.IpSecAlgorithm IpSecAlgorithm} specifying the authentication to be applied.
 
 * This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.net.IpSecTransform.Builder setAuthentication(@androidx.annotation.NonNull android.net.IpSecAlgorithm algo) { throw new RuntimeException("Stub!"); }

/**
 * Set the authenticated encryption algorithm.
 *
 * <p>The Authenticated Encryption (AE) class of algorithms are also known as
 * Authenticated Encryption with Associated Data (AEAD) algorithms, or Combined mode
 * algorithms (as referred to in
 * <a href="https://tools.ietf.org/html/rfc4301">RFC 4301</a>).
 *
 * <p>Authenticated encryption is mutually exclusive with encryption and authentication.
 *
 * @param algo {@link android.net.IpSecAlgorithm IpSecAlgorithm} specifying the authenticated encryption algorithm to
 *     be applied.
 
 * This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.net.IpSecTransform.Builder setAuthenticatedEncryption(@androidx.annotation.NonNull android.net.IpSecAlgorithm algo) { throw new RuntimeException("Stub!"); }

/**
 * Add UDP encapsulation to an IPv4 transform.
 *
 * <p>This allows IPsec traffic to pass through a NAT.
 *
 * @see <a href="https://tools.ietf.org/html/rfc3948">RFC 3948, UDP Encapsulation of IPsec
 *     ESP Packets</a>
 * @see <a href="https://tools.ietf.org/html/rfc7296#section-2.23">RFC 7296 section 2.23,
 *     NAT Traversal of IKEv2</a>
 * @param localSocket a socket for sending and receiving encapsulated traffic
 * This value must never be {@code null}.
 * @param remotePort the UDP port number of the remote host that will send and receive
 *     encapsulated traffic. In the case of IKEv2, this should be port 4500.
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.net.IpSecTransform.Builder setIpv4Encapsulation(@androidx.annotation.NonNull android.net.IpSecManager.UdpEncapsulationSocket localSocket, int remotePort) { throw new RuntimeException("Stub!"); }

/**
 * Build a transport mode {@link android.net.IpSecTransform IpSecTransform}.
 *
 * <p>This builds and activates a transport mode transform. Note that an active transform
 * will not affect any network traffic until it has been applied to one or more sockets.
 *
 * @see IpSecManager#applyTransportModeTransform
 * @param sourceAddress the source {@code InetAddress} of traffic on sockets that will use
 *     this transform; this address must belong to the Network used by all sockets that
 *     utilize this transform; if provided, then only traffic originating from the
 *     specified source address will be processed.
 * This value must never be {@code null}.
 * @param spi a unique {@link android.net.IpSecManager.SecurityParameterIndex IpSecManager.SecurityParameterIndex} to identify transformed
 *     traffic
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException indicating that a particular combination of transform
 *     properties is invalid
 * @throws android.net.IpSecManager.ResourceUnavailableException indicating that too many transforms
 *     are active
 * @throws android.net.IpSecManager.SpiUnavailableException indicating the rare case where an SPI
 *     collides with an existing transform
 * @throws java.io.IOException indicating other errors
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.net.IpSecTransform buildTransportModeTransform(@androidx.annotation.NonNull java.net.InetAddress sourceAddress, @androidx.annotation.NonNull android.net.IpSecManager.SecurityParameterIndex spi) throws java.io.IOException, android.net.IpSecManager.ResourceUnavailableException, android.net.IpSecManager.SpiUnavailableException { throw new RuntimeException("Stub!"); }
}

}

