/*
 * Copyright (C) 2017 The Android Open Source Project
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
 * This abstract class is used to implement {@link android.bluetooth.BluetoothGatt BluetoothGatt} callbacks.
 * @apiSince 18
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class BluetoothGattCallback {

public BluetoothGattCallback() { throw new RuntimeException("Stub!"); }

/**
 * Callback triggered as result of {@link android.bluetooth.BluetoothGatt#setPreferredPhy BluetoothGatt#setPreferredPhy}, or as a result of
 * remote device changing the PHY.
 *
 * @param gatt GATT client
 * @param txPhy the transmitter PHY in use. One of {@link android.bluetooth.BluetoothDevice#PHY_LE_1M BluetoothDevice#PHY_LE_1M}, {@link android.bluetooth.BluetoothDevice#PHY_LE_2M BluetoothDevice#PHY_LE_2M}, and {@link android.bluetooth.BluetoothDevice#PHY_LE_CODED BluetoothDevice#PHY_LE_CODED}.
 * @param rxPhy the receiver PHY in use. One of {@link android.bluetooth.BluetoothDevice#PHY_LE_1M BluetoothDevice#PHY_LE_1M}, {@link android.bluetooth.BluetoothDevice#PHY_LE_2M BluetoothDevice#PHY_LE_2M}, and {@link android.bluetooth.BluetoothDevice#PHY_LE_CODED BluetoothDevice#PHY_LE_CODED}.
 * @param status Status of the PHY update operation. {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS BluetoothGatt#GATT_SUCCESS} if the
 * operation succeeds.
 * @apiSince 26
 */

public void onPhyUpdate(android.bluetooth.BluetoothGatt gatt, int txPhy, int rxPhy, int status) { throw new RuntimeException("Stub!"); }

/**
 * Callback triggered as result of {@link android.bluetooth.BluetoothGatt#readPhy BluetoothGatt#readPhy}
 *
 * @param gatt GATT client
 * @param txPhy the transmitter PHY in use. One of {@link android.bluetooth.BluetoothDevice#PHY_LE_1M BluetoothDevice#PHY_LE_1M}, {@link android.bluetooth.BluetoothDevice#PHY_LE_2M BluetoothDevice#PHY_LE_2M}, and {@link android.bluetooth.BluetoothDevice#PHY_LE_CODED BluetoothDevice#PHY_LE_CODED}.
 * @param rxPhy the receiver PHY in use. One of {@link android.bluetooth.BluetoothDevice#PHY_LE_1M BluetoothDevice#PHY_LE_1M}, {@link android.bluetooth.BluetoothDevice#PHY_LE_2M BluetoothDevice#PHY_LE_2M}, and {@link android.bluetooth.BluetoothDevice#PHY_LE_CODED BluetoothDevice#PHY_LE_CODED}.
 * @param status Status of the PHY read operation. {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS BluetoothGatt#GATT_SUCCESS} if the
 * operation succeeds.
 * @apiSince 26
 */

public void onPhyRead(android.bluetooth.BluetoothGatt gatt, int txPhy, int rxPhy, int status) { throw new RuntimeException("Stub!"); }

/**
 * Callback indicating when GATT client has connected/disconnected to/from a remote
 * GATT server.
 *
 * @param gatt GATT client
 * @param status Status of the connect or disconnect operation. {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS BluetoothGatt#GATT_SUCCESS} if the operation succeeds.
 * @param newState Returns the new connection state. Can be one of {@link android.bluetooth.BluetoothProfile#STATE_DISCONNECTED BluetoothProfile#STATE_DISCONNECTED} or {@link android.bluetooth.BluetoothProfile#STATE_CONNECTED BluetoothProfile#STATE_CONNECTED}
 * @apiSince 18
 */

public void onConnectionStateChange(android.bluetooth.BluetoothGatt gatt, int status, int newState) { throw new RuntimeException("Stub!"); }

/**
 * Callback invoked when the list of remote services, characteristics and descriptors
 * for the remote device have been updated, ie new services have been discovered.
 *
 * @param gatt GATT client invoked {@link android.bluetooth.BluetoothGatt#discoverServices BluetoothGatt#discoverServices}
 * @param status {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS BluetoothGatt#GATT_SUCCESS} if the remote device has been explored
 * successfully.
 * @apiSince 18
 */

public void onServicesDiscovered(android.bluetooth.BluetoothGatt gatt, int status) { throw new RuntimeException("Stub!"); }

/**
 * Callback reporting the result of a characteristic read operation.
 *
 * @param gatt GATT client invoked {@link android.bluetooth.BluetoothGatt#readCharacteristic BluetoothGatt#readCharacteristic}
 * @param characteristic Characteristic that was read from the associated remote device.
 * @param status {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS BluetoothGatt#GATT_SUCCESS} if the read operation was completed
 * successfully.
 * @apiSince 18
 */

public void onCharacteristicRead(android.bluetooth.BluetoothGatt gatt, android.bluetooth.BluetoothGattCharacteristic characteristic, int status) { throw new RuntimeException("Stub!"); }

/**
 * Callback indicating the result of a characteristic write operation.
 *
 * <p>If this callback is invoked while a reliable write transaction is
 * in progress, the value of the characteristic represents the value
 * reported by the remote device. An application should compare this
 * value to the desired value to be written. If the values don't match,
 * the application must abort the reliable write transaction.
 *
 * @param gatt GATT client invoked {@link android.bluetooth.BluetoothGatt#writeCharacteristic BluetoothGatt#writeCharacteristic}
 * @param characteristic Characteristic that was written to the associated remote device.
 * @param status The result of the write operation {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS BluetoothGatt#GATT_SUCCESS} if the
 * operation succeeds.
 * @apiSince 18
 */

public void onCharacteristicWrite(android.bluetooth.BluetoothGatt gatt, android.bluetooth.BluetoothGattCharacteristic characteristic, int status) { throw new RuntimeException("Stub!"); }

/**
 * Callback triggered as a result of a remote characteristic notification.
 *
 * @param gatt GATT client the characteristic is associated with
 * @param characteristic Characteristic that has been updated as a result of a remote
 * notification event.
 * @apiSince 18
 */

public void onCharacteristicChanged(android.bluetooth.BluetoothGatt gatt, android.bluetooth.BluetoothGattCharacteristic characteristic) { throw new RuntimeException("Stub!"); }

/**
 * Callback reporting the result of a descriptor read operation.
 *
 * @param gatt GATT client invoked {@link android.bluetooth.BluetoothGatt#readDescriptor BluetoothGatt#readDescriptor}
 * @param descriptor Descriptor that was read from the associated remote device.
 * @param status {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS BluetoothGatt#GATT_SUCCESS} if the read operation was completed
 * successfully
 * @apiSince 18
 */

public void onDescriptorRead(android.bluetooth.BluetoothGatt gatt, android.bluetooth.BluetoothGattDescriptor descriptor, int status) { throw new RuntimeException("Stub!"); }

/**
 * Callback indicating the result of a descriptor write operation.
 *
 * @param gatt GATT client invoked {@link android.bluetooth.BluetoothGatt#writeDescriptor BluetoothGatt#writeDescriptor}
 * @param descriptor Descriptor that was writte to the associated remote device.
 * @param status The result of the write operation {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS BluetoothGatt#GATT_SUCCESS} if the
 * operation succeeds.
 * @apiSince 18
 */

public void onDescriptorWrite(android.bluetooth.BluetoothGatt gatt, android.bluetooth.BluetoothGattDescriptor descriptor, int status) { throw new RuntimeException("Stub!"); }

/**
 * Callback invoked when a reliable write transaction has been completed.
 *
 * @param gatt GATT client invoked {@link android.bluetooth.BluetoothGatt#executeReliableWrite BluetoothGatt#executeReliableWrite}
 * @param status {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS BluetoothGatt#GATT_SUCCESS} if the reliable write transaction was
 * executed successfully
 * @apiSince 18
 */

public void onReliableWriteCompleted(android.bluetooth.BluetoothGatt gatt, int status) { throw new RuntimeException("Stub!"); }

/**
 * Callback reporting the RSSI for a remote device connection.
 *
 * This callback is triggered in response to the
 * {@link android.bluetooth.BluetoothGatt#readRemoteRssi BluetoothGatt#readRemoteRssi} function.
 *
 * @param gatt GATT client invoked {@link android.bluetooth.BluetoothGatt#readRemoteRssi BluetoothGatt#readRemoteRssi}
 * @param rssi The RSSI value for the remote device
 * @param status {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS BluetoothGatt#GATT_SUCCESS} if the RSSI was read successfully
 * @apiSince 18
 */

public void onReadRemoteRssi(android.bluetooth.BluetoothGatt gatt, int rssi, int status) { throw new RuntimeException("Stub!"); }

/**
 * Callback indicating the MTU for a given device connection has changed.
 *
 * This callback is triggered in response to the
 * {@link android.bluetooth.BluetoothGatt#requestMtu BluetoothGatt#requestMtu} function, or in response to a connection
 * event.
 *
 * @param gatt GATT client invoked {@link android.bluetooth.BluetoothGatt#requestMtu BluetoothGatt#requestMtu}
 * @param mtu The new MTU size
 * @param status {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS BluetoothGatt#GATT_SUCCESS} if the MTU has been changed successfully
 * @apiSince 21
 */

public void onMtuChanged(android.bluetooth.BluetoothGatt gatt, int mtu, int status) { throw new RuntimeException("Stub!"); }
}

