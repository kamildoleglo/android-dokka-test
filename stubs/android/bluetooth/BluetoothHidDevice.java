/*
 * Copyright (C) 2016 The Android Open Source Project
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

import java.util.concurrent.Executor;

/**
 * Provides the public APIs to control the Bluetooth HID Device profile.
 *
 * <p>BluetoothHidDevice is a proxy object for controlling the Bluetooth HID Device Service via IPC.
 * Use {@link android.bluetooth.BluetoothAdapter#getProfileProxy BluetoothAdapter#getProfileProxy} to get the BluetoothHidDevice proxy object.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class BluetoothHidDevice implements android.bluetooth.BluetoothProfile {

BluetoothHidDevice() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 28
 */

public java.util.List<android.bluetooth.BluetoothDevice> getConnectedDevices() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 28
 */

public java.util.List<android.bluetooth.BluetoothDevice> getDevicesMatchingConnectionStates(int[] states) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 28
 */

public int getConnectionState(android.bluetooth.BluetoothDevice device) { throw new RuntimeException("Stub!"); }

/**
 * Registers application to be used for HID device. Connections to HID Device are only possible
 * when application is registered. Only one application can be registered at one time. When an
 * application is registered, the HID Host service will be disabled until it is unregistered.
 * When no longer used, application should be unregistered using {@link #unregisterApp()}. The
 * app will be automatically unregistered if it is not foreground. The registration status
 * should be tracked by the application by handling callback from Callback#onAppStatusChanged.
 * The app registration status is not related to the return value of this method.
 *
 * @param sdp {@link android.bluetooth.BluetoothHidDeviceAppSdpSettings BluetoothHidDeviceAppSdpSettings} object of HID Device SDP record. The HID
 *     Device SDP record is required.
 * @param inQos {@link android.bluetooth.BluetoothHidDeviceAppQosSettings BluetoothHidDeviceAppQosSettings} object of Incoming QoS Settings. The
 *     Incoming QoS Settings is not required. Use null or default
 *     BluetoothHidDeviceAppQosSettings.Builder for default values.
 * @param outQos {@link android.bluetooth.BluetoothHidDeviceAppQosSettings BluetoothHidDeviceAppQosSettings} object of Outgoing QoS Settings. The
 *     Outgoing QoS Settings is not required. Use null or default
 *     BluetoothHidDeviceAppQosSettings.Builder for default values.
 * @param executor {@link java.util.concurrent.Executor Executor} object on which callback will be executed. The Executor
 *     object is required.
 * @param callback {@link android.bluetooth.BluetoothHidDevice.Callback Callback} object to which callback messages will be sent. The Callback
 *     object is required.
 * @return true if the command is successfully sent; otherwise false.
 * @apiSince 28
 */

public boolean registerApp(android.bluetooth.BluetoothHidDeviceAppSdpSettings sdp, android.bluetooth.BluetoothHidDeviceAppQosSettings inQos, android.bluetooth.BluetoothHidDeviceAppQosSettings outQos, java.util.concurrent.Executor executor, android.bluetooth.BluetoothHidDevice.Callback callback) { throw new RuntimeException("Stub!"); }

/**
 * Unregisters application. Active connection will be disconnected and no new connections will
 * be allowed until registered again using {@link #registerApp
 * (android.bluetooth.BluetoothHidDeviceAppQosSettings,android.bluetooth.BluetoothHidDeviceAppQosSettings,android.bluetooth.BluetoothHidDeviceAppQosSettings,java.util.concurrent.Executor,android.bluetooth.BluetoothHidDevice.Callback)}. The registration status should be
 * tracked by the application by handling callback from Callback#onAppStatusChanged. The app
 * registration status is not related to the return value of this method.
 *
 * @return true if the command is successfully sent; otherwise false.
 * @apiSince 28
 */

public boolean unregisterApp() { throw new RuntimeException("Stub!"); }

/**
 * Sends report to remote host using interrupt channel.
 *
 * @param id Report Id, as defined in descriptor. Can be 0 in case Report Id are not defined in
 *     descriptor.
 * @param data Report data, not including Report Id.
 * @return true if the command is successfully sent; otherwise false.
 * @apiSince 28
 */

public boolean sendReport(android.bluetooth.BluetoothDevice device, int id, byte[] data) { throw new RuntimeException("Stub!"); }

/**
 * Sends report to remote host as reply for GET_REPORT request from {@link android.bluetooth.BluetoothHidDevice.Callback#onGetReport(android.bluetooth.BluetoothDevice,byte,byte,int) Callback#onGetReport(BluetoothDevice, byte, byte, int)}.
 *
 * @param type Report Type, as in request.
 * @param id Report Id, as in request.
 * @param data Report data, not including Report Id.
 * @return true if the command is successfully sent; otherwise false.
 * @apiSince 28
 */

public boolean replyReport(android.bluetooth.BluetoothDevice device, byte type, byte id, byte[] data) { throw new RuntimeException("Stub!"); }

/**
 * Sends error handshake message as reply for invalid SET_REPORT request from {@link android.bluetooth.BluetoothHidDevice.Callback#onSetReport(android.bluetooth.BluetoothDevice,byte,byte,byte[]) Callback#onSetReport(BluetoothDevice, byte, byte, byte[])}.
 *
 * @param error Error to be sent for SET_REPORT via HANDSHAKE.
 * @return true if the command is successfully sent; otherwise false.
 * @apiSince 28
 */

public boolean reportError(android.bluetooth.BluetoothDevice device, byte error) { throw new RuntimeException("Stub!"); }

/**
 * Initiates connection to host which is currently paired with this device. If the application
 * is not registered, #connect(BluetoothDevice) will fail. The connection state should be
 * tracked by the application by handling callback from Callback#onConnectionStateChanged. The
 * connection state is not related to the return value of this method.
 *
 * @return true if the command is successfully sent; otherwise false.
 * @apiSince 28
 */

public boolean connect(android.bluetooth.BluetoothDevice device) { throw new RuntimeException("Stub!"); }

/**
 * Disconnects from currently connected host. The connection state should be tracked by the
 * application by handling callback from Callback#onConnectionStateChanged. The connection state
 * is not related to the return value of this method.
 *
 * @return true if the command is successfully sent; otherwise false.
 * @apiSince 28
 */

public boolean disconnect(android.bluetooth.BluetoothDevice device) { throw new RuntimeException("Stub!"); }

/**
 * Intent used to broadcast the change in connection state of the Input Host profile.
 *
 * <p>This intent will have 3 extras:
 *
 * <ul>
 *   <li>{@link #EXTRA_STATE} - The current state of the profile.
 *   <li>{@link #EXTRA_PREVIOUS_STATE}- The previous state of the profile.
 *   <li>{@link android.bluetooth.BluetoothDevice#EXTRA_DEVICE BluetoothDevice#EXTRA_DEVICE} - The remote device.
 * </ul>
 *
 * <p>{@link #EXTRA_STATE} or {@link #EXTRA_PREVIOUS_STATE} can be any of {@link
 * #STATE_DISCONNECTED}, {@link #STATE_CONNECTING}, {@link #STATE_CONNECTED}, {@link
 * #STATE_DISCONNECTING}.
 *
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission to receive.
 * @apiSince 28
 */

public static final java.lang.String ACTION_CONNECTION_STATE_CHANGED = "android.bluetooth.hiddevice.profile.action.CONNECTION_STATE_CHANGED";

/**
 * Constant representing error response for Set Report due to "invalid parameter".
 *
 * @see android.bluetooth.BluetoothHidDevice.Callback#onSetReport(BluetoothDevice, byte, byte, byte[])
 * @apiSince 28
 */

public static final byte ERROR_RSP_INVALID_PARAM = 4; // 0x4

/**
 * Constant representing error response for Set Report due to "invalid report ID".
 *
 * @see android.bluetooth.BluetoothHidDevice.Callback#onSetReport(BluetoothDevice, byte, byte, byte[])
 * @apiSince 28
 */

public static final byte ERROR_RSP_INVALID_RPT_ID = 2; // 0x2

/**
 * Constant representing error response for Set Report due to "not ready".
 *
 * @see android.bluetooth.BluetoothHidDevice.Callback#onSetReport(BluetoothDevice, byte, byte, byte[])
 * @apiSince 28
 */

public static final byte ERROR_RSP_NOT_READY = 1; // 0x1

/**
 * Constant representing success response for Set Report.
 *
 * @see android.bluetooth.BluetoothHidDevice.Callback#onSetReport(BluetoothDevice, byte, byte, byte[])
 * @apiSince 28
 */

public static final byte ERROR_RSP_SUCCESS = 0; // 0x0

/**
 * Constant representing error response for Set Report with unknown reason.
 *
 * @see android.bluetooth.BluetoothHidDevice.Callback#onSetReport(BluetoothDevice, byte, byte, byte[])
 * @apiSince 28
 */

public static final byte ERROR_RSP_UNKNOWN = 14; // 0xe

/**
 * Constant representing error response for Set Report due to "unsupported request".
 *
 * @see android.bluetooth.BluetoothHidDevice.Callback#onSetReport(BluetoothDevice, byte, byte, byte[])
 * @apiSince 28
 */

public static final byte ERROR_RSP_UNSUPPORTED_REQ = 3; // 0x3

/**
 * Constant representing boot protocol mode used set by host. Default is always {@link
 * #PROTOCOL_REPORT_MODE} unless notified otherwise.
 *
 * @see android.bluetooth.BluetoothHidDevice.Callback#onSetProtocol(BluetoothDevice, byte)
 * @apiSince 28
 */

public static final byte PROTOCOL_BOOT_MODE = 0; // 0x0

/**
 * Constant representing report protocol mode used set by host. Default is always {@link
 * #PROTOCOL_REPORT_MODE} unless notified otherwise.
 *
 * @see android.bluetooth.BluetoothHidDevice.Callback#onSetProtocol(BluetoothDevice, byte)
 * @apiSince 28
 */

public static final byte PROTOCOL_REPORT_MODE = 1; // 0x1

/**
 * Constant representing HID Feature Report type.
 *
 * @see android.bluetooth.BluetoothHidDevice.Callback#onGetReport(BluetoothDevice, byte, byte, int)
 * @see android.bluetooth.BluetoothHidDevice.Callback#onSetReport(BluetoothDevice, byte, byte, byte[])
 * @see android.bluetooth.BluetoothHidDevice.Callback#onInterruptData(BluetoothDevice, byte, byte[])
 * @apiSince 28
 */

public static final byte REPORT_TYPE_FEATURE = 3; // 0x3

/**
 * Constant representing HID Input Report type.
 *
 * @see android.bluetooth.BluetoothHidDevice.Callback#onGetReport(BluetoothDevice, byte, byte, int)
 * @see android.bluetooth.BluetoothHidDevice.Callback#onSetReport(BluetoothDevice, byte, byte, byte[])
 * @see android.bluetooth.BluetoothHidDevice.Callback#onInterruptData(BluetoothDevice, byte, byte[])
 * @apiSince 28
 */

public static final byte REPORT_TYPE_INPUT = 1; // 0x1

/**
 * Constant representing HID Output Report type.
 *
 * @see android.bluetooth.BluetoothHidDevice.Callback#onGetReport(BluetoothDevice, byte, byte, int)
 * @see android.bluetooth.BluetoothHidDevice.Callback#onSetReport(BluetoothDevice, byte, byte, byte[])
 * @see android.bluetooth.BluetoothHidDevice.Callback#onInterruptData(BluetoothDevice, byte, byte[])
 * @apiSince 28
 */

public static final byte REPORT_TYPE_OUTPUT = 2; // 0x2

/**
 * Constant representing combo keyboard and mouse subclass.
 *
 * @see #registerApp (BluetoothHidDeviceAppQosSettings, BluetoothHidDeviceAppQosSettings,
 *     BluetoothHidDeviceAppQosSettings, Executor, Callback)
 * @apiSince 28
 */

public static final byte SUBCLASS1_COMBO = -64; // 0xffffffc0

/**
 * Constant representing keyboard subclass.
 *
 * @see #registerApp (BluetoothHidDeviceAppQosSettings, BluetoothHidDeviceAppQosSettings,
 *     BluetoothHidDeviceAppQosSettings, Executor, Callback)
 * @apiSince 28
 */

public static final byte SUBCLASS1_KEYBOARD = 64; // 0x40

/**
 * Constant representing mouse subclass.
 *
 * @see #registerApp (BluetoothHidDeviceAppQosSettings, BluetoothHidDeviceAppQosSettings,
 *     BluetoothHidDeviceAppQosSettings, Executor, Callback)
 * @apiSince 28
 */

public static final byte SUBCLASS1_MOUSE = -128; // 0xffffff80

/**
 * Constant representing unspecified HID device subclass.
 *
 * @see #registerApp (BluetoothHidDeviceAppQosSettings, BluetoothHidDeviceAppQosSettings,
 *     BluetoothHidDeviceAppQosSettings, Executor, Callback)
 * @apiSince 28
 */

public static final byte SUBCLASS1_NONE = 0; // 0x0

/**
 * Constant representing card reader subclass.
 *
 * @see #registerApp (BluetoothHidDeviceAppQosSettings, BluetoothHidDeviceAppQosSettings,
 *     BluetoothHidDeviceAppQosSettings, Executor, Callback)
 * @apiSince 28
 */

public static final byte SUBCLASS2_CARD_READER = 6; // 0x6

/**
 * Constant representing digitizer tablet subclass.
 *
 * @see #registerApp (BluetoothHidDeviceAppQosSettings, BluetoothHidDeviceAppQosSettings,
 *     BluetoothHidDeviceAppQosSettings, Executor, Callback)
 * @apiSince 28
 */

public static final byte SUBCLASS2_DIGITIZER_TABLET = 5; // 0x5

/**
 * Constant representing gamepad subclass.
 *
 * @see #registerApp (BluetoothHidDeviceAppQosSettings, BluetoothHidDeviceAppQosSettings,
 *     BluetoothHidDeviceAppQosSettings, Executor, Callback)
 * @apiSince 28
 */

public static final byte SUBCLASS2_GAMEPAD = 2; // 0x2

/**
 * Constant representing joystick subclass.
 *
 * @see #registerApp (BluetoothHidDeviceAppQosSettings, BluetoothHidDeviceAppQosSettings,
 *     BluetoothHidDeviceAppQosSettings, Executor, Callback)
 * @apiSince 28
 */

public static final byte SUBCLASS2_JOYSTICK = 1; // 0x1

/**
 * Constant representing remote control subclass.
 *
 * @see #registerApp (BluetoothHidDeviceAppQosSettings, BluetoothHidDeviceAppQosSettings,
 *     BluetoothHidDeviceAppQosSettings, Executor, Callback)
 * @apiSince 28
 */

public static final byte SUBCLASS2_REMOTE_CONTROL = 3; // 0x3

/**
 * Constant representing sensing device subclass.
 *
 * @see #registerApp (BluetoothHidDeviceAppQosSettings, BluetoothHidDeviceAppQosSettings,
 *     BluetoothHidDeviceAppQosSettings, Executor, Callback)
 * @apiSince 28
 */

public static final byte SUBCLASS2_SENSING_DEVICE = 4; // 0x4

/**
 * Constant representing uncategorized HID device subclass.
 *
 * @see #registerApp (BluetoothHidDeviceAppQosSettings, BluetoothHidDeviceAppQosSettings,
 *     BluetoothHidDeviceAppQosSettings, Executor, Callback)
 * @apiSince 28
 */

public static final byte SUBCLASS2_UNCATEGORIZED = 0; // 0x0
/**
 * The template class that applications use to call callback functions on events from the HID
 * host. Callback functions are wrapped in this class and registered to the Android system
 * during app registration.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class Callback {

public Callback() { throw new RuntimeException("Stub!"); }

/**
 * Callback called when application registration state changes. Usually it's called due to
 * either {@link android.bluetooth.BluetoothHidDevice#registerApp BluetoothHidDevice#registerApp} or {@link android.bluetooth.BluetoothHidDevice#unregisterApp() BluetoothHidDevice#unregisterApp()} , but can be also
 * unsolicited in case e.g. Bluetooth was turned off in which case application is
 * unregistered automatically.
 *
 * @param pluggedDevice {@link android.bluetooth.BluetoothDevice BluetoothDevice} object which represents host that currently
 *     has Virtual Cable established with device. Only valid when application is registered,
 *     can be <code>null</code>.
 * @param registered <code>true</code> if application is registered, <code>false</code>
 *     otherwise.
 * @apiSince 28
 */

public void onAppStatusChanged(android.bluetooth.BluetoothDevice pluggedDevice, boolean registered) { throw new RuntimeException("Stub!"); }

/**
 * Callback called when connection state with remote host was changed. Application can
 * assume than Virtual Cable is established when called with {@link android.bluetooth.BluetoothProfile#STATE_CONNECTED BluetoothProfile#STATE_CONNECTED} <code>state</code>.
 *
 * @param device {@link android.bluetooth.BluetoothDevice BluetoothDevice} object representing host device which connection
 *     state was changed.
 * @param state Connection state as defined in {@link android.bluetooth.BluetoothProfile BluetoothProfile}.
 * @apiSince 28
 */

public void onConnectionStateChanged(android.bluetooth.BluetoothDevice device, int state) { throw new RuntimeException("Stub!"); }

/**
 * Callback called when GET_REPORT is received from remote host. Should be replied by
 * application using {@link android.bluetooth.BluetoothHidDevice#replyReport(android.bluetooth.BluetoothDevice,byte,byte,byte[]) BluetoothHidDevice#replyReport(BluetoothDevice, byte, byte,
 * byte[])}.
 *
 * @param type Requested Report Type.
 * @param id Requested Report Id, can be 0 if no Report Id are defined in descriptor.
 * @param bufferSize Requested buffer size, application shall respond with at least given
 *     number of bytes.
 * @apiSince 28
 */

public void onGetReport(android.bluetooth.BluetoothDevice device, byte type, byte id, int bufferSize) { throw new RuntimeException("Stub!"); }

/**
 * Callback called when SET_REPORT is received from remote host. In case received data are
 * invalid, application shall respond with {@link android.bluetooth.BluetoothHidDevice#reportError(android.bluetooth.BluetoothDevice,byte) BluetoothHidDevice#reportError(BluetoothDevice, byte)}.
 *
 * @param type Report Type.
 * @param id Report Id.
 * @param data Report data.
 * @apiSince 28
 */

public void onSetReport(android.bluetooth.BluetoothDevice device, byte type, byte id, byte[] data) { throw new RuntimeException("Stub!"); }

/**
 * Callback called when SET_PROTOCOL is received from remote host. Application shall use
 * this information to send only reports valid for given protocol mode. By default, {@link android.bluetooth.BluetoothHidDevice#PROTOCOL_REPORT_MODE BluetoothHidDevice#PROTOCOL_REPORT_MODE} shall be assumed.
 *
 * @param protocol Protocol Mode.
 * @apiSince 28
 */

public void onSetProtocol(android.bluetooth.BluetoothDevice device, byte protocol) { throw new RuntimeException("Stub!"); }

/**
 * Callback called when report data is received over interrupt channel. Report Type is
 * assumed to be {@link android.bluetooth.BluetoothHidDevice#REPORT_TYPE_OUTPUT BluetoothHidDevice#REPORT_TYPE_OUTPUT}.
 *
 * @param reportId Report Id.
 * @param data Report data.
 * @apiSince 28
 */

public void onInterruptData(android.bluetooth.BluetoothDevice device, byte reportId, byte[] data) { throw new RuntimeException("Stub!"); }

/**
 * Callback called when Virtual Cable is removed. After this callback is received connection
 * will be disconnected automatically.
 * @apiSince 28
 */

public void onVirtualCableUnplug(android.bluetooth.BluetoothDevice device) { throw new RuntimeException("Stub!"); }
}

}

