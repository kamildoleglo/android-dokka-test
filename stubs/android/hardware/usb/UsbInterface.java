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


package android.hardware.usb;


/**
 * A class representing an interface on a {@link android.hardware.usb.UsbDevice UsbDevice}.
 * USB devices can have one or more interfaces, each one providing a different
 * piece of functionality, separate from the other interfaces.
 * An interface will have one or more {@link android.hardware.usb.UsbEndpoint UsbEndpoint}s, which are the
 * channels by which the host transfers data with the device.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about communicating with USB hardware, read the
 * <a href="{@docRoot}guide/topics/usb/index.html">USB</a> developer guide.</p>
 * </div>
 * @apiSince 12
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class UsbInterface implements android.os.Parcelable {

UsbInterface() { throw new RuntimeException("Stub!"); }

/**
 * Returns the interface's bInterfaceNumber field.
 * This is an integer that along with the alternate setting uniquely identifies
 * the interface on the device.
 *
 * @return the interface's ID
 * @apiSince 12
 */

public int getId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the interface's bAlternateSetting field.
 * This is an integer that along with the ID uniquely identifies
 * the interface on the device.
 * {@link android.hardware.usb.UsbDeviceConnection#setInterface UsbDeviceConnection#setInterface} can be used to switch between
 * two interfaces with the same ID but different alternate setting.
 *
 * @return the interface's alternate setting
 * @apiSince 21
 */

public int getAlternateSetting() { throw new RuntimeException("Stub!"); }

/**
 * Returns the interface's name.
 *
 * @return the interface's name, or {@code null} if the property could not be read
 * @apiSince 21
 */

@androidx.annotation.Nullable
public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * Returns the interface's class field.
 * Some useful constants for USB classes can be found in {@link android.hardware.usb.UsbConstants UsbConstants}
 *
 * @return the interface's class
 * @apiSince 12
 */

public int getInterfaceClass() { throw new RuntimeException("Stub!"); }

/**
 * Returns the interface's subclass field.
 *
 * @return the interface's subclass
 * @apiSince 12
 */

public int getInterfaceSubclass() { throw new RuntimeException("Stub!"); }

/**
 * Returns the interface's protocol field.
 *
 * @return the interface's protocol
 * @apiSince 12
 */

public int getInterfaceProtocol() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of {@link android.hardware.usb.UsbEndpoint}s this interface contains.
 *
 * @return the number of endpoints
 * @apiSince 12
 */

public int getEndpointCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.hardware.usb.UsbEndpoint} at the given index.
 *
 * @return the endpoint
 * @apiSince 12
 */

public android.hardware.usb.UsbEndpoint getEndpoint(int index) { throw new RuntimeException("Stub!"); }

/** @apiSince 12 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 12 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 12 */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 12 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.hardware.usb.UsbInterface> CREATOR;
static { CREATOR = null; }
}

