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

import android.Manifest;

/**
 * Public API for controlling the Bluetooth Headset Service. This includes both
 * Bluetooth Headset and Handsfree (v1.5) profiles.
 *
 * <p>BluetoothHeadset is a proxy object for controlling the Bluetooth Headset
 * Service via IPC.
 *
 * <p> Use {@link android.bluetooth.BluetoothAdapter#getProfileProxy BluetoothAdapter#getProfileProxy} to get
 * the BluetoothHeadset proxy object. Use
 * {@link android.bluetooth.BluetoothAdapter#closeProfileProxy BluetoothAdapter#closeProfileProxy} to close the service connection.
 *
 * <p> Android only supports one connected Bluetooth Headset at a time.
 * Each method is protected with its appropriate permission.
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class BluetoothHeadset implements android.bluetooth.BluetoothProfile {

BluetoothHeadset() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 11
 */

public java.util.List<android.bluetooth.BluetoothDevice> getConnectedDevices() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 11
 */

public java.util.List<android.bluetooth.BluetoothDevice> getDevicesMatchingConnectionStates(int[] states) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 11
 */

public int getConnectionState(android.bluetooth.BluetoothDevice device) { throw new RuntimeException("Stub!"); }

/**
 * Start Bluetooth voice recognition. This methods sends the voice
 * recognition AT command to the headset and establishes the
 * audio connection.
 *
 * <p> Users can listen to {@link #ACTION_AUDIO_STATE_CHANGED}.
 * If this function returns true, this intent will be broadcasted with
 * {@link #EXTRA_STATE} set to {@link #STATE_AUDIO_CONNECTING}.
 *
 * <p> {@link #EXTRA_STATE} will transition from
 * {@link #STATE_AUDIO_CONNECTING} to {@link #STATE_AUDIO_CONNECTED} when
 * audio connection is established and to {@link #STATE_AUDIO_DISCONNECTED}
 * in case of failure to establish the audio connection.
 *
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
 *
 * @param device Bluetooth headset
 * @return false if there is no headset connected, or the connected headset doesn't support
 * voice recognition, or voice recognition is already started, or audio channel is occupied,
 * or on error, true otherwise
 * @apiSince 11
 */

public boolean startVoiceRecognition(android.bluetooth.BluetoothDevice device) { throw new RuntimeException("Stub!"); }

/**
 * Stop Bluetooth Voice Recognition mode, and shut down the
 * Bluetooth audio path.
 *
 * <p> Users can listen to {@link #ACTION_AUDIO_STATE_CHANGED}.
 * If this function returns true, this intent will be broadcasted with
 * {@link #EXTRA_STATE} set to {@link #STATE_AUDIO_DISCONNECTED}.
 *
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
 *
 * @param device Bluetooth headset
 * @return false if there is no headset connected, or voice recognition has not started,
 * or voice recognition has ended on this headset, or on error, true otherwise
 * @apiSince 11
 */

public boolean stopVoiceRecognition(android.bluetooth.BluetoothDevice device) { throw new RuntimeException("Stub!"); }

/**
 * Check if Bluetooth SCO audio is connected.
 *
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
 *
 * @param device Bluetooth headset
 * @return true if SCO is connected, false otherwise or on error
 * @apiSince 11
 */

public boolean isAudioConnected(android.bluetooth.BluetoothDevice device) { throw new RuntimeException("Stub!"); }

/**
 * Sends a vendor-specific unsolicited result code to the headset.
 *
 * <p>The actual string to be sent is <code>command + ": " + arg</code>. For example, if {@code
 * command} is {@link #VENDOR_RESULT_CODE_COMMAND_ANDROID} and {@code arg} is {@code "0"}, the
 * string <code>"+ANDROID: 0"</code> will be sent.
 *
 * <p>Currently only {@link #VENDOR_RESULT_CODE_COMMAND_ANDROID} is allowed as {@code command}.
 *
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
 *
 * @param device Bluetooth headset.
 * @param command A vendor-specific command.
 * @param arg The argument that will be attached to the command.
 * @return {@code false} if there is no headset connected, or if the command is not an allowed
 * vendor-specific unsolicited result code, or on error. {@code true} otherwise.
 * @throws java.lang.IllegalArgumentException if {@code command} is {@code null}.
 * @apiSince 19
 */

public boolean sendVendorSpecificResultCode(android.bluetooth.BluetoothDevice device, java.lang.String command, java.lang.String arg) { throw new RuntimeException("Stub!"); }

/**
 * Intent used to broadcast the change in the Audio Connection state of the
 * A2DP profile.
 *
 * <p>This intent will have 3 extras:
 * <ul>
 * <li> {@link #EXTRA_STATE} - The current state of the profile. </li>
 * <li> {@link #EXTRA_PREVIOUS_STATE}- The previous state of the profile. </li>
 * <li> {@link android.bluetooth.BluetoothDevice#EXTRA_DEVICE BluetoothDevice#EXTRA_DEVICE} - The remote device. </li>
 * </ul>
 * <p>{@link #EXTRA_STATE} or {@link #EXTRA_PREVIOUS_STATE} can be any of
 * {@link #STATE_AUDIO_CONNECTED}, {@link #STATE_AUDIO_DISCONNECTED},
 *
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission
 * to receive.
 * @apiSince 11
 */

public static final java.lang.String ACTION_AUDIO_STATE_CHANGED = "android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED";

/**
 * Intent used to broadcast the change in connection state of the Headset
 * profile.
 *
 * <p>This intent will have 3 extras:
 * <ul>
 * <li> {@link #EXTRA_STATE} - The current state of the profile. </li>
 * <li> {@link #EXTRA_PREVIOUS_STATE}- The previous state of the profile. </li>
 * <li> {@link android.bluetooth.BluetoothDevice#EXTRA_DEVICE BluetoothDevice#EXTRA_DEVICE} - The remote device. </li>
 * </ul>
 * <p>{@link #EXTRA_STATE} or {@link #EXTRA_PREVIOUS_STATE} can be any of
 * {@link #STATE_DISCONNECTED}, {@link #STATE_CONNECTING},
 * {@link #STATE_CONNECTED}, {@link #STATE_DISCONNECTING}.
 *
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission to
 * receive.
 * @apiSince 11
 */

public static final java.lang.String ACTION_CONNECTION_STATE_CHANGED = "android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED";

/**
 * Intent used to broadcast that the headset has posted a
 * vendor-specific event.
 *
 * <p>This intent will have 4 extras and 1 category.
 * <ul>
 * <li> {@link android.bluetooth.BluetoothDevice#EXTRA_DEVICE BluetoothDevice#EXTRA_DEVICE} - The remote Bluetooth Device
 * </li>
 * <li> {@link #EXTRA_VENDOR_SPECIFIC_HEADSET_EVENT_CMD} - The vendor
 * specific command </li>
 * <li> {@link #EXTRA_VENDOR_SPECIFIC_HEADSET_EVENT_CMD_TYPE} - The AT
 * command type which can be one of  {@link #AT_CMD_TYPE_READ},
 * {@link #AT_CMD_TYPE_TEST}, or {@link #AT_CMD_TYPE_SET},
 * {@link #AT_CMD_TYPE_BASIC},{@link #AT_CMD_TYPE_ACTION}. </li>
 * <li> {@link #EXTRA_VENDOR_SPECIFIC_HEADSET_EVENT_ARGS} - Command
 * arguments. </li>
 * </ul>
 *
 * <p> The category is the Company ID of the vendor defining the
 * vendor-specific command. {@link android.bluetooth.BluetoothAssignedNumbers BluetoothAssignedNumbers}
 *
 * For example, for Plantronics specific events
 * Category will be {@link #VENDOR_SPECIFIC_HEADSET_EVENT_COMPANY_ID_CATEGORY}.55
 *
 * <p> For example, an AT+XEVENT=foo,3 will get translated into
 * <ul>
 * <li> EXTRA_VENDOR_SPECIFIC_HEADSET_EVENT_CMD = +XEVENT </li>
 * <li> EXTRA_VENDOR_SPECIFIC_HEADSET_EVENT_CMD_TYPE = AT_CMD_TYPE_SET </li>
 * <li> EXTRA_VENDOR_SPECIFIC_HEADSET_EVENT_ARGS = foo, 3 </li>
 * </ul>
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission
 * to receive.
 * @apiSince 11
 */

public static final java.lang.String ACTION_VENDOR_SPECIFIC_HEADSET_EVENT = "android.bluetooth.headset.action.VENDOR_SPECIFIC_HEADSET_EVENT";

/**
 * AT command type ACTION used with
 * {@link #EXTRA_VENDOR_SPECIFIC_HEADSET_EVENT_CMD_TYPE}
 * For example, AT+CHUP. There are no arguments for action commands.
 * @apiSince 11
 */

public static final int AT_CMD_TYPE_ACTION = 4; // 0x4

/**
 * AT command type BASIC used with
 * {@link #EXTRA_VENDOR_SPECIFIC_HEADSET_EVENT_CMD_TYPE}
 * For example, ATD. Single character commands and everything following the
 * character are arguments.
 * @apiSince 11
 */

public static final int AT_CMD_TYPE_BASIC = 3; // 0x3

/**
 * AT command type READ used with
 * {@link #EXTRA_VENDOR_SPECIFIC_HEADSET_EVENT_CMD_TYPE}
 * For example, AT+VGM?. There are no arguments for this command type.
 * @apiSince 11
 */

public static final int AT_CMD_TYPE_READ = 0; // 0x0

/**
 * AT command type SET used with
 * {@link #EXTRA_VENDOR_SPECIFIC_HEADSET_EVENT_CMD_TYPE}
 * For example, AT+VGM=<args>.
 * @apiSince 11
 */

public static final int AT_CMD_TYPE_SET = 2; // 0x2

/**
 * AT command type TEST used with
 * {@link #EXTRA_VENDOR_SPECIFIC_HEADSET_EVENT_CMD_TYPE}
 * For example, AT+VGM=?. There are no arguments for this command type.
 * @apiSince 11
 */

public static final int AT_CMD_TYPE_TEST = 1; // 0x1

/**
 * A Parcelable String array extra field in
 * {@link #ACTION_VENDOR_SPECIFIC_HEADSET_EVENT} intents that contains
 * the arguments to the vendor-specific command.
 * @apiSince 11
 */

public static final java.lang.String EXTRA_VENDOR_SPECIFIC_HEADSET_EVENT_ARGS = "android.bluetooth.headset.extra.VENDOR_SPECIFIC_HEADSET_EVENT_ARGS";

/**
 * A String extra field in {@link #ACTION_VENDOR_SPECIFIC_HEADSET_EVENT}
 * intents that contains the name of the vendor-specific command.
 * @apiSince 11
 */

public static final java.lang.String EXTRA_VENDOR_SPECIFIC_HEADSET_EVENT_CMD = "android.bluetooth.headset.extra.VENDOR_SPECIFIC_HEADSET_EVENT_CMD";

/**
 * An int extra field in {@link #ACTION_VENDOR_SPECIFIC_HEADSET_EVENT}
 * intents that contains the AT command type of the vendor-specific command.
 * @apiSince 11
 */

public static final java.lang.String EXTRA_VENDOR_SPECIFIC_HEADSET_EVENT_CMD_TYPE = "android.bluetooth.headset.extra.VENDOR_SPECIFIC_HEADSET_EVENT_CMD_TYPE";

/**
 * Headset state when SCO audio is connected.
 * This state can be one of
 * {@link #EXTRA_STATE} or {@link #EXTRA_PREVIOUS_STATE} of
 * {@link #ACTION_AUDIO_STATE_CHANGED} intent.
 * @apiSince 11
 */

public static final int STATE_AUDIO_CONNECTED = 12; // 0xc

/**
 * Headset state when SCO audio is connecting.
 * This state can be one of
 * {@link #EXTRA_STATE} or {@link #EXTRA_PREVIOUS_STATE} of
 * {@link #ACTION_AUDIO_STATE_CHANGED} intent.
 * @apiSince 11
 */

public static final int STATE_AUDIO_CONNECTING = 11; // 0xb

/**
 * Headset state when SCO audio is not connected.
 * This state can be one of
 * {@link #EXTRA_STATE} or {@link #EXTRA_PREVIOUS_STATE} of
 * {@link #ACTION_AUDIO_STATE_CHANGED} intent.
 * @apiSince 11
 */

public static final int STATE_AUDIO_DISCONNECTED = 10; // 0xa

/**
 * A vendor-specific command for unsolicited result code.
 * @apiSince 19
 */

public static final java.lang.String VENDOR_RESULT_CODE_COMMAND_ANDROID = "+ANDROID";

/**
 * The intent category to be used with {@link #ACTION_VENDOR_SPECIFIC_HEADSET_EVENT}
 * for the companyId
 * @apiSince 11
 */

public static final java.lang.String VENDOR_SPECIFIC_HEADSET_EVENT_COMPANY_ID_CATEGORY = "android.bluetooth.headset.intent.category.companyid";
}

