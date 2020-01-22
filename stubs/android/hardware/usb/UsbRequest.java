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


package android.hardware.usb;

import android.os.Build;
import java.nio.ByteBuffer;

/**
 * A class representing USB request packet.
 * This can be used for both reading and writing data to or from a
 * {@link android.hardware.usb.UsbDeviceConnection}.
 * UsbRequests can be used to transfer data on bulk and interrupt endpoints.
 * Requests on bulk endpoints can be sent synchronously via {@link android.hardware.usb.UsbDeviceConnection#bulkTransfer UsbDeviceConnection#bulkTransfer}
 * or asynchronously via {@link #queue} and {@link android.hardware.usb.UsbDeviceConnection#requestWait UsbDeviceConnection#requestWait}.
 * Requests on interrupt endpoints are only send and received asynchronously.
 *
 * <p>Requests on endpoint zero are not supported by this class;
 * use {@link android.hardware.usb.UsbDeviceConnection#controlTransfer UsbDeviceConnection#controlTransfer} for endpoint zero requests instead.
 * @apiSince 12
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class UsbRequest {

/** @apiSince 12 */

public UsbRequest() { throw new RuntimeException("Stub!"); }

/**
 * Initializes the request so it can read or write data on the given endpoint.
 * Whether the request allows reading or writing depends on the direction of the endpoint.
 *
 * @param endpoint the endpoint to be used for this request.
 * @return true if the request was successfully opened.
 * @apiSince 12
 */

public boolean initialize(android.hardware.usb.UsbDeviceConnection connection, android.hardware.usb.UsbEndpoint endpoint) { throw new RuntimeException("Stub!"); }

/**
 * Releases all resources related to this request.
 * @apiSince 12
 */

public void close() { throw new RuntimeException("Stub!"); }

/** @apiSince 12 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/**
 * Returns the endpoint for the request, or null if the request is not opened.
 *
 * @return the request's endpoint
 * @apiSince 12
 */

public android.hardware.usb.UsbEndpoint getEndpoint() { throw new RuntimeException("Stub!"); }

/**
 * Returns the client data for the request.
 * This can be used in conjunction with {@link #setClientData}
 * to associate another object with this request, which can be useful for
 * maintaining state between calls to {@link #queue} and
 * {@link android.hardware.usb.UsbDeviceConnection#requestWait}
 *
 * @return the client data for the request
 * @apiSince 12
 */

public java.lang.Object getClientData() { throw new RuntimeException("Stub!"); }

/**
 * Sets the client data for the request.
 * This can be used in conjunction with {@link #getClientData}
 * to associate another object with this request, which can be useful for
 * maintaining state between calls to {@link #queue} and
 * {@link android.hardware.usb.UsbDeviceConnection#requestWait}
 *
 * @param data the client data for the request
 * @apiSince 12
 */

public void setClientData(java.lang.Object data) { throw new RuntimeException("Stub!"); }

/**
 * Queues the request to send or receive data on its endpoint.
 * <p>For OUT endpoints, the given buffer data will be sent on the endpoint. For IN endpoints,
 * the endpoint will attempt to read the given number of bytes into the specified buffer. If the
 * queueing operation is successful, return true. The result will be returned via
 * {@link android.hardware.usb.UsbDeviceConnection#requestWait UsbDeviceConnection#requestWait}</p>
 *
 * @param buffer the buffer containing the bytes to write, or location to store the results of a
 *               read. Position and array offset will be ignored and assumed to be 0. Limit and
 *               capacity will be ignored. Once the request
 *               {@link android.hardware.usb.UsbDeviceConnection#requestWait() UsbDeviceConnection#requestWait()} the position will be set
 *               to the number of bytes read/written.
 * @param length number of bytes to read or write. Before {@value android.os.Build.VERSION_CODES#P Build.VERSION_CODES#P}, a
 *               value larger than 16384 bytes would be truncated down to 16384. In API
 *               {@value android.os.Build.VERSION_CODES#P Build.VERSION_CODES#P} and after, any value of length is valid.
 *
 * @return true if the queueing operation succeeded
 *
 * @deprecated Use {@link #queue(java.nio.ByteBuffer)} instead.
 * @apiSince 12
 * @deprecatedSince 26
 */

@Deprecated
public boolean queue(java.nio.ByteBuffer buffer, int length) { throw new RuntimeException("Stub!"); }

/**
 * Queues the request to send or receive data on its endpoint.
 *
 * <p>For OUT endpoints, the remaining bytes of the buffer will be sent on the endpoint. For IN
 * endpoints, the endpoint will attempt to fill the remaining bytes of the buffer. If the
 * queueing operation is successful, return true. The result will be returned via
 * {@link android.hardware.usb.UsbDeviceConnection#requestWait UsbDeviceConnection#requestWait}</p>
 *
 * @param buffer the buffer containing the bytes to send, or the buffer to fill. The state
 *               of the buffer is undefined until the request is returned by
 *               {@link android.hardware.usb.UsbDeviceConnection#requestWait UsbDeviceConnection#requestWait}. If the request failed the buffer
 *               will be unchanged; if the request succeeded the position of the buffer is
 *               incremented by the number of bytes sent/received. Before
 *               {@value android.os.Build.VERSION_CODES#P Build.VERSION_CODES#P}, a buffer of length larger than 16384 bytes
 *               would throw IllegalArgumentException. In API {@value android.os.Build.VERSION_CODES#P Build.VERSION_CODES#P}
 *               and after, any size buffer is valid.
 *
 * This value may be {@code null}.
 * @return true if the queueing operation succeeded
 * @apiSince 26
 */

public boolean queue(@androidx.annotation.Nullable java.nio.ByteBuffer buffer) { throw new RuntimeException("Stub!"); }

/**
 * Cancels a pending queue operation.
 *
 * @return true if cancelling succeeded
 * @apiSince 12
 */

public boolean cancel() { throw new RuntimeException("Stub!"); }
}

