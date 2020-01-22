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

import java.util.HashMap;
import android.content.pm.PackageManager;
import android.Manifest;
import android.os.Build;
import android.app.PendingIntent;

/**
 * This class allows you to access the state of USB and communicate with USB devices.
 * Currently only host mode is supported in the public API.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about communicating with USB hardware, read the
 * <a href="{@docRoot}guide/topics/connectivity/usb/index.html">USB developer guide</a>.</p>
 * </div>
 * @apiSince 12
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class UsbManager {

UsbManager() { throw new RuntimeException("Stub!"); }

/**
 * Returns a HashMap containing all USB devices currently attached.
 * USB device name is the key for the returned HashMap.
 * The result will be empty if no devices are attached, or if
 * USB host mode is inactive or unsupported.
 *
 * <br>
 * Requires the {@link android.content.pm.PackageManager#FEATURE_USB_HOST PackageManager#FEATURE_USB_HOST} feature which can be detected using {@link android.content.pm.PackageManager#hasSystemFeature(String) PackageManager.hasSystemFeature(String)}.
 * @return HashMap containing all connected USB devices.
 * @apiSince 12
 */

public java.util.HashMap<java.lang.String,android.hardware.usb.UsbDevice> getDeviceList() { throw new RuntimeException("Stub!"); }

/**
 * Opens the device so it can be used to send and receive
 * data using {@link android.hardware.usb.UsbRequest}.
 *
 * <br>
 * Requires the {@link android.content.pm.PackageManager#FEATURE_USB_HOST PackageManager#FEATURE_USB_HOST} feature which can be detected using {@link android.content.pm.PackageManager#hasSystemFeature(String) PackageManager.hasSystemFeature(String)}.
 * @param device the device to open
 * @return a {@link android.hardware.usb.UsbDeviceConnection UsbDeviceConnection}, or {@code null} if open failed
 * @apiSince 12
 */

public android.hardware.usb.UsbDeviceConnection openDevice(android.hardware.usb.UsbDevice device) { throw new RuntimeException("Stub!"); }

/**
 * Returns a list of currently attached USB accessories.
 * (in the current implementation there can be at most one)
 *
 * <br>
 * Requires the {@link android.content.pm.PackageManager#FEATURE_USB_ACCESSORY PackageManager#FEATURE_USB_ACCESSORY} feature which can be detected using {@link android.content.pm.PackageManager#hasSystemFeature(String) PackageManager.hasSystemFeature(String)}.
 * @return list of USB accessories, or null if none are attached.
 * @apiSince 12
 */

public android.hardware.usb.UsbAccessory[] getAccessoryList() { throw new RuntimeException("Stub!"); }

/**
 * Opens a file descriptor for reading and writing data to the USB accessory.
 *
 * <p>If data is read from the {@link java.io.InputStream} created from this file descriptor all
 * data of a USB transfer should be read at once. If only a partial request is read the rest of
 * the transfer is dropped.
 *
 * <br>
 * Requires the {@link android.content.pm.PackageManager#FEATURE_USB_ACCESSORY PackageManager#FEATURE_USB_ACCESSORY} feature which can be detected using {@link android.content.pm.PackageManager#hasSystemFeature(String) PackageManager.hasSystemFeature(String)}.
 * @param accessory the USB accessory to open
 * @return file descriptor, or null if the accessory could not be opened.
 * @apiSince 12
 */

public android.os.ParcelFileDescriptor openAccessory(android.hardware.usb.UsbAccessory accessory) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the caller has permission to access the device.
 * Permission might have been granted temporarily via
 * {@link #requestPermission(android.hardware.usb.UsbDevice,android.app.PendingIntent)} or
 * by the user choosing the caller as the default application for the device.
 * Permission for USB devices of class {@link android.hardware.usb.UsbConstants#USB_CLASS_VIDEO UsbConstants#USB_CLASS_VIDEO} for clients that
 * target SDK {@link android.os.Build.VERSION_CODES#P} and above can be granted only if they
 * have additionally the {@link android.Manifest.permission#CAMERA} permission.
 *
 * <br>
 * Requires the {@link android.content.pm.PackageManager#FEATURE_USB_HOST PackageManager#FEATURE_USB_HOST} feature which can be detected using {@link android.content.pm.PackageManager#hasSystemFeature(String) PackageManager.hasSystemFeature(String)}.
 * @param device to check permissions for
 * @return true if caller has permission
 * @apiSince 12
 */

public boolean hasPermission(android.hardware.usb.UsbDevice device) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the caller has permission to access the accessory.
 * Permission might have been granted temporarily via
 * {@link #requestPermission(android.hardware.usb.UsbAccessory,android.app.PendingIntent)} or
 * by the user choosing the caller as the default application for the accessory.
 *
 * <br>
 * Requires the {@link android.content.pm.PackageManager#FEATURE_USB_ACCESSORY PackageManager#FEATURE_USB_ACCESSORY} feature which can be detected using {@link android.content.pm.PackageManager#hasSystemFeature(String) PackageManager.hasSystemFeature(String)}.
 * @param accessory to check permissions for
 * @return true if caller has permission
 * @apiSince 12
 */

public boolean hasPermission(android.hardware.usb.UsbAccessory accessory) { throw new RuntimeException("Stub!"); }

/**
 * Requests temporary permission for the given package to access the device.
 * This may result in a system dialog being displayed to the user
 * if permission had not already been granted.
 * Success or failure is returned via the {@link android.app.PendingIntent} pi.
 * If successful, this grants the caller permission to access the device only
 * until the device is disconnected.
 *
 * The following extras will be added to pi:
 * <ul>
 * <li> {@link #EXTRA_DEVICE} containing the device passed into this call
 * <li> {@link #EXTRA_PERMISSION_GRANTED} containing boolean indicating whether
 * permission was granted by the user
 * </ul>
 *
 * Permission for USB devices of class {@link android.hardware.usb.UsbConstants#USB_CLASS_VIDEO UsbConstants#USB_CLASS_VIDEO} for clients that
 * target SDK {@link android.os.Build.VERSION_CODES#P} and above can be granted only if they
 * have additionally the {@link android.Manifest.permission#CAMERA} permission.
 *
 * <br>
 * Requires the {@link android.content.pm.PackageManager#FEATURE_USB_HOST PackageManager#FEATURE_USB_HOST} feature which can be detected using {@link android.content.pm.PackageManager#hasSystemFeature(String) PackageManager.hasSystemFeature(String)}.
 * @param device to request permissions for
 * @param pi PendingIntent for returning result
 * @apiSince 12
 */

public void requestPermission(android.hardware.usb.UsbDevice device, android.app.PendingIntent pi) { throw new RuntimeException("Stub!"); }

/**
 * Requests temporary permission for the given package to access the accessory.
 * This may result in a system dialog being displayed to the user
 * if permission had not already been granted.
 * Success or failure is returned via the {@link android.app.PendingIntent} pi.
 * If successful, this grants the caller permission to access the accessory only
 * until the device is disconnected.
 *
 * The following extras will be added to pi:
 * <ul>
 * <li> {@link #EXTRA_ACCESSORY} containing the accessory passed into this call
 * <li> {@link #EXTRA_PERMISSION_GRANTED} containing boolean indicating whether
 * permission was granted by the user
 * </ul>
 *
 * <br>
 * Requires the {@link android.content.pm.PackageManager#FEATURE_USB_ACCESSORY PackageManager#FEATURE_USB_ACCESSORY} feature which can be detected using {@link android.content.pm.PackageManager#hasSystemFeature(String) PackageManager.hasSystemFeature(String)}.
 * @param accessory to request permissions for
 * @param pi PendingIntent for returning result
 * @apiSince 12
 */

public void requestPermission(android.hardware.usb.UsbAccessory accessory, android.app.PendingIntent pi) { throw new RuntimeException("Stub!"); }

/**
 * Activity intent sent when user attaches a USB accessory.
 *
 * <ul>
 * <li> {@link #EXTRA_ACCESSORY} containing the {@link android.hardware.usb.UsbAccessory}
 * for the attached accessory
 * </ul>
 * @apiSince 12
 */

public static final java.lang.String ACTION_USB_ACCESSORY_ATTACHED = "android.hardware.usb.action.USB_ACCESSORY_ATTACHED";

/**
 * Broadcast Action:  A broadcast for USB accessory detached event.
 *
 * This intent is sent when a USB accessory is detached.
 * <ul>
 * <li> {@link #EXTRA_ACCESSORY} containing the {@link android.hardware.usb.UsbAccessory UsbAccessory}
 * for the attached accessory that was detached
 * </ul>
 * @apiSince 12
 */

public static final java.lang.String ACTION_USB_ACCESSORY_DETACHED = "android.hardware.usb.action.USB_ACCESSORY_DETACHED";

/**
 * Activity intent sent when user attaches a USB device.
 *
 * This intent is sent when a USB device is attached to the USB bus when in host mode.
 * <ul>
 * <li> {@link #EXTRA_DEVICE} containing the {@link android.hardware.usb.UsbDevice}
 * for the attached device
 * </ul>
 * @apiSince 12
 */

public static final java.lang.String ACTION_USB_DEVICE_ATTACHED = "android.hardware.usb.action.USB_DEVICE_ATTACHED";

/**
 * Broadcast Action:  A broadcast for USB device detached event.
 *
 * This intent is sent when a USB device is detached from the USB bus when in host mode.
 * <ul>
 * <li> {@link #EXTRA_DEVICE} containing the {@link android.hardware.usb.UsbDevice}
 * for the detached device
 * </ul>
 * @apiSince 12
 */

public static final java.lang.String ACTION_USB_DEVICE_DETACHED = "android.hardware.usb.action.USB_DEVICE_DETACHED";

/**
 * Name of extra for {@link #ACTION_USB_ACCESSORY_ATTACHED} and
 * {@link #ACTION_USB_ACCESSORY_DETACHED} broadcasts
 * containing the {@link android.hardware.usb.UsbAccessory UsbAccessory} object for the accessory.
 * @apiSince 12
 */

public static final java.lang.String EXTRA_ACCESSORY = "accessory";

/**
 * Name of extra for {@link #ACTION_USB_DEVICE_ATTACHED} and
 * {@link #ACTION_USB_DEVICE_DETACHED} broadcasts
 * containing the {@link android.hardware.usb.UsbDevice UsbDevice} object for the device.
 * @apiSince 12
 */

public static final java.lang.String EXTRA_DEVICE = "device";

/**
 * Name of extra added to the {@link android.app.PendingIntent}
 * passed into {@link #requestPermission(android.hardware.usb.UsbDevice,android.app.PendingIntent)}
 * or {@link #requestPermission(android.hardware.usb.UsbAccessory,android.app.PendingIntent)}
 * containing a boolean value indicating whether the user granted permission or not.
 * @apiSince 12
 */

public static final java.lang.String EXTRA_PERMISSION_GRANTED = "permission";
}

