/*
 * Copyright (C) 2012 The Android Open Source Project
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


package android.hardware.input;

import android.view.InputDevice;

/**
 * Provides information about input devices and available key layouts.
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class InputManager {

private InputManager() { throw new RuntimeException("Stub!"); }

/**
 * Gets information about the input device with the specified id.
 * @param id The device id.
 * @return The input device or null if not found.
 * @apiSince 16
 */

public android.view.InputDevice getInputDevice(int id) { throw new RuntimeException("Stub!"); }

/**
 * Gets the ids of all input devices in the system.
 * @return The input device ids.
 * @apiSince 16
 */

public int[] getInputDeviceIds() { throw new RuntimeException("Stub!"); }

/**
 * Registers an input device listener to receive notifications about when
 * input devices are added, removed or changed.
 *
 * @param listener The listener to register.
 * @param handler The handler on which the listener should be invoked, or null
 * if the listener should be invoked on the calling thread's looper.
 *
 * @see #unregisterInputDeviceListener
 * @apiSince 16
 */

public void registerInputDeviceListener(android.hardware.input.InputManager.InputDeviceListener listener, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Unregisters an input device listener.
 *
 * @param listener The listener to unregister.
 *
 * @see #registerInputDeviceListener
 * @apiSince 16
 */

public void unregisterInputDeviceListener(android.hardware.input.InputManager.InputDeviceListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Broadcast Action: Query available keyboard layouts.
 * <p>
 * The input manager service locates available keyboard layouts
 * by querying broadcast receivers that are registered for this action.
 * An application can offer additional keyboard layouts to the user
 * by declaring a suitable broadcast receiver in its manifest.
 * </p><p>
 * Here is an example broadcast receiver declaration that an application
 * might include in its AndroidManifest.xml to advertise keyboard layouts.
 * The meta-data specifies a resource that contains a description of each keyboard
 * layout that is provided by the application.
 * <pre><code>
 * &lt;receiver android:name=".InputDeviceReceiver"
 *         android:label="@string/keyboard_layouts_label">
 *     &lt;intent-filter>
 *         &lt;action android:name="android.hardware.input.action.QUERY_KEYBOARD_LAYOUTS" />
 *     &lt;/intent-filter>
 *     &lt;meta-data android:name="android.hardware.input.metadata.KEYBOARD_LAYOUTS"
 *             android:resource="@xml/keyboard_layouts" />
 * &lt;/receiver>
 * </code></pre>
 * </p><p>
 * In the above example, the <code>@xml/keyboard_layouts</code> resource refers to
 * an XML resource whose root element is <code>&lt;keyboard-layouts></code> that
 * contains zero or more <code>&lt;keyboard-layout></code> elements.
 * Each <code>&lt;keyboard-layout></code> element specifies the name, label, and location
 * of a key character map for a particular keyboard layout.  The label on the receiver
 * is used to name the collection of keyboard layouts provided by this receiver in the
 * keyboard layout settings.
 * <pre><code>
 * &lt;?xml version="1.0" encoding="utf-8"?>
 * &lt;keyboard-layouts xmlns:android="http://schemas.android.com/apk/res/android">
 *     &lt;keyboard-layout android:name="keyboard_layout_english_us"
 *             android:label="@string/keyboard_layout_english_us_label"
 *             android:keyboardLayout="@raw/keyboard_layout_english_us" />
 * &lt;/keyboard-layouts>
 * </pre></code>
 * </p><p>
 * The <code>android:name</code> attribute specifies an identifier by which
 * the keyboard layout will be known in the package.
 * The <code>android:label</code> attribute specifies a human-readable descriptive
 * label to describe the keyboard layout in the user interface, such as "English (US)".
 * The <code>android:keyboardLayout</code> attribute refers to a
 * <a href="http://source.android.com/tech/input/key-character-map-files.html">
 * key character map</a> resource that defines the keyboard layout.
 * </p>
 * @apiSince 16
 */

public static final java.lang.String ACTION_QUERY_KEYBOARD_LAYOUTS = "android.hardware.input.action.QUERY_KEYBOARD_LAYOUTS";

/**
 * Metadata Key: Keyboard layout metadata associated with
 * {@link #ACTION_QUERY_KEYBOARD_LAYOUTS}.
 * <p>
 * Specifies the resource id of a XML resource that describes the keyboard
 * layouts that are provided by the application.
 * </p>
 * @apiSince 16
 */

public static final java.lang.String META_DATA_KEYBOARD_LAYOUTS = "android.hardware.input.metadata.KEYBOARD_LAYOUTS";
/**
 * Listens for changes in input devices.
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface InputDeviceListener {

/**
 * Called whenever an input device has been added to the system.
 * Use {@link android.hardware.input.InputManager#getInputDevice InputManager#getInputDevice} to get more information about the device.
 *
 * @param deviceId The id of the input device that was added.
 * @apiSince 16
 */

public void onInputDeviceAdded(int deviceId);

/**
 * Called whenever an input device has been removed from the system.
 *
 * @param deviceId The id of the input device that was removed.
 * @apiSince 16
 */

public void onInputDeviceRemoved(int deviceId);

/**
 * Called whenever the properties of an input device have changed since they
 * were last queried.  Use {@link android.hardware.input.InputManager#getInputDevice InputManager#getInputDevice} to get
 * a fresh {@link android.view.InputDevice InputDevice} object with the new properties.
 *
 * @param deviceId The id of the input device that changed.
 * @apiSince 16
 */

public void onInputDeviceChanged(int deviceId);
}

}

