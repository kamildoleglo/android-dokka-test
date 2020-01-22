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


package android.mtp;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import java.io.IOException;

/**
 * This class represents an MTP or PTP device connected on the USB host bus. An application can
 * instantiate an object of this type, by referencing an attached {@link
 * android.hardware.usb.UsbDevice} and then use methods in this class to get information about the
 * device and objects stored on it, as well as open the connection and transfer data.
 * @apiSince 12
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class MtpDevice {

/**
 * MtpClient constructor
 *
 * @param device the {@link android.hardware.usb.UsbDevice} for the MTP or PTP device
 
 * This value must never be {@code null}.
 * @apiSince 12
 */

public MtpDevice(@androidx.annotation.NonNull android.hardware.usb.UsbDevice device) { throw new RuntimeException("Stub!"); }

/**
 * Opens the MTP device.  Once the device is open it takes ownership of the
 * {@link android.hardware.usb.UsbDeviceConnection}.
 * The connection will be closed when you call {@link #close()}
 * The connection will also be closed if this method fails.
 *
 * @param connection an open {@link android.hardware.usb.UsbDeviceConnection} for the device
 * This value must never be {@code null}.
 * @return true if the device was successfully opened.
 * @apiSince 12
 */

public boolean open(@androidx.annotation.NonNull android.hardware.usb.UsbDeviceConnection connection) { throw new RuntimeException("Stub!"); }

/**
 * Closes all resources related to the MtpDevice object.
 * After this is called, the object can not be used until {@link #open} is called again
 * with a new {@link android.hardware.usb.UsbDeviceConnection}.
 * @apiSince 12
 */

public void close() { throw new RuntimeException("Stub!"); }

/** @apiSince 12 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/**
 * Returns the name of the USB device
 * This returns the same value as {@link android.hardware.usb.UsbDevice#getDeviceName}
 * for the device's {@link android.hardware.usb.UsbDevice}
 *
 * @return the device name
 
 * This value will never be {@code null}.
 * @apiSince 12
 */

@androidx.annotation.NonNull
public java.lang.String getDeviceName() { throw new RuntimeException("Stub!"); }

/**
 * Returns the USB ID of the USB device.
 * This returns the same value as {@link android.hardware.usb.UsbDevice#getDeviceId}
 * for the device's {@link android.hardware.usb.UsbDevice}
 *
 * @return the device ID
 * @apiSince 12
 */

public int getDeviceId() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @return This value will never be {@code null}.
 * @apiSince 12
 */

@androidx.annotation.NonNull
public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.mtp.MtpDeviceInfo MtpDeviceInfo} for this device
 *
 * @return the device info, or null if fetching device info fails
 * @apiSince 12
 */

@androidx.annotation.Nullable
public android.mtp.MtpDeviceInfo getDeviceInfo() { throw new RuntimeException("Stub!"); }

/**
 * Returns the list of IDs for all storage units on this device
 * Information about each storage unit can be accessed via {@link #getStorageInfo}.
 *
 * @return the list of storage IDs, or null if fetching storage IDs fails
 * @apiSince 12
 */

@androidx.annotation.Nullable
public int[] getStorageIds() { throw new RuntimeException("Stub!"); }

/**
 * Returns the list of object handles for all objects on the given storage unit,
 * with the given format and parent.
 * Information about each object can be accessed via {@link #getObjectInfo}.
 *
 * @param storageId the storage unit to query
 * @param format the format of the object to return, or zero for all formats
 * @param objectHandle the parent object to query, -1 for the storage root,
 *     or zero for all objects
 * @return the object handles, or null if fetching object handles fails
 * @apiSince 12
 */

@androidx.annotation.Nullable
public int[] getObjectHandles(int storageId, int format, int objectHandle) { throw new RuntimeException("Stub!"); }

/**
 * Returns the data for an object as a byte array.
 * This call may block for an arbitrary amount of time depending on the size
 * of the data and speed of the devices.
 *
 * @param objectHandle handle of the object to read
 * @param objectSize the size of the object (this should match
 *      {@link android.mtp.MtpObjectInfo#getCompressedSize MtpObjectInfo#getCompressedSize})
 * @return the object's data, or null if reading fails
 * @apiSince 12
 */

@androidx.annotation.Nullable
public byte[] getObject(int objectHandle, int objectSize) { throw new RuntimeException("Stub!"); }

/**
 * Obtains object bytes in the specified range and writes it to an array.
 * This call may block for an arbitrary amount of time depending on the size
 * of the data and speed of the devices.
 *
 * @param objectHandle handle of the object to read
 * @param offset Start index of reading range. It must be a non-negative value at most
 *     0xffffffff.
 * @param size Size of reading range. It must be a non-negative value at most Integer.MAX_VALUE
 *     or 0xffffffff. If 0xffffffff is specified, the method obtains the full bytes of object.
 * @param buffer Array to write data.
 * This value must never be {@code null}.
 * @return Size of bytes that are actually read.
 * @apiSince 24
 */

public long getPartialObject(int objectHandle, long offset, long size, @androidx.annotation.NonNull byte[] buffer) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Obtains object bytes in the specified range and writes it to an array.
 * This call may block for an arbitrary amount of time depending on the size
 * of the data and speed of the devices.
 *
 * This is a vender-extended operation supported by Android that enables us to pass
 * unsigned 64-bit offset. Check if the MTP device supports the operation by using
 * {@link android.mtp.MtpDeviceInfo#getOperationsSupported() MtpDeviceInfo#getOperationsSupported()}.
 *
 * @param objectHandle handle of the object to read
 * @param offset Start index of reading range. It must be a non-negative value.
 * @param size Size of reading range. It must be a non-negative value at most Integer.MAX_VALUE.
 * @param buffer Array to write data.
 * This value must never be {@code null}.
 * @return Size of bytes that are actually read.
 * @see android.mtp.MtpConstants#OPERATION_GET_PARTIAL_OBJECT_64
 * @apiSince 24
 */

public long getPartialObject64(int objectHandle, long offset, long size, @androidx.annotation.NonNull byte[] buffer) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Returns the thumbnail data for an object as a byte array.
 * The size and format of the thumbnail data can be determined via
 * {@link android.mtp.MtpObjectInfo#getThumbCompressedSize MtpObjectInfo#getThumbCompressedSize} and
 * {@link android.mtp.MtpObjectInfo#getThumbFormat MtpObjectInfo#getThumbFormat}.
 * For typical devices the format is JPEG.
 *
 * @param objectHandle handle of the object to read
 * @return the object's thumbnail, or null if reading fails
 * @apiSince 12
 */

@androidx.annotation.Nullable
public byte[] getThumbnail(int objectHandle) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the {@link android.mtp.MtpStorageInfo MtpStorageInfo} for a storage unit.
 *
 * @param storageId the ID of the storage unit
 * @return the MtpStorageInfo, or null if fetching storage info fails
 * @apiSince 12
 */

@androidx.annotation.Nullable
public android.mtp.MtpStorageInfo getStorageInfo(int storageId) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the {@link android.mtp.MtpObjectInfo MtpObjectInfo} for an object.
 *
 * @param objectHandle the handle of the object
 * @return the MtpObjectInfo, or null if fetching object info fails
 * @apiSince 12
 */

@androidx.annotation.Nullable
public android.mtp.MtpObjectInfo getObjectInfo(int objectHandle) { throw new RuntimeException("Stub!"); }

/**
 * Deletes an object on the device.  This call may block, since
 * deleting a directory containing many files may take a long time
 * on some devices.
 *
 * @param objectHandle handle of the object to delete
 * @return true if the deletion succeeds
 * @apiSince 12
 */

public boolean deleteObject(int objectHandle) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the object handle for the parent of an object on the device.
 *
 * @param objectHandle handle of the object to query
 * @return the parent's handle, or zero if it is in the root of the storage
 * @apiSince 12
 */

public long getParent(int objectHandle) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the ID of the storage unit containing the given object on the device.
 *
 * @param objectHandle handle of the object to query
 * @return the object's storage unit ID
 * @apiSince 12
 */

public long getStorageId(int objectHandle) { throw new RuntimeException("Stub!"); }

/**
 * Copies the data for an object to a file in external storage.
 * This call may block for an arbitrary amount of time depending on the size
 * of the data and speed of the devices.
 *
 * @param objectHandle handle of the object to read
 * @param destPath path to destination for the file transfer.
 *      This path should be in the external storage as defined by
 *      {@link android.os.Environment#getExternalStorageDirectory}
 * This value must never be {@code null}.
 * @return true if the file transfer succeeds
 * @apiSince 12
 */

public boolean importFile(int objectHandle, @androidx.annotation.NonNull java.lang.String destPath) { throw new RuntimeException("Stub!"); }

/**
 * Copies the data for an object to a file descriptor.
 * This call may block for an arbitrary amount of time depending on the size
 * of the data and speed of the devices. The file descriptor is not closed
 * on completion, and must be done by the caller.
 *
 * @param objectHandle handle of the object to read
 * @param descriptor file descriptor to write the data to for the file transfer.
 * This value must never be {@code null}.
 * @return true if the file transfer succeeds
 * @apiSince 24
 */

public boolean importFile(int objectHandle, @androidx.annotation.NonNull android.os.ParcelFileDescriptor descriptor) { throw new RuntimeException("Stub!"); }

/**
 * Copies the data for an object from a file descriptor.
 * This call may block for an arbitrary amount of time depending on the size
 * of the data and speed of the devices. The file descriptor is not closed
 * on completion, and must be done by the caller.
 *
 * @param objectHandle handle of the target file
 * @param size size of the file in bytes
 * @param descriptor file descriptor to read the data from.
 * This value must never be {@code null}.
 * @return true if the file transfer succeeds
 * @apiSince 24
 */

public boolean sendObject(int objectHandle, long size, @androidx.annotation.NonNull android.os.ParcelFileDescriptor descriptor) { throw new RuntimeException("Stub!"); }

/**
 * Uploads an object metadata for a new entry. The {@link android.mtp.MtpObjectInfo MtpObjectInfo} can be
 * created with the {@link android.mtp.MtpObjectInfo.Builder MtpObjectInfo.Builder} class.
 *
 * The returned {@link android.mtp.MtpObjectInfo MtpObjectInfo} has the new object handle field filled in.
 *
 * @param info metadata of the entry
 * This value must never be {@code null}.
 * @return object info of the created entry, or null if sending object info fails
 * @apiSince 24
 */

@androidx.annotation.Nullable
public android.mtp.MtpObjectInfo sendObjectInfo(@androidx.annotation.NonNull android.mtp.MtpObjectInfo info) { throw new RuntimeException("Stub!"); }

/**
 * Reads an event from the device. It blocks the current thread until it gets an event.
 * It throws OperationCanceledException if it is cancelled by signal.
 *
 * @param signal signal for cancellation
 * This value may be {@code null}.
 * @return obtained event
 * This value will never be {@code null}.
 * @throws java.io.IOException
 * @apiSince 24
 */

@androidx.annotation.NonNull
public android.mtp.MtpEvent readEvent(@androidx.annotation.Nullable android.os.CancellationSignal signal) throws java.io.IOException { throw new RuntimeException("Stub!"); }
}

