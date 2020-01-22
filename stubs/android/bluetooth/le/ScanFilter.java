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

import android.os.Parcelable;
import android.bluetooth.BluetoothAdapter;

/**
 * Criteria for filtering result from Bluetooth LE scans. A {@link android.bluetooth.le.ScanFilter ScanFilter} allows clients to
 * restrict scan results to only those that are of interest to them.
 * <p>
 * Current filtering on the following fields are supported:
 * <li>Service UUIDs which identify the bluetooth gatt services running on the device.
 * <li>Name of remote Bluetooth LE device.
 * <li>Mac address of the remote device.
 * <li>Service data which is the data associated with a service.
 * <li>Manufacturer specific data which is the data associated with a particular manufacturer.
 *
 * @see android.bluetooth.le.ScanResult
 * @see android.bluetooth.le.BluetoothLeScanner
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ScanFilter implements android.os.Parcelable {

private ScanFilter() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Returns the filter set the device name field of Bluetooth advertisement data.
 
 * @return This value may be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public java.lang.String getDeviceName() { throw new RuntimeException("Stub!"); }

/**
 * Returns the filter set on the service uuid.
 
 * @return This value may be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public android.os.ParcelUuid getServiceUuid() { throw new RuntimeException("Stub!"); }

/**
 * @return This value may be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public android.os.ParcelUuid getServiceUuidMask() { throw new RuntimeException("Stub!"); }

/**
 * Returns the filter set on the service Solicitation uuid.
 
 * @return This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.os.ParcelUuid getServiceSolicitationUuid() { throw new RuntimeException("Stub!"); }

/**
 * Returns the filter set on the service Solicitation uuid mask.
 
 * @return This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.os.ParcelUuid getServiceSolicitationUuidMask() { throw new RuntimeException("Stub!"); }

/**
 * @return This value may be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public java.lang.String getDeviceAddress() { throw new RuntimeException("Stub!"); }

/**
 * @return This value may be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public byte[] getServiceData() { throw new RuntimeException("Stub!"); }

/**
 * @return This value may be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public byte[] getServiceDataMask() { throw new RuntimeException("Stub!"); }

/**
 * @return This value may be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public android.os.ParcelUuid getServiceDataUuid() { throw new RuntimeException("Stub!"); }

/**
 * Returns the manufacturer id. -1 if the manufacturer filter is not set.
 * @apiSince 21
 */

public int getManufacturerId() { throw new RuntimeException("Stub!"); }

/**
 * @return This value may be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public byte[] getManufacturerData() { throw new RuntimeException("Stub!"); }

/**
 * @return This value may be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public byte[] getManufacturerDataMask() { throw new RuntimeException("Stub!"); }

/**
 * Check if the scan filter matches a {@code scanResult}. A scan result is considered as a match
 * if it matches all the field filters.
 * @apiSince 21
 */

public boolean matches(android.bluetooth.le.ScanResult scanResult) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * A {@link android.os.Parcelable.Creator} to create {@link android.bluetooth.le.ScanFilter ScanFilter} from parcel.
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.bluetooth.le.ScanFilter> CREATOR;
static { CREATOR = null; }
/**
 * Builder class for {@link android.bluetooth.le.ScanFilter ScanFilter}.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Set filter on device name.
 * @apiSince 21
 */

public android.bluetooth.le.ScanFilter.Builder setDeviceName(java.lang.String deviceName) { throw new RuntimeException("Stub!"); }

/**
 * Set filter on device address.
 *
 * @param deviceAddress The device Bluetooth address for the filter. It needs to be in the
 * format of "01:02:03:AB:CD:EF". The device address can be validated using {@link android.bluetooth.BluetoothAdapter#checkBluetoothAddress BluetoothAdapter#checkBluetoothAddress}.
 * @throws java.lang.IllegalArgumentException If the {@code deviceAddress} is invalid.
 * @apiSince 21
 */

public android.bluetooth.le.ScanFilter.Builder setDeviceAddress(java.lang.String deviceAddress) { throw new RuntimeException("Stub!"); }

/**
 * Set filter on service uuid.
 * @apiSince 21
 */

public android.bluetooth.le.ScanFilter.Builder setServiceUuid(android.os.ParcelUuid serviceUuid) { throw new RuntimeException("Stub!"); }

/**
 * Set filter on partial service uuid. The {@code uuidMask} is the bit mask for the
 * {@code serviceUuid}. Set any bit in the mask to 1 to indicate a match is needed for the
 * bit in {@code serviceUuid}, and 0 to ignore that bit.
 *
 * @throws java.lang.IllegalArgumentException If {@code serviceUuid} is {@code null} but {@code
 * uuidMask} is not {@code null}.
 * @apiSince 21
 */

public android.bluetooth.le.ScanFilter.Builder setServiceUuid(android.os.ParcelUuid serviceUuid, android.os.ParcelUuid uuidMask) { throw new RuntimeException("Stub!"); }

/**
 * Set filter on service solicitation uuid.
 
 * @param serviceSolicitationUuid This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.bluetooth.le.ScanFilter.Builder setServiceSolicitationUuid(@androidx.annotation.Nullable android.os.ParcelUuid serviceSolicitationUuid) { throw new RuntimeException("Stub!"); }

/**
 * Set filter on partial service Solicitation uuid. The {@code SolicitationUuidMask} is the
 * bit mask for the {@code serviceSolicitationUuid}. Set any bit in the mask to 1 to
 * indicate a match is needed for the bit in {@code serviceSolicitationUuid}, and 0 to
 * ignore that bit.
 *
 * @param serviceSolicitationUuid can only be null if solicitationUuidMask is null.
 * This value may be {@code null}.
 * @param solicitationUuidMask can be null or a mask with no restriction.
 *
 * This value may be {@code null}.
 * @throws java.lang.IllegalArgumentException If {@code serviceSolicitationUuid} is {@code null} but
 *             {@code serviceSolicitationUuidMask} is not {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.bluetooth.le.ScanFilter.Builder setServiceSolicitationUuid(@androidx.annotation.Nullable android.os.ParcelUuid serviceSolicitationUuid, @androidx.annotation.Nullable android.os.ParcelUuid solicitationUuidMask) { throw new RuntimeException("Stub!"); }

/**
 * Set filtering on service data.
 *
 * @throws java.lang.IllegalArgumentException If {@code serviceDataUuid} is null.
 * @apiSince 21
 */

public android.bluetooth.le.ScanFilter.Builder setServiceData(android.os.ParcelUuid serviceDataUuid, byte[] serviceData) { throw new RuntimeException("Stub!"); }

/**
 * Set partial filter on service data. For any bit in the mask, set it to 1 if it needs to
 * match the one in service data, otherwise set it to 0 to ignore that bit.
 * <p>
 * The {@code serviceDataMask} must have the same length of the {@code serviceData}.
 *
 * @throws java.lang.IllegalArgumentException If {@code serviceDataUuid} is null or {@code
 * serviceDataMask} is {@code null} while {@code serviceData} is not or {@code
 * serviceDataMask} and {@code serviceData} has different length.
 * @apiSince 21
 */

public android.bluetooth.le.ScanFilter.Builder setServiceData(android.os.ParcelUuid serviceDataUuid, byte[] serviceData, byte[] serviceDataMask) { throw new RuntimeException("Stub!"); }

/**
 * Set filter on on manufacturerData. A negative manufacturerId is considered as invalid id.
 * <p>
 * Note the first two bytes of the {@code manufacturerData} is the manufacturerId.
 *
 * @throws java.lang.IllegalArgumentException If the {@code manufacturerId} is invalid.
 * @apiSince 21
 */

public android.bluetooth.le.ScanFilter.Builder setManufacturerData(int manufacturerId, byte[] manufacturerData) { throw new RuntimeException("Stub!"); }

/**
 * Set filter on partial manufacture data. For any bit in the mask, set it the 1 if it needs
 * to match the one in manufacturer data, otherwise set it to 0.
 * <p>
 * The {@code manufacturerDataMask} must have the same length of {@code manufacturerData}.
 *
 * @throws java.lang.IllegalArgumentException If the {@code manufacturerId} is invalid, or {@code
 * manufacturerData} is null while {@code manufacturerDataMask} is not, or {@code
 * manufacturerData} and {@code manufacturerDataMask} have different length.
 * @apiSince 21
 */

public android.bluetooth.le.ScanFilter.Builder setManufacturerData(int manufacturerId, byte[] manufacturerData, byte[] manufacturerDataMask) { throw new RuntimeException("Stub!"); }

/**
 * Build {@link android.bluetooth.le.ScanFilter ScanFilter}.
 *
 * @throws java.lang.IllegalArgumentException If the filter cannot be built.
 * @apiSince 21
 */

public android.bluetooth.le.ScanFilter build() { throw new RuntimeException("Stub!"); }
}

}

