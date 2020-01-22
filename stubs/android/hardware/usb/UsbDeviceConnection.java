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


package android.hardware.usb;

import android.os.Build;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeoutException;

/**
 * This class is used for sending and receiving data and control messages to a USB device.
 * Instances of this class are created by {@link android.hardware.usb.UsbManager#openDevice UsbManager#openDevice}.
 * @apiSince 12
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class UsbDeviceConnection {

UsbDeviceConnection() { throw new RuntimeException("Stub!"); }

/**
 * Releases all system resources related to the device.
 * Once the object is closed it cannot be used again.
 * The client must call {@link android.hardware.usb.UsbManager#openDevice UsbManager#openDevice} again
 * to retrieve a new instance to reestablish communication with the device.
 * @apiSince 12
 */

public void close() { throw new RuntimeException("Stub!"); }

/**
 * Returns the native file descriptor for the device, or
 * -1 if the device is not opened.
 * This is intended for passing to native code to access the device.
 *
 * @return the native file descriptor
 * @apiSince 12
 */

public int getFileDescriptor() { throw new RuntimeException("Stub!"); }

/**
 * Returns the raw USB descriptors for the device.
 * This can be used to access descriptors not supported directly
 * via the higher level APIs.
 *
 * @return raw USB descriptors
 * @apiSince 13
 */

public byte[] getRawDescriptors() { throw new RuntimeException("Stub!"); }

/**
 * Claims exclusive access to a {@link android.hardware.usb.UsbInterface}.
 * This must be done before sending or receiving data on any
 * {@link android.hardware.usb.UsbEndpoint}s belonging to the interface.
 *
 * @param intf the interface to claim
 * @param force true to disconnect kernel driver if necessary
 * @return true if the interface was successfully claimed
 * @apiSince 12
 */

public boolean claimInterface(android.hardware.usb.UsbInterface intf, boolean force) { throw new RuntimeException("Stub!"); }

/**
 * Releases exclusive access to a {@link android.hardware.usb.UsbInterface}.
 *
 * @return true if the interface was successfully released
 * @apiSince 12
 */

public boolean releaseInterface(android.hardware.usb.UsbInterface intf) { throw new RuntimeException("Stub!"); }

/**
 * Sets the current {@link android.hardware.usb.UsbInterface}.
 * Used to select between two interfaces with the same ID but different alternate setting.
 *
 * @return true if the interface was successfully selected
 * @apiSince 21
 */

public boolean setInterface(android.hardware.usb.UsbInterface intf) { throw new RuntimeException("Stub!"); }

/**
 * Sets the device's current {@link android.hardware.usb.UsbConfiguration}.
 *
 * @return true if the configuration was successfully set
 * @apiSince 21
 */

public boolean setConfiguration(android.hardware.usb.UsbConfiguration configuration) { throw new RuntimeException("Stub!"); }

/**
 * Performs a control transaction on endpoint zero for this device.
 * The direction of the transfer is determined by the request type.
 * If requestType & {@link android.hardware.usb.UsbConstants#USB_ENDPOINT_DIR_MASK UsbConstants#USB_ENDPOINT_DIR_MASK} is
 * {@link android.hardware.usb.UsbConstants#USB_DIR_OUT UsbConstants#USB_DIR_OUT}, then the transfer is a write,
 * and if it is {@link android.hardware.usb.UsbConstants#USB_DIR_IN UsbConstants#USB_DIR_IN}, then the transfer
 * is a read.
 * <p>
 * This method transfers data starting from index 0 in the buffer.
 * To specify a different offset, use
 * {@link #controlTransfer(int,int,int,int,byte[],int,int,int)}.
 * </p>
 *
 * @param requestType request type for this transaction
 * @param request request ID for this transaction
 * @param value value field for this transaction
 * @param index index field for this transaction
 * @param buffer buffer for data portion of transaction,
 * or null if no data needs to be sent or received
 * @param length the length of the data to send or receive
 * @param timeout in milliseconds
 * @return length of data transferred (or zero) for success,
 * or negative value for failure
 * @apiSince 12
 */

public int controlTransfer(int requestType, int request, int value, int index, byte[] buffer, int length, int timeout) { throw new RuntimeException("Stub!"); }

/**
 * Performs a control transaction on endpoint zero for this device.
 * The direction of the transfer is determined by the request type.
 * If requestType & {@link android.hardware.usb.UsbConstants#USB_ENDPOINT_DIR_MASK UsbConstants#USB_ENDPOINT_DIR_MASK} is
 * {@link android.hardware.usb.UsbConstants#USB_DIR_OUT UsbConstants#USB_DIR_OUT}, then the transfer is a write,
 * and if it is {@link android.hardware.usb.UsbConstants#USB_DIR_IN UsbConstants#USB_DIR_IN}, then the transfer
 * is a read.
 *
 * @param requestType request type for this transaction
 * @param request request ID for this transaction
 * @param value value field for this transaction
 * @param index index field for this transaction
 * @param buffer buffer for data portion of transaction,
 * or null if no data needs to be sent or received
 * @param offset the index of the first byte in the buffer to send or receive
 * @param length the length of the data to send or receive
 * @param timeout in milliseconds
 * @return length of data transferred (or zero) for success,
 * or negative value for failure
 * @apiSince 18
 */

public int controlTransfer(int requestType, int request, int value, int index, byte[] buffer, int offset, int length, int timeout) { throw new RuntimeException("Stub!"); }

/**
 * Performs a bulk transaction on the given endpoint.
 * The direction of the transfer is determined by the direction of the endpoint.
 * <p>
 * This method transfers data starting from index 0 in the buffer.
 * To specify a different offset, use
 * {@link #bulkTransfer(android.hardware.usb.UsbEndpoint,byte[],int,int,int)}.
 * </p>
 *
 * @param endpoint the endpoint for this transaction
 * @param buffer buffer for data to send or receive; can be {@code null} to wait for next
 *               transaction without reading data
 * @param length the length of the data to send or receive. Before
 *               {@value android.os.Build.VERSION_CODES#P Build.VERSION_CODES#P}, a value larger than 16384 bytes
 *               would be truncated down to 16384. In API {@value android.os.Build.VERSION_CODES#P Build.VERSION_CODES#P}
 *               and after, any value of length is valid.
 * @param timeout in milliseconds, 0 is infinite
 * @return length of data transferred (or zero) for success,
 * or negative value for failure
 * @apiSince 12
 */

public int bulkTransfer(android.hardware.usb.UsbEndpoint endpoint, byte[] buffer, int length, int timeout) { throw new RuntimeException("Stub!"); }

/**
 * Performs a bulk transaction on the given endpoint.
 * The direction of the transfer is determined by the direction of the endpoint.
 *
 * @param endpoint the endpoint for this transaction
 * @param buffer buffer for data to send or receive
 * @param offset the index of the first byte in the buffer to send or receive
 * @param length the length of the data to send or receive. Before
 *               {@value android.os.Build.VERSION_CODES#P Build.VERSION_CODES#P}, a value larger than 16384 bytes
 *               would be truncated down to 16384. In API {@value android.os.Build.VERSION_CODES#P Build.VERSION_CODES#P}
 *               and after, any value of length is valid.
 * @param timeout in milliseconds, 0 is infinite
 * @return length of data transferred (or zero) for success,
 * or negative value for failure
 * @apiSince 18
 */

public int bulkTransfer(android.hardware.usb.UsbEndpoint endpoint, byte[] buffer, int offset, int length, int timeout) { throw new RuntimeException("Stub!"); }

/**
 * Waits for the result of a {@link android.hardware.usb.UsbRequest#queue} operation
 * <p>Note that this may return requests queued on multiple
 * {@link android.hardware.usb.UsbEndpoint}s. When multiple endpoints are in use,
 * {@link android.hardware.usb.UsbRequest#getEndpoint} and {@link
 * android.hardware.usb.UsbRequest#getClientData} can be useful in determining how to process
 * the result of this function.</p>
 *
 * @return a completed USB request, or null if an error occurred
 *
 * @throws java.lang.IllegalArgumentException Before API {@value android.os.Build.VERSION_CODES#O Build.VERSION_CODES#O}: if the number of
 *                                  bytes read or written is more than the limit of the
 *                                  request's buffer. The number of bytes is determined by the
 *                                  {@code length} parameter of
 *                                  {@link android.hardware.usb.UsbRequest#queue(java.nio.ByteBuffer,int) UsbRequest#queue(ByteBuffer, int)}
 * @throws java.nio.BufferOverflowException In API {@value android.os.Build.VERSION_CODES#O Build.VERSION_CODES#O} and after: if the
 *                                 number of bytes read or written is more than the limit of the
 *                                 request's buffer. The number of bytes is determined by the
 *                                 {@code length} parameter of
 *                                 {@link android.hardware.usb.UsbRequest#queue(java.nio.ByteBuffer,int) UsbRequest#queue(ByteBuffer, int)}
 * @apiSince 12
 */

public android.hardware.usb.UsbRequest requestWait() { throw new RuntimeException("Stub!"); }

/**
 * Waits for the result of a {@link android.hardware.usb.UsbRequest#queue} operation
 * <p>Note that this may return requests queued on multiple
 * {@link android.hardware.usb.UsbEndpoint}s. When multiple endpoints are in use,
 * {@link android.hardware.usb.UsbRequest#getEndpoint} and {@link
 * android.hardware.usb.UsbRequest#getClientData} can be useful in determining how to process
 * the result of this function.</p>
 * <p>Android processes {@link android.hardware.usb.UsbRequest UsbRequest} asynchronously. Hence it is not
 * guaranteed that {@link #requestWait(long) requestWait(0)} returns a request that has been
 * queued right before even if the request could have been processed immediately.</p>
 *
 * @param timeout timeout in milliseconds. If 0 this method does not wait.
 *
 * @return a completed USB request, or {@code null} if an error occurred
 *
 * @throws java.nio.BufferOverflowException if the number of bytes read or written is more than the
 *                                 limit of the request's buffer. The number of bytes is
 *                                 determined by the {@code length} parameter of
 *                                 {@link android.hardware.usb.UsbRequest#queue(java.nio.ByteBuffer,int) UsbRequest#queue(ByteBuffer, int)}
 * @throws java.util.concurrent.TimeoutException if no request was received in {@code timeout} milliseconds.
 * @apiSince 26
 */

public android.hardware.usb.UsbRequest requestWait(long timeout) throws java.util.concurrent.TimeoutException { throw new RuntimeException("Stub!"); }

/**
 * Returns the serial number for the device.
 * This will return null if the device has not been opened.
 *
 * @return the device serial number
 * @apiSince 12
 */

public java.lang.String getSerial() { throw new RuntimeException("Stub!"); }

/** @apiSince 12 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }
}

