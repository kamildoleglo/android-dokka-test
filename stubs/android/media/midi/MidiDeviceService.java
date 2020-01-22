/*
 * Copyright (C) 2015 The Android Open Source Project
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


/**
 * A service that implements a virtual MIDI device.
 * Subclasses must implement the {@link #onGetInputPortReceivers} method to provide a
 * list of {@link android.media.midi.MidiReceiver MidiReceiver}s to receive data sent to the device's input ports.
 * Similarly, subclasses can call {@link #getOutputPortReceivers} to fetch a list
 * of {@link android.media.midi.MidiReceiver MidiReceiver}s for sending data out the output ports.
 *
 * <p>To extend this class, you must declare the service in your manifest file with
 * an intent filter with the {@link #SERVICE_INTERFACE} action
 * and meta-data to describe the virtual device.
 For example:</p>
 * <pre>
 * &lt;service android:name=".VirtualDeviceService"
 *          android:label="&#64;string/service_name">
 *     &lt;intent-filter>
 *         &lt;action android:name="android.media.midi.MidiDeviceService" />
 *     &lt;/intent-filter>
 *           &lt;meta-data android:name="android.media.midi.MidiDeviceService"
               android:resource="@xml/device_info" />
 * &lt;/service></pre>
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class MidiDeviceService extends android.app.Service {

public MidiDeviceService() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public void onCreate() { throw new RuntimeException("Stub!"); }

/**
 * Returns an array of {@link android.media.midi.MidiReceiver MidiReceiver} for the device's input ports.
 * Subclasses must override this to provide the receivers which will receive
 * data sent to the device's input ports. An empty array should be returned if
 * the device has no input ports.
 * @return array of MidiReceivers
 * @apiSince 23
 */

public abstract android.media.midi.MidiReceiver[] onGetInputPortReceivers();

/**
 * Returns an array of {@link android.media.midi.MidiReceiver MidiReceiver} for the device's output ports.
 * These can be used to send data out the device's output ports.
 * @return array of MidiReceivers
 * @apiSince 23
 */

public final android.media.midi.MidiReceiver[] getOutputPortReceivers() { throw new RuntimeException("Stub!"); }

/**
 * returns the {@link android.media.midi.MidiDeviceInfo MidiDeviceInfo} instance for this service
 * @return our MidiDeviceInfo
 * @apiSince 23
 */

public final android.media.midi.MidiDeviceInfo getDeviceInfo() { throw new RuntimeException("Stub!"); }

/**
 * Called to notify when an our {@link android.media.midi.MidiDeviceStatus MidiDeviceStatus} has changed
 * @param status the number of the port that was opened
 * @apiSince 23
 */

public void onDeviceStatusChanged(android.media.midi.MidiDeviceStatus status) { throw new RuntimeException("Stub!"); }

/**
 * Called to notify when our device has been closed by all its clients
 * @apiSince 23
 */

public void onClose() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public android.os.IBinder onBind(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public static final java.lang.String SERVICE_INTERFACE = "android.media.midi.MidiDeviceService";
}

