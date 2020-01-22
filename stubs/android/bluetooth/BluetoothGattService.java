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
 * Represents a Bluetooth GATT Service
 *
 * <p> Gatt Service contains a collection of {@link android.bluetooth.BluetoothGattCharacteristic BluetoothGattCharacteristic},
 * as well as referenced services.
 * @apiSince 18
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class BluetoothGattService implements android.os.Parcelable {

/**
 * Create a new BluetoothGattService.
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
 *
 * @param uuid The UUID for this service
 * @param serviceType The type of this service,
 * {@link android.bluetooth.BluetoothGattService#SERVICE_TYPE_PRIMARY BluetoothGattService#SERVICE_TYPE_PRIMARY}
 * or {@link android.bluetooth.BluetoothGattService#SERVICE_TYPE_SECONDARY BluetoothGattService#SERVICE_TYPE_SECONDARY}
 * @apiSince 18
 */

public BluetoothGattService(java.util.UUID uuid, int serviceType) { throw new RuntimeException("Stub!"); }

/**
 * @hide
 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Add an included service to this service.
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
 *
 * @param service The service to be added
 * @return true, if the included service was added to the service
 * @apiSince 18
 */

public boolean addService(android.bluetooth.BluetoothGattService service) { throw new RuntimeException("Stub!"); }

/**
 * Add a characteristic to this service.
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
 *
 * @param characteristic The characteristics to be added
 * @return true, if the characteristic was added to the service
 * @apiSince 18
 */

public boolean addCharacteristic(android.bluetooth.BluetoothGattCharacteristic characteristic) { throw new RuntimeException("Stub!"); }

/**
 * Returns the UUID of this service
 *
 * @return UUID of this service
 * @apiSince 18
 */

public java.util.UUID getUuid() { throw new RuntimeException("Stub!"); }

/**
 * Returns the instance ID for this service
 *
 * <p>If a remote device offers multiple services with the same UUID
 * (ex. multiple battery services for different batteries), the instance
 * ID is used to distuinguish services.
 *
 * @return Instance ID of this service
 * @apiSince 18
 */

public int getInstanceId() { throw new RuntimeException("Stub!"); }

/**
 * Get the type of this service (primary/secondary)
 * @apiSince 18
 */

public int getType() { throw new RuntimeException("Stub!"); }

/**
 * Get the list of included GATT services for this service.
 *
 * @return List of included services or empty list if no included services were discovered.
 * @apiSince 18
 */

public java.util.List<android.bluetooth.BluetoothGattService> getIncludedServices() { throw new RuntimeException("Stub!"); }

/**
 * Returns a list of characteristics included in this service.
 *
 * @return Characteristics included in this service
 * @apiSince 18
 */

public java.util.List<android.bluetooth.BluetoothGattCharacteristic> getCharacteristics() { throw new RuntimeException("Stub!"); }

/**
 * Returns a characteristic with a given UUID out of the list of
 * characteristics offered by this service.
 *
 * <p>This is a convenience function to allow access to a given characteristic
 * without enumerating over the list returned by {@link #getCharacteristics}
 * manually.
 *
 * <p>If a remote service offers multiple characteristics with the same
 * UUID, the first instance of a characteristic with the given UUID
 * is returned.
 *
 * @return GATT characteristic object or null if no characteristic with the given UUID was
 * found.
 * @apiSince 18
 */

public android.bluetooth.BluetoothGattCharacteristic getCharacteristic(java.util.UUID uuid) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.bluetooth.BluetoothGattService> CREATOR;
static { CREATOR = null; }

/**
 * Primary service
 * @apiSince 18
 */

public static final int SERVICE_TYPE_PRIMARY = 0; // 0x0

/**
 * Secondary service (included by primary services)
 * @apiSince 18
 */

public static final int SERVICE_TYPE_SECONDARY = 1; // 0x1

/**
 * List of characteristics included in this service.
 * @apiSince 18
 */

protected java.util.List<android.bluetooth.BluetoothGattCharacteristic> mCharacteristics;

/**
 * List of included services for this service.
 * @apiSince 18
 */

protected java.util.List<android.bluetooth.BluetoothGattService> mIncludedServices;
}

