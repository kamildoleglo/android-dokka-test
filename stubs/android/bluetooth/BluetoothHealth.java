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


package android.bluetooth;

import android.os.ParcelFileDescriptor;
import java.util.List;

/**
 * Public API for Bluetooth Health Profile.
 *
 * <p>BluetoothHealth is a proxy object for controlling the Bluetooth
 * Service via IPC.
 *
 * <p> How to connect to a health device which is acting in the source role.
 * <li> Use {@link android.bluetooth.BluetoothAdapter#getProfileProxy BluetoothAdapter#getProfileProxy} to get
 * the BluetoothHealth proxy object. </li>
 * <li> Create an {@link android.bluetooth.BluetoothHealth BluetoothHealth} callback and call
 * {@link #registerSinkAppConfiguration} to register an application
 * configuration </li>
 * <li> Pair with the remote device. This currently needs to be done manually
 * from Bluetooth Settings </li>
 * <li> Connect to a health device using {@link #connectChannelToSource}. Some
 * devices will connect the channel automatically. The {@link android.bluetooth.BluetoothHealth BluetoothHealth}
 * callback will inform the application of channel state change. </li>
 * <li> Use the file descriptor provided with a connected channel to read and
 * write data to the health channel. </li>
 * <li> The received data needs to be interpreted using a health manager which
 * implements the IEEE 11073-xxxxx specifications.
 * <li> When done, close the health channel by calling {@link #disconnectChannel}
 * and unregister the application configuration calling
 * {@link #unregisterAppConfiguration}
 *
 * @deprecated Health Device Profile (HDP) and MCAP protocol are no longer used. New apps
 * should use Bluetooth Low Energy based solutions such as {@link android.bluetooth.BluetoothGatt BluetoothGatt},
 * {@link android.bluetooth.BluetoothAdapter#listenUsingL2capChannel() BluetoothAdapter#listenUsingL2capChannel()}, or
 * {@link android.bluetooth.BluetoothDevice#createL2capChannel(int) BluetoothDevice#createL2capChannel(int)}
 * @apiSince 14
 * @deprecatedSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public final class BluetoothHealth implements android.bluetooth.BluetoothProfile {

BluetoothHealth() { throw new RuntimeException("Stub!"); }

/**
 * Register an application configuration that acts as a Health SINK.
 * This is the configuration that will be used to communicate with health devices
 * which will act as the {@link #SOURCE_ROLE}. This is an asynchronous call and so
 * the callback is used to notify success or failure if the function returns true.
 *
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
 *
 * @param name The friendly name associated with the application or configuration.
 * @param dataType The dataType of the Source role of Health Profile to which the sink wants to
 * connect to.
 * @param callback A callback to indicate success or failure of the registration and all
 * operations done on this application configuration.
 * @return If true, callback will be called.
 *
 * @deprecated Health Device Profile (HDP) and MCAP protocol are no longer used. New
 * apps should use Bluetooth Low Energy based solutions such as {@link android.bluetooth.BluetoothGatt BluetoothGatt},
 * {@link android.bluetooth.BluetoothAdapter#listenUsingL2capChannel() BluetoothAdapter#listenUsingL2capChannel()}, or
 * {@link android.bluetooth.BluetoothDevice#createL2capChannel(int) BluetoothDevice#createL2capChannel(int)}
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated
public boolean registerSinkAppConfiguration(java.lang.String name, int dataType, android.bluetooth.BluetoothHealthCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Unregister an application configuration that has been registered using
 * {@link #registerSinkAppConfiguration}
 *
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
 *
 * @param config The health app configuration
 * @return Success or failure.
 *
 * @deprecated Health Device Profile (HDP) and MCAP protocol are no longer used. New
 * apps should use Bluetooth Low Energy based solutions such as {@link android.bluetooth.BluetoothGatt BluetoothGatt},
 * {@link android.bluetooth.BluetoothAdapter#listenUsingL2capChannel() BluetoothAdapter#listenUsingL2capChannel()}, or
 * {@link android.bluetooth.BluetoothDevice#createL2capChannel(int) BluetoothDevice#createL2capChannel(int)}
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated
public boolean unregisterAppConfiguration(android.bluetooth.BluetoothHealthAppConfiguration config) { throw new RuntimeException("Stub!"); }

/**
 * Connect to a health device which has the {@link #SOURCE_ROLE}.
 * This is an asynchronous call. If this function returns true, the callback
 * associated with the application configuration will be called.
 *
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
 *
 * @param device The remote Bluetooth device.
 * @param config The application configuration which has been registered using {@link
 * #registerSinkAppConfiguration(java.lang.String,int,android.bluetooth.BluetoothHealthCallback) }
 * @return If true, the callback associated with the application config will be called.
 *
 * @deprecated Health Device Profile (HDP) and MCAP protocol are no longer used. New
 * apps should use Bluetooth Low Energy based solutions such as {@link android.bluetooth.BluetoothGatt BluetoothGatt},
 * {@link android.bluetooth.BluetoothAdapter#listenUsingL2capChannel() BluetoothAdapter#listenUsingL2capChannel()}, or
 * {@link android.bluetooth.BluetoothDevice#createL2capChannel(int) BluetoothDevice#createL2capChannel(int)}
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated
public boolean connectChannelToSource(android.bluetooth.BluetoothDevice device, android.bluetooth.BluetoothHealthAppConfiguration config) { throw new RuntimeException("Stub!"); }

/**
 * Disconnect a connected health channel.
 * This is an asynchronous call. If this function returns true, the callback
 * associated with the application configuration will be called.
 *
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
 *
 * @param device The remote Bluetooth device.
 * @param config The application configuration which has been registered using {@link
 * #registerSinkAppConfiguration(java.lang.String,int,android.bluetooth.BluetoothHealthCallback) }
 * @param channelId The channel id associated with the channel
 * @return If true, the callback associated with the application config will be called.
 *
 * @deprecated Health Device Profile (HDP) and MCAP protocol are no longer used. New
 * apps should use Bluetooth Low Energy based solutions such as {@link android.bluetooth.BluetoothGatt BluetoothGatt},
 * {@link android.bluetooth.BluetoothAdapter#listenUsingL2capChannel() BluetoothAdapter#listenUsingL2capChannel()}, or
 * {@link android.bluetooth.BluetoothDevice#createL2capChannel(int) BluetoothDevice#createL2capChannel(int)}
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated
public boolean disconnectChannel(android.bluetooth.BluetoothDevice device, android.bluetooth.BluetoothHealthAppConfiguration config, int channelId) { throw new RuntimeException("Stub!"); }

/**
 * Get the file descriptor of the main channel associated with the remote device
 * and application configuration.
 *
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
 *
 * <p> Its the responsibility of the caller to close the ParcelFileDescriptor
 * when done.
 *
 * @param device The remote Bluetooth health device
 * @param config The application configuration
 * @return null on failure, ParcelFileDescriptor on success.
 *
 * @deprecated Health Device Profile (HDP) and MCAP protocol are no longer used. New
 * apps should use Bluetooth Low Energy based solutions such as {@link android.bluetooth.BluetoothGatt BluetoothGatt},
 * {@link android.bluetooth.BluetoothAdapter#listenUsingL2capChannel() BluetoothAdapter#listenUsingL2capChannel()}, or
 * {@link android.bluetooth.BluetoothDevice#createL2capChannel(int) BluetoothDevice#createL2capChannel(int)}
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated
public android.os.ParcelFileDescriptor getMainChannelFd(android.bluetooth.BluetoothDevice device, android.bluetooth.BluetoothHealthAppConfiguration config) { throw new RuntimeException("Stub!"); }

/**
 * Get the current connection state of the profile.
 *
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
 *
 * This is not specific to any application configuration but represents the connection
 * state of the local Bluetooth adapter with the remote device. This can be used
 * by applications like status bar which would just like to know the state of the
 * local adapter.
 *
 * @param device Remote bluetooth device.
 * @return State of the profile connection. One of {@link #STATE_CONNECTED}, {@link
 * #STATE_CONNECTING}, {@link #STATE_DISCONNECTED}, {@link #STATE_DISCONNECTING}
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated
public int getConnectionState(android.bluetooth.BluetoothDevice device) { throw new RuntimeException("Stub!"); }

/**
 * Get connected devices for the health profile.
 *
 * <p> Return the set of devices which are in state {@link #STATE_CONNECTED}
 *
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
 *
 * This is not specific to any application configuration but represents the connection
 * state of the local Bluetooth adapter for this profile. This can be used
 * by applications like status bar which would just like to know the state of the
 * local adapter.
 *
 * @return List of devices. The list will be empty on error.
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated
public java.util.List<android.bluetooth.BluetoothDevice> getConnectedDevices() { throw new RuntimeException("Stub!"); }

/**
 * Get a list of devices that match any of the given connection
 * states.
 *
 * <p> If none of the devices match any of the given states,
 * an empty list will be returned.
 *
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
 * This is not specific to any application configuration but represents the connection
 * state of the local Bluetooth adapter for this profile. This can be used
 * by applications like status bar which would just like to know the state of the
 * local adapter.
 *
 * @param states Array of states. States can be one of {@link #STATE_CONNECTED}, {@link
 * #STATE_CONNECTING}, {@link #STATE_DISCONNECTED}, {@link #STATE_DISCONNECTING},
 * @return List of devices. The list will be empty on error.
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated
public java.util.List<android.bluetooth.BluetoothDevice> getDevicesMatchingConnectionStates(int[] states) { throw new RuntimeException("Stub!"); }

/** Health App Configuration registration failure
 *
 * @deprecated Health Device Profile (HDP) and MCAP protocol are no longer used. New
 * apps should use Bluetooth Low Energy based solutions such as {@link android.bluetooth.BluetoothGatt BluetoothGatt},
 * {@link android.bluetooth.BluetoothAdapter#listenUsingL2capChannel() BluetoothAdapter#listenUsingL2capChannel()}, or
 * {@link android.bluetooth.BluetoothDevice#createL2capChannel(int) BluetoothDevice#createL2capChannel(int)}
 @apiSince 14
 @deprecatedSince 29
 */

@Deprecated public static final int APP_CONFIG_REGISTRATION_FAILURE = 1; // 0x1

/** Health App Configuration registration success
 *
 * @deprecated Health Device Profile (HDP) and MCAP protocol are no longer used. New
 * apps should use Bluetooth Low Energy based solutions such as {@link android.bluetooth.BluetoothGatt BluetoothGatt},
 * {@link android.bluetooth.BluetoothAdapter#listenUsingL2capChannel() BluetoothAdapter#listenUsingL2capChannel()}, or
 * {@link android.bluetooth.BluetoothDevice#createL2capChannel(int) BluetoothDevice#createL2capChannel(int)}
 @apiSince 14
 @deprecatedSince 29
 */

@Deprecated public static final int APP_CONFIG_REGISTRATION_SUCCESS = 0; // 0x0

/** Health App Configuration un-registration failure
 *
 * @deprecated Health Device Profile (HDP) and MCAP protocol are no longer used. New
 * apps should use Bluetooth Low Energy based solutions such as {@link android.bluetooth.BluetoothGatt BluetoothGatt},
 * {@link android.bluetooth.BluetoothAdapter#listenUsingL2capChannel() BluetoothAdapter#listenUsingL2capChannel()}, or
 * {@link android.bluetooth.BluetoothDevice#createL2capChannel(int) BluetoothDevice#createL2capChannel(int)}
 @apiSince 14
 @deprecatedSince 29
 */

@Deprecated public static final int APP_CONFIG_UNREGISTRATION_FAILURE = 3; // 0x3

/** Health App Configuration un-registration success
 *
 * @deprecated Health Device Profile (HDP) and MCAP protocol are no longer used. New
 * apps should use Bluetooth Low Energy based solutions such as {@link android.bluetooth.BluetoothGatt BluetoothGatt},
 * {@link android.bluetooth.BluetoothAdapter#listenUsingL2capChannel() BluetoothAdapter#listenUsingL2capChannel()}, or
 * {@link android.bluetooth.BluetoothDevice#createL2capChannel(int) BluetoothDevice#createL2capChannel(int)}
 @apiSince 14
 @deprecatedSince 29
 */

@Deprecated public static final int APP_CONFIG_UNREGISTRATION_SUCCESS = 2; // 0x2

/**
 * Health Profile - Channel Type used - Reliable
 *
 * @deprecated Health Device Profile (HDP) and MCAP protocol are no longer used. New
 * apps should use Bluetooth Low Energy based solutions such as {@link android.bluetooth.BluetoothGatt BluetoothGatt},
 * {@link android.bluetooth.BluetoothAdapter#listenUsingL2capChannel() BluetoothAdapter#listenUsingL2capChannel()}, or
 * {@link android.bluetooth.BluetoothDevice#createL2capChannel(int) BluetoothDevice#createL2capChannel(int)}
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated public static final int CHANNEL_TYPE_RELIABLE = 10; // 0xa

/**
 * Health Profile - Channel Type used - Streaming
 *
 * @deprecated Health Device Profile (HDP) and MCAP protocol are no longer used. New
 * apps should use Bluetooth Low Energy based solutions such as {@link android.bluetooth.BluetoothGatt BluetoothGatt},
 * {@link android.bluetooth.BluetoothAdapter#listenUsingL2capChannel() BluetoothAdapter#listenUsingL2capChannel()}, or
 * {@link android.bluetooth.BluetoothDevice#createL2capChannel(int) BluetoothDevice#createL2capChannel(int)}
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated public static final int CHANNEL_TYPE_STREAMING = 11; // 0xb

/**
 * Health Profile Sink Role the device talking to the health device.
 *
 * @deprecated Health Device Profile (HDP) and MCAP protocol are no longer used. New
 * apps should use Bluetooth Low Energy based solutions such as {@link android.bluetooth.BluetoothGatt BluetoothGatt},
 * {@link android.bluetooth.BluetoothAdapter#listenUsingL2capChannel() BluetoothAdapter#listenUsingL2capChannel()}, or
 * {@link android.bluetooth.BluetoothDevice#createL2capChannel(int) BluetoothDevice#createL2capChannel(int)}
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated public static final int SINK_ROLE = 2; // 0x2

/**
 * Health Profile Source Role - the health device.
 *
 * @deprecated Health Device Profile (HDP) and MCAP protocol are no longer used. New
 * apps should use Bluetooth Low Energy based solutions such as {@link android.bluetooth.BluetoothGatt BluetoothGatt},
 * {@link android.bluetooth.BluetoothAdapter#listenUsingL2capChannel() BluetoothAdapter#listenUsingL2capChannel()}, or
 * {@link android.bluetooth.BluetoothDevice#createL2capChannel(int) BluetoothDevice#createL2capChannel(int)}
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated public static final int SOURCE_ROLE = 1; // 0x1

/** Health Channel Connection State - Connected
 *
 * @deprecated Health Device Profile (HDP) and MCAP protocol are no longer used. New
 * apps should use Bluetooth Low Energy based solutions such as {@link android.bluetooth.BluetoothGatt BluetoothGatt},
 * {@link android.bluetooth.BluetoothAdapter#listenUsingL2capChannel() BluetoothAdapter#listenUsingL2capChannel()}, or
 * {@link android.bluetooth.BluetoothDevice#createL2capChannel(int) BluetoothDevice#createL2capChannel(int)}
 @apiSince 14
 @deprecatedSince 29
 */

@Deprecated public static final int STATE_CHANNEL_CONNECTED = 2; // 0x2

/** Health Channel Connection State - Connecting
 *
 * @deprecated Health Device Profile (HDP) and MCAP protocol are no longer used. New
 * apps should use Bluetooth Low Energy based solutions such as {@link android.bluetooth.BluetoothGatt BluetoothGatt},
 * {@link android.bluetooth.BluetoothAdapter#listenUsingL2capChannel() BluetoothAdapter#listenUsingL2capChannel()}, or
 * {@link android.bluetooth.BluetoothDevice#createL2capChannel(int) BluetoothDevice#createL2capChannel(int)}
 @apiSince 14
 @deprecatedSince 29
 */

@Deprecated public static final int STATE_CHANNEL_CONNECTING = 1; // 0x1

/** Health Channel Connection State - Disconnected
 *
 * @deprecated Health Device Profile (HDP) and MCAP protocol are no longer used. New
 * apps should use Bluetooth Low Energy based solutions such as {@link android.bluetooth.BluetoothGatt BluetoothGatt},
 * {@link android.bluetooth.BluetoothAdapter#listenUsingL2capChannel() BluetoothAdapter#listenUsingL2capChannel()}, or
 * {@link android.bluetooth.BluetoothDevice#createL2capChannel(int) BluetoothDevice#createL2capChannel(int)}
 @apiSince 14
 @deprecatedSince 29
 */

@Deprecated public static final int STATE_CHANNEL_DISCONNECTED = 0; // 0x0

/** Health Channel Connection State - Disconnecting
 *
 * @deprecated Health Device Profile (HDP) and MCAP protocol are no longer used. New
 * apps should use Bluetooth Low Energy based solutions such as {@link android.bluetooth.BluetoothGatt BluetoothGatt},
 * {@link android.bluetooth.BluetoothAdapter#listenUsingL2capChannel() BluetoothAdapter#listenUsingL2capChannel()}, or
 * {@link android.bluetooth.BluetoothDevice#createL2capChannel(int) BluetoothDevice#createL2capChannel(int)}
 @apiSince 14
 @deprecatedSince 29
 */

@Deprecated public static final int STATE_CHANNEL_DISCONNECTING = 3; // 0x3
}

