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
import java.util.List;

/**
 * Represents a Bluetooth GATT Characteristic
 *
 * <p>A GATT characteristic is a basic data element used to construct a GATT service,
 * {@link android.bluetooth.BluetoothGattService BluetoothGattService}. The characteristic contains a value as well as
 * additional information and optional GATT descriptors, {@link android.bluetooth.BluetoothGattDescriptor BluetoothGattDescriptor}.
 * @apiSince 18
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class BluetoothGattCharacteristic implements android.os.Parcelable {

/**
 * Create a new BluetoothGattCharacteristic.
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
 *
 * @param uuid The UUID for this characteristic
 * @param properties Properties of this characteristic
 * @param permissions Permissions for this characteristic
 * @apiSince 18
 */

public BluetoothGattCharacteristic(java.util.UUID uuid, int properties, int permissions) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Adds a descriptor to this characteristic.
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
 *
 * @param descriptor Descriptor to be added to this characteristic.
 * @return true, if the descriptor was added to the characteristic
 * @apiSince 18
 */

public boolean addDescriptor(android.bluetooth.BluetoothGattDescriptor descriptor) { throw new RuntimeException("Stub!"); }

/**
 * Returns the service this characteristic belongs to.
 *
 * @return The asscociated service
 * @apiSince 18
 */

public android.bluetooth.BluetoothGattService getService() { throw new RuntimeException("Stub!"); }

/**
 * Returns the UUID of this characteristic
 *
 * @return UUID of this characteristic
 * @apiSince 18
 */

public java.util.UUID getUuid() { throw new RuntimeException("Stub!"); }

/**
 * Returns the instance ID for this characteristic.
 *
 * <p>If a remote device offers multiple characteristics with the same UUID,
 * the instance ID is used to distuinguish between characteristics.
 *
 * @return Instance ID of this characteristic
 * @apiSince 18
 */

public int getInstanceId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the properties of this characteristic.
 *
 * <p>The properties contain a bit mask of property flags indicating
 * the features of this characteristic.
 *
 * @return Properties of this characteristic
 * @apiSince 18
 */

public int getProperties() { throw new RuntimeException("Stub!"); }

/**
 * Returns the permissions for this characteristic.
 *
 * @return Permissions of this characteristic
 * @apiSince 18
 */

public int getPermissions() { throw new RuntimeException("Stub!"); }

/**
 * Gets the write type for this characteristic.
 *
 * @return Write type for this characteristic
 * @apiSince 18
 */

public int getWriteType() { throw new RuntimeException("Stub!"); }

/**
 * Set the write type for this characteristic
 *
 * <p>Setting the write type of a characteristic determines how the
 * {@link android.bluetooth.BluetoothGatt#writeCharacteristic BluetoothGatt#writeCharacteristic} function write this
 * characteristic.
 *
 * @param writeType The write type to for this characteristic. Can be one of: {@link
 * #WRITE_TYPE_DEFAULT}, {@link #WRITE_TYPE_NO_RESPONSE} or {@link #WRITE_TYPE_SIGNED}.
 * @apiSince 18
 */

public void setWriteType(int writeType) { throw new RuntimeException("Stub!"); }

/**
 * Returns a list of descriptors for this characteristic.
 *
 * @return Descriptors for this characteristic
 * @apiSince 18
 */

public java.util.List<android.bluetooth.BluetoothGattDescriptor> getDescriptors() { throw new RuntimeException("Stub!"); }

/**
 * Returns a descriptor with a given UUID out of the list of
 * descriptors for this characteristic.
 *
 * @return GATT descriptor object or null if no descriptor with the given UUID was found.
 * @apiSince 18
 */

public android.bluetooth.BluetoothGattDescriptor getDescriptor(java.util.UUID uuid) { throw new RuntimeException("Stub!"); }

/**
 * Get the stored value for this characteristic.
 *
 * <p>This function returns the stored value for this characteristic as
 * retrieved by calling {@link android.bluetooth.BluetoothGatt#readCharacteristic BluetoothGatt#readCharacteristic}. The cached
 * value of the characteristic is updated as a result of a read characteristic
 * operation or if a characteristic update notification has been received.
 *
 * @return Cached value of the characteristic
 * @apiSince 18
 */

public byte[] getValue() { throw new RuntimeException("Stub!"); }

/**
 * Return the stored value of this characteristic.
 *
 * <p>The formatType parameter determines how the characteristic value
 * is to be interpreted. For example, settting formatType to
 * {@link #FORMAT_UINT16} specifies that the first two bytes of the
 * characteristic value at the given offset are interpreted to generate the
 * return value.
 *
 * @param formatType The format type used to interpret the characteristic value.
 * @param offset Offset at which the integer value can be found.
 * @return Cached value of the characteristic or null of offset exceeds value size.
 * @apiSince 18
 */

public java.lang.Integer getIntValue(int formatType, int offset) { throw new RuntimeException("Stub!"); }

/**
 * Return the stored value of this characteristic.
 * <p>See {@link #getValue} for details.
 *
 * @param formatType The format type used to interpret the characteristic value.
 * @param offset Offset at which the float value can be found.
 * @return Cached value of the characteristic at a given offset or null if the requested offset
 * exceeds the value size.
 * @apiSince 18
 */

public java.lang.Float getFloatValue(int formatType, int offset) { throw new RuntimeException("Stub!"); }

/**
 * Return the stored value of this characteristic.
 * <p>See {@link #getValue} for details.
 *
 * @param offset Offset at which the string value can be found.
 * @return Cached value of the characteristic
 * @apiSince 18
 */

public java.lang.String getStringValue(int offset) { throw new RuntimeException("Stub!"); }

/**
 * Updates the locally stored value of this characteristic.
 *
 * <p>This function modifies the locally stored cached value of this
 * characteristic. To send the value to the remote device, call
 * {@link android.bluetooth.BluetoothGatt#writeCharacteristic BluetoothGatt#writeCharacteristic} to send the value to the
 * remote device.
 *
 * @param value New value for this characteristic
 * @return true if the locally stored value has been set, false if the requested value could not
 * be stored locally.
 * @apiSince 18
 */

public boolean setValue(byte[] value) { throw new RuntimeException("Stub!"); }

/**
 * Set the locally stored value of this characteristic.
 * <p>See {@link #setValue(byte[])} for details.
 *
 * @param value New value for this characteristic
 * @param formatType Integer format type used to transform the value parameter
 * @param offset Offset at which the value should be placed
 * @return true if the locally stored value has been set
 * @apiSince 18
 */

public boolean setValue(int value, int formatType, int offset) { throw new RuntimeException("Stub!"); }

/**
 * Set the locally stored value of this characteristic.
 * <p>See {@link #setValue(byte[])} for details.
 *
 * @param mantissa Mantissa for this characteristic
 * @param exponent exponent value for this characteristic
 * @param formatType Float format type used to transform the value parameter
 * @param offset Offset at which the value should be placed
 * @return true if the locally stored value has been set
 * @apiSince 18
 */

public boolean setValue(int mantissa, int exponent, int formatType, int offset) { throw new RuntimeException("Stub!"); }

/**
 * Set the locally stored value of this characteristic.
 * <p>See {@link #setValue(byte[])} for details.
 *
 * @param value New value for this characteristic
 * @return true if the locally stored value has been set
 * @apiSince 18
 */

public boolean setValue(java.lang.String value) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.bluetooth.BluetoothGattCharacteristic> CREATOR;
static { CREATOR = null; }

/**
 * Characteristic value format type float (32-bit float)
 * @apiSince 18
 */

public static final int FORMAT_FLOAT = 52; // 0x34

/**
 * Characteristic value format type sfloat (16-bit float)
 * @apiSince 18
 */

public static final int FORMAT_SFLOAT = 50; // 0x32

/**
 * Characteristic value format type sint16
 * @apiSince 18
 */

public static final int FORMAT_SINT16 = 34; // 0x22

/**
 * Characteristic value format type sint32
 * @apiSince 18
 */

public static final int FORMAT_SINT32 = 36; // 0x24

/**
 * Characteristic value format type sint8
 * @apiSince 18
 */

public static final int FORMAT_SINT8 = 33; // 0x21

/**
 * Characteristic value format type uint16
 * @apiSince 18
 */

public static final int FORMAT_UINT16 = 18; // 0x12

/**
 * Characteristic value format type uint32
 * @apiSince 18
 */

public static final int FORMAT_UINT32 = 20; // 0x14

/**
 * Characteristic value format type uint8
 * @apiSince 18
 */

public static final int FORMAT_UINT8 = 17; // 0x11

/**
 * Characteristic read permission
 * @apiSince 18
 */

public static final int PERMISSION_READ = 1; // 0x1

/**
 * Characteristic permission: Allow encrypted read operations
 * @apiSince 18
 */

public static final int PERMISSION_READ_ENCRYPTED = 2; // 0x2

/**
 * Characteristic permission: Allow reading with man-in-the-middle protection
 * @apiSince 18
 */

public static final int PERMISSION_READ_ENCRYPTED_MITM = 4; // 0x4

/**
 * Characteristic write permission
 * @apiSince 18
 */

public static final int PERMISSION_WRITE = 16; // 0x10

/**
 * Characteristic permission: Allow encrypted writes
 * @apiSince 18
 */

public static final int PERMISSION_WRITE_ENCRYPTED = 32; // 0x20

/**
 * Characteristic permission: Allow encrypted writes with man-in-the-middle
 * protection
 * @apiSince 18
 */

public static final int PERMISSION_WRITE_ENCRYPTED_MITM = 64; // 0x40

/**
 * Characteristic permission: Allow signed write operations
 * @apiSince 18
 */

public static final int PERMISSION_WRITE_SIGNED = 128; // 0x80

/**
 * Characteristic permission: Allow signed write operations with
 * man-in-the-middle protection
 * @apiSince 18
 */

public static final int PERMISSION_WRITE_SIGNED_MITM = 256; // 0x100

/**
 * Characteristic proprty: Characteristic is broadcastable.
 * @apiSince 18
 */

public static final int PROPERTY_BROADCAST = 1; // 0x1

/**
 * Characteristic property: Characteristic has extended properties
 * @apiSince 18
 */

public static final int PROPERTY_EXTENDED_PROPS = 128; // 0x80

/**
 * Characteristic property: Characteristic supports indication
 * @apiSince 18
 */

public static final int PROPERTY_INDICATE = 32; // 0x20

/**
 * Characteristic property: Characteristic supports notification
 * @apiSince 18
 */

public static final int PROPERTY_NOTIFY = 16; // 0x10

/**
 * Characteristic property: Characteristic is readable.
 * @apiSince 18
 */

public static final int PROPERTY_READ = 2; // 0x2

/**
 * Characteristic property: Characteristic supports write with signature
 * @apiSince 18
 */

public static final int PROPERTY_SIGNED_WRITE = 64; // 0x40

/**
 * Characteristic property: Characteristic can be written.
 * @apiSince 18
 */

public static final int PROPERTY_WRITE = 8; // 0x8

/**
 * Characteristic property: Characteristic can be written without response.
 * @apiSince 18
 */

public static final int PROPERTY_WRITE_NO_RESPONSE = 4; // 0x4

/**
 * Write characteristic, requesting acknoledgement by the remote device
 * @apiSince 18
 */

public static final int WRITE_TYPE_DEFAULT = 2; // 0x2

/**
 * Write characteristic without requiring a response by the remote device
 * @apiSince 18
 */

public static final int WRITE_TYPE_NO_RESPONSE = 1; // 0x1

/**
 * Write characteristic including authentication signature
 * @apiSince 18
 */

public static final int WRITE_TYPE_SIGNED = 4; // 0x4

/**
 * List of descriptors included in this characteristic.
 * @apiSince 18
 */

protected java.util.List<android.bluetooth.BluetoothGattDescriptor> mDescriptors;
}

