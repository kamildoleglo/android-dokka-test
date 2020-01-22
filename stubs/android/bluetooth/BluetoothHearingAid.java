/*
 * Copyright 2018 The Android Open Source Project
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

import android.Manifest;

/**
 * This class provides the public APIs to control the Hearing Aid profile.
 *
 * <p>BluetoothHearingAid is a proxy object for controlling the Bluetooth Hearing Aid
 * Service via IPC. Use {@link android.bluetooth.BluetoothAdapter#getProfileProxy BluetoothAdapter#getProfileProxy} to get
 * the BluetoothHearingAid proxy object.
 *
 * <p> Android only supports one set of connected Bluetooth Hearing Aid device at a time. Each
 * method is protected with its appropriate permission.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class BluetoothHearingAid implements android.bluetooth.BluetoothProfile {

BluetoothHearingAid() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.util.List<android.bluetooth.BluetoothDevice> getConnectedDevices() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param states This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.util.List<android.bluetooth.BluetoothDevice> getDevicesMatchingConnectionStates(@androidx.annotation.NonNull int[] states) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param device This value must never be {@code null}.
 * @return Value is {@link android.bluetooth.BluetoothProfile#STATE_DISCONNECTED}, {@link android.bluetooth.BluetoothProfile#STATE_CONNECTING}, {@link android.bluetooth.BluetoothProfile#STATE_CONNECTED}, or {@link android.bluetooth.BluetoothProfile#STATE_DISCONNECTING}
 * @apiSince 29
 */

public int getConnectionState(@androidx.annotation.NonNull android.bluetooth.BluetoothDevice device) { throw new RuntimeException("Stub!"); }

/**
 * Intent used to broadcast the change in connection state of the Hearing Aid
 * profile. Please note that in the binaural case, there will be two different LE devices for
 * the left and right side and each device will have their own connection state changes.S
 *
 * <p>This intent will have 3 extras:
 * <ul>
 * <li> {@link #EXTRA_STATE} - The current state of the profile. </li>
 * <li> {@link #EXTRA_PREVIOUS_STATE}- The previous state of the profile.</li>
 * <li> {@link android.bluetooth.BluetoothDevice#EXTRA_DEVICE BluetoothDevice#EXTRA_DEVICE} - The remote device. </li>
 * </ul>
 *
 * <p>{@link #EXTRA_STATE} or {@link #EXTRA_PREVIOUS_STATE} can be any of
 * {@link #STATE_DISCONNECTED}, {@link #STATE_CONNECTING},
 * {@link #STATE_CONNECTED}, {@link #STATE_DISCONNECTING}.
 *
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission to
 * receive.
 * @apiSince 29
 */

public static final java.lang.String ACTION_CONNECTION_STATE_CHANGED = "android.bluetooth.hearingaid.profile.action.CONNECTION_STATE_CHANGED";
}

