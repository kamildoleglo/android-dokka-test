/*
 * Copyright (C) 2011 The Android Open Source Project
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
 * A class representing a USB accessory, which is an external hardware component
 * that communicates with an android application over USB.
 * The accessory is the USB host and android the device side of the USB connection.
 *
 * <p>When the accessory connects, it reports its manufacturer and model names,
 * the version of the accessory, and a user visible description of the accessory to the device.
 * The manufacturer, model and version strings are used by the USB Manager to choose
 * an appropriate application for the accessory.
 * The accessory may optionally provide a unique serial number
 * and a URL to for the accessory's website to the device as well.
 *
 * <p>An instance of this class is sent to the application via the
 * {@link android.hardware.usb.UsbManager#ACTION_USB_ACCESSORY_ATTACHED UsbManager#ACTION_USB_ACCESSORY_ATTACHED} Intent.
 * The application can then call {@link android.hardware.usb.UsbManager#openAccessory UsbManager#openAccessory} to open a file descriptor
 * for reading and writing data to and from the accessory.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about communicating with USB hardware, read the
 * <a href="{@docRoot}guide/topics/usb/index.html">USB</a> developer guide.</p>
 * </div>
 * @apiSince 12
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class UsbAccessory implements android.os.Parcelable {

UsbAccessory() { throw new RuntimeException("Stub!"); }

/**
 * Returns the manufacturer name of the accessory.
 *
 * @return the accessory manufacturer
 
 * This value will never be {@code null}.
 * @apiSince 12
 */

@androidx.annotation.NonNull
public java.lang.String getManufacturer() { throw new RuntimeException("Stub!"); }

/**
 * Returns the model name of the accessory.
 *
 * @return the accessory model
 
 * This value will never be {@code null}.
 * @apiSince 12
 */

@androidx.annotation.NonNull
public java.lang.String getModel() { throw new RuntimeException("Stub!"); }

/**
 * Returns a user visible description of the accessory.
 *
 * @return the accessory description, or {@code null} if not set
 * @apiSince 12
 */

@androidx.annotation.Nullable
public java.lang.String getDescription() { throw new RuntimeException("Stub!"); }

/**
 * Returns the version of the accessory.
 *
 * @return the accessory version, or {@code null} if not set
 * @apiSince 12
 */

@androidx.annotation.Nullable
public java.lang.String getVersion() { throw new RuntimeException("Stub!"); }

/**
 * Returns the URI for the accessory.
 * This is an optional URI that might show information about the accessory
 * or provide the option to download an application for the accessory
 *
 * @return the accessory URI, or {@code null} if not set
 * @apiSince 12
 */

@androidx.annotation.Nullable
public java.lang.String getUri() { throw new RuntimeException("Stub!"); }

/**
 * Returns the unique serial number for the accessory.
 * This is an optional serial number that can be used to differentiate
 * between individual accessories of the same model and manufacturer
 *
 * @return the unique serial number, or {@code null} if not set
 *
 * @throws java.lang.SecurityException if the app targets SDK >= {@value android.os.Build.VERSION_CODES#Q}
 *                           and the app does not have permission to read from the accessory.
 * @apiSince 12
 */

@androidx.annotation.Nullable
public java.lang.String getSerial() { throw new RuntimeException("Stub!"); }

/** @apiSince 12 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/** @apiSince 12 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 12 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 12 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 12 */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 12 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.hardware.usb.UsbAccessory> CREATOR;
static { CREATOR = null; }
}

