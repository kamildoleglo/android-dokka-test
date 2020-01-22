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

import android.bluetooth.BluetoothAdapter;

/**
 * This class provides a way to perform Bluetooth LE advertise operations, such as starting and
 * stopping advertising. An advertiser can broadcast up to 31 bytes of advertisement data
 * represented by {@link android.bluetooth.le.AdvertiseData AdvertiseData}.
 * <p>
 * To get an instance of {@link android.bluetooth.le.BluetoothLeAdvertiser BluetoothLeAdvertiser}, call the
 * {@link android.bluetooth.BluetoothAdapter#getBluetoothLeAdvertiser() BluetoothAdapter#getBluetoothLeAdvertiser()} method.
 * <p>
 * <b>Note:</b> Most of the methods here require {@link android.Manifest.permission#BLUETOOTH_ADMIN}
 * permission.
 *
 * @see android.bluetooth.le.AdvertiseData
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class BluetoothLeAdvertiser {

BluetoothLeAdvertiser() { throw new RuntimeException("Stub!"); }

/**
 * Start Bluetooth LE Advertising. On success, the {@code advertiseData} will be broadcasted.
 * Returns immediately, the operation status is delivered through {@code callback}.
 * <p>
 * Requires {@link android.Manifest.permission#BLUETOOTH_ADMIN} permission.
 *
 * @param settings Settings for Bluetooth LE advertising.
 * @param advertiseData Advertisement data to be broadcasted.
 * @param callback Callback for advertising status.
 * @apiSince 21
 */

public void startAdvertising(android.bluetooth.le.AdvertiseSettings settings, android.bluetooth.le.AdvertiseData advertiseData, android.bluetooth.le.AdvertiseCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Start Bluetooth LE Advertising. The {@code advertiseData} will be broadcasted if the
 * operation succeeds. The {@code scanResponse} is returned when a scanning device sends an
 * active scan request. This method returns immediately, the operation status is delivered
 * through {@code callback}.
 * <p>
 * Requires {@link android.Manifest.permission#BLUETOOTH_ADMIN}
 *
 * @param settings Settings for Bluetooth LE advertising.
 * @param advertiseData Advertisement data to be advertised in advertisement packet.
 * @param scanResponse Scan response associated with the advertisement data.
 * @param callback Callback for advertising status.
 * @apiSince 21
 */

public void startAdvertising(android.bluetooth.le.AdvertiseSettings settings, android.bluetooth.le.AdvertiseData advertiseData, android.bluetooth.le.AdvertiseData scanResponse, android.bluetooth.le.AdvertiseCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Stop Bluetooth LE advertising. The {@code callback} must be the same one use in
 * {@link android.bluetooth.le.BluetoothLeAdvertiser#startAdvertising BluetoothLeAdvertiser#startAdvertising}.
 * <p>
 * Requires {@link android.Manifest.permission#BLUETOOTH_ADMIN} permission.
 *
 * @param callback {@link android.bluetooth.le.AdvertiseCallback AdvertiseCallback} identifies the advertising instance to stop.
 * @apiSince 21
 */

public void stopAdvertising(android.bluetooth.le.AdvertiseCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new advertising set. If operation succeed, device will start advertising. This
 * method returns immediately, the operation status is delivered through
 * {@code callback.onAdvertisingSetStarted()}.
 * <p>
 *
 * @param parameters advertising set parameters.
 * @param advertiseData Advertisement data to be broadcasted. Size must not exceed {@link android.bluetooth.BluetoothAdapter#getLeMaximumAdvertisingDataLength BluetoothAdapter#getLeMaximumAdvertisingDataLength}. If the advertisement is connectable,
 * three bytes will be added for flags.
 * @param scanResponse Scan response associated with the advertisement data. Size must not
 * exceed {@link android.bluetooth.BluetoothAdapter#getLeMaximumAdvertisingDataLength BluetoothAdapter#getLeMaximumAdvertisingDataLength}.
 * @param periodicParameters periodic advertisng parameters. If null, periodic advertising will
 * not be started.
 * @param periodicData Periodic advertising data. Size must not exceed {@link android.bluetooth.BluetoothAdapter#getLeMaximumAdvertisingDataLength BluetoothAdapter#getLeMaximumAdvertisingDataLength}.
 * @param callback Callback for advertising set.
 * @throws java.lang.IllegalArgumentException when any of the data parameter exceed the maximum allowable
 * size, or unsupported advertising PHY is selected, or when attempt to use Periodic Advertising
 * feature is made when it's not supported by the controller.
 * @apiSince 26
 */

public void startAdvertisingSet(android.bluetooth.le.AdvertisingSetParameters parameters, android.bluetooth.le.AdvertiseData advertiseData, android.bluetooth.le.AdvertiseData scanResponse, android.bluetooth.le.PeriodicAdvertisingParameters periodicParameters, android.bluetooth.le.AdvertiseData periodicData, android.bluetooth.le.AdvertisingSetCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new advertising set. If operation succeed, device will start advertising. This
 * method returns immediately, the operation status is delivered through
 * {@code callback.onAdvertisingSetStarted()}.
 * <p>
 *
 * @param parameters advertising set parameters.
 * @param advertiseData Advertisement data to be broadcasted. Size must not exceed {@link android.bluetooth.BluetoothAdapter#getLeMaximumAdvertisingDataLength BluetoothAdapter#getLeMaximumAdvertisingDataLength}. If the advertisement is connectable,
 * three bytes will be added for flags.
 * @param scanResponse Scan response associated with the advertisement data. Size must not
 * exceed {@link android.bluetooth.BluetoothAdapter#getLeMaximumAdvertisingDataLength BluetoothAdapter#getLeMaximumAdvertisingDataLength}.
 * @param periodicParameters periodic advertisng parameters. If null, periodic advertising will
 * not be started.
 * @param periodicData Periodic advertising data. Size must not exceed {@link android.bluetooth.BluetoothAdapter#getLeMaximumAdvertisingDataLength BluetoothAdapter#getLeMaximumAdvertisingDataLength}.
 * @param callback Callback for advertising set.
 * @param handler thread upon which the callbacks will be invoked.
 * @throws java.lang.IllegalArgumentException when any of the data parameter exceed the maximum allowable
 * size, or unsupported advertising PHY is selected, or when attempt to use Periodic Advertising
 * feature is made when it's not supported by the controller.
 * @apiSince 26
 */

public void startAdvertisingSet(android.bluetooth.le.AdvertisingSetParameters parameters, android.bluetooth.le.AdvertiseData advertiseData, android.bluetooth.le.AdvertiseData scanResponse, android.bluetooth.le.PeriodicAdvertisingParameters periodicParameters, android.bluetooth.le.AdvertiseData periodicData, android.bluetooth.le.AdvertisingSetCallback callback, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new advertising set. If operation succeed, device will start advertising. This
 * method returns immediately, the operation status is delivered through
 * {@code callback.onAdvertisingSetStarted()}.
 * <p>
 *
 * @param parameters advertising set parameters.
 * @param advertiseData Advertisement data to be broadcasted. Size must not exceed {@link android.bluetooth.BluetoothAdapter#getLeMaximumAdvertisingDataLength BluetoothAdapter#getLeMaximumAdvertisingDataLength}. If the advertisement is connectable,
 * three bytes will be added for flags.
 * @param scanResponse Scan response associated with the advertisement data. Size must not
 * exceed {@link android.bluetooth.BluetoothAdapter#getLeMaximumAdvertisingDataLength BluetoothAdapter#getLeMaximumAdvertisingDataLength}.
 * @param periodicParameters periodic advertisng parameters. If null, periodic advertising will
 * not be started.
 * @param periodicData Periodic advertising data. Size must not exceed {@link android.bluetooth.BluetoothAdapter#getLeMaximumAdvertisingDataLength BluetoothAdapter#getLeMaximumAdvertisingDataLength}.
 * @param duration advertising duration, in 10ms unit. Valid range is from 1 (10ms) to 65535
 * (655,350 ms). 0 means advertising should continue until stopped.
 * @param maxExtendedAdvertisingEvents maximum number of extended advertising events the
 * controller shall attempt to send prior to terminating the extended advertising, even if the
 * duration has not expired. Valid range is from 1 to 255. 0 means no maximum.
 * @param callback Callback for advertising set.
 * @throws java.lang.IllegalArgumentException when any of the data parameter exceed the maximum allowable
 * size, or unsupported advertising PHY is selected, or when attempt to use Periodic Advertising
 * feature is made when it's not supported by the controller.
 * @apiSince 26
 */

public void startAdvertisingSet(android.bluetooth.le.AdvertisingSetParameters parameters, android.bluetooth.le.AdvertiseData advertiseData, android.bluetooth.le.AdvertiseData scanResponse, android.bluetooth.le.PeriodicAdvertisingParameters periodicParameters, android.bluetooth.le.AdvertiseData periodicData, int duration, int maxExtendedAdvertisingEvents, android.bluetooth.le.AdvertisingSetCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new advertising set. If operation succeed, device will start advertising. This
 * method returns immediately, the operation status is delivered through
 * {@code callback.onAdvertisingSetStarted()}.
 * <p>
 *
 * @param parameters Advertising set parameters.
 * @param advertiseData Advertisement data to be broadcasted. Size must not exceed {@link android.bluetooth.BluetoothAdapter#getLeMaximumAdvertisingDataLength BluetoothAdapter#getLeMaximumAdvertisingDataLength}. If the advertisement is connectable,
 * three bytes will be added for flags.
 * @param scanResponse Scan response associated with the advertisement data. Size must not
 * exceed {@link android.bluetooth.BluetoothAdapter#getLeMaximumAdvertisingDataLength BluetoothAdapter#getLeMaximumAdvertisingDataLength}
 * @param periodicParameters Periodic advertisng parameters. If null, periodic advertising will
 * not be started.
 * @param periodicData Periodic advertising data. Size must not exceed {@link android.bluetooth.BluetoothAdapter#getLeMaximumAdvertisingDataLength BluetoothAdapter#getLeMaximumAdvertisingDataLength}
 * @param duration advertising duration, in 10ms unit. Valid range is from 1 (10ms) to 65535
 * (655,350 ms). 0 means advertising should continue until stopped.
 * @param maxExtendedAdvertisingEvents maximum number of extended advertising events the
 * controller shall attempt to send prior to terminating the extended advertising, even if the
 * duration has not expired. Valid range is from 1 to 255. 0 means no maximum.
 * @param callback Callback for advertising set.
 * @param handler Thread upon which the callbacks will be invoked.
 * @throws java.lang.IllegalArgumentException When any of the data parameter exceed the maximum allowable
 * size, or unsupported advertising PHY is selected, or when attempt to use Periodic Advertising
 * feature is made when it's not supported by the controller, or when
 * maxExtendedAdvertisingEvents is used on a controller that doesn't support the LE Extended
 * Advertising
 * @apiSince 26
 */

public void startAdvertisingSet(android.bluetooth.le.AdvertisingSetParameters parameters, android.bluetooth.le.AdvertiseData advertiseData, android.bluetooth.le.AdvertiseData scanResponse, android.bluetooth.le.PeriodicAdvertisingParameters periodicParameters, android.bluetooth.le.AdvertiseData periodicData, int duration, int maxExtendedAdvertisingEvents, android.bluetooth.le.AdvertisingSetCallback callback, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Used to dispose of a {@link android.bluetooth.le.AdvertisingSet AdvertisingSet} object, obtained with {@link android.bluetooth.le.BluetoothLeAdvertiser#startAdvertisingSet BluetoothLeAdvertiser#startAdvertisingSet}.
 * @apiSince 26
 */

public void stopAdvertisingSet(android.bluetooth.le.AdvertisingSetCallback callback) { throw new RuntimeException("Stub!"); }
}

