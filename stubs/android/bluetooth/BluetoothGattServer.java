/*
 * Copyright (C) 2013 The Android Open Source Project
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

import java.util.List;
import java.util.UUID;

/**
 * Public API for the Bluetooth GATT Profile server role.
 *
 * <p>This class provides Bluetooth GATT server role functionality,
 * allowing applications to create Bluetooth Smart services and
 * characteristics.
 *
 * <p>BluetoothGattServer is a proxy object for controlling the Bluetooth Service
 * via IPC.  Use {@link android.bluetooth.BluetoothManager#openGattServer BluetoothManager#openGattServer} to get an instance
 * of this class.
 * @apiSince 18
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class BluetoothGattServer implements android.bluetooth.BluetoothProfile {

BluetoothGattServer() { throw new RuntimeException("Stub!"); }

/**
 * Close this GATT server instance.
 *
 * Application should call this method as early as possible after it is done with
 * this GATT server.
 * @apiSince 18
 */

public void close() { throw new RuntimeException("Stub!"); }

/**
 * Initiate a connection to a Bluetooth GATT capable device.
 *
 * <p>The connection may not be established right away, but will be
 * completed when the remote device is available. A
 * {@link android.bluetooth.BluetoothGattServerCallback#onConnectionStateChange BluetoothGattServerCallback#onConnectionStateChange} callback will be
 * invoked when the connection state changes as a result of this function.
 *
 * <p>The autoConnect parameter determines whether to actively connect to
 * the remote device, or rather passively scan and finalize the connection
 * when the remote device is in range/available. Generally, the first ever
 * connection to a device should be direct (autoConnect set to false) and
 * subsequent connections to known devices should be invoked with the
 * autoConnect parameter set to true.
 *
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
 *
 * @param autoConnect Whether to directly connect to the remote device (false) or to
 * automatically connect as soon as the remote device becomes available (true).
 * @return true, if the connection attempt was initiated successfully
 * @apiSince 18
 */

public boolean connect(android.bluetooth.BluetoothDevice device, boolean autoConnect) { throw new RuntimeException("Stub!"); }

/**
 * Disconnects an established connection, or cancels a connection attempt
 * currently in progress.
 *
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
 *
 * @param device Remote device
 * @apiSince 18
 */

public void cancelConnection(android.bluetooth.BluetoothDevice device) { throw new RuntimeException("Stub!"); }

/**
 * Set the preferred connection PHY for this app. Please note that this is just a
 * recommendation, whether the PHY change will happen depends on other applications peferences,
 * local and remote controller capabilities. Controller can override these settings. <p> {@link android.bluetooth.BluetoothGattServerCallback#onPhyUpdate BluetoothGattServerCallback#onPhyUpdate} will be triggered as a result of this call, even if
 * no PHY change happens. It is also triggered when remote device updates the PHY.
 *
 * @param device The remote device to send this response to
 * @param txPhy preferred transmitter PHY. Bitwise OR of any of {@link android.bluetooth.BluetoothDevice#PHY_LE_1M_MASK BluetoothDevice#PHY_LE_1M_MASK}, {@link android.bluetooth.BluetoothDevice#PHY_LE_2M_MASK BluetoothDevice#PHY_LE_2M_MASK}, and {@link android.bluetooth.BluetoothDevice#PHY_LE_CODED_MASK BluetoothDevice#PHY_LE_CODED_MASK}.
 * @param rxPhy preferred receiver PHY. Bitwise OR of any of {@link android.bluetooth.BluetoothDevice#PHY_LE_1M_MASK BluetoothDevice#PHY_LE_1M_MASK}, {@link android.bluetooth.BluetoothDevice#PHY_LE_2M_MASK BluetoothDevice#PHY_LE_2M_MASK}, and {@link android.bluetooth.BluetoothDevice#PHY_LE_CODED_MASK BluetoothDevice#PHY_LE_CODED_MASK}.
 * @param phyOptions preferred coding to use when transmitting on the LE Coded PHY. Can be one
 * of {@link android.bluetooth.BluetoothDevice#PHY_OPTION_NO_PREFERRED BluetoothDevice#PHY_OPTION_NO_PREFERRED}, {@link android.bluetooth.BluetoothDevice#PHY_OPTION_S2 BluetoothDevice#PHY_OPTION_S2} or
 * {@link android.bluetooth.BluetoothDevice#PHY_OPTION_S8 BluetoothDevice#PHY_OPTION_S8}
 * @apiSince 26
 */

public void setPreferredPhy(android.bluetooth.BluetoothDevice device, int txPhy, int rxPhy, int phyOptions) { throw new RuntimeException("Stub!"); }

/**
 * Read the current transmitter PHY and receiver PHY of the connection. The values are returned
 * in {@link android.bluetooth.BluetoothGattServerCallback#onPhyRead BluetoothGattServerCallback#onPhyRead}
 *
 * @param device The remote device to send this response to
 * @apiSince 26
 */

public void readPhy(android.bluetooth.BluetoothDevice device) { throw new RuntimeException("Stub!"); }

/**
 * Send a response to a read or write request to a remote device.
 *
 * <p>This function must be invoked in when a remote read/write request
 * is received by one of these callback methods:
 *
 * <ul>
 * <li>{@link android.bluetooth.BluetoothGattServerCallback#onCharacteristicReadRequest BluetoothGattServerCallback#onCharacteristicReadRequest}
 * <li>{@link android.bluetooth.BluetoothGattServerCallback#onCharacteristicWriteRequest BluetoothGattServerCallback#onCharacteristicWriteRequest}
 * <li>{@link android.bluetooth.BluetoothGattServerCallback#onDescriptorReadRequest BluetoothGattServerCallback#onDescriptorReadRequest}
 * <li>{@link android.bluetooth.BluetoothGattServerCallback#onDescriptorWriteRequest BluetoothGattServerCallback#onDescriptorWriteRequest}
 * </ul>
 *
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
 *
 * @param device The remote device to send this response to
 * @param requestId The ID of the request that was received with the callback
 * @param status The status of the request to be sent to the remote devices
 * @param offset Value offset for partial read/write response
 * @param value The value of the attribute that was read/written (optional)
 * @apiSince 18
 */

public boolean sendResponse(android.bluetooth.BluetoothDevice device, int requestId, int status, int offset, byte[] value) { throw new RuntimeException("Stub!"); }

/**
 * Send a notification or indication that a local characteristic has been
 * updated.
 *
 * <p>A notification or indication is sent to the remote device to signal
 * that the characteristic has been updated. This function should be invoked
 * for every client that requests notifications/indications by writing
 * to the "Client Configuration" descriptor for the given characteristic.
 *
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
 *
 * @param device The remote device to receive the notification/indication
 * @param characteristic The local characteristic that has been updated
 * @param confirm true to request confirmation from the client (indication), false to send a
 * notification
 * @return true, if the notification has been triggered successfully
 * @throws java.lang.IllegalArgumentException
 * @apiSince 18
 */

public boolean notifyCharacteristicChanged(android.bluetooth.BluetoothDevice device, android.bluetooth.BluetoothGattCharacteristic characteristic, boolean confirm) { throw new RuntimeException("Stub!"); }

/**
 * Add a service to the list of services to be hosted.
 *
 * <p>Once a service has been addded to the list, the service and its
 * included characteristics will be provided by the local device.
 *
 * <p>If the local device has already exposed services when this function
 * is called, a service update notification will be sent to all clients.
 *
 * <p>The {@link android.bluetooth.BluetoothGattServerCallback#onServiceAdded BluetoothGattServerCallback#onServiceAdded} callback will indicate
 * whether this service has been added successfully. Do not add another service
 * before this callback.
 *
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
 *
 * @param service Service to be added to the list of services provided by this device.
 * @return true, if the request to add service has been initiated
 * @apiSince 18
 */

public boolean addService(android.bluetooth.BluetoothGattService service) { throw new RuntimeException("Stub!"); }

/**
 * Removes a service from the list of services to be provided.
 *
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
 *
 * @param service Service to be removed.
 * @return true, if the service has been removed
 * @apiSince 18
 */

public boolean removeService(android.bluetooth.BluetoothGattService service) { throw new RuntimeException("Stub!"); }

/**
 * Remove all services from the list of provided services.
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
 * @apiSince 18
 */

public void clearServices() { throw new RuntimeException("Stub!"); }

/**
 * Returns a list of GATT services offered by this device.
 *
 * <p>An application must call {@link #addService} to add a serice to the
 * list of services offered by this device.
 *
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
 *
 * @return List of services. Returns an empty list if no services have been added yet.
 * @apiSince 18
 */

public java.util.List<android.bluetooth.BluetoothGattService> getServices() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link android.bluetooth.BluetoothGattService BluetoothGattService} from the list of services offered
 * by this device.
 *
 * <p>If multiple instances of the same service (as identified by UUID)
 * exist, the first instance of the service is returned.
 *
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
 *
 * @param uuid UUID of the requested service
 * @return BluetoothGattService if supported, or null if the requested service is not offered by
 * this device.
 * @apiSince 18
 */

public android.bluetooth.BluetoothGattService getService(java.util.UUID uuid) { throw new RuntimeException("Stub!"); }

/**
 * Not supported - please use {@link android.bluetooth.BluetoothManager#getConnectedDevices(int) BluetoothManager#getConnectedDevices(int)}
 * with {@link android.bluetooth.BluetoothProfile#GATT BluetoothProfile#GATT} as argument
 *
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 18
 */

public int getConnectionState(android.bluetooth.BluetoothDevice device) { throw new RuntimeException("Stub!"); }

/**
 * Not supported - please use {@link android.bluetooth.BluetoothManager#getConnectedDevices(int) BluetoothManager#getConnectedDevices(int)}
 * with {@link android.bluetooth.BluetoothProfile#GATT BluetoothProfile#GATT} as argument
 *
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 18
 */

public java.util.List<android.bluetooth.BluetoothDevice> getConnectedDevices() { throw new RuntimeException("Stub!"); }

/**
 * Not supported - please use
 * {@link android.bluetooth.BluetoothManager#getDevicesMatchingConnectionStates(int,int[]) BluetoothManager#getDevicesMatchingConnectionStates(int, int[])}
 * with {@link android.bluetooth.BluetoothProfile#GATT BluetoothProfile#GATT} as first argument
 *
 * @throws java.lang.UnsupportedOperationException
 * @apiSince 18
 */

public java.util.List<android.bluetooth.BluetoothDevice> getDevicesMatchingConnectionStates(int[] states) { throw new RuntimeException("Stub!"); }
}

