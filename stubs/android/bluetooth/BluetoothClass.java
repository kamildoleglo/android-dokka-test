/*
 * Copyright (C) 2008 The Android Open Source Project
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


/**
 * Represents a Bluetooth class, which describes general characteristics
 * and capabilities of a device. For example, a Bluetooth class will
 * specify the general device type such as a phone, a computer, or
 * headset, and whether it's capable of services such as audio or telephony.
 *
 * <p>Every Bluetooth class is composed of zero or more service classes, and
 * exactly one device class. The device class is further broken down into major
 * and minor device class components.
 *
 * <p>{@link android.bluetooth.BluetoothClass BluetoothClass} is useful as a hint to roughly describe a device
 * (for example to show an icon in the UI), but does not reliably describe which
 * Bluetooth profiles or services are actually supported by a device. Accurate
 * service discovery is done through SDP requests, which are automatically
 * performed when creating an RFCOMM socket with {@link android.bluetooth.BluetoothDevice#createRfcommSocketToServiceRecord BluetoothDevice#createRfcommSocketToServiceRecord} and {@link android.bluetooth.BluetoothAdapter#listenUsingRfcommWithServiceRecord BluetoothAdapter#listenUsingRfcommWithServiceRecord}</p>
 *
 * <p>Use {@link android.bluetooth.BluetoothDevice#getBluetoothClass BluetoothDevice#getBluetoothClass} to retrieve the class for
 * a remote device.
 *
 * <!--
 * The Bluetooth class is a 32 bit field. The format of these bits is defined at
 * http://www.bluetooth.org/Technical/AssignedNumbers/baseband.htm
 * (login required). This class contains that 32 bit field, and provides
 * constants and methods to determine which Service Class(es) and Device Class
 * are encoded in that field.
 * -->
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class BluetoothClass implements android.os.Parcelable {

BluetoothClass() { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Return true if the specified service class is supported by this
 * {@link android.bluetooth.BluetoothClass BluetoothClass}.
 * <p>Valid service classes are the public constants in
 * {@link android.bluetooth.BluetoothClass.Service BluetoothClass.Service}. For example, {@link android.bluetooth.BluetoothClass.Service#AUDIO BluetoothClass.Service#AUDIO}.
 *
 * @param service valid service class
 * @return true if the service class is supported
 * @apiSince 5
 */

public boolean hasService(int service) { throw new RuntimeException("Stub!"); }

/**
 * Return the major device class component of this {@link android.bluetooth.BluetoothClass BluetoothClass}.
 * <p>Values returned from this function can be compared with the
 * public constants in {@link android.bluetooth.BluetoothClass.Device.Major BluetoothClass.Device.Major} to determine
 * which major class is encoded in this Bluetooth class.
 *
 * @return major device class component
 * @apiSince 5
 */

public int getMajorDeviceClass() { throw new RuntimeException("Stub!"); }

/**
 * Return the (major and minor) device class component of this
 * {@link android.bluetooth.BluetoothClass BluetoothClass}.
 * <p>Values returned from this function can be compared with the
 * public constants in {@link android.bluetooth.BluetoothClass.Device BluetoothClass.Device} to determine which
 * device class is encoded in this Bluetooth class.
 *
 * @return device class component
 * @apiSince 5
 */

public int getDeviceClass() { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.bluetooth.BluetoothClass> CREATOR;
static { CREATOR = null; }
/**
 * Defines all device class constants.
 * <p>Each {@link android.bluetooth.BluetoothClass BluetoothClass} encodes exactly one device class, with
 * major and minor components.
 * <p>The constants in {@link android.bluetooth.BluetoothClass.Device BluetoothClass.Device} represent a combination of major and minor
 * device components (the complete device class). The constants in {@link android.bluetooth.BluetoothClass.Device.Major BluetoothClass.Device.Major} represent only major device classes.
 * <p>See {@link android.bluetooth.BluetoothClass.Service BluetoothClass.Service} for service class constants.
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Device {

public Device() { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public static final int AUDIO_VIDEO_CAMCORDER = 1076; // 0x434

/** @apiSince 5 */

public static final int AUDIO_VIDEO_CAR_AUDIO = 1056; // 0x420

/** @apiSince 5 */

public static final int AUDIO_VIDEO_HANDSFREE = 1032; // 0x408

/** @apiSince 5 */

public static final int AUDIO_VIDEO_HEADPHONES = 1048; // 0x418

/** @apiSince 5 */

public static final int AUDIO_VIDEO_HIFI_AUDIO = 1064; // 0x428

/** @apiSince 5 */

public static final int AUDIO_VIDEO_LOUDSPEAKER = 1044; // 0x414

/** @apiSince 5 */

public static final int AUDIO_VIDEO_MICROPHONE = 1040; // 0x410

/** @apiSince 5 */

public static final int AUDIO_VIDEO_PORTABLE_AUDIO = 1052; // 0x41c

/** @apiSince 5 */

public static final int AUDIO_VIDEO_SET_TOP_BOX = 1060; // 0x424

/** @apiSince 5 */

public static final int AUDIO_VIDEO_UNCATEGORIZED = 1024; // 0x400

/** @apiSince 5 */

public static final int AUDIO_VIDEO_VCR = 1068; // 0x42c

/** @apiSince 5 */

public static final int AUDIO_VIDEO_VIDEO_CAMERA = 1072; // 0x430

/** @apiSince 5 */

public static final int AUDIO_VIDEO_VIDEO_CONFERENCING = 1088; // 0x440

/** @apiSince 5 */

public static final int AUDIO_VIDEO_VIDEO_DISPLAY_AND_LOUDSPEAKER = 1084; // 0x43c

/** @apiSince 5 */

public static final int AUDIO_VIDEO_VIDEO_GAMING_TOY = 1096; // 0x448

/** @apiSince 5 */

public static final int AUDIO_VIDEO_VIDEO_MONITOR = 1080; // 0x438

/** @apiSince 5 */

public static final int AUDIO_VIDEO_WEARABLE_HEADSET = 1028; // 0x404

/** @apiSince 5 */

public static final int COMPUTER_DESKTOP = 260; // 0x104

/** @apiSince 5 */

public static final int COMPUTER_HANDHELD_PC_PDA = 272; // 0x110

/** @apiSince 5 */

public static final int COMPUTER_LAPTOP = 268; // 0x10c

/** @apiSince 5 */

public static final int COMPUTER_PALM_SIZE_PC_PDA = 276; // 0x114

/** @apiSince 5 */

public static final int COMPUTER_SERVER = 264; // 0x108

/** @apiSince 5 */

public static final int COMPUTER_UNCATEGORIZED = 256; // 0x100

/** @apiSince 5 */

public static final int COMPUTER_WEARABLE = 280; // 0x118

/** @apiSince 5 */

public static final int HEALTH_BLOOD_PRESSURE = 2308; // 0x904

/** @apiSince 5 */

public static final int HEALTH_DATA_DISPLAY = 2332; // 0x91c

/** @apiSince 5 */

public static final int HEALTH_GLUCOSE = 2320; // 0x910

/** @apiSince 5 */

public static final int HEALTH_PULSE_OXIMETER = 2324; // 0x914

/** @apiSince 5 */

public static final int HEALTH_PULSE_RATE = 2328; // 0x918

/** @apiSince 5 */

public static final int HEALTH_THERMOMETER = 2312; // 0x908

/** @apiSince 5 */

public static final int HEALTH_UNCATEGORIZED = 2304; // 0x900

/** @apiSince 5 */

public static final int HEALTH_WEIGHING = 2316; // 0x90c

/** @apiSince 5 */

public static final int PHONE_CELLULAR = 516; // 0x204

/** @apiSince 5 */

public static final int PHONE_CORDLESS = 520; // 0x208

/** @apiSince 5 */

public static final int PHONE_ISDN = 532; // 0x214

/** @apiSince 5 */

public static final int PHONE_MODEM_OR_GATEWAY = 528; // 0x210

/** @apiSince 5 */

public static final int PHONE_SMART = 524; // 0x20c

/** @apiSince 5 */

public static final int PHONE_UNCATEGORIZED = 512; // 0x200

/** @apiSince 5 */

public static final int TOY_CONTROLLER = 2064; // 0x810

/** @apiSince 5 */

public static final int TOY_DOLL_ACTION_FIGURE = 2060; // 0x80c

/** @apiSince 5 */

public static final int TOY_GAME = 2068; // 0x814

/** @apiSince 5 */

public static final int TOY_ROBOT = 2052; // 0x804

/** @apiSince 5 */

public static final int TOY_UNCATEGORIZED = 2048; // 0x800

/** @apiSince 5 */

public static final int TOY_VEHICLE = 2056; // 0x808

/** @apiSince 5 */

public static final int WEARABLE_GLASSES = 1812; // 0x714

/** @apiSince 5 */

public static final int WEARABLE_HELMET = 1808; // 0x710

/** @apiSince 5 */

public static final int WEARABLE_JACKET = 1804; // 0x70c

/** @apiSince 5 */

public static final int WEARABLE_PAGER = 1800; // 0x708

/** @apiSince 5 */

public static final int WEARABLE_UNCATEGORIZED = 1792; // 0x700

/** @apiSince 5 */

public static final int WEARABLE_WRIST_WATCH = 1796; // 0x704
/**
 * Defines all major device class constants.
 * <p>See {@link android.bluetooth.BluetoothClass.Device BluetoothClass.Device} for minor classes.
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Major {

public Major() { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public static final int AUDIO_VIDEO = 1024; // 0x400

/** @apiSince 5 */

public static final int COMPUTER = 256; // 0x100

/** @apiSince 5 */

public static final int HEALTH = 2304; // 0x900

/** @apiSince 5 */

public static final int IMAGING = 1536; // 0x600

/** @apiSince 5 */

public static final int MISC = 0; // 0x0

/** @apiSince 5 */

public static final int NETWORKING = 768; // 0x300

/** @apiSince 5 */

public static final int PERIPHERAL = 1280; // 0x500

/** @apiSince 5 */

public static final int PHONE = 512; // 0x200

/** @apiSince 5 */

public static final int TOY = 2048; // 0x800

/** @apiSince 5 */

public static final int UNCATEGORIZED = 7936; // 0x1f00

/** @apiSince 5 */

public static final int WEARABLE = 1792; // 0x700
}

}

/**
 * Defines all service class constants.
 * <p>Each {@link android.bluetooth.BluetoothClass BluetoothClass} encodes zero or more service classes.
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Service {

public Service() { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public static final int AUDIO = 2097152; // 0x200000

/** @apiSince 5 */

public static final int CAPTURE = 524288; // 0x80000

/** @apiSince 5 */

public static final int INFORMATION = 8388608; // 0x800000

/** @apiSince 5 */

public static final int LIMITED_DISCOVERABILITY = 8192; // 0x2000

/** @apiSince 5 */

public static final int NETWORKING = 131072; // 0x20000

/** @apiSince 5 */

public static final int OBJECT_TRANSFER = 1048576; // 0x100000

/** @apiSince 5 */

public static final int POSITIONING = 65536; // 0x10000

/** @apiSince 5 */

public static final int RENDER = 262144; // 0x40000

/** @apiSince 5 */

public static final int TELEPHONY = 4194304; // 0x400000
}

}

