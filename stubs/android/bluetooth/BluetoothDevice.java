/*
 * Copyright (C) 2009 The Android Open Source Project
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
import java.util.UUID;
import java.io.IOException;
import android.os.Parcelable;
import android.os.ParcelUuid;

/**
 * Represents a remote Bluetooth device. A {@link android.bluetooth.BluetoothDevice BluetoothDevice} lets you
 * create a connection with the respective device or query information about
 * it, such as the name, address, class, and bonding state.
 *
 * <p>This class is really just a thin wrapper for a Bluetooth hardware
 * address. Objects of this class are immutable. Operations on this class
 * are performed on the remote Bluetooth hardware address, using the
 * {@link android.bluetooth.BluetoothAdapter BluetoothAdapter} that was used to create this {@link android.bluetooth.BluetoothDevice BluetoothDevice}.
 *
 * <p>To get a {@link android.bluetooth.BluetoothDevice BluetoothDevice}, use
 * {@link android.bluetooth.BluetoothAdapter#getRemoteDevice(java.lang.String) BluetoothAdapter#getRemoteDevice(String)} to create one representing a device
 * of a known MAC address (which you can get through device discovery with
 * {@link android.bluetooth.BluetoothAdapter BluetoothAdapter}) or get one from the set of bonded devices
 * returned by {@link android.bluetooth.BluetoothAdapter#getBondedDevices() BluetoothAdapter#getBondedDevices()}. You can then open a
 * {@link android.bluetooth.BluetoothSocket BluetoothSocket} for communication with the remote device, using
 * {@link #createRfcommSocketToServiceRecord(java.util.UUID)} over Bluetooth BR/EDR or using
 * {@link #createL2capChannel(int)} over Bluetooth LE.
 *
 * <p class="note"><strong>Note:</strong>
 * Requires the {@link android.Manifest.permission#BLUETOOTH} permission.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>
 * For more information about using Bluetooth, read the <a href=
 * "{@docRoot}guide/topics/connectivity/bluetooth.html">Bluetooth</a> developer
 * guide.
 * </p>
 * </div>
 *
 * {@see BluetoothAdapter}
 * {@see BluetoothSocket}
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class BluetoothDevice implements android.os.Parcelable {

BluetoothDevice() { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of this BluetoothDevice.
 * <p>Currently this is the Bluetooth hardware address, for example
 * "00:11:22:AA:BB:CC". However, you should always use {@link #getAddress}
 * if you explicitly require the Bluetooth hardware address in case the
 * {@link #toString} representation changes in the future.
 *
 * @return string representation of this BluetoothDevice
 * @apiSince 5
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Returns the hardware address of this BluetoothDevice.
 * <p> For example, "00:11:22:AA:BB:CC".
 *
 * @return Bluetooth hardware address as string
 * @apiSince 5
 */

public java.lang.String getAddress() { throw new RuntimeException("Stub!"); }

/**
 * Get the friendly Bluetooth name of the remote device.
 *
 * <p>The local adapter will automatically retrieve remote names when
 * performing a device scan, and will cache them. This method just returns
 * the name for this device from the cache.
 *
 * <br>
 * Requires {@link android.Manifest.permission#BLUETOOTH}
 * @return the Bluetooth name, or null if there was a problem.
 * @apiSince 5
 */

public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * Get the Bluetooth device type of the remote device.
 *
 * <br>
 * Requires {@link android.Manifest.permission#BLUETOOTH}
 * @return the device type {@link #DEVICE_TYPE_CLASSIC}, {@link #DEVICE_TYPE_LE} {@link
 * #DEVICE_TYPE_DUAL}. {@link #DEVICE_TYPE_UNKNOWN} if it's not available
 * @apiSince 18
 */

public int getType() { throw new RuntimeException("Stub!"); }

/**
 * Get the Bluetooth alias of the remote device.
 * <p>Alias is the locally modified name of a remote device.
 *
 * <br>
 * Requires {@link android.Manifest.permission#BLUETOOTH}
 * @return the Bluetooth alias, the friendly device name if no alias, or
 * null if there was a problem
 * @apiSince R
 */

@androidx.annotation.Nullable
public java.lang.String getAlias() { throw new RuntimeException("Stub!"); }

/**
 * Start the bonding (pairing) process with the remote device.
 * <p>This is an asynchronous call, it will return immediately. Register
 * for {@link #ACTION_BOND_STATE_CHANGED} intents to be notified when
 * the bonding process completes, and its result.
 * <p>Android system services will handle the necessary user interactions
 * to confirm and complete the bonding process.
 *
 * <br>
 * Requires {@link android.Manifest.permission#BLUETOOTH_ADMIN}
 * @return false on immediate error, true if bonding will begin
 * @apiSince 19
 */

public boolean createBond() { throw new RuntimeException("Stub!"); }

/**
 * Get the bond state of the remote device.
 * <p>Possible values for the bond state are:
 * {@link #BOND_NONE},
 * {@link #BOND_BONDING},
 * {@link #BOND_BONDED}.
 *
 * <br>
 * Requires {@link android.Manifest.permission#BLUETOOTH}
 * @return the bond state
 * @apiSince 5
 */

public int getBondState() { throw new RuntimeException("Stub!"); }

/**
 * Get the Bluetooth class of the remote device.
 *
 * <br>
 * Requires {@link android.Manifest.permission#BLUETOOTH}
 * @return Bluetooth class object, or null on error
 * @apiSince 5
 */

public android.bluetooth.BluetoothClass getBluetoothClass() { throw new RuntimeException("Stub!"); }

/**
 * Returns the supported features (UUIDs) of the remote device.
 *
 * <p>This method does not start a service discovery procedure to retrieve the UUIDs
 * from the remote device. Instead, the local cached copy of the service
 * UUIDs are returned.
 * <p>Use {@link #fetchUuidsWithSdp} if fresh UUIDs are desired.
 *
 * <br>
 * Requires {@link android.Manifest.permission#BLUETOOTH}
 * @return the supported features (UUIDs) of the remote device, or null on error
 * @apiSince 15
 */

public android.os.ParcelUuid[] getUuids() { throw new RuntimeException("Stub!"); }

/**
 * Perform a service discovery on the remote device to get the UUIDs supported.
 *
 * <p>This API is asynchronous and {@link #ACTION_UUID} intent is sent,
 * with the UUIDs supported by the remote end. If there is an error
 * in getting the SDP records or if the process takes a long time,
 * {@link #ACTION_UUID} intent is sent with the UUIDs that is currently
 * present in the cache. Clients should use the {@link #getUuids} to get UUIDs
 * if service discovery is not to be performed.
 *
 * <br>
 * Requires {@link android.Manifest.permission#BLUETOOTH}
 * @return False if the sanity check fails, True if the process of initiating an ACL connection
 * to the remote device was started.
 * @apiSince 15
 */

public boolean fetchUuidsWithSdp() { throw new RuntimeException("Stub!"); }

/**
 * Set the pin during pairing when the pairing method is {@link #PAIRING_VARIANT_PIN}
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH_ADMIN}.
 *
 * @return true pin has been set false for error
 * @apiSince 19
 */

public boolean setPin(byte[] pin) { throw new RuntimeException("Stub!"); }

/**
 * Confirm passkey for {@link #PAIRING_VARIANT_PASSKEY_CONFIRMATION} pairing.
 *
 * <br>
 * Requires {@link android.Manifest.permission#BLUETOOTH_PRIVILEGED}
 * @return true confirmation has been sent out false for error
 * @apiSince 19
 */

public boolean setPairingConfirmation(boolean confirm) { throw new RuntimeException("Stub!"); }

/**
 * Create an RFCOMM {@link android.bluetooth.BluetoothSocket BluetoothSocket} ready to start a secure
 * outgoing connection to this remote device using SDP lookup of uuid.
 * <p>This is designed to be used with {@link android.bluetooth.BluetoothAdapter#listenUsingRfcommWithServiceRecord BluetoothAdapter#listenUsingRfcommWithServiceRecord} for peer-peer
 * Bluetooth applications.
 * <p>Use {@link android.bluetooth.BluetoothSocket#connect BluetoothSocket#connect} to initiate the outgoing
 * connection. This will also perform an SDP lookup of the given uuid to
 * determine which channel to connect to.
 * <p>The remote device will be authenticated and communication on this
 * socket will be encrypted.
 * <p> Use this socket only if an authenticated socket link is possible.
 * Authentication refers to the authentication of the link key to
 * prevent man-in-the-middle type of attacks.
 * For example, for Bluetooth 2.1 devices, if any of the devices does not
 * have an input and output capability or just has the ability to
 * display a numeric key, a secure socket connection is not possible.
 * In such a case, use {@link #createInsecureRfcommSocketToServiceRecord}.
 * For more details, refer to the Security Model section 5.2 (vol 3) of
 * Bluetooth Core Specification version 2.1 + EDR.
 * <p>Hint: If you are connecting to a Bluetooth serial board then try
 * using the well-known SPP UUID 00001101-0000-1000-8000-00805F9B34FB.
 * However if you are connecting to an Android peer then please generate
 * your own unique UUID.
 *
 * <br>
 * Requires {@link android.Manifest.permission#BLUETOOTH}
 * @param uuid service record uuid to lookup RFCOMM channel
 * @return a RFCOMM BluetoothServerSocket ready for an outgoing connection
 * @throws java.io.IOException on error, for example Bluetooth not available, or insufficient
 * permissions
 * @apiSince 5
 */

public android.bluetooth.BluetoothSocket createRfcommSocketToServiceRecord(java.util.UUID uuid) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Create an RFCOMM {@link android.bluetooth.BluetoothSocket BluetoothSocket} socket ready to start an insecure
 * outgoing connection to this remote device using SDP lookup of uuid.
 * <p> The communication channel will not have an authenticated link key
 * i.e it will be subject to man-in-the-middle attacks. For Bluetooth 2.1
 * devices, the link key will be encrypted, as encryption is mandatory.
 * For legacy devices (pre Bluetooth 2.1 devices) the link key will
 * be not be encrypted. Use {@link #createRfcommSocketToServiceRecord} if an
 * encrypted and authenticated communication channel is desired.
 * <p>This is designed to be used with {@link android.bluetooth.BluetoothAdapter#listenUsingInsecureRfcommWithServiceRecord BluetoothAdapter#listenUsingInsecureRfcommWithServiceRecord} for peer-peer
 * Bluetooth applications.
 * <p>Use {@link android.bluetooth.BluetoothSocket#connect BluetoothSocket#connect} to initiate the outgoing
 * connection. This will also perform an SDP lookup of the given uuid to
 * determine which channel to connect to.
 * <p>The remote device will be authenticated and communication on this
 * socket will be encrypted.
 * <p>Hint: If you are connecting to a Bluetooth serial board then try
 * using the well-known SPP UUID 00001101-0000-1000-8000-00805F9B34FB.
 * However if you are connecting to an Android peer then please generate
 * your own unique UUID.
 *
 * <br>
 * Requires {@link android.Manifest.permission#BLUETOOTH}
 * @param uuid service record uuid to lookup RFCOMM channel
 * @return a RFCOMM BluetoothServerSocket ready for an outgoing connection
 * @throws java.io.IOException on error, for example Bluetooth not available, or insufficient
 * permissions
 * @apiSince 10
 */

public android.bluetooth.BluetoothSocket createInsecureRfcommSocketToServiceRecord(java.util.UUID uuid) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Connect to GATT Server hosted by this device. Caller acts as GATT client.
 * The callback is used to deliver results to Caller, such as connection status as well
 * as any further GATT client operations.
 * The method returns a BluetoothGatt instance. You can use BluetoothGatt to conduct
 * GATT client operations.
 *
 * @param callback GATT callback handler that will receive asynchronous callbacks.
 * @param autoConnect Whether to directly connect to the remote device (false) or to
 * automatically connect as soon as the remote device becomes available (true).
 * @throws java.lang.IllegalArgumentException if callback is null
 * @apiSince 18
 */

public android.bluetooth.BluetoothGatt connectGatt(android.content.Context context, boolean autoConnect, android.bluetooth.BluetoothGattCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Connect to GATT Server hosted by this device. Caller acts as GATT client.
 * The callback is used to deliver results to Caller, such as connection status as well
 * as any further GATT client operations.
 * The method returns a BluetoothGatt instance. You can use BluetoothGatt to conduct
 * GATT client operations.
 *
 * @param callback GATT callback handler that will receive asynchronous callbacks.
 * @param autoConnect Whether to directly connect to the remote device (false) or to
 * automatically connect as soon as the remote device becomes available (true).
 * @param transport preferred transport for GATT connections to remote dual-mode devices {@link android.bluetooth.BluetoothDevice#TRANSPORT_AUTO BluetoothDevice#TRANSPORT_AUTO} or {@link android.bluetooth.BluetoothDevice#TRANSPORT_BREDR BluetoothDevice#TRANSPORT_BREDR} or {@link android.bluetooth.BluetoothDevice#TRANSPORT_LE BluetoothDevice#TRANSPORT_LE}
 * @throws java.lang.IllegalArgumentException if callback is null
 * @apiSince 23
 */

public android.bluetooth.BluetoothGatt connectGatt(android.content.Context context, boolean autoConnect, android.bluetooth.BluetoothGattCallback callback, int transport) { throw new RuntimeException("Stub!"); }

/**
 * Connect to GATT Server hosted by this device. Caller acts as GATT client.
 * The callback is used to deliver results to Caller, such as connection status as well
 * as any further GATT client operations.
 * The method returns a BluetoothGatt instance. You can use BluetoothGatt to conduct
 * GATT client operations.
 *
 * @param callback GATT callback handler that will receive asynchronous callbacks.
 * @param autoConnect Whether to directly connect to the remote device (false) or to
 * automatically connect as soon as the remote device becomes available (true).
 * @param transport preferred transport for GATT connections to remote dual-mode devices {@link android.bluetooth.BluetoothDevice#TRANSPORT_AUTO BluetoothDevice#TRANSPORT_AUTO} or {@link android.bluetooth.BluetoothDevice#TRANSPORT_BREDR BluetoothDevice#TRANSPORT_BREDR} or {@link android.bluetooth.BluetoothDevice#TRANSPORT_LE BluetoothDevice#TRANSPORT_LE}
 * @param phy preferred PHY for connections to remote LE device. Bitwise OR of any of {@link android.bluetooth.BluetoothDevice#PHY_LE_1M_MASK BluetoothDevice#PHY_LE_1M_MASK}, {@link android.bluetooth.BluetoothDevice#PHY_LE_2M_MASK BluetoothDevice#PHY_LE_2M_MASK}, and {@link android.bluetooth.BluetoothDevice#PHY_LE_CODED_MASK BluetoothDevice#PHY_LE_CODED_MASK}. This option does not take effect if {@code autoConnect}
 * is set to true.
 * @throws java.lang.NullPointerException if callback is null
 * @apiSince 26
 */

public android.bluetooth.BluetoothGatt connectGatt(android.content.Context context, boolean autoConnect, android.bluetooth.BluetoothGattCallback callback, int transport, int phy) { throw new RuntimeException("Stub!"); }

/**
 * Connect to GATT Server hosted by this device. Caller acts as GATT client.
 * The callback is used to deliver results to Caller, such as connection status as well
 * as any further GATT client operations.
 * The method returns a BluetoothGatt instance. You can use BluetoothGatt to conduct
 * GATT client operations.
 *
 * @param callback GATT callback handler that will receive asynchronous callbacks.
 * @param autoConnect Whether to directly connect to the remote device (false) or to
 * automatically connect as soon as the remote device becomes available (true).
 * @param transport preferred transport for GATT connections to remote dual-mode devices {@link android.bluetooth.BluetoothDevice#TRANSPORT_AUTO BluetoothDevice#TRANSPORT_AUTO} or {@link android.bluetooth.BluetoothDevice#TRANSPORT_BREDR BluetoothDevice#TRANSPORT_BREDR} or {@link android.bluetooth.BluetoothDevice#TRANSPORT_LE BluetoothDevice#TRANSPORT_LE}
 * @param phy preferred PHY for connections to remote LE device. Bitwise OR of any of {@link android.bluetooth.BluetoothDevice#PHY_LE_1M_MASK BluetoothDevice#PHY_LE_1M_MASK}, {@link android.bluetooth.BluetoothDevice#PHY_LE_2M_MASK BluetoothDevice#PHY_LE_2M_MASK}, an d{@link android.bluetooth.BluetoothDevice#PHY_LE_CODED_MASK BluetoothDevice#PHY_LE_CODED_MASK}. This option does not take effect if {@code autoConnect}
 * is set to true.
 * @param handler The handler to use for the callback. If {@code null}, callbacks will happen on
 * an un-specified background thread.
 * @throws java.lang.NullPointerException if callback is null
 * @apiSince 26
 */

public android.bluetooth.BluetoothGatt connectGatt(android.content.Context context, boolean autoConnect, android.bluetooth.BluetoothGattCallback callback, int transport, int phy, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Create a Bluetooth L2CAP Connection-oriented Channel (CoC) {@link android.bluetooth.BluetoothSocket BluetoothSocket} that can
 * be used to start a secure outgoing connection to the remote device with the same dynamic
 * protocol/service multiplexer (PSM) value. The supported Bluetooth transport is LE only.
 * <p>This is designed to be used with {@link android.bluetooth.BluetoothAdapter#listenUsingL2capChannel() BluetoothAdapter#listenUsingL2capChannel()} for
 * peer-peer Bluetooth applications.
 * <p>Use {@link android.bluetooth.BluetoothSocket#connect BluetoothSocket#connect} to initiate the outgoing connection.
 * <p>Application using this API is responsible for obtaining PSM value from remote device.
 * <p>The remote device will be authenticated and communication on this socket will be
 * encrypted.
 * <p> Use this socket if an authenticated socket link is possible. Authentication refers
 * to the authentication of the link key to prevent man-in-the-middle type of attacks.
 *
 * <br>
 * Requires {@link android.Manifest.permission#BLUETOOTH}
 * @param psm dynamic PSM value from remote device
 * @return a CoC #BluetoothSocket ready for an outgoing connection
 * This value will never be {@code null}.
 * @throws java.io.IOException on error, for example Bluetooth not available, or insufficient
 * permissions
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.bluetooth.BluetoothSocket createL2capChannel(int psm) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Create a Bluetooth L2CAP Connection-oriented Channel (CoC) {@link android.bluetooth.BluetoothSocket BluetoothSocket} that can
 * be used to start a secure outgoing connection to the remote device with the same dynamic
 * protocol/service multiplexer (PSM) value. The supported Bluetooth transport is LE only.
 * <p>This is designed to be used with {@link android.bluetooth.BluetoothAdapter#listenUsingInsecureL2capChannel() BluetoothAdapter#listenUsingInsecureL2capChannel()} for peer-peer Bluetooth applications.
 * <p>Use {@link android.bluetooth.BluetoothSocket#connect BluetoothSocket#connect} to initiate the outgoing connection.
 * <p>Application using this API is responsible for obtaining PSM value from remote device.
 * <p> The communication channel may not have an authenticated link key, i.e. it may be subject
 * to man-in-the-middle attacks. Use {@link #createL2capChannel(int)} if an encrypted and
 * authenticated communication channel is possible.
 *
 * <br>
 * Requires {@link android.Manifest.permission#BLUETOOTH}
 * @param psm dynamic PSM value from remote device
 * @return a CoC #BluetoothSocket ready for an outgoing connection
 * This value will never be {@code null}.
 * @throws java.io.IOException on error, for example Bluetooth not available, or insufficient
 * permissions
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.bluetooth.BluetoothSocket createInsecureL2capChannel(int psm) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Broadcast Action: Indicates a low level (ACL) connection has been
 * established with a remote device.
 * <p>Always contains the extra field {@link #EXTRA_DEVICE}.
 * <p>ACL connections are managed automatically by the Android Bluetooth
 * stack.
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} to receive.
 * @apiSince 5
 */

public static final java.lang.String ACTION_ACL_CONNECTED = "android.bluetooth.device.action.ACL_CONNECTED";

/**
 * Broadcast Action: Indicates a low level (ACL) disconnection from a
 * remote device.
 * <p>Always contains the extra field {@link #EXTRA_DEVICE}.
 * <p>ACL connections are managed automatically by the Android Bluetooth
 * stack.
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} to receive.
 * @apiSince 5
 */

public static final java.lang.String ACTION_ACL_DISCONNECTED = "android.bluetooth.device.action.ACL_DISCONNECTED";

/**
 * Broadcast Action: Indicates that a low level (ACL) disconnection has
 * been requested for a remote device, and it will soon be disconnected.
 * <p>This is useful for graceful disconnection. Applications should use
 * this intent as a hint to immediately terminate higher level connections
 * (RFCOMM, L2CAP, or profile connections) to the remote device.
 * <p>Always contains the extra field {@link #EXTRA_DEVICE}.
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} to receive.
 * @apiSince 5
 */

public static final java.lang.String ACTION_ACL_DISCONNECT_REQUESTED = "android.bluetooth.device.action.ACL_DISCONNECT_REQUESTED";

/**
 * Broadcast Action: Indicates the alias of a remote device has been
 * changed.
 * <p>Always contains the extra field {@link #EXTRA_DEVICE}.
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} to receive.
 * @apiSince R
 */

public static final java.lang.String ACTION_ALIAS_CHANGED = "android.bluetooth.action.ALIAS_CHANGED";

/**
 * Broadcast Action: Indicates a change in the bond state of a remote
 * device. For example, if a device is bonded (paired).
 * <p>Always contains the extra fields {@link #EXTRA_DEVICE}, {@link
 * #EXTRA_BOND_STATE} and {@link #EXTRA_PREVIOUS_BOND_STATE}.
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} to receive.
 * @apiSince 5
 */

public static final java.lang.String ACTION_BOND_STATE_CHANGED = "android.bluetooth.device.action.BOND_STATE_CHANGED";

/**
 * Broadcast Action: Bluetooth class of a remote device has changed.
 * <p>Always contains the extra fields {@link #EXTRA_DEVICE} and {@link
 * #EXTRA_CLASS}.
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} to receive.
 * {@see BluetoothClass}
 * @apiSince 5
 */

public static final java.lang.String ACTION_CLASS_CHANGED = "android.bluetooth.device.action.CLASS_CHANGED";

/**
 * Broadcast Action: Remote device discovered.
 * <p>Sent when a remote device is found during discovery.
 * <p>Always contains the extra fields {@link #EXTRA_DEVICE} and {@link
 * #EXTRA_CLASS}. Can contain the extra fields {@link #EXTRA_NAME} and/or
 * {@link #EXTRA_RSSI} if they are available.
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} and
 * {@link android.Manifest.permission#ACCESS_COARSE_LOCATION} to receive.
 * @apiSince 5
 */

public static final java.lang.String ACTION_FOUND = "android.bluetooth.device.action.FOUND";

/**
 * Broadcast Action: Indicates the friendly name of a remote device has
 * been retrieved for the first time, or changed since the last retrieval.
 * <p>Always contains the extra fields {@link #EXTRA_DEVICE} and {@link
 * #EXTRA_NAME}.
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} to receive.
 * @apiSince 5
 */

public static final java.lang.String ACTION_NAME_CHANGED = "android.bluetooth.device.action.NAME_CHANGED";

/**
 * Broadcast Action: This intent is used to broadcast PAIRING REQUEST
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH_ADMIN} to
 * receive.
 * @apiSince 19
 */

public static final java.lang.String ACTION_PAIRING_REQUEST = "android.bluetooth.device.action.PAIRING_REQUEST";

/**
 * Broadcast Action: This intent is used to broadcast the {@link java.util.UUID UUID}
 * wrapped as a {@link android.os.ParcelUuid} of the remote device after it
 * has been fetched. This intent is sent only when the UUIDs of the remote
 * device are requested to be fetched using Service Discovery Protocol
 * <p> Always contains the extra field {@link #EXTRA_DEVICE}
 * <p> Always contains the extra field {@link #EXTRA_UUID}
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH_ADMIN} to receive.
 * @apiSince 15
 */

public static final java.lang.String ACTION_UUID = "android.bluetooth.device.action.UUID";

/**
 * Indicates the remote device is bonded (paired).
 * <p>A shared link keys exists locally for the remote device, so
 * communication can be authenticated and encrypted.
 * <p><i>Being bonded (paired) with a remote device does not necessarily
 * mean the device is currently connected. It just means that the pending
 * procedure was completed at some earlier time, and the link key is still
 * stored locally, ready to use on the next connection.
 * </i>
 * @apiSince 5
 */

public static final int BOND_BONDED = 12; // 0xc

/**
 * Indicates bonding (pairing) is in progress with the remote device.
 * @apiSince 5
 */

public static final int BOND_BONDING = 11; // 0xb

/**
 * Indicates the remote device is not bonded (paired).
 * <p>There is no shared link key with the remote device, so communication
 * (if it is allowed at all) will be unauthenticated and unencrypted.
 * @apiSince 5
 */

public static final int BOND_NONE = 10; // 0xa

/** @apiSince 5 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.bluetooth.BluetoothDevice> CREATOR;
static { CREATOR = null; }

/**
 * Bluetooth device type, Classic - BR/EDR devices
 * @apiSince 18
 */

public static final int DEVICE_TYPE_CLASSIC = 1; // 0x1

/**
 * Bluetooth device type, Dual Mode - BR/EDR/LE
 * @apiSince 18
 */

public static final int DEVICE_TYPE_DUAL = 3; // 0x3

/**
 * Bluetooth device type, Low Energy - LE-only
 * @apiSince 18
 */

public static final int DEVICE_TYPE_LE = 2; // 0x2

/**
 * Bluetooth device type, Unknown
 * @apiSince 18
 */

public static final int DEVICE_TYPE_UNKNOWN = 0; // 0x0

/**
 * Sentinel error value for this class. Guaranteed to not equal any other
 * integer constant in this class. Provided as a convenience for functions
 * that require a sentinel error value, for example:
 * <p><code>Intent.getIntExtra(BluetoothDevice.EXTRA_BOND_STATE,
 * BluetoothDevice.ERROR)</code>
 * @apiSince 5
 */

public static final int ERROR = -2147483648; // 0x80000000

/**
 * Used as an int extra field in {@link #ACTION_BOND_STATE_CHANGED} intents.
 * Contains the bond state of the remote device.
 * <p>Possible values are:
 * {@link #BOND_NONE},
 * {@link #BOND_BONDING},
 * {@link #BOND_BONDED}.
 * @apiSince 5
 */

public static final java.lang.String EXTRA_BOND_STATE = "android.bluetooth.device.extra.BOND_STATE";

/**
 * Used as a Parcelable {@link android.bluetooth.BluetoothClass BluetoothClass} extra field in {@link
 * #ACTION_FOUND} and {@link #ACTION_CLASS_CHANGED} intents.
 * @apiSince 5
 */

public static final java.lang.String EXTRA_CLASS = "android.bluetooth.device.extra.CLASS";

/**
 * Used as a Parcelable {@link android.bluetooth.BluetoothDevice BluetoothDevice} extra field in every intent
 * broadcast by this class. It contains the {@link android.bluetooth.BluetoothDevice BluetoothDevice} that
 * the intent applies to.
 * @apiSince 5
 */

public static final java.lang.String EXTRA_DEVICE = "android.bluetooth.device.extra.DEVICE";

/**
 * Used as a String extra field in {@link #ACTION_NAME_CHANGED} and {@link
 * #ACTION_FOUND} intents. It contains the friendly Bluetooth name.
 * @apiSince 5
 */

public static final java.lang.String EXTRA_NAME = "android.bluetooth.device.extra.NAME";

/**
 * Used as an int extra field in {@link #ACTION_PAIRING_REQUEST}
 * intents as the value of passkey.
 * @apiSince 19
 */

public static final java.lang.String EXTRA_PAIRING_KEY = "android.bluetooth.device.extra.PAIRING_KEY";

/**
 * Used as an int extra field in {@link #ACTION_PAIRING_REQUEST}
 * intents to indicate pairing method used. Possible values are:
 * {@link #PAIRING_VARIANT_PIN},
 * {@link #PAIRING_VARIANT_PASSKEY_CONFIRMATION},
 * @apiSince 19
 */

public static final java.lang.String EXTRA_PAIRING_VARIANT = "android.bluetooth.device.extra.PAIRING_VARIANT";

/**
 * Used as an int extra field in {@link #ACTION_BOND_STATE_CHANGED} intents.
 * Contains the previous bond state of the remote device.
 * <p>Possible values are:
 * {@link #BOND_NONE},
 * {@link #BOND_BONDING},
 * {@link #BOND_BONDED}.
 * @apiSince 5
 */

public static final java.lang.String EXTRA_PREVIOUS_BOND_STATE = "android.bluetooth.device.extra.PREVIOUS_BOND_STATE";

/**
 * Used as an optional short extra field in {@link #ACTION_FOUND} intents.
 * Contains the RSSI value of the remote device as reported by the
 * Bluetooth hardware.
 * @apiSince 5
 */

public static final java.lang.String EXTRA_RSSI = "android.bluetooth.device.extra.RSSI";

/**
 * Used as an extra field in {@link #ACTION_UUID} intents,
 * Contains the {@link android.os.ParcelUuid}s of the remote device which
 * is a parcelable version of {@link java.util.UUID UUID}.
 * @apiSince 15
 */

public static final java.lang.String EXTRA_UUID = "android.bluetooth.device.extra.UUID";

/**
 * The user will be prompted to confirm the passkey displayed on the screen or
 * an app will confirm the passkey for the user.
 * @apiSince 19
 */

public static final int PAIRING_VARIANT_PASSKEY_CONFIRMATION = 2; // 0x2

/**
 * The user will be prompted to enter a pin or
 * an app will enter a pin for user.
 * @apiSince 19
 */

public static final int PAIRING_VARIANT_PIN = 0; // 0x0

/**
 * Bluetooth LE 1M PHY. Used to refer to LE 1M Physical Channel for advertising, scanning or
 * connection.
 * @apiSince 26
 */

public static final int PHY_LE_1M = 1; // 0x1

/**
 * Bluetooth LE 1M PHY mask. Used to specify LE 1M Physical Channel as one of many available
 * options in a bitmask.
 * @apiSince 26
 */

public static final int PHY_LE_1M_MASK = 1; // 0x1

/**
 * Bluetooth LE 2M PHY. Used to refer to LE 2M Physical Channel for advertising, scanning or
 * connection.
 * @apiSince 26
 */

public static final int PHY_LE_2M = 2; // 0x2

/**
 * Bluetooth LE 2M PHY mask. Used to specify LE 2M Physical Channel as one of many available
 * options in a bitmask.
 * @apiSince 26
 */

public static final int PHY_LE_2M_MASK = 2; // 0x2

/**
 * Bluetooth LE Coded PHY. Used to refer to LE Coded Physical Channel for advertising, scanning
 * or connection.
 * @apiSince 26
 */

public static final int PHY_LE_CODED = 3; // 0x3

/**
 * Bluetooth LE Coded PHY mask. Used to specify LE Coded Physical Channel as one of many
 * available options in a bitmask.
 * @apiSince 26
 */

public static final int PHY_LE_CODED_MASK = 4; // 0x4

/**
 * No preferred coding when transmitting on the LE Coded PHY.
 * @apiSince 26
 */

public static final int PHY_OPTION_NO_PREFERRED = 0; // 0x0

/**
 * Prefer the S=2 coding to be used when transmitting on the LE Coded PHY.
 * @apiSince 26
 */

public static final int PHY_OPTION_S2 = 1; // 0x1

/**
 * Prefer the S=8 coding to be used when transmitting on the LE Coded PHY.
 * @apiSince 26
 */

public static final int PHY_OPTION_S8 = 2; // 0x2

/**
 * No preference of physical transport for GATT connections to remote dual-mode devices
 * @apiSince 23
 */

public static final int TRANSPORT_AUTO = 0; // 0x0

/**
 * Prefer BR/EDR transport for GATT connections to remote dual-mode devices
 * @apiSince 23
 */

public static final int TRANSPORT_BREDR = 1; // 0x1

/**
 * Prefer LE transport for GATT connections to remote dual-mode devices
 * @apiSince 23
 */

public static final int TRANSPORT_LE = 2; // 0x2
}

