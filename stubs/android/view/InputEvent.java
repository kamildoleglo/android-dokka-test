/*
 * Copyright (C) 2010 The Android Open Source Project
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


package android.view;


/**
 * Common base class for input events.
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class InputEvent implements android.os.Parcelable {

InputEvent() { throw new RuntimeException("Stub!"); }

/**
 * Gets the id for the device that this event came from.  An id of
 * zero indicates that the event didn't come from a physical device
 * and maps to the default keymap.  The other numbers are arbitrary and
 * you shouldn't depend on the values.
 *
 * @return The device id.
 * @see android.view.InputDevice#getDevice
 * @apiSince 9
 */

public abstract int getDeviceId();

/**
 * Gets the device that this event came from.
 *
 * @return The device, or null if unknown.
 * @apiSince 9
 */

public final android.view.InputDevice getDevice() { throw new RuntimeException("Stub!"); }

/**
 * Gets the source of the event.
 *
 * @return The event source or {@link android.view.InputDevice#SOURCE_UNKNOWN InputDevice#SOURCE_UNKNOWN} if unknown.
 * @see android.view.InputDevice#getSources
 * @apiSince 9
 */

public abstract int getSource();

/**
 * Determines whether the event is from the given source.
 *
 * @param source The input source to check against. This can be a specific device type, such as
 * {@link android.view.InputDevice#SOURCE_TOUCH_NAVIGATION InputDevice#SOURCE_TOUCH_NAVIGATION}, or a more generic device class, such as
 * {@link android.view.InputDevice#SOURCE_CLASS_POINTER InputDevice#SOURCE_CLASS_POINTER}.
 * @return Whether the event is from the given source.
 * @apiSince 18
 */

public boolean isFromSource(int source) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the time this event occurred,
 * in the {@link android.os.SystemClock#uptimeMillis} time base.
 *
 * @return Returns the time this event occurred,
 * in the {@link android.os.SystemClock#uptimeMillis} time base.
 * @apiSince 16
 */

public abstract long getEventTime();

/** @apiSince 9 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.InputEvent> CREATOR;
static { CREATOR = null; }
}

