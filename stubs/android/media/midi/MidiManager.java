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


package android.media.midi;

import android.content.pm.PackageManager;
import android.os.Handler;
import android.bluetooth.BluetoothDevice;

/**
 * This class is the public application interface to the MIDI service.
 
 * <br>
 * Requires the {@link android.content.pm.PackageManager#FEATURE_MIDI PackageManager#FEATURE_MIDI} feature which can be detected using {@link android.content.pm.PackageManager#hasSystemFeature(String) PackageManager.hasSystemFeature(String)}.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class MidiManager {

MidiManager() { throw new RuntimeException("Stub!"); }

/**
 * Registers a callback to receive notifications when MIDI devices are added and removed.
 *
 * The {@link android.media.midi.MidiManager.DeviceCallback#onDeviceStatusChanged DeviceCallback#onDeviceStatusChanged} method will be called immediately
 * for any devices that have open ports. This allows applications to know which input
 * ports are already in use and, therefore, unavailable.
 *
 * Applications should call {@link #getDevices} before registering the callback
 * to get a list of devices already added.
 *
 * @param callback a {@link android.media.midi.MidiManager.DeviceCallback DeviceCallback} for MIDI device notifications
 * @param handler The {@link android.os.Handler Handler} that will be used for delivering the
 *                device notifications. If handler is null, then the thread used for the
 *                callback is unspecified.
 * @apiSince 23
 */

public void registerDeviceCallback(android.media.midi.MidiManager.DeviceCallback callback, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Unregisters a {@link android.media.midi.MidiManager.DeviceCallback DeviceCallback}.
 *
 * @param callback a {@link android.media.midi.MidiManager.DeviceCallback DeviceCallback} to unregister
 * @apiSince 23
 */

public void unregisterDeviceCallback(android.media.midi.MidiManager.DeviceCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Gets the list of all connected MIDI devices.
 *
 * @return an array of all MIDI devices
 * @apiSince 23
 */

public android.media.midi.MidiDeviceInfo[] getDevices() { throw new RuntimeException("Stub!"); }

/**
 * Opens a MIDI device for reading and writing.
 *
 * @param deviceInfo a {@link android.media.midi.MidiDeviceInfo} to open
 * @param listener a {@link android.media.midi.MidiManager.OnDeviceOpenedListener MidiManager.OnDeviceOpenedListener} to be called
 *                 to receive the result
 * @param handler the {@link android.os.Handler Handler} that will be used for delivering
 *                the result. If handler is null, then the thread used for the
 *                listener is unspecified.
 * @apiSince 23
 */

public void openDevice(android.media.midi.MidiDeviceInfo deviceInfo, android.media.midi.MidiManager.OnDeviceOpenedListener listener, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Opens a Bluetooth MIDI device for reading and writing.
 *
 * @param bluetoothDevice a {@link android.bluetooth.BluetoothDevice} to open as a MIDI device
 * @param listener a {@link android.media.midi.MidiManager.OnDeviceOpenedListener MidiManager.OnDeviceOpenedListener} to be called to receive the
 * result
 * @param handler the {@link android.os.Handler Handler} that will be used for delivering
 *                the result. If handler is null, then the thread used for the
 *                listener is unspecified.
 * @apiSince 23
 */

public void openBluetoothDevice(android.bluetooth.BluetoothDevice bluetoothDevice, android.media.midi.MidiManager.OnDeviceOpenedListener listener, android.os.Handler handler) { throw new RuntimeException("Stub!"); }
/**
 * Callback class used for clients to receive MIDI device added and removed notifications
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class DeviceCallback {

public DeviceCallback() { throw new RuntimeException("Stub!"); }

/**
 * Called to notify when a new MIDI device has been added
 *
 * @param device a {@link android.media.midi.MidiDeviceInfo MidiDeviceInfo} for the newly added device
 * @apiSince 23
 */

public void onDeviceAdded(android.media.midi.MidiDeviceInfo device) { throw new RuntimeException("Stub!"); }

/**
 * Called to notify when a MIDI device has been removed
 *
 * @param device a {@link android.media.midi.MidiDeviceInfo MidiDeviceInfo} for the removed device
 * @apiSince 23
 */

public void onDeviceRemoved(android.media.midi.MidiDeviceInfo device) { throw new RuntimeException("Stub!"); }

/**
 * Called to notify when the status of a MIDI device has changed
 *
 * @param status a {@link android.media.midi.MidiDeviceStatus MidiDeviceStatus} for the changed device
 * @apiSince 23
 */

public void onDeviceStatusChanged(android.media.midi.MidiDeviceStatus status) { throw new RuntimeException("Stub!"); }
}

/**
 * Listener class used for receiving the results of {@link #openDevice} and
 * {@link #openBluetoothDevice}
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnDeviceOpenedListener {

/**
 * Called to respond to a {@link #openDevice} request
 *
 * @param device a {@link android.media.midi.MidiDevice MidiDevice} for opened device, or null if opening failed
 * @apiSince 23
 */

public void onDeviceOpened(android.media.midi.MidiDevice device);
}

}

