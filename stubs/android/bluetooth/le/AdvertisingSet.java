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


package android.bluetooth.le;

import android.bluetooth.BluetoothAdapter;

/**
 * This class provides a way to control single Bluetooth LE advertising instance.
 * <p>
 * To get an instance of {@link android.bluetooth.le.AdvertisingSet AdvertisingSet}, call the
 * {@link android.bluetooth.le.BluetoothLeAdvertiser#startAdvertisingSet BluetoothLeAdvertiser#startAdvertisingSet} method.
 * <p>
 * <b>Note:</b> Most of the methods here require {@link android.Manifest.permission#BLUETOOTH_ADMIN}
 * permission.
 *
 * @see android.bluetooth.le.AdvertiseData
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class AdvertisingSet {

AdvertisingSet() { throw new RuntimeException("Stub!"); }

/**
 * Enables Advertising. This method returns immediately, the operation status is
 * delivered through {@code callback.onAdvertisingEnabled()}.
 * <p>
 * Requires {@link android.Manifest.permission#BLUETOOTH_ADMIN}
 *
 * @param enable whether the advertising should be enabled (true), or disabled (false)
 * @param duration advertising duration, in 10ms unit. Valid range is from 1 (10ms) to 65535
 * (655,350 ms)
 * @param maxExtendedAdvertisingEvents maximum number of extended advertising events the
 * controller shall attempt to send prior to terminating the extended advertising, even if the
 * duration has not expired. Valid range is from 1 to 255.
 * @apiSince 26
 */

public void enableAdvertising(boolean enable, int duration, int maxExtendedAdvertisingEvents) { throw new RuntimeException("Stub!"); }

/**
 * Set/update data being Advertised. Make sure that data doesn't exceed the size limit for
 * specified AdvertisingSetParameters. This method returns immediately, the operation status is
 * delivered through {@code callback.onAdvertisingDataSet()}.
 * <p>
 * Advertising data must be empty if non-legacy scannable advertising is used.
 *
 * @param advertiseData Advertisement data to be broadcasted. Size must not exceed {@link android.bluetooth.BluetoothAdapter#getLeMaximumAdvertisingDataLength BluetoothAdapter#getLeMaximumAdvertisingDataLength}. If the advertisement is connectable,
 * three bytes will be added for flags. If the update takes place when the advertising set is
 * enabled, the data can be maximum 251 bytes long.
 * @apiSince 26
 */

public void setAdvertisingData(android.bluetooth.le.AdvertiseData advertiseData) { throw new RuntimeException("Stub!"); }

/**
 * Set/update scan response data. Make sure that data doesn't exceed the size limit for
 * specified AdvertisingSetParameters. This method returns immediately, the operation status
 * is delivered through {@code callback.onScanResponseDataSet()}.
 *
 * @param scanResponse Scan response associated with the advertisement data. Size must not
 * exceed {@link android.bluetooth.BluetoothAdapter#getLeMaximumAdvertisingDataLength BluetoothAdapter#getLeMaximumAdvertisingDataLength}. If the update takes place
 * when the advertising set is enabled, the data can be maximum 251 bytes long.
 * @apiSince 26
 */

public void setScanResponseData(android.bluetooth.le.AdvertiseData scanResponse) { throw new RuntimeException("Stub!"); }

/**
 * Update advertising parameters associated with this AdvertisingSet. Must be called when
 * advertising is not active. This method returns immediately, the operation status is delivered
 * through {@code callback.onAdvertisingParametersUpdated}.
 *
 * @param parameters advertising set parameters.
 * @apiSince 26
 */

public void setAdvertisingParameters(android.bluetooth.le.AdvertisingSetParameters parameters) { throw new RuntimeException("Stub!"); }

/**
 * Update periodic advertising parameters associated with this set. Must be called when
 * periodic advertising is not enabled. This method returns immediately, the operation
 * status is delivered through {@code callback.onPeriodicAdvertisingParametersUpdated()}.
 * @apiSince 26
 */

public void setPeriodicAdvertisingParameters(android.bluetooth.le.PeriodicAdvertisingParameters parameters) { throw new RuntimeException("Stub!"); }

/**
 * Used to set periodic advertising data, must be called after setPeriodicAdvertisingParameters,
 * or after advertising was started with periodic advertising data set. This method returns
 * immediately, the operation status is delivered through
 * {@code callback.onPeriodicAdvertisingDataSet()}.
 *
 * @param periodicData Periodic advertising data. Size must not exceed {@link android.bluetooth.BluetoothAdapter#getLeMaximumAdvertisingDataLength BluetoothAdapter#getLeMaximumAdvertisingDataLength}. If the update takes place when the
 * periodic advertising is enabled for this set, the data can be maximum 251 bytes long.
 * @apiSince 26
 */

public void setPeriodicAdvertisingData(android.bluetooth.le.AdvertiseData periodicData) { throw new RuntimeException("Stub!"); }

/**
 * Used to enable/disable periodic advertising. This method returns immediately, the operation
 * status is delivered through {@code callback.onPeriodicAdvertisingEnable()}.
 *
 * @param enable whether the periodic advertising should be enabled (true), or disabled
 * (false).
 * @apiSince 26
 */

public void setPeriodicAdvertisingEnabled(boolean enable) { throw new RuntimeException("Stub!"); }
}

