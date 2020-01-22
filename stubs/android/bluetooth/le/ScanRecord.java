/*
 * Copyright (C) 2014 The Android Open Source Project
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


package android.bluetooth.le;


/**
 * Represents a scan record from Bluetooth LE scan.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ScanRecord {

private ScanRecord() { throw new RuntimeException("Stub!"); }

/**
 * Returns the advertising flags indicating the discoverable mode and capability of the device.
 * Returns -1 if the flag field is not set.
 * @apiSince 21
 */

public int getAdvertiseFlags() { throw new RuntimeException("Stub!"); }

/**
 * Returns a list of service UUIDs within the advertisement that are used to identify the
 * bluetooth GATT services.
 * @apiSince 21
 */

public java.util.List<android.os.ParcelUuid> getServiceUuids() { throw new RuntimeException("Stub!"); }

/**
 * Returns a list of service solicitation UUIDs within the advertisement that are used to
 * identify the Bluetooth GATT services.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.util.List<android.os.ParcelUuid> getServiceSolicitationUuids() { throw new RuntimeException("Stub!"); }

/**
 * Returns a sparse array of manufacturer identifier and its corresponding manufacturer specific
 * data.
 * @apiSince 21
 */

public android.util.SparseArray<byte[]> getManufacturerSpecificData() { throw new RuntimeException("Stub!"); }

/**
 * Returns the manufacturer specific data associated with the manufacturer id. Returns
 * {@code null} if the {@code manufacturerId} is not found.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public byte[] getManufacturerSpecificData(int manufacturerId) { throw new RuntimeException("Stub!"); }

/**
 * Returns a map of service UUID and its corresponding service data.
 * @apiSince 21
 */

public java.util.Map<android.os.ParcelUuid,byte[]> getServiceData() { throw new RuntimeException("Stub!"); }

/**
 * Returns the service data byte array associated with the {@code serviceUuid}. Returns
 * {@code null} if the {@code serviceDataUuid} is not found.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public byte[] getServiceData(android.os.ParcelUuid serviceDataUuid) { throw new RuntimeException("Stub!"); }

/**
 * Returns the transmission power level of the packet in dBm. Returns {@link java.lang.Integer#MIN_VALUE Integer#MIN_VALUE}
 * if the field is not set. This value can be used to calculate the path loss of a received
 * packet using the following equation:
 * <p>
 * <code>pathloss = txPowerLevel - rssi</code>
 * @apiSince 21
 */

public int getTxPowerLevel() { throw new RuntimeException("Stub!"); }

/**
 * Returns the local name of the BLE device. This is a UTF-8 encoded string.
 
 * @return This value may be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public java.lang.String getDeviceName() { throw new RuntimeException("Stub!"); }

/**
 * Returns raw bytes of scan record.
 * @apiSince 21
 */

public byte[] getBytes() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

