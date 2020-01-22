/*
 * Copyright (C) 2013 The Android Open Source Project
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

import java.util.UUID;

/**
 * Represents a Bluetooth GATT Descriptor
 *
 * <p> GATT Descriptors contain additional information and attributes of a GATT
 * characteristic, {@link android.bluetooth.BluetoothGattCharacteristic BluetoothGattCharacteristic}. They can be used to describe
 * the characteristic's features or to control certain behaviours of the characteristic.
 * @apiSince 18
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class BluetoothGattDescriptor implements android.os.Parcelable {

/**
 * Create a new BluetoothGattDescriptor.
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
 *
 * @param uuid The UUID for this descriptor
 * @param permissions Permissions for this descriptor
 * @apiSince 18
 */

public BluetoothGattDescriptor(java.util.UUID uuid, int permissions) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Returns the characteristic this descriptor belongs to.
 *
 * @return The characteristic.
 * @apiSince 18
 */

public android.bluetooth.BluetoothGattCharacteristic getCharacteristic() { throw new RuntimeException("Stub!"); }

/**
 * Returns the UUID of this descriptor.
 *
 * @return UUID of this descriptor
 * @apiSince 18
 */

public java.util.UUID getUuid() { throw new RuntimeException("Stub!"); }

/**
 * Returns the permissions for this descriptor.
 *
 * @return Permissions of this descriptor
 * @apiSince 18
 */

public int getPermissions() { throw new RuntimeException("Stub!"); }

/**
 * Returns the stored value for this descriptor
 *
 * <p>This function returns the stored value for this descriptor as
 * retrieved by calling {@link android.bluetooth.BluetoothGatt#readDescriptor BluetoothGatt#readDescriptor}. The cached
 * value of the descriptor is updated as a result of a descriptor read
 * operation.
 *
 * @return Cached value of the descriptor
 * @apiSince 18
 */

public byte[] getValue() { throw new RuntimeException("Stub!"); }

/**
 * Updates the locally stored value of this descriptor.
 *
 * <p>This function modifies the locally stored cached value of this
 * descriptor. To send the value to the remote device, call
 * {@link android.bluetooth.BluetoothGatt#writeDescriptor BluetoothGatt#writeDescriptor} to send the value to the
 * remote device.
 *
 * @param value New value for this descriptor
 * @return true if the locally stored value has been set, false if the requested value could not
 * be stored locally.
 * @apiSince 18
 */

public boolean setValue(byte[] value) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.bluetooth.BluetoothGattDescriptor> CREATOR;
static { CREATOR = null; }

/**
 * Value used to disable notifications or indicatinos
 * @apiSince 18
 */

public static final byte[] DISABLE_NOTIFICATION_VALUE;
static { DISABLE_NOTIFICATION_VALUE = new byte[0]; }

/**
 * Value used to enable indication for a client configuration descriptor
 * @apiSince 18
 */

public static final byte[] ENABLE_INDICATION_VALUE;
static { ENABLE_INDICATION_VALUE = new byte[0]; }

/**
 * Value used to enable notification for a client configuration descriptor
 * @apiSince 18
 */

public static final byte[] ENABLE_NOTIFICATION_VALUE;
static { ENABLE_NOTIFICATION_VALUE = new byte[0]; }

/**
 * Descriptor read permission
 * @apiSince 18
 */

public static final int PERMISSION_READ = 1; // 0x1

/**
 * Descriptor permission: Allow encrypted read operations
 * @apiSince 18
 */

public static final int PERMISSION_READ_ENCRYPTED = 2; // 0x2

/**
 * Descriptor permission: Allow reading with man-in-the-middle protection
 * @apiSince 18
 */

public static final int PERMISSION_READ_ENCRYPTED_MITM = 4; // 0x4

/**
 * Descriptor write permission
 * @apiSince 18
 */

public static final int PERMISSION_WRITE = 16; // 0x10

/**
 * Descriptor permission: Allow encrypted writes
 * @apiSince 18
 */

public static final int PERMISSION_WRITE_ENCRYPTED = 32; // 0x20

/**
 * Descriptor permission: Allow encrypted writes with man-in-the-middle
 * protection
 * @apiSince 18
 */

public static final int PERMISSION_WRITE_ENCRYPTED_MITM = 64; // 0x40

/**
 * Descriptor permission: Allow signed write operations
 * @apiSince 18
 */

public static final int PERMISSION_WRITE_SIGNED = 128; // 0x80

/**
 * Descriptor permission: Allow signed write operations with
 * man-in-the-middle protection
 * @apiSince 18
 */

public static final int PERMISSION_WRITE_SIGNED_MITM = 256; // 0x100
}

